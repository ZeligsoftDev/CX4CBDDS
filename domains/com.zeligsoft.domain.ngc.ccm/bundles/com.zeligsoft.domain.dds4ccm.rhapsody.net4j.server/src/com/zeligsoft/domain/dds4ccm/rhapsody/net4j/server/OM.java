package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OSGiActivator;
import org.eclipse.net4j.util.om.log.OMLogger;
import org.eclipse.net4j.util.om.trace.OMTracer;

/**
 * Standard infrastructure for starting up the net4j environment
 *
 */
public class OM {

	public static final String BUNDLE_ID = "com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server"; //$NON-NLS-1$

	public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID,
			OM.class);

	public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

	public static final OMLogger LOG = BUNDLE.logger();

	/**
	 * 
	 */
	public static final class Activator extends OSGiActivator {
		public Activator() {
			super(BUNDLE);
		}
		
		@Override
		protected void doStop() throws Exception {
			CXNet4j.shutdown();
			super.doStop();
		}
	}
}
