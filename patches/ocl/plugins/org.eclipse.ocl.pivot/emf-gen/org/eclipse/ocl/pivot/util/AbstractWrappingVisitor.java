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
 * An AbstractWrappingVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingVisitor<R, C, @NonNull D extends Visitor<R>, P>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractWrappingVisitor(@NonNull D delegate, C context) {
		super(context);
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the thrown exception to determine the overall wrapped result.
	 *
	 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
	 */
	protected R badVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtains the visitor that I wrap.
	 *
	 * @return my wrapped visitor
	 */
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 *
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected R postVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable, @Nullable P prologue, R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 *
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return null;
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAnnotation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAnyType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAssociationClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAssociationClassCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBagType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBehavior(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBooleanType(org.eclipse.ocl.pivot.@NonNull BooleanType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCallOperationAction(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionItem(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionRange(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitComment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteEnvironment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConnectionPointReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConstraint(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDataType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDetail(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicBehavior(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicValueSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitElementExtension(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitElementLiteralExp(org.eclipse.ocl.pivot.@NonNull ElementLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitElementLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumeration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumerationLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExpressionInOCL(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFeature(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFeatureCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFinalState(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIfExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImport(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInstanceSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIntegerLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInvalidLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInvalidType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIterableType(org.eclipse.ocl.pivot.@NonNull IterableType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIterableType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIterateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratorExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteratorVariable(org.eclipse.ocl.pivot.@NonNull IteratorVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratorVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLambdaType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLanguageExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLetExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLetVariable(org.eclipse.ocl.pivot.@NonNull LetVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLetVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLibrary(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMessageExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMessageType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamespace(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNavigationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNullLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNumericLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOCLExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOppositePropertyCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOrderedSetType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOrphanCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitParameterVariable(org.eclipse.ocl.pivot.@NonNull ParameterVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitParameterVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrecedence(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProfile(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProfileApplication(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPropertyCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPseudostate(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRealLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitResultVariable(org.eclipse.ocl.pivot.@NonNull ResultVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitResultVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSelfType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSendSignalAction(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSequenceType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSetType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSignal(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSlot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStandardLibrary(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitState(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStateMachine(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStereotype(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStereotypeExtender(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStringLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateParameterSubstitution(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateSignature(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateableElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTransition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTrigger(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnlimitedNaturalLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnspecifiedValueExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitValueSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVertex(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVoidType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitWildcardType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
