/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.annotations.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.annotations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage
 * @generated
 */
public class PivotAnnotationsSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PivotAnnotationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotAnnotationsSwitch() {
		if (modelPackage == null) {
			modelPackage = PivotAnnotationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case 0: {
				ASLibrary_EPackage asLibrary_EPackage = (ASLibrary_EPackage)theEObject;
				T result = caseASLibrary_EPackage(asLibrary_EPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				ASMetamodel_EPackage asMetamodel_EPackage = (ASMetamodel_EPackage)theEObject;
				T result = caseASMetamodel_EPackage(asMetamodel_EPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				Collection_EClass collection_EClass = (Collection_EClass)theEObject;
				T result = caseCollection_EClass(collection_EClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				Collection_EPackage collection_EPackage = (Collection_EPackage)theEObject;
				T result = caseCollection_EPackage(collection_EPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				Collection_ETypedElement collection_ETypedElement = (Collection_ETypedElement)theEObject;
				T result = caseCollection_ETypedElement(collection_ETypedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				Ecore_OCL_EClassifier ecore_OCL_EClassifier = (Ecore_OCL_EClassifier)theEObject;
				T result = caseEcore_OCL_EClassifier(ecore_OCL_EClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				Ecore_OCL_EOperation ecore_OCL_EOperation = (Ecore_OCL_EOperation)theEObject;
				T result = caseEcore_OCL_EOperation(ecore_OCL_EOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				Ecore_OCL_EStructuralFeature ecore_OCL_EStructuralFeature = (Ecore_OCL_EStructuralFeature)theEObject;
				T result = caseEcore_OCL_EStructuralFeature(ecore_OCL_EStructuralFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				Import_EPackage import_EPackage = (Import_EPackage)theEObject;
				T result = caseImport_EPackage(import_EPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				MetaAnnotation_EAnnotation metaAnnotation_EAnnotation = (MetaAnnotation_EAnnotation)theEObject;
				T result = caseMetaAnnotation_EAnnotation(metaAnnotation_EAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AS Library EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AS Library EPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseASLibrary_EPackage(ASLibrary_EPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AS Metamodel EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AS Metamodel EPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseASMetamodel_EPackage(ASMetamodel_EPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollection_EClass(Collection_EClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection EPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollection_EPackage(Collection_EPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection ETyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection ETyped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollection_ETypedElement(Collection_ETypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore OCL EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore OCL EClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcore_OCL_EClassifier(Ecore_OCL_EClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore OCL EOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore OCL EOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcore_OCL_EOperation(Ecore_OCL_EOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore OCL EStructural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore OCL EStructural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcore_OCL_EStructuralFeature(Ecore_OCL_EStructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import EPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport_EPackage(Import_EPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Annotation EAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Annotation EAnnotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaAnnotation_EAnnotation(MetaAnnotation_EAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnnotationsSwitch
