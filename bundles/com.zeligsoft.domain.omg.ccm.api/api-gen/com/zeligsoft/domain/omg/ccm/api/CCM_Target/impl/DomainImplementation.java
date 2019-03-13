package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Domain;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.InterconnectInstance;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.NodeInstance;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SharedResource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.BridgeInstance;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public class DomainImplementation
    extends NamedElementImplementation implements Domain{
    protected java.util.List<SharedResource> _sharedResource;
    protected java.util.List<InterconnectInstance> _interconnect;
    protected java.util.List<NodeInstance> _node;
    protected java.util.List<CORBAAttribute> _infoProperty;
    protected java.util.List<BridgeInstance> _bridge;
    protected java.util.List<AssemblyConnector> _connections;
    public DomainImplementation(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    public java.util.List<SharedResource> getSharedResource(){
        if(_sharedResource == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "sharedResource");
            _sharedResource = new java.util.ArrayList<SharedResource>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    SharedResource nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, SharedResource.class);
                    _sharedResource.add(nextWrapper);
                }   
            }
        }
        return _sharedResource;
    }
    public void addSharedResource(SharedResource val){
    	// make sure the sharedResource list is created
    	getSharedResource();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "sharedResource");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_sharedResource != null) {
    		_sharedResource.add(val);
    	}
    }
    public <T extends SharedResource> T addSharedResource(Class<T> typeToCreate, String concept){
    	// make sure the sharedResource list is created
    	getSharedResource();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "sharedResource", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_sharedResource != null) {
    		_sharedResource.add(element);
    	}
    	return element;
    }
    public SharedResource addSharedResource(){
    	// make sure the sharedResource list is created
    	getSharedResource();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "sharedResource", "CCM::CCM_Target::SharedResource");
    	SharedResource element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					SharedResource.class);
    	if(_sharedResource != null) {
    		_sharedResource.add(element);
    	}
    	return element;
    }
    public java.util.List<InterconnectInstance> getInterconnect(){
        if(_interconnect == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "interconnect");
            _interconnect = new java.util.ArrayList<InterconnectInstance>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    InterconnectInstance nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, InterconnectInstance.class);
                    _interconnect.add(nextWrapper);
                }   
            }
        }
        return _interconnect;
    }
    public void addInterconnect(InterconnectInstance val){
    	// make sure the interconnect list is created
    	getInterconnect();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "interconnect");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_interconnect != null) {
    		_interconnect.add(val);
    	}
    }
    public <T extends InterconnectInstance> T addInterconnect(Class<T> typeToCreate, String concept){
    	// make sure the interconnect list is created
    	getInterconnect();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "interconnect", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_interconnect != null) {
    		_interconnect.add(element);
    	}
    	return element;
    }
    public InterconnectInstance addInterconnect(){
    	// make sure the interconnect list is created
    	getInterconnect();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "interconnect", "CCM::CCM_Target::InterconnectInstance");
    	InterconnectInstance element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					InterconnectInstance.class);
    	if(_interconnect != null) {
    		_interconnect.add(element);
    	}
    	return element;
    }
    public java.util.List<NodeInstance> getNode(){
        if(_node == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "node");
            _node = new java.util.ArrayList<NodeInstance>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    NodeInstance nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, NodeInstance.class);
                    _node.add(nextWrapper);
                }   
            }
        }
        return _node;
    }
    public void addNode(NodeInstance val){
    	// make sure the node list is created
    	getNode();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "node");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_node != null) {
    		_node.add(val);
    	}
    }
    public <T extends NodeInstance> T addNode(Class<T> typeToCreate, String concept){
    	// make sure the node list is created
    	getNode();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "node", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_node != null) {
    		_node.add(element);
    	}
    	return element;
    }
    public NodeInstance addNode(){
    	// make sure the node list is created
    	getNode();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "node", "CCM::CCM_Target::NodeInstance");
    	NodeInstance element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					NodeInstance.class);
    	if(_node != null) {
    		_node.add(element);
    	}
    	return element;
    }
    public java.util.List<CORBAAttribute> getInfoProperty(){
        if(_infoProperty == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "infoProperty");
            _infoProperty = new java.util.ArrayList<CORBAAttribute>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    CORBAAttribute nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, CORBAAttribute.class);
                    _infoProperty.add(nextWrapper);
                }   
            }
        }
        return _infoProperty;
    }
    public void addInfoProperty(CORBAAttribute val){
    	// make sure the infoProperty list is created
    	getInfoProperty();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "infoProperty");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_infoProperty != null) {
    		_infoProperty.add(val);
    	}
    }
    public <T extends CORBAAttribute> T addInfoProperty(Class<T> typeToCreate, String concept){
    	// make sure the infoProperty list is created
    	getInfoProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "infoProperty", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_infoProperty != null) {
    		_infoProperty.add(element);
    	}
    	return element;
    }
    public CORBAAttribute addInfoProperty(){
    	// make sure the infoProperty list is created
    	getInfoProperty();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "infoProperty", "CORBADomain::IDL::CORBAAttribute");
    	CORBAAttribute element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					CORBAAttribute.class);
    	if(_infoProperty != null) {
    		_infoProperty.add(element);
    	}
    	return element;
    }
    public String getUUID(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "UUID");
            return (String) rawValue;
    }
    public void setUUID(String val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Target::Domain", "UUID", val);
    			}
    public String getLabel(){
            final Object rawValue =
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "label");
            return (String) rawValue;
    }
    public void setLabel(String val)
    {
    				ZDLUtil.setValue(element, "CCM::CCM_Target::Domain", "label", val);
    			}
    public java.util.List<BridgeInstance> getBridge(){
        if(_bridge == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "bridge");
            _bridge = new java.util.ArrayList<BridgeInstance>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    BridgeInstance nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, BridgeInstance.class);
                    _bridge.add(nextWrapper);
                }   
            }
        }
        return _bridge;
    }
    public void addBridge(BridgeInstance val){
    	// make sure the bridge list is created
    	getBridge();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "bridge");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_bridge != null) {
    		_bridge.add(val);
    	}
    }
    public <T extends BridgeInstance> T addBridge(Class<T> typeToCreate, String concept){
    	// make sure the bridge list is created
    	getBridge();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "bridge", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_bridge != null) {
    		_bridge.add(element);
    	}
    	return element;
    }
    public BridgeInstance addBridge(){
    	// make sure the bridge list is created
    	getBridge();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "bridge", "CCM::CCM_Target::BridgeInstance");
    	BridgeInstance element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					BridgeInstance.class);
    	if(_bridge != null) {
    		_bridge.add(element);
    	}
    	return element;
    }
    public java.util.List<AssemblyConnector> getConnections(){
        if(_connections == null) {
            final Object rawValue = 
                com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Domain", "connections");
            _connections = new java.util.ArrayList<AssemblyConnector>();
            @SuppressWarnings("unchecked")
            final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
            for(Object next : rawList) {
                if(next instanceof org.eclipse.emf.ecore.EObject) {
                    AssemblyConnector nextWrapper = 
                         ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, AssemblyConnector.class);
                    _connections.add(nextWrapper);
                }   
            }
        }
        return _connections;
    }
    public void addConnections(AssemblyConnector val){
    	// make sure the connections list is created
    	getConnections();
    	
    	final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Domain", "connections");
    	@SuppressWarnings("unchecked")
    	final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
    	rawList.add(val.eObject());
    	if(_connections != null) {
    		_connections.add(val);
    	}
    }
    public <T extends AssemblyConnector> T addConnections(Class<T> typeToCreate, String concept){
    	// make sure the connections list is created
    	getConnections();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "connections", concept);
    	T element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					typeToCreate);
    	if(_connections != null) {
    		_connections.add(element);
    	}
    	return element;
    }
    public AssemblyConnector addConnections(){
    	// make sure the connections list is created
    	getConnections();
    	org.eclipse.emf.ecore.EObject newConcept = 
    		ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Domain", "connections", "ZMLMM::ZML_Component::AssemblyConnector");
    	AssemblyConnector element = ZDLFactoryRegistry.INSTANCE
    			.create((org.eclipse.emf.ecore.EObject) newConcept,
    					AssemblyConnector.class);
    	if(_connections != null) {
    		_connections.add(element);
    	}
    	return element;
    }
    
    @Override
    public org.eclipse.uml2.uml.Component asComponent() {
        return (org.eclipse.uml2.uml.Component) eObject();
    }
}
