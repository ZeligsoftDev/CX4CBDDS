package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBASequence extends CORBATemplate, CORBAType, Contained, CORBAModuleContained, CORBAClassifierContained {
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
/**
 * A predicate which returns true if the Object is an
 * instance of CORBASequence
 */
static final TypeSelectPredicate<CORBASequence> type = 
    new TypeSelectPredicate<CORBASequence>(
        "CORBADomain::IDL::CORBASequence", //$NON-NLS-1$
        CORBASequence.class); 
}
