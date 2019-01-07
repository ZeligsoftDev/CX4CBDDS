package com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSForEntity;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class QoSForEntityZImpl
    extends NamedElementImplementation implements QoSForEntity{
    protected java.util.List<qosProperty> _qosProperty;
    public QoSForEntityZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<qosProperty> getQosProperty(){
        if(_qosProperty == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS4CCM::QoSProfiles::QoSForEntity", "qosProperty");
            _qosProperty = new java.util.ArrayList<qosProperty>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    qosProperty nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, qosProperty.class);
                    _qosProperty.add(nextWrapper);
                }   
            }
        }
        return _qosProperty;
    }
    public void addQosProperty(qosProperty val){
    	// make sure the qosProperty list is created
    	getQosProperty();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "DDS4CCM::QoSProfiles::QoSForEntity", "qosProperty");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_qosProperty != null) {
    		_qosProperty.add(val);
    	}
    }
    public <T extends qosProperty> T addQosProperty(Class<T> typeToCreate, String concept){
    	// make sure the qosProperty list is created
    	getQosProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "DDS4CCM::QoSProfiles::QoSForEntity", "qosProperty", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_qosProperty != null) {
    		_qosProperty.add(element);
    	}
    	return element;
    }
    public qosProperty addQosProperty(){
    	// make sure the qosProperty list is created
    	getQosProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "DDS4CCM::QoSProfiles::QoSForEntity", "qosProperty", "DDS::QOS::qosProperty");
    	qosProperty element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					qosProperty.class);
    	if(_qosProperty != null) {
    		_qosProperty.add(element);
    	}
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.Class asClass() {
        return (org.eclipse.uml2.uml.Class) eObject();
    }
}
