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

import com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenMenuDelegateActionItemProvider extends GenMenuActionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenMenuDelegateActionItemProvider(AdapterFactory adapterFactory) {
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

			addHostBundlePropertyDescriptor(object);
			addClassNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Host Bundle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHostBundlePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenMenuDelegateAction_hostBundle_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenMenuDelegateAction_hostBundle_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenMenuDelegateAction_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DomainMenuPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Class Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenMenuDelegateAction_className_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenMenuDelegateAction_className_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenMenuDelegateAction_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_MENU_DELEGATE_ACTION__CLASS_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DomainMenuPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This returns GenMenuDelegateAction.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenMenuDelegateAction")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenMenuDelegateAction) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenMenuDelegateAction_type") : //$NON-NLS-1$
				getString("_UI_GenMenuDelegateAction_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenMenuDelegateAction.class)) {
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE:
		case ZDLGenPackage.GEN_MENU_DELEGATE_ACTION__CLASS_NAME:
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

}
