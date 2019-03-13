package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBACase;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBAUnionFieldImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBACaseImplementation
    extends CORBAUnionFieldImplementation implements CORBACase{
    protected java.util.List<String> _label;
    public CORBACaseImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<String> getLabel(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBACase", "label");
            
            if(_label == null) {
            _label = new java.util.ArrayList<String>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                _label.add((String) next);
                 
            }
            }
            return _label;
    }
    public void addLabel(String val)
    {
    				// make sure the label list is created
    				getLabel();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CORBADomain::IDL::CORBACase", "label");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val);
    				if(_label != null) {
    					_label.add(val);
    				}
    			}
    
}
