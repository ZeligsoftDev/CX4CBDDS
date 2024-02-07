/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.FeatureCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.oclstdlibcs.*;

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
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage
 * @generated
 */
public class OCLstdlibCSSwitch<@Nullable T>
		extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCLstdlibCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSSwitch() {
		if (modelPackage == null)
		{
			modelPackage = OCLstdlibCSPackage.eINSTANCE;
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
		switch (classifierID)
		{
			case 0:
			{
				JavaClassCS javaClassCS = (JavaClassCS)theEObject;
				T result = caseJavaClassCS(javaClassCS);
				if (result == null) result = caseNamedElementCS(javaClassCS);
				if (result == null) result = caseModelElementCS(javaClassCS);
				if (result == null) result = casePivotableElementCS(javaClassCS);
				if (result == null) result = caseElementCS(javaClassCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1:
			{
				JavaImplementationCS javaImplementationCS = (JavaImplementationCS)theEObject;
				T result = caseJavaImplementationCS(javaImplementationCS);
				if (result == null) result = caseElementCS(javaImplementationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2:
			{
				LibClassCS libClassCS = (LibClassCS)theEObject;
				T result = caseLibClassCS(libClassCS);
				if (result == null) result = caseStructuredClassCS(libClassCS);
				if (result == null) result = caseJavaImplementationCS(libClassCS);
				if (result == null) result = caseClassCS(libClassCS);
				if (result == null) result = caseNamespaceCS(libClassCS);
				if (result == null) result = caseNamedElementCS(libClassCS);
				if (result == null) result = caseTypeCS(libClassCS);
				if (result == null) result = caseTemplateableElementCS(libClassCS);
				if (result == null) result = caseModelElementCS(libClassCS);
				if (result == null) result = casePivotableElementCS(libClassCS);
				if (result == null) result = caseElementCS(libClassCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3:
			{
				LibCoercionCS libCoercionCS = (LibCoercionCS)theEObject;
				T result = caseLibCoercionCS(libCoercionCS);
				if (result == null) result = caseOperationCS(libCoercionCS);
				if (result == null) result = caseJavaImplementationCS(libCoercionCS);
				if (result == null) result = caseFeatureCS(libCoercionCS);
				if (result == null) result = caseTemplateableElementCS(libCoercionCS);
				if (result == null) result = caseTypedElementCS(libCoercionCS);
				if (result == null) result = caseNamedElementCS(libCoercionCS);
				if (result == null) result = caseModelElementCS(libCoercionCS);
				if (result == null) result = casePivotableElementCS(libCoercionCS);
				if (result == null) result = caseElementCS(libCoercionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4:
			{
				LibConstraintCS libConstraintCS = (LibConstraintCS)theEObject;
				T result = caseLibConstraintCS(libConstraintCS);
				if (result == null) result = caseConstraintCS(libConstraintCS);
				if (result == null) result = caseNamedElementCS(libConstraintCS);
				if (result == null) result = caseModelElementCS(libConstraintCS);
				if (result == null) result = casePivotableElementCS(libConstraintCS);
				if (result == null) result = caseElementCS(libConstraintCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5:
			{
				LibIterationCS libIterationCS = (LibIterationCS)theEObject;
				T result = caseLibIterationCS(libIterationCS);
				if (result == null) result = caseOperationCS(libIterationCS);
				if (result == null) result = caseJavaImplementationCS(libIterationCS);
				if (result == null) result = caseFeatureCS(libIterationCS);
				if (result == null) result = caseTemplateableElementCS(libIterationCS);
				if (result == null) result = caseTypedElementCS(libIterationCS);
				if (result == null) result = caseNamedElementCS(libIterationCS);
				if (result == null) result = caseModelElementCS(libIterationCS);
				if (result == null) result = casePivotableElementCS(libIterationCS);
				if (result == null) result = caseElementCS(libIterationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6:
			{
				LibOperationCS libOperationCS = (LibOperationCS)theEObject;
				T result = caseLibOperationCS(libOperationCS);
				if (result == null) result = caseOperationCS(libOperationCS);
				if (result == null) result = caseJavaImplementationCS(libOperationCS);
				if (result == null) result = caseFeatureCS(libOperationCS);
				if (result == null) result = caseTemplateableElementCS(libOperationCS);
				if (result == null) result = caseTypedElementCS(libOperationCS);
				if (result == null) result = caseNamedElementCS(libOperationCS);
				if (result == null) result = caseModelElementCS(libOperationCS);
				if (result == null) result = casePivotableElementCS(libOperationCS);
				if (result == null) result = caseElementCS(libOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7:
			{
				LibOppositeCS libOppositeCS = (LibOppositeCS)theEObject;
				T result = caseLibOppositeCS(libOppositeCS);
				if (result == null) result = caseFeatureCS(libOppositeCS);
				if (result == null) result = caseTypedElementCS(libOppositeCS);
				if (result == null) result = caseNamedElementCS(libOppositeCS);
				if (result == null) result = caseModelElementCS(libOppositeCS);
				if (result == null) result = casePivotableElementCS(libOppositeCS);
				if (result == null) result = caseElementCS(libOppositeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8:
			{
				LibPackageCS libPackageCS = (LibPackageCS)theEObject;
				T result = caseLibPackageCS(libPackageCS);
				if (result == null) result = casePackageCS(libPackageCS);
				if (result == null) result = casePackageOwnerCS(libPackageCS);
				if (result == null) result = caseNamespaceCS(libPackageCS);
				if (result == null) result = caseNamedElementCS(libPackageCS);
				if (result == null) result = caseModelElementCS(libPackageCS);
				if (result == null) result = casePivotableElementCS(libPackageCS);
				if (result == null) result = caseElementCS(libPackageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9:
			{
				LibPropertyCS libPropertyCS = (LibPropertyCS)theEObject;
				T result = caseLibPropertyCS(libPropertyCS);
				if (result == null) result = caseAttributeCS(libPropertyCS);
				if (result == null) result = caseJavaImplementationCS(libPropertyCS);
				if (result == null) result = caseStructuralFeatureCS(libPropertyCS);
				if (result == null) result = caseFeatureCS(libPropertyCS);
				if (result == null) result = caseTypedElementCS(libPropertyCS);
				if (result == null) result = caseNamedElementCS(libPropertyCS);
				if (result == null) result = caseModelElementCS(libPropertyCS);
				if (result == null) result = casePivotableElementCS(libPropertyCS);
				if (result == null) result = caseElementCS(libPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10:
			{
				LibRootPackageCS libRootPackageCS = (LibRootPackageCS)theEObject;
				T result = caseLibRootPackageCS(libRootPackageCS);
				if (result == null) result = caseRootPackageCS(libRootPackageCS);
				if (result == null) result = casePackageOwnerCS(libRootPackageCS);
				if (result == null) result = caseRootCS(libRootPackageCS);
				if (result == null) result = caseModelElementCS(libRootPackageCS);
				if (result == null) result = casePivotableElementCS(libRootPackageCS);
				if (result == null) result = caseElementCS(libRootPackageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11:
			{
				MetaclassNameCS metaclassNameCS = (MetaclassNameCS)theEObject;
				T result = caseMetaclassNameCS(metaclassNameCS);
				if (result == null) result = caseElementCS(metaclassNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12:
			{
				PrecedenceCS precedenceCS = (PrecedenceCS)theEObject;
				T result = casePrecedenceCS(precedenceCS);
				if (result == null) result = caseNamedElementCS(precedenceCS);
				if (result == null) result = caseModelElementCS(precedenceCS);
				if (result == null) result = casePivotableElementCS(precedenceCS);
				if (result == null) result = caseElementCS(precedenceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaClassCS(JavaClassCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibClassCS(LibClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Coercion CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Coercion CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibCoercionCS(LibCoercionCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibConstraintCS(LibConstraintCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Iteration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Iteration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibIterationCS(LibIterationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibOperationCS(LibOperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Opposite CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Opposite CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibOppositeCS(LibOppositeCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibPackageCS(LibPackageCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibPropertyCS(LibPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lib Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lib Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibRootPackageCS(LibRootPackageCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metaclass Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metaclass Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaclassNameCS(MetaclassNameCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Implementation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Implementation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaImplementationCS(JavaImplementationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precedence CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precedence CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrecedenceCS(PrecedenceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotableElementCS(PivotableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElementCS(TemplateableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassCS(ClassCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementCS(TypedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCS(FeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCS(OperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Owner CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Owner CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageOwnerCS(PackageOwnerCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralFeatureCS(StructuralFeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeCS(AttributeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootPackageCS(RootPackageCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceCS(NamespaceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredClassCS(StructuredClassCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintCS(ConstraintCS object) {
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

} //OCLstdlibCSSwitch
