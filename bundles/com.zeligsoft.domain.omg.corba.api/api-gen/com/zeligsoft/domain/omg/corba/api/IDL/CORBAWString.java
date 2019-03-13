package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAWString extends CORBABounded, CORBAType, CORBAClassifierContained {
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAWString
 */
static final TypeSelectPredicate<CORBAWString> type = 
    new TypeSelectPredicate<CORBAWString>(
        "CORBADomain::IDL::CORBAWString", //$NON-NLS-1$
        CORBAWString.class); 
}
