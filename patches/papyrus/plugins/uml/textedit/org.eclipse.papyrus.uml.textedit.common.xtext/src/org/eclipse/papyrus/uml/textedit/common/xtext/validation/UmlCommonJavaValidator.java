/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.common.xtext.validation;

import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.xtext.validation.Check;


/**
 *
 * This validator provides :
 * <ul>
 * <li>a method to validate the fields</li>
 * <li>others methods to manipulate easily the edited element in the XText Editor</li>
 * </ul>
 *
 */
public class UmlCommonJavaValidator extends AbstractUmlCommonJavaValidator {


	/**
	 * boolean to know if the multiplicity is correct or not!
	 * this variable must be static
	 */
	protected static boolean valid_MultiplicityRule = true;

	/**
	 *
	 * @return
	 *         <code>true</code> if the validation is OK
	 */
	public boolean validate() {
		return true;
	}

	/**
	 * Custom validation for multiplicities. Raises an error in the case where the lower bound is upper than the upper bound.
	 *
	 */
	@Check
	public void checkMultiplicityRule(org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule rule) {
		int lowerValue = 0;
		int upperValue = 0;
		String errorMessage = "The upper bound of a multiplicity cannot be lower than the lower bound."; //$NON-NLS-1$
		try {
			if (rule.getBounds().size() == 2) {
				lowerValue = rule.getBounds().get(0).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(0).getValue()); //$NON-NLS-1$
				upperValue = rule.getBounds().get(1).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(1).getValue()); //$NON-NLS-1$
				if ((lowerValue == -1 && upperValue != -1) || (lowerValue > upperValue && upperValue != -1)) {
					error(errorMessage, UmlCommonPackage.eINSTANCE.getBoundSpecification_Value());
					valid_MultiplicityRule = false;
				} else {
					valid_MultiplicityRule = true;
				}
			}
		} catch (Exception e) {
			// An exception may be raised only in the case where the syntax for multiplicities is not respected.
			// No error needs to be generated (the syntax error is automatically handled by XText)
		}
	}
}
