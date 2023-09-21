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

package org.eclipse.xpand2;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class XpandUtil {

    private static final String SLASH = "/";

    public static final String NS_DELIM = SyntaxConstants.NS_DELIM;

    public static final String TEMPLATE_EXTENSION = "xpt";

    public final static String getJavaResourceName(final String fqn) {
        return fqn.replaceAll(NS_DELIM, SLASH) + "." + TEMPLATE_EXTENSION;
    }

    public static String withoutLastSegment(final String fqn) {
        if (fqn == null || fqn.lastIndexOf(SyntaxConstants.NS_DELIM) == -1)
            return null;
        return fqn.substring(0, fqn.lastIndexOf(SyntaxConstants.NS_DELIM));
    }

    public static String getLastSegment(final String fqn) {
        if (fqn == null || fqn.lastIndexOf(SyntaxConstants.NS_DELIM) == -1)
            return fqn;
        return fqn.substring(fqn.lastIndexOf(SyntaxConstants.NS_DELIM) + SyntaxConstants.NS_DELIM.length());
    }

}
