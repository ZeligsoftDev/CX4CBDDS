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

/* $Id: FlateEncodeOutputStream.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.util.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This class applies a FlateEncode filter to the stream. It is basically the
 * normal DeflaterOutputStream except now also implementing the Finalizable
 * interface.
 *
 * @version $Id: FlateEncodeOutputStream.java 1732018 2016-02-24 04:51:06Z gadams $
 */
public class FlateEncodeOutputStream extends java.util.zip.DeflaterOutputStream
            implements Finalizable {

    /** @see java.util.zip.DeflaterOutputStream **/
    public FlateEncodeOutputStream(OutputStream out) {
        super(out);
    }

    /** @see Finalizable **/
    public void finalizeStream() throws IOException {
        finish();
        flush();

        // ensure that Deflater resources are released
        def.end();

        if (out instanceof Finalizable) {
            ((Finalizable)out).finalizeStream();
        }
    }

}


