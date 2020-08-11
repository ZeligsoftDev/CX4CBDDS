/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage
 * @generated
 */
public interface ZDLGenFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ZDLGenFactory eINSTANCE = com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gen Domain Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Concept</em>'.
	 * @generated
	 */
	GenDomainConcept createGenDomainConcept();

	/**
	 * Returns a new object of class '<em>Gen Domain Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Generalization</em>'.
	 * @generated
	 */
	GenDomainGeneralization createGenDomainGeneralization();

	/**
	 * Returns a new object of class '<em>Gen Domain Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Block</em>'.
	 * @generated
	 */
	GenDomainBlock createGenDomainBlock();

	/**
	 * Returns a new object of class '<em>Gen Domain Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Attribute</em>'.
	 * @generated
	 */
	GenDomainAttribute createGenDomainAttribute();

	/**
	 * Returns a new object of class '<em>Gen Domain Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Data Type</em>'.
	 * @generated
	 */
	GenDomainDataType createGenDomainDataType();

	/**
	 * Returns a new object of class '<em>Gen Attribute Override</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Attribute Override</em>'.
	 * @generated
	 */
	GenAttributeOverride createGenAttributeOverride();

	/**
	 * Returns a new object of class '<em>Gen Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Menu</em>'.
	 * @generated
	 */
	GenMenu createGenMenu();

	/**
	 * Returns a new object of class '<em>Gen Domain Block Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Block Import</em>'.
	 * @generated
	 */
	GenDomainBlockImport createGenDomainBlockImport();

	/**
	 * Returns a new object of class '<em>Gen Domain Block Merge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Block Merge</em>'.
	 * @generated
	 */
	GenDomainBlockMerge createGenDomainBlockMerge();

	/**
	 * Returns a new object of class '<em>Gen Palette</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Palette</em>'.
	 * @generated
	 */
	GenPalette createGenPalette();

	/**
	 * Returns a new object of class '<em>Gen Palette Drawer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Palette Drawer</em>'.
	 * @generated
	 */
	GenPaletteDrawer createGenPaletteDrawer();

	/**
	 * Returns a new object of class '<em>Gen Menu Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Menu Model</em>'.
	 * @generated
	 */
	GenMenuModel createGenMenuModel();

	/**
	 * Returns a new object of class '<em>Gen UML Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen UML Menu</em>'.
	 * @generated
	 */
	GenUMLMenu createGenUMLMenu();

	/**
	 * Returns a new object of class '<em>Gen Domain Block Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Block Reference</em>'.
	 * @generated
	 */
	GenDomainBlockReference createGenDomainBlockReference();

	/**
	 * Returns a new object of class '<em>Gen Domain Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Enum</em>'.
	 * @generated
	 */
	GenDomainEnum createGenDomainEnum();

	/**
	 * Returns a new object of class '<em>Gen Domain Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Enum Literal</em>'.
	 * @generated
	 */
	GenDomainEnumLiteral createGenDomainEnumLiteral();

	/**
	 * Returns a new object of class '<em>Gen Palette Creation Tool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Palette Creation Tool</em>'.
	 * @generated
	 */
	GenPaletteCreationTool createGenPaletteCreationTool();

	/**
	 * Returns a new object of class '<em>Gen Palette Stack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Palette Stack</em>'.
	 * @generated
	 */
	GenPaletteStack createGenPaletteStack();

	/**
	 * Returns a new object of class '<em>Oaw Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Oaw Expression</em>'.
	 * @generated
	 */
	OawExpression createOawExpression();

	/**
	 * Returns a new object of class '<em>Oaw Xtend</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Oaw Xtend</em>'.
	 * @generated
	 */
	OawXtend createOawXtend();

	/**
	 * Returns a new object of class '<em>Gen Menu Delegate Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Menu Delegate Action</em>'.
	 * @generated
	 */
	GenMenuDelegateAction createGenMenuDelegateAction();

	/**
	 * Returns a new object of class '<em>Gen Menu Create Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Menu Create Action</em>'.
	 * @generated
	 */
	GenMenuCreateAction createGenMenuCreateAction();

	/**
	 * Returns a new object of class '<em>Gen Menu Separator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Menu Separator</em>'.
	 * @generated
	 */
	GenMenuSeparator createGenMenuSeparator();

	/**
	 * Returns a new object of class '<em>Gen Domain Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Reference</em>'.
	 * @generated
	 */
	GenDomainReference createGenDomainReference();

	/**
	 * Returns a new object of class '<em>Gen Domain Specialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Specialization</em>'.
	 * @generated
	 */
	GenDomainSpecialization createGenDomainSpecialization();

	/**
	 * Returns a new object of class '<em>Gen Domain Model Library Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Model Library Reference</em>'.
	 * @generated
	 */
	GenDomainModelLibraryReference createGenDomainModelLibraryReference();

	/**
	 * Returns a new object of class '<em>Gen Domain Model Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Model Library</em>'.
	 * @generated
	 */
	GenDomainModelLibrary createGenDomainModelLibrary();

	/**
	 * Returns a new object of class '<em>Gen Domain Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Model</em>'.
	 * @generated
	 */
	GenDomainModel createGenDomainModel();

	/**
	 * Returns a new object of class '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Model</em>'.
	 * @generated
	 */
	GenModel createGenModel();

	/**
	 * Returns a new object of class '<em>Gen Domain Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Domain Package</em>'.
	 * @generated
	 */
	GenDomainPackage createGenDomainPackage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ZDLGenPackage getZDLGenPackage();

} //ZDLGenFactory
