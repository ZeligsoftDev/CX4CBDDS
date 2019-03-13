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
package com.zeligsoft.domain.idl3plus.ui.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.cx.ui.providers.ZDLElementLabelProvider;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Add table for component ports that the selected connector dot is connected
 * to.
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusDataSpaceCustomPropertySectionProvider implements
		ICXCustomPropertySection {

	private TableViewer tableViewer;

	@Override
	public Map<String, Control> createSection(Composite parent,
			CXPropertyDescriptor descriptor, Property property) {
		Map<String, Control> map = CXPropertiesWidgetFactory
				.createSectionForReferenceType(parent, descriptor);
		createContentForConnectedPortsTable(parent, descriptor);
		return map;
	}

	private void createContentForConnectedPortsTable(Composite parent,
			CXPropertyDescriptor descriptor) {

		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.verticalIndent = 5;
		CXWidgetFactory.createLabel(parent,
				Messages.IDL3PlusDataSpaceCustomPropertySectionProvider_Label)
				.setLayoutData(data);

		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 0;
		compositeLayout.marginHeight = 10;
		compositeLayout.verticalSpacing = 0;
		compositeLayout.horizontalSpacing = 0;
		GridData compositeLData = new GridData(GridData.FILL_BOTH);
		compositeLData.grabExcessHorizontalSpace = true;
		compositeLData.grabExcessVerticalSpace = true;
		compositeLData.horizontalSpan = 2;
		compositeLData.verticalIndent = 0;

		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);
		composite.setBackground(parent.getBackground());

		// Create table area
		createListAreaa(composite, descriptor);

	}

	private void createListAreaa(Composite parent,
			CXPropertyDescriptor descriptor) {
		GridData tableViewerData = new GridData(GridData.FILL_BOTH);
		tableViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER);
		tableViewer.getTable().setLayoutData(tableViewerData);
		tableViewer.setContentProvider(new ConnectedPortsContentProvider());
		tableViewer.setLabelProvider(new ZDLElementLabelProvider(tableViewer));
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				EObject selection = (EObject) ((StructuredSelection) tableViewer
						.getSelection()).getFirstElement();
				if (selection == null) {
					return;
				}
				BaseUIUtil.showInProjectExplorer(selection);
			}
		});
		tableViewer.setInput(descriptor.getContext());

	}

	/**
	 * Content provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class ConnectedPortsContentProvider implements
			IStructuredContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (!ZDLUtil.isZDLConcept((EObject) inputElement,
					IDL3PlusNames.DATA_SPACE)) {
				return new Object[0];
			}
			Property dataSpace = (Property) inputElement;
			Component assembly = (Component) dataSpace.eContainer();
			List<EObject> connectedPorts = new ArrayList<EObject>();
			for (Connector connector : assembly.getOwnedConnectors()) {
				if (connector.getEnds().size() != 2) {
					continue;
				}

				EObject connectedPort = null;
				EObject part = ZDLUtil.getEValue(connector.getEnds().get(0),
						ZMLMMNames.CONNECTOR_END,
						ZMLMMNames.CONNECTOR_END__PART);
				EObject port = ZDLUtil.getEValue(connector.getEnds().get(0),
						ZMLMMNames.CONNECTOR_END,
						ZMLMMNames.CONNECTOR_END__PORT);
				if (part == null && port == null) {
					continue;
				}
				if (dataSpace == part) {
					connectedPort = ZDLUtil.getEValue(connector.getEnds()
							.get(1), ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PORT);
				} else {
					if (dataSpace == ZDLUtil.getEValue(
							connector.getEnds().get(1),
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART)) {
						connectedPort = port;
					}
				}
				if (connectedPort == null) {
					continue;
				}
				getConnectedPorts(connectedPort, connectedPorts);
			}
			Collections.sort(connectedPorts, new Comparator<EObject>() {

				@Override
				public int compare(final EObject eobj1, final EObject eobj2) {
					return ((Port) eobj1).getName().compareTo(
							((Port) eobj2).getName());
				}
			});
			return connectedPorts.toArray();
		}

		/**
		 * Find connected ports
		 * 
		 * @param port
		 * @param visitedConnector
		 * @param connectedPorts
		 */
		private void getConnectedPorts(EObject port,
				List<EObject> connectedPorts) {
			Component assembly = (Component) CCMUtil
					.getAssemblyFromComponent(port.eContainer());
			if (assembly != null) {
				for (Connector conn : assembly.getOwnedConnectors()) {
					if (conn.getEnds().size() != 2) {
						continue;
					}
					EObject firstPort = ZDLUtil.getEValue(
							conn.getEnds().get(0), ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PORT);
					EObject secondPort = ZDLUtil.getEValue(conn.getEnds()
							.get(1), ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PORT);
					if (firstPort == port) {
						if (!CCMUtil.isAssemblyComponent(secondPort
								.eContainer())) {
							connectedPorts.add(secondPort);
						} else {
							getConnectedPorts(secondPort, connectedPorts);
						}
					}
					if (secondPort == port) {
						if (!CCMUtil
								.isAssemblyComponent(firstPort.eContainer())) {
							connectedPorts.add(firstPort);
						} else {
							getConnectedPorts(firstPort, connectedPorts);
						}
					}
				}
			} else {
				connectedPorts.add(port);
			}
		}
	};

}
