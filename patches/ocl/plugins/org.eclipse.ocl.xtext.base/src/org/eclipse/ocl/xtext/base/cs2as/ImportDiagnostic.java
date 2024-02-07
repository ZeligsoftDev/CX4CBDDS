/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.nodemodel.INode;

public class ImportDiagnostic extends AbstractDiagnostic
{
	private final INode node;
	private final String message;
	private final String code;
	private final String[] data;

	public ImportDiagnostic(INode node, String message, String code, String... data) {
		this.node = node;
		this.message = message;
		this.code = code;
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportDiagnostic other = (ImportDiagnostic) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public int getColumn() {
		return -1;
	}

	@Override
	public String[] getData() {
		return data;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public INode getNode() {
		return node;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getMessage();
	}
}