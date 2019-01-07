package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPTemplateInstantiationParameter
import com.telelogic.rhapsody.core.IRPTemplateParameter
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleBinding
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule
import java.util.List
import org.eclipse.uml2.uml.Package

class ModuleInstantiationRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension RhapsodyImportTraversal
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyZDLUtil
    
    def dispatch ModuleInstantiation importModuleInstantiation(IRPClass source, Package context) {
        val name = source.name
    	val element = createZDLElement(context, name, IDL3PlusNames::MODULE_INSTANTIATION, typeof(ModuleInstantiation)) as ModuleInstantiation
        val moduleBinding = createZDLElement(element, "", IDL3PlusNames::MODULE_BINDING, typeof(ModuleBinding)) as ModuleBinding
        val moduleToInstantiate = source.ofTemplate
        if(moduleToInstantiate != null){
			updateRequired.add(new ReferenceUpdateMetadata(IDL3PlusNames::MODULE_BINDING, 
	    			IDL3PlusNames::MODULE_BINDING__TEMPLATE, 
	   				moduleBinding.asTemplateBinding, moduleToInstantiate.fullPathName))
   		}
   		val ti = source.ti
   		if(ti != null){
	        source.ti.templateInstantiationParameters.toList.forEach(IRPTemplateInstantiationParameter p | p.populateParameter(element, moduleBinding))
        }
        val packagedElements = source.nestedElements.toList
        packagedElements.forEach(IRPModelElement pkgE | pkgE.map(element))

        return element
    }
    
	 def dispatch ModuleInstantiation importModuleInstantiation(IRPClass source, CORBAModule context) {
    	return importModuleInstantiation(source, context.asPackage)
    }
    
	def private void populateParameter(IRPTemplateInstantiationParameter parameter, ModuleInstantiation container, ModuleBinding binding) { 
		val paramBinding = binding.addParameterBinding
        val type = parameter.type
        if(type != null){		
			updateRequired.add(new ReferenceUpdateMetadata(IDL3PlusNames::PARAMETER_BINDING, 
	            			IDL3PlusNames::PARAMETER_BINDING__TYPE, 
	           				paramBinding.asTemplateParameterSubstitution, type.fullPathName))
        }
        val paramName = parameter.name
        val templateModule = parameter.owner.ofTemplate
        if(templateModule != null && templateModule.isZDLConcept(IDL3PlusNames::TEMPLATE_MODULE)){
	        val params = templateModule.templateParameters.toList.filter(IRPTemplateParameter p | p.name.equals(paramName))
	        if(params.size > 0){
				updateRequired.add(new ReferenceUpdateMetadata(IDL3PlusNames::PARAMETER_BINDING, 
		            			IDL3PlusNames::PARAMETER_BINDING__TYPE_PARAMETER,
		           				paramBinding.asTemplateParameterSubstitution, params.head.fullPathName))
	        }
        }
	}

    def dispatch ModuleInstantiation importModuleInstantiation(IRPModelElement source, Object context) {
    	return null
	}
	
}