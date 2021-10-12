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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenTargetRegistry;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.DDKCodegenTarget;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainSpecializationItemProvider extends GenDomainPackageableElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainSpecializationItemProvider(AdapterFactory adapterFactory) {
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

			addDomainSpecializationPropertyDescriptor(object);
			addDomainConceptPropertyDescriptor(object);
			addPluginNamePropertyDescriptor(object);
			addResourceNamePropertyDescriptor(object);
			addModelLibraryNamesPackagePropertyDescriptor(object);
			addModelLibrarySourceFolderPropertyDescriptor(object);
			addMenuModelResourcePropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addCodeGenTargetPropertyDescriptor(object);
			addRhapsodyJavaProjectPropertyDescriptor(object);
			addRhapsodyJDTJavaLibraryPropertyDescriptor(object);
			addElementtypeConfigurationContainerUriPropertyDescriptor(object);
			addExcludedPaletteItemPropertyDescriptor(object);
			addIncludedUMLMenusPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Domain Specialization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainSpecializationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_domainSpecialization_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
						"_UI_GenDomainSpecialization_domainSpecialization_feature", "_UI_GenDomainSpecialization_type"), //$NON-NLS-1$ //$NON-NLS-2$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION, false, false, true, null,
				getString("_UI_DomainPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Domain Concept feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainConceptPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_domainConcept_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainSpecialization_domainConcept_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT, false, false, false, null,
				getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Plugin Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPluginNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_pluginName_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_pluginName_feature", "_UI_GenDomainSpecialization_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Resource Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_resourceName_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_resourceName_feature", "_UI_GenDomainSpecialization_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Model Library Names Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelLibraryNamesPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_modelLibraryNamesPackage_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_modelLibraryNamesPackage_feature", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Model Library Source Folder feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelLibrarySourceFolderPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_modelLibrarySourceFolder_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_modelLibrarySourceFolder_feature", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Menu Model Resource feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMenuModelResourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_menuModelResource_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainSpecialization_menuModelResource_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_MenumodelPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_version_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainSpecialization_version_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__VERSION, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Code Gen Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCodeGenTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_codeGenTarget_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainSpecialization_codeGenTarget_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
				null) {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Collection getChoiceOfValues(Object object) {
				return CodegenTargetRegistry.INSTANCE.getTargets();
			}

			@Override
			public Object getPropertyValue(Object object) {
				if (object instanceof GenDomainSpecialization) {
					final GenDomainSpecialization specialization = (GenDomainSpecialization) object;
					final String value = specialization.getCodeGenTarget();

					if (value != null) {
						return CodegenTargetRegistry.INSTANCE.getTarget(value);
					}
				}
				return super.getPropertyValue(object);
			}

			@Override
			public IItemLabelProvider getLabelProvider(Object object) {
				return new IItemLabelProvider() {

					@Override
					public String getText(Object object) {
						String result = null;
						if (object instanceof DDKCodegenTarget) {
							final DDKCodegenTarget extension = (DDKCodegenTarget) object;

							if (extension.getName() != null && !extension.getName().isEmpty()) {
								result = extension.getName();
							} else {
								result = extension.getId();
							}
						}
						return result;
					}

					@Override
					public Object getImage(Object object) {
						return null;
					}
				};
			}

			@Override
			public void setPropertyValue(Object object, Object value) {
				if (object instanceof GenDomainSpecialization) {
					final GenDomainSpecialization specialization = (GenDomainSpecialization) object;

					if (value instanceof DDKCodegenTarget) {
						final EditingDomain editingDomain = getEditingDomain(object);
						final DDKCodegenTarget extension = (DDKCodegenTarget) value;
						final EStructuralFeature feature = ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET;
						final String codegenTarget = extension.getId();

						if (editingDomain == null) {
							specialization.eSet(feature, codegenTarget);
						} else {
							editingDomain.getCommandStack()
									.execute(SetCommand.create(editingDomain, specialization, feature, codegenTarget));
						}
					}
				}
			}
		});
	}

	/**
	 * This adds a property descriptor for the Rhapsody Java Project feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyJavaProjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_rhapsodyJavaProject_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
						"_UI_GenDomainSpecialization_rhapsodyJavaProject_feature", "_UI_GenDomainSpecialization_type"), //$NON-NLS-1$ //$NON-NLS-2$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_RhapsodyPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Rhapsody JDT Java Library feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRhapsodyJDTJavaLibraryPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_rhapsodyJDTJavaLibrary_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_rhapsodyJDTJavaLibrary_feature", //$NON-NLS-1$
								"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_RhapsodyPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Excluded Palette Item feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludedPaletteItemPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainSpecialization_excludedPaletteItem_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainSpecialization_excludedPaletteItem_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM, true, false, true,
						null, getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Included UML Menus feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncludedUMLMenusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_includedUMLMenus_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainSpecialization_includedUMLMenus_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS, true, false, true, null,
				getString("_UI_MenumodelPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Elementtype Configuration Container Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementtypeConfigurationContainerUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainSpecialization_elementtypeConfigurationContainerUri_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
						"_UI_GenDomainSpecialization_elementtypeConfigurationContainerUri_feature", //$NON-NLS-1$
						"_UI_GenDomainSpecialization_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY);
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
	 * This returns GenDomainSpecialization.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenDomainSpecialization")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenDomainSpecialization) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenDomainSpecialization_type") : //$NON-NLS-1$
				getString("_UI_GenDomainSpecialization_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenDomainSpecialization.class)) {
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
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
	}

}
