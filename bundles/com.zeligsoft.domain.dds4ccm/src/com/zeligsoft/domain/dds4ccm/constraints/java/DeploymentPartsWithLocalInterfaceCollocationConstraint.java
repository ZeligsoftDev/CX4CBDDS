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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.impl.DeploymentPlanImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.ConnectorEnd;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.PortTypeable;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Deployment;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This makes sure that components with local connections are deployed to the same process 
 * 
 * @author das
 * 
 * Algorithm followed:
 * 
 *	1. For a CCMPart which is deployed and being validated (i.e., partToCheck), get the list of local client interface ports (i.e., localClientPortsToCheck). 
 *	    - Consider "dPartToCheckDeployed" as the deployment part of "partToCheck". 
 *	2. Get the collocated deployment parts (i.e., collocatedParts) of "dPartToCheckDeployed" by retrieving all the deployment parts which are deployed to a target same as "dPartToCheckDeployed" and whose modelElement is CCMPart.
 *  3. For all the deployed CCMPart (i.e., partToCompare) except for "partToCheck", do the following: 
 *		a. Get all the connected local server interface ports (i.e., localFacetPorts) for each receptacle in "localClientPortsToCheck" 
 * 		b. If the component definition of "partToCompare" owns any port from "localFacetPorts", check if the list "collocatedParts" contains the deployment part of "partToCompare"
 * 		c. If there is a match, generate validation error 
 * 
 */
public class DeploymentPartsWithLocalInterfaceCollocationConstraint extends AbstractModelConstraint {
	
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (objToVerify == null
				|| !ZDLUtil.isZDLConcept(objToVerify,
						ZMLMMNames.DEPLOYMENT_PART)) {
			return ctx.createSuccessStatus();
		}		
		
		DeploymentPart dPartToCheckConfigured = ZDLFactoryRegistry.INSTANCE.create(objToVerify, DeploymentPart.class);

		Component compDeployment = ZDeploymentUtil.getDeployment(dPartToCheckConfigured.asProperty());

		Deployment deployment = ZDLFactoryRegistry.INSTANCE.create(compDeployment, Deployment.class);

		Allocation dPartAllocation = getAllocation(dPartToCheckConfigured, deployment);

		if(dPartAllocation == null){
			return ctx.createSuccessStatus();
		}

		
		DeploymentPart dPartToCheckDeployed = dPartAllocation.getDeployed().get(0); // 1-to-1 between dpConfigured and dpDepoloyed, right?

		if(!(dPartToCheckDeployed.getModelElement() instanceof CCMPart)){
			return ctx.createSuccessStatus();
		}

		CCMPart partToCheck = ZDLFactoryRegistry.INSTANCE.create(dPartToCheckDeployed.getModelElement().eObject(), CCMPart.class);

		List<InterfacePort> localClientPortsToCheck = getLocalClientInterfacePorts(partToCheck); // Step#1
		
		DeploymentPart dPartToCheckDeployedOn = dPartAllocation.getDeployedOn();
		List<DeploymentPart> collocatedParts = getPartsDeployedOnTarget(dPartToCheckDeployedOn, deployment);	// Step#2
		
		List<DeploymentPart> dPartsConfigured = deployment.getPart();
		
		for(DeploymentPart dPartToCompareConfigured: dPartsConfigured){

			if(dPartToCompareConfigured.equals(dPartToCheckConfigured)){
				continue;
			}

			Allocation allocationToCompare = getAllocation(dPartToCompareConfigured, deployment);

			if((allocationToCompare == null) || !(dPartToCompareConfigured.getModelElement() instanceof CCMPart)){
				continue;
			}

			DeploymentPart dPartToCompareDeployed = allocationToCompare.getDeployed().get(0); // confirm this

			CCMPart partToCompare = ZDLFactoryRegistry.INSTANCE.create(dPartToCompareDeployed.getModelElement().eObject(), CCMPart.class);

			List<InterfacePort> portsToCompare = getInterfacePorts(partToCompare);

			for(InterfacePort receptacle: localClientPortsToCheck){
				Set<InterfacePort> facetPorts = getFacetPorts(receptacle, dPartToCheckDeployed, deployment);				
				List<InterfacePort> localFacetPorts = getLocalInterfacePorts(new ArrayList<InterfacePort>(facetPorts)); // Step#3a

				for(InterfacePort p: localFacetPorts){
					if(!portsToCompare.contains(p)){
						continue;
					}

					if(!collocatedParts.contains(dPartToCompareDeployed)){	// Step#3b
						ctx.addResult(dPartToCompareConfigured.eObject());
					
						String vArg1 = dPartToCheckDeployed.getName() + " :: " + receptacle.getName();
						String vArg2 = ZDeploymentUtil.getQualifiedName(dPartToCompareDeployed.asProperty()) + " :: "+ p.getName();
						String vArg3 = ZDeploymentUtil.getQualifiedName(allocationToCompare.getDeployedOn().asProperty());
						return ctx.createFailureStatus(vArg1.trim(), vArg2.trim(), vArg3);	// Step#3c
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();		
	}
	/**
	 * Given a receptacle port and an assemblyImplementation, returns a set of possible facets in the assembly.
	 * 
	 * @param receptacle
	 * @param receptPartOwner
	 * @return a set of possible facets in receptPartOwner
	 */
	private List<InterfacePort> getPossibleFacets(InterfacePort receptacle, AssemblyImplementation receptPartOwner){

		List<InterfacePort> possibleFacets = new ArrayList<InterfacePort>();		
		List<Part> ownedParts = receptPartOwner.getPart();
		
		for(Part ownedPart: ownedParts){
			if(!(ownedPart instanceof CCMPart)){
				continue;
			}
			for(InterfacePort ip: getInterfacePorts((CCMPart) ownedPart)){
				if(!ip.getIsConjugated() && ip.getPorttype().equals(receptacle.getPorttype())){
					possibleFacets.add(ip);
				}				
			}			
		}		
		return possibleFacets;		
	}
	
	/**
	 * Given a receptacle port, returns a set of ports from corresponding component definition that the receptacle port is connected to.
	 * 
	 * @param receptacle
	 * @param receptPartDP
	 * @param deployment
	 * @return a set of facet ports
	 */ 
	public Set<InterfacePort> getFacetPorts(InterfacePort receptacle, DeploymentPart receptPartDP, Deployment deployment){
		Set<InterfacePort> generatedFacets = new HashSet<InterfacePort>();
		CCMPart receptPart = ZDLFactoryRegistry.INSTANCE.create(receptPartDP.getModelElement().eObject(), CCMPart.class);
		
		AssemblyImplementation receptPartOwner = ZDLFactoryRegistry.INSTANCE.create(receptPart.asProperty().getOwner(), AssemblyImplementation.class);
		
		// get all the connectors connected to the receptacle port
		List<AssemblyConnector> receptacleConnectors = new ArrayList<AssemblyConnector>();		
		List<AssemblyConnector> ownedConnectors = receptPartOwner.getConnector();		
		
		for(AssemblyConnector ownedConnector: ownedConnectors){
			
			for(ConnectorEnd ce: ownedConnector.getEnd()){
				Port portCE = ce.getPort();
				Part partWithPortCE = ce.getPartWithPort();
				
				if((portCE == null) || (partWithPortCE == null)){
					continue;
				}
				
				if(portCE.equals(receptacle) && partWithPortCE.equals(receptPart)){
					receptacleConnectors.add(ownedConnector);
					break;
				}
			}
			
		}
		
		List<AssemblyConnector> receptacleConnectorsAssembly = new ArrayList<AssemblyConnector>();
		List<AssemblyConnector> receptacleConnectorsDelegation = new ArrayList<AssemblyConnector>();		
		
		for(AssemblyConnector connector: receptacleConnectors){
			if(DDS4CCMUtil.isAssemblyConnector(connector.asConnector())){
				receptacleConnectorsAssembly.add(connector);
			}
		}
		
		for(AssemblyConnector connector: receptacleConnectors){
			if(DDS4CCMUtil.isDelegationConnector(connector.asConnector())){
				receptacleConnectorsDelegation.add(connector);
			}
		}
		// get corresponding facet ports in the receptacle connectors
		List<InterfacePort> connectedFacetsAssembly = getConnectedFacets(receptacleConnectorsAssembly, receptacle);
		List<InterfacePort> connectedFacetsDelegation = getConnectedFacets(receptacleConnectorsDelegation, receptacle);
		
		if(connectedFacetsAssembly.size() > 0){
			// Filter out the external ports by taking the intersection of the possible facets and the connected facets
			List<InterfacePort> possibleFacets = getPossibleFacets(receptacle, receptPartOwner);
			connectedFacetsAssembly.retainAll(possibleFacets); // this represents a list of intermediate facets now
			
			for(InterfacePort intermediateFacet: connectedFacetsAssembly){
				
				List<DeploymentPart> dPartsForFacet = getPartsForFacetDP(intermediateFacet, receptPart, receptacle, deployment);
				
				for(DeploymentPart facetPartDP: dPartsForFacet){
			
					generatedFacets.addAll(getTerminalFacets(facetPartDP, intermediateFacet, receptPart, receptacle, deployment));
					
				}
			}
			
			
		}
		
		if(connectedFacetsDelegation.size() > 0){
			
			List<CCMPart> modelElementParts = getCCMParts(deployment);
			List<CCMPart> partsConnectedFacetsOwner = new ArrayList<CCMPart>();
			List<DeploymentPart> dpConnectedFacetsOwner = new ArrayList<DeploymentPart>();
			
			AssemblyImplementation receptPartOwnerAssembly = null;
			Element receptPartOwnerElement = receptPart.asProperty().getOwner();
			
			if(ZDLUtil.isZDLConcept(receptPartOwnerElement, CCMNames.ASSEMBLY_IMPLEMENTATION)){
				receptPartOwnerAssembly = ZDLFactoryRegistry.INSTANCE.create(receptPartOwnerElement, AssemblyImplementation.class);
			}
			
			for(CCMPart modelElementPart: modelElementParts){
				CCMComponent compPart = ZDLFactoryRegistry.INSTANCE.create(modelElementPart.getDefinition().eObject(), CCMComponent.class);
				List<AssemblyImplementation> assemblyImpls = getAssembly(compPart);
				
				if(assemblyImpls.contains(receptPartOwnerAssembly)){
					partsConnectedFacetsOwner.add(modelElementPart);
				}
			}
			
			for(DeploymentPart dPart: deployment.getPart()){
				
				for(CCMPart ccmPart: partsConnectedFacetsOwner){
					if(dPart.getModelElement().equals(ccmPart)){
						dpConnectedFacetsOwner.add(dPart);
						break;
					}
					
				}
			}
			// call the method recursively with an updated set of receptacle and receptPartDP
			for(DeploymentPart fp: dpConnectedFacetsOwner){
					for(InterfacePort cf: connectedFacetsDelegation){
						generatedFacets.addAll(getFacetPorts(cf, fp, deployment));
					}
			}
			
		}
		
		return generatedFacets;		
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
	
	/**
	 * Given a facet port, returns a list of ports which are the final destination of a signal arrived at the facet port
	 * 
	 * @param facetPartDP deployment part representing the owner instance of the facet port
	 * @param facet
	 * @param receptPart owner instance of the receptacle
	 * @param receptacle
	 * @param deployment
	 * @return List of terminal facet ports that cannot be expanded anymore  
	 */
	private List<InterfacePort> getTerminalFacets(DeploymentPart facetPartDP, InterfacePort facet, CCMPart receptPart, InterfacePort receptacle, Deployment deployment){
		List<InterfacePort> terminalFacets = new ArrayList<InterfacePort>();
		CCMPart facetPart = ZDLFactoryRegistry.INSTANCE.create(facetPartDP.getModelElement().eObject(), CCMPart.class);
		CCMComponent facetComponent = ZDLFactoryRegistry.INSTANCE.create(facetPart.getDefinition().eObject(), CCMComponent.class);
		
		List<AssemblyImplementation> assemblyImpls = getAssembly(facetComponent);
		
		if(!assemblyImpls.isEmpty()){
			List<ConnectorEnd> delConnectorEnd = new ArrayList<ConnectorEnd>();
			// Get the assembly implementation of facetPart and find all internal endpoints we must iterate into.			
			for(AssemblyImplementation assemblyImpl: assemblyImpls){
				for(AssemblyConnector conn: assemblyImpl.getConnector()){
					if(!containsPort(conn, facet)){
						continue;
					}
					
					for(ConnectorEnd ce: conn.getEnd()){
						if(!ce.getPort().equals(facet)){
							delConnectorEnd.add(ce);
						}
						break;
					}
				}
			}
			// Iterate all the delegation connector ends and call the method recursively with an updated set of parameters
			for(ConnectorEnd dce: delConnectorEnd){				
				DeploymentPart updatedFacetPartDP = null;
				InterfacePort updatedFacet = null;
				
				for(DeploymentPart nestedPart: facetPartDP.getNestedPart()){
					if(nestedPart.getModelElement().equals(dce.getPartWithPort())){
						updatedFacetPartDP = nestedPart;
						break;
					}
				}
				
				if(ZDLUtil.isZDLConcept(dce.getPort().eObject(), CCMNames.INTERFACE_PORT)){
					updatedFacet = ZDLFactoryRegistry.INSTANCE.create(dce.getPort().eObject(), InterfacePort.class);
				}
				terminalFacets.addAll(getTerminalFacets(updatedFacetPartDP, updatedFacet, receptPart, receptacle, deployment));
			}
		}else{
			terminalFacets.add(facet);
		}
		return terminalFacets;		
	}	
	
	/**
	 * Given a facet port, returns a list of deployment parts which correspond to the owner CCMParts
	 * 
	 * @param facet
	 * @param receptPart owner instance of the receptacle
	 * @param receptacle
	 * @param deployment
	 * @return a list of deployment parts representing the owner instance of the facet port   
	 */
	private List<DeploymentPart> getPartsForFacetDP(InterfacePort facet, CCMPart receptPart, InterfacePort receptacle, Deployment deployment){
		
		AssemblyImplementation partOwner = ZDLFactoryRegistry.INSTANCE.create(receptPart.asProperty().getOwner(), AssemblyImplementation.class);
		List<DeploymentPart> dPartsForFacet = new ArrayList<DeploymentPart>();
		List<AssemblyConnector> receptacleConnectors = new ArrayList<AssemblyConnector>();
		List<CCMPart> facetParts = new ArrayList<CCMPart>(); 
		
		// Get the set of all connectors that are connected to this receptacles				
		List<AssemblyConnector> ownedConnectors = partOwner.getConnector();
		
		for(AssemblyConnector ownedConnector: ownedConnectors){
			
			if(!containsPort(ownedConnector, facet)){
				continue;
			}
			
			for(ConnectorEnd ce: ownedConnector.getEnd()){
				Port portCE = ce.getPort();
				Part partWithPortCE = ce.getPartWithPort();
				
				if((portCE == null) || (partWithPortCE == null)){
					continue;
				}
				
				if(portCE.equals(receptacle) && partWithPortCE.equals(receptPart)){
					receptacleConnectors.add(ownedConnector);
					break;
				}
			}
			
		}
 
		for(AssemblyConnector receptacleConnector: receptacleConnectors){
			
			for(ConnectorEnd ce: receptacleConnector.getEnd()){
				// filter out the connector ends that correspond to receptacle
				if(ce.getPort().equals(receptacle)){
					continue;
				}
				if(!ZDLUtil.isZDLConcept(ce.getPartWithPort().eObject(), CCMNames.CCMPART)){
					continue;
				}
				CCMPart facetPart = ZDLFactoryRegistry.INSTANCE.create(ce.getPartWithPort().eObject(), CCMPart.class); 
				facetParts.add(facetPart);
			}
		}
		// retrieve deployment part for the facetParts
		for(DeploymentPart dp: deployment.getPart()){
			if(facetParts.contains(dp.getModelElement())){
				dPartsForFacet.add(dp);
			}
		}		
		
		return dPartsForFacet;
	}
	/**
	 * Given a list of receptacle connectors and a receptacle port, returns a list of connected facets
	 * 
	 * @param receptacleConnectors connectors connected to the receptacle port
	 * @param receptacle
	 * @return a list of connected facet ports   
	 */
	private List<InterfacePort> getConnectedFacets(List<AssemblyConnector> receptacleConnectors, InterfacePort receptacle){
		
		List<InterfacePort> connectedFacets = new ArrayList<InterfacePort>();
		
		for(AssemblyConnector connector: receptacleConnectors){
			
			for(ConnectorEnd ce: connector.getEnd()){
				Port port = ce.getPort();
				if(!(port instanceof InterfacePort)){
					continue;
				}
				
				if(!port.equals(receptacle)){
					connectedFacets.add((InterfacePort) port);
				}
				
			}
			
		}
		
		return connectedFacets;
	}
	/**
	 * Given a CCMComponent, returns a list of assembly implementations that inherit from the CCMComponent
	 * 
	 * @param component
	 * @return a list of assembly implementations specializing from component    
	 */
	public List<AssemblyImplementation> getAssembly(CCMComponent component){
		
		List<AssemblyImplementation> assemblyImpls = new ArrayList<AssemblyImplementation>();
		EList<Relationship> rels = component.asComponent().getRelationships();
		
		for(Relationship rel: rels){
			if(rel instanceof Generalization){
				Generalization gen = (Generalization) rel;
				Classifier specific = gen.getSpecific();
				
				if(ZDLUtil.isZDLConcept(specific, CCMNames.ASSEMBLY_IMPLEMENTATION)){
					AssemblyImplementation assembly = ZDLFactoryRegistry.INSTANCE.create(specific, AssemblyImplementation.class);
					assemblyImpls.add(assembly);
				}
				
			}
			
		}		
		
		return assemblyImpls;
	}
	/**
	 * Given a deployment instance, returns a list of all the underlying CCMParts for the deployment parts
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
	 * Given a CCMPart, returns a list of interface ports owned by the definition of the CCMPart
	 * 
	 * @param part
	 * @return a list of interface ports owned by part definition    
	 */
	public List<InterfacePort> getInterfacePorts(CCMPart part){
		List<InterfacePort> ports = new ArrayList<InterfacePort>();
		
		CCMComponent comp = ZDLFactoryRegistry.INSTANCE.create(part.getDefinition().eObject(), CCMComponent.class);
		
		if(comp != null){
			List<Port> portsComp = comp.getOwnedPort();
			
			for(Port p:portsComp){
				if(p instanceof InterfacePort){
					
					ports.add((InterfacePort) p);					
					
				}
			}
			
		}
		
		return ports;		
	}
	
	/**
	 * Given a CCMPart, returns a list of client interface ports which are typed by local interface and owned by the definition of the CCMPart
	 * 
	 * @param part
	 * @return a list of client interface ports typed by local interface and owned by the part definition    
	 */
	private List<InterfacePort> getLocalClientInterfacePorts(CCMPart part){
		List<InterfacePort> localClientPorts = new ArrayList<InterfacePort>();
		
		List<InterfacePort> ports = getInterfacePorts(part);
		
		for(InterfacePort ip:ports){			
			
			PortTypeable portTypeable = ip.getPorttype();
			
			if(!ZDLUtil.isZDLConcept(portTypeable.eObject(), CORBADomainNames.CORBAINTERFACE)){
				continue;
			}
			CORBAInterface intf = ZDLFactoryRegistry.INSTANCE.create(portTypeable.eObject(), CORBAInterface.class);			
			
				
			if(intf.getIsLocal() && ip.getIsConjugated()){
				localClientPorts.add(ip);
			}
		}		
		return localClientPorts;		
	}
	/**
	 * Given a list of interface ports, returns a sublist having interface ports typed by local interface and owned by the definition of the CCMPart
	 * 
	 * @param ports
	 * @return a filtered list of ports that are typed by local interface    
	 */
	private List<InterfacePort> getLocalInterfacePorts(List<InterfacePort> ports){
		List<InterfacePort> localPorts = new ArrayList<InterfacePort>();
		
		for(InterfacePort ip:ports){			
			
			PortTypeable portTypeable = ip.getPorttype();
			
			if(!ZDLUtil.isZDLConcept(portTypeable.eObject(), CORBADomainNames.CORBAINTERFACE)){
				continue;
			}
			CORBAInterface intf = ZDLFactoryRegistry.INSTANCE.create(portTypeable.eObject(), CORBAInterface.class);			
			
				
			if(intf.getIsLocal()){
				localPorts.add(ip);
			}
		}
		return localPorts;
	}

	/**
	 * Given a deployment instance and a deployment target, returns a list of deployment parts which are of type CCMPart and are deployed to the target
	 * 
	 * @param target
	 * @param deployment
	 * @return a list of deployment parts representing CCMParts that are deployed to target     
	 */
	private List<DeploymentPart> getPartsDeployedOnTarget(DeploymentPart target, Deployment deployment){
		List<DeploymentPart> parts = new ArrayList<DeploymentPart>();
		List<Allocation> dpAllocations = deployment.getAllocation();
		
		for(Allocation dpAllocation: dpAllocations){
			if(dpAllocation.getDeployedOn().equals(target)){
				
				List<DeploymentPart> dPartsDeployed = dpAllocation.getDeployed();
				
				for(DeploymentPart dPartDeployed: dPartsDeployed){
					
					if(dPartDeployed.getModelElement() instanceof CCMPart){
						parts.add(dPartDeployed);
					}
				}
			}
			
		}
		return parts;
	}
	
	/**
	 * Given a deployment instance and a configured deployment part, returns an allocation instance which is used for deploying the configured deployment part
	 * 
	 * @param dPartConfigured
	 * @param deployment
	 * @return an allocation instance used for deploying dPartConfigured     
	 */
	public Allocation getAllocation(DeploymentPart dPartConfigured, Deployment deployment){
		
		Allocation allocation = null;
		
		List<Allocation> dpAllocations = deployment.getAllocation();
		
		for(Allocation dpAllocation: dpAllocations){
			List<DeploymentPart> deployedDPs = dpAllocation.getDeployed();
			
			for(DeploymentPart deployedDP: deployedDPs){
				if(deployedDP.equals(dPartConfigured)){
					
					allocation = dpAllocation;
					break;
				}
			}
			if(allocation != null){
				break;
			}
			
		}
		return allocation;
	}	
}