package com.zeligsoft.domain.omg.dds.api.Topics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface TopicField extends NamedElement {
	CORBAType getType();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TopicField
	 */
	static final TypeSelectPredicate<TopicField> type = new TypeSelectPredicate<TopicField>(
			"DDS::Topics::TopicField", //$NON-NLS-1$
			TopicField.class);
}
