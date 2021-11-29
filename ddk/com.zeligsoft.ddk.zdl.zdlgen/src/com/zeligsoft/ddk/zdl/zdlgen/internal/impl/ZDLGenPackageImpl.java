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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.ddk.zdl.zdlgen.Expression;
import com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode;
import com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenu;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalettable;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.OawExpression;
import com.zeligsoft.ddk.zdl.zdlgen.OawXtend;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ZDLGenPackageImpl extends EPackageImpl implements ZDLGenPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainConceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPalettableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainStructuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainGeneralizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainBlockRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genAttributeOverrideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genUMLMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainBlockImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainBlockMergeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteDrawerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteToolContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteToolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainBlockReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainEnumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteCreationToolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPaletteStackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oawExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oawXtendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuDelegateActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuCreateActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genMenuSeparatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genPaletteDiagramKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainAttributePresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainSpecializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainModelLibraryReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainModelLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainPackageableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genDomainPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genDomainConceptCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genDomainAttributePresentationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genDomainPresentationModelKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genAllDomainCassifiersModeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ZDLGenPackageImpl() {
		super(eNS_URI, ZDLGenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ZDLGenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ZDLGenPackage init() {
		if (isInited)
			return (ZDLGenPackage) EPackage.Registry.INSTANCE.getEPackage(ZDLGenPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredZDLGenPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ZDLGenPackageImpl theZDLGenPackage = registeredZDLGenPackage instanceof ZDLGenPackageImpl
				? (ZDLGenPackageImpl) registeredZDLGenPackage
				: new ZDLGenPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theZDLGenPackage.createPackageContents();

		// Initialize created meta-data
		theZDLGenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theZDLGenPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ZDLGenPackage.eNS_URI, theZDLGenPackage);
		return theZDLGenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainConcept() {
		return genDomainConceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainConcept_Category() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_Feature() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPalettable() {
		return genPalettableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteItem() {
		return genPaletteItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenPaletteItem_Name() {
		return (EAttribute) genPaletteItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenPaletteItem_Description() {
		return (EAttribute) genPaletteItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_Generalization() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_DomainConcept() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_UmlMetaclass() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_General() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_Reference() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_Attribute() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_IconUri() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainConcept_IsRSMSuppressed() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainConcept_IsRSMUIReadOnly() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainConcept_IsRSMPropertiesUIReadOnly() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_IsRhapsodySuppressed() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_RhapsodyMetaclass() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_RhapsodyStereotypeName() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_RhapsodyAddNew() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenDomainConcept_RhapsodyAddNewConcept() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainConcept_RhapsodyDisplayName() {
		return (EAttribute) genDomainConceptEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenDomainConcept_RhapsodyToAddNew() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainConcept_Override() {
		return (EReference) genDomainConceptEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainClassifier() {
		return genDomainClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainClassifier_Block() {
		return (EReference) genDomainClassifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainNamedElement() {
		return genDomainNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainNamedElement_Name() {
		return (EAttribute) genDomainNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainNamedElement_DomainElement() {
		return (EReference) genDomainNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainStructuralFeature() {
		return genDomainStructuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainStructuralFeature_UmlMetaattribute() {
		return (EReference) genDomainStructuralFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainStructuralFeature_DomainAttribute() {
		return (EReference) genDomainStructuralFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainStructuralFeature_IsRhapsodySuppressed() {
		return (EAttribute) genDomainStructuralFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainStructuralFeature_Concept() {
		return (EReference) genDomainStructuralFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainGeneralization() {
		return genDomainGeneralizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainGeneralization_General() {
		return (EReference) genDomainGeneralizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainGeneralization_DomainGeneralization() {
		return (EReference) genDomainGeneralizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainGeneralization_Specific() {
		return (EReference) genDomainGeneralizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainBlock() {
		return genDomainBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlock_Classifier() {
		return (EReference) genDomainBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlock_Relation() {
		return (EReference) genDomainBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlock_DomainBlock() {
		return (EReference) genDomainBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlock_Import() {
		return (EReference) genDomainBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlock_Merge() {
		return (EReference) genDomainBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainBlock_RsmStereotypesSuppressed() {
		return (EAttribute) genDomainBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainBlock_RsmStereotypesUIReadOnly() {
		return (EAttribute) genDomainBlockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainBlock_RsmStereotypesPropertiesUIReadOnly() {
		return (EAttribute) genDomainBlockEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainObject() {
		return genDomainObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainObject_Owner() {
		return (EReference) genDomainObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainObject_OwnedObject() {
		return (EReference) genDomainObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainObject_GenModel() {
		return (EReference) genDomainObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainBlockRelation() {
		return genDomainBlockRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockRelation_Source() {
		return (EReference) genDomainBlockRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockRelation_Target() {
		return (EReference) genDomainBlockRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockRelation_DomainBlockRelation() {
		return (EReference) genDomainBlockRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainAttribute() {
		return genDomainAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainAttribute_Type() {
		return (EReference) genDomainAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainDataType() {
		return genDomainDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainDataType_DomainDataType() {
		return (EReference) genDomainDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenAttributeOverride() {
		return genAttributeOverrideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenAttributeOverride_Name() {
		return (EAttribute) genAttributeOverrideEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenu() {
		return genMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenu_Item() {
		return (EReference) genMenuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenu_Extends() {
		return (EReference) genMenuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuItem() {
		return genMenuItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenMenuItem_Description() {
		return (EAttribute) genMenuItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenMenuItem_Name() {
		return (EAttribute) genMenuItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuItem_Overrides() {
		return (EReference) genMenuItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenUMLMenu() {
		return genUMLMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenUMLMenu_UmlMetaclass() {
		return (EReference) genUMLMenuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuTarget() {
		return genMenuTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuTarget_Menu() {
		return (EReference) genMenuTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainBlockImport() {
		return genDomainBlockImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainBlockMerge() {
		return genDomainBlockMergeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPalette() {
		return genPaletteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPalette_OwnedDrawer() {
		return (EReference) genPaletteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPalette_Drawer() {
		return (EReference) genPaletteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteDrawer() {
		return genPaletteDrawerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteDrawer_Specializes() {
		return (EReference) genPaletteDrawerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteDrawer_Palette() {
		return (EReference) genPaletteDrawerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteToolContainer() {
		return genPaletteToolContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteToolContainer_OwnedTool() {
		return (EReference) genPaletteToolContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteToolContainer_Tool() {
		return (EReference) genPaletteToolContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenPaletteToolContainer_TargetDiagram() {
		return (EAttribute) genPaletteToolContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteTool() {
		return genPaletteToolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteTool_Overrides() {
		return (EReference) genPaletteToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteTool_Container() {
		return (EReference) genPaletteToolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuModel() {
		return genMenuModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuModel_Items() {
		return (EReference) genMenuModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuModel_UmlMenus() {
		return (EReference) genMenuModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainBlockReference() {
		return genDomainBlockReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockReference_Target() {
		return (EReference) genDomainBlockReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockReference_DomainBlockReference() {
		return (EReference) genDomainBlockReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainBlockReference_DomainSpecialization() {
		return (EReference) genDomainBlockReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainEnum() {
		return genDomainEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainEnum_Literal() {
		return (EReference) genDomainEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainEnumLiteral() {
		return genDomainEnumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainEnumLiteral_DomainEnumLiteral() {
		return (EReference) genDomainEnumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainEnumLiteral_Enumeration() {
		return (EReference) genDomainEnumLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteCreationTool() {
		return genPaletteCreationToolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteCreationTool_Type() {
		return (EReference) genPaletteCreationToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenPaletteCreationTool_ElementTypeHint() {
		return (EAttribute) genPaletteCreationToolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteCreationTool_Expression() {
		return (EReference) genPaletteCreationToolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpression_Name() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpression_Expression() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenPaletteStack() {
		return genPaletteStackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenPaletteStack_ActiveTool() {
		return (EReference) genPaletteStackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOawExpression() {
		return oawExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOawExpression_VariableName() {
		return (EAttribute) oawExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOawXtend() {
		return oawXtendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOawXtend_ExtensionFile() {
		return (EAttribute) oawXtendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuAction() {
		return genMenuActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuDelegateAction() {
		return genMenuDelegateActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenMenuDelegateAction_HostBundle() {
		return (EAttribute) genMenuDelegateActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenMenuDelegateAction_ClassName() {
		return (EAttribute) genMenuDelegateActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuCreateAction() {
		return genMenuCreateActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenMenuCreateAction_TypeHint() {
		return (EAttribute) genMenuCreateActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuCreateAction_CreateConcept() {
		return (EReference) genMenuCreateActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenMenuCreateAction_Expression() {
		return (EReference) genMenuCreateActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenMenuSeparator() {
		return genMenuSeparatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGenPaletteDiagramKind() {
		return genPaletteDiagramKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainReference() {
		return genDomainReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainReference_Target() {
		return (EReference) genDomainReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainReference_Source() {
		return (EReference) genDomainReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainReference_DomainReference() {
		return (EReference) genDomainReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainAttributePresentation() {
		return genDomainAttributePresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainAttributePresentation_Visible() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainAttributePresentation_ReadOnly() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainAttributePresentation_PresentationHint() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainAttributePresentation_PresentationKind() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainAttributePresentation_VisibleModelType() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainAttributePresentation_Order() {
		return (EAttribute) genDomainAttributePresentationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainSpecialization() {
		return genDomainSpecializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_DomainBlock() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainSpecialization_ElementtypeConfigurationContainerUri() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainModelLibraryReference() {
		return genDomainModelLibraryReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModelLibraryReference_Target() {
		return (EReference) genDomainModelLibraryReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModelLibraryReference_DomainModelLibraryReference() {
		return (EReference) genDomainModelLibraryReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainModelLibraryReference_ResourceName() {
		return (EAttribute) genDomainModelLibraryReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModelLibraryReference_DomainSpecialization() {
		return (EReference) genDomainModelLibraryReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainModelLibrary() {
		return genDomainModelLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModelLibrary_DomainModelLibrary() {
		return (EReference) genDomainModelLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_DomainSpecialization() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_DomainConcept() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_PluginName() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_ResourceName() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_DomainModelLibrary() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_ModelLibraryNamesPackage() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_ModelLibrarySourceFolder() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_MenuModelResource() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainSpecialization_Version() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainSpecialization_CodeGenTarget() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainSpecialization_RhapsodyJavaProject() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainSpecialization_RhapsodyJDTJavaLibrary() {
		return (EAttribute) genDomainSpecializationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_ExcludedPaletteItem() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainSpecialization_IncludedUMLMenus() {
		return (EReference) genDomainSpecializationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainModel() {
		return genDomainModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModel_DomainModel() {
		return (EReference) genDomainModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenDomainModel_NsURI() {
		return (EAttribute) genDomainModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainModel_RootPackage() {
		return (EAttribute) genDomainModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainModel_ImplementationSubPackage() {
		return (EAttribute) genDomainModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainModel_ImplSuffix() {
		return (EAttribute) genDomainModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenDomainModel_ApiProject() {
		return (EAttribute) genDomainModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModel_Palette() {
		return (EReference) genDomainModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModel_MenuModel() {
		return (EReference) genDomainModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainModel_OwningGenModel() {
		return (EReference) genDomainModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenModel() {
		return genModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenModel_ReferencedModel() {
		return (EReference) genModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenModel_OwnedModel() {
		return (EReference) genModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenModel_DomainModel() {
		return (EReference) genModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainPackageableElement() {
		return genDomainPackageableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainPackageableElement_Package() {
		return (EReference) genDomainPackageableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenDomainPackage() {
		return genDomainPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainPackage_Element() {
		return (EReference) genDomainPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenDomainPackage_DomainPackage() {
		return (EReference) genDomainPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGenDomainConceptCategory() {
		return genDomainConceptCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGenDomainAttributePresentationKind() {
		return genDomainAttributePresentationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGenDomainPresentationModelKind() {
		return genDomainPresentationModelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGenAllDomainCassifiersMode() {
		return genAllDomainCassifiersModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ZDLGenFactory getZDLGenFactory() {
		return (ZDLGenFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		genDomainClassifierEClass = createEClass(GEN_DOMAIN_CLASSIFIER);
		createEReference(genDomainClassifierEClass, GEN_DOMAIN_CLASSIFIER__BLOCK);

		genDomainNamedElementEClass = createEClass(GEN_DOMAIN_NAMED_ELEMENT);
		createEAttribute(genDomainNamedElementEClass, GEN_DOMAIN_NAMED_ELEMENT__NAME);
		createEReference(genDomainNamedElementEClass, GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT);

		genDomainObjectEClass = createEClass(GEN_DOMAIN_OBJECT);
		createEReference(genDomainObjectEClass, GEN_DOMAIN_OBJECT__GEN_MODEL);
		createEReference(genDomainObjectEClass, GEN_DOMAIN_OBJECT__OWNER);
		createEReference(genDomainObjectEClass, GEN_DOMAIN_OBJECT__OWNED_OBJECT);

		genModelEClass = createEClass(GEN_MODEL);
		createEReference(genModelEClass, GEN_MODEL__OWNED_MODEL);
		createEReference(genModelEClass, GEN_MODEL__DOMAIN_MODEL);
		createEReference(genModelEClass, GEN_MODEL__REFERENCED_MODEL);

		genDomainModelEClass = createEClass(GEN_DOMAIN_MODEL);
		createEReference(genDomainModelEClass, GEN_DOMAIN_MODEL__DOMAIN_MODEL);
		createEAttribute(genDomainModelEClass, GEN_DOMAIN_MODEL__NS_URI);
		createEAttribute(genDomainModelEClass, GEN_DOMAIN_MODEL__ROOT_PACKAGE);
		createEAttribute(genDomainModelEClass, GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE);
		createEAttribute(genDomainModelEClass, GEN_DOMAIN_MODEL__IMPL_SUFFIX);
		createEAttribute(genDomainModelEClass, GEN_DOMAIN_MODEL__API_PROJECT);
		createEReference(genDomainModelEClass, GEN_DOMAIN_MODEL__PALETTE);
		createEReference(genDomainModelEClass, GEN_DOMAIN_MODEL__MENU_MODEL);
		createEReference(genDomainModelEClass, GEN_DOMAIN_MODEL__OWNING_GEN_MODEL);

		genDomainPackageEClass = createEClass(GEN_DOMAIN_PACKAGE);
		createEReference(genDomainPackageEClass, GEN_DOMAIN_PACKAGE__ELEMENT);
		createEReference(genDomainPackageEClass, GEN_DOMAIN_PACKAGE__DOMAIN_PACKAGE);

		genDomainPackageableElementEClass = createEClass(GEN_DOMAIN_PACKAGEABLE_ELEMENT);
		createEReference(genDomainPackageableElementEClass, GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE);

		genPaletteEClass = createEClass(GEN_PALETTE);
		createEReference(genPaletteEClass, GEN_PALETTE__OWNED_DRAWER);
		createEReference(genPaletteEClass, GEN_PALETTE__DRAWER);

		genPaletteItemEClass = createEClass(GEN_PALETTE_ITEM);
		createEAttribute(genPaletteItemEClass, GEN_PALETTE_ITEM__NAME);
		createEAttribute(genPaletteItemEClass, GEN_PALETTE_ITEM__DESCRIPTION);

		genPaletteDrawerEClass = createEClass(GEN_PALETTE_DRAWER);
		createEReference(genPaletteDrawerEClass, GEN_PALETTE_DRAWER__SPECIALIZES);
		createEReference(genPaletteDrawerEClass, GEN_PALETTE_DRAWER__PALETTE);

		genPaletteToolContainerEClass = createEClass(GEN_PALETTE_TOOL_CONTAINER);
		createEReference(genPaletteToolContainerEClass, GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL);
		createEReference(genPaletteToolContainerEClass, GEN_PALETTE_TOOL_CONTAINER__TOOL);
		createEAttribute(genPaletteToolContainerEClass, GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM);

		genPaletteToolEClass = createEClass(GEN_PALETTE_TOOL);
		createEReference(genPaletteToolEClass, GEN_PALETTE_TOOL__OVERRIDES);
		createEReference(genPaletteToolEClass, GEN_PALETTE_TOOL__CONTAINER);

		genMenuModelEClass = createEClass(GEN_MENU_MODEL);
		createEReference(genMenuModelEClass, GEN_MENU_MODEL__ITEMS);
		createEReference(genMenuModelEClass, GEN_MENU_MODEL__UML_MENUS);

		genMenuItemEClass = createEClass(GEN_MENU_ITEM);
		createEAttribute(genMenuItemEClass, GEN_MENU_ITEM__DESCRIPTION);
		createEAttribute(genMenuItemEClass, GEN_MENU_ITEM__NAME);
		createEReference(genMenuItemEClass, GEN_MENU_ITEM__OVERRIDES);

		genUMLMenuEClass = createEClass(GEN_UML_MENU);
		createEReference(genUMLMenuEClass, GEN_UML_MENU__UML_METACLASS);

		genMenuTargetEClass = createEClass(GEN_MENU_TARGET);
		createEReference(genMenuTargetEClass, GEN_MENU_TARGET__MENU);

		genMenuEClass = createEClass(GEN_MENU);
		createEReference(genMenuEClass, GEN_MENU__EXTENDS);
		createEReference(genMenuEClass, GEN_MENU__ITEM);

		genDomainBlockEClass = createEClass(GEN_DOMAIN_BLOCK);
		createEReference(genDomainBlockEClass, GEN_DOMAIN_BLOCK__CLASSIFIER);
		createEReference(genDomainBlockEClass, GEN_DOMAIN_BLOCK__RELATION);
		createEReference(genDomainBlockEClass, GEN_DOMAIN_BLOCK__DOMAIN_BLOCK);
		createEReference(genDomainBlockEClass, GEN_DOMAIN_BLOCK__IMPORT);
		createEReference(genDomainBlockEClass, GEN_DOMAIN_BLOCK__MERGE);
		createEAttribute(genDomainBlockEClass, GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED);
		createEAttribute(genDomainBlockEClass, GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY);
		createEAttribute(genDomainBlockEClass, GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY);

		genDomainBlockRelationEClass = createEClass(GEN_DOMAIN_BLOCK_RELATION);
		createEReference(genDomainBlockRelationEClass, GEN_DOMAIN_BLOCK_RELATION__TARGET);
		createEReference(genDomainBlockRelationEClass, GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION);
		createEReference(genDomainBlockRelationEClass, GEN_DOMAIN_BLOCK_RELATION__SOURCE);

		genDomainBlockImportEClass = createEClass(GEN_DOMAIN_BLOCK_IMPORT);

		genDomainBlockMergeEClass = createEClass(GEN_DOMAIN_BLOCK_MERGE);

		genDomainGeneralizationEClass = createEClass(GEN_DOMAIN_GENERALIZATION);
		createEReference(genDomainGeneralizationEClass, GEN_DOMAIN_GENERALIZATION__SPECIFIC);
		createEReference(genDomainGeneralizationEClass, GEN_DOMAIN_GENERALIZATION__GENERAL);
		createEReference(genDomainGeneralizationEClass, GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION);

		genDomainConceptEClass = createEClass(GEN_DOMAIN_CONCEPT);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__CATEGORY);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__FEATURE);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__UML_METACLASS);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__GENERAL);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__REFERENCE);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__ATTRIBUTE);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__ICON_URI);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT);
		createEAttribute(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__OVERRIDE);
		createEReference(genDomainConceptEClass, GEN_DOMAIN_CONCEPT__GENERALIZATION);

		genPalettableEClass = createEClass(GEN_PALETTABLE);

		genDomainStructuralFeatureEClass = createEClass(GEN_DOMAIN_STRUCTURAL_FEATURE);
		createEReference(genDomainStructuralFeatureEClass, GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE);
		createEReference(genDomainStructuralFeatureEClass, GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE);
		createEAttribute(genDomainStructuralFeatureEClass, GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED);
		createEReference(genDomainStructuralFeatureEClass, GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT);

		genDomainAttributePresentationEClass = createEClass(GEN_DOMAIN_ATTRIBUTE_PRESENTATION);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE);
		createEAttribute(genDomainAttributePresentationEClass, GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER);

		genDomainReferenceEClass = createEClass(GEN_DOMAIN_REFERENCE);
		createEReference(genDomainReferenceEClass, GEN_DOMAIN_REFERENCE__TARGET);
		createEReference(genDomainReferenceEClass, GEN_DOMAIN_REFERENCE__SOURCE);
		createEReference(genDomainReferenceEClass, GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE);

		genDomainAttributeEClass = createEClass(GEN_DOMAIN_ATTRIBUTE);
		createEReference(genDomainAttributeEClass, GEN_DOMAIN_ATTRIBUTE__TYPE);

		genDomainDataTypeEClass = createEClass(GEN_DOMAIN_DATA_TYPE);
		createEReference(genDomainDataTypeEClass, GEN_DOMAIN_DATA_TYPE__DOMAIN_DATA_TYPE);

		genAttributeOverrideEClass = createEClass(GEN_ATTRIBUTE_OVERRIDE);
		createEAttribute(genAttributeOverrideEClass, GEN_ATTRIBUTE_OVERRIDE__NAME);

		genDomainBlockReferenceEClass = createEClass(GEN_DOMAIN_BLOCK_REFERENCE);
		createEReference(genDomainBlockReferenceEClass, GEN_DOMAIN_BLOCK_REFERENCE__TARGET);
		createEReference(genDomainBlockReferenceEClass, GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE);
		createEReference(genDomainBlockReferenceEClass, GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION);

		genDomainSpecializationEClass = createEClass(GEN_DOMAIN_SPECIALIZATION);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__VERSION);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT);
		createEAttribute(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS);
		createEReference(genDomainSpecializationEClass, GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK);
		createEAttribute(genDomainSpecializationEClass,
				GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI);

		genDomainModelLibraryReferenceEClass = createEClass(GEN_DOMAIN_MODEL_LIBRARY_REFERENCE);
		createEReference(genDomainModelLibraryReferenceEClass, GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET);
		createEReference(genDomainModelLibraryReferenceEClass,
				GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE);
		createEAttribute(genDomainModelLibraryReferenceEClass, GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME);
		createEReference(genDomainModelLibraryReferenceEClass,
				GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION);

		genDomainModelLibraryEClass = createEClass(GEN_DOMAIN_MODEL_LIBRARY);
		createEReference(genDomainModelLibraryEClass, GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY);

		genDomainEnumEClass = createEClass(GEN_DOMAIN_ENUM);
		createEReference(genDomainEnumEClass, GEN_DOMAIN_ENUM__LITERAL);

		genDomainEnumLiteralEClass = createEClass(GEN_DOMAIN_ENUM_LITERAL);
		createEReference(genDomainEnumLiteralEClass, GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL);
		createEReference(genDomainEnumLiteralEClass, GEN_DOMAIN_ENUM_LITERAL__ENUMERATION);

		genPaletteCreationToolEClass = createEClass(GEN_PALETTE_CREATION_TOOL);
		createEReference(genPaletteCreationToolEClass, GEN_PALETTE_CREATION_TOOL__TYPE);
		createEAttribute(genPaletteCreationToolEClass, GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT);
		createEReference(genPaletteCreationToolEClass, GEN_PALETTE_CREATION_TOOL__EXPRESSION);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__NAME);
		createEAttribute(expressionEClass, EXPRESSION__EXPRESSION);

		genPaletteStackEClass = createEClass(GEN_PALETTE_STACK);
		createEReference(genPaletteStackEClass, GEN_PALETTE_STACK__ACTIVE_TOOL);

		oawExpressionEClass = createEClass(OAW_EXPRESSION);
		createEAttribute(oawExpressionEClass, OAW_EXPRESSION__VARIABLE_NAME);

		oawXtendEClass = createEClass(OAW_XTEND);
		createEAttribute(oawXtendEClass, OAW_XTEND__EXTENSION_FILE);

		genMenuActionEClass = createEClass(GEN_MENU_ACTION);

		genMenuDelegateActionEClass = createEClass(GEN_MENU_DELEGATE_ACTION);
		createEAttribute(genMenuDelegateActionEClass, GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE);
		createEAttribute(genMenuDelegateActionEClass, GEN_MENU_DELEGATE_ACTION__CLASS_NAME);

		genMenuCreateActionEClass = createEClass(GEN_MENU_CREATE_ACTION);
		createEAttribute(genMenuCreateActionEClass, GEN_MENU_CREATE_ACTION__TYPE_HINT);
		createEReference(genMenuCreateActionEClass, GEN_MENU_CREATE_ACTION__CREATE_CONCEPT);
		createEReference(genMenuCreateActionEClass, GEN_MENU_CREATE_ACTION__EXPRESSION);

		genMenuSeparatorEClass = createEClass(GEN_MENU_SEPARATOR);

		// Create enums
		genPaletteDiagramKindEEnum = createEEnum(GEN_PALETTE_DIAGRAM_KIND);
		genAllDomainCassifiersModeEEnum = createEEnum(GEN_ALL_DOMAIN_CASSIFIERS_MODE);
		genDomainConceptCategoryEEnum = createEEnum(GEN_DOMAIN_CONCEPT_CATEGORY);
		genDomainAttributePresentationKindEEnum = createEEnum(GEN_DOMAIN_ATTRIBUTE_PRESENTATION_KIND);
		genDomainPresentationModelKindEEnum = createEEnum(GEN_DOMAIN_PRESENTATION_MODEL_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		genDomainClassifierEClass.getESuperTypes().add(this.getGenDomainNamedElement());
		genDomainNamedElementEClass.getESuperTypes().add(this.getGenDomainObject());
		genModelEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainModelEClass.getESuperTypes().add(this.getGenDomainPackage());
		genDomainPackageEClass.getESuperTypes().add(this.getGenDomainPackageableElement());
		genDomainPackageableElementEClass.getESuperTypes().add(this.getGenDomainNamedElement());
		genPaletteEClass.getESuperTypes().add(this.getGenPaletteItem());
		genPaletteItemEClass.getESuperTypes().add(this.getGenDomainObject());
		genPaletteDrawerEClass.getESuperTypes().add(this.getGenPaletteToolContainer());
		genPaletteToolContainerEClass.getESuperTypes().add(this.getGenPaletteItem());
		genPaletteToolEClass.getESuperTypes().add(this.getGenPaletteItem());
		genMenuModelEClass.getESuperTypes().add(this.getGenDomainObject());
		genMenuItemEClass.getESuperTypes().add(this.getGenDomainObject());
		genUMLMenuEClass.getESuperTypes().add(this.getGenDomainObject());
		genUMLMenuEClass.getESuperTypes().add(this.getGenMenuTarget());
		genMenuEClass.getESuperTypes().add(this.getGenMenuItem());
		genDomainBlockEClass.getESuperTypes().add(this.getGenDomainPackageableElement());
		genDomainBlockRelationEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainBlockImportEClass.getESuperTypes().add(this.getGenDomainBlockRelation());
		genDomainBlockMergeEClass.getESuperTypes().add(this.getGenDomainBlockRelation());
		genDomainGeneralizationEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainConceptEClass.getESuperTypes().add(this.getGenDomainClassifier());
		genDomainConceptEClass.getESuperTypes().add(this.getGenMenuTarget());
		genDomainConceptEClass.getESuperTypes().add(this.getGenPalettable());
		genDomainStructuralFeatureEClass.getESuperTypes().add(this.getGenDomainNamedElement());
		genDomainStructuralFeatureEClass.getESuperTypes().add(this.getGenDomainAttributePresentation());
		genDomainReferenceEClass.getESuperTypes().add(this.getGenDomainStructuralFeature());
		genDomainReferenceEClass.getESuperTypes().add(this.getGenPalettable());
		genDomainAttributeEClass.getESuperTypes().add(this.getGenDomainStructuralFeature());
		genDomainDataTypeEClass.getESuperTypes().add(this.getGenDomainClassifier());
		genAttributeOverrideEClass.getESuperTypes().add(this.getGenDomainAttributePresentation());
		genAttributeOverrideEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainBlockReferenceEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainSpecializationEClass.getESuperTypes().add(this.getGenDomainPackageableElement());
		genDomainModelLibraryReferenceEClass.getESuperTypes().add(this.getGenDomainObject());
		genDomainModelLibraryEClass.getESuperTypes().add(this.getGenDomainPackageableElement());
		genDomainEnumEClass.getESuperTypes().add(this.getGenDomainDataType());
		genDomainEnumLiteralEClass.getESuperTypes().add(this.getGenDomainNamedElement());
		genPaletteCreationToolEClass.getESuperTypes().add(this.getGenPaletteTool());
		expressionEClass.getESuperTypes().add(this.getGenDomainObject());
		genPaletteStackEClass.getESuperTypes().add(this.getGenPaletteToolContainer());
		genPaletteStackEClass.getESuperTypes().add(this.getGenPaletteTool());
		oawExpressionEClass.getESuperTypes().add(this.getExpression());
		oawXtendEClass.getESuperTypes().add(this.getExpression());
		genMenuActionEClass.getESuperTypes().add(this.getGenMenuItem());
		genMenuDelegateActionEClass.getESuperTypes().add(this.getGenMenuAction());
		genMenuCreateActionEClass.getESuperTypes().add(this.getGenMenuAction());
		genMenuSeparatorEClass.getESuperTypes().add(this.getGenMenuItem());

		// Initialize classes and features; add operations and parameters
		initEClass(genDomainClassifierEClass, GenDomainClassifier.class, "GenDomainClassifier", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainClassifier_Block(), this.getGenDomainBlock(), this.getGenDomainBlock_Classifier(),
				"block", null, 1, 1, GenDomainClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainNamedElementEClass, GenDomainNamedElement.class, "GenDomainNamedElement", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenDomainNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, //$NON-NLS-1$
				GenDomainNamedElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainNamedElement_DomainElement(), theUMLPackage.getNamedElement(), null, "domainElement", //$NON-NLS-1$
				null, 0, 1, GenDomainNamedElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		addEOperation(genDomainNamedElementEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genDomainObjectEClass, GenDomainObject.class, "GenDomainObject", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainObject_GenModel(), this.getGenModel(), null, "genModel", null, 0, 1, //$NON-NLS-1$
				GenDomainObject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainObject_Owner(), this.getGenDomainObject(), this.getGenDomainObject_OwnedObject(),
				"owner", null, 0, 1, GenDomainObject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, //$NON-NLS-1$
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainObject_OwnedObject(), this.getGenDomainObject(), this.getGenDomainObject_Owner(),
				"ownedObject", null, 0, -1, GenDomainObject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		addEOperation(genDomainObjectEClass, this.getGenModel(), "getGenModel", 0, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genModelEClass, GenModel.class, "GenModel", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenModel_OwnedModel(), this.getGenDomainModel(), this.getGenDomainModel_OwningGenModel(),
				"ownedModel", null, 0, -1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, //$NON-NLS-1$
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenModel_DomainModel(), this.getGenDomainModel(), null, "domainModel", null, 0, -1, //$NON-NLS-1$
				GenModel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenModel_ReferencedModel(), this.getGenDomainModel(), null, "referencedModel", null, 0, -1, //$NON-NLS-1$
				GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(genModelEClass, theUMLPackage.getModel(), "findUsedDomainModels", 0, -1, //$NON-NLS-1$
				IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theUMLPackage.getModel(), "model", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(genModelEClass, theUMLPackage.getModel(), "getDomainModels", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "uris", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(genDomainModelEClass, GenDomainModel.class, "GenDomainModel", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainModel_DomainModel(), theUMLPackage.getModel(), null, "domainModel", null, 1, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenDomainModel_NsURI(), ecorePackage.getEString(), "nsURI", null, 1, 1, GenDomainModel.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getGenDomainModel_RootPackage(), ecorePackage.getEString(), "rootPackage", null, 1, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainModel_ImplementationSubPackage(), ecorePackage.getEString(),
				"implementationSubPackage", null, 1, 1, GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainModel_ImplSuffix(), ecorePackage.getEString(), "implSuffix", null, 1, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainModel_ApiProject(), ecorePackage.getEString(), "apiProject", null, 1, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainModel_Palette(), this.getGenPalette(), null, "palette", null, 0, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainModel_MenuModel(), this.getGenMenuModel(), null, "menuModel", null, 1, 1, //$NON-NLS-1$
				GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainModel_OwningGenModel(), this.getGenModel(), this.getGenModel_OwnedModel(),
				"owningGenModel", null, 1, 1, GenDomainModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(genDomainModelEClass, this.getGenDomainBlock(), "getDomainBlock", 1, 1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifiedName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genDomainPackageEClass, GenDomainPackage.class, "GenDomainPackage", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainPackage_Element(), this.getGenDomainPackageableElement(),
				this.getGenDomainPackageableElement_Package(), "element", null, 0, -1, GenDomainPackage.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenDomainPackage_DomainPackage(), theUMLPackage.getPackage(), null, "domainPackage", null, 1, //$NON-NLS-1$
				1, GenDomainPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainPackageableElementEClass, GenDomainPackageableElement.class, "GenDomainPackageableElement", //$NON-NLS-1$
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainPackageableElement_Package(), this.getGenDomainPackage(),
				this.getGenDomainPackage_Element(), "package", null, 0, 1, GenDomainPackageableElement.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genPaletteEClass, GenPalette.class, "GenPalette", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPalette_OwnedDrawer(), this.getGenPaletteDrawer(), this.getGenPaletteDrawer_Palette(),
				"ownedDrawer", null, 0, -1, GenPalette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, //$NON-NLS-1$
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenPalette_Drawer(), this.getGenPaletteDrawer(), null, "drawer", null, 0, -1, //$NON-NLS-1$
				GenPalette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genPaletteItemEClass, GenPaletteItem.class, "GenPaletteItem", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenPaletteItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, GenPaletteItem.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getGenPaletteItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, //$NON-NLS-1$
				GenPaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		initEClass(genPaletteDrawerEClass, GenPaletteDrawer.class, "GenPaletteDrawer", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPaletteDrawer_Specializes(), this.getGenPaletteDrawer(), null, "specializes", null, 0, 1, //$NON-NLS-1$
				GenPaletteDrawer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenPaletteDrawer_Palette(), this.getGenPalette(), this.getGenPalette_OwnedDrawer(), "palette", //$NON-NLS-1$
				null, 1, 1, GenPaletteDrawer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(genPaletteDrawerEClass, this.getGenPaletteTool(), "allTools", 0, -1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genPaletteToolContainerEClass, GenPaletteToolContainer.class, "GenPaletteToolContainer", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPaletteToolContainer_OwnedTool(), this.getGenPaletteTool(),
				this.getGenPaletteTool_Container(), "ownedTool", null, 0, -1, GenPaletteToolContainer.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenPaletteToolContainer_Tool(), this.getGenPaletteTool(), null, "tool", null, 0, -1, //$NON-NLS-1$
				GenPaletteToolContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenPaletteToolContainer_TargetDiagram(), this.getGenPaletteDiagramKind(), "targetDiagram", //$NON-NLS-1$
				null, 0, -1, GenPaletteToolContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genPaletteToolEClass, GenPaletteTool.class, "GenPaletteTool", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPaletteTool_Overrides(), this.getGenPaletteTool(), null, "overrides", null, 0, 1, //$NON-NLS-1$
				GenPaletteTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenPaletteTool_Container(), this.getGenPaletteToolContainer(),
				this.getGenPaletteToolContainer_OwnedTool(), "container", null, 1, 1, GenPaletteTool.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuModelEClass, GenMenuModel.class, "GenMenuModel", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenMenuModel_Items(), this.getGenMenuItem(), null, "items", null, 0, -1, GenMenuModel.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenMenuModel_UmlMenus(), this.getGenUMLMenu(), null, "umlMenus", null, 0, -1, //$NON-NLS-1$
				GenMenuModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuItemEClass, GenMenuItem.class, "GenMenuItem", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenMenuItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, //$NON-NLS-1$
				GenMenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenMenuItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, GenMenuItem.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getGenMenuItem_Overrides(), this.getGenMenuItem(), null, "overrides", null, 0, 1, //$NON-NLS-1$
				GenMenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(genMenuItemEClass, this.getGenMenuItem(), "overridenBy", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genUMLMenuEClass, GenUMLMenu.class, "GenUMLMenu", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenUMLMenu_UmlMetaclass(), theUMLPackage.getClass_(), null, "umlMetaclass", null, 1, 1, //$NON-NLS-1$
				GenUMLMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuTargetEClass, GenMenuTarget.class, "GenMenuTarget", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenMenuTarget_Menu(), this.getGenMenu(), null, "menu", null, 0, 1, GenMenuTarget.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuEClass, GenMenu.class, "GenMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getGenMenu_Extends(), this.getGenMenu(), null, "extends", null, 0, 1, GenMenu.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenMenu_Item(), this.getGenMenuItem(), null, "item", null, 0, -1, GenMenu.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainBlockEClass, GenDomainBlock.class, "GenDomainBlock", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainBlock_Classifier(), this.getGenDomainClassifier(),
				this.getGenDomainClassifier_Block(), "classifier", null, 0, -1, GenDomainBlock.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getGenDomainBlock_Relation(), this.getGenDomainBlockRelation(),
				this.getGenDomainBlockRelation_Source(), "relation", null, 0, -1, GenDomainBlock.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getGenDomainBlock_DomainBlock(), theUMLPackage.getPackage(), null, "domainBlock", null, 1, 1, //$NON-NLS-1$
				GenDomainBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainBlock_Import(), this.getGenDomainBlockImport(), null, "import", null, 0, -1, //$NON-NLS-1$
				GenDomainBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainBlock_Merge(), this.getGenDomainBlockMerge(), null, "merge", null, 0, -1, //$NON-NLS-1$
				GenDomainBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainBlock_RsmStereotypesSuppressed(), ecorePackage.getEBoolean(),
				"rsmStereotypesSuppressed", "true", 1, 1, GenDomainBlock.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainBlock_RsmStereotypesUIReadOnly(), ecorePackage.getEBoolean(),
				"rsmStereotypesUIReadOnly", "false", 1, 1, GenDomainBlock.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainBlock_RsmStereotypesPropertiesUIReadOnly(), ecorePackage.getEBoolean(),
				"rsmStereotypesPropertiesUIReadOnly", "false", 1, 1, GenDomainBlock.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(genDomainBlockEClass, this.getGenDomainClassifier(), "allClassifiers", 0, -1, IS_UNIQUE, //$NON-NLS-1$
				IS_ORDERED);
		addEParameter(op, this.getGenAllDomainCassifiersMode(), "mode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(genDomainBlockRelationEClass, GenDomainBlockRelation.class, "GenDomainBlockRelation", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainBlockRelation_Target(), this.getGenDomainBlock(), null, "target", null, 1, 1, //$NON-NLS-1$
				GenDomainBlockRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainBlockRelation_DomainBlockRelation(), theUMLPackage.getDirectedRelationship(), null,
				"domainBlockRelation", null, 1, 1, GenDomainBlockRelation.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainBlockRelation_Source(), this.getGenDomainBlock(), this.getGenDomainBlock_Relation(),
				"source", null, 1, 1, GenDomainBlockRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainBlockImportEClass, GenDomainBlockImport.class, "GenDomainBlockImport", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genDomainBlockMergeEClass, GenDomainBlockMerge.class, "GenDomainBlockMerge", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genDomainGeneralizationEClass, GenDomainGeneralization.class, "GenDomainGeneralization", //$NON-NLS-1$
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainGeneralization_Specific(), this.getGenDomainConcept(),
				this.getGenDomainConcept_Generalization(), "specific", null, 1, 1, GenDomainGeneralization.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainGeneralization_General(), this.getGenDomainConcept(), null, "general", null, 1, 1, //$NON-NLS-1$
				GenDomainGeneralization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainGeneralization_DomainGeneralization(), theUMLPackage.getGeneralization(), null,
				"domainGeneralization", null, 1, 1, GenDomainGeneralization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainConceptEClass, GenDomainConcept.class, "GenDomainConcept", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenDomainConcept_Category(), this.getGenDomainConceptCategory(), "category", null, 1, 1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_Feature(), this.getGenDomainStructuralFeature(),
				this.getGenDomainStructuralFeature_Concept(), "feature", null, 0, -1, GenDomainConcept.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_DomainConcept(), theUMLPackage.getClass_(), null, "domainConcept", null, 1, //$NON-NLS-1$
				1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_UmlMetaclass(), theUMLPackage.getClass_(), null, "umlMetaclass", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenDomainConcept_General(), this.getGenDomainConcept(), null, "general", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_Reference(), this.getGenDomainReference(), null, "reference", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_Attribute(), this.getGenDomainAttribute(), null, "attribute", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_IconUri(), ecorePackage.getEString(), "iconUri", null, 1, 1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_IsRSMSuppressed(), ecorePackage.getEBoolean(), "isRSMSuppressed", null, 0, 1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_IsRSMUIReadOnly(), ecorePackage.getEBoolean(), "isRSMUIReadOnly", null, 0, 1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_IsRSMPropertiesUIReadOnly(), ecorePackage.getEBoolean(),
				"isRSMPropertiesUIReadOnly", null, 0, 1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_IsRhapsodySuppressed(), ecorePackage.getEBoolean(), "isRhapsodySuppressed", //$NON-NLS-1$
				"false", 1, 1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, //$NON-NLS-1$
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_RhapsodyMetaclass(), ecorePackage.getEString(), "rhapsodyMetaclass", null, 1, //$NON-NLS-1$
				1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_RhapsodyStereotypeName(), ecorePackage.getEString(),
				"rhapsodyStereotypeName", null, 1, 1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_RhapsodyAddNew(), ecorePackage.getEString(), "rhapsodyAddNew", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_RhapsodyAddNewConcept(), this.getGenDomainConcept(), null,
				"rhapsodyAddNewConcept", null, 0, -1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainConcept_RhapsodyDisplayName(), ecorePackage.getEString(), "rhapsodyDisplayName", //$NON-NLS-1$
				null, 1, 1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_RhapsodyToAddNew(), this.getGenDomainConcept(), null, "rhapsodyToAddNew", //$NON-NLS-1$
				null, 0, -1, GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_Override(), this.getGenAttributeOverride(), null, "override", null, 0, -1, //$NON-NLS-1$
				GenDomainConcept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainConcept_Generalization(), this.getGenDomainGeneralization(),
				this.getGenDomainGeneralization_Specific(), "generalization", null, 0, -1, GenDomainConcept.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(genDomainConceptEClass, this.getGenDomainConcept(), "allGenerals", 0, -1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(genDomainConceptEClass, this.getGenDomainConcept(), "allSpecifics", 0, -1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);

		addEOperation(genDomainConceptEClass, this.getGenDomainConcept(), "getGenerals", 0, -1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(genPalettableEClass, GenPalettable.class, "GenPalettable", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(genDomainStructuralFeatureEClass, GenDomainStructuralFeature.class, "GenDomainStructuralFeature", //$NON-NLS-1$
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainStructuralFeature_UmlMetaattribute(), theUMLPackage.getProperty(), null,
				"umlMetaattribute", null, 0, 1, GenDomainStructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenDomainStructuralFeature_DomainAttribute(), theUMLPackage.getProperty(), null,
				"domainAttribute", null, 1, 1, GenDomainStructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainStructuralFeature_IsRhapsodySuppressed(), ecorePackage.getEBoolean(),
				"isRhapsodySuppressed", "false", 1, 1, GenDomainStructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainStructuralFeature_Concept(), this.getGenDomainConcept(),
				this.getGenDomainConcept_Feature(), "concept", null, 1, 1, GenDomainStructuralFeature.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainAttributePresentationEClass, GenDomainAttributePresentation.class,
				"GenDomainAttributePresentation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getGenDomainAttributePresentation_Visible(), ecorePackage.getEBoolean(), "visible", "true", 1, 1, //$NON-NLS-1$//$NON-NLS-2$
				GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainAttributePresentation_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "false", 1, //$NON-NLS-1$//$NON-NLS-2$
				1, GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainAttributePresentation_PresentationHint(), ecorePackage.getEString(),
				"presentationHint", null, 1, 1, GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainAttributePresentation_PresentationKind(),
				this.getGenDomainAttributePresentationKind(), "presentationKind", "other", 1, 1, //$NON-NLS-1$//$NON-NLS-2$
				GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainAttributePresentation_VisibleModelType(), this.getGenDomainPresentationModelKind(),
				"visibleModelType", "ALL", 1, 1, GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainAttributePresentation_Order(), ecorePackage.getEInt(), "order", "8000", 0, 1, //$NON-NLS-1$//$NON-NLS-2$
				GenDomainAttributePresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainReferenceEClass, GenDomainReference.class, "GenDomainReference", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainReference_Target(), this.getGenDomainConcept(), null, "target", null, 1, 1, //$NON-NLS-1$
				GenDomainReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainReference_Source(), this.getGenDomainConcept(), null, "source", null, 1, 1, //$NON-NLS-1$
				GenDomainReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainReference_DomainReference(), theUMLPackage.getAssociation(), null, "domainReference", //$NON-NLS-1$
				null, 1, 1, GenDomainReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainAttributeEClass, GenDomainAttribute.class, "GenDomainAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainAttribute_Type(), this.getGenDomainDataType(), null, "type", null, 1, 1, //$NON-NLS-1$
				GenDomainAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainDataTypeEClass, GenDomainDataType.class, "GenDomainDataType", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainDataType_DomainDataType(), theUMLPackage.getDataType(), null, "domainDataType", null, //$NON-NLS-1$
				1, 1, GenDomainDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genAttributeOverrideEClass, GenAttributeOverride.class, "GenAttributeOverride", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenAttributeOverride_Name(), ecorePackage.getEString(), "name", null, 1, 1, //$NON-NLS-1$
				GenAttributeOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainBlockReferenceEClass, GenDomainBlockReference.class, "GenDomainBlockReference", //$NON-NLS-1$
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainBlockReference_Target(), this.getGenDomainBlock(), null, "target", null, 1, 1, //$NON-NLS-1$
				GenDomainBlockReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainBlockReference_DomainBlockReference(), theUMLPackage.getDependency(), null,
				"domainBlockReference", null, 1, 1, GenDomainBlockReference.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenDomainBlockReference_DomainSpecialization(), this.getGenDomainSpecialization(),
				this.getGenDomainSpecialization_DomainBlock(), "domainSpecialization", null, 1, 1, //$NON-NLS-1$
				GenDomainBlockReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainSpecializationEClass, GenDomainSpecialization.class, "GenDomainSpecialization", //$NON-NLS-1$
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainSpecialization_DomainSpecialization(), theUMLPackage.getClass_(), null,
				"domainSpecialization", null, 1, 1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainSpecialization_DomainConcept(), this.getGenDomainConcept(), null, "domainConcept", //$NON-NLS-1$
				null, 0, -1, GenDomainSpecialization.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_PluginName(), ecorePackage.getEString(), "pluginName", null, 1, 1, //$NON-NLS-1$
				GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_ResourceName(), ecorePackage.getEString(), "resourceName", null, 1, 1, //$NON-NLS-1$
				GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenDomainSpecialization_DomainModelLibrary(), this.getGenDomainModelLibraryReference(),
				this.getGenDomainModelLibraryReference_DomainSpecialization(), "domainModelLibrary", null, 0, -1, //$NON-NLS-1$
				GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_ModelLibraryNamesPackage(), ecorePackage.getEString(),
				"modelLibraryNamesPackage", null, 0, 1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_ModelLibrarySourceFolder(), ecorePackage.getEString(),
				"modelLibrarySourceFolder", "src", 0, 1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$//$NON-NLS-2$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_MenuModelResource(), ecorePackage.getEString(), "menuModelResource", //$NON-NLS-1$
				null, 0, 1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_Version(), ecorePackage.getEString(), "version", null, 1, 1, //$NON-NLS-1$
				GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_CodeGenTarget(), ecorePackage.getEString(), "codeGenTarget", null, 1, //$NON-NLS-1$
				1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_RhapsodyJavaProject(), ecorePackage.getEString(),
				"rhapsodyJavaProject", null, 1, 1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_RhapsodyJDTJavaLibrary(), ecorePackage.getEString(),
				"rhapsodyJDTJavaLibrary", "RHAPSODY_API", 1, 1, GenDomainSpecialization.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainSpecialization_ExcludedPaletteItem(), this.getGenPaletteItem(), null,
				"excludedPaletteItem", null, 0, -1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainSpecialization_IncludedUMLMenus(), this.getGenUMLMenu(), null, "includedUMLMenus", //$NON-NLS-1$
				null, 0, -1, GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainSpecialization_DomainBlock(), this.getGenDomainBlockReference(),
				this.getGenDomainBlockReference_DomainSpecialization(), "domainBlock", null, 0, -1, //$NON-NLS-1$
				GenDomainSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenDomainSpecialization_ElementtypeConfigurationContainerUri(), ecorePackage.getEString(),
				"elementtypeConfigurationContainerUri", null, 1, 1, GenDomainSpecialization.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(genDomainSpecializationEClass, ecorePackage.getEString(), "getUniqueName", 1, 1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);
		addEParameter(op, this.getGenDomainClassifier(), "classifier", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(genDomainSpecializationEClass, this.getGenDomainClassifier(), "allClassifiers", 0, -1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);

		op = addEOperation(genDomainSpecializationEClass, ecorePackage.getEBoolean(), "isExcluded", 1, 1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);
		addEParameter(op, this.getGenPaletteItem(), "item", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(genDomainSpecializationEClass, this.getGenDomainConcept(), "getDomainConcepts", 0, -1, IS_UNIQUE, //$NON-NLS-1$
				!IS_ORDERED);

		initEClass(genDomainModelLibraryReferenceEClass, GenDomainModelLibraryReference.class,
				"GenDomainModelLibraryReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getGenDomainModelLibraryReference_Target(), this.getGenDomainModelLibrary(), null, "target", //$NON-NLS-1$
				null, 1, 1, GenDomainModelLibraryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainModelLibraryReference_DomainModelLibraryReference(), theUMLPackage.getDependency(),
				null, "domainModelLibraryReference", null, 1, 1, GenDomainModelLibraryReference.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getGenDomainModelLibraryReference_ResourceName(), ecorePackage.getEString(), "resourceName", //$NON-NLS-1$
				null, 1, 1, GenDomainModelLibraryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainModelLibraryReference_DomainSpecialization(), this.getGenDomainSpecialization(),
				this.getGenDomainSpecialization_DomainModelLibrary(), "domainSpecialization", null, 1, 1, //$NON-NLS-1$
				GenDomainModelLibraryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainModelLibraryEClass, GenDomainModelLibrary.class, "GenDomainModelLibrary", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainModelLibrary_DomainModelLibrary(), theUMLPackage.getPackage(), null,
				"domainModelLibrary", null, 1, 1, GenDomainModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genDomainEnumEClass, GenDomainEnum.class, "GenDomainEnum", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainEnum_Literal(), this.getGenDomainEnumLiteral(),
				this.getGenDomainEnumLiteral_Enumeration(), "literal", null, 0, -1, GenDomainEnum.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEClass(genDomainEnumLiteralEClass, GenDomainEnumLiteral.class, "GenDomainEnumLiteral", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenDomainEnumLiteral_DomainEnumLiteral(), theUMLPackage.getEnumerationLiteral(), null,
				"domainEnumLiteral", null, 1, 1, GenDomainEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenDomainEnumLiteral_Enumeration(), this.getGenDomainEnum(), this.getGenDomainEnum_Literal(),
				"enumeration", null, 1, 1, GenDomainEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genPaletteCreationToolEClass, GenPaletteCreationTool.class, "GenPaletteCreationTool", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPaletteCreationTool_Type(), this.getGenPalettable(), null, "type", null, 0, 1, //$NON-NLS-1$
				GenPaletteCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenPaletteCreationTool_ElementTypeHint(), ecorePackage.getEString(), "elementTypeHint", null, //$NON-NLS-1$
				0, 1, GenPaletteCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenPaletteCreationTool_Expression(), this.getExpression(), null, "expression", null, 0, -1, //$NON-NLS-1$
				GenPaletteCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_Name(), ecorePackage.getEString(), "name", null, 1, 1, Expression.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getExpression_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, //$NON-NLS-1$
				Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		initEClass(genPaletteStackEClass, GenPaletteStack.class, "GenPaletteStack", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPaletteStack_ActiveTool(), this.getGenPaletteTool(), null, "activeTool", null, 0, 1, //$NON-NLS-1$
				GenPaletteStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(oawExpressionEClass, OawExpression.class, "OawExpression", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOawExpression_VariableName(), ecorePackage.getEString(), "variableName", "self", 1, 1, //$NON-NLS-1$//$NON-NLS-2$
				OawExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		initEClass(oawXtendEClass, OawXtend.class, "OawXtend", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOawXtend_ExtensionFile(), ecorePackage.getEString(), "extensionFile", null, 1, 1, //$NON-NLS-1$
				OawXtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuActionEClass, GenMenuAction.class, "GenMenuAction", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(genMenuDelegateActionEClass, GenMenuDelegateAction.class, "GenMenuDelegateAction", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenMenuDelegateAction_HostBundle(), ecorePackage.getEString(), "hostBundle", null, 0, 1, //$NON-NLS-1$
				GenMenuDelegateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGenMenuDelegateAction_ClassName(), ecorePackage.getEString(), "className", null, 1, 1, //$NON-NLS-1$
				GenMenuDelegateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuCreateActionEClass, GenMenuCreateAction.class, "GenMenuCreateAction", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenMenuCreateAction_TypeHint(), ecorePackage.getEString(), "typeHint", null, 0, 1, //$NON-NLS-1$
				GenMenuCreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenMenuCreateAction_CreateConcept(), this.getGenDomainConcept(), null, "createConcept", null, //$NON-NLS-1$
				1, 1, GenMenuCreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGenMenuCreateAction_Expression(), this.getExpression(), null, "expression", null, 0, -1, //$NON-NLS-1$
				GenMenuCreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genMenuSeparatorEClass, GenMenuSeparator.class, "GenMenuSeparator", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.class, "GenPaletteDiagramKind"); //$NON-NLS-1$
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.COMPONENT);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.CONFIGURATION);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.DEPLOYMENT);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.CLASS);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.FREEFORM);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.STRUCTURE);
		addEEnumLiteral(genPaletteDiagramKindEEnum, GenPaletteDiagramKind.STATECHART);

		initEEnum(genAllDomainCassifiersModeEEnum, GenAllDomainCassifiersMode.class, "GenAllDomainCassifiersMode"); //$NON-NLS-1$
		addEEnumLiteral(genAllDomainCassifiersModeEEnum, GenAllDomainCassifiersMode.FLAT);
		addEEnumLiteral(genAllDomainCassifiersModeEEnum, GenAllDomainCassifiersMode.IMPORT);
		addEEnumLiteral(genAllDomainCassifiersModeEEnum, GenAllDomainCassifiersMode.MERGE);
		addEEnumLiteral(genAllDomainCassifiersModeEEnum, GenAllDomainCassifiersMode.MERGE_AND_IMPORT);

		initEEnum(genDomainConceptCategoryEEnum, GenDomainConceptCategory.class, "GenDomainConceptCategory"); //$NON-NLS-1$
		addEEnumLiteral(genDomainConceptCategoryEEnum, GenDomainConceptCategory.ABSTRACT);
		addEEnumLiteral(genDomainConceptCategoryEEnum, GenDomainConceptCategory.FIRM);
		addEEnumLiteral(genDomainConceptCategoryEEnum, GenDomainConceptCategory.UNCERTAIN);

		initEEnum(genDomainAttributePresentationKindEEnum, GenDomainAttributePresentationKind.class,
				"GenDomainAttributePresentationKind"); //$NON-NLS-1$
		addEEnumLiteral(genDomainAttributePresentationKindEEnum, GenDomainAttributePresentationKind.PRIMITIVE);
		addEEnumLiteral(genDomainAttributePresentationKindEEnum, GenDomainAttributePresentationKind.TEXT);
		addEEnumLiteral(genDomainAttributePresentationKindEEnum, GenDomainAttributePresentationKind.MULTI_LINE_TEXT);
		addEEnumLiteral(genDomainAttributePresentationKindEEnum, GenDomainAttributePresentationKind.OTHER);

		initEEnum(genDomainPresentationModelKindEEnum, GenDomainPresentationModelKind.class,
				"GenDomainPresentationModelKind"); //$NON-NLS-1$
		addEEnumLiteral(genDomainPresentationModelKindEEnum, GenDomainPresentationModelKind.ALL);
		addEEnumLiteral(genDomainPresentationModelKindEEnum, GenDomainPresentationModelKind.AXCIOMA);
		addEEnumLiteral(genDomainPresentationModelKindEEnum, GenDomainPresentationModelKind.ATCD);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// subsets
		createSubsetsAnnotations();
		// union
		createUnionAnnotations();
		// redefines
		createRedefinesAnnotations();
	}

	/**
	 * Initializes the annotations for <b>subsets</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSubsetsAnnotations() {
		String source = "subsets"; //$NON-NLS-1$
		addAnnotation(getGenDomainClassifier_Block(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenModel_OwnedModel(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenModel/domainModel"), //$NON-NLS-1$
						URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenModel_ReferencedModel(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenModel/domainModel") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainModel_DomainModel(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainModel_Palette(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainModel_OwningGenModel(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainPackage_Element(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainPackage_DomainPackage(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainPackageableElement_Package(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenPalette_OwnedDrawer(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenPalette/drawer"), //$NON-NLS-1$
						URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenPaletteDrawer_Palette(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenPaletteToolContainer_OwnedTool(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenPaletteToolContainer/tool"), //$NON-NLS-1$
						URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenPaletteTool_Container(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlock_Classifier(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlock_Relation(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlock_DomainBlock(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlock_Import(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainBlock/relation") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlock_Merge(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainBlock/relation") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlockRelation_Source(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainGeneralization_Specific(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainConcept_Feature(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainConcept_DomainConcept(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainConcept_Reference(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainConcept/feature") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainConcept_Attribute(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainConcept/feature") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainConcept_Generalization(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainStructuralFeature_DomainAttribute(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainStructuralFeature_Concept(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainReference_Source(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainStructuralFeature/concept") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainReference_DomainReference(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainDataType_DomainDataType(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainBlockReference_DomainSpecialization(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainSpecialization_DomainSpecialization(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainSpecialization_DomainModelLibrary(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainSpecialization_DomainBlock(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainModelLibraryReference_DomainSpecialization(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainModelLibrary_DomainModelLibrary(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainEnum_Literal(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/ownedObject") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainEnumLiteral_DomainEnumLiteral(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainNamedElement/domainElement") //$NON-NLS-1$
				});
		addAnnotation(getGenDomainEnumLiteral_Enumeration(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainObject/owner") //$NON-NLS-1$
				});
	}

	/**
	 * Initializes the annotations for <b>union</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUnionAnnotations() {
		String source = "union"; //$NON-NLS-1$
		addAnnotation(getGenDomainNamedElement_DomainElement(), source, new String[] {});
		addAnnotation(getGenDomainObject_Owner(), source, new String[] {});
		addAnnotation(getGenDomainObject_OwnedObject(), source, new String[] {});
		addAnnotation(getGenModel_DomainModel(), source, new String[] {});
	}

	/**
	 * Initializes the annotations for <b>redefines</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createRedefinesAnnotations() {
		String source = "redefines"; //$NON-NLS-1$
		addAnnotation(getGenDomainModel_DomainModel(), source, new String[] {},
				new URI[] { URI.createURI(eNS_URI).appendFragment("//GenDomainPackage/domainPackage") //$NON-NLS-1$
				});
	}

} //ZDLGenPackageImpl
