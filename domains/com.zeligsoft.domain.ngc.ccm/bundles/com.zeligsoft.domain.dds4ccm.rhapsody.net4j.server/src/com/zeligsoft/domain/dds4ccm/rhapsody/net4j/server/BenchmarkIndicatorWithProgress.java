package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import com.zeligsoft.domain.dds4ccm.rhapsody.benchmark.Benchmark;
import com.zeligsoft.domain.dds4ccm.rhapsody.benchmark.Benchmark.TestResult;
import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;

public class BenchmarkIndicatorWithProgress extends IndicationWithMonitoring {

	private List<TestResult> testResults;

	public BenchmarkIndicatorWithProgress(
			ModelServicesServerProtocol modelServicesServerProtocol) {
		super(modelServicesServerProtocol, EclipseServerSignals.Benchmark);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in,
			final OMMonitor monitor) throws Exception {
		final int iterations = in.readInt();

		final Object activeProject = Benchmark.getActiveProject();

		new JobQueueMonitor.Builder()
				.job(new Job("Benchmark COM Performance") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						testResults = new Benchmark(activeProject, iterations).benchmark(monitor);
						return Status.OK_STATUS;
					}
				}, 400)
				.build()
				.run(monitor);

	}

	@Override
	protected void responding(ExtendedDataOutputStream out, OMMonitor monitor)
			throws Exception {
		final String summary = TestResult.summarize(testResults);

		out.writeString(summary);

	}

}
