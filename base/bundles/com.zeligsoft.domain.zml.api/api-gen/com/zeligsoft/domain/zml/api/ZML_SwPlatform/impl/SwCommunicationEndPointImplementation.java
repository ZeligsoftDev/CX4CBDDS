package com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwCommunicationEndPoint;

public abstract class SwCommunicationEndPointImplementation extends ZObjectImpl
		implements SwCommunicationEndPoint {
	public SwCommunicationEndPointImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.ConnectableElement asConnectableElement() {
		return (org.eclipse.uml2.uml.ConnectableElement) eObject();
	}
}
