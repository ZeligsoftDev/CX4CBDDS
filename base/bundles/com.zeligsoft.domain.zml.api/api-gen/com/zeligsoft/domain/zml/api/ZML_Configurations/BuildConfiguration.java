package com.zeligsoft.domain.zml.api.ZML_Configurations;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface BuildConfiguration extends Configuration {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of BuildConfiguration
	 */
	static final TypeSelectPredicate<BuildConfiguration> type = new TypeSelectPredicate<BuildConfiguration>(
			"ZMLMM::ZML_Configurations::BuildConfiguration", //$NON-NLS-1$
			BuildConfiguration.class);
}
