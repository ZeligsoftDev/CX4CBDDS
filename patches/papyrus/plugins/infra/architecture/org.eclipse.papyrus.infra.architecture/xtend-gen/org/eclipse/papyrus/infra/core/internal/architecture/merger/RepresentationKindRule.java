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
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Merge rule for {@link RepresentationKind}s.
 */
@Singleton
@SuppressWarnings("all")
public class RepresentationKindRule {
  @Inject
  @Extension
  private ArchitectureExtensions _architectureExtensions;

  @Inject
  @Extension
  private ArchitectureContextRule _architectureContextRule;

  @Inject
  @Extension
  private ArchitectureDomainRule _architectureDomainRule;

  /**
   * Obtain the corresponding {@code representation} kind in the merge result model.
   * Representation kinds are not merged <em>per se</em>, but their cross-references
   * to other architecture model elements are rewritten to reference merged elements
   * in the merge result model.
   */
  public RepresentationKind merged(final RepresentationKind representation) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(representation);
    final RepresentationKind _result;
    synchronized (_createCache_merged) {
      if (_createCache_merged.containsKey(_cacheKey)) {
        return _createCache_merged.get(_cacheKey);
      }
      RepresentationKind _copy = EcoreUtil.<RepresentationKind>copy(representation);
      _result = _copy;
      _createCache_merged.put(_cacheKey, _result);
    }
    _init_merged(_result, representation);
    return _result;
  }

  private final HashMap<ArrayList<?>, RepresentationKind> _createCache_merged = CollectionLiterals.newHashMap();

  private void _init_merged(final RepresentationKind result, final RepresentationKind representation) {
    ArchitectureExtensions.logf("Copying %s", representation);
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(((it.isContainment() || it.isContainer()) || (!it.isChangeable())));
    };
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      return Boolean.valueOf(ArchitecturePackage.Literals.AD_ELEMENT.isSuperTypeOf(it.getEReferenceType()));
    };
    final Consumer<EReference> _function_2 = (EReference xref) -> {
      EClass _eReferenceType = xref.getEReferenceType();
      final EClass type = _eReferenceType;
      boolean _matched = false;
      boolean _isSuperTypeOf = ArchitecturePackage.Literals.CONCERN.isSuperTypeOf(type);
      if (_isSuperTypeOf) {
        _matched=true;
        final UnaryOperator<Concern> _function_3 = (Concern it) -> {
          return this._architectureExtensions.mergedConcern(it.getName());
        };
        this._architectureExtensions.<Concern>eGetAsList(result, xref, Concern.class).replaceAll(_function_3);
      }
      if (!_matched) {
        boolean _isSuperTypeOf_1 = ArchitecturePackage.Literals.STAKEHOLDER.isSuperTypeOf(type);
        if (_isSuperTypeOf_1) {
          _matched=true;
          final UnaryOperator<Stakeholder> _function_4 = (Stakeholder it) -> {
            return this._architectureExtensions.mergedStakeholder(it.getName());
          };
          this._architectureExtensions.<Stakeholder>eGetAsList(result, xref, Stakeholder.class).replaceAll(_function_4);
        }
      }
      if (!_matched) {
        boolean _isSuperTypeOf_2 = ArchitecturePackage.Literals.REPRESENTATION_KIND.isSuperTypeOf(type);
        if (_isSuperTypeOf_2) {
          _matched=true;
          final UnaryOperator<RepresentationKind> _function_5 = (RepresentationKind it) -> {
            return this.merged(it);
          };
          this._architectureExtensions.<RepresentationKind>eGetAsList(result, xref, RepresentationKind.class).replaceAll(_function_5);
        }
      }
      if (!_matched) {
        boolean _isSuperTypeOf_3 = ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT.isSuperTypeOf(type);
        if (_isSuperTypeOf_3) {
          _matched=true;
          final UnaryOperator<ArchitectureContext> _function_6 = (ArchitectureContext it) -> {
            return this._architectureContextRule.merged(it);
          };
          this._architectureExtensions.<ArchitectureContext>eGetAsList(result, xref, ArchitectureContext.class).replaceAll(_function_6);
        }
      }
      if (!_matched) {
        boolean _isSuperTypeOf_4 = ArchitecturePackage.Literals.ARCHITECTURE_DOMAIN.isSuperTypeOf(type);
        if (_isSuperTypeOf_4) {
          _matched=true;
          final UnaryOperator<ArchitectureDomain> _function_7 = (ArchitectureDomain it) -> {
            return this._architectureDomainRule.merged(it);
          };
          this._architectureExtensions.<ArchitectureDomain>eGetAsList(result, xref, ArchitectureDomain.class).replaceAll(_function_7);
        }
      }
    };
    IterableExtensions.<EReference>filter(IterableExtensions.<EReference>reject(representation.eClass().getEAllReferences(), _function), _function_1).forEach(_function_2);
    ArchitectureExtensions.logf("Copied %s to %s", representation, result);
  }
}
