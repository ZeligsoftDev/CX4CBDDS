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

/* $Id: ImageUtil.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.image.loader.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.imageio.stream.ImageInputStream;
import javax.xml.transform.Source;

import org.apache.xmlgraphics.image.loader.ImageProcessingHints;
import org.apache.xmlgraphics.image.loader.ImageSessionContext;
import org.apache.xmlgraphics.image.loader.ImageSource;
import org.apache.xmlgraphics.io.XmlSourceUtil;

/**
 * Helper and convenience methods for working with the image package.
 */
public final class ImageUtil {

    private ImageUtil() {
    }

    /**
     * Returns the InputStream of a Source object.
     * @param src the Source object
     * @return the InputStream (or null if there's not InputStream available)
     * @deprecated Please use {@link XmlSourceUtil#getInputStream(Source)} instead.
     */
    @Deprecated
    public static InputStream getInputStream(Source src) {
        return XmlSourceUtil.getInputStream(src);
    }

    /**
     * Returns the ImageInputStream of a Source object.
     * @param src the Source object
     * @return the ImageInputStream (or null if there's not ImageInputStream available)
     */
    public static ImageInputStream getImageInputStream(Source src) {
        if (src instanceof ImageSource) {
            return ((ImageSource) src).getImageInputStream();
        } else {
            return null;
        }
    }

    /**
     * Returns the InputStream of a Source object. This method throws an IllegalArgumentException
     * if there's no InputStream instance available from the Source object.
     * @param src the Source object
     * @return the InputStream
     * @deprecated use {@link XmlSourceUtil#needInputStream(Source)} instead
     */
    @Deprecated
    public static InputStream needInputStream(Source src) {
        return XmlSourceUtil.needInputStream(src);
    }

    /**
     * Returns the ImageInputStream of a Source object. This method throws an
     * IllegalArgumentException if there's no ImageInputStream instance available from the
     * Source object.
     * @param src the Source object
     * @return the ImageInputStream
     */
    public static ImageInputStream needImageInputStream(Source src) {
        if (src instanceof ImageSource) {
            ImageSource isrc = (ImageSource) src;
            if (isrc.getImageInputStream() == null) {
                throw new IllegalArgumentException(
                        "ImageInputStream is null/cleared on ImageSource");
            }
            return isrc.getImageInputStream();
        } else {
            throw new IllegalArgumentException("Source must be an ImageSource");
        }
    }

    /**
     * Indicates whether the Source object has an InputStream instance.
     * @param src the Source object
     * @return true if an InputStream is available
     */
    public static boolean hasInputStream(Source src) {
        return XmlSourceUtil.hasInputStream(src) || hasImageInputStream(src);
    }

    /**
     * Indicates whether the Source object has a Reader instance.
     * @param src the Source object
     * @return true if an Reader is available
     * @deprecated use {@link XmlSourceUtil#hasReader(Source)} instead
     */
    @Deprecated
    public static boolean hasReader(Source src) {
        return XmlSourceUtil.hasReader(src);
    }

    /**
     * Indicates whether the Source object has an ImageInputStream instance.
     * @param src the Source object
     * @return true if an ImageInputStream is available
     */
    public static boolean hasImageInputStream(Source src) {
        return getImageInputStream(src) != null;
    }

    /**
     * Removes any references to InputStreams or Readers from the given Source to prohibit
     * accidental/unwanted use by a component further downstream.
     * @param src the Source object
     * @deprecated use {@link XmlSourceUtil#removeStreams(Source)} instead
     */
    @Deprecated
    public static void removeStreams(Source src) {
        XmlSourceUtil.removeStreams(src);
    }

    /**
     * Closes the InputStreams or ImageInputStreams of Source objects. Any exception occurring
     * while closing the stream is ignored.
     * @param src the Source object
     * @deprecated use {@link XmlSourceUtil#closeQuietly(Source)} instead
     */
    @Deprecated
    public static void closeQuietly(Source src) {
        XmlSourceUtil.closeQuietly(src);
    }

    /**
     * Decorates an ImageInputStream so the flush*() methods are ignored and have no effect.
     * The decoration is implemented using a dynamic proxy.
     * @param in the ImageInputStream
     * @return the decorated ImageInputStream
     */
    public static ImageInputStream ignoreFlushing(final ImageInputStream in) {
        return (ImageInputStream) Proxy.newProxyInstance(in.getClass().getClassLoader(),
                new Class[] {ImageInputStream.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        String methodName = method.getName();
                        //Ignore calls to flush*()
                        if (!methodName.startsWith("flush")) {
                            try {
                                return method.invoke(in, args);
                            } catch (InvocationTargetException ite) {
                                throw ite.getCause();
                            }
                        } else {
                            return null;
                        }
                    }
                });
    }

    /**
     * GZIP header magic number bytes, like found in a gzipped
     * files, which are encoded in Intel format (i.&#x2e;e&#x2e; little indian).
     */
    private static final byte[] GZIP_MAGIC = {(byte) 0x1f, (byte) 0x8b};

    /**
     * Indicates whether an InputStream is GZIP compressed. The InputStream must support
     * mark()/reset().
     * @param in the InputStream (must return true on markSupported())
     * @return true if the InputStream is GZIP compressed
     * @throws IOException in case of an I/O error
     */
    public static boolean isGZIPCompressed(InputStream in) throws IOException {
        if (!in.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark()!");
        }
        byte[] data = new byte[2];
        in.mark(2);
        in.read(data);
        in.reset();
        return ((data[0] == GZIP_MAGIC[0]) && (data[1] == GZIP_MAGIC[1]));
    }

    /**
     * Decorates an InputStream with a BufferedInputStream if it doesn't support mark()/reset().
     * @param in the InputStream
     * @return the decorated InputStream
     */
    public static InputStream decorateMarkSupported(InputStream in) {
        if (in.markSupported()) {
            return in;
        } else {
            return new java.io.BufferedInputStream(in);
        }
    }

    /**
     * Automatically decorates an InputStream so it is buffered. Furthermore, it makes sure
     * it is decorated with a GZIPInputStream if the stream is GZIP compressed.
     * @param in the InputStream
     * @return the decorated InputStream
     * @throws IOException in case of an I/O error
     */
    public static InputStream autoDecorateInputStream(InputStream in) throws IOException {
        in = decorateMarkSupported(in);
        if (isGZIPCompressed(in)) {
            return new GZIPInputStream(in);
        }
        return in;
    }

    /**
     * Creates a new hint Map with values from the FOUserAgent.
     * @param session the session context
     * @return a Map of hints
     */
    public static Map getDefaultHints(ImageSessionContext session) {
        java.util.Map hints = new java.util.HashMap();
        hints.put(ImageProcessingHints.SOURCE_RESOLUTION,
                session.getParentContext().getSourceResolution());
        hints.put(ImageProcessingHints.TARGET_RESOLUTION,
                session.getTargetResolution());
        hints.put(ImageProcessingHints.IMAGE_SESSION_CONTEXT, session);
        return hints;
    }

    private static final String PAGE_INDICATOR = "page=";

    /**
     * Extracts page index information from a URI. The expected pattern is "page=x" where x is
     * a non-negative integer number. The page index must be specified as part of the URI fragment
     * and is 1-based, i.e. the first page is 1 but the the method returns a zero-based page
     * index.
     * An example: <code>http://www.foo.bar/images/scan1.tif#page=4</code> (The method will return
     * 3.)
     * <p>
     * If no page index information is found in the URI or if the URI cannot be parsed, the
     * method returns null.
     * @param uri the URI that should be inspected
     * @return the page index (0 is the first page) or null if there's no page index information
     *         in the URI
     */
    public static Integer getPageIndexFromURI(String uri) {
        if (uri.indexOf('#') < 0) {
            return null;
        }
        try {
            URI u = new URI(uri);
            String fragment = u.getFragment();
            if (fragment != null) {
                int pos = fragment.indexOf(PAGE_INDICATOR);
                if (pos >= 0) {
                    pos += PAGE_INDICATOR.length();
                    StringBuffer sb = new StringBuffer();
                    while (pos < fragment.length()) {
                        char c = fragment.charAt(pos);
                        if (c >= '0' && c <= '9') {
                            sb.append(c);
                        } else {
                            break;
                        }
                        pos++;
                    }
                    if (sb.length() > 0) {
                        int pageIndex = Integer.parseInt(sb.toString()) - 1;
                        pageIndex = Math.max(0, pageIndex);
                        return pageIndex;
                    }
                }
            }
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("URI is invalid: "
                    + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Extracts page index information from a URI. The expected pattern is "page=x" where x is
     * a non-negative integer number. The page index must be specified as part of the URI fragment
     * and is 1-based, i.e. the first page is 1 but the the method returns a zero-based page
     * index.
     * An example: <code>http://www.foo.bar/images/scan1.tif#page=4</code> (The method will return
     * 3.)
     * <p>
     * If no page index information is found in the URI, the
     * method just returns 0 which indicates the first page.
     * @param uri the URI that should be inspected
     * @return the page index (0 is the first page)
     */
    public static int needPageIndexFromURI(String uri) {
        Integer res = getPageIndexFromURI(uri);
        if (res != null) {
            return res;
        } else {
            return 0;
        }
    }

}
