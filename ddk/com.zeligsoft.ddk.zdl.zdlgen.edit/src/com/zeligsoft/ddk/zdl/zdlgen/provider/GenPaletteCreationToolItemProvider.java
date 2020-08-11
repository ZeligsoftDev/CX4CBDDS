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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalettable;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenPaletteCreationToolItemProvider extends GenPaletteToolItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteCreationToolItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addElementTypeHintPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenPaletteCreationTool_type_feature"), //$NON-NLS-1$
						getString("_UI_GenPaletteCreationTool_type_description"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__TYPE, true, false, true, null,
						getString("_UI_DiagramEditorPalettePropertyCategory"), //$NON-NLS-1$
						null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						Collection<?> result = super.getChoiceOfValues(object);

						for (Iterator<?> iter = result.iterator(); iter.hasNext();) {
							Object next = iter.next();

							if (next instanceof GenDomainConcept) {
								GenDomainConcept concept = (GenDomainConcept) next;

								if ((concept.getDomainConcept() != null) && concept.getDomainConcept().isAbstract()) {
									iter.remove();
								}
							}
						}

						return result;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Element Type Hint feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addElementTypeHintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_GenPaletteCreationTool_elementTypeHint_feature"), //$NON-NLS-1$
				getString("_UI_GenPaletteCreationTool_elementTypeHint_description"), //$NON-NLS-1$
				ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT, true, false, false,
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
			childrenFeatures.add(ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__EXPRESSION);
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
	 * This returns GenPaletteCreationTool.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenPaletteCreationTool")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenPaletteCreationTool) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenPaletteCreationTool_type") : //$NON-NLS-1$
				getString("_UI_GenPaletteCreationTool_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getTextForTree(EObject object) {
		GenPaletteCreationTool tool = (GenPaletteCreationTool) object;

		GenPalettable type = tool.getType();
		String typeName = (type == null) ? "null" : tool.getType().eClass().getName(); //$NON-NLS-1$
		String key = "_TreeText_" + object.eClass().getName() + '_' + typeName; //$NON-NLS-1$

		Object[] args;
		if (type == null) {
			args = new Object[0];
		} else if (type instanceof GenDomainReference) {
			GenDomainReference ref = (GenDomainReference) type;
			args = new Object[] { ref.getConcept().getName(), ref.getDomainAttribute().getName() };
		} else {
			args = new Object[] { ((GenDomainConcept) type).getName() };
		}

		return getResourceLocator().getString(key, args);
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

		switch (notification.getFeatureID(GenPaletteCreationTool.class)) {
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__EXPRESSION,
				ZDLGenFactory.eINSTANCE.createOawExpression()));

		newChildDescriptors.add(createChildParameter(ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__EXPRESSION,
				ZDLGenFactory.eINSTANCE.createOawXtend()));
	}

}
