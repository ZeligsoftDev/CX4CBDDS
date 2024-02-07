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

/* $Id: ImageRawEPS.java 722804 2008-12-03 08:06:44Z jeremias $ */

package org.apache.xmlgraphics.image.loader.impl;

import java.awt.geom.Rectangle2D;
import java.io.InputStream;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;

/**
 * This class is an implementation of the Image interface exposing EPS file. It provides an
 * InputStream to access the EPS content and the decoded high-res bounding box.
 */
public class ImageRawEPS extends ImageRawStream {

    /**
     * Main constructor.
     * @param info the image info object
     * @param streamFactory the InputStreamFactory that is used to create InputStream instances
     */
    public ImageRawEPS(ImageInfo info, InputStreamFactory streamFactory) {
        super(info, ImageFlavor.RAW_EPS, streamFactory);
    }

    /**
     * Main constructor.
     * @param info the image info object
     * @param in the InputStream with the raw content
     */
    public ImageRawEPS(ImageInfo info, InputStream in) {
        super(info, ImageFlavor.RAW_EPS, in);
    }

    /**
     * Returns the bounding box of the EPS image.
     * @return the bounding box
     */
    public Rectangle2D getBoundingBox() {
        Rectangle2D bbox = (Rectangle2D)getInfo().getCustomObjects().get(
                PreloaderEPS.EPS_BOUNDING_BOX);
        return bbox;
    }
}
