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
import org.eclipse.emf.ecore.EObject;
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
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenPaletteItemItemProvider extends GenDomainObjectItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteItemItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenPaletteItem_name_feature"), //$NON-NLS-1$
				getString("_UI_GenPaletteItem_name_description"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_PALETTE_ITEM__NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenPaletteItem_description_feature"), //$NON-NLS-1$
				getString("_UI_GenPaletteItem_description_description"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_PALETTE_ITEM__DESCRIPTION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
				null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		GenPaletteItem item = (GenPaletteItem) object;
		EObject palette = item.eContainer();

		while (palette != null && !(palette instanceof GenPalette)) {
			palette = palette.eContainer();
		}

		String modelName = "???"; //$NON-NLS-1$

		if (palette != null) {
			GenDomainModel model = (GenDomainModel) palette.eContainer();
			if (model != null) {
				modelName = model.getName();
				modelName = (modelName == null || modelName.length() == 0) ? "???" : modelName; //$NON-NLS-1$
			}
		}

		String drawerName = item.getName();
		drawerName = (drawerName == null || drawerName.length() == 0) ? "???" : drawerName; //$NON-NLS-1$

		String key = "_Label_" + item.eClass().getName(); //$NON-NLS-1$
		return getResourceLocator().getString(key, new Object[] { modelName, drawerName });
	}

	@Override
	public String getTextForTree(EObject object) {
		String key = "_TreeText_" + object.eClass().getName(); //$NON-NLS-1$
		return getResourceLocator().getString(key, new Object[] { ((GenPaletteItem) object).getName() });
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

		switch (notification.getFeatureID(GenPaletteItem.class)) {
		case ZDLGenPackage.GEN_PALETTE_ITEM__NAME:
		case ZDLGenPackage.GEN_PALETTE_ITEM__DESCRIPTION:
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
