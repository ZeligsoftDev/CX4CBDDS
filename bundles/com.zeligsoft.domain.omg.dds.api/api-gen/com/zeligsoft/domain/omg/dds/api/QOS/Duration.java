package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Duration extends ZObject {
	Integer getSecond();

	Integer getNanosecond();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Duration
	 */
	static final TypeSelectPredicate<Duration> type = new TypeSelectPredicate<Duration>(
			"DDS::QOS::Duration", //$NON-NLS-1$
			Duration.class);
}
