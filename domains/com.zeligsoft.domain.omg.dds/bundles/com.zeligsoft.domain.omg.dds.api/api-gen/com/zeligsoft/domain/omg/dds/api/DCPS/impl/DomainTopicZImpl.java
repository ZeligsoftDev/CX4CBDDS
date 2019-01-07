package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DomainTopic;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

public class DomainTopicZImpl extends NamedEntityZImpl implements DomainTopic {
	public DomainTopicZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
