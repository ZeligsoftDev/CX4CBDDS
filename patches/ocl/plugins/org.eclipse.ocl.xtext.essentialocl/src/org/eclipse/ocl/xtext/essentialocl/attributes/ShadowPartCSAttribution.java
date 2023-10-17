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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;

public class ShadowPartCSAttribution extends AbstractAttribution
{
	public static final @NonNull ShadowPartCSAttribution INSTANCE = new ShadowPartCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY) {
			ShadowPartCS targetElement = (ShadowPartCS)target;
			CurlyBracketedClauseCS csCurlyBracketClause = targetElement.getOwningCurlyBracketClause();
			AbstractNameExpCS csNameExp = csCurlyBracketClause.getOwningNameExp();
			ShadowExp pivot = PivotUtil.getPivot(ShadowExp.class, csNameExp);
			if (pivot != null) {
				Type type = pivot.getType();
				if (type instanceof org.eclipse.ocl.pivot.DataType) {
					String name = environmentView.getName();
					if ((name == null) || (name.equals(PivotConstants.DATA_TYPE_VALUE_NAME))) {
						Property asValueProperty = new PivotHelper(environmentView.getEnvironmentFactory()).getDataTypeValueProperty();
						environmentView.addNamedElement(asValueProperty);
					}
				}
				else if (type instanceof org.eclipse.ocl.pivot.Class) {
					environmentView.addAllProperties((org.eclipse.ocl.pivot.Class)type, FeatureFilter.SELECT_NON_STATIC);
				}
			}
			return null;
		}
		return scopeView.getParent();
	}
}
