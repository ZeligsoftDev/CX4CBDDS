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

package com.zeligsoft.cx.deployment.treeeditor.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.ibm.xtools.uml.msl.resources.ILogicalResource;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentEditorInput;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This is the tree editor, it creates the deployment page and initializes the
 * deployment and the controller.
 * 
 * @author sduchesneau
 * 
 */
@SuppressWarnings("rawtypes")
public class DeploymentTreeEditor extends FormEditor implements
		ISelectionProvider, ITabbedPropertySheetPageContributor {

	public final static String DEPLOYMENT_TREE_EDITOR_ID = "DEPLOYMENT_TREE_EDITOR_ID"; //$NON-NLS-1$

	private Component deployment;

	private ResourceSetListenerImpl resourceSetListener;

	private TransactionalEditingDomain domain;

	protected ISelectionChangedListener selectionChangedListener;

	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	protected ISelection editorSelection;

	protected Viewer currentViewer;

	@Override
	public String getContributorId() {
		return "properties.DeploymentTreeEditor";//$NON-NLS-1$
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.editor.FormEditor#init(org.eclipse.ui.IEditorSite,
	 * org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInput(input);	
		site.setSelectionProvider(this);
		

		if (input instanceof DeploymentEditorInput) {
			deployment = ((DeploymentEditorInput) input).getDeployment();
			setPartName(computePartName(deployment));
		}

		resourceSetListener = new MyResourceSetListener();
		domain = TransactionUtil.getEditingDomain(deployment);
		domain.addResourceSetListener(resourceSetListener);
		
	}

	/**
	 * Mark the editor dirty. Execute using syncExec to ensure UI operations
	 * happening on main ui thread.
	 */
	public void markDirty() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				editorDirtyStateChanged();
			}
		});
	}

	/**
	 * Close the editor. Execute using syncExec to ensure UI operations
	 * happening on main ui thread.
	 */
	private void closeEditor() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchPage page = getSite().getWorkbenchWindow()
						.getActivePage();
				page.closeEditor(getEditor(), false);
			}
		});
	}

	private IEditorPart getEditor() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		try {
			addPage(new DeploymentFormPage(this, "deploymentFormPage", //$NON-NLS-1$ 
					"", deployment)); //$NON-NLS-1$
		} catch (PartInitException e) {
			Activator
					.getDefault()
					.error(
							DeploymentEditorMessages.DeploymentTreeEditor_DeploymentPageFailedLog,
							e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#createPages()
	 */
	@Override
	protected void createPages() {
		super.createPages();
		if (getPageCount() == 1 && getContainer() instanceof CTabFolder) {
			((CTabFolder) getContainer()).setTabHeight(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#dispose()
	 */
	@Override
	public void dispose() {
		if (resourceSetListener != null)
			domain.removeResourceSetListener(resourceSetListener);
		
		deployment = null;
		
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void doSave(IProgressMonitor monitor) {
		Model model = deployment.getModel();
		try {
			UMLModeler.saveModel(model);
		} catch (Exception e) {
			Activator
					.getDefault()
					.error(
							DeploymentEditorMessages.DeploymentTreeEditor_SaveFailed,
							e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		// not supported
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#isDirty()
	 */
	@Override
	public boolean isDirty() {
		if (domain == null || deployment == null) {
			return false;
		}
		ILogicalResource logicalResource = UMLModeler
				.getLogicalResource(deployment);
		if (logicalResource == null) {
			return false;
		}
		return logicalResource.isModified();
	}

	// Added to support properties view
	// SelectionChangedListeners needed for properties tab.

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;
		for (Iterator<ISelectionChangedListener> listeners = selectionChangedListeners.iterator(); listeners
				.hasNext();) {
			ISelectionChangedListener listener = listeners
					.next();
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	/**
	 * Get the editor's current tree viewer.
	 * @return Viewer viewer
	 */
	public Viewer getCurrentViewer() {
		return this.currentViewer;
	}

	/**
	 * Set the current selected tree viewer.
	 * Add and remove needed selectionChangedListener.
	 * @param Viewer viewer
	 */
	public void setCurrentViewer(Viewer viewer) {
		
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				
				selectionChangedListener = new ISelectionChangedListener() {
					
					@Override
					public void selectionChanged(
							SelectionChangedEvent selectionChangedEvent) {
						setSelection(selectionChangedEvent.getSelection());
					}
				};
			}
			
			if (currentViewer != null) {
				currentViewer
						.removeSelectionChangedListener(selectionChangedListener);
			}

			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			currentViewer = viewer;

			setSelection(currentViewer == null ? StructuredSelection.EMPTY
					: currentViewer.getSelection());
		}
	}
	
	/**
	 * Updates the editor tab label according to the current name of the
	 * deployment component. This method may be called on any thread; it takes
	 * care of synchronization.
	 */
	void updateTabLabel() {
		Display myDisplay = getEditorSite().getShell().getDisplay();
		if (myDisplay == null || myDisplay.isDisposed()) {
			// I am disposed. Ignore the request
			return;
		}

		Runnable r = new Runnable() {

			@Override
			public void run() {
				if (deployment == null) {
					// I am disposed. Ignore the request
					return;
				}

				setPartName(computePartName(deployment));
			}
		};

		if (myDisplay.getThread() != Thread.currentThread()) {
			myDisplay.syncExec(r);
		} else {
			r.run();
		}
	}
	
	/**
	 * Computes an appropriate name for the editor part based on the specified
	 * deployment component.
	 * 
	 * @param deployment
	 *            a deployment
	 * @return the part name
	 */
	String computePartName(Component deployment) {
		return deployment.getLabel();
	}
	
	//
	// Nested classes
	//
	
	private class MyResourceSetListener extends ResourceSetListenerImpl {

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {

			for (Notification notification : event.getNotifications()) {
				int eventType = notification.getEventType();

				if (notification.getOldValue() != null
						&& notification.getOldValue() instanceof Component) {
					Component component = (Component) notification
							.getOldValue();

					// Close tree editor composite when either deployment is
					// deleted or the stereotype has been removed
					if (component.equals(deployment)
							&& notification.getNewValue() == null) {
						if (deployment.eResource() == null
								|| ZDLUtil.isZDLConcept(deployment,
										ZMLMMNames.DEPLOYMENT)) {
							closeEditor();
							return;
						}
					}
				} else if (eventType == Notification.REMOVE_MANY) {
					Object oldValue = notification.getOldValue();
					if (oldValue instanceof BasicEList.UnmodifiableEList) {

						BasicEList.UnmodifiableEList list = (BasicEList.UnmodifiableEList) oldValue;
						if (list.size() > 0) {
							Object firstObject = list.get(0);
							if (firstObject instanceof Model) {
								if ((deployment == null) ||
										(deployment.getModel() == null)
										|| (deployment.getModel() == firstObject)) {
									closeEditor();
									return;
								}
							}
						}
					}
				} else if (notification.getNotifier() == deployment) {
					if (notification.getFeature() == UMLPackage.Literals.NAMED_ELEMENT__NAME) {
						updateTabLabel();
					}
				}
			}
			markDirty();
		}
	}
}
