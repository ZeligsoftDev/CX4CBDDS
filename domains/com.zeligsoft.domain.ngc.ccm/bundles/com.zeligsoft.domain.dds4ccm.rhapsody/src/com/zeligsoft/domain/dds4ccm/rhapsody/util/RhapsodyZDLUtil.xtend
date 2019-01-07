package com.zeligsoft.domain.dds4ccm.rhapsody.util

import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPStereotype
import java.util.Collections
import java.util.List

import static com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants.*

class RhapsodyZDLUtil {
    
	def List getAllZdlConcept(IRPModelElement self) {
		for (Object o : self.getStereotypes().toList()) {
			val IRPStereotype st = o as IRPStereotype;
			try {
				val value = st
						.getPropertyValueExplicit(ZDL_CONCEPT_PROPERTY);
				if (value != null) {
					val concepts = value.split(",");
					return concepts.toList;
				}
			} catch (Exception e) {
				return Collections::EMPTY_LIST;
			}
		}

		return Collections::EMPTY_LIST;
	}
	    
    def String zdlConcept(IRPModelElement self) {
		val concepts = getAllZdlConcept(self);
		if (concepts.size != 0) {
			return concepts.get(0).toString
		}
		return "";
    }
    
    def IRPStereotype zdlStereotype(IRPModelElement self, String concept) {
        val stereotypes = self.stereotypes.toList
        return stereotypes.findFirst(s | (s as IRPStereotype).isZDLConcept(concept))
    }
    
    def boolean isZDLConcept(IRPModelElement self, String concept) {
		val concepts = getAllZdlConcept(self);
		for (Object aConcept : concepts) {
			if (concept.equals(aConcept.toString)) {
				return true;
			}
		}
		return false;
    }
}