/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.adapter.rsm.extensions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;

/**
 * A set of extensions to be used in xTend when working with RSM.
 * 
 * Any of these extensions may be dependent on RSM API's
 * 
 * @author tmcclean
 * 
 */
public class RSMProfilingExtensions {

	/**
	 * Initializes a UML profile for use in RSM. This performs the following:
	 * <ul>
	 * <li>apply the <tt>ProfileBase</tt> profile</li>
	 * <li>reference the UML meta-model</li>
	 * <li>import the UML Primitive Types model library</li>
	 * </ul>
	 * 
	 * @param profile
	 *            the profile to initialize
	 * @param specialization
	 *            the domain specialization providing a resource-set context in
	 *            which to load/find the UML meta-model
	 */
	public static void initializeForRSM(Profile profile,
			GenDomainSpecialization specialization) {
		ResourceSet rset = null;

		Resource contextResource = specialization.eResource();
		if (contextResource != null) {
			rset = contextResource.getResourceSet();
		}

		if (rset == null) {
			rset = TransactionUtil.getEditingDomain(specialization).getResourceSet();
		}

		Package umlMetamodel = loadPackage(rset, UMLResource.UML_METAMODEL_URI);
		if (umlMetamodel == null) {
			throw new IllegalStateException(
				ZDLGen2UMLProfileMessages.RSMProfilingExtensions_umlMetamodel);
		}

		profile.createMetamodelReference(umlMetamodel);

		Package umlPrimitiveTypes = loadPackage(rset,
			UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI);
		if (umlPrimitiveTypes == null) {
			throw new IllegalStateException(
				ZDLGen2UMLProfileMessages.RSMProfilingExtensions_umlPrimitiveTypes);
		}

		profile.createPackageImport(umlPrimitiveTypes);

		GenDomainModel genModel = getGenDomainModel(specialization);
		if ((genModel != null) && !UML2Util.isEmpty(genModel.getNsURI())) {
			applyEPackageStereotype(profile, rset, genModel.getNsURI(),
				specialization);
		}
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
	private static GenDomainModel getGenDomainModel(
			GenDomainSpecialization specialization) {
		GenDomainModel result = null;
		GenDomainPackage pkg = specialization.getPackage();

		while (pkg != null) {
			if (pkg instanceof GenDomainModel) {
				result = (GenDomainModel) pkg;
				break;
			}

			pkg = pkg.getPackage();
		}

		return result;
	}

	/**
	 * Applies the {@literal <<ePackage>>} stereotype to the specified profile
	 * and populates the tag attributes according to the given base NS URI of
	 * the domain model and the details of the domain specialization.
	 * 
	 * @param profile the profile to tag
	 * @param rset the resource set context for loading the Ecore profile
	 * @param baseNsURI the base namespace URI from the domain model
	 * @param specialization the domain specialization definition
	 */
	private static void applyEPackageStereotype(Profile profile,
			ResourceSet rset, String baseNsURI,
			GenDomainSpecialization specialization) {

		Profile ecore = loadPackage(rset, UMLResource.ECORE_PROFILE_URI);
		if (ecore == null) {
			throw new IllegalStateException(
				ZDLGen2UMLProfileMessages.RSMProfilingExtensions_ecoreProfile);
		}

		String name = specialization.getName();

		profile.applyProfile(ecore);

		Stereotype epkgStereotype = ecore.getOwnedStereotype(UMLUtil.STEREOTYPE__E_PACKAGE);
		profile.applyStereotype(epkgStereotype);
		profile.setValue(epkgStereotype, UMLUtil.TAG_DEFINITION__PACKAGE_NAME, name.toLowerCase());
		profile.setValue(epkgStereotype, UMLUtil.TAG_DEFINITION__NS_PREFIX, name.toLowerCase());
		profile.setValue(epkgStereotype, UMLUtil.TAG_DEFINITION__PREFIX, name);

		URI nsURI = URI.createURI(baseNsURI);
		if (!name.equals(nsURI.lastSegment())) {
			nsURI = nsURI.appendSegment(name);
		}
		
		String versionSegment = specialization.getVersion();
		if(versionSegment != null && !versionSegment.isEmpty()) {
			nsURI = nsURI.appendSegment(specialization.getVersion());
		}

		profile.setValue(epkgStereotype, UMLUtil.TAG_DEFINITION__NS_URI, nsURI.toString());
	}

	/**
	 * Obtains the ZDL namespace URI.
	 * 
	 * @return the ZDL namespace URI used for annotation sources
	 */
	public static String getZDLNamespace() {
		return ZDLUtil.ZDL_NAMESPACE_URI;
	}
	
	/**
	 * Creates the enumeration literal specified by the given genEnumLiteral in the
	 * target UML enumeration.  This works around a bug in oAW owing to which which
	 * it is impossible to create EnumerationLiteral instances in a workflow that
	 * declares a profile "meta-model."  (the profile meta-model implementation NPEs
	 * on the qualified name of the enumeration that doesn't yet own he new literal)
	 * 
	 * @param genEnumLiteral the generator-model enumeration literal definition
	 * @param umlEnum the target enumeration in the UML profile
	 * 
	 * @return the new UML enumeration literal
	 */
	public static EnumerationLiteral createEnumerationLiteral(GenDomainEnumLiteral genEnumLiteral, Enumeration umlEnum) {
		return umlEnum.createOwnedLiteral(genEnumLiteral.getName());
	}
	
	/**
	 * Gets the named literal of the enumeration that types the specified property.
	 * This works around a bug in oAW in which the getOwnedLiteral(String) and
	 * getOwnedMember(String) operations and the ownedLiteral and ownedMember
	 * attributes are not available on Enumerations in order to access their literals.
	 * 
	 * @param property the UML property whose type is the enumeration
	 * @param name the name of the enumeration's literal to get
	 * 
	 * @return the literal
	 */
	public static EnumerationLiteral getEnumerationDefaultLiteral(Property property, String name) {
		EnumerationLiteral result = null;
		
		if (property.getType() instanceof Enumeration) {
			result = ((Enumeration) property.getType()).getOwnedLiteral(name);
		}
		
		return result;
	}
	
	/**
	 * Initialize a model library (generated from the given domain specialization)
	 * for use in RSM.
	 * 
	 * @param modelLibrary the model library to initialize
	 * @param profile the UML profile that we are generating for the domain
	 */
	public static void initializeForRSM(Package modelLibrary, Profile profile) {
		ResourceSet rset = null;

		Resource contextResource = profile.eResource();
		if (contextResource != null) {
			rset = contextResource.getResourceSet();
		}

		if (rset == null) {
			rset = TransactionUtil.getEditingDomain(modelLibrary).getResourceSet();
		}

		Profile std = loadPackage(rset, UMLResource.STANDARD_PROFILE_URI);
		if (std == null) {
			throw new IllegalStateException(
				ZDLGen2UMLProfileMessages.RSMProfilingExtensions_stdProfile);
		}

		modelLibrary.applyProfile(std);

		modelLibrary.applyStereotype(std.getOwnedStereotype("ModelLibrary")); //$NON-NLS-1$
	}
}
