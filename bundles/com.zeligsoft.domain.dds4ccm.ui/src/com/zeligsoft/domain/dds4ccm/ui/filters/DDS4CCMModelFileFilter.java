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
package com.zeligsoft.domain.dds4ccm.ui.filters;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonFilterDescriptor;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.navigator.INavigatorFilterService;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.domain.dds4ccm.Activator;

/**
 * Filter to disable UML model files filter that is enabled by default. We want
 * to disable this to show model files in DDS4CCM for new workspace
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMModelFileFilter extends ViewerFilter {

	private final static String UML_FILTER_ID = "com.ibm.xtools.modeler.ui.navigator.internal.providers.filter.umlModelFilter"; //$NON-NLS-1$

	private final static String STORE_KEY = "DDS4CCMModelFileFilterValue"; //$NON-NLS-1$

	private final static IEclipsePreferences store = new InstanceScope()
			.getNode(Activator.PLUGIN_ID);;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		String storeValue = store.get(STORE_KEY, null);
		if (storeValue != null) {
			// Ignore if we have already done this once
			return true;
		}
		if (element instanceof IAdaptable) {
			IFile file = (IFile) ((IAdaptable) element).getAdapter(IFile.class);
			if (file == null) {
				return true;
			}
			INavigatorContentService contentService = ((CommonViewer) viewer)
					.getNavigatorContentService();
			final INavigatorFilterService filterService = contentService
					.getFilterService();
			ICommonFilterDescriptor[] fds = filterService
					.getVisibleFilterDescriptors();
			boolean modelFilterActive = false;
			int activeFilterSize = 0;
			for (ICommonFilterDescriptor desc : fds) {
				// disable UML model filter
				if (filterService.isActive(desc.getId())) {
					if (desc.getId().equals(UML_FILTER_ID)) {
						modelFilterActive = true;
					} else {
						activeFilterSize++;
					}
				}
			}
			if (modelFilterActive) {
				final String[] filterList = new String[activeFilterSize];
				int i = 0;
				for (ICommonFilterDescriptor desc : fds) {
					// check to see if UML Model File filter is active
					if (filterService.isActive(desc.getId())
							&& !desc.getId().equals(UML_FILTER_ID)) {
						filterList[i++] = desc.getId();
					}

				}
				store.put(STORE_KEY, "done"); //$NON-NLS-1$
				try {
					store.flush();
				} catch (BackingStoreException e) {
					// silent catch
				}
				final Display dis = Display.getCurrent();
				Job job = new Job("DeactiveModelFileFilter") { //$NON-NLS-1$

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						// de-activate UML model filter
						dis.syncExec(new Runnable() {

							@Override
							public void run() {
								filterService
										.activateFilterIdsAndUpdateViewer(filterList);
							}
						});
						return Status.OK_STATUS;
					}
				};

				job.setUser(true);
				job.schedule();
			}
		}

		return true;
	}
}
