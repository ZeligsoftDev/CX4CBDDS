/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.widgets.editors.MultiplicityDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

/**
 * The extended multiplicity dialog which allow to redefine the {@link #canEditStringCombo()} method dependent of lower and upper ValueSpecification type.
 */
public class ExtendedMultiplicityDialog extends MultiplicityDialog {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The style.
	 */
	public ExtendedMultiplicityDialog(final Composite parent, final int style) {
		this(parent, style, null);
	}

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The style.
	 * @param preferenceStore
	 *            The preference store.
	 */
	public ExtendedMultiplicityDialog(final Composite parent, final int style, final IPreferenceStore preferenceStore) {
		super(parent, style, preferenceStore);
	}

	/**
	 * Redefine this method to manage the lower and upper ValueSpecification type. {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.MultiplicityDialog#canEditStringCombo()
	 */
	@Override
	protected boolean canEditStringCombo() {
		boolean result = super.canEditStringCombo();
		if (null != lowerValueEditor.getValue()) {
			if (!(lowerValueEditor.getValue() instanceof LiteralInteger)) {
				result = false;
			}
		}

		if (null != upperValueEditor.getValue()) {
			if (!(upperValueEditor.getValue() instanceof LiteralUnlimitedNatural)) {
				result = false;
			}
		}
		return result;
	}

}
