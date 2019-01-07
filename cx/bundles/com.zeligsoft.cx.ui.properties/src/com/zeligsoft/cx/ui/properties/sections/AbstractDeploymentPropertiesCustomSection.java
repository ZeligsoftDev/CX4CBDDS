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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.l10n.Messages;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.cx.ui.providers.PropertyEntryLabelProvider;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Abstract deployment properties tree viewer. Subclass must extend this class
 * to implement domain specific deployment properties section.
 * 
 * @author ysroh
 * 
 */
public abstract class AbstractDeploymentPropertiesCustomSection implements
		ICXCustomPropertySection {

	public static final int EXPAND_LEVEL = 6;

	protected EObject context;

	protected TreeViewer treeViewer = null;

	protected List<IPropertyEntry> rootProperies = null;

	private IOperationHistoryListener historyListener = new IOperationHistoryListener() {

		@Override
		public void historyNotification(OperationHistoryEvent event) {

			int type = event.getEventType();
			if (event.getOperation() == null
					|| event.getOperation().getClass() == null) {
				return;
			}
			String className = event.getOperation().getClass().getName();
			if (!className.startsWith("com.zeligsoft")) { //$NON-NLS-1$
				return;
			}
			if (type == OperationHistoryEvent.OPERATION_NOT_OK
					|| type == OperationHistoryEvent.UNDONE
					|| type == OperationHistoryEvent.REDONE) {
				// refresh the viewer if this is history or transaction roll
				// back action
				if (className.contains("CXPropertyDescriptor") //$NON-NLS-1$
						|| className.contains("PropertyEntry")) { //$NON-NLS-1$
					rootProperies = null;
					rootProperies = getRootPropertyEntries(context);
					if (treeViewer != null) {
						treeViewer.setInput(rootProperies);
						treeViewer.refresh();
						treeViewer.expandToLevel(EXPAND_LEVEL);
					}
				}
			}
			return;

		}
	};

	@Override
	public Map<String, Control> createSection(Composite parent,
			CXPropertyDescriptor descriptor, Property property) {
		this.context = descriptor.getContext();
		Map<String, Control> map = new HashMap<String, Control>();
		
		if (isValidSelection(context)) {
			createSectionForProperties(parent);
		}

		return map;
	}

	private Control createSectionForProperties(Composite parent) {

		OperationHistoryFactory.getOperationHistory()
				.addOperationHistoryListener(historyListener);

		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.verticalIndent = 5;
		CXWidgetFactory.createLabel(parent,
				Messages.DeploymentPropertiesCustomSection_propertiesLabel)
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
		createTreeArea(composite);
		composite.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				OperationHistoryFactory.getOperationHistory()
						.removeOperationHistoryListener(historyListener);
			}
		});

		return composite;

	}

	private void createTreeArea(Composite parent) {

		GridData treeViewerData = new GridData(GridData.FILL_BOTH);
		treeViewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		treeViewer.getControl().setLayoutData(treeViewerData);

		TreeViewerColumn viewerColumn = new TreeViewerColumn(treeViewer,
				SWT.NULL, 0);
		viewerColumn.getColumn().setText(
				Messages.DeploymentPropertiesCustomSection_IndexColumnLabel);
		viewerColumn.getColumn().setWidth(450);
		viewerColumn = new TreeViewerColumn(treeViewer, SWT.NULL, 1);
		viewerColumn.getColumn().setText(
				Messages.DeploymentPropertiesCustomSection_ValueColumnLabel);
		viewerColumn.getColumn().setWidth(200);

		treeViewer.setContentProvider(getContentProvider());
		treeViewer.setLabelProvider(new PropertyEntryLabelProvider());
		viewerColumn.setEditingSupport(getEditingSupport(treeViewer));

		rootProperies = getRootPropertyEntries(context);
		treeViewer.setInput(rootProperies);
		treeViewer.expandToLevel(EXPAND_LEVEL);

	}

	abstract protected List<IPropertyEntry> getRootPropertyEntries(
			EObject context);

	abstract protected IContentProvider getContentProvider();

	abstract protected EditingSupport getEditingSupport(TreeViewer treeViewer);

	abstract protected boolean isValidSelection(EObject context);
}
