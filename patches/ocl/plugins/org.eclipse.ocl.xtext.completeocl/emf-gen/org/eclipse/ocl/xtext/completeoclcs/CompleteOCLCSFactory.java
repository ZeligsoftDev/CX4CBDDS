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
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage
 * @generated
 */
public interface CompleteOCLCSFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteOCLCSFactory eINSTANCE = org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Declaration CS</em>'.
	 * @generated
	 */
	PackageDeclarationCS createPackageDeclarationCS();

	/**
	 * Returns a new object of class '<em>Property Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Context Decl CS</em>'.
	 * @generated
	 */
	PropertyContextDeclCS createPropertyContextDeclCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompleteOCLCSPackage getCompleteOCLCSPackage();

	/**
	 * Returns a new object of class '<em>Classifier Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Context Decl CS</em>'.
	 * @generated
	 */
	ClassifierContextDeclCS createClassifierContextDeclCS();

	/**
	 * Returns a new object of class '<em>Complete OCL Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete OCL Document CS</em>'.
	 * @generated
	 */
	CompleteOCLDocumentCS createCompleteOCLDocumentCS();

	/**
	 * Returns a new object of class '<em>OCL Message Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Message Arg CS</em>'.
	 * @generated
	 */
	OCLMessageArgCS createOCLMessageArgCS();

	/**
	 * Returns a new object of class '<em>Def Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Def Operation CS</em>'.
	 * @generated
	 */
	DefOperationCS createDefOperationCS();

	/**
	 * Returns a new object of class '<em>Def Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Def Property CS</em>'.
	 * @generated
	 */
	DefPropertyCS createDefPropertyCS();

	/**
	 * Returns a new object of class '<em>Operation Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Context Decl CS</em>'.
	 * @generated
	 */
	OperationContextDeclCS createOperationContextDeclCS();

} //CompleteOCLCSFactory
