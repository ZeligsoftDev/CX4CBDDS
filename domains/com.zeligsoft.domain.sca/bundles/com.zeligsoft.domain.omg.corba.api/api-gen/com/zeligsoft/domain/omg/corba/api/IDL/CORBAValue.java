package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAValue extends CORBAType, Contained, CORBAClassifier {
Boolean getIsCustom();
void setIsCustom(Boolean val)
;
Boolean getIsTruncatable();
void setIsTruncatable(Boolean val)
;
Boolean getIsAbstract();
void setIsAbstract(Boolean val)
;
org.eclipse.uml2.uml.Interface asInterface();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBAValue
 */
static final TypeSelectPredicate<CORBAValue> type = 
    new TypeSelectPredicate<CORBAValue>(
        "CORBADomain::IDL::CORBAValue", //$NON-NLS-1$
        CORBAValue.class); 
}
