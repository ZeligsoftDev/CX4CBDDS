package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

public interface Requirement extends NamedElement {
	String getResourceType();

	void setResourceType(String val);

	java.util.List<CORBAAttribute> getProperty();

	void addProperty(CORBAAttribute val);

	<T extends CORBAAttribute> T addProperty(Class<T> typeToCreate,
			String concept);

	CORBAAttribute addProperty();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Requirement
	 */
	static final TypeSelectPredicate<Requirement> type = new TypeSelectPredicate<Requirement>(
			"CCM::CCM_Target::Requirement", //$NON-NLS-1$
			Requirement.class);
}
