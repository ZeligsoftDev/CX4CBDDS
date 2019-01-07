package com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPInstanceValue;
import com.telelogic.rhapsody.core.IRPLiteralSpecification;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPTag;
import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DeploymentValueUpdateRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  private List getInstanceValueTags(final IRPModelElement source) {
    IRPCollection _allTags = source.getAllTags();
    List _list = _allTags.toList();
    final Function1<IRPTag,Boolean> _function = new Function1<IRPTag,Boolean>() {
        public Boolean apply(final IRPTag t) {
          String _name = t.getName();
          boolean _startsWith = _name.startsWith("instanceValue");
          return Boolean.valueOf(_startsWith);
        }
      };
    Iterable<IRPTag> _filter = IterableExtensions.<IRPTag>filter(_list, _function);
    final List<IRPTag> tags = IterableExtensions.<IRPTag>toList(_filter);
    return tags;
  }
  
  private IRPModelElement getClassifierTagValue(final IRPModelElement source) {
    IRPModelElement _xblockexpression = null;
    {
      IRPCollection _allTags = source.getAllTags();
      final List tags = _allTags.toList();
      final Function1<IRPTag,Boolean> _function = new Function1<IRPTag,Boolean>() {
          public Boolean apply(final IRPTag t) {
            String _name = t.getName();
            boolean _equals = Objects.equal(_name, "classifier");
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<IRPTag> _filter = IterableExtensions.<IRPTag>filter(tags, _function);
      final IRPTag tag = IterableExtensions.<IRPTag>head(_filter);
      boolean _notEquals = (!Objects.equal(tag, null));
      if (_notEquals) {
        IRPCollection _valueSpecifications = tag.getValueSpecifications();
        final List values = _valueSpecifications.toList();
        boolean _isEmpty = values.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final Object value = values.get(0);
          return ((IRPInstanceValue) value).getValue();
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  private String getValueTagValue(final IRPModelElement source) {
    String _xblockexpression = null;
    {
      IRPCollection _allTags = source.getAllTags();
      final List tags = _allTags.toList();
      final Function1<IRPTag,Boolean> _function = new Function1<IRPTag,Boolean>() {
          public Boolean apply(final IRPTag t) {
            String _name = t.getName();
            boolean _equals = Objects.equal(_name, "value");
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<IRPTag> _filter = IterableExtensions.<IRPTag>filter(tags, _function);
      final IRPTag tag = IterableExtensions.<IRPTag>head(_filter);
      boolean _notEquals = (!Objects.equal(tag, null));
      if (_notEquals) {
        IRPCollection _valueSpecifications = tag.getValueSpecifications();
        final List values = _valueSpecifications.toList();
        boolean _isEmpty = values.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final Object value = values.get(0);
          return ((IRPLiteralSpecification) value).getValue();
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected void _transformDeploymentValue(final Property part, final IRPTag instance, final IRPModelElement source) {
    final org.eclipse.uml2.uml.Package container = this.getRootContainer(part);
    IRPCollection _valueSpecifications = instance.getValueSpecifications();
    final List values = _valueSpecifications.toList();
    boolean _isEmpty = values.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final InstanceValue instanceValue = this.createInstanceValue(part);
      final Object value = values.get(0);
      boolean _and = false;
      if (!(value instanceof IRPInstanceValue)) {
        _and = false;
      } else {
        IRPModelElement _value = ((IRPInstanceValue) value).getValue();
        boolean _notEquals = (!Objects.equal(_value, null));
        _and = ((value instanceof IRPInstanceValue) && _notEquals);
      }
      if (_and) {
        IRPModelElement _value_1 = ((IRPInstanceValue) value).getValue();
        final InstanceSpecification instanceSpecification = this.transformInstance(_value_1, container);
        boolean _notEquals_1 = (!Objects.equal(instanceSpecification, null));
        if (_notEquals_1) {
          instanceValue.setInstance(instanceSpecification);
        }
      }
    }
  }
  
  protected void _transformDeploymentValue(final org.eclipse.uml2.uml.Package element, final IRPTag instance, final IRPModelElement source) {
    boolean _isZDLConcept = ZDLUtil.isZDLConcept(element, IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING);
    if (_isZDLConcept) {
      final org.eclipse.uml2.uml.Package container = this.getRootContainer(element);
      IRPCollection _valueSpecifications = instance.getValueSpecifications();
      final List values = _valueSpecifications.toList();
      boolean _isEmpty = values.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Object value = values.get(0);
        boolean _and = false;
        if (!(value instanceof IRPInstanceValue)) {
          _and = false;
        } else {
          IRPModelElement _value = ((IRPInstanceValue) value).getValue();
          boolean _notEquals = (!Objects.equal(_value, null));
          _and = ((value instanceof IRPInstanceValue) && _notEquals);
        }
        if (_and) {
          IRPModelElement _value_1 = ((IRPInstanceValue) value).getValue();
          final InstanceSpecification instanceSpecification = this.transformInstance(_value_1, container);
          boolean _notEquals_1 = (!Objects.equal(instanceSpecification, null));
          if (_notEquals_1) {
            ZDLUtil.setValue(element, IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING, 
              IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE, instanceSpecification);
          }
        }
      }
    }
  }
  
  protected void _transformDeploymentValue(final Component element, final IRPTag instance, final IRPModelElement source) {
    final org.eclipse.uml2.uml.Package container = this.getRootContainer(element);
    IRPCollection _valueSpecifications = instance.getValueSpecifications();
    final List values = _valueSpecifications.toList();
    boolean _isEmpty = values.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Object value = values.get(0);
      boolean _and = false;
      if (!(value instanceof IRPInstanceValue)) {
        _and = false;
      } else {
        IRPModelElement _value = ((IRPInstanceValue) value).getValue();
        boolean _notEquals = (!Objects.equal(_value, null));
        _and = ((value instanceof IRPInstanceValue) && _notEquals);
      }
      if (_and) {
        IRPModelElement _value_1 = ((IRPInstanceValue) value).getValue();
        final InstanceSpecification instanceSpecification = this.transformInstance(_value_1, container);
        boolean _notEquals_1 = (!Objects.equal(instanceSpecification, null));
        if (_notEquals_1) {
          final Property attr = element.createOwnedAttribute(CXRhapsodyConstants.DEFAULT_PROPERTY_INSTANCE_NAME, null);
          final InstanceValue instanceVal = this.createInstanceValue(attr);
          instanceVal.setInstance(instanceSpecification);
        }
      }
    }
  }
  
  protected void _transformDeploymentValue(final EObject element, final IRPTag instance, final IRPModelElement source) {
  }
  
  private Slot transformSlot(final IRPAttribute slotAttribute, final InstanceSpecification instance) {
    Slot _xblockexpression = null;
    {
      EList<Classifier> _classifiers = instance.getClassifiers();
      final Classifier definition = _classifiers.get(0);
      EList<Property> _allAttributes = definition.getAllAttributes();
      List<Property> _list = IterableExtensions.<Property>toList(_allAttributes);
      final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
          public Boolean apply(final Property p) {
            String _name = p.getName();
            String _name_1 = slotAttribute.getName();
            boolean _equals = _name.equals(_name_1);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<Property> _filter = IterableExtensions.<Property>filter(_list, _function);
      final Property definingFeature = IterableExtensions.<Property>head(_filter);
      boolean _notEquals = (!Objects.equal(definingFeature, null));
      if (_notEquals) {
        final Slot slot = instance.createSlot();
        slot.setDefiningFeature(definingFeature);
        final List instanceValueTags = this.getInstanceValueTags(slotAttribute);
        final Procedure1<IRPTag> _function_1 = new Procedure1<IRPTag>() {
            public void apply(final IRPTag e) {
              EObject _eContainer = instance.eContainer();
              DeploymentValueUpdateRhapsodyExt.this.transformInstanceValue(e, slot, ((org.eclipse.uml2.uml.Package) _eContainer));
            }
          };
        IterableExtensions.<IRPTag>forEach(instanceValueTags, _function_1);
        return slot;
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  private void transformInstanceValue(final IRPTag tag, final Slot slot, final org.eclipse.uml2.uml.Package container) {
    EClass _instanceValue = UMLPackage.eINSTANCE.getInstanceValue();
    ValueSpecification _createValue = slot.createValue(null, null, _instanceValue);
    final InstanceValue slotValue = ((InstanceValue) _createValue);
    IRPCollection _valueSpecifications = tag.getValueSpecifications();
    final List values = _valueSpecifications.toList();
    boolean _and = false;
    boolean _isEmpty = values.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      Object _get = values.get(0);
      _and = (_not && (_get instanceof IRPInstanceValue));
    }
    if (_and) {
      Object _get_1 = values.get(0);
      final IRPInstanceValue instanceValue = ((IRPInstanceValue) _get_1);
      IRPModelElement _value = instanceValue.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      if (_notEquals) {
        IRPModelElement _value_1 = instanceValue.getValue();
        final InstanceSpecification instanceSpec = this.transformInstance(_value_1, container);
        slotValue.setInstance(instanceSpec);
      }
    }
  }
  
  private InstanceSpecification _transformInstance(final IRPInstance source, final org.eclipse.uml2.uml.Package container) {
    InstanceSpecification _xblockexpression = null;
    {
      final IRPModelElement definingFeature = this.getClassifierTagValue(source);
      String _fullPathName = definingFeature.getFullPathName();
      final EObject definition = this.getTransformedType(_fullPathName, container);
      boolean _notEquals = (!Objects.equal(definition, null));
      if (_notEquals) {
        final String name = source.getName();
        EClass _instanceSpecification = UMLPackage.eINSTANCE.getInstanceSpecification();
        PackageableElement _createPackagedElement = container.createPackagedElement(name, _instanceSpecification);
        final InstanceSpecification instanceSpecification = ((InstanceSpecification) _createPackagedElement);
        EList<Classifier> _classifiers = instanceSpecification.getClassifiers();
        _classifiers.add(((Classifier) definition));
        IRPClassifier _otherClass = source.getOtherClass();
        IRPCollection _attributes = _otherClass.getAttributes();
        final List attributes = _attributes.toList();
        boolean _isEmpty = attributes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
              public void apply(final IRPModelElement a) {
                DeploymentValueUpdateRhapsodyExt.this.transformSlot(((IRPAttribute) a), instanceSpecification);
              }
            };
          IterableExtensions.<IRPModelElement>forEach(attributes, _function);
        } else {
          final String value = this.getValueTagValue(source);
          boolean _notEquals_1 = (!Objects.equal(value, null));
          if (_notEquals_1) {
            EClass _literalString = UMLPackage.eINSTANCE.getLiteralString();
            ValueSpecification _createSpecification = instanceSpecification.createSpecification(null, null, _literalString);
            final LiteralString literal = ((LiteralString) _createSpecification);
            literal.setValue(value);
          }
        }
        return instanceSpecification;
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  private InstanceSpecification _transformInstance(final Object source, final org.eclipse.uml2.uml.Package container) {
    return null;
  }
  
  private EObject getTransformedType(final String rhapsodyElement, final EObject context) {
    try {
      Element _xblockexpression = null;
      {
        final Element result = this.typeCache.get(rhapsodyElement);
        boolean _equals = Objects.equal(result, null);
        if (_equals) {
          String corbaPrimitive = "";
          boolean _equals_1 = rhapsodyElement.equals("void");
          if (_equals_1) {
            corbaPrimitive = "CORBAVoid";
          }
          boolean _startsWith = rhapsodyElement.startsWith("IDLPrimitives::");
          if (_startsWith) {
            final String[] split = rhapsodyElement.split("::");
            String _get = ((List<String>)Conversions.doWrapArray(split)).get(1);
            corbaPrimitive = _get;
          }
          boolean _notEquals = (!Objects.equal(corbaPrimitive, ""));
          if (_notEquals) {
            return CORBAUtil.getCORBAPrimitiveType(context, corbaPrimitive);
          }
        }
        _xblockexpression = (result);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private InstanceValue createInstanceValue(final Property property) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(property);
    final InstanceValue _result;
    synchronized (_createCache_createInstanceValue) {
      if (_createCache_createInstanceValue.containsKey(_cacheKey)) {
        return _createCache_createInstanceValue.get(_cacheKey);
      }
      InstanceValue _createInstanceValueHelper = this.createInstanceValueHelper(property);
      _result = _createInstanceValueHelper;
      _createCache_createInstanceValue.put(_cacheKey, _result);
    }
    _init_createInstanceValue(_result, property);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,InstanceValue> _createCache_createInstanceValue = CollectionLiterals.newHashMap();
  
  private void _init_createInstanceValue(final InstanceValue value, final Property property) {
  }
  
  private InstanceValue createInstanceValueHelper(final Property property) {
    EClass _instanceValue = UMLPackage.eINSTANCE.getInstanceValue();
    ValueSpecification _createDefaultValue = property.createDefaultValue(null, null, _instanceValue);
    return ((InstanceValue) _createDefaultValue);
  }
  
  private org.eclipse.uml2.uml.Package _getRootContainer(final Property element) {
    org.eclipse.uml2.uml.Package _xblockexpression = null;
    {
      org.eclipse.uml2.uml.Package container = null;
      ValueSpecification _defaultValue = element.getDefaultValue();
      boolean _notEquals = (!Objects.equal(_defaultValue, null));
      if (_notEquals) {
        ValueSpecification _defaultValue_1 = element.getDefaultValue();
        final InstanceSpecification partInstance = ((InstanceValue) _defaultValue_1).getInstance();
        EObject _eContainer = partInstance.eContainer();
        container = ((org.eclipse.uml2.uml.Package) _eContainer);
      }
      boolean _equals = Objects.equal(container, null);
      if (_equals) {
        String _name = element.getName();
        String _plus = ("_" + _name);
        EObject _eContainer_1 = element.eContainer();
        EList<EObject> _eContents = _eContainer_1.eContents();
        final String containerName = NamingUtil.generateUniqueName(_plus, _eContents);
        final EObject partContainer = element.eContainer();
        org.eclipse.uml2.uml.Package _createPackage = this._dDS4CCMFactory.createPackage(partContainer, containerName);
        container = _createPackage;
      }
      _xblockexpression = (container);
    }
    return _xblockexpression;
  }
  
  private org.eclipse.uml2.uml.Package _getRootContainer(final Component element) {
    org.eclipse.uml2.uml.Package _xblockexpression = null;
    {
      org.eclipse.uml2.uml.Package container = null;
      final Property attr = element.getOwnedAttribute(CXRhapsodyConstants.DEFAULT_PROPERTY_INSTANCE_NAME, null);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(attr, null));
      if (!_notEquals) {
        _and = false;
      } else {
        ValueSpecification _defaultValue = attr.getDefaultValue();
        boolean _notEquals_1 = (!Objects.equal(_defaultValue, null));
        _and = (_notEquals && _notEquals_1);
      }
      if (_and) {
        ValueSpecification _defaultValue_1 = attr.getDefaultValue();
        final InstanceSpecification partInstance = ((InstanceValue) _defaultValue_1).getInstance();
        EObject _eContainer = partInstance.eContainer();
        container = ((org.eclipse.uml2.uml.Package) _eContainer);
      }
      boolean _equals = Objects.equal(container, null);
      if (_equals) {
        String _name = element.getName();
        String _plus = ("_" + _name);
        EObject _eContainer_1 = element.eContainer();
        EList<EObject> _eContents = _eContainer_1.eContents();
        final String containerName = NamingUtil.generateUniqueName(_plus, _eContents);
        final EObject partContainer = element.eContainer();
        org.eclipse.uml2.uml.Package _createPackage = this._dDS4CCMFactory.createPackage(partContainer, containerName);
        container = _createPackage;
      }
      _xblockexpression = (container);
    }
    return _xblockexpression;
  }
  
  private org.eclipse.uml2.uml.Package _getRootContainer(final org.eclipse.uml2.uml.Package element) {
    return element;
  }
  
  private org.eclipse.uml2.uml.Package _getRootContainer(final EObject element) {
    return null;
  }
  
  public void transformDeploymentValue(final EObject element, final IRPTag instance, final IRPModelElement source) {
    if (element instanceof Component) {
      _transformDeploymentValue((Component)element, instance, source);
      return;
    } else if (element instanceof Property) {
      _transformDeploymentValue((Property)element, instance, source);
      return;
    } else if (element instanceof org.eclipse.uml2.uml.Package) {
      _transformDeploymentValue((org.eclipse.uml2.uml.Package)element, instance, source);
      return;
    } else if (element != null) {
      _transformDeploymentValue(element, instance, source);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, instance, source).toString());
    }
  }
  
  private InstanceSpecification transformInstance(final Object source, final org.eclipse.uml2.uml.Package container) {
    if (source instanceof IRPInstance) {
      return _transformInstance((IRPInstance)source, container);
    } else if (source != null) {
      return _transformInstance(source, container);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, container).toString());
    }
  }
  
  private org.eclipse.uml2.uml.Package getRootContainer(final EObject element) {
    if (element instanceof Component) {
      return _getRootContainer((Component)element);
    } else if (element instanceof Property) {
      return _getRootContainer((Property)element);
    } else if (element instanceof org.eclipse.uml2.uml.Package) {
      return _getRootContainer((org.eclipse.uml2.uml.Package)element);
    } else if (element != null) {
      return _getRootContainer(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
