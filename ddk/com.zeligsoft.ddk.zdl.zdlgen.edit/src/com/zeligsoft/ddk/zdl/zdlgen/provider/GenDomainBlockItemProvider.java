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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainBlockItemProvider extends GenDomainPackageableElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainBlockItemProvider(AdapterFactory adapterFactory) {
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

			addDomainBlockPropertyDescriptor(object);
			addImportPropertyDescriptor(object);
			addMergePropertyDescriptor(object);
			addRsmStereotypesSuppressedPropertyDescriptor(object);
			addRsmStereotypesUIReadOnlyPropertyDescriptor(object);
			addRsmStereotypesPropertiesUIReadOnlyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Domain Block feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainBlockPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainBlock_domainBlock_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainBlock_domainBlock_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainBlock_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK, false, false, true, null,
						getString("_UI_DomainPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Import feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainBlock_import_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainBlock_import_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainBlock_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__IMPORT, false, false, false, null,
						getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Merge feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMergePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainBlock_merge_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_GenDomainBlock_merge_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_GenDomainBlock_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__MERGE, false, false, false, null,
						getString("_UI_ZDLGeneratorPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rsm Stereotypes Suppressed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRsmStereotypesSuppressedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainBlock_rsmStereotypesSuppressed_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainBlock_rsmStereotypesSuppressed_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rsm Stereotypes UI Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRsmStereotypesUIReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainBlock_rsmStereotypesUIReadOnly_feature"), //$NON-NLS-1$
						getString("_UI_GenDomainBlock_rsmStereotypesUIReadOnly_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Rsm Stereotypes Properties UI Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRsmStereotypesPropertiesUIReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenDomainBlock_rsmStereotypesPropertiesUIReadOnly_feature"), //$NON-NLS-1$
				getString("_UI_GenDomainBlock_rsmStereotypesPropertiesUIReadOnly_description"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_RSMPropertyCategory"), //$NON-NLS-1$
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
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__CLASSIFIER);
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RELATION);
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
	 * This returns GenDomainBlock.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenDomainBlock")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenDomainBlock) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenDomainBlock_type") : //$NON-NLS-1$
				getString("_UI_GenDomainBlock_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenDomainBlock.class)) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT:
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE:
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED:
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY:
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
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
