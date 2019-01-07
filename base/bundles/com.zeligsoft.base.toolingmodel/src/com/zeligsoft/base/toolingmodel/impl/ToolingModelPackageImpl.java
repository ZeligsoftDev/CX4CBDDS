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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.uml2.uml.UMLPackage;

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
import com.zeligsoft.base.toolingmodel.ToolingModelFactory;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ToolingModelPackageImpl extends EPackageImpl implements
		ToolingModelPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paletteItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paletteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass drawerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass creationToolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkToolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySheetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textualDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegateActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuSeparatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuObjectEClass = null;

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
	private EClass oawBaseExpressionEClass = null;

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
	private EClass propertiesObjectEClass = null;

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
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ToolingModelPackageImpl() {
		super(eNS_URI, ToolingModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ToolingModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ToolingModelPackage init() {
		if (isInited)
			return (ToolingModelPackage) EPackage.Registry.INSTANCE
					.getEPackage(ToolingModelPackage.eNS_URI);

		// Obtain or create and register package
		ToolingModelPackageImpl theToolingModelPackage = (ToolingModelPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ToolingModelPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ToolingModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theToolingModelPackage.createPackageContents();

		// Initialize created meta-data
		theToolingModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theToolingModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ToolingModelPackage.eNS_URI,
				theToolingModelPackage);
		return theToolingModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPaletteItem() {
		return paletteItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPaletteItem_Name() {
		return (EAttribute) paletteItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPaletteItem_Description() {
		return (EAttribute) paletteItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPalette() {
		return paletteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPalette_Drawer() {
		return (EReference) paletteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTool() {
		return toolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolContainer() {
		return toolContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolContainer_Tool() {
		return (EReference) toolContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolContainer_TargetDiagram() {
		return (EAttribute) toolContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDrawer() {
		return drawerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStack() {
		return stackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStack_ActiveTool() {
		return (EReference) stackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreationTool() {
		return creationToolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreationTool_Concept() {
		return (EReference) creationToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreationTool_ElementTypeHint() {
		return (EAttribute) creationToolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreationTool_Expression() {
		return (EReference) creationToolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkTool() {
		return linkToolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkTool_Reference() {
		return (EReference) linkToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySource() {
		return propertySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySource_Definition() {
		return (EReference) propertySourceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertySource_ConceptName() {
		return (EAttribute) propertySourceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertySource_Order() {
		return (EAttribute) propertySourceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDefinition() {
		return propertyDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_ReadOnly() {
		return (EAttribute) propertyDefinitionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_Visible() {
		return (EAttribute) propertyDefinitionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_ContentHint() {
		return (EAttribute) propertyDefinitionEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_Section() {
		return (EAttribute) propertyDefinitionEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySheet() {
		return propertySheetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertySheet_DomainModelURI() {
		return (EAttribute) propertySheetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySheet_PropertySource() {
		return (EReference) propertySheetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySheet_PropertyDefinition() {
		return (EReference) propertySheetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextualDefinition() {
		return textualDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextualDefinition_Width() {
		return (EAttribute) textualDefinitionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextualDefinition_NumRows() {
		return (EAttribute) textualDefinitionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveDefinition() {
		return primitiveDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuModel() {
		return menuModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuModel_Item() {
		return (EReference) menuModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuModel_Menu() {
		return (EReference) menuModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuInstance() {
		return menuInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuInstance_Concept() {
		return (EAttribute) menuInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuInstance_Item() {
		return (EReference) menuInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuModel_Name() {
		return (EAttribute) menuModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuModel_Description() {
		return (EAttribute) menuModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuItem() {
		return menuItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Name() {
		return (EAttribute) menuItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Description() {
		return (EAttribute) menuItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenuItem_Container() {
		return (EReference) menuItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenu() {
		return menuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMenu_Item() {
		return (EReference) menuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuAction() {
		return menuActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateAction() {
		return createActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateAction_CreateConcept() {
		return (EAttribute) createActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateAction_TypeHint() {
		return (EAttribute) createActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateAction_Expression() {
		return (EReference) createActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegateAction() {
		return delegateActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelegateAction_ClassName() {
		return (EAttribute) delegateActionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelegateAction_HostBundle() {
		return (EAttribute) delegateActionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuSeparator() {
		return menuSeparatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuObject() {
		return menuObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuObject_Generated() {
		return (EAttribute) menuObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Name() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Expression() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOawBaseExpression() {
		return oawBaseExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOawBaseExpression_Metamodel() {
		return (EAttribute) oawBaseExpressionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOawExpression() {
		return oawExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOawExpression_VariableName() {
		return (EAttribute) oawExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOawXtend() {
		return oawXtendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOawXtend_ExtensionFile() {
		return (EAttribute) oawXtendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesObject() {
		return propertiesObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolingModelFactory getToolingModelFactory() {
		return (ToolingModelFactory) getEFactoryInstance();
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
		paletteItemEClass = createEClass(PALETTE_ITEM);
		createEAttribute(paletteItemEClass, PALETTE_ITEM__NAME);
		createEAttribute(paletteItemEClass, PALETTE_ITEM__DESCRIPTION);

		paletteEClass = createEClass(PALETTE);
		createEReference(paletteEClass, PALETTE__DRAWER);

		toolEClass = createEClass(TOOL);

		toolContainerEClass = createEClass(TOOL_CONTAINER);
		createEReference(toolContainerEClass, TOOL_CONTAINER__TOOL);
		createEAttribute(toolContainerEClass, TOOL_CONTAINER__TARGET_DIAGRAM);

		drawerEClass = createEClass(DRAWER);

		stackEClass = createEClass(STACK);
		createEReference(stackEClass, STACK__ACTIVE_TOOL);

		creationToolEClass = createEClass(CREATION_TOOL);
		createEReference(creationToolEClass, CREATION_TOOL__CONCEPT);
		createEAttribute(creationToolEClass, CREATION_TOOL__ELEMENT_TYPE_HINT);
		createEReference(creationToolEClass, CREATION_TOOL__EXPRESSION);

		linkToolEClass = createEClass(LINK_TOOL);
		createEReference(linkToolEClass, LINK_TOOL__REFERENCE);

		propertySourceEClass = createEClass(PROPERTY_SOURCE);
		createEReference(propertySourceEClass, PROPERTY_SOURCE__DEFINITION);
		createEAttribute(propertySourceEClass, PROPERTY_SOURCE__CONCEPT_NAME);
		createEAttribute(propertySourceEClass, PROPERTY_SOURCE__ORDER);

		propertyDefinitionEClass = createEClass(PROPERTY_DEFINITION);
		createEAttribute(propertyDefinitionEClass,
				PROPERTY_DEFINITION__READ_ONLY);
		createEAttribute(propertyDefinitionEClass, PROPERTY_DEFINITION__VISIBLE);
		createEAttribute(propertyDefinitionEClass,
				PROPERTY_DEFINITION__CONTENT_HINT);
		createEAttribute(propertyDefinitionEClass, PROPERTY_DEFINITION__SECTION);

		propertySheetEClass = createEClass(PROPERTY_SHEET);
		createEAttribute(propertySheetEClass, PROPERTY_SHEET__DOMAIN_MODEL_URI);
		createEReference(propertySheetEClass, PROPERTY_SHEET__PROPERTY_SOURCE);
		createEReference(propertySheetEClass,
				PROPERTY_SHEET__PROPERTY_DEFINITION);

		textualDefinitionEClass = createEClass(TEXTUAL_DEFINITION);
		createEAttribute(textualDefinitionEClass, TEXTUAL_DEFINITION__WIDTH);
		createEAttribute(textualDefinitionEClass, TEXTUAL_DEFINITION__NUM_ROWS);

		primitiveDefinitionEClass = createEClass(PRIMITIVE_DEFINITION);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		menuModelEClass = createEClass(MENU_MODEL);
		createEAttribute(menuModelEClass, MENU_MODEL__NAME);
		createEAttribute(menuModelEClass, MENU_MODEL__DESCRIPTION);
		createEReference(menuModelEClass, MENU_MODEL__ITEM);
		createEReference(menuModelEClass, MENU_MODEL__MENU);

		menuInstanceEClass = createEClass(MENU_INSTANCE);
		createEAttribute(menuInstanceEClass, MENU_INSTANCE__CONCEPT);
		createEReference(menuInstanceEClass, MENU_INSTANCE__ITEM);

		menuItemEClass = createEClass(MENU_ITEM);
		createEAttribute(menuItemEClass, MENU_ITEM__NAME);
		createEAttribute(menuItemEClass, MENU_ITEM__DESCRIPTION);
		createEReference(menuItemEClass, MENU_ITEM__CONTAINER);

		menuEClass = createEClass(MENU);
		createEReference(menuEClass, MENU__ITEM);

		menuActionEClass = createEClass(MENU_ACTION);

		createActionEClass = createEClass(CREATE_ACTION);
		createEAttribute(createActionEClass, CREATE_ACTION__CREATE_CONCEPT);
		createEAttribute(createActionEClass, CREATE_ACTION__TYPE_HINT);
		createEReference(createActionEClass, CREATE_ACTION__EXPRESSION);

		delegateActionEClass = createEClass(DELEGATE_ACTION);
		createEAttribute(delegateActionEClass, DELEGATE_ACTION__CLASS_NAME);
		createEAttribute(delegateActionEClass, DELEGATE_ACTION__HOST_BUNDLE);

		menuSeparatorEClass = createEClass(MENU_SEPARATOR);

		menuObjectEClass = createEClass(MENU_OBJECT);
		createEAttribute(menuObjectEClass, MENU_OBJECT__GENERATED);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__NAME);
		createEAttribute(expressionEClass, EXPRESSION__EXPRESSION);

		oawBaseExpressionEClass = createEClass(OAW_BASE_EXPRESSION);
		createEAttribute(oawBaseExpressionEClass,
				OAW_BASE_EXPRESSION__METAMODEL);

		oawExpressionEClass = createEClass(OAW_EXPRESSION);
		createEAttribute(oawExpressionEClass, OAW_EXPRESSION__VARIABLE_NAME);

		oawXtendEClass = createEClass(OAW_XTEND);
		createEAttribute(oawXtendEClass, OAW_XTEND__EXTENSION_FILE);

		propertiesObjectEClass = createEClass(PROPERTIES_OBJECT);
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
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE
				.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		paletteEClass.getESuperTypes().add(this.getPaletteItem());
		toolEClass.getESuperTypes().add(this.getPaletteItem());
		toolContainerEClass.getESuperTypes().add(this.getPaletteItem());
		drawerEClass.getESuperTypes().add(this.getToolContainer());
		stackEClass.getESuperTypes().add(this.getTool());
		stackEClass.getESuperTypes().add(this.getToolContainer());
		creationToolEClass.getESuperTypes().add(this.getTool());
		linkToolEClass.getESuperTypes().add(this.getTool());
		propertySourceEClass.getESuperTypes().add(this.getPropertiesObject());
		propertyDefinitionEClass.getESuperTypes().add(this.getNamedElement());
		propertyDefinitionEClass.getESuperTypes().add(
				this.getPropertiesObject());
		propertySheetEClass.getESuperTypes().add(this.getPropertiesObject());
		textualDefinitionEClass.getESuperTypes().add(
				this.getPrimitiveDefinition());
		primitiveDefinitionEClass.getESuperTypes().add(
				this.getPropertyDefinition());
		menuModelEClass.getESuperTypes().add(this.getMenuObject());
		menuInstanceEClass.getESuperTypes().add(this.getMenuObject());
		menuItemEClass.getESuperTypes().add(this.getMenuObject());
		menuEClass.getESuperTypes().add(this.getMenuItem());
		menuActionEClass.getESuperTypes().add(this.getMenuItem());
		createActionEClass.getESuperTypes().add(this.getMenuAction());
		delegateActionEClass.getESuperTypes().add(this.getMenuAction());
		menuSeparatorEClass.getESuperTypes().add(this.getMenuItem());
		oawBaseExpressionEClass.getESuperTypes().add(this.getExpression());
		oawExpressionEClass.getESuperTypes().add(this.getOawBaseExpression());
		oawXtendEClass.getESuperTypes().add(this.getOawBaseExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(
				paletteItemEClass,
				PaletteItem.class,
				"PaletteItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPaletteItem_Name(),
				ecorePackage.getEString(),
				"name", null, 1, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPaletteItem_Description(),
				ecorePackage.getEString(),
				"description", null, 0, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				paletteEClass,
				Palette.class,
				"Palette", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getPalette_Drawer(),
				this.getDrawer(),
				null,
				"drawer", null, 0, -1, Palette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(toolEClass, Tool.class,
				"Tool", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				toolContainerEClass,
				ToolContainer.class,
				"ToolContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getToolContainer_Tool(),
				this.getTool(),
				null,
				"tool", null, 0, -1, ToolContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getToolContainer_TargetDiagram(),
				ecorePackage.getEString(),
				"targetDiagram", null, 0, -1, ToolContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				drawerEClass,
				Drawer.class,
				"Drawer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				stackEClass,
				Stack.class,
				"Stack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getStack_ActiveTool(),
				this.getTool(),
				null,
				"activeTool", null, 0, 1, Stack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				creationToolEClass,
				CreationTool.class,
				"CreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCreationTool_Concept(),
				theUMLPackage.getClass_(),
				null,
				"concept", null, 1, 1, CreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCreationTool_ElementTypeHint(),
				ecorePackage.getEString(),
				"elementTypeHint", null, 0, 1, CreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCreationTool_Expression(),
				this.getExpression(),
				null,
				"expression", null, 0, -1, CreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				linkToolEClass,
				LinkTool.class,
				"LinkTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getLinkTool_Reference(),
				theUMLPackage.getProperty(),
				null,
				"reference", null, 0, 1, LinkTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				propertySourceEClass,
				PropertySource.class,
				"PropertySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getPropertySource_Definition(),
				this.getPropertyDefinition(),
				null,
				"definition", null, 1, -1, PropertySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertySource_ConceptName(),
				ecorePackage.getEString(),
				"conceptName", null, 0, 1, PropertySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertySource_Order(),
				ecorePackage.getEInt(),
				"order", "7326", 0, 1, PropertySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				propertyDefinitionEClass,
				PropertyDefinition.class,
				"PropertyDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPropertyDefinition_ReadOnly(),
				ecorePackage.getEBoolean(),
				"readOnly", "false", 0, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getPropertyDefinition_Visible(),
				ecorePackage.getEBoolean(),
				"visible", "true", 0, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getPropertyDefinition_ContentHint(),
				ecorePackage.getEString(),
				"contentHint", null, 0, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyDefinition_Section(),
				ecorePackage.getEString(),
				"section", null, 0, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				propertySheetEClass,
				PropertySheet.class,
				"PropertySheet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPropertySheet_DomainModelURI(),
				ecorePackage.getEString(),
				"domainModelURI", "", 0, 1, PropertySheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getPropertySheet_PropertySource(),
				this.getPropertySource(),
				null,
				"propertySource", null, 0, -1, PropertySheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPropertySheet_PropertyDefinition(),
				this.getPropertyDefinition(),
				null,
				"propertyDefinition", null, 0, -1, PropertySheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(
				textualDefinitionEClass,
				TextualDefinition.class,
				"TextualDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTextualDefinition_Width(),
				ecorePackage.getEShort(),
				"width", "150", 0, 1, TextualDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getTextualDefinition_NumRows(),
				ecorePackage.getEShort(),
				"numRows", "1", 0, 1, TextualDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				primitiveDefinitionEClass,
				PrimitiveDefinition.class,
				"PrimitiveDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				namedElementEClass,
				NamedElement.class,
				"NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getNamedElement_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuModelEClass,
				MenuModel.class,
				"MenuModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMenuModel_Name(),
				theUMLPackage.getString(),
				"name", null, 1, 1, MenuModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getMenuModel_Description(),
				theUMLPackage.getString(),
				"description", null, 0, 1, MenuModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getMenuModel_Item(),
				this.getMenuItem(),
				null,
				"item", null, 0, -1, MenuModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getMenuModel_Menu(),
				this.getMenuInstance(),
				null,
				"menu", null, 0, -1, MenuModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(menuModelEClass, this.getMenuItem(),
				"getItems", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theUMLPackage.getString(),
				"concept", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuInstanceEClass,
				MenuInstance.class,
				"MenuInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMenuInstance_Concept(),
				theUMLPackage.getString(),
				"concept", null, 1, 1, MenuInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getMenuInstance_Item(),
				this.getMenuItem(),
				null,
				"item", null, 0, -1, MenuInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuItemEClass,
				MenuItem.class,
				"MenuItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMenuItem_Name(),
				theUMLPackage.getString(),
				"name", null, 1, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getMenuItem_Description(),
				theUMLPackage.getString(),
				"description", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getMenuItem_Container(),
				this.getMenu(),
				this.getMenu_Item(),
				"container", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuEClass,
				Menu.class,
				"Menu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getMenu_Item(),
				this.getMenuItem(),
				this.getMenuItem_Container(),
				"item", null, 0, -1, Menu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuActionEClass,
				MenuAction.class,
				"MenuAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				createActionEClass,
				CreateAction.class,
				"CreateAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCreateAction_CreateConcept(),
				theUMLPackage.getString(),
				"createConcept", null, 0, 1, CreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCreateAction_TypeHint(),
				theUMLPackage.getString(),
				"typeHint", null, 0, 1, CreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCreateAction_Expression(),
				this.getExpression(),
				null,
				"expression", null, 0, -1, CreateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				delegateActionEClass,
				DelegateAction.class,
				"DelegateAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getDelegateAction_ClassName(),
				theUMLPackage.getString(),
				"className", null, 1, 1, DelegateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDelegateAction_HostBundle(),
				theUMLPackage.getString(),
				"hostBundle", null, 0, 1, DelegateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				menuSeparatorEClass,
				MenuSeparator.class,
				"MenuSeparator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				menuObjectEClass,
				MenuObject.class,
				"MenuObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMenuObject_Generated(),
				theUMLPackage.getBoolean(),
				"generated", "false", 0, 1, MenuObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				expressionEClass,
				Expression.class,
				"Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getExpression_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getExpression_Expression(),
				ecorePackage.getEString(),
				"expression", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				oawBaseExpressionEClass,
				OawBaseExpression.class,
				"OawBaseExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getOawBaseExpression_Metamodel(),
				ecorePackage.getEString(),
				"metamodel", null, 0, -1, OawBaseExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				oawExpressionEClass,
				OawExpression.class,
				"OawExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getOawExpression_VariableName(),
				ecorePackage.getEString(),
				"variableName", null, 1, 1, OawExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				oawXtendEClass,
				OawXtend.class,
				"OawXtend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getOawXtend_ExtensionFile(),
				ecorePackage.getEString(),
				"extensionFile", null, 1, 1, OawXtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				propertiesObjectEClass,
				PropertiesObject.class,
				"PropertiesObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ToolingModelPackageImpl
