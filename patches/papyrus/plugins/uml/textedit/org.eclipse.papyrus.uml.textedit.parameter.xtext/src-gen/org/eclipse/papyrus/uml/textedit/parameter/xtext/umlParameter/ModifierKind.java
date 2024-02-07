/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Modifier Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getModifierKind()
 * @model
 * @generated
 */
public enum ModifierKind implements Enumerator {
	/**
	 * The '<em><b>EXCEPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	EXCEPTION(0, "EXCEPTION", "exception"),

	/**
	 * The '<em><b>STREAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #STREAM_VALUE
	 * @generated
	 * @ordered
	 */
	STREAM(1, "STREAM", "stream"),

	/**
	 * The '<em><b>ORDERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ORDERED_VALUE
	 * @generated
	 * @ordered
	 */
	ORDERED(2, "ORDERED", "ordered"),

	/**
	 * The '<em><b>UNIQUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #UNIQUE_VALUE
	 * @generated
	 * @ordered
	 */
	UNIQUE(3, "UNIQUE", "unique");

	/**
	 * The '<em><b>EXCEPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXCEPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EXCEPTION
	 * @model literal="exception"
	 * @generated
	 * @ordered
	 */
	public static final int EXCEPTION_VALUE = 0;

	/**
	 * The '<em><b>STREAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STREAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STREAM
	 * @model literal="stream"
	 * @generated
	 * @ordered
	 */
	public static final int STREAM_VALUE = 1;

	/**
	 * The '<em><b>ORDERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ORDERED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ORDERED
	 * @model literal="ordered"
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_VALUE = 2;

	/**
	 * The '<em><b>UNIQUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIQUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #UNIQUE
	 * @model literal="unique"
	 * @generated
	 * @ordered
	 */
	public static final int UNIQUE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Modifier Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ModifierKind[] VALUES_ARRAY = new ModifierKind[] {
			EXCEPTION,
			STREAM,
			ORDERED,
			UNIQUE,
	};

	/**
	 * A public read-only list of all the '<em><b>Modifier Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ModifierKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Modifier Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ModifierKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ModifierKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Modifier Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ModifierKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ModifierKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Modifier Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ModifierKind get(int value) {
		switch (value) {
		case EXCEPTION_VALUE:
			return EXCEPTION;
		case STREAM_VALUE:
			return STREAM;
		case ORDERED_VALUE:
			return ORDERED;
		case UNIQUE_VALUE:
			return UNIQUE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private ModifierKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // ModifierKind
