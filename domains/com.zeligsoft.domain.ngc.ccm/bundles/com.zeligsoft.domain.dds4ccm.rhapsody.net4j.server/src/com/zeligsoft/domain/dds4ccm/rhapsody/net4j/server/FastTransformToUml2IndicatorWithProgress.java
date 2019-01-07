package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;
//import com.zeligsoft.domain.dds4ccm.rhapsody.kryo.KryoReadUtil;

public class FastTransformToUml2IndicatorWithProgress extends IndicationWithMonitoring {

	private boolean transformedOK = true;

	public FastTransformToUml2IndicatorWithProgress(
			ModelServicesServerProtocol modelServicesServerProtocol) {
		super(modelServicesServerProtocol,
				EclipseServerSignals.FastTransform);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in, OMMonitor monitor) throws Exception {
		// deserialize:
		final String projectName = in.readString();
//		final String tempFilePath = in.readString();
		
//		final BufferedInputStream fsi = new BufferedInputStream(new FileInputStream(new File(tempFilePath)));
		Object project = null;
		try {
//			project = com.zeligsoft.domain.dds4ccm.rhapsody.kryotest.kryo.KryoReadUtil.readModel(fsi);
			project = com.zeligsoft.domain.dds4ccm.rhapsody.kryo.KryoReadUtil.readModel(in);
		} finally {
//			fsi.close();
		}

		// do it...
		transformedOK = new ModelServicesImpl().fastTransformToUML2WithProgress(projectName, project, monitor);

	}

	@Override
	protected void responding(ExtendedDataOutputStream out, OMMonitor monitor)
			throws Exception {
		out.writeString(transformedOK ? "Rhapsody model successfully transformed."
							: "An error occurred during the transformation.");
		
	}

}
