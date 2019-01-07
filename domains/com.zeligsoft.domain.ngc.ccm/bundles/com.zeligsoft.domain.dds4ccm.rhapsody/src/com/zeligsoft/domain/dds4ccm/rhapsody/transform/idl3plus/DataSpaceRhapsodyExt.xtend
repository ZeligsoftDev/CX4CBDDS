package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPInstance
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Connectors.DataSpace
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation
import java.util.List
import org.eclipse.uml2.uml.VisibilityKind

class DataSpaceRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch DataSpace importDataSpace(IRPInstance source, AssemblyImplementation context) {
    	val name = source.name
        val dataSpace = createZDLElement(context, name, IDL3PlusNames::DATA_SPACE, typeof(DataSpace)) as DataSpace
        dataSpace.asProperty.setIsComposite(true);
        dataSpace.asProperty.setVisibility(VisibilityKind::PRIVATE_LITERAL) 
        val definition = source.otherClass
        if(definition != null && !definition.fullPathName.equals(source.fullPathName)) {
            updateRequired.add(new ReferenceUpdateMetadata(IDL3PlusNames::DATA_SPACE, 
            IDL3PlusNames::DATA_SPACE__CONNECTOR_TYPE, 
            dataSpace.asProperty, definition.fullPathName));
        }
        typeCache.put(source.fullPathName, dataSpace.asProperty)
        return dataSpace
    }
    
    def dispatch DataSpace importDataSpace(IRPModelElement source, Object context) {
	}
}