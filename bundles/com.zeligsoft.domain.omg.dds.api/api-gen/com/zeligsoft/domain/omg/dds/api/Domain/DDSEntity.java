package com.zeligsoft.domain.omg.dds.api.Domain;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.Classifier;

public interface DDSEntity extends Classifier {
	java.util.List<QoSProperty> getQosPolicy();

	void addQosPolicy(QoSProperty val);

	<T extends QoSProperty> T addQosPolicy(Class<T> typeToCreate, String concept);

	QoSProperty addQosPolicy();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DDSEntity
	 */
	static final TypeSelectPredicate<DDSEntity> type = new TypeSelectPredicate<DDSEntity>(
			"DDS::Domain::DDSEntity", //$NON-NLS-1$
			DDSEntity.class);
}
