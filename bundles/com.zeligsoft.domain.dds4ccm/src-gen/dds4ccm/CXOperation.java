/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXOperation#getIdlType <em>Idl Type</em>}</li>
 *   <li>{@link dds4ccm.CXOperation#isOneWay <em>Is One Way</em>}</li>
 *   <li>{@link dds4ccm.CXOperation#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXOperation()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL ownedParameter='ownedParameter' owner='owner' exceptionDef='raisedException'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXOperation extends CXNamedElement, WorkerFunctionIdentifiable, CXTyped {
	/**
	 * Returns the value of the '<em><b>Idl Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idl Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idl Type</em>' reference.
	 * @see #setIdlType(CXType)
	 * @see dds4ccm.DDS4CCMPackage#getCXOperation_IdlType()
	 * @model ordered="false"
	 * @generated
	 */
	CXType getIdlType();

	/**
	 * Sets the value of the '{@link dds4ccm.CXOperation#getIdlType <em>Idl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idl Type</em>' reference.
	 * @see #getIdlType()
	 * @generated
	 */
	void setIdlType(CXType value);

	/**
	 * Returns the value of the '<em><b>Is One Way</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is One Way</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is One Way</em>' attribute.
	 * @see #setIsOneWay(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getCXOperation_IsOneWay()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isOneWay();

	/**
	 * Sets the value of the '{@link dds4ccm.CXOperation#isOneWay <em>Is One Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is One Way</em>' attribute.
	 * @see #isOneWay()
	 * @generated
	 */
	void setIsOneWay(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Operation</em>' reference.
	 * @see #setBase_Operation(Operation)
	 * @see dds4ccm.DDS4CCMPackage#getCXOperation_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link dds4ccm.CXOperation#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // CXOperation
