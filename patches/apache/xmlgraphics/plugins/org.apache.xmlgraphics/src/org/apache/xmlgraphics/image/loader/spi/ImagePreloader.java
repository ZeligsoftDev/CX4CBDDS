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

/* $Id: ImagePreloader.java 750116 2009-03-04 19:23:59Z jeremias $ */

package org.apache.xmlgraphics.image.loader.spi;

import java.io.IOException;

import javax.xml.transform.Source;

import org.apache.xmlgraphics.image.loader.ImageContext;
import org.apache.xmlgraphics.image.loader.ImageException;
import org.apache.xmlgraphics.image.loader.ImageInfo;

/**
 * This interface provides two functions: determining whether an image format is supported and if
 * that's the case, some minimal information (mostly the image's intrinsic size) is extracted
 * and returned.
 */
public interface ImagePreloader {

    /** Default priority for preloaders */
    int DEFAULT_PRIORITY = 1000;

    /**
     * "Preloads" an image, i.e. indentifies whether the source image is supported by this
     * implementation and determines the image's intrinsic size and possibly some additional
     * information. The image is usually not fully loaded at this time to conserve memory.
     * The method returns null if the image was not identified. An {@link ImageException} is only
     * thrown if the image is identified but some error has happened while working on the file.
     * @param originalURI the original (unresolved) URI of the image
     * @param src a image source the image is loaded from
     * @param context the context object that provides configuration information
     * @return an image info object with the basic information about an image or null if the
     *           image is not supported by this implementation
     * @throws ImageException if an error occurs while preloading the image
     * @throws IOException if an I/O error occurs while preloading the image
     */
    ImageInfo preloadImage(String originalURI,
            Source src, ImageContext context) throws ImageException, IOException;

    /**
     * Returns the priority of the preloader. The lower the value, the higher the preloader's
     * priority.
     * @return an integer (default is 1000)
     */
    int getPriority();
}
