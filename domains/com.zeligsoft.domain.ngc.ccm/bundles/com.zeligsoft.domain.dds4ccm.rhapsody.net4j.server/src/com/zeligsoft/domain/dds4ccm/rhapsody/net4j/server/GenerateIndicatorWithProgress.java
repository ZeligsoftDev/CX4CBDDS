package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import com.zeligsoft.domain.dds4ccm.rhapsody.kryo.KryoReadUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.LocalRhapsodyProjectLocator;

public class GenerateIndicatorWithProgress extends IndicationWithMonitoring {

	private boolean result;

	public GenerateIndicatorWithProgress(ModelServicesServerProtocol protocol) {
		super(protocol, EclipseServerSignals.Generate);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in, OMMonitor monitor)
			throws Exception {
		
		final String zdlConcept = in.readString();
		final String modelElementQualifiedName = in.readString();
		final String transformId = in.readString();

		// pull model...
		final String modelName = in.readString();
		final Object project = KryoReadUtil.readModel(in);

		final ModelServicesImpl msi = new ModelServicesImpl();

		final LocalRhapsodyProjectLocator projectLocator = new LocalRhapsodyProjectLocator(
				project);

		List<Job> jobList = new ArrayList<Job>(3);
		jobList.add(msi.getCreateUml2ModelJob(modelName));
		jobList.add(msi
				.getTransformToUml2Job(projectLocator));
		jobList.add(msi.getCXTransformJob(zdlConcept,
				modelElementQualifiedName, transformId));
		
		// TODO: queue each job, and wait for completion
		final MultiStatus status = new MultiStatus(OM.BUNDLE_ID, IStatus.OK, "Generator Status", null);
		monitor.begin(300);
		for (Job job : jobList) {
			job.schedule();
//			job.join();
			int ticksUsed = 0;
			while(job.getState() != Job.NONE) {
				Thread.sleep(1000);
				++ticksUsed;
				monitor.worked();
			}
			monitor.worked(Math.max(1, 100 - ticksUsed));
			status.add(job.getResult());
			if(!status.isOK()) {
				break;
			}
		}
		
		result = status.isOK();
		monitor.done();
	}

	@Override
	protected void responding(ExtendedDataOutputStream out, OMMonitor monitor)
			throws Exception {
		out.writeBoolean(result);
	}

}
