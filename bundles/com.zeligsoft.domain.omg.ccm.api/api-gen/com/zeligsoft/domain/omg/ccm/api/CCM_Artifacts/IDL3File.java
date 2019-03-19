package com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface IDL3File extends NamedElement {
	String getLocation();

	void setLocation(String val);

	java.util.List<IDL3FileImport> getContents();

	void addContents(IDL3FileImport val);

	<T extends IDL3FileImport> T addContents(Class<T> typeToCreate,
			String concept);

	IDL3FileImport addContents();

	org.eclipse.uml2.uml.Artifact asArtifact();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDL3File
	 */
	static final TypeSelectPredicate<IDL3File> type = new TypeSelectPredicate<IDL3File>(
			"CCM::CCM_Artifacts::IDL3File", //$NON-NLS-1$
			IDL3File.class);
}
