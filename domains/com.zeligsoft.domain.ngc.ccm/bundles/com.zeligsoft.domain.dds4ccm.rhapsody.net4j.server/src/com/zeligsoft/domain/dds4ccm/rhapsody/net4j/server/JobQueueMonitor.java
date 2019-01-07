package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

public class JobQueueMonitor {

	private static class JobData {
		private final Job job;
		private final int ticks;

		public JobData(Job job, int ticks) {
			super();
			this.job = job;
			this.ticks = ticks;
		}

		public Job getJob() {
			return job;
		}

		public int getTicks() {
			return ticks;
		}
	}

	public static class Builder {

		final List<JobData> jobData = new ArrayList<JobData>();

		public Builder job(Job job, int ticks) {
			jobData.add(new JobData(job, ticks));
			return this;
		}

		public JobQueueMonitor build() {
			return new JobQueueMonitor(this);
		}
	}

	final List<JobData> jobData;

	protected JobQueueMonitor(Builder builder) {
		this.jobData = new ArrayList<JobData>(builder.jobData);
	}

	public IStatus run(OMMonitor monitor) {
		final MultiStatus status = new MultiStatus(OM.BUNDLE_ID, IStatus.OK,
				"Generator Status", null);

		monitor.begin(getTotalWork());
		try {
			for (JobData data : jobData) {
				final Job job = data.getJob();
				job.schedule();
				// Note: Using job.join() can result in Net4j time outs
				// Instead, we sleep our thread until the job completes.
				int ticksUsed = 0;
				while (job.getState() != Job.NONE) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// so we woke a little early, just continue...
					}
					ticksUsed = Math.max(data.getTicks(), ticksUsed + 1);
					monitor.worked();
				}
				monitor.worked(Math.max(1, data.getTicks() - ticksUsed));
				status.add(job.getResult());
				if (!status.isOK()) {
					break;
				}
			}
		} finally {
			monitor.done();
		}
		return status;
	}

	private double getTotalWork() {
		long total = 0;
		for (JobData data : jobData) {
			total += data.getTicks();
		}
		return total;
	}

}
