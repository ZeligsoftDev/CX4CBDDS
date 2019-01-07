package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;

public interface TargetAssemblyConnector extends AssemblyConnector {
/**
 * A predicate which returns true if the Object is an
 * instance of TargetAssemblyConnector
 */
static final TypeSelectPredicate<TargetAssemblyConnector> type = 
    new TypeSelectPredicate<TargetAssemblyConnector>(
        "CCM::CCM_Target::TargetAssemblyConnector", //$NON-NLS-1$
        TargetAssemblyConnector.class); 
}
