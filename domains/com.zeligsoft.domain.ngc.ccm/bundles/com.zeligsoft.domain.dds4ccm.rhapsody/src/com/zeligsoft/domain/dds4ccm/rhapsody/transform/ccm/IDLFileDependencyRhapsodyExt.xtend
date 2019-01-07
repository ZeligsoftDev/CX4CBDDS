package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPDependency
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule
import java.util.List

class IDLFileDependencyRhapsodyExt {
    @Inject extension DDS4CCMFactory
    
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    def dispatch IDLFileDependency importIDLFileDependency(IRPDependency source, CORBAModule context) {
    	val dependsOn = source.dependsOn
        val element = createZDLElement(context, "", DDS4CCMNames::IDLFILE_DEPENDENCY, typeof(IDLFileDependency)) as IDLFileDependency
        element.asDependency.clients.add(context.asPackage)
        if(dependsOn != null){
	    	updateRequired.add(new ReferenceUpdateMetadata(DDS4CCMNames::IDLFILE_DEPENDENCY, DDS4CCMNames::IDLFILE_DEPENDENCY__FILE, 
	    		element.asDependency, dependsOn.fullPathName))
    	}
    	return element
    }
    
    def dispatch IDLFileDependency importIDLFileDependency(IRPModelElement source, Object context) {
	} 
}