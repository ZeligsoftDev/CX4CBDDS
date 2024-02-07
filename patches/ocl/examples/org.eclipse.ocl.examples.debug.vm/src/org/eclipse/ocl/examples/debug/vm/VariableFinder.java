/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMTypeData;
import org.eclipse.ocl.examples.debug.vm.data.VMValueData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.request.VMVariableRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMVariableResponse;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.Value;

public class VariableFinder
{
	public static final @NonNull String CONTAINER_VARIABLE_NAME = "$container";

	/** @deprecated use non-static method */
	@Deprecated
	public static @Nullable String computeDetail(@NonNull URI variableURI, @NonNull VMEvaluationEnvironment fEvalEnv) {
		return newInstance(fEvalEnv, true).computeDetail(variableURI);
	}

	public static @NonNull URI createURI(@NonNull String @NonNull [] varPath) {
		return createURI(varPath, varPath.length - 1);
	}

	public static @NonNull URI createURI(@NonNull String @NonNull [] varPath, int endIndex) {
		String[] segments = new String[endIndex + 1];
		for (int i = 0; i < segments.length; i++) {
			segments[i] =  URI.encodeSegment(varPath[i], true);
		}
		@SuppressWarnings("null") @NonNull URI hierarchicalURI = URI.createHierarchicalURI(segments, null, null);
		return hierarchicalURI;
	}

	public static @NonNull List<EStructuralFeature> getAllFeatures(@NonNull EClass eClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.addAll(eClass.getEAllStructuralFeatures());
		/* 		if (eClass instanceof Root) {
			for (Iterator<EStructuralFeature> it = features.iterator(); it.hasNext();) {
				EStructuralFeature feature = it.next();
				if(feature instanceof ContextualProperty) {
					it.remove();
				}
			}
		}
		collectIntermediateProperties(features, eClass); */
		Collections.sort(features, new Comparator<EStructuralFeature>() {
			@Override
			public int compare(EStructuralFeature var1, EStructuralFeature var2) {
				String n1 = var1.getName();
				String n2 = var2.getName();
				if (n1 == null) n1 = "";
				if (n2 == null) n2 = "";
				return n1.compareTo(n2);
			}
		});
		return features;
	}

	private static @NonNull String getOCLType(@NonNull ETypedElement feature) {
		boolean isNullFree = Ecore2AS.isNullFree(feature);
		return getOCLType(feature.getEType(), feature.isUnique(), feature.isOrdered(), isNullFree, feature.getLowerBound(), feature.getUpperBound());
	}

	private static @NonNull String getOCLType(@Nullable EClassifier eType, boolean isUnique, boolean isOrdered, boolean isNullFree, int lowerBound, int upperBound) {
		StringBuilder s = new StringBuilder();
		if (eType == null) {
			s.append("null");
		}
		else if (upperBound != 1) {
			if (isUnique) {
				s.append(isOrdered ? "OrderedSet" : "Set");
			}
			else {
				s.append(isOrdered ? "Sequence" : "Bag");
			}
			s.append("(");
			s.append(eType.getName());
			StringUtil.appendMultiplicity(s, lowerBound, upperBound, isNullFree);
			s.append(")");
		}
		else {
			s.append(eType.getName());
		}
		return s.toString();
	}

	public static String getRootVarName(URI variableURI) {
		if (variableURI.segmentCount() == 0) {
			throw new IllegalArgumentException();
		}
		return URI.decode(variableURI.segment(0));
	}

	public static @NonNull List<VMVariableData> getVariables(@NonNull VMEvaluationEnvironment evalEnv) {
		return newInstance(evalEnv, false).getVariables();
	}

	private static boolean isPredefinedVar(String name, @NonNull VMEvaluationEnvironment evalEnv) {
		if((PivotConstants.SELF_NAME.equals(name) || PivotConstants.RESULT_NAME.equals(name)) && evalEnv.getOperation() != null) {
			return true;
		}
		return "this".equals(name);
	}

	public static @NonNull String @NonNull [] getVariablePath(@NonNull URI variableURI) {
		@NonNull String @NonNull [] ids = new @NonNull String[variableURI.segmentCount()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = String.valueOf(URI.decode(variableURI.segment(i)));
		}
		return ids;
	}

	public static @NonNull VariableFinder newInstance(@NonNull VMEvaluationEnvironment vmEvaluationEnvironment, boolean isStoreValues) {
		return vmEvaluationEnvironment.createVariableFinder(isStoreValues);
	}

	public static @NonNull URI parseURI(String variableURI) throws IllegalArgumentException {
		return URI.createURI(variableURI);
	}

	/** @deprecated use non-static method */
	@Deprecated
	public static VMResponse process(@NonNull VMVariableRequest request, @NonNull List<UnitLocation> stack, @NonNull VMEvaluationEnvironment vmEvaluationEnvironment) {
		return newInstance(vmEvaluationEnvironment, true).process(request, stack);
	}

	private static EClass selectEClass(EClass eClass, int index) {
		if(index > 0) {
			EList<EClass> superClasses = eClass.getEAllSuperTypes();
			if(index < superClasses.size()) {
				return superClasses.get(index);
			}
		}

		return eClass;
	}

	/** @deprecated use non-static method */
	@Deprecated
	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable Type optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.toString() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	/** @deprecated use non-static method */
	@Deprecated
	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable EClassifier optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.getName() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	/** @deprecated use non-static method */
	@Deprecated
	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable String declaredTypeName, @NonNull EvaluationEnvironment evalEnv) {
		VMValueData vmValue;
		VMTypeData vmType;
		if (value == null) {
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclVoid", declaredTypeName); //$NON-NLS-1$
			vmValue = null;
		} else if (value instanceof InvalidValueException) {
			vmValue = new VMValueData(VMValueData.INVALID, "invalid - " + ((InvalidValueException)value).getMessage());
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclInvalid", declaredTypeName); //$NON-NLS-1$
		} else if (value instanceof Resource) {
			Resource resource = (Resource) value;
			//			EClass eClass = eObject.eClass();
			@NonNull String strVal = String.valueOf(resource.getURI());
			vmValue = new VMValueData(VMValueData.RESOURCE, strVal, true);
			@NonNull String className = resource.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			EClass eClass = eObject.eClass();
			String qualifiedName = eClass != null ? eClass.getEPackage().getName() + "::" + eClass.getName() : eObject.getClass().getSimpleName();
			String strVal = qualifiedName + " @" + Integer.toHexString(System.identityHashCode(value));
			boolean hasVariables = (eClass == null) || !eClass.getEAllStructuralFeatures().isEmpty() || value instanceof Resource;
			vmValue = new VMValueData(VMValueData.OBJECT_REF, strVal, hasVariables);
			@SuppressWarnings("null")@NonNull String className = eClass != null ? eClass.getName() : eObject.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			String string = strVal.toString();
			vmValue = new VMValueData(VMValueData.COLLECTION_REF, string, !collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			@NonNull String className = javaType.getSimpleName();
			vmType = new VMTypeData(VMTypeData.COLLECTION, className, declaredTypeName);

		} else if (value instanceof CollectionValue) {
			CollectionValue collection = (CollectionValue) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			String string = strVal.toString();
			vmValue = new VMValueData(VMValueData.COLLECTION_REF, string, !collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			@NonNull String className = javaType.getSimpleName();
			vmType = new VMTypeData(VMTypeData.COLLECTION, className, declaredTypeName);

		} else {
			// everything else we see as a data type
			@NonNull String valueOf = String.valueOf(value);
			if (value.getClass().equals(String.class)) {
				valueOf = "'" + valueOf + "'";
			}
			vmValue = new VMValueData(VMValueData.PRIMITIVE, valueOf);
			@NonNull String className = value.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.DATATYPE, className, declaredTypeName);
		}
		variable.type = vmType;
		variable.value = vmValue;
	}

	protected final @NonNull VMEvaluationEnvironment fEvalEnv;
	protected final boolean fIsStoreValues;
	private @Nullable VMVariableData fTargetVar;		// FIXME Redundant
	private @Nullable String fRootDeclaredType;		// FIXME Redundant

	public VariableFinder(@NonNull VMEvaluationEnvironment fEvalEnv, boolean isStoreValues) {
		this.fEvalEnv = fEvalEnv;
		fIsStoreValues = isStoreValues;
	}

	public void collectChildVars(Object root, @NonNull String @NonNull [] parentPath, @Nullable String containerType, @NonNull List<@NonNull VMVariableData> result) {
		@NonNull String childPath @NonNull [] = new @NonNull String[parentPath.length + 1];
		System.arraycopy(parentPath, 0, childPath, 0, parentPath.length);

		if (root instanceof Resource) {
			Resource model = (Resource) root;
			root = model.getContents();
			containerType = "Set(EObject)";
		}

		if (root instanceof EObject) {
			EObject eObject = (EObject) root;
			@SuppressWarnings("null")@NonNull EClass eClass = eObject.eClass();

			StringBuilder uriBuf = new StringBuilder();
			List<EStructuralFeature> eAllFeatures = getAllFeatures(eClass);

			List<EClass> superClasses = eClass.getEAllSuperTypes();
			for (EStructuralFeature feature : eAllFeatures) {
				EClass owner;

				//				if(feature.eClass() == ExpressionsPackage.eINSTANCE.getContextualProperty()) {
				//					ContextualProperty ctxProperty = (ContextualProperty) feature;
				//					owner = ctxProperty.getContext();

				//					uriBuf.append('+');//.append(intermPropIndex++);
				//				} else {
				owner = feature.getEContainingClass();
				//				}

				int index = superClasses.indexOf(owner);
				uriBuf.append(index < 0 ? 0 : index);
				uriBuf.append('.').append(feature.getName());

				childPath[childPath.length - 1] = String.valueOf(uriBuf);
				VMVariableData elementVar = createFeatureVar(feature, getValue(feature, eObject), createURI(childPath).toString());
				result.add(elementVar);

				uriBuf.setLength(0);
			}
			childPath[childPath.length - 1] = CONTAINER_VARIABLE_NAME;
			Object value = eObject.eContainer();
			if (value == null) {
				value = eObject.eResource();
			}
			VMVariableData elementVar = createContainerVariable(eObject.eContainer(), createURI(childPath));
			result.add(elementVar);
		} else if(root instanceof Collection<?>) {
			Collection<?> elements = (Collection<?>) root;
			String elementType = "?";//"(containerType instanceof CollectionType) ? ((CollectionType) containerType) .getElementType() : fFeatureAccessor.getStandardLibrary().getOclAny()";

			//			Dictionary<Object, Object> asDictionary = null;
			//			if(root instanceof Dictionary<?, ?>) {
			//				@SuppressWarnings("unchecked")
			//				Dictionary<Object, Object> dict = (Dictionary<Object, Object>) root;
			//				asDictionary = dict;
			//				elements = asDictionary.keys();
			//			}

			int i = 0;
			for (Object element : elements) {
				childPath[childPath.length - 1] = String.valueOf(i);
				VMVariableData elementVar;
				//				if(asDictionary == null) {
				elementVar = createCollectionElementVar(i, element, elementType, createURI(childPath).toString());
				//				} else {
				//					Object key = element;
				//					Object value = asDictionary.get(element);
				//					elementVar = createDictionaryElementVar(key, value, elementType, createURI(childPath).toString());
				//				}
				result.add(elementVar);
				i++;
			}
		} else if(root instanceof CollectionValue) {
			CollectionValue elements = (CollectionValue) root;
			String elementType = "(containerType instanceof CollectionType) ? ((CollectionType) containerType) .getElementType() : fFeatureAccessor.getStandardLibrary().getOclAny()";

			//			Dictionary<Object, Object> asDictionary = null;
			//			if(root instanceof Dictionary<?, ?>) {
			//				@SuppressWarnings("unchecked")
			//				Dictionary<Object, Object> dict = (Dictionary<Object, Object>) root;
			//				asDictionary = dict;
			//				elements = asDictionary.keys();
			//			}

			int i = 0;
			for (Object element : elements) {
				childPath[childPath.length - 1] = String.valueOf(i);
				VMVariableData elementVar;
				//				if(asDictionary == null) {
				elementVar = createCollectionElementVar(i, element, elementType, createURI(childPath).toString());
				//				} else {
				//					Object key = element;
				//					Object value = asDictionary.get(element);
				//					elementVar = createDictionaryElementVar(key, value, elementType, createURI(childPath).toString());
				//				}
				result.add(elementVar);
				i++;
			}
		}
	}

	public @Nullable String computeDetail(@NonNull URI variableURI) {
		@NonNull String @NonNull [] variablePath = getVariablePath(variableURI);
		Object valueObject = findStackObject(variablePath);
		try {
			return LabelUtil.getLabel(valueObject);
		} catch(RuntimeException e) {
			// do nothing, empty detail will be returned
		}
		return null;
	}

	private @NonNull VMVariableData createCollectionElementVar(int elementIndex, Object element, @Nullable String elementType, String uri) {
		String varName = "[" + elementIndex + "]"; //$NON-NLS-1$ //$NON-NLS-2$
		int kind = VMVariableData.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, element, uri);
	}

	protected @NonNull VMVariableData createContainerVariable(Object value, @NonNull URI uri) {
		String oclType = getOCLType(ClassUtil.nonNullModel(EcorePackage.Literals.EOBJECT___ECONTAINER));
		return createVariable(CONTAINER_VARIABLE_NAME, VMVariableData.REFERENCE, oclType, value, uri.toString());
	}

	/*	private VMVariable createDictionaryElementVar(Object key, Object value, @Nullable String elementType, String uri) {
		String varName = String.valueOf(key);
		int kind = VMVariable.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, value, uri);
	} */

	private @NonNull VMVariableData createFeatureVar(@NonNull EStructuralFeature feature, Object value, String uri) {
		String varName = ClassUtil.nonNullModel(feature.getName());
		String declaredType = getOCLType(feature);

		int kind = VMVariableData.ATTRIBUTE;
		if (feature instanceof EReference) {
			kind = VMVariableData.REFERENCE;
		}
		//		if (feature instanceof ContextualProperty) {
		//			kind = VMVariable.INTERM_PROPERTY;
		//		}

		return createVariable(varName, kind, declaredType, value, uri);
	}

	private @NonNull VMVariableData createVariable(@NonNull String varName, int kind, @Nullable String declaredType, Object varObj, String uri) {
		VMVariableData result = new VMVariableData(varName, uri);
		result.kind = kind;
		setValueAndType(result, varObj, declaredType);
		if (fIsStoreValues) {
			result.valueObject = varObj;
		}
		return result;
	}

	public void find(@NonNull String @NonNull [] objectPath, boolean fetchChildVariables, @NonNull List<@NonNull VMVariableData> result) {
		if (result.contains(null)) {
			throw new IllegalArgumentException("null result variables"); //$NON-NLS-1$
		}
		try {
			Object referencedObj = findStackObject(objectPath);
			VMVariableData variable = fTargetVar;

			if (variable != null) {
				result.add(variable);

				if (fetchChildVariables) {
					collectChildVars(referencedObj, objectPath, fRootDeclaredType, result);
				}
			}
		} finally {
			fTargetVar = null;
		}
	}

	protected Object findChildObject(Object parentObj, @Nullable String optParentDeclaredType, @NonNull String @NonNull [] varTreePath, int pathIndex) {
		URI uri = createURI(varTreePath, pathIndex);
		// FIXME - deduce the type from actual type, ensure null is not propagated

		VMVariableData childVar = null;
		Object nextObject = null;
		String nextDeclaredType = null;

		if (parentObj instanceof Resource) {
			parentObj = ((Resource)parentObj).getContents();
			nextDeclaredType = "EObject"; //"QvtOperationalStdLibrary.INSTANCE.getElementType()";
		}

		if (parentObj instanceof EObject) {
			String indexedPath = varTreePath[pathIndex];
			if (CONTAINER_VARIABLE_NAME.equals(indexedPath)) {
				Object value = ((EObject)parentObj).eContainer();
				if (value == null) {
					value = ((EObject)parentObj).eResource();
				}
				childVar = createContainerVariable(value, uri);
				nextObject = value;
				nextDeclaredType = getOCLType(ClassUtil.nonNullModel(EcorePackage.Literals.EOBJECT___ECONTAINER));
			}
			else {
				EObject eObject = (EObject) parentObj;
				EStructuralFeature eFeature = findFeature(ClassUtil.nonNullState(indexedPath), eObject.eClass());
				if (eFeature != null) {
					Object value = getValue(eFeature, eObject);
					childVar = createFeatureVar(eFeature, value, uri.toString());
					nextObject = value;
					nextDeclaredType = getOCLType(eFeature);
				}
			}
		} else if (parentObj instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) parentObj;
			int elementIndex = -1;
			try {
				elementIndex = Integer.parseInt(varTreePath[pathIndex]);
			} catch(NumberFormatException e) {
				// FIXME
				throw new IllegalArgumentException();
			}

			if (elementIndex < 0 || elementIndex >= collection.size()) {
				// not valid element position in this collection
				throw new IllegalArgumentException();
			}

			//			if (optParentDeclaredType instanceof CollectionType) {
			//				CollectionType type = (CollectionType) optParentDeclaredType;
			//				nextDeclaredType = "type.getElementType()";
			//			} else if(nextDeclaredType == null) {
			// FIXME
			nextDeclaredType = TypeId.OCL_ANY_NAME;
			//			}

			Object element = getElement(collection, elementIndex);

			childVar = createCollectionElementVar(elementIndex, element, nextDeclaredType, uri.toString());
			nextObject = element;
		} else if (parentObj instanceof CollectionValue) {
			CollectionValue collection = (CollectionValue) parentObj;
			int elementIndex = -1;
			try {
				elementIndex = Integer.parseInt(varTreePath[pathIndex]);
			} catch(NumberFormatException e) {
				// FIXME
				throw new IllegalArgumentException();
			}

			if (elementIndex < 0 || elementIndex >= collection.intSize()) {
				// not valid element position in this collection
				throw new IllegalArgumentException();
			}

			//			if (optParentDeclaredType instanceof CollectionType) {
			//				CollectionType type = (CollectionType) optParentDeclaredType;
			//				nextDeclaredType = "type.getElementType()";
			//			} else if(nextDeclaredType == null) {
			// FIXME
			nextDeclaredType = TypeId.OCL_ANY_NAME;
			//			}

			Object element = getElement(collection.getElements(), elementIndex);

			childVar = createCollectionElementVar(elementIndex, element, nextDeclaredType, uri.toString());
			nextObject = element;
		}

		int nextIndex = pathIndex + 1;
		if (nextIndex < varTreePath.length) {
			if (nextObject != null) {
				// continue navigation in the hierarchy
				return findChildObject(nextObject, nextDeclaredType, varTreePath, nextIndex);
			} else {
				// we can't navigate further via the path due to <null> termination object
				return null;
			}
		}

		this.fTargetVar = childVar;
		return nextObject;
	}

	private @Nullable Object findStackObject(@NonNull String @NonNull [] varTreePath) {
		Object rootObj = null;
		boolean gotIt = false;
		String envVarName = ClassUtil.nonNullState(varTreePath[0]);
		if (envVarName.startsWith("$")) {
			Object pcObject = fEvalEnv.getValueOf(fEvalEnv.getPCVariable());
			for (VMEvaluationEnvironment evalEnv = fEvalEnv; evalEnv != null; evalEnv = evalEnv.getVMParentEvaluationEnvironment()) {
				for (TypedElement localVariable : evalEnv.getVariables()) {
					if (localVariable instanceof OCLExpression) {
						OCLExpression oclExpression = (OCLExpression) localVariable;
						if (oclExpression.eContainer() == pcObject) {
							String varName = getTermVariableName(oclExpression);
							if (envVarName.equals(varName)) {
								rootObj = fEvalEnv.getValueOf(localVariable);
								gotIt = true;
								break;
							}
						}
					}
				}
				if (gotIt) {
					break;
				}
			}
		}
		if (!gotIt) {
			Set<TypedElement> variables = new HashSet<TypedElement>();
			for (VMEvaluationEnvironment evalEnv = fEvalEnv; evalEnv != null; evalEnv = evalEnv.getVMParentEvaluationEnvironment()) {
				Set<TypedElement> localVariables = evalEnv.getVariables();
				variables.addAll(localVariables);
				if (NameUtil.getNameable(localVariables, PivotConstants.SELF_NAME) != null) {
					break;
				}
			}
			rootObj = NameUtil.getNameable(variables, envVarName);
			if (rootObj instanceof Variable) {
				rootObj = fEvalEnv.getValueOf((TypedElement)rootObj);
				gotIt = true;
			}
		}
		fRootDeclaredType = getDeclaredType(rootObj);
		if(rootObj != null && varTreePath.length == 1) {
			// refers to environment variable only
			@NonNull String @NonNull [] uri = new @NonNull String @NonNull [] { envVarName };
			fTargetVar = createVariable(envVarName, VMVariableData.LOCAL, fRootDeclaredType, rootObj, createURI(uri).toString());
			return rootObj;
		}

		if(rootObj == null) {
			// can't navigate further via <null> object
			return null;
		}

		// navigate from the root object using the remaining variable path
		return findChildObject(rootObj, fRootDeclaredType, varTreePath, 1);
	}

	protected String getDeclaredType(Object valueObject) {
		if (valueObject instanceof EObject) {
			return ((EObject)valueObject).eClass().getName();
		}
		else if (valueObject instanceof Value) {
			return ((Value)valueObject).getTypeId().toString();
		}
		else {
			return "evalEnv.getTypeOf(envVarName)";		// FIXME
		}
	}

	private @Nullable Object getElement(@NonNull Collection<?> collection, int index) {
		if (collection instanceof EList<?>) {
			EList<?> eList = (EList<?>) collection;
			return eList.get(index);
		}

		int curr = 0;
		for (Iterator<?> it = collection.iterator(); it.hasNext();) {
			Object object = it.next();
			if (curr++ == index) {
				return object;
			}
		}
		return null;
	}

	private @Nullable EStructuralFeature findFeature(@NonNull String featureRef, EClass actualTarget) {
		String actualRef = featureRef.startsWith("+") ? featureRef.substring(1) : featureRef;
		boolean isIntermediate = featureRef.length() != actualRef.length();

		int classIndex;
		String featureName;
		try {
			int delimiterPos = actualRef.indexOf('.');
			if(delimiterPos <= 0 || delimiterPos >= actualRef.length() - 1) {
				throw new IllegalArgumentException("navigation feature: " + actualRef);
			}

			classIndex = Integer.parseInt(actualRef.substring(0, delimiterPos));
			featureName = actualRef.substring(delimiterPos + 1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal feature reference: " + featureRef);
		}

		EClass featureOwner = selectEClass(actualTarget, classIndex);
		if(featureOwner == null) {
			return null;
		}

		if(!isIntermediate) {
			return featureOwner.getEStructuralFeature(featureName);
		}

		//		EClass contextualPropMetaClass = ExpressionsPackage.eINSTANCE.getContextualProperty();

		//		for (EStructuralFeature feature : actualTarget.getEAllStructuralFeatures()) {
		//			if(feature.eClass() == contextualPropMetaClass && feature.equals(feature.getName())) {
		//				return feature;
		//			}
		//		}

		return null;
	}

	protected static String getTermVariableName(@NonNull OCLExpression oclExpression) {
		EStructuralFeature eContainingFeature = oclExpression.eContainingFeature();
		if (eContainingFeature == null) {
			return null;
		}
		String varName;
		varName = "$" + eContainingFeature.getName();
		if (eContainingFeature.isMany()) {
			EObject eContainer = oclExpression.eContainer();
			if (eContainer != null) {
				Object eGet = eContainer.eGet(eContainingFeature);
				if (eGet instanceof List<?>) {
					int index = ((List<?>)eGet).indexOf(oclExpression);
					varName = varName + "[" + index + "]";
				}
			}
		}
		return varName;
	}

	public Object getValue(EStructuralFeature feature, EObject target) {
		return /*fEvalEnv*/navigateProperty(feature, null, target);
		//		throw new UnsupportedOperationException();
	}

	protected @Nullable VMVariableData getVariable(@NonNull TypedElement variable, @Nullable Object pcObject) {
		String varName = variable.getName();
		if (variable instanceof OCLExpression) {
			OCLExpression oclExpression = (OCLExpression) variable;
			if (oclExpression.eContainer() == pcObject) {
				varName = getTermVariableName(oclExpression);
				if (varName != null) {
					VMVariableData var = new VMVariableData(varName, null);
					var.kind = VMVariableData.LOCAL;
					Object value = null;
					try {
						value = fEvalEnv.getValueOf(oclExpression);
						var.valueObject = value;
					}
					catch (Throwable e) {
						value = e;
					}
					Type declaredType = oclExpression.getType();
					setValueAndType(var, value, declaredType);
					return var;
				}
			}
		}
		else if (varName != null) {
			VMVariableData var = new VMVariableData(varName, null);
			if (isPredefinedVar(varName, fEvalEnv)) {
				var.kind = VMVariableData.PREDEFINED_VAR;
			}
			Object value = null;
			try {
				value = fEvalEnv.getValueOf(variable);
				var.valueObject = value;
			}
			catch (Throwable e) {
				value = e;
			}
			Type declaredType = variable.getType();
			setValueAndType(var, value, declaredType);
			return var;
		}
		return null;
	}

	public @NonNull List<VMVariableData> getVariables() {
		List<VMVariableData> result = new ArrayList<VMVariableData>();
		Object pcObject = fEvalEnv.getValueOf(fEvalEnv.getPCVariable());
		for (TypedElement variable : fEvalEnv.getVariables()) {
			if (variable != null) {
				VMVariableData var = getVariable(variable, pcObject);
				if (var != null) {
					result.add(var);
				}
			}
		}
		return result;
	}

	//	@Override
	public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object target) throws IllegalArgumentException {
		/*		if(target instanceof ModuleInstance) {
			ModuleInstance moduleTarget = (ModuleInstance) target;
			EClassifier owningClassifier = QvtOperationalStdLibrary.INSTANCE.getEnvironment().getUMLReflection().getOwningClassifier(property);
			if (owningClassifier instanceof Module) {
				target = moduleTarget.getThisInstanceOf((Module) owningClassifier);
			}
			else {
				target = moduleTarget.getThisInstanceOf(moduleTarget.getModule());
			}
		} */

		EStructuralFeature resolvedProperty = property;

		//		if (property instanceof ContextualProperty) {
		//			IntermediatePropertyModelAdapter.ShadowEntry shadow = IntermediatePropertyModelAdapter.getPropertyHolder(
		//														property.getEContainingClass(), (ContextualProperty)property, target);
		//			target = shadow.getPropertyRuntimeOwner(target, this);
		//			resolvedProperty = shadow.getProperty();
		//		}

		// FIXME - workaround for a issue of multiple typle type instances, possibly coming from
		// imported modules. The super impl. looks for the property by feature instance, do it
		// by name here to avoid lookup failure, IllegalArgExc...
		/*		if(target instanceof Tuple<?, ?>) {
			if (target instanceof EObject) {
	            EObject etarget = (EObject) target;
	            resolvedProperty = etarget.eClass().getEStructuralFeature(property.getName());
	            if(resolvedProperty == null) {
	            	return null;
	            }
			}
			else {
				resolvedProperty = null;
				for (EStructuralFeature feature : ((Tuple<EOperation, EStructuralFeature>) target).getTupleType().oclProperties()) {
					if (property.getName().equals(feature.getName())) {
						resolvedProperty = feature;
						break;
					}
				}
	            if(resolvedProperty == null) {
	            	return null;
	            }
			}
		}
		else if(property.getEType() instanceof CollectionType<?, ?> && target instanceof EObject) {
			// module property of direct OCL collection type => override the super impl which coerce the result value
			// and takes only the first element and returns from navigate call
            EObject eTarget = (EObject) target;
            if (eTarget.eClass().getEAllStructuralFeatures().contains(resolvedProperty)) {
                return eTarget.eGet(resolvedProperty, true);
            }
		} */

		try {
			return superNavigateProperty(resolvedProperty, qualifiers, target);
		}
		catch (IllegalArgumentException e) {
			fEvalEnv.throwVMException(new VMRuntimeException("Unknown property '" + property.getName() + "'", e)); //$NON-NLS-1$ //$NON-NLS-2$
			return ValueUtil.INVALID_VALUE; //getInvalidResult();
		}
	}

	public @Nullable VMResponse process(@NonNull VMVariableRequest request, @NonNull List<UnitLocation> stack) {

		UnitLocation location = VMVirtualMachine.lookupEnvironmentByID(request.frameID, stack);
		if (location == null) {
			return VMResponse.createERROR();
		}

		String variableURIStr = request.variableURI;
		URI variableURI = parseURI(variableURIStr);

		@NonNull String @NonNull [] variablePath = getVariablePath(variableURI);

		List<@NonNull VMVariableData> variables = new ArrayList<@NonNull VMVariableData>();
		find(variablePath, request.includeChildVars, variables);

		if (variables.isEmpty()) {
			return VMResponse.createERROR();
		}

		@NonNull VMVariableData @Nullable [] children = null;
		int size = variables.size();
		if (size > 1) {
			children = variables.subList(1, size).toArray(new @NonNull VMVariableData @NonNull [size - 1]);
		}
		VMVariableData variable0 = variables.get(0);
		return variable0 != null ? new VMVariableResponse(variable0, children) : null;
	}

	public void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable Type optDeclaredType) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.toString() : null;
		setValueAndType(variable, value, declaredTypeName);
	}

	public void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable String declaredTypeName) {
		VMValueData vmValue;
		VMTypeData vmType;
		if (value == null) {
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclVoid", declaredTypeName); //$NON-NLS-1$
			vmValue = null;
		} else if (value instanceof InvalidValueException) {
			vmValue = new VMValueData(VMValueData.INVALID, "invalid - " + ((InvalidValueException)value).getMessage());
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclInvalid", declaredTypeName); //$NON-NLS-1$
		} else if (value instanceof Resource) {
			Resource resource = (Resource) value;
			//			EClass eClass = eObject.eClass();
			@NonNull String strVal = String.valueOf(resource.getURI());
			vmValue = new VMValueData(VMValueData.RESOURCE, strVal, true);
			@NonNull String className = resource.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			EClass eClass = eObject.eClass();
			String qualifiedName = eClass != null ? eClass.getEPackage().getName() + "::" + eClass.getName() : eObject.getClass().getSimpleName();
			String strVal = qualifiedName + " @" + Integer.toHexString(System.identityHashCode(value));
			boolean hasVariables = (eClass == null) || !eClass.getEAllStructuralFeatures().isEmpty() || value instanceof Resource;
			vmValue = new VMValueData(VMValueData.OBJECT_REF, strVal, hasVariables);
			@SuppressWarnings("null")@NonNull String className = eClass != null ? eClass.getName() : eObject.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			String string = strVal.toString();
			vmValue = new VMValueData(VMValueData.COLLECTION_REF, string, !collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			@NonNull String className = javaType.getSimpleName();
			vmType = new VMTypeData(VMTypeData.COLLECTION, className, declaredTypeName);

		} else if (value instanceof CollectionValue) {
			CollectionValue collection = (CollectionValue) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			String string = strVal.toString();
			vmValue = new VMValueData(VMValueData.COLLECTION_REF, string, !collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			@NonNull String className = javaType.getSimpleName();
			vmType = new VMTypeData(VMTypeData.COLLECTION, className, declaredTypeName);

		} else {
			// everything else we see as a data type
			@NonNull String valueOf = String.valueOf(value);
			if (value.getClass().equals(String.class)) {
				valueOf = "'" + valueOf + "'";
			}
			vmValue = new VMValueData(VMValueData.PRIMITIVE, valueOf);
			@NonNull String className = value.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.DATATYPE, className, declaredTypeName);
		}
		variable.type = vmType;
		variable.value = vmValue;
	}

	// implements the inherited specification
	public Object superNavigateProperty(EStructuralFeature property,
			List<?> qualifiers, Object target)
					throws IllegalArgumentException {

		if (target instanceof EObject) {
			EObject etarget = (EObject) target;

			if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
				if (property.getEType() instanceof VoidType) {
					// then the only instance is null; using eGet would
					// cause a ClassCastException because VoidTypeImpl
					// is neither an EClass nor an EDataType.
					return null;
				}
				return /*coerceValue(property,*/ etarget.eGet(property)/*, true)*/;
			}
		} /*else if (target instanceof Tuple<?, ?>) {
    		@SuppressWarnings("unchecked")
    		Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) target;

    		if (tuple.getTupleType().oclProperties().contains(property)) {
    			return tuple.getValue(property);
    		}
    	} */

		throw new IllegalArgumentException();
	}
}
