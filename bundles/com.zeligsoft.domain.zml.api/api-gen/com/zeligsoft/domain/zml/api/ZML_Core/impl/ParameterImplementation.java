package com.zeligsoft.domain.zml.api.ZML_Core.impl;

import com.zeligsoft.domain.zml.api.ZML_Core.Parameter;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.TypedElementImplementation;

public class ParameterImplementation extends TypedElementImplementation
		implements Parameter {
	public ParameterImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Parameter asParameter() {
		return (org.eclipse.uml2.uml.Parameter) eObject();
	}
}
