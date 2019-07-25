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
package com.zeligsoft.cx.ui.properties.pages;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.CXCustomPropertySectionRegistryReader;
import com.zeligsoft.cx.ui.properties.CXPropertyDefinitionManager;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Element creation page for property sheet page
 * 
 * @author ysroh
 * 
 */
public class CXElementCreationPage
		extends PreferencePage {

	private CXPropertyDescriptor descriptor;

	private Composite composite;

	private Composite mainComposite;

	/**
	 * Constructor
	 * 
	 * @param propertyDescriptor
	 */
	public CXElementCreationPage(CXPropertyDescriptor propertyDescriptor) {
		super(ZDLUtil.getZDLConcept(propertyDescriptor.getContext()).getName());
		this.descriptor = propertyDescriptor;
	}

	@Override
	protected Control createContents(Composite parent) {

		noDefaultAndApplyButton();

		mainComposite = parent;
		composite = CXWidgetFactory.createGridComposite(parent, 2,
			GridData.FILL_BOTH);

		createWidgets(composite);

		return composite;
	}

	/**
	 * Creates widgets for all stereotype properties
	 * 
	 * @param composite
	 */
	private void createWidgets(Composite composite) {

		EObject value = descriptor.getContext();

		Set<Property> propertyNameSet = new HashSet<Property>();
		Object conceptArray[] = ZDLUtil.getZDLConcepts(value).toArray();

		for (int i = conceptArray.length - 1; i >= 0; i--) {

			SortedSet<CXPropertyDescriptor> propertyDescriptors = 
				new TreeSet<CXPropertyDescriptor>(
						new CXPropertyDescriptor.CXPropertyDescriptorComparator());
			
			Iterator<Property> attrItor = ((Class) conceptArray[i])
				.getAllAttributes().iterator();

			while (attrItor.hasNext()) {

				Property property = attrItor.next();

				// avoid duplicate entries
				if (propertyNameSet.contains(property)) {
					continue;
				}
				propertyNameSet.add(property);

				PropertyDefinition pd = CXPropertyDefinitionManager.INSTANCE
					.getPropertyDefinition(value, (Class) conceptArray[i],
						property);

				if (pd != null) {
					if (!pd.isVisible()) {
						continue;
					}
				}
				
				CXPropertyDescriptor subDescriptor = new CXPropertyDescriptor(value,
						(Class) conceptArray[i], property, pd);
				propertyDescriptors.add(subDescriptor);
				
			}

			for(CXPropertyDescriptor subDescriptor: propertyDescriptors){
				// if there is problem getting a value for this property then no
				// point in creating a widget
				try {
					subDescriptor.getValue();
				} catch (Exception e) {
					CXPropertiesWidgetFactory
						.createErrorSection(composite, subDescriptor);
					continue;
				}

				Map<String, Control> widgets = null;
				Property property = subDescriptor.getProperty();

				List<CXCustomPropertySectionRegistryReader.CustomPropertySection> customSections = CXCustomPropertySectionRegistryReader.INSTANCE
						.getCustomPropertySections(descriptor.getContext(),
								descriptor.getConcept().getQualifiedName(),
								property.getName());

				ICXCustomPropertySection overrideSection = null;
				for (CXCustomPropertySectionRegistryReader.CustomPropertySection section : customSections) {
					if (!section.shouldAppend()) {
						overrideSection = section.getSection();
						break;
					}
				}
				if (overrideSection != null) {
					widgets = overrideSection.createSection(composite,
							subDescriptor, property);
				} else if (property.isComposite()) {

					widgets = CXPropertiesWidgetFactory
							.createSectionCompositeType(composite,
									subDescriptor);

				} else {
					if (property.getType() instanceof PrimitiveType) {
						String type = property.getType().getName();

						if (type.equals(UMLPackage.Literals.STRING.getName())
							|| type.equals(UMLPackage.Literals.INTEGER
								.getName())) {
							widgets = CXPropertiesWidgetFactory
								.createSectionForStringType(composite,
									subDescriptor);
							
							final CXPropertyDescriptor subDesc = subDescriptor;
							final Text valueField = (Text) widgets
									.get(CXPropertiesWidgetFactory.PROPERTY_VALUE);
							if (valueField != null) {
								valueField
										.addDisposeListener(new DisposeListener() {

											@Override
											public void widgetDisposed(
													DisposeEvent e) {

												Object newValue;
												if (subDesc.getValue() != null
														&& subDesc.getValue() instanceof Integer) {
													try {
														newValue = new Integer(
																valueField
																		.getText());
													} catch (NumberFormatException nfe) {
														return;
													}
												} else {
													newValue = valueField
															.getText();
												}
												subDesc.setValue(newValue);
											}
										});
							}
						}else if (type.equals(UMLPackage.Literals.BOOLEAN
							.getName())) {
							CXPropertiesWidgetFactory.createSectionForBooleanType(
								composite, subDescriptor);
						}

					} else if (property.getType() instanceof Enumeration) {
						widgets = CXPropertiesWidgetFactory
							.createSectionForEnumerationType(composite,
								subDescriptor);
					} else {
						widgets = CXPropertiesWidgetFactory
							.createSectionForReferenceType(composite,
								subDescriptor);
					}
				}
				
				for (CXCustomPropertySectionRegistryReader.CustomPropertySection section : customSections) {
					if (section.shouldAppend()) {
						widgets.putAll(section.getSection().createSection(
								composite, descriptor, property));
					}
				}
				
				if (widgets != null) {
					if (widgets
							.containsKey(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON)) {
						Control control = widgets
								.get(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON);
						if (control instanceof ToolBar) {
							((ToolBar) control).getItem(0)
									.addSelectionListener(
											new SelectionAdapter() {

												@Override
												public void widgetSelected(
														SelectionEvent e) {
													refresh();
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
											public void widgetSelected(
													SelectionEvent e) {
												refresh();
											}
										});
					}
				}
			}
		}
	}

	/**
	 * Refresh the page.
	 */
	private void refresh() {
		if (mainComposite != null) {
			if (composite != null && !composite.isDisposed()) {
				composite.dispose();
			}
			composite = (Composite) createContents(mainComposite);
			mainComposite.layout(true);
		}
	}
}
