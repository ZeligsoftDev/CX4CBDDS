package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;
import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionImpl;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class StructuralRealizationImplementation extends ZObjectImpl implements
		StructuralRealization {
	protected java.util.List<Port> _ownedPort;
	protected java.util.List<AssemblyConnector> _connector;
	protected java.util.List<WorkerFunction> _worker;
	protected ComponentInterface _interface;
	protected java.util.List<WorkerFunctionImpl> _workerImpl;
	protected java.util.List<Part> _part;

	public StructuralRealizationImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<Port> getOwnedPort() {
		if (_ownedPort == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"ownedPort");
			_ownedPort = new java.util.ArrayList<Port>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Port nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, Port.class);
					_ownedPort.add(nextWrapper);
				}
			}
		}
		return _ownedPort;
	}

	@Override
	public void addOwnedPort(Port val) {
		// make sure the ownedPort list is created
		getOwnedPort();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::StructuralRealization", "ownedPort");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedPort != null) {
			_ownedPort.add(val);
		}
	}

	@Override
	public <T extends Port> T addOwnedPort(Class<T> typeToCreate, String concept) {
		// make sure the ownedPort list is created
		getOwnedPort();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"ownedPort", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_ownedPort != null) {
			_ownedPort.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<AssemblyConnector> getConnector() {
		if (_connector == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"connector");
			_connector = new java.util.ArrayList<AssemblyConnector>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					AssemblyConnector nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									AssemblyConnector.class);
					_connector.add(nextWrapper);
				}
			}
		}
		return _connector;
	}

	@Override
	public void addConnector(AssemblyConnector val) {
		// make sure the connector list is created
		getConnector();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::StructuralRealization", "connector");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_connector != null) {
			_connector.add(val);
		}
	}

	@Override
	public <T extends AssemblyConnector> T addConnector(Class<T> typeToCreate,
			String concept) {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"connector", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public AssemblyConnector addConnector() {
		// make sure the connector list is created
		getConnector();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"connector", "ZMLMM::ZML_Component::AssemblyConnector");
		AssemblyConnector element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				AssemblyConnector.class);
		if (_connector != null) {
			_connector.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<WorkerFunction> getWorker() {
		if (_worker == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"worker");
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
				"ZMLMM::ZML_Component::StructuralRealization", "worker");
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
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"worker", concept);
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
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"worker", "ZMLMM::ZML_Component::WorkerFunction");
		WorkerFunction element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				WorkerFunction.class);
		if (_worker != null) {
			_worker.add(element);
		}
		return element;
	}

	@Override
	public ComponentInterface getInterface() {
		if (_interface == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"interface");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_interface = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ComponentInterface.class);
			}
		}
		return _interface;
	}

	@Override
	public void setInterface(ComponentInterface val) {
		ZDLUtil.setValue(element,
				"ZMLMM::ZML_Component::StructuralRealization", "interface",
				val.eObject());
	}

	@Override
	public java.util.List<WorkerFunctionImpl> getWorkerImpl() {
		if (_workerImpl == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"workerImpl");
			_workerImpl = new java.util.ArrayList<WorkerFunctionImpl>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					WorkerFunctionImpl nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									WorkerFunctionImpl.class);
					_workerImpl.add(nextWrapper);
				}
			}
		}
		return _workerImpl;
	}

	@Override
	public void addWorkerImpl(WorkerFunctionImpl val) {
		// make sure the workerImpl list is created
		getWorkerImpl();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::StructuralRealization", "workerImpl");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_workerImpl != null) {
			_workerImpl.add(val);
		}
	}

	@Override
	public <T extends WorkerFunctionImpl> T addWorkerImpl(
			Class<T> typeToCreate, String concept) {
		// make sure the workerImpl list is created
		getWorkerImpl();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"workerImpl", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_workerImpl != null) {
			_workerImpl.add(element);
		}
		return element;
	}

	@Override
	public WorkerFunctionImpl addWorkerImpl() {
		// make sure the workerImpl list is created
		getWorkerImpl();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization",
				"workerImpl", "ZMLMM::ZML_Component::WorkerFunctionImpl");
		WorkerFunctionImpl element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				WorkerFunctionImpl.class);
		if (_workerImpl != null) {
			_workerImpl.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<Part> getPart() {
		if (_part == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::StructuralRealization",
							"part");
			_part = new java.util.ArrayList<Part>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Part nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, Part.class);
					_part.add(nextWrapper);
				}
			}
		}
		return _part;
	}

	@Override
	public void addPart(Part val) {
		// make sure the part list is created
		getPart();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::StructuralRealization", "part");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_part != null) {
			_part.add(val);
		}
	}

	@Override
	public <T extends Part> T addPart(Class<T> typeToCreate, String concept) {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::StructuralRealization", "part",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
