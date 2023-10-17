/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.as2es;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.delegate.DelegateInstaller;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.OppositePropertyDetails;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.pivot.values.OrderedSet;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class AS2EcoreDeclarationVisitor
extends AbstractExtendingVisitor<Object, AS2Ecore>
{
	public static final @NonNull DuplicateConstraintsFilter duplicateConstraintsFilter = new DuplicateConstraintsFilter();
	public static final @NonNull DuplicateOperationsFilter duplicateOperationsFilter = new DuplicateOperationsFilter();
	public static final @NonNull DuplicatePropertiesFilter duplicatePropertiesFilter = new DuplicatePropertiesFilter();
	public static final @NonNull NonDuplicateConstraintsFilter nonDuplicateConstraintsFilter = new NonDuplicateConstraintsFilter();
	public static final @NonNull NonDuplicateOperationsFilter nonDuplicateOperationsFilter = new NonDuplicateOperationsFilter();
	public static final @NonNull NonDuplicatePropertiesFilter nonDuplicatePropertiesFilter = new NonDuplicatePropertiesFilter();

	protected static class DuplicateConstraintsFilter implements Predicate<Constraint>
	{
		@Override
		public boolean apply(@Nullable Constraint aConstraint) {
			if (aConstraint == null) {
				return false;
			}
			if (aConstraint.getRedefinedConstraints().size() == 0) {
				return false;
			}
			return true;
		}
	}

	protected static class DuplicateOperationsFilter implements Predicate<Operation>
	{
		@Override
		public boolean apply(@Nullable Operation anOperation) {
			if (anOperation == null) {
				return false;
			}
			if (anOperation.getRedefinedOperations().size() == 0) {
				return false;
			}
			if ("containingActivity".equals(anOperation.getName()) && "ActivityNode".equals(anOperation.getOwningClass().getName())) {
				return false;		// FIXME Bug 405061 workaround
			}
			return true;
			//			return (anOperation != null) && (anOperation.getRedefinedOperation().size() != 0);
		}
	}

	protected static class DuplicatePropertiesFilter implements Predicate<Property>
	{
		@Override
		public boolean apply(@Nullable Property aProperty) {
			if (aProperty == null) {
				return false;
			}
			if (aProperty.getRedefinedProperties().size() == 0) {
				return false;
			}
			return ClassUtil.safeEquals(aProperty.getName(), aProperty.getRedefinedProperties().get(0).getName());
		}
	}

	protected static class NonDuplicateConstraintsFilter implements Predicate<Constraint>
	{
		@Override
		public boolean apply(@Nullable Constraint aConstraint) {
			if (aConstraint == null) {
				return false;
			}
			if (aConstraint.getRedefinedConstraints().size() == 0) {
				return true;
			}
			return false;
		}
	}

	protected static class NonDuplicateOperationsFilter implements Predicate<Operation>
	{
		@Override
		public boolean apply(@Nullable Operation anOperation) {
			if (anOperation == null) {
				return false;
			}
			if (anOperation.getRedefinedOperations().size() == 0) {
				return true;
			}
			if ("containingActivity".equals(anOperation.getName()) && "ActivityNode".equals(anOperation.getOwningClass().getName())) {
				return true;		// FIXME Bug 405061 workaround
			}
			return false;
			//			return (anOperation != null) && (anOperation.getRedefinedOperation().size() == 0);
		}
	}

	protected static class NonDuplicatePropertiesFilter implements Predicate<Property>
	{
		@Override
		public boolean apply(@Nullable Property aProperty) {
			if (aProperty == null) {
				return false;
			}
			if (aProperty.getRedefinedProperties().size() == 0) {
				return true;
			}
			return !ClassUtil.safeEquals(aProperty.getName(), aProperty.getRedefinedProperties().get(0).getName());
			//			return (aProperty != null) && (aProperty.getRedefinedProperty().size() == 0);
		}
	}

	protected final @NonNull DelegateInstaller delegateInstaller;

	public AS2EcoreDeclarationVisitor(@NonNull AS2Ecore context) {
		super(context);
		this.delegateInstaller = context.getDelegateInstaller();
	}

	protected void copyClassifier(@NonNull EClassifier eClassifier, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		copyNamedElement(eClassifier, pivotType);
		@SuppressWarnings("null")@NonNull List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		copyTemplateSignature(eTypeParameters, pivotType);
		if (pivotType.eIsSet(PivotPackage.Literals.CLASS__INSTANCE_CLASS_NAME)) {
			eClassifier.setInstanceClassName(pivotType.getInstanceClassName());
		}
		else {
			eClassifier.eUnset(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		}
		//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		delegateInstaller.installDelegates(eClassifier, pivotType);
		for (Constraint pivotInvariant : pivotType.getOwnedInvariants()) {
			if (!pivotInvariant.isIsCallable()) {
				safeVisit(pivotInvariant);		// Results are inserted directly
			}
		}
	}

	protected @Nullable EAnnotation copyConstraint(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint) {
		EAnnotation eAnnotation = delegateInstaller.createConstraintDelegate(eModelElement, pivotConstraint, context.getEcoreURI());
		if (eAnnotation != null) {
			if (eModelElement instanceof EOperation) {
				AS2Ecore.copyAnnotationComments(eAnnotation, pivotConstraint);
			}
			else {
				AS2Ecore.copyCommentsAndDocumentation(eAnnotation, pivotConstraint);
			}
		}
		return eAnnotation;
	}

	protected void copyDataTypeOrEnum(@NonNull EDataType eDataType, @NonNull DataType pivotDataType) {
		copyClassifier(eDataType, pivotDataType);
		eDataType.setSerializable(pivotDataType.isIsSerializable());
	}

	protected void copyDetails(@NonNull EAnnotation eAnnotation, @NonNull Annotation pivotAnnotation) {
		copyModelElement(eAnnotation, pivotAnnotation);
		@SuppressWarnings("null")@NonNull List<EAnnotation> eAnnotations = eAnnotation.getEAnnotations();
		safeVisitAll(eAnnotations, pivotAnnotation.getOwnedAnnotations());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetails()) {
			String name = pivotDetail.getName();
			if (!PivotConstantsInternal.DOCUMENTATION_ANNOTATION_KEY.equals(name)		// Documentation and comments are merged by comment handling
					|| !PivotConstantsInternal.DOCUMENTATION_ANNOTATION_SOURCE.equals(pivotAnnotation.getName())) {
				String value = StringUtil.splice(pivotDetail.getValues(), "");
				eAnnotation.getDetails().put(name, value);
			}
		}
	}

	protected void copyModelElement(@NonNull EModelElement eModelElement, @NonNull Element pivotModelElement) {
		context.putCreated(pivotModelElement, eModelElement);
		safeVisitAll(ClassUtil.nonNullState(eModelElement.getEAnnotations()), pivotModelElement.getOwnedAnnotations());
		AS2Ecore.copyCommentsAndDocumentation(eModelElement, pivotModelElement);
	}

	protected void copyNamedElement(@NonNull ENamedElement eNamedElement, @NonNull NamedElement pivotNamedElement) {
		copyModelElement(eNamedElement, pivotNamedElement);
		String name = pivotNamedElement.getName();
		if ("containingActivity".equals(name)) {		// FIXME Bug 405061 workaround
			EObject eContainer = pivotNamedElement.eContainer();
			if ((eContainer instanceof Type) && "ActivityNode".equals(((Type)eContainer).getName())) {
				name = "ActivityNode_" + name;
			}
		}
		else if ("inActivity".equals(name)) {		// FIXME Bug 420330 workaround
			EObject eContainer = pivotNamedElement.eContainer();
			if ((eContainer instanceof Type) && "StructuredActivityNode".equals(((Type)eContainer).getName())) {
				name = "activity";
			}
		}
		eNamedElement.setName(name);
	}

	protected void copyTemplateSignature(@NonNull List<ETypeParameter> eTypeParameters, TemplateableElement pivotElement) {
		TemplateSignature templateSignature = pivotElement.getOwnedSignature();
		if (templateSignature != null) {
			List<TemplateParameter> parameters = templateSignature.getOwnedParameters();
			safeVisitAll(eTypeParameters, parameters);
		}
	}

	protected void copyTypedElement(@NonNull ETypedElement eTypedElement, @NonNull TypedElement pivotTypedElement) {
		copyNamedElement(eTypedElement, pivotTypedElement);
		context.defer(pivotTypedElement);		// Defer type/multiplicity setting
	}

	protected @Nullable EAnnotation createOppositeEAnnotation(@NonNull Property property) {
		OppositePropertyDetails oppositePropertyDetails = OppositePropertyDetails.createFromProperty(property);
		if (oppositePropertyDetails == null) {
			return null;
		}
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
		EMap<String, String> details = eAnnotation.getDetails();
		assert details != null;
		oppositePropertyDetails.addToDetails(details);
		return eAnnotation;
	}

	public <T extends EObject> void safeVisitAll(@NonNull List<T> eObjects, @NonNull Iterable<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	@Override
	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2Ecore Declaration pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		@SuppressWarnings("null")
		@NonNull EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(eAnnotation, pivotAnnotation);
		eAnnotation.setSource(pivotAnnotation.getName());
		@SuppressWarnings("null")@NonNull List<EObject> contents = eAnnotation.getContents();
		safeVisitAll(contents, pivotAnnotation.getOwnedContents());
		if (!pivotAnnotation.getReferences().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return eAnnotation;
	}

	@Override
	public EObject visitAnyType(@NonNull AnyType pivotAnyType) {
		if (pivotAnyType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotAnyType);
		Class<?> instanceClass = null;
		String name = pivotAnyType.getName();
		if (TypeId.OCL_ANY_NAME.equals(name)) {
			instanceClass = Object.class;
		}
		eClass.setInstanceClass(instanceClass);
		eClass.setAbstract(true);
		eClass.setInterface(true);
		return eClass;
	}

	@Override
	public EObject visitClass(org.eclipse.ocl.pivot.@NonNull Class pivotClass) {
		if (pivotClass.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotClass);
		eClass.setAbstract(pivotClass.isIsAbstract());
		eClass.setInterface(pivotClass.isIsInterface());
		context.defer(pivotClass);		// Defer superclass resolution
		@SuppressWarnings("null")@NonNull List<EOperation> eOperations = eClass.getEOperations();
		@NonNull Iterable<Constraint> nonDuplicateConstraints = Iterables.filter(pivotClass.getOwnedInvariants(), nonDuplicateConstraintsFilter);
		//		safeVisitAll(eOperations, nonDuplicateConstraints);
		@NonNull Iterable<Operation> nonDuplicateOperations = Iterables.filter(pivotClass.getOwnedOperations(), nonDuplicateOperationsFilter);
		safeVisitAll(eOperations, nonDuplicateOperations);
		@SuppressWarnings("null")@NonNull List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		@NonNull Iterable<Property> nonDuplicateProperties = Iterables.filter(pivotClass.getOwnedProperties(), nonDuplicatePropertiesFilter);
		safeVisitAll(eStructuralFeatures, nonDuplicateProperties);
		Map<@NonNull String, @Nullable Object> options = context.getOptions();
		String invariantPrefix = AS2Ecore.getInvariantPrefix(options);
		for (Constraint pivotInvariant : nonDuplicateConstraints) {
			if (pivotInvariant.isIsCallable()) {
				@NonNull String name = PivotUtil.getName(pivotInvariant);
				if (invariantPrefix != null) {
					name = invariantPrefix + name;
				}
				EOperation eOperation = AS2Ecore.createConstraintEOperation(pivotInvariant, name, options);
				eOperations.add(eOperation);
				context.putCreated(pivotInvariant, eOperation);
				copyConstraint(eOperation, pivotInvariant);
			}
		}
		if (!context.isSuppressDuplicates()) {
			List<ETypedElement> eDuplicates = null;
			@NonNull Iterable<Constraint> duplicateConstraints = Iterables.filter(pivotClass.getOwnedInvariants(), duplicateConstraintsFilter);
			for (Constraint asConstraint : duplicateConstraints) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
				//				Object eOperation = safeVisit(asConstraint);
				if (asConstraint.isIsCallable()) {
					EOperation eOperation = AS2Ecore.createConstraintEOperation(asConstraint, PivotUtil.getName(asConstraint), options);
					eOperations.add(eOperation);
					context.putCreated(asConstraint, eOperation);
					copyConstraint(eOperation, asConstraint);
					eDuplicates.add(eOperation);
					context.defer(asConstraint);		// Defer references
				}
			}
			@NonNull Iterable<Operation> duplicateOperations = Iterables.filter(pivotClass.getOwnedOperations(), duplicateOperationsFilter);
			for (Operation asOperation : duplicateOperations) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
				Object eOperation = safeVisit(asOperation);
				if (eOperation instanceof EOperation) {
					eDuplicates.add((EOperation)eOperation);
				}
			}
			@NonNull Iterable<Property> duplicateProperties = Iterables.filter(pivotClass.getOwnedProperties(), duplicatePropertiesFilter);
			for (Property asProperty : duplicateProperties) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
				Object eStructuralFeature = safeVisit(asProperty);
				if (eStructuralFeature instanceof EStructuralFeature) {
					eDuplicates.add((EStructuralFeature) eStructuralFeature);
				}
			}
			if (eDuplicates != null) {
				EAnnotation eAnnotation = eClass.getEAnnotation(PivotConstantsInternal.DUPLICATES_ANNOTATION_SOURCE);
				if (eAnnotation == null) {
					eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eAnnotation.setSource(PivotConstantsInternal.DUPLICATES_ANNOTATION_SOURCE);
					eClass.getEAnnotations().add(eAnnotation);
				}
				context.refreshList(eAnnotation.getContents(), eDuplicates);
			}
		}
		return eClass;
	}

	@Override
	public EObject visitCollectionType(@NonNull CollectionType pivotCollectionType) {
		if (pivotCollectionType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotCollectionType);
		Class<?> instanceClass = null;
		String name = pivotCollectionType.getName();
		if ("Bag".equals(name)) {
			instanceClass = Bag.class;
		}
		else if ("Collection".equals(name)) {
			instanceClass = Collection.class;
		}
		else if ("OrderedCollection".equals(name)) {
			instanceClass = Collection.class;
		}
		else if ("OrderedSet".equals(name)) {
			instanceClass = OrderedSet.class;
		}
		else if ("Sequence".equals(name)) {
			instanceClass = List.class;
		}
		else if ("Set".equals(name)) {
			instanceClass = Set.class;
		}
		else if ("UniqueCollection".equals(name)) {
			instanceClass = Collection.class;
		}
		@SuppressWarnings("null")@NonNull List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		@NonNull Iterable<Property> nonDuplicateProperties = Iterables.filter(pivotCollectionType.getOwnedProperties(), nonDuplicatePropertiesFilter);
		safeVisitAll(eStructuralFeatures, nonDuplicateProperties);
		eClass.setInstanceClass(instanceClass);
		eClass.setAbstract(true);
		eClass.setInterface(true);
		context.defer(pivotCollectionType);		// Defer superclass resolution
		return eClass;
	}

	@Override
	public EObject visitConstraint(@NonNull Constraint pivotConstraint) {
		Element eContainer = (Element)pivotConstraint.eContainer();
		if (eContainer != null) {
			EModelElement eModelElement = context.getCreated(EModelElement.class, eContainer);
			if (eModelElement != null) {
				copyConstraint(eModelElement, pivotConstraint);
				return null;
			}
		}
		return null;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		if (pivotDataType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
		copyDataTypeOrEnum(eDataType, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitEnumeration(@NonNull Enumeration pivotEnumeration) {
		if (pivotEnumeration.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		copyDataTypeOrEnum(eEnum, pivotEnumeration);
		@SuppressWarnings("null")@NonNull List<EEnumLiteral> eLiterals = eEnum.getELiterals();
		safeVisitAll(eLiterals, pivotEnumeration.getOwnedLiterals());
		return eEnum;
	}

	@Override
	public EObject visitEnumerationLiteral(@NonNull EnumerationLiteral pivotEnumLiteral) {
		@SuppressWarnings("null")
		@NonNull EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		copyNamedElement(eEnumLiteral, pivotEnumLiteral);
		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__LITERAL)) {
			eEnumLiteral.setLiteral(pivotEnumLiteral.getLiteral());
		}
		else {
			eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__LITERAL);
		}
		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			eEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
		}
		else {
			eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
		}
		return eEnumLiteral;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public EObject visitMapType(@NonNull MapType pivotMapType) {
		if (pivotMapType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotMapType);
		@SuppressWarnings("null")@NonNull List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		@NonNull Iterable<Property> nonDuplicateProperties = Iterables.filter(pivotMapType.getOwnedProperties(), nonDuplicatePropertiesFilter);
		safeVisitAll(eStructuralFeatures, nonDuplicateProperties);
		eClass.setInstanceClass(Map.class);
		eClass.setAbstract(true);
		eClass.setInterface(true);
		context.defer(pivotMapType);		// Defer superclass resolution
		return eClass;
	}

	@Override
	public Object visitModel(@NonNull Model pivotModel) {
		EModelElement firstElement = null;
		List<EObject> outputObjects = new ArrayList<EObject>();
		for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package pivotObject : pivotModel.getOwnedPackages()) {
			if (!Orphanage.isTypeOrphanage(pivotObject) && !PivotUtilInternal.isImplicitPackage(pivotObject)) {
				Object ecoreObject = safeVisit(pivotObject);
				if (ecoreObject instanceof EObject) {
					outputObjects.add((EObject) ecoreObject);
					if ((firstElement == null) && (ecoreObject instanceof EModelElement)) {
						firstElement = (EModelElement) ecoreObject;
					}
				}
			}
		}
		List<Import> imports = pivotModel.getOwnedImports();
		if (imports.size() > 0) {
			if (imports.size() > 0) {
				imports = new ArrayList<Import>(imports);
				Collections.sort(imports, new Comparator<Import>()
				{
					@Override
					public int compare(Import o1, Import o2) {
						String n1 = o1.getName();
						String n2 = o2.getName();
						if (n1 == null) n1 = "";
						if (n2 == null) n2 = "";
						return n1.compareTo(n2);
					}
				}
						);
			}
			EAnnotation importAnnotation = null;
			URI ecoreURI = context.getEcoreURI();
			int noNames = 0;
			for (Import anImport : imports) {
				Namespace importedNamespace = anImport.getImportedNamespace();
				if (importedNamespace != null) {
					String key = anImport.getName();
					if ((key == null) || "".equals(key)) {
						noNames++;
					}
				}
			}
			for (Import anImport : imports) {
				Namespace importedNamespace = anImport.getImportedNamespace();
				if (importedNamespace != null) {
					if (importAnnotation == null) {
						importAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
						importAnnotation.setSource(PivotConstants.IMPORT_ANNOTATION_SOURCE);
					}
					EObject eTarget = importedNamespace.getESObject();
					String value;
					if (eTarget != null) {
						URI uri = null;
						Resource eResource = eTarget.eResource();
						if ((eTarget instanceof EPackage) && ClassUtil.isRegistered(eResource)) {
							uri = eResource.getURI();
						}
						if (uri == null) {
							uri = EcoreUtil.getURI(eTarget);
						}
						URI uri2 = URIUtil.deresolve(uri, ecoreURI, true, true, true);
						value = uri2.toString();
					}
					else if (importedNamespace instanceof org.eclipse.ocl.pivot.Package) {
						value = ((org.eclipse.ocl.pivot.Package)importedNamespace).getURI();
					}
					else {
						value = importedNamespace.toString();
					}
					String key = anImport.getName();
					if ((noNames > 1) && ((key == null) || "".equals(key))) {
						key = value;
						value = null;
					}
					String oldValue = importAnnotation.getDetails().put(key, value);
					if (oldValue != null) {
						System.out.println("Conflicting " + PivotConstants.IMPORT_ANNOTATION_SOURCE + " for \"" + key + "\" => \"" + oldValue + "\" / \"" + value + "\"");
					}
				}
			}
			if ((firstElement != null) && (importAnnotation != null)) {
				firstElement.getEAnnotations().add(importAnnotation);
			}
		}
		return outputObjects;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		if (pivotOperation.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		copyTypedElement(eOperation, pivotOperation);
		@SuppressWarnings("null")@NonNull List<ETypeParameter> eTypeParameters = eOperation.getETypeParameters();
		copyTemplateSignature(eTypeParameters, pivotOperation);
		@SuppressWarnings("null")@NonNull List<EParameter> eParameters = eOperation.getEParameters();
		safeVisitAll(eParameters, pivotOperation.getOwnedParameters());
		//		safeVisitAll(eOperation.getEGenericExceptions(), pivotOperation.getRaisedException());
		LanguageExpression bodyExpression = pivotOperation.getBodyExpression();
		if (bodyExpression != null) {
			EAnnotation eBodyConstraint = delegateInstaller.createOperationDelegate(eOperation, bodyExpression, context.getEcoreURI());
			if (eBodyConstraint != null) {
				//				AS2Ecore.copyComments(eBodyConstraint, bodyExpression);
			}
		}
		for (Constraint pivotConstraint : pivotOperation.getOwnedPreconditions()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		for (Constraint pivotConstraint : pivotOperation.getOwnedPostconditions()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		if (pivotOperation.isIsTransient()) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstantsInternal.OPERATION_ANNOTATION_SOURCE);
			EMap<String, String> details = eAnnotation.getDetails();
			details.put(PivotConstantsInternal.OPERATION_IS_TRANSIENT, "true");
			eOperation.getEAnnotations().add(eAnnotation);
		}
		return eOperation;
	}

	@Override
	public EObject visitPackage(@NonNull Package pivotPackage) {
		@SuppressWarnings("null")
		@NonNull EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		copyNamedElement(ePackage, pivotPackage);
		context.defer(pivotPackage);		// Defer delegate annotation analysis
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
			ePackage.setNsPrefix(pivotPackage.getNsPrefix());
		}
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__URI)) {
			ePackage.setNsURI(pivotPackage.getURI());
		}
		@SuppressWarnings("null")@NonNull List<EPackage> eSubpackages = ePackage.getESubpackages();
		safeVisitAll(eSubpackages, pivotPackage.getOwnedPackages());
		@SuppressWarnings("null")@NonNull List<EClassifier> eClassifiers = ePackage.getEClassifiers();
		safeVisitAll(eClassifiers, pivotPackage.getOwnedClasses());
		return ePackage;
	}

	@Override
	public EObject visitParameter(@NonNull Parameter pivotParameter) {
		@SuppressWarnings("null")
		@NonNull EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		copyTypedElement(eParameter, pivotParameter);
		return eParameter;
	}

	@Override
	public EObject visitPrimitiveType(@NonNull PrimitiveType pivotPrimitiveType) {
		if (pivotPrimitiveType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
		copyDataTypeOrEnum(eDataType, pivotPrimitiveType);
		/*		Class<?> instanceClass = null;
		String name = pivotPrimitiveType.getName();
		if ("Boolean".equals(name)) {
			instanceClass = Boolean.class;
		}
		else if ("Integer".equals(name)) {
			instanceClass = IntegerValue.class;
		}
		else if ("Real".equals(name)) {
			instanceClass = RealValue.class;
		}
		else if ("String".equals(name)) {
			instanceClass = String.class;
		}
		else if ("UnlimitedNatural".equals(name)) {
			instanceClass = UnlimitedNaturalValue.class;
		}
		eDataType.setInstanceClass(instanceClass); */
		return eDataType;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isIsImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature;
		Type type = pivotProperty.getType();
		CollectionType ecoreCollectionType = context.isEcoreCollection(type);
		if (ecoreCollectionType != null) {
			type = ecoreCollectionType.getElementType();
		}
		if (type instanceof MapType) {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			eReference.setContainment(pivotProperty.isIsComposite());
			eReference.setResolveProxies(pivotProperty.isIsResolveProxies());
			eStructuralFeature = eReference;
		}
		else if (type instanceof DataType) {
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setID(pivotProperty.isIsID());
			eStructuralFeature = eAttribute;
		}
		else {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
				context.defer(pivotProperty);
			}
			eReference.setContainment(pivotProperty.isIsComposite());
			eReference.setResolveProxies(pivotProperty.isIsResolveProxies());
			eStructuralFeature = eReference;
		}
		Property opposite = pivotProperty.getOpposite();
		if ((opposite != null) && opposite.isIsImplicit()) {
			EAnnotation eAnnotation = createOppositeEAnnotation(opposite);
			if (eAnnotation != null) {
				eStructuralFeature.getEAnnotations().add(eAnnotation);
			}
		}
		copyTypedElement(eStructuralFeature, pivotProperty);
		eStructuralFeature.setChangeable(!pivotProperty.isIsReadOnly());
		eStructuralFeature.setDerived(pivotProperty.isIsDerived());
		eStructuralFeature.setTransient(pivotProperty.isIsTransient());
		eStructuralFeature.setUnsettable(pivotProperty.isIsUnsettable());
		eStructuralFeature.setVolatile(pivotProperty.isIsVolatile());
		//		Object defaultValue = pivotProperty.getDefaultValue();
		String defaultValueLiteral = pivotProperty.getDefaultValueString();
		/*		if (defaultValue != null) {
			if (defaultValue instanceof String) {
				defaultValueLiteral = (String)defaultValue;
			}
			else if (defaultValue instanceof Boolean) {
				defaultValueLiteral = defaultValue.toString();
			}
			else if (defaultValue instanceof Value) {
				defaultValueLiteral = defaultValue.toString();
			}
			else if (defaultValue instanceof EnumerationLiteral) {
				defaultValueLiteral = ((EnumerationLiteral)defaultValue).getName();
			}
//			else if (defaultValue instanceof EnumerationLiteralId) {						// type is Enumeration
//				defaultValueLiteral = ((EnumerationLiteralId)defaultValue).getName();
//			}
			else {			// FIXME Use URI for lack of Ecore support
				defaultValueLiteral = String.valueOf(defaultValue);		// FIXME need init EAnnotation for generality
			}
/ *			String defaultValueLiteral = eObject.getDefaultValueLiteral();
			Object boxedValue;
			EClassifier eType = eObject.getEType();
			if (type instanceof DataType) {
				EDataType eDataType = (EDataType)eType;
				EFactory eFactoryInstance = eDataType.getEPackage().getEFactoryInstance();
				Object unboxedValue = eFactoryInstance.createFromString(eDataType, defaultValueLiteral);
				boxedValue = metamodelManager.getIdResolver().boxedValueOf(unboxedValue);
				pivotElement.setDefaultValue(boxedValue);
			}
			else {
				URI uri = URI.createURI(defaultValueLiteral);
				boxedValue = metamodelManager.getExternalResourceSet().getEObject(uri, false);
			}
			pivotElement.setDefaultValue(boxedValue); * /


		} */
		if (defaultValueLiteral != null) {
			eStructuralFeature.setDefaultValueLiteral(defaultValueLiteral);
		}
		else {
			eStructuralFeature.eUnset(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		}
		LanguageExpression defaultExpression = pivotProperty.getOwnedExpression();
		if (defaultExpression != null) {
			delegateInstaller.createPropertyDelegate(eStructuralFeature, defaultExpression, context.getEcoreURI());
		}
		/*		for (Property redefinedProperty : pivotProperty.getRedefinedProperty()) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
			eStructuralFeature.getEAnnotations().add(eAnnotation);
		} */
		return eStructuralFeature;
	}

	@Override
	public EObject visitTemplateParameter(@NonNull TemplateParameter pivotTemplateParameter) {
		ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter.setName(pivotTemplateParameter.getName());
		context.putCreated(pivotTemplateParameter, eTypeParameter);
		if (!pivotTemplateParameter.getConstrainingClasses().isEmpty()) {
			context.defer(pivotTemplateParameter);
		}
		return eTypeParameter;
	}
}
