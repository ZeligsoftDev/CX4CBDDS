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

/* $Id: MimeEnabledImageFlavor.java 1731775 2016-02-23 01:13:36Z gadams $ */

package org.apache.xmlgraphics.image.loader;

/**
 * Special image flavor subclass which enables the restriction to a particular MIME type.
 */
public class MimeEnabledImageFlavor extends RefinedImageFlavor {

    private String mime;

    /**
     * Constructs a new image flavor.
     * @param parentFlavor the parent image flavor
     * @param mime a MIME type refining the parent image flavor
     */
    public MimeEnabledImageFlavor(ImageFlavor parentFlavor, String mime) {
        super(mime + ";" + parentFlavor.getName(), parentFlavor);
        this.mime = mime;
    }

    /** {@inheritDoc} */
    public String getMimeType() {
        return this.mime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MimeEnabledImageFlavor that = (MimeEnabledImageFlavor) o;

        if (mime != null ? !mime.equals(that.mime) : that.mime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mime != null ? mime.hashCode() : 0);
        return result;
    }
}
