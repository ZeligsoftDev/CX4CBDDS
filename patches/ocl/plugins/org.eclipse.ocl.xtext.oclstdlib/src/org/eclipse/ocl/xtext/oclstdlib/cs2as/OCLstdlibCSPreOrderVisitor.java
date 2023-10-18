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
package org.eclipse.ocl.xtext.oclstdlib.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.xtext.oclstdlibcs.util.AbstractOCLstdlibCSPreOrderVisitor;

public class OCLstdlibCSPreOrderVisitor extends AbstractOCLstdlibCSPreOrderVisitor
{
	public OCLstdlibCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitLibClassCS(@NonNull LibClassCS csClass) {
		org.eclipse.ocl.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csClass);
		if (pivotElement != null) {
			JavaClassCS implementation = csClass.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
		//		pivotElement.setInstanceClassName(implementation.getName());
			}
		}
		return super.visitLibClassCS(csClass);
	}

	@Override
	public Continuation<?> visitLibCoercionCS(@NonNull LibCoercionCS csCoercion) {
		Operation pivotCoercion = PivotUtil.getPivot(Operation.class, csCoercion);
		if (pivotCoercion != null) {
			JavaClassCS implementation = csCoercion.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotCoercion.setImplementationClass(implementation.getName());
			}
		}
		return super.visitLibCoercionCS(csCoercion);
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csIteration) {
		Iteration pivotIteration = PivotUtil.getPivot(Iteration.class, csIteration);
		if (pivotIteration != null) {
			JavaClassCS implementation = csIteration.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotIteration.setImplementationClass(implementation.getName());
			}
		}
		return super.visitLibIterationCS(csIteration);
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csOperation) {
		Operation pivotElement = PivotUtil.getPivot(Operation.class, csOperation);
		if (pivotElement != null) {
			Precedence precedence = csOperation.getPrecedence();
			if ((precedence != null) && precedence.eIsProxy()) {
				precedence = null;
			}
			pivotElement.setPrecedence(precedence);
			pivotElement.setIsStatic(csOperation.isIsStatic());
			JavaClassCS implementation = csOperation.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotElement.setImplementationClass(implementation.getName());
			}
		}
		return super.visitLibOperationCS(csOperation);
	}

	@Override
	public Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS csProperty) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csProperty);
		if (pivotElement != null) {
			pivotElement.setIsStatic(csProperty.isIsStatic());
			JavaClassCS implementation = csProperty.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotElement.setImplementationClass(implementation.getName());
			}
		}
		return super.visitLibPropertyCS(csProperty);
	}

	@Override /* FIXME Bug 548500 workaround */
	public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull MetaclassNameCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}
