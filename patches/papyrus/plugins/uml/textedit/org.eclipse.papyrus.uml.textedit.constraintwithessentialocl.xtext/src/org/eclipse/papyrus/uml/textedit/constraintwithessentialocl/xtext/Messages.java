package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext.messages"; //$NON-NLS-1$
	public static String EssentialOCLEditorConfiguration_AlreadyContainsNonEmpty;
	public static String EssentialOCLEditorConfiguration_ExistingSpecification;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
