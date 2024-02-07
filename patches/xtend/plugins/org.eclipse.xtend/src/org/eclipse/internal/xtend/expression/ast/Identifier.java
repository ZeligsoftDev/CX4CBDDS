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

package org.eclipse.internal.xtend.expression.ast;

import org.eclipse.internal.xtend.util.QualifiedName;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Karsten Thoms
 */
public class Identifier extends SyntaxElement {
	private QualifiedName qn;

	/**
	 * Constructor
	 * 
	 * @param segments
	 *            Segments of the Identifier.
	 */
	public Identifier(final String... segments) {
		// identifier segments might start with '^', which need to be removed
		final String[] qnSegments = new String[segments.length];
		for (int i = 0; i < segments.length; i++) {
			qnSegments[i] = segments[i].charAt(0) == '^' ? segments[i].substring(1) : segments[i];
		}
		qn = QualifiedName.create(qnSegments);
	}

	/**
	 * Constructor
	 * 
	 * @param segment
	 *            The one segment of the Identifier.
	 */
	public Identifier(final String segment) {
		qn = QualifiedName.create(segment.charAt(0) == '^' ? segment.substring(1) : segment);
	}

	/**
	 * Append another Identifier to this instance
	 * 
	 * @param t
	 *            An identifier.
	 * @return Will return <code>this</code> extended by the segments of <code>t</code>
	 */
	public Identifier append(final Identifier t) {
		qn = qn.append(t.qn);
		end = t.end;
		return this;
	}

	/**
	 * Returns a canonical String representation of this using '.' as namespace delimiter. For language specific conversion taking the concrete syntax
	 * into account see {@link QualifiedName#toString()}.
	 */
	@Override
	public String toString() {
		return qn.toString();
	}

	public int getSegmentCount() {
		return qn.getSegmentCount();
	}

	public String getSegment(final int index) {
		return qn.getSegment(index);
	}

	public String getLastSegment() {
		return qn.getLastSegment();
	}

	public String getFirstSegment() {
		return qn.getFirstSegment();
	}

	@Override
	public int hashCode() {
		return qn.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Identifier other = (Identifier) obj;
		if (qn != other.qn) {
			return false;
		}
		return true;
	}

}
