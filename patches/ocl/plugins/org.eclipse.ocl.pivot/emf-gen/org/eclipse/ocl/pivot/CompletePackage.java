/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompletePackage#getPartialPackages <em>Partial Packages</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCompletePackage()
 * @generated
 */
public interface CompletePackage extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Owned Complete Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.CompleteClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * This is a logically derived collection. One CompleteClass for each distinctly named partial Class
	 * inv: ownedCompleteClasses->isUnique(name)
	 * inv: ownedCompleteClasses->forAll(name <> null)
	 * inv: ownedCompleteClasses->forAll(cc | cc.partialClasses = self.partialPackages.ownedClasses->select(name = cc.name))
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompletePackage_OwnedCompleteClasses()
	 * @see org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage
	 * @generated
	 */
	@NonNull List<CompleteClass> getOwnedCompleteClasses();

	/**
	 * Returns the value of the '<em><b>Owned Complete Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.CompletePackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompletePackage_OwnedCompletePackages()
	 * @generated NOT
	 */
	@NonNull List<CompletePackage> getOwnedCompletePackages();

	/**
	 * Returns the value of the '<em><b>Owning Complete Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #setOwningCompleteModel(CompleteModel)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompletePackage_OwningCompleteModel()
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages
	 * @generated
	 */
	CompleteModel getOwningCompleteModel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #getOwningCompleteModel()
	 * @generated
	 */
	void setOwningCompleteModel(CompleteModel value);

	/**
	 * Returns the value of the '<em><b>Partial Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Packages</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompletePackage_PartialPackages()
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.pivot.Package> getPartialPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteClass getOwnedCompleteClass(String name);

	@NonNull CompleteClass getCompleteClass(org.eclipse.ocl.pivot.@NonNull Class pivotType);


	org.eclipse.ocl.pivot.Package getPrimaryPackage();

	org.eclipse.ocl.pivot.Class getMemberType(String name);

	String getURI();

	String getNsPrefix();

	int getIndex(org.eclipse.ocl.pivot.Package p1);

	void assertSamePackage(org.eclipse.ocl.pivot.Package pivotPackage);

	@Nullable EPackage getEPackage();

	Type getType(String metatypeName);

	@Nullable CompletePackage getOwnedCompletePackage(@Nullable String name);

	@NonNull CompleteModel getCompleteModel();

	@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getAllClasses();
	@Nullable CompletePackage getOwningCompletePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #getOwningCompletePackage()
	 * @generated
	 */
	void setOwningCompletePackage(CompletePackage value);
}
