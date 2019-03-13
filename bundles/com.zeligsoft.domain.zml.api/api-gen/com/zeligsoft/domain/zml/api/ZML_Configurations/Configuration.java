package com.zeligsoft.domain.zml.api.ZML_Configurations;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Configuration extends ZObject {
	org.eclipse.uml2.uml.Class asClass();

	org.eclipse.uml2.uml.InstanceSpecification asInstanceSpecification();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Configuration
	 */
	static final TypeSelectPredicate<Configuration> type = new TypeSelectPredicate<Configuration>(
			"ZMLMM::ZML_Configurations::Configuration", //$NON-NLS-1$
			Configuration.class);
}
