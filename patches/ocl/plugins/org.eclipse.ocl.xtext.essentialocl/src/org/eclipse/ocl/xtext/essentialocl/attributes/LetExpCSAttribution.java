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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

public class LetExpCSAttribution extends AbstractAttribution
{
	public static final LetExpCSAttribution INSTANCE = new LetExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (environmentView.accepts(PivotPackage.Literals.VARIABLE)) {
			LetExpCS targetElement = (LetExpCS)target;
			for (VariableCS csVariable : targetElement.getOwnedVariables()) {
				Variable variable = PivotUtil.getPivot(Variable.class, csVariable);
				if (variable != null) {		// Maybe null while resolving namespaces
					environmentView.addNamedElement(variable);
				}
			}
			if (environmentView.hasFinalResult()) {
				return null;							// Let variables occlude outer scopes
			}
		}
		return scopeView.getParent();
	}
}
