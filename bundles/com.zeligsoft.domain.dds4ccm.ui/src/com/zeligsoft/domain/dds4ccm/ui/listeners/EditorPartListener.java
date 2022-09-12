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
package com.zeligsoft.domain.dds4ccm.ui.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.pathmap.DynamicPathmapRegistry;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Handle double click event to open Deployment
 * 
 * @author Young-Soo Roh
 *
 */
public class EditorPartListener implements IPartListener2 {

	public EditorPartListener() {
		IWorkbenchPage page = BaseUIUtil.getActivepage();
		if (page != null) {
			// close all open editors due to issue with dynamic pathmap
			page.closeAllEditors(false);
		}
	}

	private static IDoubleClickListener listener = new IDoubleClickListener() {

		@Override
		public void doubleClick(DoubleClickEvent event) {
			ISelection selection = event.getSelection();
			EObject eObject = BaseUIUtil.getEObjectFromSelection(selection);

			if (eObject == null || !ZDLUtil.isZDLConcept(eObject, ZMLMMNames.DEPLOYMENT)) {
				return;
			}

			IEditorPart editor = BaseUIUtil.getActivepage().getActiveEditor();

			if (editor == null) {
				return;
			}
			ServicesRegistry serviceRegistry = null;
			if (editor instanceof IMultiDiagramEditor) {
				IMultiDiagramEditor multiEditor = (IMultiDiagramEditor) editor;
				serviceRegistry = multiEditor.getServicesRegistry();
			} else {
				return;
			}

			if (serviceRegistry == null) {
				return;
			}
			try {
				IPageManager pageManager = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
				if (pageManager.isOpen(eObject)) {
					pageManager.selectPage(eObject);
				} else {
					pageManager.openPage(eObject);
				}
			} catch (ServiceException e1) {
				// do nothing
			}
		}
	};

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// Add double click listener to model explorer tree
		// when new Papyrus model editor is open
		ModelExplorerView view = (ModelExplorerView) BaseUIUtil.getModelExplorerViewPart();
		if (view != null) {
			view.getCommonViewer().addDoubleClickListener(listener);
		}

		enableReferences();

	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {

	}

	/**
	 * Enable pathmapped references
	 */
	protected void enableReferences() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		if (editor == null) {
			return;
		}
		ServicesRegistry serviceRegistry = editor.getAdapter(ServicesRegistry.class);
		if (serviceRegistry == null) {
			return;
		}
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			EObject root = null;
			if (openedModel != null) {
				try {
					root = openedModel.lookupRoot();
					if (!(root instanceof Package)) {
						return;
					}
				} catch (NotFoundException e) {
					return;
				}
			}

			Set<Resource> resourcesToTest = new HashSet<Resource>();
			for (Package pkg : ((Package) root).getImportedPackages()) {
				if (!pkg.eIsProxy() && pkg.eResource() != null) {
					resourcesToTest.add(pkg.eResource());
				}
			}

			for (Resource r : modelSet.getResources()) {
				if (UmlModel.UML_FILE_EXTENSION.equals(r.getURI().fileExtension()) && !r.getContents().isEmpty()
						&& r.getContents().get(0) instanceof Package) {
					resourcesToTest.add(r);
				}
			}
			for (Resource r : resourcesToTest) {
				if (r.getContents().isEmpty()
						|| !ZDLUtil.isZDLConcept(r.getContents().get(0), DDS4CCMNames.DDS4_CCMMODEL)) {
					continue;
				}
				IReadOnlyHandler2 readOnlyHandler = ReadOnlyManager
						.getReadOnlyHandler(WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(modelSet));
				List<URI> uris = getAssociatedUris(r);
				if (readOnlyHandler.canMakeWritable(ReadOnlyAxis.anyAxis(), uris.toArray(new URI[0])).or(false)) {
					if (r != root.eResource() && !uris.isEmpty()) {
						readOnlyHandler.makeWritable(ReadOnlyAxis.anyAxis(), uris.toArray(new URI[0]));
					}
				}
			}
		} catch (ServiceException e) {
			// do nothing
		}
	}
	
	
	public static List<URI> getAssociatedUris(Resource resource) {
		List<URI> result = new ArrayList<URI>();
		if (resource != null && resource.getResourceSet() != null) {
			URIConverter uriConverter = resource.getResourceSet().getURIConverter();
			URI uri = resource.getURI();
			if (uri != null) {
				URI normalizedURI = uriConverter.normalize(uri);
				if (normalizedURI.isPlatformResource()) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(normalizedURI.toPlatformString(true)));
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
					IFile[] associatedFiles = OneFileUtils.getAssociatedFiles(papFile);

					for (int i = 0; i < associatedFiles.length; i++) {
						URI tempUri = URI.createPlatformResourceURI(associatedFiles[i].getFullPath().toString(), true);
						result.add(DynamicPathmapRegistry.INSTANCE.denormalizeURI(tempUri));
					}
				}
			}
		}
		return result;
	}
}
