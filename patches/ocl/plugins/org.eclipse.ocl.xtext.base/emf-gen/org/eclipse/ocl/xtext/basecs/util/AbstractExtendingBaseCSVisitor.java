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
 * An AbstractExtendingBaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingBaseCSVisitor<R, C>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingBaseCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAnnotationCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public R visitAnnotationElementCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationElementCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitAttributeCS(org.eclipse.ocl.xtext.basecs.@NonNull AttributeCS object) {
		return visitStructuralFeatureCS(object);
	}

	@Override
	public R visitClassCS(org.eclipse.ocl.xtext.basecs.@NonNull ClassCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitConstraintCS(org.eclipse.ocl.xtext.basecs.@NonNull ConstraintCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitContextLessElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ContextLessElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitDataTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull DataTypeCS object) {
		return visitClassCS(object);
	}

	@Override
	public R visitDetailCS(org.eclipse.ocl.xtext.basecs.@NonNull DetailCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitDocumentationCS(org.eclipse.ocl.xtext.basecs.@NonNull DocumentationCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public R visitElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementCS object) {
		return visiting(object);
	}

	@Override
	public R visitElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementRefCS object) {
		return visitPivotableElementCS(object);
	}

	@Override
	public R visitEnumerationCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationCS object) {
		return visitClassCS(object);
	}

	@Override
	public R visitEnumerationLiteralCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationLiteralCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull FeatureCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitImplicitOppositeCS(org.eclipse.ocl.xtext.basecs.@NonNull ImplicitOppositeCS object) {
		return visitFeatureCS(object);
	}

	@Override
	public R visitImportCS(org.eclipse.ocl.xtext.basecs.@NonNull ImportCS object) {
		return visitNamespaceCS(object);
	}

	@Override
	public R visitLambdaTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull LambdaTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitModelElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementCS object) {
		return visitPivotableElementCS(object);
	}

	@Override
	public R visitModelElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementRefCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public R visitMultiplicityBoundsCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityBoundsCS object) {
		return visitMultiplicityCS(object);
	}

	@Override
	public R visitMultiplicityCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitMultiplicityStringCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityStringCS object) {
		return visitMultiplicityCS(object);
	}

	@Override
	public R visitNamedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull NamedElementCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitNamespaceCS(org.eclipse.ocl.xtext.basecs.@NonNull NamespaceCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitOperationCS(org.eclipse.ocl.xtext.basecs.@NonNull OperationCS object) {
		return visitFeatureCS(object);
	}

	@Override
	public R visitPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageCS object) {
		return visitPackageOwnerCS(object);
	}

	@Override
	public R visitPackageOwnerCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageOwnerCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull ParameterCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitPathElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitPathElementWithURICS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementWithURICS object) {
		return visitPathElementCS(object);
	}

	@Override
	public R visitPathNameCS(org.eclipse.ocl.xtext.basecs.@NonNull PathNameCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitPivotableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PivotableElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitPrimitiveTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull PrimitiveTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitReferenceCS(org.eclipse.ocl.xtext.basecs.@NonNull ReferenceCS object) {
		return visitStructuralFeatureCS(object);
	}

	@Override
	public R visitRootCS(org.eclipse.ocl.xtext.basecs.@NonNull RootCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitRootPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull RootPackageCS object) {
		return visitPackageOwnerCS(object);
	}

	@Override
	public R visitSpecificationCS(org.eclipse.ocl.xtext.basecs.@NonNull SpecificationCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitStructuralFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuralFeatureCS object) {
		return visitFeatureCS(object);
	}

	@Override
	public R visitStructuredClassCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuredClassCS object) {
		return visitClassCS(object);
	}

	@Override
	public R visitTemplateBindingCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateBindingCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public R visitTemplateParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterSubstitutionCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitTemplateSignatureCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateSignatureCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitTemplateableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateableElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public R visitTuplePartCS(org.eclipse.ocl.xtext.basecs.@NonNull TuplePartCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitTupleTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TupleTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitTypeParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeParameterCS object) {
		return visitTemplateParameterCS(object);
	}

	@Override
	public R visitTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeRefCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public R visitTypedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedElementCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitTypedRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedRefCS object) {
		return visitTypeRefCS(object);
	}

	@Override
	public R visitTypedTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public R visitWildcardTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull WildcardTypeRefCS object) {
		return visitTypeRefCS(object);
	}
}
