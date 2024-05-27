/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class SideLabelProvider extends AdapterImpl {

	private final String ancestorLabel;

	private final String leftLabel;

	private final String rightLabel;

	private final Image ancestorImage;

	private final Image leftImage;

	private final Image rightImage;

	public SideLabelProvider(String ancestorLabel, String leftLabel, String rightLabel, Image ancestorImage,
			Image leftImage, Image rightImage) {
		this.ancestorLabel = ancestorLabel;
		this.leftLabel = leftLabel;
		this.rightLabel = rightLabel;
		this.ancestorImage = ancestorImage;
		this.leftImage = leftImage;
		this.rightImage = rightImage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == SideLabelProvider.class;
	}

	public String getAncestorLabel() {
		return ancestorLabel;
	}

	public String getLeftLabel() {
		return leftLabel;
	}

	public String getRightLabel() {
		return rightLabel;
	}

	public Image getAncestorImage() {
		return ancestorImage;
	}

	public Image getLeftImage() {
		return leftImage;
	}

	public Image getRightImage() {
		return rightImage;
	}
}
