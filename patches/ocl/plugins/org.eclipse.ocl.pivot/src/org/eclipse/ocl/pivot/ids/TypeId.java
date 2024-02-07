/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ids.OclInvalidTypeIdImpl;
import org.eclipse.ocl.pivot.internal.ids.OclVoidTypeIdImpl;

/**
 * A TypeId provides a unique hierarchical semantic identifier for type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 * <p>
 * Logically merged types may have different package NsURIs but the same TypeId.
 *
 * @see CollectionTypeId
 * @see LambdaTypeId
 * @see OclInvalidTypeId
 * @see OclVoidTypeId
 * @see PrimitiveTypeId
 * @see TupleTypeId
 */
public interface TypeId extends ElementId
{
	/**
	 * @since 1.18
	 */
	public static final @NonNull String ANY_TYPE_NAME = "AnyType";
	public static final @NonNull String BAG_NAME = "Bag";
	public static final @NonNull String BAG_TYPE_NAME = "BagType";
	public static final @NonNull String BOOLEAN_NAME = "Boolean";
	/**
	 * @since 1.18
	 */
	public static final @NonNull String BOOLEAN_TYPE_NAME = "BooleanType";
	public static final @NonNull String CLASS_NAME = "Class";
	public static final @NonNull String COLLECTION_NAME = "Collection";
	public static final @NonNull String COLLECTION_TYPE_NAME = "CollectionType";
	public static final @NonNull String DATA_TYPE_NAME = "DataType";
	public static final @NonNull String ENUMERATION_NAME = "Enumeration";
	public static final @NonNull String INTEGER_NAME = "Integer";
	public static final @NonNull String INTEGER_RANGE_NAME = "IntegerRange";
	/**
	 * @since 1.18
	 */
	public static final @NonNull String INVALID_TYPE_NAME = "InvalidType";
	/**
	 * @since 1.6
	 */
	public static final @NonNull String ITERABLE_NAME = "Iterable";
	/**
	 * @since 1.18
	 */
	public static final @NonNull String LAMBDA_NAME = "Lambda";
	public static final @NonNull String LAMBDA_TYPE_NAME = "LambdaType";
	public static final @NonNull String MAP_ENTRY_NAME = "MapEntry";
	public static final @NonNull String MAP_NAME = "Map";
	public static final @NonNull String MAP_TYPE_NAME = "MapType";
	public static final @NonNull String METACLASS_NAME = "Metaclass";
	public static final @NonNull String OCL_ANY_NAME = "OclAny";
	public static final @NonNull String OCL_COMPARABLE_NAME = "OclComparable";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_ELEMENT_NAME = "OclElement";
	/**
	 * @since 1.1
	 */
	public static final @NonNull String OCL_ENUMERATION_NAME = "OclEnumeration";
	public static final @NonNull String OCL_INVALID_NAME = "OclInvalid";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_LAMBDA_NAME = "OclLambda";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_MESSAGE_NAME = "OclMessage";
	public static final @NonNull String OCL_SELF_NAME = "OclSelf";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_STATE_NAME = "OclState";
	/**
	 * @since 1.1
	 */
	public static final @NonNull String OCL_STEREOTYPE_NAME = "OclStereotype";
	public static final @NonNull String OCL_SUMMABLE_NAME = "OclSummable";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_TUPLE_NAME = "OclTuple";
	/**
	 * @since 1.17
	 */
	public static final @NonNull String OCL_TYPE_NAME = "OclType";
	public static final @NonNull String OCL_VOID_NAME = "OclVoid";
	public static final @NonNull String OPERATION_NAME = "Operation";
	public static final @NonNull String ORDERED_COLLECTION_NAME = "OrderedCollection";
	public static final @NonNull String ORDERED_SET_NAME = "OrderedSet";
	public static final @NonNull String ORDERED_SET_TYPE_NAME = "OrderedSetType";
	public static final @NonNull String PRIMITIVE_TYPE_NAME = "PrimitiveType";
	public static final @NonNull String PROPERTY_NAME = "Property";
	public static final @NonNull String REAL_NAME = "Real";
	public static final @NonNull String SEQUENCE_NAME = "Sequence";
	public static final @NonNull String SEQUENCE_TYPE_NAME = "SequenceType";
	public static final @NonNull String SET_NAME = "Set";
	public static final @NonNull String SET_TYPE_NAME = "SetType";
	/**
	 * @since 1.18
	 */
	public static final @NonNull String STEREOTYPE_NAME = "Stereotype";
	public static final @NonNull String STRING_NAME = "String";
	public static final @NonNull String TUPLE_NAME = "Tuple";
	public static final @NonNull String TUPLE_TYPE_NAME = "TupleType";
	public static final @NonNull String UNIQUE_COLLECTION_NAME = "UniqueCollection";
	public static final @NonNull String UNLIMITED_NATURAL_NAME = "UnlimitedNatural";
	/**
	 * @since 1.18
	 */
	public static final @NonNull String VOID_TYPE_NAME = "VoidType";

	public static final @NonNull PrimitiveTypeId BOOLEAN = IdManager.getPrimitiveTypeId(BOOLEAN_NAME);
	public static final @NonNull PrimitiveTypeId INTEGER = IdManager.getPrimitiveTypeId(INTEGER_NAME);

	/**
	 * For code generation we need some kind of type identifier for a range. Perhaps it could be a Collection. For now
	 * a distinct primitive at least makes it different to everything else.
	 */
	public static final @NonNull PrimitiveTypeId INTEGER_RANGE = IdManager.getPrimitiveTypeId(INTEGER_RANGE_NAME);
	public static final @NonNull PrimitiveTypeId MAP_ENTRY = IdManager.getPrimitiveTypeId(MAP_ENTRY_NAME);
	public static final @NonNull PrimitiveTypeId OCL_ANY = IdManager.getPrimitiveTypeId(OCL_ANY_NAME);
	public static final @NonNull PrimitiveTypeId OCL_COMPARABLE = IdManager.getPrimitiveTypeId(OCL_COMPARABLE_NAME);
	/**
	 * @since 1.1
	 */
	public static final @NonNull PrimitiveTypeId OCL_ENUMERATION = IdManager.getPrimitiveTypeId(OCL_ENUMERATION_NAME);

	/**
	 * OclInvalid has a distinct Id that captures its conformance to everything and very limited validity.
	 */
	public static final @NonNull OclInvalidTypeId OCL_INVALID = new OclInvalidTypeIdImpl(OCL_INVALID_NAME);
	public static final @NonNull PrimitiveTypeId OCL_SELF = IdManager.getPrimitiveTypeId(OCL_SELF_NAME);	// ?? need SelfTypeId
	/**
	 * @since 1.18
	 */
	public static final @NonNull ClassId OCL_STEREOTYPE = IdManager.METAMODEL.getClassId(OCL_STEREOTYPE_NAME, 0);
	public static final @NonNull PrimitiveTypeId OCL_SUMMABLE = IdManager.getPrimitiveTypeId(OCL_SUMMABLE_NAME);
	/**
	 * @since 1.18
	 */
	public static final @NonNull ClassId OCL_TYPE = IdManager.METAMODEL.getClassId(OCL_TYPE_NAME, 0);

	/**
	 * OclVoid has a distinct Id that captures its conformance to everything (except invalid).
	 */
	public static final @NonNull OclVoidTypeId OCL_VOID = new OclVoidTypeIdImpl(OCL_VOID_NAME);
	public static final @NonNull PrimitiveTypeId REAL = IdManager.getPrimitiveTypeId(REAL_NAME);
	public static final @NonNull PrimitiveTypeId STRING = IdManager.getPrimitiveTypeId(STRING_NAME);
	public static final @NonNull PrimitiveTypeId UNLIMITED_NATURAL = IdManager.getPrimitiveTypeId(UNLIMITED_NATURAL_NAME);

	public static final @NonNull CollectionTypeId BAG = IdManager.getCollectionTypeId(BAG_NAME);
	public static final @NonNull CollectionTypeId COLLECTION = IdManager.getCollectionTypeId(COLLECTION_NAME);
	public static final @NonNull CollectionTypeId ORDERED_COLLECTION = IdManager.getCollectionTypeId(ORDERED_COLLECTION_NAME);
	public static final @NonNull CollectionTypeId ORDERED_SET = IdManager.getCollectionTypeId(ORDERED_SET_NAME);
	public static final @NonNull CollectionTypeId SEQUENCE = IdManager.getCollectionTypeId(SEQUENCE_NAME);
	public static final @NonNull CollectionTypeId SET = IdManager.getCollectionTypeId(SET_NAME);
	public static final @NonNull CollectionTypeId UNIQUE_COLLECTION = IdManager.getCollectionTypeId(UNIQUE_COLLECTION_NAME);

	/**
	 * @since 1.18
	 */
	public static final @NonNull LambdaTypeId LAMBDA = IdManager.getLambdaTypeId(LAMBDA_NAME);
	public static final @NonNull MapTypeId MAP = IdManager.getMapTypeId(MAP_NAME);

	@Deprecated /* @deprecated no longer used */
	public static final @NonNull TemplateParameterId T_1 = IdManager.getTemplateParameterId(0);
	@Deprecated /* @deprecated no longer used */
	public static final @NonNull TemplateParameterId T_2 = IdManager.getTemplateParameterId(1);
	@Deprecated /* @deprecated no longer used */
	public static final @NonNull TemplateParameterId T_3 = IdManager.getTemplateParameterId(2);

	public static final @NonNull String @NonNull [] NULL_STRING_ARRAY = new @NonNull String[0];
	public static final @NonNull TuplePartId @NonNull [] NULL_TUPLE_PART_ID_ARRAY = new @NonNull TuplePartId[0];
	public static final @NonNull TypeId @NonNull [] NULL_TYPE_ID_ARRAY = new @NonNull TypeId[0];

	@Nullable String getLiteralName();

	@NonNull String getMetaTypeName();

	/**
	 * Return the OperationId for an Operation of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have operations.
	 */
	// FIXME This should only be available to ClassId
	@NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId);

	/**
	 * Return the PropertyId for a Property of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have properties.
	 */
	@NonNull PropertyId getPropertyId(@NonNull String name);

	/**
	 * Return the typeId for the named type parameter of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have type parameters.
	 */
	@NonNull TemplateParameterId getTemplateParameterId(int index);
	int getTemplateParameters();

	/**
	 * @since 1.7
	 */
	default boolean isTemplated() {
		return false;
	}

	@NonNull ElementId specialize(@NonNull BindingsId templateBindings);
}
