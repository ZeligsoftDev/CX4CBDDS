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
package com.zeligsoft.domain.dds4ccm.tools.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * NGC ICM model import dialog.
 * 
 * @author Young-Soo Roh
 *
 */
public class ICMBrowseDialog extends TrayDialog {

	private TreeViewer treeViewer;
	private IStructuredSelection selection;
	private ResourceSet rset = new ResourceSetImpl();

	public ICMBrowseDialog(Shell shell) {
		super(shell);

	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText("ICM Import Dialog");
	}

	public URI getSelectedResourceUri() {
		if (selection.isEmpty()) {
			return null;
		}
		Object selectedObject = selection.getFirstElement();
		if (selectedObject instanceof IFile) {
			URI uri = URI.createPlatformResourceURI(((IFile) selectedObject).getFullPath().toString(), false);
			Package root = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
			String pathmap = CCMUtil.getZCXAnnotationDetail(root, "pathmap", UML2Util.EMPTY_STRING);
			return URI.createURI("pathmap://" + pathmap).appendSegment(uri.lastSegment());
		}
		return null;
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createBrowseArea(composite);

		createButtonArea(composite);

		return composite;

	}

	private void createBrowseArea(Composite parent) {
		Composite browseComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		browseComposite.setLayout(layout);
		browseComposite
				.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		int listStyle = SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI;

		GridData viewerData = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);

		viewerData.heightHint = 250;
		viewerData.widthHint = 550;

		treeViewer = new TreeViewer(browseComposite, listStyle);
		treeViewer.getTree().setLayoutData(viewerData);
		treeViewer.setContentProvider(new ICMModelContentProvider());
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection currentSelection = (IStructuredSelection) treeViewer.getSelection();
				if (currentSelection.isEmpty()) {
					return;
				}
				Object selectedObject = currentSelection.getFirstElement();
				if (selectedObject instanceof IFile) {
					selection = currentSelection;
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});
	}

	private void createButtonArea(Composite composite) {
		Composite barComposite = new Composite(composite, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout = new GridLayout();
		GridData compositeLData = new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		barComposite.setLayoutData(compositeLData);
		barComposite.setLayout(compositeLayout);

		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonData.widthHint = 70;

		Button okButton = createButton(barComposite, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		Button cancelButton = createButton(barComposite, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL,
				false);

		okButton.setLayoutData(buttonData);
		cancelButton.setLayoutData(buttonData);
		okButton.setEnabled(false);
	}

	private class ICMModelContentProvider extends BaseWorkbenchContentProvider {

		@Override
		public Object[] getChildren(Object element) {
			List<Object> result = new ArrayList<Object>();
			Object[] children = super.getChildren(element);
			for (int i = 0; i < children.length; i++) {
				Object member = children[i];
				if (member instanceof IFile) {
					IFile file = (IFile) member;
					String ext = file.getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
						Package root = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
						if (root != null && ZDLUtil.isZDLProfile(root, "cxDDS4CCM")) {
							String pathmap = CCMUtil.getZCXAnnotationDetail(root, "pathmap", UML2Util.EMPTY_STRING);
							if (!UML2Util.isEmpty(pathmap)) {
								result.add(member);
							}
						}
					}
				} else if (member instanceof IProject) {
					if (((IProject) member).isOpen()) {
						result.add(member);
					}
				} else if (member instanceof IContainer) {
					result.add(member);
				}
			}
			return result.toArray();
		}

		@Override
		public boolean hasChildren(Object element) {
			return super.hasChildren(element);
		}
	}

}
