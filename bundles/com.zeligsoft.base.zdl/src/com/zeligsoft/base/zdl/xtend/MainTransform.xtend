package com.zeligsoft.base.zdl.xtend

import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil
import com.zeligsoft.base.zdl.util.ZDLUtil
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry
import org.eclipse.gmf.runtime.emf.type.core.IClientContext
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory
import org.eclipse.papyrus.infra.types.InheritanceKind
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceFactory
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherFactory
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Stereotype
import org.eclipse.uml2.uml.UMLPackage
import org.eclipse.emf.ecore.EClass
import java.net.URL
import org.eclipse.emf.ecore.resource.Resource

class MainTransform {
	ElementTypeSetConfiguration umlElementType
	IClientContext clientCtx
	Profile profile

	def create result : ElementTypesConfigurationsFactory::eINSTANCE.createElementTypeSetConfiguration mainTransform(
		Profile profile, ElementTypeSetConfiguration umlType, Resource resource) {
		resource.contents.add(result)
		this.profile = profile
		this.umlElementType = umlType
		this.clientCtx = ClientContextManager.getInstance().getClientContextFor(profile)
		result.description = profile.name + " Element Type Set Configuration"
		result.identifier = "com.zeligsoft.domain." + profile.name.toLowerCase + ".elementTypeSet"
		result.metamodelNsURI = "http://www.eclipse.org/uml2/5.0.0/UML"
		result.name = profile.name
		val iter = profile.eAllContents
		while (iter.hasNext) {
			val next = iter.next
			if (next instanceof Stereotype) {
				for (concept : ZDLUtil.getZDLDefinition(next)) {
					if (concept instanceof Class) {
						val metaClass = ZDLUtil.getBaseMetaclass(profile, concept);
						if (metaClass !== null) {
							concept.createSpecializedType(result)
						}
					}
				}
			}
		}
	}

	def create result: ElementTypesConfigurationsFactory::eINSTANCE.createSpecializationTypeConfiguration createSpecializedType(
		Class concept, ElementTypeSetConfiguration container) {
		val advice = concept.createApplyStereotypeAdvice(container)
		container.adviceBindingsConfigurations.add(advice)
		container.elementTypeConfigurations.add(result)
		val metaclass = ZDLUtil.getBaseMetaclass(profile, concept)
		val eclass = UMLPackage.eINSTANCE.getEClassifier(metaclass.getName()) as EClass;
		val umlType = ElementTypeRegistry.getInstance().getElementType(eclass, clientCtx);
		result.name = concept.getLabel()
		result.identifier = ZDLElementTypeUtil.getZDLElementTypeId(concept)
		result.kind = "org.eclipse.gmf.runtime.emf.type.core.IHintedType"
		for (supertype : concept.superClasses) {
			if (ZDLUtil.getBaseMetaclass(profile, supertype) !== null) {
				val temp = supertype.createSpecializedType(container)
				if (temp !== null) {
					result.specializedTypes.add(temp)
				}
			}
		}
		if (umlType !== null) {
			val id = umlType.id
			for (etc : umlElementType.elementTypeConfigurations) {
				val umlid = etc.identifier
				if (umlid == id) {
					result.specializedTypes.add(etc)
				}
			}
		}

		val iconURL = ZDLUtil.getIcon(concept)
		if (iconURL !== null) {
			result.iconEntry = iconURL.createIconEntry
		}
		result.matcherConfiguration = concept.createStereotypeMatcher
	}

	def create result : ElementTypesConfigurationsFactory::eINSTANCE.createIconEntry createIconEntry(URL url) {
		val temp = url.toString.substring("platform:/plugin/".length)
		val index = temp.indexOf("/")
		val bundle = temp.substring(0, index)
		val path = temp.substring(index)
		result.bundleId = bundle
		result.iconPath = path
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

	def create result: ApplyStereotypeAdviceFactory::eINSTANCE.createApplyStereotypeAdviceConfiguration createApplyStereotypeAdvice(
		Class concept, ElementTypeSetConfiguration container) {
		val qn = concept.qualifiedName.domainQualifiedName
		result.identifier = "com.zeligsoft.domain." + profile.name + ".apply" + qn.replaceAll("::", ".") + "Stereotype"
		result.inheritance = InheritanceKind::NONE
		result.target = concept.createSpecializedType(container)
		result.stereotypesToApply.add(concept.createStereotypeToApply)
	}

	def create result: ApplyStereotypeAdviceFactory::eINSTANCE.createStereotypeToApply createStereotypeToApply(
		Class concept) {
		val qn = concept.qualifiedName.domainQualifiedName
		result.requiredProfiles.add(profile.name)
		result.stereotypeQualifiedName = qn
		result.updateName = true;
	}

}
