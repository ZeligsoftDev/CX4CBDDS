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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.BaseCSLeft2RightVisitor;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;

/**
 * An AbstractEssentialOCLCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractEssentialOCLCSLeft2RightVisitor
	extends BaseCSLeft2RightVisitor
	implements EssentialOCLCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractEssentialOCLCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAbstractNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AbstractNameExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitAssociationClassCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull AssociationClassCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitBooleanLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CallExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionPatternCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionPatternCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitContextCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCurlyBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitExpSpecificationCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	@Override
	public @Nullable Element visitIfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIfThenExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitInfixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InfixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Element visitInvalidLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIterateCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterateCallExpCS csElement) {
		return visitIterationCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIterationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull IterationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLambdaLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLetExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLetVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LetVariableCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitMapLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitMapLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitMapTypeCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull MapTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NameExpCS csElement) {
		return visitAssociationClassCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNavigatingArgCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitNestedExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNullLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNumberLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitOperationCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitOperatorExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull OperatorExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PatternExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPrefixExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrefixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPrimitiveLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPropertyCallExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull PropertyCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitRoundBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitSelfExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitShadowExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Element visitShadowPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull ShadowPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitSquareBracketedClauseCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitStringLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTupleLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTupleLiteralPartCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitTypeLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTypeNameExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull TypeNameExpCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitUnlimitedNaturalLiteralExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitVariableCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVariableExpCS(org.eclipse.ocl.xtext.essentialoclcs.@NonNull VariableExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}
}
