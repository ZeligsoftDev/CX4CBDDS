package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;

public class TransformToUml2IndicatorWithProgress extends IndicationWithMonitoring {

	private boolean transformedOK = true;

	public TransformToUml2IndicatorWithProgress(
			ModelServicesServerProtocol modelServicesServerProtocol) {
		super(modelServicesServerProtocol,
				EclipseServerSignals.TransformToUml2);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in, OMMonitor monitor) throws Exception {
		// deserialize:
		final String modelName = in.readString();

		// do it...
		transformedOK = new ModelServicesImpl().transformToUML2WithProgress(modelName, monitor);

	}

	@Override
	protected void responding(ExtendedDataOutputStream out, OMMonitor monitor)
			throws Exception {
		out.writeString(transformedOK ? "Rhapsody model successfully transformed."
							: "An error occurred during the transformation.");
		
	}

}
