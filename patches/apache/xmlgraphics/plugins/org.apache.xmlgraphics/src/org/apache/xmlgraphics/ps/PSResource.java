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

/* $Id: PSResource.java 1598621 2014-05-30 14:55:00Z ssteiner $ */

package org.apache.xmlgraphics.ps;

/**
 * Represents a PostScript resource (file, font, procset etc.).
 */
public class PSResource implements Comparable {

    /** a file resource */
    public static final String TYPE_FILE = "file";
    /** a font resource */
    public static final String TYPE_FONT = "font";
    /** a procset resource */
    public static final String TYPE_PROCSET = "procset";
    /** a procset resource */
    public static final String TYPE_PATTERN = "pattern";
    /** a procset resource */
    public static final String TYPE_FORM = "form";
    /** a procset resource */
    public static final String TYPE_ENCODING = "encoding";
    /** A CMap resource. */
    public static final String TYPE_CMAP = "cmap";
    /** A CIDFont resource. */
    public static final String TYPE_CIDFONT = "cidfont";

    private String type;
    private String name;

    /**
     * Main constructor
     * @param type type of the resource
     * @param name name of the resource
     */
    public PSResource(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /** @return the type of the resource */
    public String getType() {
        return this.type;
    }

    /** @return the name of the resource */
    public String getName() {
        return this.name;
    }

    /** @return the &lt;resource&gt; specification as defined in DSC v3.0 spec. */
    public String getResourceSpecification() {
        StringBuffer sb = new StringBuffer();
        sb.append(getType()).append(" ").append(PSGenerator.convertStringToDSC(getName()));
        return sb.toString();
    }

    /** {@inheritDoc} */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof PSResource) {
            PSResource other = (PSResource)obj;
            return other.toString().equals(toString());
        } else {
            return false;
        }
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return toString().hashCode();
    }

    /** {@inheritDoc} */
    public int compareTo(Object o) {
        PSResource other = (PSResource)o;
        if (this == other) {
            return 0;
        }
        int result = this.getType().compareTo(other.getType());
        if (result == 0) {
            result = this.getName().compareTo(other.getName());
        }
        return result;
    }

    /** {@inheritDoc} */
    public String toString() {
        return getResourceSpecification();
    }

}
