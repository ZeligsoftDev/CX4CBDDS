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
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.uml.properties.profile.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * These preferences have been created to try to avoid the bug 522652
 * 
 * @noextend
 */
public final class ProfileTabPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * the check box editor used to activate/unactivate the truncation of the label in the Stereotype Application Tree View
	 */
	private BooleanFieldEditor truncateStereotypeTreeLabelEditor;

	/**
	 * The max char editor for the truncated label
	 */
	private IntegerFieldEditor maxLabelCharEditor;

	/**
	 * the checkbow editor used to activate/unactivate the display of the stereotype properties as children in the Stereotype Application Tree View
	 */
	private BooleanFieldEditor showStereotypePropertyValueAsChildrenEditor;

	/**
	 * the parent of the graphical editor
	 */
	private Composite maxLabelCharEditorParent;

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(ProfileTabPreferences.getPreferenceStore());
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *
	 */
	@Override
	protected void createFieldEditors() {
		this.truncateStereotypeTreeLabelEditor = new BooleanFieldEditor(ProfileTabPreferences.TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE, Messages.ProfileTabPreferencePage_TruncateLabel, getFieldEditorParent());

		this.truncateStereotypeTreeLabelEditor.setPreferenceStore(getPreferenceStore());
		addField(this.truncateStereotypeTreeLabelEditor);

		this.maxLabelCharEditorParent = getFieldEditorParent();

		this.maxLabelCharEditor = new IntegerFieldEditor(ProfileTabPreferences.TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_NB_CHAR_PREFERRENCE, Messages.ProfileTabPreferencePage_NumberOfCharToKeep, this.maxLabelCharEditorParent);
		this.maxLabelCharEditor.setPreferenceStore(getPreferenceStore());
		addField(this.maxLabelCharEditor);

		this.maxLabelCharEditor.setEnabled(getPreferenceStore().getBoolean(ProfileTabPreferences.TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE), this.maxLabelCharEditorParent);
		this.maxLabelCharEditor.setValidRange(ProfileTabPreferences.getMinLabelWidth(), ProfileTabPreferences.getMaxLabelWidth());

		this.showStereotypePropertyValueAsChildrenEditor = new BooleanFieldEditor(ProfileTabPreferences.SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE, Messages.ProfileTabPreferencePage_ShowTheValueOfTheStereotypeProperties, getFieldEditorParent());

		this.showStereotypePropertyValueAsChildrenEditor.setPreferenceStore(getPreferenceStore());
		addField(this.showStereotypePropertyValueAsChildrenEditor);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 *
	 * @param event
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (null != event && event.getSource() == this.truncateStereotypeTreeLabelEditor && event.getNewValue() instanceof Boolean) {
			this.maxLabelCharEditor.setEnabled((boolean) event.getNewValue(), maxLabelCharEditorParent);
		}
		super.propertyChange(event);
	}

}
