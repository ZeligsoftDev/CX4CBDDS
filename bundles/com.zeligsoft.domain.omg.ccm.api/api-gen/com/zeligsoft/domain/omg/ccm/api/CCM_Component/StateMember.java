package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CXTyped;

public interface StateMember extends CXTyped, CXNamedElement {
	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of StateMember
	 */
	static final TypeSelectPredicate<StateMember> type = new TypeSelectPredicate<StateMember>(
			"CCM::CCM_Component::StateMember", //$NON-NLS-1$
			StateMember.class);
}
