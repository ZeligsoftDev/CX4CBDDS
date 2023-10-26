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

/* $Id: ImageRawCCITTFax.java 750418 2009-03-05 11:03:54Z vhennebert $ */

package org.apache.xmlgraphics.image.loader.impl;

import java.awt.color.ColorSpace;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;

/**
 * This class is an implementation of the Image interface exposing a 1-bit bitmap image stream
 * that can be decoded by the PostScript or PDF CCITTFaxDecode filter.
 */
public class ImageRawCCITTFax extends ImageRawStream {

    private int compression;

    /**
     * Main constructor.
     * @param info the image info object
     * @param in the ImageInputStream with the raw content
     * @param compression the integer value of the TIFF compression scheme
     */
    public ImageRawCCITTFax(ImageInfo info, java.io.InputStream in, int compression) {
        super(info, ImageFlavor.RAW_CCITTFAX, in);
        this.compression = compression;
    }

    /**
     * Returns the image's color space
     * @return the color space
     */
    public ColorSpace getColorSpace() {
        return ColorSpace.getInstance(ColorSpace.CS_GRAY);
    }

    /**
     * Returns the TIFF compression scheme.
     * @return the TIFF compression scheme
     */
    public int getCompression() {
        return this.compression;
    }

}
