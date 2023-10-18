/*******************************************************************************
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public class EcoreWithOCLFileNewWizard extends AbstractOCLinEcoreFileNewWizard
{
	private static final Logger logger = LogManager.getLogger(EcoreWithOCLFileNewWizard.class);

	@Override
	protected @NonNull EcoreWithOCLFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		return new EcoreWithOCLFileDialog(this, wizardPage, initialSelection);
	}

	@Override
	public @NonNull
	String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog) {
		URI ecoreURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
		URI oclInEcoreURI = ecoreURI.trimFileExtension().appendFileExtension("oclinecore");
		String initialContentsAsString = super.getInitialContentsAsString(newFile, dialog);
		@SuppressWarnings("null") OCL ocl = OCL.newInstance(EPackage.Registry.INSTANCE);
		ResourceSet resourceSet2 = ocl.getResourceSet();
		BaseCSResource csResource = ClassUtil.nonNullState((BaseCSResource) resourceSet2.createResource(oclInEcoreURI));
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(initialContentsAsString.getBytes());
			csResource.load(inputStream, null);
			ASResource asResource = ocl.cs2as(csResource);
			Resource eResource = ocl.as2ecore(asResource, ecoreURI);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			eResource.save(outputStream, null);
			@SuppressWarnings("null")@NonNull String string = outputStream.toString();
			return string;
		} catch (IOException e) {
			logger.error("Failed to create " + ecoreURI, e);
		}
		finally {
			ocl.dispose();
		}
		return initialContentsAsString;
	}

	@Override
	public @NonNull String getNewFileExtension() {
		return "ecore";
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileLabel() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_fileNameLabel;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageDescription() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageDescription;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageSummary() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageSummary;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageTitle() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageTitle;
	}
}