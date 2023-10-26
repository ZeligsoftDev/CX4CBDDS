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

/* $Id: ImageLoaderRawJPEG.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.stream.ImageInputStream;
import javax.xml.transform.Source;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.xmlgraphics.image.loader.Image;
import org.apache.xmlgraphics.image.loader.ImageException;
import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.ImageSessionContext;
import org.apache.xmlgraphics.image.loader.util.ImageUtil;
import org.apache.xmlgraphics.io.XmlSourceUtil;
import org.apache.xmlgraphics.java2d.color.ColorSpaces;
import org.apache.xmlgraphics.java2d.color.profile.ColorProfileUtil;
import org.apache.xmlgraphics.util.MimeConstants;

/**
 * ImageLoader for JPEG images consumed "raw" (undecoded). Provides a
 * raw/undecoded stream.
 */
public class ImageLoaderRawJPEG extends AbstractImageLoader implements JPEGConstants {

    /** logger */
    protected static final Logger log = LogManager.getLogger(ImageLoaderRawJPEG.class);

    /**
     * Main constructor.
     */
    public ImageLoaderRawJPEG() {
    }

    /** {@inheritDoc} */
    public ImageFlavor getTargetFlavor() {
        return ImageFlavor.RAW_JPEG;
    }

    /** {@inheritDoc} */
    public Image loadImage(ImageInfo info, Map hints, ImageSessionContext session)
                throws ImageException, IOException {
        if (!MimeConstants.MIME_JPEG.equals(info.getMimeType())) {
            throw new IllegalArgumentException("ImageInfo must be from a image with MIME type: "
                    + MimeConstants.MIME_JPEG);
        }

        ColorSpace colorSpace = null;
        boolean appeFound = false;
        int sofType = 0;
        ByteArrayOutputStream iccStream = null;

        Source src = session.needSource(info.getOriginalURI());
        ImageInputStream in = ImageUtil.needImageInputStream(src);
        JPEGFile jpeg = new JPEGFile(in);
        in.mark();
        try {
            outer:
            while (true) {
                int reclen;
                int segID = jpeg.readMarkerSegment();
                if (log.isTraceEnabled()) {
                    log.trace("Seg Marker: " + Integer.toHexString(segID));
                }
                switch (segID) {
                case EOI:
                    log.trace("EOI found. Stopping.");
                    break outer;
                case SOS:
                    log.trace("SOS found. Stopping early."); //TODO Not sure if this is safe
                    break outer;
                case SOI:
                case NULL:
                    break;
                case SOF0: //baseline
                case SOF1: //extended sequential DCT
                case SOF2: //progressive (since PDF 1.3)
                case SOFA: //progressive (since PDF 1.3)
                    sofType = segID;
                    if (log.isTraceEnabled()) {
                        log.trace("SOF: " + Integer.toHexString(sofType));
                    }
                    in.mark();
                    try {
                        reclen = jpeg.readSegmentLength();
                        in.skipBytes(1); //data precision
                        in.skipBytes(2); //height
                        in.skipBytes(2); //width
                        int numComponents = in.readUnsignedByte();
                        if (numComponents == 1) {
                            colorSpace = ColorSpace.getInstance(
                              ColorSpace.CS_GRAY);
                        } else if (numComponents == 3) {
                            colorSpace = ColorSpace.getInstance(
                              ColorSpace.CS_LINEAR_RGB);
                        } else if (numComponents == 4) {
                            colorSpace = ColorSpaces.getDeviceCMYKColorSpace();
                        } else {
                            throw new ImageException("Unsupported ColorSpace for image "
                                        + info
                                        + ". The number of components supported are 1, 3 and 4.");
                        }
                    } finally {
                        in.reset();
                    }
                    in.skipBytes(reclen);
                    break;
                case APP2: //ICC (see ICC1V42.pdf)
                    in.mark();
                    try {
                        reclen = jpeg.readSegmentLength();
                        // Check for ICC profile
                        byte[] iccString = new byte[11];
                        in.readFully(iccString);
                        in.skipBytes(1); //string terminator (null byte)

                        if ("ICC_PROFILE".equals(new String(iccString, "US-ASCII"))) {
                            in.skipBytes(2); //chunk sequence number and total number of chunks
                            int payloadSize = reclen - 2 - 12 - 2;
                            if (ignoreColorProfile(hints)) {
                                log.debug("Ignoring ICC profile data in JPEG");
                                in.skipBytes(payloadSize);
                            } else {
                                byte[] buf = new byte[payloadSize];
                                in.readFully(buf);
                                if (iccStream == null) {
                                    if (log.isDebugEnabled()) {
                                        log.debug("JPEG has an ICC profile");
                                        DataInputStream din = new DataInputStream(new ByteArrayInputStream(buf));
                                        log.debug("Declared ICC profile size: " + din.readInt());
                                    }
                                    //ICC profiles can be split into several chunks
                                    //so collect in a byte array output stream
                                    iccStream = new ByteArrayOutputStream();
                                }
                                iccStream.write(buf);
                            }
                        }
                    } finally {
                        in.reset();
                    }
                    in.skipBytes(reclen);
                    break;
                case APPE: //Adobe-specific (see 5116.DCT_Filter.pdf)
                    in.mark();
                    try {
                        reclen = jpeg.readSegmentLength();
                        // Check for Adobe header
                        byte[] adobeHeader = new byte[5];
                        in.readFully(adobeHeader);

                        if ("Adobe".equals(new String(adobeHeader, "US-ASCII"))) {
                            // The reason for reading the APPE marker is that Adobe Photoshop
                            // generates CMYK JPEGs with inverted values. The correct thing
                            // to do would be to interpret the values in the marker, but for now
                            // only assume that if APPE marker is present and colorspace is CMYK,
                            // the image is inverted.
                            appeFound = true;
                        }
                    } finally {
                        in.reset();
                    }
                    in.skipBytes(reclen);
                    break;
                default:
                    jpeg.skipCurrentMarkerSegment();
                }
            }
        } finally {
            in.reset();
        }

        ICC_Profile iccProfile = buildICCProfile(info, colorSpace, iccStream);
        if (iccProfile == null && colorSpace == null) {
            throw new ImageException("ColorSpace could not be identified for JPEG image " + info);
        }

        boolean invertImage = false;
        if (appeFound && colorSpace.getType() == ColorSpace.TYPE_CMYK) {
            if (log.isDebugEnabled()) {
                log.debug("JPEG has an Adobe APPE marker. Note: CMYK Image will be inverted. ("
                        + info.getOriginalURI() + ")");
            }
            invertImage = true;
        }

        ImageRawJPEG rawImage = new ImageRawJPEG(info,
                XmlSourceUtil.needInputStream(src),
                sofType, colorSpace, iccProfile, invertImage);
        return rawImage;
    }

    private ICC_Profile buildICCProfile(ImageInfo info, ColorSpace colorSpace,
            ByteArrayOutputStream iccStream) throws IOException, ImageException {
        if (iccStream != null && iccStream.size() > 0) {
            if (log.isDebugEnabled()) {
                log.debug("Effective ICC profile size: " + iccStream.size());
            }
            final int alignment = 4;
            int padding = (alignment - (iccStream.size() % alignment)) % alignment;
            if (padding != 0) {
                try {
                    iccStream.write(new byte[padding]);
                } catch (IOException ioe) {
                    throw new IOException("Error while aligning ICC stream: " + ioe.getMessage());
                }
            }

            ICC_Profile iccProfile = null;
            try {
                iccProfile = ColorProfileUtil.getICC_Profile(iccStream.toByteArray());
                if (log.isDebugEnabled()) {
                    log.debug("JPEG has an ICC profile: " + iccProfile.toString());
                }
            } catch (IllegalArgumentException iae) {
                log.warn("An ICC profile is present in the JPEG file but it is invalid ("
                        + iae.getMessage() + "). The color profile will be ignored. ("
                        + info.getOriginalURI() + ")");
                return null;
            }
            if (iccProfile.getNumComponents() != colorSpace.getNumComponents()) {
                log.warn("The number of components of the ICC profile ("
                        + iccProfile.getNumComponents()
                        + ") doesn't match the image ("
                        + colorSpace.getNumComponents()
                        + "). Ignoring the ICC color profile.");
                return null;
            } else {
                return iccProfile;
            }
        } else {
            return null; //no ICC profile available
        }
    }

}
