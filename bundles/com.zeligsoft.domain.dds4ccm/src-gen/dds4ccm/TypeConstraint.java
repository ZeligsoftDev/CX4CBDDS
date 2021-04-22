/**
 */
package dds4ccm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Constraint</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage#getTypeConstraint()
 * @model
 * @generated
 */
public enum TypeConstraint implements Enumerator {
	/**
	 * The '<em><b>Typename</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPENAME_VALUE
	 * @generated
	 * @ordered
	 */
	TYPENAME(0, "typename", "typename"),

	/**
	 * The '<em><b>Interface</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERFACE_VALUE
	 * @generated
	 * @ordered
	 */
	INTERFACE(1, "interface", "interface"),

	/**
	 * The '<em><b>Valuetype</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUETYPE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUETYPE(2, "valuetype", "valuetype"),

	/**
	 * The '<em><b>Eventtype</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVENTTYPE_VALUE
	 * @generated
	 * @ordered
	 */
	EVENTTYPE(3, "eventtype", "eventtype"),

	/**
	 * The '<em><b>Struct</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCT_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCT(4, "struct", "struct"),

	/**
	 * The '<em><b>Union</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNION_VALUE
	 * @generated
	 * @ordered
	 */
	UNION(5, "union", "union"),

	/**
	 * The '<em><b>Sequence</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	SEQUENCE(6, "sequence", "sequence"),

	/**
	 * The '<em><b>Array</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	ARRAY(7, "array", "array"),

	/**
	 * The '<em><b>Enum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUM_VALUE
	 * @generated
	 * @ordered
	 */
	ENUM(8, "enum", "enum");

	/**
	 * The '<em><b>Typename</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPENAME
	 * @model name="typename"
	 * @generated
	 * @ordered
	 */
	public static final int TYPENAME_VALUE = 0;

	/**
	 * The '<em><b>Interface</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERFACE
	 * @model name="interface"
	 * @generated
	 * @ordered
	 */
	public static final int INTERFACE_VALUE = 1;

	/**
	 * The '<em><b>Valuetype</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUETYPE
	 * @model name="valuetype"
	 * @generated
	 * @ordered
	 */
	public static final int VALUETYPE_VALUE = 2;

	/**
	 * The '<em><b>Eventtype</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVENTTYPE
	 * @model name="eventtype"
	 * @generated
	 * @ordered
	 */
	public static final int EVENTTYPE_VALUE = 3;

	/**
	 * The '<em><b>Struct</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCT
	 * @model name="struct"
	 * @generated
	 * @ordered
	 */
	public static final int STRUCT_VALUE = 4;

	/**
	 * The '<em><b>Union</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNION
	 * @model name="union"
	 * @generated
	 * @ordered
	 */
	public static final int UNION_VALUE = 5;

	/**
	 * The '<em><b>Sequence</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @model name="sequence"
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_VALUE = 6;

	/**
	 * The '<em><b>Array</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY
	 * @model name="array"
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_VALUE = 7;

	/**
	 * The '<em><b>Enum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUM
	 * @model name="enum"
	 * @generated
	 * @ordered
	 */
	public static final int ENUM_VALUE = 8;

	/**
	 * An array of all the '<em><b>Type Constraint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypeConstraint[] VALUES_ARRAY =
		new TypeConstraint[] {
			TYPENAME,
			INTERFACE,
			VALUETYPE,
			EVENTTYPE,
			STRUCT,
			UNION,
			SEQUENCE,
			ARRAY,
			ENUM,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Constraint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypeConstraint> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeConstraint get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeConstraint result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeConstraint getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeConstraint result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeConstraint get(int value) {
		switch (value) {
			case TYPENAME_VALUE: return TYPENAME;
			case INTERFACE_VALUE: return INTERFACE;
			case VALUETYPE_VALUE: return VALUETYPE;
			case EVENTTYPE_VALUE: return EVENTTYPE;
			case STRUCT_VALUE: return STRUCT;
			case UNION_VALUE: return UNION;
			case SEQUENCE_VALUE: return SEQUENCE;
			case ARRAY_VALUE: return ARRAY;
			case ENUM_VALUE: return ENUM;
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
	private TypeConstraint(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	
} //TypeConstraint
