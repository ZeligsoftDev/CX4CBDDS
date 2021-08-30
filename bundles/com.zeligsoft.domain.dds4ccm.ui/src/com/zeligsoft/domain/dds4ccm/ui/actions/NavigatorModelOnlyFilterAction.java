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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.papyrus.infra.onefile.internal.ui.filters.OnlyDiFilter;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonFilterDescriptor;
import org.eclipse.ui.navigator.INavigatorFilterService;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

import com.zeligsoft.domain.dds4ccm.ui.filters.NavigatorModelOnlyFilter;

/**
 * CX Model only view toolbar action
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings("restriction")
public class NavigatorModelOnlyFilterAction implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
		if (view instanceof ProjectExplorer) {
			ProjectExplorer pe = (ProjectExplorer) view;
			List<String> filters = new ArrayList<>();
			INavigatorFilterService filterService = pe.getNavigatorContentService().getFilterService();
			boolean enabled = filterService.isActive(NavigatorModelOnlyFilter.FILTER_ID);
			for (ICommonFilterDescriptor d : pe.getNavigatorContentService().getFilterService()
					.getVisibleFilterDescriptors()) {
				if (!NavigatorModelOnlyFilter.FILTER_ID.equals(d.getId()) && !OnlyDiFilter.FILTER_ID.equals(d.getId())
						&& filterService.isActive(d.getId())) {
					filters.add(d.getId());
				}
			}
			if (!enabled) {
				filters.add(NavigatorModelOnlyFilter.FILTER_ID);
			} else {
				filters.add(OnlyDiFilter.FILTER_ID);
			}
			filterService.activateFilterIdsAndUpdateViewer(filters.toArray(new String[0]));

		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
