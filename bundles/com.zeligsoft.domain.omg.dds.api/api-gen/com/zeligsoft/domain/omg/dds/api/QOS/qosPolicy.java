package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface qosPolicy extends NamedElement {
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of qosPolicy
	 */
	static final TypeSelectPredicate<qosPolicy> type = new TypeSelectPredicate<qosPolicy>(
			"DDS::QOS::qosPolicy", //$NON-NLS-1$
			qosPolicy.class);
}
