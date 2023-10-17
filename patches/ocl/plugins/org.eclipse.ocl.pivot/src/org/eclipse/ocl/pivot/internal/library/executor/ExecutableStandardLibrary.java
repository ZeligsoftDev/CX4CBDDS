/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StandardLibrary.StandardLibraryExtension;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorElement;
import org.eclipse.ocl.pivot.internal.executor.ExecutorBagType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorCollectionType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorMapType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorOrderedSetType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorSequenceType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorSetType;
import org.eclipse.ocl.pivot.internal.executor.ExecutorTupleType;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.MapTypeParameters;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public abstract class ExecutableStandardLibrary extends AbstractExecutorElement implements CompleteEnvironment, StandardLibraryExtension
{
	/**
	 * Shared cache of the lazily created lazily deleted specializations of each collection type.
	 */
	private @NonNull Map<@NonNull Type, @NonNull Map<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable ExecutorCollectionType>>> collectionSpecializations = new /*Weak*/HashMap<>();	// Keys are not singletons

	/**
	 * Shared cache of the lazily created lazily deleted specializations of each map type.
	 */
	private @NonNull Map<@NonNull Type, @NonNull Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable ExecutorMapType>>> mapSpecializations = new /*Weak*/HashMap<>();		// Keys are not singletons

	/**
	 * Shared cache of the lazily created lazily deleted tuples.
	 */
	private @NonNull Map<@NonNull TupleTypeId, @NonNull WeakReference<@NonNull TupleType>> tupleTypeMap = new WeakHashMap<>();		// Keys are singletons

	/**
	 * Configuration of validation preferences.
	 *
	 * The key used to be a magic String publicly exports from XXXTables polluting the API.
	 *
	 * Now it is the EOperation literal of the validation method.
	 */
	private /*LazyNonNull*/ Map<@Nullable Object, StatusCodes.@Nullable Severity> validationKey2severity = null;

	protected @NonNull HashMap<@Nullable Object, StatusCodes.@Nullable Severity> createValidationKey2severityMap() {
		return PivotValidationOptions.createValidationKey2severityMap();
	}

	@Override
	public @NonNull Iterable<@NonNull ? extends CompletePackage> getAllCompletePackages() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagType() {
		return OCLstdlibTables.Types._Bag;
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getBagType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getBagType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBooleanType() {
		return OCLstdlibTables.Types._Boolean;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getCollectionType() {
		return OCLstdlibTables.Types._Collection;
	}

	@Override
	public @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class genericType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(genericType, elementType, false, lower, upper);
	}

	@Override
	public synchronized @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class genericType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		IntegerValue lower2 = lower;
		UnlimitedNaturalValue upper2 = upper;
		if (lower2 == null) {
			lower2 = ValueUtil.ZERO_VALUE;
		}
		if (upper2 == null) {
			upper2 = ValueUtil.UNLIMITED_VALUE;
		}
		CollectionTypeParameters<@NonNull Type> typeParameters = TypeUtil.createCollectionTypeParameters(elementType, isNullFree, lower2, upper2);
		ExecutorCollectionType specializedType = null;
		Map<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable ExecutorCollectionType>> map = collectionSpecializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<>();
			collectionSpecializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, typeParameters);
		}
		if (specializedType == null) {
			String name = ClassUtil.nonNullModel(genericType.getName());
			if (genericType instanceof BagType) {
				specializedType = new ExecutorBagType(name, genericType, elementType, isNullFree, lower, upper);
			}
			else if (genericType instanceof OrderedSetType) {
				specializedType = new ExecutorOrderedSetType(name, genericType, elementType, isNullFree, lower, upper);
			}
			else if (genericType instanceof SequenceType) {
				specializedType = new ExecutorSequenceType(name, genericType, elementType, isNullFree, lower, upper);
			}
			else if (genericType instanceof SetType) {
				specializedType = new ExecutorSetType(name, genericType, elementType, isNullFree, lower, upper);
			}
			else {
				specializedType = new ExecutorCollectionType(name, genericType, elementType, isNullFree, lower, upper);
			}
			map.put(typeParameters, new WeakReference<>(specializedType));
		}
		return specializedType;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getIntegerType() {
		return OCLstdlibTables.Types._Integer;
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType,
			@NonNull List<@NonNull ? extends Type> parameterTypes, @NonNull Type resultType, @Nullable TemplateParameterSubstitutions bindings) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMapType() {
		return OCLstdlibTables.Types._Map;
	}

	@Override
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class genericType, @NonNull Type keyType, @NonNull Type valueType) {
		return getMapType(genericType, keyType, true, valueType, true);
	}

	@Override
	public synchronized @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class genericType, @NonNull Type keyType, boolean keyValuesAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters = TypeUtil.createMapTypeParameters(keyType, keyValuesAreNullFree, valueType, valuesAreNullFree);
		ExecutorMapType specializedType = null;
		Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable ExecutorMapType>> map = mapSpecializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<>();
			mapSpecializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, typeParameters);
		}
		if (specializedType == null) {
			specializedType = new ExecutorMapType(PivotUtil.getName(genericType), genericType, keyType, keyValuesAreNullFree, valueType, valuesAreNullFree);
			map.put(typeParameters, new WeakReference<>(specializedType));
		}
		return specializedType;
	}

	@Override
	public synchronized @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class genericType, org.eclipse.ocl.pivot.@NonNull Class entryClass) {
		MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters = TypeUtil.createMapTypeParameters(entryClass);
		ExecutorMapType specializedType = null;
		Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable ExecutorMapType>> map = mapSpecializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<>();
			mapSpecializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, typeParameters);
		}
		if (specializedType == null) {
			specializedType = new ExecutorMapType(ClassUtil.nonNullModel(genericType.getName()), genericType, typeParameters.getKeyType(), typeParameters.getValueType());
			map.put(typeParameters, new WeakReference<>(specializedType));
		}
		return specializedType;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMetaclass(@NonNull Type asInstanceType) {
		String metaclassName = TypeUtil.getMetaclassName(asInstanceType);
		return ClassUtil.nonNullState(getPivotType(metaclassName));
	}

	@Override
	public @NonNull Type getMetaType(@NonNull Type instanceType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package getNestedPackage(org.eclipse.ocl.pivot.@NonNull Package parentPackage, @NonNull String name) {
		return NameUtil.getNameable(parentPackage.getOwnedPackages(), name);
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getNestedType(org.eclipse.ocl.pivot.@NonNull Package parentPackage, @NonNull String name) {
		return NameUtil.getNameable(parentPackage.getOwnedClasses(), name);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclAnyType() {
		return OCLstdlibTables.Types._OclAny;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclComparableType() {
		return OCLstdlibTables.Types._OclComparable;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclElementType() {
		return OCLstdlibTables.Types._OclElement;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclEnumerationType() {
		return OCLstdlibTables.Types._OclEnumeration;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclInvalidType() {
		return OCLstdlibTables.Types._OclInvalid;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclMessageType() {
		return OCLstdlibTables.Types._OclMessage;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclSelfType() {
		return OCLstdlibTables.Types._OclSelf;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Class getOclStereotypeType() {
		return OCLstdlibTables.Types._OclStereotype;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclSummableType() {
		return OCLstdlibTables.Types._OclSummable;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclTupleType() {
		return OCLstdlibTables.Types._OclTuple;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclVoidType() {
		return OCLstdlibTables.Types._OclVoid;
	}

	@Override
	public @Nullable Element getOperationTemplateParameter(@NonNull Operation anOperation, int index) {
		return anOperation.getTypeParameters().get(index);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOrderedCollectionType() {
		return OCLstdlibTables.Types._OrderedCollection;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOrderedSetType() {
		return OCLstdlibTables.Types._OrderedSet;
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getOrderedSetType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getOrderedSetType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CompleteModel getOwnedCompleteModel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull StandardLibrary getOwnedStandardLibrary() {
		return this;
	}

	@Override
	public CompleteEnvironment getOwningCompleteEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Package getPackage() {
		return OCLstdlibTables.PACKAGE;
	}

	public org.eclipse.ocl.pivot.@Nullable Class getPivotType(@NonNull String className) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Type getPrimitiveType(@NonNull PrimitiveTypeId typeId) {
		return TypeUtil.getPrimitiveType(this, typeId);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getRealType() {
		return OCLstdlibTables.Types._Real;
	}

	@Override
	public org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getSequenceType() {
		return OCLstdlibTables.Types._Sequence;
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSequenceType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSequenceType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getSetType() {
		return OCLstdlibTables.Types._Set;
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSetType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSetType(), elementType, isNullFree, lower, upper);
	}

	//	@Override
	public StatusCodes.@Nullable Severity getSeverity(@Nullable Object validationKey) {
		Map<@Nullable Object, StatusCodes.@Nullable Severity> validationKey2severity2 = validationKey2severity;
		if (validationKey2severity2 == null) {
			validationKey2severity = validationKey2severity2 = createValidationKey2severityMap();
		}
		return validationKey2severity2.get(validationKey);
	}

	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStringType() {
		return OCLstdlibTables.Types._String;
	}

	/*	public @NonNull DomainTupleType getTupleType(@NonNull List<? extends DomainTypedElement> parts) {
		StringBuilder s = new StringBuilder();
		for (DomainTypedElement part : parts) {
			s.append(part.getName());
			s.append("\n"); //$NON-NLS-1$
		}
		String key = s.toString();
		synchronized (this) {
			List<WeakReference<DomainTupleType>> tupleTypes = tupleTypeMap.get(key);
			if (tupleTypes != null) {
				for (int j = tupleTypes.size(); --j >= 0; ) {
					WeakReference<DomainTupleType> tupleTypeRef = tupleTypes.get(j);
					DomainTupleType tupleType = tupleTypeRef.get();
					if (tupleType == null) {
						tupleTypes.remove(j);		// Trim stale list entry.
					}
					else {
						int i = 0;
						for (; i < parts.size(); i++) {
							List<? extends DomainTypedElement> ownedAttributes = tupleType.getOwnedAttribute();
							if (ownedAttributes.get(i).getType() != parts.get(i).getType()) {
								break;
							}
						}
						if (i >= parts.size()) {
							return tupleType;
						}
					}
				}
			}
			else {
				tupleTypes = new ArrayList<>();
				tupleTypeMap.put(key, tupleTypes);
			}
			DomainTupleType tupleType = new AbstractTupleType(this, parts);
			tupleTypes.add(new WeakReference<>(tupleType));
			return tupleType;
		}
	} */

	public @NonNull Element getTemplateParameter(@NonNull TemplateParameterId id, Element context) {
		throw new UnsupportedOperationException();
	}

	public synchronized @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		WeakReference<@NonNull TupleType> ref = tupleTypeMap.get(typeId);
		if (ref != null) {
			TupleType domainTupleType = ref.get();
			if (domainTupleType != null) {
				return domainTupleType;
			}
		}
		TupleType domainTupleType = new ExecutorTupleType(typeId);
		tupleTypeMap.put(typeId, new WeakReference<>(domainTupleType));
		return domainTupleType;
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<@NonNull ? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getUniqueCollectionType() {
		return OCLstdlibTables.Types._UniqueCollection;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getUnlimitedNaturalType() {
		return OCLstdlibTables.Types._UnlimitedNatural;
	}

	public void resetSeverities() {
		validationKey2severity = null;
	}

	@Override
	public void setOwnedCompleteModel(CompleteModel value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwnedStandardLibrary(StandardLibrary value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningCompleteEnvironment(CompleteEnvironment value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the map.get(key).get() entry if there is one or null if not, removing any stale
	 * entry that may be encountered.
	 */
	protected <K, V> @Nullable V weakGet(@NonNull Map<K, @NonNull WeakReference<V>> map, @NonNull K key) {
		WeakReference<V> ref = map.get(key);
		if (ref == null) {
			return null;
		}
		@Nullable V value = ref.get();
		if (value == null) {
			map.remove(key);
		}
		return value;
	}
}
