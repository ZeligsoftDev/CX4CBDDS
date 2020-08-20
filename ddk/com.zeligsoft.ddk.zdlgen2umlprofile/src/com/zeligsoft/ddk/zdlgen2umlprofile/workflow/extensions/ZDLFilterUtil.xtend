package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import org.eclipse.emf.ecore.EObject
import com.zeligsoft.base.zdl.util.ZDLUtil

class ZDLFilterUtil {
	
	def findConcepts(org.eclipse.uml2.uml.Package pkg, String concept) {
	    val conceptElements = 
	       pkg.packagedElements.filter(EObject eobj | ZDLUtil::isZDLConcept(eobj, concept))
        val result = conceptElements.map(EObject eobj | eobj)
	}
}