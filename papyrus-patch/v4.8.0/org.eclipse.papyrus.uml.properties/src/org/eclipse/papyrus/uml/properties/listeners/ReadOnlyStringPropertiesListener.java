/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation, Bug 522124
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.listeners;

import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.infra.properties.ui.listeners.IPropertiesListener;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;

/**
 * PropertiesListener to set readonly an editor based on the value of a String input.
 * 
 * @since 3.0
 */
public class ReadOnlyStringPropertiesListener implements IPropertiesListener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final AbstractPropertyEditor editor, final DataSource input, final Set<String> listeningPropertyPaths) {
		boolean isReadOnly = false;
		for (String propertyPath : listeningPropertyPaths) {
			IObservable observable = input.getObservable(propertyPath);

			if (observable instanceof IObservableValue<?>) {
				Object value = ((IObservableValue) observable).getValue();

				if (value instanceof String && !((String) value).isEmpty()) {
					isReadOnly = true;
				}
			}
		}

		editor.setReadOnly(isReadOnly);
	}

}
