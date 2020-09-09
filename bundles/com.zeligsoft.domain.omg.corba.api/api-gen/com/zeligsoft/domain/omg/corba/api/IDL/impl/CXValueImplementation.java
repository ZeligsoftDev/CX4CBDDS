package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXValue;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTypeImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXClassifierContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.CXConstant;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXValueImplementation extends CXTypeImplementation implements CXValue {
	protected java.util.List<CXConstant> _ownedConstants;
	protected java.util.List<CXClassifierContained> _contents;
	protected java.util.List<CXAttribute> _ownedAttribute;
	protected java.util.List<CXOperation> _ownedOperation;

	public CXValueImplementation(org.eclipse.emf.ecore.EObject element) {
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
	public Boolean getIsCustom() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXValue",
				"isCustom");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsCustom(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXValue", "isCustom", val);
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
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXValue",
				"isAbstract");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsAbstract(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXValue", "isAbstract", val);
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
	public Boolean getIsTruncatable() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXValue",
				"isTruncatable");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsTruncatable(Boolean val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXValue", "isTruncatable", val);
	}

	@Override
	public org.eclipse.uml2.uml.Interface asInterface() {
		return (org.eclipse.uml2.uml.Interface) eObject();
	}
}
