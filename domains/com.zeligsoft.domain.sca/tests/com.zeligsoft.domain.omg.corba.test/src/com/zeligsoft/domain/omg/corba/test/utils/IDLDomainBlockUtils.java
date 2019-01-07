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
package com.zeligsoft.domain.omg.corba.test.utils;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A set of utility functions for working with a profile that contains the CORBA domain
 * concepts. It needs a reference to the profile that contains the concepts as well
 * as a model library with the primitive types.
 * 
 * @author tobymcclean
 *
 */
public class IDLDomainBlockUtils {
	
	protected Profile idlProfile;
	
	protected Model idlPrimitivesLibrary;
	
	/**
	 * @param scaProfile The profile that contains the idl concepts.
	 */
	public IDLDomainBlockUtils(Profile idlProfile, Model idlPrimitivesLibrary) {
		super();
		this.idlProfile = idlProfile;
		this.idlPrimitivesLibrary = idlPrimitivesLibrary;
	}

	protected Profile getIDLProfile() {
		return idlProfile;
	}
	
	protected void setIDLProfile(Profile idlProfile) {
		this.idlProfile = idlProfile;
	}
	
	protected Model getIdlPrimitivesLibrary() {
		return idlPrimitivesLibrary;
	}
	
	/**
	 * Create a new IDLFile in the provided container.
	 * 
	 * @param container The container to create the new file in
	 * @param name The name of the new file
	 * @return The newly created IDLFile
	 */
	public Package createIDLFile(Package container, String name) {
		Package newPackage = container.createNestedPackage(name);
		newPackage.applyStereotype(idlProfile.getOwnedStereotype("IDLFile")); //$NON-NLS-1$
		return newPackage;
	}

	/**
	 * Create a CorbaModule in the provided container.
	 * 
	 * @param container The container to create the new module in
	 * @param name The name of the new module
	 * @return The new CORBAModule
	 */
	public Package createCORBAModule(Package container, String name) {
		Package newPackage = container.createNestedPackage(name);
		newPackage.applyStereotype(idlProfile.getOwnedStereotype("CORBAModule")); //$NON-NLS-1$
		return newPackage;
	}

	/**
	 * Create a CorbaInterface in the provided container.
	 * 
	 * @param container The container to create the interface in
	 * @param name The name of the new interface
	 * @return The new interface that was created
	 */
	public org.eclipse.uml2.uml.Interface createCORBAInterface(
			Package container, String name) {
		org.eclipse.uml2.uml.Interface newInterface = 
			(org.eclipse.uml2.uml.Interface) container
				.createPackagedElement(name, UMLPackage.Literals.INTERFACE);
		newInterface.applyStereotype(idlProfile.getOwnedStereotype("CORBAInterface")); //$NON-NLS-1$
		return newInterface;
	}
	
	/**
	 * Create an attribute (Property) on the container object.
	 * 
	 * @param container The element to add the attribute to
	 * @param name The name of the new attribute to be added
	 * @return The newly created attribute
	 */
	public Property createCORBAAttribute(
			org.eclipse.uml2.uml.Interface container, String name) {
		return createCORBAAttribute(container, name, null);
	}
	
	/**
	 * Create an attribute (Property) on the container object.
	 * 
	 * @param container The element to add the attribute to
	 * @param name The name of the new attribute to be added
	 * @param primitiveType A string name of the primitive type
	 * @return The newly created attribute
	 * @throws Exception
	 */
	public Property createCORBAAttributeWithPrimitiveType(
			org.eclipse.uml2.uml.Interface container, String name, String primitiveType) throws Exception {
		org.eclipse.uml2.uml.Type pType = this.getIdlPrimitivesLibrary().getOwnedType(primitiveType);
		
		return createCORBAAttribute(container, name, pType);
	}
	
	/**
	 * Create an attribute (Property) on the container object.
	 * 
	 * @param container The element to add the attribute to
	 * @param name The name of the new attribute to be added
	 * @param type The initial type of the attribute
	 * @return The newly created attribute
	 */
	protected Property createCORBAAttribute(
			org.eclipse.uml2.uml.Interface container, String name, org.eclipse.uml2.uml.Type type) {
		return container.createOwnedAttribute(name, type);
	}
	
	/**
	 * Creates a relationship between a more general (base) Interface
	 * and a more specialized (sub) Interface.
	 * 
	 * specialized ---|> general
	 * 
	 * @param general The more general interface
	 * @param special The more specialized interface
	 */
	public void specializeCORBAInterface(org.eclipse.uml2.uml.Interface general,
			org.eclipse.uml2.uml.Interface special) {
		special.createGeneralization(general);
	}
	
	/**
	 * Creates a new operation in the provided container, with the
	 * provided name and that returns the provided returnType
	 * 
	 * @param container The element to add the CorbaOperation to
	 * @param name The name of the new operation
	 * @param returnType The return type of the new operation
	 * @return The newly created CorbaOperation
	 */
	public Operation createCORBAOperation(
			org.eclipse.uml2.uml.Interface container, String name, org.eclipse.uml2.uml.Type returnType) {
		return container.createOwnedOperation(name, null, null, returnType);
	}
	
	/**
	 * Creates a new operation in the provided container, with the
	 * provided name and that has a null return type
	 * 
	 * @param container The element to add the CorbaOperation to
	 * @param name The name of the new operation
	 * @return The newly created CorbaOperation with a null return type
	 */
	public Operation createCORBAOperation(
			org.eclipse.uml2.uml.Interface container, String name) {
		return createCORBAOperation(container, name, null);
	}
	
	/**
	 * Create a new parameter in the provided container and return it to the caller.
	 * 
	 * @param container The element to add the parameter to
	 * @param name The name of the new parameter
	 * @param type The type of the new parameter or null
	 * @return The newly created parameter
	 */
	public Parameter createCORBAParameter(Operation container, String name, org.eclipse.uml2.uml.Type type){
		return createCORBAParameter(container, name, type, ParameterDirectionKind.IN_LITERAL);
	}

	/**
	 * Create a new parameter in the provided container and return it to the caller.
	 * 
	 * @param container The element to add the parameter to
	 * @param name The name of the new parameter
	 * @param type The type of the new parameter or null
	 * @param direction The direction of the parameter
	 * @return The newly created parameter
	 */
	public Parameter createCORBAParameter(Operation container, String name, org.eclipse.uml2.uml.Type type, ParameterDirectionKind direction){
		Parameter newParameter = container.createOwnedParameter(name, type);
		newParameter.setDirection(direction);
		return newParameter;
	}

	/**
	 * Create a new parameter in the provided container and return it to the caller.
	 * The parameter will have a null type.
	 * 
	 * @param container The element to add the parameter to
	 * @param name The name of the new parameter
	 * @return The newly created parameter
	 */
	public Parameter createCORBAParameter(Operation container, String name){
		return createCORBAParameter(container, name, null, ParameterDirectionKind.IN_LITERAL);
	}
	
	/**
	 * Create a new parameter in the provided container a return it to the caller.
	 * The parameter will have the IDL primitive type passed in as a string.
	 * 
	 * @param container
	 * 			The element to add the parameter to
	 * @param name
	 * 			The name of the new parameter
	 * @param primitiveType
	 * 			The IDL primitive type to use for the type of the parameter
	 * @return The newly created parameter
	 * @throws Exception
	 */
	public Parameter createCORBAParameterWithPrimtive(Operation container, String name, String primitiveType) 
		throws Exception {
			return createCORBAParameterWithPrimtive(container, name,
					primitiveType, ParameterDirectionKind.IN_LITERAL);
		}

	/**
	 * Create a new parameter in the provided container a return it to the caller.
	 * The parameter will have the IDL primitive type passed in as a string.
	 * 
	 * @param container
	 * 			The element to add the parameter to
	 * @param name
	 * 			The name of the new parameter
	 * @param primitiveType
	 * 			The IDL primitive type to use for the type of the parameter
	 * @param direction 
	 * 			The direction of the new CORBAParamter
	 * @return The newly created parameter
	 * @throws Exception
	 */
	public Parameter createCORBAParameterWithPrimtive(Operation container, String name, String primitiveType, ParameterDirectionKind direction) 
		throws Exception {
		org.eclipse.uml2.uml.Type pType = this.getIdlPrimitivesLibrary().getOwnedType(primitiveType);
		
		return createCORBAParameter(container, name, pType, direction);
	}
	
	/**
	 * Create a CorbaException and return it to the caller
	 * @param container The element that will contain the newly created CorbaException
	 * @param name The name of the new CorbaException
	 * @return The newly created CorbaException
	 */
	public DataType createCORBAException(Package container, String name) {
		DataType newDataType = 
			(DataType) container.createOwnedType(name, UMLPackage.Literals.DATA_TYPE);
		newDataType.applyStereotype(idlProfile.getOwnedStereotype("CORBAException")); //$NON-NLS-1$
		return newDataType;
	}
	
	/**
	 * Create a CorbaException and return it to the caller
	 * @param container The element that will contain the newly created CorbaException
	 * @param name The name of the new CorbaException
	 * @return The newly created CorbaException
	 */
	public DataType createCORBAException(org.eclipse.uml2.uml.Interface container, String name) {
		DataType newDataType = 
			(DataType) container.createNestedClassifier(name, UMLPackage.Literals.DATA_TYPE);
		newDataType.applyStereotype(idlProfile.getOwnedStereotype("CORBAException")); //$NON-NLS-1$
		return newDataType;
	}

	/**
	 * Create a CORBAConst in the provided container and return it to the caller.
	 * 
	 * @param container
	 * 			The element to add the constant to
	 * @param constName
	 * 			The name of the new constant
	 * @param constValue
	 * 			The value that will be assigned to the constant
	 * @param primitiveType
	 * 			The type of the constant, which is a string representing the name of a CORBA primitive
	 * @return
	 * 			The newly created CORBAConstant
	 */
	public Property createCORBAConstantUsingPrimitive(Interface container,
			String constName, String constValue, String primitiveType) {
		org.eclipse.uml2.uml.Type pType = this.getIdlPrimitivesLibrary().getOwnedType(primitiveType);
		
		Property newConstant = container.createOwnedAttribute(constName, pType);
		newConstant.applyStereotype(idlProfile.getOwnedStereotype("CORBAConstant")); //$NON-NLS-1$
		
		OpaqueExpression expr = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOpaqueExpression();
		expr.getBodies().add(constValue);
		expr.getLanguages().add("IDL"); //$NON-NLS-1$
		newConstant.setDefaultValue(expr);
		
		return newConstant;
	}
}
