package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class WorkerFunctionIdentifiableImplementation
    extends ZObjectImpl implements WorkerFunctionIdentifiable{
    public WorkerFunctionIdentifiableImplementation(org.eclipse.emf.ecore.EObject element) {
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
    
}
