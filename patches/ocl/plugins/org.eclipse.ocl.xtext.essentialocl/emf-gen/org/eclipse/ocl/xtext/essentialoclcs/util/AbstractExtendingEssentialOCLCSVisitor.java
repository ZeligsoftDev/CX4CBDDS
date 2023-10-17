/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.essentialoclcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingEssentialOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingEssentialOCLCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.basecs.util.AbstractExtendingBaseCSVisitor<R, C>
	implements EssentialOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingEssentialOCLCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAbstractNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AbstractNameExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitAssociationClassCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AssociationClassCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public R visitBooleanLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CallExpCS object) {
		return visitAbstractNameExpCS(object);
	}

	@Override
	public R visitCollectionLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitCollectionLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitCollectionPatternCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionPatternCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitCollectionTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitContextCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ContextCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitCurlyBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CurlyBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public R visitExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitExpSpecificationCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpSpecificationCS object) {
		return visitSpecificationCS(object);
	}

	@Override
	public R visitIfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitIfThenExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfThenExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitInfixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InfixExpCS object) {
		return visitOperatorExpCS(object);
	}

	@Override
	public R visitInvalidLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitIterateCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterateCallExpCS object) {
		return visitIterationCallExpCS(object);
	}

	@Override
	public R visitIterationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterationCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public R visitLambdaLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LambdaLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitLetExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitLetVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetVariableCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LiteralExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitMapLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitMapLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitMapTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NameExpCS object) {
		return visitAssociationClassCallExpCS(object);
	}

	@Override
	public R visitNavigatingArgCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NavigatingArgCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitNestedExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NestedExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitNullLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitNumberLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitOperationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperationCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public R visitOperatorExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperatorExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitPatternExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PatternExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitPrefixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrefixExpCS object) {
		return visitOperatorExpCS(object);
	}

	@Override
	public R visitPrimitiveLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitPropertyCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PropertyCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public R visitRoundBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull RoundBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public R visitSelfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SelfExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitShadowExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowExpCS object) {
		return visitAbstractNameExpCS(object);
	}

	@Override
	public R visitShadowPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowPartCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitSquareBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SquareBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public R visitStringLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitTupleLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitTupleLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	@Override
	public R visitTypeLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public R visitTypeNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeNameExpCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitVariableExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableExpCS object) {
		return visitAbstractNameExpCS(object);
	}
}
