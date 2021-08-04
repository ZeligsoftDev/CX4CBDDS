package com.zeligsoft.domain.dds4ccm.tools.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.dds4ccm.tools.l10n.Messages"; //$NON-NLS-1$
	public static String DDS4CCMDynamicURIMapHandler_BrokenLinkValidateMsg;
	public static String DDS4CCMDynamicURIMapHandler_BrokenLinkWarningTitle;
	public static String DDS4CCMDynamicURIMapHandler_UpdateingWorkspaceUri;
	public static String DDS4CCMDynamicURIMapHandler_RemovingDynamicModelWarning;
	public static String DDS4CCMDynamicURIMapHandler_WarningDialogTitle;
	public static String DynamicPathmapCustomPropertySection_FieldLabel;
	public static String DynamicURIMappingsPreferencePage_PreferencePageTitle;
	public static String DynamicURIMappingsPreferencePage_RemapLabel;
	public static String ICMBrowseDialog_DialogTitle;
	public static String DDS4CCMDynamicURIMapHandler_PackageImportError;
	public static String ReferencesCustomPropertySection_FindingReferencedModelsTaskName;
	public static String ReferencesCustomPropertySection_FindReferencingModelTaskName;
	public static String ReferencesCustomPropertySection_ReferencedModelTabLabel;
	public static String ReferencesCustomPropertySection_ReferencingModelTabLabl;
	public static String ReferencesCustomPropertySection_SectionLabel;
	public static String ReferencesCustomPropertySection_ShowReferencedModelButtonLabel;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
