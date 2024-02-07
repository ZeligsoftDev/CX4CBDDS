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

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Merge rule for {@link ArchitectureViewpoint}s.
 */
@Singleton
@SuppressWarnings("all")
public class ArchitectureViewpointRule {
  @Extension
  private static ArchitectureFactory factory = ArchitectureFactory.eINSTANCE;

  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private RepresentationKindRule _representationKindRule;

  /**
   * Obtain the merge result for a viewpoint owned by merged {@code contexts}. Viewpoints are merged by name.
   * If merged previously, that previous merge result is returned.
   */
  public ArchitectureViewpoint mergedViewpoint(final String name, final Set<? extends ArchitectureContext> contexts) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(name, contexts);
    final ArchitectureViewpoint _result;
    synchronized (_createCache_mergedViewpoint) {
      if (_createCache_mergedViewpoint.containsKey(_cacheKey)) {
        return _createCache_mergedViewpoint.get(_cacheKey);
      }
      ArchitectureViewpoint _createArchitectureViewpoint = ArchitectureViewpointRule.factory.createArchitectureViewpoint();
      _result = _createArchitectureViewpoint;
      _createCache_mergedViewpoint.put(_cacheKey, _result);
    }
    _init_mergedViewpoint(_result, name, contexts);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureViewpoint> _createCache_mergedViewpoint = CollectionLiterals.newHashMap();

  private void _init_mergedViewpoint(final ArchitectureViewpoint result, final String name, final Set<? extends ArchitectureContext> contexts) {
    final Function1<ArchitectureContext, EList<ArchitectureViewpoint>> _function = (ArchitectureContext it) -> {
      return it.getViewpoints();
    };
    final Consumer<ArchitectureViewpoint> _function_1 = (ArchitectureViewpoint viewpoint) -> {
      ArchitectureViewpoint _copy = this._architectureExtensions.<ArchitectureViewpoint>copy(result, viewpoint);
      final Procedure1<ArchitectureViewpoint> _function_2 = (ArchitectureViewpoint it) -> {
        EList<Concern> _concerns = it.getConcerns();
        final Function1<Concern, String> _function_3 = (Concern it_1) -> {
          return it_1.getName();
        };
        final Function1<String, Concern> _function_4 = (String it_1) -> {
          return this._architectureExtensions.mergedConcern(it_1);
        };
        Iterable<Concern> _map = IterableExtensions.<String, Concern>map(this._architectureExtensions.<Concern, String>mapUnique(viewpoint.getConcerns(), _function_3), _function_4);
        Iterables.<Concern>addAll(_concerns, _map);
        EList<RepresentationKind> _representationKinds = it.getRepresentationKinds();
        final Function1<RepresentationKind, RepresentationKind> _function_5 = (RepresentationKind it_1) -> {
          return this._representationKindRule.merged(it_1);
        };
        List<RepresentationKind> _map_1 = ListExtensions.<RepresentationKind, RepresentationKind>map(viewpoint.getRepresentationKinds(), _function_5);
        Iterables.<RepresentationKind>addAll(_representationKinds, _map_1);
      };
      ObjectExtensions.<ArchitectureViewpoint>operator_doubleArrow(_copy, _function_2);
      ArchitectureExtensions.logf("Merged %s into %s", viewpoint, result);
    };
    this._architectureExtensions.<ArchitectureViewpoint>named(IterableExtensions.flatMap(contexts, _function), name).forEach(_function_1);
  }
}
