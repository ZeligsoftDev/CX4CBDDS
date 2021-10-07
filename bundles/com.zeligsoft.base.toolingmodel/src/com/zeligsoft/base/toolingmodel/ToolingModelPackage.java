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
package com.zeligsoft.base.toolingmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.zeligsoft.base.toolingmodel.ToolingModelFactory
 * @model kind="package"
 * @generated
 */
public interface ToolingModelPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "toolingmodel"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.zeligsoft.com/zdl/2008/tooling"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tool"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ToolingModelPackage eINSTANCE = com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PaletteItemImpl <em>Palette Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PaletteItemImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPaletteItem()
	 * @generated
	 */
	int PALETTE_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_ITEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_ITEM__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Palette Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PaletteImpl <em>Palette</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PaletteImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPalette()
	 * @generated
	 */
	int PALETTE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__NAME = PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__DESCRIPTION = PALETTE_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Drawer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__DRAWER = PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Palette</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_FEATURE_COUNT = PALETTE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.ToolImpl <em>Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getTool()
	 * @generated
	 */
	int TOOL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__NAME = PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__DESCRIPTION = PALETTE_ITEM__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_FEATURE_COUNT = PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl <em>Tool Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getToolContainer()
	 * @generated
	 */
	int TOOL_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONTAINER__NAME = PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONTAINER__DESCRIPTION = PALETTE_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONTAINER__TOOL = PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONTAINER__TARGET_DIAGRAM = PALETTE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tool Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONTAINER_FEATURE_COUNT = PALETTE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.DrawerImpl <em>Drawer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.DrawerImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getDrawer()
	 * @generated
	 */
	int DRAWER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__NAME = TOOL_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__DESCRIPTION = TOOL_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__TOOL = TOOL_CONTAINER__TOOL;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__TARGET_DIAGRAM = TOOL_CONTAINER__TARGET_DIAGRAM;

	/**
	 * The number of structural features of the '<em>Drawer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_FEATURE_COUNT = TOOL_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.StackImpl <em>Stack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.StackImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getStack()
	 * @generated
	 */
	int STACK = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK__NAME = TOOL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK__DESCRIPTION = TOOL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK__TOOL = TOOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK__TARGET_DIAGRAM = TOOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Active Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK__ACTIVE_TOOL = TOOL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FEATURE_COUNT = TOOL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.CreationToolImpl <em>Creation Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.CreationToolImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getCreationTool()
	 * @generated
	 */
	int CREATION_TOOL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL__NAME = TOOL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL__DESCRIPTION = TOOL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL__CONCEPT = TOOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL__ELEMENT_TYPE_HINT = TOOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL__EXPRESSION = TOOL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Creation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_TOOL_FEATURE_COUNT = TOOL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.LinkToolImpl <em>Link Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.LinkToolImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getLinkTool()
	 * @generated
	 */
	int LINK_TOOL = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TOOL__NAME = TOOL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TOOL__DESCRIPTION = TOOL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TOOL__REFERENCE = TOOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TOOL_FEATURE_COUNT = TOOL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertiesObjectImpl <em>Properties Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PropertiesObjectImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertiesObject()
	 * @generated
	 */
	int PROPERTIES_OBJECT = 27;

	/**
	 * The number of structural features of the '<em>Properties Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl <em>Property Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertySource()
	 * @generated
	 */
	int PROPERTY_SOURCE = 8;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SOURCE__DEFINITION = PROPERTIES_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concept Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SOURCE__CONCEPT_NAME = PROPERTIES_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SOURCE__ORDER = PROPERTIES_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SOURCE_FEATURE_COUNT = PROPERTIES_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.NamedElementImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertyDefinition()
	 * @generated
	 */
	int PROPERTY_DEFINITION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__READ_ONLY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__VISIBLE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Content Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__CONTENT_HINT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__SECTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__VISIBLE_MODEL_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl <em>Property Sheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertySheet()
	 * @generated
	 */
	int PROPERTY_SHEET = 10;

	/**
	 * The feature id for the '<em><b>Domain Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SHEET__DOMAIN_MODEL_URI = PROPERTIES_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SHEET__PROPERTY_SOURCE = PROPERTIES_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Definition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SHEET__PROPERTY_DEFINITION = PROPERTIES_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SHEET_FEATURE_COUNT = PROPERTIES_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.PrimitiveDefinitionImpl <em>Primitive Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.PrimitiveDefinitionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPrimitiveDefinition()
	 * @generated
	 */
	int PRIMITIVE_DEFINITION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__READ_ONLY = PROPERTY_DEFINITION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__VISIBLE = PROPERTY_DEFINITION__VISIBLE;

	/**
	 * The feature id for the '<em><b>Content Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__CONTENT_HINT = PROPERTY_DEFINITION__CONTENT_HINT;

	/**
	 * The feature id for the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__SECTION = PROPERTY_DEFINITION__SECTION;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__VISIBLE_MODEL_TYPE = PROPERTY_DEFINITION__VISIBLE_MODEL_TYPE;

	/**
	 * The number of structural features of the '<em>Primitive Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.TextualDefinitionImpl <em>Textual Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.TextualDefinitionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getTextualDefinition()
	 * @generated
	 */
	int TEXTUAL_DEFINITION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__NAME = PRIMITIVE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__READ_ONLY = PRIMITIVE_DEFINITION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__VISIBLE = PRIMITIVE_DEFINITION__VISIBLE;

	/**
	 * The feature id for the '<em><b>Content Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__CONTENT_HINT = PRIMITIVE_DEFINITION__CONTENT_HINT;

	/**
	 * The feature id for the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__SECTION = PRIMITIVE_DEFINITION__SECTION;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__VISIBLE_MODEL_TYPE = PRIMITIVE_DEFINITION__VISIBLE_MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__WIDTH = PRIMITIVE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION__NUM_ROWS = PRIMITIVE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Textual Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_DEFINITION_FEATURE_COUNT = PRIMITIVE_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuObjectImpl <em>Menu Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuObjectImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuObject()
	 * @generated
	 */
	int MENU_OBJECT = 22;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_OBJECT__GENERATED = 0;

	/**
	 * The number of structural features of the '<em>Menu Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuModelImpl <em>Menu Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuModelImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuModel()
	 * @generated
	 */
	int MENU_MODEL = 14;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL__GENERATED = MENU_OBJECT__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL__NAME = MENU_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL__DESCRIPTION = MENU_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL__ITEM = MENU_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL__MENU = MENU_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Menu Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_MODEL_FEATURE_COUNT = MENU_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl <em>Menu Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuInstance()
	 * @generated
	 */
	int MENU_INSTANCE = 15;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_INSTANCE__GENERATED = MENU_OBJECT__GENERATED;

	/**
	 * The feature id for the '<em><b>Concept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_INSTANCE__CONCEPT = MENU_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_INSTANCE__ITEM = MENU_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Menu Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_INSTANCE_FEATURE_COUNT = MENU_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuItemImpl <em>Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuItemImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuItem()
	 * @generated
	 */
	int MENU_ITEM = 16;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__GENERATED = MENU_OBJECT__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__NAME = MENU_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__DESCRIPTION = MENU_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__CONTAINER = MENU_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_FEATURE_COUNT = MENU_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuImpl <em>Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenu()
	 * @generated
	 */
	int MENU = 17;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__GENERATED = MENU_ITEM__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__NAME = MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__DESCRIPTION = MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__CONTAINER = MENU_ITEM__CONTAINER;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ITEM = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuActionImpl <em>Menu Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuActionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuAction()
	 * @generated
	 */
	int MENU_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__GENERATED = MENU_ITEM__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__NAME = MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__DESCRIPTION = MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION__CONTAINER = MENU_ITEM__CONTAINER;

	/**
	 * The number of structural features of the '<em>Menu Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ACTION_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.CreateActionImpl <em>Create Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.CreateActionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getCreateAction()
	 * @generated
	 */
	int CREATE_ACTION = 19;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__GENERATED = MENU_ACTION__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__NAME = MENU_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__DESCRIPTION = MENU_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__CONTAINER = MENU_ACTION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Create Concept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__CREATE_CONCEPT = MENU_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__TYPE_HINT = MENU_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__EXPRESSION = MENU_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION_FEATURE_COUNT = MENU_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.DelegateActionImpl <em>Delegate Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.DelegateActionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getDelegateAction()
	 * @generated
	 */
	int DELEGATE_ACTION = 20;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__GENERATED = MENU_ACTION__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__NAME = MENU_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__DESCRIPTION = MENU_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__CONTAINER = MENU_ACTION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__CLASS_NAME = MENU_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Host Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION__HOST_BUNDLE = MENU_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Delegate Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATE_ACTION_FEATURE_COUNT = MENU_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuSeparatorImpl <em>Menu Separator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.MenuSeparatorImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuSeparator()
	 * @generated
	 */
	int MENU_SEPARATOR = 21;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_SEPARATOR__GENERATED = MENU_ITEM__GENERATED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_SEPARATOR__NAME = MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_SEPARATOR__DESCRIPTION = MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_SEPARATOR__CONTAINER = MENU_ITEM__CONTAINER;

	/**
	 * The number of structural features of the '<em>Menu Separator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_SEPARATOR_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.ExpressionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.OawBaseExpressionImpl <em>Oaw Base Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.OawBaseExpressionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawBaseExpression()
	 * @generated
	 */
	int OAW_BASE_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_BASE_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_BASE_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_BASE_EXPRESSION__METAMODEL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Oaw Base Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_BASE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.OawExpressionImpl <em>Oaw Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.OawExpressionImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawExpression()
	 * @generated
	 */
	int OAW_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__NAME = OAW_BASE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__EXPRESSION = OAW_BASE_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__METAMODEL = OAW_BASE_EXPRESSION__METAMODEL;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__VARIABLE_NAME = OAW_BASE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Oaw Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION_FEATURE_COUNT = OAW_BASE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.toolingmodel.impl.OawXtendImpl <em>Oaw Xtend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.toolingmodel.impl.OawXtendImpl
	 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawXtend()
	 * @generated
	 */
	int OAW_XTEND = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__NAME = OAW_BASE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__EXPRESSION = OAW_BASE_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__METAMODEL = OAW_BASE_EXPRESSION__METAMODEL;

	/**
	 * The feature id for the '<em><b>Extension File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__EXTENSION_FILE = OAW_BASE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Oaw Xtend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND_FEATURE_COUNT = OAW_BASE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PaletteItem <em>Palette Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette Item</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PaletteItem
	 * @generated
	 */
	EClass getPaletteItem();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PaletteItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PaletteItem#getName()
	 * @see #getPaletteItem()
	 * @generated
	 */
	EAttribute getPaletteItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PaletteItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PaletteItem#getDescription()
	 * @see #getPaletteItem()
	 * @generated
	 */
	EAttribute getPaletteItem_Description();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Palette
	 * @generated
	 */
	EClass getPalette();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.Palette#getDrawer <em>Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Drawer</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Palette#getDrawer()
	 * @see #getPalette()
	 * @generated
	 */
	EReference getPalette_Drawer();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Tool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Tool
	 * @generated
	 */
	EClass getTool();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.ToolContainer <em>Tool Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Container</em>'.
	 * @see com.zeligsoft.base.toolingmodel.ToolContainer
	 * @generated
	 */
	EClass getToolContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.ToolContainer#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tool</em>'.
	 * @see com.zeligsoft.base.toolingmodel.ToolContainer#getTool()
	 * @see #getToolContainer()
	 * @generated
	 */
	EReference getToolContainer_Tool();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.base.toolingmodel.ToolContainer#getTargetDiagram <em>Target Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Target Diagram</em>'.
	 * @see com.zeligsoft.base.toolingmodel.ToolContainer#getTargetDiagram()
	 * @see #getToolContainer()
	 * @generated
	 */
	EAttribute getToolContainer_TargetDiagram();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Drawer <em>Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drawer</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Drawer
	 * @generated
	 */
	EClass getDrawer();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Stack <em>Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Stack
	 * @generated
	 */
	EClass getStack();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.base.toolingmodel.Stack#getActiveTool <em>Active Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Tool</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Stack#getActiveTool()
	 * @see #getStack()
	 * @generated
	 */
	EReference getStack_ActiveTool();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.CreationTool <em>Creation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creation Tool</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreationTool
	 * @generated
	 */
	EClass getCreationTool();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.base.toolingmodel.CreationTool#getConcept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Concept</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreationTool#getConcept()
	 * @see #getCreationTool()
	 * @generated
	 */
	EReference getCreationTool_Concept();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.CreationTool#getElementTypeHint <em>Element Type Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type Hint</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreationTool#getElementTypeHint()
	 * @see #getCreationTool()
	 * @generated
	 */
	EAttribute getCreationTool_ElementTypeHint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.CreationTool#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreationTool#getExpression()
	 * @see #getCreationTool()
	 * @generated
	 */
	EReference getCreationTool_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.LinkTool <em>Link Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Tool</em>'.
	 * @see com.zeligsoft.base.toolingmodel.LinkTool
	 * @generated
	 */
	EClass getLinkTool();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.base.toolingmodel.LinkTool#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see com.zeligsoft.base.toolingmodel.LinkTool#getReference()
	 * @see #getLinkTool()
	 * @generated
	 */
	EReference getLinkTool_Reference();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PropertySource <em>Property Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Source</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySource
	 * @generated
	 */
	EClass getPropertySource();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.base.toolingmodel.PropertySource#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Definition</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySource#getDefinition()
	 * @see #getPropertySource()
	 * @generated
	 */
	EReference getPropertySource_Definition();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertySource#getConceptName <em>Concept Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concept Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySource#getConceptName()
	 * @see #getPropertySource()
	 * @generated
	 */
	EAttribute getPropertySource_ConceptName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertySource#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySource#getOrder()
	 * @see #getPropertySource()
	 * @generated
	 */
	EAttribute getPropertySource_Order();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition <em>Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Definition</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition
	 * @generated
	 */
	EClass getPropertyDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition#isReadOnly()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition#isVisible()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_Visible();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getContentHint <em>Content Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Hint</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition#getContentHint()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_ContentHint();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition#getSection()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_Section();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getVisibleModelType <em>Visible Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible Model Type</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertyDefinition#getVisibleModelType()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_VisibleModelType();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PropertySheet <em>Property Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Sheet</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySheet
	 * @generated
	 */
	EClass getPropertySheet();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.PropertySheet#getDomainModelURI <em>Domain Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Model URI</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySheet#getDomainModelURI()
	 * @see #getPropertySheet()
	 * @generated
	 */
	EAttribute getPropertySheet_DomainModelURI();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.PropertySheet#getPropertySource <em>Property Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Source</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySheet#getPropertySource()
	 * @see #getPropertySheet()
	 * @generated
	 */
	EReference getPropertySheet_PropertySource();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.PropertySheet#getPropertyDefinition <em>Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Definition</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertySheet#getPropertyDefinition()
	 * @see #getPropertySheet()
	 * @generated
	 */
	EReference getPropertySheet_PropertyDefinition();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.TextualDefinition <em>Textual Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textual Definition</em>'.
	 * @see com.zeligsoft.base.toolingmodel.TextualDefinition
	 * @generated
	 */
	EClass getTextualDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see com.zeligsoft.base.toolingmodel.TextualDefinition#getWidth()
	 * @see #getTextualDefinition()
	 * @generated
	 */
	EAttribute getTextualDefinition_Width();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getNumRows <em>Num Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Rows</em>'.
	 * @see com.zeligsoft.base.toolingmodel.TextualDefinition#getNumRows()
	 * @see #getTextualDefinition()
	 * @generated
	 */
	EAttribute getTextualDefinition_NumRows();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PrimitiveDefinition <em>Primitive Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Definition</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PrimitiveDefinition
	 * @generated
	 */
	EClass getPrimitiveDefinition();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see com.zeligsoft.base.toolingmodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuModel <em>Menu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Model</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel
	 * @generated
	 */
	EClass getMenuModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.MenuModel#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Item</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel#getItem()
	 * @see #getMenuModel()
	 * @generated
	 */
	EReference getMenuModel_Item();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.MenuModel#getMenu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Menu</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel#getMenu()
	 * @see #getMenuModel()
	 * @generated
	 */
	EReference getMenuModel_Menu();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuInstance <em>Menu Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Instance</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuInstance
	 * @generated
	 */
	EClass getMenuInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuInstance#getConcept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concept</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuInstance#getConcept()
	 * @see #getMenuInstance()
	 * @generated
	 */
	EAttribute getMenuInstance_Concept();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.base.toolingmodel.MenuInstance#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Item</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuInstance#getItem()
	 * @see #getMenuInstance()
	 * @generated
	 */
	EReference getMenuInstance_Item();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel#getName()
	 * @see #getMenuModel()
	 * @generated
	 */
	EAttribute getMenuModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuModel#getDescription()
	 * @see #getMenuModel()
	 * @generated
	 */
	EAttribute getMenuModel_Description();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuItem
	 * @generated
	 */
	EClass getMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuItem#getName()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuItem#getDescription()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Description();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.base.toolingmodel.MenuItem#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuItem#getContainer()
	 * @see #getMenuItem()
	 * @generated
	 */
	EReference getMenuItem_Container();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Menu
	 * @generated
	 */
	EClass getMenu();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.Menu#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Item</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Menu#getItem()
	 * @see #getMenu()
	 * @generated
	 */
	EReference getMenu_Item();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuAction <em>Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Action</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuAction
	 * @generated
	 */
	EClass getMenuAction();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.CreateAction <em>Create Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Action</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreateAction
	 * @generated
	 */
	EClass getCreateAction();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.CreateAction#getCreateConcept <em>Create Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Concept</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreateAction#getCreateConcept()
	 * @see #getCreateAction()
	 * @generated
	 */
	EAttribute getCreateAction_CreateConcept();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.CreateAction#getTypeHint <em>Type Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Hint</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreateAction#getTypeHint()
	 * @see #getCreateAction()
	 * @generated
	 */
	EAttribute getCreateAction_TypeHint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.toolingmodel.CreateAction#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.CreateAction#getExpression()
	 * @see #getCreateAction()
	 * @generated
	 */
	EReference getCreateAction_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.DelegateAction <em>Delegate Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegate Action</em>'.
	 * @see com.zeligsoft.base.toolingmodel.DelegateAction
	 * @generated
	 */
	EClass getDelegateAction();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.DelegateAction#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.DelegateAction#getClassName()
	 * @see #getDelegateAction()
	 * @generated
	 */
	EAttribute getDelegateAction_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.DelegateAction#getHostBundle <em>Host Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host Bundle</em>'.
	 * @see com.zeligsoft.base.toolingmodel.DelegateAction#getHostBundle()
	 * @see #getDelegateAction()
	 * @generated
	 */
	EAttribute getDelegateAction_HostBundle();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuSeparator <em>Menu Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Separator</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuSeparator
	 * @generated
	 */
	EClass getMenuSeparator();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.MenuObject <em>Menu Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Object</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuObject
	 * @generated
	 */
	EClass getMenuObject();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.MenuObject#isGenerated <em>Generated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated</em>'.
	 * @see com.zeligsoft.base.toolingmodel.MenuObject#isGenerated()
	 * @see #getMenuObject()
	 * @generated
	 */
	EAttribute getMenuObject_Generated();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.Expression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Expression#getName()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.Expression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.Expression#getExpression()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.OawBaseExpression <em>Oaw Base Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oaw Base Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawBaseExpression
	 * @generated
	 */
	EClass getOawBaseExpression();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.base.toolingmodel.OawBaseExpression#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Metamodel</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawBaseExpression#getMetamodel()
	 * @see #getOawBaseExpression()
	 * @generated
	 */
	EAttribute getOawBaseExpression_Metamodel();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.OawExpression <em>Oaw Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oaw Expression</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawExpression
	 * @generated
	 */
	EClass getOawExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.OawExpression#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawExpression#getVariableName()
	 * @see #getOawExpression()
	 * @generated
	 */
	EAttribute getOawExpression_VariableName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.OawXtend <em>Oaw Xtend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oaw Xtend</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawXtend
	 * @generated
	 */
	EClass getOawXtend();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.toolingmodel.OawXtend#getExtensionFile <em>Extension File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension File</em>'.
	 * @see com.zeligsoft.base.toolingmodel.OawXtend#getExtensionFile()
	 * @see #getOawXtend()
	 * @generated
	 */
	EAttribute getOawXtend_ExtensionFile();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.toolingmodel.PropertiesObject <em>Properties Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Object</em>'.
	 * @see com.zeligsoft.base.toolingmodel.PropertiesObject
	 * @generated
	 */
	EClass getPropertiesObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ToolingModelFactory getToolingModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PaletteItemImpl <em>Palette Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PaletteItemImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPaletteItem()
		 * @generated
		 */
		EClass PALETTE_ITEM = eINSTANCE.getPaletteItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PALETTE_ITEM__NAME = eINSTANCE.getPaletteItem_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PALETTE_ITEM__DESCRIPTION = eINSTANCE.getPaletteItem_Description();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PaletteImpl <em>Palette</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PaletteImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPalette()
		 * @generated
		 */
		EClass PALETTE = eINSTANCE.getPalette();

		/**
		 * The meta object literal for the '<em><b>Drawer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PALETTE__DRAWER = eINSTANCE.getPalette_Drawer();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.ToolImpl <em>Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getTool()
		 * @generated
		 */
		EClass TOOL = eINSTANCE.getTool();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl <em>Tool Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getToolContainer()
		 * @generated
		 */
		EClass TOOL_CONTAINER = eINSTANCE.getToolContainer();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_CONTAINER__TOOL = eINSTANCE.getToolContainer_Tool();

		/**
		 * The meta object literal for the '<em><b>Target Diagram</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_CONTAINER__TARGET_DIAGRAM = eINSTANCE.getToolContainer_TargetDiagram();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.DrawerImpl <em>Drawer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.DrawerImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getDrawer()
		 * @generated
		 */
		EClass DRAWER = eINSTANCE.getDrawer();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.StackImpl <em>Stack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.StackImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getStack()
		 * @generated
		 */
		EClass STACK = eINSTANCE.getStack();

		/**
		 * The meta object literal for the '<em><b>Active Tool</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK__ACTIVE_TOOL = eINSTANCE.getStack_ActiveTool();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.CreationToolImpl <em>Creation Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.CreationToolImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getCreationTool()
		 * @generated
		 */
		EClass CREATION_TOOL = eINSTANCE.getCreationTool();

		/**
		 * The meta object literal for the '<em><b>Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATION_TOOL__CONCEPT = eINSTANCE.getCreationTool_Concept();

		/**
		 * The meta object literal for the '<em><b>Element Type Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATION_TOOL__ELEMENT_TYPE_HINT = eINSTANCE.getCreationTool_ElementTypeHint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATION_TOOL__EXPRESSION = eINSTANCE.getCreationTool_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.LinkToolImpl <em>Link Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.LinkToolImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getLinkTool()
		 * @generated
		 */
		EClass LINK_TOOL = eINSTANCE.getLinkTool();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TOOL__REFERENCE = eINSTANCE.getLinkTool_Reference();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl <em>Property Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertySource()
		 * @generated
		 */
		EClass PROPERTY_SOURCE = eINSTANCE.getPropertySource();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SOURCE__DEFINITION = eINSTANCE.getPropertySource_Definition();

		/**
		 * The meta object literal for the '<em><b>Concept Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_SOURCE__CONCEPT_NAME = eINSTANCE.getPropertySource_ConceptName();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_SOURCE__ORDER = eINSTANCE.getPropertySource_Order();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertyDefinition()
		 * @generated
		 */
		EClass PROPERTY_DEFINITION = eINSTANCE.getPropertyDefinition();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__READ_ONLY = eINSTANCE.getPropertyDefinition_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__VISIBLE = eINSTANCE.getPropertyDefinition_Visible();

		/**
		 * The meta object literal for the '<em><b>Content Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__CONTENT_HINT = eINSTANCE.getPropertyDefinition_ContentHint();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__SECTION = eINSTANCE.getPropertyDefinition_Section();

		/**
		 * The meta object literal for the '<em><b>Visible Model Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__VISIBLE_MODEL_TYPE = eINSTANCE.getPropertyDefinition_VisibleModelType();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl <em>Property Sheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertySheet()
		 * @generated
		 */
		EClass PROPERTY_SHEET = eINSTANCE.getPropertySheet();

		/**
		 * The meta object literal for the '<em><b>Domain Model URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_SHEET__DOMAIN_MODEL_URI = eINSTANCE.getPropertySheet_DomainModelURI();

		/**
		 * The meta object literal for the '<em><b>Property Source</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SHEET__PROPERTY_SOURCE = eINSTANCE.getPropertySheet_PropertySource();

		/**
		 * The meta object literal for the '<em><b>Property Definition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SHEET__PROPERTY_DEFINITION = eINSTANCE.getPropertySheet_PropertyDefinition();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.TextualDefinitionImpl <em>Textual Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.TextualDefinitionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getTextualDefinition()
		 * @generated
		 */
		EClass TEXTUAL_DEFINITION = eINSTANCE.getTextualDefinition();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTUAL_DEFINITION__WIDTH = eINSTANCE.getTextualDefinition_Width();

		/**
		 * The meta object literal for the '<em><b>Num Rows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTUAL_DEFINITION__NUM_ROWS = eINSTANCE.getTextualDefinition_NumRows();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PrimitiveDefinitionImpl <em>Primitive Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PrimitiveDefinitionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPrimitiveDefinition()
		 * @generated
		 */
		EClass PRIMITIVE_DEFINITION = eINSTANCE.getPrimitiveDefinition();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.NamedElementImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuModelImpl <em>Menu Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuModelImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuModel()
		 * @generated
		 */
		EClass MENU_MODEL = eINSTANCE.getMenuModel();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_MODEL__ITEM = eINSTANCE.getMenuModel_Item();

		/**
		 * The meta object literal for the '<em><b>Menu</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_MODEL__MENU = eINSTANCE.getMenuModel_Menu();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl <em>Menu Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuInstance()
		 * @generated
		 */
		EClass MENU_INSTANCE = eINSTANCE.getMenuInstance();

		/**
		 * The meta object literal for the '<em><b>Concept</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_INSTANCE__CONCEPT = eINSTANCE.getMenuInstance_Concept();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_INSTANCE__ITEM = eINSTANCE.getMenuInstance_Item();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_MODEL__NAME = eINSTANCE.getMenuModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_MODEL__DESCRIPTION = eINSTANCE.getMenuModel_Description();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuItemImpl <em>Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuItemImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuItem()
		 * @generated
		 */
		EClass MENU_ITEM = eINSTANCE.getMenuItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__NAME = eINSTANCE.getMenuItem_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__DESCRIPTION = eINSTANCE.getMenuItem_Description();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_ITEM__CONTAINER = eINSTANCE.getMenuItem_Container();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuImpl <em>Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenu()
		 * @generated
		 */
		EClass MENU = eINSTANCE.getMenu();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU__ITEM = eINSTANCE.getMenu_Item();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuActionImpl <em>Menu Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuActionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuAction()
		 * @generated
		 */
		EClass MENU_ACTION = eINSTANCE.getMenuAction();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.CreateActionImpl <em>Create Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.CreateActionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getCreateAction()
		 * @generated
		 */
		EClass CREATE_ACTION = eINSTANCE.getCreateAction();

		/**
		 * The meta object literal for the '<em><b>Create Concept</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_ACTION__CREATE_CONCEPT = eINSTANCE.getCreateAction_CreateConcept();

		/**
		 * The meta object literal for the '<em><b>Type Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_ACTION__TYPE_HINT = eINSTANCE.getCreateAction_TypeHint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_ACTION__EXPRESSION = eINSTANCE.getCreateAction_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.DelegateActionImpl <em>Delegate Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.DelegateActionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getDelegateAction()
		 * @generated
		 */
		EClass DELEGATE_ACTION = eINSTANCE.getDelegateAction();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELEGATE_ACTION__CLASS_NAME = eINSTANCE.getDelegateAction_ClassName();

		/**
		 * The meta object literal for the '<em><b>Host Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELEGATE_ACTION__HOST_BUNDLE = eINSTANCE.getDelegateAction_HostBundle();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuSeparatorImpl <em>Menu Separator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuSeparatorImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuSeparator()
		 * @generated
		 */
		EClass MENU_SEPARATOR = eINSTANCE.getMenuSeparator();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.MenuObjectImpl <em>Menu Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.MenuObjectImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getMenuObject()
		 * @generated
		 */
		EClass MENU_OBJECT = eINSTANCE.getMenuObject();

		/**
		 * The meta object literal for the '<em><b>Generated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_OBJECT__GENERATED = eINSTANCE.getMenuObject_Generated();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.ExpressionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__NAME = eINSTANCE.getExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.OawBaseExpressionImpl <em>Oaw Base Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.OawBaseExpressionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawBaseExpression()
		 * @generated
		 */
		EClass OAW_BASE_EXPRESSION = eINSTANCE.getOawBaseExpression();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAW_BASE_EXPRESSION__METAMODEL = eINSTANCE.getOawBaseExpression_Metamodel();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.OawExpressionImpl <em>Oaw Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.OawExpressionImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawExpression()
		 * @generated
		 */
		EClass OAW_EXPRESSION = eINSTANCE.getOawExpression();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAW_EXPRESSION__VARIABLE_NAME = eINSTANCE.getOawExpression_VariableName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.OawXtendImpl <em>Oaw Xtend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.OawXtendImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getOawXtend()
		 * @generated
		 */
		EClass OAW_XTEND = eINSTANCE.getOawXtend();

		/**
		 * The meta object literal for the '<em><b>Extension File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAW_XTEND__EXTENSION_FILE = eINSTANCE.getOawXtend_ExtensionFile();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.toolingmodel.impl.PropertiesObjectImpl <em>Properties Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.toolingmodel.impl.PropertiesObjectImpl
		 * @see com.zeligsoft.base.toolingmodel.impl.ToolingModelPackageImpl#getPropertiesObject()
		 * @generated
		 */
		EClass PROPERTIES_OBJECT = eINSTANCE.getPropertiesObject();

	}

} //ToolingModelPackage
