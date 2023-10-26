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

/* $Id: ImageIOUtil.java 1804124 2017-08-04 14:13:54Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.impl.imageio;

import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.apache.xmlgraphics.image.loader.ImageSize;
import org.apache.xmlgraphics.util.UnitConv;

/**
 * Helper and convenience methods for ImageIO.
 */
public final class ImageIOUtil {

    private ImageIOUtil() {
    }

    /** Key for ImageInfo's custom objects to embed the ImageIO metadata */
    public static final Object IMAGEIO_METADATA = IIOMetadata.class;

    /**
     * Extracts the resolution information from the standard ImageIO metadata.
     * @param iiometa the metadata provided by ImageIO
     * @param size the image size object
     */
    public static void extractResolution(IIOMetadata iiometa, ImageSize size) {
        if (iiometa != null && iiometa.isStandardMetadataFormatSupported()) {
            Element metanode = (Element)iiometa.getAsTree(
                    IIOMetadataFormatImpl.standardMetadataFormatName);
            Element dim = getChild(metanode, "Dimension");
            if (dim != null) {
                Element child;
                double dpiHorz = size.getDpiHorizontal();
                double dpiVert = size.getDpiVertical();
                child = getChild(dim, "HorizontalPixelSize");
                if (child != null) {
                    float value = Float.parseFloat(child.getAttribute("value"));
                    if (value != 0 && !Float.isInfinite(value)) {
                        dpiHorz = UnitConv.IN2MM / value;
                    }
                }
                child = getChild(dim, "VerticalPixelSize");
                if (child != null) {
                    float value = Float.parseFloat(child.getAttribute("value"));
                    if (value != 0 && !Float.isInfinite(value)) {
                        dpiVert = UnitConv.IN2MM / value;
                    }
                }
                size.setResolution(dpiHorz, dpiVert);
                size.calcSizeFromPixels();
            }
        }
    }

    /**
     * Returns a child element of another element or null if there's no such child.
     * @param el the parent element
     * @param name the name of the requested child
     * @return the child or null if there's no such child
     */
    public static Element getChild(Element el, String name) {
        NodeList nodes = el.getElementsByTagName(name);
        if (nodes.getLength() > 0) {
            return (Element)nodes.item(0);
        } else {
            return null;
        }
    }

    /**
     * Dumps the content of an IIOMetadata instance to System.out.
     * @param iiometa the metadata
     */
    public static void dumpMetadataToSystemOut(IIOMetadata iiometa) {
        String[] metanames = iiometa.getMetadataFormatNames();
        for (String metaname : metanames) {
            System.out.println("--->" + metaname);
            dumpNodeToSystemOut(iiometa.getAsTree(metaname));
        }
    }

    /**
     * Serializes a W3C DOM node to a String and dumps it to System.out.
     * @param node a W3C DOM node
     */
    private static void dumpNodeToSystemOut(Node node) {
        Transformer trans = null;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            Source src = new DOMSource(node);
            Result res = new StreamResult(System.out);
            trans.transform(src, res);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
