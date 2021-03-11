/**
 */
package dds4ccm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Wiring Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage#getWiringKind()
 * @model
 * @generated
 */
public enum WiringKind implements Enumerator {
	/**
	 * The '<em><b>Connector</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONNECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONNECTOR(0, "connector", "connector"),

	/**
	 * The '<em><b>Sap</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAP_VALUE
	 * @generated
	 * @ordered
	 */
	SAP(1, "sap", "sap"),

	/**
	 * The '<em><b>Spp</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPP_VALUE
	 * @generated
	 * @ordered
	 */
	SPP(2, "spp", "spp");

	/**
	 * The '<em><b>Connector</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONNECTOR
	 * @model name="connector"
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTOR_VALUE = 0;

	/**
	 * The '<em><b>Sap</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAP
	 * @model name="sap"
	 * @generated
	 * @ordered
	 */
	public static final int SAP_VALUE = 1;

	/**
	 * The '<em><b>Spp</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPP
	 * @model name="spp"
	 * @generated
	 * @ordered
	 */
	public static final int SPP_VALUE = 2;

	/**
	 * An array of all the '<em><b>Wiring Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WiringKind[] VALUES_ARRAY =
		new WiringKind[] {
			CONNECTOR,
			SAP,
			SPP,
		};

	/**
	 * A public read-only list of all the '<em><b>Wiring Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<WiringKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Wiring Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static WiringKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WiringKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Wiring Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static WiringKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WiringKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Wiring Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static WiringKind get(int value) {
		switch (value) {
			case CONNECTOR_VALUE: return CONNECTOR;
			case SAP_VALUE: return SAP;
			case SPP_VALUE: return SPP;
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
	private WiringKind(int value, String name, String literal) {
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
	
} //WiringKind
