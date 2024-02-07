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

/* $Id: ImageLoaderFactoryInternalTIFF.java 1681137 2015-05-22 14:54:05Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.spi.ImageLoader;
import org.apache.xmlgraphics.util.MimeConstants;

/**
 * Factory class for the ImageLoader for TIFF (based on Commons' internal TIFF codec).
 */
public class ImageLoaderFactoryInternalTIFF extends AbstractImageLoaderFactory {

    private static final String[] MIMES = new String[] {
        MimeConstants.MIME_TIFF};

    private static final ImageFlavor[] FLAVORS = new ImageFlavor[] {
        ImageFlavor.RENDERED_IMAGE};


    /** {@inheritDoc} */
    public String[] getSupportedMIMETypes() {
        return MIMES;
    }

    /** {@inheritDoc} */
    public ImageFlavor[] getSupportedFlavors(String mime) {
        if (MimeConstants.MIME_TIFF.equals(mime)) {
            return FLAVORS;
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + mime);
    }

    /** {@inheritDoc} */
    public ImageLoader newImageLoader(ImageFlavor targetFlavor) {
        return new ImageLoaderInternalTIFF();
    }

    /** {@inheritDoc} */
    public boolean isAvailable() {
        return true;
    }

}
