/**
 */
package dds4ccm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Configuration Slot Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage#getConfigurationSlotKind()
 * @model
 * @generated
 */
public enum ConfigurationSlotKind implements Enumerator {
	/**
	 * The '<em><b>Additive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIVE(0, "additive", "additive"),

	/**
	 * The '<em><b>Override</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE(1, "override", "override");

	/**
	 * The '<em><b>Additive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIVE
	 * @model name="additive"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIVE_VALUE = 0;

	/**
	 * The '<em><b>Override</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE
	 * @model name="override"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Configuration Slot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConfigurationSlotKind[] VALUES_ARRAY =
		new ConfigurationSlotKind[] {
			ADDITIVE,
			OVERRIDE,
		};

	/**
	 * A public read-only list of all the '<em><b>Configuration Slot Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConfigurationSlotKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Configuration Slot Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationSlotKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigurationSlotKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Configuration Slot Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationSlotKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigurationSlotKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Configuration Slot Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationSlotKind get(int value) {
		switch (value) {
			case ADDITIVE_VALUE: return ADDITIVE;
			case OVERRIDE_VALUE: return OVERRIDE;
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
	private ConfigurationSlotKind(int value, String name, String literal) {
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
	
} //ConfigurationSlotKind
