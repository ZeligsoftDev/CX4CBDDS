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

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.swt.widgets.Composite;

public class OCLstdlibFileDialog extends AbstractFileDialog
{
	/**
	 * Creates an extended new OCL Standard Library file creation dialog. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 */
	public OCLstdlibFileDialog(@NonNull OCLstdlibFileNewWizard wizard, @NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		super(wizard, wizardPage, initialSelection);
	}

	@Override
	protected void createMetamodelsArea(Composite parent) {}
}
