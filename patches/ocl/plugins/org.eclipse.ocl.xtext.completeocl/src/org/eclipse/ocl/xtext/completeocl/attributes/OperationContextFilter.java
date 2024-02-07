/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.attributes;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;

public class OperationContextFilter implements ScopeFilter
{
	private final @NonNull OperationContextDeclCS csOperationContext;

	public OperationContextFilter(@NonNull OperationContextDeclCS csOperationContext) {
		this.csOperationContext = csOperationContext;
	}

	@Override
	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		if (!(object instanceof Operation)) {
			return false;
		}
		Operation candidateOperation = (Operation) object;
		PivotMetamodelManager metamodelManager = environmentView.getEnvironmentFactory().getMetamodelManager();
//		Type context = metamodelManager.getPrimaryType(candidateOperation.getOwningType());
//		if (context != metamodelManager.getPrimaryElement(forType)) {
//			return false;
//		}
		List<ParameterCS> contextParameters = csOperationContext.getOwnedParameters();
		List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
		int iMax = contextParameters.size();
		if (iMax != candidateParameters.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			ParameterCS contextParameter = contextParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			Type contextType = PivotUtil.getPivot(Type.class, contextParameter.getOwnedType());
			Type candidateType = candidateParameter.getType();
			if (contextType != null) {
				contextType = metamodelManager.getPrimaryType(contextType);
			}
			if (candidateType != null) {
				candidateType = metamodelManager.getPrimaryType(candidateType);
			}
// FIXME Need to resolve parameter type pivots first
//			if (contextType != candidateType) {
//				return false;
//			}
		}
		return true;
	}
}