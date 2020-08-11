package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.common.collect.Sets
import com.google.inject.Inject
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
import java.util.Set
import org.eclipse.uml2.uml.Classifier
import org.eclipse.uml2.uml.Feature
import org.eclipse.uml2.uml.Property
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
import org.eclipse.uml2.uml.Type

class GenDomainStructuralFeatureExtensions {
    @Inject extension JavaNamingExtensions
    
	def dispatch typeAsString(GenDomainAttribute feature) {
		if(feature.type == null) {
			if(feature.domainAttribute.type == null) {
			    if(feature.umlMetaattribute != null) {
			        "org.eclipse.uml2.uml." + feature.umlMetaattribute.type.name
			    } else {
			        'TYPE IS NULL'
			    }
			} else {
				val type = feature.domainAttribute.type.name
				if(type == 'UnlimitedNatural') {
					return 'Integer'
				} else {
					type
				}
			}
		} else {
			feature.type.javaInterfaceName
		}
	}
	
	def dispatch hasZDLType(GenDomainReference feature) {
	    var result = false
        if(feature.target == null) {
           if(feature.domainAttribute.type == null) {
               result = false
           } else {
               switch(feature.domainAttribute.type.name) {
                   case 'Integer' :
                       result = false
                   case 'UnlimitedNatural':
                       result = false
                   case 'String' :
                       result = false
                   case 'Boolean' :
                       result = false
                   default :
                       result = true
                }
           }
        } else {
            result = true
        }
        
        result
	}
	
	def dispatch hasZDLType(GenDomainAttribute feature) {
	    var result = false
	    if(feature.type == null) {
	       if(feature.domainAttribute.type == null) {
	           result = false
	       } else {
	           switch(feature.domainAttribute.type.name) {
                   case 'Integer' :
                       result = false
                   case 'UnlimitedNatural':
                       result = false
                   case 'String' :
                       result = false
                   case 'Boolean' :
                       result = false
                   default :
                       result = true
                }
	       }
	    } else {
	        result = true
	    }
	    
	    result
	}
	
	def dispatch hasUMLType(GenDomainReference feature) {
		var result = false
	    if(feature.target == null) {
            if(feature.domainAttribute.type == null) {
                if(feature.umlMetaattribute != null) {
                    result = true
                } else {
                    result = false
                }
            } else {
                result = false
            }
        } else {
            result = false
        }
        
        result
	}
	
	def dispatch hasUMLType(GenDomainAttribute feature) {
	    var result = false
	    if(feature.type == null) {
            if(feature.domainAttribute.type == null) {
                if(feature.umlMetaattribute != null) {
                    result = true
                } else {
                    result = false
                }
            } else {
                result = false
            }
        } else {
            result = false
        }
        
        result
	}
	
	def dispatch hasPrimitiveType(GenDomainReference feature) {
	    var result = false
	    if(feature.target == null) {
	        if(feature.domainAttribute.type == null) {
	            result = false
	        } else {
	            switch(feature.domainAttribute.type.name) {
                   case 'Integer' :
                       result = true
                   case 'UnlimitedNatural':
                       result = true
                   case 'String' :
                       result = true
                   case 'Boolean' :
                       result = true
                   default :
                       result = false
                }
	        }
	    }
	    
	    return result
	}
	
	def dispatch hasPrimitiveType(GenDomainAttribute feature) {
	    var result = false
	    
	    if(feature.type == null) {
	        if(feature.domainAttribute.type == null) {
	            result = false
	        } else {
	            switch(feature.domainAttribute.type.name) {
	               case 'Integer' :
	                   result = true
	               case 'UnlimitedNatural':
	                   result = true
                   case 'String' :
	                   result = true
	               case 'Boolean' :
	                   result = true
	               default :
	                   result = false
	            }
	        }
	    }
	    
	    result
	}
	
	def dispatch typeAsString(GenDomainReference feature) {
		if(feature.target == null) {
			if(feature.umlMetaattribute != null) {
                    "org.eclipse.uml2.uml." + feature.umlMetaattribute.type.name
            } else {
                'TYPE IS NULL'
            }
		} else {
			feature.target.javaInterfaceName
		}
	}
	
	def dispatch hasEnumerationType(GenDomainAttribute feature) {
	    feature.type instanceof GenDomainEnum
	}
	
	def dispatch hasEnumerationType(GenDomainReference feature) {
        feature.target instanceof GenDomainEnum
    }
	
	def conceptQualifiedName(GenDomainStructuralFeature feature) {
		feature.concept.domainElement.qualifiedName
	}
	
	def featureAccessorReturnType(GenDomainStructuralFeature feature) {
        if(feature.domainAttribute.multivalued) {
            '''java.util.List<«feature.typeAsString»>'''
        } else {
            feature.typeAsString
        }
    }
    
    def featureModifierType(GenDomainStructuralFeature feature) {
    	feature.typeAsString
    }
    
    def isConsistentOverride(GenDomainStructuralFeature feature, GenDomainStructuralFeature overriden) {
        var result = false
        if(feature.domainAttribute.name.equalsIgnoreCase(overriden.domainAttribute.name)) {
            //if(feature.domainAttribute.redefinedProperties.contains(overriden.domainAttribute)) {
                val featureType = feature.domainAttribute.type
                val overridenType = overriden.domainAttribute.type
                
                if(featureType.conformsTo(overridenType)) {
                    result = true
                } 
            //}
        }
        
        result
    }
    
    def isInconsistentOverride(GenDomainStructuralFeature feature, GenDomainStructuralFeature overriden) {
        var result = false
        if(feature.domainAttribute.name.equalsIgnoreCase(overriden.domainAttribute.name)) {
            //if(feature.domainAttribute.redefinedProperties.contains(overriden.domainAttribute)) {
                val featureType = feature.domainAttribute.type
                val overridenType = overriden.domainAttribute.type
                
                if(!featureType.conformsTo(overridenType)) {
                    result = true
                }
            //}
        }
        
        result
    }
    
    def isOverride(GenDomainStructuralFeature feature) {
        var result = false
        val overridenFeature = 
            feature.overridenFeatures
            
        if(!overridenFeature.empty) {
            result = true
        }
        
        result
    }
    
    def isInconsistentOverride(GenDomainStructuralFeature feature) {
        var result = false
        val overridenFeature = 
            feature.overridenFeatures
            
        for(next : overridenFeature) {
            val featureType = feature.domainAttribute.type
            val overridenType = next.type
            
            if(!featureType.conformsTo(overridenType)) {
                result = true
            } else if(feature.domainAttribute.multivalued != next.multivalued) {
                result = true
            }
        }
        
        result
    }
    
    def getInconsistentOverrideString(GenDomainStructuralFeature feature){
        var count = 0;
        val overridenFeature = 
            feature.overridenFeatures
            
        for(next : overridenFeature) {
            val featureType = feature.domainAttribute.type
            val overridenType = next.type
            
            if(!featureType.conformsTo(overridenType)) {
                count = count + 1;
            } else if(feature.domainAttribute.multivalued != next.multivalued) {
                count = count + 1
            }
        }
        
        if(count == 1){
            "Override"
        }else if(count > 1){
            "Override" + count
        }else{
            ""
        }
    }
    
    def Set<Property> overridenFeatures(GenDomainStructuralFeature feature) {
        val concept = feature.concept
        val generals = concept.domainConcept.allParents
        val Set<Property> overridenFeatures = Sets::newHashSet()
        
        for(Classifier c : generals) {
            overridenFeatures.addAll(c.attributes.filter([Feature f | f != feature.domainAttribute && feature.domainAttribute.name.equalsIgnoreCase(f.name)]))
        }
        
        overridenFeatures
    }
    
    def Set<GenDomainStructuralFeature> overridenGenFeatures(GenDomainStructuralFeature feature) {
        val concept = feature.concept
        val generals = concept.allGenerals
        val Set<GenDomainStructuralFeature> overridenFeatures = Sets::newHashSet()
        
        for(GenDomainConcept c : generals) {
            overridenFeatures.addAll(c.features.filter([GenDomainStructuralFeature f | f != feature && feature.featureName.equals(f.featureName)]))
        }
        
        overridenFeatures
    }
    
    def dispatch featureName(GenDomainAttribute attr) {
        attr.name
    }
    
    def dispatch featureName(GenDomainReference ref) {
        ref.domainAttribute.name
    }
    
    def dispatch featureType(GenDomainAttribute attr) {
        attr.type
    }
    
    def dispatch featureType(GenDomainReference ref) {
        ref.target
    }
    
    def featureTypeQualifiedName(GenDomainStructuralFeature feat) {
    	val featureType = feat.featureType
    	if(featureType == null) {
    		""
    	} else {
    		featureType.domainElement.qualifiedName
    	}
    }
    
    def dispatch typeIsAbstract(GenDomainAttribute attr) {
    	val Type attrType = attr.domainAttribute.type
    	switch attrType {
    		Classifier : attrType.isAbstract
    		default : false
    	}
    }
    
    def dispatch typeIsAbstract(GenDomainReference attr) {
    	val Type attrType = attr.domainAttribute.type
    	switch attrType {
    		Classifier : attrType.isAbstract
    		default : false
    	}
    }
}