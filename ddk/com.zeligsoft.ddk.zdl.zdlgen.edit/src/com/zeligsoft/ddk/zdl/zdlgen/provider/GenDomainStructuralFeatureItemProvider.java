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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * This is the item provider adapter for a {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenDomainStructuralFeatureItemProvider extends GenDomainNamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainStructuralFeatureItemProvider(AdapterFactory adapterFactory) {
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
			addVisibleModelTypePropertyDescriptor(object);
			addUmlMetaattributePropertyDescriptor(object);
			addDomainAttributePropertyDescriptor(object);
			addIsRhapsodySuppressedPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Visible Model Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibleModelTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainAttributePresentation_visibleModelType_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_visibleModelType_feature", //$NON-NLS-1$
								"_UI_GenDomainAttributePresentation_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Uml Metaattribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUmlMetaattributePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainStructuralFeature_umlMetaattribute_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_umlMetaattribute_feature", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE, true, false, true,
						null, getString("_UI_ProfileMappingPropertyCategory"), //$NON-NLS-1$
						null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						if (object instanceof GenDomainStructuralFeature) {
							return getAvailableUMLMetaattributes((GenDomainStructuralFeature) object);
						}

						return super.getChoiceOfValues(object);
					}
				});
	}

	/**
	 * Populate the list of values with UML meta-attributes that the domain
	 * feature's UML metaclasses have in common.  If applicable,
	 * the list will be restricted to those that are appropriate for the
	 * specified domain structural feature.
	 * 
	 * @param feature a domain structural feature
	 * 
	 * @return the list of UML meta-attributes that are appropriate for the feature
	 */
	protected Collection<Property> getAvailableUMLMetaattributes(GenDomainStructuralFeature feature) {
		Collection<Property> result = Collections.emptyList();
		GenDomainConcept concept = feature.getConcept();

		if (concept != null) {
			Set<Class> metaclasses = new java.util.HashSet<Class>();
			metaclasses.addAll(concept.getUmlMetaclasses());
			for (GenDomainConcept general : concept.allGenerals()) {
				metaclasses.addAll(general.getUmlMetaclasses());
			}

			if (!metaclasses.isEmpty()) {
				filterGenerals(metaclasses);

				result = new java.util.HashSet<Property>();
				Set<Class> common = getCommonSuperclasses(metaclasses);
				for (Class next : common) {
					result.addAll(next.getAllAttributes());
				}
			} else {
				result = new java.util.ArrayList<Property>();

				// collect all properties in the UML metamodel
				Resource res = concept.eResource().getResourceSet()
						.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true);
				if ((res != null) && res.isLoaded()) {
					Package metamodel = (Package) EcoreUtil.getObjectByType(res.getContents(),
							UMLPackage.Literals.PACKAGE);
					if (metamodel != null) {
						for (TreeIterator<?> iter = metamodel.eAllContents(); iter.hasNext();) {
							Object next = iter.next();

							if (next instanceof Property) {
								result.add((Property) next);
								iter.prune(); // nothing interesting here
							} else if (!(next instanceof Class)) {
								// only want properties in metaclasses that are
								// contained by the metamodel
								iter.prune();
							}
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Computes the closest common superclasses of all of the specified UML
	 * <tt>classes</tt>.
	 * 
	 * @param classes a bunch of UML classes (possibly empty)
	 * @return their nearest common superclasses, or an empty collection if
	 *     the <tt>classes</tt> collection is empty
	 */
	protected Set<Class> getCommonSuperclasses(Collection<? extends Class> classes) {
		Set<Class> result = new java.util.HashSet<Class>();

		if (classes.size() == 1) {
			result.addAll(classes);
		} else if (!classes.isEmpty()) {
			Iterator<? extends Class> iter = classes.iterator();
			Set<Classifier> supers = new java.util.HashSet<Classifier>(iter.next().allParents());
			while (iter.hasNext()) {
				supers.retainAll(iter.next().allParents());
			}

			for (Classifier next : supers) {
				if (next instanceof Class) {
					result.add((Class) next);
				}
			}

			filterGenerals(result);

			return result;
		}

		return result;
	}

	/**
	 * Filters out of the given classifiers all of those that are generals of
	 * any other classifier in the collection.
	 * 
	 * @param classifiers
	 *            a bunch of classifiers
	 */
	protected void filterGenerals(Collection<? extends Classifier> classifiers) {
		boolean loop;
		do {
			loop = false;
			for (Classifier next : classifiers) {
				if (classifiers.removeAll(next.allParents())) {
					// do it again
					loop = true;
					break;
				}
			}
		} while (loop);
	}

	/**
	 * This adds a property descriptor for the Domain Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainStructuralFeature_domainAttribute_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_domainAttribute_feature", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE, false, false, true,
						null, getString("_UI_DomainPropertyCategory"), //$NON-NLS-1$
						null));
	}

	/**
	 * This adds a property descriptor for the Is Rhapsody Suppressed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsRhapsodySuppressedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_GenDomainStructuralFeature_isRhapsodySuppressed_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_isRhapsodySuppressed_feature", //$NON-NLS-1$
								"_UI_GenDomainStructuralFeature_type"), //$NON-NLS-1$
						ZDLGenPackage.Literals.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_Rhapsody80PropertyCategory"), //$NON-NLS-1$
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
		String label = ((GenDomainStructuralFeature) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_GenDomainStructuralFeature_type") : //$NON-NLS-1$
				getString("_UI_GenDomainStructuralFeature_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	private boolean includesCardinality(Property p, int cardinality) {
		// TODO: UML 5 Migration verify
		// replaces pre-UML 5.0 p.includesCardinality(cardinality)
		return p.getLower() <= cardinality && cardinality <= p.getUpper();
	}

	@Override
	public String getTextForTree(EObject object) {
		String key = "_TreeText_" + object.eClass().getName(); //$NON-NLS-1$

		GenDomainStructuralFeature genFeature = (GenDomainStructuralFeature) object;
		Property domainFeature = genFeature.getDomainAttribute();

		if (domainFeature == null) {
			return super.getTextForTree(object);
		}

		String result = getResourceLocator().getString(key, new Object[] { domainFeature.getName() });

		if (domainFeature != null) {
			if (domainFeature.isDerived()) {
				result = "/ " + result; //$NON-NLS-1$
			}

			if (domainFeature.getType() != null) {
				result = result + " : " + domainFeature.getType().getName(); //$NON-NLS-1$
			}

			if (!domainFeature.is(1, 1)) {
				String multiplicity = domainFeature.is(0, LiteralUnlimitedNatural.UNLIMITED) ? "*" //$NON-NLS-1$
						: includesCardinality(domainFeature, LiteralUnlimitedNatural.UNLIMITED)
								? (String.valueOf(domainFeature.getLower()) + "..*") //$NON-NLS-1$
								: (String.valueOf(domainFeature.getLower()) + ".." + String //$NON-NLS-1$
										.valueOf(domainFeature.getUpper()));
				result = result + " [" + multiplicity + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return result;
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

		switch (notification.getFeatureID(GenDomainStructuralFeature.class)) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED:
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
