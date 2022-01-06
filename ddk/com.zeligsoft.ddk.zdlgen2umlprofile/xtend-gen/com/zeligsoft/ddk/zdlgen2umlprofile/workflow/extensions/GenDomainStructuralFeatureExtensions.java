package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GenDomainStructuralFeatureExtensions {
  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;
  
  protected String _typeAsString(final GenDomainAttribute feature) {
    String _xifexpression = null;
    GenDomainDataType _type = feature.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      String _xifexpression_1 = null;
      Type _type_1 = feature.getDomainAttribute().getType();
      boolean _equals_1 = Objects.equal(_type_1, null);
      if (_equals_1) {
        String _xifexpression_2 = null;
        Property _umlMetaattribute = feature.getUmlMetaattribute();
        boolean _notEquals = (!Objects.equal(_umlMetaattribute, null));
        if (_notEquals) {
          String _name = feature.getUmlMetaattribute().getType().getName();
          _xifexpression_2 = ("org.eclipse.uml2.uml." + _name);
        } else {
          _xifexpression_2 = "TYPE IS NULL";
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        String _xblockexpression = null;
        {
          final String type = feature.getDomainAttribute().getType().getName();
          String _xifexpression_3 = null;
          boolean _equals_2 = Objects.equal(type, "UnlimitedNatural");
          if (_equals_2) {
            return "Integer";
          } else {
            _xifexpression_3 = type;
          }
          _xblockexpression = _xifexpression_3;
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = this._javaNamingExtensions.javaInterfaceName(feature.getType());
    }
    return _xifexpression;
  }
  
  protected boolean _hasZDLType(final GenDomainReference feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      GenDomainConcept _target = feature.getTarget();
      boolean _equals = Objects.equal(_target, null);
      if (_equals) {
        Type _type = feature.getDomainAttribute().getType();
        boolean _equals_1 = Objects.equal(_type, null);
        if (_equals_1) {
          result = false;
        } else {
          String _name = feature.getDomainAttribute().getType().getName();
          if (_name != null) {
            switch (_name) {
              case "Integer":
                result = false;
                break;
              case "UnlimitedNatural":
                result = false;
                break;
              case "String":
                result = false;
                break;
              case "Boolean":
                result = false;
                break;
              default:
                result = true;
                break;
            }
          } else {
            result = true;
          }
        }
      } else {
        result = true;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected boolean _hasZDLType(final GenDomainAttribute feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      GenDomainDataType _type = feature.getType();
      boolean _equals = Objects.equal(_type, null);
      if (_equals) {
        Type _type_1 = feature.getDomainAttribute().getType();
        boolean _equals_1 = Objects.equal(_type_1, null);
        if (_equals_1) {
          result = false;
        } else {
          String _name = feature.getDomainAttribute().getType().getName();
          if (_name != null) {
            switch (_name) {
              case "Integer":
                result = false;
                break;
              case "UnlimitedNatural":
                result = false;
                break;
              case "String":
                result = false;
                break;
              case "Boolean":
                result = false;
                break;
              default:
                result = true;
                break;
            }
          } else {
            result = true;
          }
        }
      } else {
        result = true;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected boolean _hasUMLType(final GenDomainReference feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      GenDomainConcept _target = feature.getTarget();
      boolean _equals = Objects.equal(_target, null);
      if (_equals) {
        Type _type = feature.getDomainAttribute().getType();
        boolean _equals_1 = Objects.equal(_type, null);
        if (_equals_1) {
          Property _umlMetaattribute = feature.getUmlMetaattribute();
          boolean _notEquals = (!Objects.equal(_umlMetaattribute, null));
          if (_notEquals) {
            result = true;
          } else {
            result = false;
          }
        } else {
          result = false;
        }
      } else {
        result = false;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected boolean _hasUMLType(final GenDomainAttribute feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      GenDomainDataType _type = feature.getType();
      boolean _equals = Objects.equal(_type, null);
      if (_equals) {
        Type _type_1 = feature.getDomainAttribute().getType();
        boolean _equals_1 = Objects.equal(_type_1, null);
        if (_equals_1) {
          Property _umlMetaattribute = feature.getUmlMetaattribute();
          boolean _notEquals = (!Objects.equal(_umlMetaattribute, null));
          if (_notEquals) {
            result = true;
          } else {
            result = false;
          }
        } else {
          result = false;
        }
      } else {
        result = false;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected boolean _hasPrimitiveType(final GenDomainReference feature) {
    boolean result = false;
    GenDomainConcept _target = feature.getTarget();
    boolean _equals = Objects.equal(_target, null);
    if (_equals) {
      Type _type = feature.getDomainAttribute().getType();
      boolean _equals_1 = Objects.equal(_type, null);
      if (_equals_1) {
        result = false;
      } else {
        String _name = feature.getDomainAttribute().getType().getName();
        if (_name != null) {
          switch (_name) {
            case "Integer":
              result = true;
              break;
            case "UnlimitedNatural":
              result = true;
              break;
            case "String":
              result = true;
              break;
            case "Boolean":
              result = true;
              break;
            default:
              result = false;
              break;
          }
        } else {
          result = false;
        }
      }
    }
    return result;
  }
  
  protected boolean _hasPrimitiveType(final GenDomainAttribute feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      GenDomainDataType _type = feature.getType();
      boolean _equals = Objects.equal(_type, null);
      if (_equals) {
        Type _type_1 = feature.getDomainAttribute().getType();
        boolean _equals_1 = Objects.equal(_type_1, null);
        if (_equals_1) {
          result = false;
        } else {
          String _name = feature.getDomainAttribute().getType().getName();
          if (_name != null) {
            switch (_name) {
              case "Integer":
                result = true;
                break;
              case "UnlimitedNatural":
                result = true;
                break;
              case "String":
                result = true;
                break;
              case "Boolean":
                result = true;
                break;
              default:
                result = false;
                break;
            }
          } else {
            result = false;
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected String _typeAsString(final GenDomainReference feature) {
    String _xifexpression = null;
    GenDomainConcept _target = feature.getTarget();
    boolean _equals = Objects.equal(_target, null);
    if (_equals) {
      String _xifexpression_1 = null;
      Property _umlMetaattribute = feature.getUmlMetaattribute();
      boolean _notEquals = (!Objects.equal(_umlMetaattribute, null));
      if (_notEquals) {
        String _name = feature.getUmlMetaattribute().getType().getName();
        _xifexpression_1 = ("org.eclipse.uml2.uml." + _name);
      } else {
        _xifexpression_1 = "TYPE IS NULL";
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = this._javaNamingExtensions.javaInterfaceName(feature.getTarget());
    }
    return _xifexpression;
  }
  
  protected boolean _hasEnumerationType(final GenDomainAttribute feature) {
    GenDomainDataType _type = feature.getType();
    return (_type instanceof GenDomainEnum);
  }
  
  protected boolean _hasEnumerationType(final GenDomainReference feature) {
    GenDomainConcept _target = feature.getTarget();
    return (_target instanceof GenDomainEnum);
  }
  
  public String conceptQualifiedName(final GenDomainStructuralFeature feature) {
    return feature.getConcept().getDomainElement().getQualifiedName();
  }
  
  public CharSequence featureAccessorReturnType(final GenDomainStructuralFeature feature) {
    CharSequence _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("java.util.List<�feature.typeAsString�>");
      _xifexpression = _builder;
    } else {
      _xifexpression = this.typeAsString(feature);
    }
    return _xifexpression;
  }
  
  public String featureModifierType(final GenDomainStructuralFeature feature) {
    return this.typeAsString(feature);
  }
  
  public boolean isConsistentOverride(final GenDomainStructuralFeature feature, final GenDomainStructuralFeature overriden) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      boolean _equalsIgnoreCase = feature.getDomainAttribute().getName().equalsIgnoreCase(overriden.getDomainAttribute().getName());
      if (_equalsIgnoreCase) {
        final Type featureType = feature.getDomainAttribute().getType();
        final Type overridenType = overriden.getDomainAttribute().getType();
        boolean _conformsTo = featureType.conformsTo(overridenType);
        if (_conformsTo) {
          result = true;
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public boolean isInconsistentOverride(final GenDomainStructuralFeature feature, final GenDomainStructuralFeature overriden) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      boolean _equalsIgnoreCase = feature.getDomainAttribute().getName().equalsIgnoreCase(overriden.getDomainAttribute().getName());
      if (_equalsIgnoreCase) {
        final Type featureType = feature.getDomainAttribute().getType();
        final Type overridenType = overriden.getDomainAttribute().getType();
        boolean _conformsTo = featureType.conformsTo(overridenType);
        boolean _not = (!_conformsTo);
        if (_not) {
          result = true;
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public boolean isOverride(final GenDomainStructuralFeature feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      final Set<Property> overridenFeature = this.overridenFeatures(feature);
      boolean _isEmpty = overridenFeature.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        result = true;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public boolean isInconsistentOverride(final GenDomainStructuralFeature feature) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      final Set<Property> overridenFeature = this.overridenFeatures(feature);
      for (final Property next : overridenFeature) {
        {
          final Type featureType = feature.getDomainAttribute().getType();
          final Type overridenType = next.getType();
          boolean _conformsTo = featureType.conformsTo(overridenType);
          boolean _not = (!_conformsTo);
          if (_not) {
            result = true;
          } else {
            boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
            boolean _isMultivalued_1 = next.isMultivalued();
            boolean _notEquals = (_isMultivalued != _isMultivalued_1);
            if (_notEquals) {
              result = true;
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String getInconsistentOverrideString(final GenDomainStructuralFeature feature) {
    String _xblockexpression = null;
    {
      int count = 0;
      final Set<Property> overridenFeature = this.overridenFeatures(feature);
      for (final Property next : overridenFeature) {
        {
          final Type featureType = feature.getDomainAttribute().getType();
          final Type overridenType = next.getType();
          boolean _conformsTo = featureType.conformsTo(overridenType);
          boolean _not = (!_conformsTo);
          if (_not) {
            count = (count + 1);
          } else {
            boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
            boolean _isMultivalued_1 = next.isMultivalued();
            boolean _notEquals = (_isMultivalued != _isMultivalued_1);
            if (_notEquals) {
              count = (count + 1);
            }
          }
        }
      }
      String _xifexpression = null;
      if ((count == 1)) {
        _xifexpression = "Override";
      } else {
        String _xifexpression_1 = null;
        if ((count > 1)) {
          _xifexpression_1 = ("Override" + Integer.valueOf(count));
        } else {
          _xifexpression_1 = "";
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Set<Property> overridenFeatures(final GenDomainStructuralFeature feature) {
    Set<Property> _xblockexpression = null;
    {
      final GenDomainConcept concept = feature.getConcept();
      final EList<Classifier> generals = concept.getDomainConcept().allParents();
      final Set<Property> overridenFeatures = Sets.<Property>newHashSet();
      for (final Classifier c : generals) {
        final Function1<Feature, Boolean> _function = (Feature f) -> {
          return Boolean.valueOf(((!Objects.equal(f, feature.getDomainAttribute())) && feature.getDomainAttribute().getName().equalsIgnoreCase(f.getName())));
        };
        Iterables.<Property>addAll(overridenFeatures, IterableExtensions.<Property>filter(c.getAttributes(), _function));
      }
      _xblockexpression = overridenFeatures;
    }
    return _xblockexpression;
  }
  
  public Set<GenDomainStructuralFeature> overridenGenFeatures(final GenDomainStructuralFeature feature) {
    Set<GenDomainStructuralFeature> _xblockexpression = null;
    {
      final GenDomainConcept concept = feature.getConcept();
      final EList<GenDomainConcept> generals = concept.allGenerals();
      final Set<GenDomainStructuralFeature> overridenFeatures = Sets.<GenDomainStructuralFeature>newHashSet();
      for (final GenDomainConcept c : generals) {
        final Function1<GenDomainStructuralFeature, Boolean> _function = (GenDomainStructuralFeature f) -> {
          return Boolean.valueOf(((!Objects.equal(f, feature)) && this.featureName(feature).equals(this.featureName(f))));
        };
        Iterables.<GenDomainStructuralFeature>addAll(overridenFeatures, IterableExtensions.<GenDomainStructuralFeature>filter(c.getFeatures(), _function));
      }
      _xblockexpression = overridenFeatures;
    }
    return _xblockexpression;
  }
  
  protected String _featureName(final GenDomainAttribute attr) {
    return attr.getName();
  }
  
  protected String _featureName(final GenDomainReference ref) {
    return ref.getDomainAttribute().getName();
  }
  
  protected GenDomainClassifier _featureType(final GenDomainAttribute attr) {
    return attr.getType();
  }
  
  protected GenDomainClassifier _featureType(final GenDomainReference ref) {
    return ref.getTarget();
  }
  
  public String featureTypeQualifiedName(final GenDomainStructuralFeature feat) {
    String _xblockexpression = null;
    {
      final GenDomainClassifier featureType = this.featureType(feat);
      String _xifexpression = null;
      boolean _equals = Objects.equal(featureType, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = featureType.getDomainElement().getQualifiedName();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean _typeIsAbstract(final GenDomainAttribute attr) {
    boolean _xblockexpression = false;
    {
      final Type attrType = attr.getDomainAttribute().getType();
      boolean _switchResult = false;
      boolean _matched = false;
      if (attrType instanceof Classifier) {
        _matched=true;
        _switchResult = ((Classifier)attrType).isAbstract();
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected boolean _typeIsAbstract(final GenDomainReference attr) {
    boolean _xblockexpression = false;
    {
      final Type attrType = attr.getDomainAttribute().getType();
      boolean _switchResult = false;
      boolean _matched = false;
      if (attrType instanceof Classifier) {
        _matched=true;
        _switchResult = ((Classifier)attrType).isAbstract();
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public String typeAsString(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _typeAsString((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _typeAsString((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public boolean hasZDLType(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _hasZDLType((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _hasZDLType((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public boolean hasUMLType(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _hasUMLType((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _hasUMLType((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public boolean hasPrimitiveType(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _hasPrimitiveType((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _hasPrimitiveType((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public boolean hasEnumerationType(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _hasEnumerationType((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _hasEnumerationType((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String featureName(final GenDomainStructuralFeature attr) {
    if (attr instanceof GenDomainAttribute) {
      return _featureName((GenDomainAttribute)attr);
    } else if (attr instanceof GenDomainReference) {
      return _featureName((GenDomainReference)attr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr).toString());
    }
  }
  
  public GenDomainClassifier featureType(final GenDomainStructuralFeature attr) {
    if (attr instanceof GenDomainAttribute) {
      return _featureType((GenDomainAttribute)attr);
    } else if (attr instanceof GenDomainReference) {
      return _featureType((GenDomainReference)attr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr).toString());
    }
  }
  
  public boolean typeIsAbstract(final GenDomainStructuralFeature attr) {
    if (attr instanceof GenDomainAttribute) {
      return _typeIsAbstract((GenDomainAttribute)attr);
    } else if (attr instanceof GenDomainReference) {
      return _typeIsAbstract((GenDomainReference)attr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr).toString());
    }
  }
}
