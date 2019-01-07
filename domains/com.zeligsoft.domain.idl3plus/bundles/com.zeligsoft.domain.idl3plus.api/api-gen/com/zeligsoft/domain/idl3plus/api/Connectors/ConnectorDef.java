package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

public interface ConnectorDef extends ComponentInterface, CORBAModuleContained, CORBANamedElement, CORBAType {
java.util.List<CORBAAttribute> getOwnedAttribute();
void addOwnedAttribute(CORBAAttribute val);
<T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept);
CORBAAttribute addOwnedAttribute();
java.util.List<ConnectorDef> getGeneral();
void addGeneral(ConnectorDef val)
;
org.eclipse.uml2.uml.Component asComponent();
/**
 * A predicate which returns true if the Object is an
 * instance of ConnectorDef
 */
static final TypeSelectPredicate<ConnectorDef> type = 
    new TypeSelectPredicate<ConnectorDef>(
        "IDL3Plus::Connectors::ConnectorDef", //$NON-NLS-1$
        ConnectorDef.class); 
}
