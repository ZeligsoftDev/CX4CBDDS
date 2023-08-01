/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - don't rely on IMarker changes to refresh Model Explorer labels (CDO)
 *
 * History:
 *  Renamed from MoDiscoLabelProviderWTooltips - fix for bug 371905
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ModelExplorerDecorationAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.navigator.NavigatorDecoratingLabelProvider;

/**
 * A LabelProvider with support for decorations
 */
public class DecoratingLabelProviderWTooltips extends NavigatorDecoratingLabelProvider implements Observer {

	private DecorationService decorationService;

	public DecoratingLabelProviderWTooltips(ILabelProvider labelProvider, ServicesRegistry servicesRegistry) {
		super(labelProvider);
		try {
			this.decorationService = servicesRegistry.getService(DecorationService.class);
			this.decorationService.addListener(this);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void dispose() {
		try {
			if (decorationService != null) {
				decorationService.deleteListener(this);
			}
		} finally {
			super.dispose();
		}
	}

	public void update(Observable o, Object arg) {
		if ((decorationService != null) && (o == decorationService)) {

			// fix for bug 409381 - [Validation] Performance issues. Make updates asynchronously so that
			// most updates are ignored.
			// TODO: check whether the decoration service should offer a service for listeners that want to
			// be notified in this lazy way.
			if (!asyncUpdateRunning) {
				asyncUpdateRunning = true;

				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireLabelProviderChanged(new LabelProviderChangedEvent(DecoratingLabelProviderWTooltips.this));
						while (updatePending) {
							updatePending = false;
							fireLabelProviderChanged(new LabelProviderChangedEvent(DecoratingLabelProviderWTooltips.this));
						}
						asyncUpdateRunning = false;

					}
				});
			}
			else {
				updatePending = true;
			}
		}

	}

	@Override
	public String getToolTipText(Object element) {
		if (decorationService == null) {
			return null;
		}

		return Decoration.getMessageFromDecorations(decorationService, element);
	}

	@Override
	public Image getImage(Object element) {
		Image baseImage = super.getImage(element);

		if (decorationService == null) {
			return baseImage;
		}
		// Get the Model Explorer Adapter
		ModelExplorerDecorationAdapter adapter = new ModelExplorerDecorationAdapter(baseImage);


		// Set the adapter decoration with position as indicated by decoration (from decoration service)
		if (element != null) {
			if (element instanceof EObject || element instanceof EReferenceTreeElement // fix for bug 391676
					|| (EMFHelper.getEObject(element) != null)) {
				List<IPapyrusDecoration> decorations = decorationService.getDecorations(EMFHelper.getEObject(element), true);
				if (decorations != null) {
					adapter.setDecorations(decorations);
				}
			}
		}

		// return the target decorated
		return adapter.getDecoratedImage();
	}

	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 500;
	}

	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 10000;
	}

	protected boolean asyncUpdateRunning;

	protected boolean updatePending;

}
