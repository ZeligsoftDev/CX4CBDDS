package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface CORBANamedElement extends NamedElement {
org.eclipse.uml2.uml.NamedElement asNamedElement();
/**
 * A predicate which returns true if the Object is an
 * instance of CORBANamedElement
 */
static final TypeSelectPredicate<CORBANamedElement> type = 
    new TypeSelectPredicate<CORBANamedElement>(
        "CORBADomain::IDL::CORBANamedElement", //$NON-NLS-1$
        CORBANamedElement.class); 
}
