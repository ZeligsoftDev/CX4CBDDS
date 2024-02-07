/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Constraint for OCL Direct Editor.
 * 
 * @author Gabriel Pascual
 *
 */
public class OCLDirectEditorConstraint implements IDirectEditorConstraint {

	/** The Constant OCL_LANGAGE_CONSTRAINT. */
	private static final String OCL_LANGUAGE_CONSTRAINT = "OCL Language Constraint"; //$NON-NLS-1$

	/** The Constant OCL_LANGAGE_BODY. */
	private static final String OCL_LANGUAGE_BODY = "OCL"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 */
	public OCLDirectEditorConstraint() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#getLabel()
	 *
	 * @return
	 */
	public String getLabel() {
		return OCL_LANGUAGE_CONSTRAINT;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConstraint#appliesTo(java.lang.Object)
	 *
	 * @param selection
	 * @return
	 */
	public boolean appliesTo(Object selection) {
		boolean appliedConstraint = false;
		EObject resolvedEObject = EMFHelper.getEObject(selection);
		if (resolvedEObject instanceof Constraint) {
			Constraint selectedConstraint = (Constraint) resolvedEObject;
			appliedConstraint = checkValueSpecification(selectedConstraint.getSpecification());
		}
		else if (resolvedEObject instanceof ValueSpecification) {
			appliedConstraint = checkValueSpecification((ValueSpecification) resolvedEObject);
		}
		return appliedConstraint;
	}
	
	/**
	 * check whether a value specification complies with OCL editor
	 * @param specification
	 * @return true, if either opaque-expression (empty or OCL as language) or a literal string
	 */
	public boolean checkValueSpecification(ValueSpecification specification) {
		if (specification instanceof OpaqueExpression) {
			return ((OpaqueExpression) specification).getBodies().isEmpty() || ((OpaqueExpression) specification).getLanguages().contains(OCL_LANGUAGE_BODY);
		}
		else {
			return specification instanceof LiteralString;
		}
	}
}
