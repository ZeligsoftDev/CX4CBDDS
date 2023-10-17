/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ids.BindingsIdImpl.BindingsIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedCollectionTypeIdImpl.CollectionTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedLambdaTypeIdImpl.LambdaTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedMapTypeIdImpl.MapTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedTupleTypeIdImpl.TupleTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.NsURIPackageIdImpl.NsURIPackageIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.ParametersIdImpl.ParametersIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.PrimitiveTypeIdImpl.PrimitiveTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.RootPackageIdImpl.RootPackageIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.TemplateParameterIdImpl;
import org.eclipse.ocl.pivot.internal.ids.TuplePartIdImpl.TuplePartIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.UnspecifiedIdImpl;
import org.eclipse.ocl.pivot.internal.ids.WildcardIdImpl;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

import com.google.common.collect.Iterables;

/**
 * IdManager supervises the thread-safe allocation of unique hierarchical identifier to each metamodel element.
 *
 * @see ElementId
 */
public final class IdManager
{
	/*
	 * IdManager is final and the sole instance of IdManager is private and ElementId implementations need an IdManager
	 * for construction so ElementId uniqueness is guaranteed.
	 */
	private static final @NonNull IdManager PRIVATE_INSTANCE = new IdManager();

	/**
	 * Map from the BindingsId hashCode to the elements with the same hash.
	 */
	private static final @NonNull BindingsIdSingletonScope bindingsIds = new BindingsIdSingletonScope();

	/**
	 * Map from a Collection type name to the corresponding CollectionTypeId.
	 */
	private static final @NonNull CollectionTypeIdSingletonScope collectionNames = new CollectionTypeIdSingletonScope();

	/**
	 * Map from a Map type name to the corresponding MapTypeId.
	 */
	private static final @NonNull MapTypeIdSingletonScope mapNames = new MapTypeIdSingletonScope();

	/**
	 * Map from an nsURI to the corresponding NsURITypeId.
	 */
	private static final @NonNull NsURIPackageIdSingletonScope nsURIs = new NsURIPackageIdSingletonScope();

	/**
	 * Map from the Lambda hashCode to the lambda typeIds with the same hash.
	 */
	private static final @NonNull LambdaTypeIdSingletonScope lambdaTypes = new LambdaTypeIdSingletonScope();

	/**
	 * Map from the TuplePart hashCode to the tuplePartIds with the same hash.
	 */
	private static final @NonNull TuplePartIdSingletonScope tupleParts = new TuplePartIdSingletonScope();

	/**
	 * Map from a name to the corresponding URI-less unnested RootPackageTypeId.
	 */
	private static final @NonNull RootPackageIdSingletonScope roots = new RootPackageIdSingletonScope();

	/**
	 * List of template parameters; 0 index at least index ... up to most nested
	 */
	private static final @NonNull List<@NonNull TemplateParameterIdImpl> templateParameterNormalizedIds = new ArrayList<>(10);

	/**
	 * Map from the Tuple hashCode to the tuple typeIds with the same hash.
	 */
	private static final @NonNull TupleTypeIdSingletonScope tupleTypes = new TupleTypeIdSingletonScope();

	/**
	 * Map from the ParametersId hashCode to the parametersId with the same hash.
	 */
	private static final @NonNull ParametersIdSingletonScope parametersIds = new ParametersIdSingletonScope();

	/**
	 * Map from a Primitive type name to the corresponding PrimitiveTypeId.
	 */
	private static final @NonNull PrimitiveTypeIdSingletonScope primitiveTypes = new PrimitiveTypeIdSingletonScope();

	private static @Nullable Map<@NonNull String, @NonNull String> metamodelURI2name = null;

	private static @Nullable WildcardId wildcardId = null;

	public static final @NonNull RootPackageId METAMODEL = getRootPackageId(PivotConstants.METAMODEL_NAME);

	/**
	 * Define a metamodelNsURI as a contributor to the metamodelName. THis facility is used to enable
	 * UML2's duplicate Eclipse/OMG models to be treated as merged rather than conflicting.
	 */
	public static void addMetamodelEPackage(@NonNull String metamodelNsURI, @NonNull String metamodelName) {
		Map<@NonNull String, @NonNull String> metamodelURI2name2 = metamodelURI2name;
		if (metamodelURI2name2 == null) {
			metamodelURI2name = metamodelURI2name2 = new HashMap<>();
		}
		metamodelURI2name2.put(metamodelNsURI, metamodelName);
	}

	/**
	 * Return the bindingsId for a given list of bindings.
	 *
	 * @since 1.18
	 */
	public static @Nullable BindingsId basicGetBindingsId(@Nullable Iterable<@NonNull TemplateBinding> templateBindings) {
		if (templateBindings == null) {
			return null;
		}
		List<@NonNull ElementId> elementIdList = new ArrayList<>();
		for (@NonNull TemplateBinding templateBinding : templateBindings) {
			for (@NonNull TemplateParameterSubstitution templateParameterSubstitution : PivotUtil.getOwnedSubstitutions(templateBinding)) {
				Type actual = templateParameterSubstitution.getActual();
				elementIdList.add(actual.getTypeId());
			}
		}
		int size = elementIdList.size();
		if (size <= 0) {
			return null;
		}
		@NonNull ElementId[] elementIds = elementIdList.toArray(new @NonNull ElementId[size]);
		return bindingsIds.getSingleton(PRIVATE_INSTANCE, elementIds, null);
	}

	public static @NonNull BindingsId getBindingsId(@NonNull Type... types) {
		@NonNull ElementId @NonNull [] elementIds = new @NonNull ElementId @NonNull [types.length];
		for (int i = 0; i < types.length; i++) {
			elementIds[i] = types[i].getTypeId();
		}
		return getBindingsId(elementIds);
	}

	/**
	 * Return the bindingsId for a given type list.
	 */
	public static @NonNull BindingsId getBindingsId(@NonNull ElementId @NonNull ... elementIds) {
		return bindingsIds.getSingleton(PRIVATE_INSTANCE, elementIds, null);
	}

	/**
	 * Return the bindingsId for a given types followed by values list.
	 *
	 * @since 1.18
	 */
	public static @NonNull BindingsId getBindingsId(@NonNull Object @NonNull ... elementIdAndValues) {
		int elementIdCount = 0;
		for (@NonNull Object elementId : elementIdAndValues) {
			if (elementId instanceof ElementId) {
				elementIdCount++;
			}
		}
		int valuesCount = elementIdAndValues.length - elementIdCount;
		@NonNull ElementId[] elementIds = new @NonNull ElementId[elementIdCount];
		@NonNull Object[] values = new @NonNull Object[valuesCount];
		int index = 0;
		for (int i = 0; i < elementIdCount; i++) {
			elementIds[i] = (ElementId)elementIdAndValues[index++];
		}
		for (int i = 0; i < valuesCount; i++) {
			values[i] = elementIdAndValues[index++];
		}
		return bindingsIds.getSingleton(PRIVATE_INSTANCE, elementIds, values);
	}

	/**
	 * Return the bindingsId for a given type list of element and value parameters.
	 *
	 * @since 1.18
	 */
	public static @NonNull BindingsId getBindingsId(@NonNull ElementId @NonNull [] elementIds, @NonNull Object @Nullable [] values) {
		return bindingsIds.getSingleton(PRIVATE_INSTANCE, elementIds, values);
	}

	/**
	 * Return the classId for aType.
	 */
	public static @NonNull ClassId getClassId(org.eclipse.ocl.pivot.@NonNull Class aType) {
		if (aType.eIsProxy()) {
			return getUnspecifiedTypeId(aType);		// FIXME This occurs for underspecified/wildcard types
		}
		org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(aType);
		String name = aType.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Package parentPackage = unspecializedType.getOwningPackage();
		if (parentPackage != null) {
			TemplateParameters typeParameters = unspecializedType.getTypeParameters();
			PackageId packageId = parentPackage.getPackageId();
			ClassId unspecializedClassId = packageId.getClassId(name, typeParameters.parametersSize());
			BindingsId bindingsId = basicGetBindingsId(PivotUtil.getOwnedBindings(aType));
			return bindingsId != null ? (ClassId)unspecializedClassId.getSpecializedId(bindingsId) : unspecializedClassId;
		}
		else {
			return getUnspecifiedTypeId(aType);		// FIXME This occurs for underspecified/wildcard types
		}
	}

	/**
	 * Return the classId for eClass.
	 */
	public static @NonNull ClassId getClassId(@NonNull EClass eClass) {
		EPackage ePackage = ClassUtil.nonNullEMF(eClass.getEPackage());
		PackageId packageId = IdManager.getPackageId(ePackage);
		String className = ClassUtil.nonNullEMF(NameUtil.getOriginalName(eClass));
		ClassId classId = packageId.getClassId(className, eClass.getETypeParameters().size());
		return classId;
	}

	/**
	 * Return the named collection typeId.
	 */
	public static @NonNull CollectionTypeId getCollectionTypeId(@NonNull String collectionTypeName) {
		return collectionNames.getSingleton(PRIVATE_INSTANCE, collectionTypeName);
	}

	/**
	 * Return the dataTypeId for aType.
	 */
	public static @NonNull DataTypeId getDataTypeId(org.eclipse.ocl.pivot.@NonNull Class aType) {
		if (aType.eIsProxy()) {
			return getUnspecifiedTypeId(aType);		// FIXME This occurs for underspecified/wildcard types
		}
		org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(aType);
		String name = aType.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Package parentPackage = unspecializedType.getOwningPackage();
		if (parentPackage != null) {
			TemplateParameters typeParameters = unspecializedType.getTypeParameters();
			PackageId packageId = parentPackage.getPackageId();
			DataTypeId unspecializedDataTypeId = packageId.getDataTypeId(name, typeParameters.parametersSize());
			BindingsId bindingsId = basicGetBindingsId(PivotUtil.getOwnedBindings(aType));
			return bindingsId != null ? (DataTypeId)unspecializedDataTypeId.getSpecializedId(bindingsId) : unspecializedDataTypeId;
		}
		else {
			return getUnspecifiedTypeId(aType);		// FIXME This occurs for underspecified/wildcard types
		}
	}

	/**
	 * Return the typeId for aType.
	 */
	public static @NonNull EnumerationId getEnumerationId(@NonNull Enumeration anEnumeration) {
		String name = anEnumeration.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Package parentPackage = anEnumeration.getOwningPackage();
		assert parentPackage != null;
		return parentPackage.getPackageId().getEnumerationId(name);
	}

	/**
	 * Return the typeId for an EEnum.
	 *
	 * @Deprecated (UML-aware) caller should resolve the PackageId and then tunnel down.
	 * The UML-blind implementation here fails to resolve Ecore profiles.
	 */
	@Deprecated
	public static @NonNull EnumerationId getEnumerationId(@NonNull EEnum eEnum) {
		String name = eEnum.getName();
		assert name != null;
		EPackage parentPackage = eEnum.getEPackage();
		assert parentPackage != null;
		return getPackageId(parentPackage).getEnumerationId(name);
	}

	/**
	 * Return the typeId for an EEnumLiteral.
	 *
	 * @Deprecated (UML-aware) caller should resolve the PackageId and then tunnel down.
	 * The UML-blind implementation here fails to resolve Ecore profiles.
	 */
	@Deprecated
	public static @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull EEnumLiteral eEnumLiteral) {
		EEnum eEnum = ClassUtil.nonNullModel(eEnumLiteral.getEEnum());
		String name = ClassUtil.nonNullModel(eEnumLiteral.getName());
		EnumerationId enumerationId = getEnumerationId(eEnum);
		EnumerationLiteralId enumerationLiteralId = enumerationId.getEnumerationLiteralId(name);
		return enumerationLiteralId;
	}

	/**
	 * Return the typeId for aLambdaType.
	 */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull LambdaType lambdaType) {
		String name = NameUtil.getSafeName(lambdaType);
		return getLambdaTypeId(name, lambdaType.getParametersId());
	}

	/**
	 * Return the named lambda typeId with the defined type parameters.
	 */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull String name, @NonNull TypeId @NonNull ... typeIds) {
		return getLambdaTypeId(name, getParametersId(typeIds));
	}

	/**
	 * Return the named lambda typeId with the defined type parameters.
	 */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull String name, @NonNull ParametersId parametersId) {
		return lambdaTypes.getSingleton(PRIVATE_INSTANCE, name, parametersId);
	}

	/**
	 * Return the named collection typeId.
	 */
	public static @NonNull MapTypeId getMapTypeId(@NonNull String mapTypeName) {
		return mapNames.getSingleton(PRIVATE_INSTANCE, mapTypeName);
	}

	/**
	 * Return the URIed package typeId.
	 */
	public static @NonNull NsURIPackageId getNsURIPackageId(@NonNull String nsURI, @Nullable String nsPrefix, @Nullable EPackage ePackage) {
		NsURIPackageId nsURIPackageId = nsURIs.getSingleton(PRIVATE_INSTANCE, nsURI, nsPrefix, ePackage);
		if ((ePackage != null) && (nsURIPackageId.getEPackage() == null)) {		// Late ePackage may occur if early lifecycle is OCLinEcore then AS
			nsURIPackageId.setEPackage(ePackage);
		}
		return nsURIPackageId;
	}

	/**
	 * Return the OperationId for anOperation.
	 */
	public static @NonNull OperationId getOperationId(@NonNull Operation anOperation) {
		String name = NameUtil.getSafeName(anOperation);
		org.eclipse.ocl.pivot.Class owningClass = PivotUtil.getOwningClass(anOperation);
		TypeId parentTypeId = owningClass.getTypeId();
		TemplateParameters typeParameters = anOperation.getTypeParameters();
		int typeParametersSize = typeParameters.parametersSize();
		ParametersId parametersId;
		if ((typeParametersSize <= 0) || (anOperation.getUnspecializedElement() != null)) {	// If unspecializeable or specialized
			@NonNull Type @NonNull [] parameterTypes = TypeUtil.getOperationParameterTypes(anOperation);
			parametersId = getParametersId(parameterTypes);
		}
		else {																				// If unspecialized
			List<@NonNull TemplateParameter> contextTemplateParameters = PivotUtil.getTemplateParameters(owningClass);
			TemplateSignature operationTemplateSignature = anOperation.getOwnedSignature();
			if (operationTemplateSignature == null) {										// Never happens
				parametersId = ParametersId.EMPTY;
			}
			else {
				int operationTemplateParameterSize = Iterables.size(PivotUtil.getOwnedParameters(operationTemplateSignature));
				if (operationTemplateParameterSize <= 0) {									// Never happens
					parametersId = ParametersId.EMPTY;
				}
				else {		// Templated operations cannot be overloaded so use the normalized template parameter ids only
					@NonNull TypeId typeIds[] = new @NonNull TypeId[operationTemplateParameterSize];
					int contextTemplateParameterSize = contextTemplateParameters != null ? contextTemplateParameters.size() : 0;
					for (int i = 0; i < operationTemplateParameterSize; i++) {
						typeIds[i] = IdManager.getTemplateParameterId(contextTemplateParameterSize + i);
					}
					parametersId = getParametersId(typeIds);
				}
			}
		}
		return parentTypeId.getOperationId(typeParametersSize, name, parametersId);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which are alphabetically ordered by part name).
	 */
	public static @NonNull TupleTypeId getOrderedTupleTypeId(@NonNull String name, @NonNull TuplePartId @NonNull [] parts) {
		return tupleTypes.getSingleton(PRIVATE_INSTANCE, name, parts);
	}

	/**
	 * Return the typeId for aPackage.
	 */
	public static @NonNull PackageId getPackageId(org.eclipse.ocl.pivot.@NonNull Package aPackage) {
		String nsURI = aPackage.getURI();
		if (nsURI != null) {
			return getNsURIPackageId(nsURI, aPackage.getNsPrefix(), aPackage.getEPackage());
		}
		String name = aPackage.getName();
		//		assert name != null;
		if (name == null) name = "";
		org.eclipse.ocl.pivot.Package parentPackage = aPackage.getOwningPackage();
		if (parentPackage != null) {
			return parentPackage.getPackageId().getNestedPackageId(name);
		}
		else {
			return getRootPackageId(name);
		}
	}

	/**
	 * Return the typeId for ePackage.
	 */
	public static @NonNull PackageId getPackageId(@NonNull EPackage ePackage) {
		if (ClassUtil.basicGetMetamodelAnnotation(ePackage) != null) {
			return METAMODEL;
		}
		String nsURI = ePackage.getNsURI();
		if (nsURI != null) {
			if (metamodelURI2name != null) {
				String metamodelName = metamodelURI2name.get(nsURI);
				if (metamodelName != null) {
					return getRootPackageId(metamodelName);
				}
			}
			//			if (nsURI.equals(UMLPackage.eNS_URI)) {		// FIXME use extension point
			//				return getRootPackageId(PivotConstants.UML_METAMODEL_NAME);
			//			}
			//			else if (nsURI.equals(TypesPackage.eNS_URI)) {		// FIXME use extension point
			//				return getRootPackageId(PivotConstants.TYPES_METAMODEL_NAME);
			//			}
			EObject eContainer1 = ePackage.eContainer();
			if (eContainer1 instanceof EAnnotation) {
				EAnnotation eAnnotation = (EAnnotation)eContainer1;
				if (DerivedConstants.UML2_UML_PACKAGE_2_0_NS_URI.equals(eAnnotation.getSource())) {
					EObject eContainer2 = eAnnotation.eContainer();
					if (eContainer2 != null) {
						EClass eClass2 = eContainer2.eClass();
						if ("Profile".equals(eClass2.getName())) {
							EStructuralFeature eStructuralFeature = eClass2.getEStructuralFeature("URI");
							if (eStructuralFeature != null) {
								Object uri = eContainer2.eGet(eStructuralFeature);
								if (uri != null) {
									return getNsURIPackageId(String.valueOf(uri), ePackage.getNsPrefix(), ePackage);
								}
								eStructuralFeature = eClass2.getEStructuralFeature("name");
								if (eStructuralFeature != null) {
									Object name = eContainer2.eGet(eStructuralFeature);
									if (name != null) {
										return getRootPackageId(String.valueOf(name));
									}
								}
							}
						}
					}
				}
			//	System.out.println("Looks like a UML Profile has not been used in place of its EPackage for " + nsURI);
			}
			return getNsURIPackageId(nsURI, ePackage.getNsPrefix(), ePackage);
		}
		String name = ePackage.getName();
		assert name != null;
		EPackage parentPackage = ePackage.getESuperPackage();
		if (parentPackage != null) {
			return getPackageId(parentPackage).getNestedPackageId(name);
		}
		return getNsURIPackageId(name, ePackage.getNsPrefix(), null);
	}

	public static @NonNull ParametersId getParametersId(@NonNull Type @NonNull [] parameterTypes) {
		int iSize = parameterTypes.length;
		@NonNull TypeId @NonNull [] typeIds = new @NonNull TypeId[iSize];
		for (int i = 0; i < iSize; i++) {
			Type parameterType = parameterTypes[i];
			@SuppressWarnings("null")boolean isNonNull = parameterType != null;
			typeIds[i] = isNonNull ? parameterType.getNormalizedTypeId() : TypeId.OCL_INVALID;		// Never happens NPE guard
		}
		return getParametersId(typeIds);
	}

	/**
	 * Return the parametersId for a given type list.
	 */
	public static @NonNull ParametersId getParametersId(@NonNull TypeId @NonNull ... typeIds) {
		return parametersIds.getSingleton(PRIVATE_INSTANCE, typeIds);
	}

	/**
	 * Return the named primitive typeId.
	 */
	public static @NonNull PrimitiveTypeId getPrimitiveTypeId(@NonNull String name) {
		return primitiveTypes.getSingleton(PRIVATE_INSTANCE, name);
	}

	/**
	 * Return the propertyId for an EStructuralFeature.
	 */
	public static @NonNull PropertyId getPropertyId(@NonNull EStructuralFeature eFeature) {
		String name = NameUtil.getOriginalName(eFeature);
		assert name != null;
		EClass parentClass = eFeature.getEContainingClass();
		assert parentClass != null;
		ClassId classId = getClassId(parentClass);
		return classId.getPropertyId(name);
	}

	/**
	 * Return the URI-less unnested package typeId.
	 */
	public static @NonNull RootPackageId getRootPackageId(@NonNull String name) {
		//	if (PivotConstants.METAMODEL_NAME.equals(name)) {
		//		return METAMODEL;
		//	}
		return roots.getSingleton(PRIVATE_INSTANCE, name);
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull TemplateParameterId getTemplateParameterIndexId(@NonNull TemplateParameter templateParameter) {
		List<@NonNull TemplateParameter> templateParameters = PivotUtil.getTemplateParameters(templateParameter);
		assert templateParameters != null;
		int index = templateParameters.indexOf(templateParameter);
		return getTemplateParameterId(index);
	}

	@Deprecated /* @deprecated change to private and probably inlined */
	public static @NonNull TemplateParameterId getTemplateParameterId(int index) {
		assert index >= 0;
		if (index >= templateParameterNormalizedIds.size()) {
			synchronized (templateParameterNormalizedIds) {
				while (index >= templateParameterNormalizedIds.size()) {
					templateParameterNormalizedIds.add(new TemplateParameterIdImpl(PRIVATE_INSTANCE, templateParameterNormalizedIds.size()));
				}
			}
		}
		TemplateParameterIdImpl templateParameterId = templateParameterNormalizedIds.get(index);
		assert templateParameterId != null;
		return templateParameterId;
	}

	/**
	 * Return the named tuplePartId for the givem property of a TupleType.
	 * @since 1.3
	 */
	public static @NonNull TuplePartId getTuplePartId(@NonNull Property asProperty) {
		TupleType tupleType = (TupleType) PivotUtil.getOwningClass(asProperty);
		String name = NameUtil.getSafeName(asProperty);
		int index = tupleType.getOwnedProperties().indexOf(asProperty);
		return IdManager.getTuplePartId(index, name, asProperty.getTypeId());
	}

	/**
	 * Return the named tuplePartId with the defined name and type.
	 */
	public static @NonNull TuplePartId getTuplePartId(int index, @NonNull String name, @NonNull TypeId typeId) {
		return tupleParts.getSingleton(PRIVATE_INSTANCE, index, name, typeId);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public static @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull Collection<@NonNull ? extends TuplePartId> parts) {
		@NonNull TuplePartId @NonNull [] orderedParts = new @NonNull TuplePartId[parts.size()];
		int i = 0;
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
		}
		Arrays.sort(orderedParts);
		return getOrderedTupleTypeId(name, orderedParts);
	}

	public static @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull TuplePartId @NonNull ... parts) {
		@NonNull TuplePartId @NonNull [] orderedParts = new @NonNull TuplePartId[parts.length];
		int i = 0;
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
		}
		Arrays.sort(orderedParts);
		return getOrderedTupleTypeId(name, orderedParts);
	}

	/**
	 * Return the typeId for an EClassifier.
	 */
	public static @NonNull TypeId getTypeId(@NonNull EClassifier eClassifier) {
		String name = NameUtil.getOriginalName(eClassifier);
		assert name != null;
		EPackage parentPackage = eClassifier.getEPackage();
		assert parentPackage != null;
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters != null;
		PackageId packageId = getPackageId(parentPackage);
		int eTypeParameterCount = eTypeParameters.size();
		if (eClassifier instanceof EEnum) {
			return packageId.getEnumerationId(name);
		}
		else if (eClassifier instanceof EDataType) {
			return packageId.getDataTypeId(name, eTypeParameterCount);
		}
		else {
			return packageId.getClassId(name, eTypeParameterCount);
		}
	}

	/**
	 * Return the typeId for aType.
	 */
	public static @NonNull UnspecifiedIdImpl getUnspecifiedTypeId(@NonNull Type aType) {
		UnspecifiedIdImpl newId = new UnspecifiedIdImpl(PRIVATE_INSTANCE, aType);
		//		System.out.println("Create " + newId.getClass().getSimpleName() + " " + newId + " => @" + Integer.toHexString(newId.hashCode()));
		return newId;
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull WildcardId getWildcardId() {
		WildcardId wildcardId2 = wildcardId ;
		if (wildcardId2 == null) {
			wildcardId = wildcardId2 = new WildcardIdImpl(PRIVATE_INSTANCE);
		}
		return wildcardId2;
	}

	private IdManager() {}		// private to guarantee ElementId uniqueness
}