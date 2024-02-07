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

/* $Id: AbstractImageLoaderFactory.java 924666 2010-03-18 08:26:30Z jeremias $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.spi.ImageLoader;
import org.apache.xmlgraphics.image.loader.spi.ImageLoaderFactory;

/**
 * Abstract base class for ImageLoaderFactory implementations.
 */
public abstract class AbstractImageLoaderFactory implements ImageLoaderFactory {

    /** {@inheritDoc} */
    public boolean isSupported(ImageInfo imageInfo) {
        //Most ImageLoaderFactories are assumed to support the complete feature set of
        //an image format.
        return true;
    }

    /**
     * {@inheritDoc}
     * @deprecated Redundancy with {@link ImageLoader#getUsagePenalty()}
     */
    public int getUsagePenalty(String mime, ImageFlavor flavor) {
        //Kept for compatibility
        ImageLoader loader = newImageLoader(flavor);
        return loader.getUsagePenalty();
    }

}
