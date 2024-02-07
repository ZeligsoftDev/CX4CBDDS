/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;

public class NavigatingArgCSAttribution extends AbstractAttribution
{
	public static final @NonNull NavigatingArgCSAttribution INSTANCE = new NavigatingArgCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		NavigatingArgCS fromArgument = (NavigatingArgCS)target;
		NavigationRole role = fromArgument.getRole();
		RoundBracketedClauseCS csRoundBracketedClause = fromArgument.getOwningRoundBracketedClause();
		AbstractNameExpCS targetElement = csRoundBracketedClause.getOwningNameExp();
		assert targetElement != null;
		InfixExpCS csNavigationOperator = NavigationUtil.getNavigationInfixExp(targetElement);
		OCLExpression pivot = PivotUtil.getPivot(OCLExpression.class, targetElement);	// NB QVTr's RelationCallExp is not a CallExp
		if (pivot instanceof LoopExp) {				// FIXME This is null for nested iteration
			if (role == NavigationRole.EXPRESSION) {
				for (Variable iterator : ((LoopExp)pivot).getOwnedIterators()) {
					if (iterator.isIsImplicit()) {
						environmentView.addElementsOfScope(iterator.getType(), scopeView);
					}
					else {
						environmentView.addNamedElement(iterator);
					}
					if (environmentView.hasFinalResult()) {
						return null;
					}
				}
				for (Variable iterator : ((LoopExp)pivot).getOwnedCoIterators()) {
					if (iterator.isIsImplicit()) {
						environmentView.addElementsOfScope(iterator.getType(), scopeView);
					}
					else {
						environmentView.addNamedElement(iterator);
					}
					if (environmentView.hasFinalResult()) {
						return null;
					}
				}
				if (pivot instanceof IterateExp) {
					Variable result = ((IterateExp)pivot).getOwnedResult();
					if (result.isIsImplicit()) {
						environmentView.addElementsOfScope(result.getType(), scopeView);
					}
					else {
						environmentView.addNamedElement(result);
					}
					if (environmentView.hasFinalResult()) {
						return null;
					}
				}
			}
			else if (role == NavigationRole.ITERATOR) {			// Happens during save
				List<Variable> iterators = ((LoopExp)pivot).getOwnedIterators();
				assert iterators != null;
				environmentView.addNamedElements(iterators);
			}
			else if (role == NavigationRole.ACCUMULATOR) {
				Variable result = ((IterateExp)pivot).getOwnedResult();
				if (result != null) {
					environmentView.addNamedElement(result);
				}
			}
		}
		else if (pivot != null) {								// OperationCallExp
		}
		else {													// No pivot resolved yet
			if (role == NavigationRole.EXPRESSION) {
				//
				//	Challenges:
				//		for x->select(oclIsKindOf(T)) must accept both T as a type (and as a source property)
				//		for x->select(something(T)) must accept both T as a source property (and as a type)
				//
				if ((csNavigationOperator != null) && PivotUtil.isAggregateNavigationOperator(csNavigationOperator.getName())) {
					ExpCS csSource = csNavigationOperator.getSource();
					OCLExpression source = PivotUtil.getPivot(OCLExpression.class, csSource);
					if (source != null) {
						Type type = source.getType();
						Type elementType;
						CollectionType collectionType;
						PivotMetamodelManager metamodelManager = environmentView.getEnvironmentFactory().getMetamodelManager();
						if (type instanceof CollectionType) {		// collection->collection-operation(name...
							collectionType = (CollectionType)type;
							elementType = collectionType.getElementType();
							ExpCS csArgument = csNavigationOperator.getArgument();
							assert csArgument == targetElement;
						}
						else {
							elementType = type;
							collectionType = metamodelManager.getStandardLibrary().getSetType();
						}
						if (NavigationUtil.isIteration(metamodelManager, csRoundBracketedClause, collectionType)) {
							if (environmentView.accepts(PivotPackage.Literals.TYPE)) {
								EClassifier requiredType = environmentView.getRequiredType();
								try {
									environmentView.setRequiredType(PivotPackage.Literals.TYPE);
									environmentView.computeLookups(scopeView.getParent().getParent().getParent());
								}
								finally {
									environmentView.setRequiredType(requiredType);
								}
							}
							environmentView.addElementsOfScope(elementType, scopeView);
							if (environmentView.hasFinalResult()) {								// If we found a type
								return null;													// but look no further for variables
							}
						}
					}
				}
			}
		}
		if (csNavigationOperator != null) {
			return scopeView.getParent().getParent().getParent().getParent();	// Leapfrog over RoundBracketedClauseCS, InvocationExpCS and its source operator
		}
		else {
			return scopeView.getParent().getParent().getParent();				// Leapfrog over RoundBracketedClauseCS, InvocationExpCS
		}
	}
}
