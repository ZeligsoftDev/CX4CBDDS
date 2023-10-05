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

package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.contribution;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.commands.MultiplicityLowerValueSetCommand;

/**
 * This class allow to define a direct editor configuration for the multiplicity lower value (with allow to redefine the set command for the specific integer value.
 */
public class MultiplicityLowerValueSpecificationXtextDirectEditorConfiguration extends ValueSpecificationXtextDirectEditorConfiguration {

	/**
	 * Constructor.
	 */
	public MultiplicityLowerValueSpecificationXtextDirectEditorConfiguration() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration#getParseCommand(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected ICommand getParseCommand(final EObject initialValue, final EObject xtextObject) {
		ICommand result = null;
		if (objectToEdit instanceof EObject && null != structuralFeature) {
			// If the xtext object is not null, that means the xtext was already parsed
			if (null == xtextObject) {
				result = MultiplicityLowerValueSetCommand.getInstance().createSetCommand(getInjector(), (EObject) objectToEdit, structuralFeature, xtextStringValue, getDefaultLanguages());
			} else {
				result = MultiplicityLowerValueSetCommand.getInstance().getParseCommand((EObject) objectToEdit, structuralFeature, xtextObject, xtextStringValue, getDefaultLanguages());
			}
		}
		return result;
	}

}
