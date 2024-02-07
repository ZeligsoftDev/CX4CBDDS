/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.data;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class VMBreakpointData implements Serializable
{
	private static final long serialVersionUID = 2199378435188939811L;

	private final boolean conditionEnabled;
	private final @Nullable String condition;
	private final boolean conditionSuspendOnTrue;
	private final int hitCount;
	
	public VMBreakpointData(boolean conditionEnabled, @Nullable String condition, boolean conditionSuspendOnTrue, int hitCount) {
		this.conditionEnabled = conditionEnabled;
		this.condition = condition;
		this.conditionSuspendOnTrue = conditionSuspendOnTrue;
		this.hitCount = hitCount;
	}
	
	protected VMBreakpointData(@NonNull VMBreakpointData data) {
		this.conditionEnabled = data.conditionEnabled;
		this.condition = data.condition;
		this.conditionSuspendOnTrue = data.conditionSuspendOnTrue;
		this.hitCount = data.hitCount;
	}

	public @Nullable String getCondition() {
		return condition;
	}

	public boolean getConditionEnabled() {
		return conditionEnabled;
	}

	public boolean getConditionSuspendOnTrue() {
		return conditionSuspendOnTrue;
	}

	public int getHitCount() {
		return hitCount;
	}
}