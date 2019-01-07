package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPInstance
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeInstance
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List

class HomeInstanceRhapsodyExt {
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch HomeInstance importHomeInstance(IRPInstance source, AssemblyImplementation context) {
    	val name = source.name
        val element = createZDLElement(context, name, CCMNames::HOME_INSTANCE, typeof(HomeInstance)) as HomeInstance
        element.asProperty.setIsComposite(true);
        val definition = source.otherClass
        if(definition != null) {
            updateRequired.add(new ReferenceUpdateMetadata(CCMNames::HOME_INSTANCE, 
            ZMLMMNames::PART__DEFINITION, 
            element.asProperty, definition.fullPathName));
        }
        return element
    }
    
    def dispatch HomeInstance importHomeInstance(IRPModelElement source, Object context) {
	}
}