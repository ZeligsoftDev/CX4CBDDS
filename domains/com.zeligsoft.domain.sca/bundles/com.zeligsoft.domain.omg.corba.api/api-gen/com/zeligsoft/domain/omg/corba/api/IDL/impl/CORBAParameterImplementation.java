package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBATypedImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBAParameterImplementation
    extends CORBATypedImplementation implements CORBAParameter{
    protected org.eclipse.uml2.uml.ParameterDirectionKind _direction;
    public CORBAParameterImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public org.eclipse.uml2.uml.ParameterDirectionKind getDirection(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAParameter", "direction");
            return (org.eclipse.uml2.uml.ParameterDirectionKind) rawValue;
    }
    public void setDirection(org.eclipse.uml2.uml.ParameterDirectionKind val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAParameter", "direction", val);
    			}
    public String getQualifiedName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
            return (String) rawValue;
    }
    public String getName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "name");
            return (String) rawValue;
    }
    public void setName(String val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
    			}
    
    @Override
    public org.eclipse.uml2.uml.Parameter asParameter() {
        return (org.eclipse.uml2.uml.Parameter) eObject();
    }
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
