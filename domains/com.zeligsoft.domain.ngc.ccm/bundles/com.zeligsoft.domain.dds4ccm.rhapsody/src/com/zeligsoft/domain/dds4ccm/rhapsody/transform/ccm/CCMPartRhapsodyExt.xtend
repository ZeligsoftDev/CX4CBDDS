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
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List
import org.eclipse.uml2.uml.VisibilityKind

class CCMPartRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch CCMPart importCCMPart(IRPInstance source, AssemblyImplementation context) {
    	val name = source.name
        val ccmPart = createZDLElement(context, name, CCMNames::CCMPART, typeof(CCMPart)) as CCMPart
        // part type
        ccmPart.asProperty.setIsComposite(true);
		ccmPart.asProperty.setVisibility(VisibilityKind::PRIVATE_LITERAL)        
        val definition = source.otherClass
        if(definition != null && !definition.fullPathName.equals(source.fullPathName)) {
            updateRequired.add(new ReferenceUpdateMetadata(CCMNames::CCMPART, 
            ZMLMMNames::PART__DEFINITION, 
            ccmPart.asProperty, definition.fullPathName));
        }
        typeCache.put(source.fullPathName, ccmPart.asProperty)
        return ccmPart
    }
    
    def dispatch CCMPart importCCMPart(IRPModelElement source, Object context) {
	}
}