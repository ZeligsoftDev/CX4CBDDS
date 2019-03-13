package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.idl3plus.api.Generics.ParameterBinding;

import com.zeligsoft.domain.idl3plus.api.Generics.TypeParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class ParameterBindingZImpl
    extends ZObjectImpl implements ParameterBinding{
    protected CORBAType _type;
    protected TypeParameter _typeParameter;
    public ParameterBindingZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBAType getType(){
        if(_type == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "IDL3Plus::Generics::ParameterBinding", "type");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAType.class);
            }
        }
        return _type;
    }
    public void setType(CORBAType val)
    {
    				ZDLUtil.setValue(element, "IDL3Plus::Generics::ParameterBinding", "type", val.eObject());
    			}
    public TypeParameter getTypeParameter(){
        if(_typeParameter == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "IDL3Plus::Generics::ParameterBinding", "typeParameter");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _typeParameter = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, TypeParameter.class);
            }
        }
        return _typeParameter;
    }
    public void setTypeParameter(TypeParameter val)
    {
    				ZDLUtil.setValue(element, "IDL3Plus::Generics::ParameterBinding", "typeParameter", val.eObject());
    			}
    
    @Override
    public org.eclipse.uml2.uml.TemplateParameterSubstitution asTemplateParameterSubstitution() {
        return (org.eclipse.uml2.uml.TemplateParameterSubstitution) eObject();
    }
}
