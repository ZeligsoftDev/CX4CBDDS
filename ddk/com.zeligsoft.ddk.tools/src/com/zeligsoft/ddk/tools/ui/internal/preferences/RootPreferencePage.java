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
package com.zeligsoft.ddk.tools.ui.internal.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The root preference page for the Zeligsoft developer tools. This page serves
 * only as a container for nested preference pages.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class RootPreferencePage
	extends PreferencePage 
	implements IWorkbenchPreferencePage {
	
	@Override
	public void init(IWorkbench workbench) {
		// nothing to do
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		result.setLayout(grid);
		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		result.setLayoutData(data);

		Label label = new Label(result, SWT.NONE);
		label.setText("Expand at left for specfic preferences.");
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		label.setLayoutData(data);

		return result;
	}

}
