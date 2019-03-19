package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeInstance;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.PartImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class HomeInstanceImplementation extends PartImplementation implements
		HomeInstance {
	protected Home _definition;

	public HomeInstanceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Core::NamedElement", "name");
		return (String) rawValue;
	}

	@Override
	public void setName(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
	}

	@Override
	public Home getDefinitionOverride() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CCM::CCM_Implementation::HomeInstance",
							"definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue, Home.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinitionOverride(Home val) {
		ZDLUtil.setValue(element, "CCM::CCM_Implementation::HomeInstance",
				"definition", val.eObject());
	}

	@Override
	public ComponentInterface getDefinition() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDefinition(ComponentInterface val) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
		return (String) rawValue;
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
