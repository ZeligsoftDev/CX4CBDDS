package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages"; //$NON-NLS-1$
	public static String GenerateAllDescriptors_ErrorElementIsNull;
	public static String GenerateAllDescriptors_FailureExecutingWorkflow;
	public static String GenerateAllDescriptors_FailurePreparingWorkflow;
	public static String GenerateAllCDDs_ErrorElementIsNull;
	public static String GenerateAllCDDs_ErrorElementIsNotDomainDefinitionOrPackage;
	public static String GenerateAllCDDs_FailurePreparingWorkflow;
	public static String GenerateAllCDDs_FailureExecutingWorkflow;
	public static String GenerateAllCDDs_TaskTitle;
	public static String GenerateAllCDPs_ErrorElementIsNull;
	public static String GenerateAllCDPs_ErrorElementIsNotDeploymentPlanOrPackage;
	public static String GenerateAllCDPs_FailurePreparingWorkflow;
	public static String GenerateAllCDPs_FailureExecutingWorkflow;
	public static String GenerateAllCDPs_TaskTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
