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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.zeligsoft.base.toolingmodel.CreateAction;
import com.zeligsoft.base.toolingmodel.CreationTool;
import com.zeligsoft.base.toolingmodel.DelegateAction;
import com.zeligsoft.base.toolingmodel.Drawer;
import com.zeligsoft.base.toolingmodel.Expression;
import com.zeligsoft.base.toolingmodel.LinkTool;
import com.zeligsoft.base.toolingmodel.Menu;
import com.zeligsoft.base.toolingmodel.MenuAction;
import com.zeligsoft.base.toolingmodel.MenuInstance;
import com.zeligsoft.base.toolingmodel.MenuItem;
import com.zeligsoft.base.toolingmodel.MenuModel;
import com.zeligsoft.base.toolingmodel.MenuObject;
import com.zeligsoft.base.toolingmodel.MenuSeparator;
import com.zeligsoft.base.toolingmodel.NamedElement;
import com.zeligsoft.base.toolingmodel.OawBaseExpression;
import com.zeligsoft.base.toolingmodel.OawExpression;
import com.zeligsoft.base.toolingmodel.OawXtend;
import com.zeligsoft.base.toolingmodel.Palette;
import com.zeligsoft.base.toolingmodel.PaletteItem;
import com.zeligsoft.base.toolingmodel.PrimitiveDefinition;
import com.zeligsoft.base.toolingmodel.PropertiesObject;
import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.PropertySheet;
import com.zeligsoft.base.toolingmodel.PropertySource;
import com.zeligsoft.base.toolingmodel.Stack;
import com.zeligsoft.base.toolingmodel.TextualDefinition;
import com.zeligsoft.base.toolingmodel.Tool;
import com.zeligsoft.base.toolingmodel.ToolContainer;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

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
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage
 * @generated
 */
public class ToolingModelSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ToolingModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolingModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ToolingModelPackage.eINSTANCE;
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
		case ToolingModelPackage.PALETTE_ITEM: {
			PaletteItem paletteItem = (PaletteItem) theEObject;
			T result = casePaletteItem(paletteItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PALETTE: {
			Palette palette = (Palette) theEObject;
			T result = casePalette(palette);
			if (result == null)
				result = casePaletteItem(palette);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.TOOL: {
			Tool tool = (Tool) theEObject;
			T result = caseTool(tool);
			if (result == null)
				result = casePaletteItem(tool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.TOOL_CONTAINER: {
			ToolContainer toolContainer = (ToolContainer) theEObject;
			T result = caseToolContainer(toolContainer);
			if (result == null)
				result = casePaletteItem(toolContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.DRAWER: {
			Drawer drawer = (Drawer) theEObject;
			T result = caseDrawer(drawer);
			if (result == null)
				result = caseToolContainer(drawer);
			if (result == null)
				result = casePaletteItem(drawer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.STACK: {
			Stack stack = (Stack) theEObject;
			T result = caseStack(stack);
			if (result == null)
				result = caseTool(stack);
			if (result == null)
				result = caseToolContainer(stack);
			if (result == null)
				result = casePaletteItem(stack);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.CREATION_TOOL: {
			CreationTool creationTool = (CreationTool) theEObject;
			T result = caseCreationTool(creationTool);
			if (result == null)
				result = caseTool(creationTool);
			if (result == null)
				result = casePaletteItem(creationTool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.LINK_TOOL: {
			LinkTool linkTool = (LinkTool) theEObject;
			T result = caseLinkTool(linkTool);
			if (result == null)
				result = caseTool(linkTool);
			if (result == null)
				result = casePaletteItem(linkTool);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PROPERTY_SOURCE: {
			PropertySource propertySource = (PropertySource) theEObject;
			T result = casePropertySource(propertySource);
			if (result == null)
				result = casePropertiesObject(propertySource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PROPERTY_DEFINITION: {
			PropertyDefinition propertyDefinition = (PropertyDefinition) theEObject;
			T result = casePropertyDefinition(propertyDefinition);
			if (result == null)
				result = caseNamedElement(propertyDefinition);
			if (result == null)
				result = casePropertiesObject(propertyDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PROPERTY_SHEET: {
			PropertySheet propertySheet = (PropertySheet) theEObject;
			T result = casePropertySheet(propertySheet);
			if (result == null)
				result = casePropertiesObject(propertySheet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.TEXTUAL_DEFINITION: {
			TextualDefinition textualDefinition = (TextualDefinition) theEObject;
			T result = caseTextualDefinition(textualDefinition);
			if (result == null)
				result = casePrimitiveDefinition(textualDefinition);
			if (result == null)
				result = casePropertyDefinition(textualDefinition);
			if (result == null)
				result = caseNamedElement(textualDefinition);
			if (result == null)
				result = casePropertiesObject(textualDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PRIMITIVE_DEFINITION: {
			PrimitiveDefinition primitiveDefinition = (PrimitiveDefinition) theEObject;
			T result = casePrimitiveDefinition(primitiveDefinition);
			if (result == null)
				result = casePropertyDefinition(primitiveDefinition);
			if (result == null)
				result = caseNamedElement(primitiveDefinition);
			if (result == null)
				result = casePropertiesObject(primitiveDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			T result = caseNamedElement(namedElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_MODEL: {
			MenuModel menuModel = (MenuModel) theEObject;
			T result = caseMenuModel(menuModel);
			if (result == null)
				result = caseMenuObject(menuModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_INSTANCE: {
			MenuInstance menuInstance = (MenuInstance) theEObject;
			T result = caseMenuInstance(menuInstance);
			if (result == null)
				result = caseMenuObject(menuInstance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_ITEM: {
			MenuItem menuItem = (MenuItem) theEObject;
			T result = caseMenuItem(menuItem);
			if (result == null)
				result = caseMenuObject(menuItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU: {
			Menu menu = (Menu) theEObject;
			T result = caseMenu(menu);
			if (result == null)
				result = caseMenuItem(menu);
			if (result == null)
				result = caseMenuObject(menu);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_ACTION: {
			MenuAction menuAction = (MenuAction) theEObject;
			T result = caseMenuAction(menuAction);
			if (result == null)
				result = caseMenuItem(menuAction);
			if (result == null)
				result = caseMenuObject(menuAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.CREATE_ACTION: {
			CreateAction createAction = (CreateAction) theEObject;
			T result = caseCreateAction(createAction);
			if (result == null)
				result = caseMenuAction(createAction);
			if (result == null)
				result = caseMenuItem(createAction);
			if (result == null)
				result = caseMenuObject(createAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.DELEGATE_ACTION: {
			DelegateAction delegateAction = (DelegateAction) theEObject;
			T result = caseDelegateAction(delegateAction);
			if (result == null)
				result = caseMenuAction(delegateAction);
			if (result == null)
				result = caseMenuItem(delegateAction);
			if (result == null)
				result = caseMenuObject(delegateAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_SEPARATOR: {
			MenuSeparator menuSeparator = (MenuSeparator) theEObject;
			T result = caseMenuSeparator(menuSeparator);
			if (result == null)
				result = caseMenuItem(menuSeparator);
			if (result == null)
				result = caseMenuObject(menuSeparator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.MENU_OBJECT: {
			MenuObject menuObject = (MenuObject) theEObject;
			T result = caseMenuObject(menuObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.EXPRESSION: {
			Expression expression = (Expression) theEObject;
			T result = caseExpression(expression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.OAW_BASE_EXPRESSION: {
			OawBaseExpression oawBaseExpression = (OawBaseExpression) theEObject;
			T result = caseOawBaseExpression(oawBaseExpression);
			if (result == null)
				result = caseExpression(oawBaseExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.OAW_EXPRESSION: {
			OawExpression oawExpression = (OawExpression) theEObject;
			T result = caseOawExpression(oawExpression);
			if (result == null)
				result = caseOawBaseExpression(oawExpression);
			if (result == null)
				result = caseExpression(oawExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.OAW_XTEND: {
			OawXtend oawXtend = (OawXtend) theEObject;
			T result = caseOawXtend(oawXtend);
			if (result == null)
				result = caseOawBaseExpression(oawXtend);
			if (result == null)
				result = caseExpression(oawXtend);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ToolingModelPackage.PROPERTIES_OBJECT: {
			PropertiesObject propertiesObject = (PropertiesObject) theEObject;
			T result = casePropertiesObject(propertiesObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaletteItem(PaletteItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePalette(Palette object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTool(Tool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolContainer(ToolContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drawer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drawer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDrawer(Drawer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStack(Stack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Creation Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Creation Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreationTool(CreationTool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkTool(LinkTool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySource(PropertySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDefinition(PropertyDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Sheet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySheet(PropertySheet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Textual Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Textual Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextualDefinition(TextualDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveDefinition(PrimitiveDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuModel(MenuModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuInstance(MenuInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuItem(MenuItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenu(Menu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuAction(MenuAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateAction(CreateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegate Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegate Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegateAction(DelegateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Separator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Separator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuSeparator(MenuSeparator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuObject(MenuObject object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Oaw Base Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Oaw Base Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOawBaseExpression(OawBaseExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Properties Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesObject(PropertiesObject object) {
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

} //ToolingModelSwitch
