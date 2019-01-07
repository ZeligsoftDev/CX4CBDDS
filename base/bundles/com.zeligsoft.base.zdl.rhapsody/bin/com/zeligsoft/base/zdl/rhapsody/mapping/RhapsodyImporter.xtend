package com.zeligsoft.base.zdl.rhapsody.mapping

import org.eclipse.emf.ecore.EObject
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPStereotype
import com.telelogic.rhapsody.core.RhapsodyAppServer
import com.telelogic.rhapsody.core.IRPProject
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.google.common.base.Strings

class RhapsodyImporter {
    
    def void importElement(String project, String elementQName, String rhapsodyMetaclass, EObject context) {
        val application = RhapsodyAppServer::createRhapsodyApplication
        
        try {
            if(application != null) {
                val rhapsodyProject = application.openProject(project)
                
                importElement(rhapsodyProject, elementQName, rhapsodyMetaclass, context)
            }
        } finally {
            if (application != null) {
                application.quit
            }
        }
    }
    
    def void importElement(String elementQName, String rhapsodyMetaclass, EObject context) {
        val application = RhapsodyAppServer::activeRhapsodyApplication
        
        try {
            if(application != null) {
                val rhapsodyProject = application.activeProject
                
                importElement(rhapsodyProject, elementQName, rhapsodyMetaclass, context)
            }
        } finally {
            if (application != null) {
                application.quit
            }
        }
    }
    
    def void importElement(IRPProject rhapsodyProject, String elementQName, String rhapsodyMetaclass, EObject context) {
        if(rhapsodyProject != null) {
            val element = rhapsodyProject.findElementsByFullName(elementQName, rhapsodyMetaclass)
            if(element != null) {
                map(element, context)
            }
        }
    }
    
    def EObject map(IRPModelElement self, EObject context) {
        val stereotypes = self.stereotypes
        
        val IRPStereotype zdlStereotype = stereotypes.toList.findFirst(s | (s as IRPStereotype).isZDLConcept)
        if(zdlStereotype != null) {
            val zdlConcept = zdlStereotype.getPropertyValueExplicit("CX.DomainModel.DefiningConcept")
        
            if(!Strings::isNullOrEmpty(zdlConcept)) {
                if(context != null) {
                    val newObject = ZDLUtil::createZDLConcept(context, zdlConcept)
                    System::out.println("Created a new model element of type " + zdlConcept)
                    return newObject
                }
            }
        }
        return null
    }
    
    def boolean isZDLConcept(IRPStereotype stereotype) {
        try {
            val zdlConcept = stereotype.getPropertyValueExplicit("CX.DomainModel.DefiningConcept")
        } catch(Exception ex) {
            return false
        }
        
        return true
    }
}