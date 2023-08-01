/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *  Vincent Lorenzo (CEA LIST) - Vincent.lorenzo@cea.fr - bug 481507
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview;

import java.util.List;

import org.eclipse.papyrus.infra.services.decoration.util.DecorationImageUtils;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.swt.graphics.Image;



/**
 * The Class ModelExplorerDecorationAdapter.
 */
public class ModelExplorerDecorationAdapter {

	/** The decorator target. */
	protected Image decoratorTarget;

	/** The decoration. */
	protected List<IPapyrusDecoration> decorations;

	/** The decoration position. */
	protected int decorationPosition;

	/**
	 * Instantiates a new model explorer decoration adapter.
	 *
	 * @param baseImage
	 *            the base image
	 */
	public ModelExplorerDecorationAdapter(Image baseImage) {
		this.decoratorTarget = baseImage;
	}

	/**
	 * Gets the decorator target.
	 *
	 * @return the decorator target
	 */
	public Image getDecoratorTarget() {
		return this.decoratorTarget;
	}

	/**
	 * Sets the decoration.
	 *
	 * @param decoration
	 *            the decoration
	 * @param decorationPosition
	 *            the decoration position
	 */
	public void setDecorations(List<IPapyrusDecoration> decorations) {
		this.decorations = decorations;
	}

	/**
	 * Sets the decorator target.
	 *
	 * @param decoratorTarget
	 *            the new decorator target
	 */
	public void setDecoratorTarget(Image decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}


	/**
	 * Sets the decoration position.
	 *
	 * @param decorationPosition
	 *            the new decoration position
	 */
	public void setDecorationPosition(int decorationPosition) {
		this.decorationPosition = decorationPosition;
	}

	/**
	 * Sets the decorated image.
	 *
	 * @param baseImage
	 *            the base image
	 * @param decoration
	 *            the decoration
	 * @param decorationPosition
	 *            the decoration position
	 */
	public Image getDecoratedImage() {
		return DecorationImageUtils.getDecoratedImage(decoratorTarget, decorations, DecorationImageUtils.SIZE_16_16);
	}

	/**
	 * 
	 * @return
	 * 		a unique id to identify the image
	 * @deprecated since Papyrus 1.2
	 */
	@Deprecated
	public String calcId() {
		return DecorationImageUtils.calcId(decoratorTarget, decorations);
	}
}
