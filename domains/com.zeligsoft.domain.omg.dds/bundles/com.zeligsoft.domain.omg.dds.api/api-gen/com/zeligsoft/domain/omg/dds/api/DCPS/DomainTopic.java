package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface DomainTopic extends NamedEntity {
	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainTopic
	 */
	static final TypeSelectPredicate<DomainTopic> type = new TypeSelectPredicate<DomainTopic>(
			"DDS::DCPS::DomainTopic", //$NON-NLS-1$
			DomainTopic.class);
}
