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

/* $Id: TIFFEncodeParam.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.image.codec.tiff;

import java.util.Iterator;
import java.util.zip.Deflater;

import org.apache.xmlgraphics.image.codec.util.ImageEncodeParam;
import org.apache.xmlgraphics.image.codec.util.PropertyUtil;

/**
 * An instance of <code>ImageEncodeParam</code> for encoding images in
 * the TIFF format.
 *
 * <p> This class allows for the specification of encoding parameters. By
 * default, the image is encoded without any compression, and is written
 * out consisting of strips, not tiles. The particular compression scheme
 * to be used can be specified by using the <code>setCompression()</code>
 * method. The compression scheme specified will be honored only if it is
 * compatible with the type of image being written out. For example,
 * Group3 and Group4 compressions can only be used with Bilevel images.
 * Writing of tiled TIFF images can be enabled by calling the
 * <code>setWriteTiled()</code> method.
 *
 * <p><b> This class is not a committed part of the JAI API.  It may
 * be removed or changed in future releases of JAI.</b>
 *
 */
public class TIFFEncodeParam implements ImageEncodeParam {

    private static final long serialVersionUID = 2471949735040024055L;
    private CompressionValue compression = CompressionValue.NONE;

    private boolean writeTiled;
    private int tileWidth;
    private int tileHeight;

    private Iterator extraImages;

    private TIFFField[] extraFields;

    private boolean convertJPEGRGBToYCbCr = true;

    private int deflateLevel = Deflater.DEFAULT_COMPRESSION;

    /**
     * Constructs a TIFFEncodeParam object with default values for
     * all parameters.
     */
    public TIFFEncodeParam() {
        //nop
    }

    /** Returns the value of the compression parameter. */
    public CompressionValue getCompression() {
        return compression;
    }

    /**
     * Specifies the type of compression to be used.  The compression type
     * specified will be honored only if it is compatible with the image
     * being written out.  Currently only PackBits, JPEG, and DEFLATE
     * compression schemes are supported.
     *
     * <p> If <code>compression</code> is set to any value but
     * <code>COMPRESSION_NONE</code> and the <code>OutputStream</code>
     * supplied to the <code>ImageEncoder</code> is not a
     * <code>SeekableOutputStream</code>, then the encoder will use either
     * a temporary file or a memory cache when compressing the data
     * depending on whether the file system is accessible.  Compression
     * will therefore be more efficient if a <code>SeekableOutputStream</code>
     * is supplied.
     *
     * @param compression    The compression type.
     */
    public void setCompression(CompressionValue compression) {

        switch(compression) {
        case NONE:
        case PACKBITS:
        case DEFLATE:
            // Do nothing.
            break;
        default:
            throw new RuntimeException(PropertyUtil.getString("TIFFEncodeParam0"));
        }

        this.compression = compression;
    }

    /**
     * Returns the value of the writeTiled parameter.
     */
    public boolean getWriteTiled() {
        return writeTiled;
    }

    /**
     * If set, the data will be written out in tiled format, instead of
     * in strips.
     *
     * @param writeTiled     Specifies whether the image data should be
     *                       wriiten out in tiled format.
     */
    public void setWriteTiled(boolean writeTiled) {
        this.writeTiled = writeTiled;
    }

    /**
     * Sets the dimensions of the tiles to be written.  If either
     * value is non-positive, the encoder will use a default value.
     *
     * <p> If the data are being written as tiles, i.e.,
     * <code>getWriteTiled()</code> returns <code>true</code>, then the
     * default tile dimensions used by the encoder are those of the tiles
     * of the image being encoded.
     *
     * <p> If the data are being written as strips, i.e.,
     * <code>getWriteTiled()</code> returns <code>false</code>, the width
     * of each strip is always the width of the image and the default
     * number of rows per strip is 8.
     *
     * @param tileWidth The tile width; ignored if strips are used.
     * @param tileHeight The tile height or number of rows per strip.
     */
    public void setTileSize(int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    /**
     * Retrieves the tile width set via <code>setTileSize()</code>.
     */
    public int getTileWidth() {
        return tileWidth;
    }

    /**
     * Retrieves the tile height set via <code>setTileSize()</code>.
     */
    public int getTileHeight() {
        return tileHeight;
    }

    /**
     * Sets an <code>Iterator</code> of additional images to be written
     * after the image passed as an argument to the <code>ImageEncoder</code>.
     * The methods on the supplied <code>Iterator</code> must only be invoked
     * by the <code>ImageEncoder</code> which will exhaust the available
     * values unless an error occurs.
     *
     * <p> The value returned by an invocation of <code>next()</code> on the
     * <code>Iterator</code> must return either a <code>RenderedImage</code>
     * or an <code>Object[]</code> of length 2 wherein the element at index
     * zero is a <code>RenderedImage</code> amd the other element is a
     * <code>TIFFEncodeParam</code>.  If no <code>TIFFEncodeParam</code> is
     * supplied in this manner for an additional image, the parameters used
     * to create the <code>ImageEncoder</code> will be used.  The extra
     * image <code>Iterator</code> set on any <code>TIFFEncodeParam</code>
     * of an additional image will in all cases be ignored.
     */
    public synchronized void setExtraImages(Iterator extraImages) {
        this.extraImages = extraImages;
    }

    /**
     * Returns the additional image <code>Iterator</code> specified via
     * <code>setExtraImages()</code> or <code>null</code> if none was
     * supplied or if a <code>null</code> value was supplied.
     */
    public synchronized Iterator getExtraImages() {
        return extraImages;
    }

    /**
     * Sets the compression level for DEFLATE-compressed data which should
     * either be <code>java.util.Deflater.DEFAULT_COMPRESSION</code> or a
     * value in the range [1,9] where larger values indicate more compression.
     * The default setting is <code>Deflater.DEFAULT_COMPRESSION</code>.  This
     * setting is ignored if the compression type is not DEFLATE.
     */
    public void setDeflateLevel(int deflateLevel) {
        if (deflateLevel != Deflater.DEFAULT_COMPRESSION) {
            throw new RuntimeException(PropertyUtil.getString("TIFFEncodeParam1"));
        }

        this.deflateLevel = deflateLevel;
    }

    /**
     * Gets the compression level for DEFLATE compression.
     */
    public int getDeflateLevel() {
        return deflateLevel;
    }

    /**
     * Sets flag indicating whether to convert RGB data to YCbCr when the
     * compression type is JPEG.  The default value is <code>true</code>.
     * This flag is ignored if the compression type is not JPEG.
     */
    public void setJPEGCompressRGBToYCbCr(boolean convertJPEGRGBToYCbCr) {
        this.convertJPEGRGBToYCbCr = convertJPEGRGBToYCbCr;
    }

    /**
     * Whether RGB data will be converted to YCbCr when using JPEG compression.
     */
    public boolean getJPEGCompressRGBToYCbCr() {
        return convertJPEGRGBToYCbCr;
    }

    /**
     * Sets an array of extra fields to be written to the TIFF Image File
     * Directory (IFD).  Fields with tags equal to the tag of any
     * automatically generated fields are ignored.  No error checking is
     * performed with respect to the validity of the field contents or
     * the appropriateness of the field for the image being encoded.
     *
     * @param extraFields An array of extra fields; the parameter is
     * copied by reference.
     */
    public void setExtraFields(TIFFField[] extraFields) {
        this.extraFields = extraFields;
    }

    /**
     * Returns the value set by <code>setExtraFields()</code>.
     */
    public TIFFField[] getExtraFields() {
        if (extraFields == null) {
            return new TIFFField[0];
        }
        return extraFields;
    }
}
