/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.navigation;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.navigation.provider.NavigationTargetProvider;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.papyrus.infra.widgets.util.RevealSemanticElementWrapper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

/**
 * A NavigationTargetProvider for the ModelExplorer view
 *
 * @author Camille Letavernier
 *
 */
public class ModelExplorerNavigationTargetProvider implements NavigationTargetProvider {


	/**
	 * {@inheritDoc}
	 *
	 * Returns a NavigationTarget based on the active ModelExplorerView (or null if the ModelExplorer is closed)
	 */
	public NavigationTarget getNavigationTarget(ServicesRegistry registry) {
		IViewPart modelExplorerView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ModelExplorerPageBookView.VIEW_ID);

		if (modelExplorerView instanceof MultiViewPageBookView) {
			MultiViewPageBookView pageBook = (MultiViewPageBookView) modelExplorerView;
			IViewPart activeView = pageBook.getActiveView();
			if (activeView instanceof NavigationTarget) {
				return (NavigationTarget) activeView;
			} else if (activeView instanceof IRevealSemanticElement) {
				return new RevealSemanticElementWrapper((IRevealSemanticElement) activeView);
			}
		}

		return null;
	}

}
