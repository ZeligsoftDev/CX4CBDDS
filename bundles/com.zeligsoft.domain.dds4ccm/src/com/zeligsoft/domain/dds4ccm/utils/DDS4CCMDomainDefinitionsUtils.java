/**
 * Copyright 2022 Zeligsoft Limited.
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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author eposse
 */
public final class DDS4CCMDomainDefinitionsUtils {

	public static boolean isDomainDefinition(EObject modelElement) {
		return modelElement != null && ZDLUtil.isZDLConcept(modelElement, DDS4CCMNames.DOMAIN_DEFINITION);
	}

	public static boolean isDomainDeployment(EObject modelElement) {
		return modelElement != null && modelElement instanceof Component
				&& ZDLUtil.isZDLConcept(modelElement, DDS4CCMNames.DOMAIN_DEPLOYMENT);
	}

	public static boolean isDomainDeploymentPart(EObject modelElement) {
		return modelElement != null && modelElement instanceof Property
				&& ZDLUtil.isZDLConcept(modelElement, DDS4CCMNames.DOMAIN_DEPLOYMENT_PART);
	}

	public static boolean isNodeInstance(EObject modelElement) {
		return modelElement != null && modelElement instanceof Property
				&& ZDLUtil.isZDLConcept(modelElement, CCMNames.NODE_INSTANCE);
	}

	public static boolean isBridgeInstance(EObject modelElement) {
		return modelElement != null && modelElement instanceof Property
				&& ZDLUtil.isZDLConcept(modelElement, CCMNames.BRIDGE_INSTANCE);
	}

	public static boolean isInterconnectInstance(EObject modelElement) {
		return modelElement != null && modelElement instanceof Property
				&& ZDLUtil.isZDLConcept(modelElement, CCMNames.INTERCONNECT_INSTANCE);
	}

	public static List<Component> getAllDomainDefinitions(Package umlPackage) {
		List<Component> list = new ArrayList<>();
		for (Element element : umlPackage.allOwnedElements()) {
			if (isDomainDefinition(element)) {
				list.add((Component) element);
			}
		}
		return list;
	}

	public static List<Component> getDomainDefinitions(Package umlPackage) {
		List<Component> list = new ArrayList<>();
		for (PackageableElement element : umlPackage.getPackagedElements()) {
			if (isDomainDefinition(element)) {
				list.add((Component) element);
			}
		}
		return list;
	}

	public static List<Component> getDomainDeployments(Component domainDefinition) {
		List<Component> list = new ArrayList<>();
		for (PackageableElement element : domainDefinition.getPackagedElements()) {
			if (isDomainDeployment(element)) {
				list.add((Component) element);
			}
		}
		return list;
	}

	public static List<Property> getDomainDeploymentParts(Component domainDeployment) {
		List<Property> list = new ArrayList<>();
		for (PackageableElement element : domainDeployment.getPackagedElements()) {
			if (isDomainDeploymentPart(element)) {
				list.add((Property) element);
			}
		}
		return list;
	}

	public static Component getDeploymentPartDomainDefinition(Property deploymentPart) {
		Object obj = ZDLUtil.getValue(deploymentPart, ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		if (obj == null || !(obj instanceof EObject)) {
			return null;
		}
		EObject eObject = (EObject) obj;
		Component domainDefinition = null;
		if (ZDLUtil.isZDLConcept(eObject, CCMNames.NODE_INSTANCE)
				|| ZDLUtil.isZDLConcept(eObject, CCMNames.BRIDGE_INSTANCE)
				|| ZDLUtil.isZDLConcept(eObject, CCMNames.INTERCONNECT_INSTANCE)) {
			EObject owner = ((Property) obj).getOwner();
			if (isDomainDefinition(owner)) {
				domainDefinition = (Component) owner;
			}
		}
		return domainDefinition;
	}

}
