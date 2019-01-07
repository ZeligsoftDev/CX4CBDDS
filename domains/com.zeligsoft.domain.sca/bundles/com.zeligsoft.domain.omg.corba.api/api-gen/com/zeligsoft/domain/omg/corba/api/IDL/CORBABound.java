package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBABound extends ZObject {
String getValue();
void setValue(String val)
;
CORBAConstant getConstant();
void setConstant(CORBAConstant val)
;
/**
 * A predicate which returns true if the Object is an
 * instance of CORBABound
 */
static final TypeSelectPredicate<CORBABound> type = 
    new TypeSelectPredicate<CORBABound>(
        "CORBADomain::IDL::CORBABound", //$NON-NLS-1$
        CORBABound.class); 
}
