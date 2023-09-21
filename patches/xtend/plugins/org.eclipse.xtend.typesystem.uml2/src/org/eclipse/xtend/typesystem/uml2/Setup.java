/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.typesystem.uml2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.Mapping;

/**
 * Initialization of UML2 Support. This class must be integrated into workflows
 * using EMF UML2 like follows:
 * <p>
 *
 * <pre>
 *  	MWE1:
 *  	&lt;bean class=&quot;org.eclipse.internal.xtend.uml2.Setup&quot;/&gt;
 *
 *  	MWE2
 *  	bean = org.eclipse.internal.xtend.uml2.Setup {  }
 * </pre>
 *
 * @author Sven Efftinge - initial implementation and API
 * @author Karsten Thoms - docs, maintenance
 */
public class Setup extends org.eclipse.xtend.typesystem.emf.Setup {
	private static final Logger LOG = LogManager.getLogger(Setup.class);
	//
	private static final String UML2_200_NS_URI = "http://www.eclipse.org/uml2/2.0.0/UML";
	private static final String UML2_210_NS_URI = "http://www.eclipse.org/uml2/2.1.0/UML";
	private static final String UML2_300_NS_URI = "http://www.eclipse.org/uml2/3.0.0/UML";
	private static final String UML2_400_NS_URI = "http://www.eclipse.org/uml2/4.0.0/UML";
	/**
	 * Constructor. Registers the UMLPackage.
	 *
	 */
	public Setup() {
		doStandaloneRegistration();
	}

	/**
	 * @deprecated Registration already occurs with instantiation
	 */
	@Deprecated
	public void setStandardUML2Setup(boolean b) {
		LOG.warn("Setting 'standardUML2Setup' not required anymore. Please remove the setting from your workflow/standalone configuration.");
	}

	/**
	 * Registers all required UML resources.
	 *
	 * @param b
	 *            Initialization occurs only if <code>true</code> is passed.
	 */
	private void doStandaloneRegistration() {
		addUriMap(new Mapping("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "pathmap://UML_PROFILES/StandardL2.profile.uml"));
		addUriMap(new Mapping("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "pathmap://UML_PROFILES/StandardL3.profile.uml"));

		if (Platform.isRunning()) {
			return;
		}
		addEPackageClass(UMLPackage.eINSTANCE.getClass().getName());
		addExtensionMap(new Mapping("ecore", "org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl"));
		addExtensionMap(new Mapping("uml", "org.eclipse.uml2.uml.resource.UMLResource"));
		addExtensionMap(new Mapping("uml2", "org.eclipse.uml2.uml.resource.UML22UMLResource"));
		String p = "metamodels/UML.metamodel.uml";
		URI uri = EcoreUtil2.getURI(p);
		if (uri != null && !uri.toString().equals(p)) {
			String path = uri.toString();
			final int mmIndex = path.lastIndexOf("/metamodels");
			if (mmIndex < 0)
				throw new IllegalStateException("Missing required plugin 'org.eclipse.uml2.uml.resources' in classpath.");

			path = path.substring(0, mmIndex);
			path = addJarProtocolIfNecessary(path);
			addUriMap(new Mapping("pathmap://UML_PROFILES/", path + "/profiles/"));
			addUriMap(new Mapping("pathmap://UML_METAMODELS/", path + "/metamodels/"));
			addUriMap(new Mapping("pathmap://UML_LIBRARIES/", path + "/libraries/"));
		} else {
			throw new IllegalStateException("Missing required plugin 'org.eclipse.uml2.uml.resources' in classpath.");
		}
		// Register old UML2 URIs which is not done in Java Application mode. Running Eclipse this
		// part is done automatically using the eclipse extension registry and EMF metamodel Extension
		// which is generated for all EPackages
		if (EPackage.Registry.INSTANCE.get(UML2_200_NS_URI)==null) {
			EPackage.Registry.INSTANCE.put(UML2_200_NS_URI, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		}
		if (EPackage.Registry.INSTANCE.get(UML2_210_NS_URI)==null) {
			EPackage.Registry.INSTANCE.put(UML2_210_NS_URI, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		}
		if (EPackage.Registry.INSTANCE.get(UML2_300_NS_URI)==null) {
			EPackage.Registry.INSTANCE.put(UML2_300_NS_URI, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		}
		if (EPackage.Registry.INSTANCE.get(UML2_400_NS_URI)==null) {
			EPackage.Registry.INSTANCE.put(UML2_400_NS_URI, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		}
		Ecore2XMLPackage.eINSTANCE.getEClassifiers();
		uri = EcoreUtil2.getURI("model/UML2_2_UML.ecore2xml");
		if (uri != null) {
			String path = addJarProtocolIfNecessary(uri.toString());
			addUriMap(new Mapping("platform:/plugin/org.eclipse.uml2.uml/model/UML2_2_UML.ecore2xml", path));
		}
	}

	/**
	 * Fixes a resource path of a Jar file, if necessary.
	 *
	 * @param path
	 *            A resource path
	 * @return If the path ends with '.jar', but has no protocol prefix 'jar:',
	 *         the prefix is prepended. Otherwise path is returned unchanged.
	 */
	private String addJarProtocolIfNecessary(String path) {
		if (path.indexOf(".jar!") != -1) {
			if (!path.startsWith("jar:"))
				path = "jar:" + path;
		}
		return path;
	}

}
