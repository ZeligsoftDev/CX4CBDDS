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
package com.zeligsoft.domain.ngc.ccm.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.generator.utils.IDL3PlusXtendUtils;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * @author Toby McClean (tmcclean)
 * 
 */
public class CCMXtendUtils {

	private CCMXtendUtils() {
		// no state
	}

	public static boolean requiresInclude(org.eclipse.uml2.uml.Element element,
			org.eclipse.uml2.uml.Element referencedElement) {
		org.eclipse.uml2.uml.Package elementPkg = getDefnFilePkg(element);
		org.eclipse.uml2.uml.Package referencedElementPkg = getDefnFilePkg(referencedElement);

		return !elementPkg.equals(referencedElementPkg);
	}

	private static org.eclipse.uml2.uml.Package getDefnFilePkg(
			org.eclipse.uml2.uml.Element element) {
		org.eclipse.uml2.uml.Package defnPkg = null;
		EObject curObj = element;

		while (curObj != null
				&& (!(curObj instanceof org.eclipse.uml2.uml.Package) || ZDLUtil
						.isZDLConcept(curObj, CXDomainNames.CXMODULE))) {
			curObj = curObj.eContainer();
		}

		if (curObj instanceof org.eclipse.uml2.uml.Package
				&& !(ZDLUtil.isZDLConcept(curObj, CXDomainNames.CXMODULE))) {
			defnPkg = (org.eclipse.uml2.uml.Package) curObj;
		}

		return defnPkg;
	}

	public static List<PackageableElement> packagedElement(
			org.eclipse.uml2.uml.NamedElement element) {
		if (element instanceof org.eclipse.uml2.uml.Package) {
			return ((org.eclipse.uml2.uml.Package) element)
					.getPackagedElements();
		}

		return Collections.emptyList();
	}

	public static void updateTypeName(
			com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl self) {
		updateEventScopedName(self.getType());
	}

	public static void updateTypeName(
			com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl self) {
		updateEventScopedName(self.getType());
	}

	private static void updateEventScopedName(
			com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName sn) {
		if (!sn.getName().isEmpty()) {
			sn.getName().set(sn.getName().size() - 1,
					sn.getName().get(sn.getName().size() - 1) + "_event");
		}
	}

	/**
	 * @deprecated Use {@link IDL3PlusXtendUtils#getComponentsHomes(Component)}
	 *             instead
	 */
	public static List<org.eclipse.uml2.uml.Class> getComponentsHomes(
			Component comp) {
		return IDL3PlusXtendUtils.getComponentsHomes(comp);
	}
	
	public static List<Component> getMonolithicImplementations(Component comp) {
		List<Component> retVal = new ArrayList<Component>();
		
		for( Setting s : UML2Util.getInverseReferences(comp)) {
			if( s.getEObject() instanceof Generalization ) {
				Generalization g = (Generalization)s.getEObject();
				if( ZDLUtil.isZDLConcept(g.getOwner(), CCMNames.MONOLITHIC_IMPLEMENTATION)) {
					retVal.add((Component) g.getOwner());
				}
			}
		}
		
		return retVal;
	}

	/**
	 * @deprecated Use
	 *             {@link IDL3PlusXtendUtils#getTypeParameterName(ClassifierTemplateParameter)}
	 *             instead
	 */
	public static String getTypeParameterName(ClassifierTemplateParameter param) {
		return IDL3PlusXtendUtils.getTypeParameterName(param);
	}

	/**
	 * @deprecated Use
	 *             {@link IDL3PlusXtendUtils#getPortTypeProvides(org.eclipse.uml2.uml.Class)}
	 *             instead
	 */
	public static List<Dependency> getPortTypeProvides(
			org.eclipse.uml2.uml.Class port) {
		return IDL3PlusXtendUtils.getPortTypeProvides(port);
	}

	/**
	 * @deprecated Use
	 *             {@link IDL3PlusXtendUtils#getPortTypeUses(org.eclipse.uml2.uml.Class)}
	 *             instead
	 */
	public static List<Dependency> getPortTypeUses(
			org.eclipse.uml2.uml.Class port) {
		return IDL3PlusXtendUtils.getPortTypeUses(port);
	}

	/**
	 * Converts a qualified name as modeled in CX to an IDL scoped name that
	 * would be accurate in the repository. This is done by skipping the package
	 * and IDLFile parts of the qualified name.
	 * 
	 * @param qualifiedName
	 * @return
	 * @deprecated Use
	 *             {@link IDL3PlusXtendUtils#scopedNameFromNamedElementForIDL3(NamedElement)}
	 *             instead
	 */
	@SuppressWarnings("nls")
	public static String scopedNameFromNamedElementForIDL3(NamedElement element) {
		return IDL3PlusXtendUtils.scopedNameFromNamedElementForIDL3(element);
	}

	@SuppressWarnings("unchecked")
	public static NamedElement getCORBASequence(Package self,
			NamedElement modelInstantiation) {
		List<Element> sequences = IDL3PlusUtil.getConceptElements(
				self.getModel(), CXDomainNames.CXSEQUENCE);

		EObject moduleBinding = (EObject) ZDLUtil.getValue(modelInstantiation,
				IDL3PlusNames.MODULE_INSTANTIATION,
				IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);
		for (Element parameterBinding : (List<Element>) ZDLUtil.getValue(
				moduleBinding, IDL3PlusNames.MODULE_BINDING,
				IDL3PlusNames.MODULE_BINDING__PARAMETER_BINDING)) {
			for (Element sequence : sequences) {
				Property p = ((DataType) sequence).getOwnedAttributes().get(0);
				if (ZDLUtil.getValue(parameterBinding,
						IDL3PlusNames.PARAMETER_BINDING,
						IDL3PlusNames.PARAMETER_BINDING__TYPE) == p.getType()) {
					return (NamedElement) sequence;
				}
			}

		}
		return null;

	}

	/**
	 * @deprecated Use
	 *             {@link IDL3PlusXtendUtils#isContainedInModuleInstParam(NamedElement)}
	 *             instead
	 */
	public static boolean isContainedInModuleInstParam(
			NamedElement corbaSequence) {
		return IDL3PlusXtendUtils.isContainedInModuleInstParam(corbaSequence);
	}

	/**
	 * Return the list of included file names to be generated for a CX
	 * element.
	 * 
	 * @param corbaElementName
	 * @return A list of file names to include.
	 * @deprecated Use {@link IDL3PlusXtendUtils#getIncludeFileName(String)}
	 *             instead
	 */
	public static List<String> getIncludeFileName(String corbaElementName) {
		return IDL3PlusXtendUtils.getIncludeFileName(corbaElementName);
	}
	
	public static EObject copy(EObject original, EObject context) {
		return EcoreUtil.copy(original);
	}
}
