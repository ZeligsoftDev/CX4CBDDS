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
 * An AbstractDelegatingEssentialOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingEssentialOCLCSVisitor<R, C, @NonNull D extends EssentialOCLCSVisitor<R>>
	extends org.eclipse.ocl.xtext.basecs.util.AbstractDelegatingBaseCSVisitor<R, C, D>
	implements EssentialOCLCSVisitor<R>
{
	protected AbstractDelegatingEssentialOCLCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AbstractNameExpCS object) {
		return delegate.visitAbstractNameExpCS(object);
	}

	@Override
	public R visitAssociationClassCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AssociationClassCallExpCS object) {
		return delegate.visitAssociationClassCallExpCS(object);
	}

	@Override
	public R visitBooleanLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull BooleanLiteralExpCS object) {
		return delegate.visitBooleanLiteralExpCS(object);
	}

	@Override
	public R visitCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CallExpCS object) {
		return delegate.visitCallExpCS(object);
	}

	@Override
	public R visitCollectionLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralExpCS object) {
		return delegate.visitCollectionLiteralExpCS(object);
	}

	@Override
	public R visitCollectionLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralPartCS object) {
		return delegate.visitCollectionLiteralPartCS(object);
	}

	@Override
	public R visitCollectionPatternCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionPatternCS object) {
		return delegate.visitCollectionPatternCS(object);
	}

	@Override
	public R visitCollectionTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionTypeCS object) {
		return delegate.visitCollectionTypeCS(object);
	}

	@Override
	public R visitContextCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ContextCS object) {
		return delegate.visitContextCS(object);
	}

	@Override
	public R visitCurlyBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CurlyBracketedClauseCS object) {
		return delegate.visitCurlyBracketedClauseCS(object);
	}

	@Override
	public R visitExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpCS object) {
		return delegate.visitExpCS(object);
	}

	@Override
	public R visitExpSpecificationCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpSpecificationCS object) {
		return delegate.visitExpSpecificationCS(object);
	}

	@Override
	public R visitIfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfExpCS object) {
		return delegate.visitIfExpCS(object);
	}

	@Override
	public R visitIfThenExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfThenExpCS object) {
		return delegate.visitIfThenExpCS(object);
	}

	@Override
	public R visitInfixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InfixExpCS object) {
		return delegate.visitInfixExpCS(object);
	}

	@Override
	public R visitInvalidLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InvalidLiteralExpCS object) {
		return delegate.visitInvalidLiteralExpCS(object);
	}

	@Override
	public R visitIterateCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterateCallExpCS object) {
		return delegate.visitIterateCallExpCS(object);
	}

	@Override
	public R visitIterationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterationCallExpCS object) {
		return delegate.visitIterationCallExpCS(object);
	}

	@Override
	public R visitLambdaLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LambdaLiteralExpCS object) {
		return delegate.visitLambdaLiteralExpCS(object);
	}

	@Override
	public R visitLetExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetExpCS object) {
		return delegate.visitLetExpCS(object);
	}

	@Override
	public R visitLetVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetVariableCS object) {
		return delegate.visitLetVariableCS(object);
	}

	@Override
	public R visitLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LiteralExpCS object) {
		return delegate.visitLiteralExpCS(object);
	}

	@Override
	public R visitMapLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralExpCS object) {
		return delegate.visitMapLiteralExpCS(object);
	}

	@Override
	public R visitMapLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralPartCS object) {
		return delegate.visitMapLiteralPartCS(object);
	}

	@Override
	public R visitMapTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapTypeCS object) {
		return delegate.visitMapTypeCS(object);
	}

	@Override
	public R visitNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NameExpCS object) {
		return delegate.visitNameExpCS(object);
	}

	@Override
	public R visitNavigatingArgCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NavigatingArgCS object) {
		return delegate.visitNavigatingArgCS(object);
	}

	@Override
	public R visitNestedExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NestedExpCS object) {
		return delegate.visitNestedExpCS(object);
	}

	@Override
	public R visitNullLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NullLiteralExpCS object) {
		return delegate.visitNullLiteralExpCS(object);
	}

	@Override
	public R visitNumberLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NumberLiteralExpCS object) {
		return delegate.visitNumberLiteralExpCS(object);
	}

	@Override
	public R visitOperationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperationCallExpCS object) {
		return delegate.visitOperationCallExpCS(object);
	}

	@Override
	public R visitOperatorExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperatorExpCS object) {
		return delegate.visitOperatorExpCS(object);
	}

	@Override
	public R visitPatternExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PatternExpCS object) {
		return delegate.visitPatternExpCS(object);
	}

	@Override
	public R visitPrefixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrefixExpCS object) {
		return delegate.visitPrefixExpCS(object);
	}

	@Override
	public R visitPrimitiveLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrimitiveLiteralExpCS object) {
		return delegate.visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public R visitPropertyCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PropertyCallExpCS object) {
		return delegate.visitPropertyCallExpCS(object);
	}

	@Override
	public R visitRoundBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull RoundBracketedClauseCS object) {
		return delegate.visitRoundBracketedClauseCS(object);
	}

	@Override
	public R visitSelfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SelfExpCS object) {
		return delegate.visitSelfExpCS(object);
	}

	@Override
	public R visitShadowExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowExpCS object) {
		return delegate.visitShadowExpCS(object);
	}

	@Override
	public R visitShadowPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowPartCS object) {
		return delegate.visitShadowPartCS(object);
	}

	@Override
	public R visitSquareBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SquareBracketedClauseCS object) {
		return delegate.visitSquareBracketedClauseCS(object);
	}

	@Override
	public R visitStringLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull StringLiteralExpCS object) {
		return delegate.visitStringLiteralExpCS(object);
	}

	@Override
	public R visitTupleLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralExpCS object) {
		return delegate.visitTupleLiteralExpCS(object);
	}

	@Override
	public R visitTupleLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralPartCS object) {
		return delegate.visitTupleLiteralPartCS(object);
	}

	@Override
	public R visitTypeLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeLiteralExpCS object) {
		return delegate.visitTypeLiteralExpCS(object);
	}

	@Override
	public R visitTypeNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeNameExpCS object) {
		return delegate.visitTypeNameExpCS(object);
	}

	@Override
	public R visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull UnlimitedNaturalLiteralExpCS object) {
		return delegate.visitUnlimitedNaturalLiteralExpCS(object);
	}

	@Override
	public R visitVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableCS object) {
		return delegate.visitVariableCS(object);
	}

	@Override
	public R visitVariableExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableExpCS object) {
		return delegate.visitVariableExpCS(object);
	}
}
