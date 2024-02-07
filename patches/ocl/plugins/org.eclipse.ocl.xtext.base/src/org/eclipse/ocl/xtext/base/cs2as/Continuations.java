/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

public class Continuations implements Continuation<ModelElementCS>
{
	public static Continuation<?> combine(Continuation<?>... inputContinuations) {
		List<BasicContinuation<?>> continuations = null;
		Continuation<?> continuation = null;
		for (Continuation<?> inputContinuation : inputContinuations) {
			if (inputContinuation != null) {
				if (continuation == null) {
					continuation = inputContinuation;
				}
				else {
					if (continuations == null) {
						continuations = new ArrayList<BasicContinuation<?>>();
						continuation.addTo(continuations);
					}
					inputContinuation.addTo(continuations);
				}
			}
		}
		return continuations != null ? new Continuations(continuations) : continuation;
	}

	private final @NonNull List<BasicContinuation<?>> continuations;

	public Continuations() {
		this.continuations = new ArrayList<BasicContinuation<?>>();
	}

	public Continuations(@NonNull List<BasicContinuation<?>> continuations) {
		this.continuations = continuations;
	}

	public void add(@NonNull BasicContinuation<?> continuation) {
		continuations.add(continuation);
	}

	@Override
	public void addTo(@NonNull List<BasicContinuation<?>> simpleContinuations) {
		for (BasicContinuation<?> continuation : continuations) {
			continuation.addTo(simpleContinuations);
		}
	}

	public Continuation<?> getContinuation() {
		if (continuations.isEmpty()) {
			return null;
		}
		else if (continuations.size() == 1) {
			return continuations.get(0);
		}
		else {
			return this;
		}
	}
}