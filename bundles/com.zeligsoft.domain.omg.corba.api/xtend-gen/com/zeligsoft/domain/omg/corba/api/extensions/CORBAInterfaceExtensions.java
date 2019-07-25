package com.zeligsoft.domain.omg.corba.api.extensions;

import com.google.inject.Inject;
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;

@SuppressWarnings("all")
public class CORBAInterfaceExtensions {
  @Inject
  private ZListExtensions _zListExtensions;
  
  public List<CORBAInterface> generals(final CORBAInterface self) {
    Interface _asInterface = self.asInterface();
    EList<Classifier> _generals = _asInterface.getGenerals();
    List<CORBAInterface> _typeSelect = this._zListExtensions.<CORBAInterface>typeSelect(_generals, CORBAInterface.type);
    return _typeSelect;
  }
}
