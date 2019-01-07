package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;

public interface BridgeInstance extends NamedElement, TypedElement {
String getLabel();
void setLabel(String val)
;
Bridge getTypeOverride();
void setTypeOverride(Bridge val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of BridgeInstance
 */
static final TypeSelectPredicate<BridgeInstance> type = 
    new TypeSelectPredicate<BridgeInstance>(
        "CCM::CCM_Target::BridgeInstance", //$NON-NLS-1$
        BridgeInstance.class); 
}
