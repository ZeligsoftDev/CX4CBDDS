/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXInterface#isLocal <em>Is Local</em>}</li>
 *   <li>{@link dds4ccm.CXInterface#isAsynchronous <em>Is Asynchronous</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXInterface()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL isAbstract='isAbstract' generals='general'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXInterface extends CXNamedElement, Interface, WorkerFunctionIdentifiable, Contained, CXClassifier, CXType {
	/**
	 * Returns the value of the '<em><b>Is Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Local</em>' attribute.
	 * @see #setIsLocal(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getCXInterface_IsLocal()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isLocal();

	/**
	 * Sets the value of the '{@link dds4ccm.CXInterface#isLocal <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Local</em>' attribute.
	 * @see #isLocal()
	 * @generated
	 */
	void setIsLocal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Asynchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Asynchronous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Asynchronous</em>' attribute.
	 * @see #setIsAsynchronous(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getCXInterface_IsAsynchronous()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAsynchronous();

	/**
	 * Sets the value of the '{@link dds4ccm.CXInterface#isAsynchronous <em>Is Asynchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Asynchronous</em>' attribute.
	 * @see #isAsynchronous()
	 * @generated
	 */
	void setIsAsynchronous(boolean value);

} // CXInterface
