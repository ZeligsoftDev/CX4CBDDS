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
package org.eclipse.papyrus.uml.properties.editors;

import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.papyrus.uml.properties.widgets.RichTextEditorCompositeWrapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * The Class RichTextValueEditor.
 * 
 * @since 2.0
 */
public class RichTextValueEditor extends AbstractValueEditor {

	private boolean isReadOnly = false;

	/** The rich text editor. */
	protected RichTextEditorCompositeWrapper richTextEditor;

	/**
	 * Instantiates a new rich text value editor.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	protected RichTextValueEditor(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		createRichTextEditor(parent);
		setCommitOnFocusLost(richTextEditor.getControl());
	}

	/**
	 * Gets the rich text.
	 *
	 * @return the rich text
	 */
	public RichTextEditorCompositeWrapper getRichTextEditor() {
		return richTextEditor;
	}

	/**
	 * Gets the new editor.
	 *
	 * @return the new editor
	 */
	public RichTextEditorCompositeWrapper getNewEditor() {
		return richTextEditor;
	}

	/**
	 * Sets the new editor.
	 *
	 * @param newEditor
	 *            the new new editor
	 */
	public void setNewEditor(RichTextEditorCompositeWrapper newEditor) {
		this.richTextEditor = newEditor;
	}

	/**
	 * Creates the rich text editor.
	 *
	 * @param parent
	 *            the parent
	 */
	public void createRichTextEditor(Composite parent) {
		richTextEditor = new RichTextEditorCompositeWrapper(parent, SWT.NONE);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor#getValue()
	 */
	@Override
	public String getValue() {
		return richTextEditor.getText();
	}

	/**
	 * Gets the editable type.
	 *
	 * @return the editable type
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#getEditableType()
	 */
	@Override
	public Object getEditableType() {
		return RichTextEditorCompositeWrapper.class;
	}

	/**
	 * Sets the read only.
	 *
	 * @param readOnly
	 *            the new read only
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#setReadOnly(boolean)
	 */
	@Override
	public void setReadOnly(boolean readOnly) {
		isReadOnly = readOnly;
	}

	/**
	 * Checks if is read only.
	 *
	 * @return true, if is read only
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		return isReadOnly;
	}

	/**
	 * Sets the tool tip text.
	 *
	 * @param tooltip
	 *            the new tool tip text
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#setToolTipText(java.lang.String)
	 */
	@Override
	public void setToolTipText(String tooltip) {
		super.setLabelToolTipText(tooltip);
	}

	/**
	 * Sets the current text value for this editor.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(Object value) {
		if (value instanceof String) {
			this.richTextEditor.setText((String) value);
		} else {
			this.richTextEditor.setText(""); //$NON-NLS-1$
		}
	}
}
