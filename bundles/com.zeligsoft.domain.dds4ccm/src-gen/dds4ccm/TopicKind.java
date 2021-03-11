/**
 */
package dds4ccm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Topic Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage#getTopicKind()
 * @model
 * @generated
 */
public enum TopicKind implements Enumerator {
	/**
	 * The '<em><b>STANDARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STANDARD_VALUE
	 * @generated
	 * @ordered
	 */
	STANDARD(0, "STANDARD", "STANDARD"),

	/**
	 * The '<em><b>MULTI TOPIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTI_TOPIC_VALUE
	 * @generated
	 * @ordered
	 */
	MULTI_TOPIC(1, "MULTI_TOPIC", "MULTI_TOPIC"),

	/**
	 * The '<em><b>CONTENT FILTERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_FILTERED_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_FILTERED(2, "CONTENT_FILTERED", "CONTENT_FILTERED");

	/**
	 * The '<em><b>STANDARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STANDARD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD_VALUE = 0;

	/**
	 * The '<em><b>MULTI TOPIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTI_TOPIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULTI_TOPIC_VALUE = 1;

	/**
	 * The '<em><b>CONTENT FILTERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_FILTERED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_FILTERED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Topic Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TopicKind[] VALUES_ARRAY =
		new TopicKind[] {
			STANDARD,
			MULTI_TOPIC,
			CONTENT_FILTERED,
		};

	/**
	 * A public read-only list of all the '<em><b>Topic Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TopicKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Topic Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TopicKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TopicKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Topic Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TopicKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TopicKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Topic Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TopicKind get(int value) {
		switch (value) {
			case STANDARD_VALUE: return STANDARD;
			case MULTI_TOPIC_VALUE: return MULTI_TOPIC;
			case CONTENT_FILTERED_VALUE: return CONTENT_FILTERED;
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
	private TopicKind(int value, String name, String literal) {
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
	
} //TopicKind
