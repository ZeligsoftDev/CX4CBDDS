/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.TaggedValue;
import org.eclipse.papyrus.uml.alf.TaggedValueList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TaggedValueListImpl#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedValueListImpl extends SyntaxElementImpl implements TaggedValueList {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedValueListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getTaggedValueList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TaggedValue> getTaggedValue() {
		return (EList<TaggedValue>)eGet(AlfPackage.eINSTANCE.getTaggedValueList_TaggedValue(), true);
	}

} // TaggedValueListImpl
