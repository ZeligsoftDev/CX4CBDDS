/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker Function Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.WorkerFunctionImpl#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getWorkerFunctionImpl()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL language='language' workerFunction='specification' body='body'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface WorkerFunctionImpl extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #setBase_OpaqueBehavior(OpaqueBehavior)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunctionImpl_Base_OpaqueBehavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OpaqueBehavior getBase_OpaqueBehavior();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunctionImpl#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #getBase_OpaqueBehavior()
	 * @generated
	 */
	void setBase_OpaqueBehavior(OpaqueBehavior value);

} // WorkerFunctionImpl
