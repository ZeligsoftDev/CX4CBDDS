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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter;

/**
 * This class allows to receive notification for derived subset feature, according to the UML bug 394623
 * the following features are managed :
 * <ul>
 * <li>Class::superClass -> Classifier::generalization</li>
 * <li>Classifier::general -> Classifier::generalization</li>
 * <li>EncapsulatedClassifier::ownedPort -> StructuredClassifier::ownedAttribute</li>
 * <li>Package::nestedPackage -> Package::packagedElement</li>
 * <li>Package::ownedStereotype -> Package::packagedElement</li>
 * <li>Package::ownedType -> Package::packagedElement</li>
 * </ul>
 * .
 * Unfortunately, the main part of the derived features, referenced in the bug 394623 are not managed by this class
 *
 * @author Vincent Lorenzo
 *
 *         This class has not been generated
 */
public class PapyrusUMLDerivedSubsetAdapter extends UMLDerivedUnionAdapter {

	/**
	 * This method has been used to write in the console the text for the 3 managed EClass.
	 *
	 * @param eClass
	 *            the e class
	 */
	private static final void writeAllSubTypeMethodInConsole(final EClass eClass) {
		List<EClass> subType = new ArrayList<EClass>();
		for (EClassifier current : UMLPackage.eINSTANCE.getEClassifiers()) {
			if (current instanceof EClass) {
				if (eClass.isSuperTypeOf((EClass) current)) {
					if (!((EClass) current).isAbstract() && !((EClass) current).isInterface()) {
						subType.add((EClass) current);
					}
				}
			}
		}

		for (EClass current : subType) {
			String name = current.getName();
			String methodeName = "notify" + name + "Changed"; //$NON-NLS-1$ //$NON-NLS-2$
			System.out.println("@Override\n protected void " + methodeName + "(Notification notification, EClass eClass){"); //$NON-NLS-1$ //$NON-NLS-2$
			System.out.println("super." + methodeName + "(notification,eClass);"); //$NON-NLS-1$ //$NON-NLS-2$
			System.out.println("switch(notification.getFeatureID(org.eclipse.uml2.uml." + name + ".class)) {\n"); //$NON-NLS-1$ //$NON-NLS-2$
			if (eClass == UMLPackage.eINSTANCE.getClassifier()) {
				System.out
						.println("case UMLPackage.CLASSIFIER__GENERALIZATION: \n notifyChanged(notification, eClass, UMLPackage.Literals.CLASS__SUPER_CLASS); \n break; \n case UMLPackage.CLASSIFIER__GENERAL:notifyChanged(notification, eClass, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);\n"); //$NON-NLS-1$
			}
			if (eClass == UMLPackage.eINSTANCE.getStructuredClassifier()) {
				System.out.println("case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE: \n 	notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);"); //$NON-NLS-1$
			}
			if (eClass == UMLPackage.eINSTANCE.getPackage()) {
				System.out
						.println("case UMLPackage.PACKAGE__PACKAGED_ELEMENT:\n notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);\n notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE); \n notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);\n"); //$NON-NLS-1$
			}
			System.out.println("break; \n default:break;\n break;\n}}"); //$NON-NLS-1$
		}
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyActivityChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyActorChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyArtifactChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyAssociationChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyAssociationClassChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyClassChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyCollaborationChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyCommunicationPathChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyComponentChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyDataTypeChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyDeploymentSpecificationChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyDeviceChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyEnumerationChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyExecutionEnvironmentChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyExtensionChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyFunctionBehaviorChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyInformationItemChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyInteractionChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyInterfaceChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyNodeChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyOpaqueBehaviorChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyPrimitiveTypeChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyProtocolStateMachineChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifySignalChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyStateMachineChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyStereotypeChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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
		case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE:
			notifyChanged(notification, eClass, UMLPackage.Literals.ENCAPSULATED_CLASSIFIER__OWNED_PORT);
			break;
		default:
			break;
		}
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyUseCaseChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

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

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyPackageChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

	@Override
	protected void notifyPackageChanged(Notification notification, EClass eClass) {
		super.notifyPackageChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Package.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyProfileChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

	@Override
	protected void notifyProfileChanged(Notification notification, EClass eClass) {
		super.notifyProfileChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Profile.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter#notifyModelChanged(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EClass)
	 *
	 * @param notification
	 * @param eClass
	 */

	@Override
	protected void notifyModelChanged(Notification notification, EClass eClass) {
		super.notifyModelChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Model.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}


}
