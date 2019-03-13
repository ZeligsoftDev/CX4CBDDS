package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBATyped;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class CORBATypedImplementation
    extends ZObjectImpl implements CORBATyped{
    protected CORBAType _idlType;
    public CORBATypedImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBAType getIdlType(){
        if(_idlType == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBATyped", "idlType");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAType.class);
            }
        }
        return _idlType;
    }
    public void setIdlType(CORBAType val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBATyped", "idlType", val.eObject());
    			}
    
}
