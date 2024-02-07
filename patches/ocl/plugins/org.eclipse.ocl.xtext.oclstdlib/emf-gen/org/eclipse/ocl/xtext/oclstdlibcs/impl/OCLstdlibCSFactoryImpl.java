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

package org.eclipse.ocl.xtext.oclstdlibcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLstdlibCSFactoryImpl
extends EFactoryImpl
implements OCLstdlibCSFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLstdlibCSFactory init() {
		try
		{
			OCLstdlibCSFactory theOCLstdlibCSFactory = (OCLstdlibCSFactory)EPackage.Registry.INSTANCE.getEFactory(OCLstdlibCSPackage.eNS_URI);
			if (theOCLstdlibCSFactory != null)
			{
				return theOCLstdlibCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLstdlibCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case 0: return createJavaClassCS();
			case 2: return createLibClassCS();
			case 3: return createLibCoercionCS();
			case 4: return createLibConstraintCS();
			case 5: return createLibIterationCS();
			case 6: return createLibOperationCS();
			case 7: return createLibOppositeCS();
			case 8: return createLibPackageCS();
			case 9: return createLibPropertyCS();
			case 10: return createLibRootPackageCS();
			case 11: return createMetaclassNameCS();
			case 12: return createPrecedenceCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull JavaClassCS createJavaClassCS()
	{
		JavaClassCSImpl javaClassCS = new JavaClassCSImpl();
		return javaClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibClassCS createLibClassCS() {
		LibClassCSImpl libClassCS = new LibClassCSImpl();
		return libClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibCoercionCS createLibCoercionCS()
	{
		LibCoercionCSImpl libCoercionCS = new LibCoercionCSImpl();
		return libCoercionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibConstraintCS createLibConstraintCS() {
		LibConstraintCSImpl libConstraintCS = new LibConstraintCSImpl();
		return libConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibIterationCS createLibIterationCS() {
		LibIterationCSImpl libIterationCS = new LibIterationCSImpl();
		return libIterationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibOperationCS createLibOperationCS() {
		LibOperationCSImpl libOperationCS = new LibOperationCSImpl();
		return libOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibOppositeCS createLibOppositeCS()
	{
		LibOppositeCSImpl libOppositeCS = new LibOppositeCSImpl();
		return libOppositeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibPackageCS createLibPackageCS()
	{
		LibPackageCSImpl libPackageCS = new LibPackageCSImpl();
		return libPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibPropertyCS createLibPropertyCS() {
		LibPropertyCSImpl libPropertyCS = new LibPropertyCSImpl();
		return libPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LibRootPackageCS createLibRootPackageCS()
	{
		LibRootPackageCSImpl libRootPackageCS = new LibRootPackageCSImpl();
		return libRootPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MetaclassNameCS createMetaclassNameCS()
	{
		MetaclassNameCSImpl metaclassNameCS = new MetaclassNameCSImpl();
		return metaclassNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PrecedenceCS createPrecedenceCS() {
		PrecedenceCSImpl precedenceCS = new PrecedenceCSImpl();
		return precedenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLstdlibCSPackage getOCLstdlibCSPackage()
	{
		return (OCLstdlibCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLstdlibCSPackage getPackage() {
		return OCLstdlibCSPackage.eINSTANCE;
	}

} //OCLstdlibCSFactoryImpl
