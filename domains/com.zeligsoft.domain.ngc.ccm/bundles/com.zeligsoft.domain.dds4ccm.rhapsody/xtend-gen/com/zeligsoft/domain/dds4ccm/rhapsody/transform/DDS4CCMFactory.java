package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.google.common.base.Objects;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class DDS4CCMFactory {
  public CORBAModule createCorbaModule(final org.eclipse.uml2.uml.Package container, final String name) {
    final org.eclipse.uml2.uml.Package module = this.createCorbaModuleHelper(container, name);
    return ZDLFactoryRegistry.INSTANCE.<CORBAModule>create(module, CORBAModule.class);
  }
  
  public CORBAModule createCorbaModule(final CORBAModule container, final String name) {
    org.eclipse.uml2.uml.Package _asPackage = container.asPackage();
    final org.eclipse.uml2.uml.Package module = this.createCorbaModuleHelper(_asPackage, name);
    return ZDLFactoryRegistry.INSTANCE.<CORBAModule>create(module, CORBAModule.class);
  }
  
  private org.eclipse.uml2.uml.Package createCorbaModuleHelper(final org.eclipse.uml2.uml.Package container, final String name) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(container, name);
    final org.eclipse.uml2.uml.Package _result;
    synchronized (_createCache_createCorbaModuleHelper) {
      if (_createCache_createCorbaModuleHelper.containsKey(_cacheKey)) {
        return _createCache_createCorbaModuleHelper.get(_cacheKey);
      }
      org.eclipse.uml2.uml.Package _createNestedPackage = container.createNestedPackage(name);
      _result = _createNestedPackage;
      _createCache_createCorbaModuleHelper.put(_cacheKey, _result);
    }
    _init_createCorbaModuleHelper(_result, container, name);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,org.eclipse.uml2.uml.Package> _createCache_createCorbaModuleHelper = CollectionLiterals.newHashMap();
  
  private void _init_createCorbaModuleHelper(final org.eclipse.uml2.uml.Package module, final org.eclipse.uml2.uml.Package container, final String name) {
    ZDLUtil.addZDLConcept(module, CORBADomainNames.CORBAMODULE);
  }
  
  public org.eclipse.uml2.uml.Package _createPackage(final org.eclipse.uml2.uml.Package container, final String name) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(container, name);
    final org.eclipse.uml2.uml.Package _result;
    synchronized (_createCache_createPackage) {
      if (_createCache_createPackage.containsKey(_cacheKey)) {
        return _createCache_createPackage.get(_cacheKey);
      }
      org.eclipse.uml2.uml.Package _createNestedPackage = container.createNestedPackage(name);
      _result = _createNestedPackage;
      _createCache_createPackage.put(_cacheKey, _result);
    }
    _init_createPackage(_result, container, name);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,org.eclipse.uml2.uml.Package> _createCache_createPackage = CollectionLiterals.newHashMap();
  
  private void _init_createPackage(final org.eclipse.uml2.uml.Package pkg, final org.eclipse.uml2.uml.Package container, final String name) {
  }
  
  public org.eclipse.uml2.uml.Package _createPackage(final Component container, final String name) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(container, name);
    final org.eclipse.uml2.uml.Package _result;
    synchronized (_createCache_createPackage_1) {
      if (_createCache_createPackage_1.containsKey(_cacheKey)) {
        return _createCache_createPackage_1.get(_cacheKey);
      }
      org.eclipse.uml2.uml.Package _createComponentPackage = this.createComponentPackage(container, name);
      _result = _createComponentPackage;
      _createCache_createPackage_1.put(_cacheKey, _result);
    }
    _init_createPackage_1(_result, container, name);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,org.eclipse.uml2.uml.Package> _createCache_createPackage_1 = CollectionLiterals.newHashMap();
  
  private void _init_createPackage_1(final org.eclipse.uml2.uml.Package pkg, final Component container, final String name) {
  }
  
  public org.eclipse.uml2.uml.Package _createPackage(final EObject container, final String name) {
    return null;
  }
  
  public org.eclipse.uml2.uml.Package createNestedPackage(final CORBAModule container, final String name) {
    org.eclipse.uml2.uml.Package _asPackage = container.asPackage();
    org.eclipse.uml2.uml.Package _createNestedPackage = _asPackage.createNestedPackage(name);
    return _createNestedPackage;
  }
  
  public org.eclipse.uml2.uml.Package createComponentPackage(final Component container, final String name) {
    EClass _package = UMLPackage.eINSTANCE.getPackage();
    PackageableElement _createPackagedElement = container.createPackagedElement(name, _package);
    return ((org.eclipse.uml2.uml.Package) _createPackagedElement);
  }
  
  public ConnectorStatusListenerConnection createConnectorStatusListenerConnection(final AssemblyImplementation container, final String name) {
    Component _asComponent = container.asComponent();
    final Connector conn = _asComponent.createOwnedConnector(name);
    conn.setKind(ConnectorKind.ASSEMBLY_LITERAL);
    ZDLUtil.addZDLConcept(conn, DDS4CCMNames.CONNECTOR_STATUS_LISTENER_CONNECTION);
    return ZDLFactoryRegistry.INSTANCE.<ConnectorStatusListenerConnection>create(conn, ConnectorStatusListenerConnection.class);
  }
  
  public ZObject _createZDLElement(final EObject container, final String name, final String concept, final Class type) {
    try {
      final EObject element = ZDLUtil.createZDLConceptIn(container, concept);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(name, ""));
      if (!_notEquals) {
        _and = false;
      } else {
        _and = (_notEquals && (element instanceof NamedElement));
      }
      if (_and) {
        ((NamedElement) element).setName(name);
      }
      return ZDLFactoryRegistry.INSTANCE.<ZObject>create(element, type);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public ZObject _createZDLElement(final Object container, final String name, final String concept, final Class type) {
    return null;
  }
  
  public ZObject _createZDLElement(final ZObject container, final String name, final String concept, final Class type) {
    EObject _eObject = container.eObject();
    ZObject _createZDLElement = this.createZDLElement(_eObject, name, concept, type);
    return _createZDLElement;
  }
  
  public org.eclipse.uml2.uml.Package createPackage(final EObject container, final String name) {
    if (container instanceof Component) {
      return _createPackage((Component)container, name);
    } else if (container instanceof org.eclipse.uml2.uml.Package) {
      return _createPackage((org.eclipse.uml2.uml.Package)container, name);
    } else if (container != null) {
      return _createPackage(container, name);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(container, name).toString());
    }
  }
  
  public ZObject createZDLElement(final Object container, final String name, final String concept, final Class type) {
    if (container instanceof EObject) {
      return _createZDLElement((EObject)container, name, concept, type);
    } else if (container instanceof ZObject) {
      return _createZDLElement((ZObject)container, name, concept, type);
    } else if (container != null) {
      return _createZDLElement(container, name, concept, type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(container, name, concept, type).toString());
    }
  }
}
