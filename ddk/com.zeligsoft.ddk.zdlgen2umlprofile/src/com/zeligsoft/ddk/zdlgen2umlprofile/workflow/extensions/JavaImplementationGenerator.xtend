package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.google.inject.name.Named
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
import java.util.HashSet
import java.util.Set
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
import org.eclipse.uml2.common.util.UML2Util
import org.eclipse.uml2.uml.AggregationKind

class JavaImplementationGenerator {
	@Inject extension GenDomainConceptExtensions
    @Inject extension GenDomainStructuralFeatureExtensions
    @Inject extension JavaMethodSignaturesExtensions
    @Inject extension JavaNamingExtensions
    @Inject extension JavaImportExtensions
    
    @Inject @Named('Root Package')String rootPackage
    @Inject @Named('Implementation SubPackage')String implSubPackage
    @Inject @Named('Implementation Suffix')String implSuffix
    
    def dispatch compileImplementation(GenDomainClassifier concept, String pkg) ''''''

    def dispatch compileImplementation(GenDomainConcept concept, String pkg) {
        val baseConcepts = concept.generals
        val firstBaseConcept = baseConcepts.head

'''package «concept.block.implementationJavaPackage»;

«concept.implementationImports»
    
public «IF concept.domainConcept.isAbstract»abstract «ENDIF»class «concept.javaImplementationName»
    «IF firstBaseConcept != null»extends «firstBaseConcept.javaImplementationName» «ELSE»extends ZObjectImpl «ENDIF»implements «concept.javaInterfaceName»{
    «concept.implementationStandardFields»
    «concept.implementationFields»
    «concept.implementationConstructor»
    «concept.implementationStandardAccessors»
    
    «FOR feature:concept.allFeaturesToImplement»
    «feature.compileImplementation» 
    «IF feature.isInconsistentOverride»
    «FOR overriden : feature.overridenGenFeatures»
    «overriden.compileOverridenImplementation»
    «ENDFOR»
    «ENDIF»
    «ENDFOR»
    
    «concept.umlMappingImplementationMethods»
}
'''
}

    def compileImplementation(GenDomainStructuralFeature feature) '''
    	«feature.accessorImplementation»
    	«feature.modifierImplementation»
    '''
    
    def private dispatch accessorImplementation(GenDomainStructuralFeature feature) ''''''
    
    def private dispatch accessorImplementation(GenDomainAttribute feature) '''public «feature.featureAccessorReturnType» get«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(){
        «IF !feature.domainAttribute.multivalued && feature.hasPrimitiveType»
        final Object rawValue =
            com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "«feature.conceptQualifiedName»", "«feature.name»");
        return («feature.typeAsString») rawValue;
        «ELSEIF !feature.domainAttribute.multivalued && feature.hasUMLType»
        final Object rawValue =
            com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "«feature.conceptQualifiedName»", "«feature.name»");
        return («feature.typeAsString») rawValue;
        «ELSE»
        final Object rawValue =
            com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "«feature.conceptQualifiedName»", "«feature.name»");
        
        if(«feature.featureFieldName» == null) {
        «IF feature.domainAttribute.multivalued»
            «feature.featureFieldName» = new java.util.ArrayList<«feature.typeAsString»>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                «IF feature.hasPrimitiveType»
                «feature.featureFieldName».add((«feature.typeAsString») next);
                «ELSEIF feature.type instanceof GenDomainEnum»
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    «feature.typeAsString» nextWrapper = 
                         «feature.typeAsString».create((org.eclipse.emf.ecore.EObject) next);
                    «feature.featureFieldName».add(nextWrapper);
                }
                «ELSEIF feature.hasZDLType»
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    «feature.typeAsString» nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, «feature.typeAsString».class);
                    «feature.featureFieldName».add(nextWrapper);
                }
                «ELSEIF feature.hasUMLType»
                «feature.featureFieldName».add((«feature.typeAsString») next);
                «ENDIF»
                 
            }
            «ELSE»
            «IF feature.type instanceof GenDomainEnum»
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
                «feature.featureFieldName» = «feature.typeAsString».create((org.eclipse.emf.ecore.EObject) rawValue);
            }
            «ELSEIF feature.hasZDLType»
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              «feature.featureFieldName» = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, «feature.typeAsString».class);
            }
            «ENDIF»
            «ENDIF»
        }
        return «feature.featureFieldName»;
        «ENDIF»
}'''
    
    def private dispatch accessorImplementation(GenDomainReference feature) '''
    public «feature.featureAccessorReturnType» get«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(){
        if(«feature.featureFieldName» == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "«feature.conceptQualifiedName»", "«feature.domainAttribute.name»");
            «IF feature.domainAttribute.multivalued»
            «feature.featureFieldName» = new java.util.ArrayList<«feature.typeAsString»>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    «feature.typeAsString» nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, «feature.typeAsString».class);
                    «feature.featureFieldName».add(nextWrapper);
                }   
            }
            «ELSE»
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              «feature.featureFieldName» = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, «feature.typeAsString».class);
            }
            «ENDIF»
        }
        return «feature.featureFieldName»;
    }'''
    
    def  compileOverridenImplementation(GenDomainStructuralFeature feature) '''
    public «feature.featureAccessorReturnType» get«feature.domainAttribute.name.toFirstUpper»«feature.inconsistentOverrideString»(){
        throw new UnsupportedOperationException();
    }
    
    «feature.modifierImplementationOverriden»
    '''
    
    def private dispatch modifierImplementation(GenDomainStructuralFeature feature)''''''
    
    def private dispatch modifierImplementationOverriden(GenDomainStructuralFeature feature)''''''
    
    def private dispatch modifierImplementation(GenDomainAttribute feature){
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			feature.compositeModifierImplementation
	    		case AggregationKind::SHARED: 
	    			feature.sharedModifierImplementation
	    		case AggregationKind::NONE: 
	    			feature.noneModifierImplementation
	    		default : 
	    			''''''.toString
	    	}
    	}
    }
    
    def private dispatch modifierImplementationOverriden(GenDomainAttribute feature){
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			feature.compositeModifierImplementationOverriden
	    		case AggregationKind::SHARED: 
	    			feature.sharedModifierImplementationOverriden
	    		case AggregationKind::NONE: 
	    			feature.noneModifierImplementationOverriden
	    		default : 
	    			''''''.toString
	    	}
    	}
    }
    
    def private dispatch modifierImplementation(GenDomainReference feature){
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			feature.compositeModifierImplementation
	    		case AggregationKind::SHARED: 
	    			feature.sharedModifierImplementation
	    		case AggregationKind::NONE: 
	    			feature.noneModifierImplementation
	    		default : 
	    			''''''.toString
	    	}
    	}
    }
    
    def private dispatch modifierImplementationOverriden(GenDomainReference feature){
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			feature.compositeModifierImplementationOverriden
	    		case AggregationKind::SHARED: 
	    			feature.sharedModifierImplementationOverriden
	    		case AggregationKind::NONE: 
	    			feature.noneModifierImplementationOverriden
	    		default : 
	    			''''''.toString
	    	}
    	}
    }
    
    def private compositeModifierImplementation(GenDomainStructuralFeature feature) {
    	if(feature.domainAttribute.multivalued) {
			'''
			public «feature.compositeMultivaluedAddExistingSignature»{
				// make sure the «feature.featureName» list is created
				«feature.accessorName»();
	
				final Object rawValue = ZDLUtil.getValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»");
				@SuppressWarnings("unchecked")
				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
				rawList.add(val.eObject());
				if(«feature.featureFieldName» != null) {
					«feature.featureFieldName».add(val);
				}
			}
			public «feature.compositeMultivaluedAddParemeterizedSignature»{
				// make sure the «feature.domainAttribute.name» list is created
				«feature.accessorName»();
				org.eclipse.emf.ecore.EObject newConcept = 
					ZDLUtil.createZDLConcept(element, "«feature.conceptQualifiedName»", "«feature.featureName»", concept);
				T element = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) newConcept,
								typeToCreate);
				if(«feature.featureFieldName» != null) {
					«feature.featureFieldName».add(element);
				}
				return element;
			}
			«IF ! feature.typeIsAbstract»public «feature.compositeMultivalueAddSignature»{
				// make sure the «feature.featureName» list is created
				«feature.accessorName»();
				org.eclipse.emf.ecore.EObject newConcept = 
					ZDLUtil.createZDLConcept(element, "«feature.conceptQualifiedName»", "«feature.featureName»", "«feature.featureTypeQualifiedName»");
				«feature.featureModifierType» element = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) newConcept,
								«feature.featureModifierType».class);
				if(«feature.featureFieldName» != null) {
					«feature.featureFieldName».add(element);
				}
				return element;
			}«ENDIF»
			'''.toString
		} else {
			'''
			public «feature.compositeAddExistingSignature»{
				«IF feature.hasPrimitiveType || feature.hasEnumerationType || feature.hasUMLType»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val);
				«ELSE»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val.eObject());
				«ENDIF»
			}
			public «feature.compositeAddParemeterizedSignature»{
				org.eclipse.emf.ecore.EObject newConcept = 
					ZDLUtil.createZDLConcept(element, "«feature.conceptQualifiedName»", "«feature.featureName»", concept);
				T element = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) newConcept,
								typeToCreate);
				return element;
			}
			«IF ! feature.typeIsAbstract»public «feature.compositeAddSignature»{
				org.eclipse.emf.ecore.EObject newConcept = 
					ZDLUtil.createZDLConcept(element, "«feature.conceptQualifiedName»", "«feature.featureName»", "«feature.featureTypeQualifiedName»");
				«feature.featureModifierType» element = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) newConcept,
								«feature.featureModifierType».class);
				return element;
			}«ENDIF»
			'''.toString
		}
    }
    
    def private compositeModifierImplementationOverriden(GenDomainStructuralFeature feature) {
    	if(feature.domainAttribute.multivalued) {
			'''
			public «feature.compositeMultivaluedAddExistingSignature»{
				throw new UnsupportedOperationException();
			}
			public «feature.compositeMultivaluedAddParemeterizedSignature»{
				throw new UnsupportedOperationException();
			}
			«IF ! feature.typeIsAbstract»public «feature.compositeMultivalueAddSignature»{
				throw new UnsupportedOperationException();
			}«ENDIF»
			'''.toString
		} else {
			'''
			public «feature.compositeAddExistingSignature»{
				throw new UnsupportedOperationException();
			}
			public «feature.compositeAddParemeterizedSignature»{
				throw new UnsupportedOperationException();
			}
			«IF ! feature.typeIsAbstract»public «feature.compositeAddSignature»{
				throw new UnsupportedOperationException();
			}«ENDIF»
			'''.toString
		}
    }
    
    def private sharedModifierImplementation(GenDomainStructuralFeature feature) {
    	if(feature.domainAttribute.multivalued) {
			'''public «feature.sharedMultivaluedAddSignature»{
				// make sure the «feature.featureName» list is created
				«feature.accessorName»();

				final Object rawValue = ZDLUtil.getValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»");
				@SuppressWarnings("unchecked")
				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
				rawList.add(val.eObject());
				if(«feature.featureFieldName» != null) {
					«feature.featureFieldName».add(val);
				}
			}'''.toString
		} else {
			'''public «feature.sharedAddSignature»{
				«IF feature.hasPrimitiveType || feature.hasUMLType»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val);
				«ELSEIF feature.hasEnumerationType»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val.eObject(element));
				«ELSE»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val.eObject());
				«ENDIF»
			}'''.toString
		}
    }
    
    def private sharedModifierImplementationOverriden(GenDomainStructuralFeature feature) {
    	if(feature.domainAttribute.multivalued) {
			'''public «feature.sharedMultivaluedAddSignature»{
				throw new UnsupportedOperationException();
			}'''.toString
		} else {
			'''public «feature.sharedAddSignature»{
				throw new UnsupportedOperationException();
			}'''.toString
		}
    }
    
    def private noneModifierImplementation(GenDomainStructuralFeature feature){
    	if(feature.domainAttribute.multivalued) {
			'''public «feature.noneMultivaluedAddSignature»{
				// make sure the «feature.featureName» list is created
				«feature.accessorName»();

				final Object rawValue = ZDLUtil.getValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»");
				@SuppressWarnings("unchecked")
				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
				«IF feature.hasPrimitiveType »
				rawList.add(val);
				«ELSEIF feature.hasEnumerationType»
				rawList.add(val.eObject(element));
				«ELSE»
				rawList.add(val.eObject());
				«ENDIF»
				if(«feature.featureFieldName» != null) {
					«feature.featureFieldName».add(val);
				}
			}'''.toString
		} else {
			'''public «feature.noneAddSignature»{
				«IF feature.hasPrimitiveType || feature.hasUMLType»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val);
				«ELSEIF feature.hasEnumerationType»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val.eObject(element));
				«ELSE»
				ZDLUtil.setValue(element, "«feature.conceptQualifiedName»", "«feature.featureName»", val.eObject());
				«ENDIF»
			}'''.toString
		}
    }
    
    def private noneModifierImplementationOverriden(GenDomainStructuralFeature feature){
    	if(feature.domainAttribute.multivalued) {
			'''public «feature.noneMultivaluedAddSignature»{
				throw new UnsupportedOperationException();
			}'''.toString
		} else {
			'''public «feature.noneAddSignature»{
				throw new UnsupportedOperationException();
			}'''.toString
		}
    }
    
    def implementationImports(GenDomainConcept concept) {
        val firstBaseConcept = concept.generals.head
        val baseConceptsToImplement = 
            concept.baseDomainConceptsToImplement
        // features
        val featureTypes = concept.features.map(GenDomainStructuralFeature feature | feature.featureType)
        val inconsistentOverrideInterfaces = concept.features
            .filter(GenDomainStructuralFeature feature | feature.isInconsistentOverride)
            .map(GenDomainStructuralFeature overriden | overriden.overridenGenFeatures).flatten
            .map(GenDomainStructuralFeature baseFeature | baseFeature.featureType)
        val baseFeatureTypes = baseConceptsToImplement.map(GenDomainConcept baseConcept | baseConcept.features.map(GenDomainStructuralFeature feature | feature.featureType)).flatten
        var Set<GenDomainClassifier> allInclusions = new HashSet<GenDomainClassifier>()
        allInclusions.addAll(featureTypes)
        allInclusions.addAll(baseFeatureTypes)
        allInclusions.addAll(inconsistentOverrideInterfaces)
        allInclusions.remove(concept)
        
        '''
        import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
        «IF firstBaseConcept == null»
        import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;
        «ENDIF»
        
        import «concept.qualifiedName»;
        «IF firstBaseConcept != null»import «firstBaseConcept.implementationQualifiedName»;«ENDIF»
        
        «FOR inclusion: allInclusions.filterNull»
        «inclusion.inclusionHelper»
        «ENDFOR»
        
        import com.zeligsoft.base.zdl.util.ZDLUtil;
        '''
        
    } 
    
    def inclusionHelper(GenDomainClassifier type) '''
        «type.generateImport»
    '''

    def umlMappingImplementationMethods(GenDomainConcept concept) {
    '''«FOR umlClass:concept.allMetaclassesToImplementAccessorsFor»
    @Override
    public org.eclipse.uml2.uml.«umlClass.name» as«umlClass.name.toFirstUpper»() {
        return (org.eclipse.uml2.uml.«umlClass.name») eObject();
    }
    «ENDFOR»'''
    }
    
    def implementationStandardFields(GenDomainConcept concept) {
    ''''''
    }
    
    def implementationStandardAccessors(GenDomainConcept concept) ''''''
    
    def implementationConstructor(GenDomainConcept concept) '''
        public «concept.javaImplementationName»(org.eclipse.emf.ecore.EObject element) {
            super(element);
        }
    '''
    
    def implementationFields(GenDomainConcept concept) '''
        «FOR feature : concept.allFeaturesToImplement»
        «feature.implementationField»
        «ENDFOR»
    '''
    
    def private implementationField(GenDomainStructuralFeature feature) '''
    «IF feature.domainAttribute.multivalued»
        protected java.util.List<«feature.typeAsString»> «feature.featureFieldName»;
        «ELSEIF !(feature.hasPrimitiveType)»
        protected «feature.typeAsString» «feature.featureFieldName»;
        «ENDIF»
    '''
    
    def private featureFieldName(GenDomainStructuralFeature feature) {
        '''_«UML2Util::getValidJavaIdentifier(feature.domainAttribute.name)»'''.toString
    }
}