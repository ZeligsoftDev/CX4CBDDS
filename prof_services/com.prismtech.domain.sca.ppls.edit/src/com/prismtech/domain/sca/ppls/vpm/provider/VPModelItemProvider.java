/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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

import com.prismtech.domain.sca.ppls.vpm.Attribute;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.ConstrainedElement;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.VpmFactory;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;

/**
 * This is the item provider adapter for a {@link com.prismtech.domain.sca.ppls.vpm.VPModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VPModelItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPModelItemProvider(AdapterFactory adapterFactory) {
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
			addSourcePropertyDescriptor(object);
			addQualifiedNamePropertyDescriptor(object);
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
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VPModel_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VPModel_name_feature", "_UI_VPModel_type"),
				 VpmPackage.Literals.VP_MODEL__NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VPModel_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VPModel_source_feature", "_UI_VPModel_type"),
				 VpmPackage.Literals.VP_MODEL__SOURCE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Qualified Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQualifiedNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VPModel_qualifiedName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VPModel_qualifiedName_feature", "_UI_VPModel_type"),
				 VpmPackage.Literals.VP_MODEL__QUALIFIED_NAME,
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
			childrenFeatures.add(VpmPackage.Literals.VP_MODEL__VARIATION_POINTS);
			childrenFeatures.add(VpmPackage.Literals.VP_MODEL__CONFIGURATIONS);
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
	 * This returns VPModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VPModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VPModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VPModel_type") :
			getString("_UI_VPModel_type") + " " + label;
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

		switch (notification.getFeatureID(VPModel.class)) {
			case VpmPackage.VP_MODEL__NAME:
			case VpmPackage.VP_MODEL__SOURCE:
			case VpmPackage.VP_MODEL__QUALIFIED_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VpmPackage.VP_MODEL__VARIATION_POINTS:
			case VpmPackage.VP_MODEL__CONFIGURATIONS:
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
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		Configuration config = VpmFactory.eINSTANCE.createConfiguration();
		
		newChildDescriptors.add
			(createChildParameter
				(VpmPackage.Literals.VP_MODEL__CONFIGURATIONS,
				 config));
		
		for( VariationPoint vp : ((VPModel)object).getVariationPoints()) {
			ConfigurationPoint cp = null;
			if( vp instanceof VariationPointWithValue) {
				cp = VpmFactory.eINSTANCE.createConfigurationPointWithValue();
			} else if( vp instanceof VariationPointWithSettings) {
				cp = VpmFactory.eINSTANCE.createConfigurationPointWithSettings();
				for(ConstrainedElement ce : ((VariationPointWithSettings)vp).getConstrainedElements()){
					for(Attribute attribute : ce.getAttributes()){
						boolean found=false;
						for(SettableAttribute sa : ((ConfigurationPointWithSettings)cp).getSettableAttributes()){
							//If it's there, leave it alone
							if(sa.getName().equals(attribute.getName())){
								found=true;
							}					
						}
						//If it's not, add it in
						if(found==false){
							SettableAttribute newSa; 
							newSa = VpmFactory.eINSTANCE.createSettableAttribute();
							newSa.setName(attribute.getName());	
							((ConfigurationPointWithSettings)cp).getSettableAttributes().add(newSa);
						}
					}					
				}
			} else {
				cp = VpmFactory.eINSTANCE.createConfigurationPoint();
			}
			cp.setName(vp.getName());
			cp.setVariationPoint(vp);
			config.getConfigurationPoints().add(cp);
		}
		
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return VpmEditPlugin.INSTANCE;
	}

}
