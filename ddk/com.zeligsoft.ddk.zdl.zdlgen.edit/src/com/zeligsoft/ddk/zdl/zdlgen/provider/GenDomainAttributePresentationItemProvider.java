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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainAttributePresentationItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainAttributePresentationItemProvider(AdapterFactory adapterFactory) {
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

			addVisiblePropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addPresentationHintPropertyDescriptor(object);
			addPresentationKindPropertyDescriptor(object);
			addOrderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainAttributePresentation_visible_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainAttributePresentation_visible_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_PresentationPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainAttributePresentation_readOnly_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainAttributePresentation_readOnly_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_PresentationPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Presentation Hint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPresentationHintPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainAttributePresentation_presentationHint_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_presentationHint_feature", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_PresentationPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Presentation Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPresentationKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainAttributePresentation_presentationKind_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_presentationKind_feature", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_PresentationPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Order feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainAttributePresentation_order_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_GenDomainAttributePresentation_order_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString("_UI_PresentationPropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		GenDomainAttributePresentation genDomainAttributePresentation = (GenDomainAttributePresentation) object;
		return getString("_UI_GenDomainAttributePresentation_type") + " " + genDomainAttributePresentation.isVisible(); //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenDomainAttributePresentation.class)) {
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ZDLGenEditPlugin.INSTANCE;
	}

}
