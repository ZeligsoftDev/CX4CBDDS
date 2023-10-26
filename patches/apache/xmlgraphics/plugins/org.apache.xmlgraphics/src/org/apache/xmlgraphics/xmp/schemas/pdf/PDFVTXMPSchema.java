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

/* $Id: PDFVTXMPSchema.java 1732018 2016-02-24 04:51:06Z gadams $ */
package org.apache.xmlgraphics.xmp.schemas.pdf;

import org.apache.xmlgraphics.xmp.Metadata;
import org.apache.xmlgraphics.xmp.XMPConstants;
import org.apache.xmlgraphics.xmp.XMPSchema;

public class PDFVTXMPSchema extends XMPSchema {
    public static final String NAMESPACE = XMPConstants.PDF_VT_IDENTIFICATION;

    /** Creates a new schema instance for Dublin Core. */
    public PDFVTXMPSchema() {
        super(NAMESPACE, "pdfvtid");
    }

    /**
     * Creates and returns an adapter for this schema around the given metadata object.
     * @param meta the metadata object
     * @return the newly instantiated adapter
     */
    public static PDFVTAdapter getAdapter(Metadata meta) {
        return new PDFVTAdapter(meta, NAMESPACE);
    }
}
