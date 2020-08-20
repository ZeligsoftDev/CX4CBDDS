package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import java.util.Arrays;

@SuppressWarnings("all")
public class ZDLGenExtensions {
  protected GenDomainModel _domainModel(final GenDomainConcept concept) {
    return this.domainModel(concept.getBlock());
  }
  
  protected GenDomainModel _domainModel(final GenDomainBlock block) {
    return this.domainModel(block.eContainer());
  }
  
  protected GenDomainModel _domainModel(final GenDomainPackage pkg) {
    return this.domainModel(pkg.eContainer());
  }
  
  protected GenDomainModel _domainModel(final GenDomainModel model) {
    return model;
  }
  
  protected GenDomainModel _domainModel(final Object eobj) {
    return null;
  }
  
  public GenDomainModel domainModel(final Object model) {
    if (model instanceof GenDomainModel) {
      return _domainModel((GenDomainModel)model);
    } else if (model instanceof GenDomainBlock) {
      return _domainModel((GenDomainBlock)model);
    } else if (model instanceof GenDomainConcept) {
      return _domainModel((GenDomainConcept)model);
    } else if (model instanceof GenDomainPackage) {
      return _domainModel((GenDomainPackage)model);
    } else if (model != null) {
      return _domainModel(model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model).toString());
    }
  }
}
