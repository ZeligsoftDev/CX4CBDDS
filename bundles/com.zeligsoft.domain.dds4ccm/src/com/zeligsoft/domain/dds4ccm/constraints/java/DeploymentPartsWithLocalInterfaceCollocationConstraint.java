/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.constraints.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Relationship;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;
import com.zeligsoft.domain.zml.api.ZML_Component.ConnectorEnd;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.PortTypeable;
import com.zeligsoft.domain.zml.api.ZML_Deployments.ComponentDeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Deployment;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This makes sure that components with local connections are deployed to the same process 
 * 
 * @author das 
 */
public class DeploymentPartsWithLocalInterfaceCollocationConstraint extends AbstractModelConstraint {
	private static class DelegationUsesPartInfo{
		CCMPart part;
		AssemblyImplementation assembly;
		DeploymentPart assemblyDP;
	}
	
	private static class ConnectedProvidesPartInfo{
		DeploymentPart connectedProvidesPartDP;
		DeploymentPart connectedProvidesPartTargetProcessDP;
		InterfacePort connectedProvidesPort;
	}
	
	private static class ValidationInfo{
		Boolean validationStatus;
		DeploymentPart providesPartDP;
		InterfacePort providesPort;
		DeploymentPart providesPartTargetProcessDP;
		public ValidationInfo(){
			validationStatus = Boolean.TRUE;
		}
	}
	
	private static class SearchContext{
		AssemblyImplementation contextAssembly;
		DeploymentPart contextAssemblyDP;
		InterfacePort contextUsesPort;
		CCMPart contextUsesPart;
		DeploymentPart usesPartTargetProcessDP;
		DeploymentPart topLevelAssemblyDP;
		
		public SearchContext(){}
		
		public SearchContext(AssemblyImplementation contextAssembly, DeploymentPart contextAssemblyDP, InterfacePort contextUsesPort,
					CCMPart contextUsesPart, DeploymentPart usesPartTargetProcessDP, DeploymentPart topLevelAssemblyDP) {
			this.contextAssembly = contextAssembly;
			this.contextAssemblyDP = contextAssemblyDP;
			this.contextUsesPort = contextUsesPort;
			this.contextUsesPart = contextUsesPart;
			this.usesPartTargetProcessDP = usesPartTargetProcessDP;
			this.topLevelAssemblyDP = topLevelAssemblyDP;
		}
	}
	
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (objToVerify == null
				|| !ZDLUtil.isZDLConcept(objToVerify,
						ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
			return ctx.createSuccessStatus();
		}		
		
		ComponentDeploymentPart partToCheckDP = ZDLFactoryRegistry.INSTANCE.create(objToVerify, ComponentDeploymentPart.class);
		
		// Check for CCMPart is necessary as a CCMComponent can also be a ComponentDeploymentPart
		if(!(partToCheckDP.getModelElement() instanceof CCMPart)){
			return ctx.createSuccessStatus();
		}		
		
		CCMPart partToCheck = (CCMPart) partToCheckDP.getModelElement();
		
		List<InterfacePort> localUsesPortsToCheck = getLocalUsesInterfacePorts(partToCheck);
		
		if(localUsesPortsToCheck.isEmpty()){
			return ctx.createSuccessStatus();
		}
		
		DeploymentPart usesPartTargetProcessDP = getTargetProcessInDeploy(partToCheckDP);
		
		if(usesPartTargetProcessDP == null){// it would be null if 'partToCheckDP' is not deployed
			return ctx.createSuccessStatus();
		}
		
		DeploymentPart topLevelAssemblyDP = getTopLevelAssemblyDP(partToCheckDP);
		DeploymentPart contextAssemblyDP = getParentDP(partToCheckDP);
		AssemblyImplementation contextAssembly = (AssemblyImplementation) partToCheck.zContainer();
		// create a search context for each of the 'local-uses' port and call the overloaded 'validate' method
		for(InterfacePort usesPort: localUsesPortsToCheck){
			SearchContext sc = new SearchContext(contextAssembly, contextAssemblyDP, usesPort, partToCheck, usesPartTargetProcessDP, topLevelAssemblyDP);
			ValidationInfo validationResult = validate(sc);
			
			if(!validationResult.validationStatus){
				ctx.addResult(validationResult.providesPartDP.eObject());
				
				String vArg1 = partToCheckDP.getName() + " :: " + usesPort.getName();
				String vArg2 = ZDeploymentUtil.getQualifiedName(validationResult.providesPartDP.asProperty()) + " :: " + validationResult.providesPort.getName();
				String vArg3 = ZDeploymentUtil.getQualifiedName(validationResult.providesPartTargetProcessDP.asProperty());
				return ctx.createFailureStatus(vArg1.trim(), vArg2.trim(), vArg3);				
			}
		}
		return ctx.createSuccessStatus();
	}
	
	private ValidationInfo validate(SearchContext sc) {
		List<CCMConnector> contextConnectors = getMatchedConnectorsFromOwnerAssembly(sc.contextUsesPort, sc.contextUsesPart, sc.contextAssembly);
		
		for(CCMConnector connector: contextConnectors){
			ConnectorEnd connectedConnectorEnd = getOtherConnectorEnd(connector, sc.contextUsesPort);
			InterfacePort connectedPort = (InterfacePort) connectedConnectorEnd.getPort(); 
			
			if(DDS4CCMUtil.isAssemblyConnector(connector.asConnector())){
				// port in other end is a 'provides' port
				CCMPart connectedProvidesPart = (CCMPart) connectedConnectorEnd.getPartWithPort();
				InterfacePort connectedProvidesPort = connectedPort;

				List<ConnectedProvidesPartInfo> listConnectedProvidesPartInfo = getConnectedProvidesPartInfo(sc.contextAssemblyDP, sc.topLevelAssemblyDP, connectedProvidesPart, connectedProvidesPort, sc.contextUsesPort);
				
				for(ConnectedProvidesPartInfo providesPartInfo: listConnectedProvidesPartInfo){
					DeploymentPart providesPartTargetProcessDP = providesPartInfo.connectedProvidesPartTargetProcessDP;
					if((providesPartTargetProcessDP != null) && !sc.usesPartTargetProcessDP.equals(providesPartTargetProcessDP)){
						ValidationInfo vInfo = new ValidationInfo();
						vInfo.validationStatus = Boolean.FALSE;
						vInfo.providesPartTargetProcessDP = providesPartTargetProcessDP;
						vInfo.providesPartDP = providesPartInfo.connectedProvidesPartDP;
						vInfo.providesPort = providesPartInfo.connectedProvidesPort;						
						return vInfo;
					}
				}
			}else if(DDS4CCMUtil.isDelegationConnector(connector.asConnector())){
				// port in other end is a 'uses' port
				DelegationUsesPartInfo usesDelegationPartInfo = getUsesDelegationPartInfo(sc.contextAssemblyDP);
				SearchContext updatedSC = new SearchContext();
				updatedSC.contextUsesPart = usesDelegationPartInfo.part;				
				updatedSC.contextAssembly = usesDelegationPartInfo.assembly;
				updatedSC.contextAssemblyDP = usesDelegationPartInfo.assemblyDP;
				updatedSC.usesPartTargetProcessDP = sc.usesPartTargetProcessDP;
				updatedSC.topLevelAssemblyDP = sc.topLevelAssemblyDP;
				updatedSC.contextUsesPort = connectedPort;
				// recursive call to the validate method with an updated search context
				ValidationInfo vInfo = validate(updatedSC);
				if(!vInfo.validationStatus){
					return vInfo;
				}		
			}		
		}
		return new ValidationInfo();
	}
	/**
	 * Given a 'uses' port and a context assembly deployment part, compute a list of 'ConnectedProvidesPartInfo' instances. 
	 * Each instance of the returned list corresponds to a 'monolithic' component connected to the given 'uses' port.
	 * 
	 * */
	private List<ConnectedProvidesPartInfo> getConnectedProvidesPartInfo(DeploymentPart contextAssemblyDP, DeploymentPart topLevelAssemblyDP, CCMPart connectedProvidesPart, InterfacePort connectedProvidesPort, InterfacePort contextPort){
	
		List<ConnectedProvidesPartInfo> listConnectedProvidesPartInfo = new ArrayList<ConnectedProvidesPartInfo>();
		AssemblyImplementation connectedPartAssembly = getAssembly(connectedProvidesPart);
		
		if(connectedPartAssembly != null){
			// connected to a provides port on an Assembly Component
			List<CCMConnector> matchedConnectors = getMatchedConnectorsFromOwnerAssembly(connectedProvidesPort, connectedProvidesPart, connectedPartAssembly);
			for(CCMConnector matchedConnector: matchedConnectors){
				
				ConnectorEnd connectedProvidesConnectorEnd = getOtherConnectorEnd(matchedConnector, connectedProvidesPort);
				InterfacePort updatedConnectedProvidesPort = (InterfacePort) connectedProvidesConnectorEnd.getPort();
				CCMPart updatedConnectedProvidesPart = (CCMPart) connectedProvidesConnectorEnd.getPartWithPort();
				DeploymentPart updatedContextAssemblyDP = getConnectedPartDP(contextAssemblyDP, connectedProvidesPart);
				if(updatedContextAssemblyDP != null){
					listConnectedProvidesPartInfo.addAll(getConnectedProvidesPartInfo(updatedContextAssemblyDP, topLevelAssemblyDP, updatedConnectedProvidesPart, updatedConnectedProvidesPort, connectedProvidesPort));
				}
			}
		}else{
			// connected to a provides port on a Monolithic Component
			DeploymentPart connectedProvidesPartDP = getConnectedPartDP(contextAssemblyDP, connectedProvidesPart);
			DeploymentPart connectedProvidesPartTargetProcessDP = getDeploymentTarget(topLevelAssemblyDP, connectedProvidesPartDP);
			
			if(connectedProvidesPartTargetProcessDP != null){
				ConnectedProvidesPartInfo cppi = new ConnectedProvidesPartInfo();
				cppi.connectedProvidesPartDP = connectedProvidesPartDP;
				cppi.connectedProvidesPartTargetProcessDP = connectedProvidesPartTargetProcessDP;
				cppi.connectedProvidesPort = connectedProvidesPort;
				
				listConnectedProvidesPartInfo.add(cppi);
			}
		}
		return listConnectedProvidesPartInfo;
	}
	
	/**
	 * Given an instance of context assembly deployment part, return the deployment part instance that represents the given 'part' in the assembly deployment part   
	 * 
	 * */	
	private DeploymentPart getConnectedPartDP(DeploymentPart contextAssemblyDP, CCMPart part){
		
		DeploymentPart partDP = null;
		
		for(DeploymentPart childDP: contextAssemblyDP.getNestedPart()){
			if(childDP.getModelElement().equals(part)){
				partDP = childDP;
				break;
			}
		}
		return partDP;
	}
	
	/**
	 * Given deployment info for assembly on one end of a 'uses' delegation, return the details of 'uses' part on other end   
	 *  
	 * */
	
	private DelegationUsesPartInfo getUsesDelegationPartInfo(DeploymentPart contextAssemblyDP){
		
		DelegationUsesPartInfo usesDelegationPartInfo = new DelegationUsesPartInfo();
		CCMPart connectedPart = null;
		DeploymentPart contextAssemblyOwnerDP = getParentDP(contextAssemblyDP);
		// modelElement of contextAssemblyOwnerDP can be a CCMPart or a CCMComponent
		AssemblyImplementation contextAssemblyOwner = getAssembly(contextAssemblyOwnerDP.getModelElement());	
		
		for(Part part: contextAssemblyOwner.getPart()){
			if(part.equals(contextAssemblyDP.getModelElement())){
				connectedPart = (CCMPart) part;
				break;
			}
		}
		// 'connectedPart' must not be null as this method is called only for 'delegation' connectors 
		assert(connectedPart != null);
		
		usesDelegationPartInfo.part = connectedPart;
		usesDelegationPartInfo.assembly = contextAssemblyOwner;
		usesDelegationPartInfo.assemblyDP = contextAssemblyOwnerDP;
		
		return usesDelegationPartInfo; 
	}
	
	private AssemblyImplementation getAssembly(ZObject zObject){
		if(zObject instanceof CCMPart){
			return getAssembly((CCMPart) zObject);
		}else if(zObject instanceof CCMComponent){
			return getAssembly((CCMComponent) zObject);
		}
		return null;
	}
	
	private DeploymentPart getParentDP(DeploymentPart childDP){
		DeploymentPart parentDP = null;
		org.eclipse.uml2.uml.Property parentProperty = ZDeploymentUtil.getParentPart(childDP.asProperty());
		
		if(parentProperty != null){
			parentDP = ZDLFactoryRegistry.INSTANCE.create(parentProperty, DeploymentPart.class);
		}
		return parentDP;
	}
	
	public CCMComponent getComponent(AssemblyImplementation assemblyImpl){		
		CCMComponent comp = null;
		EList<Relationship> rels = assemblyImpl.asComponent().getRelationships();
		
		for(Relationship rel: rels){
			if(rel instanceof Generalization){
				Generalization gen = (Generalization) rel;
				Classifier genClassifier = gen.getGeneral();
				
				if(ZDLUtil.isZDLConcept(genClassifier, CCMNames.CCMCOMPONENT)){
					comp = ZDLFactoryRegistry.INSTANCE.create(genClassifier, CCMComponent.class);
					break;
				}				
			}			
		}
		return comp;
	}
	
	// Go through all the CCMConnectors in 'contextAssembly' and return a list of connectors 
	// that are actually connected to "contextPart" via "contextPort"  
	private List<CCMConnector> getMatchedConnectorsFromOwnerAssembly(InterfacePort contextPort, CCMPart contextPart, AssemblyImplementation contextAssembly){
		
		List<AssemblyConnector> ownedConnectors = contextAssembly.getConnector();
		List<CCMConnector> matchedConnectors = new ArrayList<CCMConnector>();
		
		for(AssemblyConnector ownedConnector: ownedConnectors){
			if(!(ownedConnector instanceof CCMConnector)){
				continue;
			}
			CCMConnector ownedCcmConnector = (CCMConnector) ownedConnector;
			for(ConnectorEnd ce: ownedCcmConnector.getEnd()){
				Port portCE = ce.getPort();
				Part partWithPortCE = ce.getPartWithPort();
				
				if(portCE == null){
					continue;
				}
				if(contextPort.getIsConjugated()){
					if(portCE.equals(contextPort) && (partWithPortCE != null) && partWithPortCE.equals(contextPart)){
						matchedConnectors.add(ownedCcmConnector);
						break;
					}
				}else{// 'partWithPortCE' is null for a 'provides' port on a delegation connector going inward
					if(portCE.equals(contextPort)){
						matchedConnectors.add(ownedCcmConnector);
						break;
					}
				}
				
			}
			
		}
		return matchedConnectors;
	}
	
	private DeploymentPart getDeploymentTarget(DeploymentPart topLevelAssemblyDP, DeploymentPart partDP){
		
		List<DeploymentPart> nestedParts = topLevelAssemblyDP.getNestedPart();
		
		for(DeploymentPart dp: nestedParts){
			if(!(dp instanceof ComponentDeploymentPart)){
				continue;
			}
			if(dp == partDP){
				return getTargetProcessInDeploy((ComponentDeploymentPart) dp);
			}
			if(!dp.getNestedPart().isEmpty()){
				DeploymentPart target = getDeploymentTarget(dp, partDP);
				if(target != null){
					return target;
				}
			}
		}
		return null;
	}
	
	private DeploymentPart getTopLevelAssemblyDP(DeploymentPart childDP){
		org.eclipse.uml2.uml.Property parentProperty;
		org.eclipse.uml2.uml.Property childProperty = childDP.asProperty();
		while((parentProperty = ZDeploymentUtil.getParentPart(childProperty)) != null){
			childProperty = parentProperty;
		}
		
		return ZDLFactoryRegistry.INSTANCE.create(childProperty, DeploymentPart.class);
	}		
	
	/**
	 * Check if any of the connectorEnds of the given assembly connector contains the given interface port.
	 * 
	 * @param conn
	 * @param ip
	 * @return true, if any of the connectorEnds of conn has the ip port; false, otherwise  
	 */
	public boolean containsPort(AssemblyConnector conn, InterfacePort ip){
		boolean isPortFound = false;
		for(ConnectorEnd ce: conn.getEnd()){
			if((ce.getPort() != null) && ce.getPort().equals(ip)){
				isPortFound = true;
				break;
			}			
		}
		return isPortFound;
	}
	// Given a CCMConnector and a port in one connetorEnd, return the other connectorEnd	
	private ConnectorEnd getOtherConnectorEnd(CCMConnector contextConnector, InterfacePort contextPort){
		
		ConnectorEnd otherConnectorEnd = null;
		for(ConnectorEnd ce: contextConnector.getEnd()){
			Port port = ce.getPort();
			
			if(!port.equals(contextPort)){
				otherConnectorEnd = ce;
				break;
			}				
		}			
		
		return otherConnectorEnd;
	}
	
	private AssemblyImplementation getAssembly(CCMPart part){
		CCMComponent comp = (CCMComponent) part.getDefinition();
		return getAssembly(comp);
		
	}
	/**
	 * Given a CCMComponent, return a list of assembly implementations that inherit from the CCMComponent
	 * 
	 * @param component
	 * @return a list of assembly implementations specializing from component    
	 */
	public AssemblyImplementation getAssembly(CCMComponent component){
		
		AssemblyImplementation assembly = null;
		EList<Relationship> rels = component.asComponent().getRelationships();
		
		for(Relationship rel: rels){
			if(rel instanceof Generalization){
				Generalization gen = (Generalization) rel;
				Classifier specific = gen.getSpecific();
				
				if(ZDLUtil.isZDLConcept(specific, CCMNames.ASSEMBLY_IMPLEMENTATION)){
					assembly = ZDLFactoryRegistry.INSTANCE.create(specific, AssemblyImplementation.class);
					break;
				}				
			}			
		}		
		return assembly;
	}
	
	/**
	 * Given a deployment instance, return a list of all the underlying CCMParts for the deployment parts
	 * 
	 * @param deployment
	 * @return a list of underlying CCMParts    
	 */
	public List<CCMPart> getCCMParts(Deployment deployment){
		List<CCMPart> ccmParts = new ArrayList<CCMPart>();
		
		for(DeploymentPart dPart: deployment.getPart()){
			if(dPart.getModelElement() instanceof CCMPart){
				ccmParts.add((CCMPart) dPart.getModelElement());
			}
		}		
		return ccmParts;
	}
	
	/**
	 * Given a component deployment part in 'configure' view, get the corresponding target deployment part (process) from 'deploy' view
	 * 
	 * @param partToCheckDP Deployment part in configure view
	 * @return if dPartInConfigure is deployed, return the 'deployedOn' attribute of the corresponding 'allocation' instance 
	 * 		   if dPartInConfigure is not deployed, null.
	 */
	public DeploymentPart getTargetProcessInDeploy(ComponentDeploymentPart partToCheckDP){
		
		DeploymentPart targetProcessDP = null;
		Dependency dependencyPartToCheck = ZDeploymentUtil.getAllocationForSourcePart(partToCheckDP.asProperty());
		if(dependencyPartToCheck == null){
			return targetProcessDP;
		}
		org.eclipse.uml2.uml.Property targetPropertyToCheck = ZDeploymentUtil.getTargetPartForAllocation(dependencyPartToCheck);
		targetProcessDP = ZDLFactoryRegistry.INSTANCE.create(targetPropertyToCheck, DeploymentPart.class);
		return targetProcessDP;
	}	
	
	/**
	 * Check if the given interface port is typed by a local interface
	 * 
	 * @param ip
	 * @return 
	 */	
	private boolean isPorttypeLocal(InterfacePort ip){
		boolean returnVal = false;		
		PortTypeable portTypeable = ip.getPorttype();
		
		if(!ZDLUtil.isZDLConcept(portTypeable.eObject(), CXDomainNames.CXINTERFACE)){
			return returnVal;
		}
		CXInterface intf = ZDLFactoryRegistry.INSTANCE.create(portTypeable.eObject(), CXInterface.class);			
			
		if(intf.getIsLocal()){
			returnVal = true;
		}
		
		return returnVal;
	}
	
	/**
	 * Given a CCMPart, return a list of interface ports owned by the definition of the CCMPart
	 */
	private List<InterfacePort> getLocalUsesInterfacePorts(CCMPart part){
		CCMComponent comp = (CCMComponent) part.getDefinition();
		List<InterfacePort> localUsesIP = new ArrayList<InterfacePort>();
		if(comp == null){
			return localUsesIP;
		}
		
		List<Port> portsComp = comp.getOwnedPort();
		
		for(Port p:portsComp){
			if(!(p instanceof InterfacePort)){
				continue;
			}
			
			InterfacePort ip = (InterfacePort) p;
			if(!ip.getIsConjugated() || !isPorttypeLocal(ip)){
				continue;
			}
			localUsesIP.add(ip);
		}
		return localUsesIP;
	}
}