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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.uml.alf.BooleanLiteralExpression;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.LiteralExpression;
import org.eclipse.papyrus.uml.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.NaturalLiteralExpression;
import org.eclipse.papyrus.uml.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.SequenceExpressionList;
import org.eclipse.papyrus.uml.alf.StringLiteralExpression;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class AppliedStereotypePropertyEditorUtil {

	private static final String VALUE_NULL = "= null"; //$NON-NLS-1$

	private static final String EQUAL = "="; //$NON-NLS-1$

	private static final String BRAKET_END = "}"; //$NON-NLS-1$

	private static final String HOOK_END = "]"; //$NON-NLS-1$

	private static final String BRACKET_BEGIN = "{"; //$NON-NLS-1$

	private static final String HOOK_BEGIN = "["; //$NON-NLS-1$

	/**
	 * this method is used to display the content of stereotype application property to be edited
	 *
	 * @param appliedStereotypeProperty
	 * @return a string
	 */
	public static String getLabel(AppliedStereotypeProperty appliedStereotypeProperty) {

		final Property property = appliedStereotypeProperty.getStereotypeProperty();
		final Stereotype stereotype = appliedStereotypeProperty.getStereotype();
		final Element umlElement = appliedStereotypeProperty.getBaseElement();

		String result = StereotypeUtil.displayPropertyValueToEdit(stereotype, property, umlElement, ""); //$NON-NLS-1$

		// first replace [ by {
		result = result.replace(HOOK_BEGIN, BRACKET_BEGIN);
		result = result.replace(HOOK_END, BRAKET_END);
		if (!(result.contains(EQUAL))) {
			result = result + VALUE_NULL;
		}
		// strip property from string (we are sure that result contains EQUAL due to previous check)
		result = result.substring(result.indexOf(EQUAL));

		if (result.contains(VALUE_NULL)) {
			return result;

		}
		if ((StringConstants.INTEGER.equals(property.getType().getName()))) {
			result = result.replace("\"", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if ((StringConstants.BOOLEAN.equals(property.getType().getName()))) {
			result = result.replace("\"", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

		return result;
	}

	/**
	 * get a list of all possible objects in a model that can be a value for a Applied stereotype property
	 *
	 * @param appliedStereotypeProperty
	 * @return an array of object
	 */
	public static Object[] getPossibleElements(AppliedStereotypeProperty appliedStereotypeProperty) {
		EStructuralFeature foundStructuralFeature = null;
		Iterator<EStructuralFeature> iterator = appliedStereotypeProperty.getStereotypeApplication().eClass().getEAllStructuralFeatures().iterator();
		while (iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = iterator.next();
			if (eStructuralFeature.getName().equals(appliedStereotypeProperty.getStereotypeProperty().getName())) {
				foundStructuralFeature = eStructuralFeature;
			}
		}
		UMLContentProvider umlContentProvider = new UMLContentProvider(appliedStereotypeProperty.getStereotypeApplication(), foundStructuralFeature, appliedStereotypeProperty.getStereotype());
		HierarchicToFlatContentProvider treeToFlatContentProvider = new HierarchicToFlatContentProvider(umlContentProvider);
		// TODO: result of content provider often unusable (since empty, even if there are matches)
		return treeToFlatContentProvider.getElements();
	}

	/**
	 * Compute the primitive value(s) corresponding to the value specification
	 * 
	 * @param valueSpecification
	 *            the value specified for the property
	 * @return result
	 *         the corresponding concrete value(s)
	 */
	public static List<Object> resolvePrimitiveValue(Expression valueSpecification) {
		List<Object> result = new ArrayList<Object>();
		if (valueSpecification instanceof SequenceConstructionExpression) {
			SequenceConstructionExpression sequence = (SequenceConstructionExpression) valueSpecification;
			if (sequence.getElements() instanceof SequenceExpressionList) {
				SequenceExpressionList expList = (SequenceExpressionList) sequence.getElements();
				for (Expression expression : expList.getElement()) {
					result.addAll(resolvePrimitiveValue(expression));
				}
			}
		} else {
			if (valueSpecification instanceof LiteralExpression) {
				if (valueSpecification instanceof StringLiteralExpression) {
					result.add(((StringLiteralExpression) valueSpecification).getImage());
				} else if (valueSpecification instanceof BooleanLiteralExpression) {
					result.add(Boolean.parseBoolean(((BooleanLiteralExpression) valueSpecification).getImage()));
				} else if (valueSpecification instanceof NaturalLiteralExpression) {
					result.add(Integer.parseInt(((NaturalLiteralExpression) valueSpecification).getImage()));
				}
			}
		}
		return result;
	}

	/**
	 * Compute the enumeration literal value(s) corresponding depicted by the provided expression.
	 * The resolution rely on a list of candidates which basically are all the literal available (inherited)
	 * are included
	 * 
	 * @param expression
	 *            the expression depicting the enumeration literal(s) to resolve
	 * 
	 * @param candidates
	 *            the list of enumeration literal on which the expression may resolve
	 * 
	 * @return result
	 *         the list of enumeration literal that have been resolved from the expression
	 */
	public static List<EnumerationLiteral> resolveEnumerationLiteralValue(Expression expression, List<NamedElement> candidates) {
		List<EnumerationLiteral> result = new ArrayList<EnumerationLiteral>();
		;
		if (expression instanceof SequenceConstructionExpression) {
			SequenceConstructionExpression sequence = (SequenceConstructionExpression) expression;
			if (sequence.getElements() instanceof SequenceExpressionList) {
				SequenceExpressionList expList = (SequenceExpressionList) sequence.getElements();
				for (Expression exp : expList.getElement()) {
					result.addAll(resolveEnumerationLiteralValue(exp, candidates));
				}
			}
		} else {
			if (expression instanceof NameExpression) {
				NameExpression nameExpression = (NameExpression) expression;
				String name = nameExpression.getName().getUnqualifiedName().getName();
				int i = 0;
				EnumerationLiteral literal = null;
				while (i < candidates.size() && literal == null) {
					literal = (EnumerationLiteral) candidates.get(i);
					if (!literal.getName().equals(name)) {
						literal = null;
					}
					i++;
				}
				if (literal != null) {
					result.add(literal);
				}
			}
		}
		return result;
	}

	/**
	 * Resolve a reference to an existing model element, this reference being described through an expression
	 * 
	 * @param expression
	 *            the expression depicting the reference to element that need to be resolved
	 * 
	 * @return references
	 *         the list of references to which the expression resolves
	 */
	public static List<NamedElement> resolveReferenceValue(Expression expression, Element scope) {
		List<NamedElement> references = new ArrayList<NamedElement>();
		if (expression instanceof SequenceConstructionExpression) {
			SequenceConstructionExpression sequence = (SequenceConstructionExpression) expression;
			if (sequence.getElements() instanceof SequenceExpressionList) {
				SequenceExpressionList expList = (SequenceExpressionList) sequence.getElements();
				for (Expression exp : expList.getElement()) {
					references.addAll(resolveReferenceValue(exp, scope));
				}
			}
		} else {
			if (expression instanceof NameExpression) {
				NameExpression nameExpression = (NameExpression) expression;
				String name = nameExpression.getName().getPathName();
				List<NamedElement> potentialReferences = NameResolutionUtils.getNamedElements(name, scope, null);
				NamedElement reference = null;
				if (potentialReferences.size() >= 1) {
					reference = potentialReferences.get(0); /* if multiple matches then we take the first one */
					references.add(reference);
				}
			}
		}
		return references;
	}
}
