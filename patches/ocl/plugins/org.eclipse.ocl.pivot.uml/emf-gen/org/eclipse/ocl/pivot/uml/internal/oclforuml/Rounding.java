/**
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Rounding</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getRounding()
 * @model
 * @generated
 */
public enum Rounding
		implements
		Enumerator {

	/**
	 * The '<em><b>Nearest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEAREST_VALUE
	 * @generated
	 * @ordered
	 */
	NEAREST(0, "nearest", "nearest"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ceiling</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CEILING_VALUE
	 * @generated
	 * @ordered
	 */
	CEILING(1, "ceiling", "ceiling"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Floor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOOR_VALUE
	 * @generated
	 * @ordered
	 */
	FLOOR(2, "floor", "floor"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Congruent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONGRUENT_VALUE
	 * @generated
	 * @ordered
	 */
	CONGRUENT(3, "congruent", "congruent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Nearest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nearest</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEAREST
	 * @model name="nearest"
	 * @generated
	 * @ordered
	 */
	public static final int NEAREST_VALUE = 0;

	/**
	 * The '<em><b>Ceiling</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ceiling</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CEILING
	 * @model name="ceiling"
	 * @generated
	 * @ordered
	 */
	public static final int CEILING_VALUE = 1;

	/**
	 * The '<em><b>Floor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Floor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOOR
	 * @model name="floor"
	 * @generated
	 * @ordered
	 */
	public static final int FLOOR_VALUE = 2;

	/**
	 * The '<em><b>Congruent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Congruent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONGRUENT
	 * @model name="congruent"
	 * @generated
	 * @ordered
	 */
	public static final int CONGRUENT_VALUE = 3;

	/**
	 * An array of all the '<em><b>Rounding</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Rounding[] VALUES_ARRAY = new Rounding[]
		{
			NEAREST,
			CEILING,
			FLOOR,
			CONGRUENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Rounding</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Rounding> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Rounding</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Rounding get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Rounding result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rounding</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Rounding getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Rounding result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rounding</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Rounding get(int value) {
		switch (value)
		{
			case NEAREST_VALUE: return NEAREST;
			case CEILING_VALUE: return CEILING;
			case FLOOR_VALUE: return FLOOR;
			case CONGRUENT_VALUE: return CONGRUENT;
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
	private Rounding(int value, String name, String literal) {
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

} //Rounding
