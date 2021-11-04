/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus (CEA) - 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.Extension;

/**
 * An ObservableValue to edit the derived "isRequired" property for a Stereotype Extension
 * The isRequired property is reverse derived to retrieve the lower bound of the extensionEnd
 *
 * @author Camille Letavernier
 *
 * @deprecated since 4.3
 *             use {@link org.eclipe.papyrus.uml.properties.databinding.ExtensionRequiredObservableValue} instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 */
@Deprecated
public class ExtensionRequiredObservableValue extends AbstractObservableValue implements IChangeListener, IObserving {

	private Extension extension;

	private MultiplicityObservableValue observable;

	private boolean currentValue;

	public ExtensionRequiredObservableValue(Extension extension, EditingDomain domain) {
		this.extension = extension;
		if (!this.extension.getOwnedEnds().isEmpty()) {
			observable = new MultiplicityObservableValue(this.extension.getOwnedEnds().get(0), domain);
			observable.addChangeListener(this);
		}
		currentValue = extension.isRequired();
	}

	@Override
	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return extension.isRequired();
	}

	@Override
	protected void doSetValue(Object value) {
		if (!(value instanceof Boolean)) {
			return;
		}

		Boolean required = (Boolean) value;

		if (extension.getOwnedEnds().isEmpty()) {
			Activator.log.warn("Unable to change the extension \"isRequired\" property"); //$NON-NLS-1$
		}

		observable.setValue(required ? MultiplicityParser.ONE : MultiplicityParser.OPTIONAL);
		currentValue = required;
	}

	@Override
	public Object getObserved() {
		return extension;
	}

	@Override
	public void dispose() {
		observable.removeChangeListener(this);
		observable.dispose();
		observable = null;
		super.dispose();
	}

	@Override
	public void handleChange(ChangeEvent event) {
		final boolean oldValue = currentValue;
		final boolean newValue = doGetValue();
		currentValue = newValue;
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
