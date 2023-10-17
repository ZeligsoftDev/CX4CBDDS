/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.osgi.util.NLS;

public class ValidationWarning extends BasicDiagnostic
{
	public ValidationWarning(String messageTemplate, Object... bindings) {
		super(WARNING, PivotMessages.Validation, 0, NLS.bind(messageTemplate, bindings), null);
	}
}