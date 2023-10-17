/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.pivot.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.lookup.LookupPackage;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

public class PivotUnqualifiedLookupVisitor
extends AbstractPivotCommonLookupVisitor
{
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Lookup", null, LookupPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Pivot", null, PivotPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_org_eclipse_ocl_pivot_util = IdManager.getRootPackageId("java://org.eclipse.ocl.pivot.util");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Behavior = PACKid_$metamodel$.getClassId("Behavior", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DataType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DataType_0 = PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element_0 = PACKid_$metamodel$.getClassId("Element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Enumeration = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Enumeration", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EnumerationLiteral = PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Enumeration_0 = PACKid_$metamodel$.getClassId("Enumeration", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("ExpressionInOCL", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL_0 = PACKid_$metamodel$.getClassId("ExpressionInOCL", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Import = PACKid_$metamodel$.getClassId("Import", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IterateExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IterateExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IterateExp_0 = PACKid_$metamodel$.getClassId("IterateExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IteratorExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IteratorExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IteratorExp_0 = PACKid_$metamodel$.getClassId("IteratorExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LetExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("LetExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LetExp_0 = PACKid_$metamodel$.getClassId("LetExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Library", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Library_0 = PACKid_$metamodel$.getClassId("Library", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Model", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model_0 = PACKid_$metamodel$.getClassId("Model", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation_0 = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Package", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package_0 = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PivotUnqualifiedLookupVisitor = PACKid_java_c_s_s_org_eclipse_ocl_pivot_util.getClassId("PivotUnqualifiedLookupVisitor", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Precedence = PACKid_$metamodel$.getClassId("Precedence", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Behavior = TypeId.BAG.getSpecializedId(CLSSid_Behavior);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Operation = TypeId.BAG.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Property = TypeId.BAG.getSpecializedId(CLSSid_Property);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteral);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Import = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Import);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Precedence = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Precedence);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Behavior = TypeId.SET.getSpecializedId(CLSSid_Behavior);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_DataType = TypeId.SET.getSpecializedId(CLSSid_DataType_0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package_0);

	protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
	protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
	protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child;

	public PivotUnqualifiedLookupVisitor(@NonNull LookupEnvironment context) {
		super(context);
		this.executor = ClassUtil.nonNullState(context.getExecutor());
		this.idResolver = executor.getIdResolver();
	}

	@Override
	protected @Nullable LookupEnvironment doVisiting(@NonNull Visitable visitable) {
		return parentEnv((EObject)visitable);
	}

	/**
	 * Continue the search for matches in the parent of element.
	 */
	protected @Nullable LookupEnvironment parentEnv(@NonNull EObject element) {
		EObject parent = element.eContainer();
		if (parent instanceof Visitable) {
			this.child = element;
			return ((Visitable)parent).accept(this);
		}
		else {
			return context;
		}
	}

	/**
	 * visitClass(element : Class[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitClass(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class element) {
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, element);
		final org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOfValue(null, oclAsSet);
		final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
		final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, SET_CLSSid_Class);
		/**
		 * Implementation of the iterator body.
		 */
		final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
		{
			/**
			 * _'null' : Set(Class)
			 */
			@Override
			public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object _1) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class symbol_0 = (Class)_1;
				if (symbol_0 == null) {
					throw new InvalidValueException("Null source for \'Class::superClasses\'");
				}
				final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Class> superClasses_0 = symbol_0.getSuperClasses();
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(SET_CLSSid_Class, superClasses_0);
				return BOXED_superClasses_0;
			}
		};
		final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue superClasses = ClassUtil.nonNullState((SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
		@Nullable Iterator<?> ITERATOR__1_0 = superClasses.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
		while (true) {
			if (!ITERATOR__1_0.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class _1_0 = (Class)ITERATOR__1_0.next();
			/**
			 * _'null' : OrderedSet(Property)
			 */
			if (_1_0 == null) {
				throw new InvalidValueException("Null source for \'Class::ownedProperties\'");
			}
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ownedProperties = _1_0.getOwnedProperties();
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
			//
			for (Object value : BOXED_ownedProperties.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
		@Nullable Iterator<?> ITERATOR__1_1 = collect.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue select;
		while (true) {
			if (!ITERATOR__1_1.hasNext()) {
				select = accumulator_0;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Property _1_1 = (Property)ITERATOR__1_1.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1_1 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic = _1_1.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
			if (not == null) {
				throw new InvalidValueException("Null body for \'Bag(T).select(Bag.T[?] | Lambda T() : Boolean[1]) : Bag(T)\'");
			}
			//
			if (not == ValueUtil.TRUE_VALUE) {
				accumulator_0.add(_1_1);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, select);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ECORE_select);
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_1 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
		@Nullable Iterator<?> ITERATOR__1_2 = superClasses.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect_0;
		while (true) {
			if (!ITERATOR__1_2.hasNext()) {
				collect_0 = accumulator_1;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class _1_2 = (Class)ITERATOR__1_2.next();
			/**
			 * _'null' : OrderedSet(Operation)
			 */
			if (_1_2 == null) {
				throw new InvalidValueException("Null source for \'Class::ownedOperations\'");
			}
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ownedOperations = _1_2.getOwnedOperations();
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
			//
			for (Object value : BOXED_ownedOperations.flatten().getElements()) {
				accumulator_1.add(value);
			}
		}
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_2 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
		@Nullable Iterator<?> ITERATOR__1_3 = collect_0.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue select_0;
		while (true) {
			if (!ITERATOR__1_3.hasNext()) {
				select_0 = accumulator_2;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Operation _1_3 = (Operation)ITERATOR__1_3.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1_3 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic_0 = _1_3.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
			if (not_0 == null) {
				throw new InvalidValueException("Null body for \'Bag(T).select(Bag.T[?] | Lambda T() : Boolean[1]) : Bag(T)\'");
			}
			//
			if (not_0 == ValueUtil.TRUE_VALUE) {
				accumulator_2.add(_1_3);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_select_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, select_0);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = addElements.addElements(ECORE_select_0);
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_3 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Behavior);
		@Nullable Iterator<?> ITERATOR__1_4 = superClasses.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect_1;
		while (true) {
			if (!ITERATOR__1_4.hasNext()) {
				collect_1 = accumulator_3;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class _1_4 = (Class)ITERATOR__1_4.next();
			/**
			 * _'null' : Set(Behavior)
			 */
			if (_1_4 == null) {
				throw new InvalidValueException("Null source for \'Class::ownedBehaviors\'");
			}
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Behavior> ownedBehaviors = _1_4.getOwnedBehaviors();
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_ownedBehaviors = idResolver.createSetOfAll(SET_CLSSid_Behavior, ownedBehaviors);
			//
			for (Object value : BOXED_ownedBehaviors.flatten().getElements()) {
				accumulator_3.add(value);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Behavior> ECORE_collect_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Behavior.class, collect_1);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements_0.addElements(ECORE_collect_1);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
		if (hasFinalResult) {
			symbol_1 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element);
			symbol_1 = parentEnv;
		}
		return symbol_1;
	}

	/**
	 * visitDataType(element : DataType[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitDataType(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull DataType element_0) {
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_DataType, element_0);
		final org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOfValue(null, oclAsSet);
		final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
		final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, SET_CLSSid_Class);
		/**
		 * Implementation of the iterator body.
		 */
		final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
		{
			/**
			 * _'null' : Set(Class)
			 */
			@Override
			public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object c) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class symbol_0 = (Class)c;
				if (symbol_0 == null) {
					throw new InvalidValueException("Null source for \'Class::superClasses\'");
				}
				final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Class> superClasses_0 = symbol_0.getSuperClasses();
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(SET_CLSSid_Class, superClasses_0);
				return BOXED_superClasses_0;
			}
		};
		final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue superClasses = ClassUtil.nonNullState((SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
		@Nullable Iterator<?> ITERATOR__1 = superClasses.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class _1 = (Class)ITERATOR__1.next();
			/**
			 * _'null' : OrderedSet(Property)
			 */
			if (_1 == null) {
				throw new InvalidValueException("Null source for \'Class::ownedProperties\'");
			}
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ownedProperties = _1.getOwnedProperties();
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
			//
			for (Object value : BOXED_ownedProperties.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
		@Nullable Iterator<?> ITERATOR__1_0 = collect.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue select;
		while (true) {
			if (!ITERATOR__1_0.hasNext()) {
				select = accumulator_0;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Property _1_0 = (Property)ITERATOR__1_0.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1_0 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic = _1_0.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
			if (not == null) {
				throw new InvalidValueException("Null body for \'Bag(T).select(Bag.T[?] | Lambda T() : Boolean[1]) : Bag(T)\'");
			}
			//
			if (not == ValueUtil.TRUE_VALUE) {
				accumulator_0.add(_1_0);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, select);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ECORE_select);
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_1 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
		@Nullable Iterator<?> ITERATOR__1_1 = superClasses.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect_0;
		while (true) {
			if (!ITERATOR__1_1.hasNext()) {
				collect_0 = accumulator_1;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Class _1_1 = (Class)ITERATOR__1_1.next();
			/**
			 * _'null' : OrderedSet(Operation)
			 */
			if (_1_1 == null) {
				throw new InvalidValueException("Null source for \'Class::ownedOperations\'");
			}
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ownedOperations = _1_1.getOwnedOperations();
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
			//
			for (Object value : BOXED_ownedOperations.flatten().getElements()) {
				accumulator_1.add(value);
			}
		}
		/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_2 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
		@Nullable Iterator<?> ITERATOR__1_2 = collect_0.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue select_0;
		while (true) {
			if (!ITERATOR__1_2.hasNext()) {
				select_0 = accumulator_2;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Operation _1_2 = (Operation)ITERATOR__1_2.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1_2 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic_0 = _1_2.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
			if (not_0 == null) {
				throw new InvalidValueException("Null body for \'Bag(T).select(Bag.T[?] | Lambda T() : Boolean[1]) : Bag(T)\'");
			}
			//
			if (not_0 == ValueUtil.TRUE_VALUE) {
				accumulator_2.add(_1_2);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_select_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, select_0);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements.addElements(ECORE_select_0);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
		if (hasFinalResult) {
			symbol_1 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_0);
			symbol_1 = parentEnv;
		}
		return symbol_1;
	}

	/**
	 * visitElement(element : Element[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitElement(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Element element_1) {
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_1);
		return parentEnv;
	}

	/**
	 * visitEnumeration(element : Enumeration[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitEnumeration(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Enumeration element_2) {
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<EnumerationLiteral> ownedLiterals = element_2.getOwnedLiterals();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ownedLiterals);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ownedProperties = element_2.getOwnedProperties();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
		/*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Property);
		@Nullable Iterator<?> ITERATOR__1 = BOXED_ownedProperties.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue select;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				select = accumulator;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Property _1 = (Property)ITERATOR__1.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic = _1.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
			if (not == null) {
				throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
			}
			//
			if (not == ValueUtil.TRUE_VALUE) {
				accumulator.add(_1);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Property> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, select);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = addElements.addElements(ECORE_select);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ownedOperations = element_2.getOwnedOperations();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
		/*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Operation);
		@Nullable Iterator<?> ITERATOR__1_0 = BOXED_ownedOperations.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue select_0;
		while (true) {
			if (!ITERATOR__1_0.hasNext()) {
				select_0 = accumulator_0;
				break;
			}
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Operation _1_0 = (Operation)ITERATOR__1_0.next();
			/**
			 * _'not' : Boolean[?]
			 */
			if (_1_0 == null) {
				throw new InvalidValueException("Null source for \'Feature::isStatic\'");
			}
			final /*@Thrown*/ boolean isStatic_0 = _1_0.isIsStatic();
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
			if (not_0 == null) {
				throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
			}
			//
			if (not_0 == ValueUtil.TRUE_VALUE) {
				accumulator_0.add(_1_0);
			}
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_select_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, select_0);
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_1 = addElements_0.addElements(ECORE_select_0);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Behavior> ownedBehaviors = element_2.getOwnedBehaviors();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements_1.addElements(ownedBehaviors);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
		if (hasFinalResult) {
			symbol_0 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_2);
			symbol_0 = parentEnv;
		}
		return symbol_0;
	}

	/**
	 * visitExpressionInOCL(element : ExpressionInOCL[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitExpressionInOCL(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL element_3) {
		final /*@Thrown*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Variable ownedContext = element_3.getOwnedContext();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElement = context.addElement(ownedContext);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Variable> ownedParameters = element_3.getOwnedParameters();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = addElement.addElements(ownedParameters);
		final /*@Thrown*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Variable ownedResult = element_3.getOwnedResult();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements.addElement(ownedResult);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
		if (hasFinalResult) {
			symbol_0 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_3);
			symbol_0 = parentEnv;
		}
		return symbol_0;
	}

	/**
	 * visitIterateExp(element : IterateExp[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitIterateExp(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull IterateExp element_4) {
		final /*@Thrown*/ java.util.List<Variable> ownedIterators = element_4.getOwnedIterators();
		assert ownedIterators != null;
		final /*@Thrown*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Variable ownedResult = element_4.getOwnedResult();
		final /*@Thrown*/ boolean eq = (child != null) ? child.equals(ownedResult) : (ownedResult == null);
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_4;
		if (eq) {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ownedIterators);
			final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
			if (hasFinalResult) {
				symbol_0 = inner;
			}
			else {
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_4);
				symbol_0 = parentEnv;
			}
			symbol_4 = symbol_0;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedIterators_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators_0, child);
			final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, index, INT_1).booleanValue();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_3;
			if (gt) {
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedIterators_0, INT_1, diff);
				final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Variable> ECORE_subOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, subOrderedSet);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner_0 = context.addElements(ECORE_subOrderedSet);
				final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
				/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
				if (hasFinalResult_0) {
					symbol_1 = inner_0;
				}
				else {
					final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element_4);
					symbol_1 = parentEnv_0;
				}
				symbol_3 = symbol_1;
			}
			else {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ownedIterators);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner_1 = addElements.addElement(ownedResult);
				final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
				/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_2;
				if (hasFinalResult_1) {
					symbol_2 = inner_1;
				}
				else {
					final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_1 = this.parentEnv(element_4);
					symbol_2 = parentEnv_1;
				}
				symbol_3 = symbol_2;
			}
			symbol_4 = symbol_3;
		}
		return symbol_4;
	}

	/**
	 * visitIteratorExp(element : IteratorExp[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitIteratorExp(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull IteratorExp element_5) {
		final /*@Thrown*/ java.util.List<Variable> ownedIterators = element_5.getOwnedIterators();
		assert ownedIterators != null;
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, child);
		final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, index, INT_1).booleanValue();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_2;
		if (gt) {
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
			final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedIterators, INT_1, diff);
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Variable> ECORE_subOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, subOrderedSet);
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ECORE_subOrderedSet);
			final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
			if (hasFinalResult) {
				symbol_0 = inner;
			}
			else {
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_5);
				symbol_0 = parentEnv;
			}
			symbol_2 = symbol_0;
		}
		else {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner_0 = context.addElements(ownedIterators);
			final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
			if (hasFinalResult_0) {
				symbol_1 = inner_0;
			}
			else {
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element_5);
				symbol_1 = parentEnv_0;
			}
			symbol_2 = symbol_1;
		}
		return symbol_2;
	}

	/**
	 * visitLetExp(element : LetExp[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitLetExp(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull LetExp element_6) {
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull OCLExpression ownedIn = element_6.getOwnedIn();
		final /*@Thrown*/ boolean eq = ownedIn.equals(child);
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
		if (eq) {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Variable ownedVariable = element_6.getOwnedVariable();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElement(ownedVariable);
			final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
			if (hasFinalResult) {
				symbol_0 = inner;
			}
			else {
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_6);
				symbol_0 = parentEnv;
			}
			symbol_1 = symbol_0;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element_6);
			symbol_1 = parentEnv_0;
		}
		return symbol_1;
	}

	/**
	 * visitLibrary(element : Library[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitLibrary(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Library element_7) {
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = element_7.getOwnedPackages();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ownedPackages);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Class> ownedClasses = element_7.getOwnedClasses();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = addElements.addElements(ownedClasses);
		@SuppressWarnings("null")
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Precedence> ownedPrecedences = element_7.getOwnedPrecedences();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements_0.addElements(ownedPrecedences);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
		if (hasFinalResult) {
			symbol_0 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_7);
			symbol_0 = parentEnv;
		}
		return symbol_0;
	}

	/**
	 * visitModel(element : Model[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitModel(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Model element_8) {
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_8);
		if (parentEnv == null) {
			throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(Collection(addElements.NE)) : lookup::LookupEnvironment[1]\'");
		}
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Import> ownedImports = element_8.getOwnedImports();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = parentEnv.addElements(ownedImports);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = element_8.getOwnedPackages();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = addElements.addElements(ownedPackages);
		return addElements_0;
	}

	/**
	 * visitOperation(element : Operation[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitOperation(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Operation element_9) {
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ownedParameters = element_9.getOwnedParameters();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_Parameter, ownedParameters);
		final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedParameters, child).booleanValue();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
		if (includes) {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_9);
			symbol_1 = parentEnv;
		}
		else {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ownedParameters);
			final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
			/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
			if (hasFinalResult) {
				symbol_0 = inner;
			}
			else {
				final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element_9);
				symbol_0 = parentEnv_0;
			}
			symbol_1 = symbol_0;
		}
		return symbol_1;
	}

	/**
	 * visitPackage(element : Package[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[?]
	 */
	@Override
	public /*@NonInvalid*/ LookupEnvironment visitPackage(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Package element_10) {
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = element_10.getOwnedPackages();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = context.addElements(ownedPackages);
		final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Class> ownedClasses = element_10.getOwnedClasses();
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElements.addElements(ownedClasses);
		final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
		/*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
		if (hasFinalResult) {
			symbol_0 = inner;
		}
		else {
			final /*@Thrown*/ org.eclipse.ocl.pivot.internal.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_10);
			symbol_0 = parentEnv;
		}
		return symbol_0;
	}
}
