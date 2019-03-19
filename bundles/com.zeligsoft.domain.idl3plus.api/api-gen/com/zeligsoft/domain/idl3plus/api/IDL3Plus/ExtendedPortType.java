package com.zeligsoft.domain.idl3plus.api.IDL3Plus;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.zml.api.ZML_Component.PortType;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

public interface ExtendedPortType extends CORBAModuleContained, PortType,
		CORBANamedElement, CORBAType {
	java.util.List<CORBAAttribute> getOwnedAttribute();

	void addOwnedAttribute(CORBAAttribute val);

	<T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate,
			String concept);

	CORBAAttribute addOwnedAttribute();

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
