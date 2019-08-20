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

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.providers.ZDLElementContentProvider;
import com.zeligsoft.cx.ui.providers.ZDLElementLabelProvider;

/**
 * Element selection composite for ZDL Elements.
 * 
 * @author ysroh
 * 
 */
public abstract class ZDLElementSelectionComposite {

	private EObject context;

	private List<String> concepts;

	private IFilter filter = null;

	private boolean includeImportedPackages;

	private TableViewer tableViewer;

	private int listHeight = 250;

	private int listWidth = 550;

	private IStructuredSelection selection = null;
	
	private IContentProvider cp = null;
	
	private IBaseLabelProvider lp = null;
	
	private boolean showSearchScopeCheckBoxes;

	

	/**
	 * Constructor
	 * 
	 * @param context
	 *            the root package and all its contents will be the scope of the
	 *            search
	 * @param ZDLConcepts
	 *            fully qualified ZDL qualified name. Only elements that have at
	 *            least one of these concepts will be visible in the list
	 * @param includeImportedPackages
	 *            set this parameter to true to include top level imported
	 *            packages to the search scope
	 */
	public ZDLElementSelectionComposite(EObject context,
			List<String> ZDLConcepts, boolean includeImportedPackages,
			boolean showSearchScopeCheckBoxes) {
		this.concepts = ZDLConcepts;
		this.includeImportedPackages = includeImportedPackages;
		this.context = context;
		this.showSearchScopeCheckBoxes = showSearchScopeCheckBoxes;
	}
	
	public ZDLElementSelectionComposite(EObject context,
			List<String> ZDLConcepts, boolean includeImportedPackages) {
		this(context, ZDLConcepts, includeImportedPackages, true);
	}
	
	/**
	 * Creates the element selection composite
	 * 
	 * @param parent
	 * @return
	 */
	public Composite createComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createSelectionArea(composite);

		createCompositeAdditions(composite);

		return composite;

	}

	/**
	 * Add additional controls after the selection composite
	 * 
	 * @param parent
	 */
	protected void createCompositeAdditions(Composite parent) {
		// subclass can override this method to provide an extra section after
		// the viewer composite
	}

	/**
	 * Create element selection area
	 * 
	 * @param parent
	 */
	private void createSelectionArea(Composite parent) {

		Composite listAreaComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		listAreaComposite.setLayout(layout);
		listAreaComposite.setLayoutData(new GridData(GridData.FILL_BOTH
			| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		int listStyle = SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI;

		GridData viewerData = new GridData(GridData.FILL_BOTH
			| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);

		viewerData.heightHint = listHeight;
		viewerData.widthHint = listWidth;

		final Text searchText = new Text(listAreaComposite, SWT.BORDER);
		searchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		searchText.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event event) {
				tableViewer.setInput(searchText.getText());
			}
		});
		searchText.setFocus();

		Label listLabel = new Label(listAreaComposite, SWT.NONE);
		listLabel
			.setText(Messages.ZDLElementSelectionComposite_ElementListViewerTitle);

		tableViewer = new TableViewer(listAreaComposite, listStyle);
		tableViewer.getTable().setLayoutData(viewerData);
		if (cp == null) {
			cp = new ZDLElementContentProvider(context, concepts, filter,
					includeImportedPackages);
			((ZDLElementContentProvider) cp).setFilter(filter);
		}
		tableViewer.setContentProvider(cp);
		if (lp == null) {
			lp = new ZDLElementLabelProvider(tableViewer);
		}
		tableViewer.setLabelProvider(lp);
		tableViewer.setInput(new Object());

		tableViewer
			.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {

					IStructuredSelection currentSelection = (IStructuredSelection) tableViewer
						.getSelection();
					selection = currentSelection;
					handleSelection(selection);
					tableViewer.refresh();
				}
			});

		final IEclipsePreferences store = new InstanceScope()
				.getNode(ZeligsoftCXUIPlugin.PLUGIN_ID);
		boolean searchWorkspace = store.getBoolean(
				CXPreferenceConstants.SEARCH_WORKSPACE,
				CXPreferenceConstants.DEFAULT_SEARCH_WORKSPACE);
		boolean searchProject = store.getBoolean(
				CXPreferenceConstants.SEARCH_PROJECT,
				CXPreferenceConstants.DEFAULT_SEARCH_PROJECT);	
		if (showSearchScopeCheckBoxes) {
			final Button workspaceCheckbox = new Button(listAreaComposite,
					SWT.CHECK);
			workspaceCheckbox.setSelection(searchWorkspace);
			workspaceCheckbox
					.setText(Messages.ZDLElementSelectionComposite_SearchScopeLabel);
			workspaceCheckbox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					store.putBoolean(CXPreferenceConstants.SEARCH_WORKSPACE,
							workspaceCheckbox.getSelection());
					try {
						store.flush();
					} catch (BackingStoreException e1) {
						// nothing do to
					}
					tableViewer.refresh();
				}
			});
			final Button projectCheckbox = new Button(listAreaComposite,
					SWT.CHECK);
			projectCheckbox.setSelection(searchProject);
			projectCheckbox
					.setText(Messages.ZDLElementSelectionComposite_ProjectScopeLabel);
			projectCheckbox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					store.putBoolean(CXPreferenceConstants.SEARCH_PROJECT,
							projectCheckbox.getSelection());
					try {
						store.flush();
					} catch (BackingStoreException e1) {
						// nothing do to
					}
					tableViewer.refresh();
				}
			});
		}
	}

	/**
	 * Subclass to override to handle selection
	 * 
	 * @param IStructuredSelection selection
	 */
	protected abstract void handleSelection(IStructuredSelection selection);

	/**
	 * Set element filter
	 * 
	 * @param filter
	 */
	public void setElementFilter(IFilter filter) {
		this.filter = filter;
		if (cp != null && cp instanceof ZDLElementContentProvider) {
			((ZDLElementContentProvider) cp).setFilter(filter);
		}
	}

	public void setContentProvider(IContentProvider provider){
		cp = provider;
	}
	
	public void setLabelProvider(IBaseLabelProvider provider){
		lp = provider;
	}
	
	/**
	 * Set element list default height
	 * 
	 * @param height
	 */
	public void setListHeight(int height) {
		listHeight = height;
	}

	/**
	 * set element list default width
	 * 
	 * @param width
	 */
	public void setListWidth(int width) {
		listWidth = width;
	}

	public IStructuredSelection getSelection() {
		if (selection == null) {
			return new StructuredSelection();
		}
		return selection;
	}

	/**
	 * Queries the element list viewer
	 * 
	 * @return
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}
}
