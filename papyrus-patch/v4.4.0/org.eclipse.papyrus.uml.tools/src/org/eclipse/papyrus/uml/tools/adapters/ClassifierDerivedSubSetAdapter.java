/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.adapters;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter;

/**
 *
 * @see for generation see {@link PapyrusUMLDerivedSubsetAdapter} This adapter allows to receive the notifications of the following derived subset
 *      features :
 *      <ul>
 *      <li>UMLPackage.Literals.CLASS__SUPER_CLASS</li>
 *      <li>UMLPackage.Literals.CLASSIFIER__GENERALIZATION</li>
 *      </ul>
 *
 * @author Vincent Lorenzo
 *
 */
public class ClassifierDerivedSubSetAdapter extends UMLDerivedUnionAdapter {

	@Override
	protected void notifyStereotypeChanged(Notification notification, EClass eClass) {
		super.notifyStereotypeChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Stereotype.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyClassChanged(Notification notification, EClass eClass) {
		super.notifyClassChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Class.class)) {

		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyExtensionChanged(Notification notification, EClass eClass) {
		super.notifyExtensionChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Extension.class)) {

		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyAssociationChanged(Notification notification, EClass eClass) {
		super.notifyAssociationChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Association.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyDeploymentSpecificationChanged(Notification notification, EClass eClass) {
		super.notifyDeploymentSpecificationChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.DeploymentSpecification.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyArtifactChanged(Notification notification, EClass eClass) {
		super.notifyArtifactChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Artifact.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyInterfaceChanged(Notification notification, EClass eClass) {
		super.notifyInterfaceChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Interface.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifySignalChanged(Notification notification, EClass eClass) {
		super.notifySignalChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Signal.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyProtocolStateMachineChanged(Notification notification, EClass eClass) {
		super.notifyProtocolStateMachineChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.ProtocolStateMachine.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);

			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyStateMachineChanged(Notification notification, EClass eClass) {
		super.notifyStateMachineChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.StateMachine.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyDataTypeChanged(Notification notification, EClass eClass) {
		super.notifyDataTypeChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.DataType.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyEnumerationChanged(Notification notification, EClass eClass) {
		super.notifyEnumerationChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Enumeration.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyPrimitiveTypeChanged(Notification notification, EClass eClass) {
		super.notifyPrimitiveTypeChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.PrimitiveType.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyCollaborationChanged(Notification notification, EClass eClass) {
		super.notifyCollaborationChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Collaboration.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyUseCaseChanged(Notification notification, EClass eClass) {
		super.notifyUseCaseChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.UseCase.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyActivityChanged(Notification notification, EClass eClass) {
		super.notifyActivityChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Activity.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyInteractionChanged(Notification notification, EClass eClass) {
		super.notifyInteractionChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Interaction.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyActorChanged(Notification notification, EClass eClass) {
		super.notifyActorChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Actor.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyAssociationClassChanged(Notification notification, EClass eClass) {
		super.notifyAssociationClassChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.AssociationClass.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyCommunicationPathChanged(Notification notification, EClass eClass) {
		super.notifyCommunicationPathChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.CommunicationPath.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyComponentChanged(Notification notification, EClass eClass) {
		super.notifyComponentChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Component.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyDeviceChanged(Notification notification, EClass eClass) {
		super.notifyDeviceChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Device.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyNodeChanged(Notification notification, EClass eClass) {
		super.notifyNodeChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Node.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyExecutionEnvironmentChanged(Notification notification, EClass eClass) {
		super.notifyExecutionEnvironmentChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.ExecutionEnvironment.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyFunctionBehaviorChanged(Notification notification, EClass eClass) {
		super.notifyFunctionBehaviorChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.FunctionBehavior.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyOpaqueBehaviorChanged(Notification notification, EClass eClass) {
		super.notifyOpaqueBehaviorChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.OpaqueBehavior.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyInformationItemChanged(Notification notification, EClass eClass) {
		super.notifyInformationItemChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.InformationItem.class)) {
		case UMLPackage.CLASSIFIER__GENERALIZATION:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS);
			break;
		case UMLPackage.CLASSIFIER__GENERAL:
			notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
			break;
		default:
			break;
		}
	}

}
