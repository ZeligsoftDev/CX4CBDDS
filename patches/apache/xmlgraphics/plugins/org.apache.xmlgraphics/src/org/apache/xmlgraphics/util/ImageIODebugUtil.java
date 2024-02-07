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

/* $Id: ImageIODebugUtil.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.util;

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

import org.w3c.dom.Node;

/**
 * Helper class for debugging stuff in Image I/O.
 *
 * @version $Id: ImageIODebugUtil.java 1732018 2016-02-24 04:51:06Z gadams $
 */
public final class ImageIODebugUtil {

    private ImageIODebugUtil() {
    }

    public static void dumpMetadata(IIOMetadata meta, boolean nativeFormat) {
        String format;
        if (nativeFormat) {
            format = meta.getNativeMetadataFormatName();
        } else {
            format = IIOMetadataFormatImpl.standardMetadataFormatName;
        }
        Node node = meta.getAsTree(format);
        dumpNode(node);
    }

    public static void dumpNode(Node node) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            Source src = new DOMSource(node);
            Result res = new StreamResult(System.out);
            t.transform(src, res);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
