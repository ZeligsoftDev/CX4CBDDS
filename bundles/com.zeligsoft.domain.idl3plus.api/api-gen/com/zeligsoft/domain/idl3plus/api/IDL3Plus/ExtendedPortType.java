package com.zeligsoft.domain.idl3plus.api.IDL3Plus;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.zml.api.ZML_Component.PortType;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

public interface ExtendedPortType extends CXModuleContained, PortType, CXNamedElement, CXType {
	java.util.List<CXAttribute> getOwnedAttribute();

	void addOwnedAttribute(CXAttribute val);

	<T extends CXAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept);

	CXAttribute addOwnedAttribute();

	@Override
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ExtendedPortType
	 */
	static final TypeSelectPredicate<ExtendedPortType> type = new TypeSelectPredicate<ExtendedPortType>(
			"IDL3Plus::IDL3Plus::ExtendedPortType", //$NON-NLS-1$
			ExtendedPortType.class);
}
