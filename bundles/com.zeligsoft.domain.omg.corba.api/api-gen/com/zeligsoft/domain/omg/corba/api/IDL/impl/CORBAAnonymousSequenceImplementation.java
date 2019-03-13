package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAnonymousSequence;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBAAnonymousSequenceImplementation
    extends ZObjectImpl implements CORBAAnonymousSequence{
    public CORBAAnonymousSequenceImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
    @Override
    public org.eclipse.uml2.uml.DataType asDataType() {
        return (org.eclipse.uml2.uml.DataType) eObject();
    }
}
