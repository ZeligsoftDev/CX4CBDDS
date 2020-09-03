/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Param Direction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getParamDirection()
 * @model
 * @generated
 */
public enum ParamDirection implements Enumerator
{
  /**
   * The '<em><b>In</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_VALUE
   * @generated
   * @ordered
   */
  IN(0, "In", "in"),

  /**
   * The '<em><b>Out</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_VALUE
   * @generated
   * @ordered
   */
  OUT(1, "Out", "out"),

  /**
   * The '<em><b>In Out</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_VALUE
   * @generated
   * @ordered
   */
  IN_OUT(2, "InOut", "inout"),

  /**
   * The '<em><b>Return</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RETURN_VALUE
   * @generated
   * @ordered
   */
  RETURN(3, "Return", "return");

  /**
   * The '<em><b>In</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN
   * @model name="In" literal="in"
   * @generated
   * @ordered
   */
  public static final int IN_VALUE = 0;

  /**
   * The '<em><b>Out</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT
   * @model name="Out" literal="out"
   * @generated
   * @ordered
   */
  public static final int OUT_VALUE = 1;

  /**
   * The '<em><b>In Out</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT
   * @model name="InOut" literal="inout"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_VALUE = 2;

  /**
   * The '<em><b>Return</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RETURN
   * @model name="Return" literal="return"
   * @generated
   * @ordered
   */
  public static final int RETURN_VALUE = 3;

  /**
   * An array of all the '<em><b>Param Direction</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ParamDirection[] VALUES_ARRAY =
    new ParamDirection[]
    {
      IN,
      OUT,
      IN_OUT,
      RETURN,
    };

  /**
   * A public read-only list of all the '<em><b>Param Direction</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ParamDirection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Param Direction</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ParamDirection get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ParamDirection result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Param Direction</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ParamDirection getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ParamDirection result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Param Direction</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ParamDirection get(int value)
  {
    switch (value)
    {
      case IN_VALUE: return IN;
      case OUT_VALUE: return OUT;
      case IN_OUT_VALUE: return IN_OUT;
      case RETURN_VALUE: return RETURN;
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
  private ParamDirection(int value, String name, String literal)
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
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  
} //ParamDirection
