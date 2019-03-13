package com.zeligsoft.domain.omg.corba.idlimport.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.domain.omg.corba.idlimport.l10n.messages"; //$NON-NLS-1$

	public static String IDL2ScopeFinder_0;

	public static String IDL2ScopeFinder_1;

	public static String IDLParserComponent_ExceptionClosingInputStream;

	public static String IDLParserComponent_FileNotFoundException;

	public static String IDLParserComponent_InvalidProcessedIDLFileSlot;

	public static String IDLParserComponent_MissingOutputIDLSlotNameError;
	
	public static String IDLParserComponent_SyntaxError;

	public static String IDLPreprocessor_AccessErrorMessage;

	public static String IDLPreprocessor_DeleteErrorMessage;

	public static String IDLPreprocessor_GPPNotFound;

	public static String IDLPreprocessor_GPPRuntimeProblem;

	public static String IDLPreprocessor_OutputNotSpecified;

	public static String IDLPreprocessor_PreprocessorErrorMsg;

	public static String IDLPreprocessor_SourceNotSpecified;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
