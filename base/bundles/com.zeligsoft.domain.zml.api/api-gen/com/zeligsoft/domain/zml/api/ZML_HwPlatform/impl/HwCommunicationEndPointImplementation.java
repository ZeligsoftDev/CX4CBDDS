package com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwCommunicationEndPoint;

public abstract class HwCommunicationEndPointImplementation extends ZObjectImpl
		implements HwCommunicationEndPoint {
	public HwCommunicationEndPointImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.ConnectableElement asConnectableElement() {
		return (org.eclipse.uml2.uml.ConnectableElement) eObject();
	}
}
