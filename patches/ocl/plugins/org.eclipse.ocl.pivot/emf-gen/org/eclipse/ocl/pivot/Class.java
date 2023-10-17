/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.
 *
 * A Classifier represents a classification of instances according to their Features.
 *
 * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getExtenders <em>Extenders</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#isIsActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#isIsInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getOwnedBehaviors <em>Owned Behaviors</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getOwnedInvariants <em>Owned Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Class#getSuperClasses <em>Super Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_()
 * @generated
 */
public interface Class
extends Type, Namespace, TemplateableElement {

	/**
	 * Returns the value of the '<em><b>Extenders</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.StereotypeExtender}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.StereotypeExtender#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extenders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extenders</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_Extenders()
	 * @see org.eclipse.ocl.pivot.StereotypeExtender#getClass_
	 * @generated
	 */
	@NonNull List<StereotypeExtender> getExtenders();

	/**
	 * Returns the value of the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Class Name</em>' attribute.
	 * @see #setInstanceClassName(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_InstanceClassName()
	 * @generated
	 */
	String getInstanceClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Class#getInstanceClassName <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Class Name</em>' attribute.
	 * @see #getInstanceClassName()
	 * @generated
	 */
	void setInstanceClassName(String value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, the Class does not provide a complete declaration and cannot be instantiated. An abstract Class is typically used as a target of Associations or Generalizations.
	 *
	 * If true, the Classifier can only be instantiated by instantiating one of its specializations. An abstract Classifier is intended to be used by other Classifiers e.g., as the target of Associations or Generalizations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_IsAbstract()
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Class#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether an object specified by this Class is active or not. If true, then the owning Class is referred to as an active Class. If false, then such a Class is referred to as a passive Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Active</em>' attribute.
	 * @see #setIsActive(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_IsActive()
	 * @generated
	 */
	boolean isIsActive();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Class#isIsActive <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Active</em>' attribute.
	 * @see #isIsActive()
	 * @generated
	 */
	void setIsActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interface</em>' attribute.
	 * @see #setIsInterface(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_IsInterface()
	 * @generated
	 */
	boolean isIsInterface();

	/**
	 * Returns the value of the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_OwnedInvariants()
	 * @generated
	 */
	@NonNull List<Constraint> getOwnedInvariants();

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Operation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Operations owned by the Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_OwnedOperations()
	 * @see org.eclipse.ocl.pivot.Operation#getOwningClass
	 * @generated
	 */
	@NonNull List<Operation> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(org.eclipse.ocl.pivot.Package)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_OwningPackage()
	 * @see org.eclipse.ocl.pivot.Package#getOwnedClasses
	 * @generated
	 */
	org.eclipse.ocl.pivot.Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Class#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(org.eclipse.ocl.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>Super Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Classes</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_SuperClasses()
	 * @generated
	 */
	@NonNull List<Class> getSuperClasses();

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueInvariantName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Class#isIsInterface <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interface</em>' attribute.
	 * @see #isIsInterface()
	 * @generated
	 */
	void setIsInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Behaviors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Behaviors owned by a BehavioredClassifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Behaviors</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_OwnedBehaviors()
	 * @generated
	 */
	@NonNull List<Behavior> getOwnedBehaviors();

	/**
	 * Returns the value of the '<em><b>Owned Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Property#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Properties owned by the StructuredClassifier.
	 *
	 * The attributes (i.e., the Properties) owned by the Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getClass_OwnedProperties()
	 * @see org.eclipse.ocl.pivot.Property#getOwningClass
	 * @generated
	 */
	@NonNull List<Property> getOwnedProperties();

	/**
	 * Return all instances of this class or an empty set if the number of instances is not finite.
	 *
	 * @since 1.18
	 */
	default @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return ValueUtil.createSetValue(returnTypeId, Collections.emptySet());
	}

	/**
	 * Return a new instance of this type from valueFactory. Properties may be initialised using
	 * {@link Property#initValue(Object, Object) } provided no side-effect free
	 * OCL functionality is permitted to use the ObjectValue until initialisation has completed.
	 */
	@NonNull EObject createInstance();

	/**
	 * Return a new instance of this data type from valueFactory.
	 * @param value string initial value
	 */
	@Nullable Object createInstance( @NonNull String value);

	/**
	 * Return the name of the meta-type of this type.
	 */
	@NonNull String getMetaTypeName();

	/**
	 * Return the ordered list of type parameters of this type.
	 */
	@NonNull TemplateParameters getTypeParameters();

	/**
	 * Return true if this type is a Collection type and has ordered elements.
	 */
	boolean isOrdered();

	/**
	 * Return true if this type is a Collection type and has unique elements.
	 */
	boolean isUnique();

	/**
	 * Return the dynamic (overloaded) implementation of the staticOperation applicable to the types managed
	 * by the given Standard Library.
	 */
	@NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	@NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation);

} // Class
