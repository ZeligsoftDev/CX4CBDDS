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

/* $Id: TempResourceResolver.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Implementations of this interface resolve URIs for temporary files used by XGC. The temporary-
 * resource URI scheme comes from {@link TempResourceURIGenerator#TMP_SCHEME}.
 */
public interface TempResourceResolver {

    /**
     * Get a temporary-resource given the identifier pointing to said resource.
     *
     * @param id the resource identifier
     * @return the resource
     * @throws IOException if an I/O error occured during resource acquisition
     */
    Resource getResource(String id) throws IOException;

    /**
     * Gets an temporary-output stream of a given identifier.
     *
     * @param id the output stream identifier
     * @return the output stream
     * @throws IOException if an I/O error occured while creating an output stream
     */
    OutputStream getOutputStream(String id) throws IOException;
}
