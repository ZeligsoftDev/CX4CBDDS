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
package com.zeligsoft.cx.ui.dialogs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Generic element content provider that has ZDL Concept. This content provider
 * searches from the top level package of the given context and include imported
 * packages in the search path if requested.
 * 
 * @author ysroh
 * 
 */
public class ZDLElementSelectionDialog
		extends TrayDialog {

	private String dialogTitle;

	private EObject context;

	private List<String> concepts;

	private boolean includeImportedPackages;

	private String compositeTitle = null;

	private ZDLElementSelectionComposite searchComposite = null;

	private IFilter filter;
	
	private IContentProvider contentProvider;
	
	private IBaseLabelProvider labelProvider;

	private TabItem searchTab;
	
	private TabItem browseTab;
	
	private boolean isBrowseTabShown = false;
	
	private String lastSelectedTabItem = "none"; //$NON-NLS-1$
	
	protected boolean showBrowseTab;
	
	protected boolean showSearchScopeCheckBoxes;
	

	/**
	 * Constructor
	 * 
	 * @param shell
	 *            Shell
	 * @param dialogTitle
	 *            Dialog shell title
	 * @param context
	 *            EObject
	 * @param ZDLConcepts
	 *            Array of ZDL concept qualified names
	 * @param includeImportedPackages
	 */
	public ZDLElementSelectionDialog(Shell shell, String dialogTitle,
			EObject context, List<String> ZDLConcepts,
			boolean includeImportedPackages, boolean showBrowseTab,
			boolean showSearchScopeCheckBoxes) {
		super(shell);
		this.dialogTitle = dialogTitle;
		this.context = context;
		this.concepts = ZDLConcepts;
		this.includeImportedPackages = includeImportedPackages;
		this.showBrowseTab = showBrowseTab;
		this.showSearchScopeCheckBoxes = showSearchScopeCheckBoxes;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}
	
	public ZDLElementSelectionDialog(Shell shell, String dialogTitle,
			EObject context, List<String> ZDLConcepts,
			boolean includeImportedPackages, boolean showBrowseTab) {
		this(shell, dialogTitle, context, ZDLConcepts, includeImportedPackages,
				showBrowseTab, true);
	}
	
	public ZDLElementSelectionDialog(Shell shell, String dialogTitle, EObject context,
			List<String> ZDLConcepts, boolean includeImportedPackages) {
		this(shell, dialogTitle, context, ZDLConcepts, includeImportedPackages, true);
	}

	public ZDLElementSelectionDialog(Shell shell, EObject context,
			List<String> ZDLConcepts, boolean includeImportedPackages,
			boolean showBrowseTab) {
		this(shell, Messages.ZDLElementSelectionDialog_DefaultDialogTitle, context,
				ZDLConcepts, includeImportedPackages, showBrowseTab);
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(dialogTitle);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createSelectionArea(composite);

		createButtonArea(composite);
		return composite;

	}

	/**
	 * Creates and organize the button area
	 * 
	 * @param composite
	 */
	private void createButtonArea(Composite composite) {
		Composite barComposite = new Composite(composite, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout = new GridLayout();
		GridData compositeLData = new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		barComposite.setLayoutData(compositeLData);
		barComposite.setLayout(compositeLayout);

		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonData.widthHint = 70;

		Button okButton = createButton(barComposite, IDialogConstants.OK_ID,
			IDialogConstants.OK_LABEL, true);
		Button cancelButton = createButton(barComposite,
			IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

		okButton.setLayoutData(buttonData);
		cancelButton.setLayoutData(buttonData);
		okButton.setEnabled(false);
	}

	/**
	 * Create selection area
	 * 
	 * @param parent
	 */
	private void createSelectionArea(Composite parent) {

		Composite mainComposite = parent;
		if (showBrowseTab) {
			final TabFolder root = new TabFolder(parent, SWT.NULL);
			root.setLayout(new GridLayout(1, false));
			root.setLayoutData(new GridData(GridData.FILL_BOTH));
			searchTab = new TabItem(root, SWT.NULL);
			searchTab.setText(Messages.ZDLElementSelectionDialog_SearchTabLabel);
			mainComposite = root;
		}

		Composite searchCompositeArea = new Composite(mainComposite, SWT.NULL);
		searchCompositeArea.setLayout(new GridLayout(1, false));
		searchCompositeArea.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label label = new Label(searchCompositeArea, SWT.NONE);
		if (compositeTitle != null) {
			label.setText(compositeTitle);
		} else {
			label
				.setText(Messages.ZDLElementSelectionDialog_DefaultCompositeTitle);
		}

		searchComposite = new ZDLElementSelectionComposite(context, concepts,
				includeImportedPackages, showSearchScopeCheckBoxes) {

			@Override
			protected void handleSelection(IStructuredSelection selection) {
				if (selection.isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				}
			}

			@Override
			protected void createCompositeAdditions(Composite parent) {
				createAdditions(parent);
			}
		};
		searchComposite.setElementFilter(filter);
		searchComposite.setContentProvider(contentProvider);
		searchComposite.setLabelProvider(labelProvider);
		searchComposite.createComposite(searchCompositeArea);
		searchComposite.getTableViewer().addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				close();
			}
		});
		
		if (showBrowseTab) {
			searchTab.setControl(searchCompositeArea);

			final TabFolder rootFolder = (TabFolder) mainComposite;

			// Create browse tab
			browseTab = new TabItem(rootFolder, SWT.NULL);
			browseTab.setText(Messages.ZDLElementSelectionDialog_BrowseTabLabel);
			rootFolder.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (searchComposite.getSelection().isEmpty()) {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
					}
					lastSelectedTabItem = "search"; //$NON-NLS-1$
				}
			});
		}
	}
	

	/**
	 * Queries the selected element
	 * 
	 * @return
	 */
	public IStructuredSelection getSelectedElements() {
		if (searchComposite != null) {
			return searchComposite.getSelection();
		}
		return new StructuredSelection();
	}

	/**
	 * Subclass to override to add additional controls
	 * 
	 * @param parent
	 */
	protected void createAdditions(Composite parent) {
		// subclass to override to add additional controls after the selection
		// composite
	}

	/**
	 * Queries the table viewer
	 * 
	 * @return
	 */
	protected TableViewer getTableViewer() {
		if (searchComposite != null) {
			return searchComposite.getTableViewer();
		}
		return null;
	}

	/**
	 * Set ZDL concept list
	 * 
	 * @param ZDLConcepts
	 */
	protected void setZDLConcepts(List<String> ZDLConcepts) {
		this.concepts = ZDLConcepts;
	}

	/**
	 * Set element selection composite title
	 * 
	 * @param compositeTitle
	 */
	public void setCompositeTitle(String compositeTitle) {
		this.compositeTitle = compositeTitle;
	}

	/**
	 * Set element selection filter
	 * 
	 * @param filter
	 */
	public void setElementFilter(IFilter filter) {
		this.filter = filter;
		if (searchComposite != null) {
			searchComposite.setElementFilter(filter);
		}
	}
	
	public void setContentProvider(IContentProvider provider) {
		this.contentProvider = provider;
		if (searchComposite != null) {
			searchComposite.setContentProvider(provider);
		}
	}

	public void setLabelProvider(IBaseLabelProvider provider) {
		this.labelProvider = provider;
		if (searchComposite != null) {
			searchComposite.setLabelProvider(provider);
		}
	}
}
