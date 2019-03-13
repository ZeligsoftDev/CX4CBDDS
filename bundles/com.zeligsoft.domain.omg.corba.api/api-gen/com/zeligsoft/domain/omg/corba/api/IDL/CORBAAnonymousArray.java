package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAAnonymousArray extends ZObject {
org.eclipse.uml2.uml.DataType asDataType();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAAnonymousArray
 */
static final TypeSelectPredicate<CORBAAnonymousArray> type = 
    new TypeSelectPredicate<CORBAAnonymousArray>(
        "CORBADomain::IDL::CORBAAnonymousArray", //$NON-NLS-1$
        CORBAAnonymousArray.class); 
}
