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
package com.zeligsoft.ddk.zdl.zdlgen.util;

import com.zeligsoft.ddk.zdl.zdlgen.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

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
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage
 * @generated
 */
public class ZDLGenSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ZDLGenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZDLGenSwitch() {
		if (modelPackage == null) {
			modelPackage = ZDLGenPackage.eINSTANCE;
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
		case ZDLGenPackage.GEN_DOMAIN_CLASSIFIER: {
			GenDomainClassifier genDomainClassifier = (GenDomainClassifier) theEObject;
			T result = caseGenDomainClassifier(genDomainClassifier);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainClassifier);
			if (result == null)
				result = caseGenDomainObject(genDomainClassifier);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_NAMED_ELEMENT: {
			GenDomainNamedElement genDomainNamedElement = (GenDomainNamedElement) theEObject;
			T result = caseGenDomainNamedElement(genDomainNamedElement);
			if (result == null)
				result = caseGenDomainObject(genDomainNamedElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_OBJECT: {
			GenDomainObject genDomainObject = (GenDomainObject) theEObject;
			T result = caseGenDomainObject(genDomainObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MODEL: {
			GenModel genModel = (GenModel) theEObject;
			T result = caseGenModel(genModel);
			if (result == null)
				result = caseGenDomainObject(genModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_MODEL: {
			GenDomainModel genDomainModel = (GenDomainModel) theEObject;
			T result = caseGenDomainModel(genDomainModel);
			if (result == null)
				result = caseGenDomainPackage(genDomainModel);
			if (result == null)
				result = caseGenDomainPackageableElement(genDomainModel);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainModel);
			if (result == null)
				result = caseGenDomainObject(genDomainModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE: {
			GenDomainPackage genDomainPackage = (GenDomainPackage) theEObject;
			T result = caseGenDomainPackage(genDomainPackage);
			if (result == null)
				result = caseGenDomainPackageableElement(genDomainPackage);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainPackage);
			if (result == null)
				result = caseGenDomainObject(genDomainPackage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_PACKAGEABLE_ELEMENT: {
			GenDomainPackageableElement genDomainPackageableElement = (GenDomainPackageableElement) theEObject;
			T result = caseGenDomainPackageableElement(genDomainPackageableElement);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainPackageableElement);
			if (result == null)
				result = caseGenDomainObject(genDomainPackageableElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE: {
			GenPalette genPalette = (GenPalette) theEObject;
			T result = caseGenPalette(genPalette);
			if (result == null)
				result = caseGenPaletteItem(genPalette);
			if (result == null)
				result = caseGenDomainObject(genPalette);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_ITEM: {
			GenPaletteItem genPaletteItem = (GenPaletteItem) theEObject;
			T result = caseGenPaletteItem(genPaletteItem);
			if (result == null)
				result = caseGenDomainObject(genPaletteItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_DRAWER: {
			GenPaletteDrawer genPaletteDrawer = (GenPaletteDrawer) theEObject;
			T result = caseGenPaletteDrawer(genPaletteDrawer);
			if (result == null)
				result = caseGenPaletteToolContainer(genPaletteDrawer);
			if (result == null)
				result = caseGenPaletteItem(genPaletteDrawer);
			if (result == null)
				result = caseGenDomainObject(genPaletteDrawer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER: {
			GenPaletteToolContainer genPaletteToolContainer = (GenPaletteToolContainer) theEObject;
			T result = caseGenPaletteToolContainer(genPaletteToolContainer);
			if (result == null)
				result = caseGenPaletteItem(genPaletteToolContainer);
			if (result == null)
				result = caseGenDomainObject(genPaletteToolContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_TOOL: {
			GenPaletteTool genPaletteTool = (GenPaletteTool) theEObject;
			T result = caseGenPaletteTool(genPaletteTool);
			if (result == null)
				result = caseGenPaletteItem(genPaletteTool);
			if (result == null)
				result = caseGenDomainObject(genPaletteTool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_MODEL: {
			GenMenuModel genMenuModel = (GenMenuModel) theEObject;
			T result = caseGenMenuModel(genMenuModel);
			if (result == null)
				result = caseGenDomainObject(genMenuModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_ITEM: {
			GenMenuItem genMenuItem = (GenMenuItem) theEObject;
			T result = caseGenMenuItem(genMenuItem);
			if (result == null)
				result = caseGenDomainObject(genMenuItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_UML_MENU: {
			GenUMLMenu genUMLMenu = (GenUMLMenu) theEObject;
			T result = caseGenUMLMenu(genUMLMenu);
			if (result == null)
				result = caseGenDomainObject(genUMLMenu);
			if (result == null)
				result = caseGenMenuTarget(genUMLMenu);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_TARGET: {
			GenMenuTarget genMenuTarget = (GenMenuTarget) theEObject;
			T result = caseGenMenuTarget(genMenuTarget);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU: {
			GenMenu genMenu = (GenMenu) theEObject;
			T result = caseGenMenu(genMenu);
			if (result == null)
				result = caseGenMenuItem(genMenu);
			if (result == null)
				result = caseGenDomainObject(genMenu);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_BLOCK: {
			GenDomainBlock genDomainBlock = (GenDomainBlock) theEObject;
			T result = caseGenDomainBlock(genDomainBlock);
			if (result == null)
				result = caseGenDomainPackageableElement(genDomainBlock);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainBlock);
			if (result == null)
				result = caseGenDomainObject(genDomainBlock);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_RELATION: {
			GenDomainBlockRelation genDomainBlockRelation = (GenDomainBlockRelation) theEObject;
			T result = caseGenDomainBlockRelation(genDomainBlockRelation);
			if (result == null)
				result = caseGenDomainObject(genDomainBlockRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_IMPORT: {
			GenDomainBlockImport genDomainBlockImport = (GenDomainBlockImport) theEObject;
			T result = caseGenDomainBlockImport(genDomainBlockImport);
			if (result == null)
				result = caseGenDomainBlockRelation(genDomainBlockImport);
			if (result == null)
				result = caseGenDomainObject(genDomainBlockImport);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_MERGE: {
			GenDomainBlockMerge genDomainBlockMerge = (GenDomainBlockMerge) theEObject;
			T result = caseGenDomainBlockMerge(genDomainBlockMerge);
			if (result == null)
				result = caseGenDomainBlockRelation(genDomainBlockMerge);
			if (result == null)
				result = caseGenDomainObject(genDomainBlockMerge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION: {
			GenDomainGeneralization genDomainGeneralization = (GenDomainGeneralization) theEObject;
			T result = caseGenDomainGeneralization(genDomainGeneralization);
			if (result == null)
				result = caseGenDomainObject(genDomainGeneralization);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT: {
			GenDomainConcept genDomainConcept = (GenDomainConcept) theEObject;
			T result = caseGenDomainConcept(genDomainConcept);
			if (result == null)
				result = caseGenDomainClassifier(genDomainConcept);
			if (result == null)
				result = caseGenMenuTarget(genDomainConcept);
			if (result == null)
				result = caseGenPalettable(genDomainConcept);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainConcept);
			if (result == null)
				result = caseGenDomainObject(genDomainConcept);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTABLE: {
			GenPalettable genPalettable = (GenPalettable) theEObject;
			T result = caseGenPalettable(genPalettable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE: {
			GenDomainStructuralFeature genDomainStructuralFeature = (GenDomainStructuralFeature) theEObject;
			T result = caseGenDomainStructuralFeature(genDomainStructuralFeature);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainStructuralFeature);
			if (result == null)
				result = caseGenDomainAttributePresentation(genDomainStructuralFeature);
			if (result == null)
				result = caseGenDomainObject(genDomainStructuralFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION: {
			GenDomainAttributePresentation genDomainAttributePresentation = (GenDomainAttributePresentation) theEObject;
			T result = caseGenDomainAttributePresentation(genDomainAttributePresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE: {
			GenDomainReference genDomainReference = (GenDomainReference) theEObject;
			T result = caseGenDomainReference(genDomainReference);
			if (result == null)
				result = caseGenDomainStructuralFeature(genDomainReference);
			if (result == null)
				result = caseGenPalettable(genDomainReference);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainReference);
			if (result == null)
				result = caseGenDomainAttributePresentation(genDomainReference);
			if (result == null)
				result = caseGenDomainObject(genDomainReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE: {
			GenDomainAttribute genDomainAttribute = (GenDomainAttribute) theEObject;
			T result = caseGenDomainAttribute(genDomainAttribute);
			if (result == null)
				result = caseGenDomainStructuralFeature(genDomainAttribute);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainAttribute);
			if (result == null)
				result = caseGenDomainAttributePresentation(genDomainAttribute);
			if (result == null)
				result = caseGenDomainObject(genDomainAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_DATA_TYPE: {
			GenDomainDataType genDomainDataType = (GenDomainDataType) theEObject;
			T result = caseGenDomainDataType(genDomainDataType);
			if (result == null)
				result = caseGenDomainClassifier(genDomainDataType);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainDataType);
			if (result == null)
				result = caseGenDomainObject(genDomainDataType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE: {
			GenAttributeOverride genAttributeOverride = (GenAttributeOverride) theEObject;
			T result = caseGenAttributeOverride(genAttributeOverride);
			if (result == null)
				result = caseGenDomainAttributePresentation(genAttributeOverride);
			if (result == null)
				result = caseGenDomainObject(genAttributeOverride);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE: {
			GenDomainBlockReference genDomainBlockReference = (GenDomainBlockReference) theEObject;
			T result = caseGenDomainBlockReference(genDomainBlockReference);
			if (result == null)
				result = caseGenDomainObject(genDomainBlockReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION: {
			GenDomainSpecialization genDomainSpecialization = (GenDomainSpecialization) theEObject;
			T result = caseGenDomainSpecialization(genDomainSpecialization);
			if (result == null)
				result = caseGenDomainPackageableElement(genDomainSpecialization);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainSpecialization);
			if (result == null)
				result = caseGenDomainObject(genDomainSpecialization);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE: {
			GenDomainModelLibraryReference genDomainModelLibraryReference = (GenDomainModelLibraryReference) theEObject;
			T result = caseGenDomainModelLibraryReference(genDomainModelLibraryReference);
			if (result == null)
				result = caseGenDomainObject(genDomainModelLibraryReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY: {
			GenDomainModelLibrary genDomainModelLibrary = (GenDomainModelLibrary) theEObject;
			T result = caseGenDomainModelLibrary(genDomainModelLibrary);
			if (result == null)
				result = caseGenDomainPackageableElement(genDomainModelLibrary);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainModelLibrary);
			if (result == null)
				result = caseGenDomainObject(genDomainModelLibrary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_ENUM: {
			GenDomainEnum genDomainEnum = (GenDomainEnum) theEObject;
			T result = caseGenDomainEnum(genDomainEnum);
			if (result == null)
				result = caseGenDomainDataType(genDomainEnum);
			if (result == null)
				result = caseGenDomainClassifier(genDomainEnum);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainEnum);
			if (result == null)
				result = caseGenDomainObject(genDomainEnum);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL: {
			GenDomainEnumLiteral genDomainEnumLiteral = (GenDomainEnumLiteral) theEObject;
			T result = caseGenDomainEnumLiteral(genDomainEnumLiteral);
			if (result == null)
				result = caseGenDomainNamedElement(genDomainEnumLiteral);
			if (result == null)
				result = caseGenDomainObject(genDomainEnumLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL: {
			GenPaletteCreationTool genPaletteCreationTool = (GenPaletteCreationTool) theEObject;
			T result = caseGenPaletteCreationTool(genPaletteCreationTool);
			if (result == null)
				result = caseGenPaletteTool(genPaletteCreationTool);
			if (result == null)
				result = caseGenPaletteItem(genPaletteCreationTool);
			if (result == null)
				result = caseGenDomainObject(genPaletteCreationTool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.EXPRESSION: {
			Expression expression = (Expression) theEObject;
			T result = caseExpression(expression);
			if (result == null)
				result = caseGenDomainObject(expression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_PALETTE_STACK: {
			GenPaletteStack genPaletteStack = (GenPaletteStack) theEObject;
			T result = caseGenPaletteStack(genPaletteStack);
			if (result == null)
				result = caseGenPaletteToolContainer(genPaletteStack);
			if (result == null)
				result = caseGenPaletteTool(genPaletteStack);
			if (result == null)
				result = caseGenPaletteItem(genPaletteStack);
			if (result == null)
				result = caseGenDomainObject(genPaletteStack);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.OAW_EXPRESSION: {
			OawExpression oawExpression = (OawExpression) theEObject;
			T result = caseOawExpression(oawExpression);
			if (result == null)
				result = caseExpression(oawExpression);
			if (result == null)
				result = caseGenDomainObject(oawExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.OAW_XTEND: {
			OawXtend oawXtend = (OawXtend) theEObject;
			T result = caseOawXtend(oawXtend);
			if (result == null)
				result = caseExpression(oawXtend);
			if (result == null)
				result = caseGenDomainObject(oawXtend);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_ACTION: {
			GenMenuAction genMenuAction = (GenMenuAction) theEObject;
			T result = caseGenMenuAction(genMenuAction);
			if (result == null)
				result = caseGenMenuItem(genMenuAction);
			if (result == null)
				result = caseGenDomainObject(genMenuAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION: {
			GenMenuDelegateAction genMenuDelegateAction = (GenMenuDelegateAction) theEObject;
			T result = caseGenMenuDelegateAction(genMenuDelegateAction);
			if (result == null)
				result = caseGenMenuAction(genMenuDelegateAction);
			if (result == null)
				result = caseGenMenuItem(genMenuDelegateAction);
			if (result == null)
				result = caseGenDomainObject(genMenuDelegateAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION: {
			GenMenuCreateAction genMenuCreateAction = (GenMenuCreateAction) theEObject;
			T result = caseGenMenuCreateAction(genMenuCreateAction);
			if (result == null)
				result = caseGenMenuAction(genMenuCreateAction);
			if (result == null)
				result = caseGenMenuItem(genMenuCreateAction);
			if (result == null)
				result = caseGenDomainObject(genMenuCreateAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ZDLGenPackage.GEN_MENU_SEPARATOR: {
			GenMenuSeparator genMenuSeparator = (GenMenuSeparator) theEObject;
			T result = caseGenMenuSeparator(genMenuSeparator);
			if (result == null)
				result = caseGenMenuItem(genMenuSeparator);
			if (result == null)
				result = caseGenDomainObject(genMenuSeparator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainConcept(GenDomainConcept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palettable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palettable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPalettable(GenPalettable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteItem(GenPaletteItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainClassifier(GenDomainClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainNamedElement(GenDomainNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Structural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Structural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainStructuralFeature(GenDomainStructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Generalization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainGeneralization(GenDomainGeneralization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainBlock(GenDomainBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainObject(GenDomainObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Block Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Block Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainBlockRelation(GenDomainBlockRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainAttribute(GenDomainAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainDataType(GenDomainDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Attribute Override</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Attribute Override</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenAttributeOverride(GenAttributeOverride object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenu(GenMenu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuItem(GenMenuItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen UML Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen UML Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenUMLMenu(GenUMLMenu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuTarget(GenMenuTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Block Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Block Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainBlockImport(GenDomainBlockImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Block Merge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Block Merge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainBlockMerge(GenDomainBlockMerge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPalette(GenPalette object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Drawer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Drawer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteDrawer(GenPaletteDrawer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Tool Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Tool Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteToolContainer(GenPaletteToolContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteTool(GenPaletteTool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuModel(GenMenuModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Block Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Block Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainBlockReference(GenDomainBlockReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainEnum(GenDomainEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainEnumLiteral(GenDomainEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Creation Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Creation Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteCreationTool(GenPaletteCreationTool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Palette Stack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Palette Stack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPaletteStack(GenPaletteStack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Oaw Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Oaw Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOawExpression(OawExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Oaw Xtend</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Oaw Xtend</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOawXtend(OawXtend object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuAction(GenMenuAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Delegate Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Delegate Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuDelegateAction(GenMenuDelegateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Create Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Create Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuCreateAction(GenMenuCreateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Menu Separator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Menu Separator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMenuSeparator(GenMenuSeparator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainReference(GenDomainReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Attribute Presentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Attribute Presentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainAttributePresentation(GenDomainAttributePresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Specialization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Specialization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainSpecialization(GenDomainSpecialization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Model Library Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Model Library Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainModelLibraryReference(GenDomainModelLibraryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Model Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Model Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainModelLibrary(GenDomainModelLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainModel(GenDomainModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenModel(GenModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainPackageableElement(GenDomainPackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Domain Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Domain Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenDomainPackage(GenDomainPackage object) {
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

} //ZDLGenSwitch
