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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenUMLMenuItemProvider extends GenDomainObjectItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenUMLMenuItemProvider(AdapterFactory adapterFactory) {
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
			addUmlMetaclassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
	 * This adds a property descriptor for the Uml Metaclass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUmlMetaclassPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenUMLMenu_umlMetaclass_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenUMLMenu_umlMetaclass_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenUMLMenu_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_UML_MENU__UML_METACLASS, true, false, true, null, null, null));
	}

	/**
	 * This returns GenUMLMenu.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenUMLMenu")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		// This is highly dangerous code that will break when the metamodel
		// is changed it would be much better to make it part of the metamodel
		GenUMLMenu umlMenu = (GenUMLMenu) object;
		GenMenuModel menuModel = (GenMenuModel) umlMenu.eContainer();
		GenDomainModel model = (GenDomainModel) menuModel.eContainer();

		String key = "_Label_" + umlMenu.eClass().getName(); //$NON-NLS-1$
		String name = "???"; //$NON-NLS-1$
		String modelName = model.getName();

		if (umlMenu.getUmlMetaclass() != null) {
			name = umlMenu.getUmlMetaclass().getLabel();
		}

		return getResourceLocator().getString(key, new Object[] { modelName, name });
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

	@Override
	public String getTextForTree(EObject object) {
		String key = "_TreeText_" + object.eClass().getName(); //$NON-NLS-1$
		String name = "???"; //$NON-NLS-1$
		GenUMLMenu umlMenu = (GenUMLMenu) object;

		if (umlMenu.getUmlMetaclass() != null) {
			name = umlMenu.getUmlMetaclass().getLabel();
		}

		return getResourceLocator().getString(key, new Object[] { name });
	}

}
