package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.PartImplementation;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CCMPartImplementation extends PartImplementation implements CCMPart {
	public CCMPartImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"qualifiedName");
		return (String) rawValue;
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
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
