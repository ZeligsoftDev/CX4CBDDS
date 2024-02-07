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

/* $Id: ImageIOJPEGImageWriter.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.image.writer.imageio;

import java.awt.image.RenderedImage;

import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

import org.apache.xmlgraphics.image.writer.ImageWriterParams;


/**
 * ImageWriter that encodes JPEG images using Image I/O.
 *
 * @version $Id: ImageIOJPEGImageWriter.java 1732018 2016-02-24 04:51:06Z gadams $
 */
public class ImageIOJPEGImageWriter extends ImageIOImageWriter {

    private static final String JPEG_NATIVE_FORMAT = "javax_imageio_jpeg_image_1.0";

    /**
     * Main constructor.
     */
    public ImageIOJPEGImageWriter() {
        super("image/jpeg");
    }

    @Override
    protected IIOMetadata updateMetadata(RenderedImage image, IIOMetadata meta,
            ImageWriterParams params) {
        if (JPEG_NATIVE_FORMAT.equals(meta.getNativeMetadataFormatName())) {
            meta = addAdobeTransform(meta);
            IIOMetadataNode root = (IIOMetadataNode)meta.getAsTree(JPEG_NATIVE_FORMAT);
            IIOMetadataNode jv = getChildNode(root, "JPEGvariety");
            if (jv == null) {
                jv = new IIOMetadataNode("JPEGvariety");
                root.appendChild(jv);
            }
            IIOMetadataNode child;
            if (params.getResolution() != null) {
                child = getChildNode(jv, "app0JFIF");
                if (child == null) {
                    child = new IIOMetadataNode("app0JFIF");
                    jv.appendChild(child);
                }
                //JPEG gets special treatment because there seems to be a bug in
                //the JPEG codec in ImageIO converting the pixel size incorrectly
                //(or not at all) when using standard metadata format.
                child.setAttribute("majorVersion", null);
                child.setAttribute("minorVersion", null);
                switch (params.getResolutionUnit()) {
                case INCH:
                    child.setAttribute("resUnits", "1"); //dots per inch
                    break;
                case CENTIMETER:
                    child.setAttribute("resUnits", "2"); //dots per cm
                    break;
                default:
                    child.setAttribute("resUnits", "0"); //no unit
                }
                child.setAttribute("Xdensity", params.getXResolution().toString());
                child.setAttribute("Ydensity", params.getYResolution().toString());
                child.setAttribute("thumbWidth", null);
                child.setAttribute("thumbHeight", null);
            }
            try {
                meta.setFromTree(JPEG_NATIVE_FORMAT, root);
                //meta.mergeTree(JPEG_NATIVE_FORMAT, root);
            } catch (IIOInvalidTreeException e) {
                throw new RuntimeException("Cannot update image metadata: "
                            + e.getMessage(), e);
            }
        }
        return meta;
    }

    private static IIOMetadata addAdobeTransform(IIOMetadata meta) {
        // add the adobe transformation (transform 1 -> to YCbCr)
        IIOMetadataNode root = (IIOMetadataNode)meta.getAsTree(JPEG_NATIVE_FORMAT);

        IIOMetadataNode markerSequence = getChildNode(root, "markerSequence");
        if (markerSequence == null) {
            throw new RuntimeException("Invalid metadata!");
        }

        IIOMetadataNode adobeTransform = getChildNode(markerSequence, "app14Adobe");
        if (adobeTransform == null) {
            adobeTransform = new IIOMetadataNode("app14Adobe");
            adobeTransform.setAttribute("transform" , "1"); // convert RGB to YCbCr
            adobeTransform.setAttribute("version", "101");
            adobeTransform.setAttribute("flags0", "0");
            adobeTransform.setAttribute("flags1", "0");

            markerSequence.appendChild(adobeTransform);
        } else {
            adobeTransform.setAttribute("transform" , "1");
        }

        try {
            meta.setFromTree(JPEG_NATIVE_FORMAT, root);
        } catch (IIOInvalidTreeException e) {
            throw new RuntimeException("Cannot update image metadata: "
                        + e.getMessage(), e);
        }
        return meta;
    }

    /** {@inheritDoc} */
    @Override
    protected ImageWriteParam getDefaultWriteParam(
            ImageWriter iiowriter, RenderedImage image,
            ImageWriterParams params) {
        JPEGImageWriteParam param = new JPEGImageWriteParam(iiowriter.getLocale());
        //ImageTypeSpecifier type = ImageTypeSpecifier.createFromRenderedImage(image);
        /*
        ImageTypeSpecifier type = new ImageTypeSpecifier(
                image.getColorModel(), image.getSampleModel());
                */
        /* didn't work as expected...
        ImageTypeSpecifier type = ImageTypeSpecifier.createFromBufferedImageType(
                BufferedImage.TYPE_INT_RGB);
        param.setDestinationType(type);
        param.setSourceBands(new int[] {0, 1, 2});
        */
        return param;
    }


}
