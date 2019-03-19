package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface QoSForEntity extends NamedElement {
	java.util.List<qosProperty> getQosProperty();

	void addQosProperty(qosProperty val);

	<T extends qosProperty> T addQosProperty(Class<T> typeToCreate,
			String concept);

	qosProperty addQosProperty();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of QoSForEntity
	 */
	static final TypeSelectPredicate<QoSForEntity> type = new TypeSelectPredicate<QoSForEntity>(
			"DDS4CCM::QoSProfiles::QoSForEntity", //$NON-NLS-1$
			QoSForEntity.class);
}
