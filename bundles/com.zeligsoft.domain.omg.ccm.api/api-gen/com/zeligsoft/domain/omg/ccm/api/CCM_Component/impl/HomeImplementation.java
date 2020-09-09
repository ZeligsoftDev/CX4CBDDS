package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.ManagesEndImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class HomeImplementation extends ManagesEndImplementation implements Home {
	protected Manages _manages;
	protected java.util.List<CXNamedElement> _property;
	protected java.util.List<CXAttribute> _ownedAttribute;
	protected java.util.List<CXNamedElement> _export;
	protected java.util.List<CXNamedElement> _nestedClassifier;
	protected java.util.List<CXNamedElement> _operation;

	public HomeImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"qualifiedName");
		return (String) rawValue;
	}

	@Override
	public Manages getManages() {
		if (_manages == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"manages");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_manages = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, Manages.class);
			}
		}
		return _manages;
	}

	@Override
	public void setManages(Manages val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::Home", "manages", val.eObject());
	}

	@Override
	public <T extends Manages> T createManages(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Home",
				"manages", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public Manages createManages() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Home",
				"manages", "CCM::CCM_Component::Manages");
		Manages element = ZDLFactoryRegistry.INSTANCE.create(newConcept, Manages.class);
		return element;
	}

	@Override
	public java.util.List<CXNamedElement> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"property");
			_property = new java.util.ArrayList<CXNamedElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXNamedElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, CXNamedElement.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public void addProperty(CXNamedElement val) {
		// make sure the property list is created
		getProperty();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Home", "property");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_property != null) {
			_property.add(val);
		}
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"name");
		return (String) rawValue;
	}

	@Override
	public void setName(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
	}

	@Override
	public java.util.List<CXAttribute> getOwnedAttribute() {
		if (_ownedAttribute == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"ownedAttribute");
			_ownedAttribute = new java.util.ArrayList<CXAttribute>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXAttribute nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXAttribute.class);
					_ownedAttribute.add(nextWrapper);
				}
			}
		}
		return _ownedAttribute;
	}

	@Override
	public void addOwnedAttribute(CXAttribute val) {
		// make sure the ownedAttribute list is created
		getOwnedAttribute();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Home", "ownedAttribute");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedAttribute != null) {
			_ownedAttribute.add(val);
		}
	}

	@Override
	public <T extends CXAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept) {
		// make sure the ownedAttribute list is created
		getOwnedAttribute();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Home",
				"ownedAttribute", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_ownedAttribute != null) {
			_ownedAttribute.add(element);
		}
		return element;
	}

	@Override
	public CXAttribute addOwnedAttribute() {
		// make sure the ownedAttribute list is created
		getOwnedAttribute();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Home",
				"ownedAttribute", "CXDomain::IDL::CXAttribute");
		CXAttribute element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXAttribute.class);
		if (_ownedAttribute != null) {
			_ownedAttribute.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<CXNamedElement> getExport() {
		if (_export == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"export");
			_export = new java.util.ArrayList<CXNamedElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXNamedElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, CXNamedElement.class);
					_export.add(nextWrapper);
				}
			}
		}
		return _export;
	}

	@Override
	public void addExport(CXNamedElement val) {
		// make sure the export list is created
		getExport();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Home", "export");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_export != null) {
			_export.add(val);
		}
	}

	@Override
	public java.util.List<CXNamedElement> getNestedClassifier() {
		if (_nestedClassifier == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"nestedClassifier");
			_nestedClassifier = new java.util.ArrayList<CXNamedElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXNamedElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, CXNamedElement.class);
					_nestedClassifier.add(nextWrapper);
				}
			}
		}
		return _nestedClassifier;
	}

	@Override
	public void addNestedClassifier(CXNamedElement val) {
		// make sure the nestedClassifier list is created
		getNestedClassifier();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Home", "nestedClassifier");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_nestedClassifier != null) {
			_nestedClassifier.add(val);
		}
	}

	@Override
	public java.util.List<CXNamedElement> getOperation() {
		if (_operation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Home",
					"operation");
			_operation = new java.util.ArrayList<CXNamedElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXNamedElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, CXNamedElement.class);
					_operation.add(nextWrapper);
				}
			}
		}
		return _operation;
	}

	@Override
	public void addOperation(CXNamedElement val) {
		// make sure the operation list is created
		getOperation();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Home", "operation");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_operation != null) {
			_operation.add(val);
		}
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
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
