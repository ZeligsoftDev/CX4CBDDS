package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBATypeDef;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBAWrapperImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBATypeDefImplementation
    extends CORBAWrapperImplementation implements CORBATypeDef{
    protected CORBAType _type;
    public CORBATypeDefImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBAType getType(){
        if(_type == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBATypeDef", "type");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAType.class);
            }
        }
        return _type;
    }
    public void setType(CORBAType val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBATypeDef", "type", val.eObject());
    			}
    
}
