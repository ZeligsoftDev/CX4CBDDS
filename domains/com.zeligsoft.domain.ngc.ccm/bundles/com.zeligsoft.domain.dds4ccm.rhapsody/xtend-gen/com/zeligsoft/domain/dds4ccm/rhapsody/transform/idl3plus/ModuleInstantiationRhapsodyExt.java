package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPTemplateInstantiation;
import com.telelogic.rhapsody.core.IRPTemplateInstantiationParameter;
import com.telelogic.rhapsody.core.IRPTemplateParameter;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleBinding;
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation;
import com.zeligsoft.domain.idl3plus.api.Generics.ParameterBinding;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ModuleInstantiationRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyZDLUtil _rhapsodyZDLUtil;
  
  protected ModuleInstantiation _importModuleInstantiation(final IRPClass source, final org.eclipse.uml2.uml.Package context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.MODULE_INSTANTIATION, ModuleInstantiation.class);
    final ModuleInstantiation element = ((ModuleInstantiation) _createZDLElement);
    ZObject _createZDLElement_1 = this._dDS4CCMFactory.createZDLElement(element, "", IDL3PlusNames.MODULE_BINDING, ModuleBinding.class);
    final ModuleBinding moduleBinding = ((ModuleBinding) _createZDLElement_1);
    final IRPModelElement moduleToInstantiate = source.getOfTemplate();
    boolean _notEquals = (!Objects.equal(moduleToInstantiate, null));
    if (_notEquals) {
      TemplateBinding _asTemplateBinding = moduleBinding.asTemplateBinding();
      String _fullPathName = moduleToInstantiate.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(IDL3PlusNames.MODULE_BINDING, 
        IDL3PlusNames.MODULE_BINDING__TEMPLATE, _asTemplateBinding, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    final IRPTemplateInstantiation ti = source.getTi();
    boolean _notEquals_1 = (!Objects.equal(ti, null));
    if (_notEquals_1) {
      IRPTemplateInstantiation _ti = source.getTi();
      IRPCollection _templateInstantiationParameters = _ti.getTemplateInstantiationParameters();
      List _list = _templateInstantiationParameters.toList();
      final Procedure1<IRPTemplateInstantiationParameter> _function = new Procedure1<IRPTemplateInstantiationParameter>() {
          public void apply(final IRPTemplateInstantiationParameter p) {
            ModuleInstantiationRhapsodyExt.this.populateParameter(p, element, moduleBinding);
          }
        };
      IterableExtensions.<IRPTemplateInstantiationParameter>forEach(_list, _function);
    }
    IRPCollection _nestedElements = source.getNestedElements();
    final List packagedElements = _nestedElements.toList();
    final Procedure1<IRPModelElement> _function_1 = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement pkgE) {
          ModuleInstantiationRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(packagedElements, _function_1);
    return element;
  }
  
  protected ModuleInstantiation _importModuleInstantiation(final IRPClass source, final CORBAModule context) {
    org.eclipse.uml2.uml.Package _asPackage = context.asPackage();
    return this.importModuleInstantiation(source, _asPackage);
  }
  
  private void populateParameter(final IRPTemplateInstantiationParameter parameter, final ModuleInstantiation container, final ModuleBinding binding) {
    final ParameterBinding paramBinding = binding.addParameterBinding();
    final IRPClassifier type = parameter.getType();
    boolean _notEquals = (!Objects.equal(type, null));
    if (_notEquals) {
      TemplateParameterSubstitution _asTemplateParameterSubstitution = paramBinding.asTemplateParameterSubstitution();
      String _fullPathName = type.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(IDL3PlusNames.PARAMETER_BINDING, 
        IDL3PlusNames.PARAMETER_BINDING__TYPE, _asTemplateParameterSubstitution, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    final String paramName = parameter.getName();
    IRPModelElement _owner = parameter.getOwner();
    final IRPModelElement templateModule = _owner.getOfTemplate();
    boolean _and = false;
    boolean _notEquals_1 = (!Objects.equal(templateModule, null));
    if (!_notEquals_1) {
      _and = false;
    } else {
      boolean _isZDLConcept = this._rhapsodyZDLUtil.isZDLConcept(templateModule, IDL3PlusNames.TEMPLATE_MODULE);
      _and = (_notEquals_1 && _isZDLConcept);
    }
    if (_and) {
      IRPCollection _templateParameters = templateModule.getTemplateParameters();
      List _list = _templateParameters.toList();
      final Function1<IRPTemplateParameter,Boolean> _function = new Function1<IRPTemplateParameter,Boolean>() {
          public Boolean apply(final IRPTemplateParameter p) {
            String _name = p.getName();
            boolean _equals = _name.equals(paramName);
            return Boolean.valueOf(_equals);
          }
        };
      final Iterable<IRPTemplateParameter> params = IterableExtensions.<IRPTemplateParameter>filter(_list, _function);
      int _size = IterableExtensions.size(params);
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        TemplateParameterSubstitution _asTemplateParameterSubstitution_1 = paramBinding.asTemplateParameterSubstitution();
        IRPTemplateParameter _head = IterableExtensions.<IRPTemplateParameter>head(params);
        String _fullPathName_1 = _head.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata_1 = new ReferenceUpdateMetadata(IDL3PlusNames.PARAMETER_BINDING, 
          IDL3PlusNames.PARAMETER_BINDING__TYPE_PARAMETER, _asTemplateParameterSubstitution_1, _fullPathName_1);
        this.updateRequired.add(_referenceUpdateMetadata_1);
      }
    }
  }
  
  protected ModuleInstantiation _importModuleInstantiation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public ModuleInstantiation importModuleInstantiation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass
         && context instanceof org.eclipse.uml2.uml.Package) {
      return _importModuleInstantiation((IRPClass)source, (org.eclipse.uml2.uml.Package)context);
    } else if (source instanceof IRPClass
         && context instanceof CORBAModule) {
      return _importModuleInstantiation((IRPClass)source, (CORBAModule)context);
    } else if (source != null
         && context != null) {
      return _importModuleInstantiation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
