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
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.architecture.Activator;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;
import org.eclipse.papyrus.infra.core.architecture.TreeViewerConfiguration;
import org.eclipse.papyrus.infra.core.architecture.util.FormattableADElement;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Utility extensions for the <em>Architecture Description</em> model.
 */
@Singleton
@SuppressWarnings("all")
public class ArchitectureExtensions {
  @Extension
  private static ArchitectureFactory factory = ArchitectureFactory.eINSTANCE;

  @Inject
  @Named(ArchitectureMergerModule.MERGE_TRACE)
  private BiConsumer<? super ADElement, ? super ADElement> mergeTrace;

  @Inject
  @Extension
  private MergeState _mergeState;

  /**
   * A custom cross-reference adapter that propagates itself up the content tree as well as down.
   */
  private final ECrossReferenceAdapter xrefAdapter = new ECrossReferenceAdapter() {
    @Override
    protected void setTarget(final Resource target) {
      super.setTarget(target);
      ResourceSet _resourceSet = target.getResourceSet();
      if (_resourceSet!=null) {
        this.addAdapter(_resourceSet);
      }
    }

    @Override
    protected void setTarget(final EObject target) {
      super.setTarget(target);
      if ((!this.iterating)) {
        final Procedure1<InternalEObject> _function = (InternalEObject it) -> {
          Resource.Internal _eDirectResource = it.eDirectResource();
          if (_eDirectResource!=null) {
            this.addAdapter(_eDirectResource);
          }
          InternalEObject _eInternalContainer = it.eInternalContainer();
          if (_eInternalContainer!=null) {
            this.addAdapter(_eInternalContainer);
          }
        };
        ObjectExtensions.<InternalEObject>operator_doubleArrow(
          ((InternalEObject) target), _function);
      }
    }
  };

  private ECrossReferenceAdapter xrefs(final EObject object) {
    ECrossReferenceAdapter _elvis = null;
    ECrossReferenceAdapter _crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
    if (_crossReferenceAdapter != null) {
      _elvis = _crossReferenceAdapter;
    } else {
      final Procedure1<ECrossReferenceAdapter> _function = (ECrossReferenceAdapter it) -> {
        EList<Adapter> _eAdapters = object.eAdapters();
        _eAdapters.add(it);
      };
      ECrossReferenceAdapter _doubleArrow = ObjectExtensions.<ECrossReferenceAdapter>operator_doubleArrow(this.xrefAdapter, _function);
      _elvis = _doubleArrow;
    }
    return _elvis;
  }

  /**
   * Query referencers to an object via the given reference.
   */
  public <T extends EObject> Iterable<T> invert(final EObject target, final EReference reference) {
    final Function1<EStructuralFeature.Setting, T> _function = (EStructuralFeature.Setting it) -> {
      EObject _eObject = it.getEObject();
      return ((T) _eObject);
    };
    return IterableExtensions.<EStructuralFeature.Setting, T>map(this.xrefs(target).getInverseReferences(target, reference, true), _function);
  }

  /**
   * Query whether any other object references the given object via some reference.
   */
  public boolean isReferenced(final EObject target, final EReference reference) {
    boolean _isEmpty = this.xrefs(target).getInverseReferences(target, reference, true).isEmpty();
    return (!_isEmpty);
  }

  /**
   * Get the first source element that was merged into the given output.
   */
  public <T extends ADElement> T trace(final T mergedElement) {
    MergeTraceAdapter _mergeTraces = MergeTraceAdapter.getMergeTraces(mergedElement);
    Collection<? extends ADElement> _trace = null;
    if (_mergeTraces!=null) {
      _trace=_mergeTraces.trace(mergedElement);
    }
    ADElement _head = IterableExtensions.head(_trace);
    return ((T) _head);
  }

  /**
   * Get a feature of an object as a list, even if it isn't a list.
   */
  public <T extends Object> EList<T> eGetAsList(final EObject owner, final EStructuralFeature feature, final Class<T> type) {
    EList<T> _xifexpression = null;
    boolean _isMany = feature.isMany();
    if (_isMany) {
      Object _eGet = owner.eGet(feature);
      _xifexpression = ((EList<T>) _eGet);
    } else {
      int _xifexpression_1 = (int) 0;
      Object _eGet_1 = owner.eGet(feature);
      boolean _tripleEquals = (_eGet_1 == null);
      if (_tripleEquals) {
        _xifexpression_1 = 0;
      } else {
        _xifexpression_1 = 1;
      }
      Object _eGet_2 = owner.eGet(feature);
      _xifexpression = new BasicEList<T>(_xifexpression_1, new Object[] { _eGet_2 }) {
        @Override
        protected void didAdd(final int index, final Object newObject) {
          if ((index == 0)) {
            owner.eSet(feature, newObject);
          }
        }

        @Override
        protected void didSet(final int index, final Object newObject, final Object oldObject) {
          if ((index == 0)) {
            owner.eSet(feature, newObject);
          }
        }

        @Override
        protected void didRemove(final int index, final Object oldObject) {
          if ((index == 0)) {
            boolean _isEmpty = this.isEmpty();
            if (_isEmpty) {
              owner.eSet(feature, null);
            } else {
              owner.eSet(feature, this.get(0));
            }
          }
        }

        @Override
        protected void didClear(final int size, final Object[] oldObjects) {
          owner.eSet(feature, null);
        }

        @Override
        protected void didMove(final int index, final Object movedObject, final int oldIndex) {
          if ((index == 0)) {
            owner.eSet(feature, movedObject);
          }
        }
      };
    }
    return _xifexpression;
  }

  /**
   * Create a trace relationship from a target model element to the source model element
   * that it derives from, which usually is some merge, for inheritance or for extension.
   */
  public <T extends ADElement> void traceTo(final T target, final T source) {
    this.mergeTrace.accept(target, source);
  }

  /**
   * Log a merge tracing message.
   */
  static void logf(final String pattern, final Object... arg) {
    boolean _isTraceEnabled = Activator.log.isTraceEnabled(Activator.DEBUG_MERGE);
    if (_isTraceEnabled) {
      Activator.log.trace(Activator.DEBUG_MERGE, String.format(pattern, FormattableADElement.wrapAll(arg)));
    }
  }

  /**
   * A model element formatted suitably for printing.
   */
  public Object formatted(final ADElement element) {
    return FormattableADElement.wrap(element);
  }

  /**
   * Copy the basic attributes of a target object, for which it does not already have a vakye, from some source.
   * As a side-effect a trace relationship is recorded.
   * 
   * @see #traceTo(ADElement, ADElement)
   */
  public <T extends ADElement> T copy(final T target, final T source) {
    T _xblockexpression = null;
    {
      String _elvis = null;
      String _name = target.getName();
      if (_name != null) {
        _elvis = _name;
      } else {
        String _name_1 = source.getName();
        _elvis = _name_1;
      }
      target.setName(_elvis);
      String _elvis_1 = null;
      String _id = target.getId();
      if (_id != null) {
        _elvis_1 = _id;
      } else {
        String _id_1 = source.getId();
        _elvis_1 = _id_1;
      }
      target.setId(_elvis_1);
      String _elvis_2 = null;
      String _description = target.getDescription();
      if (_description != null) {
        _elvis_2 = _description;
      } else {
        String _description_1 = source.getDescription();
        _elvis_2 = _description_1;
      }
      target.setDescription(_elvis_2);
      String _elvis_3 = null;
      String _icon = target.getIcon();
      if (_icon != null) {
        _elvis_3 = _icon;
      } else {
        String _icon_1 = source.getIcon();
        _elvis_3 = _icon_1;
      }
      target.setIcon(_elvis_3);
      this.<T>traceTo(target, source);
      _xblockexpression = target;
    }
    return _xblockexpression;
  }

  /**
   * Obtain the merge result for a stakeholder owned by merged domains. Stakeholders are merged by name.
   * If merged previously, that previous merge result is returned.
   */
  public Stakeholder mergedStakeholder(final String name) {
    return this.mergedStakeholder(name, this.currentScope());
  }

  private Stakeholder mergedStakeholder(final String name, final Object scope) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(name, scope);
    final Stakeholder _result;
    synchronized (_createCache_mergedStakeholder) {
      if (_createCache_mergedStakeholder.containsKey(_cacheKey)) {
        return _createCache_mergedStakeholder.get(_cacheKey);
      }
      Stakeholder _createStakeholder = ArchitectureExtensions.factory.createStakeholder();
      _result = _createStakeholder;
      _createCache_mergedStakeholder.put(_cacheKey, _result);
    }
    _init_mergedStakeholder(_result, name, scope);
    return _result;
  }

  private final HashMap<ArrayList<?>, Stakeholder> _createCache_mergedStakeholder = CollectionLiterals.newHashMap();

  private void _init_mergedStakeholder(final Stakeholder result, final String name, final Object scope) {
    final Function1<ArchitectureDomain, EList<Stakeholder>> _function = (ArchitectureDomain it) -> {
      return it.getStakeholders();
    };
    final Function1<Stakeholder, Boolean> _function_1 = (Stakeholder it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    final Consumer<Stakeholder> _function_2 = (Stakeholder it) -> {
      this.<Stakeholder>copy(result, it);
      EList<Concern> _concerns = result.getConcerns();
      final Function1<Concern, String> _function_3 = (Concern it_1) -> {
        return it_1.getName();
      };
      final Function1<String, Concern> _function_4 = (String it_1) -> {
        return this.mergedConcern(it_1);
      };
      Iterable<Concern> _map = IterableExtensions.<String, Concern>map(this.<Concern, String>mapUnique(it.getConcerns(), _function_3), _function_4);
      Iterables.<Concern>addAll(_concerns, _map);
      ArchitectureExtensions.logf("Merged %s into %s", it, result);
    };
    IterableExtensions.<Stakeholder>filter(IterableExtensions.flatMap(this.currentScope(), _function), _function_1).forEach(_function_2);
  }

  /**
   * Obtain the merge result for a concern owned by merged domains and possibly referenced by merged
   * viewpoints and representation kinds. Concerns are merged by name. If merged previously, that
   * previous merge result is returned.
   */
  public Concern mergedConcern(final String name) {
    return this.mergedConcern(name, this.currentScope());
  }

  private Concern mergedConcern(final String name, final Object scope) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(name, scope);
    final Concern _result;
    synchronized (_createCache_mergedConcern) {
      if (_createCache_mergedConcern.containsKey(_cacheKey)) {
        return _createCache_mergedConcern.get(_cacheKey);
      }
      Concern _createConcern = ArchitectureExtensions.factory.createConcern();
      _result = _createConcern;
      _createCache_mergedConcern.put(_cacheKey, _result);
    }
    _init_mergedConcern(_result, name, scope);
    return _result;
  }

  private final HashMap<ArrayList<?>, Concern> _createCache_mergedConcern = CollectionLiterals.newHashMap();

  private void _init_mergedConcern(final Concern result, final String name, final Object scope) {
    final Function1<ArchitectureDomain, EList<Concern>> _function = (ArchitectureDomain it) -> {
      return it.getConcerns();
    };
    final Function1<Concern, Boolean> _function_1 = (Concern it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    final Consumer<Concern> _function_2 = (Concern it) -> {
      this.<Concern>copy(result, it);
      ArchitectureExtensions.logf("Merged %s into %s", it, result);
    };
    IterableExtensions.<Concern>filter(IterableExtensions.flatMap(this.currentScope(), _function), _function_1).forEach(_function_2);
  }

  /**
   * Obtain the merge result for a tree viewer configuration in a merged context.
   * If merged previously, that previous merge result is returned.
   */
  public TreeViewerConfiguration merged(final TreeViewerConfiguration treeViewerConfig) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(treeViewerConfig);
    final TreeViewerConfiguration _result;
    synchronized (_createCache_merged) {
      if (_createCache_merged.containsKey(_cacheKey)) {
        return _createCache_merged.get(_cacheKey);
      }
      TreeViewerConfiguration _copy = EcoreUtil.<TreeViewerConfiguration>copy(treeViewerConfig);
      _result = _copy;
      _createCache_merged.put(_cacheKey, _result);
    }
    _init_merged(_result, treeViewerConfig);
    return _result;
  }

  private final HashMap<ArrayList<?>, TreeViewerConfiguration> _createCache_merged = CollectionLiterals.newHashMap();

  private void _init_merged(final TreeViewerConfiguration it, final TreeViewerConfiguration treeViewerConfig) {
  }

  /**
   * Query whether the merge algorithm is currently in the inheritance processing phase.
   * Only in the inheritance phase will queries about inheritance relationships return results.
   */
  public boolean inInheritancePhase() {
    MergePhase _phase = this._mergeState.phase();
    return (_phase == MergePhase.INHERITANCE);
  }

  /**
   * Query whether the merge algorithm is currently in the extensions processing phase,
   * either explicitly modelled or inferred by name.
   * Only in the extensions phase will queries about extension relationships return results.
   */
  public boolean inExtensionsPhase() {
    return ((this._mergeState.phase() == MergePhase.EXTENSIONS) || (this._mergeState.phase() == MergePhase.LEGACY));
  }

  /**
   * Query the set of architecture domains currently being merged, as implied by the contexts that they define.
   */
  public Set<? extends ArchitectureDomain> currentScope() {
    return this._mergeState.currentDomains();
  }

  /**
   * Execute a block of code in the scope of a set of domains being merged. For the duration of the
   * block, these domains will be the current scope.
   * 
   * @return the result of the block
   * @see #currentScope()
   */
  public <T extends Object> T withScope(final Iterable<? extends ArchitectureDomain> domains, final Function0<T> block) {
    return this._mergeState.<T>withDomains(domains, block);
  }

  /**
   * Execute a block of code in the scope of a set of domains being merged. For the duration of the
   * block, these domains will be the current scope.
   * 
   * @see #currentScope()
   */
  public void withScope(final Iterable<? extends ArchitectureDomain> domains, final Procedure0 block) {
    final Function0<Object> _function = () -> {
      Object _xblockexpression = null;
      {
        block.apply();
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    this.<Object>withScope(domains, _function);
  }

  /**
   * Compute a subset of objects in an iterable that are uniquely identified by some key function.
   */
  @Pure
  public <T extends Object, K extends Object> Iterable<T> uniqueBy(final Iterable<T> iterable, final Function1<? super T, K> keyer) {
    abstract class __ArchitectureExtensions_3 extends AbstractIterator<T> {
      Iterator<T> delegate;

      Set<K> uniquifier;
    }

    final Iterable<T> _function = () -> {
      return new __ArchitectureExtensions_3() {
        {
          delegate = iterable.iterator();

          uniquifier = CollectionLiterals.<K>newHashSet();
        }
        @Override
        protected T computeNext() {
          T _xblockexpression = null;
          {
            while (this.delegate.hasNext()) {
              {
                final T next = this.delegate.next();
                K _apply = keyer.apply(next);
                boolean _add = this.uniquifier.add(_apply);
                if (_add) {
                  return next;
                }
              }
            }
            _xblockexpression = this.endOfData();
          }
          return _xblockexpression;
        }
      };
    };
    return _function;
  }

  /**
   * Compute an unique subset of objects in a transformed iterable.
   */
  @Pure
  public <T extends Object, R extends Object> Iterable<R> mapUnique(final Iterable<T> iterable, final Function1<? super T, R> mapper) {
    return this.<R>unique(IterableExtensions.<T, R>map(iterable, mapper));
  }

  /**
   * Obtain the unique elements in an {@code iterable}.
   */
  @Pure
  public <T extends Object> Iterable<T> unique(final Iterable<T> iterable) {
    abstract class __ArchitectureExtensions_4 extends AbstractIterator<T> {
      Iterator<T> delegate;

      Set<T> uniquifier;
    }

    final Iterable<T> _function = () -> {
      return new __ArchitectureExtensions_4() {
        {
          delegate = iterable.iterator();

          uniquifier = CollectionLiterals.<T>newHashSet();
        }
        @Override
        protected T computeNext() {
          T _xblockexpression = null;
          {
            while (this.delegate.hasNext()) {
              {
                final T next = this.delegate.next();
                boolean _add = this.uniquifier.add(next);
                if (_add) {
                  return next;
                }
              }
            }
            _xblockexpression = this.endOfData();
          }
          return _xblockexpression;
        }
      };
    };
    return _function;
  }

  /**
   * Filter architecture elements by name.
   */
  @Pure
  public <T extends ADElement> Iterable<T> named(final Iterable<T> iterable, final String selectedName) {
    final Function1<T, Boolean> _function = (T it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, selectedName));
    };
    return IterableExtensions.<T>filter(iterable, _function);
  }

  /**
   * Obtain the difference between an {@code iterable} and a set of exclusions.
   */
  @Pure
  public <T extends Object> Iterable<T> excluding(final Iterable<T> iterable, final Object... excluded) {
    Iterable<T> _xblockexpression = null;
    {
      final HashSet<Object> unwanted = CollectionLiterals.<Object>newHashSet(excluded);
      final Function1<T, Boolean> _function = (T it) -> {
        return Boolean.valueOf(unwanted.contains(it));
      };
      _xblockexpression = IterableExtensions.<T>reject(iterable, _function);
    }
    return _xblockexpression;
  }
}
