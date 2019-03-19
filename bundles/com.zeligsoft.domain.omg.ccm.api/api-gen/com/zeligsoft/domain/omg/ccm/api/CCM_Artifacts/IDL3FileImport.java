package com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface IDL3FileImport extends ZObject {
	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDL3FileImport
	 */
	static final TypeSelectPredicate<IDL3FileImport> type = new TypeSelectPredicate<IDL3FileImport>(
			"CCM::CCM_Artifacts::IDL3FileImport", //$NON-NLS-1$
			IDL3FileImport.class);
}
