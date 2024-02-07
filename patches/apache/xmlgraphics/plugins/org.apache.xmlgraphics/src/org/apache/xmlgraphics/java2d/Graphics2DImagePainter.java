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

/* $Id: Graphics2DImagePainter.java 1345683 2012-06-03 14:50:33Z gadams $ */

package org.apache.xmlgraphics.java2d;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * This interface is used to paint vector graphic images. Components that can paint using
 * a Graphics2D instance (i.e. Java2D) can implement this interface to paint themselves.
 */
public interface Graphics2DImagePainter {

    /**
     * Called to paint the image. Implementations should scale so the image is
     * painted fully inside the given area indicated by then Rectangle2D object.
     * @param g2d the Graphics2D instance to paint on
     * @param area the target area for the image (in target device units)
     */
    void paint(Graphics2D g2d, Rectangle2D area);

    /**
     * @return the dimensions (intrinsic size) of the image to be painted in millipoints
     */
    Dimension getImageSize();

}
