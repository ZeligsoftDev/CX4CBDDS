/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.helper;

import java.util.List;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.messages.Messages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @since 4.0
 */
public class ProfileApplicationDelegatePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private RadioGroupFieldEditor radioGroupFieldEditor;

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *
	 */
	@Override
	protected void createFieldEditors() {
		List<IProfileApplicationDelegate> delegates = ProfileApplicationDelegateRegistry.INSTANCE.delegates;
		String[][] array = new String[delegates.size()][2];

		int i = 0;
		for (IProfileApplicationDelegate delegate : delegates) {
			array[i][0] = delegate.getPreferenceLabel();
			array[i][1] = delegate.getPreferenceConstant();
			i++;
		}

		radioGroupFieldEditor = new RadioGroupFieldEditor(ProfileApplicationDelegatePreferenceInitializer.PROFILE_APPLICATION_DELEGATE_PREFERENCE, Messages.ProfileApplicationDelegatePreferencePage_selectProfileApplicationTool, 1, array, getFieldEditorParent());
		addField(radioGroupFieldEditor);
	}
}
