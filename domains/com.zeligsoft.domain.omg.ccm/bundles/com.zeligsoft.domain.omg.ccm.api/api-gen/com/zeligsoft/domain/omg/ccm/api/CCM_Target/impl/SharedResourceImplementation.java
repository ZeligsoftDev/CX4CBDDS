package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SharedResource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl.ResourcePropertyImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class SharedResourceImplementation
    extends ResourcePropertyImplementation implements SharedResource{
    public SharedResourceImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
    @Override
    public org.eclipse.uml2.uml.Property asProperty() {
        return (org.eclipse.uml2.uml.Property) eObject();
    }
}
