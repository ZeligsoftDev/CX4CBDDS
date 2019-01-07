package com.zeligsoft.domain.zml.api.ZML_Core.impl;

import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

public abstract class TypeImplementation extends NamedElementImplementation
		implements Type {
	public TypeImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Classifier asClassifier() {
		return (org.eclipse.uml2.uml.Classifier) eObject();
	}
}
