/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.
 *
 * A model element that has both Association and Class properties. An AssociationClass can be seen as an Association that also has Class properties, or as a Class that also has Association properties. It not only connects a set of Classifiers but also defines a set of Features that belong to the Association itself and not to any of the associated Classifiers.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getAssociationClass()
 * @generated
 */
public interface AssociationClass
extends org.eclipse.ocl.pivot.Class {

	/**
	 * Returns the value of the '<em><b>Unowned Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Property#getAssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unowned Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unowned Attributes</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAssociationClass_UnownedAttributes()
	 * @see org.eclipse.ocl.pivot.Property#getAssociationClass
	 * @generated
	 */
	List<Property> getUnownedAttributes();

} // AssociationClass
