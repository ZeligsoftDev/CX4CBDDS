package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLIncludeDependency;

import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDLIncludeDependencyZImpl extends ZObjectImpl implements IDLIncludeDependency {
	protected CXNamedElement _includer;
	protected CXNamedElement _includee;

	public IDLIncludeDependencyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXNamedElement getIncluder() {
		if (_includer == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS4CCM::DDS4CCM::IDLIncludeDependency", "includer");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_includer = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						CXNamedElement.class);
			}
		}
		return _includer;
	}

	@Override
	public void setIncluder(CXNamedElement val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::IDLIncludeDependency", "includer", val.eObject());
	}

	@Override
	public CXNamedElement getIncludee() {
		if (_includee == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS4CCM::DDS4CCM::IDLIncludeDependency", "includee");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_includee = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						CXNamedElement.class);
			}
		}
		return _includee;
	}

	@Override
	public void setIncludee(CXNamedElement val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::IDLIncludeDependency", "includee", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
