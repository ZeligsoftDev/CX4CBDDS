package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAConstant extends CORBANamedElement, CORBATyped {
String getDefault();
void setDefault(String val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAConstant
 */
static final TypeSelectPredicate<CORBAConstant> type = 
    new TypeSelectPredicate<CORBAConstant>(
        "CORBADomain::IDL::CORBAConstant", //$NON-NLS-1$
        CORBAConstant.class); 
}
