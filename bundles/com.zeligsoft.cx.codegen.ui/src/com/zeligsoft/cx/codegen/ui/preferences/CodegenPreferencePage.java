/**
 * Copyright 2021 Zeligsoft.
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
 *
 */

package com.zeligsoft.cx.codegen.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.zeligsoft.cx.codegen.ui.l10n.Messages;

/**
 * CX codegen report preference page.
 * 
 * @author Ernesto Posse
 */
public class CodegenPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/*
	 * (non-Javadoc)
	 * 
	 * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {

		final Composite panel = new Composite(parent, SWT.NONE);

		final GridLayout layout = new GridLayout(1, false);
		panel.setLayout(layout);

		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		panel.setLayoutData(data);

		final Label label = new Label(panel, SWT.NONE);
		label.setText(Messages.CXCodegenPreferencePage_Description);

		panel.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				data.widthHint = panel.getClientArea().width - 2 * layout.marginWidth;
				panel.layout(true);
			}
		});
		panel.layout(true);
		return panel;
	}

	@Override
	public void init(IWorkbench workbench) {
		// Nothing in particular to initialize
	}


}
