package com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan;
import com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeploymentImplementation;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class DeploymentPlanImplementation
    extends DeploymentImplementation implements DeploymentPlan{
    public DeploymentPlanImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public String getId(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Deployment::DeploymentPlan", "id");
            return (String) rawValue;
    }
    public void setId(String val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Deployment::DeploymentPlan", "id", val);
    			}
    
}
