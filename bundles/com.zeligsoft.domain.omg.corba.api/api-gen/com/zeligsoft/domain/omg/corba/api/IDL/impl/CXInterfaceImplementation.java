package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.InterfaceImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXClassifierContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.CXConstant;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXInterfaceImplementation extends InterfaceImplementation implements CXInterface {
	protected java.util.List<CXConstant> _ownedConstants;
	protected java.util.List<CXInterface> _generals;
	protected java.util.List<CXClassifierContained> _contents;
	protected java.util.List<CXAttribute> _ownedAttribute;
	protected java.util.List<CXOperation> _ownedOperation;

	public CXInterfaceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CXConstant> getOwnedConstants() {
		if (_ownedConstants == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXClassifier", "ownedConstants");
			_ownedConstants = new java.util.ArrayList<CXConstant>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXConstant nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXConstant.class);
					_ownedConstants.add(nextWrapper);
				}
			}
		}
		return _ownedConstants;
	}

	@Override
	public void addOwnedConstants(CXConstant val) {
		// make sure the ownedConstants list is created
		getOwnedConstants();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXClassifier", "ownedConstants");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedConstants != null) {
			_ownedConstants.add(val);
		}
	}

	@Override
	public <T extends CXConstant> T addOwnedConstants(Class<T> typeToCreate, String concept) {
		// make sure the ownedConstants list is created
		getOwnedConstants();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"ownedConstants", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_ownedConstants != null) {
			_ownedConstants.add(element);
		}
		return element;
	}

	@Override
	public CXConstant addOwnedConstants() {
		// make sure the ownedConstants list is created
		getOwnedConstants();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"ownedConstants", "CXDomain::IDL::CXConstant");
		CXConstant element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXConstant.class);
		if (_ownedConstants != null) {
			_ownedConstants.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<CXInterface> getGenerals() {
		if (_generals == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXInterface", "generals");
			_generals = new java.util.ArrayList<CXInterface>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXInterface nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXInterface.class);
					_generals.add(nextWrapper);
				}
			}
		}
		return _generals;
	}

	@Override
	public void addGenerals(CXInterface val) {
		// make sure the generals list is created
		getGenerals();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXInterface", "generals");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_generals != null) {
			_generals.add(val);
		}
	}

	@Override
	public java.util.List<CXClassifierContained> getContents() {
		if (_contents == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXClassifier", "contents");
			_contents = new java.util.ArrayList<CXClassifierContained>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXClassifierContained nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, CXClassifierContained.class);
					_contents.add(nextWrapper);
				}
			}
		}
		return _contents;
	}

	@Override
	public void addContents(CXClassifierContained val) {
		// make sure the contents list is created
		getContents();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXClassifier", "contents");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_contents != null) {
			_contents.add(val);
		}
	}

	@Override
	public <T extends CXClassifierContained> T addContents(Class<T> typeToCreate, String concept) {
		// make sure the contents list is created
		getContents();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"contents", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_contents != null) {
			_contents.add(element);
		}
		return element;
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"qualifiedName");
		return (String) rawValue;
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
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXClassifier", "ownedAttribute");
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

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXClassifier", "ownedAttribute");
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
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
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
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"ownedAttribute", "CXDomain::IDL::CXAttribute");
		CXAttribute element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXAttribute.class);
		if (_ownedAttribute != null) {
			_ownedAttribute.add(element);
		}
		return element;
	}

	@Override
	public Boolean getIsAbstract() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXInterface",
				"isAbstract");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsAbstract(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXInterface", "isAbstract", val);
	}

	@Override
	public java.util.List<CXOperation> getOwnedOperation() {
		if (_ownedOperation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXClassifier", "ownedOperation");
			_ownedOperation = new java.util.ArrayList<CXOperation>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXOperation nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXOperation.class);
					_ownedOperation.add(nextWrapper);
				}
			}
		}
		return _ownedOperation;
	}

	@Override
	public void addOwnedOperation(CXOperation val) {
		// make sure the ownedOperation list is created
		getOwnedOperation();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXClassifier", "ownedOperation");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedOperation != null) {
			_ownedOperation.add(val);
		}
	}

	@Override
	public <T extends CXOperation> T addOwnedOperation(Class<T> typeToCreate, String concept) {
		// make sure the ownedOperation list is created
		getOwnedOperation();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"ownedOperation", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_ownedOperation != null) {
			_ownedOperation.add(element);
		}
		return element;
	}

	@Override
	public CXOperation addOwnedOperation() {
		// make sure the ownedOperation list is created
		getOwnedOperation();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXClassifier",
				"ownedOperation", "CXDomain::IDL::CXOperation");
		CXOperation element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXOperation.class);
		if (_ownedOperation != null) {
			_ownedOperation.add(element);
		}
		return element;
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
	public Boolean getIsLocal() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXInterface",
				"isLocal");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsLocal(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXInterface", "isLocal", val);
	}

	@Override
	public Boolean getIsAsynchronous() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXInterface",
				"isAsynchronous");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsAsynchronous(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXInterface", "isAsynchronous", val);
	}

	@Override
	public org.eclipse.uml2.uml.Interface asInterface() {
		return (org.eclipse.uml2.uml.Interface) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
