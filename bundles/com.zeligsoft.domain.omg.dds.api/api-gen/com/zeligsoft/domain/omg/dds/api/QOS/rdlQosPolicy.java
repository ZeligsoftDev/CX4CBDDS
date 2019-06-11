package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface rdlQosPolicy extends qosPolicy {
	Duration getAutopurge_nowriter_samples_delay();

	void setAutopurge_nowriter_samples_delay(Duration val);

	<T extends Duration> T createAutopurge_nowriter_samples_delay(
			Class<T> typeToCreate, String concept);

	Duration createAutopurge_nowriter_samples_delay();

	Duration getAutopurge_disposed_samples_delay();

	void setAutopurge_disposed_samples_delay(Duration val);

	<T extends Duration> T createAutopurge_disposed_samples_delay(
			Class<T> typeToCreate, String concept);

	Duration createAutopurge_disposed_samples_delay();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of rdlQosPolicy
	 */
	static final TypeSelectPredicate<rdlQosPolicy> type = new TypeSelectPredicate<rdlQosPolicy>(
			"DDS::QOS::rdlQosPolicy", //$NON-NLS-1$
			rdlQosPolicy.class);
}
