package com.zeligsoft.domain.omg.dds.api.Domain;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.TypedEntity;

public interface QoSProperty extends TypedEntity {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of QoSProperty
	 */
	static final TypeSelectPredicate<QoSProperty> type = new TypeSelectPredicate<QoSProperty>(
			"DDS::Domain::QoSProperty", //$NON-NLS-1$
			QoSProperty.class);
}
