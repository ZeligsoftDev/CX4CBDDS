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

/**
 * Constants interface containing all Xpand keywords.
 * @since 1.0.0 M5
 */
public interface XpandTokens {

	String LT = "\u00ab";

	char LT_CHAR = '\u00ab';

	String RT = "\u00bb";

	char RT_CHAR = '\u00bb';

	String AS = "AS";

	String CEND = "CEND";

	String CSTART = "CSTART";

	String DEFINE = "DEFINE";

	String DISABLE = "DISABLE";

	String ELSE = "ELSE";

	String ELSEIF = "ELSEIF";

	String ENDDEFINE = "ENDDEFINE";

	String ENDFILE = "ENDFILE";

	String ENDFOREACH = "ENDFOREACH";

	String ENDIF = "ENDIF";

	String ENDLET = "ENDLET";

	String ENDPROTECT = "ENDPROTECT";

	String ERROR = "ERROR";

	String EXPAND = "EXPAND";

	String EXTENSION = "EXTENSION";

	String FILE = "FILE";

	String FOR = "FOR";

	String FOREACH = "FOREACH";

	String ID = "ID";

	String IF = "IF";

	String IMPORT = "IMPORT";

	String ITERATOR = "ITERATOR";

	String LET = "LET";

	String NEW = "new";

	String PROTECT = "PROTECT";

	String SEPARATOR = "SEPARATOR";

	String ONFILECLOSE = "ONFILECLOSE";

	String REM = "REM";

	String ENDREM = "ENDREM";

	String TRUE_CONST = "true";

	String FALSE_CONST = "false";

	String NULL_CONST = "null";

	String THIS = "this";

	String LET_EXPR = "let";

	String SWITCH = "switch";

	String CASE = "case";

	String DEFAULT = "default";

	String ENDAROUND = "ENDAROUND";

	String AROUND = "AROUND";

	String[] ALLKEYWORDS = new String[] { AROUND, AS, CASE, CEND, CSTART,
			DEFAULT, DEFINE, DISABLE, ELSE, ELSEIF, 
			ENDAROUND, ENDDEFINE, ENDFILE, ENDFOREACH, ENDIF, ENDLET, ENDPROTECT, ENDREM, ERROR, EXPAND, EXTENSION, 
			FALSE_CONST, FILE, FOR, FOREACH, ID, IF, IMPORT, ITERATOR, LET, LET_EXPR, NEW, NULL_CONST, ONFILECLOSE, 
			PROTECT, REM, SEPARATOR, SWITCH, THIS, TRUE_CONST
			};

}
