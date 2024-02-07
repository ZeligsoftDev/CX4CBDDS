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
import com.google.inject.Guice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureFramework;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Model-to-model transformation that generates merged <em>Architecture Description</em> model instances
 * from the input {@link ArchitectureDomain}s (which usually will be those that are registered with
 * the {@link ArchitectureDomainManager}).
 */
@Singleton
@SuppressWarnings("all")
public class InternalArchitectureDomainMerger {
  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private ArchitectureDomainRule _architectureDomainRule;

  @Inject
  @Extension
  private MergeState _mergeState;

  /**
   * Compute the merge of the given architecture {@code domains}. The result of the merge
   * is a new distinct architecture model spanning a subset of the given {@code domains}
   * that are merged according to extension relationships (explicit or implied by name)
   * of the architecture contexts that they define. Every architecture domain in the
   * result is contained in a resource with URI matching the resource URI of the
   * primary source-model domain to which it traces. And all of those resources are
   * collected in a {@link ResourceSet} independent of the source model's resource set.
   */
  public List<MergedArchitectureDomain> mergeDomains(final Iterable<? extends ArchitectureDomain> domains) {
    ArchitectureExtensions.logf("=== Merge starting ===");
    final ResourceSetImpl mergeableSet = new ResourceSetImpl();
    final Collection<ArchitectureDomain> mergeableDomains = this.copy(domains, mergeableSet);
    this._mergeState.advancePhase();
    final Consumer<ArchitectureDomain> _function = (ArchitectureDomain it) -> {
      this._architectureDomainRule.inherit(it);
    };
    mergeableDomains.forEach(_function);
    final Consumer<ArchitectureDomain> _function_1 = (ArchitectureDomain it) -> {
      this._architectureDomainRule.finalizeInheritance(it);
    };
    mergeableDomains.forEach(_function_1);
    this._mergeState.advancePhase();
    final Procedure0 _function_2 = () -> {
      final Consumer<ArchitectureDomain> _function_3 = (ArchitectureDomain it) -> {
        this._architectureDomainRule.inferExtensions(it);
      };
      mergeableDomains.forEach(_function_3);
    };
    this._architectureExtensions.withScope(mergeableDomains, _function_2);
    final ResourceSetImpl resourceSet = new ResourceSetImpl();
    resourceSet.setPackageRegistry(ResourceUtils.createWorkspaceAwarePackageRegistry());
    resourceSet.setURIConverter(ResourceUtils.createWorkspaceAwareURIConverter());
    final Function1<ArchitectureDomain, Boolean> _function_3 = (ArchitectureDomain it) -> {
      Resource _eResource = it.eResource();
      return Boolean.valueOf((_eResource == null));
    };
    final Function1<ArchitectureDomain, URI> _function_4 = (ArchitectureDomain it) -> {
      return it.eResource().getURI();
    };
    final Function1<ArchitectureDomain, Resource> _function_5 = (ArchitectureDomain it) -> {
      return resourceSet.createResource(it.eResource().getURI());
    };
    final Map<URI, Resource> mergedResources = IterableExtensions.<ArchitectureDomain, URI, Resource>toMap(IterableExtensions.<ArchitectureDomain>reject(mergeableDomains, _function_3), _function_4, _function_5);
    this._mergeState.advancePhase();
    final Function1<ArchitectureDomain, Boolean> _function_6 = (ArchitectureDomain it) -> {
      return Boolean.valueOf(this._architectureDomainRule.isExtension(it));
    };
    final Function1<ArchitectureDomain, ArchitectureDomain> _function_7 = (ArchitectureDomain it) -> {
      return this._architectureDomainRule.merged(it);
    };
    final List<ArchitectureDomain> mergedDomains = IterableExtensions.<ArchitectureDomain>toList(IterableExtensions.<ArchitectureDomain, ArchitectureDomain>map(IterableExtensions.<ArchitectureDomain>reject(mergeableDomains, _function_6), _function_7));
    this._mergeState.advancePhase();
    EMFHelper.unload(mergeableSet);
    final Function1<ArchitectureDomain, Boolean> _function_8 = (ArchitectureDomain it) -> {
      return Boolean.valueOf(this._architectureDomainRule.hasContexts(it));
    };
    final Function1<ArchitectureDomain, MergedArchitectureDomain> _function_9 = (ArchitectureDomain it) -> {
      return this.toMergedArchitectureDomain(it, mergedResources);
    };
    return IterableExtensions.<MergedArchitectureDomain>toList(IterableExtensions.<ArchitectureDomain, MergedArchitectureDomain>map(IterableExtensions.<ArchitectureDomain>filter(mergedDomains, _function_8), _function_9));
  }

  private MergedArchitectureDomain toMergedArchitectureDomain(final ArchitectureDomain domain, final Map<URI, Resource> resources) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(domain, resources);
    final MergedArchitectureDomain _result;
    synchronized (_createCache_toMergedArchitectureDomain) {
      if (_createCache_toMergedArchitectureDomain.containsKey(_cacheKey)) {
        return _createCache_toMergedArchitectureDomain.get(_cacheKey);
      }
      MergedArchitectureDomain _mergedArchitectureDomain = new MergedArchitectureDomain(domain);
      _result = _mergedArchitectureDomain;
      _createCache_toMergedArchitectureDomain.put(_cacheKey, _result);
    }
    _init_toMergedArchitectureDomain(_result, domain, resources);
    return _result;
  }

  private final HashMap<ArrayList<?>, MergedArchitectureDomain> _createCache_toMergedArchitectureDomain = CollectionLiterals.newHashMap();

  private void _init_toMergedArchitectureDomain(final MergedArchitectureDomain result, final ArchitectureDomain domain, final Map<URI, Resource> resources) {
    ArchitectureDomain _trace = this._architectureExtensions.<ArchitectureDomain>trace(domain);
    Resource _eResource = null;
    if (_trace!=null) {
      _eResource=_trace.eResource();
    }
    URI _uRI = null;
    if (_eResource!=null) {
      _uRI=_eResource.getURI();
    }
    Resource _get = resources.get(_uRI);
    EList<EObject> _contents = null;
    if (_get!=null) {
      _contents=_get.getContents();
    }
    if (_contents!=null) {
      _contents.add(domain);
    }
    ArchitectureExtensions.logf("Merge result: %s.", domain);
    final Consumer<ArchitectureContext> _function = (ArchitectureContext it) -> {
      this.toMergedArchitectureContext(it, result);
    };
    domain.getContexts().forEach(_function);
  }

  private MergedArchitectureContext _toMergedArchitectureContext(final ArchitectureDescriptionLanguage context, final MergedArchitectureDomain domain) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(context, domain);
    final MergedArchitectureDescriptionLanguage _result;
    synchronized (_createCache_toMergedArchitectureContext) {
      if (_createCache_toMergedArchitectureContext.containsKey(_cacheKey)) {
        return _createCache_toMergedArchitectureContext.get(_cacheKey);
      }
      MergedArchitectureDescriptionLanguage _mergedArchitectureDescriptionLanguage = new MergedArchitectureDescriptionLanguage(domain, context);
      _result = _mergedArchitectureDescriptionLanguage;
      _createCache_toMergedArchitectureContext.put(_cacheKey, _result);
    }
    _init_toMergedArchitectureContext(_result, context, domain);
    return _result;
  }

  private final HashMap<ArrayList<?>, MergedArchitectureContext> _createCache_toMergedArchitectureContext = CollectionLiterals.newHashMap();

  private void _init_toMergedArchitectureContext(final MergedArchitectureDescriptionLanguage result, final ArchitectureDescriptionLanguage context, final MergedArchitectureDomain domain) {
    ArchitectureExtensions.logf("Merge result: %.60s.", context);
    final Consumer<ArchitectureViewpoint> _function = (ArchitectureViewpoint it) -> {
      this.toMergedArchitectureViewpoint(it, result);
    };
    context.getViewpoints().forEach(_function);
  }

  private MergedArchitectureContext _toMergedArchitectureContext(final ArchitectureFramework context, final MergedArchitectureDomain domain) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(context, domain);
    final MergedArchitectureFramework _result;
    synchronized (_createCache_toMergedArchitectureContext_1) {
      if (_createCache_toMergedArchitectureContext_1.containsKey(_cacheKey)) {
        return _createCache_toMergedArchitectureContext_1.get(_cacheKey);
      }
      MergedArchitectureFramework _mergedArchitectureFramework = new MergedArchitectureFramework(domain, context);
      _result = _mergedArchitectureFramework;
      _createCache_toMergedArchitectureContext_1.put(_cacheKey, _result);
    }
    _init_toMergedArchitectureContext_1(_result, context, domain);
    return _result;
  }

  private final HashMap<ArrayList<?>, MergedArchitectureContext> _createCache_toMergedArchitectureContext_1 = CollectionLiterals.newHashMap();

  private void _init_toMergedArchitectureContext_1(final MergedArchitectureFramework result, final ArchitectureFramework context, final MergedArchitectureDomain domain) {
    ArchitectureExtensions.logf("Merge result: %.60s.", context);
    final Consumer<ArchitectureViewpoint> _function = (ArchitectureViewpoint it) -> {
      this.toMergedArchitectureViewpoint(it, result);
    };
    context.getViewpoints().forEach(_function);
  }

  private MergedArchitectureViewpoint toMergedArchitectureViewpoint(final ArchitectureViewpoint viewpoint, final MergedArchitectureContext context) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(viewpoint, context);
    final MergedArchitectureViewpoint _result;
    synchronized (_createCache_toMergedArchitectureViewpoint) {
      if (_createCache_toMergedArchitectureViewpoint.containsKey(_cacheKey)) {
        return _createCache_toMergedArchitectureViewpoint.get(_cacheKey);
      }
      MergedArchitectureViewpoint _mergedArchitectureViewpoint = new MergedArchitectureViewpoint(context, viewpoint);
      _result = _mergedArchitectureViewpoint;
      _createCache_toMergedArchitectureViewpoint.put(_cacheKey, _result);
    }
    _init_toMergedArchitectureViewpoint(_result, viewpoint, context);
    return _result;
  }

  private final HashMap<ArrayList<?>, MergedArchitectureViewpoint> _createCache_toMergedArchitectureViewpoint = CollectionLiterals.newHashMap();

  private void _init_toMergedArchitectureViewpoint(final MergedArchitectureViewpoint result, final ArchitectureViewpoint viewpoint, final MergedArchitectureContext context) {
    final StringBuilder representations = new StringBuilder();
    final Formatter formatter = new Formatter(representations);
    final Consumer<RepresentationKind> _function = (RepresentationKind it) -> {
      int _length = representations.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        formatter.format(", ");
      }
      formatter.format("%.20s", this._architectureExtensions.formatted(it));
    };
    viewpoint.getRepresentationKinds().forEach(_function);
    ArchitectureExtensions.logf("Merge result: %.60s -- %s.", viewpoint, representations);
  }

  /**
   * Copy the source architecture {@code domains} into a new, independent resource set.
   * This ensures that inheritance can be processed in-place, and new context extension
   * relationships inferred in-place, without disturbing the source model.
   */
  private Collection<ArchitectureDomain> copy(final Iterable<? extends ArchitectureDomain> domains, final ResourceSet resourceSet) {
    Collection<ArchitectureDomain> _xblockexpression = null;
    {
      ArchitectureExtensions.logf("Copying source domains %s.", domains);
      final EcoreUtil.Copier copier = new EcoreUtil.Copier() {
        @Override
        public EObject copy(final EObject eObject) {
          EObject _copy = super.copy(eObject);
          final Procedure1<EObject> _function = (EObject it) -> {
            boolean _matched = false;
            if (it instanceof ADElement) {
              _matched=true;
              InternalArchitectureDomainMerger.this._architectureExtensions.<ADElement>traceTo(((ADElement)it), ((ADElement) eObject));
            }
          };
          return ObjectExtensions.<EObject>operator_doubleArrow(_copy, _function);
        }
      };
      final Collection<ArchitectureDomain> result = copier.<ArchitectureDomain>copyAll(IterableExtensions.toSet(domains));
      copier.copyReferences();
      final Function1<ArchitectureDomain, Boolean> _function = (ArchitectureDomain it) -> {
        Resource _eResource = it.eResource();
        return Boolean.valueOf((_eResource == null));
      };
      final Consumer<ArchitectureDomain> _function_1 = (ArchitectureDomain orig) -> {
        EList<EObject> _contents = resourceSet.createResource(orig.eResource().getURI()).getContents();
        EObject _get = copier.get(orig);
        _contents.add(_get);
      };
      IterableExtensions.reject(domains, _function).forEach(_function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  /**
   * Create a new architecture domain merger configured with the default injection bindings.
   */
  public static InternalArchitectureDomainMerger newInstance() {
    ArchitectureMergerModule _architectureMergerModule = new ArchitectureMergerModule();
    return InternalArchitectureDomainMerger.newInstance(_architectureMergerModule);
  }

  /**
   * Create a new architecture domain merger configured with the given injection bindings.
   */
  public static InternalArchitectureDomainMerger newInstance(final AbstractModule module) {
    return Guice.createInjector(module).<InternalArchitectureDomainMerger>getInstance(InternalArchitectureDomainMerger.class);
  }

  private MergedArchitectureContext toMergedArchitectureContext(final ArchitectureContext context, final MergedArchitectureDomain domain) {
    if (context instanceof ArchitectureDescriptionLanguage) {
      return _toMergedArchitectureContext((ArchitectureDescriptionLanguage)context, domain);
    } else if (context instanceof ArchitectureFramework) {
      return _toMergedArchitectureContext((ArchitectureFramework)context, domain);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, domain).toString());
    }
  }
}
