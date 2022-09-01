/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.idl3plus.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLCopier;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry.FilteredPropertyConfiguration;
import com.zeligsoft.domain.idl3plus.l10n.Messages;
import com.zeligsoft.domain.idl3plus.merge.ClassModelMerger;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class IDL3PlusUtil {
	public static final IDL3PlusUtil INSTANCE;

	static {
		INSTANCE = new IDL3PlusUtil();
	}

	/**
	 * Create me
	 */
	protected IDL3PlusUtil() {
		// I have no state, so we will use a singleton
	}

	/**
	 * Queries if the element is child of the DDS4CCMName.TEMPLATE_MODULE
	 * package
	 * 
	 * @param element
	 * @return Template module containing this element
	 */
	public static Package getTemplateModule(EObject element) {
		if (ZDLUtil.isZDLConcept(element, IDL3PlusNames.TEMPLATE_MODULE)) {
			return (Package) element;
		}
		if (element.eContainer() != null) {
			return getTemplateModule(element.eContainer());
		}
		return null;
	}

	/**
	 * A utility to retrieve the type parameters
	 * (DDS4CCM::Generics::TypeParameter) for the provided template.
	 * 
	 * @param template
	 *            The template to get the parameters for.
	 * @return A list of the DDS4CCM::Generics::TypeParameter for the template
	 *         it will be empty if the template does not have any parameters.
	 */
	@SuppressWarnings("unchecked")
	public List<EObject> getTemplateParameters(EObject template) {
		List<EObject> result = new ArrayList<EObject>();
		EObject signature = (EObject) ZDLUtil.getValue(template,
				IDL3PlusNames.TEMPLATE_MODULE,
				IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);

		if (signature != null) {
			Object parameters = ZDLUtil.getValue(signature,
					IDL3PlusNames.TEMPLATE_SIGNATURE,
					IDL3PlusNames.TEMPLATE_SIGNATURE__TYPE_PARAMETER);

			if (parameters instanceof Collection) {
				for (Object p : (Collection<Object>) parameters) {
					if (ZDLUtil.isZDLConcept((EObject) p,
							IDL3PlusNames.TYPE_PARAMETER)) {
						result.add((EObject) p);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Given a TemplateModule instantiate it by creating a ModuleInstantiation
	 * with a binding to the <code>moduleToInstantiate</code>. It will add the
	 * newly instantiated module to the <code>container</code> provided.
	 * 
	 * @param container
	 *            The container to instantiate the module in. Can not be null.
	 * @param moduleToInstantiate
	 *            The template to instantiate. Can not be null.
	 * @return The new ModuleInstantiation.
	 */
	public EObject instantiateTemplateModule(EObject container,
			EObject moduleToInstantiate,
			Map<ClassifierTemplateParameter, EObject> instantiationMap) {

		ZDLCopier copier = new ZDLCopier();

		EObject instantiatedModule = instantiateTemplateModule(container,
				moduleToInstantiate, instantiationMap, copier);

		copier.clear();
		copier = null;

		return instantiatedModule;

	}

	@SuppressWarnings("unchecked")
	private EObject instantiateTemplateModule(EObject container,
			EObject moduleToInstantiate,
			Map<ClassifierTemplateParameter, EObject> instantiationMap,
			ZDLCopier copier) {
		EObject instantiatedModule = null;

		if (moduleToInstantiate == null) {
			throw new IllegalArgumentException(
					Messages.IDL3PlusUtil_Exception_NullModuleToInstantiateParameter);
		}

		Object signature = ZDLUtil.getValue(moduleToInstantiate,
				IDL3PlusNames.TEMPLATE_MODULE,
				IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);

		if (signature == null) {
			throw new IllegalArgumentException(
					Messages.IDL3PlusUtil_Exception_TemplateDoesNotHaveSignature);
		}

		instantiatedModule = ZDLUtil.createZDLConceptIn(container,
				IDL3PlusNames.MODULE_INSTANTIATION);

		EObject moduleBinding = ZDLUtil.createZDLConceptIn(instantiatedModule,
				IDL3PlusNames.MODULE_BINDING);

		ZDLUtil.setValue(moduleBinding, IDL3PlusNames.MODULE_BINDING,
				IDL3PlusNames.MODULE_BINDING__TEMPLATE, signature);

		for (ClassifierTemplateParameter parameter : (List<ClassifierTemplateParameter>) ZDLUtil
				.getValue((EObject) signature,
						IDL3PlusNames.TEMPLATE_SIGNATURE,
						IDL3PlusNames.TEMPLATE_SIGNATURE__TYPE_PARAMETER)) {
			if (instantiationMap.containsKey(parameter)) {
				EObject parameterBinding = ZDLUtil.createZDLConceptIn(
						moduleBinding, IDL3PlusNames.PARAMETER_BINDING);
				ZDLUtil.setValue(parameterBinding,
						IDL3PlusNames.PARAMETER_BINDING,
						IDL3PlusNames.PARAMETER_BINDING__TYPE_PARAMETER,
						parameter);
				ZDLUtil.setValue(parameterBinding,
						IDL3PlusNames.PARAMETER_BINDING,
						IDL3PlusNames.PARAMETER_BINDING__TYPE,
						instantiationMap.get(parameter));
			}

		}

		expandTemplate(instantiatedModule, moduleToInstantiate,
				instantiationMap, copier);
		return instantiatedModule;
	}

	/**
	 * Helper method that expands templateToInstantiate into
	 * instantiatedTemplate where expanding means to create all of the elements
	 * from the templateToInstantiate in the instantiatedTemplate.
	 * 
	 * This is because UML states that a module binding implies the expansion
	 * but the Eclipse UML implementation does not actually do the expansion.
	 * 
	 * WARNING : This currently does not merge into the existing template.
	 * 
	 * @param instantiatedTemplate
	 *            A IDL3PlusNames.MODULE_INSTANTIATION to expand.
	 * @param templateToInstantiate
	 *            A IDL3PlusNames.TEMPLATE_MODULE that is being expanded
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void expandTemplate(EObject instantiatedTemplate,
			EObject templateToInstantiate,
			Map<ClassifierTemplateParameter, EObject> instantiationMap,
			ZDLCopier copier) {
		if (ZDLUtil.isZDLConcept(instantiatedTemplate,
				IDL3PlusNames.MODULE_INSTANTIATION)
				&& ZDLUtil.isZDLConcept(templateToInstantiate,
						IDL3PlusNames.TEMPLATE_MODULE)) {
			org.eclipse.uml2.uml.Package instantiatedTemplatePkg = (org.eclipse.uml2.uml.Package) instantiatedTemplate;
			org.eclipse.uml2.uml.Package templateToInstantiatePkg = (org.eclipse.uml2.uml.Package) templateToInstantiate;

			copier.put(templateToInstantiatePkg, instantiatedTemplatePkg);

			PackageableElement[] packageableElements = (PackageableElement[]) templateToInstantiatePkg
					.getPackagedElements().toArray();
			for (PackageableElement packageableElement : packageableElements) {
				if (ZDLUtil.isZDLConcept(packageableElement,
						IDL3PlusNames.MODULE_INSTANTIATION)) {

					// This is an alias (TemplateModuleRef). We need to copy it
					// and substitute the parameters.

					// Retrieve the binding/signature information for the
					// Template Module instantiated by the alias.
					EObject binding = (EObject) ZDLUtil.getValue(
							packageableElement,
							IDL3PlusNames.MODULE_INSTANTIATION,
							IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);
					EObject signature = (EObject) ZDLUtil.getValue(binding,
							IDL3PlusNames.MODULE_BINDING,
							IDL3PlusNames.MODULE_BINDING__TEMPLATE);

					// Create a new map of parameters based on the original that
					// substitutes values of the
					// instantiated template module where appropriate.
					Map<ClassifierTemplateParameter, EObject> newMap = new HashMap<ClassifierTemplateParameter, EObject>();
					for (ClassifierTemplateParameter key : instantiationMap
							.keySet()) {
						newMap.put(key, instantiationMap.get(key));
					}
					for (Object o : (List) ZDLUtil.getValue(binding,
							IDL3PlusNames.MODULE_BINDING,
							IDL3PlusNames.MODULE_BINDING__PARAMETER_BINDING)) {
						EObject eobj = (EObject) o;
						Object type = ZDLUtil.getValue(eobj,
								IDL3PlusNames.PARAMETER_BINDING,
								IDL3PlusNames.PARAMETER_BINDING__TYPE);
						for (ClassifierTemplateParameter key : instantiationMap
								.keySet()) {
							if (key.getParameteredElement() == type) {
								Object value = newMap.get(key);
								newMap.remove(key);
								newMap.put(
										(ClassifierTemplateParameter) ((TemplateParameterSubstitution) eobj)
												.getFormal(), (EObject) value);
							}
						}
					}

					// Create a new template module instantiation. ZDLCopier is
					// unable to do this.
					EObject newModule = ZDLUtil.createZDLConceptIn(
							instantiatedTemplate,
							IDL3PlusNames.MODULE_INSTANTIATION);
					EObject moduleBinding = ZDLUtil.createZDLConceptIn(
							newModule, IDL3PlusNames.MODULE_BINDING);
					ZDLUtil.setValue(moduleBinding,
							IDL3PlusNames.MODULE_BINDING,
							IDL3PlusNames.MODULE_BINDING__TEMPLATE, signature);

					// Add parameters to the module binding pertaining to the
					// signature, pointing to parameters
					// based on the newMap created above.
					for (ClassifierTemplateParameter parameter : (List<ClassifierTemplateParameter>) ZDLUtil
							.getValue(
									signature,
									IDL3PlusNames.TEMPLATE_SIGNATURE,
									IDL3PlusNames.TEMPLATE_SIGNATURE__TYPE_PARAMETER)) {
						if (newMap.containsKey(parameter)) {
							EObject parameterBinding = ZDLUtil
									.createZDLConceptIn(moduleBinding,
											IDL3PlusNames.PARAMETER_BINDING);
							ZDLUtil.setValue(
									parameterBinding,
									IDL3PlusNames.PARAMETER_BINDING,
									IDL3PlusNames.PARAMETER_BINDING__TYPE_PARAMETER,
									parameter);
							ZDLUtil.setValue(parameterBinding,
									IDL3PlusNames.PARAMETER_BINDING,
									IDL3PlusNames.PARAMETER_BINDING__TYPE,
									newMap.get(parameter));
						}
					}

					// Set the name of the sub-instantiation and add it to the
					// template module.
					ZDLUtil.setValue(newModule, ZMLMMNames.NAMED_ELEMENT,
							ZMLMMNames.NAMED_ELEMENT__NAME,
							packageableElement.getName());
					((Package) instantiatedTemplate).getPackagedElements().add(
							(Package) newModule);

					// Copy the sub-contents of the alias using the ZDLCopier.
					PackageableElement[] sub_packageableElements = (PackageableElement[]) ((Package) packageableElement)
							.getPackagedElements().toArray();
					for (PackageableElement sub_packageableElement : sub_packageableElements) {
						copier.copy(sub_packageableElement, newModule,
								UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);
					}
				} else {
					copier.copy(packageableElement, instantiatedTemplatePkg,
							UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);
				}
			}

			copier.copyReferences();

		}
	}

	/**
	 * Within a template create a parameter with the given type constraint. The
	 * new parameter will be added to the template module and returned.
	 * 
	 * @param templateModule
	 *            The templateModule to add the parameter to.
	 * @param name
	 *            The name of the new parameter.
	 * @param parameterTypeConstraint
	 *            The type constraint for the new parameter. Valid values are
	 *            defined by IDL3PlusNames.TYPE_CONSTRAINT__*.
	 * @return The new parameter.
	 */
	public static EObject createTemplateParameter(EObject templateModule, String name,
			String parameterTypeConstraint) {
		EObject signature = (EObject) ZDLUtil.getValue(templateModule,
				IDL3PlusNames.TEMPLATE_MODULE,
				IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);

		if (signature == null
				|| !ZDLUtil.isZDLConcept(signature,
						IDL3PlusNames.TEMPLATE_SIGNATURE)) {
			signature = ZDLUtil.createZDLConceptIn(templateModule,
					IDL3PlusNames.TEMPLATE_SIGNATURE);
		}

		EObject parameter = ZDLUtil.createZDLConceptIn(signature,
				IDL3PlusNames.TYPE_PARAMETER);
		ZDLUtil.setValue(parameter, IDL3PlusNames.TYPE_PARAMETER,
				IDL3PlusNames.TYPE_PARAMETER__CONSTRAINT, ZDLUtil
						.getZDLEnumLiteral(templateModule,
								IDL3PlusNames.TYPE_CONSTRAINT,
								parameterTypeConstraint));

		ClassifierTemplateParameter ctp = (ClassifierTemplateParameter) parameter;
		EClass templateParameterEClass = getParameterType(templateModule,
				parameterTypeConstraint);

		if (templateParameterEClass != null) {
			org.eclipse.uml2.uml.Classifier templateParameterType = (org.eclipse.uml2.uml.Classifier) ctp
					.createOwnedParameteredElement(templateParameterEClass);
			ZDLUtil.addZDLConcept(templateParameterType,
					IDL3PlusNames.TEMPLATE_PARAMETER_TYPE);
			templateParameterType.setName(name);
			if (parameterTypeConstraint
					.equals(IDL3PlusNames.TYPE_CONSTRAINT__SEQUENCE)) {
				((DataType) templateParameterType).createOwnedAttribute(
						"members", null); //$NON-NLS-1$
			}
		}

		return parameter;
	}

	/**
	 * Helper method that will determine the UML type to create for a parameter.
	 * Note that if the type is not found (unrecognized) then uml::Class will be
	 * returned. Similarly, for a typename parameter uml::Class will be used as
	 * well.
	 * 
	 * @param context
	 *            An object that defines the context for resolving the type
	 * @param type
	 *            A string specifying the type of parameter valid values are
	 *            defined by IDL3PlusNames.TYPE_CONSTRAINT__*.
	 * @return The EClass of the type used to create the parameter.
	 */
	private static EClass getParameterType(EObject context, String type) {
		org.eclipse.uml2.uml.Class metaclass = null;
		org.eclipse.uml2.uml.Class typeClass = null;

		if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__INTERFACE)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXINTERFACE);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__ARRAY)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXARRAY);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__ENUM)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXENUM);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__SEQUENCE)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXSEQUENCE);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__STRUCT)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXSTRUCT);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__EVENTTYPE)) {
			typeClass = ZDLUtil.getZDLConcept(context, CCMNames.EVENT);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__UNION)) {
			typeClass = ZDLUtil.getZDLConcept(context,
					CXDomainNames.CXUNION);
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__VALUETYPE)) {
			typeClass = null;
		} else if (type.equals(IDL3PlusNames.TYPE_CONSTRAINT__TYPENAME)) {
			typeClass = null;
		}

		if (typeClass != null) {
			Profile profile = ZDLUtil.getZDLProfile(context, typeClass);
			metaclass = ZDLUtil.getBaseMetaclass(profile, typeClass);
		}

		if (metaclass == null) {
			return UMLPackage.Literals.CLASS;
		} else {
			return (EClass) UMLPackage.eINSTANCE.getEClassifier(metaclass
					.getName());
		}
	}

	public void repairTemplateModuleInstantiation(EObject templateInstantiation) {
		if (templateInstantiation == null) {
			throw new IllegalArgumentException(
					Messages.IDL3PlusUtil_Exception_NullModuleInstantiateToRepairParameter);
		}

		if (!ZDLUtil.isZDLConcept(templateInstantiation,
				IDL3PlusNames.MODULE_INSTANTIATION)) {
			throw new IllegalArgumentException(
					Messages.IDL3PlusUtil_Exception_InvalidModuleInstantiateToRepairParameter);
		}

		EObject moduleBinding = (EObject) ZDLUtil.getValue(
				templateInstantiation, IDL3PlusNames.MODULE_INSTANTIATION,
				IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);

		TemplateBinding templateBinding = (TemplateBinding) moduleBinding;

		EObject template = (EObject) ZDLUtil.getValue(moduleBinding,
				IDL3PlusNames.MODULE_BINDING,
				IDL3PlusNames.MODULE_BINDING__TEMPLATE);

		if (template != null) {
			EObject moduleToInstantiate = template.eContainer();
			Map<ClassifierTemplateParameter, EObject> params = new HashMap<ClassifierTemplateParameter, EObject>();

			for (TemplateParameterSubstitution tps : templateBinding
					.getParameterSubstitutions()) {
				ClassifierTemplateParameter ctp = (ClassifierTemplateParameter) tps
						.getFormal();
				EObject actual = null;
				actual = tps.getActual();
				params.put(ctp, actual);
			}
			EObject updatedInstantiation = this.instantiateTemplateModule(
					templateInstantiation.eContainer(), moduleToInstantiate,
					params);
			((NamedElement) updatedInstantiation)
					.setName(((NamedElement) templateInstantiation).getName());
			ClassModelMerger merger = new ClassModelMerger();
			merger.merge(updatedInstantiation, templateInstantiation);
			((NamedElement) updatedInstantiation).destroy();
			assert (updatedInstantiation != null);
		}
	}

	/**
	 * Given a DDS4CCM model, repair each template module instantiation of the
	 * model.
	 * 
	 * author: Hua Guo (hguo)
	 * 
	 * @param pkg
	 * 
	 */
	public void repairAllTemplateModuleInstantiations(Package pkg) {
		List<Element> instantiations = getConceptElements(pkg,
				IDL3PlusNames.MODULE_INSTANTIATION);
		for (Element instantiation : instantiations) {
			repairTemplateModuleInstantiation(instantiation);
		}
	}

	/**
	 * Retrieve a list of all the bindings of a type parameter with a specific
	 * type in the given DDS4CCM::Generics::ModuleInstantiation.
	 * 
	 * @param templateInstantiation
	 *            The ModuleInstantiation to get the bindings for.
	 * 
	 * @return A map of the parameter to the actual type.
	 */
	@SuppressWarnings("unchecked")
	protected Map<EObject, EObject> getTemplateParemeterBindings(
			EObject templateInstantiation) {
		Map<EObject, EObject> bindings = new HashMap<EObject, EObject>();

		Object moduleBinding = ZDLUtil.getValue(templateInstantiation,
				IDL3PlusNames.MODULE_INSTANTIATION,
				IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);

		Object parameterBindingObj = ZDLUtil.getValue((EObject) moduleBinding,
				IDL3PlusNames.MODULE_BINDING,
				IDL3PlusNames.MODULE_BINDING__PARAMETER_BINDING);

		if (parameterBindingObj instanceof List) {
			for (EObject parameterBinding : (List<EObject>) parameterBindingObj) {
				EObject formalParameter = (EObject) ZDLUtil.getValue(
						parameterBinding, IDL3PlusNames.PARAMETER_BINDING,
						IDL3PlusNames.PARAMETER_BINDING__TYPE_PARAMETER);
				EObject actualParameter = (EObject) ZDLUtil.getValue(
						parameterBinding, IDL3PlusNames.PARAMETER_BINDING,
						IDL3PlusNames.PARAMETER_BINDING__TYPE);
				bindings.put(formalParameter, actualParameter);
			}
		}

		return bindings;
	}

	/**
	 * Determine whether the given attribute of the given port type matches the pattern specified for the 
	 * port type in the filteredProperties extension.
	 * 
	 * @param grandParent - A {@link Property}.
	 * @param port - A {@link Port} {@link Property}.
	 * @return A boolean.
	 */
	public static boolean filter(Property grandParent, Property port) {
		if (grandParent != null && port != null && ZDLUtil.isZDLConcept(port, ZMLMMNames.PORT)) {
			Type portType = grandParent.getType();
			if (portType != null && ZDLUtil.isZDLConcept(portType, ZMLMMNames.PORT_TYPE)) {
				String portTypeQualifiedName = getInstantiatedPortTypeQualifiedName(portType);
				FilteredPropertyConfiguration filteredPropertyConfiguration = ConnectorRegistry.getInstance()
						.getFilteredPropertyConfiguration(portTypeQualifiedName);
				if (filteredPropertyConfiguration != null) {
					return filteredPropertyConfiguration.matchesAny(port.getName());
				}
			}
		}
		return false;
	}

	public static String getInstantiatedPortTypeQualifiedName(Type portType) {
		String portTypeQName = portType.getQualifiedName();
		EObject moduleInstantiation = getTemplateInstantiation(portType);
		if (moduleInstantiation != null) {
			String relativeQName = portTypeQName.replace(EMFCoreUtil.getQualifiedName(moduleInstantiation, true),
					UML2Util.EMPTY_STRING);
			EObject templateModule = getTypedTemplateModuleForInstantiation(moduleInstantiation);
			if (templateModule != null) {
				portTypeQName = EMFCoreUtil.getQualifiedName(templateModule, true) + relativeQName;
			}
		}
		return portTypeQName;
	}

	/**
	 * Private helper method that finds all ZDL elements under a given package
	 * matching a passed concept string.
	 * 
	 * @param pkg
	 *            The package to search.
	 * @param conceptName
	 *            The concept to match.
	 * @return
	 */
	public static List<Element> getConceptElements(Package pkg,
			String conceptName) {

		ArrayList<Element> retVal = new ArrayList<Element>();

		for (TreeIterator<?> iter = EcoreUtil.getAllContents(pkg
				.getPackagedElements()); iter.hasNext();) {
			Object next = iter.next();
			if (next instanceof Element) {
				if (ZDLUtil.isZDLConcept((Element) next, conceptName)) {
					retVal.add((Element) next);
				}
			}
		}
		return retVal;
	}

	/**
	 * Helper method to locate the template instantiation of the given element
	 * 
	 * @param element
	 *            Possible child element of a template instantiation
	 * @return Instantiated template module containing this element or null if
	 *         not found
	 */
	public static EObject getTemplateInstantiation(EObject element) {
		EObject ti = null;
		EObject next = element;

		while (next != null) {
			if (ZDLUtil.isZDLConcept(next, IDL3PlusNames.MODULE_INSTANTIATION)) {
				ti = next;
			}
			next = next.eContainer();
		}
		return ti;
	}

	/**
	 * Given a property this method will check if the property is part of a copy
	 * made in a template module instantiation. If it is, it will find the
	 * original definition of the property under a template module and return
	 * that.
	 * 
	 * @param property
	 * @param defaultValueBinding
	 * @return The original property if found, null otherwise.
	 */
	public static Property getOriginalPropertyForInstantiatedProperty(
			Property property, EObject defaultValueBinding) {

		EObject connectorDef = (EObject) ZDLUtil.getValue(defaultValueBinding,
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION);
		return getOriginalPropertyFromConnectorDef(property, connectorDef);
	}

	public static Property getOriginalPropertyFromConnectorDef(
			Property property, EObject connectorDef) {
		Property retVal = null;

		Package templateInstantiation = (Package) getTemplateInstantiation(property);

		if (templateInstantiation != null) {

			// property is from the template instantiation not from
			// the template module which means that the property is
			// copied to the instantiated module so we need to find
			// the original property from the template module.
			String pathToProperty = property.getQualifiedName().replace(
					templateInstantiation.getQualifiedName(),
					UML2Util.EMPTY_STRING);
			Package templateModule = getTemplateModule(connectorDef);
			if (templateModule != null) {
				Collection<NamedElement> results = UMLUtil.findNamedElements(
						templateModule.eResource(),
						templateModule.getQualifiedName() + pathToProperty);
				if (!results.isEmpty()) {
					retVal = (Property) results.iterator().next();
				}
			}
		}

		return retVal;
	}
	
	/**
	 * Helper method to get the typed template module of the given template
	 * instantiation
	 * 
	 * @param templateInstantiation
	 *            template instantiation
	 * @return Typed template module
	 */
	public static EObject getTypedTemplateModuleForInstantiation(
			EObject templateInstantiation) {

		Object moduleBinding = ZDLUtil.getValue(templateInstantiation,
				IDL3PlusNames.MODULE_INSTANTIATION,
				IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);

		if (moduleBinding != null
				&& ZDLUtil.isZDLConcept((EObject) moduleBinding,
						IDL3PlusNames.MODULE_BINDING)) {
			Object templateSignature = ZDLUtil.getValue(
					(EObject) moduleBinding, IDL3PlusNames.MODULE_BINDING,
					IDL3PlusNames.MODULE_BINDING__TEMPLATE);
			if (templateSignature != null
					&& ZDLUtil.isZDLConcept((EObject) templateSignature,
							IDL3PlusNames.TEMPLATE_SIGNATURE)) {
				return ((EObject) templateSignature).eContainer();
			}
		}
		return null;
	}

	/**
	 * Queries the default value of connector property
	 * 
	 * @param connector
	 *            Connector definition under the instantiated template module
	 * @param property
	 *            Property
	 * @return Default value or empty string if not found
	 */
	public static String getDefaultValueForConnector(
			Property connectorDeploymentPart, EObject property,
			List<EObject> propertOwners) {
		String returnValue = null;
		Type type = connectorDeploymentPart.getType();
		if (ZDLUtil.isZDLConcept(type, IDL3PlusNames.CONNECTOR_DEF)) {
			Component connector = (Component) type;
			Property instanceProperty = connector.getOwnedAttribute(
					CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME, null);
			if (connector != null && instanceProperty != null) {
				// try to get default value from the connector definition
				if (instanceProperty.getDefaultValue() != null
						&& instanceProperty.getDefaultValue() instanceof InstanceValue) {
					returnValue = CCMUtil
							.getInstanceValueForEntry(
									((InstanceValue) instanceProperty
											.getDefaultValue()).getInstance(),
									property, propertOwners);
				}
			}
			if (connector != null && UML2Util.isEmpty(returnValue)) {
				// try to get the default value from the connector default value
				// binding
				EObject defaultValueBinding = findConnectorDefaultValueBinding(
						connectorDeploymentPart, connector);
				if (defaultValueBinding != null) {
					InstanceSpecification instance = (InstanceSpecification) ZDLUtil
							.getValue(
									defaultValueBinding,
									IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
									IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE);
					if (instance != null) {

						EObject originalProperty = property;
						if (property instanceof Property) {
							originalProperty = getOriginalPropertyForInstantiatedProperty(
									(Property) property, defaultValueBinding);
							if (originalProperty == null) {
								originalProperty = property;
							}
						}

						List<EObject> originalPropertyOwners = new ArrayList<EObject>();
						for (EObject eo : propertOwners) {
							Property origPropertyOwner = null;
							if (eo instanceof Property) {
								origPropertyOwner = getOriginalPropertyForInstantiatedProperty(
										(Property) eo, defaultValueBinding);
							}
							if (origPropertyOwner != null) {
								originalPropertyOwners.add(origPropertyOwner);
							} else {
								originalPropertyOwners.add(eo);
							}
						}

						returnValue = CCMUtil.getInstanceValueForEntry(
								instance, originalProperty,
								originalPropertyOwners);
					}
				}
			}
		}
		return returnValue == null ? UML2Util.EMPTY_STRING : returnValue;
	}
	
	public static String getDefaultValueforPerPort(
			Property perPortDeploymentPart, EObject property,
			List<EObject> propertOwners) {
		String returnValue = UML2Util.EMPTY_STRING;
		Port port = (Port) ZDLUtil.getValue(perPortDeploymentPart,
				ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		EObject parentPart = ZDeploymentUtil.getParentPart(perPortDeploymentPart);
		Property part = (Property) ZDLUtil.getValue(
				parentPart , ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		Property dataSpace = IDL3PlusUtil.getDataSpaceFromPerPort(port, part);
		EObject dataSpaceType = dataSpace.getType();
		Property deploymentPartDataSpace = null;
		List<Property> deploymentParts = ZDeploymentUtil
				.getDeploymentPartForModelElement(
						(Component) perPortDeploymentPart.eContainer(), dataSpace);
		for (Property deploymentPart : deploymentParts) {
			if (ZDeploymentUtil.getParentPart(deploymentPart) == ZDeploymentUtil
					.getParentPart((Property) parentPart)) {
				deploymentPartDataSpace = deploymentPart;
				break;
			}
		}
		if (deploymentPartDataSpace != null
				&& dataSpaceType != null
				&& ZDLUtil.isZDLConcept(dataSpaceType,
						IDL3PlusNames.CONNECTOR_DEF)) {
			InstanceSpecification instance = null;
			if (deploymentPartDataSpace.getDefaultValue() instanceof InstanceValue) {
				instance = ((InstanceValue) deploymentPartDataSpace
						.getDefaultValue()).getInstance();
			}
			if (instance != null) {
				EObject originalProperty = property;
				if (property instanceof Property) {
					originalProperty = getOriginalPropertyFromConnectorDef(
							(Property)property, dataSpace.getType());
					if (originalProperty == null) {
						originalProperty = property;
					}
				}

				List<EObject> originalPropertyOwners = new ArrayList<EObject>();
				for (EObject eo : propertOwners) {
					Property origPropertyOwner = null;
					if (eo instanceof Property) {
						origPropertyOwner = getOriginalPropertyFromConnectorDef(
								(Property) eo, dataSpace.getType());
					}
					if (origPropertyOwner != null) {
						originalPropertyOwners.add(origPropertyOwner);
					} else {
						originalPropertyOwners.add(eo);
					}
				}

				returnValue = CCMUtil.getInstanceValueForEntry(instance,
						originalProperty, originalPropertyOwners);
				if (!UML2Util.isEmpty(returnValue)) {
					return returnValue;
				}
			}
			returnValue = getDefaultValueForConnector(deploymentPartDataSpace,
					property, propertOwners);
		}
		return returnValue == null ? UML2Util.EMPTY_STRING : returnValue;
	}
	
	/**
	 * Find connector default value binding given the connector from the
	 * instantiated template module
	 * 
	 * @param connector
	 *            connector object under the instantiated template module
	 * @return ConnectorDefaultValueBinding or null if not found
	 */
	public static EObject findConnectorDefaultValueBinding(
			Property connectorDeploymentPart, Component connector) {

		EObject modelObject = ZDeploymentUtil
				.getModelElement(connectorDeploymentPart);
		if (!ZDLUtil.isZDLConcept(modelObject, IDL3PlusNames.DATA_SPACE)) {
			return null;
		}

		Component domain = null;
		for (Property part : ZDeploymentUtil
				.getDeploymentParts((Component) connectorDeploymentPart
						.eContainer())) {

			if (!ZDLUtil.isZDLConcept(part,
					ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
				continue;
			}
			Property targetPart = ZDeploymentUtil.getDeploymentTargetPart(part);
			if (targetPart == null) {
				continue;
			}
			Property rootPart = getRootDomainDeploymentPart(targetPart);
			NamedElement object = ZDeploymentUtil.getModelElement(rootPart);
			if (object == null
					|| !ZDLUtil.isZDLConcept(object, CCMNames.DOMAIN)) {
				continue;
			}
			domain = (Component) object;
			break;
		}
		if (domain == null) {
			return null;
		}

		EObject moduleInstatiation = getTemplateInstantiation(connector);
		if (moduleInstatiation == null
				|| !ZDLUtil.isZDLConcept(moduleInstatiation,
						IDL3PlusNames.MODULE_INSTANTIATION)) {
			return null;
		}
		TemplateBinding binding = (TemplateBinding) ZDLUtil.getValue(
				moduleInstatiation, IDL3PlusNames.MODULE_INSTANTIATION,
				IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);

		if (binding == null) {
			return null;
		}
		if (binding.getSignature() != null) {
			EObject templateModule = binding.getSignature().eContainer();
			if (templateModule == null
					|| !ZDLUtil.isZDLConcept(templateModule,
							IDL3PlusNames.TEMPLATE_MODULE)) {
				return null;
			}
			TreeIterator<Object> itor = EcoreUtil.getAllContents(
					templateModule, false);
			while (itor.hasNext()) {
				Object obj = itor.next();
				if (!(obj instanceof Package) && !(obj instanceof Component)) {
					itor.prune();
					continue;
				}
				EObject eo = (EObject) obj;
				if (ZDLUtil.isZDLConcept(eo, IDL3PlusNames.CONNECTOR_DEF)) {
					if (((Component) eo).getName().equals(connector.getName())) {
						Iterator<EObject> itor2 = domain.eContents().iterator();

						while (itor2.hasNext()) {
							EObject defaultValueBinding = itor2.next();
							if (!ZDLUtil
									.isZDLConcept(
											defaultValueBinding,
											IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
								continue;
							}
							Object typedDef = ZDLUtil
									.getValue(
											defaultValueBinding,
											IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
											IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION);
							if (eo == typedDef) {
								return defaultValueBinding;
							}
						}
						break;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns domain deployment part in which given deployment part is deployed
	 * under
	 * 
	 * @param part
	 * @return
	 */
	public static Property getRootDomainDeploymentPart(Property part) {

		Property targetPart = ZDeploymentUtil.getDeploymentTargetPart(part);
		if (targetPart == null) {
			Property parent = ZDeploymentUtil.getParentPart(part);
			if (parent == null) {
				return part;
			}
			return getRootDomainDeploymentPart(ZDeploymentUtil
					.getParentPart(part));
		}
		return getRootDomainDeploymentPart(targetPart);
	}
	
	public static Property getDataSpaceFromPerPort(Port port, Property part) {

		for (EObject end : port.getEnds()) {
			if (ZDLUtil.isZDLConcept(end, ZMLMMNames.CONNECTOR_END)) {
				EObject endPart = ZDLUtil.getEValue(end,
						ZMLMMNames.CONNECTOR_END,
						ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
				if (endPart == part) {
					EObject connector = end.eContainer();
					if (ZDLUtil.isZDLConcept(connector, CCMNames.CCMCONNECTOR)) {
						@SuppressWarnings("unchecked")
						List<EObject> ends = (List<EObject>) ZDLUtil.getValue(
								connector, ZMLMMNames.ASSEMBLY_CONNECTOR,
								ZMLMMNames.ASSEMBLY_CONNECTOR__END);
						for (EObject connEnd : ends) {
							EObject connEndPart = ZDLUtil.getEValue(connEnd,
									ZMLMMNames.CONNECTOR_END,
									ZMLMMNames.CONNECTOR_END__PART);
							if (connEndPart != null
									&& ZDLUtil.isZDLConcept(connEndPart,
											IDL3PlusNames.DATA_SPACE)) {
								return (Property) connEndPart;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static List<Property> buildDeploymentPartFromModelElement(
			NamedElement partToCreate, Component deployment,
			NamedElement modelParent, NamedElement selectedStructuralRealization) {

		final List<Property> parentParts = new ArrayList<Property>();
		if (modelParent != null) {
			if (ZDLUtil.isZDLConcept(modelParent, ZMLMMNames.COMPONENT_DEPLOYMENT_PART)){
				// we know exactly which deployment property is the parent
				parentParts.add((Property) modelParent);
			} else {
				// If the modelParent passed in is not null, there must be a part in
				// this deployment that can serve as the logical parent in order to
				// add this part.
				// Note that there may be more than one of these, as a component may be used
				// multiple times in a deployment
				for (Property part : ZDeploymentUtil.getDeploymentParts(deployment)) {
					NamedElement possibleModelElement = ZDeploymentUtil
							.getModelComponent(part);
					if (possibleModelElement == modelParent) {
						parentParts.add(part);
					} else if (possibleModelElement != null
							&& ZDLUtil.isZDLConcept(possibleModelElement,
									ZMLMMNames.COMPONENT_INTERFACE)) {
						Component candidateComponentRealization = null;
						ArrayList<Component> srList = ZDeploymentUtil
								.getStructuralRealizations((Component) possibleModelElement);
						if (srList.size() > 0) {
							candidateComponentRealization = srList.get(0);
						}
	
						if (candidateComponentRealization == modelParent) {
							parentParts.add(part);
	
						}
					}
				}
			}
			if (parentParts.isEmpty()) {
				// There is no valid place to put the deployment part.
				return Collections.emptyList();
			}
		}
		final List<Property> newParts = new ArrayList<Property>(parentParts.size());
		for (Property property : parentParts) {
			final Property newPart = createDeploymentPart(deployment, partToCreate,
					property, null);
			newParts.add(newPart);
		}
		// ValidationUtil.getLinkContext(LinkConstraintContext.DEPLOYMENT_PART,
		// partToCreate, parentPart));

		return newParts;
	}

	public static Property createDeploymentPart(Component deployment,
			NamedElement modelElement, Property parentPart, String conceptString) {

		Property deploymentPart = null;
		String partName = modelElement.getName();
		int nameInteger = 2;
		while (deployment.getMember(partName) != null) {
			partName = modelElement.getName()
					+ "_" + Integer.toString(nameInteger++); //$NON-NLS-1$
		}

		if (modelElement instanceof Port
				&& ZDLUtil.isZDLDomain(modelElement, "CCM")) { //$NON-NLS-1$
			deploymentPart = createPerPortDeploymentPart((Port) modelElement,
					partName, deployment);

			if (parentPart != null) {
				ZDeploymentUtil.setParentPart(deploymentPart, parentPart);
			}

		}
		return deploymentPart;
	}

	public static Property createPerPortDeploymentPart(Port port, String name,
			Component deployment) {
		Property deploymentPart = deployment.createOwnedAttribute(name,
				port.getType());
		ZDLUtil.addZDLConcept(deploymentPart,
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART);
		ZDLUtil.setValue(deploymentPart, ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT, port);
		return deploymentPart;
	}

}
