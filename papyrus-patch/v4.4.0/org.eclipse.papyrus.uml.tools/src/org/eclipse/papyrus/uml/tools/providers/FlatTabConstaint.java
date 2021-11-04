/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collection;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.widgets.SelectorDialogTabReader;
import org.eclipse.papyrus.infra.widgets.providers.IDependableContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IFlattenableContentProvider;

/**
 * Contraint for flat tabulation of selector tab. Match if the dependable content provider of {@link FlatTabUMLLabelProvider} is not flat.
 * 
 * @since 3.0
 */
public class FlatTabConstaint implements Constraint {

	/**
	 * Constructor.
	 */
	public FlatTabConstaint() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.Constraint#setConstraintDescriptor(org.eclipse.papyrus.infra.constraints.ConstraintDescriptor)
	 */
	@Override
	public void setConstraintDescriptor(final ConstraintDescriptor descriptor) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.Constraint#match(java.util.Collection)
	 */
	@Override
	public boolean match(Collection<?> selection) {
		boolean match = false;
		if (!selection.isEmpty() && selection instanceof Set) {
			// Get the id of the tab
			Object id = ((Set) selection).toArray()[0];
			if (id instanceof String) {
				ITreeContentProvider iContentProvider = SelectorDialogTabReader.getInstance().getContentProviders().get(id);
				if (iContentProvider instanceof IDependableContentProvider) {
					ITreeContentProvider contentProvider = ((IDependableContentProvider) iContentProvider).getContentProvider();
					if (contentProvider instanceof IFlattenableContentProvider) {
						IFlattenableContentProvider flattenableContentProvider = (IFlattenableContentProvider) contentProvider;
						match = !flattenableContentProvider.isFlat();
					}
				}
			}
		}
		return match;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.Constraint#getDisplayUnit()
	 */
	@Override
	public DisplayUnit getDisplayUnit() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.Constraint#overrides(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 */
	@Override
	public boolean overrides(final Constraint constraint) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.Constraint#getDescriptor()
	 */
	@Override
	public ConstraintDescriptor getDescriptor() {
		return null;
	}

}
