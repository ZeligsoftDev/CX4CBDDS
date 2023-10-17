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
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, @NonNull D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractDelegatingVisitor(@NonNull D delegate, C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 *
	 * @return my decorated visitor
	 */
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		return delegate.visitAnnotation(object);
	}

	@Override
	public R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
		return delegate.visitAnyType(object);
	}

	@Override
	public R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
		return delegate.visitAssociationClass(object);
	}

	@Override
	public R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
		return delegate.visitAssociationClassCallExp(object);
	}

	@Override
	public R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
		return delegate.visitBagType(object);
	}

	@Override
	public R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
		return delegate.visitBehavior(object);
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
		return delegate.visitBooleanLiteralExp(object);
	}

	@Override
	public R visitBooleanType(org.eclipse.ocl.pivot.@NonNull BooleanType object) {
		return delegate.visitBooleanType(object);
	}

	@Override
	public R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
		return delegate.visitCallExp(object);
	}

	@Override
	public R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
		return delegate.visitCallOperationAction(object);
	}

	@Override
	public R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
		return delegate.visitCollectionItem(object);
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
		return delegate.visitCollectionLiteralExp(object);
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
		return delegate.visitCollectionLiteralPart(object);
	}

	@Override
	public R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
		return delegate.visitCollectionRange(object);
	}

	@Override
	public R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
		return delegate.visitCollectionType(object);
	}

	@Override
	public R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
		return delegate.visitComment(object);
	}

	@Override
	public R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
		return delegate.visitCompleteClass(object);
	}

	@Override
	public R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
		return delegate.visitCompleteEnvironment(object);
	}

	@Override
	public R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
		return delegate.visitCompleteModel(object);
	}

	@Override
	public R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
		return delegate.visitCompletePackage(object);
	}

	@Override
	public R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
		return delegate.visitConnectionPointReference(object);
	}

	@Override
	public R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
		return delegate.visitConstraint(object);
	}

	@Override
	public R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
		return delegate.visitDataType(object);
	}

	@Override
	public R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
		return delegate.visitDetail(object);
	}

	@Override
	public R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
		return delegate.visitDynamicBehavior(object);
	}

	@Override
	public R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
		return delegate.visitDynamicElement(object);
	}

	@Override
	public R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
		return delegate.visitDynamicProperty(object);
	}

	@Override
	public R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
		return delegate.visitDynamicType(object);
	}

	@Override
	public R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
		return delegate.visitDynamicValueSpecification(object);
	}

	@Override
	public R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
		return delegate.visitElementExtension(object);
	}

	@Override
	public R visitElementLiteralExp(org.eclipse.ocl.pivot.@NonNull ElementLiteralExp object) {
		return delegate.visitElementLiteralExp(object);
	}

	@Override
	public R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
		return delegate.visitEnumLiteralExp(object);
	}

	@Override
	public R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		return delegate.visitEnumeration(object);
	}

	@Override
	public R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
		return delegate.visitEnumerationLiteral(object);
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
		return delegate.visitExpressionInOCL(object);
	}

	@Override
	public R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
		return delegate.visitFeature(object);
	}

	@Override
	public R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
		return delegate.visitFeatureCallExp(object);
	}

	@Override
	public R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
		return delegate.visitFinalState(object);
	}

	@Override
	public R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
		return delegate.visitIfExp(object);
	}

	@Override
	public R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
		return delegate.visitImport(object);
	}

	@Override
	public R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
		return delegate.visitInstanceSpecification(object);
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
		return delegate.visitIntegerLiteralExp(object);
	}

	@Override
	public R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
		return delegate.visitInvalidLiteralExp(object);
	}

	@Override
	public R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
		return delegate.visitInvalidType(object);
	}

	@Override
	public R visitIterableType(org.eclipse.ocl.pivot.@NonNull IterableType object) {
		return delegate.visitIterableType(object);
	}

	@Override
	public R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
		return delegate.visitIterateExp(object);
	}

	@Override
	public R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
		return delegate.visitIteration(object);
	}

	@Override
	public R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}

	@Override
	public R visitIteratorVariable(org.eclipse.ocl.pivot.@NonNull IteratorVariable object) {
		return delegate.visitIteratorVariable(object);
	}

	@Override
	public R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
		return delegate.visitLambdaType(object);
	}

	@Override
	public R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
		return delegate.visitLanguageExpression(object);
	}

	@Override
	public R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
		return delegate.visitLetExp(object);
	}

	@Override
	public R visitLetVariable(org.eclipse.ocl.pivot.@NonNull LetVariable object) {
		return delegate.visitLetVariable(object);
	}

	@Override
	public R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
		return delegate.visitLibrary(object);
	}

	@Override
	public R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
		return delegate.visitLiteralExp(object);
	}

	@Override
	public R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
		return delegate.visitLoopExp(object);
	}

	@Override
	public R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
		return delegate.visitMapLiteralExp(object);
	}

	@Override
	public R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
		return delegate.visitMapLiteralPart(object);
	}

	@Override
	public R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
		return delegate.visitMapType(object);
	}

	@Override
	public R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
		return delegate.visitMessageExp(object);
	}

	@Override
	public R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
		return delegate.visitMessageType(object);
	}

	@Override
	public R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
		return delegate.visitModel(object);
	}

	@Override
	public R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
		return delegate.visitNavigationCallExp(object);
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
		return delegate.visitNullLiteralExp(object);
	}

	@Override
	public R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
		return delegate.visitNumericLiteralExp(object);
	}

	@Override
	public R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
		return delegate.visitOCLExpression(object);
	}

	@Override
	public R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
		return delegate.visitOperation(object);
	}

	@Override
	public R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	@Override
	public R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
		return delegate.visitOppositePropertyCallExp(object);
	}

	@Override
	public R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
		return delegate.visitOrderedSetType(object);
	}

	@Override
	public R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
		return delegate.visitOrphanCompletePackage(object);
	}

	@Override
	public R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
		return delegate.visitParameter(object);
	}

	@Override
	public R visitParameterVariable(org.eclipse.ocl.pivot.@NonNull ParameterVariable object) {
		return delegate.visitParameterVariable(object);
	}

	@Override
	public R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
		return delegate.visitPrecedence(object);
	}

	@Override
	public R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
		return delegate.visitPrimitiveCompletePackage(object);
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
		return delegate.visitPrimitiveLiteralExp(object);
	}

	@Override
	public R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
		return delegate.visitPrimitiveType(object);
	}

	@Override
	public R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
		return delegate.visitProfile(object);
	}

	@Override
	public R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
		return delegate.visitProfileApplication(object);
	}

	@Override
	public R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
		return delegate.visitProperty(object);
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	@Override
	public R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
		return delegate.visitPseudostate(object);
	}

	@Override
	public R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
		return delegate.visitRealLiteralExp(object);
	}

	@Override
	public R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
		return delegate.visitRegion(object);
	}

	@Override
	public R visitResultVariable(org.eclipse.ocl.pivot.@NonNull ResultVariable object) {
		return delegate.visitResultVariable(object);
	}

	@Override
	public R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
		return delegate.visitSelfType(object);
	}

	@Override
	public R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
		return delegate.visitSendSignalAction(object);
	}

	@Override
	public R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
		return delegate.visitSequenceType(object);
	}

	@Override
	public R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
		return delegate.visitSetType(object);
	}

	@Override
	public R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
		return delegate.visitShadowExp(object);
	}

	@Override
	public R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
		return delegate.visitShadowPart(object);
	}

	@Override
	public R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
		return delegate.visitSignal(object);
	}

	@Override
	public R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
		return delegate.visitSlot(object);
	}

	@Override
	public R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
		return delegate.visitStandardLibrary(object);
	}

	@Override
	public R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
		return delegate.visitState(object);
	}

	@Override
	public R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
		return delegate.visitStateExp(object);
	}

	@Override
	public R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
		return delegate.visitStateMachine(object);
	}

	@Override
	public R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
		return delegate.visitStereotype(object);
	}

	@Override
	public R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
		return delegate.visitStereotypeExtender(object);
	}

	@Override
	public R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
		return delegate.visitStringLiteralExp(object);
	}

	@Override
	public R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
		return delegate.visitTemplateBinding(object);
	}

	@Override
	public R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
		return delegate.visitTemplateParameter(object);
	}

	@Override
	public R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
		return delegate.visitTemplateParameterSubstitution(object);
	}

	@Override
	public R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
		return delegate.visitTemplateSignature(object);
	}

	@Override
	public R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
		return delegate.visitTemplateableElement(object);
	}

	@Override
	public R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
		return delegate.visitTransition(object);
	}

	@Override
	public R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
		return delegate.visitTrigger(object);
	}

	@Override
	public R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
		return delegate.visitTupleLiteralExp(object);
	}

	@Override
	public R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
		return delegate.visitTupleLiteralPart(object);
	}

	@Override
	public R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
		return delegate.visitTupleType(object);
	}

	@Override
	public R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
		return delegate.visitType(object);
	}

	@Override
	public R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
		return delegate.visitTypeExp(object);
	}

	@Override
	public R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
		return delegate.visitTypedElement(object);
	}

	@Override
	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
		return delegate.visitUnlimitedNaturalLiteralExp(object);
	}

	@Override
	public R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
		return delegate.visitUnspecifiedValueExp(object);
	}

	@Override
	public R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
		return delegate.visitValueSpecification(object);
	}

	@Override
	public R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
		return delegate.visitVariable(object);
	}

	@Override
	public R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
		return delegate.visitVariableDeclaration(object);
	}

	@Override
	public R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
		return delegate.visitVariableExp(object);
	}

	@Override
	public R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
		return delegate.visitVertex(object);
	}

	@Override
	public R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
		return delegate.visitVoidType(object);
	}

	@Override
	public R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
		return delegate.visitWildcardType(object);
	}
}
