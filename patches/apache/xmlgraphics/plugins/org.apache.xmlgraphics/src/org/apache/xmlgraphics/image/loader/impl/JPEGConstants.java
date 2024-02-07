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

/* $Id: JPEGConstants.java 750418 2009-03-05 11:03:54Z vhennebert $ */

package org.apache.xmlgraphics.image.loader.impl;

/**
 * Constants for JPEG images
 */
public interface JPEGConstants {

    /*
     * Only SOFn and APPn markers are defined as SOFn is needed for the height
     * and width search. APPn is also defined because if the JPEG contains
     * thumbnails the dimensions of the thumbnail would also be after the SOFn
     * marker enclosed inside the APPn marker. And we don't want to confuse
     * those dimensions with the image dimensions.
     */
    /** Beginning of a Marker */
    int MARK = 0xff;
    /** Special case for 0xff00 */
    int NULL = 0x00;
    /** Baseline DCT */
    int SOF0 = 0xc0;
    /** Extended Sequential DCT */
    int SOF1 = 0xc1;
    /** Progressive DCT only PDF 1.3 */
    int SOF2 = 0xc2;
    /** Progressive DCT only PDF 1.3 */
    int SOFA = 0xca;

    /** Application marker, JFIF, JFXX, CIFF */
    int APP0 = 0xe0;
    /** Application marker, EXIF, XMP */
    int APP1 = 0xe1;
    /** Application marker, ICC, FlashPix */
    int APP2 = 0xe2;
    /** Application marker APPD/APP13, Photoshop, Adobe_CM */
    int APPD = 0xed;
    /** Application marker APPE/APP14, Adobe */
    int APPE = 0xee;
    /** Application marker APPF/APP15, GraphicConverter */
    int APPF = 0xef;

    /** Start of Scan */
    int SOS = 0xda;
    /** start of Image */
    int SOI = 0xd8;
    /** end of Image */
    int EOI = 0xd9;

}
