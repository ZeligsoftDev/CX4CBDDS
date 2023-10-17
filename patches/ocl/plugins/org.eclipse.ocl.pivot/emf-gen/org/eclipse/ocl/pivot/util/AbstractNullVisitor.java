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
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullVisitor<@Nullable R, C>
	extends AbstractVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		return null;
	}

	@Override
	public R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
		return null;
	}

	@Override
	public R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
		return null;
	}

	@Override
	public R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
		return null;
	}

	@Override
	public R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
		return null;
	}

	@Override
	public R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
		return null;
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
		return null;
	}

	@Override
	public R visitBooleanType(org.eclipse.ocl.pivot.@NonNull BooleanType object) {
		return null;
	}

	@Override
	public R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
		return null;
	}

	@Override
	public R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
		return null;
	}

	@Override
	public R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		return null;
	}

	@Override
	public R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
		return null;
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
		return null;
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
		return null;
	}

	@Override
	public R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
		return null;
	}

	@Override
	public R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
		return null;
	}

	@Override
	public R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
		return null;
	}

	@Override
	public R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
		return null;
	}

	@Override
	public R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
		return null;
	}

	@Override
	public R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
		return null;
	}

	@Override
	public R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
		return null;
	}

	@Override
	public R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
		return null;
	}

	@Override
	public R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
		return null;
	}

	@Override
	public R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
		return null;
	}

	@Override
	public R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
		return null;
	}

	@Override
	public R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
		return null;
	}

	@Override
	public R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
		return null;
	}

	@Override
	public R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
		return null;
	}

	@Override
	public R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
		return null;
	}

	@Override
	public R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
		return null;
	}

	@Override
	public R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
		return null;
	}

	@Override
	public R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
		return null;
	}

	@Override
	public R visitElementLiteralExp(org.eclipse.ocl.pivot.@NonNull ElementLiteralExp object) {
		return null;
	}

	@Override
	public R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
		return null;
	}

	@Override
	public R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		return null;
	}

	@Override
	public R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
		return null;
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
		return null;
	}

	@Override
	public R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
		return null;
	}

	@Override
	public R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
		return null;
	}

	@Override
	public R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
		return null;
	}

	@Override
	public R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
		return null;
	}

	@Override
	public R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
		return null;
	}

	@Override
	public R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
		return null;
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
		return null;
	}

	@Override
	public R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
		return null;
	}

	@Override
	public R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
		return null;
	}

	@Override
	public R visitIterableType(org.eclipse.ocl.pivot.@NonNull IterableType object) {
		return null;
	}

	@Override
	public R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
		return null;
	}

	@Override
	public R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
		return null;
	}

	@Override
	public R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		return null;
	}

	@Override
	public R visitIteratorVariable(org.eclipse.ocl.pivot.@NonNull IteratorVariable object) {
		return null;
	}

	@Override
	public R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
		return null;
	}

	@Override
	public R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
		return null;
	}

	@Override
	public R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
		return null;
	}

	@Override
	public R visitLetVariable(org.eclipse.ocl.pivot.@NonNull LetVariable object) {
		return null;
	}

	@Override
	public R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
		return null;
	}

	@Override
	public R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
		return null;
	}

	@Override
	public R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
		return null;
	}

	@Override
	public R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
		return null;
	}

	@Override
	public R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
		return null;
	}

	@Override
	public R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
		return null;
	}

	@Override
	public R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
		return null;
	}

	@Override
	public R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
		return null;
	}

	@Override
	public R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
		return null;
	}

	@Override
	public R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
		return null;
	}

	@Override
	public R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
		return null;
	}

	@Override
	public R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
		return null;
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
		return null;
	}

	@Override
	public R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
		return null;
	}

	@Override
	public R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
		return null;
	}

	@Override
	public R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
		return null;
	}

	@Override
	public R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
		return null;
	}

	@Override
	public R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
		return null;
	}

	@Override
	public R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
		return null;
	}

	@Override
	public R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
		return null;
	}

	@Override
	public R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		return null;
	}

	@Override
	public R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
		return null;
	}

	@Override
	public R visitParameterVariable(org.eclipse.ocl.pivot.@NonNull ParameterVariable object) {
		return null;
	}

	@Override
	public R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
		return null;
	}

	@Override
	public R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
		return null;
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
		return null;
	}

	@Override
	public R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
		return null;
	}

	@Override
	public R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
		return null;
	}

	@Override
	public R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
		return null;
	}

	@Override
	public R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
		return null;
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
		return null;
	}

	@Override
	public R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
		return null;
	}

	@Override
	public R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
		return null;
	}

	@Override
	public R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
		return null;
	}

	@Override
	public R visitResultVariable(org.eclipse.ocl.pivot.@NonNull ResultVariable object) {
		return null;
	}

	@Override
	public R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
		return null;
	}

	@Override
	public R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
		return null;
	}

	@Override
	public R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
		return null;
	}

	@Override
	public R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
		return null;
	}

	@Override
	public R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
		return null;
	}

	@Override
	public R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
		return null;
	}

	@Override
	public R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
		return null;
	}

	@Override
	public R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
		return null;
	}

	@Override
	public R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
		return null;
	}

	@Override
	public R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
		return null;
	}

	@Override
	public R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
		return null;
	}

	@Override
	public R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
		return null;
	}

	@Override
	public R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
		return null;
	}

	@Override
	public R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
		return null;
	}

	@Override
	public R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
		return null;
	}

	@Override
	public R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
		return null;
	}

	@Override
	public R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
		return null;
	}

	@Override
	public R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
		return null;
	}

	@Override
	public R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
		return null;
	}

	@Override
	public R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
		return null;
	}

	@Override
	public R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
		return null;
	}

	@Override
	public R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
		return null;
	}

	@Override
	public R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
		return null;
	}

	@Override
	public R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
		return null;
	}

	@Override
	public R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
		return null;
	}

	@Override
	public R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
		return null;
	}

	@Override
	public R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
		return null;
	}

	@Override
	public R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
		return null;
	}

	@Override
	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
		return null;
	}

	@Override
	public R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
		return null;
	}

	@Override
	public R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
		return null;
	}

	@Override
	public R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
		return null;
	}

	@Override
	public R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
		return null;
	}

	@Override
	public R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
		return null;
	}

	@Override
	public R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
		return null;
	}

	@Override
	public R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
		return null;
	}

	@Override
	public R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
		return null;
	}
}
