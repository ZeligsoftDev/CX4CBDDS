/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public class OCLinEcoreFileNewWizard extends AbstractOCLinEcoreFileNewWizard
{
	@Override
	protected void appendImports(StringBuilder s, AbstractFileDialog dialog, IFile newFile) {
		@SuppressWarnings("null")
		List<@NonNull URI> uris = dialog.getURIs();
		if (uris.size() > 0) {
			URI newURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
			for (@NonNull URI uri : uris) {
				URI deresolvedURI = URIUtil.deresolve(uri, newURI);
				s.append("import '" + ValueUtil.oclToString(deresolvedURI) + "';\n");
			}
			s.append("\n");
		}
	}

	@Override
	protected @NonNull OCLinEcoreFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		return new OCLinEcoreFileDialog(this, wizardPage, initialSelection);
	}

	@Override
	public @NonNull String getNewFileExtension() {
		return "oclinecore";
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileLabel() {
		return OCLinEcoreUIMessages.NewWizardPage_fileNameLabel;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageDescription() {
		return OCLinEcoreUIMessages.NewWizardPage_pageDescription;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageSummary() {
		return OCLinEcoreUIMessages.NewWizardPage_pageSummary;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageTitle() {
		return OCLinEcoreUIMessages.NewWizardPage_pageTitle;
	}
}