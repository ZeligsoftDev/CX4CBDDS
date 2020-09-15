package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Interface;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;

public interface Event extends Interface, CXModuleContained, CXNamedElement {
	Boolean getIsAbstract();

	void setIsAbstract(Boolean val);

	Boolean getIsCustom();

	void setIsCustom(Boolean val);

	Boolean getIsTruncatable();

	void setIsTruncatable(Boolean val);

	java.util.List<StateMember> getMember();

	void addMember(StateMember val);

	java.util.List<CXAttribute> getOwnedAttribute();

	void addOwnedAttribute(CXAttribute val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Event
	 */
	static final TypeSelectPredicate<Event> type = new TypeSelectPredicate<Event>("CCM::CCM_Component::Event", //$NON-NLS-1$
			Event.class);
}
