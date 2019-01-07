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

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.codegen.io.IWritable;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>CV Qualifier</b></em>',
 * and utility methods for working with them.
 * @extends IWritable
 * <!-- end-user-doc -->
 * @see com.zeligsoft.cx.langc.LangCPackage#getCVQualifier()
 * @model
 * @generated
 */
@SuppressWarnings("nls")
public enum CVQualifier implements Enumerator, IWritable {
	/**
	 * The '<em><b>Const</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONST_VALUE
	 * @generated
	 * @ordered
	 */
	CONST(1, "const", "const"),

	/**
	 * The '<em><b>Volatile</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLATILE_VALUE
	 * @generated
	 * @ordered
	 */
	VOLATILE(2, "volatile", "volatile"), /**
	 * The '<em><b>Unqualified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNQUALIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNQUALIFIED(0, "unqualified", "unqualified");

	/**
	 * The '<em><b>Const</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Const</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONST
	 * @model name="const"
	 * @generated
	 * @ordered
	 */
	public static final int CONST_VALUE = 1;

	/**
	 * The '<em><b>Volatile</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Volatile</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLATILE
	 * @model name="volatile"
	 * @generated
	 * @ordered
	 */
	public static final int VOLATILE_VALUE = 2;

	/**
	 * The '<em><b>Unqualified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unqualified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNQUALIFIED
	 * @model name="unqualified"
	 * @generated
	 * @ordered
	 */
	public static final int UNQUALIFIED_VALUE = 0;

	/**
	 * An array of all the '<em><b>CV Qualifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CVQualifier[] VALUES_ARRAY =
		new CVQualifier[] {
			CONST,
			VOLATILE,
			UNQUALIFIED,
		};

	/**
	 * A public read-only list of all the '<em><b>CV Qualifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CVQualifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CV Qualifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CVQualifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CVQualifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CV Qualifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CVQualifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CVQualifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CV Qualifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CVQualifier get(int value) {
		switch (value) {
			case CONST_VALUE: return CONST;
			case VOLATILE_VALUE: return VOLATILE;
			case UNQUALIFIED_VALUE: return UNQUALIFIED;
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
	private CVQualifier(int value, String name, String literal) {
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

	public boolean write(CodeWriter code) {
		switch( this )
		{
		case CONST: return code.write( "const" );
		case VOLATILE: return code.write( "volatile" );
		default: return true;
		}
	}

} //CVQualifier
