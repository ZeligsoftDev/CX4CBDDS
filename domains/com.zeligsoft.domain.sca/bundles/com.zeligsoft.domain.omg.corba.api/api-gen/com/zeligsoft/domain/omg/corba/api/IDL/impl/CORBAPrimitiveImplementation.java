package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAPrimitive;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAPrimitiveKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBAPrimitiveImplementation
    extends CORBANamedElementImplementation implements CORBAPrimitive{
    protected CORBAPrimitiveKind _type;
    public CORBAPrimitiveImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBAPrimitiveKind getType(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAPrimitive", "type");
            
            if(_type == null) {
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
                _type = CORBAPrimitiveKind.create((org.eclipse.emf.ecore.EObject) rawValue);
            }
            }
            return _type;
    }
    public void setType(CORBAPrimitiveKind val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAPrimitive", "type", val.eObject(element));
    			}
    
    @Override
    public org.eclipse.uml2.uml.DataType asDataType() {
        return (org.eclipse.uml2.uml.DataType) eObject();
    }
}
