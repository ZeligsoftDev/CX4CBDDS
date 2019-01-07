package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.StructuralRealizationImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.ComponentCategory;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class MonolithicImplementationImplementation
    extends StructuralRealizationImplementation implements MonolithicImplementation{
    protected java.util.List<WorkerFunction> _worker;
    protected ComponentCategory _category;
    public MonolithicImplementationImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<WorkerFunction> getWorker(){
        if(_worker == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Component::Implementation", "worker");
            _worker = new java.util.ArrayList<WorkerFunction>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    WorkerFunction nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, WorkerFunction.class);
                    _worker.add(nextWrapper);
                }   
            }
        }
        return _worker;
    }
    public void addWorker(WorkerFunction val){
    	// make sure the worker list is created
    	getWorker();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "ZMLMM::ZML_Component::Implementation", "worker");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_worker != null) {
    		_worker.add(val);
    	}
    }
    public <T extends WorkerFunction> T addWorker(Class<T> typeToCreate, String concept){
    	// make sure the worker list is created
    	getWorker();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "ZMLMM::ZML_Component::Implementation", "worker", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_worker != null) {
    		_worker.add(element);
    	}
    	return element;
    }
    public WorkerFunction addWorker(){
    	// make sure the worker list is created
    	getWorker();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "ZMLMM::ZML_Component::Implementation", "worker", "ZMLMM::ZML_Component::WorkerFunction");
    	WorkerFunction element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					WorkerFunction.class);
    	if(_worker != null) {
    		_worker.add(element);
    	}
    	return element;
    }
    public ComponentCategory getCategory(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Implementation::MonolithicImplementation", "category");
            
            if(_category == null) {
            if(rawValue instanceof org.eclipse.emf.ecore.EObject) {
                _category = ComponentCategory.create((org.eclipse.emf.ecore.EObject) rawValue);
            }
            }
            return _category;
    }
    public void setCategory(ComponentCategory val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Implementation::MonolithicImplementation", "category", val.eObject(element));
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
    public String getName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Implementation::MonolithicImplementation", "name");
            return (String) rawValue;
    }
    public void setName(String val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Implementation::MonolithicImplementation", "name", val);
    			}
    public String getQualifiedName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
            return (String) rawValue;
    }
    
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
