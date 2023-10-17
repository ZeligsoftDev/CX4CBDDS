/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;

public class NavigationUtil
{
	/**
	 * Return the NavigationOperatorCS for which csExp is the left node of the navigation operator's argument tree.
	 */
	public static @Nullable InfixExpCS getNavigationInfixExp(@NonNull AbstractNameExpCS csExp) {
		EObject eContainer = csExp.eContainer();
		if (eContainer instanceof NameExpCS) {
			csExp = (NameExpCS) eContainer;
		}
		for (ExpCS csChild = csExp; true; csChild = csChild.getLocalParent()) {
			if (csChild == null) {
				return null;
			}
			OperatorExpCS csOperator = csChild.getLocalParent();
			if (csOperator == null) {
				return null;
			}
			ExpCS csSource = csOperator.getSource();
			if (csSource == csChild) {									// e.g.    ... -> (X... -> ...)
				;
			}
			else if (isNavigationInfixExp(csOperator)) {		// e.g 	   ... -> X
				return (InfixExpCS) csOperator;
			}
			else {														// e.g.    ... and X
				return null;
			}
		}
	}

	public static boolean isIteration(@NonNull PivotMetamodelManager metamodelManager, @NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull CollectionType type) {
		for (NavigatingArgCS csArg : csRoundBracketedClause.getOwnedArguments()) {
			if (csArg.getRole() != NavigationRole.EXPRESSION) {
				return true;
			}
		}
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		PathNameCS pathName = csNameExp.getOwnedPathName();
		List<PathElementCS> path = pathName.getOwnedPathElements();
		if (path.size() != 1) {
			return false;
		}
		PathElementCS csPathElement = path.get(0);
		Element unresolvedElement = csPathElement.basicGetReferredElement();
		if ((unresolvedElement != null) && !unresolvedElement.eIsProxy()) {
			return unresolvedElement instanceof Iteration;
		}
		String name = ElementUtil.getTrimmedText(csPathElement);
		assert name != null;
		for (Operation operation : metamodelManager.getAllOperations(type, FeatureFilter.SELECT_NON_STATIC, name)) {
			return operation instanceof Iteration;		// mixed overload are not allowed
		}
		return false;
	}

	public static boolean isNavigationInfixExp(@Nullable EObject eObject) {
		if (eObject instanceof InfixExpCS) {
			String name = ((InfixExpCS)eObject).getName();
			return isNavigationOperator(name);
		}
		else {
			return false;
		}
	}

	public static boolean isNavigationOperator(String name) {		// FIXME Use the grammar production
		return PivotConstants.OBJECT_NAVIGATION_OPERATOR.equals(name)
			|| PivotConstants.AGGREGATE_NAVIGATION_OPERATOR.equals(name)
			|| PivotConstants.SAFE_OBJECT_NAVIGATION_OPERATOR.equals(name)
			|| PivotConstants.SAFE_AGGREGATE_NAVIGATION_OPERATOR.equals(name)
			|| "^".equals(name)
			|| "^^".equals(name);
	}
}
