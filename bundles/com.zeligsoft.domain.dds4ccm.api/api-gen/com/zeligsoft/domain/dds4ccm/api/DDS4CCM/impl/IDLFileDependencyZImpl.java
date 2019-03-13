package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDLFileDependencyZImpl extends ZObjectImpl implements
		IDLFileDependency {
	protected IDLFileSpecification _file;
	protected CORBANamedElement _element;

	public IDLFileDependencyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	public IDLFileSpecification getFile() {
		if (_file == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS4CCM::DDS4CCM::IDLFileDependency",
							"file");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_file = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						IDLFileSpecification.class);
			}
		}
		return _file;
	}

	public void setFile(IDLFileSpecification val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::IDLFileDependency",
				"file", val.eObject());
	}

	public CORBANamedElement getElement() {
		if (_element == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS4CCM::DDS4CCM::IDLFileDependency",
							"element");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_element = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBANamedElement.class);
			}
		}
		return _element;
	}

	public void setElement(CORBANamedElement val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::IDLFileDependency",
				"element", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
