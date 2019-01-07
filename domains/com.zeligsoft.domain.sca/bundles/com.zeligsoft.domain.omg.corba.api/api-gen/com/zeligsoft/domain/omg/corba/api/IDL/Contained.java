package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Contained extends ZObject {
/**
 * A predicate which returns true if the Object is an
 * instance of Contained
 */
static final TypeSelectPredicate<Contained> type = 
    new TypeSelectPredicate<Contained>(
        "CORBADomain::IDL::Contained", //$NON-NLS-1$
        Contained.class); 
}
