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
package com.zeligsoft.base.zdl.ocl.stdlib;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Manager of the definitions and implementations of Zeligsoft extensions
 * (additional properties and attributes) of the OCL Standard Library types.
 * 
 * @author Christian W. Damus (Zeligsoft)
 */
public abstract class StandardLibraryExtender {

	/**
	 * A derived property that references the base element to which a stereotype
	 * application is attached. The star in the name ensures that it does not
	 * clash with any attribute name in the ZDL (because it couldn't possibly
	 * have parsed successfully).
	 */
	public static final String BASE_ELEMENT_PROPERTY = "*baseElement"; //$NON-NLS-1$

	/** Cache of properties that we have added to one or more environments. */
	static final Map<Property, PropertyCall<?>> properties = new java.util.WeakHashMap<Property, PropertyCall<?>>();

	/** Cache of operations that we have added to one or more environments. */
	static final Map<Operation, OperationCall<?>> operations = new java.util.WeakHashMap<Operation, OperationCall<?>>();

	/** The standard library instance that we are extending. */
	private OCLStandardLibrary<Classifier> stdlib;

	/** The resource set in which it is defined. */
	private ResourceSet rset;

	/**
	 * Initializes me.
	 * 
	 * @param stdlib
	 *            the standard library implementation that I extend
	 * @param rset
	 *            the resource set in which the standard library is being used
	 */
	public StandardLibraryExtender(OCLStandardLibrary<Classifier> stdlib,
			ResourceSet rset) {
		this.stdlib = stdlib;
		this.rset = rset;
	}

	/**
	 * Implemented by subclasses to add a newly-defined property to the
	 * environment that we are extending.
	 * 
	 * @param owner
	 *            the type on which we are defining the property
	 * @param property
	 *            the property that we are defining
	 */
	protected abstract void addProperty(Classifier owner, Property property);

	/**
	 * Implemented by subclasses to add a newly-defined operation to the
	 * environment that we are extending.
	 * 
	 * @param owner
	 *            the type on which we are defining the operation
	 * @param operation
	 *            the operation that we are defining
	 */
	protected abstract void addOperation(Classifier owner, Operation operation);

	/**
	 * Queries whether I handle navigation of a property. I handle navigation
	 * for properties that I have added to the standard library.
	 * 
	 * @param property
	 *            a property to be navigated
	 * @return whether the property is one that I have added to the standard
	 *         library
	 */
	public static boolean handles(Property property) {
		return properties.containsKey(property);
	}

	/**
	 * Performs the navigation of a property that I have added to the standard
	 * library.
	 * 
	 * @param source
	 *            the source object of the property navigation
	 * @param property
	 *            the property of the source to navigate
	 * @return the value of the property
	 */
	public static Object get(Object source, Property property) {
		return properties.get(property).call(source);
	}

	/**
	 * Queries whether I handle invocation of an operation. I handle calls to
	 * operations that I have added to the standard library.
	 * 
	 * @param operation
	 *            an operation to be called
	 * @return whether the operation is one that I have added to the standard
	 *         library
	 */
	public static boolean handles(Operation operation) {
		return operations.containsKey(operation);
	}

	/**
	 * Invokes an operation that I have added to the standard library.
	 * 
	 * @param source
	 *            the source of the operation-call expression, being the object
	 *            on which we invoke the operation
	 * @param args
	 *            the arguments (possibly an empty array) of the operation call
	 * @param operation
	 *            the operation to call
	 * @return the operation's return result. There is always a result, because
	 *         OCL can only define query operations, and these always have
	 *         results (otherwise they would not be queries)
	 */
	public static Object call(Object source, Object[] args, Operation operation) {
		return operations.get(operation).call(source, args);
	}

	/**
	 * Gets the UML metaclass (from the copy of the metamodel loaded into my
	 * resource set) that corresponds to the specified Ecore definition.
	 * 
	 * @param eclass
	 *            the Ecore definition of a UML metaclass
	 * @return the resource-set-local definition of the UML metaclass
	 */
	private Classifier getUMLMetaclass(EClass eclass) {
		return OCLUMLUtil.getClassifier(eclass, rset);
	}

	/**
	 * Adds the properties and operations that I contribute to the OCL Standard
	 * Library to the library that I extend.
	 */
	public void extend() {
		createBaseElement();
		createStringMatches();
		createStringReplaceAll();
	}

	/**
	 * Constructor for a property, including the call-back object that performs
	 * the navigation.
	 * 
	 * @param owner
	 *            the property's owner type
	 * @param name
	 *            the property name
	 * @param type
	 *            the property type
	 * @param handler
	 *            the navigation handler for the property
	 * @return the property
	 */
	private Property createProperty(Classifier owner, String name,
			Classifier type, PropertyCall<?> handler) {

		Property result = UMLFactory.eINSTANCE.createProperty();

		result.setName(name);
		result.setType(type);

		addProperty(owner, result);
		properties.put(result, handler);

		return result;
	}

	/**
	 * Constructor for an operation, including the call-back object that
	 * performs invocation.
	 * 
	 * @param owner
	 *            the operation's owner type
	 * @param name
	 *            the operation name
	 * @param type
	 *            the operation's return result type
	 * @param handler
	 *            the invocation handler for the operation
	 * @param parameters
	 *            a variable list of arguments specifying, pair-wise, the
	 *            parameter names ({@link String}) and types ({@link Type})
	 * @return the operation
	 */
	private Operation createOperation(Classifier owner, String name,
			Classifier type, OperationCall<?> handler, Object... parameters) {

		Operation result = UMLFactory.eINSTANCE.createOperation();

		result.setName(name);
		result.setType(type);
		result.setIsQuery(true); // required by OCL

		for (int i = 0; i < parameters.length; i += 2) {
			result.createOwnedParameter((String) parameters[i],
				(Type) parameters[i + 1]);
		}

		addOperation(owner, result);
		operations.put(result, handler);

		return result;
	}

	/**
	 * Creates the <tt>OclAny::*baseElement</tt> property.
	 */
	private void createBaseElement() {
		createProperty(stdlib.getOclAny(), BASE_ELEMENT_PROPERTY,
			getUMLMetaclass(UMLPackage.Literals.ELEMENT),
			new PropertyCall<Element>() {

				public Element call(Object source) {
					Element result;

					if (source instanceof Element) {
						// in the case that the expected type is a stereotype,
						// but the stereotype is not actually applied
						result = (Element) source;
					} else {
						return UMLUtil.getBaseElement((EObject) source);
					}

					return result;
				}
			});
	}

	/**
	 * Creates the <tt>String::matches(String)</tt> operation.
	 */
	private void createStringMatches() {

		createOperation(stdlib.getString(), "matches", stdlib.getBoolean(), //$NON-NLS-1$
			new OperationCall<Boolean>() {

				public Boolean call(Object source, Object[] args) {
					return StringOperations.matches((String) source,
						(String) args[0]);
				}
			}, "regex", stdlib.getString()); //$NON-NLS-1$
	}

	/**
	 * Creates the <tt>String::replaceAll(String, String)</tt> operation.
	 */
	private void createStringReplaceAll() {

		createOperation(stdlib.getString(), "replaceAll", stdlib.getString(), //$NON-NLS-1$
			new OperationCall<String>() {
				public String call(Object source, Object[] args) {
					return StringOperations.replaceAll((String) source, (String) args[0], (String) args[1]);
				}
			}, "regex", stdlib.getString() //$NON-NLS-1$
			 , "replacement", stdlib.getString()); //$NON-NLS-1$
	}

	/**
	 * A call-back interface for property navigation.
	 * 
	 * @param <T>
	 *            the property type
	 * 
	 * @author Christian W. Damus (Zeligsoft)
	 */
	private static interface PropertyCall<T> {

		/**
		 * Performs the property "call" (navigation).
		 * 
		 * @param source
		 *            the source object from which to navigate the property.
		 * 
		 * @return the property value
		 */
		T call(Object source);
	}

	/**
	 * A call-back interface for operation invocation.
	 * 
	 * @param <T>
	 *            the operation's result type
	 * 
	 * @author Christian W. Damus (Zeligsoft)
	 */
	private static interface OperationCall<T> {

		/**
		 * Performs the operation call.
		 * 
		 * @param source
		 *            the source object on which to invoke the operation
		 * @param args
		 *            the operation's arguments (may be an empty array)
		 * @return the value of the operation
		 */
		T call(Object source, Object[] args);
	}
}
