package com.zeligsoft.base.zdl.staticapi.Validation.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainCreateLinkConstraint;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainCreateLinkConstraintImpl extends DomainLinkConstraintImpl
		implements DomainCreateLinkConstraint {
	protected DomainConcept _createsConcept;

	public DomainCreateLinkConstraintImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DomainConcept getCreatesConcept() {
		if (_createsConcept == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZDL::Validation::DomainCreateLinkConstraint",
							"createsConcept");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_createsConcept = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainConcept.class);
			}
		}
		return _createsConcept;
	}

	@Override
	public void setCreatesConcept(DomainConcept val) {
		ZDLUtil.setValue(element,
				"ZDL::Validation::DomainCreateLinkConstraint",
				"createsConcept", val.eObject());
	}

}
