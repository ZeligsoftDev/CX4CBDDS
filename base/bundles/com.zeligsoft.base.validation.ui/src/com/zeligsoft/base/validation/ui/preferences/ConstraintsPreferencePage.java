/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.base.validation.ui.preferences;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.emf.validation.ui.preferences.ConstraintsSelectionBlock;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferenceLinkArea;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

import com.zeligsoft.base.validation.provider.ZDLConstraintManager;
import com.zeligsoft.base.validation.ui.l10n.Messages;

/**
 * A preference page showing the constraints (only) contributed by ZDL models.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ConstraintsPreferencePage
		extends PreferencePage
		implements IWorkbenchPreferencePage {

	private ConstraintsSelectionBlock constraintsBlock;

	@Override
	protected Control createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		grid.verticalSpacing = 15;
		result.setLayout(grid);
		
		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		result.setLayoutData(data);

		PreferenceLinkArea link = new PreferenceLinkArea(result, SWT.NONE,
			"org.eclipse.emf.validation.ui.rootPage", //$NON-NLS-1$
			Messages.ConstraintsPreferencePage_generalLink,
			(IWorkbenchPreferenceContainer) getContainer(), null);

		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		link.getControl().setLayoutData(data);

		// force initialization of pre-loaded constraints
		ZDLConstraintManager.getInstance().inializePreloadedConstraints();
		
		constraintsBlock = new ConstraintsSelectionBlock(
			new IConstraintFilter() {

				@Override
				public boolean accept(IConstraintDescriptor constraint,
						EObject target) {
					boolean result = false;

					Category zdl = ZDLConstraintManager.getInstance()
						.getZDLCategory();
					String zdlPath = zdl.getId() + '/';
					for (Category next : constraint.getCategories()) {
						if (next.getPath().startsWith(zdlPath)) {
							result = true;
							break;
						}
					}

					return result;
				}
			});
		Composite blockControl = constraintsBlock.createComposite(result);

		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = SWT.FILL;
		data.grabExcessVerticalSpace = true;
		blockControl.setLayoutData(data);

		return result;
	}

	@Override
	public void dispose() {
		constraintsBlock.dispose();
		super.dispose();
	}

	@Override
	public boolean performOk() {
		constraintsBlock.performOk();
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		constraintsBlock.performDefaults();
		super.performDefaults();
	}

	@Override
	public void init(IWorkbench workbench) {
		// nothing to do
	}
}
