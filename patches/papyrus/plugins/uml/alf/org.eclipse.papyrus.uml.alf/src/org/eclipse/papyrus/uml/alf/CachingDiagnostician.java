/*****************************************************************************
 * Copyright (c) 2014-2016 CEA LIST.
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
 * 	 Ed Seidewitz
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

public class CachingDiagnostician extends CancelableDiagnostician {

	private boolean caching = false;

	@Inject
	public CachingDiagnostician(Registry registry) {
		super(registry);
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result;
		if (this.caching) {
			result = super.validate(eObject, diagnostics, context);
		} else {
			RunTimeCaching.clearAll();
			this.caching = true;
			result = super.validate(eObject, diagnostics, context);
			this.caching = false;
		}
		return result;
	}

}
