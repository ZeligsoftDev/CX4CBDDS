/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.creation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.ui.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A factory to instantiate arguments corresponding to Message signatures
 * The arguments are pre-filled with the right name and type, which
 * are extracted from the corresponding parameter
 *
 * @author Camille Letavernier
 */
public class MessageValueSpecificationFactory extends EcorePropertyEditorFactory {

	/**
	 * The message in which the arguments will be created
	 */
	protected Message parent;

	/**
	 * Indicates the liberty we let to the user.
	 * If set to true, he won't be able to instantiate invalid elements,
	 * ie. he cannot instantiate arguments which don't correspond to an
	 * operation's parameter.
	 */
	protected boolean restrictedInstantiation = false;

	/**
	 * The directions of the parameters we want to retain
	 */
	protected Set<ParameterDirectionKind> directions;

	/**
	 *
	 * Constructor.
	 *
	 * @param type
	 *            The type that will be instantiated
	 * @param parent
	 *            The parent Message
	 * @param directions
	 *            The directions of the parameters we want to retain
	 */
	public MessageValueSpecificationFactory(EReference reference, Message parent, Set<ParameterDirectionKind> directions) {
		super(reference);
		this.parent = parent;
		this.directions = directions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<EClass> getAvailableEClasses() {
		List<EClass> allClasses = EMFHelper.getSubclassesOf(type, true);
		List<EClass> result = new LinkedList<EClass>();
		for (EClass eClass : allClasses) {
			if (isValid(eClass)) {
				result.add(eClass);
			}
		}

		return result;
	}

	@Override
	protected Object doCreateObject(Control widget, Object context) {
		EClass eClass = chooseEClass(widget);
		if (eClass == null) {
			return null;
		}

		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (instance != null && instance instanceof NamedElement) {
			Parameter parameter = getParameter();
			if (parameter != null) {
				((NamedElement) instance).setName(parameter.getName());

				if (instance instanceof InstanceValue) {
					((InstanceValue) instance).setType(parameter.getType());
				}
			}
		}

		return createObject(widget, context, instance);
	}

	/**
	 * Tests if the given EClass can be instantiated for the following
	 * parameter
	 *
	 * @param eClass
	 *            The EClass to test
	 * @return
	 *         True if the EClass is a valid type for the next parameter
	 *
	 * @see #getParameter()
	 */
	protected boolean isValid(EClass eClass) {
		Parameter parameter = getParameter();
		if (parameter == null) {
			return !restrictedInstantiation;
		}

		Type parameterType = parameter.getType();
		if (parameterType instanceof PrimitiveType) {
			return isValidType(eClass, (PrimitiveType) parameterType);
		}

		if (parameterType instanceof Classifier) {
			return eClass == UMLPackage.eINSTANCE.getInstanceValue();
		}

		return !restrictedInstantiation; // The operation has no signature
	}

	/**
	 *
	 * @return the Operation corresponding to the message's signature,
	 *         or null if the message's signature is not an operation
	 */
	protected Operation getOperation() {
		NamedElement namedElement = parent.getSignature();

		if (namedElement instanceof Operation) {
			return (Operation) namedElement;
		}

		return null;
	}

	/**
	 *
	 * @return the next parameter from the operation. The next parameter
	 *         is the first operation's parameter that isn't matched by an argument
	 *         of the parent message.
	 *
	 * @see #getOperation()
	 */
	protected Parameter getParameter() {
		Operation operation = getOperation();
		if (operation == null) {
			return null;
		}

		int index = parent.getArguments().size();

		int i = 0;
		for (Parameter parameter : operation.getOwnedParameters()) {
			ParameterDirectionKind direction = parameter.getDirection();
			if (directions.contains(direction)) {
				if (i++ == index) {
					return parameter;
				}
			}
		}

		return null;
	}

	/**
	 * Tests if the given EClass is a valid type for the given PrimitiveType
	 * This test is pretty subjective, as it tries to associate a custom primitive
	 * type to a UML Literal type (or InstanceValue).
	 *
	 * For example, the UML "Literal Integer" can match the "Integer" or "int"
	 * primitive type, which means that an instance of the "Integer" Primitive
	 * Type is a valid value for a Literal Integer.
	 *
	 * @param eClass
	 *            A Subclass of InstanceSpecification
	 * @param parameterType
	 *            A PrimitiveType
	 * @return
	 *         True if an instance of the given PrimitiveType is a valid instance for the given eClass
	 */
	// TODO : To make this method a little more usable with custom primitive
	// types, and a little less subjective, the matching should be done through
	// an extension point or a local customization (preferences).
	// This currently works only with basic UML Primitive Types and standard
	// java-like types
	protected boolean isValidType(EClass eClass, PrimitiveType parameterType) {
		String typeName = parameterType.getName();

		// Integer numbers
		if (eClass == UMLPackage.eINSTANCE.getLiteralInteger() || eClass == UMLPackage.eINSTANCE.getLiteralUnlimitedNatural()) {
			return typeName.equals("Integer") || typeName.equals("int"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Can be used to instantiate anything, except integers and booleans
		if (eClass == UMLPackage.eINSTANCE.getLiteralString()) {
			return !(typeName.equals("Integer") || typeName.equals("int") || typeName.equals("Boolean") || typeName.equals("boolean")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		// Can be used to instantiate anything, except integers, booleans and strings
		if (eClass == UMLPackage.eINSTANCE.getInstanceValue()) {
			return !(typeName.equals("Integer") || typeName.equals("int") || typeName.equals("Boolean") || typeName.equals("boolean") || typeName.equals("String")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		}

		// Booleans
		if (eClass == UMLPackage.eINSTANCE.getLiteralBoolean()) {
			return typeName.equals("Boolean") || typeName.equals("boolean"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// We aren't interested in other InstanceSpecifications
		return false;
	}
}
