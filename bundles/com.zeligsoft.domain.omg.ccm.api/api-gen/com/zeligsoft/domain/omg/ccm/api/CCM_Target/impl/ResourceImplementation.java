package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.RequirementSatisfierImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class ResourceImplementation
    extends RequirementSatisfierImplementation implements Resource{
    public ResourceImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
    @Override
    public org.eclipse.uml2.uml.Class asClass() {
        return (org.eclipse.uml2.uml.Class) eObject();
    }
}
