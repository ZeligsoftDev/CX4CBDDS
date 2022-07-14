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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Widget for editing the Rich Text Body of Comments.
 *
 * @author MickaëlADAM
 * @since 2.0
 */
public class CommentBodyRichTextEditor extends RichTextWithReferencesPropertyEditor {

	/**
	 * Instantiates a new comment body rich text editor.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public CommentBodyRichTextEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.richtext.extension.properties.RichTextWithReferences#doBinding()
	 *
	 */
	@Override
	protected void doBinding() {
		super.doBinding();
		Element editedElement = null;
		ModelElement element = getInput().getModelElement(getProperty());
		if (element instanceof EMFModelElement) {
			EMFModelElement emfElement = (EMFModelElement) element;
			EObject editedObject = emfElement.getSource();
			if (editedObject instanceof Comment) {
				editedElement = (Element) editedObject;
			}
		}
		if (editedElement != null) {
			configureEdition(editedElement, UMLPackage.eINSTANCE.getComment_Body());
		}
	}
}
