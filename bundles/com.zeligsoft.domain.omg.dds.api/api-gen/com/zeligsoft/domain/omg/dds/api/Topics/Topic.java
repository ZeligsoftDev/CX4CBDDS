package com.zeligsoft.domain.omg.dds.api.Topics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Topic extends NamedElement {
	String getExpression();

	TopicKind getKind();

	TopicField getType();

	java.util.List<qosProperty> getQosProperty();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Topic
	 */
	static final TypeSelectPredicate<Topic> type = new TypeSelectPredicate<Topic>(
			"DDS::Topics::Topic", //$NON-NLS-1$
			Topic.class);
}
