/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * IdResolver supports discovery/creation of rich Pivot-based objects from limited
 * descriptors such as ElementIds, or from Ecore objects or from Java objects.
 */
public interface IdResolver extends IdVisitor<Element>
{
	/**
	 * @since 1.1
	 */
	public interface IdResolverExtension extends IdResolver
	{
		org.eclipse.ocl.pivot.@Nullable Package basicGetPackage(@NonNull PackageId packageId);
		@NonNull <T> EList<T> ecoreValueOfAll(@Nullable Class<T> instanceClass, @NonNull Iterable<? extends Object> values);
		@Nullable Iterable<org.eclipse.ocl.pivot.@NonNull Class> getModelClassesOf(@NonNull Object value);
		int oclHashCode(@Nullable Object anObject);
	}

	void addRoot(@NonNull EObject eObject);

	@Nullable Object boxedValueOf(@Nullable Object unboxedValue);

	@Nullable Object boxedValueOf(@NonNull Object unboxedValue, @Nullable EClassifier eClassifier);

	@Nullable Object boxedValueOf(@NonNull Object unboxedValue, @NonNull ETypedElement eFeature, @Nullable TypeId typeId);

	@NonNull BagValue createBagOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull BagValue createBagOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... unboxedValues);

	@NonNull CollectionValue createCollectionOfAll(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull CollectionValue createCollectionOfAll(@NonNull CollectionTypeId collectedId, @NonNull Iterable<?> unboxedValues);

	@Nullable Object createInstance(@NonNull TypeId typeId, @NonNull String stringValue);

	@Deprecated
	@NonNull MapValue createMapOfAll(@NonNull TypeId keyTypeId, @NonNull TypeId valueTypeId, @NonNull Map<?, ?> mapEntries);

	/**
	 * @since 1.18
	 */
	@NonNull MapValue createMapOfAll(@NonNull MapTypeId mapTypeId, @NonNull Map<?, ?> mapEntries);

	@NonNull OrderedSetValue createOrderedSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull OrderedSetValue createOrderedSetOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... unboxedValues);

	@NonNull SequenceValue createSequenceOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull SequenceValue createSequenceOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... unboxedValues);

	@NonNull SetValue createSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull SetValue createSetOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... unboxedValues);

	void dispose();

	/**
	 * Return a value adjusted to Ecore calling conventions.
	 * <p>
	 * A numeric value is adjusted to the precision indicated by instanceClass.
	 * <p>
	 * An enumeration literal is converted to an Enumerator.
	 * <p>
	 * Collections are converted to EcoreEList.UnmodifiableEList
	 */
	@Nullable Object ecoreValueOf(@Nullable Class<?> instanceClass, @Nullable Object value);

	/** @deprecated no longer used */
	@Deprecated
	@NonNull EList<Object> ecoreValuesOfAll(@Nullable Class<?> instanceClass, @NonNull Iterable<Object> values);

	/** @deprecated no longer used */
	@Deprecated
	@NonNull EList<Object> ecoreValuesOfEach(@Nullable Class<?> instanceClass, @NonNull Object @NonNull ... values);

	org.eclipse.ocl.pivot.@NonNull Class getClass(@NonNull TypeId typeId, @Nullable Object context);

	@NonNull Type getCollectionType(@NonNull CollectionTypeId typeId);

	/**
	 * Compute the type of value according to its content. Beware that this can be very expensive for collections and so
	 * should only be used where it really is necessary to compute a content-dependent type.
	 */
	@NonNull Type getDynamicTypeOf(@Nullable Object value);

	@Nullable Type getDynamicTypeOf(@Nullable Object @NonNull ... values);

	@Nullable Type getDynamicTypeOf(@NonNull Iterable<?> values);

	@NonNull CompleteEnvironment getEnvironment();

	@NonNull CompleteInheritance getInheritance(@NonNull EClassifier eClassifier);

	org.eclipse.ocl.pivot.@NonNull Class getJavaType(@NonNull Class<?> javaClass);

	@NonNull Type getMapType(@NonNull MapTypeId typeId);

	@NonNull Operation getOperation(@NonNull OperationId operationId);

	org.eclipse.ocl.pivot.@NonNull Package getPackage(@NonNull PackageId packageId);

	@NonNull Property getProperty(@NonNull PropertyId propertyId);

	@NonNull StandardLibrary getStandardLibrary();

	@Deprecated /* @deprecated getStaticTypeOfValue to enable TemplateParameters to be resolved */
	org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value);

	org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @Nullable Object @NonNull ... values);

	org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values);

	/**
	 * @since 1.7
	 */
	default org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOfValue(@Nullable Type contextType, @Nullable Object value) {
		return getStaticTypeOf(value);
	}

	@NonNull TypedElement getTuplePart(@NonNull String name, @NonNull TypeId typeId);

	@NonNull TupleType getTupleType(@NonNull TupleTypeId typeId);

	org.eclipse.ocl.pivot.@NonNull Class getType(@NonNull EClassifier eClassifier);

	/**
	 * @since 1.18
	 */
	@NonNull Type getType(@NonNull TypeId typeId);

	@Deprecated /* @deprecated omit redundant context argument */
	@NonNull Type/*Class*/ getType(@NonNull TypeId typeId, @Nullable Object/*Type*/ context);

	boolean oclEquals(@Nullable Object thisValue, @Nullable Object thatValue);

	@Nullable Object unboxedValueOf(@Nullable Object boxedValue);

	@NonNull Enumerator unboxedValueOf(@NonNull EnumerationLiteralId enumerationLiteralId);

	@NonNull EList<Object> unboxedValuesOfAll(@NonNull Collection<? extends Object> boxedValues);

	@NonNull EList<Object> unboxedValuesOfEach(@Nullable Object @NonNull ... boxedValues);
}