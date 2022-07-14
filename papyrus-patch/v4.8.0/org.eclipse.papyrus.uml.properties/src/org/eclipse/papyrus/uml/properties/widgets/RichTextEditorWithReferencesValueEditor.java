/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.properties.editors.RichTextValueEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;

/**
 * A RichText editor with support for inserting references to EObjects (Via a TextReferenceHelper).
 *
 * @author Micka�l ADAM
 * @since 2.0
 */
public class RichTextEditorWithReferencesValueEditor extends RichTextValueEditor {

	/** Listeners */
	protected RichTextObservableValue richTextObservable;

	/**
	 * Instantiates a new rich text editor with references.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public RichTextEditorWithReferencesValueEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.properties.editors.RichTextValueEditor#createRichTextEditor(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createRichTextEditor(Composite parent) {
		this.richTextEditor = new RichTextEditorWithReferencesCompositeWrapper(parent, SWT.NONE);
	}

	/**
	 * 
	 * @param editedElement
	 * @param editedFeature
	 */
	public void configureEdition(Element editedElement, EStructuralFeature editedFeature) {
		if (richTextEditor instanceof RichTextEditorWithReferencesCompositeWrapper) {
			((RichTextEditorWithReferencesCompositeWrapper) richTextEditor).configureEdition(editedElement, editedFeature);
		}
	}


	/**
	 * Sets the model observable.
	 *
	 * @param observable
	 *            the new model observable
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor#setModelObservable(org.eclipse.core.databinding.observable.value.IObservableValue)
	 */
	@Override
	public void setModelObservable(@SuppressWarnings("rawtypes") IObservableValue observable) {
		richTextObservable = new RichTextObservableValue(richTextEditor, observable, SWT.FocusOut);
		setWidgetObservable(richTextObservable, true);
		super.setModelObservable(observable);
	}
}
