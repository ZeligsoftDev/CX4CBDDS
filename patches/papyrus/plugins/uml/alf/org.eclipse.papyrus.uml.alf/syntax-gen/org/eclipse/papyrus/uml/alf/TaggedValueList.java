/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A set of tagged values for a stereotype application.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TaggedValueList#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValueList()
 * @model
 * @generated
 */
public interface TaggedValueList extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.TaggedValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tagged values in the set.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tagged Value</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValueList_TaggedValue()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<TaggedValue> getTaggedValue();

} // TaggedValueList
