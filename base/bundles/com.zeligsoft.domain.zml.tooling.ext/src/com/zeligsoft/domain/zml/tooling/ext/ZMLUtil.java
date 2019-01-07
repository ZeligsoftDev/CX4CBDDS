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

package com.zeligsoft.domain.zml.tooling.ext;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author smcfee
 * 
 */
public class ZMLUtil {

	private static String QUALIFIED_SEPARATOR = NamedElement.SEPARATOR;

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	private static String PROFILE_NAME = "ZML";//$NON-NLS-1$

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String COMPONENTINTERFACE_STEREOTYPE_NAME = "ComponentInterface";//$NON-NLS-1$

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String QUALIFIED_COMPONENTINTERFACE_STEREOTYPE_NAME = PROFILE_NAME
		+ QUALIFIED_SEPARATOR + COMPONENTINTERFACE_STEREOTYPE_NAME;

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String STRUCTURALREALIZATION_STEREOTYPE_NAME = "StructuralRealization";//$NON-NLS-1$


	/**
	 * @deprecated
	 */
	@Deprecated
	public static final String IMPLEMENTATION_STEREOTYPE_NAME = "Implementation"; //$NON-NLS-1$
	

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String WORKERFUNCTION_STEREOTYPE_NAME = "WorkerFunction";//$NON-NLS-1$

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String QUALIFIED_STRUCTURALREALIZATION_STEREOTYPE_NAME = PROFILE_NAME
		+ QUALIFIED_SEPARATOR + STRUCTURALREALIZATION_STEREOTYPE_NAME;

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */

	@Deprecated
	public static final String QUALIFIED_WORKERFUNCTION_STEREOTYPE_NAME = PROFILE_NAME
		+ QUALIFIED_SEPARATOR + WORKERFUNCTION_STEREOTYPE_NAME;

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String WORKERFUNCTION_BODY_NAME = "body";//$NON-NLS-1$

	/**
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String COMPONENTINTERFACE__REALIZATION = "realization";//$NON-NLS-1$

	private static final URI BASE_PROFILE_URI = URI
		.createURI("pathmap://ZML_PROFILES/ZML.profile.uml"); //$NON-NLS-1$

	/**
	 * The qualified name of the ZML domain model.
	 * 
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String DOMAIN_MODEL = "ZMLMM"; //$NON-NLS-1$

	/** 
	 * The qualified name of the ZML domain model's "ZML_Components" block. 
	 * 
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String COMPONENT_BLOCK = DOMAIN_MODEL
		+ QUALIFIED_SEPARATOR + "ZML_Component"; //$NON-NLS-1$

	/**
	 * The qualified name of the ZML "ComponentInterface" concept.
	 * 
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String COMPONENT_INTERFACE_CONCEPT = COMPONENT_BLOCK
		+ QUALIFIED_SEPARATOR + "ComponentInterface"; //$NON-NLS-1$

	/**
	 * The qualified name of the ZML "StructuralRealization" concept.
	 * 
	 * @deprecated Use com.zeligsoft.domain.zml.tooling.ext.ZMLMMNames
	 */
	@Deprecated
	public static final String STRUCTURAL_REALIZATION_CONCEPT = COMPONENT_BLOCK
		+ QUALIFIED_SEPARATOR + "StructuralRealization"; //$NON-NLS-1$

	private static Profile profile = null;

	private ZMLUtil() {
		super();
	}

	/**
	 * Returns the ZML profile model element.
	 * 
	 * @return
	 * @deprecated Assess a particular domain instead.
	 */
	@Deprecated
	public static Profile getProfile() {
		if (profile == null) {
			Resource resource = UMLModeler.getEditingDomain().getResourceSet()
				.getResource(BASE_PROFILE_URI, true);
			profile = (Profile) resource.getContents().get(0);
		}
		return profile;
	}

	/**
	 * Returns the {@link Stereotype} corresponding to the simple name in the
	 * ZML {@link Profile}.
	 * 
	 * @param name
	 *            the simple stereotype name
	 * @return the {@link Stereotype} or null if no such named
	 *         {@link Stereotype} exists in the ZML {@link Profile}.
	 * @deprecated Please use com.zeligsoft.base.zdl.util.ZDLUtil
	 */
	@Deprecated
	public static Stereotype getZMLStereotype(String name) {
		return getProfile().getOwnedStereotype(name);
	}

	/**
	 * Tests if the given {@link EObject} is a ZML model element by inspecting
	 * for the existence of ZML {@link Profile} stereotype application with the
	 * given stereotype name. This method will try Adapt the {@link EObject} to
	 * an {@link Element}.
	 * 
	 * @param eObject
	 *            the EObject to test
	 * @param stereotypeName
	 * @return true if a stereotype application with the given stereotype name
	 *         is found, false otherwise
	 * @deprecated Please use com.zeligsoft.base.zdl.util.ZDLUtil
	 */
	@Deprecated
	public static boolean isZMLElement(EObject eObject, String stereotypeName) {
		boolean retVal = false;

		Stereotype stereotype = getZMLStereotype(stereotypeName);
		if (stereotype != null) {
			if (eObject instanceof Element) {
				retVal = ((Element) eObject).isStereotypeApplied(stereotype);
			}
			if (eObject instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) eObject)
					.getAdapter(Element.class);
				retVal = element != null
					&& element.isStereotypeApplied(stereotype);
			}
		}
		return retVal;
	}

	/**
	 * Obtains the structural realizations of the specified component interface,
	 * that are currently loaded in the resource set.
	 * 
	 * @param component
	 *            a component interface
	 * @return the available structural realizations, or an empty list if the
	 *         specified interface is not an instance of the
	 *         <tt>ComponentInterface</tt> concept
	 */
	public static EList<Component> getStructuralRealizations(Component component) {
		EList<Component> result;

		if (!ZDLUtil.isZDLConcept(component, ZMLMMNames.COMPONENT_INTERFACE)) {
			result = ECollections.emptyEList();
		} else {
			result = new UniqueEList.FastCompare<Component>();

			for (Relationship next : component
				.getRelationships(UMLPackage.Literals.GENERALIZATION)) {
				Classifier specific = ((Generalization) next).getSpecific();

				if ((specific instanceof Component)
					&& ZDLUtil.isZDLConcept(specific,
						ZMLMMNames.STRUCTURAL_REALIZATION)) {
					result.add((Component) specific);
				}
			}

			result = new BasicEList.UnmodifiableEList<Component>(result.size(),
				result.toArray());
		}

		return result;
	}

}
