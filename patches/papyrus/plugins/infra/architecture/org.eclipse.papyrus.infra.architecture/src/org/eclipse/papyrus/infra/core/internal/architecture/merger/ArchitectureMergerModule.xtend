/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger;

import java.util.function.BiConsumer;

import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Guice module for configuration of the {@link InternalArchitectureDomainMerger}.
 */
class ArchitectureMergerModule extends AbstractModule {

	/** Key for named injection of a block that sets up trace relationships from merge result to source model elements. */
	public static val String MERGE_TRACE = "MERGE_TRACE"; //$NON-NLS-1$
	
	extension val MergeTraces traces = new MergeTraces

	override protected final void configure() {
		basicConfigure();
		doConfigure();
	}

	private def basicConfigure() {
		bindMergeTraces();
	}

	private def bindMergeTraces() {
		MergeTraces.bind.toInstance(traces);
		MergeTraceAdapter.bind.toInstance(traces);

		val mergeTracerType = new TypeLiteral<BiConsumer<? super ADElement, ? super ADElement>> {}
		mergeTracerType.bind.annotatedWith(Names.named(MERGE_TRACE)).toInstance([ target, source | target.trace(source)])
	}

	/**
	 * Overridden by subclasses to add bindings. The default implementation does nothing.
	 */
	protected def void doConfigure() {
		// Pass
	}

}
