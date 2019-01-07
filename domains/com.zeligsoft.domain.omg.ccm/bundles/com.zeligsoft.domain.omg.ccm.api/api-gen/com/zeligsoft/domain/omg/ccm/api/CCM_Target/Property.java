package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;

public interface Property extends NamedElement, TypedElement {
String getValue();
void setValue(String val)
;
CORBAType getTypeOverride();
void setTypeOverride(CORBAType val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of Property
 */
static final TypeSelectPredicate<Property> type = 
    new TypeSelectPredicate<Property>(
        "CCM::CCM_Target::Property", //$NON-NLS-1$
        Property.class); 
}
