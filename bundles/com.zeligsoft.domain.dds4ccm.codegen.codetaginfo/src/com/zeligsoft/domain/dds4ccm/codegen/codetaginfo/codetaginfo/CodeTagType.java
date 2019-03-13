/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */

package com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Code Tag Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagType()
 * @model extendedMetaData="name='CodeTagType'"
 * @generated
 */
public enum CodeTagType implements Enumerator {
    /**
	 * The '<em><b>FILEHEADERH</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEHEADERH_VALUE
	 * @generated
	 * @ordered
	 */
    FILEHEADERH(0, "FILEHEADERH", "FILE_HEADER_H"),

    /**
	 * The '<em><b>FILEHEADERCPP</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEHEADERCPP_VALUE
	 * @generated
	 * @ordered
	 */
    FILEHEADERCPP(1, "FILEHEADERCPP", "FILE_HEADER_CPP"),

    /**
	 * The '<em><b>FILEFOOTERH</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEFOOTERH_VALUE
	 * @generated
	 * @ordered
	 */
    FILEFOOTERH(2, "FILEFOOTERH", "FILE_FOOTER_H"),

    /**
	 * The '<em><b>FILEFOOTERCPP</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEFOOTERCPP_VALUE
	 * @generated
	 * @ordered
	 */
    FILEFOOTERCPP(3, "FILEFOOTERCPP", "FILE_FOOTER_CPP"),

    /**
	 * The '<em><b>FILEINCLUDESH</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEINCLUDESH_VALUE
	 * @generated
	 * @ordered
	 */
    FILEINCLUDESH(4, "FILEINCLUDESH", "FILE_INCLUDES_H"),

    /**
	 * The '<em><b>FILEINCLUDESCPP</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FILEINCLUDESCPP_VALUE
	 * @generated
	 * @ordered
	 */
    FILEINCLUDESCPP(5, "FILEINCLUDESCPP", "FILE_INCLUDES_CPP"),

    /**
	 * The '<em><b>CONSTRUCTORINITLIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CONSTRUCTORINITLIST_VALUE
	 * @generated
	 * @ordered
	 */
    CONSTRUCTORINITLIST(6, "CONSTRUCTORINITLIST", "CONSTRUCTOR_INIT_LIST"),

    /**
	 * The '<em><b>CLASSGENERATEDOPERATIONIMPL</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDOPERATIONIMPL_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSGENERATEDOPERATIONIMPL(7, "CLASSGENERATEDOPERATIONIMPL", "CLASS_GENERATED_OPERATION_IMPL"),

    /**
	 * The '<em><b>CLASSGENERATEDATTRIBUTEGET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDATTRIBUTEGET_VALUE
	 * @generated
	 * @ordered
	 */
	CLASSGENERATEDATTRIBUTEGET(8, "CLASSGENERATEDATTRIBUTEGET", "CLASS_GENERATED_ATTRIBUTE_GET"), /**
	 * The '<em><b>CLASSGENERATEDATTRIBUTESET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDATTRIBUTESET_VALUE
	 * @generated
	 * @ordered
	 */
	CLASSGENERATEDATTRIBUTESET(9, "CLASSGENERATEDATTRIBUTESET", "CLASS_GENERATED_ATTRIBUTE_SET"), /**
	 * The '<em><b>CLASSPUBLICMETHODSSECTIONDECLARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSPUBLICMETHODSSECTIONDECLARE_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSPUBLICMETHODSSECTIONDECLARE(10, "CLASSPUBLICMETHODSSECTIONDECLARE", "CLASS_PUBLIC_METHODS_SECTION_DECLARE"),

    /**
	 * The '<em><b>CLASSPUBLICMETHODSSECTIONIMPL</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSPUBLICMETHODSSECTIONIMPL_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSPUBLICMETHODSSECTIONIMPL(11, "CLASSPUBLICMETHODSSECTIONIMPL", "CLASS_PUBLIC_METHODS_SECTION_IMPL"),

    /**
	 * The '<em><b>CLASSPRIVATEMETHODSSECTIONDECLARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMETHODSSECTIONDECLARE_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSPRIVATEMETHODSSECTIONDECLARE(12, "CLASSPRIVATEMETHODSSECTIONDECLARE", "CLASS_PRIVATE_METHODS_SECTION_DECLARE"),

    /**
	 * The '<em><b>CLASSPRIVATEMETHODSSECTIONIMPL</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMETHODSSECTIONIMPL_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSPRIVATEMETHODSSECTIONIMPL(13, "CLASSPRIVATEMETHODSSECTIONIMPL", "CLASS_PRIVATE_METHODS_SECTION_IMPL"),

    /**
	 * The '<em><b>CLASSPRIVATEMEMBERSSECTIONDECLARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMEMBERSSECTIONDECLARE_VALUE
	 * @generated
	 * @ordered
	 */
    CLASSPRIVATEMEMBERSSECTIONDECLARE(14, "CLASSPRIVATEMEMBERSSECTIONDECLARE", "CLASS_PRIVATE_MEMBERS_SECTION_DECLARE");

    /**
	 * The '<em><b>FILEHEADERH</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEHEADERH</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEHEADERH
	 * @model literal="FILE_HEADER_H"
	 * @generated
	 * @ordered
	 */
    public static final int FILEHEADERH_VALUE = 0;

    /**
	 * The '<em><b>FILEHEADERCPP</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEHEADERCPP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEHEADERCPP
	 * @model literal="FILE_HEADER_CPP"
	 * @generated
	 * @ordered
	 */
    public static final int FILEHEADERCPP_VALUE = 1;

    /**
	 * The '<em><b>FILEFOOTERH</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEFOOTERH</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEFOOTERH
	 * @model literal="FILE_FOOTER_H"
	 * @generated
	 * @ordered
	 */
    public static final int FILEFOOTERH_VALUE = 2;

    /**
	 * The '<em><b>FILEFOOTERCPP</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEFOOTERCPP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEFOOTERCPP
	 * @model literal="FILE_FOOTER_CPP"
	 * @generated
	 * @ordered
	 */
    public static final int FILEFOOTERCPP_VALUE = 3;

    /**
	 * The '<em><b>FILEINCLUDESH</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEINCLUDESH</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEINCLUDESH
	 * @model literal="FILE_INCLUDES_H"
	 * @generated
	 * @ordered
	 */
    public static final int FILEINCLUDESH_VALUE = 4;

    /**
	 * The '<em><b>FILEINCLUDESCPP</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FILEINCLUDESCPP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FILEINCLUDESCPP
	 * @model literal="FILE_INCLUDES_CPP"
	 * @generated
	 * @ordered
	 */
    public static final int FILEINCLUDESCPP_VALUE = 5;

    /**
	 * The '<em><b>CONSTRUCTORINITLIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CONSTRUCTORINITLIST</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CONSTRUCTORINITLIST
	 * @model literal="CONSTRUCTOR_INIT_LIST"
	 * @generated
	 * @ordered
	 */
    public static final int CONSTRUCTORINITLIST_VALUE = 6;

    /**
	 * The '<em><b>CLASSGENERATEDOPERATIONIMPL</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSGENERATEDOPERATIONIMPL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDOPERATIONIMPL
	 * @model literal="CLASS_GENERATED_OPERATION_IMPL"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSGENERATEDOPERATIONIMPL_VALUE = 7;

    /**
	 * The '<em><b>CLASSGENERATEDATTRIBUTEGET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASSGENERATEDATTRIBUTEGET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDATTRIBUTEGET
	 * @model literal="CLASS_GENERATED_ATTRIBUTE_GET"
	 * @generated
	 * @ordered
	 */
	public static final int CLASSGENERATEDATTRIBUTEGET_VALUE = 8;

				/**
	 * The '<em><b>CLASSGENERATEDATTRIBUTESET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASSGENERATEDATTRIBUTESET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASSGENERATEDATTRIBUTESET
	 * @model literal="CLASS_GENERATED_ATTRIBUTE_SET"
	 * @generated
	 * @ordered
	 */
	public static final int CLASSGENERATEDATTRIBUTESET_VALUE = 9;

				/**
	 * The '<em><b>CLASSPUBLICMETHODSSECTIONDECLARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSPUBLICMETHODSSECTIONDECLARE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSPUBLICMETHODSSECTIONDECLARE
	 * @model literal="CLASS_PUBLIC_METHODS_SECTION_DECLARE"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSPUBLICMETHODSSECTIONDECLARE_VALUE = 10;

    /**
	 * The '<em><b>CLASSPUBLICMETHODSSECTIONIMPL</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSPUBLICMETHODSSECTIONIMPL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSPUBLICMETHODSSECTIONIMPL
	 * @model literal="CLASS_PUBLIC_METHODS_SECTION_IMPL"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSPUBLICMETHODSSECTIONIMPL_VALUE = 11;

    /**
	 * The '<em><b>CLASSPRIVATEMETHODSSECTIONDECLARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSPRIVATEMETHODSSECTIONDECLARE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMETHODSSECTIONDECLARE
	 * @model literal="CLASS_PRIVATE_METHODS_SECTION_DECLARE"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSPRIVATEMETHODSSECTIONDECLARE_VALUE = 12;

    /**
	 * The '<em><b>CLASSPRIVATEMETHODSSECTIONIMPL</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSPRIVATEMETHODSSECTIONIMPL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMETHODSSECTIONIMPL
	 * @model literal="CLASS_PRIVATE_METHODS_SECTION_IMPL"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSPRIVATEMETHODSSECTIONIMPL_VALUE = 13;

    /**
	 * The '<em><b>CLASSPRIVATEMEMBERSSECTIONDECLARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CLASSPRIVATEMEMBERSSECTIONDECLARE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #CLASSPRIVATEMEMBERSSECTIONDECLARE
	 * @model literal="CLASS_PRIVATE_MEMBERS_SECTION_DECLARE"
	 * @generated
	 * @ordered
	 */
    public static final int CLASSPRIVATEMEMBERSSECTIONDECLARE_VALUE = 14;

    /**
	 * An array of all the '<em><b>Code Tag Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static final CodeTagType[] VALUES_ARRAY =
        new CodeTagType[] {
			FILEHEADERH,
			FILEHEADERCPP,
			FILEFOOTERH,
			FILEFOOTERCPP,
			FILEINCLUDESH,
			FILEINCLUDESCPP,
			CONSTRUCTORINITLIST,
			CLASSGENERATEDOPERATIONIMPL,
			CLASSGENERATEDATTRIBUTEGET,
			CLASSGENERATEDATTRIBUTESET,
			CLASSPUBLICMETHODSSECTIONDECLARE,
			CLASSPUBLICMETHODSSECTIONIMPL,
			CLASSPRIVATEMETHODSSECTIONDECLARE,
			CLASSPRIVATEMETHODSSECTIONIMPL,
			CLASSPRIVATEMEMBERSSECTIONDECLARE,
		};

    /**
	 * A public read-only list of all the '<em><b>Code Tag Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final List<CodeTagType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
	 * Returns the '<em><b>Code Tag Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static CodeTagType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CodeTagType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Code Tag Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static CodeTagType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CodeTagType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Code Tag Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static CodeTagType get(int value) {
		switch (value) {
			case FILEHEADERH_VALUE: return FILEHEADERH;
			case FILEHEADERCPP_VALUE: return FILEHEADERCPP;
			case FILEFOOTERH_VALUE: return FILEFOOTERH;
			case FILEFOOTERCPP_VALUE: return FILEFOOTERCPP;
			case FILEINCLUDESH_VALUE: return FILEINCLUDESH;
			case FILEINCLUDESCPP_VALUE: return FILEINCLUDESCPP;
			case CONSTRUCTORINITLIST_VALUE: return CONSTRUCTORINITLIST;
			case CLASSGENERATEDOPERATIONIMPL_VALUE: return CLASSGENERATEDOPERATIONIMPL;
			case CLASSGENERATEDATTRIBUTEGET_VALUE: return CLASSGENERATEDATTRIBUTEGET;
			case CLASSGENERATEDATTRIBUTESET_VALUE: return CLASSGENERATEDATTRIBUTESET;
			case CLASSPUBLICMETHODSSECTIONDECLARE_VALUE: return CLASSPUBLICMETHODSSECTIONDECLARE;
			case CLASSPUBLICMETHODSSECTIONIMPL_VALUE: return CLASSPUBLICMETHODSSECTIONIMPL;
			case CLASSPRIVATEMETHODSSECTIONDECLARE_VALUE: return CLASSPRIVATEMETHODSSECTIONDECLARE;
			case CLASSPRIVATEMETHODSSECTIONIMPL_VALUE: return CLASSPRIVATEMETHODSSECTIONIMPL;
			case CLASSPRIVATEMEMBERSSECTIONDECLARE_VALUE: return CLASSPRIVATEMEMBERSSECTIONDECLARE;
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
    private CodeTagType(int value, String name, String literal) {
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
    
} //CodeTagType
