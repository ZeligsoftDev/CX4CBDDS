/**
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
 */
package org.eclipse.papyrus.infra.core.internal.architecture.merger;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import java.util.function.BiConsumer;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Guice module for configuration of the {@link InternalArchitectureDomainMerger}.
 */
@SuppressWarnings("all")
public class ArchitectureMergerModule extends AbstractModule {
  /**
   * Key for named injection of a block that sets up trace relationships from merge result to source model elements.
   */
  public static final String MERGE_TRACE = "MERGE_TRACE";

  @Extension
  private final MergeTraces traces = new MergeTraces();

  @Override
  protected final void configure() {
    this.basicConfigure();
    this.doConfigure();
  }

  private void basicConfigure() {
    this.bindMergeTraces();
  }

  private void bindMergeTraces() {
    this.<MergeTraces>bind(MergeTraces.class).toInstance(this.traces);
    this.<MergeTraceAdapter>bind(MergeTraceAdapter.class).toInstance(this.traces);
    final TypeLiteral<BiConsumer<? super ADElement, ? super ADElement>> mergeTracerType = new TypeLiteral<BiConsumer<? super ADElement, ? super ADElement>>() {
    };
    final BiConsumer<ADElement, ADElement> _function = (ADElement target, ADElement source) -> {
      this.traces.trace(target, source);
    };
    this.<BiConsumer<? super ADElement, ? super ADElement>>bind(mergeTracerType).annotatedWith(Names.named(ArchitectureMergerModule.MERGE_TRACE)).toInstance(_function);
  }

  /**
   * Overridden by subclasses to add bindings. The default implementation does nothing.
   */
  protected void doConfigure() {
  }
}
