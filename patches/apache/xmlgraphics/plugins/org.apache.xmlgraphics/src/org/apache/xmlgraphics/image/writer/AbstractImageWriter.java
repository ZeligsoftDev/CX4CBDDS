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

/* $Id: AbstractImageWriter.java 750418 2009-03-05 11:03:54Z vhennebert $ */

package org.apache.xmlgraphics.image.writer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Abstract base class for ImageWriter implementations.
 *
 * @version $Id: AbstractImageWriter.java 750418 2009-03-05 11:03:54Z vhennebert $
 */
public abstract class AbstractImageWriter implements ImageWriter {

    /**
     * @see org.apache.xmlgraphics.image.writer.ImageWriter#createMultiImageWriter(
     *                  java.io.OutputStream)
     */
    public MultiImageWriter createMultiImageWriter(OutputStream out)
            throws IOException {
        throw new UnsupportedOperationException("This ImageWriter does not support writing"
                + " multiple images to a single image file.");
    }

    /** @see org.apache.xmlgraphics.image.writer.ImageWriter#isFunctional() */
    public boolean isFunctional() {
        return true;
    }

    /** @see org.apache.xmlgraphics.image.writer.ImageWriter#supportsMultiImageWriter() */
    public boolean supportsMultiImageWriter() {
        return false;
    }

}
