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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainModelItemProvider extends GenDomainPackageItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainModelItemProvider(AdapterFactory adapterFactory) {
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

			addDomainModelPropertyDescriptor(object);
			addNsURIPropertyDescriptor(object);
			addRootPackagePropertyDescriptor(object);
			addImplementationSubPackagePropertyDescriptor(object);
			addImplSuffixPropertyDescriptor(object);
			addApiProjectPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Domain Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_domainModel_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainModel_domainModel_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainModel_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__DOMAIN_MODEL, false, false, true, null,
						getString("_UI_DomainPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Ns URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNsURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_nsURI_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainModel_nsURI_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainModel_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__NS_URI, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Root Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRootPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_rootPackage_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainModel_rootPackage_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainModel_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__ROOT_PACKAGE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_StaticAPIPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Implementation Sub Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationSubPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_implementationSubPackage_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainModel_implementationSubPackage_feature", "_UI_GenDomainModel_type"), //$NON-NLS-1$ //$NON-NLS-2$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_StaticAPIPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Impl Suffix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplSuffixPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_implSuffix_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainModel_implSuffix_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainModel_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__IMPL_SUFFIX, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_StaticAPIPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Api Project feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addApiProjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainModel_apiProject_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainModel_apiProject_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainModel_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__API_PROJECT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_StaticAPIPropertyCategory"), //$NON-NLS-1$
						null));
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
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__PALETTE);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__MENU_MODEL);
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
	 * This returns GenDomainModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenDomainModel")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenDomainModel) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenDomainModel_type") : //$NON-NLS-1$
				getString("_UI_GenDomainModel_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenDomainModel.class)) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL__NS_URI:
		case ZDLGenPackage.GEN_DOMAIN_MODEL__ROOT_PACKAGE:
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE:
		case ZDLGenPackage.GEN_DOMAIN_MODEL__IMPL_SUFFIX:
		case ZDLGenPackage.GEN_DOMAIN_MODEL__API_PROJECT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL__PALETTE:
		case ZDLGenPackage.GEN_DOMAIN_MODEL__MENU_MODEL:
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

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__PALETTE,
				ZDLGenFactory.eINSTANCE.createGenPalette()));

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__MENU_MODEL,
				ZDLGenFactory.eINSTANCE.createGenMenuModel()));
	}

}
