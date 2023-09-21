/*******************************************************************************
 * <copyright>
 * Copyright (c) 2009 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 * </copyright>
 *******************************************************************************/

package org.eclipse.xtend.typesystem.emf.check;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

/**
 * Reads checks extensions, instantiates validators and registers them.
 * 
 * @author Jan Koehnlein
 */
public class CheckRegistry {

	private final Logger log = LogManager.getLogger(getClass());

	private static final String EXTENSION_POINT_ID = "org.eclipse.xtend.typesystem.emf.checks";
	private static final String NS_URI_ATTR_ID = "nsURI";
	private static final String CHECK_FILE_ATTR_ID = "checkFile";
	private static final String CHECK_FILE_PATH_ATTR_ID = "path";
	private static final String OVERRIDE_ATTR_ID = "override";
	private static final String REFERENCED_META_MODEL = "referencedMetaModel";

	private static CheckRegistry INSTANCE;

	private CheckRegistry() {
		registerExtensions();
	}

	public static CheckRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CheckRegistry();
		}
		return INSTANCE;
	}

	public void registerCheckFile(EPackage ePackage, String checkFileName, boolean isWrapExistingValidator,
			List<String> referencedEPackageNsURIs) {
		CheckEValidatorAdapter extxptValidator;
		if (isWrapExistingValidator) {
			EValidator validator = EValidator.Registry.INSTANCE.getEValidator(ePackage);
			if (validator instanceof CheckEValidatorAdapter)
				extxptValidator = (CheckEValidatorAdapter) validator;
			else
				extxptValidator = new CheckEValidatorAdapter(ePackage, validator);
		}
		else {
			extxptValidator = new CheckEValidatorAdapter(ePackage);
		}
		CheckFileWithContext checkFile = new CheckFileWithContext(checkFileName);
		for (String referencedEPackageNsURI : referencedEPackageNsURIs) {
			checkFile.addImportedEPackageNsUri(referencedEPackageNsURI);
		}
		extxptValidator.addCheckFile(checkFile);
		EValidator.Registry.INSTANCE.put(ePackage, extxptValidator);
	}

	private void registerExtensions() {
		try {
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(EXTENSION_POINT_ID);
			IConfigurationElement[] metaModels = extensionPoint.getConfigurationElements();
			for (IConfigurationElement metaModel : metaModels) {
				try {
					String nsURI = metaModel.getAttribute(NS_URI_ATTR_ID);
					EPackage ePackage = findEPackage(nsURI);
					boolean isWrapExistingValidator = !"true".equals(metaModel.getAttribute(OVERRIDE_ATTR_ID));
					IConfigurationElement[] checkFiles = metaModel.getChildren(CHECK_FILE_ATTR_ID);
					for (IConfigurationElement checkFile : checkFiles) {
						try {
							String checkFileName = checkFile.getAttribute(CHECK_FILE_PATH_ATTR_ID);
							List<String> referencedEPackageNsURIs = new ArrayList<String>();
							for (IConfigurationElement referencedMetaModel : checkFile
									.getChildren(REFERENCED_META_MODEL)) {
								String refNsURI = referencedMetaModel.getAttribute(NS_URI_ATTR_ID);
								referencedEPackageNsURIs.add(refNsURI);
							}
							registerCheckFile(ePackage, checkFileName, isWrapExistingValidator, referencedEPackageNsURIs);
						}
						catch (Exception exc) {
							log.error(exc);
						}
					}
				}
				catch (Exception exc) {
					log.error(exc);
				}
			}
		}
		catch (Exception exc) {
			log.error(exc);
		}
	}

	private EPackage findEPackage(String nsURI) {
		Object registryEntry = EPackage.Registry.INSTANCE.get(nsURI);
		if (registryEntry == null)
			throw new IllegalArgumentException("EPackage with URI " + nsURI
					+ " not found in EPackage.Registry.INSTANCE");
		if (registryEntry instanceof EPackage) {
			return (EPackage) registryEntry;
		}
		else if (registryEntry instanceof EPackage.Descriptor) {
			return ((EPackage.Descriptor) registryEntry).getEPackage();
		}
		throw new IllegalArgumentException("Wrong type in Ecore.Registry");
	}
}
