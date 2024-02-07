/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.as2es;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.delegate.DelegateInstaller;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class AS2EcoreReferenceVisitor extends AbstractExtendingVisitor<EObject, AS2Ecore>
{
	protected static class OptionalType
	{
		public final @Nullable Type type;
		public final boolean isRequired;

		public OptionalType(@Nullable Type type, boolean isRequired) {
			this.type = type;
			this.isRequired = isRequired;
		}
	}

	private static final Logger logger = LogManager.getLogger(AS2EcoreReferenceVisitor.class);

	protected final @NonNull AS2EcoreTypeRefVisitor typeRefVisitor;				// Optional
	/**
	 * @since 1.3
	 */
	protected final @NonNull AS2EcoreTypeRefVisitor requiredTypeRefVisitor;		// Required

	private final @NonNull AnyType oclAnyType;
	private final org.eclipse.ocl.pivot.@NonNull Class oclElementType;
	private final org.eclipse.ocl.pivot.@NonNull Class oclTypeType;

	public AS2EcoreReferenceVisitor(@NonNull AS2Ecore context) {
		super(context);
		typeRefVisitor = new AS2EcoreTypeRefVisitor(context, false);
		requiredTypeRefVisitor = new AS2EcoreTypeRefVisitor(context, true);
		StandardLibraryInternal standardLibrary = context.getStandardLibrary();
		oclAnyType = standardLibrary.getOclAnyType();
		oclElementType = standardLibrary.getOclElementType();
		oclTypeType = standardLibrary.getOclTypeType();
	}

	protected @Nullable OptionalType addPropertyRedefinitionEAnnotations(@NonNull EStructuralFeature eStructuralFeature, @NonNull Property pivotProperty) {
		@Nullable OptionalType optionalType = null;
		Type redefiningType = pivotProperty.getType();
		EAnnotation eRedefinesAnnotation = null;
		String changedEType = null;
		String changedLower = null;
		String changedUpper = null;
		for (@SuppressWarnings("null")@NonNull Property redefinedProperty : pivotProperty.getRedefinedProperties()) {
			EStructuralFeature eRedefined = getCreated(EStructuralFeature.class, redefinedProperty);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
					eStructuralFeature.getEAnnotations().add(eRedefinesAnnotation);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
				//
				IntegerValue redefinedLower = redefinedProperty.isIsRequired() ? ValueUtil.ONE_VALUE :  ValueUtil.ZERO_VALUE;
				UnlimitedNaturalValue redefinedUpper = ValueUtil.UNLIMITED_ONE_VALUE;
				Type redefinedType = redefinedProperty.getType();
				Type redefinedElementType = redefinedType;
				if (redefinedElementType instanceof CollectionType) {
					CollectionType redefinedCollectionType = (CollectionType)redefinedElementType;
					redefinedLower = redefinedCollectionType.getLowerValue();
					redefinedUpper = redefinedCollectionType.getUpperValue();
					redefinedElementType = redefinedCollectionType.getElementType();
				}
				//
				IntegerValue redefiningLower = pivotProperty.isIsRequired() ? ValueUtil.ONE_VALUE :  ValueUtil.ZERO_VALUE;
				UnlimitedNaturalValue redefiningUpper = ValueUtil.UNLIMITED_ONE_VALUE;
				Type redefiningElementType = redefiningType;
				if (redefiningElementType instanceof CollectionType) {
					CollectionType redefiningCollectionType = (CollectionType)redefiningElementType;
					redefiningLower = redefiningCollectionType.getLowerValue();
					redefiningUpper = redefiningCollectionType.getUpperValue();
					redefiningElementType = redefiningCollectionType.getElementType();
				}
				//
				if (!(redefinedType instanceof CollectionType) && (redefinedElementType != redefiningElementType)) {
					changedEType = redefiningElementType.toString();
				}
				if (!redefinedLower.equals(redefiningLower)) {
					changedLower = redefiningLower.toString();
				}
				if (!redefinedUpper.equals(redefiningUpper)) {
					changedUpper = redefiningUpper.equals(ValueUtil.UNLIMITED_VALUE) ? "-1" : redefiningUpper.toString();
				}
				//
				if (!(redefiningType instanceof CollectionType)) {
					if (!(redefinedType instanceof CollectionType)) {
						optionalType = new OptionalType(redefinedElementType, redefinedProperty.isIsRequired());
					}
					else if (redefiningType != null) {
						CollectionType redefinedCollectionType = (CollectionType)redefinedType;
						optionalType = new OptionalType(context.getMetamodelManager().getCollectionType(redefinedCollectionType.isOrdered(), redefinedCollectionType.isUnique(),
							redefiningType, redefinedCollectionType.isIsNullFree(),
							redefinedCollectionType.getLowerValue(), redefinedCollectionType.getUpperValue()), redefinedProperty.isIsRequired());
					}
				}
			}
		}
		if ((changedEType != null) || (changedLower != null) || (changedUpper != null)) {
			EAnnotation eCorrection = EcoreFactory.eINSTANCE.createEAnnotation();
			eCorrection.setSource(eStructuralFeature.getName());
			EMap<String, String> eDetails = eCorrection.getDetails();
			if (changedEType != null) {
				eDetails.put("eType", changedEType);
			}
			if (changedLower != null) {
				eDetails.put("lowerBound", changedLower);
			}
			if (changedUpper != null) {
				eDetails.put("upperBound", changedUpper);
			}
			EModelElement eContainer = (EModelElement) eStructuralFeature.eContainer();
			eContainer.getEAnnotations().add(eCorrection);
		}
		return optionalType;
	}

	protected boolean addPropertyRenameEAnnotations(@NonNull EStructuralFeature eStructuralFeature, @NonNull Property pivotProperty) {
		for (@SuppressWarnings("null")@NonNull Property redefinedProperty1 :  pivotProperty.getRedefinedProperties()) {
			if (!ClassUtil.safeEquals(pivotProperty.getName(), redefinedProperty1.getName())) {
				EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
				for (@SuppressWarnings("null")@NonNull Property redefinedProperty2 :  pivotProperty.getRedefinedProperties()) {
					EStructuralFeature eRedefined = getCreated(EStructuralFeature.class, redefinedProperty2);
					if (eRedefined != null) {
						eAnnotation.getReferences().add(eRedefined);
					}
				}
				eStructuralFeature.getEAnnotations().add(eAnnotation);
				return true;
			}
		}
		return false;
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	private <T extends EObject> @Nullable T getCreated(@NonNull Class<T> requiredClass, @NonNull Element pivotElement) {
		@Nullable T eModelElement = context.getCreated(requiredClass, pivotElement);
		if (eModelElement != null) {
			return eModelElement;
		}
		Element primaryElement = context.getMetamodelManager().getPrimaryElement(pivotElement);
		if (!(primaryElement instanceof PivotObjectImpl)) {
			return null;
		}
		EObject eObject = ((PivotObjectImpl)primaryElement).getESObject();
		if (eObject == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(eObject.getClass())) {
			logger.error("Ecore " + eObject.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) eObject;
		return castElement;
	}

	private @NonNull EClass getEntryEClass(@NonNull EPackage ePackage, @NonNull MapType pivotType) {
		Type keyType = PivotUtil.getKeyType(pivotType);
		Type valueType = PivotUtil.getValueType(pivotType);
		StringBuilder s = new StringBuilder();
		s.append(keyType.getName());
		if (!pivotType.isKeysAreNullFree()) {
			s.append("Opt");
		}
		s.append("2");
		s.append(valueType.getName());
		if (!pivotType.isValuesAreNullFree()) {
			s.append("Opt");
		}
		String name = s.toString();
		EClassifier eClassifier = ePackage.getEClassifier(name);
		if (eClassifier instanceof EClass) {
			return (EClass) eClassifier;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.setInstanceClassName(java.util.Map.Entry.class.getName());
		EStructuralFeature eKeyFeature;
		if (keyType instanceof DataType) {
			eKeyFeature = EcoreFactory.eINSTANCE.createEAttribute();
		}
		else {
			eKeyFeature = EcoreFactory.eINSTANCE.createEReference();
		}
		eKeyFeature.setName("key");
		eKeyFeature.setEType((EClassifier)(pivotType.isKeysAreNullFree() ? requiredTypeRefVisitor : typeRefVisitor).safeVisit(keyType));
		eKeyFeature.setLowerBound(pivotType.isKeysAreNullFree() ? 1 : 0);
		eKeyFeature.setUpperBound(1);
		eClass.getEStructuralFeatures().add(eKeyFeature);
		EStructuralFeature eValueFeature;
		if (valueType instanceof DataType) {
			eValueFeature = EcoreFactory.eINSTANCE.createEAttribute();
		}
		else {
			eValueFeature = EcoreFactory.eINSTANCE.createEReference();
		}
		eValueFeature.setName("value");
		eValueFeature.setEType((EClassifier)(pivotType.isValuesAreNullFree() ? requiredTypeRefVisitor : typeRefVisitor).safeVisit(valueType));
		eValueFeature.setLowerBound(pivotType.isValuesAreNullFree() ? 1 : 0);
		eValueFeature.setUpperBound(1);
		eClass.getEStructuralFeatures().add(eValueFeature);
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(PivotConstants.ENTRY_CLASS_ANNOTATION_SOURCE);
		eClass.getEAnnotations().add(eAnnotation);
		ePackage.getEClassifiers().add(eClass);
		return eClass;
	}

	public <T extends EClassifier> void safeVisitAll(Class<?> javaClass, List<EGenericType> eGenericTypes, List<T> eTypes, List<? extends Type> asTypes) {
		if (asTypes.size() > 0) {
			List<EObject> eClasses = new ArrayList<EObject>(asTypes.size());
			typeRefVisitor.safeVisitAll(eClasses, asTypes);
			eTypes.clear();
			eGenericTypes.clear();
			for (EObject superEClass : eClasses) {
				if (superEClass instanceof EGenericType) {
					eGenericTypes.add((EGenericType)superEClass);
				}
				else if (javaClass.isAssignableFrom(superEClass.getClass())){
					@SuppressWarnings("unchecked") T castSuperEClass = (T)superEClass;
					eTypes.add(castSuperEClass);
				}
			}
		}
		else {
			eGenericTypes.clear();
		}
	}

	private void resolveSuperClasses(@NonNull EClass eClass, org.eclipse.ocl.pivot.@NonNull Class pivotClass) {
		List<org.eclipse.ocl.pivot.Class> superClasses = pivotClass.getSuperClasses();
		EList<EGenericType> eGenericTypes = eClass.getEGenericSuperTypes();
		EList<EClass> eTypes = eClass.getESuperTypes();
		eTypes.clear();
		eGenericTypes.clear();
		for (org.eclipse.ocl.pivot.Class pivotObject : superClasses) {
			// Skip OCL's pseudo-supertypes.
			if ((pivotObject != oclAnyType) && (pivotObject != oclElementType) && (pivotObject != oclTypeType)) {
				EObject superEClass = typeRefVisitor.safeVisit(pivotObject);
				if (superEClass != null) {
					if (superEClass instanceof EGenericType) {
						eGenericTypes.add((EGenericType)superEClass);
					}
					else if (superEClass instanceof EClass){
						eTypes.add((EClass)superEClass);
					}
				}
				// else error
			}
		}
	}

	/* @deprecated provide isRequired argument */
	@Deprecated
	protected void setEType(@NonNull ETypedElement eTypedElement, @NonNull Type pivotType) {
		setEType(eTypedElement, pivotType, false);
	}

	/**
	 * @since 1.3
	 */
	/* @deprecated only called from setETypeAndMultiplicity */
	@Deprecated
	protected void setEType(@NonNull ETypedElement eTypedElement, @NonNull Type pivotType, boolean isRequired) {
		assert !(pivotType instanceof MapType);
		/*	if (pivotType instanceof MapType) {
			org.eclipse.ocl.pivot.Class entryClass = ((MapType)pivotType).getEntryClass();
			if (entryClass != null) {
				setEType(eTypedElement, entryClass, isRequired);
				eTypedElement.setOrdered(true);		// sic; Ecore idiom
				eTypedElement.setUnique(true);
				eTypedElement.setLowerBound(0);
				eTypedElement.setUpperBound(-1);
			}
			else {
				for (EObject eContainer = eTypedElement; eContainer != null; eContainer = eContainer.eContainer()) {
					if (eContainer instanceof EPackage) {
						EClass entryEClass = getEntryEClass((EPackage)eContainer, (MapType)pivotType);
						eTypedElement.setEType(entryEClass);
						break;
					}
				}
				eTypedElement.setUpperBound(-1);
			}
			return;
		} */
		EObject eObject = (isRequired ? requiredTypeRefVisitor : typeRefVisitor).safeVisit(pivotType);
		if (eObject instanceof EGenericType) {
			eTypedElement.setEGenericType((EGenericType)eObject);
		}
		else if (eObject instanceof EClassifier) {
			eTypedElement.setEType((EClassifier)eObject);
		}
		else if (eObject instanceof ETypeParameter) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setETypeParameter((ETypeParameter)eObject);
			eTypedElement.setEGenericType(eGenericType);
		}
		else {
			@SuppressWarnings("unused")
			EObject eObject2 = typeRefVisitor.safeVisit(pivotType);
			//			throw new IllegalArgumentException("Unsupported pivot type '" + pivotType + "' in AS2Ecore Reference pass");
		}
	}

	protected void setETypeAndMultiplicity(@NonNull ETypedElement eTypedElement, @Nullable Type pivotType, boolean isRequired) {
		if ((pivotType == null) || (pivotType instanceof VoidType)) {				// Occurs for Operation return type
			eTypedElement.setLowerBound(0);
			eTypedElement.setUpperBound(1);
			eTypedElement.setOrdered(true);
			eTypedElement.setUnique(true);
		}
		else if ((pivotType instanceof CollectionType) && (((CollectionType)pivotType).getUnspecializedElement() != context.getStandardLibrary().getCollectionType())) {		// Collection(T) cannot be distinguished from concrete Ecore collections
			CollectionType collectionType = (CollectionType)pivotType;
			Type elementType = collectionType.getElementType();
			EObject eObject = typeRefVisitor.safeVisit(elementType);
			if (eObject instanceof EGenericType) {
				eTypedElement.setEGenericType((EGenericType)eObject);
			}
			else {
				eTypedElement.setEType((EClassifier)eObject);
			}
			eTypedElement.setOrdered(collectionType.isOrdered());
			eTypedElement.setUnique(collectionType.isUnique());
			IntegerValue lower = collectionType.getLowerValue();
			UnlimitedNaturalValue upper = collectionType.getUpperValue();
			try {
				eTypedElement.setLowerBound(lower.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal lower bound", e);
			}
			try {
				eTypedElement.setUpperBound(upper.isUnlimited() ? -1 : upper.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal upper bound", e);
			}
			EAnnotation eAnnotation = eTypedElement.getEAnnotation(PivotConstants.COLLECTION_ANNOTATION_SOURCE);
			if (!collectionType.isIsNullFree()) {
				if (eAnnotation == null) {
					eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eAnnotation.setSource(PivotConstants.COLLECTION_ANNOTATION_SOURCE);
				}
				eAnnotation.getDetails().put(PivotConstants.COLLECTION_IS_NULL_FREE, "false");
				eTypedElement.getEAnnotations().add(eAnnotation);
			}
			else {
				eTypedElement.getEAnnotations().remove(eAnnotation);
			}
		}
		else if (pivotType instanceof MapType) {
			org.eclipse.ocl.pivot.Class entryClass = ((MapType)pivotType).getEntryClass();
			if (entryClass != null) {
				setEType(eTypedElement, entryClass, isRequired);
			}
			else {
				for (EObject eContainer = eTypedElement; eContainer != null; eContainer = eContainer.eContainer()) {
					if (eContainer instanceof EPackage) {
						EClass entryEClass = getEntryEClass((EPackage)eContainer, (MapType)pivotType);
						eTypedElement.setEType(entryEClass);
						break;
					}
				}
			}
			eTypedElement.setOrdered(true);		// sic; Ecore idiom is OrderedSet(Entry(K,V)[*|1])[1]
			eTypedElement.setUnique(true);
			eTypedElement.setLowerBound(0);
			eTypedElement.setUpperBound(-1);
		}
		else {
			if (isRequired) {
				eTypedElement.setLowerBound(1);
				eTypedElement.setUpperBound(1);
			}
			else {
				eTypedElement.setLowerBound(0);
				eTypedElement.setUpperBound(1);
			}
			eTypedElement.setUnique(true);
			eTypedElement.setOrdered(true);		// Ecore default
			setEType(eTypedElement, pivotType, isRequired);
		}
	}

	@Override
	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2Ecore Reference pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		EAnnotation eAnnotation = getCreated(EAnnotation.class, pivotAnnotation);
		if (eAnnotation == null) {
			return null;
		}
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReferences()) {
			if (pivotReference != null) {
				EObject target = getCreated(EObject.class, pivotReference);
				if (target != null) {
					eAnnotation.getReferences().add(target);
				}
			}
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(org.eclipse.ocl.pivot.@NonNull Class pivotClass) {
		EClass eClass = getCreated(EClass.class, pivotClass);
		if (eClass == null) {
			return null;
		}
		resolveSuperClasses(eClass, pivotClass);
		return eClass;
	}

	@Override
	public @Nullable EObject visitCollectionType(@NonNull CollectionType pivotClass) {
		EClass eClass = getCreated(EClass.class, pivotClass);
		if (eClass == null) {
			return null;
		}
		resolveSuperClasses(eClass, pivotClass);
		return eClass;
	}

	@Override
	public EObject visitConstraint(@NonNull Constraint pivotConstraint) {
		EOperation eOperation = getCreated(EOperation.class, pivotConstraint);
		EAnnotation eRedefinesAnnotation = null;
		for (@SuppressWarnings("null")@NonNull Constraint redefinedConstraint : pivotConstraint.getRedefinedConstraints()) {
			EOperation eRedefined = getCreated(EOperation.class, redefinedConstraint);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
			}
		}
		if ((eOperation != null) && (eRedefinesAnnotation != null)) {
			eOperation.getEAnnotations().add(eRedefinesAnnotation);
		}
		return eOperation;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		EDataType eDataType = getCreated(EDataType.class, pivotDataType);
		return eDataType;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable EObject visitMapType(@NonNull MapType pivotClass) {
		EClass eClass = getCreated(EClass.class, pivotClass);
		if (eClass == null) {
			return null;
		}
		resolveSuperClasses(eClass, pivotClass);
		return eClass;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		EOperation eOperation = getCreated(EOperation.class, pivotOperation);
		if (eOperation == null) {
			return null;
		}
		safeVisitAll(EClassifier.class, eOperation.getEGenericExceptions(), eOperation.getEExceptions(), pivotOperation.getRaisedExceptions());
		EAnnotation eRedefinesAnnotation = null;
		for (@SuppressWarnings("null")@NonNull Operation redefinedOperation : pivotOperation.getRedefinedOperations()) {
			EOperation eRedefined = getCreated(EOperation.class, redefinedOperation);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
			}
		}
		if (eRedefinesAnnotation != null) {
			eOperation.getEAnnotations().add(eRedefinesAnnotation);
		}
		return super.visitOperation(pivotOperation);
	}

	@Override
	public EObject visitPackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		EPackage ePackage = getCreated(EPackage.class, pivotPackage);
		if (ePackage == null) {
			return null;
		}
		boolean needsDelegates = DelegateInstaller.needsDelegates(ePackage);
		if (needsDelegates) {
			context.getDelegateInstaller().installDelegates(ePackage);
		}
		if (context.isPivot(pivotPackage)) {
			ClassUtil.getMetamodelAnnotation(ePackage);
		}
		return null;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isIsImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature = getCreated(EStructuralFeature.class, pivotProperty);
		if (eStructuralFeature == null) {
			return null;
		}
		if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference) eStructuralFeature;
			Property pivotOpposite = pivotProperty.getOpposite();
			if (pivotOpposite != null) {
				if (pivotOpposite.isIsImplicit()) {
					// FIXME Use EAnnotations for non-navigable opposites as identified by an Association
				}
				else {
					EReference eOpposite = getCreated(EReference.class, pivotOpposite);
					if (eOpposite != null) {
						eReference.setEOpposite(eOpposite);
					}
				}
			}
			for (Property pivotKey : pivotProperty.getKeys()) {
				if (pivotKey != null) {
					EAttribute eAttribute = getCreated(EAttribute.class, pivotKey);
					if (eAttribute != null) {
						eReference.getEKeys().add(eAttribute);
					}
				}
			}
		}
		Type pivotType = pivotProperty.getType();
		boolean pivotIsRequired = pivotProperty.isIsRequired();
		if (!addPropertyRenameEAnnotations(eStructuralFeature, pivotProperty)) {
			OptionalType optionalType = addPropertyRedefinitionEAnnotations(eStructuralFeature, pivotProperty);
			if (optionalType != null) {
				pivotType = optionalType.type;
				pivotIsRequired = optionalType.isRequired;
			}
		}
		setETypeAndMultiplicity(eStructuralFeature, pivotType, pivotIsRequired);
		return null;
	}

	@Override
	public EObject visitTemplateParameter(@NonNull TemplateParameter pivotTemplateParameter) {
		ETypeParameter eTypeParameter = getCreated(ETypeParameter.class, pivotTemplateParameter);
		if (eTypeParameter == null) {
			return null;
		}
		for (org.eclipse.ocl.pivot.Class constrainingType : pivotTemplateParameter.getConstrainingClasses()) {
			if (constrainingType != null) {
				EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
				eTypeParameter.getEBounds().add(eGenericType);
			}
		}
		return null;
	}

	@Override
	public EObject visitTypedElement(@NonNull TypedElement pivotTypedElement) {
		ETypedElement eTypedElement = getCreated(ETypedElement.class, pivotTypedElement);
		if (eTypedElement != null) {
			Type pivotType = pivotTypedElement.getType();
			if (pivotType == null) {
				return null;				// Occurs for Operation return type
			}
			//			setEType(eTypedElement, pivotType);
			setETypeAndMultiplicity(eTypedElement, pivotType, pivotTypedElement.isIsRequired());
		}
		return null;
	}

	/*	@Override
	public Object caseEAnnotation(EAnnotation eAnnotation) {
		AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
		for (ModelElementCSRef csReference : csAnnotation.getReferences()) {
			EObject eObject = createMap.get(csReference.getRef());
			if (eObject != null) {
				eAnnotation.getReferences().add(eObject);
			}
		}
		return null;
	} */

	/*	@Override
	public Object caseEGenericType(EGenericType eGenericType) {
		TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
		TypeCS typeRef = csTypeRef.getType();
		if (typeRef != null) {
			EModelElement eType = (EModelElement) createMap.get(typeRef);
			if (eType == null) {
				eGenericType.setEClassifier((EClassifier) ((ModelElementCS)typeRef).getOriginalObject());
			}
			else if (eType instanceof EClassifier) {
				eGenericType.setEClassifier((EClassifier) eType);
			}
			else if (eType instanceof ETypeParameter) {
				eGenericType.setETypeParameter((ETypeParameter) eType);
			}
		}
		return null;
	} */

	/*	@Override
	public Object caseEReference(EReference eReference) {
		OCLinEcoreReferenceCS csReference = (OCLinEcoreReferenceCS) deferMap.get(eReference);
		ReferenceCSRef csOpposite = csReference.getOpposite();
		if (csOpposite != null) {
			EReference eOpposite = (EReference) createMap.get(csOpposite.getRef());
			if (eOpposite != null) {
				eReference.setEOpposite(eOpposite);
			}
		}
		for (AttributeCSRef csKey : csReference.getKeys()) {
			EAttribute eAttribute = (EAttribute) createMap.get(csKey.getRef());
			if (eAttribute != null) {
				eReference.getEKeys().add(eAttribute);
			}
		}
		return null;
	} */

	//	@Override
	//	public Object caseETypeParameter(ETypeParameter eTypeParameter) {
	//		TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
	/*			ClassifierRef classifierRef = csTypedElement.getType();
		if (classifierRef != null) {
			EClassifier eClassifier = resolveClassifierRef(classifierRef);
			if (eClassifier != null) {
				eTypedElement.setEType(eClassifier);
			}
		} */
	//		return null;
	//	}

}
