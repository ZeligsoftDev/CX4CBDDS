package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation

class AssemblyImplementationRhapsodyExt {
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch AssemblyImplementation importAssemblyImplementation(IRPClass source, Object context) {
        val name = source.name
    	val assembly = createZDLElement(context, name, CCMNames::ASSEMBLY_IMPLEMENTATION, typeof(AssemblyImplementation)) as AssemblyImplementation
        source.nestedElements.toList.forEach(IRPModelElement el | el.map(assembly))
        source.generalizations.toList.forEach(IRPGeneralization g | g.mapGeneralization(assembly.eObject))
        
        return assembly
    }
    
    def dispatch AssemblyImplementation importAssemblyImplementation(IRPModelElement source, Object context) {
	} 
}