/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.services.edit.ui.databinding.AggregatedPapyrusObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.CommandBasedObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;

/**
 * An Abstract Class for Papyrus Command-based observable values
 *
 * @author Camille Letavernier
 * @since 3.3
 *
 */
public abstract class AbstractUMLAggregatedObservableValue extends ReferenceCountedObservable.Value implements AggregatedObservable, CommandBasedObservableValue {

	protected EditingDomain domain;

	protected AbstractUMLAggregatedObservableValue(EditingDomain domain) {
		this.domain = domain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; // The observable cannot be aggregated
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasDifferentValues() {
		return false;
	}
}
