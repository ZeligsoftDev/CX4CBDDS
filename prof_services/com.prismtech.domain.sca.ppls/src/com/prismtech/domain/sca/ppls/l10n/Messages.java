/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = Messages.class.getName();

	public static String GenerateModelLabel;

	public static String GenerateModelError;

	public static String GenerateModelResourceSaveError;

	public static String CreateVariationPointLabel;

	public static String CreateVariationPointError;
	
	public static String CreateVariationPointWithValueLabel;

	public static String CreateVariationPointWithValueError;
	
	public static String CreateVariationPointWithSettingsLabel;

	public static String CreateVariationPointWithSettingsError;

	public static String SaveVariationPointModelError;

	public static String SaveNewModelResourceAfterCXGenerationError;
	
	public static String RefreshWorkspaceBeforeCXGenerationError;
	
	public static String RefreshWorkspaceAfterCXGenerationError;
	
	public static String EnableVariationPointProfileLabel;
	
	public static String EnableVariationPointProfileVPProfileNotFoundError;
	
	public static String EnableVariationPointProfileModelElementNotFoundInProfileError;
	
	public static String EnableVariationPointProfileEditingDomainError;
	
	public static String EnableVariationPointProfileUnsupportedElementError;
	
	public static String EnableVariationPointProfileAlreadyEnabled;
	
	public static String EnableVariationPointProfileError;
	
	public static String InvalidDeployOnDevice;
	
	public static String AnnotateModelError;
	
	public static String FeatureNotLicensedWarning;
	
	private Messages() {
		// Do not instantiate
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
