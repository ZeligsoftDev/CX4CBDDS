package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPInstance
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.NodeInstance
import java.util.List
import org.eclipse.uml2.uml.VisibilityKind

class NodeInstanceRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch NodeInstance importNodeInstance(IRPInstance source, Object context) {
    	val name = source.name
        val nodeInstance = createZDLElement(context, name, CCMNames::NODE_INSTANCE, typeof(NodeInstance)) as NodeInstance
        // part type
        nodeInstance.asProperty.setIsComposite(true);
        nodeInstance.asProperty.setVisibility(VisibilityKind::PRIVATE_LITERAL)
        val definition = source.otherClass
        if(definition != null) {
            updateRequired.add(new ReferenceUpdateMetadata(CCMNames::NODE_INSTANCE, 
            CCMNames::NODE_INSTANCE__TYPE, 
            nodeInstance.asProperty, definition.fullPathName));
        }
        typeCache.put(source.fullPathName, nodeInstance.asProperty)
        return nodeInstance
    }
    
    def dispatch NodeInstance importNodeInstance(IRPModelElement source, Object context) {
	}
}