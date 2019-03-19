package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface DomainParticipant extends NamedEntity {
	DDSComponent getType();

	void setType(DDSComponent val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainParticipant
	 */
	static final TypeSelectPredicate<DomainParticipant> type = new TypeSelectPredicate<DomainParticipant>(
			"DDS::DCPS::DomainParticipant", //$NON-NLS-1$
			DomainParticipant.class);
}
