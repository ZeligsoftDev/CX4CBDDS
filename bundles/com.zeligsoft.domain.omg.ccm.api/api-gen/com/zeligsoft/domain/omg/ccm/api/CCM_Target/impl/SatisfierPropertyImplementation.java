package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierPropertyKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class SatisfierPropertyImplementation extends NamedElementImplementation
		implements SatisfierProperty {
	protected CORBAType _type;
	protected SatisfierPropertyKind _kind;

	public SatisfierPropertyImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getDynamic() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CCM::CCM_Target::SatisfierProperty", "dynamic");
		return (Boolean) rawValue;
	}

	@Override
	public void setDynamic(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::SatisfierProperty",
				"dynamic", val);
	}

	@Override
	public Integer getLowerBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Core::TypedElement", "lowerBound");
		return (Integer) rawValue;
	}

	@Override
	public void setLowerBound(Integer val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement",
				"lowerBound", val);
	}

	@Override
	public CORBAType getTypeOverride() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CCM::CCM_Target::SatisfierProperty",
							"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAType.class);
			}
		}
		return _type;
	}

	@Override
	public void setTypeOverride(CORBAType val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::SatisfierProperty", "type",
				val.eObject());
	}

	@Override
	public Type getType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setType(Type val) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CCM::CCM_Target::SatisfierProperty", "value");
		return (String) rawValue;
	}

	@Override
	public void setValue(String val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::SatisfierProperty",
				"value", val);
	}

	@Override
	public Integer getUpperBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Core::TypedElement", "upperBound");
		return (Integer) rawValue;
	}

	@Override
	public void setUpperBound(Integer val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement",
				"upperBound", val);
	}

	@Override
	public SatisfierPropertyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CCM::CCM_Target::SatisfierProperty", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = SatisfierPropertyKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(SatisfierPropertyKind val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::SatisfierProperty", "kind",
				val.eObject(element));
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
