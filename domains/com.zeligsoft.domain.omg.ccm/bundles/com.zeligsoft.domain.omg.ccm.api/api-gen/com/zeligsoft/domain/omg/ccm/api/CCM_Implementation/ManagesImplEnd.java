package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ManagesImplEnd extends ZObject {
/**
 * A predicate which returns true if the Object is an
 * instance of ManagesImplEnd
 */
static final TypeSelectPredicate<ManagesImplEnd> type = 
    new TypeSelectPredicate<ManagesImplEnd>(
        "CCM::CCM_Implementation::ManagesImplEnd", //$NON-NLS-1$
        ManagesImplEnd.class); 
}
