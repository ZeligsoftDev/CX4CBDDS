package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBATypeDef extends CORBAWrapper, CORBAType, CORBANamedElement, CORBAModuleContained, CORBAClassifierContained {
CORBAType getType();
void setType(CORBAType val)
;
/**
 * A predicate which returns true if the Object is an
 * instance of CORBATypeDef
 */
static final TypeSelectPredicate<CORBATypeDef> type = 
    new TypeSelectPredicate<CORBATypeDef>(
        "CORBADomain::IDL::CORBATypeDef", //$NON-NLS-1$
        CORBATypeDef.class); 
}
