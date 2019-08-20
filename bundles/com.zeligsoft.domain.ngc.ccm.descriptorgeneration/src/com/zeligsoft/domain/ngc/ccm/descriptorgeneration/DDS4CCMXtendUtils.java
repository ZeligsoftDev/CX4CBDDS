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
package com.zeligsoft.domain.ngc.ccm.descriptorgeneration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMXtendUtils {

	@SuppressWarnings("deprecation")
	public static String getLocationPrefix(Element element) {

		String result = (String) ZDLUtil.getValue(element.getModel(),
				DDS4CCMNames.DDS4_CCMMODEL,
				DDS4CCMNames.DDS4_CCMMODEL__LOCATION_PREFIX);
		if (UML2Util.isEmpty(result)) {
			IEclipsePreferences store = new InstanceScope()
					.getNode(Activator.PLUGIN_ID);
			return store.get(DDS4CCMPreferenceConstants.GLOBAL_LOCATION_PREFIX,
					UML2Util.EMPTY_STRING);
		}
		return result;
	}

	/**
	 * 1) IF the RegisterNaming property has been explicitly set to anything at
	 * all on a CCMComponent type definition, then generate a RegisterNaming tag
	 * in a CDP file for an instance of this type.
	 * 
	 * a. In the deployment plan, the RegisterNaming property on an instance of
	 * this type will show up as �Value (default)� with the �(default)�
	 * identifying that a default value for it has been set on the parent type,
	 * vs. the instance.
	 * 
	 * 2) IF the RegisterNaming property has been explicitly set on an instance
	 * of a component in a deployment plan, per its Properties pane window, then
	 * generate the tag for that instance.
	 * 
	 * a. This override setting in a deployment plan would apply regardless of
	 * whether a (default) value had been set on the CCMComponent type, or not.
	 * 
	 * 3) IF there�s no explicit RegisterNaming property set on either the
	 * CCMComponent type (default setting) OR on the instance of that type
	 * (override setting) in the deployment plan, BUT there�s a CCMConnector
	 * connection definition in the deployment assembly that connects a deployed
	 * component instance (any facet/receptacle port � just takes one) with a
	 * non-deployed component instance, then generate the tag for the deployed
	 * instance.
	 * 
	 * @param deploymentPart
	 * @param property
	 * @return
	 */
	public static boolean shouldGenerateRegisterNamingTag(
			Property deploymentPart, Property property) {

		// condition 2)
		if (deploymentPart.getDefaultValue() instanceof InstanceValue) {
			Slot s = CCMUtil.getInstanceSlotForProperty(
					((InstanceValue) deploymentPart.getDefaultValue())
							.getInstance(), property, new ArrayList<EObject>());
			if (s != null && !s.getValues().isEmpty()) {
				String value = CCMUtil.getValueFromValueSpecification(s
						.getValues().get(0));
				if (!UML2Util.isEmpty(value)) {
					return true;
				}
			}
		}

		// condition 1)
		Component definition = (Component) property.eContainer();
		Property instanceProperty = definition.getOwnedAttribute(
				CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME, null);
		if (instanceProperty != null
				&& instanceProperty.getDefaultValue() instanceof InstanceValue) {
			Slot ds = CCMUtil.getInstanceSlotForProperty(
					((InstanceValue) instanceProperty.getDefaultValue())
							.getInstance(), property, new ArrayList<EObject>());
			if (ds != null && !ds.getValues().isEmpty()) {
				String value = CCMUtil.getValueFromValueSpecification(ds
						.getValues().get(0));
				if (!UML2Util.isEmpty(value)) {
					return true;
				}
			}
		}

		// condition 3)

		// if this is not deployed then we don't need to generate register naming
		if (ZDeploymentUtil.getDeploymentTargetPart(deploymentPart) == null) {
			return false;
		}

		for (Port sourcePort : definition.getOwnedPorts()) {
			// AMI connection is covered during the AMI connection generation
			// so we can safely ignore.
			boolean isAync = (Boolean) ZDLUtil.getValue(sourcePort,
					CCMNames.INTERFACE_PORT,
					CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
			if (isAync) {
				continue;
			}

			// Ignore extended port that connected to data space
			if (!ZDLUtil.isZDLConcept(sourcePort.getType(),
					CORBADomainNames.CORBAINTERFACE)) {
				continue;
			}

			boolean conjugation = (Boolean) ZDLUtil.getValue(sourcePort,
					ZMLMMNames.CONJUGATED_PORT,
					ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);
			
			List<Property> connectedEnds = new ArrayList<Property>();
			getConnectedEnds(!conjugation, sourcePort, deploymentPart,
					new ArrayList<Connector>(), new ArrayList<EObject>(),
					connectedEnds);

			for (Property p : connectedEnds) {
				// if connected part is not deployed then generate.
				if (ZDeploymentUtil.getDeploymentTargetPart(p) == null) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Find all connected deployment parts
	 * 
	 * @param sourcePort
	 * @param sourceDeploymentPart
	 * @param connectedEnds
	 */
	private static void getConnectedEnds(boolean targetConjugation,
			Port sourcePort, Property sourceDeploymentPart,
			List<Connector> visitedConnectors, List<EObject> visitedAssembly,
			List<Property> connectedEnds) {
		if (sourcePort == null) {
			return;
		}

		boolean conjugation = (Boolean) ZDLUtil.getValue(sourcePort,
				ZMLMMNames.CONJUGATED_PORT,
				ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);

		// source component part
		Property sourcePart = (Property) ZDLUtil.getValue(sourceDeploymentPart,
				ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		List<Connector> allConnectors = new ArrayList<Connector>();

		if (targetConjugation == conjugation) {
			// if this is assembly part then check all delegation connectors
			// owned by this assembly
			Component typeAssembly = (Component) CCMUtil
					.getAssemblyFromComponent((Component) sourcePart.getType());
			// Do not go back to assembly we came from
			for (Connector c : typeAssembly.getOwnedConnectors()) {
				if (c.getKind() == ConnectorKind.DELEGATION_LITERAL) {
					allConnectors.add(c);
				}
			}
		} else {
			allConnectors.addAll(((Component) sourcePart.eContainer())
					.getOwnedConnectors());
		}

		for (Connector cntr : allConnectors) {

			if (visitedConnectors.contains(cntr)) {
				continue;
			}
			visitedConnectors.add(cntr);
			ConnectorEnd end0 = cntr.getEnds().get(0);
			ConnectorEnd end1 = cntr.getEnds().get(1);

			// if the connection is to data space then ignore
			if (!(end0.getRole() instanceof Port)
					|| !(end1.getRole() instanceof Port)) {
				continue;
			}

			Property end0Part = end0.getPartWithPort();
			Port end0Port = (Port) end0.getRole();

			Property end1Part = end1.getPartWithPort();
			Port end1Port = (Port) end1.getRole();

			Property targetPart = null;
			Port targetPort = null;

			if (targetConjugation == conjugation) {
				// if this is delegation connector into assembly
				if (sourcePort == end0Port) {
					targetPort = end1Port;
					targetPart = end1Part;
				} else if (sourcePort == end1Port) {
					targetPort = end0Port;
					targetPart = end0Part;
				}
			} else if (end0Part == sourcePart && end0Port == sourcePort) {
				targetPart = end1Part;
				targetPort = end1Port;
			} else if (end1Part == sourcePart && end1Port == sourcePort) {
				targetPart = end0Part;
				targetPort = end0Port;
			}

			if (targetPort == null) {
				continue;
			}

			Property targetDeploymentPart = null;
			Property parentDeploymentPart = ZDeploymentUtil
					.getParentPart(sourceDeploymentPart);

			// This is assembly connection
			if (targetPart != null) {
				for (Property child : ZDeploymentUtil
						.getDescendants(parentDeploymentPart)) {
					Property childPart = (Property) ZDLUtil.getValue(child,
							ZMLMMNames.DEPLOYMENT_PART,
							ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
					if (childPart == targetPart) {
						targetDeploymentPart = child;
						break;
					}
				}
			} else {
				targetDeploymentPart = parentDeploymentPart;
			}

			if (targetPart != null
					&& !CCMUtil.isAssemblyComponent(targetPart.getType())) {
				boolean isAync = (Boolean) ZDLUtil.getValue(targetPort,
						CCMNames.INTERFACE_PORT,
						CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);

				// AMI connection is covered during the AMI connection
				// generation
				// so we can safely ignore.
				if (!isAync) {
					connectedEnds.add(targetDeploymentPart);
				}
				continue;
			}
			getConnectedEnds(targetConjugation, targetPort,
					targetDeploymentPart, visitedConnectors, visitedAssembly,
					connectedEnds);
		}
	}

}
