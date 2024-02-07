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
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;

public class IterateExpAttribution extends AbstractAttribution
{
	public static final IterateExpAttribution INSTANCE = new IterateExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		IterateExp targetExpression = (IterateExp)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__OWNED_BODY) {
			OCLExpression source = targetExpression.getOwnedSource();
			environmentView.addElementsOfScope(source.getType(), scopeView);
			environmentView.addElements(targetExpression.getOwnedIterators());
			environmentView.addElements(targetExpression.getOwnedCoIterators());
			Variable result = targetExpression.getOwnedResult();
			if (result != null) {
				environmentView.addNamedElement(result);
			}
		}
		else if (containmentFeature == PivotPackage.Literals.ITERATE_EXP__OWNED_RESULT) {
			OCLExpression source = targetExpression.getOwnedSource();
			environmentView.addElements(targetExpression.getOwnedIterators());
			environmentView.addElements(targetExpression.getOwnedCoIterators());
			environmentView.addElementsOfScope(source.getType(), scopeView);
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__OWNED_ITERATORS) {
			OCLExpression source = targetExpression.getOwnedSource();
			environmentView.addElementsOfScope(source.getType(), scopeView);
			EObject child = scopeView.getChild();
			for (Variable iterator : targetExpression.getOwnedIterators()) {
				if (iterator != null) {
					environmentView.addNamedElement(iterator);
					if (iterator == child) {
						break;
					}
				}
			}
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__OWNED_CO_ITERATORS) {
			OCLExpression source = targetExpression.getOwnedSource();
			environmentView.addElementsOfScope(source.getType(), scopeView);
			EObject child = scopeView.getChild();
			for (Variable iterator : targetExpression.getOwnedCoIterators()) {
				if (iterator != null) {
					environmentView.addNamedElement(iterator);
					if (iterator == child) {
						break;
					}
				}
			}
		}
		return scopeView.getParent();
	}
}
