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
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider;
import org.eclipse.ocl.pivot.utilities.LabelUtil;

/**
 * A DomainSubstitutionLabelProvider provides readable names for EObjects. 
 */
public class LabelSubstitutionLabelProvider implements SubstitutionLabelProvider
{
	@Override
	public String getObjectLabel(EObject eObject) {
		return LabelUtil.getLabel(eObject);
	}

	@Override
	public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
		return LabelUtil.getLabel(eStructuralFeature);
	}

	@Override
	public String getValueLabel(EDataType eDataType, Object value) {
		return LabelUtil.getLabel(eDataType, value, null);
	}
}
