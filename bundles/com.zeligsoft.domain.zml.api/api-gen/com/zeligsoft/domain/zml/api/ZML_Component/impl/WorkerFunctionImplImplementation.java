package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionImpl;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class WorkerFunctionImplImplementation extends
		NamedElementImplementation implements WorkerFunctionImpl {
	protected java.util.List<String> _body;
	protected WorkerFunction _workerFunction;
	protected java.util.List<String> _language;

	public WorkerFunctionImplImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<String> getBody() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunctionImpl", "body");

		if (_body == null) {
			_body = new java.util.ArrayList<String>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				_body.add((String) next);

			}
		}
		return _body;
	}

	@Override
	public void addBody(String val) {
		// make sure the body list is created
		getBody();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::WorkerFunctionImpl", "body");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val);
		if (_body != null) {
			_body.add(val);
		}
	}

	@Override
	public WorkerFunction getWorkerFunction() {
		if (_workerFunction == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::WorkerFunctionImpl",
							"workerFunction");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_workerFunction = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						WorkerFunction.class);
			}
		}
		return _workerFunction;
	}

	@Override
	public void setWorkerFunction(WorkerFunction val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunctionImpl",
				"workerFunction", val.eObject());
	}

	@Override
	public java.util.List<String> getLanguage() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunctionImpl",
				"language");

		if (_language == null) {
			_language = new java.util.ArrayList<String>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				_language.add((String) next);

			}
		}
		return _language;
	}

	@Override
	public void addLanguage(String val) {
		// make sure the language list is created
		getLanguage();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::WorkerFunctionImpl", "language");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val);
		if (_language != null) {
			_language.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.OpaqueBehavior asOpaqueBehavior() {
		return (org.eclipse.uml2.uml.OpaqueBehavior) eObject();
	}
}
