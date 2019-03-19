package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.idl3plus.api.Generics.TypeParameter;

import com.zeligsoft.domain.idl3plus.api.Generics.TypeConstraint;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TypeParameterZImpl extends ZObjectImpl implements TypeParameter {
	protected TypeConstraint _constraint;

	public TypeParameterZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public TypeConstraint getConstraint() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "IDL3Plus::Generics::TypeParameter", "constraint");

		if (_constraint == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_constraint = TypeConstraint
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _constraint;
	}

	@Override
	public void setConstraint(TypeConstraint val) {
		ZDLUtil.setValue(element, "IDL3Plus::Generics::TypeParameter",
				"constraint", val.eObject(element));
	}

	@Override
	public org.eclipse.uml2.uml.ClassifierTemplateParameter asClassifierTemplateParameter() {
		return (org.eclipse.uml2.uml.ClassifierTemplateParameter) eObject();
	}
}
