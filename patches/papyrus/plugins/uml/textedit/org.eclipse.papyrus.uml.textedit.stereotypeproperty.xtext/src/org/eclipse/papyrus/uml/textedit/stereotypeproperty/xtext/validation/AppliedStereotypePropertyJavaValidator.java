/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypePropertyEditorUtil;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.ExpressionValueRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.validation.Check;

public class AppliedStereotypePropertyJavaValidator extends AbstractAppliedStereotypePropertyJavaValidator {

	protected static final String NOT_EXIST_DISPLAY = "This named element does not exist";

	public static final String NOT_EXIST = "AppliedStereotypeProperty.quickfix.NOT_EXIST";



	@Check
	public void checkAppliedStereotypePropertyRule_property(AppliedStereotypePropertyRule appliedStereotypePropertyRule) {
		if (appliedStereotypePropertyRule.getValue() != null) {
			ExpressionValueRule expressionRoot = appliedStereotypePropertyRule.getValue();
			if (expressionRoot.getExpression() != null) {
				Expression valueSpecification = expressionRoot.getExpression();
				if (valueSpecification != null) {
					AppliedStereotypeProperty contextElement = (AppliedStereotypeProperty) ContextElementUtil.
							getContextElement(appliedStereotypePropertyRule.eResource());
					if (!this.canExpressionResolve(contextElement, valueSpecification)) {
						error(NOT_EXIST_DISPLAY, AppliedStereotypePropertyPackage.eINSTANCE.getAppliedStereotypePropertyRule_Value());
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param context
	 * @param specification
	 * @return
	 */
	private boolean canExpressionResolve(AppliedStereotypeProperty context, Expression specification) {
		boolean canResolve = false;
		Element scope = context.getBaseElement();
		Type type = context.getStereotypeProperty().getType();
		int upperBound = context.getStereotypeProperty().getUpper();
		if (AppliedStereotypePropertyEditorUtil.getLabel(context).equals("=null")) {
			canResolve = true;
		} else {
			if (type != null) {
				/* 1. Try to resolve */
				List<?> resolvedValues = null;
				if (type instanceof PrimitiveType) {
					resolvedValues = AppliedStereotypePropertyEditorUtil.resolvePrimitiveValue(specification);
				} else if (type instanceof Enumeration) {
					List<NamedElement> candidates = new ArrayList<NamedElement>(((Enumeration) type).getMembers());
					candidates.removeAll(((Enumeration) type).getImportedMembers());
					resolvedValues = AppliedStereotypePropertyEditorUtil.resolveEnumerationLiteralValue(specification, candidates);
				} else if (type instanceof Element) {
					resolvedValues = AppliedStereotypePropertyEditorUtil.resolveReferenceValue(specification, scope);
				}
				/* 2. Analyze result */
				if (resolvedValues != null) {
					if (!resolvedValues.isEmpty()) {
						if (upperBound == 1) {
							if (upperBound == resolvedValues.size()) {
								canResolve = true;
							}
						} else {
							canResolve = true;
						}
					}
				} else {
					canResolve = true;
				}
			}
		}
		return canResolve;
	}
}
