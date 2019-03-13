package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.HomeOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class HomeOperationImplementation
    extends CORBANamedElementImplementation implements HomeOperation{
    protected Home _owner;
    protected java.util.List<CORBAException> _exceptionDef;
    protected java.util.List<CORBAParameter> _ownedParameter;
    public HomeOperationImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public Home getOwner(){
        if(_owner == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::HomeOperation", "owner");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _owner = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, Home.class);
            }
        }
        return _owner;
    }
    public void setOwner(Home val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::HomeOperation", "owner", val.eObject());
    			}
    public java.util.List<CORBAException> getExceptionDef(){
        if(_exceptionDef == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::HomeOperation", "exceptionDef");
            _exceptionDef = new java.util.ArrayList<CORBAException>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAException nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAException.class);
                    _exceptionDef.add(nextWrapper);
                }   
            }
        }
        return _exceptionDef;
    }
    public void addExceptionDef(CORBAException val)
    {
    				// make sure the exceptionDef list is created
    				getExceptionDef();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::HomeOperation", "exceptionDef");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_exceptionDef != null) {
    					_exceptionDef.add(val);
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
    public java.util.List<CORBAParameter> getOwnedParameter(){
        if(_ownedParameter == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::HomeOperation", "ownedParameter");
            _ownedParameter = new java.util.ArrayList<CORBAParameter>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAParameter nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAParameter.class);
                    _ownedParameter.add(nextWrapper);
                }   
            }
        }
        return _ownedParameter;
    }
    public void addOwnedParameter(CORBAParameter val){
    	// make sure the ownedParameter list is created
    	getOwnedParameter();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::HomeOperation", "ownedParameter");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_ownedParameter != null) {
    		_ownedParameter.add(val);
    	}
    }
    public <T extends CORBAParameter> T addOwnedParameter(Class<T> typeToCreate, String concept){
    	// make sure the ownedParameter list is created
    	getOwnedParameter();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::HomeOperation", "ownedParameter", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_ownedParameter != null) {
    		_ownedParameter.add(element);
    	}
    	return element;
    }
    public CORBAParameter addOwnedParameter(){
    	// make sure the ownedParameter list is created
    	getOwnedParameter();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::HomeOperation", "ownedParameter", "CORBADomain::IDL::CORBAParameter");
    	CORBAParameter element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					CORBAParameter.class);
    	if(_ownedParameter != null) {
    		_ownedParameter.add(element);
    	}
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.Operation asOperation() {
        return (org.eclipse.uml2.uml.Operation) eObject();
    }
}
