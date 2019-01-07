package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeImplementation
import java.util.List
import org.eclipse.uml2.uml.UMLPackage

class HomeImplementationRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::RELATION_UPDATE_LIST_BINDING)
    private List<RelationUpdateMetadata> relationUpdateCache;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch HomeImplementation importHomeImplementation(IRPClass source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CCMNames::HOME_IMPLEMENTATION, typeof(HomeImplementation)) as HomeImplementation
        source.generalizations.toList.forEach(IRPGeneralization g | g.mapRelation(element))
        // part type
        return element
    }
    
    def dispatch HomeImplementation importHomeImplementation(IRPModelElement source, HomeImplementation context) {
	}
	
	def private void mapRelation(IRPGeneralization gen, HomeImplementation container) {
		val base = gen.baseClass
		if(base != null){
			val other = gen.baseClass.fullPathName
	        relationUpdateCache.add(new RelationUpdateMetadata(container.asComponent, other, UMLPackage::eINSTANCE.generalization))
        }
	}
}