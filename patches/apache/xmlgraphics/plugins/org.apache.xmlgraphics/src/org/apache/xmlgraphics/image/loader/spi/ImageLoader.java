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

/* $Id: ImageLoader.java 924666 2010-03-18 08:26:30Z jeremias $ */

package org.apache.xmlgraphics.image.loader.spi;

import java.io.IOException;
import java.util.Map;

import org.apache.xmlgraphics.image.loader.Image;
import org.apache.xmlgraphics.image.loader.ImageException;
import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.ImageSessionContext;

/**
 * This interface is implemented by classes which load images from a source. Normally, such a
 * source will be an InputStream but can also be something else.
 */
public interface ImageLoader {

    /** Used if the loading penalty is negligible (image doesn't need to be decoded). */
    int NO_LOADING_PENALTY = 0;
    /** Default/Medium conversion penalty (if there's some effort to load the image format) */
    int MEDIUM_LOADING_PENALTY = 10;

    /**
     * Loads and returns an image.
     * @param info the image info object indicating the image
     * @param hints a Map of hints that can be used by implementations to customize the loading
     *                  process (may be null).
     * @param session the session context
     * @return the fully loaded image
     * @throws ImageException if an error occurs while loading the image
     * @throws IOException if an I/O error occurs while loading the image
     */
    Image loadImage(ImageInfo info, Map hints, ImageSessionContext session)
            throws ImageException, IOException;

    /**
     * Loads and returns an image.
     * @param info the image info object indicating the image
     * @param session the session context
     * @return the fully loaded image
     * @throws ImageException if an error occurs while loading the image
     * @throws IOException if an I/O error occurs while loading the image
     */
    Image loadImage(ImageInfo info, ImageSessionContext session)
            throws ImageException, IOException;

    /**
     * Returns the image flavor that is returned by this ImageLoader implementation.
     * @return the target image flavor
     */
    ImageFlavor getTargetFlavor();

    /**
     * Returns the penalty assigned to using this image loader. The value is used to select the
     * best processing chain for images.
     * @return the usage penalty (must be a non-negative integer)
     */
    int getUsagePenalty();

}
