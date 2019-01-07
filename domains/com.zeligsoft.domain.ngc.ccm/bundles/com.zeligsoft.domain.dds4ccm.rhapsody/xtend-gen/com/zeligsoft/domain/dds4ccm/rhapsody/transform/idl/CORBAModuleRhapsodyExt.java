package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.IRPProfile;
import com.telelogic.rhapsody.core.IRPTag;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAModuleRhapsodyExt {
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyZDLUtil _rhapsodyZDLUtil;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected void _importPackageOrModule(final IRPPackage source, final org.eclipse.uml2.uml.Package context) {
    final String name = source.getName();
    boolean _equals = "_DeploymentValues".equals(name);
    if (_equals) {
      return;
    }
    IRPCollection _nestedElements = source.getNestedElements();
    final List packagedElements = _nestedElements.toList();
    boolean _isZDLConcept = this._rhapsodyZDLUtil.isZDLConcept(source, CORBADomainNames.CORBAMODULE);
    if (_isZDLConcept) {
      final CORBAModule module = this._dDS4CCMFactory.createCorbaModule(context, name);
      final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
          public void apply(final IRPModelElement pkgE) {
            CORBAModuleRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, module);
          }
        };
      IterableExtensions.<IRPModelElement>forEach(packagedElements, _function);
    } else {
      String _name = source.getName();
      final org.eclipse.uml2.uml.Package newPkg = context.createNestedPackage(_name);
      final IRPTag tag = source.getTag("idlGenCreateDirectory");
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(tag, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _string = Boolean.toString(false);
        String _value = tag.getValue();
        boolean _equals_1 = _string.equals(_value);
        _and = (_notEquals && _equals_1);
      }
      if (_and) {
        String _string_1 = Boolean.toString(false);
        CCMUtil.putZCXAnnotationDetail(newPkg, "generatedir", _string_1);
      }
      final Procedure1<IRPModelElement> _function_1 = new Procedure1<IRPModelElement>() {
          public void apply(final IRPModelElement pkgE) {
            CORBAModuleRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, newPkg);
          }
        };
      IterableExtensions.<IRPModelElement>forEach(packagedElements, _function_1);
    }
  }
  
  protected void _importPackageOrModule(final IRPPackage source, final CORBAModule context) {
    org.eclipse.uml2.uml.Package _asPackage = context.asPackage();
    this.importPackageOrModule(source, _asPackage);
  }
  
  protected void _importPackageOrModule(final IRPModelElement source, final Object context) {
  }
  
  protected void _importPackageOrModule(final IRPProfile source, final Object context) {
  }
  
  public void importPackageOrModule(final IRPModelElement source, final Object context) {
    if (source instanceof IRPProfile
         && context != null) {
      _importPackageOrModule((IRPProfile)source, context);
      return;
    } else if (source instanceof IRPPackage
         && context instanceof org.eclipse.uml2.uml.Package) {
      _importPackageOrModule((IRPPackage)source, (org.eclipse.uml2.uml.Package)context);
      return;
    } else if (source instanceof IRPPackage
         && context instanceof CORBAModule) {
      _importPackageOrModule((IRPPackage)source, (CORBAModule)context);
      return;
    } else if (source != null
         && context != null) {
      _importPackageOrModule(source, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
