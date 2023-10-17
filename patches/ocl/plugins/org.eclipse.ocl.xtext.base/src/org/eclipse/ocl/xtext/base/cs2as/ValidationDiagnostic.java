/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
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

public class ValidationDiagnostic extends AbstractDiagnostic
{
	protected final INode node;
	protected final String message;

	public ValidationDiagnostic(INode node, String message) {
		this.node = node;
		this.message = message;
	}

	@Override
	public String getCode() {
		return "FIXME-ValidationDiagnostic-CODE";
	}

	@Override
	public int getColumn() {
		return -1;
	}

	@Override
	public String[] getData() {
		return null;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	protected INode getNode() {
		return node;
	}
}