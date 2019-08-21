package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainBlockMerge;

public class DomainBlockMergeImpl extends DomainBlockRelationImpl implements
		DomainBlockMerge {
	public DomainBlockMergeImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.PackageMerge asPackageMerge() {
		return (org.eclipse.uml2.uml.PackageMerge) eObject();
	}
}
