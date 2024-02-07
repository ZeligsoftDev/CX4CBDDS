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

/* $Id: EPSDocumentGraphics2D.java 1732018 2016-02-24 04:51:06Z gadams $ */

package org.apache.xmlgraphics.java2d.ps;

import java.io.IOException;

import org.apache.xmlgraphics.ps.DSCConstants;

/**
 * This class is a wrapper for the <tt>AbstractPSDocumentGraphics2D</tt> that
 * is used to create EPS (Encapsulated PostScript) files instead of PS file.
 *
 * @version $Id: EPSDocumentGraphics2D.java 1732018 2016-02-24 04:51:06Z gadams $
 * @see org.apache.xmlgraphics.java2d.ps.PSGraphics2D
 * @see org.apache.xmlgraphics.java2d.ps.AbstractPSDocumentGraphics2D
 */
public class EPSDocumentGraphics2D extends AbstractPSDocumentGraphics2D {

    /**
     * Create a new EPSDocumentGraphics2D.
     * This is used to create a new EPS document, the height,
     * width and output stream can be setup later.
     * For use by the transcoder which needs font information
     * for the bridge before the document size is known.
     * The resulting document is written to the stream after rendering.
     *
     * @param textAsShapes set this to true so that text will be rendered
     * using curves and not the font.
     */
    public EPSDocumentGraphics2D(boolean textAsShapes) {
        super(textAsShapes);
    }

    /** {@inheritDoc} */
    protected void writeFileHeader() throws IOException {
        final Long pagewidth = (long) this.width;
        final Long pageheight = (long) this.height;

        //PostScript Header
        gen.writeln(DSCConstants.PS_ADOBE_30 + " " + DSCConstants.EPSF_30);
        gen.writeDSCComment(DSCConstants.CREATOR,
                    new String[] {"Apache XML Graphics Commons"
                        + ": EPS Generator for Java2D"});
        gen.writeDSCComment(DSCConstants.CREATION_DATE,
                    new Object[] {new java.util.Date()});
        gen.writeDSCComment(DSCConstants.PAGES, DSCConstants.ATEND);
        gen.writeDSCComment(DSCConstants.BBOX, new Object[]
                {ZERO, ZERO, pagewidth, pageheight});
        gen.writeDSCComment(DSCConstants.LANGUAGE_LEVEL, gen.getPSLevel());
        gen.writeDSCComment(DSCConstants.END_COMMENTS);

        //Prolog
        gen.writeDSCComment(DSCConstants.BEGIN_PROLOG);
        writeProcSets();
        if (customTextHandler instanceof PSTextHandler) {
            ((PSTextHandler)customTextHandler).writeSetup();
        }
        gen.writeDSCComment(DSCConstants.END_PROLOG);
    }

    /** {@inheritDoc} */
    protected void writePageHeader() throws IOException {
        Integer pageNumber = this.pagecount;
        gen.writeDSCComment(DSCConstants.PAGE, new Object[]
                {pageNumber.toString(), pageNumber});
        gen.writeDSCComment(DSCConstants.PAGE_BBOX, new Object[]
                {ZERO, ZERO, width, height});
        gen.writeDSCComment(DSCConstants.BEGIN_PAGE_SETUP);
        if (customTextHandler instanceof PSTextHandler) {
            ((PSTextHandler)customTextHandler).writePageSetup();
        }
    }

    /** {@inheritDoc} */
    protected void writePageTrailer() throws IOException {
        //nop, no DSC PageTrailer needed
    }

}
