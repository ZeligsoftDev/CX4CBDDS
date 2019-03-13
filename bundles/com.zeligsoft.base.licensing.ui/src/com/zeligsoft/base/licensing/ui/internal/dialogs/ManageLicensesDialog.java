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
package com.zeligsoft.base.licensing.ui.internal.dialogs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.zeligsoft.base.licensing.FeatureStatus;
import com.zeligsoft.base.licensing.LicenseCheck;
import com.zeligsoft.base.licensing.ui.internal.l10n.Messages;
import com.zeligsoft.base.licensing.ui.utils.LicensingUIUtils;

/**
 * 
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ManageLicensesDialog
		extends Dialog {

	/**
	 * Exit code indicating that the user has elected to close the workbench.
	 */
	public static final int EXIT_WORKBENCH_ID = IDialogConstants.CLIENT_ID + 1;

	/**
	 * Exit code indicating that the user has elected to restart the workbench.
	 */
	public static final int RESTART_WORKBENCH_ID = IDialogConstants.CLIENT_ID + 2;

	private boolean includeOKButton;

	private TableViewer viewer;

	/**
	 * Initializes me with my parent shell. No "OK" button is shown.
	 * 
	 * @param shell
	 *            my parent shell
	 */
	public ManageLicensesDialog(Shell shell) {
		this(shell, false);
	}

	/**
	 * Initializes me with my parent shell and whether we show a simple OK
	 * button.
	 * 
	 * @param shell
	 *            my parent shell
	 * @param includeOKButton
	 *            whether to show an "OK" button
	 */
	public ManageLicensesDialog(Shell shell, boolean includeOKButton) {
		super(shell);

		this.includeOKButton = includeOKButton;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText(Messages.ManageLicensesDialog_title);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		
		createButton(parent, EXIT_WORKBENCH_ID, Messages.UILicenseListener_3,
			false);
		Button toFocus = createButton(parent, RESTART_WORKBENCH_ID,
			Messages.ManageLicensesDialog_restart, !includeOKButton);

		if (includeOKButton) {
			toFocus = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		}

		toFocus.setFocus();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		setReturnCode(buttonId);
		close();
	}

	@Override
	public int open() {
		setBlockOnOpen(true);
		return super.open();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite result = (Composite) super.createDialogArea(parent);

		new Label(result, SWT.NONE).setText(Messages.ManageLicensesDialog_summary);

		viewer = new TableViewer(result);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		int tableWidth = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		data.minimumHeight = convertVerticalDLUsToPixels(100);
		data.minimumWidth = tableWidth;
		viewer.getControl().setLayoutData(data);

		TableColumn column = new TableViewerColumn(viewer, SWT.LEFT).getColumn();
		column.setText(Messages.ManageLicensesDialog_featureCol);
		column.setResizable(true);
		int firstColumnWidth = tableWidth * 3 / 5;
		column.setWidth(firstColumnWidth);
		column = new TableViewerColumn(viewer, SWT.LEFT).getColumn();
		column.setText(Messages.ManageLicensesDialog_statusCol);
		column.setResizable(true);
		column.setWidth(tableWidth - firstColumnWidth);

		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
		viewer.setLabelProvider(new FeatureTableLabelProvider());
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setComparator(new FeatureTableComparator());
		updateFeatures();

		Button importButton = new Button(result, SWT.PUSH);
		importButton.setText(Messages.ManageLicensesDialog_importBtn);
		data = new GridData(SWT.RIGHT, SWT.TOP, false, false);
		importButton.setLayoutData(data);
		importButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				importLicenseFile();
			}
		});
		
		Button reportButton = new Button(result, SWT.PUSH);
		reportButton.setText(Messages.ManageLicensesDialog_reportBtn);
		data = new GridData(SWT.RIGHT, SWT.TOP, false, false);
		reportButton.setLayoutData(data);
		reportButton.addSelectionListener(new SelectionAdapter(){
						
			@Override
			public void widgetSelected(SelectionEvent e) {
				generateLicenseReport();				
			}
		});
		
		Link link = new Link(result, SWT.NONE);
		link.setText("<a>Mail Generated License Report to PrismTech Support</a>"); //$NON-NLS-1$
		data = new GridData(SWT.RIGHT, SWT.TOP, false, false);
		link.setLayoutData(data);
		link.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				String mailto = "mailto:" + LicensingUIUtils.enc("support@prismtech.com") + "?subject=" +  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					LicensingUIUtils.enc("Installed Licenses Report") + "&body=" +  //$NON-NLS-1$ //$NON-NLS-2$
					LicensingUIUtils.enc("Please manually attach the generated report"); //$NON-NLS-1$
						//Attachment specifications in the mailto line do not work with all email clients,
						//Implement when can confirm which clients accept the 'attach' variable
						//+ "&attach=" + fileName;
				Program.launch(mailto);
			}
		});
		
		/*
		Button activationButton = new Button(result, SWT.PUSH);
		activationButton.setText(Messages.ManageLicensesDialog_importKeyBtn);
		data = new GridData(SWT.LEFT, SWT.TOP, false, false);
		activationButton.setLayoutData(data);
		activationButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				importActivationKey();
			}
		});
		*/

		return result;
	}

	private void updateFeatures() {
		List<FeatureStatus> summary = LicenseCheck.summarizeFeatures();

		viewer.setInput(summary);
		viewer.refresh();
	}

	private void importLicenseFile() {
		FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
		dlg.setFilterExtensions(new String[] {"*.lic", "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
		dlg.setText(Messages.ManageLicensesDialog_importDlg);
		
		String fileName = dlg.open();
		
		if (fileName != null) {
			LicenseCheck.importLicenseFile(new File(fileName));
			updateFeatures();
		}
	}
	
	private String generateLicenseReport(){
		FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
		dlg.setFilterExtensions(new String[] {"*"+Messages.GenerateLicenseReport_fileExtension, "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
		dlg.setText(Messages.GenerateLicenseReport_title);
		dlg.setOverwrite(true);
		
		String fileName = dlg.open();
		
		if (fileName != null && !fileName.isEmpty()) {
			if (!fileName.endsWith(Messages.GenerateLicenseReport_fileExtension)){
				fileName = fileName.concat(Messages.GenerateLicenseReport_fileExtension);
			}
			List<FeatureStatus> summary = LicenseCheck.summarizeFeatures();
			
			File file = new File(fileName);
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				writer.write(Messages.GenerateLicenseReport_fileHeader);
				writer.newLine();
				for (FeatureStatus fs : summary) {
					writer.write(fs.toString());
					writer.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fileName;
	}
	
	@SuppressWarnings("unused")
	private boolean importActivationKey() {
		ActivationKeyDialog diag = new ActivationKeyDialog(Display.getCurrent().getActiveShell(), 
				Messages.ImportActivationKeyDialog_title, Messages.ImportActivationKeyDialog_keyMessage,
				Messages.ImportActivationKeyDialog_serverMessage);
		diag.open();
		
		return false;
	}
	
	//
	// Nested classes
	//

	private static class FeatureTableLabelProvider
			extends BaseLabelProvider
			implements ILabelProvider, ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			FeatureStatus status = (FeatureStatus) element;

			return (columnIndex == 0)
				? status.getFeature()
				: status.getStatus();
		}

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			return getColumnText(element, 0);
		}

	}

	private static class FeatureTableComparator
			extends ViewerComparator {

		@Override
		public int category(Object element) {
			// group by expiry
			return ((FeatureStatus) element).getExpiry();
		}
	}
	

	private class ActivationKeyDialog
			extends Dialog {
		
		private String keyMessage;
		
		private String serverMessage;
		
		private String title;
		
		private Text key;
		
		private Text server;
				
		@Override
		public void create() {
			super.create();
			Shell shell = getShell();
			shell.setText(title);
		}
		
		/**
		 * Constructor
		 * 
		 * @param shell
		 * @param title
		 * @param label
		 */
		public ActivationKeyDialog(Shell shell, String title, String keyLabel, String serverLabel) {
			super(shell);
			this.title = title;
			this.keyMessage = keyLabel;
			this.serverMessage = serverLabel;
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}
		
		@Override
		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NULL);
			GridLayout compositeLayout = new GridLayout();
			compositeLayout.marginWidth = 10;
			compositeLayout.marginHeight = 15;
			GridData compositeLData = new GridData(GridData.FILL_BOTH);
			compositeLData.grabExcessHorizontalSpace = true;
			compositeLData.grabExcessVerticalSpace = true;
			composite.setLayoutData(compositeLData);
			composite.setLayout(compositeLayout);
		
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.widthHint = 300;
			layoutData.heightHint = 20;
			layoutData.horizontalSpan = 2;
			layoutData.grabExcessHorizontalSpace = true;
			layoutData.grabExcessVerticalSpace = false;
			
			Label keyLabel = new Label(composite, 0);
			keyLabel.setText(keyMessage);
			keyLabel.setVisible(true);
			
			key = new Text(composite, SWT.SINGLE );
			key.setLayoutData(layoutData);
			
			Label serverLabel = new Label(composite, 0);
			serverLabel.setText(serverMessage);
			serverLabel.setVisible(true);
			
			server = new Text(composite, SWT.SINGLE );
			server.setLayoutData(layoutData);
					
			createButtonArea(composite);
		
			return composite;
		}
		
		/**
		 * Create button area
		 * 
		 * @param composite
		 */
		private void createButtonArea(Composite parent) {
			Composite composite = new Composite(parent, SWT.NULL);
			composite.setLayout(new GridLayout(1, false));
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		
			createButtonsForButtonBar(composite);
		
			GridData buttonData = (GridData) getButton(IDialogConstants.OK_ID)
				.getLayoutData();
			buttonData.widthHint = 70;
			buttonData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
			getButton(IDialogConstants.CANCEL_ID).setLayoutData(buttonData);
		}
		
		@Override
		protected void okPressed() {
			LicenseCheck.importActivationKey(key.getText(), server.getText());
			key.setText(""); //$NON-NLS-1$
			server.setText(""); //$NON-NLS-1$
			super.okPressed();
		}
	}
}
