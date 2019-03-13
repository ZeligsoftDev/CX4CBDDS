package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;

public interface IDLFileDependency extends ZObject {
	IDLFileSpecification getFile();

	void setFile(IDLFileSpecification val);

	CORBANamedElement getElement();

	void setElement(CORBANamedElement val);

	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDLFileDependency
	 */
	static final TypeSelectPredicate<IDLFileDependency> type = new TypeSelectPredicate<IDLFileDependency>(
			"DDS4CCM::DDS4CCM::IDLFileDependency", //$NON-NLS-1$
			IDLFileDependency.class);
}
