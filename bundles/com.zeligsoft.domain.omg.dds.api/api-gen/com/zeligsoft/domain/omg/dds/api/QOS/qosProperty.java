package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface qosProperty extends NamedElement {
	qosPolicy getPolicy();

	void setPolicy(qosPolicy val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of qosProperty
	 */
	static final TypeSelectPredicate<qosProperty> type = new TypeSelectPredicate<qosProperty>("DDS::QOS::qosProperty", //$NON-NLS-1$
			qosProperty.class);
}
