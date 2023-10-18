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
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSFactory
 * @model kind="package"
 * @generated
 */
public interface CompleteOCLCSPackage
extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "completeoclcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/CompleteOCLCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "completeoclcs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.xtext.completeocl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteOCLCSPackage eINSTANCE = org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPackageDeclarationCS()
	 * @generated
	 */
	int PACKAGE_DECLARATION_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.ContextDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getContextDeclCS()
	 * @generated
	 */
	int CONTEXT_DECL_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PropertyContextDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPropertyContextDeclCS()
	 * @generated
	 */
	int PROPERTY_CONTEXT_DECL_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getClassifierContextDeclCS()
	 * @generated
	 */
	int CLASSIFIER_CONTEXT_DECL_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl <em>Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefCS()
	 * @generated
	 */
	int DEF_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.OperationContextDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getOperationContextDeclCS()
	 * @generated
	 */
	int OPERATION_CONTEXT_DECL_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PathNameDeclCSImpl <em>Path Name Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PathNameDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPathNameDeclCS()
	 * @generated
	 */
	int PATH_NAME_DECL_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getCompleteOCLDocumentCS()
	 * @generated
	 */
	int COMPLETE_OCL_DOCUMENT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl <em>Def Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefOperationCS()
	 * @generated
	 */
	int DEF_OPERATION_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefPropertyCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefPropertyCS()
	 * @generated
	 */
	int DEF_PROPERTY_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.FeatureContextDeclCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getFeatureContextDeclCS()
	 * @generated
	 */
	int FEATURE_CONTEXT_DECL_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.OCLMessageArgCSImpl
	 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getOCLMessageArgCS()
	 * @generated
	 */
	int OCL_MESSAGE_ARG_CS = 7;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS <em>Feature Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Context Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS
	 * @generated
	 */
	EClass getFeatureContextDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS#getOwnedType()
	 * @see #getFeatureContextDeclCS()
	 * @generated
	 */
	EReference getFeatureContextDeclCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS <em>Package Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Declaration CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS
	 * @generated
	 */
	EClass getPackageDeclarationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getReferredPackage <em>Referred Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Package</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getReferredPackage()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_ReferredPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getOwnedContexts <em>Owned Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Contexts</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getOwnedContexts()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_OwnedContexts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getOwnedInvariants <em>Owned Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Invariants</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS#getOwnedInvariants()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_OwnedInvariants();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS <em>Path Name Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS
	 * @generated
	 */
	EClass getPathNameDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS#getOwnedPathName()
	 * @see #getPathNameDeclCS()
	 * @generated
	 */
	EReference getPathNameDeclCS_OwnedPathName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS <em>Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS
	 * @generated
	 */
	EClass getContextDeclCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS <em>Property Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Context Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS
	 * @generated
	 */
	EClass getPropertyContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getReferredProperty()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_ReferredProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDefaultExpressions <em>Owned Default Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Default Expressions</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDefaultExpressions()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_OwnedDefaultExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDerivedInvariants <em>Owned Derived Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Derived Invariants</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDerivedInvariants()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_OwnedDerivedInvariants();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompleteOCLCSFactory getCompleteOCLCSFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Context Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS
	 * @generated
	 */
	EClass getClassifierContextDeclCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Name</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getSelfName()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EAttribute getClassifierContextDeclCS_SelfName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getReferredClass()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_ReferredClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedInvariants <em>Owned Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Invariants</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedInvariants()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_OwnedInvariants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedDefinitions <em>Owned Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Definitions</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedDefinitions()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_OwnedDefinitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS <em>Complete OCL Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete OCL Document CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS
	 * @generated
	 */
	EClass getCompleteOCLDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedPackages()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_OwnedPackages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedContexts <em>Owned Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Contexts</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedContexts()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_OwnedContexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS <em>OCL Message Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Message Arg CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS
	 * @generated
	 */
	EClass getOCLMessageArgCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS <em>Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS
	 * @generated
	 */
	EClass getDefCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwningClassifierContextDecl <em>Owning Classifier Context Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Classifier Context Decl</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwningClassifierContextDecl()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_OwningClassifierContextDecl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwnedSpecification()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_OwnedSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS#isIsStatic()
	 * @see #getDefCS()
	 * @generated
	 */
	EAttribute getDefCS_IsStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.DefOperationCS <em>Def Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def Operation CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefOperationCS
	 * @generated
	 */
	EClass getDefOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.DefOperationCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefOperationCS#getOwnedParameters()
	 * @see #getDefOperationCS()
	 * @generated
	 */
	EReference getDefOperationCS_OwnedParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS <em>Def Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def Property CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS
	 * @generated
	 */
	EClass getDefPropertyCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Context Decl CS</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS
	 * @generated
	 */
	EClass getOperationContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getReferredOperation()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_ReferredOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedParameters()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedResult <em>Owned Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedResult()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_OwnedResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPreconditions <em>Owned Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Preconditions</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPreconditions()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_OwnedPreconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPostconditions <em>Owned Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Postconditions</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPostconditions()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_OwnedPostconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedBodies <em>Owned Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Bodies</em>'.
	 * @see org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedBodies()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_OwnedBodies();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.FeatureContextDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getFeatureContextDeclCS()
		 * @generated
		 */
		EClass FEATURE_CONTEXT_DECL_CS = eINSTANCE.getFeatureContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONTEXT_DECL_CS__OWNED_TYPE = eINSTANCE.getFeatureContextDeclCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PackageDeclarationCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPackageDeclarationCS()
		 * @generated
		 */
		EClass PACKAGE_DECLARATION_CS = eINSTANCE.getPackageDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Referred Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__REFERRED_PACKAGE = eINSTANCE.getPackageDeclarationCS_ReferredPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__OWNED_CONTEXTS = eINSTANCE.getPackageDeclarationCS_OwnedContexts();

		/**
		 * The meta object literal for the '<em><b>Owned Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__OWNED_INVARIANTS = eINSTANCE.getPackageDeclarationCS_OwnedInvariants();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PathNameDeclCSImpl <em>Path Name Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PathNameDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPathNameDeclCS()
		 * @generated
		 */
		EClass PATH_NAME_DECL_CS = eINSTANCE.getPathNameDeclCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_DECL_CS__OWNED_PATH_NAME = eINSTANCE.getPathNameDeclCS_OwnedPathName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.ContextDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getContextDeclCS()
		 * @generated
		 */
		EClass CONTEXT_DECL_CS = eINSTANCE.getContextDeclCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.PropertyContextDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getPropertyContextDeclCS()
		 * @generated
		 */
		EClass PROPERTY_CONTEXT_DECL_CS = eINSTANCE.getPropertyContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__REFERRED_PROPERTY = eINSTANCE.getPropertyContextDeclCS_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Default Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__OWNED_DEFAULT_EXPRESSIONS = eINSTANCE.getPropertyContextDeclCS_OwnedDefaultExpressions();

		/**
		 * The meta object literal for the '<em><b>Owned Derived Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__OWNED_DERIVED_INVARIANTS = eINSTANCE.getPropertyContextDeclCS_OwnedDerivedInvariants();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.ClassifierContextDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getClassifierContextDeclCS()
		 * @generated
		 */
		EClass CLASSIFIER_CONTEXT_DECL_CS = eINSTANCE.getClassifierContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = eINSTANCE.getClassifierContextDeclCS_SelfName();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__REFERRED_CLASS = eINSTANCE.getClassifierContextDeclCS_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Owned Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__OWNED_INVARIANTS = eINSTANCE.getClassifierContextDeclCS_OwnedInvariants();

		/**
		 * The meta object literal for the '<em><b>Owned Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__OWNED_DEFINITIONS = eINSTANCE.getClassifierContextDeclCS_OwnedDefinitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getCompleteOCLDocumentCS()
		 * @generated
		 */
		EClass COMPLETE_OCL_DOCUMENT_CS = eINSTANCE.getCompleteOCLDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES = eINSTANCE.getCompleteOCLDocumentCS_OwnedPackages();

		/**
		 * The meta object literal for the '<em><b>Owned Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS = eINSTANCE.getCompleteOCLDocumentCS_OwnedContexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl <em>Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefCS()
		 * @generated
		 */
		EClass DEF_CS = eINSTANCE.getDefCS();

		/**
		 * The meta object literal for the '<em><b>Owning Classifier Context Decl</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__OWNING_CLASSIFIER_CONTEXT_DECL = eINSTANCE.getDefCS_OwningClassifierContextDecl();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__OWNED_SPECIFICATION = eINSTANCE.getDefCS_OwnedSpecification();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEF_CS__IS_STATIC = eINSTANCE.getDefCS_IsStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl <em>Def Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefOperationCS()
		 * @generated
		 */
		EClass DEF_OPERATION_CS = eINSTANCE.getDefOperationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_OPERATION_CS__OWNED_PARAMETERS = eINSTANCE.getDefOperationCS_OwnedParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.DefPropertyCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefPropertyCS()
		 * @generated
		 */
		EClass DEF_PROPERTY_CS = eINSTANCE.getDefPropertyCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.OperationContextDeclCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getOperationContextDeclCS()
		 * @generated
		 */
		EClass OPERATION_CONTEXT_DECL_CS = eINSTANCE.getOperationContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__REFERRED_OPERATION = eINSTANCE.getOperationContextDeclCS_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OWNED_PARAMETERS = eINSTANCE.getOperationContextDeclCS_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OWNED_RESULT = eINSTANCE.getOperationContextDeclCS_OwnedResult();

		/**
		 * The meta object literal for the '<em><b>Owned Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OWNED_PRECONDITIONS = eINSTANCE.getOperationContextDeclCS_OwnedPreconditions();

		/**
		 * The meta object literal for the '<em><b>Owned Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OWNED_POSTCONDITIONS = eINSTANCE.getOperationContextDeclCS_OwnedPostconditions();

		/**
		 * The meta object literal for the '<em><b>Owned Bodies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OWNED_BODIES = eINSTANCE.getOperationContextDeclCS_OwnedBodies();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.completeoclcs.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.OCLMessageArgCSImpl
		 * @see org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLCSPackageImpl#getOCLMessageArgCS()
		 * @generated
		 */
		EClass OCL_MESSAGE_ARG_CS = eINSTANCE.getOCLMessageArgCS();

	}

} //CompleteOCLCSPackage
