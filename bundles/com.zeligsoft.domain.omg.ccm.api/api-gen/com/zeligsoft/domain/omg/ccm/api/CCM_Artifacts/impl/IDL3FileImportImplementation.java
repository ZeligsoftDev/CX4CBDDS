package com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.IDL3FileImport;

public class IDL3FileImportImplementation extends ZObjectImpl implements
		IDL3FileImport {
	public IDL3FileImportImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
