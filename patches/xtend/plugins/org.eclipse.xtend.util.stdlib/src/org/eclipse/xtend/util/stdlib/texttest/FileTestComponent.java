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
package org.eclipse.xtend.util.stdlib.texttest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

public abstract class FileTestComponent extends AbstractWorkflowComponent2 {

	private Issues issues;

	private final Logger log = LogManager.getLogger(getClass());

	@Override
	protected void checkConfigurationInternal(Issues issues) {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		this.issues = issues;
		try {
			test();
			log.info("  tests completed successfully.");
		}
		catch (Failed f) {
			issues.addError(f.getMessage());
			log.info("  TESTS FAILED!");
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "running tests...";
	}

	protected abstract void test();

	protected boolean assertTrue(boolean condition, String message) {
		if (!condition) {
			issues.addError(message);
		}
		return condition;
	}

	protected void assertTrueFatal(boolean condition, String message) {
		if (!condition) {
			issues.addError(message);
		}
		throw new RuntimeException("TEST STOPPED: " + message);
	}

	protected Handle getHandleGenerated(String idlFileName) {
		Handle handle = new Handle(idlFileName);
		return handle;
	}

	protected Handle getHandleCompare(String idlFileName) {
		Handle handle = new Handle(idlFileName);
		return handle;
	}

}
