/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Custom property section for Dynamic URI mapping
 * 
 * @author Young-Soo Roh
 * 
 */
public class DynamicPathmapCustomPropertySection implements ICXCustomPropertySection {

	private static final String PATHMAP_KEY = "pathmap"; //$NON-NLS-1$

	@Override
	public Map<String, Control> createSection(Composite parent, CXPropertyDescriptor descriptor, Property property) {

		Map<String, Control> result = new HashMap<String, Control>();
		createSectionForDynamicPathmap(parent, descriptor);
		return result;
	}

	public void createSectionForDynamicPathmap(final Composite parent, final CXPropertyDescriptor descriptor) {

		CXWidgetFactory.createLabel(parent, "Dynamic Pathmap : ", parent.getBackground());

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent, 2, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		String value = getDynamicPathmap(descriptor.getContext());

		int style = SWT.BORDER;
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		final Text text = new Text(composite, style);
		text.setLayoutData(data);
		text.setText(value);
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (!text.getEditable()) {
					return;
				}
				if (e.character == SWT.CR) {
					if (!text.isDisposed()) {
						String newValue = text.getText();
						setDynamicPathmap(descriptor.getContext(), newValue);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		text.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// do nothing
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!text.getEditable()) {
					return;
				}
				if (!text.isDisposed()) {
					String input = text.getText();

					if (value == null && UML2Util.isEmpty(input)) {
						return;
					}

					if (!input.equals(value)) {
						setDynamicPathmap(descriptor.getContext(), input);
					}
				}
			}
		});
	}

	private String getDynamicPathmap(EObject model) {

		return CCMUtil.getZCXAnnotationDetail((Element) model, PATHMAP_KEY, UML2Util.EMPTY_STRING);
	}

	private void setDynamicPathmap(EObject model, String pathmap) {

		// Remove existing pathmap
		String originalPathmap = getDynamicPathmap(model);
		// save new dynamic pathmap
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
		Command command = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				CCMUtil.putZCXAnnotationDetail((Element) model, PATHMAP_KEY, pathmap);
			}
		};
		domain.getCommandStack().execute(command);

		if (originalPathmap.equals(pathmap)) {
			// nothing to do if same
			return;
		}

		URI modelUri = model.eResource().getURI();
		if (!UML2Util.isEmpty(originalPathmap)) {
			CXDynamicURIConverter.removeMapping(modelUri);
		}
		if (UML2Util.isEmpty(pathmap)) {
			return;
		}
		// enable new URI mapping
		URI targetURI = modelUri.trimSegments(1).appendSegment("");
		URI sourceURI = URI.createURI(PATHMAP_KEY + "://" + pathmap + "/", true);
		CXDynamicURIConverter.addMapping(sourceURI, targetURI, modelUri.lastSegment());

	}
}
