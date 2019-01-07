package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBABounded extends CORBANamedElement, CORBAModuleContained {
String getBound();
void setBound(String val)
;
CORBABound getBounds();
void setBounds(CORBABound val)
;
<T extends CORBABound> T createBounds(Class<T> typeToCreate, String concept)
;
CORBABound createBounds()
;
org.eclipse.uml2.uml.DataType asDataType();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBABounded
 */
static final TypeSelectPredicate<CORBABounded> type = 
    new TypeSelectPredicate<CORBABounded>(
        "CORBADomain::IDL::CORBABounded", //$NON-NLS-1$
        CORBABounded.class); 
}
