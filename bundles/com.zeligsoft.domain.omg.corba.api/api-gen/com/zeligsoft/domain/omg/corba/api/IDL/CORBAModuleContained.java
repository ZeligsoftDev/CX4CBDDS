package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAModuleContained extends ZObject {
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAModuleContained
 */
static final TypeSelectPredicate<CORBAModuleContained> type = 
    new TypeSelectPredicate<CORBAModuleContained>(
        "CORBADomain::IDL::CORBAModuleContained", //$NON-NLS-1$
        CORBAModuleContained.class); 
}
