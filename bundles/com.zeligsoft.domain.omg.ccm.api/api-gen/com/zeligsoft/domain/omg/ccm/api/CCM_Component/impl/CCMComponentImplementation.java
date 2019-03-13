package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.ComponentInterfaceImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class CCMComponentImplementation
    extends ComponentInterfaceImplementation implements CCMComponent{
    protected java.util.List<CCMComponent> _generals;
    protected java.util.List<Property> _ownedProperty;
    protected java.util.List<CORBAAttribute> _ownedAttribute;
    public CCMComponentImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<CCMComponent> getGenerals(){
        if(_generals == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::CCMComponent", "generals");
            _generals = new java.util.ArrayList<CCMComponent>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CCMComponent nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CCMComponent.class);
                    _generals.add(nextWrapper);
                }   
            }
        }
        return _generals;
    }
    public void addGenerals(CCMComponent val)
    {
    				// make sure the generals list is created
    				getGenerals();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::CCMComponent", "generals");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_generals != null) {
    					_generals.add(val);
    				}
    			}
    public java.util.List<Property> getOwnedProperty(){
        if(_ownedProperty == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::CCMComponent", "ownedProperty");
            _ownedProperty = new java.util.ArrayList<Property>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    Property nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, Property.class);
                    _ownedProperty.add(nextWrapper);
                }   
            }
        }
        return _ownedProperty;
    }
    public void addOwnedProperty(Property val){
    	// make sure the ownedProperty list is created
    	getOwnedProperty();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::CCMComponent", "ownedProperty");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_ownedProperty != null) {
    		_ownedProperty.add(val);
    	}
    }
    public <T extends Property> T addOwnedProperty(Class<T> typeToCreate, String concept){
    	// make sure the ownedProperty list is created
    	getOwnedProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::CCMComponent", "ownedProperty", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_ownedProperty != null) {
    		_ownedProperty.add(element);
    	}
    	return element;
    }
    public Property addOwnedProperty(){
    	// make sure the ownedProperty list is created
    	getOwnedProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::CCMComponent", "ownedProperty", "CCM::CCM_Target::Property");
    	Property element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					Property.class);
    	if(_ownedProperty != null) {
    		_ownedProperty.add(element);
    	}
    	return element;
    }
    public String getQualifiedName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
            return (String) rawValue;
    }
    public String getName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "name");
            return (String) rawValue;
    }
    public void setName(String val)
    {
    				ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
    			}
    public java.util.List<CORBAAttribute> getOwnedAttribute(){
        if(_ownedAttribute == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::CCMComponent", "ownedAttribute");
            _ownedAttribute = new java.util.ArrayList<CORBAAttribute>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAAttribute nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAAttribute.class);
                    _ownedAttribute.add(nextWrapper);
                }   
            }
        }
        return _ownedAttribute;
    }
    public void addOwnedAttribute(CORBAAttribute val){
    	// make sure the ownedAttribute list is created
    	getOwnedAttribute();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::CCMComponent", "ownedAttribute");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_ownedAttribute != null) {
    		_ownedAttribute.add(val);
    	}
    }
    public <T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept){
    	// make sure the ownedAttribute list is created
    	getOwnedAttribute();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::CCMComponent", "ownedAttribute", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_ownedAttribute != null) {
    		_ownedAttribute.add(element);
    	}
    	return element;
    }
    public CORBAAttribute addOwnedAttribute(){
    	// make sure the ownedAttribute list is created
    	getOwnedAttribute();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Component::CCMComponent", "ownedAttribute", "CORBADomain::IDL::CORBAAttribute");
    	CORBAAttribute element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					CORBAAttribute.class);
    	if(_ownedAttribute != null) {
    		_ownedAttribute.add(element);
    	}
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
