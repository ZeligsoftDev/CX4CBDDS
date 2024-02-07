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

/* $Id: ImageConversionEdge.java 924666 2010-03-18 08:26:30Z jeremias $ */

package org.apache.xmlgraphics.image.loader.pipeline;

import org.apache.xmlgraphics.image.loader.spi.ImageConverter;
import org.apache.xmlgraphics.image.loader.util.Penalty;
import org.apache.xmlgraphics.util.dijkstra.Edge;
import org.apache.xmlgraphics.util.dijkstra.Vertex;

/**
 * Represents an image conversion. The class basically wraps an ImageConverter so it can be
 * used with Dijkstra's shortest route algorithm to build image conversion pipelines.
 */
class ImageConversionEdge implements Edge {

    private ImageRepresentation source;
    private ImageRepresentation target;
    private ImageConverter converter;
    private int penalty;

    /**
     * Main constructor.
     * @param converter the image converter
     * @param penalty the penalty for this edge
     */
    public ImageConversionEdge(ImageConverter converter, Penalty penalty) {
        this.converter = converter;
        this.source = new ImageRepresentation(converter.getSourceFlavor());
        this.target = new ImageRepresentation(converter.getTargetFlavor());
        this.penalty = Math.max(0, penalty.getValue());
    }

    /**
     * Returns the wrapped ImageConverter.
     * @return the ImageConverter
     */
    public ImageConverter getImageConverter() {
        return this.converter;
    }

    /** {@inheritDoc} */
    public int getPenalty() {
        return this.penalty;
    }

    /** {@inheritDoc} */
    public Vertex getStart() {
        return this.source;
    }

    /** {@inheritDoc} */
    public Vertex getEnd() {
        return this.target;
    }

}
