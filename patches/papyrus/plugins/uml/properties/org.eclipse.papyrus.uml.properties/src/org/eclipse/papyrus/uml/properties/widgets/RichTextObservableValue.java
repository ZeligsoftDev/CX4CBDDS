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

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * An ObservableValue for Rich Text field.
 *
 * @author Mickaël ADAM
 * @since 2.0
 */
@SuppressWarnings("rawtypes")
public class RichTextObservableValue extends AbstractObservableValue implements Listener, FocusListener, ModifyListener, KeyListener {

	/** The rich text editor. */
	private RichTextEditorCompositeWrapper richTextEditor;

	/** The event type. */
	private int eventType;

	/** The current value. */
	private Object currentValue;

	/** If the Text field may represent more than one value, use an AggregatedObservable May be null. */
	protected AggregatedObservable modelProperty;

	/**
	 * Constructor.
	 *
	 * @param richTextEditor
	 *            the rich text editor to observe
	 * @param modelProperty
	 *            The model IObservableValue
	 * @param eventType
	 *            The eventType to listen to. When the event is fired by the
	 *            widget, this IObservableValue will fire a ChangeEvent
	 */
	public RichTextObservableValue(RichTextEditorCompositeWrapper richTextEditor, IObservableValue modelProperty, int eventType) {
		this.richTextEditor = richTextEditor;
		this.eventType = eventType;
		if (modelProperty instanceof AggregatedObservable) {
			this.modelProperty = (AggregatedObservable) modelProperty;
		}
		// add listener on the browser editor
		this.richTextEditor.addListener(eventType, this);
		this.richTextEditor.addFocusListener(this);
		this.richTextEditor.addModifyListener(this);
		this.richTextEditor.addKeyListener(this);
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 *
	 * @return
	 */
	public Object getValueType() {
		return String.class;
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 *
	 * @return
	 */
	@Override
	protected Object doGetValue() {
		if (UnchangedObject.instance.toString().equals(richTextEditor.getText())) {
			return null;
		} else {
			return richTextEditor.getText();
		}
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 *
	 * @param value
	 */
	@Override
	protected void doSetValue(Object value) {
		if (modelProperty != null && modelProperty.hasDifferentValues()) {
			this.richTextEditor.setText(UnchangedObject.instance.toString());
			this.currentValue = UnchangedObject.instance;
		} else {
			if (value instanceof String) {
				richTextEditor.setText((String) value);
				this.currentValue = value;
			} else if (value == null) {
				this.richTextEditor.setText(""); //$NON-NLS-1$
				this.currentValue = null;
			}
		}
	}

	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 *
	 * @param event
	 */
	public void handleEvent(Event event) {
		valueChanged(event);
	}

	/**
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 *
	 */
	@Override
	public synchronized void dispose() {
		richTextEditor.removeListener(eventType, this);
		richTextEditor.removeFocusListener(this);
		richTextEditor.removeModifyListener(this);
		richTextEditor.removeKeyListener(this);
		super.dispose();
	}


	public void focusGained(FocusEvent e) {
		// Nothing
	}


	public void focusLost(FocusEvent e) {
		valueChanged(null);
	}


	public void modifyText(ModifyEvent e) {
		valueChanged(null);
	}

	public void updateReferences() {
		doSetValue(this.currentValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void valueChanged(Event event) {
		final Object oldValue = currentValue;
		final Object newValue = getValue();

		if (newValue == null) {
			return;
		}

		if (currentValue == null || !currentValue.equals(newValue)) {
			currentValue = newValue;
			if (event == null || (eventType & event.type) != 0) {
				fireValueChange(new ValueDiff() {

					@Override
					public Object getOldValue() {
						return oldValue;
					}

					@Override
					public Object getNewValue() {
						return newValue;
					}
				});
			}
		}
	}


	public void keyPressed(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {
		// Modify events handling by the rich text editor is inconsistent for deletions before anything has been added
		if (e.keyCode == SWT.DEL || e.keyCode == SWT.BS ||
				((e.stateMask & SWT.MOD1) != 0 && e.character == 'x')) {
			valueChanged(null);
		}
	}


}
