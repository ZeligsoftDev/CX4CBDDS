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
 * from: org.eclipse.ocl.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.basecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingBaseCSVisitor<R, C, @NonNull D extends BaseCSVisitor<R>>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractDelegatingBaseCSVisitor(@NonNull D delegate, C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableBaseCSVisitor<R> createNestedVisitor() {
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
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAnnotationCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationCS object) {
		return delegate.visitAnnotationCS(object);
	}

	@Override
	public R visitAnnotationElementCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationElementCS object) {
		return delegate.visitAnnotationElementCS(object);
	}

	@Override
	public R visitAttributeCS(org.eclipse.ocl.xtext.basecs.@NonNull AttributeCS object) {
		return delegate.visitAttributeCS(object);
	}

	@Override
	public R visitClassCS(org.eclipse.ocl.xtext.basecs.@NonNull ClassCS object) {
		return delegate.visitClassCS(object);
	}

	@Override
	public R visitConstraintCS(org.eclipse.ocl.xtext.basecs.@NonNull ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	@Override
	public R visitContextLessElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ContextLessElementCS object) {
		return delegate.visitContextLessElementCS(object);
	}

	@Override
	public R visitDataTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull DataTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	@Override
	public R visitDetailCS(org.eclipse.ocl.xtext.basecs.@NonNull DetailCS object) {
		return delegate.visitDetailCS(object);
	}

	@Override
	public R visitDocumentationCS(org.eclipse.ocl.xtext.basecs.@NonNull DocumentationCS object) {
		return delegate.visitDocumentationCS(object);
	}

	@Override
	public R visitElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementCS object) {
		return delegate.visitElementCS(object);
	}

	@Override
	public R visitElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementRefCS object) {
		return delegate.visitElementRefCS(object);
	}

	@Override
	public R visitEnumerationCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	@Override
	public R visitEnumerationLiteralCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationLiteralCS object) {
		return delegate.visitEnumerationLiteralCS(object);
	}

	@Override
	public R visitFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull FeatureCS object) {
		return delegate.visitFeatureCS(object);
	}

	@Override
	public R visitImplicitOppositeCS(org.eclipse.ocl.xtext.basecs.@NonNull ImplicitOppositeCS object) {
		return delegate.visitImplicitOppositeCS(object);
	}

	@Override
	public R visitImportCS(org.eclipse.ocl.xtext.basecs.@NonNull ImportCS object) {
		return delegate.visitImportCS(object);
	}

	@Override
	public R visitLambdaTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull LambdaTypeCS object) {
		return delegate.visitLambdaTypeCS(object);
	}

	@Override
	public R visitModelElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementCS object) {
		return delegate.visitModelElementCS(object);
	}

	@Override
	public R visitModelElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementRefCS object) {
		return delegate.visitModelElementRefCS(object);
	}

	@Override
	public R visitMultiplicityBoundsCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityBoundsCS object) {
		return delegate.visitMultiplicityBoundsCS(object);
	}

	@Override
	public R visitMultiplicityCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityCS object) {
		return delegate.visitMultiplicityCS(object);
	}

	@Override
	public R visitMultiplicityStringCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityStringCS object) {
		return delegate.visitMultiplicityStringCS(object);
	}

	@Override
	public R visitNamedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull NamedElementCS object) {
		return delegate.visitNamedElementCS(object);
	}

	@Override
	public R visitNamespaceCS(org.eclipse.ocl.xtext.basecs.@NonNull NamespaceCS object) {
		return delegate.visitNamespaceCS(object);
	}

	@Override
	public R visitOperationCS(org.eclipse.ocl.xtext.basecs.@NonNull OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	@Override
	public R visitPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageCS object) {
		return delegate.visitPackageCS(object);
	}

	@Override
	public R visitPackageOwnerCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageOwnerCS object) {
		return delegate.visitPackageOwnerCS(object);
	}

	@Override
	public R visitParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	@Override
	public R visitPathElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementCS object) {
		return delegate.visitPathElementCS(object);
	}

	@Override
	public R visitPathElementWithURICS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementWithURICS object) {
		return delegate.visitPathElementWithURICS(object);
	}

	@Override
	public R visitPathNameCS(org.eclipse.ocl.xtext.basecs.@NonNull PathNameCS object) {
		return delegate.visitPathNameCS(object);
	}

	@Override
	public R visitPivotableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PivotableElementCS object) {
		return delegate.visitPivotableElementCS(object);
	}

	@Override
	public R visitPrimitiveTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull PrimitiveTypeRefCS object) {
		return delegate.visitPrimitiveTypeRefCS(object);
	}

	@Override
	public R visitReferenceCS(org.eclipse.ocl.xtext.basecs.@NonNull ReferenceCS object) {
		return delegate.visitReferenceCS(object);
	}

	@Override
	public R visitRootCS(org.eclipse.ocl.xtext.basecs.@NonNull RootCS object) {
		return delegate.visitRootCS(object);
	}

	@Override
	public R visitRootPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull RootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	@Override
	public R visitSpecificationCS(org.eclipse.ocl.xtext.basecs.@NonNull SpecificationCS object) {
		return delegate.visitSpecificationCS(object);
	}

	@Override
	public R visitStructuralFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuralFeatureCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	@Override
	public R visitStructuredClassCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuredClassCS object) {
		return delegate.visitStructuredClassCS(object);
	}

	@Override
	public R visitTemplateBindingCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateBindingCS object) {
		return delegate.visitTemplateBindingCS(object);
	}

	@Override
	public R visitTemplateParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterCS object) {
		return delegate.visitTemplateParameterCS(object);
	}

	@Override
	public R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterSubstitutionCS object) {
		return delegate.visitTemplateParameterSubstitutionCS(object);
	}

	@Override
	public R visitTemplateSignatureCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateSignatureCS object) {
		return delegate.visitTemplateSignatureCS(object);
	}

	@Override
	public R visitTemplateableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateableElementCS object) {
		return delegate.visitTemplateableElementCS(object);
	}

	@Override
	public R visitTuplePartCS(org.eclipse.ocl.xtext.basecs.@NonNull TuplePartCS object) {
		return delegate.visitTuplePartCS(object);
	}

	@Override
	public R visitTupleTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TupleTypeCS object) {
		return delegate.visitTupleTypeCS(object);
	}

	@Override
	public R visitTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeCS object) {
		return delegate.visitTypeCS(object);
	}

	@Override
	public R visitTypeParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeParameterCS object) {
		return delegate.visitTypeParameterCS(object);
	}

	@Override
	public R visitTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeRefCS object) {
		return delegate.visitTypeRefCS(object);
	}

	@Override
	public R visitTypedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedElementCS object) {
		return delegate.visitTypedElementCS(object);
	}

	@Override
	public R visitTypedRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedRefCS object) {
		return delegate.visitTypedRefCS(object);
	}

	@Override
	public R visitTypedTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedTypeRefCS object) {
		return delegate.visitTypedTypeRefCS(object);
	}

	@Override
	public R visitWildcardTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull WildcardTypeRefCS object) {
		return delegate.visitWildcardTypeRefCS(object);
	}
}
