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
import org.eclipse.jdt.annotation.Nullable;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface BaseCSVisitor<R>
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
	R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable);

	R visitAnnotationCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationCS object);
	R visitAnnotationElementCS(org.eclipse.ocl.xtext.basecs.@NonNull AnnotationElementCS object);
	R visitAttributeCS(org.eclipse.ocl.xtext.basecs.@NonNull AttributeCS object);
	R visitClassCS(org.eclipse.ocl.xtext.basecs.@NonNull ClassCS object);
	R visitConstraintCS(org.eclipse.ocl.xtext.basecs.@NonNull ConstraintCS object);
	R visitContextLessElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ContextLessElementCS object);
	R visitDataTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull DataTypeCS object);
	R visitDetailCS(org.eclipse.ocl.xtext.basecs.@NonNull DetailCS object);
	R visitDocumentationCS(org.eclipse.ocl.xtext.basecs.@NonNull DocumentationCS object);
	R visitElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementCS object);
	R visitElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ElementRefCS object);
	R visitEnumerationCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationCS object);
	R visitEnumerationLiteralCS(org.eclipse.ocl.xtext.basecs.@NonNull EnumerationLiteralCS object);
	R visitFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull FeatureCS object);
	R visitImplicitOppositeCS(org.eclipse.ocl.xtext.basecs.@NonNull ImplicitOppositeCS object);
	R visitImportCS(org.eclipse.ocl.xtext.basecs.@NonNull ImportCS object);
	R visitLambdaTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull LambdaTypeCS object);
	R visitModelElementCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementCS object);
	R visitModelElementRefCS(org.eclipse.ocl.xtext.basecs.@NonNull ModelElementRefCS object);
	R visitMultiplicityBoundsCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityBoundsCS object);
	R visitMultiplicityCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityCS object);
	R visitMultiplicityStringCS(org.eclipse.ocl.xtext.basecs.@NonNull MultiplicityStringCS object);
	R visitNamedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull NamedElementCS object);
	R visitNamespaceCS(org.eclipse.ocl.xtext.basecs.@NonNull NamespaceCS object);
	R visitOperationCS(org.eclipse.ocl.xtext.basecs.@NonNull OperationCS object);
	R visitPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageCS object);
	R visitPackageOwnerCS(org.eclipse.ocl.xtext.basecs.@NonNull PackageOwnerCS object);
	R visitParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull ParameterCS object);
	R visitPathElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementCS object);
	R visitPathElementWithURICS(org.eclipse.ocl.xtext.basecs.@NonNull PathElementWithURICS object);
	R visitPathNameCS(org.eclipse.ocl.xtext.basecs.@NonNull PathNameCS object);
	R visitPivotableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull PivotableElementCS object);
	R visitPrimitiveTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull PrimitiveTypeRefCS object);
	R visitReferenceCS(org.eclipse.ocl.xtext.basecs.@NonNull ReferenceCS object);
	R visitRootCS(org.eclipse.ocl.xtext.basecs.@NonNull RootCS object);
	R visitRootPackageCS(org.eclipse.ocl.xtext.basecs.@NonNull RootPackageCS object);
	R visitSpecificationCS(org.eclipse.ocl.xtext.basecs.@NonNull SpecificationCS object);
	R visitStructuralFeatureCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuralFeatureCS object);
	R visitStructuredClassCS(org.eclipse.ocl.xtext.basecs.@NonNull StructuredClassCS object);
	R visitTemplateBindingCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateBindingCS object);
	R visitTemplateParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterCS object);
	R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateParameterSubstitutionCS object);
	R visitTemplateSignatureCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateSignatureCS object);
	R visitTemplateableElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TemplateableElementCS object);
	R visitTuplePartCS(org.eclipse.ocl.xtext.basecs.@NonNull TuplePartCS object);
	R visitTupleTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TupleTypeCS object);
	R visitTypeCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeCS object);
	R visitTypeParameterCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeParameterCS object);
	R visitTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypeRefCS object);
	R visitTypedElementCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedElementCS object);
	R visitTypedRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedRefCS object);
	R visitTypedTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull TypedTypeRefCS object);
	R visitWildcardTypeRefCS(org.eclipse.ocl.xtext.basecs.@NonNull WildcardTypeRefCS object);
}
