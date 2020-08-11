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
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import com.zeligsoft.ddk.zdl.zdlgen.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ZDLGenFactoryImpl extends EFactoryImpl implements ZDLGenFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ZDLGenFactory init() {
		try {
			ZDLGenFactory theZDLGenFactory = (ZDLGenFactory) EPackage.Registry.INSTANCE
					.getEFactory(ZDLGenPackage.eNS_URI);
			if (theZDLGenFactory != null) {
				return theZDLGenFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ZDLGenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZDLGenFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ZDLGenPackage.GEN_MODEL:
			return createGenModel();
		case ZDLGenPackage.GEN_DOMAIN_MODEL:
			return createGenDomainModel();
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE:
			return createGenDomainPackage();
		case ZDLGenPackage.GEN_PALETTE:
			return createGenPalette();
		case ZDLGenPackage.GEN_PALETTE_DRAWER:
			return createGenPaletteDrawer();
		case ZDLGenPackage.GEN_MENU_MODEL:
			return createGenMenuModel();
		case ZDLGenPackage.GEN_UML_MENU:
			return createGenUMLMenu();
		case ZDLGenPackage.GEN_MENU:
			return createGenMenu();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK:
			return createGenDomainBlock();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_IMPORT:
			return createGenDomainBlockImport();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_MERGE:
			return createGenDomainBlockMerge();
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION:
			return createGenDomainGeneralization();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT:
			return createGenDomainConcept();
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE:
			return createGenDomainReference();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE:
			return createGenDomainAttribute();
		case ZDLGenPackage.GEN_DOMAIN_DATA_TYPE:
			return createGenDomainDataType();
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE:
			return createGenAttributeOverride();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE:
			return createGenDomainBlockReference();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION:
			return createGenDomainSpecialization();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE:
			return createGenDomainModelLibraryReference();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY:
			return createGenDomainModelLibrary();
		case ZDLGenPackage.GEN_DOMAIN_ENUM:
			return createGenDomainEnum();
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL:
			return createGenDomainEnumLiteral();
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL:
			return createGenPaletteCreationTool();
		case ZDLGenPackage.GEN_PALETTE_STACK:
			return createGenPaletteStack();
		case ZDLGenPackage.OAW_EXPRESSION:
			return createOawExpression();
		case ZDLGenPackage.OAW_XTEND:
			return createOawXtend();
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION:
			return createGenMenuDelegateAction();
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION:
			return createGenMenuCreateAction();
		case ZDLGenPackage.GEN_MENU_SEPARATOR:
			return createGenMenuSeparator();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ZDLGenPackage.GEN_PALETTE_DIAGRAM_KIND:
			return createGenPaletteDiagramKindFromString(eDataType, initialValue);
		case ZDLGenPackage.GEN_ALL_DOMAIN_CASSIFIERS_MODE:
			return createGenAllDomainCassifiersModeFromString(eDataType, initialValue);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT_CATEGORY:
			return createGenDomainConceptCategoryFromString(eDataType, initialValue);
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION_KIND:
			return createGenDomainAttributePresentationKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ZDLGenPackage.GEN_PALETTE_DIAGRAM_KIND:
			return convertGenPaletteDiagramKindToString(eDataType, instanceValue);
		case ZDLGenPackage.GEN_ALL_DOMAIN_CASSIFIERS_MODE:
			return convertGenAllDomainCassifiersModeToString(eDataType, instanceValue);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT_CATEGORY:
			return convertGenDomainConceptCategoryToString(eDataType, instanceValue);
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION_KIND:
			return convertGenDomainAttributePresentationKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept createGenDomainConcept() {
		GenDomainConceptImpl genDomainConcept = new GenDomainConceptImpl();
		return genDomainConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainGeneralization createGenDomainGeneralization() {
		GenDomainGeneralizationImpl genDomainGeneralization = new GenDomainGeneralizationImpl();
		return genDomainGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlock createGenDomainBlock() {
		GenDomainBlockImpl genDomainBlock = new GenDomainBlockImpl();
		return genDomainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainAttribute createGenDomainAttribute() {
		GenDomainAttributeImpl genDomainAttribute = new GenDomainAttributeImpl();
		return genDomainAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainDataType createGenDomainDataType() {
		GenDomainDataTypeImpl genDomainDataType = new GenDomainDataTypeImpl();
		return genDomainDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenAttributeOverride createGenAttributeOverride() {
		GenAttributeOverrideImpl genAttributeOverride = new GenAttributeOverrideImpl();
		return genAttributeOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenu createGenMenu() {
		GenMenuImpl genMenu = new GenMenuImpl();
		return genMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlockImport createGenDomainBlockImport() {
		GenDomainBlockImportImpl genDomainBlockImport = new GenDomainBlockImportImpl();
		return genDomainBlockImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlockMerge createGenDomainBlockMerge() {
		GenDomainBlockMergeImpl genDomainBlockMerge = new GenDomainBlockMergeImpl();
		return genDomainBlockMerge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPalette createGenPalette() {
		GenPaletteImpl genPalette = new GenPaletteImpl();
		return genPalette;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer createGenPaletteDrawer() {
		GenPaletteDrawerImpl genPaletteDrawer = new GenPaletteDrawerImpl();
		return genPaletteDrawer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuModel createGenMenuModel() {
		GenMenuModelImpl genMenuModel = new GenMenuModelImpl();
		return genMenuModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenUMLMenu createGenUMLMenu() {
		GenUMLMenuImpl genUMLMenu = new GenUMLMenuImpl();
		return genUMLMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainBlockReference createGenDomainBlockReference() {
		GenDomainBlockReferenceImpl genDomainBlockReference = new GenDomainBlockReferenceImpl();
		return genDomainBlockReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainEnum createGenDomainEnum() {
		GenDomainEnumImpl genDomainEnum = new GenDomainEnumImpl();
		return genDomainEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainEnumLiteral createGenDomainEnumLiteral() {
		GenDomainEnumLiteralImpl genDomainEnumLiteral = new GenDomainEnumLiteralImpl();
		return genDomainEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteCreationTool createGenPaletteCreationTool() {
		GenPaletteCreationToolImpl genPaletteCreationTool = new GenPaletteCreationToolImpl();
		return genPaletteCreationTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteStack createGenPaletteStack() {
		GenPaletteStackImpl genPaletteStack = new GenPaletteStackImpl();
		return genPaletteStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OawExpression createOawExpression() {
		OawExpressionImpl oawExpression = new OawExpressionImpl();
		return oawExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OawXtend createOawXtend() {
		OawXtendImpl oawXtend = new OawXtendImpl();
		return oawXtend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuDelegateAction createGenMenuDelegateAction() {
		GenMenuDelegateActionImpl genMenuDelegateAction = new GenMenuDelegateActionImpl();
		return genMenuDelegateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuCreateAction createGenMenuCreateAction() {
		GenMenuCreateActionImpl genMenuCreateAction = new GenMenuCreateActionImpl();
		return genMenuCreateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenuSeparator createGenMenuSeparator() {
		GenMenuSeparatorImpl genMenuSeparator = new GenMenuSeparatorImpl();
		return genMenuSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteDiagramKind createGenPaletteDiagramKindFromString(EDataType eDataType, String initialValue) {
		GenPaletteDiagramKind result = GenPaletteDiagramKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenPaletteDiagramKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainReference createGenDomainReference() {
		GenDomainReferenceImpl genDomainReference = new GenDomainReferenceImpl();
		return genDomainReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainSpecialization createGenDomainSpecialization() {
		GenDomainSpecializationImpl genDomainSpecialization = new GenDomainSpecializationImpl();
		return genDomainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModelLibraryReference createGenDomainModelLibraryReference() {
		GenDomainModelLibraryReferenceImpl genDomainModelLibraryReference = new GenDomainModelLibraryReferenceImpl();
		return genDomainModelLibraryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModelLibrary createGenDomainModelLibrary() {
		GenDomainModelLibraryImpl genDomainModelLibrary = new GenDomainModelLibraryImpl();
		return genDomainModelLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModel createGenDomainModel() {
		GenDomainModelImpl genDomainModel = new GenDomainModelImpl();
		return genDomainModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenModel createGenModel() {
		GenModelImpl genModel = new GenModelImpl();
		return genModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainPackage createGenDomainPackage() {
		GenDomainPackageImpl genDomainPackage = new GenDomainPackageImpl();
		return genDomainPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConceptCategory createGenDomainConceptCategoryFromString(EDataType eDataType, String initialValue) {
		GenDomainConceptCategory result = GenDomainConceptCategory.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenDomainConceptCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainAttributePresentationKind createGenDomainAttributePresentationKindFromString(EDataType eDataType,
			String initialValue) {
		GenDomainAttributePresentationKind result = GenDomainAttributePresentationKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenDomainAttributePresentationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenAllDomainCassifiersMode createGenAllDomainCassifiersModeFromString(EDataType eDataType,
			String initialValue) {
		GenAllDomainCassifiersMode result = GenAllDomainCassifiersMode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenAllDomainCassifiersModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ZDLGenPackage getZDLGenPackage() {
		return (ZDLGenPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ZDLGenPackage getPackage() {
		return ZDLGenPackage.eINSTANCE;
	}

} //ZDLGenFactoryImpl
