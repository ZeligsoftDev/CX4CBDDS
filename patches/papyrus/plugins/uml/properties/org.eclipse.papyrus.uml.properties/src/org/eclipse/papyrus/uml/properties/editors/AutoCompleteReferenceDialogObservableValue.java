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

package org.eclipse.papyrus.uml.properties.editors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.infra.widgets.databinding.StyledTextObservableValue;
import org.eclipse.papyrus.uml.properties.widgets.AutoCompleteReferenceDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Observable for AutoCompleteReferenceDialog
 */
public class AutoCompleteReferenceDialogObservableValue extends StyledTextObservableValue {

	/**
	 * the styled text with completion reference dialog
	 */
	private AutoCompleteReferenceDialog referenceDialog;

	/**
	 * @param dialog
	 *            The observed AutoCompleteReferenceDialog
	 * @param styledText
	 *            The observed StyledText
	 * @param modelObservable
	 *            The Model IObservable
	 * @param eventType
	 *            The eventType to listen to. When the event is fired by the Text
	 *            widget, this IObservableValue will fire a ChangeEvent
	 */
	public AutoCompleteReferenceDialogObservableValue(AutoCompleteReferenceDialog dialog, StyledText styledText, IObservableValue modelObservable, int eventType) {
		super(styledText, modelObservable, eventType);
		this.referenceDialog = dialog;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.widgets.databinding.StyledTextObservableValue#doSetValue(java.lang.Object)
	 *
	 * @param value
	 */
	@Override
	protected void doSetValue(Object value) {
		if (value instanceof NamedElement) {
			NamedElement namedElement = (NamedElement) value;
			super.doSetValue(namedElement.getName());
		} else {
			super.doSetValue(value);
		}
		referenceDialog.update();
	}
}
