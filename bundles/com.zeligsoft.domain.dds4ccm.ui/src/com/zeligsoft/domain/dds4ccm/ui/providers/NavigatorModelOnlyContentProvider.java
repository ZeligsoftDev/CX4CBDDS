/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.domain.dds4ccm.ui.providers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.ui.providers.PapyrusContentProvider;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.dds4ccm.ui.filters.NavigatorModelOnlyFilter;

/**
 * CX model only view content provider
 * 
 * @author Young-Soo Roh
 *
 */
public class NavigatorModelOnlyContentProvider extends PapyrusContentProvider {

	private CommonViewer common;

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if (viewer instanceof CommonViewer) {
			common = (CommonViewer) viewer;
		}
	}

	/**
	 * Queries if the CX Model only view is active
	 * 
	 * @return
	 */
	public boolean isFiltered() {
		return common != null && common.getNavigatorContentService() != null
				&& common.getNavigatorContentService().getFilterService() != null
				&& common.getNavigatorContentService().getFilterService().isActive(NavigatorModelOnlyFilter.FILTER_ID);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		List<Object> result = new LinkedList<>();
		if (isFiltered()) {
			if (inputElement instanceof IPapyrusFile) {
				IPapyrusFile file = (IPapyrusFile) inputElement;
				for (IResource r : file.getAssociatedResources()) {
					result.add(PapyrusModelHelper.getPapyrusModelFactory().createISubResourceFile(file, (IFile) r));
				}
			} else if (inputElement instanceof IWorkspaceRoot) {

				List<IFile> files = new ArrayList<>();
				try {
					visitAllModels((IContainer) inputElement, file -> files.add(file));

					for (IFile r : files) {
						if (OneFileUtils.isDi(r)) {
							IPapyrusFile createIPapyrusFile = PapyrusModelHelper.getPapyrusModelFactory()
									.createIPapyrusFile(r);
							result.add(createIPapyrusFile);
						}
					}
				} catch (CoreException e) {
					// do nothing
				}
			}
		}
		return result.isEmpty() ? null : result.toArray();
	}

	/**
	 * Load all UML resources in a folder
	 *
	 * @param rset
	 * @param container
	 * @throws CoreException
	 */
	private void visitAllModels(IContainer container, Consumer<IFile> lambda) throws CoreException {
		IResource[] members = container.members();

		for (IResource member : members) {
			if (member instanceof IProject) {
				if (!((IProject) member).isOpen()) {
					// Ignore closed projects
					continue;
				}
			}
			if (member instanceof IContainer) {
				visitAllModels((IContainer) member, lambda);
			} else if (member instanceof IFile) {
				IFile file = (IFile) member;
				String ext = file.getFullPath().getFileExtension();
				if (!UML2Util.isEmpty(ext) && "di".equals(ext.toLowerCase())) { //$NON-NLS-1$
					lambda.accept(file);
				}
			}
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof IPapyrusFile && isFiltered()) {
			return ResourcesPlugin.getWorkspace().getRoot();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (isFiltered() && element instanceof IPapyrusFile) {
			return true;
		}
		return false;
	}
}
