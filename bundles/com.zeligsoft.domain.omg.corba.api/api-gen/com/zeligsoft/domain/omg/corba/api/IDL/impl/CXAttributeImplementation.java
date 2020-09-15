package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXException;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXAttributeImplementation extends CXNamedElementImplementation implements CXAttribute {
	protected CXModuleContained _owner;
	protected java.util.List<CXException> _setraises;
	protected CXType _idlType;
	protected java.util.List<CXException> _getraises;

	public CXAttributeImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXModuleContained getOwner() {
		if (_owner == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXAttribute", "owner");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_owner = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						CXModuleContained.class);
			}
		}
		return _owner;
	}

	@Override
	public java.util.List<CXException> getSetraises() {
		if (_setraises == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXAttribute", "setraises");
			_setraises = new java.util.ArrayList<CXException>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXException nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXException.class);
					_setraises.add(nextWrapper);
				}
			}
		}
		return _setraises;
	}

	@Override
	public void addSetraises(CXException val) {
		// make sure the setraises list is created
		getSetraises();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXAttribute", "setraises");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_setraises != null) {
			_setraises.add(val);
		}
	}

	@Override
	public Boolean getIsReadOnly() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXAttribute",
				"isReadOnly");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsReadOnly(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXAttribute", "isReadOnly", val);
	}

	@Override
	public CXType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXTyped",
					"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CXType val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXTyped", "idlType", val.eObject());
	}

	@Override
	public String getUuid() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid");
		return (String) rawValue;
	}

	@Override
	public void setUuid(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid", val);
	}

	@Override
	public java.util.List<CXException> getGetraises() {
		if (_getraises == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXAttribute", "getraises");
			_getraises = new java.util.ArrayList<CXException>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXException nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXException.class);
					_getraises.add(nextWrapper);
				}
			}
		}
		return _getraises;
	}

	@Override
	public void addGetraises(CXException val) {
		// make sure the getraises list is created
		getGetraises();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXAttribute", "getraises");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_getraises != null) {
			_getraises.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
