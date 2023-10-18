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
package org.eclipse.ocl.xtext.oclinecore.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizard;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public abstract class AbstractOCLinEcoreFileNewWizard extends AbstractFileNewWizard
{

	protected void appendImports(StringBuilder s, AbstractFileDialog dialog, IFile newFile) {}

	@Override
	protected String getEditorId() {
		return OCLinEcoreUiModule.EDITOR_ID;
	}

	@Override
	public @NonNull String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog) {
		StringBuilder s = new StringBuilder();
		appendImports(s, dialog, newFile);
		s.append("package example : ex = 'http://www.example.org/examples/example.ecore'\n");
		s.append("{\n");
		s.append("	-- Example Class with hierarchical properties and an invariant\n");
		s.append("	class Example\n");
		s.append("	{\n");
		s.append("		property name : String[?];\n");
		s.append("		property children#parent : Example[*] { composes, ordered } ;\n");
		s.append("		property parent#children : Example[?];\n");
		s.append("		operation ucName() : String[?] {\n");
		s.append("			body: name?.toUpperCase();\n");
		s.append("		}\n");
		s.append("		invariant NameIsLowerCase('Expected a lowercase name rather than \'' + name + '\''):\n");
		s.append("			name = name?.toLowerCase();\n");
		s.append("	}\n");
		s.append("}\n");
		return s.toString();
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileName() {
		return OCLinEcoreUIMessages.NewWizardPage_defaultFileName;
	}
}