package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAClassifierContained extends ZObject {
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAClassifierContained
 */
static final TypeSelectPredicate<CORBAClassifierContained> type = 
    new TypeSelectPredicate<CORBAClassifierContained>(
        "CORBADomain::IDL::CORBAClassifierContained", //$NON-NLS-1$
        CORBAClassifierContained.class); 
}
