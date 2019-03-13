package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface DataReaderWriter extends NamedEntity {
	org.eclipse.uml2.uml.Port asPort();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataReaderWriter
	 */
	static final TypeSelectPredicate<DataReaderWriter> type = new TypeSelectPredicate<DataReaderWriter>(
			"DDS::DCPS::DataReaderWriter", //$NON-NLS-1$
			DataReaderWriter.class);
}
