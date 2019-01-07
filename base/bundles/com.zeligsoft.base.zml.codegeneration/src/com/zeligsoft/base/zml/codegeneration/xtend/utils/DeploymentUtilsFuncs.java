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

package com.zeligsoft.base.zml.codegeneration.xtend.utils;

import java.util.Collection;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class DeploymentUtilsFuncs {

	/*
	 * Deployment utility functions to support generate configuration
	 */

	public static Collection<Dependency> getAllocations(Component component) {
		Collection<Dependency> retVal = ZDeploymentUtil
			.getAllocations(component);
		return retVal;
	}

	public static Dependency getAllocationForSourcePart(Property source) {
		Dependency allocation = ZDeploymentUtil
			.getAllocationForSourcePart(source);
		return allocation;
	}

	public static NamedElement getModelElementForConnector(
			Property deploymentPart) {
		NamedElement component = ZDeploymentUtil
			.getModelElement(deploymentPart);
		if (component instanceof Connector) {
			return component;
		}
		return null;
	}

	public static NamedElement getModelElementForComponent(
			Property deploymentPart) {
		NamedElement component = ZDeploymentUtil
			.getModelElement(deploymentPart);
		if (component instanceof Component) {
			return component;
		}
		return null;
	}

	public static Stereotype isStereotypeAppliedOnPart(Type source,
			String stereotype) {
		return source.getAppliedStereotype(stereotype);
	}

	public static Collection<Property> getDeploymentChildren(
			Property deploymentPart) {
		Collection<Property> retVal = ZDeploymentUtil
			.getDeploymentChildren(deploymentPart);
		return retVal;
	}

	public static String getConfiguratorPath(Property deploymentPart) {
		String parentPath = ""; //$NON-NLS-1$
		Component deployment = ZDeploymentUtil.getDeployment(deploymentPart);
		parentPath = getParentPartPath(deploymentPart, parentPath);
		return deployment.getName() + "/" + parentPath + "/" //$NON-NLS-1$ //$NON-NLS-2$
			+ deploymentPart.getName();
	}

	private static String getParentPartPath(Property deploymentPart, String path) {
		Property parentPart = ZDeploymentUtil.getParentPart(deploymentPart);

		if (parentPart != null) {
			path = path + parentPart.getName() + "/"; //$NON-NLS-1$
			getParentPartPath(parentPart, path);
		}

		return path;
	}

	public static Property getOtherComponentDeployedOnProecssName(
			Property deploymentPart, Connector connector) {
		Property retVal = null;
		for (ConnectorEnd end : connector.getEnds()) {
			if (end.getPartWithPort().getName().compareTo(
				deploymentPart.getName()) != 0) {
				/*
				 * TODO: the function below should be replaced by passing a
				 * end.getPartWithPort
				 */
				retVal = (Property) getAllocationForSourcePart(deploymentPart)
					.getSuppliers().get(0);
			}

		}
		return retVal;
	}

	public static boolean isPartEndofConnector(Property deploymentPart,
			Connector connector) {
		for (ConnectorEnd end : connector.getEnds()) {
			if (end.getPartWithPort().getName().compareTo(
				deploymentPart.getName()) == 0) {
				return true;
			}
		}

		return false;
	}

	public static Property getFindParentPartOfStereoType(
			Property deploymentPart, String stereotype) {
		Property parent = ZDeploymentUtil.getParentPart(deploymentPart);

		if (parent == null) {
			return null;
		}
		for (Stereotype st : parent.getType().getAppliedStereotypes()) {
			if (st.getQualifiedName().equals(stereotype)) {
				return parent;
			}
		}
		return getFindParentPartOfStereoType(parent, stereotype);

	}

	public static String getMySWPlatformName(Property deploymentPart) {
		String stereotype = "ZML::SwPlatform"; //$NON-NLS-1$
		Property prop = getFindParentPartOfStereoType(deploymentPart,
			stereotype);

		if (prop == null) {
			return "him_0_0"; //$NON-NLS-1$
		} else {
			return prop.getName();
		}

	}

	public static String isDeploymentPartTypeNamed(Property deploymentPart,
			String targetname) {
		if (deploymentPart.getType().getName().equals(targetname)) {
			return "true"; //$NON-NLS-1$
		} else {
			return "false"; //$NON-NLS-1$
		}
	}

	public static String getConfigurationPropertyValue(Property deploymentPart,
			String propname) {
		String deploymentPart_Stereotype = "ZeligsoftDeployment::DeploymentPart"; //$NON-NLS-1$
		String configuration_property = "configuration"; //$NON-NLS-1$
		String search_property = propname;
		Stereotype st = deploymentPart
			.getAppliedStereotype(deploymentPart_Stereotype);
		if (st != null) {
			Object obj = deploymentPart.getValue(st, configuration_property);
			if (obj != null) {
				if (obj instanceof NamedElement) {
					NamedElement ne = (NamedElement) obj;
					if (ne != null) {
						for (Element elem : ne.getOwnedElements()) {
							Slot si = (Slot) elem;
							StructuralFeature sf = si.getDefiningFeature();

							if (sf.getName().equals(search_property)) {
								// get configured value ...
								for (Object configuredval : si.getValues()) {
									if (configuredval instanceof LiteralInteger) {
										LiteralInteger litint = (LiteralInteger) configuredval;
										String retval = (new Integer(litint
											.getValue())).toString();
										return retval;
									}
								}

								// if no configured value get value from the
								// class definition ...
								for (Element stacksize : sf.getOwnedElements()) {

									if (stacksize instanceof LiteralInteger) {
										LiteralInteger litint = (LiteralInteger) stacksize;
										String retval = (new Integer(litint
											.getValue())).toString();
										return retval;
									}
								}
							}
						}
					}
				}
			}
		}

		// Grab the stack size property off the definition/type ...
		Type typeobj = deploymentPart.getType();
		if (typeobj instanceof Component) {
			Component comp = (Component) typeobj;
			for (Property p : comp.getAllAttributes()) {
				if (p.getName().equals(search_property)
					&& p.getDefaultValue() instanceof LiteralInteger) {
					LiteralInteger litint = (LiteralInteger) (p
						.getDefaultValue());
					String retval = (new Integer(litint.getValue())).toString();
					return retval;
				}
			}

		}

		// there is no configuration and no property on the DeploymentPart type
		// with a stack size property ...
		return "<NO PROPERTY NAMED:" + propname + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getDeploymentCDTPrjDir(Component deployment) {
		String retval = ""; //$NON-NLS-1$
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath location = root.getLocation();
		retval = location.toString();
		return retval + "/Z_" + deployment.getName(); //$NON-NLS-1$
	}

	public static String getImplementationPropertyValue(Operation structurePart) {
		String component_stereotype = "ZML::WorkerFunction"; //$NON-NLS-1$
		String property = "body"; //$NON-NLS-1$
		Stereotype st = structurePart
			.getAppliedStereotype(component_stereotype);
		if (st != null) {
			Object obj = structurePart.getValue(st, property);
			return obj.toString();
		}
		return ""; //$NON-NLS-1$
	}

	public static boolean isQualifiedNameMatch( Component component, String name ) {
		return component.getQualifiedName().equals(name);
	}

	public static boolean isPartBuildEnvironment( Property part ) {
		if ( part.getType() != null ) {
			return ZDLUtil.isZDLConcept( part.getType(), ZMLMMNames.BUILD_CONFIGURATION );
		}
		return false;
	}
	
	public static boolean isBuildEnvironmentMatch( Type type, String name ) {
		return type.getName().equals( name );
	}

	public static String getBuildEnvironmentProperty( Property property, String attribute ) {
		ValueSpecification vs = (InstanceValue)property.getDefaultValue();
		if ( vs == null ) {
			return "";
		}
		
		InstanceSpecification is = ((InstanceValue)vs).getInstance();
		if ( is == null ) {
			return "";
		}

		// find the given attribute in the given instance
		EList<Slot> slots = is.getSlots();
		
		for ( Slot slot: slots ) {
			if ( attribute.equals( slot.getDefiningFeature().getName() ) ) {
				EList<ValueSpecification> specs = slot.getValues();
				for ( ValueSpecification spec : specs ) {
					// TODO: need to handle this properly when we actually can get string arrays to work
					return spec.stringValue();
				}
				break;
			}
		}

		// find a default value from the hierarchy
		EList<Property> props = ((Classifier)property.getType()).getAllAttributes();
		for ( Property p : props ) {
			if ( p.getName().equals( attribute ) ) {
				return p.getDefault(); 
			}
		}

		return "";
	}	
}

