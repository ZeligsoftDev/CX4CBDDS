/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.editors.richtext.GenericRichTextEditor;
import org.eclipse.papyrus.infra.widgets.editors.richtext.GenericToolbarConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Nguyen
 * @since 2.0
 * 
 */
public class RichTextEditorCompositeWrapper extends Composite {

	/** The editor form. */
	protected ViewForm form;

	/** The embedded rich text control. */
	protected org.eclipse.nebula.widgets.richtext.RichTextEditor richTextEditor;

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the editor style
	 * @param basePath
	 *            the base path used for resolving links
	 */
	public RichTextEditorCompositeWrapper(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		init(this);
	}

	/**
	 * Initializes this editor.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the editor style
	 */
	protected void init(Composite parent) {
		try {
			form = new ViewForm(parent, SWT.BORDER | SWT.FLAT); // remove SWT.FLAT for the a blue border
			form.marginHeight = 0;
			form.marginWidth = 0;

			GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
			gridData.heightHint = 350;
			gridData.widthHint = 600;
			form.setLayoutData(gridData);

			// tagsEnabled = false;
			Composite richTextComposite = createRichTextComposite(form, SWT.BORDER);

			form.setContent(richTextComposite);
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Returns the form control.
	 * 
	 * @return the form control
	 */
	public Control getControl() {
		return form;
	}

	/**
	 * Returns the rich text control embedded within this editor.
	 */
	public org.eclipse.nebula.widgets.richtext.RichTextEditor getRichTextControl() {
		return richTextEditor;
	}

	/**
	 * Returns the rich text content.
	 * 
	 * @return the rich text content formatted in XHTML
	 */
	public String getText() {
		if (richTextEditor != null) {
			try {
				return richTextEditor.getText();
			} catch (Exception e) {
				// Silently fail
				// Activator.log.error(e);
				return ""; //$NON-NLS-1$
			}
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Sets the rich text content.
	 * 
	 * @param text
	 *            the rich text content in XHTML format
	 */
	public void setText(String text) {
		if (richTextEditor != null) {
			richTextEditor.setText(text);
		}
	}

	/**
	 * Returns an application specific property value.
	 * 
	 * @param key
	 *            the name of the property
	 * @return the value of the property or <code>null</code> if it has not
	 *         been set
	 */
	public Object getData(String key) {
		if (richTextEditor != null) {
			return richTextEditor.getData(key);
		}
		return null;
	}

	/**
	 * Sets an application specific property name and value.
	 * 
	 * @param key
	 *            the name of the property
	 * @param value
	 *            the new value for the property
	 */
	public void setData(String key, Object value) {
		if (richTextEditor != null) {
			richTextEditor.setData(key, value);
		}
	}

	/**
	 * Disposes the operating system resources allocated by this editor.
	 */
	public void disposeEditor() {
		if (richTextEditor != null) {
			richTextEditor.dispose();
			richTextEditor = null;
		}
	}

	/**
	 * Checks whether this control has been disposed.
	 * 
	 * @return <code>true</code> if this control is disposed successfully
	 */
	public boolean isEditorDisposed() {
		if (richTextEditor != null) {
			return richTextEditor.isDisposed();
		}
		return true;
	}

	/**
	 * Adds a listener to the collection of listeners who will be notified when
	 * keys are pressed and released within this editor.
	 * 
	 * @param listener
	 *            the listener which should be notified
	 */
	public void addKeyListener(KeyListener listener) {
		if (richTextEditor != null) {
			richTextEditor.addKeyListener(listener);
		}
	}

	/**
	 * Removes a listener from the collection of listeners who will be notified
	 * when keys are pressed and released within this editor.
	 * 
	 * @param listener
	 *            the listener which should no longer be notified
	 */
	public void removeKeyListener(KeyListener listener) {
		if (richTextEditor != null) {
			richTextEditor.removeKeyListener(listener);
		}
	}

	/**
	 * Adds a listener to the collection of listeners who will be notified when
	 * the content of this editor is modified.
	 * 
	 * @param listener
	 *            the listener which should be notified
	 */
	public void addModifyListener(ModifyListener listener) {
		if (richTextEditor != null) {
			richTextEditor.addModifyListener(listener);
		}
	}

	/**
	 * Removes a listener from the collection of listeners who will be notified
	 * when the content of this editor is modified.
	 * 
	 * @param listener
	 *            the listener which should no longer be notified
	 */
	public void removeModifyListener(ModifyListener listener) {
		if (richTextEditor != null) {
			richTextEditor.removeModifyListener(listener);
		}
	}

	/**
	 * Adds the listener to the collection of listeners who will be notifed when
	 * this editor is disposed.
	 * 
	 * @param listener
	 *            the listener which should be notified
	 */
	public void addDisposeListener(DisposeListener listener) {
		if (richTextEditor != null) {
			richTextEditor.addDisposeListener(listener);
		}
	}

	/**
	 * Removes a listener from the collection of listeners who will be notified
	 * when this editor is disposed.
	 * 
	 * @param listener
	 *            the listener which should no longer be notified
	 */
	public void removeDisposeListener(DisposeListener listener) {
		if (richTextEditor != null) {
			richTextEditor.removeDisposeListener(listener);
		}
	}

	/**
	 * 
	 * Adds a listener to the collection of listener who will be notified
	 * when focus events are generated for this editor
	 * 
	 * @param listener
	 *            the listener which should be notified
	 */
	public void addFocusListener(FocusListener listener) {
		if (richTextEditor != null) {
			richTextEditor.addFocusListener(listener);
		}
	}

	/**
	 * 
	 * Removes a listener to the collection of listener who will be notified
	 * when focus events are generated for this editor
	 * 
	 * @param listener
	 *            the listener which should be notified
	 */
	public void removeFocusListener(FocusListener listener) {
		if (richTextEditor != null) {
			richTextEditor.removeFocusListener(listener);
		}
	}

	/**
	 * Adds the listener to the collection of listeners who will be notifed when
	 * an event of the given type occurs within this editor.
	 * 
	 * @param eventType
	 *            the type of event to listen for
	 * @param listener
	 *            the listener which should be notified when the event occurs
	 */
	public void addListener(int eventType, Listener listener) {
		if (richTextEditor != null) {
			richTextEditor.addListener(eventType, listener);
		}
	}

	/**
	 * Removes the listener from the collection of listeners who will be notifed
	 * when an event of the given type occurs within this editor.
	 * 
	 * @param eventType
	 *            the type of event to listen for
	 * @param listener
	 *            the listener which should no longer be notified when the event
	 *            occurs
	 */
	public void removeListener(int eventType, Listener listener) {
		if (richTextEditor != null) {
			richTextEditor.removeListener(eventType, listener);
		}
	}

	/**
	 * Creates the editor tab folder.
	 * 
	 * @param parent
	 *            the parent control
	 * @param style
	 *            the style for the control
	 * @return a new editor toolbar
	 */
	protected Composite createRichTextComposite(Composite parent, int style) {
		Composite richTextComposite = new Composite(parent, SWT.FLAT | SWT.BOTTOM);
		FillLayout richTextCompositeLayout = new FillLayout();
		richTextComposite.setLayout(richTextCompositeLayout);

		richTextEditor = createRichTextEditor(richTextComposite, SWT.FLAT | SWT.BOTTOM);
		// fillToolBar();

		return richTextComposite;
	}

	/**
	 * 
	 * @param composite
	 * @param style
	 * @return
	 */
	protected org.eclipse.nebula.widgets.richtext.RichTextEditor createRichTextEditor(final Composite composite, final int style) {
		return new GenericRichTextEditor(composite, new GenericToolbarConfiguration(), SWT.FLAT | SWT.BOTTOM);
	}

	/**
	 * Disposes the operating system resources allocated by this editor.
	 */
	public void dispose() {
		if (richTextEditor != null) {
			richTextEditor.dispose();
			richTextEditor = null;
		}
	}

}
