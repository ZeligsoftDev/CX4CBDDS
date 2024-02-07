/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.XtextFactory;

/**
 * AbstractGrammarResource provides the common functionality for a derived GrammarResource that serializes the *.xtextbin
 * Xtext grammar.
 */
public abstract class AbstractGrammarResource extends XMIResourceImpl
{
	private static final Method ABSTRACT_ELEMENT_SET_FIRST_SET_PREDICATED_METHOD;

	static {
		Method abstractElement_setFirstSetPredicated_Method = null;
		try {
			abstractElement_setFirstSetPredicated_Method = AbstractElement.class.getMethod("setFirstSetPredicated", boolean.class);
		} catch (Throwable exception) {
			// Ignore - method not available in Xtext < 2.6.
		}
		ABSTRACT_ELEMENT_SET_FIRST_SET_PREDICATED_METHOD = abstractElement_setFirstSetPredicated_Method;
	}

	protected static void addAnnotation(/*@NonNull*/ AbstractRule rule, @NonNull String name) {
		try {
			@SuppressWarnings("null")@NonNull Annotation annotation = XtextFactory.eINSTANCE.createAnnotation();
			annotation.setName(name);
			rule.getAnnotations().add(annotation);
		}
		catch (Throwable t) {
			// Igbnore annotations are recent and cosmetic.
		}
	}

	protected static @NonNull Action createAction(@Nullable String feature, @Nullable String operator, @NonNull TypeRef typeRef) {
		@SuppressWarnings("null")@NonNull Action action = XtextFactory.eINSTANCE.createAction();
		action.setFeature(feature);
		action.setOperator(operator);
		action.setType(typeRef);
		return action;
	}

	protected static @NonNull Alternatives createAlternatives(AbstractElement... elements) {
		@SuppressWarnings("null")@NonNull Alternatives alternatives = XtextFactory.eINSTANCE.createAlternatives();
		List<AbstractElement> alternativesElements = alternatives.getElements();
		for (AbstractElement element : elements) {
			alternativesElements.add(element);
		}
		return alternatives;
	}

	protected static @NonNull Assignment createAssignment(@NonNull String feature, @NonNull String operator, @NonNull AbstractElement terminal) {
		@SuppressWarnings("null")@NonNull Assignment assignment = XtextFactory.eINSTANCE.createAssignment();
		assignment.setFeature(feature);
		assignment.setOperator(operator);
		assignment.setTerminal(terminal);
		return assignment;
	}

	protected static @NonNull CharacterRange createCharacterRange(@NonNull Keyword left, @NonNull Keyword right) {
		@SuppressWarnings("null")@NonNull CharacterRange characterRange = XtextFactory.eINSTANCE.createCharacterRange();
		characterRange.setLeft(left);
		characterRange.setRight(right);
		return characterRange;
	}

	protected static @NonNull CrossReference createCrossReference(@NonNull TypeRef typeRef, @NonNull AbstractElement terminal) {
		@SuppressWarnings("null")@NonNull CrossReference crossReference = XtextFactory.eINSTANCE.createCrossReference();
		crossReference.setType(typeRef);
		crossReference.setTerminal(terminal);
		return crossReference;
	}

	protected static @NonNull EnumRule createEnumRule(@NonNull String name, @NonNull TypeRef typeRef) {
		@SuppressWarnings("null")@NonNull EnumRule enumRule = XtextFactory.eINSTANCE.createEnumRule();
		enumRule.setName(name);
		enumRule.setType(typeRef);
		return enumRule;
	}

	protected static @NonNull EnumLiteralDeclaration createEnumLiteral(Keyword keyword, EEnumLiteral eEnumLiteral) {
		@SuppressWarnings("null")@NonNull EnumLiteralDeclaration enumLiteral = XtextFactory.eINSTANCE.createEnumLiteralDeclaration();
		enumLiteral.setLiteral(keyword);
		enumLiteral.setEnumLiteral(eEnumLiteral);
		return enumLiteral;
	}

	protected static @NonNull Grammar createGrammar(@NonNull String name) {
		@SuppressWarnings("null")@NonNull Grammar grammar = XtextFactory.eINSTANCE.createGrammar();
		grammar.setName(name);
		return grammar;
	}

	protected static @NonNull Group createGroup(AbstractElement... elements) {
		@SuppressWarnings("null")@NonNull Group group = XtextFactory.eINSTANCE.createGroup();
		List<AbstractElement> groupElements = group.getElements();
		for (AbstractElement element : elements) {
			groupElements.add(element);
		}
		return group;
	}

	protected static @NonNull Keyword createKeyword(String value) {
		@SuppressWarnings("null")@NonNull Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
		keyword.setValue(value);
		return keyword;
	}

	protected static @NonNull NegatedToken createNegatedToken(@NonNull AbstractElement terminal) {
		@SuppressWarnings("null")@NonNull NegatedToken negatedToken = XtextFactory.eINSTANCE.createNegatedToken();
		negatedToken.setTerminal(terminal);
		return negatedToken;
	}

	protected static @NonNull ParserRule createParserRule(@NonNull String name, @NonNull TypeRef typeRef) {
		@SuppressWarnings("null")@NonNull ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(name);
		parserRule.setType(typeRef);
		return parserRule;
	}

	protected static @NonNull ReferencedMetamodel createReferencedMetamodel(EPackage ePackage, String alias) {
		@SuppressWarnings("null")@NonNull ReferencedMetamodel referencedMetamodel = XtextFactory.eINSTANCE.createReferencedMetamodel();
		referencedMetamodel.setEPackage(ePackage);
		referencedMetamodel.setAlias(alias);
		return referencedMetamodel;
	}

	protected static @NonNull RuleCall createRuleCall(/*@NonNull*/ AbstractRule rule) {
		@SuppressWarnings("null")@NonNull RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		ruleCall.setRule(rule);
		return ruleCall;
	}

	protected static @NonNull TypeRef createTypeRef(AbstractMetamodelDeclaration metamodel, EClassifier eClassifier) {
		@SuppressWarnings("null")@NonNull TypeRef typeRef = XtextFactory.eINSTANCE.createTypeRef();
		typeRef.setMetamodel(metamodel);
		typeRef.setClassifier(eClassifier);
		return typeRef;
	}

	protected static @NonNull TerminalRule createTerminalRule(@NonNull String name, @NonNull TypeRef typeRef) {
		@SuppressWarnings("null")@NonNull TerminalRule terminalRule = XtextFactory.eINSTANCE.createTerminalRule();
		terminalRule.setName(name);
		terminalRule.setType(typeRef);
		return terminalRule;
	}

	protected static @NonNull UnorderedGroup createUnorderedGroup(AbstractElement... elements) {
		@SuppressWarnings("null")@NonNull UnorderedGroup uGroup = XtextFactory.eINSTANCE.createUnorderedGroup();
		List<AbstractElement> groupElements = uGroup.getElements();
		for (AbstractElement element : elements) {
			groupElements.add(element);
		}
		return uGroup;
	}
	protected static @NonNull UntilToken createUntilToken(@NonNull AbstractElement terminal) {
		@SuppressWarnings("null")@NonNull UntilToken untilToken = XtextFactory.eINSTANCE.createUntilToken();
		untilToken.setTerminal(terminal);
		return untilToken;
	}

	protected static @NonNull Wildcard createWildcard() {
		@SuppressWarnings("null")@NonNull Wildcard wildcard = XtextFactory.eINSTANCE.createWildcard();
		return wildcard;
	}

	protected static <T extends AbstractElement> T setCardinality(@NonNull String cardinality, @NonNull T abstractElement) {
		abstractElement.setCardinality(cardinality);
		return abstractElement;
	}

	protected static <T extends AbstractElement> T setFirstSetPredicated(@NonNull T abstractElement) {
		if (ABSTRACT_ELEMENT_SET_FIRST_SET_PREDICATED_METHOD != null) {
			try {
				ABSTRACT_ELEMENT_SET_FIRST_SET_PREDICATED_METHOD.invoke(abstractElement, true);
			} catch (Exception e) {
				// Ignore - never happens
			}
		}
		return abstractElement;
	}

	protected static <T extends AbstractElement> T setPredicated(@NonNull T abstractElement) {
		abstractElement.setPredicated(true);
		return abstractElement;
	}

	protected AbstractGrammarResource(URI uri) {
		super(uri);
	}

	/**
	 * Overridden to inhibit entry of the static shared instance in any ResourceSet.
	 */
	@Override
	public final NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		return notifications;
	}

	/**
	 * Overridden to inhibit unloading of the static shared instance.
	 */
	@Override
	protected final void doUnload() {}
}
