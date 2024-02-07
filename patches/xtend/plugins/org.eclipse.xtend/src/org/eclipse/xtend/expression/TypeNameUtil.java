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

package org.eclipse.xtend.expression;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;

/**
 * Utility class for retrieving information from various type name presentations used within Xtend's type system.
 * <p>
 * The following type formats can occur:
 * <ul>
 * <li> <code>&lt;typename&gt;</code>
 * <li> <code>&lt;collectionTypeName&gt;[&lt;typename&gt;]</code>
 * <li>
 * <code>&lt;collectionTypeName&gt;[&lt;metamodelname&gt;!&lt;typename&gt;]</code>
 * </ul>
 * Examples:
 * <ul>
 * <li> <code>entities::Account</code>
 * <li> <code>List[entities::Account]</code>
 * </ul>
 * <p>
 * '<code>&lt;typename&gt;</code>' is the fully qualified name <code>namespace1::namespace2::name</code>
 * 
 * @author Sven Efftinge (http://www.efftinge.de) - Initial implementation
 * @author Arno Haase - Initial implementation
 * @author Karsten Thoms - Documentation
 */
public class TypeNameUtil {

	/**
	 * Retrieves the collection type.
	 * 
	 * @param name
	 *            Qualified type string
	 * @return The name of the collection type if present ('List', 'Set'), otherwise <code>null</code>
	 */
	public static String getCollectionTypeName(final String name) {
		// If there is a collection type there must be a [, so quickly check for that first.
		//
		int index = name.indexOf('[');
		if (index == -1) {
			return null;
		}
		if (index == 0) {
			if (name.startsWith("[L")) {
				return "List";
			}
		}
		if (name.endsWith("]")) {
			if (name.charAt(name.length() - 2) == '[') { // TypeName[]
				return "List";
			}
			if ((index == 0) && name.startsWith("L", 1)) {
				return name.substring(2, name.length() - 1);
			}
		}
		return name.substring(0, index);
	}

	/**
	 * Retrieves the type name
	 * 
	 * @param name
	 *            Qualified type string
	 * @return The type's name
	 */
	public static String getTypeName(final String name) {
		int index = name.indexOf('[');
		if (index == -1) {
			int end = name.lastIndexOf('!');
			if (end == -1) {
				return name;
			}
			return name.substring(end + 1);
		}
		if (name.endsWith("]")) {
			if (name.charAt(name.length() - 2) == '[') { // TypeName[]
				return name.substring(0, name.length() - 2);
			}
			int end = name.lastIndexOf('!');
			if (end == -1) {
				return name.substring(index + 1, name.length() - 1);
			}
			return name.substring(end + 1, name.length() - 1);
		}
		return null;
	}

	/**
	 * Gets the internal representation of a class name.
	 * 
	 * @param class1
	 *            A class instance for which the name should be retrieved
	 * @return Xtend's classname representation ( <code>package1::package2::TheClassname</code>)
	 */
	public static String getName(final Class<?> class1) {
		return convertJavaTypeName(class1.getName());
	}

	/**
	 * Cuts the last segment from a qualified type name.
	 * 
	 * @param fqn
	 *            Qualified type name
	 * @return <pre>
	 * ns1::ns2::name   -&gt; ns1::ns2
	 * name             -&gt; &lt;null&gt;
	 * </pre>
	 */
	public static String withoutLastSegment(final String fqn) {
		int index = fqn.lastIndexOf(SyntaxConstants.NS_DELIM);
		if (index == -1) {
			return null;
		}
		return fqn.substring(0, index);
	}

	/**
	 * Retrieves only the last segment of a qualified name and therefore cuts the namespace part
	 * 
	 * @param fqn
	 *            Qualified type name
	 * @return <pre>
	 * ns1::ns2::name   -&gt; name
	 * name             -&gt; name
	 * </pre>
	 */
	public static String getLastSegment(final String fqn) {
		int index = fqn.lastIndexOf(SyntaxConstants.NS_DELIM);
		if (index == -1) {
			return fqn;
		}
		return fqn.substring(index + SyntaxConstants.NS_DELIM.length());
	}

	/**
	 * Cuts the namespace qualification from the type string.
	 * 
	 * @param fqn
	 *            Qualified type string
	 * @return <pre>
	 * ns1::ns2::type             -&gt; type
	 * List[type]                 -&gt; List[type]
	 * List[Metamodel!ns1::type]  -&gt; List[Metamodel!type]
	 * </pre>
	 */
	public static String getSimpleName(final String fqn) {
		final String ct = getCollectionTypeName(fqn);
		final String inner = getLastSegment(getTypeName(fqn));
		final StringBuffer sb = new StringBuffer();
		if (ct != null) {
			sb.append(ct).append('[');
		}
		sb.append(inner);
		if (ct != null) {
			sb.append(']');
		}
		return sb.toString();
	}

	public static String getPackage(final String insertString) {
		if ((insertString == null) || (insertString.trim().length() == 0)) {
			return null;
		}
		final int index = insertString.lastIndexOf(SyntaxConstants.NS_DELIM);
		if (index != -1) {
			return insertString.substring(0, index);
		}
		return null;
	}

	/**
	 * Converts a Java qualified name (dot seperated) to Xtend qualified name ('::' seperated).
	 * 
	 * @param javaTypeName
	 *            A java qualifier
	 * @return All dots are replaced by '::'. Returns <code>null</code> if <tt>javaTypeName</tt> is null.
	 */
	public static String convertJavaTypeName(final String javaTypeName) {
		if (javaTypeName == null) {
			return null;
		}
		int index = javaTypeName.indexOf('.');
		if (index == -1) {
			return javaTypeName;
		}
		int length = javaTypeName.length();
		StringBuilder result = new StringBuilder(length + 8);
		int start = 0;
		while (index != -1) {
			result.append(javaTypeName, start, index);
			result.append(SyntaxConstants.NS_DELIM);
			start = index + 1;
			index = javaTypeName.indexOf('.', start);
		}
		result.append(javaTypeName, start, length);
		return result.toString();
	}
}
