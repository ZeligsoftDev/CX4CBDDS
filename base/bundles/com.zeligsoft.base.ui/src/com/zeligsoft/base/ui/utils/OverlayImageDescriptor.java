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
package com.zeligsoft.base.ui.utils;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

/**
 * Overlay image on top of the source image at a given location
 * 
 * @author ysroh
 * 
 */
public class OverlayImageDescriptor extends
		org.eclipse.gmf.runtime.common.ui.util.OverlayImageDescriptor {

	private Image srcImage = null;
	private ImageDescriptor overlayDesc = null;
	private int startX = 0;
	private int startY = 0;

	/**
	 * Constructor
	 * 
	 * @param srcImage
	 * @param overlayDesc
	 */
	public OverlayImageDescriptor(Image srcImage, ImageDescriptor overlayDesc) {
		super(srcImage, overlayDesc);
		this.srcImage = srcImage;
		this.overlayDesc = overlayDesc;
	}

	/**
	 * Set position of overlay image. Overlay image will be drawn at a specified
	 * given location
	 * 
	 * @param position
	 */
	public void setOverlayPosition(int position) {
		switch (position) {
		case PositionConstants.CENTER:
			startX = srcImage.getBounds().width / 2;
			startX -= overlayDesc.getImageData().width / 2;
			startY = srcImage.getBounds().height / 2;
			startY -= overlayDesc.getImageData().height / 2;
			break;

		case PositionConstants.SOUTH_EAST:
			startX = srcImage.getBounds().width
					- overlayDesc.getImageData().width;
			startY = srcImage.getBounds().height
					- overlayDesc.getImageData().height;
			break;

		case PositionConstants.EAST:
			startX = srcImage.getBounds().width
					- overlayDesc.getImageData().width;
			startY = (srcImage.getBounds().height / 2)
					- (overlayDesc.getImageData().height / 2);
			break;
		case PositionConstants.WEST:
			startX = 0;
			startY = (srcImage.getBounds().height / 2)
					- (overlayDesc.getImageData().height / 2);
			break;
			
		case PositionConstants.SOUTH_WEST:
			startX = 0;
			startY = srcImage.getBounds().height
					- overlayDesc.getImageData().height;
			break;
			
		case PositionConstants.NORTH_EAST:
			startX = srcImage.getBounds().width;
			startX -= overlayDesc.getImageData().width;
			startY = 0;
			break;			
		default:
			break;
		}
		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.util.OverlayImageDescriptor#
	 * drawCompositeImage(int, int)
	 */
	@Override
	protected void drawCompositeImage(int width, int height) {
		// draw the base image
		ImageData backgroundData = srcImage.getImageData();
		if (backgroundData != null) {
			drawImage(backgroundData, 0, 0);
		}

		// draw the overlay image
		ImageData overlayData = overlayDesc.getImageData();
		if (overlayData != null) {
			drawImage(overlayData, startX, startY);
		}
	}
}
