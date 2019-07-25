package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10.Messages"; //$NON-NLS-1$
	public static String GenerateAllDescriptors_ErrorElementIsNull;
	public static String GenerateAllDescriptors_FailureExecutingWorkflow;
	public static String GenerateAllDescriptors_FailurePreparingWorkflow;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
