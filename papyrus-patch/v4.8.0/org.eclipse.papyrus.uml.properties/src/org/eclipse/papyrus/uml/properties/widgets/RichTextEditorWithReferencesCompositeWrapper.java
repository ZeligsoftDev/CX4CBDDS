/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.ui.editors.UMLRichtextEditorWithReferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;

/**
 * @since 2.0
 */
public class RichTextEditorWithReferencesCompositeWrapper extends RichTextEditorCompositeWrapper {

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public RichTextEditorWithReferencesCompositeWrapper(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.properties.widgets.RichTextEditorCompositeWrapper#createRichTextEditor(org.eclipse.swt.widgets.Composite, int)
	 *
	 * @param composite
	 * @param style
	 * @return
	 */
	@Override
	protected UMLRichtextEditorWithReferences createRichTextEditor(Composite composite, int style) {
		return new UMLRichtextEditorWithReferences(composite, SWT.FLAT | SWT.BOTTOM);
	}

	/**
	 * 
	 * @param editedElement
	 *            the edited element
	 * @param editedFeature
	 *            the edited feature of the edited element
	 */
	public void configureEdition(Element editedElement, EStructuralFeature editedFeature) {
		if (this.richTextEditor instanceof UMLRichtextEditorWithReferences) {
			((UMLRichtextEditorWithReferences) this.richTextEditor).configureEdition(editedElement, editedFeature);
		}
	}

}
