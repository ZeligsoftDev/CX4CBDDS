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

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class DeclaredParameter extends SyntaxElement {

    private Identifier type;

    private Identifier name;

	public DeclaredParameter(final Identifier type, final Identifier name) {
        this.type = type;
        this.name = name;
    }

    public Identifier getName() {
        return name;
    }

    public Identifier getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString() + " " + name.toString();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		DeclaredParameter other = (DeclaredParameter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;

		if (type == null) {
			if (other.type != null)
				return false;
		}
		else if (!type.equals(other.type))
			return false;

		return true;
	}

}
