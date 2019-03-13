package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainBlockImport;

public class DomainBlockImportImpl extends DomainBlockRelationImpl implements
		DomainBlockImport {
	public DomainBlockImportImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.PackageImport asPackageImport() {
		return (org.eclipse.uml2.uml.PackageImport) eObject();
	}
}
