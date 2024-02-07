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

/* $Id: ImageLoaderFactoryPNG.java 1732019 2016-02-24 05:01:10Z gadams $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.spi.ImageLoader;
import org.apache.xmlgraphics.util.MimeConstants;

public class ImageLoaderFactoryPNG extends AbstractImageLoaderFactory {

    private static final String[] MIMES = new String[] {MimeConstants.MIME_PNG};

    private static final ImageFlavor[] FLAVORS = new ImageFlavor[] {ImageFlavor.RENDERED_IMAGE};

    public ImageLoaderFactoryPNG() {
        //
    }

    /** {@inheritDoc} */
    public String[] getSupportedMIMETypes() {
        return MIMES;
    }

    /** {@inheritDoc} */
    public ImageFlavor[] getSupportedFlavors(String mime) {
        if (MimeConstants.MIME_PNG.equals(mime)) {
            return FLAVORS;
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + mime);
    }

    /** {@inheritDoc} */
    public ImageLoader newImageLoader(ImageFlavor targetFlavor) {
        return new ImageLoaderPNG();
    }

    /** {@inheritDoc} */
    public boolean isAvailable() {
        return true;
    }

}
