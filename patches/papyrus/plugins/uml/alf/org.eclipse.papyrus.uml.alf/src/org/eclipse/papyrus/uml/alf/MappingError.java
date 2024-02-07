/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Ed Seidewitz (IJI) - Initial implementation
 *  Ed Seidewitz (MDS) - Updates
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;

public class MappingError extends Exception {

	private static final long serialVersionUID = 1L;
	private ExecutionDiagnostic diagnostic = null;

	public MappingError(ExecutionDiagnostic diagnostic) {
		super(diagnostic.getMessage());
		this.diagnostic = diagnostic;
	}

	public MappingError(Exception exception) {
		super(exception);
	}

	public ExecutionDiagnostic getDiagnostic() {
		return this.diagnostic;
	}
}
