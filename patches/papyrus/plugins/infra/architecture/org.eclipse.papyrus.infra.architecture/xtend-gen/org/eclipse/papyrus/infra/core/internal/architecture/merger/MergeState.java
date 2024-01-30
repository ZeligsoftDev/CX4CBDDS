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
import java.util.Set;
import javax.inject.Singleton;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Encapsulation of "global" state of the merge algorithm.
 */
@Singleton
@SuppressWarnings("all")
final class MergeState {
  private MergePhase phase = MergePhase.NOT_STARTED;

  private final Set<ArchitectureDomain> domains = CollectionLiterals.<ArchitectureDomain>newLinkedHashSet();

  /**
   * Query the current phase of merging (especially whether inheritance or extensions processing).
   */
  public MergePhase phase() {
    return this.phase;
  }

  /**
   * Advance the state to the next phase of the merge algorithm.
   */
  void advancePhase() {
    MergePhase _switchResult = null;
    final MergePhase phase = this.phase;
    if (phase != null) {
      switch (phase) {
        case NOT_STARTED:
          _switchResult = MergePhase.INHERITANCE;
          break;
        case INHERITANCE:
          _switchResult = MergePhase.LEGACY;
          break;
        case LEGACY:
          _switchResult = MergePhase.EXTENSIONS;
          break;
        case EXTENSIONS:
          _switchResult = MergePhase.DONE;
          break;
        default:
          throw new IllegalStateException("Merge is done.");
      }
    } else {
      throw new IllegalStateException("Merge is done.");
    }
    this.phase = _switchResult;
    ArchitectureExtensions.logf("=== Merge phase: %s ===", this.phase);
  }

  /**
   * Query the current scope of domains being merged, whether for inheritance or for extension.
   */
  public Set<? extends ArchitectureDomain> currentDomains() {
    return this.domains;
  }

  /**
   * Execute a {@code block} in a new scope of {@code domains} being merged.
   */
  public <T extends Object> T withDomains(final Iterable<? extends ArchitectureDomain> domains, final Function0<T> block) {
    T _xblockexpression = null;
    {
      final Set<ArchitectureDomain> oldDomains = Set.<ArchitectureDomain>copyOf(this.domains);
      T _xtrycatchfinallyexpression = null;
      try {
        T _xblockexpression_1 = null;
        {
          this.setDomains(domains);
          ArchitectureExtensions.logf("Merging elements in scope of %s.", domains);
          _xblockexpression_1 = block.apply();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } finally {
        this.setDomains(oldDomains);
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }

  private boolean setDomains(final Iterable<? extends ArchitectureDomain> domains) {
    boolean _xblockexpression = false;
    {
      this.domains.clear();
      _xblockexpression = Iterables.<ArchitectureDomain>addAll(this.domains, domains);
    }
    return _xblockexpression;
  }
}
