package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABounded;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABound;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class CORBABoundedImplementation
    extends CORBANamedElementImplementation implements CORBABounded{
    protected CORBABound _bounds;
    public CORBABoundedImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBABound getBounds(){
        if(_bounds == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBABounded", "bounds");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _bounds = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBABound.class);
            }
        }
        return _bounds;
    }
    public void setBounds(CORBABound val)
    {
    	ZDLUtil.setValue(element, "CORBADomain::IDL::CORBABounded", "bounds", val.eObject());
    }
    public <T extends CORBABound> T createBounds(Class<T> typeToCreate, String concept)
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CORBADomain::IDL::CORBABounded", "bounds", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	return element;
    }
    public CORBABound createBounds()
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CORBADomain::IDL::CORBABounded", "bounds", "CORBADomain::IDL::CORBABound");
    	CORBABound element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					CORBABound.class);
    	return element;
    }
    public String getBound(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBABounded", "bound");
            return (String) rawValue;
    }
    public void setBound(String val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBABounded", "bound", val);
    			}
    
    @Override
    public org.eclipse.uml2.uml.DataType asDataType() {
        return (org.eclipse.uml2.uml.DataType) eObject();
    }
}
