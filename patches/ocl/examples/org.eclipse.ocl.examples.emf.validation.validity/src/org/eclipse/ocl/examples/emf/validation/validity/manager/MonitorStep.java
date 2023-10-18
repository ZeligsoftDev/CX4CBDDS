/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.manager;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;

/**
 * MonitorStep supervises the additional of a number of fractional increments to a Monitor, and the addition of the
 * entire workload when done.
 */
public class MonitorStep
{
	protected final @NonNull Monitor monitor;

	protected final int worked;
	private int workedSoFar = 0;
	private double workSoFar = 0.0;
	
	public MonitorStep(@NonNull Monitor monitor, int worked) {
		this.monitor = monitor;
		this.worked = worked;
	}
	
	public void done() {
		int residue = worked - workedSoFar;
		if (residue > 0) {
			monitor.worked(residue);
		}
	}
	
	public @NonNull Monitor getMonitor() {
		return monitor;
	}
	
	public void workedFraction(int parts) {
		int oldWorkedSoFar = workedSoFar;
		workSoFar += (double)worked / parts;
		workedSoFar = (int)workSoFar;
		monitor.worked(workedSoFar - oldWorkedSoFar);
	}
}