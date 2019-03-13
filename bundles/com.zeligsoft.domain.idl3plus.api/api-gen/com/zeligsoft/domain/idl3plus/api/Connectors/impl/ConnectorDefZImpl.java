package com.zeligsoft.domain.idl3plus.api.Connectors.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.ComponentInterfaceImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class ConnectorDefZImpl
    extends ComponentInterfaceImplementation implements ConnectorDef{
    protected java.util.List<ConnectorDef> _general;
    protected java.util.List<CORBAAttribute> _ownedAttribute;
    public ConnectorDefZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<ConnectorDef> getGeneral(){
        if(_general == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "IDL3Plus::Connectors::ConnectorDef", "general");
            _general = new java.util.ArrayList<ConnectorDef>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    ConnectorDef nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, ConnectorDef.class);
                    _general.add(nextWrapper);
                }   
            }
        }
        return _general;
    }
    public void addGeneral(ConnectorDef val)
    {
    				// make sure the general list is created
    				getGeneral();
    
    				final Object rawValue = ZDLUtil.getValue(element, "IDL3Plus::Connectors::ConnectorDef", "general");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_general != null) {
    					_general.add(val);
    				}
    			}
    public String getQualifiedName(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement", "qualifiedName");
            return (String) rawValue;
    }
    public java.util.List<CORBAAttribute> getOwnedAttribute(){
        if(_ownedAttribute == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "IDL3Plus::Connectors::ConnectorDef", "ownedAttribute");
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
    	
    	final Object rawValue = ZDLUtil.getValue(element, "IDL3Plus::Connectors::ConnectorDef", "ownedAttribute");
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
    		ZDLUtil.createZDLConcept(element, "IDL3Plus::Connectors::ConnectorDef", "ownedAttribute", concept);
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
    		ZDLUtil.createZDLConcept(element, "IDL3Plus::Connectors::ConnectorDef", "ownedAttribute", "CORBADomain::IDL::CORBAAttribute");
    	CORBAAttribute element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					CORBAAttribute.class);
    	if(_ownedAttribute != null) {
    		_ownedAttribute.add(element);
    	}
    	return element;
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
    
    @Override
    public org.eclipse.uml2.uml.Component asComponent() {
        return (org.eclipse.uml2.uml.Component) eObject();
    }
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
