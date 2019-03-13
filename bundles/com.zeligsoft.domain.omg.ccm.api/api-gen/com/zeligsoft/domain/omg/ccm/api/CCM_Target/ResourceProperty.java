package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;

public interface ResourceProperty extends TypedElement {
Resource getTypeOverride();
void setTypeOverride(Resource val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of ResourceProperty
 */
static final TypeSelectPredicate<ResourceProperty> type = 
    new TypeSelectPredicate<ResourceProperty>(
        "CCM::CCM_Target::ResourceProperty", //$NON-NLS-1$
        ResourceProperty.class); 
}
