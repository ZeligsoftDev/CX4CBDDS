/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.base.toolingmodel.util;

import com.zeligsoft.base.toolingmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage
 * @generated
 */
public class ToolingModelAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ToolingModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolingModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ToolingModelPackage.eINSTANCE;
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
	protected ToolingModelSwitch<Adapter> modelSwitch = new ToolingModelSwitch<Adapter>() {
		@Override
		public Adapter casePaletteItem(PaletteItem object) {
			return createPaletteItemAdapter();
		}

		@Override
		public Adapter casePalette(Palette object) {
			return createPaletteAdapter();
		}

		@Override
		public Adapter caseTool(Tool object) {
			return createToolAdapter();
		}

		@Override
		public Adapter caseToolContainer(ToolContainer object) {
			return createToolContainerAdapter();
		}

		@Override
		public Adapter caseDrawer(Drawer object) {
			return createDrawerAdapter();
		}

		@Override
		public Adapter caseStack(Stack object) {
			return createStackAdapter();
		}

		@Override
		public Adapter caseCreationTool(CreationTool object) {
			return createCreationToolAdapter();
		}

		@Override
		public Adapter caseLinkTool(LinkTool object) {
			return createLinkToolAdapter();
		}

		@Override
		public Adapter casePropertySource(PropertySource object) {
			return createPropertySourceAdapter();
		}

		@Override
		public Adapter casePropertyDefinition(PropertyDefinition object) {
			return createPropertyDefinitionAdapter();
		}

		@Override
		public Adapter casePropertySheet(PropertySheet object) {
			return createPropertySheetAdapter();
		}

		@Override
		public Adapter caseTextualDefinition(TextualDefinition object) {
			return createTextualDefinitionAdapter();
		}

		@Override
		public Adapter casePrimitiveDefinition(PrimitiveDefinition object) {
			return createPrimitiveDefinitionAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseMenuModel(MenuModel object) {
			return createMenuModelAdapter();
		}

		@Override
		public Adapter caseMenuInstance(MenuInstance object) {
			return createMenuInstanceAdapter();
		}

		@Override
		public Adapter caseMenuItem(MenuItem object) {
			return createMenuItemAdapter();
		}

		@Override
		public Adapter caseMenu(Menu object) {
			return createMenuAdapter();
		}

		@Override
		public Adapter caseMenuAction(MenuAction object) {
			return createMenuActionAdapter();
		}

		@Override
		public Adapter caseCreateAction(CreateAction object) {
			return createCreateActionAdapter();
		}

		@Override
		public Adapter caseDelegateAction(DelegateAction object) {
			return createDelegateActionAdapter();
		}

		@Override
		public Adapter caseMenuSeparator(MenuSeparator object) {
			return createMenuSeparatorAdapter();
		}

		@Override
		public Adapter caseMenuObject(MenuObject object) {
			return createMenuObjectAdapter();
		}

		@Override
		public Adapter caseExpression(Expression object) {
			return createExpressionAdapter();
		}

		@Override
		public Adapter caseOawBaseExpression(OawBaseExpression object) {
			return createOawBaseExpressionAdapter();
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
		public Adapter casePropertiesObject(PropertiesObject object) {
			return createPropertiesObjectAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PaletteItem <em>Palette Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PaletteItem
	 * @generated
	 */
	public Adapter createPaletteItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Palette
	 * @generated
	 */
	public Adapter createPaletteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Tool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Tool
	 * @generated
	 */
	public Adapter createToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.ToolContainer <em>Tool Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.ToolContainer
	 * @generated
	 */
	public Adapter createToolContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Drawer <em>Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Drawer
	 * @generated
	 */
	public Adapter createDrawerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Stack <em>Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Stack
	 * @generated
	 */
	public Adapter createStackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.CreationTool <em>Creation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.CreationTool
	 * @generated
	 */
	public Adapter createCreationToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.LinkTool <em>Link Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.LinkTool
	 * @generated
	 */
	public Adapter createLinkToolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PropertySource <em>Property Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PropertySource
	 * @generated
	 */
	public Adapter createPropertySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition <em>Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition
	 * @generated
	 */
	public Adapter createPropertyDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PropertySheet <em>Property Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PropertySheet
	 * @generated
	 */
	public Adapter createPropertySheetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.TextualDefinition <em>Textual Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.TextualDefinition
	 * @generated
	 */
	public Adapter createTextualDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PrimitiveDefinition <em>Primitive Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PrimitiveDefinition
	 * @generated
	 */
	public Adapter createPrimitiveDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuModel <em>Menu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel
	 * @generated
	 */
	public Adapter createMenuModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuInstance <em>Menu Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuInstance
	 * @generated
	 */
	public Adapter createMenuInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuItem
	 * @generated
	 */
	public Adapter createMenuItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Menu
	 * @generated
	 */
	public Adapter createMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuAction <em>Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuAction
	 * @generated
	 */
	public Adapter createMenuActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.CreateAction <em>Create Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.CreateAction
	 * @generated
	 */
	public Adapter createCreateActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.DelegateAction <em>Delegate Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.DelegateAction
	 * @generated
	 */
	public Adapter createDelegateActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuSeparator <em>Menu Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuSeparator
	 * @generated
	 */
	public Adapter createMenuSeparatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.MenuObject <em>Menu Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.MenuObject
	 * @generated
	 */
	public Adapter createMenuObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.OawBaseExpression <em>Oaw Base Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.OawBaseExpression
	 * @generated
	 */
	public Adapter createOawBaseExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.OawExpression <em>Oaw Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.OawExpression
	 * @generated
	 */
	public Adapter createOawExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.OawXtend <em>Oaw Xtend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.OawXtend
	 * @generated
	 */
	public Adapter createOawXtendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.base.toolingmodel.PropertiesObject <em>Properties Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.base.toolingmodel.PropertiesObject
	 * @generated
	 */
	public Adapter createPropertiesObjectAdapter() {
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

} //ToolingModelAdapterFactory
