package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPDependency
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPStereotype
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.ExtendedPortType
import java.util.List
import org.eclipse.uml2.uml.UMLPackage
import com.telelogic.rhapsody.core.IRPAttribute
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal

class ExtendedPortTypeRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject 
    @Named(RhapsodyImportModule::RELATION_UPDATE_LIST_BINDING)
    private List<RelationUpdateMetadata> relationUpdateCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    
    def dispatch ExtendedPortType importExtendedPortType(IRPClass source, Object context) {
        val name = source.name
    	val porttype = createZDLElement(context, name, IDL3PlusNames::EXTENDED_PORT_TYPE, typeof(ExtendedPortType)) as ExtendedPortType
        typeCache.put(source.fullPathName, porttype.asClass)
        source.generalizations.toList.forEach(IRPGeneralization r | r.mapRelation(porttype))
        source.dependencies.toList.forEach(IRPDependency d | d.mapDependency(porttype))
        source.attributes.toList.forEach(IRPAttribute a | a.map(porttype))

        return porttype
    }
	def private void mapRelation(IRPGeneralization gen, ExtendedPortType container) {
		val base = gen.baseClass
		if(base != null){
		val other = base.fullPathName
	        relationUpdateCache.add(new RelationUpdateMetadata(container.asClass, other, UMLPackage::eINSTANCE.interfaceRealization))
        }
	}
	
	def private void mapDependency(IRPDependency dependency, ExtendedPortType container) {
		dependency.stereotypes.toList.forEach(IRPStereotype st | st.mapDependency(dependency, container))
	}
	
	def private void mapDependency(IRPStereotype st, IRPDependency dependency, ExtendedPortType container) {
		val name = st.name
		if(name == "Usage"){
			val other = dependency.dependsOn.fullPathName
			relationUpdateCache.add(new RelationUpdateMetadata(container.asClass, other, UMLPackage::eINSTANCE.usage))
		}
	}
		
    def dispatch ExtendedPortType importExtendedPortType(IRPModelElement source, Object context) {
    	return null
	}
}