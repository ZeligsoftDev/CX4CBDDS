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

/* $Id: ArrayAddPropertyMerger.java 892977 2009-12-21 21:08:42Z jeremias $ */

package org.apache.xmlgraphics.xmp.merge;

import org.apache.xmlgraphics.xmp.Metadata;
import org.apache.xmlgraphics.xmp.XMPArray;
import org.apache.xmlgraphics.xmp.XMPArrayType;
import org.apache.xmlgraphics.xmp.XMPProperty;

/**
 * Merges properties by adding up all items from both ends into one SEQ array.
 */
public class ArrayAddPropertyMerger implements PropertyMerger {

    /**
     * @see org.apache.xmlgraphics.xmp.merge.PropertyMerger#merge(
     *          org.apache.xmlgraphics.xmp.XMPProperty, org.apache.xmlgraphics.xmp.Metadata)
     */
    public void merge(XMPProperty sourceProp, Metadata target) {
        XMPProperty existing = target.getProperty(sourceProp.getName());
        if (existing == null) {
            //simply copy over
            target.setProperty(sourceProp);
        } else {
            XMPArray array = existing.convertSimpleValueToArray(XMPArrayType.SEQ);
            XMPArray otherArray = sourceProp.getArrayValue();
            if (otherArray == null) {
                if (sourceProp.getXMLLang() != null) {
                    array.add(sourceProp.getValue().toString(), sourceProp.getXMLLang());
                } else {
                    array.add(sourceProp.getValue());
                }
            } else {
                //TODO should be refined (xml:lang etc.)
                for (int i = 0, c = otherArray.getSize(); i < c; i++) {
                    array.add(otherArray.getValue(i));
                }
            }
        }
    }

}
