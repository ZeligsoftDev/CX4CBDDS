package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;

public interface CCMConnector extends AssemblyConnector {
/**
 * A predicate which returns true if the Object is an
 * instance of CCMConnector
 */
static final TypeSelectPredicate<CCMConnector> type = 
    new TypeSelectPredicate<CCMConnector>(
        "CCM::CCM_Implementation::CCMConnector", //$NON-NLS-1$
        CCMConnector.class); 
}
