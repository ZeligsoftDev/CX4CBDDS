package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBATemplate;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class CORBATemplateImplementation
    extends CORBANamedElementImplementation implements CORBATemplate{
    public CORBATemplateImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
    @Override
    public org.eclipse.uml2.uml.DataType asDataType() {
        return (org.eclipse.uml2.uml.DataType) eObject();
    }
}
