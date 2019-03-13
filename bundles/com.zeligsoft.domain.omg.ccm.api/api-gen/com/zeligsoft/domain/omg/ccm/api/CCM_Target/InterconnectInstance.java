package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;

public interface InterconnectInstance extends NamedElement, TypedElement {
String getLabel();
void setLabel(String val)
;
Interconnect getTypeOverride();
void setTypeOverride(Interconnect val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of InterconnectInstance
 */
static final TypeSelectPredicate<InterconnectInstance> type = 
    new TypeSelectPredicate<InterconnectInstance>(
        "CCM::CCM_Target::InterconnectInstance", //$NON-NLS-1$
        InterconnectInstance.class); 
}
