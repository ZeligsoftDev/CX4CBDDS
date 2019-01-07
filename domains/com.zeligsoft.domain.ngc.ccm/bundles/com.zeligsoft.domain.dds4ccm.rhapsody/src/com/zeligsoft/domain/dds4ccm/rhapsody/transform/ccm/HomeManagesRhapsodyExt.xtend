package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPDependency
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Package

class HomeManagesDependencyRhapsodyExt {
    @Inject extension DDS4CCMFactory
    
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    def dispatch Manages importManagesDependency(IRPDependency source, Home context) {
    	val dependsOn = source.dependsOn
    	val container = context.eObject.owningPackage
        val element = createZDLElement(container, "", CCMNames::MANAGES, typeof(Manages)) as Manages
        element.asDependency.clients.add(context.asClass)
        if(dependsOn != null){
	    	updateRequired.add(new ReferenceUpdateMetadata( CCMNames::MANAGES,  CCMNames::MANAGES__COMPONENT, 
	    		element.asDependency, dependsOn.fullPathName))
    	}
    	return element
    }
    
    def dispatch Manages importManagesDependency(IRPModelElement source, Object context) {
	} 
	
	def private EObject getOwningPackage(EObject source){
		if(source instanceof Package){
			return source
		}
		val owner = source.eContainer
		return owner.owningPackage
	}
}