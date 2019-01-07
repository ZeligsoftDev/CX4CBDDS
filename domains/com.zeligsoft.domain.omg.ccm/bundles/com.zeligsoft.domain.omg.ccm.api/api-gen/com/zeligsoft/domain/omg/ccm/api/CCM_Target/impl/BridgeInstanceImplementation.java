package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.BridgeInstance;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Bridge;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class BridgeInstanceImplementation
    extends NamedElementImplementation implements BridgeInstance{
    protected Bridge _type;
    public BridgeInstanceImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public Bridge getTypeOverride(){
        if(_type == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::BridgeInstance", "type");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, Bridge.class);
            }
        }
        return _type;
    }
    public void setTypeOverride(Bridge val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Target::BridgeInstance", "type", val.eObject());
    			}
    public Type getType(){
        throw new UnsupportedOperationException();
    }
    
    public void setType(Type val)
    {
    				throw new UnsupportedOperationException();
    			}
    public Integer getUpperBound(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::TypedElement", "upperBound");
            return (Integer) rawValue;
    }
    public void setUpperBound(Integer val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement", "upperBound", val);
    			}
    public Integer getLowerBound(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::TypedElement", "lowerBound");
            return (Integer) rawValue;
    }
    public void setLowerBound(Integer val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement", "lowerBound", val);
    			}
    public String getLabel(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::BridgeInstance", "label");
            return (String) rawValue;
    }
    public void setLabel(String val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Target::BridgeInstance", "label", val);
    			}
    
    @Override
    public org.eclipse.uml2.uml.Property asProperty() {
        return (org.eclipse.uml2.uml.Property) eObject();
    }
}
