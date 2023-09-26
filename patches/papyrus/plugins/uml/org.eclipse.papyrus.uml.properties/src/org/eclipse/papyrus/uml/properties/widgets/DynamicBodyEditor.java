/*****************************************************************************
 * Copyright (c) 2011, 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea. fr - Bug 536594
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.papyrus.uml.properties.expression.ExpressionList.Expression;
import org.eclipse.papyrus.uml.properties.preferences.LanguageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * An editor to edit an expression body.
 * Depending on the matching language, a different widget will be used to edit
 * the expression body.
 *
 * @author Camille Letavernier
 *
 */
public class DynamicBodyEditor extends AbstractValueEditor implements Listener {

	private BodyEditor currentEditor;

	private final Composite bodyEditorContainer;

	private final Set<Listener> changeListeners = new HashSet<Listener>();

	private boolean readOnly = false;

	private ModelElement context = null;

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed
	 * @param style
	 *            The widget's composite style
	 */
	public DynamicBodyEditor(Composite parent, int style) {
		super(parent, style);

		bodyEditorContainer = new Composite(this, style);
		bodyEditorContainer.setLayout(new FillLayout());
		bodyEditorContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		currentEditor = new NullBodyEditor();
		currentEditor.createWidget(bodyEditorContainer, SWT.NONE);
	}

	/**
	 * Sets the {@link Expression} to edit.
	 * This will refresh the widget used to edit the expression body.
	 *
	 * @param expression
	 *            the expression to edit
	 */
	public void display(Expression expression) {
		if (currentEditor != null) {
			disposeBodyEditor();
		}

		BodyEditor editor;

		if (expression == null) {
			editor = new NullBodyEditor();
			editor.createWidget(bodyEditorContainer, SWT.NONE);
			bodyEditorContainer.layout();
			return;
		}

		String language = expression.getLanguage();
		String initialText = expression.getBody();

		editor = getEditor(language);
		editor.createWidget(bodyEditorContainer, SWT.NONE);
		if (context != null) {
			editor.setContext(context);
		}

		editor.setInput(initialText);
		editor.addChangeListener(this);

		editor.setReadOnly(readOnly);

		bodyEditorContainer.layout();

		currentEditor = editor;
	}

	/**
	 * Adds a listener to this object
	 * Events will be fired when the body has changed
	 *
	 * @param listener
	 */
	// TODO : isn't it simply a commit listener ?
	public void addChangeListener(Listener listener) {
		changeListeners.add(listener);
	}

	/**
	 * Removes a listener from this object
	 *
	 * @param listener
	 */
	public void removeChangeListener(Listener listener) {
		changeListeners.remove(listener);
	}

	private BodyEditor getEditor(String language) {
		final BodyEditor editor = LanguageRegistry.instance.getEditorFor(language);
		if (editor instanceof LanguageBodyEditor && null != language) {
			((LanguageBodyEditor) editor).setLanguage(language);
		}
		return editor;
	}

	private void disposeBodyEditor() {
		currentEditor.removeChangeListener(this);
		currentEditor.dispose();
		if (null != bodyEditorContainer && !bodyEditorContainer.isDisposed()) {
			for (Control control : bodyEditorContainer.getChildren()) {
				control.dispose();
			}
		}
	}

	@Override
	public String getValue() {
		if (currentEditor != null) {
			return currentEditor.getValue();
		}
		return null;
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		if (currentEditor != null) {
			currentEditor.setReadOnly(readOnly);
		}

		this.readOnly = readOnly;
	}

	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	@Override
	public void setToolTipText(String text) {
		super.setLabelToolTipText(text);
	}

	public void handleEvent(Event event) {
		for (Listener listener : changeListeners) {
			listener.handleEvent(event);
		}
	}

	@Override
	protected GridData getLabelLayoutData() {
		GridData result = super.getLabelLayoutData();
		result.verticalAlignment = SWT.BEGINNING;
		return result;
	}

	/**
	 * Sets the ModelElement used by this editor
	 *
	 * @param modelElement
	 */
	public void setContext(ModelElement modelElement) {
		this.context = modelElement;
		if (currentEditor != null) {
			currentEditor.setContext(context);
		}
	}

	@Override
	public void updateStatus(IStatus status) {
		
	}


	@Override
	public void changeColorField() {
		

	}
}
