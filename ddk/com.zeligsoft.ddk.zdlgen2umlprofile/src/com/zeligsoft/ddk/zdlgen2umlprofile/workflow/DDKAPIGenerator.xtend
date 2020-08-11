package com.zeligsoft.ddk.zdlgen2umlprofile.workflow

import com.google.inject.Inject
import com.google.inject.name.Named
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainConceptExtensions
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainStructuralFeatureExtensions
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaImplementationGenerator
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaInterfaceGenerator
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaNamingExtensions
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaUMLPackageTypeSelectUtilGenerator
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.ZDLGenExtensions
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainModelExtensions
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaEnumerationGenerator
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
import org.eclipse.uml2.common.util.UML2Util
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFileSystemAccess

class DDKAPIGenerator {
	@Inject extension GenDomainConceptExtensions
	@Inject extension GenDomainStructuralFeatureExtensions
	@Inject extension JavaNamingExtensions
	@Inject extension JavaInterfaceGenerator
	@Inject extension JavaImplementationGenerator
	@Inject extension JavaEnumerationGenerator
	@Inject extension JavaUMLPackageTypeSelectUtilGenerator
	@Inject extension ZDLGenExtensions
	@Inject extension GenDomainModelExtensions
	
	@Inject @Named('Root Package')String rootPackage
	@Inject @Named('Implementation SubPackage')String implSubPackage
	@Inject @Named('Implementation Suffix')String implSuffix
	
	@Inject IFileSystemAccess fileSystemAccess
	
	def doGenerate(GenDomainModel model) {
		model.compileFactoryClass
		model.compileTypeSelectClass
		for(block : model.domainBlocks) {
			block.doGenerate
		}
	}
	
	def doGenerate(GenDomainBlock block) {
		val blockName = block.name
		val rootDirectory = block.interfaceJavaPackage.replace('.', '/')
		val implDirectory = block.implementationJavaPackage.replace('.', '/')
		
		for(concept : block.classifiers.filter(typeof(GenDomainConcept))) {
			fileSystemAccess.generateFile(
			 '''«rootDirectory»/«concept.javaInterfaceName».java'''.toString, 
			 concept.compileInterface)
			fileSystemAccess.generateFile(
			 '''«implDirectory»/«concept.javaImplementationName».java'''.toString, 
			 concept.compileImplementation(blockName))
		}
		
		for(element : block.classifiers.filter(typeof(GenDomainEnum))) {
            fileSystemAccess.generateFile(
             '''«rootDirectory»/«UML2Util::getValidJavaIdentifier(element.javaInterfaceName)».java'''.toString, 
             element.compileEnumeration(blockName))     
        }
		//for(blockImport : block.imports) {
		//	val importedBlock = blockImport.target
		//	importedBlock.doGenerate
		//}
	}
	
	def compileTypeSelectClass(GenDomainModel model) {
	    fileSystemAccess.generateFile('''«model.rootPackage.replace(".", "/")»/«model.name»/util/«model.name»TypeSelectUtil.java'''.toString, model.generateJavaUMLPackageTypeSelectUtil);
	}
	
	def compileFactoryClass(GenDomainModel model) {
	    val domainSpecializations = 
	       model.elements.filter(typeof(GenDomainSpecialization))
	    domainSpecializations.forEach(GenDomainSpecialization spec | spec.compileFactoryClass)
	}
	
	def compileFactoryClass(GenDomainSpecialization model) {
	    val domainModel = model.eContainer.domainModel
	    fileSystemAccess.generateFile('''«domainModel.rootPackage.replace(".", "/")»/«domainModel.name»/util/«model.name»FactoryImpl.java'''.toString, model.compileFactoryClassHelper);
	}
	
	def private compileFactoryClassHelper(GenDomainSpecialization model) {
	val domainModel = model.eContainer.domainModel
	'''
	package «domainModel.rootPackage».«domainModel.name».util;
	
	import java.util.Map;
	
	import com.google.common.collect.Maps;
	
	import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;
	
	public class «model.name»FactoryImpl extends AbstractBaseZDLFactory {
		protected java.util.Map<String, Class<?>> registry 
			= Maps.newHashMap();
		
		public «model.name»FactoryImpl() {
		«FOR concept : model.domainConcepts.filter(GenDomainConcept concept | !concept.domainConcept.isAbstract)»
			registry.put("«concept.domainElement.qualifiedName»", 
				«concept.implementationQualifiedName».class);
		«ENDFOR»
		}
		
		@Override
		protected Map<String, Class<?>> getRegistry() {
		    return registry;
		}
	}
	'''
	}
}