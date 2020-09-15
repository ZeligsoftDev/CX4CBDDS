package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Event;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.InterfaceImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.StateMember;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class EventImplementation extends InterfaceImplementation implements Event {
	protected java.util.List<StateMember> _member;
	protected java.util.List<CXAttribute> _ownedAttribute;

	public EventImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"qualifiedName");
		return (String) rawValue;
	}

	@Override
	public Boolean getIsCustom() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event",
				"isCustom");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsCustom(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isCustom", val);
	}

	@Override
	public java.util.List<StateMember> getMember() {
		if (_member == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event",
					"member");
			_member = new java.util.ArrayList<StateMember>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					StateMember nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							StateMember.class);
					_member.add(nextWrapper);
				}
			}
		}
		return _member;
	}

	@Override
	public void addMember(StateMember val) {
		// make sure the member list is created
		getMember();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Event", "member");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_member != null) {
			_member.add(val);
		}
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
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event",
					"ownedAttribute");
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

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Event", "ownedAttribute");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedAttribute != null) {
			_ownedAttribute.add(val);
		}
	}

	@Override
	public Boolean getIsAbstract() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event",
				"isAbstract");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsAbstract(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isAbstract", val);
	}

	@Override
	public Boolean getIsTruncatable() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event",
				"isTruncatable");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsTruncatable(Boolean val) {
		ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isTruncatable", val);
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
