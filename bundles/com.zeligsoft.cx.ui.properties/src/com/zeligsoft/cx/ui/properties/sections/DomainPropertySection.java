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
package com.zeligsoft.cx.ui.properties.sections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.CXCustomPropertySectionRegistryReader;
import com.zeligsoft.cx.ui.properties.CXPropertyDefinitionManager;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.l10n.Messages;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Page for domain property tab.
 * 
 * @author ysroh
 * 
 */
public class DomainPropertySection extends AbstractCXPropertySection {

	private EObject context = null;

	private Composite sectionComposite = null;

	@Override
	protected Composite createContents(Composite parent) {

		context = getEObject();

		sectionComposite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 10;
		compositeLayout.marginHeight = 0;
		compositeLayout.numColumns = 2;
		compositeLayout.verticalSpacing = 0;
		sectionComposite.setLayout(compositeLayout);
		sectionComposite.setBackground(CXWidgetFactory.whiteColor);
		if (parent.getLayout() instanceof GridLayout) {
			sectionComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}

		createWidgetsForProperties(sectionComposite);

		return sectionComposite;

	}

	@Override
	public void dispose() {
		if (sectionComposite != null)
			sectionComposite.dispose();
		sectionComposite = null;
		super.dispose();
	}

	/**
	 * Creates widgets for all stereotype properties
	 * 
	 * @param composite
	 */
	private void createWidgetsForProperties(Composite composite) {

		List<EObject> listToSynchronize = new ArrayList<EObject>();
		listToSynchronize.addAll(getSelectedEObjects());
		listToSynchronize.remove(0);

		Set<Property> commonPropertySet = null;
		if (getSelectedEObjects().size() > 1) {
			commonPropertySet = getCommonPropertySet();
		}

		Object concepts[] = ZDLUtil.getZDLConcepts(context).toArray();

		if (concepts.length == 0) {
			return;
		}

		Set<Property> propertySet = new HashSet<Property>();

		boolean propertyDisplayed = false;

		for (int i = concepts.length - 1; i >= 0; i--) {

			Class concept = (Class) concepts[i];
			SortedSet<CXPropertyDescriptor> propertyDescriptors = new TreeSet<CXPropertyDescriptor>(
					new CXPropertyDescriptor.CXPropertyDescriptorComparator());

			Iterator<Property> attrItor = concept.getAllAttributes().iterator();

			while (attrItor.hasNext()) {
				Property property = attrItor.next();

				if (propertySet.contains(property)) {
					continue;
				}

				if (commonPropertySet != null) {
					if (property.isComposite() || !commonPropertySet.contains(property)) {
						continue;
					}
				}

				propertySet.add(property);

				CXPropertyDescriptor descriptor = CXPropertyDefinitionManager.INSTANCE
						.getPropertyDescriptor(context, concept, property);

				if (descriptor.getPropertyDefinition() != null) {
					if (!descriptor.getPropertyDefinition().isVisible()) {
						continue;
					}
				}

				descriptor.addEObjectListToSynchronize(listToSynchronize);
				propertyDisplayed = true;
				propertyDescriptors.add(descriptor);
			}

			for (CXPropertyDescriptor descriptor : propertyDescriptors) {
				Property property = descriptor.getProperty();
				// if there is problem getting a value for this property then no
				// point in creating a widget
				try {
					descriptor.getValue();
				} catch (Exception e) {
					CXPropertiesWidgetFactory.createErrorSection(composite, descriptor);
					continue;
				}

				Map<String, Control> widgets = null;

				List<CXCustomPropertySectionRegistryReader.CustomPropertySection> customSections = CXCustomPropertySectionRegistryReader.INSTANCE
						.getCustomPropertySections(descriptor.getContext(), descriptor
								.getConcept().getQualifiedName(), property.getName());
				
				ICXCustomPropertySection overrideSection = null;
				for (CXCustomPropertySectionRegistryReader.CustomPropertySection section : customSections) {
					if (!section.shouldAppend()) {
						overrideSection = section.getSection();
						break;
					}
				}
				if (overrideSection != null) {
					widgets = overrideSection.createSection(composite,
							descriptor, property);
				} else if (property.isComposite()) {

					widgets = CXPropertiesWidgetFactory
							.createSectionCompositeType(composite, descriptor);
				} else {
					if (property.getType() instanceof PrimitiveType) {
						String type = property.getType().getName();

						if (type.equals(UMLPackage.Literals.STRING.getName())
								|| type.equals(UMLPackage.Literals.INTEGER.getName())) {
							widgets = CXPropertiesWidgetFactory.createSectionForStringType(
									composite, descriptor);
						} else if (type.equals(UMLPackage.Literals.BOOLEAN.getName())) {
							CXPropertiesWidgetFactory.createSectionForBooleanType(composite,
									descriptor);
						}

					} else if (property.getType() instanceof Enumeration) {
						widgets = CXPropertiesWidgetFactory.createSectionForEnumerationType(
								composite, descriptor);
					} else {
						widgets = CXPropertiesWidgetFactory.createSectionForReferenceType(
								composite, descriptor);
					}
				}
				
				addWidgetListener(widgets);
				
				for (CXCustomPropertySectionRegistryReader.CustomPropertySection section : customSections) {
					if (section.shouldAppend()) {
						widgets = section.getSection().createSection(composite,
								descriptor, property);
						addWidgetListener(widgets);
					}
				}
			}
		}
		if (!propertyDisplayed) {
			Label label = new Label(composite, SWT.NULL);
			GridData data = new GridData();
			data.verticalIndent = 5;
			label.setLayoutData(data);
			label.setText(Messages.DomainPropertySection_EmptyTabMsg);
			label.setBackground(composite.getBackground());
		}
	}

	/**
	 * Refresh after user edit
	 * @param widgets
	 */
	private void addWidgetListener(Map<String, Control> widgets) {
		if (widgets != null) {
			if (widgets
					.containsKey(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON)) {
				Control control = widgets
						.get(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON);
				if (control instanceof ToolBar) {
					((ToolBar) control).getItem(0).addSelectionListener(
							new SelectionAdapter() {

								@Override
								public void widgetSelected(SelectionEvent e) {
									internalRefresh();
								}
							});
				}
			}
			if (widgets
					.containsKey(CXPropertiesWidgetFactory.PROPERTY_DELETE_BUTTON)) {
				((ToolBar) widgets
						.get(CXPropertiesWidgetFactory.PROPERTY_DELETE_BUTTON))
						.getItem(0).addSelectionListener(
								new SelectionAdapter() {

									@Override
									public void widgetSelected(SelectionEvent e) {
										internalRefresh();
									}
								});
			}
		}
	}
	/**
	 * Queries the common property set of selected objects
	 * 
	 * @return
	 */
	private Set<Property> getCommonPropertySet() {
		Set<Property> commonSet = new HashSet<Property>();

		Iterator<Class> iter = ZDLUtil.getZDLConcepts(getSelectedEObjects().get(0))
				.iterator();
		while (iter.hasNext()) {
			commonSet.addAll(iter.next().getAllAttributes());
		}

		for (EObject eo : getSelectedEObjects()) {
			iter = ZDLUtil.getZDLConcepts(eo).iterator();
			Set<Property> set = new HashSet<Property>();
			while (iter.hasNext()) {
				set.addAll(iter.next().getAllAttributes());
			}
			commonSet.retainAll(set);
		}
		return commonSet;
	}
}
