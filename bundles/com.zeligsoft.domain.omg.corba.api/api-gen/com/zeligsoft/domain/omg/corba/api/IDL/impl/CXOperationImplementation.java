package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXException;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXOperationImplementation extends CXNamedElementImplementation implements CXOperation {
	protected CXModuleContained _owner;
	protected java.util.List<CXException> _exceptionDef;
	protected java.util.List<CXParameter> _ownedParameter;
	protected CXType _idlType;

	public CXOperationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXModuleContained getOwner() {
		if (_owner == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXOperation", "owner");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_owner = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						CXModuleContained.class);
			}
		}
		return _owner;
	}

	@Override
	public java.util.List<CXException> getExceptionDef() {
		if (_exceptionDef == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXOperation", "exceptionDef");
			_exceptionDef = new java.util.ArrayList<CXException>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXException nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXException.class);
					_exceptionDef.add(nextWrapper);
				}
			}
		}
		return _exceptionDef;
	}

	@Override
	public void addExceptionDef(CXException val) {
		// make sure the exceptionDef list is created
		getExceptionDef();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXOperation", "exceptionDef");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_exceptionDef != null) {
			_exceptionDef.add(val);
		}
	}

	@Override
	public Boolean getIsOneWay() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXOperation",
				"isOneWay");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsOneWay(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXOperation", "isOneWay", val);
	}

	@Override
	public java.util.List<CXParameter> getOwnedParameter() {
		if (_ownedParameter == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXOperation", "ownedParameter");
			_ownedParameter = new java.util.ArrayList<CXParameter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXParameter nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXParameter.class);
					_ownedParameter.add(nextWrapper);
				}
			}
		}
		return _ownedParameter;
	}

	@Override
	public void addOwnedParameter(CXParameter val) {
		// make sure the ownedParameter list is created
		getOwnedParameter();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXOperation", "ownedParameter");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedParameter != null) {
			_ownedParameter.add(val);
		}
	}

	@Override
	public <T extends CXParameter> T addOwnedParameter(Class<T> typeToCreate, String concept) {
		// make sure the ownedParameter list is created
		getOwnedParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXOperation",
				"ownedParameter", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_ownedParameter != null) {
			_ownedParameter.add(element);
		}
		return element;
	}

	@Override
	public CXParameter addOwnedParameter() {
		// make sure the ownedParameter list is created
		getOwnedParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXOperation",
				"ownedParameter", "CXDomain::IDL::CXParameter");
		CXParameter element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXParameter.class);
		if (_ownedParameter != null) {
			_ownedParameter.add(element);
		}
		return element;
	}

	@Override
	public CXType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXOperation", "idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CXType val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXOperation", "idlType", val.eObject());
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
	public org.eclipse.uml2.uml.Operation asOperation() {
		return (org.eclipse.uml2.uml.Operation) eObject();
	}
}
