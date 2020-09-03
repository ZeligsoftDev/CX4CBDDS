/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDL Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getIDLComment()
 * @model
 * @generated
 */
public interface IDLComment extends Definition, Export, ComponentExport, PortExport, ConnectorExport, TemplateDefinition, FixedDefinition
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' attribute.
   * @see #setBody(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getIDLComment_Body()
   * @model
   * @generated
   */
  String getBody();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment#getBody <em>Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' attribute.
   * @see #getBody()
   * @generated
   */
  void setBody(String value);

} // IDLComment
