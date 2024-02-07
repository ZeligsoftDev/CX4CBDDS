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
import java.io.StringReader;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;
import freemarker.template.utility.StringUtil;

final class StringLiteral extends Expression implements TemplateScalarModel {
    
    private final String value;
    private TemplateElement dynamicValue;
    
    StringLiteral(String value) {
        this.value = value;
    }
    
    void checkInterpolation() throws ParseException {
        if (value.length() > 3 && (value.indexOf("${") >= 0 || value.indexOf("#{") >= 0)) {
            SimpleCharStream scs = new SimpleCharStream(new StringReader(value), beginLine, beginColumn+1, value.length());
            FMParserTokenManager token_source = new FMParserTokenManager(scs);
            token_source.onlyTextOutput = true;
            FMParser parser = new FMParser(token_source);
            parser.setTemplate(getTemplate());
            try {
                dynamicValue = parser.FreeMarkerText();
            }
            catch(ParseException e) {
                e.setTemplateName(getTemplate().getSourceName());
                throw e;
            }
            this.constantValue = null;
        }
    }
    
    TemplateModel _eval(Environment env) throws TemplateException {
        return new SimpleScalar(evalAndCoerceToString(env));
    }

    public String getAsString() {
        return value;
    }
    
    /**
     * Tells if this is something like <tt>"${foo}"</tt>, which is usually a user mistake.
     */
    boolean isSingleInterpolationLiteral() {
        return dynamicValue != null && dynamicValue.getChildCount() == 1
                && dynamicValue.getChildAt(0) instanceof DollarVariable;
    }
    
    String evalAndCoerceToString(Environment env) throws TemplateException {
        if (dynamicValue == null) {
            return value;
        } 
        else {
            TemplateExceptionHandler teh = env.getTemplateExceptionHandler();
            env.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            try {
               return env.renderElementToString(dynamicValue);
            }
            catch (IOException ioe) {
                throw new _MiscTemplateException(ioe, env);
            }
            finally {
                env.setTemplateExceptionHandler(teh);
            }
        }
    }

    public String getCanonicalForm() {
        return StringUtil.ftlQuote(value); 
    }
    
    String getNodeTypeSymbol() {
        return dynamicValue == null ? getCanonicalForm() : "dynamic \"...\"";
    }
    
    boolean isLiteral() {
        return dynamicValue == null;
    }

    protected Expression deepCloneWithIdentifierReplaced_inner(
            String replacedIdentifier, Expression replacement, ReplacemenetState replacementState) {
        StringLiteral cloned = new StringLiteral(value);
        // FIXME: replacedIdentifier should be searched inside interpolatedOutput too:
        cloned.dynamicValue = this.dynamicValue;
        return cloned;
    }

    int getParameterCount() {
        return 1;
    }

    Object getParameterValue(int idx) {
        if (idx != 0) throw new IndexOutOfBoundsException();
        return dynamicValue;
    }

    ParameterRole getParameterRole(int idx) {
        if (idx != 0) throw new IndexOutOfBoundsException();
        return ParameterRole.EMBEDDED_TEMPLATE;
    }
    
}
