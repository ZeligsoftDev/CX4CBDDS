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

/* $Id: ImageRepresentation.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.pipeline;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.util.dijkstra.Vertex;

/**
 * This class represents a combination of MIME type and an image flavor.
 * It is used in conjunction with Dijkstra's algorithm to find and construct a
 * conversion pipeline for images.
 */
public class ImageRepresentation implements Vertex {

    private ImageFlavor flavor;

    /**
     * Main constructor
     * @param flavor the image flavor
     */
    public ImageRepresentation(ImageFlavor flavor) {
        if (flavor == null) {
            throw new NullPointerException("flavor must not be null");
        }
        this.flavor = flavor;
    }

    /**
     * Returns the image flavor.
     * @return the image flavor
     */
    public ImageFlavor getFlavor() {
        return flavor;
    }

    /** {@inheritDoc} */
    public boolean equals(Object obj) {
        assert obj != null;
        return toString().equals(obj.toString());
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return getFlavor().hashCode();
    }

    /** {@inheritDoc} */
    public int compareTo(Object obj) {
        return toString().compareTo(((ImageRepresentation)obj).toString());
    }

    /** {@inheritDoc} */
    public String toString() {
        return getFlavor().toString();
    }

}
