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
package com.zeligsoft.cx.langc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Pointer</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.cx.langc.LangCPackage#getPointer()
 * @model
 * @generated
 */
@SuppressWarnings("nls")
public enum Pointer implements Enumerator {
	/**
	 * The '<em><b>Pointer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINTER_VALUE
	 * @generated
	 * @ordered
	 */
	POINTER(1, "pointer", "pointer"),

	/**
	 * The '<em><b>Const pointer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONST_POINTER_VALUE
	 * @generated
	 * @ordered
	 */
	CONST_POINTER(2, "const_pointer", "const_pointer"), /**
	 * The '<em><b>Invalid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVALID_VALUE
	 * @generated
	 * @ordered
	 */
	INVALID(0, "invalid", ""), /**
	 * The '<em><b>Volatile pointer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLATILE_POINTER_VALUE
	 * @generated
	 * @ordered
	 */
	VOLATILE_POINTER(0, "volatile_pointer", "volatile_pointer"), /**
	 * The '<em><b>Const volatile pointer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONST_VOLATILE_POINTER_VALUE
	 * @generated
	 * @ordered
	 */
	CONST_VOLATILE_POINTER(0, "const_volatile_pointer", "const_volatile_pointer");

	/**
	 * The '<em><b>Pointer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pointer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POINTER
	 * @model name="pointer"
	 * @generated
	 * @ordered
	 */
	public static final int POINTER_VALUE = 1;

	/**
	 * The '<em><b>Const pointer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Const pointer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONST_POINTER
	 * @model name="const_pointer"
	 * @generated
	 * @ordered
	 */
	public static final int CONST_POINTER_VALUE = 2;

	/**
	 * The '<em><b>Invalid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Invalid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVALID
	 * @model name="invalid" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int INVALID_VALUE = 0;

	/**
	 * The '<em><b>Volatile pointer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Volatile pointer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLATILE_POINTER
	 * @model name="volatile_pointer"
	 * @generated
	 * @ordered
	 */
	public static final int VOLATILE_POINTER_VALUE = 0;

	/**
	 * The '<em><b>Const volatile pointer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Const volatile pointer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONST_VOLATILE_POINTER
	 * @model name="const_volatile_pointer"
	 * @generated
	 * @ordered
	 */
	public static final int CONST_VOLATILE_POINTER_VALUE = 0;

	/**
	 * An array of all the '<em><b>Pointer</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Pointer[] VALUES_ARRAY =
		new Pointer[] {
			POINTER,
			CONST_POINTER,
			INVALID,
			VOLATILE_POINTER,
			CONST_VOLATILE_POINTER,
		};

	/**
	 * A public read-only list of all the '<em><b>Pointer</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Pointer> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Pointer</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Pointer result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pointer</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Pointer result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pointer</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer get(int value) {
		switch (value) {
			case POINTER_VALUE: return POINTER;
			case CONST_POINTER_VALUE: return CONST_POINTER;
			case INVALID_VALUE: return INVALID;
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
	private Pointer(int value, String name, String literal) {
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
	
} //Pointer
