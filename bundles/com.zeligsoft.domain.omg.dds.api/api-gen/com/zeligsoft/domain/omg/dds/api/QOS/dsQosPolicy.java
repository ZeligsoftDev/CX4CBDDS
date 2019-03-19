package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface dsQosPolicy extends qosPolicy {
	HistoryQosPolicyKind getHistory_kind();

	void setHistory_kind(HistoryQosPolicyKind val);

	Integer getMax_instances();

	void setMax_instances(Integer val);

	Integer getMax_samples();

	void setMax_samples(Integer val);

	Integer getMax_samples_per_instance();

	void setMax_samples_per_instance(Integer val);

	Duration getService_cleanup_delay();

	void setService_cleanup_delay(Duration val);

	<T extends Duration> T createService_cleanup_delay(Class<T> typeToCreate,
			String concept);

	Duration createService_cleanup_delay();

	Integer getHistory_depth();

	void setHistory_depth(Integer val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of dsQosPolicy
	 */
	static final TypeSelectPredicate<dsQosPolicy> type = new TypeSelectPredicate<dsQosPolicy>(
			"DDS::QOS::dsQosPolicy", //$NON-NLS-1$
			dsQosPolicy.class);
}
