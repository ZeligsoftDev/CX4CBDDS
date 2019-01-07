package com.zeligsoft.domain.omg.corba.api.IDLFileSupport;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface IDLImport extends ZObject {
IDLFile getTarget();
void setTarget(IDLFile val)
;
org.eclipse.uml2.uml.Dependency asDependency();
/**
 * A predicate which returns true if the Object is an
 * instance of IDLImport
 */
static final TypeSelectPredicate<IDLImport> type = 
    new TypeSelectPredicate<IDLImport>(
        "CORBADomain::IDLFileSupport::IDLImport", //$NON-NLS-1$
        IDLImport.class); 
}
