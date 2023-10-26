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

/* $Id: ImageXMLDOM.java 682720 2008-08-05 14:22:29Z jeremias $ */

package org.apache.xmlgraphics.image.loader.impl;

import org.w3c.dom.Document;

import org.apache.xmlgraphics.image.loader.ImageFlavor;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.XMLNamespaceEnabledImageFlavor;

/**
 * This class is an implementation of the Image interface exposing an XML DOM (W3C).
 */
public class ImageXMLDOM extends AbstractImage {

    private ImageFlavor flavor;
    private Document doc;
    private String rootNamespace;

    /**
     * Main constructor.
     * @param info the image info object
     * @param doc the W3C DOM document
     * @param rootNamespace the root XML namespace of the XML document in the DOM
     */
    public ImageXMLDOM(ImageInfo info, Document doc, String rootNamespace) {
        super(info);
        this.doc = doc;
        this.rootNamespace = rootNamespace;
        this.flavor = new XMLNamespaceEnabledImageFlavor(ImageFlavor.XML_DOM, rootNamespace);
    }

    /**
     * Main constructor.
     * @param info the image info object
     * @param doc the W3C DOM document
     * @param flavor the image flavor
     */
    public ImageXMLDOM(ImageInfo info, Document doc, XMLNamespaceEnabledImageFlavor flavor) {
        super(info);
        this.doc = doc;
        this.rootNamespace = flavor.getNamespace();
        this.flavor = flavor;
    }

    /** {@inheritDoc} */
    public ImageFlavor getFlavor() {
        return this.flavor;
    }

    /** {@inheritDoc} */
    public boolean isCacheable() {
        return true;
    }

    /**
     * Returns the contained W3C DOM document.
     * @return the DOM
     */
    public Document getDocument() {
        return this.doc;
    }

    /**
     * Returns the root XML namespace of the XML document.
     * @return the root namespace
     */
    public String getRootNamespace() {
        return this.rootNamespace;
    }

}
