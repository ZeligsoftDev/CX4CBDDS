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

/* $Id: AbstractImageConverter.java 750418 2009-03-05 11:03:54Z vhennebert $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.apache.xmlgraphics.image.loader.Image;
import org.apache.xmlgraphics.image.loader.spi.ImageConverter;

/**
 * Abstract base class for ImageConverter implementations.
 */
public abstract class AbstractImageConverter implements ImageConverter {

    /**
     * Checks if the source flavor of the given image is compatible with this ImageConverter.
     * @param img the image to check
     */
    protected void checkSourceFlavor(Image img) {
        if (!getSourceFlavor().equals(img.getFlavor())) {
            throw new IllegalArgumentException("Incompatible image: " + img);
        }
    }

    /** {@inheritDoc} */
    public int getConversionPenalty() {
        return MEDIUM_CONVERSION_PENALTY;
    }

}
