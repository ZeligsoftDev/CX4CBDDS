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

/* $Id: SoftReferenceWithKey.java 1345683 2012-06-03 14:50:33Z gadams $ */

package org.apache.xmlgraphics.image.loader.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Special SoftReference subclass that holds an additional key object that can be used to remove
 * a reference from a Map once the referenced object is collected, for example.
 */
public class SoftReferenceWithKey extends SoftReference {

    private Object key;

    /**
     * Creates a new SoftReference with a key.
     * @param referent object the new soft reference will refer to
     * @param key the key object
     * @param q queue the soft reference is registered with
     */
    public SoftReferenceWithKey(Object referent, Object key, ReferenceQueue q) {
        super(referent, q);
        this.key = key;
    }

    /**
     * Returns the key associated with this reference.
     * @return the key
     */
    public Object getKey() {
        return this.key;
    }

}
