package com.zeligsoft.domain.dds4ccm.codegen.xtend;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions;
import com.zeligsoft.base.zdl.staticapi.xtend.ZDLStandardLibrary;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoFactory;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.HomeImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.util.WorkerFunctionUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MainTransform {
  @Inject
  @Extension
  private ZListExtensions _zListExtensions;
  
  @Inject
  @Extension
  private ZDLStandardLibrary _zDLStandardLibrary;
  
  public CodeTagInfo mainTransform(final MonolithicImplementation impl) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(impl);
    final CodeTagInfo _result;
    synchronized (_createCache_mainTransform) {
      if (_createCache_mainTransform.containsKey(_cacheKey)) {
        return _createCache_mainTransform.get(_cacheKey);
      }
      CodeTagInfo _createCodeTagInfo = CodetaginfoFactory.eINSTANCE.createCodeTagInfo();
      _result = _createCodeTagInfo;
      _createCache_mainTransform.put(_cacheKey, _result);
    }
    _init_mainTransform(_result, impl);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CodeTagInfo> _createCache_mainTransform = CollectionLiterals.newHashMap();
  
  private void _init_mainTransform(final CodeTagInfo result, final MonolithicImplementation impl) {
    result.getFilename().add(this.fileName(impl));
    final List sortedOps = BaseUtil.sortEObjectsByName(impl.asComponent().getOwnedOperations());
    for (final Object op : sortedOps) {
      {
        final ZObject worker = this._zDLStandardLibrary.zObject(((Operation) op));
        if ((worker instanceof WorkerFunction)) {
          CollectionExtensions.<CodeTag>addAll(result.getCodetag(), this.createCodeTag(((WorkerFunction) worker), impl));
        }
      }
    }
  }
  
  public CodeTag createCodeTag(final WorkerFunction worker, final MonolithicImplementation impl) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(worker, impl);
    final CodeTag _result;
    synchronized (_createCache_createCodeTag) {
      if (_createCache_createCodeTag.containsKey(_cacheKey)) {
        return _createCache_createCodeTag.get(_cacheKey);
      }
      CodeTag _createCodeTag = CodetaginfoFactory.eINSTANCE.createCodeTag();
      _result = _createCodeTag;
      _createCache_createCodeTag.put(_cacheKey, _result);
    }
    _init_createCodeTag(_result, worker, impl);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CodeTag> _createCache_createCodeTag = CollectionLiterals.newHashMap();
  
  private void _init_createCodeTag(final CodeTag result, final WorkerFunction worker, final MonolithicImplementation impl) {
    boolean _startsWith = worker.getName().startsWith("_attr_");
    if (_startsWith) {
      String _name = worker.getName();
      int _length = worker.getName().length();
      int _minus = (_length - 4);
      result.getName().add(_name.substring(6, _minus));
    } else {
      boolean _startsWith_1 = worker.getName().startsWith("_pattr_");
      if (_startsWith_1) {
        String _name_1 = worker.getName();
        int _length_1 = worker.getName().length();
        int _minus_1 = (_length_1 - 4);
        result.getName().add(_name_1.substring(7, _minus_1).split("___")[1]);
      } else {
        boolean _startsWith_2 = worker.getName().startsWith("_hattr_");
        if (_startsWith_2) {
          String _name_2 = worker.getName();
          int _length_2 = worker.getName().length();
          int _minus_2 = (_length_2 - 4);
          result.getName().add(_name_2.substring(7, _minus_2).split("___")[1]);
        } else {
          boolean _prependName = this.prependName(worker);
          if (_prependName) {
            EList<String> _name_3 = result.getName();
            String _name_4 = impl.getName();
            String _name_5 = worker.getName();
            String _plus = (_name_4 + _name_5);
            _name_3.add(_plus);
          } else {
            boolean _contains = worker.getName().contains("_EPI_");
            if (_contains) {
              result.getName().add(worker.getName().replace("_EPI_", "_"));
            } else {
              result.getName().add(worker.getName());
            }
          }
        }
      }
    }
    result.getUuid().add(worker.getUuid());
    result.getType().add(this.getWorkerType(worker));
    result.getTag_begin().add(this.userEditBegin(worker, "C++"));
    result.getContents().add(this.xmlEncode(this.workerFunctionCode(worker, "C++")));
    result.getTag_end().add(this.userEditEnd());
    result.getContextinfo().add(this.createContext(worker));
  }
  
  public CodeTagContext createContext(final WorkerFunction worker) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(worker);
    final CodeTagContext _result;
    synchronized (_createCache_createContext) {
      if (_createCache_createContext.containsKey(_cacheKey)) {
        return _createCache_createContext.get(_cacheKey);
      }
      CodeTagContext _createCodeTagContext = CodetaginfoFactory.eINSTANCE.createCodeTagContext();
      _result = _createCodeTagContext;
      _createCache_createContext.put(_cacheKey, _result);
    }
    _init_createContext(_result, worker);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CodeTagContext> _createCache_createContext = CollectionLiterals.newHashMap();
  
  private void _init_createContext(final CodeTagContext result, final WorkerFunction worker) {
    final CodeTagType workerType = this.getWorkerType(worker);
    result.getComponent_name().add(this.workerOwnerName(worker));
    boolean _startsWith = worker.getName().startsWith("_home_");
    if (_startsWith) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = this.getHome(worker).getName();
      _builder.append(_name);
      _builder.append("_exec_i");
      result.getClass_name().add(_builder.toString());
    } else {
      boolean _hasClassName = this.hasClassName(worker);
      if (_hasClassName) {
        result.getClass_name().add(this.getClassName(worker));
      }
    }
    boolean _equals = Objects.equal(workerType, CodeTagType.CLASSGENERATEDOPERATIONIMPL);
    if (_equals) {
      result.getOperation_name().add(this.getOperationName(worker, result.getClass_name()));
    }
  }
  
  public String getOperationName(final WorkerFunction worker, final EList<String> class_name) {
    String _xblockexpression = null;
    {
      String result = this.trimPrefix(worker);
      if ((worker.getName().endsWith("destructor_operation_impl") || worker.getName().endsWith("constructor_operation_impl"))) {
        boolean _isEmpty = class_name.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          result = class_name.get(0);
        }
        boolean _endsWith = worker.getName().endsWith("destructor_operation_impl");
        if (_endsWith) {
          result = ("~" + result);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private String _fileName(final MonolithicImplementation self) {
    String _xblockexpression = null;
    {
      final Object container = self.zContainer();
      String _fileName = this.fileName(container, self.asNamedElement().getName());
      _xblockexpression = (_fileName + ".taginfo.xml");
    }
    return _xblockexpression;
  }
  
  private String _fileName(final ComponentInterface self) {
    throw new IllegalArgumentException("Shouldn\'t be getting filenames for raw ComponentInterface");
  }
  
  private String _fileName(final Object self, final String name) {
    return name;
  }
  
  private String _fileName(final CORBAModule self, final String name) {
    String _xblockexpression = null;
    {
      final List<IDLFileDependency> filedependency = this._zListExtensions.<IDLFileDependency>typeSelect(self.asNamedElement().getClientDependencies(), IDLFileDependency.type);
      String _xifexpression = null;
      boolean _isEmpty = filedependency.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _xblockexpression_1 = null;
        {
          final IDLFileDependency firstFileDependency = IterableExtensions.<IDLFileDependency>head(filedependency);
          StringConcatenation _builder = new StringConcatenation();
          String _filename = firstFileDependency.getFile().getFilename();
          _builder.append(_filename);
          _builder.append("_");
          _builder.append(name);
          _xblockexpression_1 = this.fileName(self.zContainer(), _builder.toString());
        }
        _xifexpression = _xblockexpression_1;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        String _name = self.getName();
        _builder.append(_name);
        _builder.append("_");
        _builder.append(name);
        _xifexpression = this.fileName(self.zContainer(), _builder.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private String _fileName(final Void self, final String name) {
    return name;
  }
  
  private String _fileName(final NamedElement self, final String name) {
    return this.fileName(self.zContainer(), name);
  }
  
  private String _fileName(final org.eclipse.uml2.uml.Package self, final String name) {
    return this.fileName(this._zDLStandardLibrary.zContainer(self), name);
  }
  
  private boolean prependName(final WorkerFunction worker) {
    boolean _xifexpression = false;
    boolean _startsWith = worker.getName().startsWith("_home_");
    if (_startsWith) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      CodeTagType _workerTypeForNullPort = this.getWorkerTypeForNullPort(worker);
      boolean _notEquals = (!Objects.equal(_workerTypeForNullPort, CodeTagType.CLASSGENERATEDOPERATIONIMPL));
      if (_notEquals) {
        boolean _xifexpression_2 = false;
        if ((worker.getName().contains("_CSL_") || worker.getName().contains("_EPI_"))) {
          _xifexpression_2 = false;
        } else {
          _xifexpression_2 = true;
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        boolean _xifexpression_3 = false;
        if ((worker.getName().equals("_destructor_operation_impl") || worker.getName().equals("_constructor_operation_impl"))) {
          return true;
        } else {
          boolean _switchResult = false;
          String _name = worker.getName();
          if (_name != null) {
            switch (_name) {
              case "_ccm_activate":
                _switchResult = true;
                break;
              case "_ccm_passivate":
                _switchResult = true;
                break;
              case "_ccm_remove":
                _switchResult = true;
                break;
              case "_configuration_complete":
                _switchResult = true;
                break;
              default:
                _switchResult = false;
                break;
            }
          } else {
            _switchResult = false;
          }
          _xifexpression_3 = _switchResult;
        }
        _xifexpression_1 = _xifexpression_3;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CodeTagType getWorkerType(final WorkerFunction worker) {
    CodeTagType _xifexpression = null;
    Port _receivingPort = worker.getReceivingPort();
    boolean _notEquals = (!Objects.equal(_receivingPort, null));
    if (_notEquals) {
      _xifexpression = this.getWorkerTypeForNonNullPort(worker);
    } else {
      CodeTagType _xifexpression_1 = null;
      if (((worker.getName().startsWith("_attr_") || 
        worker.getName().startsWith("_pattr_")) || 
        worker.getName().startsWith("_hattr_"))) {
        CodeTagType _xifexpression_2 = null;
        boolean _endsWith = worker.getName().endsWith("_get");
        if (_endsWith) {
          _xifexpression_2 = CodeTagType.CLASSGENERATEDATTRIBUTEGET;
        } else {
          _xifexpression_2 = CodeTagType.CLASSGENERATEDATTRIBUTESET;
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        _xifexpression_1 = this.getWorkerTypeForNullPort(worker);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CodeTagType getWorkerTypeForNonNullPort(final WorkerFunction worker) {
    CodeTagType _xblockexpression = null;
    {
      final String portname = worker.getReceivingPort().getName();
      CodeTagType _switchResult = null;
      String _name = worker.getName();
      boolean _matched = false;
      if (Objects.equal(_name, (portname + "_constructor_init_list"))) {
        _matched=true;
        _switchResult = CodeTagType.CONSTRUCTORINITLIST;
      }
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_class_public_methods_section_declare"))) {
          _matched=true;
          _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_class_public_methods_section_impl"))) {
          _matched=true;
          _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_class_private_methods_section_declare"))) {
          _matched=true;
          _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_class_private_methods_section_impl"))) {
          _matched=true;
          _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_class_private_members_section_declare"))) {
          _matched=true;
          _switchResult = CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE;
        }
      }
      if (!_matched) {
        _switchResult = CodeTagType.CLASSGENERATEDOPERATIONIMPL;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public CodeTagType getWorkerTypeForNullPort(final WorkerFunction worker) {
    CodeTagType _xblockexpression = null;
    {
      final Home home = this.getHome(worker.zContainer());
      final String homePrefix = this.homePrefix(home);
      CodeTagType _xifexpression = null;
      if ((worker.getName().contains("_CSL_") || worker.getName().contains("_EPI_"))) {
        CodeTagType _xifexpression_1 = null;
        boolean _contains = worker.getName().contains("_constructor_init_list");
        if (_contains) {
          _xifexpression_1 = CodeTagType.CONSTRUCTORINITLIST;
        } else {
          CodeTagType _xifexpression_2 = null;
          boolean _contains_1 = worker.getName().contains("_class_public_methods_section_declare");
          if (_contains_1) {
            _xifexpression_2 = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          } else {
            CodeTagType _xifexpression_3 = null;
            boolean _contains_2 = worker.getName().contains("_class_public_methods_section_impl");
            if (_contains_2) {
              _xifexpression_3 = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
            } else {
              CodeTagType _xifexpression_4 = null;
              boolean _contains_3 = worker.getName().contains("_class_private_methods_section_declare");
              if (_contains_3) {
                _xifexpression_4 = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
              } else {
                CodeTagType _xifexpression_5 = null;
                boolean _contains_4 = worker.getName().contains("_class_private_methods_section_impl");
                if (_contains_4) {
                  _xifexpression_5 = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
                } else {
                  CodeTagType _xifexpression_6 = null;
                  boolean _contains_5 = worker.getName().contains("_class_private_members_section_declare");
                  if (_contains_5) {
                    _xifexpression_6 = CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE;
                  } else {
                    _xifexpression_6 = CodeTagType.CLASSGENERATEDOPERATIONIMPL;
                  }
                  _xifexpression_5 = _xifexpression_6;
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        CodeTagType _switchResult = null;
        String _name = worker.getName();
        boolean _matched = false;
        if (Objects.equal(_name, "_file_header_h")) {
          _matched=true;
          _switchResult = CodeTagType.FILEHEADERH;
        }
        if (!_matched) {
          if (Objects.equal(_name, "_file_header_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEHEADERCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_file_footer_h")) {
            _matched=true;
            _switchResult = CodeTagType.FILEFOOTERH;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_file_footer_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEFOOTERCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_file_includes_h")) {
            _matched=true;
            _switchResult = CodeTagType.FILEINCLUDESH;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_file_includes_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEINCLUDESCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_constructor_init_list")) {
            _matched=true;
            _switchResult = CodeTagType.CONSTRUCTORINITLIST;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_class_public_methods_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_class_public_methods_section_impl")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_class_private_methods_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_class_private_methods_section_impl")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, "_class_private_members_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_constructor_init_list"))) {
            _matched=true;
            _switchResult = CodeTagType.CONSTRUCTORINITLIST;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_class_public_methods_section_declare"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_class_public_methods_section_impl"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_class_private_methods_section_declare"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_class_private_methods_section_impl"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name, (homePrefix + "_class_private_members_section_declare"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          _switchResult = CodeTagType.CLASSGENERATEDOPERATIONIMPL;
        }
        _xifexpression = _switchResult;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Home _getHome(final WorkerFunction worker) {
    Home _xblockexpression = null;
    {
      final Object owner = this._zDLStandardLibrary.zContainer(worker.asOperation());
      boolean _equals = Objects.equal(owner, null);
      if (_equals) {
        throw new IllegalArgumentException("Worker needs to have an owner");
      }
      if ((!(owner instanceof MonolithicImplementation))) {
        throw new IllegalArgumentException("Worker needs an owner that is a MonolithicImplementation");
      }
      _xblockexpression = this.getHome(((MonolithicImplementation) owner));
    }
    return _xblockexpression;
  }
  
  protected Home _getHome(final MonolithicImplementation impl) {
    return this.getHome(impl.getInterface());
  }
  
  protected Home _getHome(final CCMComponent component) {
    Home _xblockexpression = null;
    {
      Home home = null;
      Collection<EStructuralFeature.Setting> _inverseReferences = UML2Util.getInverseReferences(component.asComponent());
      for (final EStructuralFeature.Setting s : _inverseReferences) {
        if (((!Objects.equal(s.getEObject(), null)) && ZDLUtil.isZDLConcept(s.getEObject(), "CCM::CCM_Component::Manages"))) {
          Object _value = ZDLUtil.getValue(s.getEObject(), "CCM::CCM_Component::Manages", "home");
          final EObject value = ((EObject) _value);
          HomeImplementation _homeImplementation = new HomeImplementation(value);
          home = _homeImplementation;
        }
      }
      _xblockexpression = home;
    }
    return _xblockexpression;
  }
  
  protected Home _getHome(final Object component) {
    return null;
  }
  
  public String homePrefix(final Home home) {
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(home, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_home_");
      String _name = home.getName();
      _builder.append(_name);
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public String trimPrefix(final WorkerFunction worker) {
    String _xblockexpression = null;
    {
      String workerName = worker.getName();
      final Port port = worker.getReceivingPort();
      String portName = null;
      boolean _notEquals = (!Objects.equal(port, null));
      if (_notEquals) {
        portName = port.getName();
      }
      boolean _notEquals_1 = (!Objects.equal(portName, null));
      if (_notEquals_1) {
        boolean _startsWith = workerName.startsWith(portName);
        if (_startsWith) {
          workerName = workerName.substring(portName.length());
        }
      }
      if ((workerName.startsWith("_home") && workerName.endsWith("_create"))) {
        workerName = "create";
      }
      boolean _startsWith_1 = workerName.startsWith("_");
      if (_startsWith_1) {
        workerName = workerName.substring(1);
      }
      com.zeligsoft.domain.zml.api.ZML_Component.Operation _portOperation = worker.getPortOperation();
      boolean _notEquals_2 = (!Objects.equal(_portOperation, null));
      if (_notEquals_2) {
        workerName = worker.getPortOperation().getName();
      }
      _xblockexpression = workerName;
    }
    return _xblockexpression;
  }
  
  public boolean hasClassName(final WorkerFunction worker) {
    boolean _switchResult = false;
    String _name = worker.getName();
    if (_name != null) {
      switch (_name) {
        case "_file_header_h":
          _switchResult = false;
          break;
        case "_file_header_cpp":
          _switchResult = false;
          break;
        case "_file_footer_h":
          _switchResult = false;
          break;
        case "_file_footer_cpp":
          _switchResult = false;
          break;
        case "_file_includes_h":
          _switchResult = false;
          break;
        case "_file_includes_cpp":
          _switchResult = false;
          break;
        default:
          _switchResult = true;
          break;
      }
    } else {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  public String getClassName(final WorkerFunction worker) {
    String _xifexpression = null;
    boolean _startsWith = worker.getName().startsWith("_pattr_");
    if (_startsWith) {
      String _name = worker.getName();
      int _length = worker.getName().length();
      int _minus = (_length - 4);
      String _get = _name.substring(7, _minus).split("___")[0];
      _xifexpression = (_get + "_exec_i");
    } else {
      String _xifexpression_1 = null;
      boolean _startsWith_1 = worker.getName().startsWith("_hattr_");
      if (_startsWith_1) {
        String _name_1 = worker.getName();
        int _length_1 = worker.getName().length();
        int _minus_1 = (_length_1 - 4);
        String _get_1 = _name_1.substring(7, _minus_1).split("___")[0];
        _xifexpression_1 = (_get_1 + "_exec_i");
      } else {
        String _xifexpression_2 = null;
        Port _receivingPort = worker.getReceivingPort();
        boolean _equals = Objects.equal(_receivingPort, null);
        if (_equals) {
          String _xblockexpression = null;
          {
            final Element owner = worker.asOperation().getOwner();
            String _xifexpression_3 = null;
            boolean _contains = worker.getName().contains("_CSL_");
            if (_contains) {
              String _get_2 = worker.getName().split("_CSL_")[0];
              _xifexpression_3 = (_get_2 + "_CSL_exec_i");
            } else {
              String _xifexpression_4 = null;
              boolean _contains_1 = worker.getName().contains("_EPI_");
              if (_contains_1) {
                String _get_3 = worker.getName().split("_EPI_")[0];
                _xifexpression_4 = (_get_3 + "_exec_i");
              } else {
                String _xifexpression_5 = null;
                if ((owner instanceof org.eclipse.uml2.uml.NamedElement)) {
                  String _xblockexpression_1 = null;
                  {
                    final String ownerName = ((org.eclipse.uml2.uml.NamedElement) owner).getName();
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(ownerName);
                    _builder.append("_exec_i");
                    _xblockexpression_1 = _builder.toString();
                  }
                  _xifexpression_5 = _xblockexpression_1;
                } else {
                  throw new IllegalArgumentException();
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xblockexpression = _xifexpression_3;
          }
          _xifexpression_2 = _xblockexpression;
        } else {
          _xifexpression_2 = this.getClassName(worker, worker.getReceivingPort());
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _getClassName(final WorkerFunction worker, final InterfacePort port) {
    String _xifexpression = null;
    Boolean _isConjugated = port.getIsConjugated();
    if ((_isConjugated).booleanValue()) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("AMI4CCM_");
      String _name = port.asPort().getType().getName();
      _builder.append(_name);
      _builder.append("ReplyHandler_");
      String _name_1 = port.getName();
      _builder.append(_name_1);
      _builder.append("_i");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_2 = port.getName();
      _builder_1.append(_name_2);
      _builder_1.append("_exec_i");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  protected String _getClassName(final WorkerFunction worker, final Port port) {
    throw new UnsupportedOperationException();
  }
  
  public CharSequence getContents(final WorkerFunction worker) {
    return this.workerCode(worker, "C++");
  }
  
  private CharSequence workerCode(final WorkerFunction worker, final String language) {
    StringConcatenation _builder = new StringConcatenation();
    String _userEditBegin = UserEditableRegion.userEditBegin(worker.asOperation(), ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY, language);
    _builder.append(_userEditBegin);
    _builder.newLineIfNotEmpty();
    String _workerFunctionImplementationCode = WorkerFunctionUtil.getWorkerFunctionImplementationCode(worker.asOperation().getOwner(), worker.asOperation(), language);
    _builder.append(_workerFunctionImplementationCode);
    _builder.newLineIfNotEmpty();
    String _userEditEnd = UserEditableRegion.userEditEnd();
    _builder.append(_userEditEnd);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private String workerOwnerName(final WorkerFunction worker) {
    String _xblockexpression = null;
    {
      final Element owner = worker.asOperation().getOwner();
      String _xifexpression = null;
      if ((owner instanceof org.eclipse.uml2.uml.NamedElement)) {
        String _xblockexpression_1 = null;
        {
          final String ownerName = ((org.eclipse.uml2.uml.NamedElement) owner).getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(ownerName);
          _xblockexpression_1 = _builder.toString();
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private String userEditBegin(final WorkerFunction worker, final String language) {
    return UserEditableRegion.userEditBegin(worker.eObject(), ZMLMMNames.WORKER_FUNCTION, "body", language);
  }
  
  private String userEditEnd() {
    return UserEditableRegion.userEditEnd();
  }
  
  private String workerFunctionCode(final WorkerFunction worker, final String language) {
    return WorkerFunctionUtil.getWorkerFunctionImplementationCode(worker.asOperation().getOwner(), worker.asOperation(), language);
  }
  
  private String xmlEncode(final String s) {
    return s.replaceAll(">", "zcxgt;").replaceAll("\'", "zcxapos;");
  }
  
  private String fileName(final ZObject self) {
    if (self instanceof MonolithicImplementation) {
      return _fileName((MonolithicImplementation)self);
    } else if (self instanceof ComponentInterface) {
      return _fileName((ComponentInterface)self);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(self).toString());
    }
  }
  
  private String fileName(final Object self, final String name) {
    if (self instanceof org.eclipse.uml2.uml.Package) {
      return _fileName((org.eclipse.uml2.uml.Package)self, name);
    } else if (self instanceof CORBAModule) {
      return _fileName((CORBAModule)self, name);
    } else if (self instanceof NamedElement) {
      return _fileName((NamedElement)self, name);
    } else if (self == null) {
      return _fileName((Void)null, name);
    } else if (self != null) {
      return _fileName(self, name);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(self, name).toString());
    }
  }
  
  public Home getHome(final Object component) {
    if (component instanceof CCMComponent) {
      return _getHome((CCMComponent)component);
    } else if (component instanceof WorkerFunction) {
      return _getHome((WorkerFunction)component);
    } else if (component instanceof MonolithicImplementation) {
      return _getHome((MonolithicImplementation)component);
    } else if (component != null) {
      return _getHome(component);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(component).toString());
    }
  }
  
  public String getClassName(final WorkerFunction worker, final Port port) {
    if (port instanceof InterfacePort) {
      return _getClassName(worker, (InterfacePort)port);
    } else if (port != null) {
      return _getClassName(worker, port);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(worker, port).toString());
    }
  }
}
