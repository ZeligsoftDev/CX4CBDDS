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

package org.eclipse.internal.xtend.expression.parser;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Markus Voelter
 */
public interface SyntaxConstants {
	public final static String NS_DELIM = "::";

	public final static String TYPE_NS_DELIM = ".";

	public static final String COLLECT = "collect";

	public static final String SELECT = "select";

	public static final String SELECTFIRST = "selectFirst";

	public static final String REJECT = "reject";

	public static final String EXISTS = "exists";

	public static final String NOT_EXISTS = "notExists";

	public static final String FOR_ALL = "forAll";

	public static final String SORT_BY = "sortBy";

	public static final String DEFAULT_ELE_NAME = "element";

	public static final String TYPE_SELECT = "typeSelect";
}
