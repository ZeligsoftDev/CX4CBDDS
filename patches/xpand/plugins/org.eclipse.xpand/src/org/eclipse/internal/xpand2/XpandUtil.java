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
package org.eclipse.internal.xpand2;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;

/**
 * Xpand utility class. Contains static helper methods and constants. 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public final class XpandUtil {

    private static final String SLASH = "/";

    public static final String NS_DELIM = SyntaxConstants.NS_DELIM;

    public static final String TEMPLATE_EXTENSION = "xpt";

    public final static String getJavaResourceName(final String fqn) {
        return new StringBuilder(fqn.length()+4).append(fqn.replace(NS_DELIM, SLASH)).append('.').append(TEMPLATE_EXTENSION).toString();
    }

    /**
     * Returns the name without its last segment.
     * @param fqn Qualified name (foo::bar).
     * @return <tt>fqn</tt> without the last segment. Returns <tt>null</tt> if <tt>fqn</tt> is null
     * or the name does not contain a qualifier ('::').
     */
    public static String withoutLastSegment(final String fqn) {
        if (fqn == null)
            return null;
        final int offsetNsDelim = fqn.lastIndexOf(SyntaxConstants.NS_DELIM);
        if (offsetNsDelim == -1)
            return null;
        return fqn.substring(0, offsetNsDelim);
    }

    /**
     * Returns the last segment of a qualified name.
     * @param fqn Qualified name (foo::bar).
     * @return The last segment of <tt>fqn</tt>. Returns <tt>null</tt> if <tt>fqn</tt> is null.
     * Returns <tt>fqn</tt> if the name does not contain a qualifier ('::'). 
     */
    public static String getLastSegment(final String fqn) {
        if (fqn == null)
            return null;
        final int offsetNsDelim = fqn.lastIndexOf(SyntaxConstants.NS_DELIM);
        if (offsetNsDelim == -1)
            return fqn;
        return fqn.substring(offsetNsDelim + 2 /*SyntaxConstants.NS_DELIM.length()*/);
    }

}
