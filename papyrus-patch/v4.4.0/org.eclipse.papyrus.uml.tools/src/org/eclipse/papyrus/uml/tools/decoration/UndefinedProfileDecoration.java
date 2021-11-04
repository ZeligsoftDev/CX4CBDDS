/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.decoration;


import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Decoration for Undefined Profile.
 *
 * @author Gabriel Pascual
 * @since 4.1
 */
public class UndefinedProfileDecoration implements IDecorationSpecificFunctions {

	/** The Constant DECORATION_MESSAGE. */
	private static final String DECORATION_MESSAGE = "The Profile Definition is outdated  since last modifications"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 */
	public UndefinedProfileDecoration() {
	}

	/**
	 * Gets the image descriptor for ge.
	 *
	 * @param marker
	 *            the marker
	 * @return the image descriptor for ge
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getImageDescriptorForGE(org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker)
	 */
	@Override
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker) {
		return null;
	}

	/**
	 * Gets the image descriptor for me.
	 *
	 * @param marker
	 *            the marker
	 * @return the image descriptor for me
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getImageDescriptorForME(org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker)
	 */
	@Override
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker) {
		ImageDescriptor imageDescriptor = null;
		if (marker instanceof UndefinedProfileMarker) {
			imageDescriptor = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
		}
		return imageDescriptor;
	}

	/**
	 * Gets the prefered position.
	 *
	 * @param marker
	 *            the marker
	 * @return the prefered position
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getPreferedPosition(org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker)
	 */
	@Override
	public PreferedPosition getPreferedPosition(IPapyrusMarker marker) {
		return PreferedPosition.NORTH_EAST;
	}

	/**
	 * Gets the message.
	 *
	 * @param marker
	 *            the marker
	 * @return the message
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getMessage(org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker)
	 */
	@Override
	public String getMessage(IPapyrusMarker marker) {
		return DECORATION_MESSAGE;
	}

	/**
	 * Gets the priority.
	 *
	 * @param marker
	 *            the marker
	 * @return the priority
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getPriority(org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker)
	 */
	@Override
	public int getPriority(IPapyrusMarker marker) {
		return 0;
	}

	/**
	 * Supports marker propagation.
	 *
	 * @return the mark children
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#supportsMarkerPropagation()
	 */
	@Override
	public MarkChildren supportsMarkerPropagation() {

		return null;
	}

	/**
	 * Marker propagation.
	 *
	 * @param childDecorations
	 *            the child decorations
	 * @return the i papyrus decoration
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#markerPropagation(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		return null;
	}

}
