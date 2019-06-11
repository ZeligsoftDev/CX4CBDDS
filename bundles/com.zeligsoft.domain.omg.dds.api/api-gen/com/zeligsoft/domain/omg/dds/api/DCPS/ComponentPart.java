package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface ComponentPart extends NamedEntity {
	PublisherSubscriber getType();

	void setType(PublisherSubscriber val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ComponentPart
	 */
	static final TypeSelectPredicate<ComponentPart> type = new TypeSelectPredicate<ComponentPart>(
			"DDS::DCPS::ComponentPart", //$NON-NLS-1$
			ComponentPart.class);
}
