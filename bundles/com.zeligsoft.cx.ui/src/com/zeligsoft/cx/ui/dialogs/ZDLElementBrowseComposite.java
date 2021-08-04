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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.TypedElement;

import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.providers.ZDLElementContentProvider;
import com.zeligsoft.cx.ui.providers.ZDLElementLabelProvider;

/**
 * ZDL Element Browse Composite
 * 
 * @author ysroh
 * 
 */
public abstract class ZDLElementBrowseComposite {

	protected Object browseTabLastSelectedElement = null;

	protected EObject context;

	protected List<String> concepts = new ArrayList<String>();

	protected IFilter filter = null;

	protected IStructuredSelection selection = null;

	boolean includeImportedPackages;

	protected TreeViewer treeViewer;


	public ZDLElementBrowseComposite(EObject context, List<String> concepts, boolean includeImportedPackages) {
		this.context = context;
		if (context instanceof TypedElement && ((TypedElement) context).getType() != null) {
			selection = new StructuredSelection(((TypedElement) context).getType());
		} else {
			selection = new StructuredSelection(EcoreUtil.getRootContainer(context));
		}
		if (concepts != null) {
			this.concepts = concepts;
		}
		this.includeImportedPackages = includeImportedPackages;
	}

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

		createBrowseArea(composite);

		return composite;

	}

	/**
	 * Create element selection area
	 * 
	 * @param parent
	 */
	private void createBrowseArea(Composite parent) {

		Composite listAreaComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		listAreaComposite.setLayout(layout);
		listAreaComposite
				.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		int listStyle = SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI;

		GridData viewerData = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);

		viewerData.heightHint = 250;
		viewerData.widthHint = 550;

		Label listLabel = new Label(listAreaComposite, SWT.NONE);
		listLabel.setText(Messages.ZDLElementSelectionComposite_ElementListViewerTitle);

		treeViewer = new TreeViewer(listAreaComposite, listStyle);
		treeViewer.getTree().setLayoutData(viewerData);
		treeViewer.setContentProvider(new DelegatingContentProvider());
		treeViewer.setLabelProvider(new DelegatingLabelProvider());
		treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		treeViewer.setSelection(selection);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection currentSelection = (IStructuredSelection) treeViewer.getSelection();
				selection = currentSelection;
				handleSelection(selection);
			}
		});
	}

	/**
	 * Subclass to override to handle selection
	 * 
	 * @param IStructuredSelection selection
	 */
	protected abstract void handleSelection(IStructuredSelection selection);

	private class DelegatingLabelProvider extends LabelProvider {

		private WorkbenchLabelProvider wlp = new WorkbenchLabelProvider();
		private ZDLElementLabelProvider zlp = new ZDLElementLabelProvider();

		@Override
		public Image getImage(Object element) {
			if (element instanceof IResource) {
				return wlp.getImage(element);
			}
			return zlp.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof IResource) {
				return wlp.getText(element);
			}
			return zlp.getText(element);
		}
	}

	private class DelegatingContentProvider implements ITreeContentProvider {

		private BaseWorkbenchContentProvider wcp = new BaseWorkbenchContentProvider();
		private ZDLElementContentProvider zcp = new ZDLElementContentProvider(context, concepts, filter,
				includeImportedPackages);

		public DelegatingContentProvider() {
			Set<URI> uris = new HashSet<URI>();
			zcp.loadAllResources(uris, ResourcesPlugin.getWorkspace().getRoot());
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		private boolean hasUml(IContainer container) throws CoreException {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					String fileExt = ((IFile) res).getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(fileExt) && BaseUtil.UML_MODEL_EXTENSION.equals(fileExt.toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(((IFile) res).getFullPath().toString(), true);
						ResourceSet rset = context.eResource().getResourceSet();
						Resource eres = rset.getResource(uri, false);
						if (eres != null) {
							// Resource already loaded
							return true;
						}
					}
				} else if (res instanceof IContainer) {
					if(hasUml((IContainer) res)) {
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public Object[] getChildren(Object element) {
			if (element instanceof IProject && !((IProject) element).isOpen()) {
				return new Object[0];
			}
			List<Object> result = new ArrayList<Object>();
			if (element instanceof IContainer) {
				try {
					for (IResource res : ((IContainer) element).members()) {
						if (res instanceof IProject) {
							if (((IProject) res).isOpen()) {
								result.add(res);
							}
						} else if (res instanceof IContainer) {
							if (hasUml((IContainer) res)) {
								result.add(res);
							}
						} else if (res instanceof IFile) {

							String ext = ((IFile) res).getFullPath().getFileExtension();
							if (!UML2Util.isEmpty(ext) && BaseUtil.UML_MODEL_EXTENSION.equals(ext.toLowerCase())) {
								URI uri = URI.createPlatformResourceURI(((IFile) res).getFullPath().toString(), true);
								ResourceSet rset = context.eResource().getResourceSet();
								Resource eres = rset.getResource(uri, false);
								if (eres != null) {
									result.add(eres.getContents().get(0));
								}
							}
						}
					}
				} catch (CoreException e) {
					// Don't do anything
				}
			} else if (element instanceof EObject) {
				return zcp.getChildren(element);
			}
			return result.toArray();
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof IResource) {
				return wcp.getParent(element);
			} else if (element instanceof Model) {
				return wcp.getParent(WorkspaceSynchronizer.getFile(((EObject) element).eResource()));
			}
			return zcp.getParent(element);
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length != 0;
		}

	}

	public void setFilter(IFilter filter) {
		this.filter = filter;
	}

	/**
	 * Return structured selection
	 * 
	 * @return
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	protected boolean isValidSelection() {
		if (selection.getFirstElement() instanceof EObject) {
			return isSelectedElementValid((EObject) selection.getFirstElement());
		}
		return false;
	}

	/**
	 * Queries if the given element is valid element
	 * 
	 * @param element
	 * @return
	 */
	private boolean isSelectedElementValid(EObject element) {
		if (filter != null) {
			if (filter.select(element)) {
				return true;
			}
			return false;
		}
		for (String concept : concepts) {
			if (ZDLUtil.isZDLConcept(element, concept)) {
				return true;
			}
		}
		return false;
	}
}
