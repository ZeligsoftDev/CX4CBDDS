/*
 * Copyright 2014 Attila Szegedi, Daniel Dekany, Jonathan Revusky
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package freemarker.core;

import java.io.IOException;
import java.util.ArrayList;

import freemarker.template.TemplateException;

/**
 * Container for a group of related #if, #elseif and #else elements.
 * Each such block is a nested {@link ConditionalBlock}. Note that if an #if has no #else of #elseif,
 * {@link ConditionalBlock} doesn't need this parent element. 
 */
final class IfBlock extends TemplateElement {

    IfBlock(ConditionalBlock block)
    {
        nestedElements = new ArrayList();
        addBlock(block);
    }

    void addBlock(ConditionalBlock block) {
        nestedElements.add(block);
    }

    void accept(Environment env) throws TemplateException, IOException {
        for (int i = 0; i<nestedElements.size(); i++) {
            ConditionalBlock cblock = (ConditionalBlock) nestedElements.get(i);
            Expression condition = cblock.condition;
            env.replaceElementStackTop(cblock);
            if (condition == null || condition.evalToBoolean(env)) {
                if (cblock.nestedBlock != null) {
                    env.visitByHiddingParent(cblock.nestedBlock);
                }
                return;
            }
        }
    }

    TemplateElement postParseCleanup(boolean stripWhitespace)
        throws ParseException 
    {
        if (nestedElements.size() == 1) {
            ConditionalBlock cblock = (ConditionalBlock) nestedElements.get(0);
            cblock.isLonelyIf = true;
            cblock.setLocation(getTemplate(), cblock, this);
            return cblock.postParseCleanup(stripWhitespace);
        }
        else {
            return super.postParseCleanup(stripWhitespace);
        }
    }
    
    protected String dump(boolean canonical) {
        if (canonical) {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < nestedElements.size(); i++) {
                ConditionalBlock cblock = (ConditionalBlock) nestedElements.get(i);
                buf.append(cblock.dump(canonical));
            }
            buf.append("</#if>");
            return buf.toString();
        } else {
            return getNodeTypeSymbol();
        }
    }
    
    String getNodeTypeSymbol() {
        return "#if-#elseif-#else-container";
    }
    
    int getParameterCount() {
        return 0;
    }

    Object getParameterValue(int idx) {
        throw new IndexOutOfBoundsException();
    }

    ParameterRole getParameterRole(int idx) {
        throw new IndexOutOfBoundsException();
    }
    
    boolean isShownInStackTrace() {
        return false;
    }

    boolean isNestedBlockRepeater() {
        return false;
    }
    
}
