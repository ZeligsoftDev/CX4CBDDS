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
package com.zeligsoft.ce.deployment.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.ENamedElementItemProvider;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.zeligsoft.ce.deployment.DeploymentFactory;
import com.zeligsoft.ce.deployment.DeploymentPackage;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ce.deployment.DeploymentPart} object.
 * <!-- begin-user-doc -->
 * For the moment when you re-generate the edit code you need to re-add ITableItemLabelProvider to the
 * implements list below or else the simple table viewer will not display properly.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentPartItemProvider
	extends ENamedElementItemProvider
	implements	
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
		{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public static final String copyright = "* Copyright (c) 2008 Zeligsoft Inc.\r\n *\r\n * All rights reserved. \r\n *  \r\n * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND\r\n * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, \r\n * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,\r\n * IS STRICTLY PROHIBITED.";
	public static final String copyright = "* Copyright 2018 ADLINK Technology Limited.\r\n *\r\n * Licensed under the Apache License, Version 2.0";
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPartItemProvider(AdapterFactory adapterFactory) {
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

			addConfigurationElementPropertyDescriptor(object);
			addSourceAllocationPropertyDescriptor(object);
			addTargetAllocationPropertyDescriptor(object);
			addParentPartPropertyDescriptor(object);
			addChildPartPropertyDescriptor(object);
			addDeploymentPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addModelElementPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Model Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_modelElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_modelElement_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__MODEL_ELEMENT,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configuration Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigurationElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_configurationElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_configurationElement_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__CONFIGURATION_ELEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Allocation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceAllocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_sourceAllocation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_sourceAllocation_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__SOURCE_ALLOCATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Allocation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetAllocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_targetAllocation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_targetAllocation_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__TARGET_ALLOCATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent Part feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_parentPart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_parentPart_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__PARENT_PART,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Child Part feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChildPartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_childPart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_childPart_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__CHILD_PART,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Deployment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeploymentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_deployment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_deployment_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__DEPLOYMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeploymentPart_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DeploymentPart_id_feature", "_UI_DeploymentPart_type"),
				 DeploymentPackage.Literals.DEPLOYMENT_PART__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
			childrenFeatures.add(DeploymentPackage.Literals.DEPLOYMENT_PART__CHILD_PART);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DeploymentPart)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DeploymentPart_type") :
			getString("_UI_DeploymentPart_type") + " " + label;
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

		switch (notification.getFeatureID(DeploymentPart.class)) {
			case DeploymentPackage.DEPLOYMENT_PART__CONFIGURATION_ELEMENT:
			case DeploymentPackage.DEPLOYMENT_PART__TARGET_ALLOCATION:
			case DeploymentPackage.DEPLOYMENT_PART__PARENT_PART:
			case DeploymentPackage.DEPLOYMENT_PART__ID:
			case DeploymentPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DeploymentPackage.DEPLOYMENT_PART__CHILD_PART:
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

		newChildDescriptors.add
			(createChildParameter
				(DeploymentPackage.Literals.DEPLOYMENT_PART__CHILD_PART,
				 DeploymentFactory.eINSTANCE.createDeploymentComponentPart()));

		newChildDescriptors.add
			(createChildParameter
				(DeploymentPackage.Literals.DEPLOYMENT_PART__CHILD_PART,
				 DeploymentFactory.eINSTANCE.createDeploymentConnectorPart()));

		newChildDescriptors.add
			(createChildParameter
				(DeploymentPackage.Literals.DEPLOYMENT_PART__CHILD_PART,
				 DeploymentFactory.eINSTANCE.createDeploymentPortPart()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DeploymentEditPlugin.INSTANCE;
	}

	public Object getColumnImage(Object object, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}	
}
