package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.Implementation;

import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ImplementationImplementation extends ZObjectImpl implements
		Implementation {
	protected java.util.List<WorkerFunction> _worker;

	public ImplementationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<WorkerFunction> getWorker() {
		if (_worker == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::Implementation", "worker");
			_worker = new java.util.ArrayList<WorkerFunction>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					WorkerFunction nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									WorkerFunction.class);
					_worker.add(nextWrapper);
				}
			}
		}
		return _worker;
	}

	@Override
	public void addWorker(WorkerFunction val) {
		// make sure the worker list is created
		getWorker();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::Implementation", "worker");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_worker != null) {
			_worker.add(val);
		}
	}

	@Override
	public <T extends WorkerFunction> T addWorker(Class<T> typeToCreate,
			String concept) {
		// make sure the worker list is created
		getWorker();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::Implementation", "worker",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_worker != null) {
			_worker.add(element);
		}
		return element;
	}

	@Override
	public WorkerFunction addWorker() {
		// make sure the worker list is created
		getWorker();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::Implementation", "worker",
				"ZMLMM::ZML_Component::WorkerFunction");
		WorkerFunction element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				WorkerFunction.class);
		if (_worker != null) {
			_worker.add(element);
		}
		return element;
	}

}
