/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.iterator.CollectIteration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.attributes.ImportCSAttribution;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.AbstractUnresolvedProxyMessageProvider;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.MessageBinder;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.ContextCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.attributes.LetExpCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.attributes.LetVariableCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigatingArgCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationOperatorCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialocl.attributes.ShadowPartCSAttribution;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;

public class EssentialOCLScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(EssentialOCLCSPackage.Literals.CONTEXT_CS, ContextCSAttribution.INSTANCE);
		registry.put(EssentialOCLCSPackage.Literals.LET_EXP_CS, LetExpCSAttribution.INSTANCE);
		registry.put(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS, LetVariableCSAttribution.INSTANCE);  // Needed for let deeply nested in Iterator/CollectionLiteral
		registry.put(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS, NavigatingArgCSAttribution.INSTANCE);
		registry.put(EssentialOCLCSPackage.Literals.INFIX_EXP_CS, NavigationOperatorCSAttribution.INSTANCE);
		registry.put(EssentialOCLCSPackage.Literals.SHADOW_PART_CS, ShadowPartCSAttribution.INSTANCE);
		CS2AS.addUnresolvedProxyMessageProvider(new PathElementCSUnresolvedProxyMessageProvider());
	}

	private static final class PathElementCSUnresolvedProxyMessageProvider extends AbstractUnresolvedProxyMessageProvider
	{
		private PathElementCSUnresolvedProxyMessageProvider() {
			super(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		}

		@Override
		public String getMessage(@NonNull EObject eObject, @NonNull String linkText) {
			PathElementCS csPathElement = (PathElementCS) eObject;
			PathNameCS pathName = csPathElement.getOwningPathName();
			List<@NonNull PathElementCS> pathElements = ClassUtil.nullFree(pathName.getOwnedPathElements());
			List<PathElementCS> path = pathElements;
			int index = path.indexOf(csPathElement);
			for (int i = 0; i < index; i++) {
				PathElementCS csElement = path.get(i);
				Element element = csElement.basicGetReferredElement();
				if ((element == null) || element.eIsProxy()) {
					return null;		// Suppress nested unresolved message
				}
			}
			ElementCS csContext = pathName.getContext();
			if (csContext == null) {
				csContext = (ElementCS) pathName.eContainer();
			}
			assert csContext != null;
			String messageTemplate;
			String typeText = null;
			String argumentText = null;
			ExpCS navigationArgument = null;
			Type sourceType = null;
			if ((index + 1) < path.size()) {
				messageTemplate = PivotMessagesInternal.UnresolvedNamespace_ERROR_;
				if (pathElements.size() > 0) {
					StringBuilder s = new StringBuilder();
					for (int i = 0; i < index; i++) {
						if (i > 0) {
							s.append("::");
						}
						s.append(pathElements.get(i));
					}
					typeText = s.toString();
				}
			}
			else if (csContext instanceof NameExpCS) {
				NameExpCS csNameExp = (NameExpCS)csContext;
				navigationArgument = csNameExp;
				RoundBracketedClauseCS csRoundBracketedClause = csNameExp.getOwnedRoundBracketedClause();
				if (csRoundBracketedClause != null) {
					argumentText = getOperationArguments(csRoundBracketedClause);
					List<NavigatingArgCS> arguments = csRoundBracketedClause.getOwnedArguments();
					if ((arguments.size() > 0) && (arguments.get(0).getRole() == NavigationRole.ITERATOR)) {
						messageTemplate = PivotMessagesInternal.UnresolvedIterationCall_ERROR_;
					}
					else {		// FIXME If e.g. self.unresolved() for a Class-valued self, csNameExp.getSourceTypeValue() != null -- is the 'static' diagnosis valid / helpful ?
						messageTemplate = /*csNameExp.getSourceTypeValue() != null ? PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_ :*/ PivotMessagesInternal.UnresolvedOperationCall_ERROR_;
					}
				}
				else {
					EClassifier elementType = CS2AS.getElementType(pathName);
					if (elementType == PivotPackage.Literals.PROPERTY) {
						messageTemplate = /*csNameExp.getSourceTypeValue() != null ? PivotMessagesInternal.UnresolvedStaticProperty_ERROR_ :*/ PivotMessagesInternal.UnresolvedProperty_ERROR_;
					}
					else {
						assert elementType == PivotPackage.Literals.ELEMENT;
						messageTemplate = /*csNameExp.getSourceTypeValue() != null ? PivotMessagesInternal.UnresolvedStaticElement_ERROR_ :*/ PivotMessagesInternal.UnresolvedElement_ERROR_;
					}
				}
				if (csNameExp.getSourceTypeValue() != null) {
					sourceType = csNameExp.getSourceTypeValue();
				}
				if (index > 0) {
					StringBuilder s = new StringBuilder();
					for (int i = 0; i < index; i++) {
						if (i > 0) {
							s.append("::");
						}
						s.append(ElementUtil.getTextName(pathElements.get(i)));
					}
					typeText = s.toString();
				}
			}
			else if (csContext instanceof TypeNameExpCS) {
				messageTemplate = PivotMessagesInternal.UnresolvedType_ERROR_;
			}
			else if (csContext instanceof TypedTypeRefCS) {
				messageTemplate = PivotMessagesInternal.UnresolvedType_ERROR_;
			}
			else if (csContext instanceof ExpCS) {
				navigationArgument = (ExpCS)csContext;
				messageTemplate = PivotMessagesInternal.UnresolvedProperty_ERROR_;
			}
			else if (csContext instanceof ImportCS) {
				return ImportCSAttribution.INSTANCE.getMessage(csContext, linkText);			// FIXME return a messageTemplate
			}
			else if (csContext instanceof ModelElementRefCS) {
				messageTemplate = "Unresolved ModelElement ''{0}''";
			}
			else {
				messageTemplate = "Unresolved ''{0}'' ''{1}''";
			}
			if (typeText == null) {
				assert messageTemplate != null;
				TypedElement source = null;
				ExpCS csSource = navigationArgument;
				OperatorExpCS csOperator = null;
				for (ExpCS aSource = csSource; aSource != null; ) {										// FIXME rewrite me
					csOperator = aSource.getLocalParent();
					if ((csOperator != null) && (csOperator.getSource() != aSource)) {
						csSource = csOperator.getSource();
						break;
					}
					EObject eContainer = aSource.eContainer();
					if (eContainer instanceof NavigatingArgCS) {
						aSource = ((NavigatingArgCS)eContainer).getOwningRoundBracketedClause().getOwningNameExp();
					}
					else if (eContainer instanceof InfixExpCS) {
						aSource = (InfixExpCS)eContainer;
					}
					else if (eContainer instanceof PrefixExpCS) {
						aSource = (PrefixExpCS)eContainer;
					}
					else if (eContainer instanceof NestedExpCS) {
						aSource = (NestedExpCS)eContainer;
					}
					else if (eContainer instanceof SpecificationCS) {
						ExpressionInOCL expression = PivotUtil.getContainingExpressionInOCL(((SpecificationCS)eContainer).getPivot());
						source = expression!= null ? expression.getOwnedContext() : null;
						break;
					}
					else {
						break;
					}
				}
				if (source == null) {
					if ((csSource != null) && (csSource != navigationArgument)) {
						source = PivotUtil.getPivot(OCLExpression.class, csSource);
					}
				}
				if (source != null) {
					if (sourceType == null) {
						sourceType = source.getType();
					}
					if (csOperator != null) {
						boolean isAggregate = PivotUtil.isAggregate(sourceType);
						if (isAggregate) {
							String navigationOperatorName = csOperator.getName();
							if (PivotUtil.isObjectNavigationOperator(navigationOperatorName)) {
								if (source.eContainingFeature() == PivotPackage.Literals.CALL_EXP__OWNED_SOURCE) {
									EObject eContainer = source.eContainer();
									if (eContainer instanceof IteratorExp) {
										IteratorExp iteratorExp = (IteratorExp)eContainer;
										if (iteratorExp.isIsImplicit()) {
											LibraryFeature iterationImplementation = iteratorExp.getReferredIteration().getImplementation();
											if (iterationImplementation == CollectIteration.INSTANCE) {
												Variable iterator = PivotUtil.getOwnedIterators(iteratorExp).iterator().next();
												sourceType = PivotUtil.getType(iterator);
											}
										}
									}
								}
							}
						}
					}
				}
				typeText = "";
				if (source != null) {
					typeText = PivotConstantsInternal.UNKNOWN_TYPE_TEXT;
					if (sourceType == null) {
						sourceType = source.getType();
					}
					if (sourceType != null) {
					//	sourceType = PivotUtil.getBehavioralType(sourceType);
						OperatorExpCS csParent = navigationArgument != null ? navigationArgument.getLocalParent() : null;
						if (!PivotUtil.isAggregate(sourceType) && NavigationUtil.isNavigationInfixExp(csParent) && (csParent != null) && PivotUtil.isAggregateNavigationOperator(((InfixExpCS)csParent).getName())) {
							typeText = "Set(" + sourceType.toString() + ")";
						}
						else {
							typeText = sourceType.toString();
						}
					}
				}
			}
			assert messageTemplate != null;
			MessageBinder messageBinder = CS2AS.getMessageBinder();
			String messageText;
			if (argumentText == null) {
				messageText = messageBinder.bind(csContext, messageTemplate, typeText, linkText);
			}
			else {
				messageText = messageBinder.bind(csContext, messageTemplate, typeText, linkText, argumentText);
			}
			return messageText;
		}

		public String getOperationArguments(@NonNull RoundBracketedClauseCS csRoundBracketedClause) {
			List<@NonNull NavigatingArgCS> arguments = ClassUtil.nullFree(csRoundBracketedClause.getOwnedArguments());
			StringBuilder s = new StringBuilder();
			for (@NonNull NavigatingArgCS csArgument : arguments) {
				TypedElement pivot = PivotUtil.getPivot(TypedElement.class, csArgument);
				if ((pivot != null) && !pivot.eIsProxy()) {
					if (s.length() > 0) {
						s.append(", ");
					}
					Type type = pivot.getType();
					s.append(String.valueOf(type));
				}
				else {
					s.append(ElementUtil.getTrimmedText(csArgument));
				}
			}
			return s.toString();
		}
	}
}
