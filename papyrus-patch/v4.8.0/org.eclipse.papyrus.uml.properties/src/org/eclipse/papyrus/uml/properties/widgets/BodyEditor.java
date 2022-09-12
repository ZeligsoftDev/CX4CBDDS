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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * An interface representing a widget able to edit the body of an
 * expression.
 *
 * Unlike most editors, this editor takes two slots in a grid (One
 * slot for the languages, and another one for the body)
 *
 * @author Camille Letavernier
 *
 */
public interface BodyEditor {

	/**
	 * Creates a widget for editing the body of an expression
	 *
	 * @param parent
	 *            The SWT Composite in which the widgets will be displayed
	 * @param style
	 *            The style for this widget
	 */
	public void createWidget(Composite parent, int style);

	/**
	 * Sets the current value for this expression
	 *
	 * @param value
	 *            The initial value for the String being edited
	 */
	public void setInput(String value);

	/**
	 * Disposes this editor
	 */
	public void dispose();

	/**
	 * Adds a change listener for this editor
	 *
	 * @param listener
	 */
	public void addChangeListener(Listener listener);

	/**
	 * Removes a registered change listener from this editor
	 *
	 * @param listener
	 */
	public void removeChangeListener(Listener listener);

	/**
	 * @return the current value for this editor
	 */
	public String getValue();

	/**
	 * Marks this editor as read-only
	 *
	 * @param readOnly
	 */
	public void setReadOnly(boolean readOnly);

	/**
	 * Sets the context for this editor
	 *
	 * @param context
	 *            The ModelElement being edited
	 */
	public void setContext(ModelElement context);
}
