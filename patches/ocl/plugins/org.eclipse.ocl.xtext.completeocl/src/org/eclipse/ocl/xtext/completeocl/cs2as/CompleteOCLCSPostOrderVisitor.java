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
package org.eclipse.ocl.xtext.completeocl.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.util.AbstractCompleteOCLCSPostOrderVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

public class CompleteOCLCSPostOrderVisitor extends AbstractCompleteOCLCSPostOrderVisitor
{
	public class ContectDeclSpecificationCSCompletion extends SingleContinuation<ExpSpecificationCS>
	{
		protected final @NonNull TypedRefCS csTypedRef;

		public ContectDeclSpecificationCSCompletion(@NonNull CS2ASConversion context, @NonNull ExpSpecificationCS csElement, @NonNull TypedRefCS csTypedRef) {
			super(context, null, null, csElement);
			this.csTypedRef = csTypedRef;
		}

		@Override
		public BasicContinuation<?> execute() {
			ExpressionInOCL asSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement);
			if ((asSpecification != null) && (asSpecification.eContainer() != null)) {		// null eContainer is a problem in the parent, no need for another diagnostic
				context.refreshContextVariable(csElement, asSpecification);
				ExpCS csExpression = csElement.getOwnedExpression();
				OCLExpression asExpression = csExpression != null ? context.visitLeft2Right(OCLExpression.class, csExpression) : null;
				if (asExpression != null) {
					Type asExpressionType = asExpression.getType();
					Type asContextType = PivotUtil.getPivot(Type.class, csTypedRef);
					StandardLibraryInternal standardLibrary = context.getStandardLibrary();
					if ((asContextType != null) && !asExpressionType.conformsTo(standardLibrary, asContextType)) {
						PrimitiveType integerType = standardLibrary.getIntegerType();
						Operation asCoercion = NameUtil.getNameable(integerType.getOwnedOperations(), "toUnlimitedNatural");
						if (asCoercion != null) {
							PrimitiveType unlimitedNaturalType = standardLibrary.getUnlimitedNaturalType();
							if (asExpressionType.conformsTo(standardLibrary, integerType)) {
								if (asContextType.conformsTo(standardLibrary, unlimitedNaturalType)) {
									asExpression = new PivotHelper(context.getEnvironmentFactory()).createCoercionCallExp(asExpression, asCoercion);
								}
							}
						}
					}
				}
				String statusText = csExpression != null ? ElementUtil.getExpressionText(csExpression) : "null";
				PivotUtil.setBody(asSpecification, asExpression, statusText);
				boolean isRequired = (asExpression != null) && asExpression.isIsRequired();
				helper.setType(asSpecification, asExpression != null ? asExpression.getType() : null, isRequired);
			}
			return null;
		}
	}

	public CompleteOCLCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (contextOperation != null) {
			context.refreshRequiredType(contextOperation, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		Property contextProperty = PivotUtil.getPivot(Property.class, csElement);
		if (contextProperty != null) {
			context.refreshRequiredType(contextProperty, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public final @Nullable Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		EObject csContainer = csElement.eContainer();
		if (csContainer instanceof FeatureContextDeclCS) {
			TypedRefCS ownedType = ((FeatureContextDeclCS)csContainer).getOwnedType();
			if (ownedType != null) {
				return new ContectDeclSpecificationCSCompletion(context, csElement, ownedType);
			}
		}
		return super.visitExpSpecificationCS(csElement);
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		Operation modelOperation = csElement.getReferredOperation();
		if ((modelOperation != null) && !modelOperation.eIsProxy()) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
			if (contextOperation != null) {
				helper.refreshName(contextOperation, ClassUtil.nonNullModel(modelOperation.getName()));
				helper.setType(contextOperation, modelOperation.getType(), modelOperation.isIsRequired());		// FIXME type consistency check
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		return null;
	}
}
