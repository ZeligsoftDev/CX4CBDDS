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
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Encapsulation of merge traces from merged architecture model elements to
 * the original source models.
 */
@SuppressWarnings("all")
final class MergeTraces extends AdapterImpl implements MergeTraceAdapter {
  private final Multimap<ADElement, ADElement> traces = ArrayListMultimap.<ADElement, ADElement>create();

  public MergeTraces trace(final ADElement mergedElement, final ADElement sourceElement) {
    MergeTraces _xblockexpression = null;
    {
      boolean _hasTraces = this.hasTraces(sourceElement);
      if (_hasTraces) {
        ArchitectureExtensions.logf("Tracing %s -> %s.", mergedElement, this.internalTrace(sourceElement));
        this.traces.putAll(mergedElement, this.internalTrace(sourceElement));
      } else {
        ArchitectureExtensions.logf("Tracing %s -> %s.", mergedElement, sourceElement);
        this.traces.put(mergedElement, sourceElement);
      }
      this.addAdapter(mergedElement);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  private Collection<ADElement> internalTrace(final ADElement mergedElement) {
    return this.traces.get(mergedElement);
  }

  public boolean hasTraces(final ADElement element) {
    boolean _isEmpty = this.internalTrace(element).isEmpty();
    return (!_isEmpty);
  }

  @Override
  public Collection<? extends ADElement> trace(final ADElement mergedElement) {
    return Collections.<ADElement>unmodifiableCollection(this.internalTrace(mergedElement));
  }

  @Override
  public boolean tracesTo(final ADElement mergedElement, final ADElement sourceElement) {
    return (Objects.equal(mergedElement, sourceElement) || this.internalTrace(mergedElement).contains(sourceElement));
  }

  /**
   * Trace a merged element to the source element that contributed its value of the given
   * {@code feature}. In case of a multi-valued feature, this will be any source element
   * that contributed any values in that feature. <strong>Note</strong> that an empty
   * result is possible because it could be that no source elements contributed any
   * values to this {@code feature} (in which case that feature probably is unset).
   * 
   * @param <T> the element type to trace
   * @param mergedElement the element to trace to a contributing source
   * @param feature the feature to trace
   * @return the source element for that feature
   */
  @Override
  public <T extends ADElement> T trace(final T mergedElement, final EStructuralFeature feature) {
    final Function1<ADElement, Boolean> _function = (ADElement it) -> {
      return Boolean.valueOf(this.intersects(feature, mergedElement, it));
    };
    ADElement _findFirst = IterableExtensions.<ADElement>findFirst(this.internalTrace(mergedElement), _function);
    return ((T) _findFirst);
  }

  private boolean intersects(final EStructuralFeature feature, final EObject object1, final EObject object2) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (feature instanceof EAttribute) {
      boolean _isMany = ((EAttribute)feature).isMany();
      boolean _not = (!_isMany);
      if (_not) {
        _matched=true;
        _switchResult = java.util.Objects.equals(object1.eGet(feature), object2.eGet(feature));
      }
    }
    if (!_matched) {
      if (feature instanceof EAttribute) {
        _matched=true;
        Object _eGet = object1.eGet(feature);
        Object _eGet_1 = object2.eGet(feature);
        _switchResult = this.intersects(((Collection<?>) _eGet), ((Collection<?>) _eGet_1));
      }
    }
    if (!_matched) {
      if (feature instanceof EReference) {
        if ((ArchitecturePackage.Literals.AD_ELEMENT.isSuperTypeOf(((EReference)feature).getEReferenceType()) && (!((EReference)feature).isMany()))) {
          _matched=true;
          Object _eGet = object1.eGet(feature);
          Object _eGet_1 = object2.eGet(feature);
          _switchResult = this.tracesTo(((ADElement) _eGet), ((ADElement) _eGet_1));
        }
      }
    }
    if (!_matched) {
      if (feature instanceof EReference) {
        boolean _isSuperTypeOf = ArchitecturePackage.Literals.AD_ELEMENT.isSuperTypeOf(((EReference)feature).getEReferenceType());
        if (_isSuperTypeOf) {
          _matched=true;
          Object _eGet = object1.eGet(feature);
          Object _eGet_1 = object2.eGet(feature);
          _switchResult = this.tracesAny(((Collection<? extends ADElement>) _eGet), ((Collection<? extends ADElement>) _eGet_1));
        }
      }
    }
    if (!_matched) {
      if (feature instanceof EReference) {
        boolean _isMany = ((EReference)feature).isMany();
        boolean _not = (!_isMany);
        if (_not) {
          _matched=true;
          Object _eGet = object1.eGet(feature);
          Object _eGet_1 = object2.eGet(feature);
          _switchResult = (_eGet == _eGet_1);
        }
      }
    }
    if (!_matched) {
      Object _eGet = object1.eGet(feature);
      Object _eGet_1 = object2.eGet(feature);
      _switchResult = this.intersects(((Collection<?>) _eGet), ((Collection<?>) _eGet_1));
    }
    return _switchResult;
  }

  private boolean intersects(final Collection<?> a, final Collection<?> b) {
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf(b.contains(it));
    };
    return IterableExtensions.exists(a, _function);
  }

  private boolean tracesAny(final Collection<? extends ADElement> a, final Collection<? extends ADElement> b) {
    final Function1<ADElement, Boolean> _function = (ADElement fromA) -> {
      final Function1<ADElement, Boolean> _function_1 = (ADElement fromB) -> {
        return Boolean.valueOf(this.tracesTo(fromA, fromB));
      };
      return Boolean.valueOf(IterableExtensions.exists(b, _function_1));
    };
    return IterableExtensions.exists(a, _function);
  }

  @Override
  public boolean isAdapterForType(final Object type) {
    return (Objects.equal(type, MergeTraceAdapter.class) || Objects.equal(type, MergeTraces.class));
  }

  public boolean addAdapter(final Notifier notifier) {
    boolean _xifexpression = false;
    boolean _contains = notifier.eAdapters().contains(this);
    boolean _not = (!_contains);
    if (_not) {
      EList<Adapter> _eAdapters = notifier.eAdapters();
      _xifexpression = _eAdapters.add(this);
    }
    return _xifexpression;
  }

  public boolean removeAdapter(final Notifier notifier) {
    return notifier.eAdapters().remove(this);
  }

  @Override
  public void setTarget(final Notifier newTarget) {
    boolean _matched = false;
    if (newTarget instanceof ADElement) {
      if (Objects.equal(newTarget, ((ADElement)newTarget))) {
        _matched=true;
        final Consumer<ADElement> _function = (ADElement it) -> {
          this.addAdapter(it);
        };
        Iterables.<ADElement>filter(((ADElement)newTarget).eContents(), ADElement.class).forEach(_function);
      }
    }
  }

  @Override
  public void unsetTarget(final Notifier oldTarget) {
    this.traces.removeAll(oldTarget);
    boolean _matched = false;
    if (oldTarget instanceof ADElement) {
      if (Objects.equal(oldTarget, ((ADElement)oldTarget))) {
        _matched=true;
        final Consumer<ADElement> _function = (ADElement it) -> {
          this.removeAdapter(it);
        };
        Iterables.<ADElement>filter(((ADElement)oldTarget).eContents(), ADElement.class).forEach(_function);
      }
    }
  }

  @Override
  public void notifyChanged(final Notification msg) {
    final Object feature = msg.getFeature();
    boolean _matched = false;
    if (feature instanceof EReference) {
      if ((ArchitecturePackage.Literals.AD_ELEMENT.isSuperTypeOf(((EReference)feature).getEReferenceType()) && ((EReference)feature).isContainment())) {
        _matched=true;
        int _eventType = msg.getEventType();
        switch (_eventType) {
          case Notification.ADD:
            Object _newValue = msg.getNewValue();
            this.addAdapter(((ADElement) _newValue));
            break;
          case Notification.ADD_MANY:
            Object _newValue_1 = msg.getNewValue();
            final Consumer<ADElement> _function = (ADElement it) -> {
              this.addAdapter(it);
            };
            ((Iterable<? extends ADElement>) _newValue_1).forEach(_function);
            break;
          case Notification.REMOVE:
            Object _oldValue = msg.getOldValue();
            this.removeAdapter(((ADElement) _oldValue));
            break;
          case Notification.REMOVE_MANY:
            Object _oldValue_1 = msg.getOldValue();
            final Consumer<ADElement> _function_1 = (ADElement it) -> {
              this.removeAdapter(it);
            };
            ((Iterable<? extends ADElement>) _oldValue_1).forEach(_function_1);
            break;
          case Notification.SET:
            Object _newValue_2 = msg.getNewValue();
            this.addAdapter(((ADElement) _newValue_2));
            Object _oldValue_2 = msg.getOldValue();
            this.removeAdapter(((ADElement) _oldValue_2));
            break;
        }
      }
    }
  }
}
