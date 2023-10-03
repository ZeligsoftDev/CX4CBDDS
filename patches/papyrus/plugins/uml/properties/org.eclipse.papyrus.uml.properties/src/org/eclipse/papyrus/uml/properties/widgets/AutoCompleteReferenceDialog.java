/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collections;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog;
import org.eclipse.papyrus.infra.widgets.editors.StyledTextStringEditor;
import org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.uml.properties.editors.AutoCompleteReferenceDialogObservableValue;
import org.eclipse.papyrus.uml.properties.editors.AutoCompleteStyledTextStringEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Reference dialog for auto-completion
 */
public class AutoCompleteReferenceDialog extends StyledTextReferenceDialog  {

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public AutoCompleteReferenceDialog(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected StyledTextStringEditor createStyledTextStringEditor(Composite parent, String initialValue, int style) {
		StyledTextStringEditor editor = new AutoCompleteStyledTextStringEditor(parent, style);
		editor.setValue(initialValue);
		return editor;
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog#createWidgetObservable(org.eclipse.core.databinding.observable.value.IObservableValue)
	 *
	 * @param modelProperty
	 * @return
	 */
	@Override
	protected IObservableValue createWidgetObservable(IObservableValue modelProperty) {
		AutoCompleteReferenceDialogObservableValue val = new AutoCompleteReferenceDialogObservableValue(this, this.styledTextStringEditor.getText(), modelProperty, SWT.FocusOut);
		return val;
	}

	public void setNameResolutionHelper(INameResolutionHelper nameResolutionHelper) {
		((AutoCompleteStyledTextStringEditor) styledTextStringEditor).setNameResolutionHelper(nameResolutionHelper);
	}	
	
	@Override
	protected void browseAction() {
		setInitialSelection(Collections.singletonList(getValue()));
		int result = dialog.open();
		if (result == Window.OK) {
			Object[] newValue = dialog.getResult();
			if (newValue == null) {
				return;
			}

			if (newValue.length == 0) {
				setValue(null);
			} else {
				Object value = newValue[0];
				if (contentProvider instanceof IAdaptableContentProvider) {
					value = ((IAdaptableContentProvider) contentProvider).getAdaptedValue(value);
				}
				setValue(value);
			}
		}
	}
}
