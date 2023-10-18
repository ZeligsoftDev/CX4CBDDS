/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public abstract class SideBySideImageDecorator extends LabelProvider implements ILabelDecorator
{
	protected static class SideBySideImages extends ComposedImage		// NB super's Javadoc recommends static
	{
		protected final int gap;

		protected SideBySideImages(int gap, Collection<?> images) {
			super(images);
			this.gap = gap;
		}

		@Override
		public boolean equals(Object that) {
		    return that instanceof SideBySideImages && (((SideBySideImages)that).gap == gap) && ((SideBySideImages)that).getImages().equals(images);
		}

		@Override
		public int hashCode() {
			return super.hashCode() + gap + getClass().hashCode();
		}

		@Override
		public List<Point> getDrawPoints(Size size) {
		    Size size0 = this.imageSizes.get(0);
		    Size size1 = this.imageSizes.get(1);
		    int height = Math.max(size0.height, size1.height);
			List<Point> result = new ArrayList<Point>();
			Point overlay0 = new Point();
			overlay0.y = Math.min(height - size0.height, height/2);
			result.add(overlay0);
			Point overlay1 = new Point();
			overlay1.x = size0.width + gap;
			overlay1.y = Math.min(height - size1.height, height/2);
			result.add(overlay1);
			return result;
		}

		@Override
		public Size getSize(Collection<? extends Size> imageSizes) {
		    this.imageSizes = new ArrayList<Size>(imageSizes);
		    Size size0 = this.imageSizes.get(0);
		    Size size1 = this.imageSizes.get(1);
		    Size result = new Size();
		    result.width = size0.width + gap + size1.width;
		    result.height = Math.max(size0.height, size1.height);
		    return result;
		}
	}

	protected final int gap;

	public SideBySideImageDecorator(int gap) {
		this.gap = gap;
	}

	public Image composeImages(Image image, Object image2) {
		if (image == null) {
			return ExtendedImageRegistry.INSTANCE.getImage(image2);
		} else {
			List<Object> images = new ArrayList<Object>(2);
			images.add(image2);
			images.add(image);
			ComposedImage composedImage = new SideBySideImages(gap, images);
			return ExtendedImageRegistry.INSTANCE.getImage(composedImage);
		}
	}

	public String decorateText(String text, Object element) {
		return text;
	}
}
