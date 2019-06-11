package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.domain.zml.api.ZML_Component.Operation;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

public class OperationImplementation extends NamedElementImplementation
		implements Operation {
	public OperationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Operation asOperation() {
		return (org.eclipse.uml2.uml.Operation) eObject();
	}
}
