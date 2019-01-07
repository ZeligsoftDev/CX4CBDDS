package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPOperation;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAOperation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAOperationRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected CORBAOperation _importCorbaOperation(final IRPOperation source, final Object context) {
    final String name = source.getName();
    IRPCollection _arguments = source.getArguments();
    final List parameters = _arguments.toList();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAOPERATION, CORBAOperation.class);
    final CORBAOperation operation = ((CORBAOperation) _createZDLElement);
    boolean _notEquals = (!Objects.equal(operation, null));
    if (_notEquals) {
      final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
          public void apply(final IRPModelElement pkgE) {
            CORBAOperationRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, operation);
          }
        };
      IterableExtensions.<IRPModelElement>forEach(parameters, _function);
      IRPClassifier _returns = source.getReturns();
      boolean _notEquals_1 = (!Objects.equal(_returns, null));
      if (_notEquals_1) {
        Operation _asOperation = operation.asOperation();
        IRPClassifier _returns_1 = source.getReturns();
        String _fullPathName = _returns_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBAOPERATION, 
          CORBADomainNames.CORBATYPED__IDL_TYPE, _asOperation, _fullPathName);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
    }
    return operation;
  }
  
  protected CORBAOperation _importCorbaOperation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAOperation importCorbaOperation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPOperation) {
      return _importCorbaOperation((IRPOperation)source, context);
    } else if (source != null) {
      return _importCorbaOperation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
