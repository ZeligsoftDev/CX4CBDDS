package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAPrimitive extends CORBANamedElement, CORBAType, Contained {
CORBAPrimitiveKind getType();
void setType(CORBAPrimitiveKind val)
;
org.eclipse.uml2.uml.DataType asDataType();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAPrimitive
 */
static final TypeSelectPredicate<CORBAPrimitive> type = 
    new TypeSelectPredicate<CORBAPrimitive>(
        "CORBADomain::IDL::CORBAPrimitive", //$NON-NLS-1$
        CORBAPrimitive.class); 
}
