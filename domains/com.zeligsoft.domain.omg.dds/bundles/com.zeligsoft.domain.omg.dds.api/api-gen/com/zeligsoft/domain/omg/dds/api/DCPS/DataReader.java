package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DataReader extends DataReaderWriter {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataReader
	 */
	static final TypeSelectPredicate<DataReader> type = new TypeSelectPredicate<DataReader>(
			"DDS::DCPS::DataReader", //$NON-NLS-1$
			DataReader.class);
}
