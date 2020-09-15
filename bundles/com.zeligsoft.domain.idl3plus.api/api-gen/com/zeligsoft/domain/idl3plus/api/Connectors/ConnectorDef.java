package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

public interface ConnectorDef extends ComponentInterface, CXModuleContained, CXNamedElement, CXType {
	java.util.List<CXAttribute> getOwnedAttribute();

	void addOwnedAttribute(CXAttribute val);

	<T extends CXAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept);

	CXAttribute addOwnedAttribute();

	java.util.List<ConnectorDef> getGeneral();

	void addGeneral(ConnectorDef val);

	@Override
	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorDef
	 */
	static final TypeSelectPredicate<ConnectorDef> type = new TypeSelectPredicate<ConnectorDef>(
			"IDL3Plus::Connectors::ConnectorDef", //$NON-NLS-1$
			ConnectorDef.class);
}
