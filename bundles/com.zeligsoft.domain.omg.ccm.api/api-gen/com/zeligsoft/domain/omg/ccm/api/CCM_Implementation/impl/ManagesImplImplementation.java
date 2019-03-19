package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.ManagesImpl;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.ManagesImplEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ManagesImplImplementation extends ZObjectImpl implements
		ManagesImpl {
	protected ManagesImplEnd _component;
	protected ManagesImplEnd _home;

	public ManagesImplImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ManagesImplEnd getComponent() {
		if (_component == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CCM::CCM_Implementation::ManagesImpl", "component");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_component = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ManagesImplEnd.class);
			}
		}
		return _component;
	}

	@Override
	public void setComponent(ManagesImplEnd val) {
		ZDLUtil.setValue(element, "CCM::CCM_Implementation::ManagesImpl",
				"component", val.eObject());
	}

	@Override
	public <T extends ManagesImplEnd> T createComponent(Class<T> typeToCreate,
			String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Implementation::ManagesImpl", "component",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public ManagesImplEnd getHome() {
		if (_home == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CCM::CCM_Implementation::ManagesImpl", "home");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_home = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ManagesImplEnd.class);
			}
		}
		return _home;
	}

	@Override
	public void setHome(ManagesImplEnd val) {
		ZDLUtil.setValue(element, "CCM::CCM_Implementation::ManagesImpl",
				"home", val.eObject());
	}

	@Override
	public <T extends ManagesImplEnd> T createHome(Class<T> typeToCreate,
			String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Implementation::ManagesImpl", "home",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
