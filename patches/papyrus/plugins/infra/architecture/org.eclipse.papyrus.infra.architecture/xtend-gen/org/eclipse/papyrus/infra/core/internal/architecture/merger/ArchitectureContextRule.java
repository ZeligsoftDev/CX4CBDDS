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

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.TreeViewerConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Extension merge rule for {@link ArchitectureContext}s.
 */
@Singleton
@SuppressWarnings("all")
public class ArchitectureContextRule {
  @Extension
  private static ArchitectureFactory factory = ArchitectureFactory.eINSTANCE;

  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private ArchitectureViewpointRule _architectureViewpointRule;

  @Inject
  @Extension
  private RepresentationKindRule _representationKindRule;

  public boolean hasExtensions(final ArchitectureContext context) {
    return this._architectureExtensions.isReferenced(context, ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS);
  }

  public boolean canExtend(final ArchitectureContext extending, final ArchitectureContext extended) {
    EClass _eClass = extending.eClass();
    EClass _eClass_1 = extended.eClass();
    return (_eClass == _eClass_1);
  }

  /**
   * Query the set of contexts that have extension relationships targeting this context (not recursive).
   */
  public <T extends ArchitectureContext> Iterable<T> extensions(final T context) {
    Iterable<T> _xifexpression = null;
    boolean _inExtensionsPhase = this._architectureExtensions.inExtensionsPhase();
    if (_inExtensionsPhase) {
      final Function1<T, Boolean> _function = (T it) -> {
        return Boolean.valueOf(this.canExtend(context, it));
      };
      _xifexpression = IterableExtensions.<T>filter(this._architectureExtensions.<T>invert(context, ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS), _function);
    } else {
      _xifexpression = CollectionLiterals.<T>emptyList();
    }
    return _xifexpression;
  }

  /**
   * Query the set of all contexts that extend this context directly or indirectly (recursively).
   */
  public <T extends ArchitectureContext> List<T> allExtensions(final T context) {
    List<T> _xifexpression = null;
    boolean _inExtensionsPhase = this._architectureExtensions.inExtensionsPhase();
    if (_inExtensionsPhase) {
      _xifexpression = IterableExtensions.<T>toList(this.<T>allExtensionsHelper(context, CollectionLiterals.<T>newLinkedHashSet()));
    } else {
      _xifexpression = CollectionLiterals.<T>emptyList();
    }
    return _xifexpression;
  }

  private <T extends ArchitectureContext> Iterable<T> allExtensionsHelper(final T context, final Set<T> result) {
    Set<T> _xblockexpression = null;
    {
      final Function1<T, Boolean> _function = (T it) -> {
        return Boolean.valueOf(result.contains(it));
      };
      final Consumer<T> _function_1 = (T it) -> {
        result.add(it);
        this.<T>allExtensionsHelper(it, result);
      };
      IterableExtensions.<T>reject(this.<T>extensions(context), _function).forEach(_function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  /**
   * Obtain the product of merging extension content (if any) into this context, if not previously merged.
   * if previously merged, the previous merge result is returned.
   */
  protected ArchitectureContext _merged(final ArchitectureDescriptionLanguage context) {
    return this.mergedADL(context);
  }

  private ArchitectureDescriptionLanguage mergedADL(final ArchitectureDescriptionLanguage context) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(context);
    final ArchitectureDescriptionLanguage _result;
    synchronized (_createCache_mergedADL) {
      if (_createCache_mergedADL.containsKey(_cacheKey)) {
        return _createCache_mergedADL.get(_cacheKey);
      }
      ArchitectureDescriptionLanguage _createArchitectureDescriptionLanguage = ArchitectureContextRule.factory.createArchitectureDescriptionLanguage();
      _result = _createArchitectureDescriptionLanguage;
      _createCache_mergedADL.put(_cacheKey, _result);
    }
    _init_mergedADL(_result, context);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureDescriptionLanguage> _createCache_mergedADL = CollectionLiterals.newHashMap();

  private void _init_mergedADL(final ArchitectureDescriptionLanguage it, final ArchitectureDescriptionLanguage context) {
    this.<ArchitectureDescriptionLanguage>merge(it, context);
  }

  /**
   * Merge the source context and all of its extensions into the newly created target context.
   */
  <T extends ArchitectureContext> Set<T> merge(final T target, final T source) {
    Set<T> _of = Set.<T>of(source);
    List<T> _allExtensions = this.<T>allExtensions(source);
    Set<T> _set = IterableExtensions.<T>toSet(Iterables.<T>concat(_of, _allExtensions));
    final Procedure1<Set<T>> _function = (Set<T> it) -> {
      final Consumer<T> _function_1 = (T it_1) -> {
        this.copyContext(target, it_1);
      };
      it.forEach(_function_1);
      this.mergeViewpoints(target, it);
      ArchitectureExtensions.logf("Merged %s into %s", source, target);
    };
    return ObjectExtensions.<Set<T>>operator_doubleArrow(_set, _function);
  }

  private ArchitectureContext _mergeViewpoints(final ArchitectureDescriptionLanguage target, final Set<? extends ArchitectureContext> sources) {
    return this.mergeContextViewPoints(target, sources);
  }

  private ArchitectureContext _mergeViewpoints(final ArchitectureContext target, final Set<? extends ArchitectureContext> sources) {
    return this.mergeContextViewPoints(target, sources);
  }

  private ArchitectureContext mergeContextViewPoints(final ArchitectureContext target, final Set<? extends ArchitectureContext> sources) {
    final Procedure1<ArchitectureContext> _function = (ArchitectureContext it) -> {
      final Function1<ArchitectureContext, EList<ArchitectureViewpoint>> _function_1 = (ArchitectureContext it_1) -> {
        return it_1.getViewpoints();
      };
      final Iterable<ArchitectureViewpoint> allViewpoints = IterableExtensions.flatMap(sources, _function_1);
      EList<ArchitectureViewpoint> _viewpoints = it.getViewpoints();
      final Function1<ArchitectureViewpoint, String> _function_2 = (ArchitectureViewpoint it_1) -> {
        return it_1.getName();
      };
      final Function1<String, ArchitectureViewpoint> _function_3 = (String it_1) -> {
        return this._architectureViewpointRule.mergedViewpoint(it_1, sources);
      };
      Iterable<ArchitectureViewpoint> _map = IterableExtensions.<String, ArchitectureViewpoint>map(this._architectureExtensions.<ArchitectureViewpoint, String>mapUnique(allViewpoints, _function_2), _function_3);
      Iterables.<ArchitectureViewpoint>addAll(_viewpoints, _map);
      final Function1<ArchitectureContext, EList<ArchitectureViewpoint>> _function_4 = (ArchitectureContext it_1) -> {
        return it_1.getDefaultViewpoints();
      };
      final Iterable<ArchitectureViewpoint> allDefaults = IterableExtensions.flatMap(sources, _function_4);
      boolean _isEmpty = IterableExtensions.isEmpty(allDefaults);
      boolean _not = (!_isEmpty);
      if (_not) {
        final Function1<ArchitectureViewpoint, String> _function_5 = (ArchitectureViewpoint it_1) -> {
          return it_1.getName();
        };
        final Function1<ArchitectureViewpoint, ArchitectureViewpoint> _function_6 = (ArchitectureViewpoint it_1) -> {
          return it_1;
        };
        final Map<String, ArchitectureViewpoint> viewpointsByName = IterableExtensions.<ArchitectureViewpoint, String, ArchitectureViewpoint>toMap(it.getViewpoints(), _function_5, _function_6);
        EList<ArchitectureViewpoint> _defaultViewpoints = it.getDefaultViewpoints();
        final Function1<ArchitectureViewpoint, String> _function_7 = (ArchitectureViewpoint it_1) -> {
          return it_1.getName();
        };
        final Function1<String, ArchitectureViewpoint> _function_8 = (String it_1) -> {
          return viewpointsByName.get(it_1);
        };
        Iterable<ArchitectureViewpoint> _filterNull = IterableExtensions.<ArchitectureViewpoint>filterNull(IterableExtensions.<String, ArchitectureViewpoint>map(this._architectureExtensions.<ArchitectureViewpoint, String>mapUnique(allDefaults, _function_7), _function_8));
        Iterables.<ArchitectureViewpoint>addAll(_defaultViewpoints, _filterNull);
      }
    };
    return ObjectExtensions.<ArchitectureContext>operator_doubleArrow(target, _function);
  }

  /**
   * Obtain the product of merging extension content (if any) into this context, if not previously merged.
   * if previously merged, the previous merge result is returned.
   */
  protected ArchitectureContext _merged(final ArchitectureFramework context) {
    return this.merged(context, this._architectureExtensions.currentScope());
  }

  private ArchitectureFramework merged(final ArchitectureFramework context, final Object scope) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(context, scope);
    final ArchitectureFramework _result;
    synchronized (_createCache_merged) {
      if (_createCache_merged.containsKey(_cacheKey)) {
        return _createCache_merged.get(_cacheKey);
      }
      ArchitectureFramework _createArchitectureFramework = ArchitectureContextRule.factory.createArchitectureFramework();
      _result = _createArchitectureFramework;
      _createCache_merged.put(_cacheKey, _result);
    }
    _init_merged(_result, context, scope);
    return _result;
  }

  private final HashMap<ArrayList<?>, ArchitectureFramework> _createCache_merged = CollectionLiterals.newHashMap();

  private void _init_merged(final ArchitectureFramework it, final ArchitectureFramework context, final Object scope) {
    this.<ArchitectureFramework>merge(it, context);
  }

  private ArchitectureContext copyContext(final ArchitectureContext target, final ArchitectureContext source) {
    return this.<ArchitectureContext>copyContext(target, source, this.contextCopier(target));
  }

  /**
   * Copy definitions from a source context into the target, with optional additional processing of extension
   * content as applicable to the context type (ADLs have more to merge than AFs).
   */
  private <T extends ArchitectureContext> T copyContext(final T target, final T source, final Consumer<? super T> extensionMerger) {
    final Procedure1<T> _function = (T it) -> {
      this._architectureExtensions.<T>copy(it, source);
      String _elvis = null;
      String _creationCommandClass = it.getCreationCommandClass();
      if (_creationCommandClass != null) {
        _elvis = _creationCommandClass;
      } else {
        String _creationCommandClass_1 = source.getCreationCommandClass();
        _elvis = _creationCommandClass_1;
      }
      it.setCreationCommandClass(_elvis);
      String _elvis_1 = null;
      String _conversionCommandClass = it.getConversionCommandClass();
      if (_conversionCommandClass != null) {
        _elvis_1 = _conversionCommandClass;
      } else {
        String _conversionCommandClass_1 = source.getConversionCommandClass();
        _elvis_1 = _conversionCommandClass_1;
      }
      it.setConversionCommandClass(_elvis_1);
      String _elvis_2 = null;
      String _extensionPrefix = it.getExtensionPrefix();
      if (_extensionPrefix != null) {
        _elvis_2 = _extensionPrefix;
      } else {
        String _extensionPrefix_1 = source.getExtensionPrefix();
        _elvis_2 = _extensionPrefix_1;
      }
      it.setExtensionPrefix(_elvis_2);
      EList<ElementTypeSetConfiguration> _elementTypes = it.getElementTypes();
      EList<ElementTypeSetConfiguration> _elementTypes_1 = source.getElementTypes();
      Iterables.<ElementTypeSetConfiguration>addAll(_elementTypes, _elementTypes_1);
      if ((extensionMerger != null)) {
        extensionMerger.accept(source);
      }
    };
    return ObjectExtensions.<T>operator_doubleArrow(target, _function);
  }

  private Consumer<? super ArchitectureContext> _contextCopier(final ArchitectureDescriptionLanguage adl) {
    final Consumer<ArchitectureContext> _function = (ArchitectureContext source) -> {
      boolean _matched = false;
      if (source instanceof ArchitectureDescriptionLanguage) {
        if (Objects.equal(source, ((ArchitectureDescriptionLanguage)source))) {
          _matched=true;
          final Procedure1<ArchitectureDescriptionLanguage> _function_1 = (ArchitectureDescriptionLanguage it) -> {
            EList<RepresentationKind> _representationKinds = it.getRepresentationKinds();
            final Function1<RepresentationKind, RepresentationKind> _function_2 = (RepresentationKind it_1) -> {
              return this._representationKindRule.merged(it_1);
            };
            List<RepresentationKind> _map = ListExtensions.<RepresentationKind, RepresentationKind>map(((ArchitectureDescriptionLanguage)source).getRepresentationKinds(), _function_2);
            Iterables.<RepresentationKind>addAll(_representationKinds, _map);
            EList<TreeViewerConfiguration> _treeViewerConfigurations = it.getTreeViewerConfigurations();
            final Function1<TreeViewerConfiguration, TreeViewerConfiguration> _function_3 = (TreeViewerConfiguration it_1) -> {
              return this._architectureExtensions.merged(it_1);
            };
            List<TreeViewerConfiguration> _map_1 = ListExtensions.<TreeViewerConfiguration, TreeViewerConfiguration>map(((ArchitectureDescriptionLanguage)source).getTreeViewerConfigurations(), _function_3);
            Iterables.<TreeViewerConfiguration>addAll(_treeViewerConfigurations, _map_1);
            EPackage _elvis = null;
            EPackage _metamodel = it.getMetamodel();
            if (_metamodel != null) {
              _elvis = _metamodel;
            } else {
              EPackage _metamodel_1 = ((ArchitectureDescriptionLanguage)source).getMetamodel();
              _elvis = _metamodel_1;
            }
            it.setMetamodel(_elvis);
            EList<EPackage> _profiles = it.getProfiles();
            EList<EPackage> _profiles_1 = ((ArchitectureDescriptionLanguage)source).getProfiles();
            Iterables.<EPackage>addAll(_profiles, _profiles_1);
          };
          ObjectExtensions.<ArchitectureDescriptionLanguage>operator_doubleArrow(adl, _function_1);
        }
      }
    };
    return _function;
  }

  private Consumer<? super ArchitectureContext> _contextCopier(final ArchitectureContext context) {
    final Consumer<ArchitectureContext> _function = (ArchitectureContext source) -> {
      final Procedure1<ArchitectureContext> _function_1 = (ArchitectureContext it) -> {
      };
      ObjectExtensions.<ArchitectureContext>operator_doubleArrow(context, _function_1);
    };
    return _function;
  }

  /**
   * Infer an extension relationship to the most appropriate other context
   * of the same qualified name (if any). The most appropriate other context is the one that
   * {@linkplain ArchitectureContext#isCompatibleWith(ArchitectureContext) is compatible with it} and
   * that has the most other contexts extending it (either explicitly or implicitly).
   */
  public void inferExtensions(final ArchitectureContext context) {
    final Function1<ArchitectureContext, Boolean> _function = (ArchitectureContext it) -> {
      return Boolean.valueOf(this.canExtend(context, it));
    };
    final Consumer<ArchitectureContext> _function_1 = (ArchitectureContext it) -> {
      EList<ArchitectureContext> _extendedContexts = context.getExtendedContexts();
      _extendedContexts.add(it);
    };
    IterableExtensions.take(this._architectureExtensions.excluding(IterableExtensions.filter(this.sortedInstances(context.getClass(), context.getQualifiedName()), _function), context), 1).forEach(_function_1);
  }

  /**
   * Get contexts of the given {@code type} and qualified {@code name}
   * sorted by decreasing number of extensions contributing to it.
   */
  private List<? extends ArchitectureContext> sortedInstances(final Class<? extends ArchitectureContext> type, final String name) {
    final Function1<ArchitectureDomain, EList<ArchitectureContext>> _function = (ArchitectureDomain it) -> {
      return it.getContexts();
    };
    final Function1<ArchitectureContext, Boolean> _function_1 = (ArchitectureContext it) -> {
      String _qualifiedName = it.getQualifiedName();
      return Boolean.valueOf(Objects.equal(_qualifiedName, name));
    };
    final Function1<ArchitectureContext, Integer> _function_2 = (ArchitectureContext it) -> {
      return Integer.valueOf(this.<ArchitectureContext>allExtensions(it).size());
    };
    return ListExtensions.reverseView(IterableExtensions.sortBy(IterableExtensions.filter(Iterables.filter(IterableExtensions.flatMap(this._architectureExtensions.currentScope(), _function), type), _function_1), _function_2));
  }

  public ArchitectureContext merged(final ArchitectureContext context) {
    if (context instanceof ArchitectureDescriptionLanguage) {
      return _merged((ArchitectureDescriptionLanguage)context);
    } else if (context instanceof ArchitectureFramework) {
      return _merged((ArchitectureFramework)context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context).toString());
    }
  }

  private ArchitectureContext mergeViewpoints(final ArchitectureContext target, final Set<? extends ArchitectureContext> sources) {
    if (target instanceof ArchitectureDescriptionLanguage) {
      return _mergeViewpoints((ArchitectureDescriptionLanguage)target, sources);
    } else if (target != null) {
      return _mergeViewpoints(target, sources);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(target, sources).toString());
    }
  }

  private Consumer<? super ArchitectureContext> contextCopier(final ArchitectureContext adl) {
    if (adl instanceof ArchitectureDescriptionLanguage) {
      return _contextCopier((ArchitectureDescriptionLanguage)adl);
    } else if (adl != null) {
      return _contextCopier(adl);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(adl).toString());
    }
  }
}
