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
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;
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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;
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
    EList<String> _filename = result.getFilename();
    String _fileName = this.fileName(impl);
    _filename.add(_fileName);
    Component _asComponent = impl.asComponent();
    EList<Operation> _ownedOperations = _asComponent.getOwnedOperations();
    final List sortedOps = BaseUtil.sortEObjectsByName(_ownedOperations);
    for (final Object op : sortedOps) {
      {
        final ZObject worker = this._zDLStandardLibrary.zObject(((Operation) op));
        if ((worker instanceof WorkerFunction)) {
          EList<CodeTag> _codetag = result.getCodetag();
          CodeTag _createCodeTag = this.createCodeTag(((WorkerFunction) worker), impl);
          CollectionExtensions.<CodeTag>addAll(_codetag, _createCodeTag);
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
    String _name = worker.getName();
    boolean _startsWith = _name.startsWith("_attr_");
    if (_startsWith) {
      EList<String> _name_1 = result.getName();
      String _name_2 = worker.getName();
      String _name_3 = worker.getName();
      int _length = _name_3.length();
      int _minus = (_length - 4);
      String _substring = _name_2.substring(6, _minus);
      _name_1.add(_substring);
    } else {
      String _name_4 = worker.getName();
      boolean _startsWith_1 = _name_4.startsWith("_pattr_");
      if (_startsWith_1) {
        EList<String> _name_5 = result.getName();
        String _name_6 = worker.getName();
        String _name_7 = worker.getName();
        int _length_1 = _name_7.length();
        int _minus_1 = (_length_1 - 4);
        String _substring_1 = _name_6.substring(7, _minus_1);
        String[] _split = _substring_1.split("___");
        String _get = _split[1];
        _name_5.add(_get);
      } else {
        String _name_8 = worker.getName();
        boolean _startsWith_2 = _name_8.startsWith("_hattr_");
        if (_startsWith_2) {
          EList<String> _name_9 = result.getName();
          String _name_10 = worker.getName();
          String _name_11 = worker.getName();
          int _length_2 = _name_11.length();
          int _minus_2 = (_length_2 - 4);
          String _substring_2 = _name_10.substring(7, _minus_2);
          String[] _split_1 = _substring_2.split("___");
          String _get_1 = _split_1[1];
          _name_9.add(_get_1);
        } else {
          boolean _prependName = this.prependName(worker);
          if (_prependName) {
            EList<String> _name_12 = result.getName();
            String _name_13 = impl.getName();
            String _name_14 = worker.getName();
            String _plus = (_name_13 + _name_14);
            _name_12.add(_plus);
          } else {
            String _name_15 = worker.getName();
            boolean _contains = _name_15.contains("_EPI_");
            if (_contains) {
              EList<String> _name_16 = result.getName();
              String _name_17 = worker.getName();
              String _replace = _name_17.replace("_EPI_", "_");
              _name_16.add(_replace);
            } else {
              EList<String> _name_18 = result.getName();
              String _name_19 = worker.getName();
              _name_18.add(_name_19);
            }
          }
        }
      }
    }
    EList<String> _uuid = result.getUuid();
    String _uuid_1 = worker.getUuid();
    _uuid.add(_uuid_1);
    EList<CodeTagType> _type = result.getType();
    CodeTagType _workerType = this.getWorkerType(worker);
    _type.add(_workerType);
    EList<String> _tag_begin = result.getTag_begin();
    String _userEditBegin = this.userEditBegin(worker, "C++");
    _tag_begin.add(_userEditBegin);
    EList<String> _contents = result.getContents();
    String _workerFunctionCode = this.workerFunctionCode(worker, "C++");
    String _xmlEncode = this.xmlEncode(_workerFunctionCode);
    _contents.add(_xmlEncode);
    EList<String> _tag_end = result.getTag_end();
    String _userEditEnd = this.userEditEnd();
    _tag_end.add(_userEditEnd);
    EList<CodeTagContext> _contextinfo = result.getContextinfo();
    CodeTagContext _createContext = this.createContext(worker);
    _contextinfo.add(_createContext);
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
    EList<String> _component_name = result.getComponent_name();
    String _workerOwnerName = this.workerOwnerName(worker);
    _component_name.add(_workerOwnerName);
    String _name = worker.getName();
    boolean _startsWith = _name.startsWith("_home_");
    if (_startsWith) {
      EList<String> _class_name = result.getClass_name();
      StringConcatenation _builder = new StringConcatenation();
      Home _home = this.getHome(worker);
      String _name_1 = _home.getName();
      _builder.append(_name_1, "");
      _builder.append("_exec_i");
      String _string = _builder.toString();
      _class_name.add(_string);
    } else {
      boolean _hasClassName = this.hasClassName(worker);
      if (_hasClassName) {
        EList<String> _class_name_1 = result.getClass_name();
        String _className = this.getClassName(worker);
        _class_name_1.add(_className);
      }
    }
    boolean _equals = Objects.equal(workerType, CodeTagType.CLASSGENERATEDOPERATIONIMPL);
    if (_equals) {
      EList<String> _operation_name = result.getOperation_name();
      EList<String> _class_name_2 = result.getClass_name();
      String _operationName = this.getOperationName(worker, _class_name_2);
      _operation_name.add(_operationName);
    }
  }
  
  public String getOperationName(final WorkerFunction worker, final EList<String> class_name) {
    String _xblockexpression = null;
    {
      String result = this.trimPrefix(worker);
      boolean _or = false;
      String _name = worker.getName();
      boolean _endsWith = _name.endsWith("destructor_operation_impl");
      if (_endsWith) {
        _or = true;
      } else {
        String _name_1 = worker.getName();
        boolean _endsWith_1 = _name_1.endsWith("constructor_operation_impl");
        _or = _endsWith_1;
      }
      if (_or) {
        boolean _isEmpty = class_name.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          String _get = class_name.get(0);
          result = _get;
        }
        String _name_2 = worker.getName();
        boolean _endsWith_2 = _name_2.endsWith("destructor_operation_impl");
        if (_endsWith_2) {
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
      NamedElement _asNamedElement = self.asNamedElement();
      String _name = _asNamedElement.getName();
      String _fileName = this.fileName(container, _name);
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
      NamedElement _asNamedElement = self.asNamedElement();
      EList<Dependency> _clientDependencies = _asNamedElement.getClientDependencies();
      final List<IDLFileDependency> filedependency = this._zListExtensions.<IDLFileDependency>typeSelect(_clientDependencies, IDLFileDependency.type);
      String _xifexpression = null;
      boolean _isEmpty = filedependency.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _xblockexpression_1 = null;
        {
          final IDLFileDependency firstFileDependency = IterableExtensions.<IDLFileDependency>head(filedependency);
          Object _zContainer = self.zContainer();
          StringConcatenation _builder = new StringConcatenation();
          IDLFileSpecification _file = firstFileDependency.getFile();
          String _filename = _file.getFilename();
          _builder.append(_filename, "");
          _builder.append("_");
          _builder.append(name, "");
          String _string = _builder.toString();
          _xblockexpression_1 = this.fileName(_zContainer, _string);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        Object _zContainer = self.zContainer();
        StringConcatenation _builder = new StringConcatenation();
        String _name = self.getName();
        _builder.append(_name, "");
        _builder.append("_");
        _builder.append(name, "");
        String _string = _builder.toString();
        _xifexpression = this.fileName(_zContainer, _string);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private String _fileName(final Void self, final String name) {
    return name;
  }
  
  private String _fileName(final com.zeligsoft.domain.zml.api.ZML_Core.NamedElement self, final String name) {
    Object _zContainer = self.zContainer();
    return this.fileName(_zContainer, name);
  }
  
  private String _fileName(final org.eclipse.uml2.uml.Package self, final String name) {
    Object _zContainer = this._zDLStandardLibrary.zContainer(self);
    return this.fileName(_zContainer, name);
  }
  
  private boolean prependName(final WorkerFunction worker) {
    boolean _xifexpression = false;
    String _name = worker.getName();
    boolean _startsWith = _name.startsWith("_home_");
    if (_startsWith) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      CodeTagType _workerTypeForNullPort = this.getWorkerTypeForNullPort(worker);
      boolean _notEquals = (!Objects.equal(_workerTypeForNullPort, CodeTagType.CLASSGENERATEDOPERATIONIMPL));
      if (_notEquals) {
        boolean _xifexpression_2 = false;
        boolean _or = false;
        String _name_1 = worker.getName();
        boolean _contains = _name_1.contains("_CSL_");
        if (_contains) {
          _or = true;
        } else {
          String _name_2 = worker.getName();
          boolean _contains_1 = _name_2.contains("_EPI_");
          _or = _contains_1;
        }
        if (_or) {
          _xifexpression_2 = false;
        } else {
          _xifexpression_2 = true;
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        boolean _xifexpression_3 = false;
        boolean _or_1 = false;
        String _name_3 = worker.getName();
        boolean _equals = _name_3.equals("_destructor_operation_impl");
        if (_equals) {
          _or_1 = true;
        } else {
          String _name_4 = worker.getName();
          boolean _equals_1 = _name_4.equals("_constructor_operation_impl");
          _or_1 = _equals_1;
        }
        if (_or_1) {
          return true;
        } else {
          boolean _switchResult = false;
          String _name_5 = worker.getName();
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_name_5, "_ccm_activate")) {
              _matched=true;
              _switchResult = true;
            }
          }
          if (!_matched) {
            if (Objects.equal(_name_5, "_ccm_passivate")) {
              _matched=true;
              _switchResult = true;
            }
          }
          if (!_matched) {
            if (Objects.equal(_name_5, "_ccm_remove")) {
              _matched=true;
              _switchResult = true;
            }
          }
          if (!_matched) {
            if (Objects.equal(_name_5, "_configuration_complete")) {
              _matched=true;
              _switchResult = true;
            }
          }
          if (!_matched) {
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
      boolean _or = false;
      boolean _or_1 = false;
      String _name = worker.getName();
      boolean _startsWith = _name.startsWith("_attr_");
      if (_startsWith) {
        _or_1 = true;
      } else {
        String _name_1 = worker.getName();
        boolean _startsWith_1 = _name_1.startsWith("_pattr_");
        _or_1 = _startsWith_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        String _name_2 = worker.getName();
        boolean _startsWith_2 = _name_2.startsWith("_hattr_");
        _or = _startsWith_2;
      }
      if (_or) {
        CodeTagType _xifexpression_2 = null;
        String _name_3 = worker.getName();
        boolean _endsWith = _name_3.endsWith("_get");
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
      Port _receivingPort = worker.getReceivingPort();
      final String portname = _receivingPort.getName();
      CodeTagType _switchResult = null;
      String _name = worker.getName();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_name, (portname + "_constructor_init_list"))) {
          _matched=true;
          _switchResult = CodeTagType.CONSTRUCTORINITLIST;
        }
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
      Object _zContainer = worker.zContainer();
      final Home home = this.getHome(_zContainer);
      final String homePrefix = this.homePrefix(home);
      CodeTagType _xifexpression = null;
      boolean _or = false;
      String _name = worker.getName();
      boolean _contains = _name.contains("_CSL_");
      if (_contains) {
        _or = true;
      } else {
        String _name_1 = worker.getName();
        boolean _contains_1 = _name_1.contains("_EPI_");
        _or = _contains_1;
      }
      if (_or) {
        CodeTagType _xifexpression_1 = null;
        String _name_2 = worker.getName();
        boolean _contains_2 = _name_2.contains("_constructor_init_list");
        if (_contains_2) {
          _xifexpression_1 = CodeTagType.CONSTRUCTORINITLIST;
        } else {
          CodeTagType _xifexpression_2 = null;
          String _name_3 = worker.getName();
          boolean _contains_3 = _name_3.contains("_class_public_methods_section_declare");
          if (_contains_3) {
            _xifexpression_2 = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          } else {
            CodeTagType _xifexpression_3 = null;
            String _name_4 = worker.getName();
            boolean _contains_4 = _name_4.contains("_class_public_methods_section_impl");
            if (_contains_4) {
              _xifexpression_3 = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
            } else {
              CodeTagType _xifexpression_4 = null;
              String _name_5 = worker.getName();
              boolean _contains_5 = _name_5.contains("_class_private_methods_section_declare");
              if (_contains_5) {
                _xifexpression_4 = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
              } else {
                CodeTagType _xifexpression_5 = null;
                String _name_6 = worker.getName();
                boolean _contains_6 = _name_6.contains("_class_private_methods_section_impl");
                if (_contains_6) {
                  _xifexpression_5 = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
                } else {
                  CodeTagType _xifexpression_6 = null;
                  String _name_7 = worker.getName();
                  boolean _contains_7 = _name_7.contains("_class_private_members_section_declare");
                  if (_contains_7) {
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
        String _name_8 = worker.getName();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_header_h")) {
            _matched=true;
            _switchResult = CodeTagType.FILEHEADERH;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_header_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEHEADERCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_footer_h")) {
            _matched=true;
            _switchResult = CodeTagType.FILEFOOTERH;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_footer_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEFOOTERCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_includes_h")) {
            _matched=true;
            _switchResult = CodeTagType.FILEINCLUDESH;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_file_includes_cpp")) {
            _matched=true;
            _switchResult = CodeTagType.FILEINCLUDESCPP;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_constructor_init_list")) {
            _matched=true;
            _switchResult = CodeTagType.CONSTRUCTORINITLIST;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_class_public_methods_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_class_public_methods_section_impl")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_class_private_methods_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_class_private_methods_section_impl")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, "_class_private_members_section_declare")) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_constructor_init_list"))) {
            _matched=true;
            _switchResult = CodeTagType.CONSTRUCTORINITLIST;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_class_public_methods_section_declare"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_class_public_methods_section_impl"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_class_private_methods_section_declare"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_class_private_methods_section_impl"))) {
            _matched=true;
            _switchResult = CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL;
          }
        }
        if (!_matched) {
          if (Objects.equal(_name_8, (homePrefix + "_class_private_members_section_declare"))) {
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
      Operation _asOperation = worker.asOperation();
      final Object owner = this._zDLStandardLibrary.zContainer(_asOperation);
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
    ComponentInterface _interface = impl.getInterface();
    return this.getHome(_interface);
  }
  
  protected Home _getHome(final CCMComponent component) {
    Home _xblockexpression = null;
    {
      Home home = null;
      Component _asComponent = component.asComponent();
      Collection<EStructuralFeature.Setting> _inverseReferences = UML2Util.getInverseReferences(_asComponent);
      for (final EStructuralFeature.Setting s : _inverseReferences) {
        boolean _and = false;
        EObject _eObject = s.getEObject();
        boolean _notEquals = (!Objects.equal(_eObject, null));
        if (!_notEquals) {
          _and = false;
        } else {
          EObject _eObject_1 = s.getEObject();
          boolean _isZDLConcept = ZDLUtil.isZDLConcept(_eObject_1, "CCM::CCM_Component::Manages");
          _and = _isZDLConcept;
        }
        if (_and) {
          EObject _eObject_2 = s.getEObject();
          Object _value = ZDLUtil.getValue(_eObject_2, "CCM::CCM_Component::Manages", "home");
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
      _builder.append(_name, "");
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
        String _name = port.getName();
        portName = _name;
      }
      boolean _notEquals_1 = (!Objects.equal(portName, null));
      if (_notEquals_1) {
        boolean _startsWith = workerName.startsWith(portName);
        if (_startsWith) {
          int _length = portName.length();
          String _substring = workerName.substring(_length);
          workerName = _substring;
        }
      }
      boolean _and = false;
      boolean _startsWith_1 = workerName.startsWith("_home");
      if (!_startsWith_1) {
        _and = false;
      } else {
        boolean _endsWith = workerName.endsWith("_create");
        _and = _endsWith;
      }
      if (_and) {
        workerName = "create";
      }
      boolean _startsWith_2 = workerName.startsWith("_");
      if (_startsWith_2) {
        String _substring_1 = workerName.substring(1);
        workerName = _substring_1;
      }
      com.zeligsoft.domain.zml.api.ZML_Component.Operation _portOperation = worker.getPortOperation();
      boolean _notEquals_2 = (!Objects.equal(_portOperation, null));
      if (_notEquals_2) {
        com.zeligsoft.domain.zml.api.ZML_Component.Operation _portOperation_1 = worker.getPortOperation();
        String _name_1 = _portOperation_1.getName();
        workerName = _name_1;
      }
      _xblockexpression = workerName;
    }
    return _xblockexpression;
  }
  
  public boolean hasClassName(final WorkerFunction worker) {
    boolean _switchResult = false;
    String _name = worker.getName();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_name, "_file_header_h")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "_file_header_cpp")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "_file_footer_h")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "_file_footer_cpp")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "_file_includes_h")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "_file_includes_cpp")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  public String getClassName(final WorkerFunction worker) {
    String _xifexpression = null;
    String _name = worker.getName();
    boolean _startsWith = _name.startsWith("_pattr_");
    if (_startsWith) {
      String _name_1 = worker.getName();
      String _name_2 = worker.getName();
      int _length = _name_2.length();
      int _minus = (_length - 4);
      String _substring = _name_1.substring(7, _minus);
      String[] _split = _substring.split("___");
      String _get = _split[0];
      _xifexpression = (_get + "_exec_i");
    } else {
      String _xifexpression_1 = null;
      String _name_3 = worker.getName();
      boolean _startsWith_1 = _name_3.startsWith("_hattr_");
      if (_startsWith_1) {
        String _name_4 = worker.getName();
        String _name_5 = worker.getName();
        int _length_1 = _name_5.length();
        int _minus_1 = (_length_1 - 4);
        String _substring_1 = _name_4.substring(7, _minus_1);
        String[] _split_1 = _substring_1.split("___");
        String _get_1 = _split_1[0];
        _xifexpression_1 = (_get_1 + "_exec_i");
      } else {
        String _xifexpression_2 = null;
        Port _receivingPort = worker.getReceivingPort();
        boolean _equals = Objects.equal(_receivingPort, null);
        if (_equals) {
          String _xblockexpression = null;
          {
            Operation _asOperation = worker.asOperation();
            final Element owner = _asOperation.getOwner();
            String _xifexpression_3 = null;
            String _name_6 = worker.getName();
            boolean _contains = _name_6.contains("_CSL_");
            if (_contains) {
              String _name_7 = worker.getName();
              String[] _split_2 = _name_7.split("_CSL_");
              String _get_2 = _split_2[0];
              _xifexpression_3 = (_get_2 + "_CSL_exec_i");
            } else {
              String _xifexpression_4 = null;
              String _name_8 = worker.getName();
              boolean _contains_1 = _name_8.contains("_EPI_");
              if (_contains_1) {
                String _name_9 = worker.getName();
                String[] _split_3 = _name_9.split("_EPI_");
                String _get_3 = _split_3[0];
                _xifexpression_4 = (_get_3 + "_exec_i");
              } else {
                String _xifexpression_5 = null;
                if ((owner instanceof NamedElement)) {
                  String _xblockexpression_1 = null;
                  {
                    final String ownerName = ((NamedElement) owner).getName();
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(ownerName, "");
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
          Port _receivingPort_1 = worker.getReceivingPort();
          _xifexpression_2 = this.getClassName(worker, _receivingPort_1);
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
      org.eclipse.uml2.uml.Port _asPort = port.asPort();
      Type _type = _asPort.getType();
      String _name = _type.getName();
      _builder.append(_name, "");
      _builder.append("ReplyHandler_");
      String _name_1 = port.getName();
      _builder.append(_name_1, "");
      _builder.append("_i");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_2 = port.getName();
      _builder_1.append(_name_2, "");
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
    Operation _asOperation = worker.asOperation();
    String _userEditBegin = UserEditableRegion.userEditBegin(_asOperation, ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY, language);
    _builder.append(_userEditBegin, "");
    _builder.newLineIfNotEmpty();
    Operation _asOperation_1 = worker.asOperation();
    Element _owner = _asOperation_1.getOwner();
    Operation _asOperation_2 = worker.asOperation();
    String _workerFunctionImplementationCode = WorkerFunctionUtil.getWorkerFunctionImplementationCode(_owner, _asOperation_2, language);
    _builder.append(_workerFunctionImplementationCode, "");
    _builder.newLineIfNotEmpty();
    String _userEditEnd = UserEditableRegion.userEditEnd();
    _builder.append(_userEditEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private String workerOwnerName(final WorkerFunction worker) {
    String _xblockexpression = null;
    {
      Operation _asOperation = worker.asOperation();
      final Element owner = _asOperation.getOwner();
      String _xifexpression = null;
      if ((owner instanceof NamedElement)) {
        String _xblockexpression_1 = null;
        {
          final String ownerName = ((NamedElement) owner).getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(ownerName, "");
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
    EObject _eObject = worker.eObject();
    return UserEditableRegion.userEditBegin(_eObject, ZMLMMNames.WORKER_FUNCTION, "body", language);
  }
  
  private String userEditEnd() {
    return UserEditableRegion.userEditEnd();
  }
  
  private String workerFunctionCode(final WorkerFunction worker, final String language) {
    Operation _asOperation = worker.asOperation();
    Element _owner = _asOperation.getOwner();
    Operation _asOperation_1 = worker.asOperation();
    return WorkerFunctionUtil.getWorkerFunctionImplementationCode(_owner, _asOperation_1, language);
  }
  
  private String xmlEncode(final String s) {
    String _replaceAll = s.replaceAll(">", "zcxgt;");
    return _replaceAll.replaceAll("\'", "zcxapos;");
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
    } else if (self instanceof com.zeligsoft.domain.zml.api.ZML_Core.NamedElement) {
      return _fileName((com.zeligsoft.domain.zml.api.ZML_Core.NamedElement)self, name);
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
