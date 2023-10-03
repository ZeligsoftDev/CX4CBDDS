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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.properties.editors.RichTextValueEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;

/**
 * A rich text property editor with support for TextReferences.
 * 
 * @author Mickael ADAM
 *
 * @see {@link org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper}
 * @since 2.0
 */
public abstract class RichTextWithReferencesPropertyEditor extends AbstractPropertyEditor {

	/**
	 * the embedded editor
	 */
	protected RichTextEditorWithReferencesValueEditor editor;

	/**
	 * Instantiates a new rich text with references.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public RichTextWithReferencesPropertyEditor(Composite parent, int style) {
		super();
		setEditor(editor = new RichTextEditorWithReferencesValueEditor(parent, style));
	}

	/**
	 * 
	 * @param element
	 *            the edited element
	 * @param editedFeature
	 *            the edited feature
	 */
	public void configureEdition(final Element element, final EStructuralFeature editedFeature) {
		editor.configureEdition(element, editedFeature);
	}


	/**
	 * Do binding.
	 *
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		super.doBinding();
		if (getInputObservableValue() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener) getInputObservableValue());
		}
	}

	/**
	 * Gets the rich text editor.
	 *
	 * @return the rich text editor
	 */
	protected RichTextValueEditor getRichTextEditor() {
		return (RichTextValueEditor) valueEditor;
	}

}

