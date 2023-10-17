/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;

public class PivotableElementCSAttribution extends AbstractAttribution
{
	public static final PivotableElementCSAttribution INSTANCE = new PivotableElementCSAttribution();

	@Override
	public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Element pivot = PivotUtil.getPivot(Element.class, (PivotableElementCS)target);
		if ((pivot == null) || (pivot.eResource() == null)  || (pivot instanceof InvalidType)) {
			return scopeView.getParent();
		}
		environmentView.computeLookups(pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
		// Uncomment to debug Bug 551826, should always return null if a pivot search was attempted but failed
//		if (!environmentView.hasFinalResult()) {
//			environmentView.computeLookups(pivot, null);
//			return scopeView.getParent();
//		}
		return null;
	}
}
