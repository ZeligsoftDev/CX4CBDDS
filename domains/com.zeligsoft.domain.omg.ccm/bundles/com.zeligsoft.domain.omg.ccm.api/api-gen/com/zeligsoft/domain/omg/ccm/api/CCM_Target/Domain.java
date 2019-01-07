package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

public interface Domain extends NamedElement {
String getLabel();
void setLabel(String val)
;
String getUUID();
void setUUID(String val)
;
java.util.List<NodeInstance> getNode();
void addNode(NodeInstance val);
<T extends NodeInstance> T addNode(Class<T> typeToCreate, String concept);
NodeInstance addNode();
java.util.List<InterconnectInstance> getInterconnect();
void addInterconnect(InterconnectInstance val);
<T extends InterconnectInstance> T addInterconnect(Class<T> typeToCreate, String concept);
InterconnectInstance addInterconnect();
java.util.List<BridgeInstance> getBridge();
void addBridge(BridgeInstance val);
<T extends BridgeInstance> T addBridge(Class<T> typeToCreate, String concept);
BridgeInstance addBridge();
java.util.List<AssemblyConnector> getConnections();
void addConnections(AssemblyConnector val);
<T extends AssemblyConnector> T addConnections(Class<T> typeToCreate, String concept);
AssemblyConnector addConnections();
java.util.List<CORBAAttribute> getInfoProperty();
void addInfoProperty(CORBAAttribute val);
<T extends CORBAAttribute> T addInfoProperty(Class<T> typeToCreate, String concept);
CORBAAttribute addInfoProperty();
java.util.List<SharedResource> getSharedResource();
void addSharedResource(SharedResource val);
<T extends SharedResource> T addSharedResource(Class<T> typeToCreate, String concept);
SharedResource addSharedResource();
org.eclipse.uml2.uml.Component asComponent();
/**
 * A predicate which returns true if the Object is an
 * instance of Domain
 */
static final TypeSelectPredicate<Domain> type = 
    new TypeSelectPredicate<Domain>(
        "CCM::CCM_Target::Domain", //$NON-NLS-1$
        Domain.class); 
}
