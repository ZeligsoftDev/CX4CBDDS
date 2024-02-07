/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.check;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;

public class CheckUtils {

    public static final String FILE_EXTENSION = "chk";

    private static final String SLASH = "/";

    public static final String NS_DELIM = SyntaxConstants.NS_DELIM;

    public final static String getJavaResourceName(final String fqn) {
        return fqn.replaceAll(NS_DELIM, SLASH) + "." + FILE_EXTENSION;
    }

}
