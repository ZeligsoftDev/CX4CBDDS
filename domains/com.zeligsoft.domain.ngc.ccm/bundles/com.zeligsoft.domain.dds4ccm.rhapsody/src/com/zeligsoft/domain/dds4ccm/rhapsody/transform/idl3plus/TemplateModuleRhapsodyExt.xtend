package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPTemplateParameter
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil
import com.google.inject.name.Named
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Element
import java.util.Arrays

class TemplateModuleRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch TemplateModule importTemplateModule(IRPClass source, Object context) {
        val name = source.name
    	val element = createZDLElement(context, name, IDL3PlusNames::TEMPLATE_MODULE, typeof(TemplateModule)) as TemplateModule
        
        source.templateParameters.toList.forEach(IRPTemplateParameter p | p.populateTemplateParameter(element))
        val packagedElements = source.nestedElements.toList
        packagedElements.forEach(IRPModelElement pkgE | pkgE.map(element))
        
        typeCache.put(source.fullPathName, element.asPackage);
        return element
    }
    
	def private populateTemplateParameter(IRPTemplateParameter param, TemplateModule container) { 
		// Populate template parameters
		var signature = container.signature
		if(signature == null){
			signature = createZDLElement(container, "", IDL3PlusNames::TEMPLATE_SIGNATURE, typeof(TemplateSignature)) as TemplateSignature
		}

		var constraint = param.declaration
		if(constraint.toLowerCase.contains("sequence")){
			constraint = "sequence"
		}else if(constraint.equals("class")){
			constraint = "typename"
		}
		val constraints = Arrays::asList("typename",
				"interface", "eventtype", "struct", "union", "sequence",
				"array", "enum")
		if(constraints.contains(constraint)){
			val EObject result = IDL3PlusUtil::createTemplateParameter(container.asPackage, param.name, constraint)
			if(result instanceof Element){
				typeCache.put(param.owner.fullPathName + "::" + param.name, result as Element)
			}
		}
	}
    
    
    def dispatch TemplateModule importTemplateModule(IRPModelElement source, Object context) {
    	return null
	}
	
}