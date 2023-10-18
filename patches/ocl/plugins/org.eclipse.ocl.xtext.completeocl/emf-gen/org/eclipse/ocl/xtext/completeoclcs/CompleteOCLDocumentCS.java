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

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.RootCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CompleteOCLDocumentCS supports the entire Complete OCL Document that extends
 * referenced classes and packages with additional or complementary declarations .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedContexts <em>Owned Contexts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS()
 * @model
 * @generated
 */
public interface CompleteOCLDocumentCS
		extends NamespaceCS, RootCS {

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declarations that extend within the context of a referenced package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageDeclarationCS> getOwnedPackages();

	/**
	 * Returns the value of the '<em><b>Owned Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declarations that directly extend classes, operations or properties.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Contexts</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS_OwnedContexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextDeclCS> getOwnedContexts();

} // DocumentCS
