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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing with auto-completion through a Dialog
 * (not binded with Papyrus Properties fwk)
 */
public class AutoCompletePropertyEditor extends AbstractPropertyEditor {

	/**
	 * The ReferenceDialog widget
	 */
	protected org.eclipse.papyrus.uml.properties.widgets.AutoCompleteReferenceDialog editor;

	/**
	 * The ValueFactory used to create or edit Objects directly from
	 * this editor
	 */
	protected ReferenceValueFactory factory;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 */
	public AutoCompletePropertyEditor(Composite parent, int style) {
		editor = createReferenceDialog(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the reference dialog.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The style for the widget
	 * @return the reference dialog.
	 */
	protected org.eclipse.papyrus.uml.properties.widgets.AutoCompleteReferenceDialog createReferenceDialog(Composite parent, int style) {
		return new org.eclipse.papyrus.uml.properties.widgets.AutoCompleteReferenceDialog(parent, style);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider provider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);
		editor.setLabelProvider(labelProvider);
		editor.setContentProvider(provider);
		editor.setDirectCreation(input.getDirectCreation(propertyPath));
		editor.setMandatory(input.isMandatory(propertyPath));
		if (factory == null) { // Use the default factory from the DataSource
			editor.setValueFactory(input.getValueFactory(propertyPath));
		} else { // Use the factory explicitly specified
			editor.setValueFactory(factory);
		}
		INameResolutionHelper nameResolutionHelper = input.getNameResolutionHelper(propertyPath);
		if (nameResolutionHelper != null) {
			editor.setNameResolutionHelper(nameResolutionHelper);
		}
		super.doBinding();
	}

	/**
	 * Sets the ValueFactory used to create or edit Objects directly from
	 * this editor
	 *
	 * @param factory
	 */
	public void setFactory(ReferenceValueFactory factory) {
		this.factory = factory;
		editor.setValueFactory(factory);
	}

	/**
	 * @return The ValueFactory used to create or edit Objects directly from
	 *         this editor
	 */
	public ReferenceValueFactory getFactory() {
		return factory;
	}

}
