package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.collect.Iterables;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;

@SuppressWarnings("all")
public class GenDomainModelExtensions {
  public Iterable<GenDomainBlock> domainBlocks(final GenDomainModel model) {
    return Iterables.<GenDomainBlock>filter(model.getElements(), GenDomainBlock.class);
  }
}
