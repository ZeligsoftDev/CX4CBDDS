/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Implementation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getImplementationType()
 * @model extendedMetaData="name='implementation_._type'"
 * @generated
 */
public enum ImplementationType implements Enumerator {
	/**
	 * The '<em><b>Scalar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCALAR_VALUE
	 * @generated
	 * @ordered
	 */
	SCALAR(0, "scalar", "scalar"),

	/**
	 * The '<em><b>Array</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	ARRAY(1, "array", "array"),

	/**
	 * The '<em><b>Circular Buffer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCULAR_BUFFER(2, "circularBuffer", "circular_buffer"),

	/**
	 * The '<em><b>Circular Buffer Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_BUFFER_BUS_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCULAR_BUFFER_BUS(3, "circularBufferBus", "circular_buffer_bus");

	/**
	 * The '<em><b>Scalar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scalar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCALAR
	 * @model name="scalar"
	 * @generated
	 * @ordered
	 */
	public static final int SCALAR_VALUE = 0;

	/**
	 * The '<em><b>Array</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Array</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARRAY
	 * @model name="array"
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_VALUE = 1;

	/**
	 * The '<em><b>Circular Buffer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Circular Buffer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_BUFFER
	 * @model name="circularBuffer" literal="circular_buffer"
	 * @generated
	 * @ordered
	 */
	public static final int CIRCULAR_BUFFER_VALUE = 2;

	/**
	 * The '<em><b>Circular Buffer Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Circular Buffer Bus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_BUFFER_BUS
	 * @model name="circularBufferBus" literal="circular_buffer_bus"
	 * @generated
	 * @ordered
	 */
	public static final int CIRCULAR_BUFFER_BUS_VALUE = 3;

	/**
	 * An array of all the '<em><b>Implementation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImplementationType[] VALUES_ARRAY =
		new ImplementationType[] {
			SCALAR,
			ARRAY,
			CIRCULAR_BUFFER,
			CIRCULAR_BUFFER_BUS,
		};

	/**
	 * A public read-only list of all the '<em><b>Implementation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImplementationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Implementation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImplementationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Implementation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImplementationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Implementation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationType get(int value) {
		switch (value) {
			case SCALAR_VALUE: return SCALAR;
			case ARRAY_VALUE: return ARRAY;
			case CIRCULAR_BUFFER_VALUE: return CIRCULAR_BUFFER;
			case CIRCULAR_BUFFER_BUS_VALUE: return CIRCULAR_BUFFER_BUS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ImplementationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ImplementationType
