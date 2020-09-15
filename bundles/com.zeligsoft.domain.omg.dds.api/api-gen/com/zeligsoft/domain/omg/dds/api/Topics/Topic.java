package com.zeligsoft.domain.omg.dds.api.Topics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;

public interface Topic extends NamedElement {
	String getExpression();

	void setExpression(String val);

	TopicKind getKind();

	void setKind(TopicKind val);

	TopicField getType();

	void setType(TopicField val);

	java.util.List<qosProperty> getQosProperty();

	void addQosProperty(qosProperty val);

	<T extends qosProperty> T addQosProperty(Class<T> typeToCreate, String concept);

	qosProperty addQosProperty();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Topic
	 */
	static final TypeSelectPredicate<Topic> type = new TypeSelectPredicate<Topic>("DDS::Topics::Topic", //$NON-NLS-1$
			Topic.class);
}
