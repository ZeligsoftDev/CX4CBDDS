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

import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

/**
 * A "Null" implementation of the BodyEditor
 *
 * @author Camille Letavernier
 *
 */
public class NullBodyEditor implements BodyEditor {

	private Label messageLabel;

	public void createWidget(Composite parent, int style) {
		messageLabel = new Label(parent, style | SWT.WRAP);
		messageLabel.setText("Please select a language first.");
	}

	public void setInput(String value) {
		// Ignore
	}

	public void dispose() {
		if (messageLabel != null) {
			messageLabel.dispose();
			messageLabel = null;
		}
	}

	public void addChangeListener(Listener listener) {
		// Ignore
	}

	public void removeChangeListener(Listener listener) {
		// Ignore
	}

	public String getValue() {
		return null; // Ignore
	}

	public void setReadOnly(boolean readOnly) {
		// Ignore
	}

	public void setContext(ModelElement context) {
		// Ignore
	}

}
