/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.WorkerFunction#getReceivingPort <em>Receiving Port</em>}</li>
 *   <li>{@link dds4ccm.WorkerFunction#getPortOperation <em>Port Operation</em>}</li>
 *   <li>{@link dds4ccm.WorkerFunction#getBody <em>Body</em>}</li>
 *   <li>{@link dds4ccm.WorkerFunction#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.WorkerFunction#isDelegate <em>Delegate</em>}</li>
 *   <li>{@link dds4ccm.WorkerFunction#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL parameter='ownedParameter'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface WorkerFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Receiving Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiving Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiving Port</em>' reference.
	 * @see #setReceivingPort(Port)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_ReceivingPort()
	 * @model ordered="false"
	 * @generated
	 */
	Port getReceivingPort();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#getReceivingPort <em>Receiving Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiving Port</em>' reference.
	 * @see #getReceivingPort()
	 * @generated
	 */
	void setReceivingPort(Port value);

	/**
	 * Returns the value of the '<em><b>Port Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Operation</em>' reference.
	 * @see #setPortOperation(Operation)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_PortOperation()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getPortOperation();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#getPortOperation <em>Port Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Operation</em>' reference.
	 * @see #getPortOperation()
	 * @generated
	 */
	void setPortOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_Body()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_Uuid()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate</em>' attribute.
	 * @see #setDelegate(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_Delegate()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDelegate();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#isDelegate <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate</em>' attribute.
	 * @see #isDelegate()
	 * @generated
	 */
	void setDelegate(boolean value);

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
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunction_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunction#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // WorkerFunction
