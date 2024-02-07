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

/* $Id: ImageIOImageWriter.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.image.writer.imageio;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.event.IIOWriteWarningListener;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.apache.xmlgraphics.image.writer.ImageWriter;
import org.apache.xmlgraphics.image.writer.ImageWriterParams;
import org.apache.xmlgraphics.image.writer.MultiImageWriter;
import org.apache.xmlgraphics.image.writer.ResolutionUnit;
import org.apache.xmlgraphics.util.UnitConv;

/**
 * ImageWriter implementation that uses Image I/O to write images.
 *
 * @version $Id: ImageIOImageWriter.java 1732018 2016-02-24 04:51:06Z gadams $
 */
public class ImageIOImageWriter implements ImageWriter, IIOWriteWarningListener {

    private static final String DIMENSION = "Dimension";
    private static final String VERTICAL_PIXEL_SIZE = "VerticalPixelSize";
    private static final String HORIZONTAL_PIXEL_SIZE = "HorizontalPixelSize";

    private static final String STANDARD_METADATA_FORMAT = "javax_imageio_1.0";

    private String targetMIME;

    /**
     * Main constructor.
     * @param mime the MIME type of the image format
     */
    public ImageIOImageWriter(String mime) {
        this.targetMIME = mime;
    }

    /** {@inheritDoc} */
    public void writeImage(RenderedImage image, OutputStream out) throws IOException {
        writeImage(image, out, null);
    }

    /** {@inheritDoc} */
    public void writeImage(RenderedImage image, OutputStream out,
            ImageWriterParams params)
                throws IOException {
        javax.imageio.ImageWriter iiowriter = getIIOImageWriter();
        iiowriter.addIIOWriteWarningListener(this);

        ImageOutputStream imgout = ImageIO.createImageOutputStream(out);
        try {

            ImageWriteParam iwParam = getDefaultWriteParam(iiowriter, image, params);

            IIOMetadata streamMetadata = createStreamMetadata(iiowriter, iwParam, params);

            ImageTypeSpecifier type;
            if (iwParam.getDestinationType() != null) {
                type = iwParam.getDestinationType();
            } else {
                type = ImageTypeSpecifier.createFromRenderedImage(image);
            }

            //Handle metadata
            IIOMetadata meta = iiowriter.getDefaultImageMetadata(
                    type, iwParam);
            //meta might be null for some JAI codecs as they don't support metadata
            if (params != null && meta != null) {
                meta = updateMetadata(image, meta, params);
            }

            //Write image
            iiowriter.setOutput(imgout);
            IIOImage iioimg = new IIOImage(image, null, meta);
            iiowriter.write(streamMetadata, iioimg, iwParam);

        } finally {
            imgout.close();
            iiowriter.dispose();
        }
    }

    /**
     * Creates the stream metadata for image. By default, this method returns null which
     * causes the default stream metadata to be used. Subclasses can override this to
     * supply special stream metadata (see TIFF for an example).
     * @param writer the image write
     * @param writeParam the ImageIO write parameters
     * @param params the ImageWriter write parameters
     * @return the stream metadata (or null if no special metadata needs to be produced)
     */
    protected IIOMetadata createStreamMetadata(javax.imageio.ImageWriter writer,
            ImageWriteParam writeParam, ImageWriterParams params) {
        return null; //leave the default
    }

    private javax.imageio.ImageWriter getIIOImageWriter() {
        Iterator<javax.imageio.ImageWriter> iter = ImageIO.getImageWritersByMIMEType(getMIMEType());
        javax.imageio.ImageWriter iiowriter = null;
        if (iter.hasNext()) {
            iiowriter = iter.next();
        }
        if (iiowriter == null) {
            throw new UnsupportedOperationException("No ImageIO codec for writing "
                    + getMIMEType() + " is available!");
        }
        return iiowriter;
    }

    /**
     * Returns the default write parameters for encoding the image.
     * @param iiowriter The IIO ImageWriter that will be used
     * @param image the image to be encoded
     * @param params the parameters for this writer instance
     * @return the IIO ImageWriteParam instance
     */
    protected ImageWriteParam getDefaultWriteParam(
            javax.imageio.ImageWriter iiowriter, RenderedImage image,
            ImageWriterParams params) {
        ImageWriteParam param = iiowriter.getDefaultWriteParam();
        //System.err.println("Param: " + params);
        if ((params != null) && (params.getCompressionMethod() != null)) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionType(params.getCompressionMethod());
        }
        return param;
    }

    /**
     * Updates the metadata information based on the parameters to this writer.
     * @param image the current image being rendered
     * @param meta the metadata
     * @param params the parameters
     * @return the updated metadata
     */
    protected IIOMetadata updateMetadata(RenderedImage image, IIOMetadata meta,
                ImageWriterParams params) {
        if (meta.isStandardMetadataFormatSupported() && params.getResolution() != null) {

            //NOTE: There are several bugs in ImageIO codecs concerning resolution handling
            //http://www.tracemodeler.com/articles/aging-bugs-and-setting-dpi-with-java-image-io/

            float multiplier = (ResolutionUnit.CENTIMETER == params.getResolutionUnit()) ? 10f : UnitConv.IN2MM;
            double pixelWidthInMillimeters = multiplier / params.getXResolution().doubleValue();
            double pixelHeightInMillimeters = multiplier / params.getYResolution().doubleValue();

            //Try with the right value as per the ImageIO spec
            updatePixelSize(meta, pixelWidthInMillimeters, pixelHeightInMillimeters);

            //Check the merge result
            double checkMerged = getHorizontalPixelSize(meta);
            if (!equals(checkMerged, pixelWidthInMillimeters, 0.00001)) {
                //Merging bug in Sun/Oracle JRE encountered
                //Try compensation strategy for PNG bug:
                //http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=5106305
                double horzValue = 1 / pixelWidthInMillimeters;
                double vertValue = 1 / pixelHeightInMillimeters;
                updatePixelSize(meta, horzValue, vertValue);
            }
        }
        return meta;
    }

    private static boolean equals(double d1, double d2, double maxDelta) {
        return Math.abs(d1 - d2) <= maxDelta;
    }

    private double getHorizontalPixelSize(IIOMetadata meta) {
        double result = 0;
        IIOMetadataNode root = (IIOMetadataNode)meta.getAsTree(STANDARD_METADATA_FORMAT);
        IIOMetadataNode dim = getChildNode(root, DIMENSION);
        if (dim != null) {
            IIOMetadataNode horz = getChildNode(dim, HORIZONTAL_PIXEL_SIZE);
            if (horz != null) {
                result = Double.parseDouble(horz.getAttribute("value"));
            }
        }
        return result;
    }

    private void updatePixelSize(IIOMetadata meta, double horzValue, double vertValue) {
        IIOMetadataNode root = (IIOMetadataNode)meta.getAsTree(STANDARD_METADATA_FORMAT);
        IIOMetadataNode dim = getChildNode(root, DIMENSION);
        IIOMetadataNode child;

        child = getChildNode(dim, HORIZONTAL_PIXEL_SIZE);
        if (child == null) {
            child = new IIOMetadataNode(HORIZONTAL_PIXEL_SIZE);
            dim.appendChild(child);
        }
        child.setAttribute("value", Double.toString(horzValue));

        child = getChildNode(dim, VERTICAL_PIXEL_SIZE);
        if (child == null) {
            child = new IIOMetadataNode(VERTICAL_PIXEL_SIZE);
            dim.appendChild(child);
        }
        child.setAttribute("value", Double.toString(vertValue));
        try {
            meta.mergeTree(STANDARD_METADATA_FORMAT, root);
        } catch (IIOInvalidTreeException e) {
            throw new RuntimeException("Cannot update image metadata: "
                        + e.getMessage());
        }
    }

    /**
     * Returns a specific metadata child node
     * @param n the base node
     * @param name the name of the child
     * @return the requested child node
     */
    protected static IIOMetadataNode getChildNode(Node n, String name) {
        NodeList nodes = n.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node child = nodes.item(i);
            if (name.equals(child.getNodeName())) {
                return (IIOMetadataNode)child;
            }
        }
        return null;
    }

    /** {@inheritDoc} */
    public String getMIMEType() {
        return this.targetMIME;
    }

    /** {@inheritDoc} */
    public boolean isFunctional() {
        Iterator<javax.imageio.ImageWriter> iter = ImageIO.getImageWritersByMIMEType(getMIMEType());
        //Only return true if an IIO ImageWriter is available in the current environment
        return (iter.hasNext());
    }

    /** {@inheritDoc} */
    public void warningOccurred(javax.imageio.ImageWriter source,
            int imageIndex, String warning) {
        System.err.println("Problem while writing image using ImageI/O: "
                + warning);
    }

    /** {@inheritDoc} */
    public MultiImageWriter createMultiImageWriter(OutputStream out) throws IOException {
        return new IIOMultiImageWriter(out);
    }

    /** {@inheritDoc} */
    public boolean supportsMultiImageWriter() {
        javax.imageio.ImageWriter iiowriter = getIIOImageWriter();
        try {
            return iiowriter.canWriteSequence();
        } finally {
            iiowriter.dispose();
        }
    }

    private class IIOMultiImageWriter implements MultiImageWriter {

        private javax.imageio.ImageWriter iiowriter;
        private ImageOutputStream imageStream;
        private boolean prepared;

        public IIOMultiImageWriter(OutputStream out) throws IOException {
            this.iiowriter = getIIOImageWriter();
            if (!iiowriter.canWriteSequence()) {
                throw new UnsupportedOperationException("This ImageWriter does not support writing"
                        + " multiple images to a single image file.");
            }
            iiowriter.addIIOWriteWarningListener(ImageIOImageWriter.this);

            imageStream = ImageIO.createImageOutputStream(out);
            iiowriter.setOutput(imageStream);

        }

        public void writeImage(RenderedImage image, ImageWriterParams params) throws IOException {
            if (iiowriter == null) {
                throw new IllegalStateException("MultiImageWriter already closed!");
            }
            ImageWriteParam iwParam = getDefaultWriteParam(iiowriter, image, params);

            if (!prepared) {
                //Only prepare once
                IIOMetadata streamMetadata = createStreamMetadata(iiowriter, iwParam, params);
                iiowriter.prepareWriteSequence(streamMetadata);
                prepared = true;
            }

            ImageTypeSpecifier type;
            if (iwParam.getDestinationType() != null) {
                type = iwParam.getDestinationType();
            } else {
                type = ImageTypeSpecifier.createFromRenderedImage(image);
            }

            //Handle metadata
            IIOMetadata meta = iiowriter.getDefaultImageMetadata(
                    type, iwParam);
            //meta might be null for some JAI codecs as they don't support metadata
            if (params != null && meta != null) {
                meta = updateMetadata(image, meta, params);
            }

            //Write image
            IIOImage iioimg = new IIOImage(image, null, meta);
            iiowriter.writeToSequence(iioimg, iwParam);
        }

        public void close() throws IOException {
            imageStream.close();
            imageStream = null;
            iiowriter.dispose();
            iiowriter = null;
        }

    }

}
