package com.zeligsoft.domain.dds4ccm.rhapsody.transform

import com.zeligsoft.base.zdl.staticapi.core.ZObject
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Component
import org.eclipse.uml2.uml.ConnectorKind
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.UMLPackage

class DDS4CCMFactory {
	
    // ********************************
	// IDL
    // ********************************
	
	// CORBAModule
    def public CORBAModule createCorbaModule(org.eclipse.uml2.uml.Package container, String name) {
        val module = createCorbaModuleHelper(container, name)
        
        return ZDLFactoryRegistry::INSTANCE.create(module, typeof(CORBAModule))
    }
    
    def public CORBAModule createCorbaModule(CORBAModule container, String name) {
        val module = createCorbaModuleHelper(container.asPackage, name)
        
        return ZDLFactoryRegistry::INSTANCE.create(module, typeof(CORBAModule))
    }
        
    def private create module : container.createNestedPackage(name) 
        createCorbaModuleHelper(org.eclipse.uml2.uml.Package container, String name) {
        ZDLUtil::addZDLConcept(module, CORBADomainNames::CORBAMODULE)
    } 
    
    def public dispatch Package create pkg : container.createNestedPackage(name) 
        createPackage(Package container, String name) {
            
    }
        
    def public dispatch Package create pkg : container.createComponentPackage(name) 
        createPackage(Component container, String name) {
            
    }        
    def public dispatch Package createPackage(EObject container, String name) {
    }
                
    def public org.eclipse.uml2.uml.Package createNestedPackage(CORBAModule container, String name) {
        container.asPackage.createNestedPackage(name)
    }
    
    def public org.eclipse.uml2.uml.Package createComponentPackage(Component container, String name) {
        container.createPackagedElement(name, UMLPackage::eINSTANCE.getPackage()) as Package
    }    
    
    // ConnectorStatusListenerConnection
    def public ConnectorStatusListenerConnection createConnectorStatusListenerConnection(AssemblyImplementation container, String name){
    	val conn = container.asComponent.createOwnedConnector(name)
    	conn.setKind(ConnectorKind::ASSEMBLY_LITERAL)
    	ZDLUtil::addZDLConcept(conn, DDS4CCMNames::CONNECTOR_STATUS_LISTENER_CONNECTION)
    	return ZDLFactoryRegistry::INSTANCE.create(conn, typeof(ConnectorStatusListenerConnection))
    }

	// ****************************
	// Generic ZDL element creator    
	// ****************************
    def public dispatch ZObject createZDLElement(EObject container, String name, String concept, Class type){
    	try{
			val element = ZDLUtil::createZDLConceptIn(container, concept)
			
			if(name != "" && element instanceof NamedElement){
				(element as NamedElement).name = name
			}
			return ZDLFactoryRegistry::INSTANCE.create(element, type)	
		}catch(IllegalArgumentException e){
			return null
		}
    }
    
    def public dispatch ZObject createZDLElement(Object container, String name, String concept, Class type){
    	
    }
    
    def public dispatch ZObject createZDLElement(ZObject container, String name, String concept, Class type){
		createZDLElement(container.eObject, name, concept, type)
    }    

}