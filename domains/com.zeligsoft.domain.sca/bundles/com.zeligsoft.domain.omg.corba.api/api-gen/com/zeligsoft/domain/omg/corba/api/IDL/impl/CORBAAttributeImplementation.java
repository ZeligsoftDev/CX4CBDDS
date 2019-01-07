package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CORBAAttributeImplementation
    extends CORBANamedElementImplementation implements CORBAAttribute{
    protected CORBAModuleContained _owner;
    protected CORBAType _idlType;
    protected java.util.List<CORBAException> _getraises;
    protected java.util.List<CORBAException> _setraises;
    public CORBAAttributeImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public CORBAModuleContained getOwner(){
        if(_owner == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAAttribute", "owner");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _owner = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAModuleContained.class);
            }
        }
        return _owner;
    }
    public Boolean getIsReadOnly(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAAttribute", "isReadOnly");
            return (Boolean) rawValue;
    }
    public void setIsReadOnly(Boolean val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAAttribute", "isReadOnly", val);
    			}
    public CORBAType getIdlType(){
        if(_idlType == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBATyped", "idlType");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, CORBAType.class);
            }
        }
        return _idlType;
    }
    public void setIdlType(CORBAType val)
    {
    				ZDLUtil.setValue(element, "CORBADomain::IDL::CORBATyped", "idlType", val.eObject());
    			}
    public java.util.List<CORBAException> getGetraises(){
        if(_getraises == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAAttribute", "getraises");
            _getraises = new java.util.ArrayList<CORBAException>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAException nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAException.class);
                    _getraises.add(nextWrapper);
                }   
            }
        }
        return _getraises;
    }
    public void addGetraises(CORBAException val)
    {
    				// make sure the getraises list is created
    				getGetraises();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CORBADomain::IDL::CORBAAttribute", "getraises");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_getraises != null) {
    					_getraises.add(val);
    				}
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
    public java.util.List<CORBAException> getSetraises(){
        if(_setraises == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CORBADomain::IDL::CORBAAttribute", "setraises");
            _setraises = new java.util.ArrayList<CORBAException>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAException nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAException.class);
                    _setraises.add(nextWrapper);
                }   
            }
        }
        return _setraises;
    }
    public void addSetraises(CORBAException val)
    {
    				// make sure the setraises list is created
    				getSetraises();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CORBADomain::IDL::CORBAAttribute", "setraises");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_setraises != null) {
    					_setraises.add(val);
    				}
    			}
    
    @Override
    public org.eclipse.uml2.uml.Property asProperty() {
        return (org.eclipse.uml2.uml.Property) eObject();
    }
}
