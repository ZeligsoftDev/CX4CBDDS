package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SharedResource extends ResourceProperty {
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of SharedResource
 */
static final TypeSelectPredicate<SharedResource> type = 
    new TypeSelectPredicate<SharedResource>(
        "CCM::CCM_Target::SharedResource", //$NON-NLS-1$
        SharedResource.class); 
}
