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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * NGC ICM model import dialog.
 * 
 * @author Young-Soo Roh
 *
 */
public class RefactorPathmapDialog extends TrayDialog {

	private TableViewer tableViewer;
	private IStructuredSelection selection;

	public RefactorPathmapDialog(Shell shell) {
		super(shell);

	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(Messages.RefactorPathmapDialog_DialogTitle);
	}

	public URI getSelectedUri() {
		if (selection != null && selection.getFirstElement() != null) {
			return (URI) selection.getFirstElement();
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

		viewerData.heightHint = 300;
		viewerData.widthHint = 700;

		List<URI> content = new ArrayList<URI>();
		for (URI uri : CXDynamicURIConverter.PATHMAPS.keySet()) {
			CXPathmapDescriptor desc = CXDynamicURIConverter.getPathmapDescriptor(uri);
			for (String model : desc.getRegisteredModels()) {
				content.add(uri.appendSegment(model));
			}
		}

		Text label = new Text(browseComposite, SWT.NONE);
		label.setText(Messages.RefactorPathmapDialog_Label);
		label.setBackground(browseComposite.getBackground());

		// create table
		tableViewer = new TableViewer(browseComposite, listStyle);
		tableViewer.getTable().setLayoutData(viewerData);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection currentSelection = (IStructuredSelection) tableViewer.getSelection();
				Object selectedObject = currentSelection.getFirstElement();
				if (selectedObject instanceof URI) {
					selection = currentSelection;
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});
		tableViewer.setInput(content);
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

}
