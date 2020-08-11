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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage
 * @generated
 */
public class ZDLGenAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ZDLGenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZDLGenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ZDLGenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ZDLGenSwitch<Adapter> modelSwitch = new ZDLGenSwitch<Adapter>() {
		@Override
		public Adapter caseGenDomainClassifier(GenDomainClassifier object) {
			return createGenDomainClassifierAdapter();
		}

		@Override
		public Adapter caseGenDomainNamedElement(GenDomainNamedElement object) {
			return createGenDomainNamedElementAdapter();
		}

		@Override
		public Adapter caseGenDomainObject(GenDomainObject object) {
			return createGenDomainObjectAdapter();
		}

		@Override
		public Adapter caseGenModel(GenModel object) {
			return createGenModelAdapter();
		}

		@Override
		public Adapter caseGenDomainModel(GenDomainModel object) {
			return createGenDomainModelAdapter();
		}

		@Override
		public Adapter caseGenDomainPackage(GenDomainPackage object) {
			return createGenDomainPackageAdapter();
		}

		@Override
		public Adapter caseGenDomainPackageableElement(GenDomainPackageableElement object) {
			return createGenDomainPackageableElementAdapter();
		}

		@Override
		public Adapter caseGenPalette(GenPalette object) {
			return createGenPaletteAdapter();
		}

		@Override
		public Adapter caseGenPaletteItem(GenPaletteItem object) {
			return createGenPaletteItemAdapter();
		}

		@Override
		public Adapter caseGenPaletteDrawer(GenPaletteDrawer object) {
			return createGenPaletteDrawerAdapter();
		}

		@Override
		public Adapter caseGenPaletteToolContainer(GenPaletteToolContainer object) {
			return createGenPaletteToolContainerAdapter();
		}

		@Override
		public Adapter caseGenPaletteTool(GenPaletteTool object) {
			return createGenPaletteToolAdapter();
		}

		@Override
		public Adapter caseGenMenuModel(GenMenuModel object) {
			return createGenMenuModelAdapter();
		}

		@Override
		public Adapter caseGenMenuItem(GenMenuItem object) {
			return createGenMenuItemAdapter();
		}

		@Override
		public Adapter caseGenUMLMenu(GenUMLMenu object) {
			return createGenUMLMenuAdapter();
		}

		@Override
		public Adapter caseGenMenuTarget(GenMenuTarget object) {
			return createGenMenuTargetAdapter();
		}

		@Override
		public Adapter caseGenMenu(GenMenu object) {
			return createGenMenuAdapter();
		}

		@Override
		public Adapter caseGenDomainBlock(GenDomainBlock object) {
			return createGenDomainBlockAdapter();
		}

		@Override
		public Adapter caseGenDomainBlockRelation(GenDomainBlockRelation object) {
			return createGenDomainBlockRelationAdapter();
		}

		@Override
		public Adapter caseGenDomainBlockImport(GenDomainBlockImport object) {
			return createGenDomainBlockImportAdapter();
		}

		@Override
		public Adapter caseGenDomainBlockMerge(GenDomainBlockMerge object) {
			return createGenDomainBlockMergeAdapter();
		}

		@Override
		public Adapter caseGenDomainGeneralization(GenDomainGeneralization object) {
			return createGenDomainGeneralizationAdapter();
		}

		@Override
		public Adapter caseGenDomainConcept(GenDomainConcept object) {
			return createGenDomainConceptAdapter();
		}

		@Override
		public Adapter caseGenPalettable(GenPalettable object) {
			return createGenPalettableAdapter();
		}

		@Override
		public Adapter caseGenDomainStructuralFeature(GenDomainStructuralFeature object) {
			return createGenDomainStructuralFeatureAdapter();
		}

		@Override
		public Adapter caseGenDomainAttributePresentation(GenDomainAttributePresentation object) {
			return createGenDomainAttributePresentationAdapter();
		}

		@Override
		public Adapter caseGenDomainReference(GenDomainReference object) {
			return createGenDomainReferenceAdapter();
		}

		@Override
		public Adapter caseGenDomainAttribute(GenDomainAttribute object) {
			return createGenDomainAttributeAdapter();
		}

		@Override
		public Adapter caseGenDomainDataType(GenDomainDataType object) {
			return createGenDomainDataTypeAdapter();
		}

		@Override
		public Adapter caseGenAttributeOverride(GenAttributeOverride object) {
			return createGenAttributeOverrideAdapter();
		}

		@Override
		public Adapter caseGenDomainBlockReference(GenDomainBlockReference object) {
			return createGenDomainBlockReferenceAdapter();
		}

		@Override
		public Adapter caseGenDomainSpecialization(GenDomainSpecialization object) {
			return createGenDomainSpecializationAdapter();
		}

		@Override
		public Adapter caseGenDomainModelLibraryReference(GenDomainModelLibraryReference object) {
			return createGenDomainModelLibraryReferenceAdapter();
		}

		@Override
		public Adapter caseGenDomainModelLibrary(GenDomainModelLibrary object) {
			return createGenDomainModelLibraryAdapter();
		}

		@Override
		public Adapter caseGenDomainEnum(GenDomainEnum object) {
			return createGenDomainEnumAdapter();
		}

		@Override
		public Adapter caseGenDomainEnumLiteral(GenDomainEnumLiteral object) {
			return createGenDomainEnumLiteralAdapter();
		}

		@Override
		public Adapter caseGenPaletteCreationTool(GenPaletteCreationTool object) {
			return createGenPaletteCreationToolAdapter();
		}

		@Override
		public Adapter caseExpression(Expression object) {
			return createExpressionAdapter();
		}

		@Override
		public Adapter caseGenPaletteStack(GenPaletteStack object) {
			return createGenPaletteStackAdapter();
		}

		@Override
		public Adapter caseOawExpression(OawExpression object) {
			return createOawExpressionAdapter();
		}

		@Override
		public Adapter caseOawXtend(OawXtend object) {
			return createOawXtendAdapter();
		}

		@Override
		public Adapter caseGenMenuAction(GenMenuAction object) {
			return createGenMenuActionAdapter();
		}

		@Override
		public Adapter caseGenMenuDelegateAction(GenMenuDelegateAction object) {
			return createGenMenuDelegateActionAdapter();
		}

		@Override
		public Adapter caseGenMenuCreateAction(GenMenuCreateAction object) {
			return createGenMenuCreateActionAdapter();
		}

		@Override
		public Adapter caseGenMenuSeparator(GenMenuSeparator object) {
			return createGenMenuSeparatorAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept <em>Gen Domain Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
	 * @generated
	 */
	public Adapter createGenDomainConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalettable <em>Gen Palettable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalettable
	 * @generated
	 */
	public Adapter createGenPalettableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem <em>Gen Palette Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem
	 * @generated
	 */
	public Adapter createGenPaletteItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier <em>Gen Domain Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
	 * @generated
	 */
	public Adapter createGenDomainClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement <em>Gen Domain Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement
	 * @generated
	 */
	public Adapter createGenDomainNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature <em>Gen Domain Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
	 * @generated
	 */
	public Adapter createGenDomainStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization <em>Gen Domain Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization
	 * @generated
	 */
	public Adapter createGenDomainGeneralizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock <em>Gen Domain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
	 * @generated
	 */
	public Adapter createGenDomainBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject <em>Gen Domain Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject
	 * @generated
	 */
	public Adapter createGenDomainObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation <em>Gen Domain Block Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation
	 * @generated
	 */
	public Adapter createGenDomainBlockRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute <em>Gen Domain Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
	 * @generated
	 */
	public Adapter createGenDomainAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType <em>Gen Domain Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType
	 * @generated
	 */
	public Adapter createGenDomainDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride <em>Gen Attribute Override</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride
	 * @generated
	 */
	public Adapter createGenAttributeOverrideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu <em>Gen Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenu
	 * @generated
	 */
	public Adapter createGenMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem <em>Gen Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem
	 * @generated
	 */
	public Adapter createGenMenuItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu <em>Gen UML Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu
	 * @generated
	 */
	public Adapter createGenUMLMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget <em>Gen Menu Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget
	 * @generated
	 */
	public Adapter createGenMenuTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport <em>Gen Domain Block Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport
	 * @generated
	 */
	public Adapter createGenDomainBlockImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge <em>Gen Domain Block Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge
	 * @generated
	 */
	public Adapter createGenDomainBlockMergeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette <em>Gen Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalette
	 * @generated
	 */
	public Adapter createGenPaletteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer <em>Gen Palette Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer
	 * @generated
	 */
	public Adapter createGenPaletteDrawerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer <em>Gen Palette Tool Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer
	 * @generated
	 */
	public Adapter createGenPaletteToolContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool <em>Gen Palette Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool
	 * @generated
	 */
	public Adapter createGenPaletteToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel <em>Gen Menu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel
	 * @generated
	 */
	public Adapter createGenMenuModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference <em>Gen Domain Block Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference
	 * @generated
	 */
	public Adapter createGenDomainBlockReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum <em>Gen Domain Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
	 * @generated
	 */
	public Adapter createGenDomainEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral <em>Gen Domain Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral
	 * @generated
	 */
	public Adapter createGenDomainEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool <em>Gen Palette Creation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool
	 * @generated
	 */
	public Adapter createGenPaletteCreationToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack <em>Gen Palette Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack
	 * @generated
	 */
	public Adapter createGenPaletteStackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.OawExpression <em>Oaw Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawExpression
	 * @generated
	 */
	public Adapter createOawExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.OawXtend <em>Oaw Xtend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawXtend
	 * @generated
	 */
	public Adapter createOawXtendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuAction <em>Gen Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuAction
	 * @generated
	 */
	public Adapter createGenMenuActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction <em>Gen Menu Delegate Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction
	 * @generated
	 */
	public Adapter createGenMenuDelegateActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction <em>Gen Menu Create Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction
	 * @generated
	 */
	public Adapter createGenMenuCreateActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator <em>Gen Menu Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator
	 * @generated
	 */
	public Adapter createGenMenuSeparatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference <em>Gen Domain Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
	 * @generated
	 */
	public Adapter createGenDomainReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation <em>Gen Domain Attribute Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation
	 * @generated
	 */
	public Adapter createGenDomainAttributePresentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization <em>Gen Domain Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization
	 * @generated
	 */
	public Adapter createGenDomainSpecializationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference <em>Gen Domain Model Library Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference
	 * @generated
	 */
	public Adapter createGenDomainModelLibraryReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary <em>Gen Domain Model Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary
	 * @generated
	 */
	public Adapter createGenDomainModelLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel <em>Gen Domain Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
	 * @generated
	 */
	public Adapter createGenDomainModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel <em>Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenModel
	 * @generated
	 */
	public Adapter createGenModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement <em>Gen Domain Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement
	 * @generated
	 */
	public Adapter createGenDomainPackageableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage <em>Gen Domain Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage
	 * @generated
	 */
	public Adapter createGenDomainPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ZDLGenAdapterFactory
