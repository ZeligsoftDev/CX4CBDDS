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
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.InterconnectInstance
import java.util.List
import org.eclipse.uml2.uml.VisibilityKind

class InterconnectInstanceRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch InterconnectInstance importInterconnectInstance(IRPInstance source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CCMNames::INTERCONNECT_INSTANCE, typeof(InterconnectInstance)) as InterconnectInstance
        // part type
        element.asProperty.setIsComposite(true);
        element.asProperty.setVisibility(VisibilityKind::PRIVATE_LITERAL)
        val definition = source.otherClass
        if(definition != null) {
            updateRequired.add(new ReferenceUpdateMetadata(CCMNames::INTERCONNECT_INSTANCE, 
            CCMNames::INTERCONNECT_INSTANCE__TYPE, 
            element.asProperty, definition.fullPathName));
        }
        typeCache.put(source.fullPathName, element.asProperty)
        return element
    }
    
    def dispatch InterconnectInstance importInterconnectInstance(IRPModelElement source, Object context) {
	}
}