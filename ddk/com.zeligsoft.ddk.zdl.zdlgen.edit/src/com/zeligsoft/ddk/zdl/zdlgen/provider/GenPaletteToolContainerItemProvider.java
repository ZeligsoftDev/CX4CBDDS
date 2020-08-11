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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.uml2.common.edit.command.SubsetAddCommand;
import org.eclipse.uml2.common.edit.command.SubsetSupersetReplaceCommand;
import org.eclipse.uml2.common.edit.command.SubsetSupersetSetCommand;
import org.eclipse.uml2.common.edit.command.SupersetRemoveCommand;

import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenPaletteToolContainerItemProvider extends GenPaletteItemItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteToolContainerItemProvider(AdapterFactory adapterFactory) {
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

			addToolPropertyDescriptor(object);
			addTargetDiagramPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Tool feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addToolPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenPaletteToolContainer_tool_feature"), //$NON-NLS-1$
						getString("_UI_GenPaletteToolContainer_tool_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL, true, false, true, null,
						getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Target Diagram feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetDiagramPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenPaletteToolContainer_targetDiagram_feature"), //$NON-NLS-1$
				getString("_UI_GenPaletteToolContainer_targetDiagram_description"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
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
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL);
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
	 * This returns GenPaletteToolContainer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenPaletteToolContainer")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenPaletteToolContainer) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenPaletteToolContainer_type") : //$NON-NLS-1$
				getString("_UI_GenPaletteToolContainer_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GenPaletteToolContainer.class)) {
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
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

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL,
				ZDLGenFactory.eINSTANCE.createGenPaletteCreationTool()));

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL,
				ZDLGenFactory.eINSTANCE.createGenPaletteStack()));
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL) {
			return new SubsetAddCommand(domain, owner, feature,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL }, collection,
					index);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL) {
			return new SupersetRemoveCommand(domain, owner, feature,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL },
					collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createReplaceCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createReplaceCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, Collection<?> collection) {
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL }, null, value,
					collection);
		}
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature, null,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL }, value,
					collection);
		}
		return super.createReplaceCommand(domain, owner, feature, value, collection);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL) {
			return new SubsetSupersetSetCommand(domain, owner, feature,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL }, null, value);
		}
		if (feature == ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__TOOL) {
			return new SubsetSupersetSetCommand(domain, owner, feature, null,
					new EStructuralFeature[] { ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL }, value);
		}
		return super.createSetCommand(domain, owner, feature, value);
	}

}
