/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.uml;

import java.net.URL;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Registry;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.labels.CommentLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralBooleanLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralIntegerLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralNullLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralRealLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralStringLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralUnlimitedNaturalLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.NamedElementLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.OpaqueExpressionLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.PackageImportLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.SlotLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.UMLElementExtensionLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.resource.UMLASResourceFactory;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.uml2.uml.UMLPlugin;

/**
 * Initialization support for UML Pivot models without equinox extension registry
 */
public class UMLStandaloneSetup //implements ISetup
{
	public static final @NonNull String PROFILES_PATHMAP = "pathmap://OCL_PROFILES/"; //$NON-NLS-1$
	public static final @NonNull String OCL4UML_PROFILE_URI = PROFILES_PATHMAP + "OCLforUML.profile.uml#_0"; //$NON-NLS-1$

	private static boolean initialized = false;
	private static final Logger logger = LogManager.getLogger(UMLStandaloneSetup.class);

	/**
	 * Verify that initialization has occurred, generation a warning log message if not and initializing anyway.
	 */
	public static void assertInitialized() {
		if (!initialized && !EMFPlugin.IS_ECLIPSE_RUNNING) {
			logger.warn("UMLStandaloneSetup.init() should be called before using OCL's UML facilities");
			init();
		}
	}

	private static URI getBaseOCLResourceURI() {
		URI umlMetamodel = URI.createURI(OCL4UML_PROFILE_URI).trimFragment();
		String jarResourceName = String.format("model/%s", umlMetamodel.lastSegment()); //$NON-NLS-1$
		URL resultURL = UMLStandaloneSetup.class.getClassLoader().getResource(jarResourceName);

		URI result;

		if (resultURL != null) {
			// remove the /model/OCLforUML.profile.uml segments of the resource we found
			result = URI.createURI(resultURL.toExternalForm(), true).trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source project folder layout
			Class<?> exampleClass = UMLStandaloneSetup.class;
			resultURL = exampleClass.getResource(exampleClass.getSimpleName() + ".class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();
			baseURL = baseURL.substring(0, baseURL.lastIndexOf("/bin/")); //$NON-NLS-1$
			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	/**
	 * Initialize the OCL facilities and the associated UML facilities.
	 */
	public static void init() {
		if (!initialized) {
			initialized = true;
			PivotStandaloneSetup.init();
			UMLASResourceFactory.getInstance();
			UML2AS.initialize();
			UML2AS.initializeUMLglobals();
			EPackage.Registry.INSTANCE.put(OCLforUMLPackage.eNS_URI, OCLforUMLPackage.eINSTANCE);
			URI ocl4umlProfileURI = URI.createURI(OCL4UML_PROFILE_URI);
			UMLPlugin.getEPackageNsURIToProfileLocationMap().put(OCLforUMLPackage.eNS_URI, ocl4umlProfileURI);
			URI baseURI = getBaseOCLResourceURI();
			mapUMLResourceURIs(URIConverter.URI_MAP, PROFILES_PATHMAP, baseURI.appendSegment("model")); //$NON-NLS-1$
			initializeLabelGenerators(ILabelGenerator.Registry.INSTANCE);
		}
	}

	/**
	 * Initialize labelRegistry with the UML-specific lable generators.
	 */
	public static void initializeLabelGenerators(@NonNull Registry labelRegistry) {
		CommentLabelGenerator.initialize(labelRegistry);
		LiteralBooleanLabelGenerator.initialize(labelRegistry);
		LiteralIntegerLabelGenerator.initialize(labelRegistry);
		LiteralNullLabelGenerator.initialize(labelRegistry);
		LiteralRealLabelGenerator.initialize(labelRegistry);
		LiteralStringLabelGenerator.initialize(labelRegistry);
		LiteralUnlimitedNaturalLabelGenerator.initialize(labelRegistry);
		NamedElementLabelGenerator.initialize(labelRegistry);
		OpaqueExpressionLabelGenerator.initialize(labelRegistry);
		PackageImportLabelGenerator.initialize(labelRegistry);
		SlotLabelGenerator.initialize(labelRegistry);
		UMLElementExtensionLabelGenerator.initialize(labelRegistry);
	}

	private static void mapUMLResourceURIs(Map<URI, URI> uriMap, String uri,
			URI location) {

		URI prefix = URI.createURI(uri);

		// ensure trailing separator (make it a "URI prefix")
		if (!prefix.hasTrailingPathSeparator()) {
			prefix = prefix.appendSegment(""); //$NON-NLS-1$
		}

		// same with the location
		if (!location.hasTrailingPathSeparator()) {
			location = location.appendSegment(""); //$NON-NLS-1$
		}

		uriMap.put(prefix, location);

		// and platform URIs, too
		String folder = location.segment(location.segmentCount() - 2);
		String platformURI = String.format("%s/%s/", PivotUMLPlugin.PLUGIN_ID, folder); //$NON-NLS-1$
		uriMap.put(URI.createPlatformPluginURI(platformURI, true), location);
		uriMap.put(URI.createPlatformResourceURI(platformURI, true), location);
	}
}
