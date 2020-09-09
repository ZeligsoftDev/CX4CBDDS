package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataReaderWriter;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

public class DataReaderWriterZImpl extends NamedEntityZImpl implements DataReaderWriter {
	public DataReaderWriterZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Port asPort() {
		return (org.eclipse.uml2.uml.Port) eObject();
	}
}
