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

/* $Id: PreloaderTIFF.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl;

import java.io.IOException;
import java.text.MessageFormat;

import javax.imageio.stream.ImageInputStream;
import javax.xml.transform.Source;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.xmlgraphics.image.codec.tiff.TIFFDirectory;
import org.apache.xmlgraphics.image.codec.tiff.TIFFField;
import org.apache.xmlgraphics.image.codec.tiff.TIFFImageDecoder;
import org.apache.xmlgraphics.image.codec.util.SeekableStream;
import org.apache.xmlgraphics.image.loader.ImageContext;
import org.apache.xmlgraphics.image.loader.ImageException;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.ImageSize;
import org.apache.xmlgraphics.image.loader.SubImageNotFoundException;
import org.apache.xmlgraphics.image.loader.util.ImageUtil;
import org.apache.xmlgraphics.image.loader.util.SeekableStreamAdapter;
import org.apache.xmlgraphics.util.MimeConstants;
import org.apache.xmlgraphics.util.UnitConv;

/**
 * Image preloader for TIFF images.
 * <p>
 * Note: The implementation relies on the TIFF codec code in Apache XML Graphics Commons for
 * access to the TIFF directory.
 */
public class PreloaderTIFF extends AbstractImagePreloader {

    private static Logger log = LogManager.getLogger(PreloaderTIFF.class);

    private static final int TIFF_SIG_LENGTH = 8;

    /** {@inheritDoc}
     * @throws ImageException */
    public ImageInfo preloadImage(String uri, Source src, ImageContext context)
            throws IOException, ImageException {
        if (!ImageUtil.hasImageInputStream(src)) {
            return null;
        }
        ImageInputStream in = ImageUtil.needImageInputStream(src);
        byte[] header = getHeader(in, TIFF_SIG_LENGTH);
        boolean supported = false;

        // first 2 bytes = II (little endian encoding)
        if (header[0] == (byte) 0x49 && header[1] == (byte) 0x49) {

            // look for '42' in byte 3 and '0' in byte 4
            if (header[2] == 42 && header[3] == 0) {
                supported = true;
            }
        }

        // first 2 bytes == MM (big endian encoding)
        if (header[0] == (byte) 0x4D && header[1] == (byte) 0x4D) {

            // look for '42' in byte 4 and '0' in byte 3
            if (header[2] == 0 && header[3] == 42) {
                supported = true;
            }
        }

        if (supported) {
            ImageInfo info = createImageInfo(uri, in, context);
            return info;
        } else {
            return null;
        }
    }

    private ImageInfo createImageInfo(String uri, ImageInputStream in, ImageContext context)
                throws IOException, ImageException {
        ImageInfo info = null;
        in.mark();
        try {
            int pageIndex = ImageUtil.needPageIndexFromURI(uri);

            SeekableStream seekable = new SeekableStreamAdapter(in);
            TIFFDirectory dir;
            try {
                dir = new TIFFDirectory(seekable, pageIndex);
            } catch (IllegalArgumentException iae) {
                String errorMessage = MessageFormat.format(
                        "Subimage {0} does not exist.", new Object[] {pageIndex});
                throw new SubImageNotFoundException(errorMessage);
            }
            int width = (int)dir.getFieldAsLong(TIFFImageDecoder.TIFF_IMAGE_WIDTH);
            int height = (int)dir.getFieldAsLong(TIFFImageDecoder.TIFF_IMAGE_LENGTH);
            ImageSize size = new ImageSize();
            size.setSizeInPixels(width, height);
            int unit = 2; //inch is default
            if (dir.isTagPresent(TIFFImageDecoder.TIFF_RESOLUTION_UNIT)) {
                unit = (int)dir.getFieldAsLong(TIFFImageDecoder.TIFF_RESOLUTION_UNIT);
            }
            if (unit == 2 || unit == 3) {
                float xRes;
                float yRes;
                TIFFField fldx = dir.getField(TIFFImageDecoder.TIFF_X_RESOLUTION);
                TIFFField fldy = dir.getField(TIFFImageDecoder.TIFF_Y_RESOLUTION);
                if (fldx == null || fldy == null) {
                    unit = 2;
                    xRes = context.getSourceResolution();
                    yRes = xRes;
                } else {
                    xRes = fldx.getAsFloat(0);
                    yRes = fldy.getAsFloat(0);
                }
                if (xRes == 0 || yRes == 0) {
                    //Some TIFFs may report 0 here which would lead to problems
                    size.setResolution(context.getSourceResolution());
                } else if (unit == 2) {
                    size.setResolution(xRes, yRes); //Inch
                } else {
                    size.setResolution(
                            UnitConv.in2mm(xRes) / 10,
                            UnitConv.in2mm(yRes) / 10); //Centimeters
                }
            } else {
                size.setResolution(context.getSourceResolution());
            }
            size.calcSizeFromPixels();
            if (log.isTraceEnabled()) {
                log.trace("TIFF image detected: " + size);
            }

            info = new ImageInfo(uri, MimeConstants.MIME_TIFF);
            info.setSize(size);

            TIFFField fld;

            fld = dir.getField(TIFFImageDecoder.TIFF_COMPRESSION);
            if (fld != null) {
                int compression = fld.getAsInt(0);
                if (log.isTraceEnabled()) {
                    log.trace("TIFF compression: " + compression);
                }
                info.getCustomObjects().put("TIFF_COMPRESSION", compression);
            }

            fld = dir.getField(TIFFImageDecoder.TIFF_TILE_WIDTH);
            if (fld != null) {
                if (log.isTraceEnabled()) {
                    log.trace("TIFF is tiled");
                }
                info.getCustomObjects().put("TIFF_TILED", Boolean.TRUE);
            }

            int stripCount;
            fld = dir.getField(TIFFImageDecoder.TIFF_ROWS_PER_STRIP);
            if (fld == null) {
                stripCount = 1;
            } else {
                stripCount = (int)Math.ceil(size.getHeightPx() / (double)fld.getAsLong(0));
            }
            if (log.isTraceEnabled()) {
                log.trace("TIFF has " + stripCount + " strips.");
            }
            info.getCustomObjects().put("TIFF_STRIP_COUNT", stripCount);

            try {
                //Check if there is a next page
                new TIFFDirectory(seekable, pageIndex + 1);
                info.getCustomObjects().put(ImageInfo.HAS_MORE_IMAGES, Boolean.TRUE);
                if (log.isTraceEnabled()) {
                    log.trace("TIFF is multi-page.");
                }
            } catch (IllegalArgumentException iae) {
                info.getCustomObjects().put(ImageInfo.HAS_MORE_IMAGES, Boolean.FALSE);
            }
        } finally {
            in.reset();
        }

        return info;
    }

}
