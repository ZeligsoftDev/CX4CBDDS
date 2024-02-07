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
 * A representation of the literals of the enumeration '<em><b>Overflow</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getOverflow()
 * @model
 * @generated
 */
public enum Overflow
		implements
		Enumerator {

	/**
	 * The '<em><b>Invalid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVALID_VALUE
	 * @generated
	 * @ordered
	 */
	INVALID(0, "invalid", "invalid"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Saturate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SATURATE_VALUE
	 * @generated
	 * @ordered
	 */
	SATURATE(1, "saturate", "saturate"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Modulo</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULO_VALUE
	 * @generated
	 * @ordered
	 */
	MODULO(2, "modulo", "modulo"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Invalid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Invalid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVALID
	 * @model name="invalid"
	 * @generated
	 * @ordered
	 */
	public static final int INVALID_VALUE = 0;

	/**
	 * The '<em><b>Saturate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Saturate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SATURATE
	 * @model name="saturate"
	 * @generated
	 * @ordered
	 */
	public static final int SATURATE_VALUE = 1;

	/**
	 * The '<em><b>Modulo</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Modulo</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULO
	 * @model name="modulo"
	 * @generated
	 * @ordered
	 */
	public static final int MODULO_VALUE = 2;

	/**
	 * An array of all the '<em><b>Overflow</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Overflow[] VALUES_ARRAY = new Overflow[]
		{
			INVALID,
			SATURATE,
			MODULO,
		};

	/**
	 * A public read-only list of all the '<em><b>Overflow</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Overflow> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Overflow</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Overflow get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Overflow result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Overflow</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Overflow getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Overflow result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Overflow</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Overflow get(int value) {
		switch (value)
		{
			case INVALID_VALUE: return INVALID;
			case SATURATE_VALUE: return SATURATE;
			case MODULO_VALUE: return MODULO;
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
	private Overflow(int value, String name, String literal) {
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

} //Overflow
