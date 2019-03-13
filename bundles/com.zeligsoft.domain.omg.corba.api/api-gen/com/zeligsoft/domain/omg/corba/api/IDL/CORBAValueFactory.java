package com.zeligsoft.domain.omg.corba.api.IDL;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAValueFactory extends ZObject {
org.eclipse.uml2.uml.Operation asOperation();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAValueFactory
 */
static final TypeSelectPredicate<CORBAValueFactory> type = 
    new TypeSelectPredicate<CORBAValueFactory>(
        "CORBADomain::IDL::CORBAValueFactory", //$NON-NLS-1$
        CORBAValueFactory.class); 
}
