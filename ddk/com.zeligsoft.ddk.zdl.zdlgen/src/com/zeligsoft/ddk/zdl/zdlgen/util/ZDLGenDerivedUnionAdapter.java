/**
 * Copyright (c) 2008 Zeligsoft Inc.
 *
 * All rights reserved. 
 *  
 * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND
 * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, 
 * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,
 * IS STRICTLY PROHIBITED.
 *
 */
package com.zeligsoft.ddk.zdl.zdlgen.util;

import com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenu;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.OawExpression;
import com.zeligsoft.ddk.zdl.zdlgen.OawXtend;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An adapter that propagates notifications for derived unions.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage
 * @generated
 */
public class ZDLGenDerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ZDLGenPackage modelPackage;

	/**
	 * Creates an instance of the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZDLGenDerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = ZDLGenPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject) {
			EClass eClass = ((EObject) notifier).eClass();
			if (eClass.eContainer() == modelPackage) {
				notifyChanged(notification, eClass);
			}
		}
	}

	/**
	 * Calls <code>notifyXXXChanged</code> for the corresponding class of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyChanged(Notification notification, EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ZDLGenPackage.GEN_MODEL:
			notifyGenModelChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL:
			notifyGenDomainModelChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE:
			notifyGenDomainPackageChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_PALETTE:
			notifyGenPaletteChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_PALETTE_DRAWER:
			notifyGenPaletteDrawerChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_MENU_MODEL:
			notifyGenMenuModelChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_UML_MENU:
			notifyGenUMLMenuChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_MENU:
			notifyGenMenuChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK:
			notifyGenDomainBlockChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_IMPORT:
			notifyGenDomainBlockImportChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_MERGE:
			notifyGenDomainBlockMergeChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION:
			notifyGenDomainGeneralizationChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT:
			notifyGenDomainConceptChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE:
			notifyGenDomainReferenceChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE:
			notifyGenDomainAttributeChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_DATA_TYPE:
			notifyGenDomainDataTypeChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_ATTRIBUTE_OVERRIDE:
			notifyGenAttributeOverrideChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE:
			notifyGenDomainBlockReferenceChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION:
			notifyGenDomainSpecializationChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE:
			notifyGenDomainModelLibraryReferenceChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY:
			notifyGenDomainModelLibraryChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ENUM:
			notifyGenDomainEnumChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL:
			notifyGenDomainEnumLiteralChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL:
			notifyGenPaletteCreationToolChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_PALETTE_STACK:
			notifyGenPaletteStackChanged(notification, eClass);
			break;
		case ZDLGenPackage.OAW_EXPRESSION:
			notifyOawExpressionChanged(notification, eClass);
			break;
		case ZDLGenPackage.OAW_XTEND:
			notifyOawXtendChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION:
			notifyGenMenuDelegateActionChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION:
			notifyGenMenuCreateActionChanged(notification, eClass);
			break;
		case ZDLGenPackage.GEN_MENU_SEPARATOR:
			notifyGenMenuSeparatorChanged(notification, eClass);
			break;
		}
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @param derivedUnion the derived union affected by the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		// Do nothing.
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenModelChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenModel.class)) {
		case ZDLGenPackage.GEN_MODEL__OWNED_MODEL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_MODEL__DOMAIN_MODEL);
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_MODEL__REFERENCED_MODEL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_MODEL__DOMAIN_MODEL);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainModelChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainModel.class)) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ELEMENT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__DOMAIN_MODEL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__OWNING_GEN_MODEL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainPackageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainPackage.class)) {
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE__PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE__ELEMENT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_PACKAGE__DOMAIN_PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenPaletteChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenPalette.class)) {
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenPaletteDrawerChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenPaletteDrawer.class)) {
		case ZDLGenPackage.GEN_PALETTE_DRAWER__OWNED_TOOL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenMenuModelChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenMenuModel.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenUMLMenuChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenUMLMenu.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenMenuChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenMenu.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainBlockChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainBlock.class)) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainBlockImportChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainBlockImport.class)) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_IMPORT__SOURCE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainBlockMergeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainBlockMerge.class)) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_MERGE__SOURCE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainGeneralizationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainGeneralization.class)) {
		case ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainConceptChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainConcept.class)) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__BLOCK:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainReference.class)) {
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_ATTRIBUTE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainAttributeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainAttribute.class)) {
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE__DOMAIN_ATTRIBUTE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE__CONCEPT:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainDataTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainDataType.class)) {
		case ZDLGenPackage.GEN_DOMAIN_DATA_TYPE__BLOCK:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_DATA_TYPE__DOMAIN_DATA_TYPE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenAttributeOverrideChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenAttributeOverride.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainBlockReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainBlockReference.class)) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainSpecializationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainSpecialization.class)) {
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainModelLibraryReferenceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainModelLibraryReference.class)) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainModelLibraryChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainModelLibrary.class)) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__PACKAGE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainEnumChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainEnum.class)) {
		case ZDLGenPackage.GEN_DOMAIN_ENUM__BLOCK:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ENUM__DOMAIN_DATA_TYPE:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ENUM__LITERAL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenDomainEnumLiteralChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenDomainEnumLiteral.class)) {
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);
			break;
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenPaletteCreationToolChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenPaletteCreationTool.class)) {
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__CONTAINER:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenPaletteStackChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenPaletteStack.class)) {
		case ZDLGenPackage.GEN_PALETTE_STACK__OWNED_TOOL:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			break;
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			notifyChanged(notification, eClass, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNER);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOawExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OawExpression.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOawXtendChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OawXtend.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenMenuDelegateActionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenMenuDelegateAction.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenMenuCreateActionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenMenuCreateAction.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGenMenuSeparatorChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(GenMenuSeparator.class)) {
		}
	}

} //ZDLGenDerivedUnionAdapter
