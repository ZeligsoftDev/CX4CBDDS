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
package com.zeligsoft.domain.dds4ccm.ui.filters;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;

/**
 * Project explorer model only viewer filter
 * 
 * @author Young-Soo Roh
 *
 */
public class NavigatorModelOnlyFilter extends ViewerFilter {

	public static final String FILTER_ID = "com.zeligsoft.domain.dds4ccm.ui.cxdionlyfilter"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
	 * .Viewer, java.lang.Object, java.lang.Object)
	 *
	 * @Override
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IWorkspaceRoot) {
			return true;
		}
		if (element instanceof IPapyrusFile) {
			return true;
		}
		if (element instanceof ISubResourceFile) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#isFilterProperty(java.lang.Object,
	 * java.lang.String)
	 *
	 * @Override
	 */
	@Override
	public boolean isFilterProperty(Object element, String property) {
		return true;
	}

}
