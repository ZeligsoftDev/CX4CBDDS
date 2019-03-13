package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface IDLFileSpecification extends ZObject {
	String getFilename();

	void setFilename(String val);

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDLFileSpecification
	 */
	static final TypeSelectPredicate<IDLFileSpecification> type = new TypeSelectPredicate<IDLFileSpecification>(
			"DDS4CCM::DDS4CCM::IDLFileSpecification", //$NON-NLS-1$
			IDLFileSpecification.class); 
}
