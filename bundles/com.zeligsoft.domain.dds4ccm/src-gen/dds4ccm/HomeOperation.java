/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Home Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.HomeOperation#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getHomeOperation()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL ownedParameter='ownedParameter' owner='owner' exceptionDef='raisedException'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface HomeOperation extends CXNamedElement, WorkerFunctionIdentifiable {
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
	 * @see dds4ccm.DDS4CCMPackage#getHomeOperation_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link dds4ccm.HomeOperation#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // HomeOperation
