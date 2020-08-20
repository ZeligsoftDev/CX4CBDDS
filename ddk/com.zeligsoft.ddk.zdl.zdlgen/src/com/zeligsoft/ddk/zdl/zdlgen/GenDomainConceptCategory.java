/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Gen Domain Concept Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConceptCategory()
 * @model
 * @generated
 */
public enum GenDomainConceptCategory implements Enumerator {
	/**
	 * The '<em><b>Abstract</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	ABSTRACT(0, "abstract", "abstract"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Firm</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRM_VALUE
	 * @generated
	 * @ordered
	 */
	FIRM(1, "firm", "firm"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Uncertain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNCERTAIN_VALUE
	 * @generated
	 * @ordered
	 */
	UNCERTAIN(2, "uncertain", "uncertain"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Abstract</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSTRACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT
	 * @model name="abstract"
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_VALUE = 0;

	/**
	 * The '<em><b>Firm</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRM
	 * @model name="firm"
	 * @generated
	 * @ordered
	 */
	public static final int FIRM_VALUE = 1;

	/**
	 * The '<em><b>Uncertain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNCERTAIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNCERTAIN
	 * @model name="uncertain"
	 * @generated
	 * @ordered
	 */
	public static final int UNCERTAIN_VALUE = 2;

	/**
	 * An array of all the '<em><b>Gen Domain Concept Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GenDomainConceptCategory[] VALUES_ARRAY = new GenDomainConceptCategory[] { ABSTRACT, FIRM,
			UNCERTAIN, };

	/**
	 * A public read-only list of all the '<em><b>Gen Domain Concept Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GenDomainConceptCategory> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gen Domain Concept Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainConceptCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDomainConceptCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Domain Concept Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainConceptCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GenDomainConceptCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gen Domain Concept Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GenDomainConceptCategory get(int value) {
		switch (value) {
		case ABSTRACT_VALUE:
			return ABSTRACT;
		case FIRM_VALUE:
			return FIRM;
		case UNCERTAIN_VALUE:
			return UNCERTAIN;
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
	private GenDomainConceptCategory(int value, String name, String literal) {
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

} //GenDomainConceptCategory
