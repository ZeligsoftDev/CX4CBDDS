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

package org.eclipse.internal.xtend.xtend;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.ao.AbstractWorkflowAdvice;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.XtendComponent;

public class XtendAdvice extends AbstractWorkflowAdvice {

	private final List<String> extensionAdvices = new ArrayList<String>();

	public void addExtensionAdvice(final String extensionAdvice) {
		this.extensionAdvices.add(extensionAdvice);
	}

	@Override
	public void weave(WorkflowComponent c, Issues issues) {
		if (!(c instanceof XtendComponent)) {
			issues.addError(this, "advice target is not an XtendComponent.");
		} else {
			XtendComponent xc = (XtendComponent)c;
			for (String advice : extensionAdvices) {
				xc.addExtensionAdvice(advice);
			}
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "extensionAdvices: " + buildList(extensionAdvices);
	}

}
