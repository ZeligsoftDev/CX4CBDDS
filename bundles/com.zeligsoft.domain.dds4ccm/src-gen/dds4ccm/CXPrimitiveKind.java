/**
 */
package dds4ccm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>CX Primitive Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage#getCXPrimitiveKind()
 * @model
 * @generated
 */
public enum CXPrimitiveKind implements Enumerator {
	/**
	 * The '<em><b>CXW Char</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CXW_CHAR_VALUE
	 * @generated
	 * @ordered
	 */
	CXW_CHAR(0, "CXWChar", "CXWChar"),

	/**
	 * The '<em><b>CX Void</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_VOID_VALUE
	 * @generated
	 * @ordered
	 */
	CX_VOID(1, "CXVoid", "CXVoid"),

	/**
	 * The '<em><b>CX Unsigned Short</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_SHORT_VALUE
	 * @generated
	 * @ordered
	 */
	CX_UNSIGNED_SHORT(2, "CXUnsignedShort", "CXUnsignedShort"),

	/**
	 * The '<em><b>CX Unsigned Long Long</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_LONG_LONG_VALUE
	 * @generated
	 * @ordered
	 */
	CX_UNSIGNED_LONG_LONG(3, "CXUnsignedLongLong", "CXUnsignedLongLong"),

	/**
	 * The '<em><b>CX Unsigned Long</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_LONG_VALUE
	 * @generated
	 * @ordered
	 */
	CX_UNSIGNED_LONG(4, "CXUnsignedLong", "CXUnsignedLong"),

	/**
	 * The '<em><b>CX Short</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_SHORT_VALUE
	 * @generated
	 * @ordered
	 */
	CX_SHORT(5, "CXShort", "CXShort"),

	/**
	 * The '<em><b>CX Octet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_OCTET_VALUE
	 * @generated
	 * @ordered
	 */
	CX_OCTET(6, "CXOctet", "CXOctet"),

	/**
	 * The '<em><b>CX Object Ref</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_OBJECT_REF_VALUE
	 * @generated
	 * @ordered
	 */
	CX_OBJECT_REF(7, "CXObjectRef", "CXObjectRef"),

	/**
	 * The '<em><b>CX Long Long</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG_LONG_VALUE
	 * @generated
	 * @ordered
	 */
	CX_LONG_LONG(8, "CXLongLong", "CXLongLong"),

	/**
	 * The '<em><b>CX Long Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	CX_LONG_DOUBLE(9, "CXLongDouble", "CXLongDouble"),

	/**
	 * The '<em><b>CX Long</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG_VALUE
	 * @generated
	 * @ordered
	 */
	CX_LONG(10, "CXLong", "CXLong"),

	/**
	 * The '<em><b>CX Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	CX_FLOAT(11, "CXFloat", "CXFloat"),

	/**
	 * The '<em><b>CX Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	CX_DOUBLE(12, "CXDouble", "CXDouble"),

	/**
	 * The '<em><b>CX Char</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_CHAR_VALUE
	 * @generated
	 * @ordered
	 */
	CX_CHAR(13, "CXChar", "CXChar"),

	/**
	 * The '<em><b>CX Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	CX_BOOLEAN(14, "CXBoolean", "CXBoolean"),

	/**
	 * The '<em><b>CX Any</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_ANY_VALUE
	 * @generated
	 * @ordered
	 */
	CX_ANY(15, "CXAny", "CXAny"),

	/**
	 * The '<em><b>CX String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_STRING_VALUE
	 * @generated
	 * @ordered
	 */
	CX_STRING(16, "CXString", "CXString"),

	/**
	 * The '<em><b>CXW String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CXW_STRING_VALUE
	 * @generated
	 * @ordered
	 */
	CXW_STRING(17, "CXWString", "CXWString"),

	/**
	 * The '<em><b>CX Typecode</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_TYPECODE_VALUE
	 * @generated
	 * @ordered
	 */
	CX_TYPECODE(18, "CXTypecode", "CXTypecode");

	/**
	 * The '<em><b>CXW Char</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CXW_CHAR
	 * @model name="CXWChar"
	 * @generated
	 * @ordered
	 */
	public static final int CXW_CHAR_VALUE = 0;

	/**
	 * The '<em><b>CX Void</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_VOID
	 * @model name="CXVoid"
	 * @generated
	 * @ordered
	 */
	public static final int CX_VOID_VALUE = 1;

	/**
	 * The '<em><b>CX Unsigned Short</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_SHORT
	 * @model name="CXUnsignedShort"
	 * @generated
	 * @ordered
	 */
	public static final int CX_UNSIGNED_SHORT_VALUE = 2;

	/**
	 * The '<em><b>CX Unsigned Long Long</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_LONG_LONG
	 * @model name="CXUnsignedLongLong"
	 * @generated
	 * @ordered
	 */
	public static final int CX_UNSIGNED_LONG_LONG_VALUE = 3;

	/**
	 * The '<em><b>CX Unsigned Long</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_UNSIGNED_LONG
	 * @model name="CXUnsignedLong"
	 * @generated
	 * @ordered
	 */
	public static final int CX_UNSIGNED_LONG_VALUE = 4;

	/**
	 * The '<em><b>CX Short</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_SHORT
	 * @model name="CXShort"
	 * @generated
	 * @ordered
	 */
	public static final int CX_SHORT_VALUE = 5;

	/**
	 * The '<em><b>CX Octet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_OCTET
	 * @model name="CXOctet"
	 * @generated
	 * @ordered
	 */
	public static final int CX_OCTET_VALUE = 6;

	/**
	 * The '<em><b>CX Object Ref</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_OBJECT_REF
	 * @model name="CXObjectRef"
	 * @generated
	 * @ordered
	 */
	public static final int CX_OBJECT_REF_VALUE = 7;

	/**
	 * The '<em><b>CX Long Long</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG_LONG
	 * @model name="CXLongLong"
	 * @generated
	 * @ordered
	 */
	public static final int CX_LONG_LONG_VALUE = 8;

	/**
	 * The '<em><b>CX Long Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG_DOUBLE
	 * @model name="CXLongDouble"
	 * @generated
	 * @ordered
	 */
	public static final int CX_LONG_DOUBLE_VALUE = 9;

	/**
	 * The '<em><b>CX Long</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_LONG
	 * @model name="CXLong"
	 * @generated
	 * @ordered
	 */
	public static final int CX_LONG_VALUE = 10;

	/**
	 * The '<em><b>CX Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_FLOAT
	 * @model name="CXFloat"
	 * @generated
	 * @ordered
	 */
	public static final int CX_FLOAT_VALUE = 11;

	/**
	 * The '<em><b>CX Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_DOUBLE
	 * @model name="CXDouble"
	 * @generated
	 * @ordered
	 */
	public static final int CX_DOUBLE_VALUE = 12;

	/**
	 * The '<em><b>CX Char</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_CHAR
	 * @model name="CXChar"
	 * @generated
	 * @ordered
	 */
	public static final int CX_CHAR_VALUE = 13;

	/**
	 * The '<em><b>CX Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_BOOLEAN
	 * @model name="CXBoolean"
	 * @generated
	 * @ordered
	 */
	public static final int CX_BOOLEAN_VALUE = 14;

	/**
	 * The '<em><b>CX Any</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_ANY
	 * @model name="CXAny"
	 * @generated
	 * @ordered
	 */
	public static final int CX_ANY_VALUE = 15;

	/**
	 * The '<em><b>CX String</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_STRING
	 * @model name="CXString"
	 * @generated
	 * @ordered
	 */
	public static final int CX_STRING_VALUE = 16;

	/**
	 * The '<em><b>CXW String</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CXW_STRING
	 * @model name="CXWString"
	 * @generated
	 * @ordered
	 */
	public static final int CXW_STRING_VALUE = 17;

	/**
	 * The '<em><b>CX Typecode</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CX_TYPECODE
	 * @model name="CXTypecode"
	 * @generated
	 * @ordered
	 */
	public static final int CX_TYPECODE_VALUE = 18;

	/**
	 * An array of all the '<em><b>CX Primitive Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CXPrimitiveKind[] VALUES_ARRAY =
		new CXPrimitiveKind[] {
			CXW_CHAR,
			CX_VOID,
			CX_UNSIGNED_SHORT,
			CX_UNSIGNED_LONG_LONG,
			CX_UNSIGNED_LONG,
			CX_SHORT,
			CX_OCTET,
			CX_OBJECT_REF,
			CX_LONG_LONG,
			CX_LONG_DOUBLE,
			CX_LONG,
			CX_FLOAT,
			CX_DOUBLE,
			CX_CHAR,
			CX_BOOLEAN,
			CX_ANY,
			CX_STRING,
			CXW_STRING,
			CX_TYPECODE,
		};

	/**
	 * A public read-only list of all the '<em><b>CX Primitive Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CXPrimitiveKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CX Primitive Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CXPrimitiveKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CXPrimitiveKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CX Primitive Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CXPrimitiveKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CXPrimitiveKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CX Primitive Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CXPrimitiveKind get(int value) {
		switch (value) {
			case CXW_CHAR_VALUE: return CXW_CHAR;
			case CX_VOID_VALUE: return CX_VOID;
			case CX_UNSIGNED_SHORT_VALUE: return CX_UNSIGNED_SHORT;
			case CX_UNSIGNED_LONG_LONG_VALUE: return CX_UNSIGNED_LONG_LONG;
			case CX_UNSIGNED_LONG_VALUE: return CX_UNSIGNED_LONG;
			case CX_SHORT_VALUE: return CX_SHORT;
			case CX_OCTET_VALUE: return CX_OCTET;
			case CX_OBJECT_REF_VALUE: return CX_OBJECT_REF;
			case CX_LONG_LONG_VALUE: return CX_LONG_LONG;
			case CX_LONG_DOUBLE_VALUE: return CX_LONG_DOUBLE;
			case CX_LONG_VALUE: return CX_LONG;
			case CX_FLOAT_VALUE: return CX_FLOAT;
			case CX_DOUBLE_VALUE: return CX_DOUBLE;
			case CX_CHAR_VALUE: return CX_CHAR;
			case CX_BOOLEAN_VALUE: return CX_BOOLEAN;
			case CX_ANY_VALUE: return CX_ANY;
			case CX_STRING_VALUE: return CX_STRING;
			case CXW_STRING_VALUE: return CXW_STRING;
			case CX_TYPECODE_VALUE: return CX_TYPECODE;
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
	private CXPrimitiveKind(int value, String name, String literal) {
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
	
} //CXPrimitiveKind
