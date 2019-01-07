package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.MessagePortImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class InterfacePortImplementation
    extends MessagePortImplementation implements InterfacePort{
    public InterfacePortImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public String getUuid(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid");
            return (String) rawValue;
    }
    public void setUuid(String val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Component::WorkerFunctionIdentifiable", "uuid", val);
    			}
    public Boolean getIsAsynchronous(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::InterfacePort", "isAsynchronous");
            return (Boolean) rawValue;
    }
    public void setIsAsynchronous(Boolean val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::InterfacePort", "isAsynchronous", val);
    			}
    public Boolean getHasCSL(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::InterfacePort", "hasCSL");
            return (Boolean) rawValue;
    }
    public void setHasCSL(Boolean val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::InterfacePort", "hasCSL", val);
    			}
    public Boolean getIsConjugated(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Component::ConjugatedPort", "isConjugated");
            return (Boolean) rawValue;
    }
    public void setIsConjugated(Boolean val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConjugatedPort", "isConjugated", val);
    			}
    
}
