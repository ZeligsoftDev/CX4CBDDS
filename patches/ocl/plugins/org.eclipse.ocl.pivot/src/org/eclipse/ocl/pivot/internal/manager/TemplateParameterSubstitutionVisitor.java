/*******************************************************************************
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryIterationOrOperation;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

/**
 * A TemplateParameterSubstitutionVisitor traverses a CallExp to identify the formal/actual TemplateParameterSubstitutions
 * associated with that CallExp. This creates a mapping from each formal template parameter to a list of actual types that
 * correspond. This mapping can then be used to create new specializations.
 * <p>
 * The visitor should be constructed with a MetamodelManager in case any synthetic types need contructing, and the identity
 * of the self type incase one of the substitutions uses OclSelf.
 */
public class TemplateParameterSubstitutionVisitor extends AbstractExtendingVisitor<Object, Map<Integer, Type>> implements TemplateParameterSubstitutions
{
	public static @NonNull TemplateParameterSubstitutions createBindings(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Type formalType, @NonNull Type actualType) {
		TemplateParameterSubstitutionVisitor visitor = createVisitor(actualType, environmentFactory, null, null);
		visitor.analyzeType(formalType, actualType);
		return visitor;
	}

	public static @NonNull TemplateParameterSubstitutions createBindings(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type sourceType, @Nullable Type sourceTypeValue, @NonNull Operation candidateOperation) {
		// assert sourceTypeValue == null;			// Bug 580791  Enforcing redundant argument
		TemplateParameterSubstitutionVisitor visitor = createVisitor(candidateOperation, environmentFactory, sourceType, null);
		visitor.analyzeType(candidateOperation.getOwningClass(), sourceType);
		for (EObject eObject = candidateOperation; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedSignature();
				if (templateSignature != null) {
					List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
					int iSize = templateParameters.size();
					if (iSize > 0) {
						return visitor;
					}
				}
			}
		}
		return TemplateParameterSubstitutions.EMPTY;
	}

	protected static @NonNull TemplateParameterSubstitutionVisitor createVisitor(@NonNull EObject eObject, @NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
		Resource resource = eObject.eResource();
		if (environmentFactory instanceof EnvironmentFactoryInternalExtension) {
			return ((EnvironmentFactoryInternalExtension)environmentFactory).createTemplateParameterSubstitutionVisitor(selfType, null);
		}
		else if (resource instanceof ASResource) {				// This used to be thefirst choice; now it should never happen
			return ((ASResource)resource).getASResourceFactory().createTemplateParameterSubstitutionVisitor(environmentFactory, selfType, null);
		}
		else {													// This too should never happen
			return new TemplateParameterSubstitutionVisitor(environmentFactory, selfType, null);
		}
	}

	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings under the
	 * supervision of a metamodelManager and using selfType as the value of OclSelf.
	 */
	public static @NonNull Type specializeType(@NonNull Type type, @NonNull CallExp callExp, @NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
		TemplateParameterSubstitutionVisitor visitor = createVisitor(callExp, environmentFactory, selfType, null);
		visitor.exclude(callExp);
		visitor.visit(callExp);
		return visitor.specializeType(type);
	}

	private final @NonNull EnvironmentFactoryInternal environmentFactory;
	private final @Nullable Type selfType;
	private @Nullable TypedElement excludedTarget = null;

	/**
	 * Internal variable used to pass the actual corresponding to the visited formal.
	 */
	private Element actual;

	public TemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		super(new HashMap<Integer, Type>());
		this.environmentFactory = environmentFactory;
		this.selfType = selfType;
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}

	protected void analyzeFeature(@Nullable Feature formalFeature, @Nullable TypedElement actualElement) {
		if ((formalFeature != null) && (actualElement != null)) {
			Type formalType = formalFeature.getOwningClass();
			Type actualType = actualElement.getType();
			analyzeType(formalType, actualType);
		}
	}

	protected void analyzeType(@Nullable Type newFormal, @Nullable Element newActual) {
		if ((newFormal != null) && (newActual != null)) {
			Element oldActual = actual;
			try {
				actual = newActual;
				newFormal.accept(this);
			} finally {
				actual = oldActual;
			}
		}
	}

	protected void analyzeTypedElement(@Nullable TypedElement newFormal, @Nullable TypedElement newActual) {
		if ((newFormal != null) && (newActual != null) && (newActual != excludedTarget)) {
			Element oldActual = actual;
			try {
				actual = newActual;
				newFormal.accept(this);
			} finally {
				actual = oldActual;
			}
		}
	}

	protected void analyzeTypedElements(@NonNull List<? extends TypedElement> formalElements, @Nullable List<? extends TypedElement> actualElements) {
		if (actualElements != null) {
			int iMax = Math.min(formalElements.size(), actualElements.size());
			for (int i = 0; i < iMax; i++) {
				TypedElement formalElement = formalElements.get(i);
				TypedElement actualElement = actualElements.get(i);
				analyzeTypedElement(formalElement, actualElement);
			}
		}
	}

	protected void analyzeTypes(@NonNull List<? extends Type> formalElements, @NonNull List<? extends Type> actualElements) {
		int iMax = Math.min(formalElements.size(), actualElements.size());
		for (int i = 0; i < iMax; i++) {
			analyzeType(formalElements.get(i), actualElements.get(i));
		}
	}

	/**
	 * Exclude the current typed element which may have a stale type.
	 */
	private void exclude(@NonNull TypedElement typedElement) {
		assert excludedTarget == null;
		excludedTarget = typedElement;
	}

	@Override
	public @Nullable Type get(@Nullable TemplateParameter templateParameter) {
		if (templateParameter == null) {
			return null;
		}
		return context.get(templateParameter.getTemplateParameterId().getIndex());
	}

	@Deprecated /* @deprecated all functionality moved to LibraryOperation */
	protected @Nullable TemplateParameterSubstitutionHelper getHelper(@NonNull Operation operation) {
		return  null;
	}

	protected @NonNull TupleType getSpecializedTupleType(@NonNull TupleType type) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		List<Property> parts = specializedTupleType.getOwnedProperties();
		for (Property part : parts) {
			if (part != null) {
				Type propertyType = PivotUtilInternal.getType(part);
				Type resolvedPropertyType = specializeType(propertyType);
				if (resolvedPropertyType != propertyType) {
					if (resolutions == null) {
						resolutions = new HashMap<String, Type>();
					}
					resolutions.put(NameUtil.getSafeName(part), resolvedPropertyType);
				}
			}
		}
		if (resolutions != null) {
			List<@NonNull TuplePartId> partIds = new ArrayList<@NonNull TuplePartId>(parts.size());
			for (int i = 0; i < parts.size(); i++) {
				@SuppressWarnings("null") @NonNull Property part = parts.get(i);
				String partName = NameUtil.getSafeName(part);
				Type resolvedPropertyType = resolutions.get(partName);
				TypeId partTypeId = resolvedPropertyType != null ? resolvedPropertyType.getTypeId() : part.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				partIds.add(tuplePartId);
			}
			TupleTypeId tupleTypeId = IdManager.getTupleTypeId(ClassUtil.nonNullModel(type.getName()), partIds);
			specializedTupleType = metamodelManager.getCompleteModel().getTupleManager().getTupleType(metamodelManager.getEnvironmentFactory().getIdResolver(), tupleTypeId);
			return specializedTupleType;
		}
		else {
			Map<@NonNull String, @NonNull Type> partMap = new HashMap<>();
			for (TypedElement part : type.getOwnedProperties()) {
				Type type1 = part.getType();
				if (type1 != null) {
					Type type2 = metamodelManager.getPrimaryType(type1);
					Type type3 = specializeType(type2);
					partMap.put(PivotUtil.getName(part), type3);
				}
			}
			return metamodelManager.getCompleteModel().getTupleManager().getTupleType(NameUtil.getSafeName(type), partMap);
		}
	}

	@Override
	public boolean isEmpty() {
		return context.isEmpty();
	}

	public void put(int templateParameterIndex, @Nullable Type actualType) {
		context.put(templateParameterIndex, actualType);
	}

	@Override
	public @NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType) {
		TemplateParameterId elementId = formalTemplateParameter.getTemplateParameterId();
		int index = elementId.getIndex();
		Type oldType = context.get(index);
		if (oldType != null) {
			IdResolver idResolver = environmentFactory.getIdResolver();
			Type commonType = oldType.getCommonType(idResolver, actualType);
			Type bestType = environmentFactory.getMetamodelManager().getPrimaryType(commonType);
			if (bestType != oldType) {
				context.put(index, bestType);
			}
			return bestType;
		}
		else {
			context.put(index, actualType);
			return actualType;
		}
	}

	public @NonNull Type specializeType(@NonNull Type type) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			int index = asTemplateParameter.getTemplateParameterId().getIndex();
			Type actualType = context.get(index);
			return actualType != null ? actualType : type;
		}
		if (type instanceof SelfType) {
			return ClassUtil.nonNullState(selfType != null ? selfType : type);
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Type elementType = ClassUtil.nonNullModel(collectionType.getElementType());
			Type specializedElementType = specializeType(elementType);
			CollectionType unspecializedCollectionType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			return metamodelManager.getCompleteEnvironment().getCollectionType(unspecializedCollectionType, specializedElementType, collectionType.isIsNullFree(), collectionType.getLowerValue(), collectionType.getUpperValue());
		}
		else if (type instanceof MapType) {
			MapType mapType = (MapType)type;
			Type keyType = ClassUtil.nonNullModel(mapType.getKeyType());
			Type valueType = ClassUtil.nonNullModel(mapType.getValueType());
			Type specializedKeyType = specializeType(keyType);
			Type specializedValueType = specializeType(valueType);
			MapType unspecializedMapType = PivotUtil.getUnspecializedTemplateableElement(mapType);
			return metamodelManager.getCompleteEnvironment().getMapType(unspecializedMapType, specializedKeyType, mapType.isKeysAreNullFree(), specializedValueType, mapType.isValuesAreNullFree());
		}
		else if (type instanceof TupleType) {
			return getSpecializedTupleType((TupleType) type);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = ClassUtil.nonNullModel(lambdaType.getName());
			Type specializedContextType = specializeType(ClassUtil.nonNullModel(lambdaType.getContextType()));
			List<@NonNull Type> specializedParameterTypes = new ArrayList<@NonNull Type>();
			for (Type parameterType : lambdaType.getParameterType()) {
				if (parameterType != null) {
					specializedParameterTypes.add(specializeType(parameterType));
				}
			}
			Type specializedResultType = specializeType(ClassUtil.nonNullModel(lambdaType.getResultType()));
			return metamodelManager.getCompleteModel().getLambdaType(typeName, specializedContextType, specializedParameterTypes, specializedResultType);
		}
		else {
			//
			//	Get the bindings of the type.
			//
			org.eclipse.ocl.pivot.Class partiallySpecializedType = (org.eclipse.ocl.pivot.Class)type;
			org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(partiallySpecializedType);
			List<TemplateBinding> ownedTemplateBindings = partiallySpecializedType.getOwnedBindings();
			if (ownedTemplateBindings.size() > 0) {
			//	boolean hasActual = false;
				List<@NonNull Type> templateArguments = new ArrayList<@NonNull Type>();
				for (TemplateBinding ownedTemplateBinding : ownedTemplateBindings) {
					for (TemplateParameterSubstitution ownedTemplateParameterSubstitution : ownedTemplateBinding.getOwnedSubstitutions()) {
						Type actualType = ownedTemplateParameterSubstitution.getActual();
						if (actualType != null) {
							actualType = specializeType(actualType);
			//				hasActual = true;
						}
						else {
							TemplateParameter formalParameter = ownedTemplateParameterSubstitution.getFormal();
							if (formalParameter != null) {
								actualType = PivotUtil.basicGetLowerBound(formalParameter);
							}
						}
						if (actualType == null) {
							actualType = metamodelManager.getStandardLibrary().getOclAnyType();
						}
						templateArguments.add(actualType);
					}
				}
			//	if (hasActual) {
					return metamodelManager.getLibraryType(unspecializedType, templateArguments);
			//	}
			//	else {
			//		return unspecializedType;
			//	}
			}
			TemplateSignature ownedTemplateSignature = partiallySpecializedType.getOwnedSignature();
			if (ownedTemplateSignature != null) {
				List<@NonNull Type> templateArguments = new ArrayList<@NonNull Type>();
				for (@SuppressWarnings("null")@NonNull TemplateParameter ownedTemplateParameter : ownedTemplateSignature.getOwnedParameters()) {
					Type actualType = specializeType(ownedTemplateParameter);
					templateArguments.add(actualType);
				}
				return metamodelManager.getLibraryType(unspecializedType, templateArguments);
			}
		}
		return type;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");
		boolean isFirst = true;
		List<Integer> keys = new ArrayList<Integer>(context.keySet());
		Collections.sort(keys);
		for (Integer index : keys) {
			if (!isFirst) {
				s.append("\n");
			}
			s.append(index + " => " + context.get(index));
			isFirst = false;
		}
		s.append("}");
		return s.toString();
	}

	@Override
	public String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		for (TemplateBinding templateBinding : object.getOwnedBindings()) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
				safeVisit(templateParameterSubstitution.getActual());
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCollectionType(@NonNull CollectionType object) {
		if (actual instanceof CollectionType) {
			Type formalElementType = object.getElementType();
			Type actualElementType = ((CollectionType)actual).getElementType();
			analyzeType(formalElementType, actualElementType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitIterateExp(@NonNull IterateExp object) {
		Iteration referredIteration = object.getReferredIteration();
		analyzeTypedElement(referredIteration, object);
		analyzeFeature(referredIteration, object.getOwnedSource());
		analyzeTypedElements(referredIteration.getOwnedIterators(), object.getOwnedIterators());
		//		analyzeTypedElements(referredIteration.getOwnedCoIterators(), object.getOwnedCoIterators());
		analyzeTypedElements(referredIteration.getOwnedAccumulators(), Collections.singletonList(object.getOwnedResult()));
		analyzeTypedElements(referredIteration.getOwnedParameters(), Collections.singletonList(object.getOwnedBody()));
		return null;
	}

	@Override
	public @Nullable Object visitIteratorExp(@NonNull IteratorExp object) {
		Iteration referredIteration = object.getReferredIteration();
		analyzeTypedElement(referredIteration, object);
		analyzeFeature(referredIteration, object.getOwnedSource());
		analyzeTypedElements(referredIteration.getOwnedIterators(), object.getOwnedIterators());
		//		analyzeTypedElements(referredIteration.getOwnedCoIterators(), object.getOwnedCoIterators());
		List<Parameter> formalElements = referredIteration.getOwnedParameters();
		if (formalElements.size() > 0) {
			OCLExpression actualElement = object.getOwnedBody();
			Type actualType = actualElement.getType();
			LibraryIterationOrOperation implementation = (LibraryIterationOrOperation) referredIteration.getImplementation();
			if (implementation != null) {		// Library classes have implementations, Complete OCL classes may be recursive
				actualType = implementation.resolveBodyType(environmentFactory, object, actualType);
			}
			analyzeType(formalElements.get(0).getType(), actualType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitLambdaType(@NonNull LambdaType object) {
		if (actual instanceof LambdaType) {
			LambdaType actualLambdaType = (LambdaType)actual;
			analyzeType(object.getContextType(), actualLambdaType.getContextType());
			analyzeType(object.getResultType(), actualLambdaType.getResultType());
			analyzeTypes(object.getParameterType(), actualLambdaType.getParameterType());
		}
		else {
			analyzeType(object.getResultType(), actual);
		}
		return null;
	}

	@Override
	public @Nullable Object visitMapType(@NonNull MapType object) {
		if (actual instanceof MapType) {
			Type formalKeyType = object.getKeyType();
			Type formalValueType = object.getValueType();
			MapType mapType = (MapType)actual;
			Type actualKeyType = mapType.getKeyType();
			Type actualValueType = mapType.getValueType();
			analyzeType(formalKeyType, actualKeyType);
			analyzeType(formalValueType, actualValueType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
		//		visit(referredOperation, object);
		analyzeTypedElement(referredOperation, object);
		OCLExpression source = object.getOwnedSource();
		if (source != null) {
			analyzeType(referredOperation.getOwningClass(), source.getType());
		}
		analyzeTypedElements(referredOperation.getOwnedParameters(), object.getOwnedArguments());
		//
		//	FIXME More general processing for T2 < T1
		//
		LibraryIterationOrOperation implementation = (LibraryIterationOrOperation)referredOperation.getImplementation();
		if (implementation != null) {		// Library classes have implementations, Complete OCL classes may be recursive
			implementation.resolveUnmodeledTemplateParameterSubstitutions(this, object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		Property referredOppositeProperty = object.getReferredProperty();
		if (referredOppositeProperty != null) {
			Property referredProperty = referredOppositeProperty.getOpposite();
			if (referredProperty != null) {
				analyzeFeature(referredProperty, object.getOwnedSource());
				analyzeTypedElement(referredProperty, object);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitParameter(@NonNull Parameter object) {
		if ((object.isIsTypeof()) && actual instanceof OCLExpression) {
			analyzeType(object.getType(), ((OCLExpression)actual).getTypeValue());
		}
		else {
			super.visitParameter(object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitPrimitiveType(@NonNull PrimitiveType object) {
		return null;
	}

	@Override
	public @Nullable Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		Property referredProperty = object.getReferredProperty();
		if (referredProperty != null) {
			OCLExpression source = object.getOwnedSource();
			if (source != null) {
				Type sourceType = source.getType();
				analyzeType(referredProperty.getOwningClass(), sourceType);
			}
			analyzeTypedElement(referredProperty, object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitSelfType(@NonNull SelfType object) {
		analyzeType(/*selfIsTypeof ? metamodelManager.getClassType() :*/ selfType, actual);
		return null;
	}

	@Override
	public @Nullable Object visitTemplateParameter(@NonNull TemplateParameter object) {
		if (actual instanceof Type) {
			put(object, (Type)actual);
		}
		return null;
	}

	@Override
	public @Nullable Object visitTupleType(@NonNull TupleType object) {
		if (actual instanceof TupleType) {
			analyzeTypedElements(object.getOwnedProperties(), ((TupleType)actual).getOwnedProperties());
		}
		return null;
	}

	@Override
	public @Nullable Object visitTypedElement(@NonNull TypedElement object) {
		if (actual instanceof TypedElement) {
			analyzeType(object.getType(), ((TypedElement)actual).getType());
		}
		return null;
	}
}
