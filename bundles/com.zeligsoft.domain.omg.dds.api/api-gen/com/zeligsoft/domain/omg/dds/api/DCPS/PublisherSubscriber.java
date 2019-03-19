package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface PublisherSubscriber extends NamedEntity {
	java.util.List<DataReaderWriter> getData();

	void addData(DataReaderWriter val);

	<T extends DataReaderWriter> T addData(Class<T> typeToCreate, String concept);

	DataReaderWriter addData();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of PublisherSubscriber
	 */
	static final TypeSelectPredicate<PublisherSubscriber> type = new TypeSelectPredicate<PublisherSubscriber>(
			"DDS::DCPS::PublisherSubscriber", //$NON-NLS-1$
			PublisherSubscriber.class);
}
