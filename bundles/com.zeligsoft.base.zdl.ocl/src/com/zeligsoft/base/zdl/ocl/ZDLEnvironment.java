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
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.utilities.UMLReflection;
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

import com.zeligsoft.base.zdl.ocl.stdlib.StandardLibraryExtender;

/**
 * A specialized UML environment for ZDL that defines additional attributes
 * and/or operations in support of the mapping of ZDL to UML profiles.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("deprecation")
public class ZDLEnvironment
		extends UMLEnvironment {

	/** Zeligsoft additions to the features of the OCL Standard Library types. */
	private StandardLibraryExtender stdlibExt;

	private ZDLReflection reflection;

	/**
	 * Initializes me with my parent, as a generic UML environment.
	 * 
	 * @param parent
	 *            my parent environment
	 */
	public ZDLEnvironment(
			Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent) {
		super(parent);
	}

	/**
	 * Initializes me with a factory that provides the Ecore package registry
	 * and resource set that I use to find UML models.
	 * 
	 * @param factory
	 *            the environment factory that created me
	 */
	public ZDLEnvironment(ZDLEnvironmentFactory factory) {
		super(factory.getEPackageRegistry(), factory.getResourceSet());

		setFactory(factory);
		initializeRootEnvironment();
	}

	/**
	 * Initializes the root environment of a ZDL environment hierarchy, creating
	 * the additional attributes and operations that it needs.
	 */
	private void initializeRootEnvironment() {
		stdlibExt = new StandardLibraryExtender(getOCLStandardLibrary(), getResourceSet()) {

			@Override
			protected void addProperty(Classifier owner, Property property) {
				ZDLEnvironment.this.addProperty(owner, property);
			}

			@Override
			protected void addOperation(Classifier owner, Operation operation) {
				ZDLEnvironment.this.addOperation(owner, operation);
			}
		};

		stdlibExt.extend();
	}

	/**
	 * Obtains my standard-library extender that adds cool features to the OCL
	 * Standard Library types.
	 * 
	 * @return my standard-library extender
	 */
	StandardLibraryExtender getStandardLibraryExtender() {
		if (getParent() instanceof ZDLEnvironment) {
			return ((ZDLEnvironment) getParent()).getStandardLibraryExtender();
		}

		return stdlibExt;
	}

	/**
	 * Obtains the <tt>OclAny::*baseElement</tt> property that navigates the
	 * from a stereotype application to its base element.
	 * 
	 * @return the base-element property
	 */
	Property getBaseElementProperty() {
		return lookupProperty(getOCLStandardLibrary().getOclAny(),
			StandardLibraryExtender.BASE_ELEMENT_PROPERTY);
	}

	/**
	 * Creates an {@link UMLReflection} instance tailored to dealing with the
	 * ZDL-to-profile mappings.
	 */
	@Override
	public UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
		if (reflection == null) {
			reflection = new ZDLReflection(super.getUMLReflection());
		}

		return reflection;
	}
}
