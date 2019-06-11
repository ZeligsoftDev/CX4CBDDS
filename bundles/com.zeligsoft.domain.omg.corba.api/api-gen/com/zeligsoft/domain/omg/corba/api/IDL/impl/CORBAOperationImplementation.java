package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAOperationImplementation extends
		CORBANamedElementImplementation implements CORBAOperation {
	protected CORBAModuleContained _owner;
	protected java.util.List<CORBAException> _exceptionDef;
	protected java.util.List<CORBAParameter> _ownedParameter;
	protected CORBAType _idlType;

	public CORBAOperationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CORBAModuleContained getOwner() {
		if (_owner == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAOperation",
							"owner");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_owner = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAModuleContained.class);
			}
		}
		return _owner;
	}

	@Override
	public java.util.List<CORBAException> getExceptionDef() {
		if (_exceptionDef == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAOperation",
							"exceptionDef");
			_exceptionDef = new java.util.ArrayList<CORBAException>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBAException nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBAException.class);
					_exceptionDef.add(nextWrapper);
				}
			}
		}
		return _exceptionDef;
	}

	@Override
	public void addExceptionDef(CORBAException val) {
		// make sure the exceptionDef list is created
		getExceptionDef();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAOperation", "exceptionDef");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_exceptionDef != null) {
			_exceptionDef.add(val);
		}
	}

	@Override
	public String getUuid() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunctionIdentifiable",
				"uuid");
		return (String) rawValue;
	}

	@Override
	public void setUuid(String val) {
		ZDLUtil.setValue(element,
				"ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid", val);
	}

	@Override
	public Boolean getIsOneWay() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBAOperation", "isOneWay");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsOneWay(Boolean val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAOperation",
				"isOneWay", val);
	}

	@Override
	public java.util.List<CORBAParameter> getOwnedParameter() {
		if (_ownedParameter == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAOperation",
							"ownedParameter");
			_ownedParameter = new java.util.ArrayList<CORBAParameter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBAParameter nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBAParameter.class);
					_ownedParameter.add(nextWrapper);
				}
			}
		}
		return _ownedParameter;
	}

	@Override
	public void addOwnedParameter(CORBAParameter val) {
		// make sure the ownedParameter list is created
		getOwnedParameter();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAOperation", "ownedParameter");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedParameter != null) {
			_ownedParameter.add(val);
		}
	}

	@Override
	public <T extends CORBAParameter> T addOwnedParameter(
			Class<T> typeToCreate, String concept) {
		// make sure the ownedParameter list is created
		getOwnedParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAOperation", "ownedParameter",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_ownedParameter != null) {
			_ownedParameter.add(element);
		}
		return element;
	}

	@Override
	public CORBAParameter addOwnedParameter() {
		// make sure the ownedParameter list is created
		getOwnedParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAOperation", "ownedParameter",
				"CORBADomain::IDL::CORBAParameter");
		CORBAParameter element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				CORBAParameter.class);
		if (_ownedParameter != null) {
			_ownedParameter.add(element);
		}
		return element;
	}

	@Override
	public CORBAType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAOperation",
							"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CORBAType val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAOperation",
				"idlType", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Operation asOperation() {
		return (org.eclipse.uml2.uml.Operation) eObject();
	}
}
