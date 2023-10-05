/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Behavior Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getBehaviorKind()
 * @model
 * @generated
 */
public enum BehaviorKind implements Enumerator {
	/**
	 * The '<em><b>ACTIVITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACTIVITY_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVITY(0, "ACTIVITY", "Activity"),

	/**
	 * The '<em><b>STATE MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATE_MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_MACHINE(1, "STATE_MACHINE", "StateMachine"),

	/**
	 * The '<em><b>OPAQUE BEHAVIOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #OPAQUE_BEHAVIOR_VALUE
	 * @generated
	 * @ordered
	 */
	OPAQUE_BEHAVIOR(2, "OPAQUE_BEHAVIOR", "OpaqueBehavior");

	/**
	 * The '<em><b>ACTIVITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACTIVITY
	 * @model literal="Activity"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVITY_VALUE = 0;

	/**
	 * The '<em><b>STATE MACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE MACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATE_MACHINE
	 * @model literal="StateMachine"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_MACHINE_VALUE = 1;

	/**
	 * The '<em><b>OPAQUE BEHAVIOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPAQUE BEHAVIOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OPAQUE_BEHAVIOR
	 * @model literal="OpaqueBehavior"
	 * @generated
	 * @ordered
	 */
	public static final int OPAQUE_BEHAVIOR_VALUE = 2;

	/**
	 * An array of all the '<em><b>Behavior Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final BehaviorKind[] VALUES_ARRAY = new BehaviorKind[] {
			ACTIVITY,
			STATE_MACHINE,
			OPAQUE_BEHAVIOR,
	};

	/**
	 * A public read-only list of all the '<em><b>Behavior Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<BehaviorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Behavior Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BehaviorKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BehaviorKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Behavior Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BehaviorKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BehaviorKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Behavior Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BehaviorKind get(int value) {
		switch (value) {
		case ACTIVITY_VALUE:
			return ACTIVITY;
		case STATE_MACHINE_VALUE:
			return STATE_MACHINE;
		case OPAQUE_BEHAVIOR_VALUE:
			return OPAQUE_BEHAVIOR;
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
	private BehaviorKind(int value, String name, String literal) {
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

} // BehaviorKind
