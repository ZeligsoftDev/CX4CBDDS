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

/* $Id: XMPComplexValue.java 750418 2009-03-05 11:03:54Z vhennebert $ */

package org.apache.xmlgraphics.xmp;

import org.apache.xmlgraphics.util.XMLizable;

/**
 * Base class for complex data types in XMP.
 */
public abstract class XMPComplexValue implements XMLizable {

    /**
     * Returns a normal Java object representing the value if it is available.
     * @return a simple object value or null if no such value can be returned (for example,
     *          because the value is an array and has multiple entries.
     */
    public abstract Object getSimpleValue();

}
