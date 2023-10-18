/*******************************************************************************
 * Copyright (c) 2011, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Form;

public class FormMessageManager {
	/** The form for which we manage messages. */
	private final Form managedForm;

	/**
	 * Instantiates our message manager given its target form.
	 * 
	 * @param managedForm
	 *            The form for which we should manage messages.
	 */
	public FormMessageManager(Form managedForm) {
		this.managedForm = managedForm;
	}

	public void addMessage(Object key, String message, int type) {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().addMessage(key, message, null, type);
		}
	}

	public void addMessage(String key, String message, int type, Control control) {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().addMessage(key, message, null, type, control);
		}
	}

	public void removeAllMessages() {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().removeAllMessages();
		}
	}

	public void removeMessage(Object key) {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().removeMessage(key);
		}
	}

	public void removeMessages(Control control) {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().removeMessages(control);
		}
	}

	public void setDecorationPosition(int position) {
		if (!managedForm.isDisposed()) {
			managedForm.getMessageManager().setDecorationPosition(position);
		}
	}
}
