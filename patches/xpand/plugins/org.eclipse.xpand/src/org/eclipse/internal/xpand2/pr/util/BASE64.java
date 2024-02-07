/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.pr.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BASE64 {
    /**
     * Creates an <tt>OutputStream</tt> that writes base64 encoded bytes to
     * the given <tt>OutputStream</tt>.
     * 
     * It writes a line separator every 54 bytes.
     * 
     * @param out
     *            <tt>OutputStream</tt> to write to.
     * 
     * @return BASE64 encoding OutputStream
     */
    public static OutputStream createOutputStream(final OutputStream out) {
        return new BASE64OutputStream(out);
    }

    /**
     * Creates an <tt>OutputStream</tt> that writes base64 encoded bytes to
     * the given <tt>OutputStream</tt>
     * 
     * @param out
     *            <tt>OutputStream</tt> to write to.
     * @param linebreak
     *            iff true write a line separator every 54 bytes.
     * 
     * @return BASE64 encoding OutputStream
     */
    public static OutputStream createOutputStream(final OutputStream out, final boolean linebreak) {
        return new BASE64OutputStream(out, linebreak);
    }

    public static String toString(final String raw) throws IOException {
        return toString(raw.getBytes());
    }

    public static String toString(final byte[] raw) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final OutputStream os = new BASE64OutputStream(bos, false);
        final InputStream is = new ByteArrayInputStream(raw);

        int c = 0;
        while ((c = is.read()) != -1) {
            os.write(c);
        }
        is.close();
        os.close();

        return new String(bos.toByteArray());
    }

    public static byte[] toByteArray(final String b64) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final InputStream is = new BASE64InputStream(new ByteArrayInputStream(b64.getBytes()));

        int c = 0;
        while ((c = is.read()) != -1) {
            bos.write(c);
        }

        is.close();
        bos.close();

        return bos.toByteArray();
    }

    private static class BASE64OutputStream extends FilterOutputStream {
        public BASE64OutputStream(final OutputStream out) {
            this(out, true);
        }

        public BASE64OutputStream(final OutputStream out, final boolean linebreak) {
            super(out);
            this.linebreak = linebreak;
        }

        // Close the stream.
        @Override
        public void close() throws IOException {
            // write padding and buffered bytes
            // System.out.println("CLOSE: "+Integer.toString(stack,2));
            switch (pos % 3) {
            case 0:
                break;

            case 1:
                out.write(base64[(stack >> 18) & 0x3F]); // 18-23
                out.write(base64[(stack >> 12) & 0x3F]); // 12-17
                out.write(padding);
                out.write(padding);
                break;
            case 2:
                out.write(base64[(stack >> 18) & 0x3F]); // 18-23
                out.write(base64[(stack >> 12) & 0x3F]); // 12-17
                out.write(base64[(stack >> 6) & 0x3F]); // 6-11
                out.write(padding);

                break;
            }
            stack = 0;
            pos = 0;

            super.close();
        }

        private int pos = 0;

        private int stack = 0;

        private boolean linebreak = false;

        // Writes the specified byte to this output stream.
        @Override
        public void write(final int c) throws IOException {
            // DEBUG System.out.println("WRITEB64: "+c+"
            // ("+pos+","+Integer.toString(c,2)+","+(byte) c+")");
            switch (pos % 3) {
            case 0:
                // 0-7
                stack |= (c << 16) & 0xFF0000;
                // DEBUG System.out.println("WRITEB64 STACK: "+stack);
                break;
            case 1:
                // 8-15
                stack |= (c << 8) & 0x00FF00;
                // DEBUG System.out.println("WRITEB64 STACK: "+stack);
                break;
            case 2:
                // 16-23
                stack |= (c << 0) & 0x0000FF;

                // DEBUG System.out.println("WRITEB64 STACK: "+stack+
                // "("+Integer.toString(stack,2)+")");
                // DEBUG System.out.println("WRITEB64: WRITING!");
                // write
                out.write(base64[(stack >> 18) & 0x3F]); // 18-23
                out.write(base64[(stack >> 12) & 0x3F]); // 12-17
                out.write(base64[(stack >> 6) & 0x3F]); // 6-11
                out.write(base64[(stack >> 0) & 0x3F]); // 0-5
                // reset stack after writing
                stack = 0;
                break;
            }

            // don't let pos increase to much. In fact we only need to know
            // if we have just written a chunk of 54 original bytes for line
            // breaking
            pos = (pos + 1) % 54;

            if (linebreak && pos == 0) {
                out.write(System.getProperty("line.separator").getBytes());
            }

        }

    }

    private static final int[] base64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '+', '/' };

    private static final int padding = '=';

    private static final int[] bin64 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1,
            -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 64, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

    private static class BASE64InputStream extends InputStream {
        public BASE64InputStream(final InputStream in) {
            this.in = in;
        }

        private InputStream in;

        // pos is the current position (mod 3)
        private int pos = 0;

        // keeps 3 current bytes and returns it on read()
        private int stack = 0;

        private int eof = -1;

        private int readAndSkipNonBase64() throws IOException {
            int c;
            while ((c = in.read()) != -1) {
                if (bin64[c] != -1)
                    return c;
            }
            return c;
        }

        // Reads the next byte of data from this input stream.
        // TODO: think about abort condition (eof != -1)
        @Override
        public int read() throws IOException {
            // System.out.println("READ
            // (eof="+eof+",pos="+pos+",stack="+Integer.toString(stack,2)+")");
            if (eof == -1 && pos == 0) {
                // read new chunk
                stack = 0;

                int count = 0;
                int c = 0;
                while (count != 4 && (c = readAndSkipNonBase64()) != -1) {
                    if (c == padding) {
                        if (eof == -1) {
                            eof = count;
                        }
                        count++;
                        continue;
                    }
                    if (bin64[c] != -1) {
                        stack |= (bin64[c] & 0x3F) << (18 - count * 6);
                        count++;
                    }
                }
                // System.out.println("READ AFTER CHUNK
                // (eof="+eof+",pos="+pos+",stack="+Integer.toString(stack,2)+","+count+")");
                if (count == 0) {
                    eof = 0;
                } else {
                    if (count != 4)
                        throw new IOException("Invalid base64 data. Found chunk of size " + count);
                }
            }
            if (eof == 0)
                return -1;
            if (eof == 1)
                return -1;
            if (eof == 2 && pos > 0)
                return -1;
            if (eof == 3 && pos > 1)
                return -1;
            // return pos'th byte from stack
            final int ret = (stack >> (16 - pos * 8)) & 0xFF;
            pos = (pos + 1) % 3;
            return ret;
        }

        // Closes this input stream and releases any system resources
        @Override
        public void close() throws IOException {
            in.close();
        }
    }

}
