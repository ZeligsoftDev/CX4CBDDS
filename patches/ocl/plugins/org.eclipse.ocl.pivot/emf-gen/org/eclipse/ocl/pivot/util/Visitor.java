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
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Visitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class,
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable);

	R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object);
	R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object);
	R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object);
	R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object);
	R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object);
	R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object);
	R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object);
	R visitBooleanType(org.eclipse.ocl.pivot.@NonNull BooleanType object);
	R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object);
	R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object);
	R visitClass(org.eclipse.ocl.pivot.@NonNull Class object);
	R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object);
	R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object);
	R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object);
	R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object);
	R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object);
	R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object);
	R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object);
	R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object);
	R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object);
	R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object);
	R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object);
	R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object);
	R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object);
	R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object);
	R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object);
	R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object);
	R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object);
	R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object);
	R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object);
	R visitElement(org.eclipse.ocl.pivot.@NonNull Element object);
	R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object);
	R visitElementLiteralExp(org.eclipse.ocl.pivot.@NonNull ElementLiteralExp object);
	R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object);
	R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object);
	R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object);
	R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object);
	R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object);
	R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object);
	R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object);
	R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object);
	R visitImport(org.eclipse.ocl.pivot.@NonNull Import object);
	R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object);
	R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object);
	R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object);
	R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object);
	R visitIterableType(org.eclipse.ocl.pivot.@NonNull IterableType object);
	R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object);
	R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object);
	R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object);
	R visitIteratorVariable(org.eclipse.ocl.pivot.@NonNull IteratorVariable object);
	R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object);
	R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object);
	R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object);
	R visitLetVariable(org.eclipse.ocl.pivot.@NonNull LetVariable object);
	R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object);
	R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object);
	R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object);
	R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object);
	R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object);
	R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object);
	R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object);
	R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object);
	R visitModel(org.eclipse.ocl.pivot.@NonNull Model object);
	R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object);
	R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object);
	R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object);
	R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object);
	R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object);
	R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object);
	R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object);
	R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object);
	R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object);
	R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object);
	R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object);
	R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object);
	R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object);
	R visitParameterVariable(org.eclipse.ocl.pivot.@NonNull ParameterVariable object);
	R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object);
	R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object);
	R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object);
	R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object);
	R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object);
	R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object);
	R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object);
	R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object);
	R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object);
	R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object);
	R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object);
	R visitResultVariable(org.eclipse.ocl.pivot.@NonNull ResultVariable object);
	R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object);
	R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object);
	R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object);
	R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object);
	R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object);
	R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object);
	R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object);
	R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object);
	R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object);
	R visitState(org.eclipse.ocl.pivot.@NonNull State object);
	R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object);
	R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object);
	R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object);
	R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object);
	R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object);
	R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object);
	R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object);
	R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object);
	R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object);
	R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object);
	R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object);
	R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object);
	R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object);
	R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object);
	R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object);
	R visitType(org.eclipse.ocl.pivot.@NonNull Type object);
	R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object);
	R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object);
	R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object);
	R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object);
	R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object);
	R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object);
	R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object);
	R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object);
	R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object);
	R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object);
	R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object);
}
