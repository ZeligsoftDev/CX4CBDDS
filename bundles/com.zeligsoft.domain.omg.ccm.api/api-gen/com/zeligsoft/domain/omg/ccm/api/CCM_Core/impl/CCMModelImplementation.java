package com.zeligsoft.domain.omg.ccm.api.CCM_Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Core.CCMModel;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.ModelImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CCMModelImplementation
    extends ModelImplementation implements CCMModel{
    public CCMModelImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
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
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
