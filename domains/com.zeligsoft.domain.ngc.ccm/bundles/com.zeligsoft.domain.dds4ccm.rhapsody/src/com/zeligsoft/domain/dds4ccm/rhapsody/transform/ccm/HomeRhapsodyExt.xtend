package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPDependency
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPOperation
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FactoryOperation
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FinderOperation
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home

class HomeRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch Home importHome(IRPClass source, Object context) {
        val name = source.name
        val home = createZDLElement(context, name, CCMNames::HOME, typeof(Home)) as Home
        typeCache.put(source.fullPathName, home.asClass)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(home))
        // operations
        source.operations.toList.forEach(IRPModelElement e | e.map(home))
		// generalization
        source.generalizations.toList.forEach(IRPGeneralization g | g.mapGeneralization(home.eObject))

        source.dependencies.toList.forEach(IRPDependency d | d.map(home))
        
        return home
    }
    
    def dispatch Home importHome(IRPModelElement source, Object context) {
	}
	
	def dispatch FactoryOperation importFactoryOperation(IRPOperation source, Home context){
		val name = source.name
        val op = createZDLElement(context, name, CCMNames::FACTORY_OPERATION, typeof(FactoryOperation)) as FactoryOperation
        val parameters = source.arguments.toList
        parameters.forEach(IRPModelElement pkgE | pkgE.map(op))
		return op
		
	}
	def dispatch FactoryOperation importFactoryOperation(IRPModelElement source, Object context){
		return null
	}	

	def dispatch FinderOperation importFinderOperation(IRPOperation source, Home context){
		val name = source.name
        val op = createZDLElement(context, name, CCMNames::FINDER_OPERATION, typeof(FinderOperation)) as FinderOperation
        val parameters = source.arguments.toList
        parameters.forEach(IRPModelElement pkgE | pkgE.map(op))
		return op
		
	}
	def dispatch FinderOperation importFinderOperation(IRPModelElement source, Object context){
		return null
	}		
	
}