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

/* $Id: ImageGraphics2D.java 1784728 2017-02-28 11:53:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.apache.xmlgraphics.image.loader.Image;
import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.java2d.Graphics2DImagePainter;

/**
 * This class is an implementation of the Image interface exposing a Graphics2DImagePainter.
 */
public class ImageGraphics2D extends AbstractImage {

    private Graphics2DImagePainter painter;

    /**
     * Main constructor.
     * @param info the image info object
     * @param painter the image painter that will paint the Java2D image
     */
    public ImageGraphics2D(ImageInfo info, Graphics2DImagePainter painter) {
        super(info);
        setGraphics2DImagePainter(painter);
    }

    /** {@inheritDoc} */
    public ImageFlavor getFlavor() {
        return ImageFlavor.GRAPHICS2D;
    }

    /** {@inheritDoc} */
    public boolean isCacheable() {
        Image img = getInfo().getOriginalImage();
        if (img == null) {
            return true;
        }
        return img.isCacheable();
    }

    /**
     * Returns the contained Graphics2DImagePainter instance.
     * @return the image painter
     */
    public Graphics2DImagePainter getGraphics2DImagePainter() {
        return this.painter;
    }

    /**
     * Sets the Graphics2DImagePainter instance.
     * @param painter the image painter
     */
    public void setGraphics2DImagePainter(Graphics2DImagePainter painter) {
        this.painter = painter;
    }

}
