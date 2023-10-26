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

/* $Id: PostScriptComment.java 1681108 2015-05-22 13:26:12Z ssteiner $ */

package org.apache.xmlgraphics.ps.dsc.events;

import java.io.IOException;

import org.apache.xmlgraphics.ps.PSGenerator;

/**
 * Represents a PostScript comment
 */
public class PostScriptComment extends AbstractEvent {

    private String comment;

    /**
     * Creates a new instance.
     * @param comment the comment
     */
    public PostScriptComment(String comment) {
        if (comment != null && comment.startsWith("%")) {
            this.comment = comment.substring(1);
        } else {
            this.comment = comment;
        }
    }

    /**
     * Returns the comment text.
     * @return the comment (without the "%" prefix)
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @see org.apache.xmlgraphics.ps.dsc.events.DSCEvent#generate(org.apache.xmlgraphics.ps.PSGenerator)
     */
    public void generate(PSGenerator gen) throws IOException {
        gen.commentln("%" + getComment());
    }

    /**
     * @see org.apache.xmlgraphics.ps.dsc.events.DSCEvent#getEventType()
     */
    public int getEventType() {
        return COMMENT;
    }

    /**
     * @see org.apache.xmlgraphics.ps.dsc.events.AbstractEvent#isComment()
     */
    public boolean isComment() {
        return true;
    }

}
