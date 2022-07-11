package com.zeligsoft.ddk.zdlgen2umlprofile.xtend

import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil
import com.zeligsoft.base.zdl.util.ZDLUtil
import java.net.URL
import java.nio.file.Paths
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry
import org.eclipse.gmf.runtime.emf.type.core.IClientContext
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory
import org.eclipse.papyrus.infra.types.IconEntry
import org.eclipse.papyrus.infra.types.InheritanceKind
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceConfiguration
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceFactory
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherFactory
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Stereotype
import org.eclipse.uml2.uml.UMLPackage
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherConfiguration

class MainTransform {
	ElementTypeSetConfiguration umlElementType
	IClientContext clientCtx
	Profile profile
	ElementTypeSetConfiguration typeSet
	List<Class> processedConcepts = new ArrayList<Class>()

	def mainTransform(Profile profile, ElementTypeSetConfiguration umlType, ElementTypeSetConfiguration typeSet) {
		this.profile = profile
		this.umlElementType = umlType
		this.clientCtx = ClientContextManager.getInstance().getClientContextFor(profile)
		this.typeSet = typeSet
		typeSet.description = profile.name + " Element Type Set Configuration"
		typeSet.identifier = "com.zeligsoft.domain." + profile.name.toLowerCase + ".elementTypeSet"
		typeSet.metamodelNsURI = "http://www.eclipse.org/uml2/5.0.0/UML"
		typeSet.name = profile.name
		val iter = profile.eAllContents
		while (iter.hasNext) {
			val next = iter.next
			if (next instanceof Stereotype) {
				for (concept : ZDLUtil.getZDLDefinition(next)) {
					if (concept instanceof Class) {
						val metaClass = ZDLUtil.getBaseMetaclass(profile, concept);
						if (metaClass !== null && !concept.isAbstract) {
							concept.processConcept(next)
						}
					}
				}
			}
		}
	}

	def ElementTypeConfiguration processConcept(Class concept, Stereotype st) {
		val speId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(profile, concept)
		val config = speId.findSpecializationTypeConfiguration
		if (processedConcepts.contains(concept)) {
			return config
		}
		processedConcepts.add(concept)

		var ElementTypeConfiguration result;
		if (config !== null) {
			config.configureSpecializationType(concept, st)
			result = config
		} else {
			result = concept.createSpecializedType(st)
		}

		// process advice configuration
		val advice = concept.applyStereotypeAdviceConfigurationId.findApplyStereotypeAdviceConfiguration
		if (advice !== null) {
			advice.configureApplyStereotypeAdviceConfiguration(concept, result)
		} else {
			concept.createApplyStereotypeAdvice(result)
		}

		return result

	}

	def ApplyStereotypeAdviceConfiguration findApplyStereotypeAdviceConfiguration(String id) {
		for (advice : typeSet.adviceBindingsConfigurations) {
			if (advice.identifier == id) {
				return advice as ApplyStereotypeAdviceConfiguration
			}
		}
		return null
	}

	def SpecializationTypeConfiguration findSpecializationTypeConfiguration(String id) {
		for (et : typeSet.elementTypeConfigurations) {
			if (et.identifier == id) {
				return et as SpecializationTypeConfiguration
			}
		}
		return null
	}

	def void configureSpecializationType(SpecializationTypeConfiguration type, Class concept, Stereotype stereotype) {
		val metaclass = ZDLUtil.getBaseMetaclass(profile, concept)
		val eclass = UMLPackage.eINSTANCE.getEClassifier(metaclass.getName()) as EClass;
		val umlType = ElementTypeRegistry.getInstance().getElementType(eclass, clientCtx);
		type.name = concept.getLabel()
		type.identifier = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(profile, concept);
		type.kind = "org.eclipse.gmf.runtime.emf.type.core.IHintedType"
		if (umlType !== null) {
			val id = umlType.id
			for (etc : umlElementType.elementTypeConfigurations) {
				val umlid = etc.identifier
				if (umlid == id) {
					type.specializedTypes.add(etc)
				}
			}
		}

		var URL iconURL = null;
		var IconEntry iconEntry = null;
		if(!stereotype.icons.empty){
			iconURL = new URL(stereotype.icons.get(0).location);
		}
		if(iconURL === null){
			iconURL = ZDLUtil.getIcon(concept)
		}
		if (iconURL !== null) {
			iconEntry = iconURL.createIconEntry
		} else {
			for (st : type.specializedTypes) {
				if (st.iconEntry !== null && type.iconEntry === null) {
					iconEntry = st.iconEntry.createIconEntry
				}
			}
		}
		
		if(iconEntry !== null){
			if(type.iconEntry !== null){
				type.iconEntry.bundleId = iconEntry.bundleId;
				type.iconEntry.iconPath = iconEntry.iconPath;
				EcoreUtil.delete(iconEntry)
			}else{
				type.iconEntry = iconEntry;
			}
		}
		
		if(type.matcherConfiguration === null){
			type.matcherConfiguration = concept.createStereotypeMatcher
		}else{
			val stMatcher =	(type.matcherConfiguration as StereotypeApplicationMatcherConfiguration)
			stMatcher.stereotypesQualifiedNames.clear
			stMatcher.stereotypesQualifiedNames.add(concept.qualifiedName.domainQualifiedName)
		} 
	}

	def create result: ElementTypesConfigurationsFactory::eINSTANCE.createSpecializationTypeConfiguration createSpecializedType(
		Class concept, Stereotype st) {
		typeSet.elementTypeConfigurations.add(result)
		result.configureSpecializationType(concept, st)
	}

	def createIconEntry(IconEntry iconEntry) {
		var result = ElementTypesConfigurationsFactory::eINSTANCE.createIconEntry
		result.bundleId = iconEntry.bundleId
		var path = Paths.get(iconEntry.iconPath)
		result.iconPath = path.normalize.toString.replace("\\", "/");
		return result
	}

	def createIconEntry(URL url) {
		var result = ElementTypesConfigurationsFactory::eINSTANCE.createIconEntry
		val temp = url.toString.substring("platform:/plugin/".length)
		val index = temp.indexOf("/")
		val bundle = temp.substring(0, index)
		val path = temp.substring(index)
		result.bundleId = bundle
		if(bundle == "e"){
			result.bundleId = bundle
		}
		result.iconPath = path
		return result
	}

	def String domainQualifiedName(String qn) {

		val index = qn.lastIndexOf("::")
		val result = profile.name + qn.substring(index)
		return result
	}

	def create result : StereotypeApplicationMatcherFactory::eINSTANCE.createStereotypeApplicationMatcherConfiguration createStereotypeMatcher(
		Class concept) {
		val qn = concept.qualifiedName.domainQualifiedName
		result.stereotypesQualifiedNames.add(qn)
	}

	def configureApplyStereotypeAdviceConfiguration(ApplyStereotypeAdviceConfiguration adviceConfig, Class concept,
		ElementTypeConfiguration et) {
		adviceConfig.identifier = concept.applyStereotypeAdviceConfigurationId
		adviceConfig.inheritance = InheritanceKind::NONE
		adviceConfig.target = et
		val stToApply = concept.createStereotypeToApply
		if (!adviceConfig.stereotypesToApply.empty) {
			adviceConfig.stereotypesToApply.get(0).stereotypeQualifiedName = stToApply.stereotypeQualifiedName
			EcoreUtil.delete(stToApply)
		}else{
			adviceConfig.stereotypesToApply.add(stToApply)
		}
	}

	def String getApplyStereotypeAdviceConfigurationId(Class concept) {
		"com.zeligsoft.domain." + profile.name + ".apply" +
			concept.qualifiedName.domainQualifiedName.replaceAll("::", ".") + "Stereotype"
	}

	def create result: ApplyStereotypeAdviceFactory::eINSTANCE.createApplyStereotypeAdviceConfiguration createApplyStereotypeAdvice(
		Class concept, ElementTypeConfiguration et) {
		typeSet.adviceBindingsConfigurations.add(result)
		result.configureApplyStereotypeAdviceConfiguration(concept, et)
	}

	def create result: ApplyStereotypeAdviceFactory::eINSTANCE.createStereotypeToApply createStereotypeToApply(
		Class concept) {
		val qn = concept.qualifiedName.domainQualifiedName
		result.requiredProfiles.add(profile.name)
		result.stereotypeQualifiedName = qn
		result.updateName = true;
	}

}
