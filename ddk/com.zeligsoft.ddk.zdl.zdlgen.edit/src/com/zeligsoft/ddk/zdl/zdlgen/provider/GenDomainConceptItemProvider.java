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
package com.zeligsoft.ddk.zdl.zdlgen.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.util.RhapsodyMetaclasses;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainConceptItemProvider extends GenDomainClassifierItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConceptItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMenuPropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addDomainConceptPropertyDescriptor(object);
			addUmlMetaclassPropertyDescriptor(object);
			addGeneralPropertyDescriptor(object);
			addReferencePropertyDescriptor(object);
			addAttributePropertyDescriptor(object);
			addIsRSMSuppressedPropertyDescriptor(object);
			addIsRSMUIReadOnlyPropertyDescriptor(object);
			addIsRSMPropertiesUIReadOnlyPropertyDescriptor(object);
			addIsRhapsodySuppressedPropertyDescriptor(object);
			addRhapsodyMetaclassPropertyDescriptor(object);
			addRhapsodyStereotypeNamePropertyDescriptor(object);
			addRhapsodyAddNewPropertyDescriptor(object);
			addRhapsodyAddNewConceptPropertyDescriptor(object);
			addRhapsodyDisplayNamePropertyDescriptor(object);
			addRhapsodyToAddNewPropertyDescriptor(object);
			addIconUriPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_category_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_category_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__CATEGORY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Domain Concept feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainConceptPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_domainConcept_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_domainConcept_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT, false, false, true, null,
						getString("_UI_DomainPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Uml Metaclass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUmlMetaclassPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_umlMetaclass_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_umlMetaclass_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__UML_METACLASS, true, false, true, null,
						getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						if (object instanceof GenDomainConcept) {
							return getAvailableUMLMetaclasses((GenDomainConcept) object);
						}

						return super.getChoiceOfValues(object);
					}
				});
	}

	/**
	 * Populate the list of values with UML metaclasses only.  If applicable,
	 * the list will be restricted to those that are appropriate for the
	 * specified domain concept.
	 * 
	 * @param concept a domain concept
	 * 
	 * @return the list of UML metaclasses that are appropriate for the concept
	 */
	protected Collection<Class> getAvailableUMLMetaclasses(GenDomainConcept concept) {
		Collection<Class> result = Collections.emptyList();

		Resource resource = concept.eResource();

		if (resource != null) {
			ResourceSet rset = resource.getResourceSet();

			if (rset != null) {
				Resource umlMetamodel = rset.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true);

				if ((umlMetamodel != null) && umlMetamodel.isLoaded()) {
					Package metamodel = (Package) EcoreUtil.getObjectByType(umlMetamodel.getContents(),
							UMLPackage.Literals.PACKAGE);

					if (metamodel != null) {
						result = EcoreUtil.getObjectsByType(metamodel.getOwnedTypes(), UMLPackage.Literals.CLASS);
					}
				}
			}
		}

		return result;
	}

	/**
	 * This adds a property descriptor for the General feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_general_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_general_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__GENERAL, false, false, false, null,
						getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_reference_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_reference_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__REFERENCE, false, false, false, null,
						getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_attribute_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_attribute_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__ATTRIBUTE, false, false, false, null,
						getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Icon Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_iconUri_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_iconUri_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__ICON_URI, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Is RSM Suppressed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsRSMSuppressedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_isRSMSuppressed_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainConcept_isRSMSuppressed_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Is RSMUI Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsRSMUIReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_isRSMUIReadOnly_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainConcept_isRSMUIReadOnly_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Is RSM Properties UI Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsRSMPropertiesUIReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_isRSMPropertiesUIReadOnly_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainConcept_isRSMPropertiesUIReadOnly_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Is Rhapsody Suppressed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsRhapsodySuppressedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_isRhapsodySuppressed_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainConcept_isRhapsodySuppressed_feature", "_UI_GenDomainConcept_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rhapsody Metaclass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRhapsodyMetaclassPropertyDescriptor(Object object) {
		//		itemPropertyDescriptors
		//				.add(createItemPropertyDescriptor(
		//						((ComposeableAdapterFactory) adapterFactory)
		//								.getRootAdapterFactory(),
		//						getResourceLocator(),
		//						getString("_UI_GenDomainConcept_rhapsodyMetaclass_feature"), //$NON-NLS-1$
		//						getString(
		//								"_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_rhapsodyMetaclass_feature", "_UI_GenDomainConcept_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		//						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS,
		//						true, false, false,
		//						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
		//						getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
		//						null));
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyMetaclass_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainConcept_rhapsodyMetaclass_feature", "_UI_GenDomainConcept_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null) {

					/* (non-Javadoc)
					 * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getChoiceOfValues(java.lang.Object)
					 */
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						return RhapsodyMetaclasses.METACLASSES;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Rhapsody Stereotype Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyStereotypeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyStereotypeName_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainConcept_rhapsodyStereotypeName_feature", "_UI_GenDomainConcept_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rhapsody Add New feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRhapsodyAddNewPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyAddNew_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_rhapsodyAddNew_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null) {

					/* (non-Javadoc)
					 * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getChoiceOfValues(java.lang.Object)
					 */
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						return RhapsodyMetaclasses.METACLASSES;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Rhapsody Add New Concept feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyAddNewConceptPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyAddNewConcept_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainConcept_rhapsodyAddNewConcept_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT, true, false, true, null,
						getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rhapsody Display Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyDisplayNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyDisplayName_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainConcept_rhapsodyDisplayName_feature", "_UI_GenDomainConcept_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rhapsody To Add New feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyToAddNewPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainConcept_rhapsodyToAddNew_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainConcept_rhapsodyToAddNew_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainConcept_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW, true, false, true, null,
						getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Menu feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMenuPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenMenuTarget_menu_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenMenuTarget_menu_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenMenuTarget_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_MENU_TARGET__MENU, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__FEATURE);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__GENERALIZATION);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__OVERRIDE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns GenDomainConcept.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenDomainConcept")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = null;
		GenDomainConcept concept = (GenDomainConcept) object;

		if (concept.getDomainConcept() != null) {
			Class domainConcept = concept.getDomainConcept();
			label = domainConcept.getLabel() == null ? "<null>" //$NON-NLS-1$
					: domainConcept.getLabel();
			label = label + " - " //$NON-NLS-1$
					+ domainConcept.getNamespace().getQualifiedName();
		} else {
			label = concept.getName();
		}
		return label == null || label.length() == 0 ? getString("_UI_GenDomainConcept_type") : //$NON-NLS-1$
				label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(GenDomainConcept.class)) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__OVERRIDE,
				ZDLGenFactory.eINSTANCE.createGenAttributeOverride()));
	}

}
