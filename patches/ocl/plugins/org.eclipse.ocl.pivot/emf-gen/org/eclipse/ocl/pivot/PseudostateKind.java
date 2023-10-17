/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Pseudostate Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * PseudostateKind is an Enumeration type that is used to differentiate various kinds of Pseudostates.
 * <!-- end-model-doc -->
 * @see org.eclipse.ocl.pivot.PivotPackage#getPseudostateKind()
 * @generated
 */
public enum PseudostateKind implements Enumerator
{
	/**
	 * The '<em><b>Initial</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIAL_VALUE
	 * @generated
	 * @ordered
	 */
	INITIAL(0, "initial", "initial"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Deep History</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEEP_HISTORY_VALUE
	 * @generated
	 * @ordered
	 */
	DEEP_HISTORY(1, "deepHistory", "deepHistory"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Shallow History</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHALLOW_HISTORY_VALUE
	 * @generated
	 * @ordered
	 */
	SHALLOW_HISTORY(2, "shallowHistory", "shallowHistory"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Join</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIN_VALUE
	 * @generated
	 * @ordered
	 */
	JOIN(3, "join", "join"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Fork</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORK_VALUE
	 * @generated
	 * @ordered
	 */
	FORK(4, "fork", "fork"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Junction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	JUNCTION(5, "junction", "junction"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Choice</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHOICE_VALUE
	 * @generated
	 * @ordered
	 */
	CHOICE(6, "choice", "choice"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Entry Point</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRY_POINT_VALUE
	 * @generated
	 * @ordered
	 */
	ENTRY_POINT(7, "entryPoint", "entryPoint"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Exit Point</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_POINT_VALUE
	 * @generated
	 * @ordered
	 */
	EXIT_POINT(8, "exitPoint", "exitPoint"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Terminate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINATE_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATE(9, "terminate", "terminate"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Initial</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIAL
	 * @generated
	 * @ordered
	 */
	public static final int INITIAL_VALUE = 0;

	/**
	 * The '<em><b>Deep History</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEEP_HISTORY
	 * @generated
	 * @ordered
	 */
	public static final int DEEP_HISTORY_VALUE = 1;

	/**
	 * The '<em><b>Shallow History</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHALLOW_HISTORY
	 * @generated
	 * @ordered
	 */
	public static final int SHALLOW_HISTORY_VALUE = 2;

	/**
	 * The '<em><b>Join</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIN
	 * @generated
	 * @ordered
	 */
	public static final int JOIN_VALUE = 3;

	/**
	 * The '<em><b>Fork</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORK
	 * @generated
	 * @ordered
	 */
	public static final int FORK_VALUE = 4;

	/**
	 * The '<em><b>Junction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUNCTION
	 * @generated
	 * @ordered
	 */
	public static final int JUNCTION_VALUE = 5;

	/**
	 * The '<em><b>Choice</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHOICE
	 * @generated
	 * @ordered
	 */
	public static final int CHOICE_VALUE = 6;

	/**
	 * The '<em><b>Entry Point</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRY_POINT
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY_POINT_VALUE = 7;

	/**
	 * The '<em><b>Exit Point</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_POINT
	 * @generated
	 * @ordered
	 */
	public static final int EXIT_POINT_VALUE = 8;

	/**
	 * The '<em><b>Terminate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINATE
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATE_VALUE = 9;

	/**
	 * An array of all the '<em><b>Pseudostate Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PseudostateKind[] VALUES_ARRAY =
		new PseudostateKind[]
		{
			INITIAL,
			DEEP_HISTORY,
			SHALLOW_HISTORY,
			JOIN,
			FORK,
			JUNCTION,
			CHOICE,
			ENTRY_POINT,
			EXIT_POINT,
			TERMINATE,
		};

	/**
	 * A public read-only list of all the '<em><b>Pseudostate Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PseudostateKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Pseudostate Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PseudostateKind get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			PseudostateKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pseudostate Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PseudostateKind getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			PseudostateKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pseudostate Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PseudostateKind get(int value)
	{
		switch (value)
		{
			case INITIAL_VALUE: return INITIAL;
			case DEEP_HISTORY_VALUE: return DEEP_HISTORY;
			case SHALLOW_HISTORY_VALUE: return SHALLOW_HISTORY;
			case JOIN_VALUE: return JOIN;
			case FORK_VALUE: return FORK;
			case JUNCTION_VALUE: return JUNCTION;
			case CHOICE_VALUE: return CHOICE;
			case ENTRY_POINT_VALUE: return ENTRY_POINT;
			case EXIT_POINT_VALUE: return EXIT_POINT;
			case TERMINATE_VALUE: return TERMINATE;
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
	private PseudostateKind(int value, String name, String literal)
	{
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
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}

} //PseudostateKind
