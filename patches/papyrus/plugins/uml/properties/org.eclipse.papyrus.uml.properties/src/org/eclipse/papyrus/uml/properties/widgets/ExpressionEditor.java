/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.properties.expression.ExpressionList;
import org.eclipse.papyrus.uml.properties.expression.ExpressionList.Expression;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * A Property Editor for editing UML Expressions.
 * UML Expressions maintain two lists ; one for the languages, and another one
 * for the expression bodies. These lists should be coherent. This editor
 * ensures that operations on the language list will not break the coherence
 * with the bodies list. For example, when a language is deleted, the
 * associated body is deleted as well.
 *
 * @author Camille Letavernier
 *
 * @see ExpressionLanguageEditor
 */
// TODO : Check support for Ctrl+Z (Is there one single command executed ?)
// TODO : Check listeners on observables (If there is an external modification, is the value correctly refreshed ?)
public class ExpressionEditor extends AbstractPropertyEditor implements Listener, ISelectionChangedListener, ICommitListener {

	private final ExpressionLanguageEditor languageEditor;

	private IObservableList bodies;

	private Expression currentExpression = null;

	private DynamicBodyEditor bodyEditor;

	public class ExpressionListChangeHandler implements IChangeListener {

		public void handleChange(ChangeEvent event) {
			if (event.getSource() == currentExpression) {
				bodyEditor.display(currentExpression);
				languageEditor.refreshValue();
			}
		}
	}

	ExpressionListChangeHandler expressionListChangeHandler;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget is created
	 * @param style
	 *            The style for the {@link DynamicBodyEditor}
	 */
	public ExpressionEditor(Composite parent, int style) {

		languageEditor = new ExpressionLanguageEditor(parent, SWT.NONE);

		GridLayout l = new GridLayout(2, false);
		parent.setLayout(l);

		GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, true);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;

		bodyEditor = new DynamicBodyEditor(parent, style);
		bodyEditor.setLayoutData(gridData);

		bodyEditor.addChangeListener(this);

		languageEditor.getViewer().addSelectionChangedListener(this);
		languageEditor.addCommitListener(this);

		expressionListChangeHandler = new ExpressionListChangeHandler();
		setEditor(languageEditor);
	}

	@Override
	public void setInput(DataSource input) {
		bodies = (IObservableList) input.getObservable("UML:OpaqueExpression:body"); //$NON-NLS-1$
		super.setInput(input);
	}

	@Override
	protected void doBinding() {
		super.doBinding();
		languageEditor.addCommitListener((ExpressionList) observableList);
		bodyEditor.setContext(input.getModelElement(propertyPath));

		if (languageEditor.getViewer().getTree().getItemCount() > 0) {
			Object firstItem = languageEditor.getViewer().getTree().getItem(0).getData();
			StructuredSelection selection = new StructuredSelection(firstItem);
			languageEditor.getViewer().setSelection(selection);
		}
	}

	/**
	 * @return the IObservableList for this propertyEditor, or null if it is not
	 *         available
	 */
	@Override
	protected IObservableList getInputObservableList() {
		if (observableList == null) {
			observableList = new ExpressionList(super.getInputObservableList(), bodies, expressionListChangeHandler);
		}

		return observableList;
	}

	public void handleEvent(Event event) {
		String newValue = bodyEditor.getValue();
		if (newValue == null) {
			return;
		}

		currentExpression.setBody(newValue);
		((ExpressionList) observableList).commit(bodyEditor);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();

		if (selection.isEmpty()) {
			bodyEditor.display(null);
		} else if (selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Expression newExpression = (Expression) sSelection.getFirstElement();
			if (newExpression != currentExpression) {
				// ((ExpressionList)observableList).commit(bodyEditor);
				currentExpression = newExpression;
				bodyEditor.display(currentExpression);
			}
		}

		// Force the layout of the widget after the new widget has been displayed
		bodyEditor.getParent().layout();
	}

	@Override
	protected void applyReadOnly(boolean readOnly) {
		languageEditor.setReadOnly(readOnly);
		bodyEditor.setReadOnly(readOnly);
	}

	public void commit(AbstractEditor editor) {
		// If the viewer has no selection, or if there is only one element,
		// automatically set the selection to the first element
		if (editor == languageEditor && observableList != null) {
			if (observableList.size() == 0) {
				languageEditor.getViewer().setSelection(StructuredSelection.EMPTY);
			} else if (observableList.size() == 1 || languageEditor.getViewer().getSelection().isEmpty()) {
				languageEditor.getViewer().setSelection(new StructuredSelection(observableList.get(0)));
			}
		}
	}
}
