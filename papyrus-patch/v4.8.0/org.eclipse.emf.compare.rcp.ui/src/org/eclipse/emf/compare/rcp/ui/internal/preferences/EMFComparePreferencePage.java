/*******************************************************************************
 * Copyright (c) 2006, 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Global preference page for EMF Compare
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class EMFComparePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public EMFComparePreferencePage() {
		noDefaultAndApplyButton();
	}

	public EMFComparePreferencePage(String title) {
		super(title);
		noDefaultAndApplyButton();
	}

	public EMFComparePreferencePage(String title, ImageDescriptor image) {
		super(title, image);
		noDefaultAndApplyButton();
	}

	public void init(IWorkbench workbench) {

	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText(EMFCompareRCPUIMessages.getString("EMFComparePreferencePage.intro.text")); //$NON-NLS-1$
		return container;
	}
}
