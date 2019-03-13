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
package com.zeligsoft.base.zdl.ocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;

/**
 * A factory for UML environment that are specialized for handling the
 * ZDL-to-profile mappings and the OCL transformations performed by the
 * {@link ZDLToProfileTransformation}.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLEnvironmentFactory
		extends UMLEnvironmentFactory {

	/**
	 * Initializes me.
	 */
	public ZDLEnvironmentFactory() {
		super();
	}

	/**
	 * Initializes me with the Ecore package registry and resource set that I
	 * use to find UML models.
	 * 
	 * @param registry
	 *            an Ecore package registry containing UML2-generated metamodels
	 * @param rset
	 *            a resource set containing UML models and profiles
	 */
	public ZDLEnvironmentFactory(EPackage.Registry registry, ResourceSet rset) {
		super(registry, rset);
	}

	/**
	 * Initializes me with the resource set that I use to find UML models.  I
	 * find UML2-generated Ecore metamodels in the static package registry.
	 * 
	 * @param rset
	 *            a resource set containing UML models and profiles
	 */
	public ZDLEnvironmentFactory(ResourceSet rset) {
		super(rset);
	}

	/**
	 * Creates a new root parsing environment for ZDL constraints.
	 */
	@Override
	public ZDLEnvironment createEnvironment() {
		return new ZDLEnvironment(this);
	}

	/**
	 * Creates a new nested parsing environment for ZDL constraints.
	 */
	@Override
	public ZDLEnvironment createEnvironment(
			Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent) {

		return new ZDLEnvironment(parent);
	}

	/**
	 * Creates a new root evaluation environment for ZDL constraints.
	 */
	@Override
	public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> createEvaluationEnvironment() {
		return new ZDLEvaluationEnvironment(this);
	}

	/**
	 * Creates a new nested evaluation environment for ZDL constraints.
	 */
	@Override
	public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> createEvaluationEnvironment(
			EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
		return new ZDLEvaluationEnvironment(parent);
	}
}
