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

package com.zeligsoft.domain.ngc.ccm.idltouml.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.domain.ngc.ccm.idltouml.l10n.Messages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("nls")
public class CCMPSMUtils {

	/**
	 * 
	 */
	private CCMPSMUtils() {
		// nothting to do
	}
	
	public static void addDetail(EAnnotation annotation, String key, String value) {
		annotation.getDetails().put(key, value);
	}
	
	public static String getDetail(EAnnotation annotation, String key) {
		return annotation.getDetails().get(key);
	}
	
	public static String getXMIId(org.eclipse.uml2.uml.NamedElement element) {
		return EcoreUtil.getURI(element).fragment();
	}
	
	public static void makePublic(org.eclipse.uml2.uml.NamedElement element) {
		element.setVisibility(VisibilityKind.PUBLIC_LITERAL);
	}
	
	public static void makePrivate(org.eclipse.uml2.uml.NamedElement element) {
		element.setVisibility(VisibilityKind.PRIVATE_LITERAL);
	}
	
	public static void makeProtected(org.eclipse.uml2.uml.NamedElement element) {
		element.setVisibility(VisibilityKind.PROTECTED_LITERAL);
	}

	public static void makePackage(org.eclipse.uml2.uml.NamedElement element) {
		element.setVisibility(VisibilityKind.PACKAGE_LITERAL);
	}
	
	public static AggregationKind aggregation_kind_COMPOSITE() {
		return AggregationKind.COMPOSITE_LITERAL;
	}
	
	public static AggregationKind aggregation_kind_NONE() {
		return AggregationKind.NONE_LITERAL;
	}
	
	public static AggregationKind aggregation_kind_SHARED() {
		return AggregationKind.SHARED_LITERAL;
	}
	
	public static ParameterDirectionKind parameter_direction_kind_IN() {
		return ParameterDirectionKind.IN_LITERAL;
	}
	
	public static ParameterDirectionKind parameter_direction_kind_OUT() {
		return ParameterDirectionKind.OUT_LITERAL;
	}
	
	public static ParameterDirectionKind parameter_direction_kind_INOUT() {
		return ParameterDirectionKind.INOUT_LITERAL;
	}
	
	public static ParameterDirectionKind parameter_direction_kind_RETURN() {
		return ParameterDirectionKind.RETURN_LITERAL;
	}
	
	public static VisibilityKind visibility_kind_PUBLIC() {
		return VisibilityKind.PUBLIC_LITERAL;
	}
	
	public static VisibilityKind visibility_kind_PRIVATE() {
		return VisibilityKind.PRIVATE_LITERAL;
	}
	
	public static VisibilityKind visibility_kind_PROTECTED() {
		return VisibilityKind.PROTECTED_LITERAL;
	}
	
	public static VisibilityKind visibility_kind_PACKAGE() {
		return VisibilityKind.PACKAGE_LITERAL;
	}
	
	/**
	 * Initialize a model library (generated from the given domain specialization)
	 * for use in RSM.
	 * 
	 * @param newModel the model library to initialize
	 * @param sourceModel the UML profile that we are generating for the domain
	 */
	public static void initializeNewModel(Package newModel, Package sourceModel) {
		ResourceSet rset = null;

		Resource contextResource = sourceModel.eResource();
		if (contextResource != null) {
			rset = contextResource.getResourceSet();
		}

		if (rset == null) {
			throw new IllegalStateException(
					Messages.CCMPSMUtils_Error_SourcePartOfResource);
		}

		Profile std = loadPackage(rset, UMLResource.STANDARD_PROFILE_URI);
		if (std == null) {
			throw new IllegalStateException(
				Messages.CCMPSMUtils_Error_StandardProfile);
		}

		newModel.applyProfile(std);
	}
	
	/**
	 * Loads a package in the current resource set.
	 * 
	 * @param rset
	 *            the contextual resource set
	 * @param uri
	 *            the package's location URI
	 * @return the package at the specified location URI
	 */
	public static <T extends Package> T loadPackage(ResourceSet rset,
			String uri) {
		return (T) rset.getResource(URI.createURI(uri), true).getContents().get(0);
	}
	
	public static void applyTraceStereotype(org.eclipse.uml2.uml.Abstraction obj) {
		Stereotype traceStereotype = obj.getApplicableStereotype("Standard::Trace");
		
		if(traceStereotype != null) {
			obj.applyStereotype(traceStereotype);
		}
	}
}
