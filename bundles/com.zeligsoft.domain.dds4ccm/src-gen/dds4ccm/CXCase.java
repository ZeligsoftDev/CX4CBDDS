/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXCase#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXCase()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXCase extends CXUnionField {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute list.
	 * @see dds4ccm.DDS4CCMPackage#getCXCase_Label()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	EList<String> getLabel();

} // CXCase
