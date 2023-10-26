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

/* $Id: ReplacePropertyMerger.java 426584 2006-07-28 16:01:47Z jeremias $ */

package org.apache.xmlgraphics.xmp.merge;

import org.apache.xmlgraphics.xmp.Metadata;
import org.apache.xmlgraphics.xmp.XMPProperty;

/**
 * The most basic PropertyMerger which simply overwrites any existing value in the target metadata.
 */
public class ReplacePropertyMerger implements PropertyMerger {

    /**
     * @see org.apache.xmlgraphics.xmp.merge.PropertyMerger#merge(
     *          org.apache.xmlgraphics.xmp.XMPProperty, org.apache.xmlgraphics.xmp.Metadata)
     */
    public void merge(XMPProperty sourceProp, Metadata target) {
        target.setProperty(sourceProp);
    }

}
