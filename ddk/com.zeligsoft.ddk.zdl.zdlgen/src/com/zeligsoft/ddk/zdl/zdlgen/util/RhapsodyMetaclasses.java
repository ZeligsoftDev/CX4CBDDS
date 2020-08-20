/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author prismtech
 *
 */
public final class RhapsodyMetaclasses {
	private RhapsodyMetaclasses() {
		//nothing to do
	}
	
	public static final String ACCEPT_EVENT_ACTION = "AcceptEventAction"; //$NON-NLS-1$
	public static final String ACCEPT_TIME_EVENT = "AcceptTimeEvent"; //$NON-NLS-1$
	public static final String ACTIVITY_DIAGRAM = "ActivityDiagram"; //$NON-NLS-1$
	public static final String ACTOR = "Actor"; //$NON-NLS-1$
	public static final String ARGUMENT = "Argument"; //$NON-NLS-1$
	public static final String ASSOCIATION = "Association"; //$NON-NLS-1$
	public static final String ASSOCIATION_END = "AssociationEnd"; //$NON-NLS-1$
	public static final String ATTRIBUTE = "Attribute"; //$NON-NLS-1$
	public static final String CALL_OPERATION = "CallOperation"; //$NON-NLS-1$
	public static final String CLASS = "Class"; //$NON-NLS-1$
	public static final String CLASSIFIER_ROLE = "ClassifierRole"; //$NON-NLS-1$
	public static final String CLEANUP = "Cleanup"; //$NON-NLS-1$
	public static final String COMBINED_FRAGMENT = "CombinedFragment"; //$NON-NLS-1$
	public static final String COMMENT = "Comment"; //$NON-NLS-1$
	public static final String COMMUNICATION_DIAGRAM = "CommunicationDiagram"; //$NON-NLS-1$
	public static final String COMPONENT = "Component"; //$NON-NLS-1$
	public static final String COMPONENT_DIAGRAM = "ComponentDiagram"; //$NON-NLS-1$
	public static final String COMPONENT_INSTANCE = "ComponentInstance"; //$NON-NLS-1$
	public static final String CONDITION = "Condition"; //$NON-NLS-1$
	public static final String CONFIGURATION = "Configuration"; //$NON-NLS-1$
	public static final String CONNECTOR = "Connector"; //$NON-NLS-1$
	public static final String CONSTRAINT = "Constraint"; //$NON-NLS-1$
	public static final String CONSTRUCTOR = "Constructor"; //$NON-NLS-1$
	public static final String CONTROLLED_FILE = "ControlledFile"; //$NON-NLS-1$
	public static final String DEFAULT_TRANSITION = "DefaultTransition"; //$NON-NLS-1$
	public static final String DEPENDENCY = "Dependency"; //$NON-NLS-1$
	public static final String DEPLOYMENT_DIAGRAM = "DeploymentDiagram"; //$NON-NLS-1$
	public static final String DESTRUCTOR = "Destructor"; //$NON-NLS-1$
	public static final String ENUMERATION_LITERAL = "EnumerationLiteral"; //$NON-NLS-1$
	public static final String EVENT = "Event"; //$NON-NLS-1$
	public static final String EXECUTION_OCCURRENCE = "ExecutionOccurrence"; //$NON-NLS-1$
	public static final String FILE = "File"; //$NON-NLS-1$
	public static final String FLOW = "Flow"; //$NON-NLS-1$
	public static final String FOLDER = "Folder"; //$NON-NLS-1$
	public static final String GENERALIZATION = "Generalization"; //$NON-NLS-1$
	public static final String HYPERLINK = "HyperLink"; //$NON-NLS-1$
	public static final String INITIALIZER = "Initializer"; //$NON-NLS-1$
	public static final String INSTANCESLOT = "InstanceSlot"; //$NON-NLS-1$
	public static final String INSTANCE_SPECIFICATION = "InstanceSpecification"; //$NON-NLS-1$
	public static final String INTERACTION_OCCURRENCE = "InteractionOccurrence"; //$NON-NLS-1$
	public static final String INTERACTION_OPERAND = "InteractionOperand"; //$NON-NLS-1$
	public static final String ITEM_FLOW = "ItemFlow"; //$NON-NLS-1$
	public static final String LINK = "Link"; //$NON-NLS-1$
	public static final String MATRIX_LAYOUT = "MatrixLayout"; //$NON-NLS-1$
	public static final String MATRIX_VIEW = "MatrixView"; //$NON-NLS-1$
	public static final String MESSAGE = "Message"; //$NON-NLS-1$
	public static final String MODULE = "Module"; //$NON-NLS-1$
	public static final String NODE = "Node"; //$NON-NLS-1$
	public static final String OBJECT = "Object"; //$NON-NLS-1$
	public static final String OBJECT_MODEL_DIAGRAM = "ObjectModelDiagram"; //$NON-NLS-1$
	public static final String OBJECT_NODE = "ObjectNode"; //$NON-NLS-1$
	public static final String OPERATION = "Operation"; //$NON-NLS-1$
	public static final String PACKAGE = "Package"; //$NON-NLS-1$
	public static final String PANEL_DIAGRAM = "PanelDiagram"; //$NON-NLS-1$
	public static final String PIN = "Pin"; //$NON-NLS-1$
	public static final String PORT = "Port"; //$NON-NLS-1$
	public static final String PROFILE = "Profile"; //$NON-NLS-1$
	public static final String PROJECT = "Project"; //$NON-NLS-1$
	public static final String RECEPTION = "Reception"; //$NON-NLS-1$
	public static final String REFERENCE_ACTIVITY = "ReferenceActivity"; //$NON-NLS-1$
	public static final String REQUIREMENT = "Requirement"; //$NON-NLS-1$
	public static final String SEQUENCE_DIAGRAM = "SequenceDiagram"; //$NON-NLS-1$
	public static final String STATE = "State"; //$NON-NLS-1$
	public static final String STATECHART = "Statechart"; //$NON-NLS-1$
	public static final String STEREOTYPE = "Stereotype"; //$NON-NLS-1$
	public static final String STRUCTURE_DIAGRAM = "StructureDiagram"; //$NON-NLS-1$
	public static final String SWIMLANE = "Swimlane"; //$NON-NLS-1$
	public static final String SYSML_PORT = "SysMLPort"; //$NON-NLS-1$
	public static final String TABLE_LAYOUT = "TableLayout"; //$NON-NLS-1$
	public static final String TABLE_VIEW = "TableView"; //$NON-NLS-1$
	public static final String TAG = "Tag"; //$NON-NLS-1$
	public static final String TRANSITION = "Transition"; //$NON-NLS-1$
	public static final String TRIGGERED_OPERATION = "TriggeredOperation"; //$NON-NLS-1$
	public static final String TYPE = "Type"; //$NON-NLS-1$
	public static final String TEMPLATEPARAMETER = "TemplateParameter"; //$NON-NLS-1$
	public static final String USE_CASE = "UseCase"; //$NON-NLS-1$
	public static final String USE_CASE_DIAGRAM = "UseCaseDiagram"; //$NON-NLS-1$
	
	public static final List<String> METACLASSES = Arrays.asList(
			ACCEPT_EVENT_ACTION,
			 ACCEPT_TIME_EVENT,
			 ACTIVITY_DIAGRAM,
			 ACTOR,
			 ARGUMENT,
			 ASSOCIATION,
			 ASSOCIATION_END,
			 ATTRIBUTE,
			 CALL_OPERATION,
			 CLASS,
			 CLASSIFIER_ROLE,
			 CLEANUP,
			 COMBINED_FRAGMENT,
			 COMMENT,
			 COMMUNICATION_DIAGRAM,
			 COMPONENT,
			 COMPONENT_DIAGRAM,
			 COMPONENT_INSTANCE,
			 CONDITION,
			 CONFIGURATION,
			 CONNECTOR,
			 CONSTRAINT,
			 CONSTRUCTOR,
			 CONTROLLED_FILE,
			 DEFAULT_TRANSITION,
			 DEPENDENCY,
			 DEPLOYMENT_DIAGRAM,
			 DESTRUCTOR,
			 ENUMERATION_LITERAL,
			 EVENT,
			 EXECUTION_OCCURRENCE,
			 FILE,
			 FLOW,
			 FOLDER,
			 GENERALIZATION,
			 HYPERLINK,
			 INITIALIZER,
			 INSTANCESLOT,
			 INSTANCE_SPECIFICATION,
			 INTERACTION_OCCURRENCE,
			 INTERACTION_OPERAND,
			 ITEM_FLOW,
			 LINK,
			 MATRIX_LAYOUT,
			 MATRIX_VIEW,
			 MESSAGE,
			 MODULE,
			 NODE,
			 OBJECT,
			 OBJECT_MODEL_DIAGRAM,
			 OBJECT_NODE,
			 OPERATION,
			 PACKAGE,
			 PANEL_DIAGRAM,
			 PIN,
			 PORT,
			 PROFILE,
			 PROJECT,
			 RECEPTION,
			 REFERENCE_ACTIVITY,
			 REQUIREMENT,
			 SEQUENCE_DIAGRAM,
			 STATE,
			 STATECHART,
			 STEREOTYPE,
			 STRUCTURE_DIAGRAM,
			 SWIMLANE,
			 SYSML_PORT,
			 TABLE_LAYOUT,
			 TABLE_VIEW,
			 TAG,
			 TRANSITION,
			 TRIGGERED_OPERATION,
			 TYPE,
			 USE_CASE,
			 USE_CASE_DIAGRAM,
			 TEMPLATEPARAMETER
			);

}
