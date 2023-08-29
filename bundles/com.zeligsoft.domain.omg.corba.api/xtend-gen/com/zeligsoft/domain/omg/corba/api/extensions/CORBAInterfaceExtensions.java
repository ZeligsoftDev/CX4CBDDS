package com.zeligsoft.domain.omg.corba.api.extensions;

import com.google.inject.Inject;
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions;
import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CORBAInterfaceExtensions {
  @Inject
  @Extension
  private ZListExtensions _zListExtensions;

  public List<CXInterface> generals(final CXInterface intf) {
    return this._zListExtensions.<CXInterface>typeSelect(intf.asInterface().getGenerals(), CXInterface.type);
  }
}
