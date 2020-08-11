package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.zeligsoft.base.zdl.ZDLNames
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject

class GenDomainConceptExtensions {
    @Inject extension GenDomainStructuralFeatureExtensions
    
	def baseDomainConcepts(GenDomainConcept concept) {
		val result = concept.domainConcept.generals
		result.remove(concept.domainConcept)
		return result
	}
	
	def baseDomainConceptsToImplement(GenDomainConcept concept) {
	    val firstBaseConcept = concept.generals.head
	    val result = 
            new ArrayList<GenDomainConcept>(concept.allGenerals)
        
        if(firstBaseConcept != null) {
            result.remove(firstBaseConcept)
            result.removeAll(firstBaseConcept.allGenerals)
        }
        
        result
	}
	
	def allFeaturesToImplement(GenDomainConcept concept) {
	    val Map<String, GenDomainStructuralFeature> featureNameMap = newHashMap()
	    
	    for(nextFeature : concept.features) {
	        featureNameMap.put(nextFeature.featureName, nextFeature)
	    }
	    
	    for(baseConcept : concept.baseDomainConceptsToImplement) {
	        for(nextFeature : baseConcept.features) {
	            if(!featureNameMap.containsKey(nextFeature.featureName)) {
	               featureNameMap.put(nextFeature.featureName, nextFeature)
	               
	            }
	        }
	    }
	    
	    featureNameMap.values.toList
	}
	
	def allMetaclassesToImplementAccessorsFor(GenDomainConcept concept) {
	    val List<org.eclipse.uml2.uml.Class> result = newArrayList()
	    result.addAll(concept.umlMetaclasses)
	    for(baseConcept:concept.baseDomainConceptsToImplement) {
	        result.addAll(baseConcept.umlMetaclasses)
	    }
	    
	    result.toSet
	}
}
