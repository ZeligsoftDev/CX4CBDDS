/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.ocl.pivot/model/OCL-2.5.oclstdlib
 *   http://www.eclipse.org/ocl/2015/Pivot
 * using:
 *   /org.eclipse.ocl.pivot/model/oclstdlib.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.ocl.pivot.oclstdlib;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorAnyType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorBagType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorBooleanType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorCollectionType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorInvalidType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorOrderedSetType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPrimitiveType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorSequenceType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorSetType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorVoidType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorLambdaType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
// import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * OCLstdlibTables provides the dispatch tables for the ocl for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class OCLstdlibTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(OCLstdlibPackage.eINSTANCE, IdManager.METAMODEL);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = new ExecutorStandardLibrary();

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			OCLstdlibTables.init();
		}

		public static final @NonNull ExecutorTypeParameter _0_K = new ExecutorTypeParameter(0, "K");
		public static final @NonNull ExecutorTypeParameter _0_T = new ExecutorTypeParameter(0, "T");
		public static final @NonNull ExecutorTypeParameter _0_TT = new ExecutorTypeParameter(0, "TT");
		public static final @NonNull ExecutorTypeParameter _1_T2 = new ExecutorTypeParameter(1, "T2");
		public static final @NonNull ExecutorTypeParameter _1_TT = new ExecutorTypeParameter(1, "TT");
		public static final @NonNull ExecutorTypeParameter _1_Tacc = new ExecutorTypeParameter(1, "Tacc");
		public static final @NonNull ExecutorTypeParameter _1_V = new ExecutorTypeParameter(1, "V");
		public static final @NonNull ExecutorTypeParameter _2_K2 = new ExecutorTypeParameter(2, "K2");
		public static final @NonNull ExecutorTypeParameter _2_Tacc = new ExecutorTypeParameter(2, "Tacc");
		public static final @NonNull ExecutorTypeParameter _2_V2 = new ExecutorTypeParameter(2, "V2");
		public static final @NonNull ExecutorTypeParameter _3_V2 = new ExecutorTypeParameter(3, "V2");
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Bag_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Bag__collect_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Bag__collectNested_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Bag__flatten_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Bag__selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Bag__selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Collection_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__collect_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__collectBy_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__collectNested_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__excludesAll_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__flatten_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__includesAll_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__iterate_Tacc = _1_Tacc;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__product_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Collection__selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Map_K = _0_K;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Map_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__collect_V2 = _2_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__collectBy_V2 = _2_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__collectNested_V2 = _2_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__excludesAll_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__excludesMap_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__excludesMap_V2 = _3_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__excludingMap_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__excludingMap_V2 = _3_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__includesAll_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__includesMap_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__includesMap_V2 = _3_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__includingMap_K2 = _2_K2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__includingMap_V2 = _3_V2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Map__iterate_Tacc = _2_Tacc;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OclAny__oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OclElement__oclAsModelType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OclInvalid__oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OclVoid__oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _OrderedCollection_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _OrderedSet_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OrderedSet__collect_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OrderedSet__collectNested_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OrderedSet__flatten_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OrderedSet__selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __OrderedSet__selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Sequence_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Sequence__collect_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Sequence__collectNested_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Sequence__flatten_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Sequence__selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Sequence__selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _Set_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Set__collect_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Set__collectNested_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Set__flatten_T2 = _1_T2;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Set__selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __Set__selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter _UniqueCollection_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ExecutorTypeParameter __UnlimitedNatural__oclAsType_TT = _0_TT;

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final @NonNull EcoreExecutorBagType _Bag = new EcoreExecutorBagType(TypeId.BAG, PACKAGE, 0, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorBooleanType _Boolean = new EcoreExecutorBooleanType(TypeId.BOOLEAN, PACKAGE, 0);
		public static final @NonNull EcoreExecutorCollectionType _Collection = new EcoreExecutorCollectionType(TypeId.COLLECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorPrimitiveType _Integer = new EcoreExecutorPrimitiveType(TypeId.INTEGER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Map = new EcoreExecutorType(OCLstdlibPackage.Literals.MAP, PACKAGE, 0, TypeParameters._0_K, TypeParameters._1_V);
		public static final @NonNull EcoreExecutorAnyType _OclAny = new EcoreExecutorAnyType(TypeId.OCL_ANY, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclComparable = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_COMPARABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclElement = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclEnumeration = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_ENUMERATION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorInvalidType _OclInvalid = new EcoreExecutorInvalidType(TypeId.OCL_INVALID, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclLambda = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_LAMBDA, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclMessage = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_MESSAGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclSelf = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_SELF, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclState = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_STATE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclStereotype = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_STEREOTYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclSummable = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_SUMMABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclTuple = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_TUPLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OclType = new EcoreExecutorType(OCLstdlibPackage.Literals.OCL_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorVoidType _OclVoid = new EcoreExecutorVoidType(TypeId.OCL_VOID, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorCollectionType _OrderedCollection = new EcoreExecutorCollectionType(TypeId.ORDERED_COLLECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorOrderedSetType _OrderedSet = new EcoreExecutorOrderedSetType(TypeId.ORDERED_SET, PACKAGE, ExecutorType.ORDERED | ExecutorType.UNIQUE, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorPrimitiveType _Real = new EcoreExecutorPrimitiveType(TypeId.REAL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorSequenceType _Sequence = new EcoreExecutorSequenceType(TypeId.SEQUENCE, PACKAGE, ExecutorType.ORDERED, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorSetType _Set = new EcoreExecutorSetType(TypeId.SET, PACKAGE, ExecutorType.UNIQUE, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorPrimitiveType _String = new EcoreExecutorPrimitiveType(TypeId.STRING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorCollectionType _UniqueCollection = new EcoreExecutorCollectionType(TypeId.UNIQUE_COLLECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._0_T);
		public static final @NonNull EcoreExecutorPrimitiveType _UnlimitedNatural = new EcoreExecutorPrimitiveType(TypeId.UNLIMITED_NATURAL, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_Bag,
			_Boolean,
			_Collection,
			_Integer,
			_Map,
			_OclAny,
			_OclComparable,
			_OclElement,
			_OclEnumeration,
			_OclInvalid,
			_OclLambda,
			_OclMessage,
			_OclSelf,
			_OclState,
			_OclStereotype,
			_OclSummable,
			_OclTuple,
			_OclType,
			_OclVoid,
			_OrderedCollection,
			_OrderedSet,
			_Real,
			_Sequence,
			_Set,
			_String,
			_UniqueCollection,
			_UnlimitedNatural
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final @NonNull ExecutorFragment _Bag__Bag = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._Bag);
		private static final @NonNull ExecutorFragment _Bag__Collection = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Bag__OclAny = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Boolean__Boolean = new ExecutorFragment(Types._Boolean, OCLstdlibTables.Types._Boolean);
		private static final @NonNull ExecutorFragment _Boolean__OclAny = new ExecutorFragment(Types._Boolean, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Collection__Collection = new ExecutorFragment(Types._Collection, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Collection__OclAny = new ExecutorFragment(Types._Collection, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Integer__Integer = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._Integer);
		private static final @NonNull ExecutorFragment _Integer__OclAny = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Integer__OclComparable = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _Integer__OclSummable = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _Integer__Real = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._Real);

		private static final @NonNull ExecutorFragment _Map__Map = new ExecutorFragment(Types._Map, OCLstdlibTables.Types._Map);
		private static final @NonNull ExecutorFragment _Map__OclAny = new ExecutorFragment(Types._Map, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _OclAny__OclAny = new ExecutorFragment(Types._OclAny, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _OclComparable__OclAny = new ExecutorFragment(Types._OclComparable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclComparable__OclComparable = new ExecutorFragment(Types._OclComparable, OCLstdlibTables.Types._OclComparable);

		private static final @NonNull ExecutorFragment _OclElement__OclAny = new ExecutorFragment(Types._OclElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclElement__OclElement = new ExecutorFragment(Types._OclElement, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _OclEnumeration__OclAny = new ExecutorFragment(Types._OclEnumeration, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclEnumeration__OclElement = new ExecutorFragment(Types._OclEnumeration, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OclEnumeration__OclEnumeration = new ExecutorFragment(Types._OclEnumeration, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _OclEnumeration__OclType = new ExecutorFragment(Types._OclEnumeration, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _OclInvalid__OclAny = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclInvalid__OclInvalid = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclInvalid);
		private static final @NonNull ExecutorFragment _OclInvalid__OclVoid = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclVoid);

		private static final @NonNull ExecutorFragment _OclLambda__OclAny = new ExecutorFragment(Types._OclLambda, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclLambda__OclLambda = new ExecutorFragment(Types._OclLambda, OCLstdlibTables.Types._OclLambda);

		private static final @NonNull ExecutorFragment _OclMessage__OclAny = new ExecutorFragment(Types._OclMessage, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclMessage__OclMessage = new ExecutorFragment(Types._OclMessage, OCLstdlibTables.Types._OclMessage);

		private static final @NonNull ExecutorFragment _OclSelf__OclAny = new ExecutorFragment(Types._OclSelf, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclSelf__OclSelf = new ExecutorFragment(Types._OclSelf, OCLstdlibTables.Types._OclSelf);

		private static final @NonNull ExecutorFragment _OclState__OclAny = new ExecutorFragment(Types._OclState, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclState__OclState = new ExecutorFragment(Types._OclState, OCLstdlibTables.Types._OclState);

		private static final @NonNull ExecutorFragment _OclStereotype__OclAny = new ExecutorFragment(Types._OclStereotype, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclStereotype__OclElement = new ExecutorFragment(Types._OclStereotype, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OclStereotype__OclStereotype = new ExecutorFragment(Types._OclStereotype, OCLstdlibTables.Types._OclStereotype);
		private static final @NonNull ExecutorFragment _OclStereotype__OclType = new ExecutorFragment(Types._OclStereotype, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _OclSummable__OclAny = new ExecutorFragment(Types._OclSummable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclSummable__OclSummable = new ExecutorFragment(Types._OclSummable, OCLstdlibTables.Types._OclSummable);

		private static final @NonNull ExecutorFragment _OclTuple__OclAny = new ExecutorFragment(Types._OclTuple, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclTuple__OclTuple = new ExecutorFragment(Types._OclTuple, OCLstdlibTables.Types._OclTuple);

		private static final @NonNull ExecutorFragment _OclType__OclAny = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclType__OclElement = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OclType__OclType = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _OclVoid__OclAny = new ExecutorFragment(Types._OclVoid, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclVoid__OclVoid = new ExecutorFragment(Types._OclVoid, OCLstdlibTables.Types._OclVoid);

		private static final @NonNull ExecutorFragment _OrderedCollection__Collection = new ExecutorFragment(Types._OrderedCollection, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _OrderedCollection__OclAny = new ExecutorFragment(Types._OrderedCollection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OrderedCollection__OrderedCollection = new ExecutorFragment(Types._OrderedCollection, OCLstdlibTables.Types._OrderedCollection);

		private static final @NonNull ExecutorFragment _OrderedSet__Collection = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _OrderedSet__OclAny = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OrderedSet__OrderedCollection = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._OrderedCollection);
		private static final @NonNull ExecutorFragment _OrderedSet__OrderedSet = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._OrderedSet);
		private static final @NonNull ExecutorFragment _OrderedSet__UniqueCollection = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _Real__OclAny = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Real__OclComparable = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _Real__OclSummable = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _Real__Real = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._Real);

		private static final @NonNull ExecutorFragment _Sequence__Collection = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Sequence__OclAny = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Sequence__OrderedCollection = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._OrderedCollection);
		private static final @NonNull ExecutorFragment _Sequence__Sequence = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._Sequence);

		private static final @NonNull ExecutorFragment _Set__Collection = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Set__OclAny = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Set__Set = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._Set);
		private static final @NonNull ExecutorFragment _Set__UniqueCollection = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _String__OclAny = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _String__OclComparable = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _String__OclSummable = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _String__String = new ExecutorFragment(Types._String, OCLstdlibTables.Types._String);

		private static final @NonNull ExecutorFragment _UniqueCollection__Collection = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _UniqueCollection__OclAny = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UniqueCollection__UniqueCollection = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _UnlimitedNatural__OclAny = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__OclComparable = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__UnlimitedNatural = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._UnlimitedNatural);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final @NonNull ParameterTypes _0_K = TypeUtil.createParameterTypes(TypeParameters._0_K);
		public static final @NonNull ParameterTypes _0_K___1_V = TypeUtil.createParameterTypes(TypeParameters._0_K, TypeParameters._1_V);
		public static final @NonNull ParameterTypes _0_T = TypeUtil.createParameterTypes(TypeParameters._0_T);
		public static final @NonNull ParameterTypes _0_TT = TypeUtil.createParameterTypes(TypeParameters._0_TT);
		public static final @NonNull ParameterTypes _1_TT = TypeUtil.createParameterTypes(TypeParameters._1_TT);
		public static final @NonNull ParameterTypes _1_V = TypeUtil.createParameterTypes(TypeParameters._1_V);
		public static final @NonNull ParameterTypes _Boolean = TypeUtil.createParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull ParameterTypes _Collection = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.COLLECTION, TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Collection__0_K__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.COLLECTION, TypeParameters._0_K));
		public static final @NonNull ParameterTypes _Collection__0_T__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.COLLECTION, TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Collection__1_T2__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.COLLECTION, TypeParameters._1_T2));
		public static final @NonNull ParameterTypes _Collection__2_K2__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.COLLECTION, TypeParameters._2_K2));
		public static final @NonNull ParameterTypes _Integer = TypeUtil.createParameterTypes(OCLstdlibTables.Types._Integer);
		public static final @NonNull ParameterTypes _Integer___0_T = TypeUtil.createParameterTypes(OCLstdlibTables.Types._Integer, TypeParameters._0_T);
		public static final @NonNull ParameterTypes _Integer___Integer = TypeUtil.createParameterTypes(OCLstdlibTables.Types._Integer, OCLstdlibTables.Types._Integer);
		public static final @NonNull ParameterTypes _Lambda_0_K_2_Tacc = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_K));
		public static final @NonNull ParameterTypes _Lambda_0_K_2_V2 = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_K));
		public static final @NonNull ParameterTypes _Lambda_0_K_Boolean = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_K));
		public static final @NonNull ParameterTypes _Lambda_0_K_OclAny = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_K));
		public static final @NonNull ParameterTypes _Lambda_0_T_1_Tacc = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_1_V = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_Boolean = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_OclAny = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_OrderedSet = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_OrderedSet__0_T__ = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_Set = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Lambda_0_T_Set__0_T__ = TypeUtil.createParameterTypes(new ExecutorLambdaType("Lambda", TypeParameters._0_T));
		public static final @NonNull ParameterTypes _Map__2_K2_3_V2__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.MAP, TypeParameters._2_K2, TypeParameters._3_V2));
		public static final @NonNull ParameterTypes _OclSelf = TypeUtil.createParameterTypes(OCLstdlibTables.Types._OclSelf);
		public static final @NonNull ParameterTypes _OclState = TypeUtil.createParameterTypes(OCLstdlibTables.Types._OclState);
		public static final @NonNull ParameterTypes _OclStereotype = TypeUtil.createParameterTypes(OCLstdlibTables.Types._OclStereotype);
		public static final @NonNull ParameterTypes _OclType = TypeUtil.createParameterTypes(OCLstdlibTables.Types._OclType);
		public static final @NonNull ParameterTypes _OrderedCollection__0_T__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.ORDERED_COLLECTION, TypeParameters._0_T));
		public static final @NonNull ParameterTypes _String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String);
		public static final @NonNull ParameterTypes _String___Boolean = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String, OCLstdlibTables.Types._Boolean);
		public static final @NonNull ParameterTypes _String___String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String, OCLstdlibTables.Types._String);
		public static final @NonNull ParameterTypes _UniqueCollection = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.UNIQUE_COLLECTION, TypeParameters._0_T));
		public static final @NonNull ParameterTypes _UniqueCollection__0_T__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.UNIQUE_COLLECTION, TypeParameters._0_T));
		public static final @NonNull ParameterTypes _UniqueCollection__OclAny__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType(TypeId.UNIQUE_COLLECTION, OCLstdlibTables.Types._OclAny));
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Bag_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Bag_selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Bag_selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Bag_T__ = _Collection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Collection_excludesAll_T2__ = _Collection__1_T2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Collection_includesAll_T2__ = _Collection__1_T2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Collection_product_T2__ = _Collection__1_T2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Map_K__ = _Collection__0_K__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Map_excludesAll_K2__ = _Collection__2_K2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Map_includesAll_K2__ = _Collection__2_K2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__OrderedSet_T__ = _Collection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Sequence_T__ = _Collection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__Set_T__ = _Collection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection__UniqueCollection_T__ = _Collection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection_selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Collection_selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Integer___OrderedSet_T = _Integer___0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Integer___Sequence_T = _Integer___0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map_K = _0_K;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map_K___Map_V = _0_K___1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map_V = _1_V;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map__Map_excludesMap_K2_Map_excludesMap_V2__ = _Map__2_K2_3_V2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map__Map_excludingMap_K2_Map_excludingMap_V2__ = _Map__2_K2_3_V2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map__Map_includesMap_K2_Map_includesMap_V2__ = _Map__2_K2_3_V2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Map__Map_includingMap_K2_Map_includingMap_V2__ = _Map__2_K2_3_V2__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OclAny_oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OclElement_oclAsModelType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OclInvalid_oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OclVoid_oclAsType_TT = _0_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedCollection_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedCollection__OrderedSet_T__ = _OrderedCollection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedCollection__Sequence_T__ = _OrderedCollection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedSet_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedSet_selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _OrderedSet_selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Sequence_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Sequence_selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Sequence_selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Set_T = _0_T;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Set_selectByKind_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _Set_selectByType_TT = _1_TT;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _UniqueCollection__Collection_T__ = _UniqueCollection__0_T__;
		@Deprecated /* @deprecated use normalized name */
		public static final @NonNull ParameterTypes _UnlimitedNatural_oclAsType_TT = _0_TT;

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final @NonNull ExecutorOperation _Bag___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Bag,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Bag,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__closure = new ExecutorOperation("closure", Parameters._Lambda_0_T_Set__0_T__, Types._Bag,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__collect = new ExecutorOperation("collect", Parameters._Lambda_0_T_1_V, Types._Bag,
			3, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_T_1_V, Types._Bag,
			4, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__excluding = new ExecutorOperation("excluding", Parameters._0_T, Types._Bag,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__0_T__, Types._Bag,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__flatten = new ExecutorOperation("flatten", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Bag,
			7, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__including = new ExecutorOperation("including", Parameters._0_T, Types._Bag,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__0_T__, Types._Bag,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__reject = new ExecutorOperation("reject", Parameters._Lambda_0_T_Boolean, Types._Bag,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__select = new ExecutorOperation("select", Parameters._Lambda_0_T_Boolean, Types._Bag,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__selectByKind = new ExecutorOperation("selectByKind", Parameters._1_TT, Types._Bag,
			12, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__selectByType = new ExecutorOperation("selectByType", Parameters._1_TT, Types._Bag,
			13, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._Bag,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);

		public static final @NonNull ExecutorOperation _Boolean___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Boolean,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Boolean,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__and = new ExecutorOperation("and", Parameters._Boolean, Types._Boolean,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._Boolean,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__not = new ExecutorOperation("not", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Boolean,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanNotOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__or = new ExecutorOperation("or", Parameters._Boolean, Types._Boolean,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanOrOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__xor = new ExecutorOperation("xor", Parameters._Boolean, Types._Boolean,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanXorOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._Boolean,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__and2 = new ExecutorOperation("and2", Parameters._Boolean, Types._Boolean,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanAndOperation2.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__implies2 = new ExecutorOperation("implies2", Parameters._Boolean, Types._Boolean,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation2.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__not2 = new ExecutorOperation("not2", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Boolean,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanNotOperation2.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__or2 = new ExecutorOperation("or2", Parameters._Boolean, Types._Boolean,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanOrOperation2.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Boolean,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__xor2 = new ExecutorOperation("xor2", Parameters._Boolean, Types._Boolean,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanXorOperation2.INSTANCE);

		public static final @NonNull ExecutorOperation _Collection___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Collection,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Collection,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__any = new ExecutorOperation("any", Parameters._Lambda_0_T_Boolean, Types._Collection,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.AnyIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asBag = new ExecutorOperation("asBag", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionAsBagOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asOrderedSet = new ExecutorOperation("asOrderedSet", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asSequence = new ExecutorOperation("asSequence", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asSet = new ExecutorOperation("asSet", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__collect = new ExecutorOperation("collect", Parameters._Lambda_0_T_1_V, Types._Collection,
			7, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__collectBy = new ExecutorOperation("collectBy", Parameters._Lambda_0_T_1_V, Types._Collection,
			8, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_T_1_V, Types._Collection,
			9, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__count = new ExecutorOperation("count", Parameters._0_T, Types._Collection,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionCountOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludes = new ExecutorOperation("excludes", Parameters._0_T, Types._Collection,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludesAll = new ExecutorOperation("excludesAll", Parameters._Collection__1_T2__, Types._Collection,
			12, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionExcludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excluding = new ExecutorOperation("excluding", Parameters._0_T, Types._Collection,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection, Types._Collection,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__2_exists = new ExecutorOperation("exists", Parameters._Lambda_0_T_Boolean, Types._Collection,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_exists = new ExecutorOperation("exists", Parameters._Lambda_0_T_Boolean, Types._Collection,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_exists = new ExecutorOperation("exists", Parameters._Lambda_0_T_Boolean, Types._Collection,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__flatten = new ExecutorOperation("flatten", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			18, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__2_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_T_Boolean, Types._Collection,
			19, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_T_Boolean, Types._Collection,
			20, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_T_Boolean, Types._Collection,
			21, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includes = new ExecutorOperation("includes", Parameters._0_T, Types._Collection,
			22, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includesAll = new ExecutorOperation("includesAll", Parameters._Collection__1_T2__, Types._Collection,
			23, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionIncludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__including = new ExecutorOperation("including", Parameters._0_T, Types._Collection,
			24, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includingAll = new ExecutorOperation("includingAll", Parameters._Collection, Types._Collection,
			25, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_intersection = new ExecutorOperation("intersection", Parameters._Collection, Types._Collection,
			26, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_intersection = new ExecutorOperation("intersection", Parameters._UniqueCollection__0_T__, Types._Collection,
			27, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__isEmpty = new ExecutorOperation("isEmpty", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			28, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__isUnique = new ExecutorOperation("isUnique", Parameters._Lambda_0_T_OclAny, Types._Collection,
			29, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.IsUniqueIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__iterate = new ExecutorOperation("iterate", Parameters._Lambda_0_T_1_Tacc, Types._Collection,
			30, TypeUtil.createTemplateParameters(TypeParameters._1_Tacc), org.eclipse.ocl.pivot.library.iterator.IterateIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__max = new ExecutorOperation("max", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			31, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__min = new ExecutorOperation("min", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			32, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__notEmpty = new ExecutorOperation("notEmpty", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			33, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__one = new ExecutorOperation("one", Parameters._Lambda_0_T_Boolean, Types._Collection,
			34, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.OneIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__product = new ExecutorOperation("product", Parameters._Collection__1_T2__, Types._Collection,
			35, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionProductOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__reject = new ExecutorOperation("reject", Parameters._Lambda_0_T_Boolean, Types._Collection,
			36, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__select = new ExecutorOperation("select", Parameters._Lambda_0_T_Boolean, Types._Collection,
			37, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__selectByKind = new ExecutorOperation("selectByKind", Parameters._1_TT, Types._Collection,
			38, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__selectByType = new ExecutorOperation("selectByType", Parameters._1_TT, Types._Collection,
			39, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__size = new ExecutorOperation("size", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			40, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._Collection,
			41, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__sum = new ExecutorOperation("sum", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Collection,
			42, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionSumOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__union = new ExecutorOperation("union", Parameters._Collection, Types._Collection,
			43, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionUnionOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Integer___mul_ = new ExecutorOperation("*", Parameters._OclSelf, Types._Integer,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericTimesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___add_ = new ExecutorOperation("+", Parameters._OclSelf, Types._Integer,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___neg_ = new ExecutorOperation("-", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Integer,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericNegateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___sub_ = new ExecutorOperation("-", Parameters._OclSelf, Types._Integer,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___div_ = new ExecutorOperation("/", Parameters._OclSelf, Types._Integer,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericDivideOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__abs = new ExecutorOperation("abs", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Integer,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericAbsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__div = new ExecutorOperation("div", Parameters._Integer, Types._Integer,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericDivOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__max = new ExecutorOperation("max", Parameters._OclSelf, Types._Integer,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__min = new ExecutorOperation("min", Parameters._OclSelf, Types._Integer,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__mod = new ExecutorOperation("mod", Parameters._Integer, Types._Integer,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericModOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Integer,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__toUnlimitedNatural = new ExecutorOperation("toUnlimitedNatural", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Integer,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.IntegerToUnlimitedNaturalOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Map___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Map,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Map,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__any = new ExecutorOperation("any", Parameters._Lambda_0_K_Boolean, Types._Map,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.AnyIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__at = new ExecutorOperation("at", Parameters._0_K, Types._Map,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__collect = new ExecutorOperation("collect", Parameters._Lambda_0_K_2_V2, Types._Map,
			4, TypeUtil.createTemplateParameters(TypeParameters._2_V2), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__collectBy = new ExecutorOperation("collectBy", Parameters._Lambda_0_K_2_V2, Types._Map,
			5, TypeUtil.createTemplateParameters(TypeParameters._2_V2), org.eclipse.ocl.pivot.library.iterator.CollectByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_K_2_V2, Types._Map,
			6, TypeUtil.createTemplateParameters(TypeParameters._2_V2), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__0_excludes = new ExecutorOperation("excludes", Parameters._0_K, Types._Map,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__1_excludes = new ExecutorOperation("excludes", Parameters._0_K___1_V, Types._Map,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludesPairOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__excludesAll = new ExecutorOperation("excludesAll", Parameters._Collection__2_K2__, Types._Map,
			9, TypeUtil.createTemplateParameters(TypeParameters._2_K2), org.eclipse.ocl.pivot.library.map.MapExcludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__excludesMap = new ExecutorOperation("excludesMap", Parameters._Map__2_K2_3_V2__, Types._Map,
			10, TypeUtil.createTemplateParameters(TypeParameters._2_K2, TypeParameters._3_V2), org.eclipse.ocl.pivot.library.map.MapExcludesMapOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__excludesValue = new ExecutorOperation("excludesValue", Parameters._1_V, Types._Map,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludesValueOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__0_excluding = new ExecutorOperation("excluding", Parameters._0_K, Types._Map,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__1_excluding = new ExecutorOperation("excluding", Parameters._0_K___1_V, Types._Map,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludingPairOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__0_K__, Types._Map,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__excludingMap = new ExecutorOperation("excludingMap", Parameters._Map__2_K2_3_V2__, Types._Map,
			15, TypeUtil.createTemplateParameters(TypeParameters._2_K2, TypeParameters._3_V2), org.eclipse.ocl.pivot.library.map.MapExcludingMapOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__2_exists = new ExecutorOperation("exists", Parameters._Lambda_0_K_Boolean, Types._Map,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__1_exists = new ExecutorOperation("exists", Parameters._Lambda_0_K_Boolean, Types._Map,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__0_exists = new ExecutorOperation("exists", Parameters._Lambda_0_K_Boolean, Types._Map,
			18, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__2_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_K_Boolean, Types._Map,
			19, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__1_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_K_Boolean, Types._Map,
			20, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__0_forAll = new ExecutorOperation("forAll", Parameters._Lambda_0_K_Boolean, Types._Map,
			21, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__0_includes = new ExecutorOperation("includes", Parameters._0_K, Types._Map,
			22, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapIncludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__1_includes = new ExecutorOperation("includes", Parameters._0_K___1_V, Types._Map,
			23, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapIncludesPairOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__includesAll = new ExecutorOperation("includesAll", Parameters._Collection__2_K2__, Types._Map,
			24, TypeUtil.createTemplateParameters(TypeParameters._2_K2), org.eclipse.ocl.pivot.library.map.MapIncludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__includesMap = new ExecutorOperation("includesMap", Parameters._Map__2_K2_3_V2__, Types._Map,
			25, TypeUtil.createTemplateParameters(TypeParameters._2_K2, TypeParameters._3_V2), org.eclipse.ocl.pivot.library.map.MapIncludesMapOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__includesValue = new ExecutorOperation("includesValue", Parameters._1_V, Types._Map,
			26, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapIncludesValueOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__including = new ExecutorOperation("including", Parameters._0_K___1_V, Types._Map,
			27, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapIncludingPairOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__includingMap = new ExecutorOperation("includingMap", Parameters._Map__2_K2_3_V2__, Types._Map,
			28, TypeUtil.createTemplateParameters(TypeParameters._2_K2, TypeParameters._3_V2), org.eclipse.ocl.pivot.library.map.MapIncludingMapOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__isEmpty = new ExecutorOperation("isEmpty", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Map,
			29, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapIsEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__isUnique = new ExecutorOperation("isUnique", Parameters._Lambda_0_K_OclAny, Types._Map,
			30, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.IsUniqueIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__iterate = new ExecutorOperation("iterate", Parameters._Lambda_0_K_2_Tacc, Types._Map,
			31, TypeUtil.createTemplateParameters(TypeParameters._2_Tacc), org.eclipse.ocl.pivot.library.iterator.IterateIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__keys = new ExecutorOperation("keys", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Map,
			32, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapKeysOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__notEmpty = new ExecutorOperation("notEmpty", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Map,
			33, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapNotEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__one = new ExecutorOperation("one", Parameters._Lambda_0_K_Boolean, Types._Map,
			34, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.OneIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__reject = new ExecutorOperation("reject", Parameters._Lambda_0_K_Boolean, Types._Map,
			35, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.MapRejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__select = new ExecutorOperation("select", Parameters._Lambda_0_K_Boolean, Types._Map,
			36, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.MapSelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__size = new ExecutorOperation("size", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Map,
			37, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapSizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Map__values = new ExecutorOperation("values", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Map,
			38, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.map.MapValuesOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclAny___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclAny,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclAny,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclAsSet = new ExecutorOperation("oclAsSet", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclAsType = new ExecutorOperation("oclAsType", Parameters._0_TT, Types._OclAny,
			3, TypeUtil.createTemplateParameters(TypeParameters._0_TT), org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsInState = new ExecutorOperation("oclIsInState", Parameters._OclState, Types._OclAny,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsInvalid = new ExecutorOperation("oclIsInvalid", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsKindOf = new ExecutorOperation("oclIsKindOf", Parameters._OclType, Types._OclAny,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsNew = new ExecutorOperation("oclIsNew", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsTypeOf = new ExecutorOperation("oclIsTypeOf", Parameters._OclType, Types._OclAny,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsUndefined = new ExecutorOperation("oclIsUndefined", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__0_oclLog = new ExecutorOperation("oclLog", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclLogOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__1_oclLog = new ExecutorOperation("oclLog", Parameters._String, Types._OclAny,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclLogOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclType = new ExecutorOperation("oclType", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclTypes = new ExecutorOperation("oclTypes", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclAny,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclComparable___lt_ = new ExecutorOperation("<", Parameters._OclSelf, Types._OclComparable,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___lt__eq_ = new ExecutorOperation("<=", Parameters._OclSelf, Types._OclComparable,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___gt_ = new ExecutorOperation(">", Parameters._OclSelf, Types._OclComparable,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___gt__eq_ = new ExecutorOperation(">=", Parameters._OclSelf, Types._OclComparable,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._OclComparable,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclComparableCompareToOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclElement__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._OclElement,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclAsModelType = new ExecutorOperation("oclAsModelType", Parameters._0_TT, Types._OclElement,
			1, TypeUtil.createTemplateParameters(TypeParameters._0_TT), org.eclipse.ocl.pivot.library.oclany.OclElementOclAsModelTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__0_oclBase = new ExecutorOperation("oclBase", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclBaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__1_oclBase = new ExecutorOperation("oclBase", Parameters._OclType, Types._OclElement,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclBaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclContainer = new ExecutorOperation("oclContainer", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclContents = new ExecutorOperation("oclContents", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.classifier.ClassifierOclContentsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclExtension = new ExecutorOperation("oclExtension", Parameters._OclStereotype, Types._OclElement,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclExtensionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__1_oclExtensions = new ExecutorOperation("oclExtensions", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclExtensionsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__0_oclExtensions = new ExecutorOperation("oclExtensions", Parameters._OclStereotype, Types._OclElement,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclExtensionsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclIsModelKindOf = new ExecutorOperation("oclIsModelKindOf", Parameters._OclType, Types._OclElement,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclIsModelKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclModelType = new ExecutorOperation("oclModelType", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclModelTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclModelTypes = new ExecutorOperation("oclModelTypes", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclElement,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclElementOclModelTypesOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclEnumeration__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._OclEnumeration,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclInvalid___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclInvalid,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclInvalid,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__and = new ExecutorOperation("and", Parameters._Boolean, Types._OclInvalid,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._OclInvalid,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__or = new ExecutorOperation("or", Parameters._Boolean, Types._OclInvalid,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._OclInvalid,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclAsSet = new ExecutorOperation("oclAsSet", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclAsType = new ExecutorOperation("oclAsType", Parameters._0_TT, Types._OclInvalid,
			7, TypeUtil.createTemplateParameters(TypeParameters._0_TT), org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclBadOperation = new ExecutorOperation("oclBadOperation", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			8, TemplateParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsInvalid = new ExecutorOperation("oclIsInvalid", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsKindOf = new ExecutorOperation("oclIsKindOf", Parameters._OclType, Types._OclInvalid,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsTypeOf = new ExecutorOperation("oclIsTypeOf", Parameters._OclType, Types._OclInvalid,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsUndefined = new ExecutorOperation("oclIsUndefined", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclType = new ExecutorOperation("oclType", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclInvalid,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclMessage__hasReturned = new ExecutorOperation("hasReturned", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclMessage,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__isOperationCall = new ExecutorOperation("isOperationCall", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclMessage,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__isSignalSent = new ExecutorOperation("isSignalSent", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclMessage,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__result = new ExecutorOperation("result", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclMessage,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclStereotype__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._OclStereotype,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclSummable__sum = new ExecutorOperation("sum", Parameters._OclSelf, Types._OclSummable,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _OclSummable__zero = new ExecutorOperation("zero", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclSummable,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _OclTuple___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclTuple,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclTuple___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclTuple,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclType__conformsTo = new ExecutorOperation("conformsTo", Parameters._OclType, Types._OclType,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclVoid___add_ = new ExecutorOperation("+", Parameters._String, Types._OclVoid,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclVoid,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclVoid,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__and = new ExecutorOperation("and", Parameters._Boolean, Types._OclVoid,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclvoid.OclVoidAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._OclVoid,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__not = new ExecutorOperation("not", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanNotOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__or = new ExecutorOperation("or", Parameters._Boolean, Types._OclVoid,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclvoid.OclVoidOrOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__xor = new ExecutorOperation("xor", Parameters._Boolean, Types._OclVoid,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.logical.BooleanXorOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__allInstances = new ExecutorOperation("allInstances", Parameters._Integer, Types._OclVoid,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__concat = new ExecutorOperation("concat", Parameters._String, Types._OclVoid,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclAsSet = new ExecutorOperation("oclAsSet", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclAsType = new ExecutorOperation("oclAsType", Parameters._0_TT, Types._OclVoid,
			11, TypeUtil.createTemplateParameters(TypeParameters._0_TT), org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsInvalid = new ExecutorOperation("oclIsInvalid", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsKindOf = new ExecutorOperation("oclIsKindOf", Parameters._OclType, Types._OclVoid,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsTypeOf = new ExecutorOperation("oclIsTypeOf", Parameters._OclType, Types._OclVoid,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsUndefined = new ExecutorOperation("oclIsUndefined", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclType = new ExecutorOperation("oclType", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclTypes = new ExecutorOperation("oclTypes", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OclVoid,
			18, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OrderedCollection__at = new ExecutorOperation("at", Parameters._Integer, Types._OrderedCollection,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedCollection__first = new ExecutorOperation("first", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OrderedCollection,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedCollection__indexOf = new ExecutorOperation("indexOf", Parameters._0_T, Types._OrderedCollection,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedCollection__last = new ExecutorOperation("last", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OrderedCollection,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OrderedSet___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._OrderedSet,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OrderedSet,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OrderedSet,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__append = new ExecutorOperation("append", Parameters._0_T, Types._OrderedSet,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionAppendOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__appendAll = new ExecutorOperation("appendAll", Parameters._OrderedCollection__0_T__, Types._OrderedSet,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionAppendAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__closure = new ExecutorOperation("closure", Parameters._Lambda_0_T_OrderedSet, Types._OrderedSet,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__collect = new ExecutorOperation("collect", Parameters._Lambda_0_T_1_V, Types._OrderedSet,
			6, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_T_1_V, Types._OrderedSet,
			7, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__excluding = new ExecutorOperation("excluding", Parameters._0_T, Types._OrderedSet,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__0_T__, Types._OrderedSet,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__flatten = new ExecutorOperation("flatten", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OrderedSet,
			10, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__including = new ExecutorOperation("including", Parameters._0_T, Types._OrderedSet,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__0_T__, Types._OrderedSet,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__insertAt = new ExecutorOperation("insertAt", Parameters._Integer___0_T, Types._OrderedSet,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__prepend = new ExecutorOperation("prepend", Parameters._0_T, Types._OrderedSet,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionPrependOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__prependAll = new ExecutorOperation("prependAll", Parameters._OrderedCollection__0_T__, Types._OrderedSet,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionPrependAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__reject = new ExecutorOperation("reject", Parameters._Lambda_0_T_Boolean, Types._OrderedSet,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__reverse = new ExecutorOperation("reverse", TypeUtil.EMPTY_PARAMETER_TYPES, Types._OrderedSet,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionReverseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__select = new ExecutorOperation("select", Parameters._Lambda_0_T_Boolean, Types._OrderedSet,
			18, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__selectByKind = new ExecutorOperation("selectByKind", Parameters._1_TT, Types._OrderedSet,
			19, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__selectByType = new ExecutorOperation("selectByType", Parameters._1_TT, Types._OrderedSet,
			20, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._OrderedSet,
			21, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__subOrderedSet = new ExecutorOperation("subOrderedSet", Parameters._Integer___Integer, Types._OrderedSet,
			22, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Real___mul_ = new ExecutorOperation("*", Parameters._OclSelf, Types._Real,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericTimesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___add_ = new ExecutorOperation("+", Parameters._OclSelf, Types._Real,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___neg_ = new ExecutorOperation("-", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Real,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericNegateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___sub_ = new ExecutorOperation("-", Parameters._OclSelf, Types._Real,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___div_ = new ExecutorOperation("/", Parameters._OclSelf, Types._Real,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericDivideOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Real,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Real,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__abs = new ExecutorOperation("abs", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Real,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericAbsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__floor = new ExecutorOperation("floor", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Real,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericFloorOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__max = new ExecutorOperation("max", Parameters._OclSelf, Types._Real,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__min = new ExecutorOperation("min", Parameters._OclSelf, Types._Real,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__round = new ExecutorOperation("round", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Real,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.NumericRoundOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Real,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Sequence___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Sequence,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Sequence,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__append = new ExecutorOperation("append", Parameters._0_T, Types._Sequence,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionAppendOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__appendAll = new ExecutorOperation("appendAll", Parameters._OrderedCollection__0_T__, Types._Sequence,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionAppendAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__closure = new ExecutorOperation("closure", Parameters._Lambda_0_T_OrderedSet__0_T__, Types._Sequence,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__collect = new ExecutorOperation("collect", Parameters._Lambda_0_T_1_V, Types._Sequence,
			5, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_T_1_V, Types._Sequence,
			6, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__excluding = new ExecutorOperation("excluding", Parameters._0_T, Types._Sequence,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__0_T__, Types._Sequence,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__flatten = new ExecutorOperation("flatten", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Sequence,
			9, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__including = new ExecutorOperation("including", Parameters._0_T, Types._Sequence,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__0_T__, Types._Sequence,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__insertAt = new ExecutorOperation("insertAt", Parameters._Integer___0_T, Types._Sequence,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__prepend = new ExecutorOperation("prepend", Parameters._0_T, Types._Sequence,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionPrependOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__prependAll = new ExecutorOperation("prependAll", Parameters._OrderedCollection__0_T__, Types._Sequence,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionPrependAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__reject = new ExecutorOperation("reject", Parameters._Lambda_0_T_Boolean, Types._Sequence,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__reverse = new ExecutorOperation("reverse", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Sequence,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.OrderedCollectionReverseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__select = new ExecutorOperation("select", Parameters._Lambda_0_T_Boolean, Types._Sequence,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__selectByKind = new ExecutorOperation("selectByKind", Parameters._1_TT, Types._Sequence,
			18, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__selectByType = new ExecutorOperation("selectByType", Parameters._1_TT, Types._Sequence,
			19, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._Sequence,
			20, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__subSequence = new ExecutorOperation("subSequence", Parameters._Integer___Integer, Types._Sequence,
			21, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.SequenceSubSequenceOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Set___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._Set,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Set,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Set,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__closure = new ExecutorOperation("closure", Parameters._Lambda_0_T_Set, Types._Set,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__collect = new ExecutorOperation("collect", Parameters._Lambda_0_T_1_V, Types._Set,
			4, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_0_T_1_V, Types._Set,
			5, TypeUtil.createTemplateParameters(TypeParameters._1_V), org.eclipse.ocl.pivot.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__excluding = new ExecutorOperation("excluding", Parameters._0_T, Types._Set,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__0_T__, Types._Set,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__flatten = new ExecutorOperation("flatten", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Set,
			8, TypeUtil.createTemplateParameters(TypeParameters._1_T2), org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__including = new ExecutorOperation("including", Parameters._0_T, Types._Set,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__0_T__, Types._Set,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__reject = new ExecutorOperation("reject", Parameters._Lambda_0_T_Boolean, Types._Set,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__select = new ExecutorOperation("select", Parameters._Lambda_0_T_Boolean, Types._Set,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__selectByKind = new ExecutorOperation("selectByKind", Parameters._1_TT, Types._Set,
			13, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__selectByType = new ExecutorOperation("selectByType", Parameters._1_TT, Types._Set,
			14, TypeUtil.createTemplateParameters(TypeParameters._1_TT), org.eclipse.ocl.pivot.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._Set,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);

		public static final @NonNull ExecutorOperation _String___add_ = new ExecutorOperation("+", Parameters._String, Types._String,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt_ = new ExecutorOperation("<", Parameters._OclSelf, Types._String,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringLessThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt__eq_ = new ExecutorOperation("<=", Parameters._OclSelf, Types._String,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringLessThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._String,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._String,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___gt_ = new ExecutorOperation(">", Parameters._OclSelf, Types._String,
			5, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringGreaterThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___gt__eq_ = new ExecutorOperation(">=", Parameters._OclSelf, Types._String,
			6, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringGreaterThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__at = new ExecutorOperation("at", Parameters._Integer, Types._String,
			7, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__characters = new ExecutorOperation("characters", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			8, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringCharactersOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._String,
			9, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringCompareToOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__concat = new ExecutorOperation("concat", Parameters._String, Types._String,
			10, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__endsWith = new ExecutorOperation("endsWith", Parameters._String, Types._String,
			11, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringEndsWithOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__equalsIgnoreCase = new ExecutorOperation("equalsIgnoreCase", Parameters._String, Types._String,
			12, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__indexOf = new ExecutorOperation("indexOf", Parameters._String, Types._String,
			13, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__lastIndexOf = new ExecutorOperation("lastIndexOf", Parameters._String, Types._String,
			14, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringLastIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__matches = new ExecutorOperation("matches", Parameters._String, Types._String,
			15, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringMatchesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__replaceAll = new ExecutorOperation("replaceAll", Parameters._String___String, Types._String,
			16, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringReplaceAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__replaceFirst = new ExecutorOperation("replaceFirst", Parameters._String___String, Types._String,
			17, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringReplaceFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__size = new ExecutorOperation("size", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			18, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringSizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__startsWith = new ExecutorOperation("startsWith", Parameters._String, Types._String,
			19, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringStartsWithOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substituteAll = new ExecutorOperation("substituteAll", Parameters._String___String, Types._String,
			20, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringSubstituteAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substituteFirst = new ExecutorOperation("substituteFirst", Parameters._String___String, Types._String,
			21, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringSubstituteFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substring = new ExecutorOperation("substring", Parameters._Integer___Integer, Types._String,
			22, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringSubstringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toBoolean = new ExecutorOperation("toBoolean", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			23, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToBooleanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toInteger = new ExecutorOperation("toInteger", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			24, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToIntegerOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toLower = new ExecutorOperation("toLower", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			25, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToLowerCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toLowerCase = new ExecutorOperation("toLowerCase", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			26, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToLowerCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toReal = new ExecutorOperation("toReal", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			27, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToRealOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toString = new ExecutorOperation("toString", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			28, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toUpper = new ExecutorOperation("toUpper", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			29, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToUpperCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toUpperCase = new ExecutorOperation("toUpperCase", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			30, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringToUpperCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__0_tokenize = new ExecutorOperation("tokenize", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			31, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__1_tokenize = new ExecutorOperation("tokenize", Parameters._String, Types._String,
			32, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__2_tokenize = new ExecutorOperation("tokenize", Parameters._String___Boolean, Types._String,
			33, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__trim = new ExecutorOperation("trim", TypeUtil.EMPTY_PARAMETER_TYPES, Types._String,
			34, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.string.StringTrimOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _UniqueCollection___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._UniqueCollection,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__intersection = new ExecutorOperation("intersection", Parameters._Collection__0_T__, Types._UniqueCollection,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_0_T_OclAny, Types._UniqueCollection,
			2, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__symmetricDifference = new ExecutorOperation("symmetricDifference", Parameters._UniqueCollection__OclAny__, Types._UniqueCollection,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__union = new ExecutorOperation("union", Parameters._UniqueCollection, Types._UniqueCollection,
			4, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.collection.CollectionUnionOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _UnlimitedNatural__max = new ExecutorOperation("max", Parameters._OclSelf, Types._UnlimitedNatural,
			0, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.UnlimitedNaturalMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UnlimitedNatural__min = new ExecutorOperation("min", Parameters._OclSelf, Types._UnlimitedNatural,
			1, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.UnlimitedNaturalMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UnlimitedNatural__oclAsType = new ExecutorOperation("oclAsType", Parameters._0_TT, Types._UnlimitedNatural,
			2, TypeUtil.createTemplateParameters(TypeParameters._0_TT), org.eclipse.ocl.pivot.library.numeric.UnlimitedNaturalOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UnlimitedNatural__toInteger = new ExecutorOperation("toInteger", TypeUtil.EMPTY_PARAMETER_TYPES, Types._UnlimitedNatural,
			3, TemplateParameters.EMPTY_LIST, org.eclipse.ocl.pivot.library.numeric.UnlimitedNaturalToIntegerOperation.INSTANCE);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}


		public static final @NonNull ExecutorProperty _Collection__elementType = new ExecutorPropertyWithImplementation("elementType", Types._Collection, 0, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorProperty _Collection__lower = new ExecutorPropertyWithImplementation("lower", Types._Collection, 1, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorProperty _Collection__upper = new ExecutorPropertyWithImplementation("upper", Types._Collection, 2, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorProperty _Map__keyType = new ExecutorPropertyWithImplementation("keyType", Types._Map, 0, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorProperty _Map__valueType = new ExecutorPropertyWithImplementation("valueType", Types._Map, 1, org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorProperty _OclAny__OclInvalid__oclBadProperty = new ExecutorPropertyWithImplementation("OclInvalid", Types._OclAny, 0, new EcoreLibraryOppositeProperty(OCLstdlibPackage.Literals.OCL_INVALID__OCL_BAD_PROPERTY));

		public static final @NonNull ExecutorProperty _OclElement__oclContainer = new ExecutorPropertyWithImplementation("oclContainer", Types._OclElement, 0, org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty.INSTANCE);
		public static final @NonNull ExecutorProperty _OclElement__oclContents = new ExecutorPropertyWithImplementation("oclContents", Types._OclElement, 1, org.eclipse.ocl.pivot.library.oclany.OclElementOclContentsProperty.INSTANCE);
		public static final @NonNull ExecutorProperty _OclElement__OclElement__oclContainer = new ExecutorPropertyWithImplementation("OclElement", Types._OclElement, 2, new EcoreLibraryOppositeProperty(OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER));
		public static final @NonNull ExecutorProperty _OclElement__OclElement__oclContents = new ExecutorPropertyWithImplementation("OclElement", Types._OclElement, 3, new EcoreLibraryOppositeProperty(OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTENTS));

		public static final @NonNull ExecutorProperty _OclInvalid__oclBadProperty = new EcoreExecutorProperty(OCLstdlibPackage.Literals.OCL_INVALID__OCL_BAD_PROPERTY, Types._OclInvalid, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final @NonNull ExecutorFragment @NonNull [] _Bag =
			{
				Fragments._Bag__OclAny /* 0 */,
				Fragments._Bag__Collection /* 1 */,
				Fragments._Bag__Bag /* 2 */
			};
		private static final int @NonNull [] __Bag = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Boolean =
			{
				Fragments._Boolean__OclAny /* 0 */,
				Fragments._Boolean__Boolean /* 1 */
			};
		private static final int @NonNull [] __Boolean = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Collection =
			{
				Fragments._Collection__OclAny /* 0 */,
				Fragments._Collection__Collection /* 1 */
			};
		private static final int @NonNull [] __Collection = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Integer =
			{
				Fragments._Integer__OclAny /* 0 */,
				Fragments._Integer__OclComparable /* 1 */,
				Fragments._Integer__OclSummable /* 1 */,
				Fragments._Integer__Real /* 2 */,
				Fragments._Integer__Integer /* 3 */
			};
		private static final int @NonNull [] __Integer = { 1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Map =
			{
				Fragments._Map__OclAny /* 0 */,
				Fragments._Map__Map /* 1 */
			};
		private static final int @NonNull [] __Map = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclAny =
			{
				Fragments._OclAny__OclAny /* 0 */
			};
		private static final int @NonNull [] __OclAny = { 1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclComparable =
			{
				Fragments._OclComparable__OclAny /* 0 */,
				Fragments._OclComparable__OclComparable /* 1 */
			};
		private static final int @NonNull [] __OclComparable = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclElement =
			{
				Fragments._OclElement__OclAny /* 0 */,
				Fragments._OclElement__OclElement /* 1 */
			};
		private static final int @NonNull [] __OclElement = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclEnumeration =
			{
				Fragments._OclEnumeration__OclAny /* 0 */,
				Fragments._OclEnumeration__OclElement /* 1 */,
				Fragments._OclEnumeration__OclType /* 2 */,
				Fragments._OclEnumeration__OclEnumeration /* 3 */
			};
		private static final int @NonNull [] __OclEnumeration = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclInvalid =
			{
				Fragments._OclInvalid__OclAny /* 0 */,
				Fragments._OclInvalid__OclVoid /* 1 */,
				Fragments._OclInvalid__OclInvalid /* 2 */
			};
		private static final int @NonNull [] __OclInvalid = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclLambda =
			{
				Fragments._OclLambda__OclAny /* 0 */,
				Fragments._OclLambda__OclLambda /* 1 */
			};
		private static final int @NonNull [] __OclLambda = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclMessage =
			{
				Fragments._OclMessage__OclAny /* 0 */,
				Fragments._OclMessage__OclMessage /* 1 */
			};
		private static final int @NonNull [] __OclMessage = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclSelf =
			{
				Fragments._OclSelf__OclAny /* 0 */,
				Fragments._OclSelf__OclSelf /* 1 */
			};
		private static final int @NonNull [] __OclSelf = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclState =
			{
				Fragments._OclState__OclAny /* 0 */,
				Fragments._OclState__OclState /* 1 */
			};
		private static final int @NonNull [] __OclState = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclStereotype =
			{
				Fragments._OclStereotype__OclAny /* 0 */,
				Fragments._OclStereotype__OclElement /* 1 */,
				Fragments._OclStereotype__OclType /* 2 */,
				Fragments._OclStereotype__OclStereotype /* 3 */
			};
		private static final int @NonNull [] __OclStereotype = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclSummable =
			{
				Fragments._OclSummable__OclAny /* 0 */,
				Fragments._OclSummable__OclSummable /* 1 */
			};
		private static final int @NonNull [] __OclSummable = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclTuple =
			{
				Fragments._OclTuple__OclAny /* 0 */,
				Fragments._OclTuple__OclTuple /* 1 */
			};
		private static final int @NonNull [] __OclTuple = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclType =
			{
				Fragments._OclType__OclAny /* 0 */,
				Fragments._OclType__OclElement /* 1 */,
				Fragments._OclType__OclType /* 2 */
			};
		private static final int @NonNull [] __OclType = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OclVoid =
			{
				Fragments._OclVoid__OclAny /* 0 */,
				Fragments._OclVoid__OclVoid /* 1 */
			};
		private static final int @NonNull [] __OclVoid = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OrderedCollection =
			{
				Fragments._OrderedCollection__OclAny /* 0 */,
				Fragments._OrderedCollection__Collection /* 1 */,
				Fragments._OrderedCollection__OrderedCollection /* 2 */
			};
		private static final int @NonNull [] __OrderedCollection = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OrderedSet =
			{
				Fragments._OrderedSet__OclAny /* 0 */,
				Fragments._OrderedSet__Collection /* 1 */,
				Fragments._OrderedSet__OrderedCollection /* 2 */,
				Fragments._OrderedSet__UniqueCollection /* 2 */,
				Fragments._OrderedSet__OrderedSet /* 3 */
			};
		private static final int @NonNull [] __OrderedSet = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Real =
			{
				Fragments._Real__OclAny /* 0 */,
				Fragments._Real__OclComparable /* 1 */,
				Fragments._Real__OclSummable /* 1 */,
				Fragments._Real__Real /* 2 */
			};
		private static final int @NonNull [] __Real = { 1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Sequence =
			{
				Fragments._Sequence__OclAny /* 0 */,
				Fragments._Sequence__Collection /* 1 */,
				Fragments._Sequence__OrderedCollection /* 2 */,
				Fragments._Sequence__Sequence /* 3 */
			};
		private static final int @NonNull [] __Sequence = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Set =
			{
				Fragments._Set__OclAny /* 0 */,
				Fragments._Set__Collection /* 1 */,
				Fragments._Set__UniqueCollection /* 2 */,
				Fragments._Set__Set /* 3 */
			};
		private static final int @NonNull [] __Set = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _String =
			{
				Fragments._String__OclAny /* 0 */,
				Fragments._String__OclComparable /* 1 */,
				Fragments._String__OclSummable /* 1 */,
				Fragments._String__String /* 2 */
			};
		private static final int @NonNull [] __String = { 1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UniqueCollection =
			{
				Fragments._UniqueCollection__OclAny /* 0 */,
				Fragments._UniqueCollection__Collection /* 1 */,
				Fragments._UniqueCollection__UniqueCollection /* 2 */
			};
		private static final int @NonNull [] __UniqueCollection = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UnlimitedNatural =
			{
				Fragments._UnlimitedNatural__OclAny /* 0 */,
				Fragments._UnlimitedNatural__OclComparable /* 1 */,
				Fragments._UnlimitedNatural__UnlimitedNatural /* 2 */
			};
		private static final int @NonNull [] __UnlimitedNatural = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Bag.initFragments(_Bag, __Bag);
			Types._Boolean.initFragments(_Boolean, __Boolean);
			Types._Collection.initFragments(_Collection, __Collection);
			Types._Integer.initFragments(_Integer, __Integer);
			Types._Map.initFragments(_Map, __Map);
			Types._OclAny.initFragments(_OclAny, __OclAny);
			Types._OclComparable.initFragments(_OclComparable, __OclComparable);
			Types._OclElement.initFragments(_OclElement, __OclElement);
			Types._OclEnumeration.initFragments(_OclEnumeration, __OclEnumeration);
			Types._OclInvalid.initFragments(_OclInvalid, __OclInvalid);
			Types._OclLambda.initFragments(_OclLambda, __OclLambda);
			Types._OclMessage.initFragments(_OclMessage, __OclMessage);
			Types._OclSelf.initFragments(_OclSelf, __OclSelf);
			Types._OclState.initFragments(_OclState, __OclState);
			Types._OclStereotype.initFragments(_OclStereotype, __OclStereotype);
			Types._OclSummable.initFragments(_OclSummable, __OclSummable);
			Types._OclTuple.initFragments(_OclTuple, __OclTuple);
			Types._OclType.initFragments(_OclType, __OclType);
			Types._OclVoid.initFragments(_OclVoid, __OclVoid);
			Types._OrderedCollection.initFragments(_OrderedCollection, __OrderedCollection);
			Types._OrderedSet.initFragments(_OrderedSet, __OrderedSet);
			Types._Real.initFragments(_Real, __Real);
			Types._Sequence.initFragments(_Sequence, __Sequence);
			Types._Set.initFragments(_Set, __Set);
			Types._String.initFragments(_String, __String);
			Types._UniqueCollection.initFragments(_UniqueCollection, __UniqueCollection);
			Types._UnlimitedNatural.initFragments(_UnlimitedNatural, __UnlimitedNatural);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final @NonNull ExecutorOperation @NonNull [] _Bag__Bag = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Bag__closure /* closure(T[1]|Lambda T() : Set(T)[?]) */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Bag__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Bag__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Bag__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Bag__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Bag__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Bag__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Bag__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Bag__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Bag__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Bag__Collection = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Bag__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Bag__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Bag__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Bag__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Bag__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Bag__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Bag__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Bag__OclAny = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Boolean__Boolean = {
			OCLstdlibTables.Operations._Boolean___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Boolean___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Boolean__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__not /* _'not'() */,
			OCLstdlibTables.Operations._Boolean__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__xor /* _'xor'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._Boolean__and2 /* and2(Boolean[1]) */,
			OCLstdlibTables.Operations._Boolean__implies2 /* implies2(Boolean[1]) */,
			OCLstdlibTables.Operations._Boolean__not2 /* not2() */,
			OCLstdlibTables.Operations._Boolean__or2 /* or2(Boolean[1]) */,
			OCLstdlibTables.Operations._Boolean__toString /* toString() */,
			OCLstdlibTables.Operations._Boolean__xor2 /* xor2(Boolean[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Boolean__OclAny = {
			OCLstdlibTables.Operations._Boolean___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Boolean___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._Boolean__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Collection__Collection = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Collection__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Collection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Collection__OclAny = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Integer__Integer = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Integer__div /* div(Integer[1]) */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer__mod /* mod(Integer[1]) */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */,
			OCLstdlibTables.Operations._Integer__toUnlimitedNatural /* toUnlimitedNatural() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Integer__OclAny = {
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Integer__OclComparable = {
			OCLstdlibTables.Operations._OclComparable___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable__compareTo /* compareTo(OclSelf[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Integer__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Integer__Real = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Real__floor /* floor() */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf[1]) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real__round /* round() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Map__Map = {
			OCLstdlibTables.Operations._Map___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Map___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Map__any /* any(K[1]|Lambda K() : Boolean[1]) */,
			OCLstdlibTables.Operations._Map__at /* at(K[?]) */,
			OCLstdlibTables.Operations._Map__collect /* collect(V2)(K[?]|Lambda K() : V2[?]) */,
			OCLstdlibTables.Operations._Map__collectBy /* collectBy(V2)(K[?]|Lambda K() : V2[?]) */,
			OCLstdlibTables.Operations._Map__collectNested /* collectNested(V2)(K[?]|Lambda K() : V2[?]) */,
			OCLstdlibTables.Operations._Map__0_excludes /* excludes(K[?]) */,
			OCLstdlibTables.Operations._Map__1_excludes /* excludes(K[?],V[?]) */,
			OCLstdlibTables.Operations._Map__excludesAll /* excludesAll(K2)(Collection(K2)) */,
			OCLstdlibTables.Operations._Map__excludesMap /* excludesMap(K2, V2)(Map(K2[1],V2[1])[1]) */,
			OCLstdlibTables.Operations._Map__excludesValue /* excludesValue(V[?]) */,
			OCLstdlibTables.Operations._Map__0_excluding /* excluding(K[?]) */,
			OCLstdlibTables.Operations._Map__1_excluding /* excluding(K[?],V[?]) */,
			OCLstdlibTables.Operations._Map__excludingAll /* excludingAll(Collection(K)) */,
			OCLstdlibTables.Operations._Map__excludingMap /* excludingMap(K2, V2)(Map(K2[1],V2[1])[1]) */,
			OCLstdlibTables.Operations._Map__2_exists /* exists(K[?],K[?],K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__1_exists /* exists(K[?],K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__0_exists /* exists(K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__2_forAll /* forAll(K[?],K[?],K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__1_forAll /* forAll(K[?],K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__0_forAll /* forAll(K[?]|Lambda K() : Boolean[?]) */,
			OCLstdlibTables.Operations._Map__0_includes /* includes(K[?]) */,
			OCLstdlibTables.Operations._Map__1_includes /* includes(K[?],V[?]) */,
			OCLstdlibTables.Operations._Map__includesAll /* includesAll(K2)(Collection(K2)) */,
			OCLstdlibTables.Operations._Map__includesMap /* includesMap(K2, V2)(Map(K2[1],V2[1])[1]) */,
			OCLstdlibTables.Operations._Map__includesValue /* includesValue(V[?]) */,
			OCLstdlibTables.Operations._Map__including /* including(K[?],V[?]) */,
			OCLstdlibTables.Operations._Map__includingMap /* includingMap(K2, V2)(Map(K2[1],V2[1])[1]) */,
			OCLstdlibTables.Operations._Map__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Map__isUnique /* isUnique(K[?]|Lambda K() : OclAny[?]) */,
			OCLstdlibTables.Operations._Map__iterate /* iterate(Tacc)(K[?];Tacc[?]|Lambda K() : Tacc[?]) */,
			OCLstdlibTables.Operations._Map__keys /* keys() */,
			OCLstdlibTables.Operations._Map__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Map__one /* one(K[?]|Lambda K() : Boolean[1]) */,
			OCLstdlibTables.Operations._Map__reject /* reject(K[?]|Lambda K() : Boolean[1]) */,
			OCLstdlibTables.Operations._Map__select /* select(K[?]|Lambda K() : Boolean[1]) */,
			OCLstdlibTables.Operations._Map__size /* size() */,
			OCLstdlibTables.Operations._Map__values /* values() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Map__OclAny = {
			OCLstdlibTables.Operations._Map___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Map___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclAny__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclComparable__OclComparable = {
			OCLstdlibTables.Operations._OclComparable___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable__compareTo /* compareTo(OclSelf[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclComparable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclEnumeration__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclEnumeration__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclEnumeration__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclEnumeration__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclInvalid__OclInvalid = {
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclBadOperation /* oclBadOperation() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclInvalid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclInvalid__OclAny = {
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclVoid__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclInvalid__OclVoid = {
			OCLstdlibTables.Operations._OclVoid___add_ /* _'+'(String[?]) */,
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclInvalid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__not /* _'not'() */,
			OCLstdlibTables.Operations._OclInvalid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__xor /* _'xor'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclVoid__concat /* concat(String[?]) */,
			OCLstdlibTables.Operations._OclInvalid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclInvalid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclVoid__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclLambda__OclLambda = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OclLambda__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclMessage__OclMessage = {
			OCLstdlibTables.Operations._OclMessage__hasReturned /* hasReturned() */,
			OCLstdlibTables.Operations._OclMessage__isOperationCall /* isOperationCall() */,
			OCLstdlibTables.Operations._OclMessage__isSignalSent /* isSignalSent() */,
			OCLstdlibTables.Operations._OclMessage__result /* result() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclMessage__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclSelf__OclSelf = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OclSelf__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclState__OclState = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OclState__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclStereotype__OclStereotype = {
			OCLstdlibTables.Operations._OclStereotype__allInstances /* allInstances(Integer[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclStereotype__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclStereotype__OclElement = {
			OCLstdlibTables.Operations._OclStereotype__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclStereotype__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclSummable__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclSummable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclTuple__OclTuple = {
			OCLstdlibTables.Operations._OclTuple___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclTuple___eq_ /* _'='(OclSelf[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclTuple__OclAny = {
			OCLstdlibTables.Operations._OclTuple___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclTuple___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OclVoid__OclVoid = {
			OCLstdlibTables.Operations._OclVoid___add_ /* _'+'(String[?]) */,
			OCLstdlibTables.Operations._OclVoid___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclVoid___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclVoid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__not /* _'not'() */,
			OCLstdlibTables.Operations._OclVoid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__xor /* _'xor'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclVoid__concat /* concat(String[?]) */,
			OCLstdlibTables.Operations._OclVoid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclVoid__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclVoid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclVoid__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclVoid__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclVoid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclVoid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclVoid__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclVoid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OclVoid__OclAny = {
			OCLstdlibTables.Operations._OclVoid___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclVoid___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclVoid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclVoid__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclVoid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclVoid__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclVoid__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclVoid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclVoid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclVoid__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclVoid__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OrderedCollection__OrderedCollection = {
			OCLstdlibTables.Operations._OrderedCollection__at /* at(Integer[1]) */,
			OCLstdlibTables.Operations._OrderedCollection__first /* first() */,
			OCLstdlibTables.Operations._OrderedCollection__indexOf /* indexOf(T[?]) */,
			OCLstdlibTables.Operations._OrderedCollection__last /* last() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedCollection__Collection = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Collection__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Collection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedCollection__OclAny = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OrderedSet__OrderedSet = {
			OCLstdlibTables.Operations._OrderedSet___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OrderedSet__append /* append(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__appendAll /* appendAll(OrderedCollection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__closure /* closure(T[1]|Lambda T() : OrderedSet(T)[?]) */,
			OCLstdlibTables.Operations._OrderedSet__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._OrderedSet__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._OrderedSet__including /* including(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__insertAt /* insertAt(Integer[1],T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__prepend /* prepend(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__prependAll /* prependAll(OrderedCollection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._OrderedSet__reverse /* reverse() */,
			OCLstdlibTables.Operations._OrderedSet__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._OrderedSet__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OrderedSet__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._OrderedSet__subOrderedSet /* subOrderedSet(Integer[1],Integer[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedSet__Collection = {
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._OrderedSet__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._OrderedSet__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._OrderedSet__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__including /* including(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._OrderedSet__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._OrderedSet__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OrderedSet__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedSet__OclAny = {
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedSet__OrderedCollection = {
			OCLstdlibTables.Operations._OrderedCollection__at /* at(Integer[1]) */,
			OCLstdlibTables.Operations._OrderedCollection__first /* first() */,
			OCLstdlibTables.Operations._OrderedCollection__indexOf /* indexOf(T[?]) */,
			OCLstdlibTables.Operations._OrderedCollection__last /* last() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OrderedSet__UniqueCollection = {
			OCLstdlibTables.Operations._OrderedSet___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Real__Real = {
			OCLstdlibTables.Operations._Real___mul_ /* _'*'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real___add_ /* _'+'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Real___sub_ /* _'-'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real___div_ /* _'/'(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Real__abs /* abs() */,
			OCLstdlibTables.Operations._Real__floor /* floor() */,
			OCLstdlibTables.Operations._Real__max /* max(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real__min /* min(OclSelf[1]) */,
			OCLstdlibTables.Operations._Real__round /* round() */,
			OCLstdlibTables.Operations._Real__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Real__OclAny = {
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._Real__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Real__OclComparable = {
			OCLstdlibTables.Operations._OclComparable___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable__compareTo /* compareTo(OclSelf[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Real__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Sequence__Sequence = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Sequence__append /* append(T[?]) */,
			OCLstdlibTables.Operations._Sequence__appendAll /* appendAll(OrderedCollection(T)) */,
			OCLstdlibTables.Operations._Sequence__closure /* closure(T[1]|Lambda T() : OrderedSet(T)[?]) */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Sequence__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Sequence__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Sequence__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Sequence__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Sequence__insertAt /* insertAt(Integer[1],T[?]) */,
			OCLstdlibTables.Operations._Sequence__prepend /* prepend(T[?]) */,
			OCLstdlibTables.Operations._Sequence__prependAll /* prependAll(OrderedCollection(T)) */,
			OCLstdlibTables.Operations._Sequence__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Sequence__reverse /* reverse() */,
			OCLstdlibTables.Operations._Sequence__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Sequence__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Sequence__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Sequence__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Sequence__subSequence /* subSequence(Integer[1],Integer[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Sequence__Collection = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Sequence__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Sequence__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Sequence__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Sequence__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Sequence__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Sequence__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Sequence__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Sequence__OclAny = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Sequence__OrderedCollection = {
			OCLstdlibTables.Operations._OrderedCollection__at /* at(Integer[1]) */,
			OCLstdlibTables.Operations._OrderedCollection__first /* first() */,
			OCLstdlibTables.Operations._OrderedCollection__indexOf /* indexOf(T[?]) */,
			OCLstdlibTables.Operations._OrderedCollection__last /* last() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Set__Set = {
			OCLstdlibTables.Operations._Set___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Set__closure /* closure(T[1]|Lambda T() : Set(T)[?]) */,
			OCLstdlibTables.Operations._Set__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Set__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Set__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Set__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Set__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Set__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Set__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Set__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Set__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Set__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Set__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Set__Collection = {
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Set__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Set__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Set__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Set__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Set__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Set__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Set__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Set__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Set__OclAny = {
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Set__UniqueCollection = {
			OCLstdlibTables.Operations._Set___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _String__String = {
			OCLstdlibTables.Operations._String___add_ /* _'+'(String[?]) */,
			OCLstdlibTables.Operations._String___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._String___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._String___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._String__at /* at(Integer[1]) */,
			OCLstdlibTables.Operations._String__characters /* characters() */,
			OCLstdlibTables.Operations._String__compareTo /* compareTo(OclSelf[1]) */,
			OCLstdlibTables.Operations._String__concat /* concat(String[?]) */,
			OCLstdlibTables.Operations._String__endsWith /* endsWith(String[1]) */,
			OCLstdlibTables.Operations._String__equalsIgnoreCase /* equalsIgnoreCase(String[1]) */,
			OCLstdlibTables.Operations._String__indexOf /* indexOf(String[1]) */,
			OCLstdlibTables.Operations._String__lastIndexOf /* lastIndexOf(String[1]) */,
			OCLstdlibTables.Operations._String__matches /* matches(String[1]) */,
			OCLstdlibTables.Operations._String__replaceAll /* replaceAll(String[1],String[1]) */,
			OCLstdlibTables.Operations._String__replaceFirst /* replaceFirst(String[1],String[1]) */,
			OCLstdlibTables.Operations._String__size /* size() */,
			OCLstdlibTables.Operations._String__startsWith /* startsWith(String[1]) */,
			OCLstdlibTables.Operations._String__substituteAll /* substituteAll(String[1],String[1]) */,
			OCLstdlibTables.Operations._String__substituteFirst /* substituteFirst(String[1],String[1]) */,
			OCLstdlibTables.Operations._String__substring /* substring(Integer[1],Integer[1]) */,
			OCLstdlibTables.Operations._String__toBoolean /* toBoolean() */,
			OCLstdlibTables.Operations._String__toInteger /* toInteger() */,
			OCLstdlibTables.Operations._String__toLower /* toLower() */,
			OCLstdlibTables.Operations._String__toLowerCase /* toLowerCase() */,
			OCLstdlibTables.Operations._String__toReal /* toReal() */,
			OCLstdlibTables.Operations._String__toString /* toString() */,
			OCLstdlibTables.Operations._String__toUpper /* toUpper() */,
			OCLstdlibTables.Operations._String__toUpperCase /* toUpperCase() */,
			OCLstdlibTables.Operations._String__0_tokenize /* tokenize() */,
			OCLstdlibTables.Operations._String__1_tokenize /* tokenize(String[1]) */,
			OCLstdlibTables.Operations._String__2_tokenize /* tokenize(String[1],Boolean[1]) */,
			OCLstdlibTables.Operations._String__trim /* trim() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _String__OclAny = {
			OCLstdlibTables.Operations._String___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._String___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._String__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _String__OclComparable = {
			OCLstdlibTables.Operations._String___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._String___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._String__compareTo /* compareTo(OclSelf[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _String__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _UniqueCollection__UniqueCollection = {
			OCLstdlibTables.Operations._UniqueCollection___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UniqueCollection__Collection = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[1]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Collection__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectBy /* collectBy(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__excluding /* excluding(T[?]) */,
			OCLstdlibTables.Operations._Collection__excludingAll /* excludingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__2_exists /* exists(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__2_forAll /* forAll(T[?],T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean[?]) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(T[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__reject /* reject(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__select /* select(T[?]|Lambda T() : Boolean[1]) */,
			OCLstdlibTables.Operations._Collection__selectByKind /* selectByKind(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__selectByType /* selectByType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._UniqueCollection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UniqueCollection__OclAny = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _UnlimitedNatural__UnlimitedNatural = {
			OCLstdlibTables.Operations._UnlimitedNatural__max /* max(OclSelf[1]) */,
			OCLstdlibTables.Operations._UnlimitedNatural__min /* min(OclSelf[1]) */,
			OCLstdlibTables.Operations._UnlimitedNatural__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._UnlimitedNatural__toInteger /* toInteger() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnlimitedNatural__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._UnlimitedNatural__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnlimitedNatural__OclComparable = {
			OCLstdlibTables.Operations._OclComparable___lt_ /* _'<'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___lt__eq_ /* _'<='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt_ /* _'>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable___gt__eq_ /* _'>='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclComparable__compareTo /* compareTo(OclSelf[1]) */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Bag__Bag.initOperations(_Bag__Bag);
			Fragments._Bag__Collection.initOperations(_Bag__Collection);
			Fragments._Bag__OclAny.initOperations(_Bag__OclAny);

			Fragments._Boolean__Boolean.initOperations(_Boolean__Boolean);
			Fragments._Boolean__OclAny.initOperations(_Boolean__OclAny);

			Fragments._Collection__Collection.initOperations(_Collection__Collection);
			Fragments._Collection__OclAny.initOperations(_Collection__OclAny);

			Fragments._Integer__Integer.initOperations(_Integer__Integer);
			Fragments._Integer__OclAny.initOperations(_Integer__OclAny);
			Fragments._Integer__OclComparable.initOperations(_Integer__OclComparable);
			Fragments._Integer__OclSummable.initOperations(_Integer__OclSummable);
			Fragments._Integer__Real.initOperations(_Integer__Real);

			Fragments._Map__Map.initOperations(_Map__Map);
			Fragments._Map__OclAny.initOperations(_Map__OclAny);

			Fragments._OclAny__OclAny.initOperations(_OclAny__OclAny);

			Fragments._OclComparable__OclAny.initOperations(_OclComparable__OclAny);
			Fragments._OclComparable__OclComparable.initOperations(_OclComparable__OclComparable);

			Fragments._OclElement__OclAny.initOperations(_OclElement__OclAny);
			Fragments._OclElement__OclElement.initOperations(_OclElement__OclElement);

			Fragments._OclEnumeration__OclAny.initOperations(_OclEnumeration__OclAny);
			Fragments._OclEnumeration__OclElement.initOperations(_OclEnumeration__OclElement);
			Fragments._OclEnumeration__OclEnumeration.initOperations(_OclEnumeration__OclEnumeration);
			Fragments._OclEnumeration__OclType.initOperations(_OclEnumeration__OclType);

			Fragments._OclInvalid__OclAny.initOperations(_OclInvalid__OclAny);
			Fragments._OclInvalid__OclInvalid.initOperations(_OclInvalid__OclInvalid);
			Fragments._OclInvalid__OclVoid.initOperations(_OclInvalid__OclVoid);

			Fragments._OclLambda__OclAny.initOperations(_OclLambda__OclAny);
			Fragments._OclLambda__OclLambda.initOperations(_OclLambda__OclLambda);

			Fragments._OclMessage__OclAny.initOperations(_OclMessage__OclAny);
			Fragments._OclMessage__OclMessage.initOperations(_OclMessage__OclMessage);

			Fragments._OclSelf__OclAny.initOperations(_OclSelf__OclAny);
			Fragments._OclSelf__OclSelf.initOperations(_OclSelf__OclSelf);

			Fragments._OclState__OclAny.initOperations(_OclState__OclAny);
			Fragments._OclState__OclState.initOperations(_OclState__OclState);

			Fragments._OclStereotype__OclAny.initOperations(_OclStereotype__OclAny);
			Fragments._OclStereotype__OclElement.initOperations(_OclStereotype__OclElement);
			Fragments._OclStereotype__OclStereotype.initOperations(_OclStereotype__OclStereotype);
			Fragments._OclStereotype__OclType.initOperations(_OclStereotype__OclType);

			Fragments._OclSummable__OclAny.initOperations(_OclSummable__OclAny);
			Fragments._OclSummable__OclSummable.initOperations(_OclSummable__OclSummable);

			Fragments._OclTuple__OclAny.initOperations(_OclTuple__OclAny);
			Fragments._OclTuple__OclTuple.initOperations(_OclTuple__OclTuple);

			Fragments._OclType__OclAny.initOperations(_OclType__OclAny);
			Fragments._OclType__OclElement.initOperations(_OclType__OclElement);
			Fragments._OclType__OclType.initOperations(_OclType__OclType);

			Fragments._OclVoid__OclAny.initOperations(_OclVoid__OclAny);
			Fragments._OclVoid__OclVoid.initOperations(_OclVoid__OclVoid);

			Fragments._OrderedCollection__Collection.initOperations(_OrderedCollection__Collection);
			Fragments._OrderedCollection__OclAny.initOperations(_OrderedCollection__OclAny);
			Fragments._OrderedCollection__OrderedCollection.initOperations(_OrderedCollection__OrderedCollection);

			Fragments._OrderedSet__Collection.initOperations(_OrderedSet__Collection);
			Fragments._OrderedSet__OclAny.initOperations(_OrderedSet__OclAny);
			Fragments._OrderedSet__OrderedCollection.initOperations(_OrderedSet__OrderedCollection);
			Fragments._OrderedSet__OrderedSet.initOperations(_OrderedSet__OrderedSet);
			Fragments._OrderedSet__UniqueCollection.initOperations(_OrderedSet__UniqueCollection);

			Fragments._Real__OclAny.initOperations(_Real__OclAny);
			Fragments._Real__OclComparable.initOperations(_Real__OclComparable);
			Fragments._Real__OclSummable.initOperations(_Real__OclSummable);
			Fragments._Real__Real.initOperations(_Real__Real);

			Fragments._Sequence__Collection.initOperations(_Sequence__Collection);
			Fragments._Sequence__OclAny.initOperations(_Sequence__OclAny);
			Fragments._Sequence__OrderedCollection.initOperations(_Sequence__OrderedCollection);
			Fragments._Sequence__Sequence.initOperations(_Sequence__Sequence);

			Fragments._Set__Collection.initOperations(_Set__Collection);
			Fragments._Set__OclAny.initOperations(_Set__OclAny);
			Fragments._Set__Set.initOperations(_Set__Set);
			Fragments._Set__UniqueCollection.initOperations(_Set__UniqueCollection);

			Fragments._String__OclAny.initOperations(_String__OclAny);
			Fragments._String__OclComparable.initOperations(_String__OclComparable);
			Fragments._String__OclSummable.initOperations(_String__OclSummable);
			Fragments._String__String.initOperations(_String__String);

			Fragments._UniqueCollection__Collection.initOperations(_UniqueCollection__Collection);
			Fragments._UniqueCollection__OclAny.initOperations(_UniqueCollection__OclAny);
			Fragments._UniqueCollection__UniqueCollection.initOperations(_UniqueCollection__UniqueCollection);

			Fragments._UnlimitedNatural__OclAny.initOperations(_UnlimitedNatural__OclAny);
			Fragments._UnlimitedNatural__OclComparable.initOperations(_UnlimitedNatural__OclComparable);
			Fragments._UnlimitedNatural__UnlimitedNatural.initOperations(_UnlimitedNatural__UnlimitedNatural);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final @NonNull ExecutorProperty @NonNull [] _Bag = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Boolean = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Collection = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Integer = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Map = {
			OCLstdlibTables.Properties._Map__keyType,
			OCLstdlibTables.Properties._Map__valueType
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclAny = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclComparable = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclElement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclEnumeration = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclInvalid = {
			OCLstdlibTables.Properties._OclInvalid__oclBadProperty
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclLambda = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclMessage = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclSelf = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclState = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclStereotype = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclSummable = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclTuple = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OclType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OclVoid = {};

		private static final @NonNull ExecutorProperty @NonNull [] _OrderedCollection = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OrderedSet = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Real = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Sequence = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Set = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _String = {};

		private static final @NonNull ExecutorProperty @NonNull [] _UniqueCollection = {
			OCLstdlibTables.Properties._Collection__elementType,
			OCLstdlibTables.Properties._Collection__lower,
			OCLstdlibTables.Properties._Collection__upper
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UnlimitedNatural = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Bag__Bag.initProperties(_Bag);
			Fragments._Boolean__Boolean.initProperties(_Boolean);
			Fragments._Collection__Collection.initProperties(_Collection);
			Fragments._Integer__Integer.initProperties(_Integer);
			Fragments._Map__Map.initProperties(_Map);
			Fragments._OclAny__OclAny.initProperties(_OclAny);
			Fragments._OclComparable__OclComparable.initProperties(_OclComparable);
			Fragments._OclElement__OclElement.initProperties(_OclElement);
			Fragments._OclEnumeration__OclEnumeration.initProperties(_OclEnumeration);
			Fragments._OclInvalid__OclInvalid.initProperties(_OclInvalid);
			Fragments._OclLambda__OclLambda.initProperties(_OclLambda);
			Fragments._OclMessage__OclMessage.initProperties(_OclMessage);
			Fragments._OclSelf__OclSelf.initProperties(_OclSelf);
			Fragments._OclState__OclState.initProperties(_OclState);
			Fragments._OclStereotype__OclStereotype.initProperties(_OclStereotype);
			Fragments._OclSummable__OclSummable.initProperties(_OclSummable);
			Fragments._OclTuple__OclTuple.initProperties(_OclTuple);
			Fragments._OclType__OclType.initProperties(_OclType);
			Fragments._OclVoid__OclVoid.initProperties(_OclVoid);
			Fragments._OrderedCollection__OrderedCollection.initProperties(_OrderedCollection);
			Fragments._OrderedSet__OrderedSet.initProperties(_OrderedSet);
			Fragments._Real__Real.initProperties(_Real);
			Fragments._Sequence__Sequence.initProperties(_Sequence);
			Fragments._Set__Set.initProperties(_Set);
			Fragments._String__String.initProperties(_String);
			Fragments._UniqueCollection__UniqueCollection.initProperties(_UniqueCollection);
			Fragments._UnlimitedNatural__UnlimitedNatural.initProperties(_UnlimitedNatural);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of OCLstdlibTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new OCLstdlibTables();
	}

	private OCLstdlibTables() {
		super(OCLstdlibPackage.eNS_URI);
	}
}
