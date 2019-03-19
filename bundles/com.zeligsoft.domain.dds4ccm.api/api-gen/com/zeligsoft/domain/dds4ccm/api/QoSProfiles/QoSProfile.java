package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface QoSProfile extends NamedElement {
	String getFilename();

	void setFilename(String val);

	java.util.List<QoSForEntity> getQosForEntity();

	void addQosForEntity(QoSForEntity val);

	<T extends QoSForEntity> T addQosForEntity(Class<T> typeToCreate,
			String concept);

	java.util.List<QoSEntity> getQosEntity();

	void addQosEntity(QoSEntity val);

	<T extends QoSEntity> T addQosEntity(Class<T> typeToCreate, String concept);

	QoSEntity addQosEntity();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of QoSProfile
	 */
	static final TypeSelectPredicate<QoSProfile> type = new TypeSelectPredicate<QoSProfile>(
			"DDS4CCM::QoSProfiles::QoSProfile", //$NON-NLS-1$
			QoSProfile.class);
}
