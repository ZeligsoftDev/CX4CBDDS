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
package com.zeligsoft.base.toolingmodel.impl;

import com.zeligsoft.base.toolingmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ToolingModelFactoryImpl extends EFactoryImpl implements ToolingModelFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ToolingModelFactory init() {
		try {
			ToolingModelFactory theToolingModelFactory = (ToolingModelFactory) EPackage.Registry.INSTANCE
					.getEFactory(ToolingModelPackage.eNS_URI);
			if (theToolingModelFactory != null) {
				return theToolingModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ToolingModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolingModelFactoryImpl() {
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
		case ToolingModelPackage.PALETTE:
			return createPalette();
		case ToolingModelPackage.DRAWER:
			return createDrawer();
		case ToolingModelPackage.STACK:
			return createStack();
		case ToolingModelPackage.CREATION_TOOL:
			return createCreationTool();
		case ToolingModelPackage.LINK_TOOL:
			return createLinkTool();
		case ToolingModelPackage.PROPERTY_SOURCE:
			return createPropertySource();
		case ToolingModelPackage.PROPERTY_DEFINITION:
			return createPropertyDefinition();
		case ToolingModelPackage.PROPERTY_SHEET:
			return createPropertySheet();
		case ToolingModelPackage.TEXTUAL_DEFINITION:
			return createTextualDefinition();
		case ToolingModelPackage.PRIMITIVE_DEFINITION:
			return createPrimitiveDefinition();
		case ToolingModelPackage.NAMED_ELEMENT:
			return createNamedElement();
		case ToolingModelPackage.MENU_MODEL:
			return createMenuModel();
		case ToolingModelPackage.MENU_INSTANCE:
			return createMenuInstance();
		case ToolingModelPackage.MENU:
			return createMenu();
		case ToolingModelPackage.CREATE_ACTION:
			return createCreateAction();
		case ToolingModelPackage.DELEGATE_ACTION:
			return createDelegateAction();
		case ToolingModelPackage.MENU_SEPARATOR:
			return createMenuSeparator();
		case ToolingModelPackage.OAW_EXPRESSION:
			return createOawExpression();
		case ToolingModelPackage.OAW_XTEND:
			return createOawXtend();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Palette createPalette() {
		PaletteImpl palette = new PaletteImpl();
		return palette;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Drawer createDrawer() {
		DrawerImpl drawer = new DrawerImpl();
		return drawer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stack createStack() {
		StackImpl stack = new StackImpl();
		return stack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreationTool createCreationTool() {
		CreationToolImpl creationTool = new CreationToolImpl();
		return creationTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkTool createLinkTool() {
		LinkToolImpl linkTool = new LinkToolImpl();
		return linkTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySource createPropertySource() {
		PropertySourceImpl propertySource = new PropertySourceImpl();
		return propertySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDefinition createPropertyDefinition() {
		PropertyDefinitionImpl propertyDefinition = new PropertyDefinitionImpl();
		return propertyDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySheet createPropertySheet() {
		PropertySheetImpl propertySheet = new PropertySheetImpl();
		return propertySheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualDefinition createTextualDefinition() {
		TextualDefinitionImpl textualDefinition = new TextualDefinitionImpl();
		return textualDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveDefinition createPrimitiveDefinition() {
		PrimitiveDefinitionImpl primitiveDefinition = new PrimitiveDefinitionImpl();
		return primitiveDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuModel createMenuModel() {
		MenuModelImpl menuModel = new MenuModelImpl();
		return menuModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuInstance createMenuInstance() {
		MenuInstanceImpl menuInstance = new MenuInstanceImpl();
		return menuInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Menu createMenu() {
		MenuImpl menu = new MenuImpl();
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateAction createCreateAction() {
		CreateActionImpl createAction = new CreateActionImpl();
		return createAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelegateAction createDelegateAction() {
		DelegateActionImpl delegateAction = new DelegateActionImpl();
		return delegateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuSeparator createMenuSeparator() {
		MenuSeparatorImpl menuSeparator = new MenuSeparatorImpl();
		return menuSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OawExpression createOawExpression() {
		OawExpressionImpl oawExpression = new OawExpressionImpl();
		return oawExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OawXtend createOawXtend() {
		OawXtendImpl oawXtend = new OawXtendImpl();
		return oawXtend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolingModelPackage getToolingModelPackage() {
		return (ToolingModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ToolingModelPackage getPackage() {
		return ToolingModelPackage.eINSTANCE;
	}

} //ToolingModelFactoryImpl
