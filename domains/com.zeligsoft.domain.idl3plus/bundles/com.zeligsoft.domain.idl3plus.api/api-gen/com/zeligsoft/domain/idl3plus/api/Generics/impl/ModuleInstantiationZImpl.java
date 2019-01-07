package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.idl3plus.api.Generics.ModuleBinding;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class ModuleInstantiationZImpl
    extends CORBANamedElementImplementation implements ModuleInstantiation{
    protected ModuleBinding _moduleBinding;
    public ModuleInstantiationZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public ModuleBinding getModuleBinding(){
        if(_moduleBinding == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "IDL3Plus::Generics::ModuleInstantiation", "moduleBinding");
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
              _moduleBinding = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, ModuleBinding.class);
            }
        }
        return _moduleBinding;
    }
    public void setModuleBinding(ModuleBinding val)
    {
    	ZDLUtil.setValue(element, "IDL3Plus::Generics::ModuleInstantiation", "moduleBinding", val.eObject());
    }
    public <T extends ModuleBinding> T createModuleBinding(Class<T> typeToCreate, String concept)
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "IDL3Plus::Generics::ModuleInstantiation", "moduleBinding", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	return element;
    }
    public ModuleBinding createModuleBinding()
    {
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "IDL3Plus::Generics::ModuleInstantiation", "moduleBinding", "IDL3Plus::Generics::ModuleBinding");
    	ModuleBinding element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					ModuleBinding.class);
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.Package asPackage() {
        return (org.eclipse.uml2.uml.Package) eObject();
    }
}
