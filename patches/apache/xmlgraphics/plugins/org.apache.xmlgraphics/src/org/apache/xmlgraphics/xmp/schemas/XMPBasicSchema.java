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

/* $Id: XMPBasicSchema.java 892977 2009-12-21 21:08:42Z jeremias $ */

package org.apache.xmlgraphics.xmp.schemas;

import org.apache.xmlgraphics.util.QName;
import org.apache.xmlgraphics.xmp.Metadata;
import org.apache.xmlgraphics.xmp.XMPConstants;
import org.apache.xmlgraphics.xmp.XMPSchema;
import org.apache.xmlgraphics.xmp.merge.MergeRuleSet;
import org.apache.xmlgraphics.xmp.merge.NoReplacePropertyMerger;

/**
 * XMP schema for XMP Basic.
 */
public class XMPBasicSchema extends XMPSchema {

    /** Namespace URI for XMP Basic */
    public static final String NAMESPACE = XMPConstants.XMP_BASIC_NAMESPACE;

    /** Preferred prefix for XMP Basic */
    public static final String PREFERRED_PREFIX = "xmp";

    /** Namespace URI for the qualifier for xmp:Identifier */
    public static final String QUALIFIER_NAMESPACE = "http://ns.adobe.com/xmp/Identifier/qual/1.0/";

    /** The qualified name for the qualifier for xmp:Identifier */
    public static final QName SCHEME_QUALIFIER = new QName(QUALIFIER_NAMESPACE, "xmpidq:Scheme");

    private static MergeRuleSet mergeRuleSet = new MergeRuleSet();

    /** Creates a new schema instance for Dublin Core. */
    public XMPBasicSchema() {
        super(NAMESPACE, PREFERRED_PREFIX);
    }

    static {
        //CreateDate shall be preserved if it exists
        mergeRuleSet.addRule(new QName(NAMESPACE, "CreateDate"), new NoReplacePropertyMerger());
    }

    /**
     * Creates and returns an adapter for this schema around the given metadata object.
     * @param meta the metadata object
     * @return the newly instantiated adapter
     */
    public static XMPBasicAdapter getAdapter(Metadata meta) {
        return new XMPBasicAdapter(meta, NAMESPACE);
    }

    /** @see org.apache.xmlgraphics.xmp.XMPSchema#getDefaultMergeRuleSet() */
    public MergeRuleSet getDefaultMergeRuleSet() {
        return mergeRuleSet;
    }

}
