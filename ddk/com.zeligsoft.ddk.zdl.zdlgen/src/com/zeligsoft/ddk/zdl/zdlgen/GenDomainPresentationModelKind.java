/**
 * Copyright (c) 2008 Zeligsoft Inc.
 *
 * All rights reserved. 
 *  
 * THIS PROGRAM IS THE UNPUBLISHED, PROPRIETARY PROPERTY OF ZELIGSOFT INC. AND
 * IS TO BE MAINTAINED IN STRICT CONFIDENCE.  UNAUTHORIZED REPRODUCTION, 
 * DISTRIBUTION OR DISCLOSURE OF THIS PROGRAM, OR ANY PROGRAM DERIVED FROM IT,
 * IS STRICTLY PROHIBITED.
 *
 */
package com.zeligsoft.ddk.zdl.zdlgen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Gen Domain Presentation Model Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainPresentationModelKind()
 * @model
 * @generated
 */
public enum GenDomainPresentationModelKind implements Enumerator {
	/**
	 * The '<em><b>ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(0, "ALL", "ALL"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>AXCIOMA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AXCIOMA_VALUE
	 * @generated
	 * @ordered
	 */
	AXCIOMA(1, "AXCIOMA", "AXCIOMA"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ATCD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATCD_VALUE
	 * @generated
	 * @ordered
	 */
	ATCD(2, "ATCD", "ATCD"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 0;

	/**
	 * The '<em><b>AXCIOMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AXCIOMA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AXCIOMA_VALUE = 1;

	/**
	 * The '<em><b>ATCD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATCD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATCD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Gen Domain Presentation Model Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GenDomainPresentationModelKind[] VALUES_ARRAY = new GenDomainPresentationModelKind[] { ALL,
			AXCIOMA, ATCD, };

	/**
	 * A public read-only list of all the '<em><b>Gen Domain Presentation Model Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GenDomainPresentationModelKind> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gen Domain Presentation Model Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainPresentationModelKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDomainPresentationModelKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Domain Presentation Model Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainPresentationModelKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDomainPresentationModelKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Domain Presentation Model Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainPresentationModelKind get(int value) {
		switch (value) {
		case ALL_VALUE:
			return ALL;
		case AXCIOMA_VALUE:
			return AXCIOMA;
		case ATCD_VALUE:
			return ATCD;
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
	private GenDomainPresentationModelKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

} //GenDomainPresentationModelKind
