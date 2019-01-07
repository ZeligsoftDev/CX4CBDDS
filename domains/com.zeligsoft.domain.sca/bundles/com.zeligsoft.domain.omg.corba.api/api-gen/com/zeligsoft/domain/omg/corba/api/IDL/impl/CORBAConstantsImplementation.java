package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBAConstantsImplementation
    extends CORBANamedElementImplementation implements CORBAConstants{
    public CORBAConstantsImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
    @Override
    public org.eclipse.uml2.uml.Class asClass() {
        return (org.eclipse.uml2.uml.Class) eObject();
    }
}
