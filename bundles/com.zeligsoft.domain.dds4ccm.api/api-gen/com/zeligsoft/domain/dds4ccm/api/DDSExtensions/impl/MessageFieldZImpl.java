package com.zeligsoft.domain.dds4ccm.api.DDSExtensions.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBAFieldImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class MessageFieldZImpl
    extends CORBAFieldImplementation implements MessageField{
    protected CORBAType _idlType;
    public MessageFieldZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public Boolean getIsKey(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS4CCM::DDSExtensions::MessageField", "isKey");
            return (Boolean) rawValue;
    }
    public void setIsKey(Boolean val)
    {
    				ZDLUtil.setValue(element, "DDS4CCM::DDSExtensions::MessageField", "isKey", val);
    			}
    public CORBAType getIdlType(){
        if(_idlType == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS4CCM::DDSExtensions::MessageField", "idlType");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAType.class);
            }
        }
        return _idlType;
    }
    public void setIdlType(CORBAType val)
    {
    				ZDLUtil.setValue(element, "DDS4CCM::DDSExtensions::MessageField", "idlType", val.eObject());
    			}
    
}
