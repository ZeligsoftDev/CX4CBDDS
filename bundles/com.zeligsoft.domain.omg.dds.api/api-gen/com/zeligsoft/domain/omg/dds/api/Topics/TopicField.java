package com.zeligsoft.domain.omg.dds.api.Topics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

public interface TopicField extends NamedElement {
	CXType getType();

	void setType(CXType val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TopicField
	 */
	static final TypeSelectPredicate<TopicField> type = new TypeSelectPredicate<TopicField>("DDS::Topics::TopicField", //$NON-NLS-1$
			TopicField.class);
}
