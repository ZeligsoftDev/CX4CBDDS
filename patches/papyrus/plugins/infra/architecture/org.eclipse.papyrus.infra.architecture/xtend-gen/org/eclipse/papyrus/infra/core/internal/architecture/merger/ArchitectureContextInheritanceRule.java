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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Inheritance rule for {@link ArchitectureContext}s.
 */
@Singleton
@SuppressWarnings("all")
public class ArchitectureContextInheritanceRule {
  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private ArchitectureContextRule _architectureContextRule;

  /**
   * Query whether a context looks like a "legacy" context that does not participate in any
   * explicit inheritance or extension relationships, and so would be assuming the legacy
   * implicit name-based merge semantics.
   */
  public boolean legacyContext(final ArchitectureContext context) {
    return (!(((this.hasGeneral(context) || context.isExtension()) || this.hasSpecializations(context)) || this._architectureContextRule.hasExtensions(context)));
  }

  public boolean hasGeneral(final ArchitectureContext context) {
    ArchitectureContext _generalContext = context.getGeneralContext();
    return (_generalContext != null);
  }

  public ArchitectureContext general(final ArchitectureContext context) {
    ArchitectureContext _xifexpression = null;
    if ((this.hasGeneral(context) && this.canInherit(context, context.getGeneralContext()))) {
      _xifexpression = context.getGeneralContext();
    }
    return _xifexpression;
  }

  /**
   * Query whether a context is the target of any generalization relationships from other contexts.
   */
  public boolean hasSpecializations(final ArchitectureContext context) {
    return this._architectureExtensions.isReferenced(context, ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__GENERAL_CONTEXT);
  }

  public boolean canInherit(final ArchitectureContext specific, final ArchitectureContext general) {
    EClass _eClass = specific.eClass();
    EClass _eClass_1 = general.eClass();
    return (_eClass == _eClass_1);
  }

  /**
   * Query the set of contexts that have generalization relationships to a context (not recursive).
   */
  public <T extends ArchitectureContext> Iterable<T> specializations(final T context) {
    final Function1<T, Boolean> _function = (T it) -> {
      return Boolean.valueOf(this.canInherit(it, context));
    };
    return IterableExtensions.<T>filter(this._architectureExtensions.<T>invert(context, ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__GENERAL_CONTEXT), _function);
  }

  /**
   * Update the given context (if not already thus updated) with inheritable context from its general context, if any.
   */
  public ArchitectureContext inherit(final ArchitectureContext context) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(context);
    final ArchitectureContext _result;
    synchronized (_createCache_inherit) {
      if (_createCache_inherit.containsKey(_cacheKey)) {
        return _createCache_inherit.get(_cacheKey);
      }
      _result = context;
      _createCache_inherit.put(_cacheKey, _result);
    }
    _init_inherit(_result, context);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureContext> _createCache_inherit = CollectionLiterals.newHashMap();

  private void _init_inherit(final ArchitectureContext it, final ArchitectureContext context) {
    if ((this.hasGeneral(context) && this.canInherit(context, context.getGeneralContext()))) {
      this.inherit(context, this.inherit(context.getGeneralContext()));
    }
  }

  private Set<ArchitectureContext> inherit(final ArchitectureContext specific, final ArchitectureContext general) {
    final Function0<Set<ArchitectureContext>> _function = () -> {
      return this._architectureContextRule.<ArchitectureContext>merge(specific, general);
    };
    return this._architectureExtensions.<Set<ArchitectureContext>>withScope(CollectionLiterals.<ArchitectureDomain>newLinkedHashSet(specific.getDomain(), general.getDomain()), _function);
  }

  /**
   * Complete the processing of inheritance for the context by clearing the reference to its general.
   * The merged model does not retain inheritance and extension relationships as they would be redundant.
   */
  public void finalizeInheritance(final ArchitectureContext context) {
    context.setGeneralContext(null);
  }
}
