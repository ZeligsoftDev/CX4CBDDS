package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPTemplateParameter;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TemplateModuleRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected TemplateModule _importTemplateModule(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.TEMPLATE_MODULE, TemplateModule.class);
    final TemplateModule element = ((TemplateModule) _createZDLElement);
    IRPCollection _templateParameters = source.getTemplateParameters();
    List _list = _templateParameters.toList();
    final Procedure1<IRPTemplateParameter> _function = new Procedure1<IRPTemplateParameter>() {
        public void apply(final IRPTemplateParameter p) {
          TemplateModuleRhapsodyExt.this.populateTemplateParameter(p, element);
        }
      };
    IterableExtensions.<IRPTemplateParameter>forEach(_list, _function);
    IRPCollection _nestedElements = source.getNestedElements();
    final List packagedElements = _nestedElements.toList();
    final Procedure1<IRPModelElement> _function_1 = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement pkgE) {
          TemplateModuleRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(packagedElements, _function_1);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Package _asPackage = element.asPackage();
    this.typeCache.put(_fullPathName, _asPackage);
    return element;
  }
  
  private void populateTemplateParameter(final IRPTemplateParameter param, final TemplateModule container) {
    TemplateSignature signature = container.getSignature();
    boolean _equals = Objects.equal(signature, null);
    if (_equals) {
      ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(container, "", IDL3PlusNames.TEMPLATE_SIGNATURE, TemplateSignature.class);
      signature = ((TemplateSignature) _createZDLElement);
    }
    String constraint = param.getDeclaration();
    String _lowerCase = constraint.toLowerCase();
    boolean _contains = _lowerCase.contains("sequence");
    if (_contains) {
      constraint = "sequence";
    } else {
      boolean _equals_1 = constraint.equals("class");
      if (_equals_1) {
        constraint = "typename";
      }
    }
    final List<String> constraints = Arrays.<String>asList("typename", 
      "interface", "eventtype", "struct", "union", "sequence", 
      "array", "enum");
    boolean _contains_1 = constraints.contains(constraint);
    if (_contains_1) {
      org.eclipse.uml2.uml.Package _asPackage = container.asPackage();
      String _name = param.getName();
      final EObject result = IDL3PlusUtil.createTemplateParameter(_asPackage, _name, constraint);
      if ((result instanceof Element)) {
        IRPModelElement _owner = param.getOwner();
        String _fullPathName = _owner.getFullPathName();
        String _plus = (_fullPathName + "::");
        String _name_1 = param.getName();
        String _plus_1 = (_plus + _name_1);
        this.typeCache.put(_plus_1, ((Element) result));
      }
    }
  }
  
  protected TemplateModule _importTemplateModule(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public TemplateModule importTemplateModule(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importTemplateModule((IRPClass)source, context);
    } else if (source != null) {
      return _importTemplateModule(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
