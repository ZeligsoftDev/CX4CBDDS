package com.zeligsoft.domain.omg.corba.api.IDLFileSupport.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLImport;

import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDLImportImplementation extends ZObjectImpl implements IDLImport {
	protected IDLFile _target;

	public IDLImportImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public IDLFile getTarget() {
		if (_target == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CORBADomain::IDLFileSupport::IDLImport", "target");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_target = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) rawValue,
								IDLFile.class);
			}
		}
		return _target;
	}

	@Override
	public void setTarget(IDLFile val) {
		ZDLUtil.setValue(element, "CORBADomain::IDLFileSupport::IDLImport",
				"target", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
