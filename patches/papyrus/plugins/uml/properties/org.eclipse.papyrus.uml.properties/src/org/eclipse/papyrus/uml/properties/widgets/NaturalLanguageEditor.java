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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * A BodyEditor for the natural language.
 * This is a basic text-box.
 *
 * @author Camille Letavernier
 */
public class NaturalLanguageEditor implements BodyEditor {

	private StringEditor editor;

	private final Set<Listener> changeListeners = new HashSet<Listener>();

	private String currentValue;

	public void createWidget(Composite parent, int style) {
		editor = new StringEditor(parent, style | SWT.MULTI | SWT.WRAP) {

			@Override
			protected GridData getDefaultLayoutData() {
				GridData data = super.getDefaultLayoutData();
				data.grabExcessVerticalSpace = true;
				data.verticalAlignment = SWT.FILL;
				return data;
			}
		};

		editor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				Event event = new Event();
				currentValue = (String) NaturalLanguageEditor.this.editor.getValue();
				event.text = (String) NaturalLanguageEditor.this.editor.getValue();
				for (Listener listener : changeListeners) {
					listener.handleEvent(event);
				}
			}

		});

		editor.layout();
	}

	public void setInput(String value) {
		currentValue = value;

		IObservableValue observable = new AbstractObservableValue() {

			public Object getValueType() {
				return String.class;
			}

			@Override
			protected Object doGetValue() {
				return currentValue;
			}

			@Override
			protected void doSetValue(Object value) {
				if (value instanceof String) {
					currentValue = (String) value;
				}
			}

		};

		editor.setModelObservable(observable);
	}

	public void dispose() {
		editor.dispose();
		changeListeners.clear();
	}

	public void addChangeListener(Listener listener) {
		changeListeners.add(listener);
	}

	public void removeChangeListener(Listener listener) {
		changeListeners.remove(listener);
	}

	public String getValue() {
		return currentValue;
	}

	public void setReadOnly(boolean readOnly) {
		editor.setReadOnly(readOnly);
	}

	public void setContext(ModelElement context) {
		// Nothing
	}

}
