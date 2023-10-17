/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package	org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An IdVisitor supports visting an ElementId to react according to the derived Element type.
 */
public interface IdVisitor<R>
{
	R visitClassId(@NonNull ClassId id);
	R visitCollectionTypeId(@NonNull CollectionTypeId id);
	R visitDataTypeId(@NonNull DataTypeId id);
	R visitEnumerationId(@NonNull EnumerationId id);
	R visitEnumerationLiteralId(@NonNull EnumerationLiteralId id);
	R visitInvalidId(@NonNull OclInvalidTypeId id);
	R visitLambdaTypeId(@NonNull LambdaTypeId id);
	R visitMapTypeId(@NonNull MapTypeId id);
	R visitNestedPackageId(@NonNull NestedPackageId id);
	R visitNsURIPackageId(@NonNull NsURIPackageId id);
	R visitNullId(@NonNull OclVoidTypeId id);
	R visitOperationId(@NonNull OperationId id);
	R visitPrimitiveTypeId(@NonNull PrimitiveTypeId id);
	R visitPropertyId(@NonNull PropertyId id);
	R visitRootPackageId(@NonNull RootPackageId id);
	R visitTemplateBinding(@NonNull TemplateBinding id);
	R visitTemplateParameterId(@NonNull TemplateParameterId id);
	R visitTemplateableTypeId(@NonNull TemplateableTypeId id);
	R visitTuplePartId(@NonNull TuplePartId id);
	R visitTupleTypeId(@NonNull TupleTypeId id);
	R visitUnspecifiedId(@NonNull UnspecifiedId id);
	R visitWildcardId(@NonNull  WildcardId id);
}
