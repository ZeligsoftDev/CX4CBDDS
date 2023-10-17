/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.AbstractEssentialOCLCSPostOrderVisitor;

public class EssentialOCLCSPostOrderVisitor extends AbstractEssentialOCLCSPostOrderVisitor
{
	static final Logger logger = LogManager.getLogger(EssentialOCLCSPostOrderVisitor.class);

	public class ConstraintCSCompletion extends SingleContinuation<ConstraintCS>
	{
		public ConstraintCSCompletion(@NonNull CS2ASConversion context, @NonNull ConstraintCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			// NB Three cases for the Constraint content
			// a) refreshing an OpaqueExpression that originated from Ecore2AS
			// b) refreshing an ExpressionInOCL for a simple statusExpression
			// c) refreshing an ExpressionInOCL+PropertyCallExp of a TupleLiteralExp for statusExpression+messageExpression
			Constraint asConstraint = PivotUtil.getPivot(Constraint.class, csElement);
			ExpSpecificationCS csStatusSpecification = (ExpSpecificationCS)csElement.getOwnedSpecification();
			if ((asConstraint != null) && (csStatusSpecification != null)) {
				ExpCS csStatusExpression = csStatusSpecification.getOwnedExpression();
				if (csStatusExpression != null) {
					@SuppressWarnings("null")@NonNull ExpressionInOCL asSpecification = (ExpressionInOCL) asConstraint.getOwnedSpecification();
					context.refreshContextVariable(csStatusSpecification, asSpecification);
					ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS)csElement.getOwnedMessageSpecification();
					String statusText = ElementUtil.getExpressionText(csStatusExpression);
					if (csMessageSpecification == null) {
						OCLExpression asExpression = context.visitLeft2Right(OCLExpression.class, csStatusExpression);
						asSpecification.setOwnedBody(asExpression);
						boolean isRequired = (asExpression != null) && asExpression.isIsRequired();
						helper.setType(asSpecification, asExpression != null ? asExpression.getType() : null, isRequired);
						PivotUtil.setBody(asSpecification, asExpression, statusText);
					}
					else {
						TupleLiteralPart asStatusTuplePart = PivotUtilInternal.getNonNullAst(TupleLiteralPart.class, csStatusSpecification);
						OCLExpression asStatusExpression = context.visitLeft2Right(OCLExpression.class, csStatusExpression);
						asStatusTuplePart.setOwnedInit(asStatusExpression);
						TupleLiteralPart asMessageTuplePart = PivotUtilInternal.getNonNullAst(TupleLiteralPart.class, csMessageSpecification);
						ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
						OCLExpression asMessageExpression = csMessageExpression != null ? context.visitLeft2Right(OCLExpression.class, csMessageExpression) : null;
						asMessageTuplePart.setOwnedInit(asMessageExpression);
						@SuppressWarnings("null")@NonNull OCLExpression asTuplePartExp = asSpecification.getOwnedBody();
						helper.setType(asSpecification, asTuplePartExp.getType(), true);
						String messageText = csMessageExpression != null ? ElementUtil.getExpressionText(csMessageExpression) : "null";
						String tupleText = PivotUtil.createTupleValuedConstraint(statusText, null, messageText);
						PivotUtil.setBody(asSpecification, asTuplePartExp, tupleText);
					}
				}
				else {
					@SuppressWarnings("null")@NonNull LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
					asSpecification.setBody(csStatusSpecification.getExprString());
				}
			}
			return null;
		}
	}

	protected static class ContextCSCompletion extends SingleContinuation<ContextCS>
	{
		public ContextCSCompletion(@NonNull CS2ASConversion context, @NonNull ContextCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			context.visitLeft2Right(Element.class, csElement);
			return null;
		}
	}

	public class ExpSpecificationCSCompletion extends SingleContinuation<ExpSpecificationCS>
	{
		public ExpSpecificationCSCompletion(@NonNull CS2ASConversion context, @NonNull ExpSpecificationCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			ExpressionInOCL asSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement);
			if ((asSpecification != null) && (asSpecification.eContainer() != null)) {		// null eContainer is a problem in the parent, no need for another diagnostic
				context.refreshContextVariable(csElement, asSpecification);
				ExpCS csExpression = csElement.getOwnedExpression();
				OCLExpression asExpression = csExpression != null ? context.visitLeft2Right(OCLExpression.class, csExpression) : null;
				String statusText = csExpression != null ? ElementUtil.getExpressionText(csExpression) : "null";
				PivotUtil.setBody(asSpecification, asExpression, statusText);
				boolean isRequired = (asExpression != null) && asExpression.isIsRequired();
				helper.setType(asSpecification, asExpression != null ? asExpression.getType() : null, isRequired);
			}
			return null;
		}
	}

	protected final @NonNull PivotMetamodelManager metamodelManager;

	public EssentialOCLCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
		this.metamodelManager = context.getMetamodelManager();
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csCollectionType) {
		// FIXME untemplated collections need type deduction here
		/*		MetamodelManager metamodelManager = context.getMetamodelManager();
		TypedRefCS csElementType = csCollectionType.getOwnedType();
		Type type;
		if (csElementType != null) {
			Type elementType = PivotUtil.getPivot(Type.class, csElementType);
			type = metamodelManager.getLibraryType(csCollectionType.getName(), Collections.singletonList(elementType));
		}
		else {
			type = metamodelManager.getLibraryType(csCollectionType.getName());
		}
		context.reusePivotElement(csCollectionType, type);
		 */		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csConstraint) {
		return new ConstraintCSCompletion(context, csConstraint);
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csContext) {
		ExpCS ownedExpression = csContext.getOwnedExpression();
		if (ownedExpression != null) {
			return new ContextCSCompletion(context, csContext);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitContextLessElementCS(@NonNull ContextLessElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csExp) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		if (!(csElement.eContainer() instanceof ConstraintCS)) {
			return new ExpSpecificationCSCompletion(context, csElement);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitMapTypeCS(@NonNull MapTypeCS csMapType) {
		// FIXME untemplated maps need type deduction here
		/*		MetamodelManager metamodelManager = context.getMetamodelManager();
		TypedRefCS csElementType = csCollectionType.getOwnedType();
		Type type;
		if (csElementType != null) {
			Type elementType = PivotUtil.getPivot(Type.class, csElementType);
			type = metamodelManager.getLibraryType(csCollectionType.getName(), Collections.singletonList(elementType));
		}
		else {
			type = metamodelManager.getLibraryType(csCollectionType.getName());
		}
		context.reusePivotElement(csCollectionType, type);
		 */		return null;
	}

	@Override
	public final Continuation<?> visitSpecificationCS(@NonNull SpecificationCS csSpecification) {
		return null;	// Must be managed by container
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csVariable) {
		return null;
	}
}
