package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.google.inject.name.Named
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import java.util.Set
import java.util.HashSet
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
import org.eclipse.uml2.uml.AggregationKind

class JavaInterfaceGenerator {
	@Inject extension GenDomainConceptExtensions
    @Inject extension GenDomainStructuralFeatureExtensions
    @Inject extension JavaNamingExtensions
    @Inject extension JavaImportExtensions
    @Inject extension JavaMethodSignaturesExtensions
    
    @Inject @Named('Root Package')String rootPackage
    @Inject @Named('Implementation SubPackage')String implSubPackage
    @Inject @Named('Implementation Suffix')String implSuffix
    
    def dispatch compileInterface(GenDomainClassifier concept) '''
       package «concept.block.interfaceJavaPackage»;

       public interface «concept.javaInterfaceName» {
       }
'''
    
    def dispatch compileInterface(GenDomainConcept concept) {
       val importedTypes = concept.interfaceImports
       '''
       package «concept.block.interfaceJavaPackage»;
       
        «IF concept.baseDomainConcepts.isEmpty»
        import com.zeligsoft.base.zdl.staticapi.core.ZObject;
       «ENDIF»
       import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
       «FOR importedType:importedTypes.filterNull»
       «IF importedType.block != concept.block»
       «importedType.generateImport»
       «ENDIF»
       «ENDFOR»

       public interface «concept.domainElement.name»«IF concept.baseDomainConcepts.isEmpty» extends ZObject«ENDIF»«FOR general:concept.baseDomainConcepts BEFORE ' extends ' SEPARATOR ', '»«general.name»«ENDFOR» {
       «FOR feature:concept.features»
          «feature.compileInterface»
       «ENDFOR»
       «concept.umlMappingInterfaceMethods»
       «concept.typeSelectFields»
       }
       '''
}

    def dispatch compileInterface(GenDomainStructuralFeature feature) ''''''
    
    def dispatch compileInterface(GenDomainAttribute feature) '''
    	«attributeAccessor(feature)»
    	«attributeModifier(feature)»
    '''
    
    def attributeAccessor(GenDomainAttribute feature) '''«feature.accessorSignature»;'''
    
    def attributeModifier(GenDomainAttribute feature) {
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''
	    				«feature.compositeMultivaluedAddExistingSignature»;
	    				«feature.compositeMultivaluedAddParemeterizedSignature»;
	    				«IF ! feature.typeIsAbstract»«feature.compositeMultivalueAddSignature»;«ENDIF»
	    				'''.toString
	    			} else {
	    				'''
	    				«feature.compositeAddExistingSignature»;
	    				«feature.compositeAddParemeterizedSignature»;
	    				«IF ! feature.typeIsAbstract»«feature.compositeAddSignature»;«ENDIF»
	    				'''.toString
	    			}
	    		case AggregationKind::SHARED: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''«feature.sharedMultivaluedAddSignature»;'''.toString
	    			} else {
	    				'''«feature.sharedAddSignature»;'''.toString
	    			}
	    		case AggregationKind::NONE: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''«feature.noneMultivaluedAddSignature»;'''.toString
	    			} else {
	    				'''«feature.noneAddSignature»;'''.toString
	    			}
	    		default : 
	    			''''''.toString
	    			
	    	}
    	}
    }
    
    def referenceModifier(GenDomainReference feature) {
    	if(!feature.domainAttribute.readOnly) {
	    	switch(feature.domainAttribute.aggregation.ordinal) {
	    		case AggregationKind::COMPOSITE: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''
	    				«feature.compositeMultivaluedAddExistingSignature»;
	    				«feature.compositeMultivaluedAddParemeterizedSignature»;
	    				«IF ! feature.typeIsAbstract»«feature.compositeMultivalueAddSignature»;«ENDIF»
	    				'''.toString
	    			} else {
	    				'''
	    				«feature.compositeAddExistingSignature»;
	    				«feature.compositeAddParemeterizedSignature»;
	    				«IF ! feature.typeIsAbstract»«feature.compositeAddSignature»;«ENDIF»
	    				'''.toString
	    			}
	    		case AggregationKind::SHARED: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''«feature.sharedMultivaluedAddSignature»;'''.toString
	    			} else {
	    				'''«feature.sharedAddSignature»;'''.toString
	    			}
	    		case AggregationKind::NONE: 
	    			if(feature.domainAttribute.multivalued) {
	    				'''«feature.noneMultivaluedAddSignature»;'''.toString
	    			} else {
	    				'''«feature.noneAddSignature»;'''.toString
	    			}
	    		default : 
	    			''''''.toString
	    			
	    	}
    	}
    }
    
    def dispatch compileInterface(GenDomainReference feature) '''
    	«referenceAccessor(feature)»
    	«referenceModifier(feature)»
    	'''
    
    def private referenceAccessor(GenDomainReference feature) '''«feature.accessorSignature»;'''
    
    def interfaceImports(GenDomainConcept concept) {
        // base interfaces
        val baseInterfaces = concept.generals
        
        // features
        val attributeInterfaces = concept.attributes.map(GenDomainAttribute attribute | attribute.type)
        val referenceInterfaces = concept.references.map(GenDomainReference ref | ref.target)
        
        var Set<GenDomainClassifier> allInclusions = new HashSet<GenDomainClassifier>()
        allInclusions.addAll(baseInterfaces)
        allInclusions.addAll(attributeInterfaces)
        allInclusions.addAll(referenceInterfaces)
        
        allInclusions.remove(concept)
        
        allInclusions.toList
    }
    
    def umlMappingInterfaceMethods(GenDomainConcept concept) '''
    «FOR umlClass:concept.umlMetaclasses»
    org.eclipse.uml2.uml.«umlClass.name» as«umlClass.name.toFirstUpper»();
    «ENDFOR»
    '''
    
    def typeSelectFields(GenDomainConcept concept) '''
    /**
     * A predicate which returns true if the Object is an
     * instance of «concept.javaInterfaceName»
     */
    static final TypeSelectPredicate<«concept.javaInterfaceName»> type = 
        new TypeSelectPredicate<«concept.javaInterfaceName»>(
            "«concept.domainElement.qualifiedName»", //$NON-NLS-1$
            «concept.javaInterfaceName».class); 
    '''
}