/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizard;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.xtext.oclstdlib.ui.OCLstdlibUiModule;
import org.eclipse.ocl.xtext.oclstdlib.ui.messages.OCLstdlibUIMessages;

/**
 * Wizard allowing the user to create a new OCL Standard Library file.
 */
public class OCLstdlibFileNewWizard extends AbstractFileNewWizard
{
	@Override
	protected @NonNull OCLstdlibFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		return new OCLstdlibFileDialog(this, wizardPage, initialSelection);
	}

	@Override
	protected String getEditorId() {
		return OCLstdlibUiModule.EDITOR_ID;
	}

	@Override
	public @NonNull String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog) {
		StringBuilder s = new StringBuilder();
		s.append("-- import an existing library to be extended\n");
		s.append("import '" + LibraryConstants.STDLIB_URI + "';\n");
		s.append("\n");
		s.append("-- import an extension library re-using the imported library nsURI\n");
		s.append("library lib : lib = '" + LibraryConstants.STDLIB_URI + "' {\n");
		s.append("    type String : PrimitiveType {\n");
		s.append("    	-- define an additional operation accessed by my.strings.ExtraOperation.INSTANCE.evaluate\n");
		s.append("    	operation extraOperation(elem : Boolean) : Boolean => 'my.strings.ExtraOperation';\n");
		s.append("    }\n");
		s.append("}\n");
		return s.toString();
	}

	@Override
	public @NonNull String getNewFileExtension() {
		return "oclstdlib";
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileName() {
		return OCLstdlibUIMessages.NewWizardPage_defaultFileName;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileLabel() {
		return OCLstdlibUIMessages.NewWizardPage_fileNameLabel;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageDescription() {
		return OCLstdlibUIMessages.NewWizardPage_pageDescription;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageSummary() {
		return OCLstdlibUIMessages.NewWizardPage_pageSummary;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageTitle() {
		return OCLstdlibUIMessages.NewWizardPage_pageTitle;
	}
}