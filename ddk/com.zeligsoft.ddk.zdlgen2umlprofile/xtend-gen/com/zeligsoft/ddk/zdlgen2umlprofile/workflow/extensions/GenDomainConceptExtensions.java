package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GenDomainConceptExtensions {
  @Inject
  @Extension
  private GenDomainStructuralFeatureExtensions _genDomainStructuralFeatureExtensions;

  public EList<Classifier> baseDomainConcepts(final GenDomainConcept concept) {
    final EList<Classifier> result = concept.getDomainConcept().getGenerals();
    result.remove(concept.getDomainConcept());
    return result;
  }

  public ArrayList<GenDomainConcept> baseDomainConceptsToImplement(final GenDomainConcept concept) {
    ArrayList<GenDomainConcept> _xblockexpression = null;
    {
      final GenDomainConcept firstBaseConcept = IterableExtensions.<GenDomainConcept>head(concept.getGenerals());
      EList<GenDomainConcept> _allGenerals = concept.allGenerals();
      final ArrayList<GenDomainConcept> result = new ArrayList<GenDomainConcept>(_allGenerals);
      boolean _notEquals = (!Objects.equal(firstBaseConcept, null));
      if (_notEquals) {
        result.remove(firstBaseConcept);
        result.removeAll(firstBaseConcept.allGenerals());
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public List<GenDomainStructuralFeature> allFeaturesToImplement(final GenDomainConcept concept) {
    List<GenDomainStructuralFeature> _xblockexpression = null;
    {
      final Map<String, GenDomainStructuralFeature> featureNameMap = CollectionLiterals.<String, GenDomainStructuralFeature>newHashMap();
      EList<GenDomainStructuralFeature> _features = concept.getFeatures();
      for (final GenDomainStructuralFeature nextFeature : _features) {
        featureNameMap.put(this._genDomainStructuralFeatureExtensions.featureName(nextFeature), nextFeature);
      }
      ArrayList<GenDomainConcept> _baseDomainConceptsToImplement = this.baseDomainConceptsToImplement(concept);
      for (final GenDomainConcept baseConcept : _baseDomainConceptsToImplement) {
        EList<GenDomainStructuralFeature> _features_1 = baseConcept.getFeatures();
        for (final GenDomainStructuralFeature nextFeature_1 : _features_1) {
          boolean _containsKey = featureNameMap.containsKey(this._genDomainStructuralFeatureExtensions.featureName(nextFeature_1));
          boolean _not = (!_containsKey);
          if (_not) {
            featureNameMap.put(this._genDomainStructuralFeatureExtensions.featureName(nextFeature_1), nextFeature_1);
          }
        }
      }
      _xblockexpression = IterableExtensions.<GenDomainStructuralFeature>toList(featureNameMap.values());
    }
    return _xblockexpression;
  }

  public Set<org.eclipse.uml2.uml.Class> allMetaclassesToImplementAccessorsFor(final GenDomainConcept concept) {
    Set<org.eclipse.uml2.uml.Class> _xblockexpression = null;
    {
      final List<org.eclipse.uml2.uml.Class> result = CollectionLiterals.<org.eclipse.uml2.uml.Class>newArrayList();
      result.addAll(concept.getUmlMetaclasses());
      ArrayList<GenDomainConcept> _baseDomainConceptsToImplement = this.baseDomainConceptsToImplement(concept);
      for (final GenDomainConcept baseConcept : _baseDomainConceptsToImplement) {
        result.addAll(baseConcept.getUmlMetaclasses());
      }
      _xblockexpression = IterableExtensions.<org.eclipse.uml2.uml.Class>toSet(result);
    }
    return _xblockexpression;
  }
}
