package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;

public interface IDLIncludeDependency extends ZObject {
	CORBANamedElement getIncluder();

	void setIncluder(CORBANamedElement val);

	CORBANamedElement getIncludee();

	void setIncludee(CORBANamedElement val);

	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDLIncludeDependency
	 */
	static final TypeSelectPredicate<IDLIncludeDependency> type = new TypeSelectPredicate<IDLIncludeDependency>(
			"DDS4CCM::DDS4CCM::IDLIncludeDependency", //$NON-NLS-1$
			IDLIncludeDependency.class);
}
