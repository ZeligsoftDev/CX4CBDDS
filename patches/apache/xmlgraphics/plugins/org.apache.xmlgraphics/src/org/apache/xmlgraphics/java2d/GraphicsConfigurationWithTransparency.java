/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id: GraphicsConfigurationWithTransparency.java 1862543 2019-07-04 09:25:38Z ssteiner $ */

package org.apache.xmlgraphics.java2d;

import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * An implementation of {@link java.awt.GraphicsConfiguration} that supports transparencies (alpha
 * channels).
 */
public class GraphicsConfigurationWithTransparency extends AbstractGraphicsConfiguration {
    // We use this to get a good colormodel..
    private static final BufferedImage BI_WITH_ALPHA =
        new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    // We use this to get a good colormodel..
    private static final BufferedImage BI_WITHOUT_ALPHA =
        new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    /**
     * Construct a buffered image with an alpha channel, unless transparency is OPAQUE (no alpha
     * at all).
     *
     * @param width the width of the image
     * @param height the height of the image
     * @param transparency the alpha value of the image
     * @return the new buffered image
     */
    public BufferedImage createCompatibleImage(int width, int height, int transparency) {
        if (transparency == Transparency.OPAQUE) {
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        } else {
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    }

    /**
     * Construct a buffered image with an alpha channel.
     *
     * @param width the width of the image
     * @param height the height of the image
     * @return the new buffered image
     */
    public BufferedImage createCompatibleImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * TODO: This should return the page bounds in Pts,  I couldn't figure out how to get this for
     * the current page (this still works for now, but it should be fixed...).
     *
     * @return the bounds of the document page
     */
    public Rectangle getBounds() {
        return new Rectangle();
    }

    /**
     * Return a good default color model for this 'device'.
     * @return the colour model for the configuration
     */
    public ColorModel getColorModel() {
        return BI_WITH_ALPHA.getColorModel();
    }

    /**
     * Return a good color model given <code>transparency</code>
     *
     * @param transparency the alpha value for the colour model
     * @return the colour model for the configuration
     */
    public ColorModel getColorModel(int transparency) {
        if (transparency == Transparency.OPAQUE) {
            return BI_WITHOUT_ALPHA.getColorModel();
        } else {
            return BI_WITH_ALPHA.getColorModel();
        }
    }

    /**
     * The default transform (1:1).
     *
     * @return the default transform for the configuration
     */
    public AffineTransform getDefaultTransform() {
        return new AffineTransform();
    }

    /**
     * The normalizing transform (1:1) (since we currently
     * render images at 72dpi, which we might want to change
     * in the future).
     *
     * @return the normalizing transform for the configuration
     */
    public AffineTransform getNormalizingTransform() {
        return new AffineTransform(2, 0, 0, 2, 0, 0);
    }

    /**
     * Return our dummy instance of GraphicsDevice
     *
     * @return the graphics device
     */
    public GraphicsDevice getDevice() {
        return new GenericGraphicsDevice(this);
    }
}
