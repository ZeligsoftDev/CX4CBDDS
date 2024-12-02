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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;

import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ConnectorType;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.dds4ccm.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * A set of utilities that help when working with the DDS4CCM domain.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class DDS4CCMUtil {

	public static final DDS4CCMUtil INSTANCE;

	static {
		INSTANCE = new DDS4CCMUtil();
	}

	/**
	 * Create me
	 */
	protected DDS4CCMUtil() {
		// I have no state, so we will use a singleton
	}
	
	public static void addStereotypesToResource(EObject container,
			EObject containee) {
		if (container == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContainerParameter);
		}

		if (containee == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContaineeParameter);
		}

		if (container.eResource() == null) {
			throw new IllegalArgumentException(
					Messages.DDS4CCMUtil_Exception_ContainerNotInResource);
		}

		// make sure that the stereotypes applied are contained in the same
		// resource
		Resource resource = container.eResource();
		if (containee instanceof Element && resource != null) {
			resource.getContents().addAll(
					((Element) containee).getStereotypeApplications());
		}
	}

	public static void debug(Object o) {
		o.getClass();
	}

	/**
	 * Returns true if a CORBAInterface types a port that is asynchronous.
	 * Certain IDL pragmas and D&C descriptors are generated when this is the
	 * case.
	 * 
	 * @param intf
	 * @return
	 */
	public static boolean isUsedAsynchronously(Interface intf) {

		if (ZDLUtil.isZDLConcept(intf, CXDomainNames.CXINTERFACE) == false) {
			return false;
		}

		return (Boolean) ZDLUtil.getValue(intf,
				CXDomainNames.CXINTERFACE,
				CXDomainNames.CXINTERFACE__IS_ASYNCHRONOUS);
	}
	
	/**
	 * Returns true if the CXInterface is neither local nor asynchronous.
	 * 
	 * @param intf
	 * @return
	 */
	public static boolean isUsedSynchronously(Interface intf) {

		if (ZDLUtil.isZDLConcept(intf, CXDomainNames.CXINTERFACE) == false) {
			return false;
		}
		boolean isAsynchronous = (Boolean) ZDLUtil.getValue(intf,
				CXDomainNames.CXINTERFACE,
				CXDomainNames.CXINTERFACE__IS_ASYNCHRONOUS);
		boolean isLocal = (Boolean) ZDLUtil.getValue(intf,
				CXDomainNames.CXINTERFACE,
				CXDomainNames.CXINTERFACE__IS_LOCAL);
		return !isAsynchronous && !isLocal;
	}


	private static EObject getPropertyType(Component containerProcess, PropertyVariable property) {
		switch (property) {
		case LM_PROCESSNAME:
		case LM_CPUAFFINITY:
		case LM_PROCESSPRIORITY:
		case LOCALITY_ARGUMENTS:
			return CORBAUtil.getCORBAPrimitiveType(containerProcess, "CXString"); //$NON-NLS-1$
		case ZMQ_SRV_IOTHREADS:
		case ZMQ_SRV_POLLINGTHREADS:
		case ZMQ_SRV_MAXSOCKETS:
		case ZMQ_SRV_THREADPRIO:
		case ZMQ_SRV_THREADSCHEDPOLICY:
			return CORBAUtil.getCORBAPrimitiveType(containerProcess, "CXULong"); //$NON-NLS-1$
		default:
			return CORBAUtil.getCORBAPrimitiveType(containerProcess, "CXString"); //$NON-NLS-1$
		}
	}
	
	private static PropertyVariable[] CONTAINER_PROPERTIES_TO_ADD = {
			PropertyVariable.LM_CPUAFFINITY,
			PropertyVariable.LM_PROCESSPRIORITY,
			PropertyVariable.LOCALITY_ARGUMENTS,
			PropertyVariable.ZMQ_SRV_IOTHREADS,
			PropertyVariable.ZMQ_SRV_POLLINGTHREADS,
			PropertyVariable.ZMQ_SRV_MAXSOCKETS,
			PropertyVariable.ZMQ_SRV_THREADPRIO,
			PropertyVariable.ZMQ_SRV_THREADSCHEDPOLICY
	};

	private static PropertyVariable[] CONTAINER_PROPERTIES_TO_REMOVE = {
			PropertyVariable.LM_PROCESSNAME
	};
/**
	 * 
	 * 
	 * @param containerProcess
	 */
	public static boolean setupContainerProcessResources(
			Component containerProcess) {

		String modelType = DDS4CCMUtil.getModelType(containerProcess);

		boolean containerProcessModified = false;

		if (ZDLUtil.isZDLConcept(containerProcess, CCMNames.CONTAINER_PROCESS)) {
			for (PropertyVariable p: CONTAINER_PROPERTIES_TO_ADD) {
				String name = p.getName(modelType);
				boolean hasRequiredProperty = false;
				for (Property umlProperty: containerProcess.getOwnedAttributes()) {
					if (name.equals(umlProperty.getName())) {
						hasRequiredProperty = true;
					}
				}
				if (!hasRequiredProperty) {
					containerProcessModified = true;
					EObject property = ZDLUtil.createZDLConceptIn(containerProcess,
							CCMNames.PROPERTY);
					ZDLUtil.setValue(property, CCMNames.PROPERTY,
							ZMLMMNames.NAMED_ELEMENT__NAME, name);
					ZDLUtil.setValue(property, CCMNames.PROPERTY,
							ZMLMMNames.TYPED_ELEMENT__TYPE, getPropertyType(containerProcess, p));
				}
			}
			for (PropertyVariable p: CONTAINER_PROPERTIES_TO_REMOVE) {
				String name = p.getName(modelType);
				boolean hasUndesiredProperty = false;
				for (Property umlProperty: containerProcess.getOwnedAttributes()) {
					if (name.equals(umlProperty.getName())) {
						hasUndesiredProperty = true;
						break;
					}
				}
				if (hasUndesiredProperty) {
					containerProcessModified = true;
					Command cmd = BaseUtil.getDeleteCommand(Collections.singletonList(containerProcess.getOwnedMember(name)));
					TransactionUtil.getEditingDomain(containerProcess).getCommandStack().execute(cmd);
				}
			}
		}

		return containerProcessModified;
	}
	
	public static boolean addRegisterNamingProperty(Class zdlClass) {
		
		String modelType = DDS4CCMUtil.getModelType(zdlClass);
		
		boolean b_componentModified = false;
		
		EObject corbaStringType = CORBAUtil.getCORBAPrimitiveType(zdlClass, "CXString"); //$NON-NLS-1$
		
		if (ZDLUtil.isZDLConcept(zdlClass, CCMNames.CCMCOMPONENT)
			|| ZDLUtil.isZDLConcept(zdlClass, CCMNames.HOME)) {
			
			boolean b_hasRegisterNaming = false;
			
			for (Property p : zdlClass.getOwnedAttributes()) {
				if (p.getName().matches(PropertyVariable.REGISTER_NAMING.getName(modelType))) {
					b_hasRegisterNaming = true;
				}
			}
			
			if (!b_hasRegisterNaming) {
				b_componentModified = true;
				EObject property = ZDLUtil.createZDLConceptIn(zdlClass,
						CCMNames.PROPERTY);
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.NAMED_ELEMENT__NAME, PropertyVariable.REGISTER_NAMING.getName(modelType));
				ZDLUtil.setValue(property, CCMNames.PROPERTY,
						ZMLMMNames.TYPED_ELEMENT__TYPE, corbaStringType);
			}
		}
		
		return b_componentModified;
	}

	@SuppressWarnings("nls")
	public static void convertCORBAStructToDDSMessage(Element struct) {
		// Because structs and fields don't have any useful information that
		// isn't already stored in UML, it's safe to unapply
		// and reapply the stereotypes. This logic is specific to the DDS4CCM
		// profile.
		Stereotype s = struct.getAppliedStereotype("cxDDS4CCM::CXStruct");
		struct.unapplyStereotype(s);
		ZDLUtil.addZDLConcept(struct, DDS4CCMNames.DDSMESSAGE);
		for (Element sub : struct.getOwnedElements()) {
			s = sub.getAppliedStereotype("cxDDS4CCM::CXField");
			if (s != null) {
				sub.unapplyStereotype(s);
				ZDLUtil.addZDLConcept(sub, DDS4CCMNames.MESSAGE_FIELD);
			}
			for (Comment comment : sub.getOwnedComments()) {
				if (comment.getBody().contains("@key")) {
					sub.getOwnedComments().remove(comment);
					ZDLUtil.setValue(sub, DDS4CCMNames.MESSAGE_FIELD,
							DDS4CCMNames.MESSAGE_FIELD__IS_KEY, true);
					break;
				}
			}
		}
	}
	
	/**
	 * Converts DDSMeesage to CXStruct
	 * @param ddsMessage
	 */
	@SuppressWarnings("nls")
	public static void convertDDSMessageToCORBAStruct(Element ddsMessage) {
		Stereotype stereotype = ddsMessage
				.getAppliedStereotype("cxDDS4CCM::DDSMessage"); 
		ddsMessage.unapplyStereotype(stereotype);
		ZDLUtil.addZDLConcept(ddsMessage, CXDomainNames.CXSTRUCT);

		for (Element element : ddsMessage.getOwnedElements()) {
			stereotype = element
					.getAppliedStereotype("cxDDS4CCM::MessageField"); 

			if (stereotype != null) {
				element.unapplyStereotype(stereotype);
				ZDLUtil.addZDLConcept(element, CXDomainNames.CXFIELD);
			}	
		}
	}
	
	/**
	 * Reapplies stereotypes to fields of CXStruct and DDSMessage
	 * 
	 * @param element
	 * @return
	 */
	public static boolean reapplyFieldStereotypes(Element element) {
		Boolean stereotypeApplied = false;
		if (ZDLUtil.isZDLConcept(element, DDS4CCMNames.DDSMESSAGE)) {
			for (Element field : element.getOwnedElements()) {
				if(!ZDLUtil.isZDLConcept(field, CXDomainNames.CXFIELD)){
					continue;
				}
				Stereotype stereotype = field
						.getAppliedStereotype("cxDDS4CCM::CXField"); //$NON-NLS-1$
				if (stereotype != null) {
					field.unapplyStereotype(stereotype);
					ZDLUtil.addZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD);
					stereotypeApplied = true;
				} else {
					if (!ZDLUtil.isZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD)) {
						ZDLUtil.addZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD);
						stereotypeApplied = true;
					}
				}
			}
		} else if (ZDLUtil.isZDLConcept(element, CXDomainNames.CXSTRUCT)) {
			for (Element field : element.getOwnedElements()) {
				if(!ZDLUtil.isZDLConcept(field, CXDomainNames.CXFIELD)){
					continue;
				}
				Stereotype stereotype = field
						.getAppliedStereotype("cxDDS4CCM::MessageField"); //$NON-NLS-1$
				if (stereotype != null) {
					field.unapplyStereotype(stereotype);
					ZDLUtil.addZDLConcept(field, CXDomainNames.CXFIELD);
					stereotypeApplied = true;
				} else {
					if (!ZDLUtil.isZDLConcept(field, CXDomainNames.CXFIELD)) {
						ZDLUtil.addZDLConcept(field,
								CXDomainNames.CXFIELD);
						stereotypeApplied = true;
					}
				}
			}
		}
		return stereotypeApplied;
	}
	
	/**
	 * Remove register naming property from the given component
	 * 
	 * @param component
	 */
	public static void removeRegisterNamingProperty(Component component) {
		String modelType = DDS4CCMUtil.getModelType(component);
		
		Property p = component.getOwnedAttribute(PropertyVariable.REGISTER_NAMING.getName(modelType), null);
		if (p == null) {
			return;
		}
		Command cmd = BaseUtil.getDeleteCommand(Collections.singleton(p));
		if (cmd.canExecute()) {
			TransactionUtil.getEditingDomain(component).getCommandStack().execute(cmd);
		}
	}

	public static Status createStatus(String pluginId, int severity, String msg) {
		Status status = new Status(severity, pluginId, IStatus.OK, msg, null);
		return status;
	}

	public static String getPropertyName(String modelType, String propertyKey){
		String propertyName = ""; //$NON-NLS-1$
		PropertyVariable pv = PropertyVariable.valueOf(propertyKey);
		if(pv == null){
			return propertyName;
		}
		propertyName = pv.getName(modelType);		
		return propertyName;
	}
	/**
	 * Browse the containers of the given element for the root of the model and find out the model type    
	 * 
	 * @param model
	 * 			Element instance to be checked
	 * 
	 * @return modelType
	 *                    
	 */
	public static String getModelType(Element model){
		Model rootModel = null;
		while(model.getOwner()!=null){
			model = model.getOwner();
		}
		if(model instanceof Model){
			rootModel = (Model) model;
		}
		return getModelTypeValue(rootModel);
	}

	/**
	 * Get the type of a model: ATCD or AXCIOMA   
	 * 
	 * @param model
	 * 			model instance to be checked
	 * 
	 * @return modelType
	 *                    
	 */
	private static String getModelTypeValue(Model model){
		DDS4CCMModel contextModel =  ZDLFactoryRegistry.INSTANCE.create(model, DDS4CCMModel.class);
		return contextModel.getModelType().name();		
	}
	
	public static boolean isAsyncCapableConnector(String connectorType){
		ConnectorType ct = ConnectorType.valueOf(connectorType);
		return ct.isAsyncCapable();		
	}
	
	public static boolean isSyncCapableConnector(String connectorType){
		ConnectorType ct = ConnectorType.valueOf(connectorType);
		return ct.isSyncCapable();		
	}
	
	public static boolean isAssemblyConnector(Connector connector){
		return connector.getKind().equals(ConnectorKind.ASSEMBLY_LITERAL);
	}
	
	public static boolean isDelegationConnector(Connector connector){
		return connector.getKind().equals(ConnectorKind.DELEGATION_LITERAL);
	}
}
