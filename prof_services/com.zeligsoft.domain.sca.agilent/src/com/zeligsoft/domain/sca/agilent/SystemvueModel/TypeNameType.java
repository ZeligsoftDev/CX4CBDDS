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
 * A representation of the literals of the enumeration '<em><b>Type Name Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getTypeNameType()
 * @model extendedMetaData="name='type_name_._type'"
 * @generated
 */
public enum TypeNameType implements Enumerator {
	/**
	 * The '<em><b>Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(0, "int", "int"),

	/**
	 * The '<em><b>Bool</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	BOOL(1, "bool", "bool"),

	/**
	 * The '<em><b>Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT(2, "float", "float"),

	/**
	 * The '<em><b>Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE(3, "double", "double"),

	/**
	 * The '<em><b>Std Complex Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STD_COMPLEX_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	STD_COMPLEX_DOUBLE(4, "stdComplexDouble", "std::complex_double_"),

	/**
	 * The '<em><b>Std Complex Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STD_COMPLEX_FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	STD_COMPLEX_FLOAT(5, "stdComplexFloat", "std::complex_float_"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Bool</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_BOOL(6, "AgilentEEsofMatrixBool", "AgilentEEsof::Matrix_bool_"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_INT_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_INT(7, "AgilentEEsofMatrixInt", "AgilentEEsof::Matrix_int_"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_DOUBLE(8, "AgilentEEsofMatrixDouble", "AgilentEEsof::Matrix_double_"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Std Complex Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE(9, "AgilentEEsofMatrixStdComplexDouble", "AgilentEEsof::Matrix_std::complex_double__"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_FLOAT(10, "AgilentEEsofMatrixFloat", "AgilentEEsof::Matrix_float_"),

	/**
	 * The '<em><b>Agilent EEsof Matrix Std Complex Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT(11, "AgilentEEsofMatrixStdComplexFloat", "AgilentEEsof::Matrix_std::complex_float__");

	/**
	 * The '<em><b>Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @model name="int"
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 0;

	/**
	 * The '<em><b>Bool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOL
	 * @model name="bool"
	 * @generated
	 * @ordered
	 */
	public static final int BOOL_VALUE = 1;

	/**
	 * The '<em><b>Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOAT
	 * @model name="float"
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_VALUE = 2;

	/**
	 * The '<em><b>Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE
	 * @model name="double"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_VALUE = 3;

	/**
	 * The '<em><b>Std Complex Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Std Complex Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STD_COMPLEX_DOUBLE
	 * @model name="stdComplexDouble" literal="std::complex_double_"
	 * @generated
	 * @ordered
	 */
	public static final int STD_COMPLEX_DOUBLE_VALUE = 4;

	/**
	 * The '<em><b>Std Complex Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Std Complex Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STD_COMPLEX_FLOAT
	 * @model name="stdComplexFloat" literal="std::complex_float_"
	 * @generated
	 * @ordered
	 */
	public static final int STD_COMPLEX_FLOAT_VALUE = 5;

	/**
	 * The '<em><b>Agilent EEsof Matrix Bool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Bool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_BOOL
	 * @model name="AgilentEEsofMatrixBool" literal="AgilentEEsof::Matrix_bool_"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_BOOL_VALUE = 6;

	/**
	 * The '<em><b>Agilent EEsof Matrix Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_INT
	 * @model name="AgilentEEsofMatrixInt" literal="AgilentEEsof::Matrix_int_"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_INT_VALUE = 7;

	/**
	 * The '<em><b>Agilent EEsof Matrix Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_DOUBLE
	 * @model name="AgilentEEsofMatrixDouble" literal="AgilentEEsof::Matrix_double_"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_DOUBLE_VALUE = 8;

	/**
	 * The '<em><b>Agilent EEsof Matrix Std Complex Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Std Complex Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE
	 * @model name="AgilentEEsofMatrixStdComplexDouble" literal="AgilentEEsof::Matrix_std::complex_double__"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE_VALUE = 9;

	/**
	 * The '<em><b>Agilent EEsof Matrix Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_FLOAT
	 * @model name="AgilentEEsofMatrixFloat" literal="AgilentEEsof::Matrix_float_"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_FLOAT_VALUE = 10;

	/**
	 * The '<em><b>Agilent EEsof Matrix Std Complex Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agilent EEsof Matrix Std Complex Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT
	 * @model name="AgilentEEsofMatrixStdComplexFloat" literal="AgilentEEsof::Matrix_std::complex_float__"
	 * @generated
	 * @ordered
	 */
	public static final int AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT_VALUE = 11;

	/**
	 * An array of all the '<em><b>Type Name Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypeNameType[] VALUES_ARRAY =
		new TypeNameType[] {
			INT,
			BOOL,
			FLOAT,
			DOUBLE,
			STD_COMPLEX_DOUBLE,
			STD_COMPLEX_FLOAT,
			AGILENT_EESOF_MATRIX_BOOL,
			AGILENT_EESOF_MATRIX_INT,
			AGILENT_EESOF_MATRIX_DOUBLE,
			AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE,
			AGILENT_EESOF_MATRIX_FLOAT,
			AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Name Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypeNameType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Name Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeNameType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeNameType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Name Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeNameType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeNameType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Name Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeNameType get(int value) {
		switch (value) {
			case INT_VALUE: return INT;
			case BOOL_VALUE: return BOOL;
			case FLOAT_VALUE: return FLOAT;
			case DOUBLE_VALUE: return DOUBLE;
			case STD_COMPLEX_DOUBLE_VALUE: return STD_COMPLEX_DOUBLE;
			case STD_COMPLEX_FLOAT_VALUE: return STD_COMPLEX_FLOAT;
			case AGILENT_EESOF_MATRIX_BOOL_VALUE: return AGILENT_EESOF_MATRIX_BOOL;
			case AGILENT_EESOF_MATRIX_INT_VALUE: return AGILENT_EESOF_MATRIX_INT;
			case AGILENT_EESOF_MATRIX_DOUBLE_VALUE: return AGILENT_EESOF_MATRIX_DOUBLE;
			case AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE_VALUE: return AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE;
			case AGILENT_EESOF_MATRIX_FLOAT_VALUE: return AGILENT_EESOF_MATRIX_FLOAT;
			case AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT_VALUE: return AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT;
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
	private TypeNameType(int value, String name, String literal) {
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
	
} //TypeNameType
