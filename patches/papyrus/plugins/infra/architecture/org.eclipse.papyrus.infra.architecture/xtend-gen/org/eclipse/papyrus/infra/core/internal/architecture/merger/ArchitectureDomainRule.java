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
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Merge rule for {@link Architecture Domain}s.
 */
@Singleton
@SuppressWarnings("all")
public class ArchitectureDomainRule {
  @Extension
  private static ArchitectureFactory factory = ArchitectureFactory.eINSTANCE;

  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private ArchitectureContextRule _architectureContextRule;

  @Inject
  @Extension
  private ArchitectureContextInheritanceRule _architectureContextInheritanceRule;

  public boolean hasExtensions(final ArchitectureDomain domain) {
    final Function1<ArchitectureContext, Boolean> _function = (ArchitectureContext it) -> {
      return Boolean.valueOf(this._architectureContextRule.hasExtensions(it));
    };
    return IterableExtensions.<ArchitectureContext>exists(domain.getContexts(), _function);
  }

  public boolean isExtension(final ArchitectureDomain domain) {
    final Function1<ArchitectureContext, Boolean> _function = (ArchitectureContext it) -> {
      return Boolean.valueOf(it.isExtension());
    };
    return IterableExtensions.<ArchitectureContext>exists(domain.getContexts(), _function);
  }

  public boolean hasInheritance(final ArchitectureDomain domain) {
    final Function1<ArchitectureContext, Boolean> _function = (ArchitectureContext it) -> {
      return Boolean.valueOf((this._architectureContextInheritanceRule.hasGeneral(it) || this._architectureContextInheritanceRule.hasSpecializations(it)));
    };
    return IterableExtensions.<ArchitectureContext>exists(domain.getContexts(), _function);
  }

  public boolean hasContexts(final ArchitectureDomain domain) {
    boolean _isEmpty = domain.getContexts().isEmpty();
    return (!_isEmpty);
  }

  public Iterable<ArchitectureContext> allContexts(final ArchitectureDomain domain) {
    EList<ArchitectureContext> _contexts = domain.getContexts();
    final Function1<ArchitectureDomain, EList<ArchitectureContext>> _function = (ArchitectureDomain it) -> {
      return it.getContexts();
    };
    Iterable<ArchitectureContext> _flatMap = IterableExtensions.<ArchitectureDomain, ArchitectureContext>flatMap(this.allExtensions(domain), _function);
    return Iterables.<ArchitectureContext>concat(_contexts, _flatMap);
  }

  /**
   * A domain's extensions are implied by the domains defining extensions of its contexts.
   */
  public Iterable<ArchitectureDomain> extensions(final ArchitectureDomain extended) {
    Iterable<ArchitectureDomain> _xifexpression = null;
    boolean _inExtensionsPhase = this._architectureExtensions.inExtensionsPhase();
    if (_inExtensionsPhase) {
      final Function1<ArchitectureContext, Iterable<ArchitectureContext>> _function = (ArchitectureContext it) -> {
        return this._architectureContextRule.<ArchitectureContext>extensions(it);
      };
      final Function1<ArchitectureContext, ArchitectureDomain> _function_1 = (ArchitectureContext it) -> {
        return it.getDomain();
      };
      _xifexpression = this._architectureExtensions.<ArchitectureContext, ArchitectureDomain>mapUnique(IterableExtensions.<ArchitectureContext, ArchitectureContext>flatMap(extended.getContexts(), _function), _function_1);
    } else {
      _xifexpression = CollectionLiterals.<ArchitectureDomain>emptyList();
    }
    return _xifexpression;
  }

  /**
   * A domain's extensions are implied by the domains defining extensions of its contexts.
   */
  public Iterable<ArchitectureDomain> allExtensions(final ArchitectureDomain extended) {
    Iterable<ArchitectureDomain> _xifexpression = null;
    boolean _inExtensionsPhase = this._architectureExtensions.inExtensionsPhase();
    if (_inExtensionsPhase) {
      final Function1<ArchitectureContext, List<ArchitectureContext>> _function = (ArchitectureContext it) -> {
        return this._architectureContextRule.<ArchitectureContext>allExtensions(it);
      };
      final Function1<ArchitectureContext, ArchitectureDomain> _function_1 = (ArchitectureContext it) -> {
        return it.getDomain();
      };
      _xifexpression = this._architectureExtensions.<ArchitectureContext, ArchitectureDomain>mapUnique(IterableExtensions.<ArchitectureContext, ArchitectureContext>flatMap(extended.getContexts(), _function), _function_1);
    } else {
      _xifexpression = CollectionLiterals.<ArchitectureDomain>emptyList();
    }
    return _xifexpression;
  }

  public Iterable<ArchitectureDomain> generals(final ArchitectureDomain specific) {
    Iterable<ArchitectureDomain> _xifexpression = null;
    boolean _inInheritancePhase = this._architectureExtensions.inInheritancePhase();
    if (_inInheritancePhase) {
      final Function1<ArchitectureContext, ArchitectureContext> _function = (ArchitectureContext it) -> {
        return this._architectureContextInheritanceRule.general(it);
      };
      final Function1<ArchitectureContext, ArchitectureDomain> _function_1 = (ArchitectureContext it) -> {
        return it.getDomain();
      };
      _xifexpression = this._architectureExtensions.<ArchitectureDomain>excluding(this._architectureExtensions.<ArchitectureDomain>unique(IterableExtensions.<ArchitectureContext, ArchitectureDomain>map(IterableExtensions.<ArchitectureContext>filterNull(ListExtensions.<ArchitectureContext, ArchitectureContext>map(specific.getContexts(), _function)), _function_1)), specific);
    } else {
      _xifexpression = CollectionLiterals.<ArchitectureDomain>emptyList();
    }
    return _xifexpression;
  }

  /**
   * Process inheritance for the contexts in a domain, if not already done previously for this domain.
   */
  public ArchitectureDomain inherit(final ArchitectureDomain domain) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(domain);
    final ArchitectureDomain _result;
    synchronized (_createCache_inherit) {
      if (_createCache_inherit.containsKey(_cacheKey)) {
        return _createCache_inherit.get(_cacheKey);
      }
      _result = domain;
      _createCache_inherit.put(_cacheKey, _result);
    }
    _init_inherit(_result, domain);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureDomain> _createCache_inherit = CollectionLiterals.newHashMap();

  private void _init_inherit(final ArchitectureDomain it, final ArchitectureDomain domain) {
    final Function1<ArchitectureDomain, ArchitectureDomain> _function = (ArchitectureDomain it_1) -> {
      return this.inherit(it_1);
    };
    final Function0<Boolean> _function_1 = () -> {
      boolean _xblockexpression = false;
      {
        EList<Concern> _concerns = domain.getConcerns();
        final Function1<ArchitectureDomain, EList<Concern>> _function_2 = (ArchitectureDomain it_1) -> {
          return it_1.getConcerns();
        };
        final Function1<Concern, String> _function_3 = (Concern it_1) -> {
          return it_1.getName();
        };
        final Function1<String, Concern> _function_4 = (String it_1) -> {
          return this._architectureExtensions.mergedConcern(it_1);
        };
        Iterable<Concern> _map = IterableExtensions.<String, Concern>map(this._architectureExtensions.<Concern, String>mapUnique(IterableExtensions.flatMap(this._architectureExtensions.currentScope(), _function_2), _function_3), _function_4);
        Iterables.<Concern>addAll(_concerns, _map);
        EList<Stakeholder> _stakeholders = domain.getStakeholders();
        final Function1<ArchitectureDomain, EList<Stakeholder>> _function_5 = (ArchitectureDomain it_1) -> {
          return it_1.getStakeholders();
        };
        final Function1<Stakeholder, String> _function_6 = (Stakeholder it_1) -> {
          return it_1.getName();
        };
        final Function1<String, Stakeholder> _function_7 = (String it_1) -> {
          return this._architectureExtensions.mergedStakeholder(it_1);
        };
        Iterable<Stakeholder> _map_1 = IterableExtensions.<String, Stakeholder>map(this._architectureExtensions.<Stakeholder, String>mapUnique(IterableExtensions.flatMap(this._architectureExtensions.currentScope(), _function_5), _function_6), _function_7);
        _xblockexpression = Iterables.<Stakeholder>addAll(_stakeholders, _map_1);
      }
      return Boolean.valueOf(_xblockexpression);
    };
    this._architectureExtensions.<Boolean>withScope(IterableExtensions.<ArchitectureDomain, ArchitectureDomain>map(this.generals(domain), _function), _function_1);
    boolean _inInheritancePhase = this._architectureExtensions.inInheritancePhase();
    if (_inInheritancePhase) {
      final Consumer<ArchitectureContext> _function_2 = (ArchitectureContext it_1) -> {
        this._architectureContextInheritanceRule.inherit(it_1);
      };
      domain.getContexts().forEach(_function_2);
    }
  }

  /**
   * Finalize inheritance processing for all contexts in a domain.
   * 
   * @see ArchitectureContextInheritanceRule#finalizeInheritance(ArchitectureContext)
   */
  public void finalizeInheritance(final ArchitectureDomain domain) {
    final Consumer<ArchitectureContext> _function = (ArchitectureContext it) -> {
      this._architectureContextInheritanceRule.finalizeInheritance(it);
    };
    domain.getContexts().forEach(_function);
  }

  /**
   * Merging of domains is implied by merging of its contexts: merge the given
   * domain with all domains that define contexts that are extended by some
   * context in this domain.
   */
  public ArchitectureDomain merged(final ArchitectureDomain domain) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(domain);
    final ArchitectureDomain _result;
    synchronized (_createCache_merged) {
      if (_createCache_merged.containsKey(_cacheKey)) {
        return _createCache_merged.get(_cacheKey);
      }
      ArchitectureDomain _createArchitectureDomain = ArchitectureDomainRule.factory.createArchitectureDomain();
      _result = _createArchitectureDomain;
      _createCache_merged.put(_cacheKey, _result);
    }
    _init_merged(_result, domain);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureDomain> _createCache_merged = CollectionLiterals.newHashMap();

  private void _init_merged(final ArchitectureDomain it, final ArchitectureDomain domain) {
    Set<ArchitectureDomain> _of = Set.<ArchitectureDomain>of(domain);
    Iterable<ArchitectureDomain> _allExtensions = this.allExtensions(domain);
    final Function0<ArchitectureDomain> _function = () -> {
      ArchitectureDomain _copy = this._architectureExtensions.<ArchitectureDomain>copy(it, domain);
      final Procedure1<ArchitectureDomain> _function_1 = (ArchitectureDomain result) -> {
        EList<Concern> _concerns = it.getConcerns();
        final Function1<ArchitectureDomain, EList<Concern>> _function_2 = (ArchitectureDomain it_1) -> {
          return it_1.getConcerns();
        };
        final Function1<Concern, String> _function_3 = (Concern it_1) -> {
          return it_1.getName();
        };
        final Function1<String, Concern> _function_4 = (String it_1) -> {
          return this._architectureExtensions.mergedConcern(it_1);
        };
        Iterable<Concern> _map = IterableExtensions.<String, Concern>map(this._architectureExtensions.<Concern, String>mapUnique(IterableExtensions.flatMap(this._architectureExtensions.currentScope(), _function_2), _function_3), _function_4);
        Iterables.<Concern>addAll(_concerns, _map);
        EList<Stakeholder> _stakeholders = it.getStakeholders();
        final Function1<ArchitectureDomain, EList<Stakeholder>> _function_5 = (ArchitectureDomain it_1) -> {
          return it_1.getStakeholders();
        };
        final Function1<Stakeholder, String> _function_6 = (Stakeholder it_1) -> {
          return it_1.getName();
        };
        final Function1<String, Stakeholder> _function_7 = (String it_1) -> {
          return this._architectureExtensions.mergedStakeholder(it_1);
        };
        Iterable<Stakeholder> _map_1 = IterableExtensions.<String, Stakeholder>map(this._architectureExtensions.<Stakeholder, String>mapUnique(IterableExtensions.flatMap(this._architectureExtensions.currentScope(), _function_5), _function_6), _function_7);
        Iterables.<Stakeholder>addAll(_stakeholders, _map_1);
        EList<ArchitectureContext> _contexts = it.getContexts();
        final Function1<ArchitectureContext, Boolean> _function_8 = (ArchitectureContext it_1) -> {
          return Boolean.valueOf(it_1.isExtension());
        };
        final Function1<ArchitectureContext, ArchitectureContext> _function_9 = (ArchitectureContext it_1) -> {
          return this._architectureContextRule.merged(it_1);
        };
        Iterable<ArchitectureContext> _map_2 = IterableExtensions.<ArchitectureContext, ArchitectureContext>map(IterableExtensions.<ArchitectureContext>reject(this.allContexts(domain), _function_8), _function_9);
        Iterables.<ArchitectureContext>addAll(_contexts, _map_2);
        final Consumer<ArchitectureDomain> _function_10 = (ArchitectureDomain it_1) -> {
          this._architectureExtensions.<ArchitectureDomain>traceTo(result, it_1);
        };
        this.allExtensions(domain).forEach(_function_10);
      };
      return ObjectExtensions.<ArchitectureDomain>operator_doubleArrow(_copy, _function_1);
    };
    this._architectureExtensions.<ArchitectureDomain>withScope(Iterables.<ArchitectureDomain>concat(_of, _allExtensions), _function);
  }

  /**
   * For all of the contexts in the given {@code domain} that do not have explicit inheritance
   * or extension relationships, infer extension relationships to the most appropriate other context.
   */
  public void inferExtensions(final ArchitectureDomain domain) {
    final Function1<ArchitectureContext, Boolean> _function = (ArchitectureContext it) -> {
      return Boolean.valueOf(this._architectureContextInheritanceRule.legacyContext(it));
    };
    final Consumer<ArchitectureContext> _function_1 = (ArchitectureContext it) -> {
      this._architectureContextRule.inferExtensions(it);
    };
    IterableExtensions.<ArchitectureContext>filter(domain.getContexts(), _function).forEach(_function_1);
  }
}
