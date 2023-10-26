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

/* $Id: ImageSize.java 696968 2008-09-19 07:52:04Z jeremias $ */

package org.apache.xmlgraphics.image.loader;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;

import org.apache.xmlgraphics.java2d.Dimension2DDouble;
import org.apache.xmlgraphics.util.UnitConv;

/**
 * Encapsulates the size of an image.
 */
public class ImageSize {

    private int widthPx;
    private int heightPx;

    private int widthMpt;
    private int heightMpt;
    private int baselinePositionFromBottomMpt;

    private double dpiHorizontal;
    private double dpiVertical;


    /**
     * Constructor.
     * @param widthPx the width of the image in pixels
     * @param heightPx the height of the image in pixels
     * @param dpiHorizontal the horizontal resolution in dots per inch
     * @param dpiVertical the vertical resolution in dots per inch
     */
    public ImageSize(int widthPx, int heightPx, double dpiHorizontal, double dpiVertical) {
        setSizeInPixels(widthPx, heightPx);
        setResolution(dpiHorizontal, dpiVertical);
    }

    /**
     * Constructor.
     * @param widthPx the width of the image in pixels
     * @param heightPx the height of the image in pixels
     * @param dpi the resolution in dots per inch
     */
    public ImageSize(int widthPx, int heightPx, double dpi) {
        this(widthPx, heightPx, dpi, dpi);
    }

    /**
     * Default Constructor.
     */
    public ImageSize() {
        //nop
    }

    /**
     * Sets the image's size in pixels.
     * @param width the width in pixels
     * @param height the height in pixels
     */
    public void setSizeInPixels(int width, int height) {
        this.widthPx = width;
        this.heightPx = height;
    }

    /**
     * Sets the image's size in millipoints.
     * @param width the width in millipoints
     * @param height the height in millipoints
     */
    public void setSizeInMillipoints(int width, int height) {
        this.widthMpt = width;
        this.heightMpt = height;
    }

    /**
     * Sets the image's resolution for interpreting the pixel size.
     * @param horizontal the horizontal resolution in dpi
     * @param vertical the vertical resolution in dpi
     */
    public void setResolution(double horizontal, double vertical) {
        this.dpiHorizontal = horizontal;
        this.dpiVertical = vertical;
    }

    /**
     * Sets the image's resolution for interpreting the pixel size.
     * @param resolution the resolution in dpi
     */
    public void setResolution(double resolution) {
        setResolution(resolution, resolution);
    }

    /**
     * Sets the vertical position of the baseline of the image relative to the bottom of the image.
     * The default is 0mpt (i.e. the image is bottom-aligned). This is used for MathML images, for
     * example, which have a baseline. Using the value the images can be properly aligned with
     * other text. Most other image don't have an implicit baseline.
     * @param distance the distance from the bottom of the image in millipoints
     */
    public void setBaselinePositionFromBottom(int distance) {
        this.baselinePositionFromBottomMpt = distance;
    }

    /**
     * Returns the vertical position of the baseline of the image relative to the bottom of the
     * image. The default is 0mpt (i.e. the image is bottom-aligned). This is used for MathML
     * images, for example, which have a baseline. Using the value the images can be properly
     * aligned with other text. Most other image don't have an implicit baseline.
     * @return the distance from the bottom of the image in millipoints
     */
    public int getBaselinePositionFromBottom() {
        return this.baselinePositionFromBottomMpt;
    }

    /**
     * Returns the image's width in pixels.
     * @return the width in pixels
     */
    public int getWidthPx() {
        return widthPx;
    }

    /**
     * Returns the image's height in pixels.
     * @return the height in pixels
     */
    public int getHeightPx() {
        return heightPx;
    }

    /**
     * Returns the image's width in millipoints.
     * @return the width in millipoints
     */
    public int getWidthMpt() {
        return widthMpt;
    }

    /**
     * Returns the image's height in millipoints.
     * @return the height in millipoints
     */
    public int getHeightMpt() {
        return heightMpt;
    }

    /**
     * Returns the image's horizontal resolution in dpi (dots per inch).
     * @return the horizontal resolution in dpi
     */
    public double getDpiHorizontal() {
        return dpiHorizontal;
    }

    /**
     * Returns the image's vertical resolution in dpi (dots per inch).
     * @return the vertical resolution in dpi
     */
    public double getDpiVertical() {
        return dpiVertical;
    }

    /**
     * Returns the size in millipoints as a Dimension object.
     * @return the size in millipoints
     */
    public Dimension getDimensionMpt() {
        return new Dimension(getWidthMpt(), getHeightMpt());
    }

    /**
     * Returns the size in points as a Dimension2D object.
     * @return the size in points
     */
    public Dimension2D getDimensionPt() {
        return new Dimension2DDouble(getWidthMpt() / 1000.0, getHeightMpt() / 1000.0);
    }

    /**
     * Returns the size in pixels as a Dimension object.
     * @return the size in pixels
     */
    public Dimension getDimensionPx() {
        return new Dimension(getWidthPx(), getHeightPx());
    }

    private void checkResolutionAvailable() {
        if (this.dpiHorizontal == 0 || this.dpiVertical == 0) {
            throw new IllegalStateException("The resolution must be set");
        }
    }

    /**
     * Calculates the size in millipoints based on the size in pixels and the resolution.
     */
    public void calcSizeFromPixels() {
        checkResolutionAvailable();
        this.widthMpt = (int)Math.round(UnitConv.in2mpt(this.widthPx / this.dpiHorizontal));
        this.heightMpt = (int)Math.round(UnitConv.in2mpt(this.heightPx / this.dpiVertical));
    }

    /**
     * Calculates the size in pixels based on the size in millipoints and the resolution.
     */
    public void calcPixelsFromSize() {
        checkResolutionAvailable();
        this.widthPx = (int)Math.round(UnitConv.mpt2in(this.widthMpt * this.dpiHorizontal));
        this.heightPx = (int)Math.round(UnitConv.mpt2in(this.heightMpt * this.dpiVertical));
    }

    /** {@inheritDoc} */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Size: ");
        sb.append(getWidthMpt()).append('x').append(getHeightMpt()).append(" mpt");
        sb.append(" (");
        sb.append(getWidthPx()).append('x').append(getHeightPx()).append(" px");
        sb.append(" at ").append(getDpiHorizontal()).append('x').append(getDpiVertical());
        sb.append(" dpi");
        sb.append(")");
        return sb.toString();
    }

}
