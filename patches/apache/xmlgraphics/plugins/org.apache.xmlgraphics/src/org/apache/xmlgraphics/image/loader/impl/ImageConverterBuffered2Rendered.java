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

/* $Id: ImageConverterBuffered2Rendered.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl;

import java.util.Map;

import org.apache.xmlgraphics.image.loader.Image;
import org.apache.xmlgraphics.image.loader.ImageFlavor;

/**
 * This ImageConverter converts BufferedImages to RenderedImages (well, it's basically just a
 * class cast).
 */
public class ImageConverterBuffered2Rendered extends AbstractImageConverter {

    /** {@inheritDoc} */
    public Image convert(Image src, Map hints) {
        checkSourceFlavor(src);
        assert src instanceof ImageBuffered;
        ImageBuffered buffered = (ImageBuffered)src;
        return new ImageRendered(buffered.getInfo(), buffered
                .getRenderedImage(), buffered.getTransparentColor());
    }

    /** {@inheritDoc} */
    public ImageFlavor getSourceFlavor() {
        return ImageFlavor.BUFFERED_IMAGE;
    }

    /** {@inheritDoc} */
    public ImageFlavor getTargetFlavor() {
        return ImageFlavor.RENDERED_IMAGE;
    }

    /** {@inheritDoc} */
    public int getConversionPenalty() {
        return NO_CONVERSION_PENALTY;
    }

}
