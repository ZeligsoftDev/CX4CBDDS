package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Event;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.InterfaceImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.StateMember;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class EventImplementation
    extends InterfaceImplementation implements Event{
    protected java.util.List<StateMember> _member;
    protected java.util.List<CORBAAttribute> _ownedAttribute;
    public EventImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<StateMember> getMember(){
        if(_member == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event", "member");
            _member = new java.util.ArrayList<StateMember>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    StateMember nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, StateMember.class);
                    _member.add(nextWrapper);
                }   
            }
        }
        return _member;
    }
    public void addMember(StateMember val)
    {
    				// make sure the member list is created
    				getMember();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Event", "member");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_member != null) {
    					_member.add(val);
    				}
    			}
    public Boolean getIsAbstract(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event", "isAbstract");
            return (Boolean) rawValue;
    }
    public void setIsAbstract(Boolean val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isAbstract", val);
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
    public Boolean getIsTruncatable(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event", "isTruncatable");
            return (Boolean) rawValue;
    }
    public void setIsTruncatable(Boolean val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isTruncatable", val);
    			}
    public Boolean getIsCustom(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event", "isCustom");
            return (Boolean) rawValue;
    }
    public void setIsCustom(Boolean val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Component::Event", "isCustom", val);
    			}
    public java.util.List<CORBAAttribute> getOwnedAttribute(){
        if(_ownedAttribute == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Component::Event", "ownedAttribute");
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
    public void addOwnedAttribute(CORBAAttribute val)
    {
    				// make sure the ownedAttribute list is created
    				getOwnedAttribute();
    
    				final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Component::Event", "ownedAttribute");
    				@SuppressWarnings("unchecked")
    				final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    				rawList.add(val.eObject());
    				if(_ownedAttribute != null) {
    					_ownedAttribute.add(val);
    				}
    			}
    
    @Override
    public org.eclipse.uml2.uml.NamedElement asNamedElement() {
        return (org.eclipse.uml2.uml.NamedElement) eObject();
    }
}
