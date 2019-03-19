package com.zeligsoft.domain.omg.dds.api.Core.impl;

import com.zeligsoft.domain.omg.dds.api.Core.Specification;
import com.zeligsoft.domain.omg.dds.api.Core.impl.ClassifierZImpl;

public abstract class SpecificationZImpl extends ClassifierZImpl implements
		Specification {
	public SpecificationZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
