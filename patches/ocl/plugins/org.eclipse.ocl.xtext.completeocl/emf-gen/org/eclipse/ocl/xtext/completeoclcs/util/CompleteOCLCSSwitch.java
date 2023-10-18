/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.completeoclcs.*;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

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
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage
 * @generated
 */
public class CompleteOCLCSSwitch<@Nullable T>
		extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompleteOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSSwitch() {
		if (modelPackage == null)
		{
			modelPackage = CompleteOCLCSPackage.eINSTANCE;
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
				ClassifierContextDeclCS classifierContextDeclCS = (ClassifierContextDeclCS)theEObject;
				T result = caseClassifierContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseTemplateableElementCS(classifierContextDeclCS);
				if (result == null) result = casePathNameDeclCS(classifierContextDeclCS);
				if (result == null) result = caseModelElementCS(classifierContextDeclCS);
				if (result == null) result = casePivotableElementCS(classifierContextDeclCS);
				if (result == null) result = caseElementCS(classifierContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1:
			{
				CompleteOCLDocumentCS completeOCLDocumentCS = (CompleteOCLDocumentCS)theEObject;
				T result = caseCompleteOCLDocumentCS(completeOCLDocumentCS);
				if (result == null) result = caseNamespaceCS(completeOCLDocumentCS);
				if (result == null) result = caseRootCS(completeOCLDocumentCS);
				if (result == null) result = caseNamedElementCS(completeOCLDocumentCS);
				if (result == null) result = caseModelElementCS(completeOCLDocumentCS);
				if (result == null) result = casePivotableElementCS(completeOCLDocumentCS);
				if (result == null) result = caseElementCS(completeOCLDocumentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2:
			{
				ContextDeclCS contextDeclCS = (ContextDeclCS)theEObject;
				T result = caseContextDeclCS(contextDeclCS);
				if (result == null) result = casePathNameDeclCS(contextDeclCS);
				if (result == null) result = caseModelElementCS(contextDeclCS);
				if (result == null) result = casePivotableElementCS(contextDeclCS);
				if (result == null) result = caseElementCS(contextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3:
			{
				DefCS defCS = (DefCS)theEObject;
				T result = caseDefCS(defCS);
				if (result == null) result = caseTypedElementCS(defCS);
				if (result == null) result = caseNamedElementCS(defCS);
				if (result == null) result = caseModelElementCS(defCS);
				if (result == null) result = casePivotableElementCS(defCS);
				if (result == null) result = caseElementCS(defCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4:
			{
				DefOperationCS defOperationCS = (DefOperationCS)theEObject;
				T result = caseDefOperationCS(defOperationCS);
				if (result == null) result = caseDefCS(defOperationCS);
				if (result == null) result = caseTemplateableElementCS(defOperationCS);
				if (result == null) result = caseTypedElementCS(defOperationCS);
				if (result == null) result = caseNamedElementCS(defOperationCS);
				if (result == null) result = caseModelElementCS(defOperationCS);
				if (result == null) result = casePivotableElementCS(defOperationCS);
				if (result == null) result = caseElementCS(defOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5:
			{
				DefPropertyCS defPropertyCS = (DefPropertyCS)theEObject;
				T result = caseDefPropertyCS(defPropertyCS);
				if (result == null) result = caseDefCS(defPropertyCS);
				if (result == null) result = caseTypedElementCS(defPropertyCS);
				if (result == null) result = caseNamedElementCS(defPropertyCS);
				if (result == null) result = caseModelElementCS(defPropertyCS);
				if (result == null) result = casePivotableElementCS(defPropertyCS);
				if (result == null) result = caseElementCS(defPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6:
			{
				FeatureContextDeclCS featureContextDeclCS = (FeatureContextDeclCS)theEObject;
				T result = caseFeatureContextDeclCS(featureContextDeclCS);
				if (result == null) result = caseContextDeclCS(featureContextDeclCS);
				if (result == null) result = casePathNameDeclCS(featureContextDeclCS);
				if (result == null) result = caseModelElementCS(featureContextDeclCS);
				if (result == null) result = casePivotableElementCS(featureContextDeclCS);
				if (result == null) result = caseElementCS(featureContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7:
			{
				OCLMessageArgCS oclMessageArgCS = (OCLMessageArgCS)theEObject;
				T result = caseOCLMessageArgCS(oclMessageArgCS);
				if (result == null) result = caseExpCS(oclMessageArgCS);
				if (result == null) result = caseModelElementCS(oclMessageArgCS);
				if (result == null) result = casePivotableElementCS(oclMessageArgCS);
				if (result == null) result = caseElementCS(oclMessageArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8:
			{
				OperationContextDeclCS operationContextDeclCS = (OperationContextDeclCS)theEObject;
				T result = caseOperationContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseFeatureContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseTemplateableElementCS(operationContextDeclCS);
				if (result == null) result = caseContextDeclCS(operationContextDeclCS);
				if (result == null) result = casePathNameDeclCS(operationContextDeclCS);
				if (result == null) result = caseModelElementCS(operationContextDeclCS);
				if (result == null) result = casePivotableElementCS(operationContextDeclCS);
				if (result == null) result = caseElementCS(operationContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9:
			{
				PackageDeclarationCS packageDeclarationCS = (PackageDeclarationCS)theEObject;
				T result = casePackageDeclarationCS(packageDeclarationCS);
				if (result == null) result = casePathNameDeclCS(packageDeclarationCS);
				if (result == null) result = caseModelElementCS(packageDeclarationCS);
				if (result == null) result = casePivotableElementCS(packageDeclarationCS);
				if (result == null) result = caseElementCS(packageDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10:
			{
				PathNameDeclCS pathNameDeclCS = (PathNameDeclCS)theEObject;
				T result = casePathNameDeclCS(pathNameDeclCS);
				if (result == null) result = caseModelElementCS(pathNameDeclCS);
				if (result == null) result = casePivotableElementCS(pathNameDeclCS);
				if (result == null) result = caseElementCS(pathNameDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11:
			{
				PropertyContextDeclCS propertyContextDeclCS = (PropertyContextDeclCS)theEObject;
				T result = casePropertyContextDeclCS(propertyContextDeclCS);
				if (result == null) result = caseFeatureContextDeclCS(propertyContextDeclCS);
				if (result == null) result = caseContextDeclCS(propertyContextDeclCS);
				if (result == null) result = casePathNameDeclCS(propertyContextDeclCS);
				if (result == null) result = caseModelElementCS(propertyContextDeclCS);
				if (result == null) result = casePivotableElementCS(propertyContextDeclCS);
				if (result == null) result = caseElementCS(propertyContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierContextDeclCS(ClassifierContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete OCL Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete OCL Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteOCLDocumentCS(CompleteOCLDocumentCS object) {
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
	public T caseTemplateableElementCS(TemplateableElementCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextDeclCS(ContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefCS(DefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Def Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefOperationCS(DefOperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Def Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefPropertyCS(DefPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureContextDeclCS(FeatureContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Message Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Message Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLMessageArgCS(OCLMessageArgCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationContextDeclCS(OperationContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageDeclarationCS(PackageDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathNameDeclCS(PathNameDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyContextDeclCS(PropertyContextDeclCS object) {
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
	public T caseRootCS(RootCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
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

} //CompleteOCLCSSwitch
