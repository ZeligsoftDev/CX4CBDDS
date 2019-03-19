package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.OperationImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Core.Parameter;
import com.zeligsoft.domain.zml.api.ZML_Component.Operation;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class WorkerFunctionImplementation extends OperationImplementation
		implements WorkerFunction {
	protected Port _receivingPort;
	protected Operation _portOperation;
	protected java.util.List<Parameter> _parameter;

	public WorkerFunctionImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getDelegate() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunction", "delegate");
		return (Boolean) rawValue;
	}

	@Override
	public void setDelegate(Boolean val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunction",
				"delegate", val);
	}

	@Override
	public Port getReceivingPort() {
		if (_receivingPort == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::WorkerFunction",
							"receivingPort");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_receivingPort = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Port.class);
			}
		}
		return _receivingPort;
	}

	@Override
	public void setReceivingPort(Port val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunction",
				"receivingPort", val.eObject());
	}

	@Override
	public Operation getPortOperation() {
		if (_portOperation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::WorkerFunction",
							"portOperation");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_portOperation = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Operation.class);
			}
		}
		return _portOperation;
	}

	@Override
	public void setPortOperation(Operation val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunction",
				"portOperation", val.eObject());
	}

	@Override
	public String getBody() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunction", "body");
		return (String) rawValue;
	}

	@Override
	public void setBody(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunction",
				"body", val);
	}

	@Override
	public String getUuid() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::WorkerFunction", "uuid");
		return (String) rawValue;
	}

	@Override
	public void setUuid(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunction",
				"uuid", val);
	}

	@Override
	public java.util.List<Parameter> getParameter() {
		if (_parameter == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::WorkerFunction", "parameter");
			_parameter = new java.util.ArrayList<Parameter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Parameter nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next,
							Parameter.class);
					_parameter.add(nextWrapper);
				}
			}
		}
		return _parameter;
	}

	@Override
	public void addParameter(Parameter val) {
		// make sure the parameter list is created
		getParameter();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::WorkerFunction", "parameter");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_parameter != null) {
			_parameter.add(val);
		}
	}

	@Override
	public <T extends Parameter> T addParameter(Class<T> typeToCreate,
			String concept) {
		// make sure the parameter list is created
		getParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::WorkerFunction", "parameter",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_parameter != null) {
			_parameter.add(element);
		}
		return element;
	}

	@Override
	public Parameter addParameter() {
		// make sure the parameter list is created
		getParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::WorkerFunction", "parameter",
				"ZMLMM::ZML_Core::Parameter");
		Parameter element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, Parameter.class);
		if (_parameter != null) {
			_parameter.add(element);
		}
		return element;
	}

}
