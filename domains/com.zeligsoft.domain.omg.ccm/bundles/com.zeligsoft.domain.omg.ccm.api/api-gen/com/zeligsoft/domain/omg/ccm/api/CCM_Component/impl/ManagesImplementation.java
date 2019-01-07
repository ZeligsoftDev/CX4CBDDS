package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.ManagesEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class ManagesImplementation
    extends CORBANamedElementImplementation implements Manages{
    protected ManagesEnd _component;
    protected ManagesEnd _home;
    public ManagesImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public ManagesEnd getComponent(){
        if(_component == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Manages", "component");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _component = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, ManagesEnd.class);
            }
        }
        return _component;
    }
    public void setComponent(ManagesEnd val)
    {
    	ZDLUtil.setValue(element, "CCM::CCM_Component::Manages", "component", val.eObject());
    }
    public <T extends ManagesEnd> T createComponent(Class<T> typeToCreate, String concept)
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Manages", "component", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	return element;
    }
    public ManagesEnd getHome(){
        if(_home == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Manages", "home");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _home = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, ManagesEnd.class);
            }
        }
        return _home;
    }
    public void setHome(ManagesEnd val)
    {
    	ZDLUtil.setValue(element, "CCM::CCM_Component::Manages", "home", val.eObject());
    }
    public <T extends ManagesEnd> T createHome(Class<T> typeToCreate, String concept)
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::Manages", "home", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.Dependency asDependency() {
        return (org.eclipse.uml2.uml.Dependency) eObject();
    }
}
