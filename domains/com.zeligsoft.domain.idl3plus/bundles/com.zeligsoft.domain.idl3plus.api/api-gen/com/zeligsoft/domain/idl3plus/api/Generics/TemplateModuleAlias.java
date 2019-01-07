package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;

public interface TemplateModuleAlias extends CORBANamedElement {
/**
 * A predicate which returns true if the Object is an
 * instance of TemplateModuleAlias
 */
static final TypeSelectPredicate<TemplateModuleAlias> type = 
    new TypeSelectPredicate<TemplateModuleAlias>(
        "IDL3Plus::Generics::TemplateModuleAlias", //$NON-NLS-1$
        TemplateModuleAlias.class); 
}
