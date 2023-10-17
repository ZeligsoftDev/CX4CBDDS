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

/**
 * An AbstractMergedVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected AbstractMergedVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		return visiting(object);
	}

	@Override
	public R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
		return visiting(object);
	}

	@Override
	public R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
		return visiting(object);
	}

	@Override
	public R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
		return visiting(object);
	}

	@Override
	public R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
		return visiting(object);
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitBooleanType(org.eclipse.ocl.pivot.@NonNull BooleanType object) {
		return visiting(object);
	}

	@Override
	public R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
		return visiting(object);
	}

	@Override
	public R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
		return visiting(object);
	}

	@Override
	public R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
		return visiting(object);
	}

	@Override
	public R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
		return visiting(object);
	}

	@Override
	public R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
		return visiting(object);
	}

	@Override
	public R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
		return visiting(object);
	}

	@Override
	public R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
		return visiting(object);
	}

	@Override
	public R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
		return visiting(object);
	}

	@Override
	public R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
		return visiting(object);
	}

	@Override
	public R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
		return visiting(object);
	}

	@Override
	public R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
		return visiting(object);
	}

	@Override
	public R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
		return visiting(object);
	}

	@Override
	public R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
		return visiting(object);
	}

	@Override
	public R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
		return visiting(object);
	}

	@Override
	public R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
		return visiting(object);
	}

	@Override
	public R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
		return visiting(object);
	}

	@Override
	public R visitElementLiteralExp(org.eclipse.ocl.pivot.@NonNull ElementLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		return visiting(object);
	}

	@Override
	public R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
		return visiting(object);
	}

	@Override
	public R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
		return visiting(object);
	}

	@Override
	public R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
		return visiting(object);
	}

	@Override
	public R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
		return visiting(object);
	}

	@Override
	public R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
		return visiting(object);
	}

	@Override
	public R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
		return visiting(object);
	}

	@Override
	public R visitIterableType(org.eclipse.ocl.pivot.@NonNull IterableType object) {
		return visiting(object);
	}

	@Override
	public R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
		return visiting(object);
	}

	@Override
	public R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
		return visiting(object);
	}

	@Override
	public R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		return visiting(object);
	}

	@Override
	public R visitIteratorVariable(org.eclipse.ocl.pivot.@NonNull IteratorVariable object) {
		return visiting(object);
	}

	@Override
	public R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
		return visiting(object);
	}

	@Override
	public R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
		return visiting(object);
	}

	@Override
	public R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
		return visiting(object);
	}

	@Override
	public R visitLetVariable(org.eclipse.ocl.pivot.@NonNull LetVariable object) {
		return visiting(object);
	}

	@Override
	public R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
		return visiting(object);
	}

	@Override
	public R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
		return visiting(object);
	}

	@Override
	public R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
		return visiting(object);
	}

	@Override
	public R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
		return visiting(object);
	}

	@Override
	public R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
		return visiting(object);
	}

	@Override
	public R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
		return visiting(object);
	}

	@Override
	public R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
		return visiting(object);
	}

	@Override
	public R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
		return visiting(object);
	}

	@Override
	public R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
		return visiting(object);
	}

	@Override
	public R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
		return visiting(object);
	}

	@Override
	public R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
		return visiting(object);
	}

	@Override
	public R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
		return visiting(object);
	}

	@Override
	public R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
		return visiting(object);
	}

	@Override
	public R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		return visiting(object);
	}

	@Override
	public R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
		return visiting(object);
	}

	@Override
	public R visitParameterVariable(org.eclipse.ocl.pivot.@NonNull ParameterVariable object) {
		return visiting(object);
	}

	@Override
	public R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
		return visiting(object);
	}

	@Override
	public R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
		return visiting(object);
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
		return visiting(object);
	}

	@Override
	public R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
		return visiting(object);
	}

	@Override
	public R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
		return visiting(object);
	}

	@Override
	public R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
		return visiting(object);
	}

	@Override
	public R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
		return visiting(object);
	}

	@Override
	public R visitResultVariable(org.eclipse.ocl.pivot.@NonNull ResultVariable object) {
		return visiting(object);
	}

	@Override
	public R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
		return visiting(object);
	}

	@Override
	public R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
		return visiting(object);
	}

	@Override
	public R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
		return visiting(object);
	}

	@Override
	public R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
		return visiting(object);
	}

	@Override
	public R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
		return visiting(object);
	}

	@Override
	public R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
		return visiting(object);
	}

	@Override
	public R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
		return visiting(object);
	}

	@Override
	public R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
		return visiting(object);
	}

	@Override
	public R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
		return visiting(object);
	}

	@Override
	public R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
		return visiting(object);
	}

	@Override
	public R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
		return visiting(object);
	}

	@Override
	public R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
		return visiting(object);
	}

	@Override
	public R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
		return visiting(object);
	}

	@Override
	public R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
		return visiting(object);
	}

	@Override
	public R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
		return visiting(object);
	}

	@Override
	public R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
		return visiting(object);
	}

	@Override
	public R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
		return visiting(object);
	}

	@Override
	public R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
		return visiting(object);
	}

	@Override
	public R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
		return visiting(object);
	}

	@Override
	public R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
		return visiting(object);
	}

	@Override
	public R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
		return visiting(object);
	}

	@Override
	public R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
		return visiting(object);
	}

	@Override
	public R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
		return visiting(object);
	}

	@Override
	public R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
		return visiting(object);
	}

	@Override
	public R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
		return visiting(object);
	}

	@Override
	public R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
		return visiting(object);
	}

	@Override
	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
		return visiting(object);
	}

	@Override
	public R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
		return visiting(object);
	}

	@Override
	public R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
		return visiting(object);
	}

	@Override
	public R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
		return visiting(object);
	}

	@Override
	public R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
		return visiting(object);
	}

	@Override
	public R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
		return visiting(object);
	}

	@Override
	public R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
		return visiting(object);
	}

	@Override
	public R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
		return visiting(object);
	}
}
