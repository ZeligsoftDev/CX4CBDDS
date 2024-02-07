/**
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import java.util.Collections;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.StandardLibrary#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getStandardLibrary()
 * @generated
 */
public interface StandardLibrary extends Element
{
	/**
	 * @since 1.1
	 */
	public interface StandardLibraryExtension extends StandardLibrary {

		/**
		 * Obtains the single instance of the Class metatype, named
		 * <tt>OclEnumeration</tt>.
		 *
		 * @return the <tt>OclEnumeration</tt> type (an instance of Class)
		 */
		org.eclipse.ocl.pivot.@NonNull Class getOclEnumerationType();
	}

	/**
	 * Returns the value of the '<em><b>Owning Complete Environment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedStandardLibrary <em>Owned Standard Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Environment</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Environment</em>' container reference.
	 * @see #setOwningCompleteEnvironment(CompleteEnvironment)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStandardLibrary_OwningCompleteEnvironment()
	 * @see org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedStandardLibrary
	 * @generated
	 */
	CompleteEnvironment getOwningCompleteEnvironment();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.StandardLibrary#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Environment</em>' container reference.
	 * @see #getOwningCompleteEnvironment()
	 * @generated
	 */
	void setOwningCompleteEnvironment(CompleteEnvironment value);

	@NonNull Iterable<@NonNull ? extends CompletePackage> getAllCompletePackages();

	/**
	 * Obtains the generic instance of the BagType metatype, named
	 * <tt>Bag(T)</tt>.
	 *
	 * @return the <tt>Bag(T)</tt> type (an instance of BagType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getBagType();

	/**
	 * Obtains the instance of the PrimitiveType metatype, named
	 * <tt>Boolean</tt>.
	 *
	 * @return the <tt>Boolean</tt> type (an instance of PrimitiveType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getBooleanType();

	/**
	 * Obtains the single instance of the org.eclipse.ocl.pivot.Class metatype, named
	 * <tt>Class</tt>.
	 *
	 * @return the <tt>Class</tt> type (an instance of Class)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getClassType();

	/**
	 * Obtains the generic instance of the CollectionType metatype, named
	 * <tt>Collection(T)</tt>.
	 *
	 * @return the <tt>Collection(T)</tt> type (an instance of CollectionType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getCollectionType();

	/**
	 * @deprecated add isNullFree argument
	 */
	@Deprecated
	@NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
	@NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	/**
	 * Obtains the single instance of the EnumerationType metatype, named
	 * <tt>Enumeration</tt>.
	 *
	 * @return the <tt>Enumeration</tt> type (an instance of Enumeration)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getEnumerationType();

	/**
	 * Return the Inheritance dispatch table for a given type.
	 */
	@NonNull CompleteInheritance getInheritance(org.eclipse.ocl.pivot.@NonNull Class type);

	/**
	 * Obtains the instance of the PrimitiveType metatype, named
	 * <tt>Integer</tt>.
	 *
	 * @return the <tt>Integer</tt> type (an instance of PrimitiveType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getIntegerType();

	org.eclipse.ocl.pivot.@NonNull Class getMapType();

	@NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type keyType, @NonNull Type valueType);

	/**
	 * Return the metaclass to which classType conforms.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getMetaclass(@NonNull Type classType);

	/**
	 * Returns the meta-type of a given type.
	 */
	@Deprecated /* @deprecated use getMetaclass */
	@NonNull Type getMetaType(@NonNull Type type);

	org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI);

	/**
	 * Return the known nsURIs
	 *
	 * @since 1.14
	 */
	default @NonNull Set<@NonNull String> getNsURIs() { return Collections.emptySet(); }

	/**
	 * Obtains the single instance of the AnyType metatype, named
	 * <tt>OclAny</tt>.
	 *
	 * @return the <tt>OclAny</tt> type (an instance of AnyType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclAnyType();

	/**
	 * Obtains the single instance of the OclComparable metatype, named
	 * <tt>OclAny</tt>.
	 *
	 * @return the <tt>OclAny</tt> type (an instance of Class)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclComparableType();

	/**
	 * Obtains the single instance of the Class metatype, named
	 * <tt>OclElement</tt>.
	 *
	 * @return the <tt>OclElement</tt> type (an instance of Class)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclElementType();

	@NonNull Operation getOclInvalidOperation();

	/**
	 * @since 1.4
	 */
	@NonNull Property getOclInvalidProperty();

	/**
	 * Obtains the single instance of the InvalidType metatype, named
	 * <tt>OclInvalid</tt>.
	 *
	 * @return the <tt>OclInvalid</tt> type (an instance of InvalidType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclInvalidType();

	/**
	 * Obtains the generic instance of the MessageType metatype, named
	 * <tt>OclMessage</tt>.
	 *
	 * @return the <tt>OclMessage</tt> type (an instance of MessageType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclMessageType();

	/**
	 * Obtains the single instance of the OclSelf pseudo-metatype, named
	 * <tt>OclSelf</tt>.
	 *
	 * @return the <tt>OclSelf</tt> type (an instance of SelfType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclSelfType();

	/**
	 * Obtains the single instance of the OclStereotype metatype, named
	 * <tt>OclStereotype</tt>.
	 *
	 * @return the <tt>OclStereotype</tt> type (an instance of Class)
	 * @since 1.1
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclStereotypeType();

	/**
	 * Obtains the single instance of the OclSummable metatype, named
	 * <tt>OclAny</tt>.
	 *
	 * @return the <tt>OclAny</tt> type (an instance of Class)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclSummableType();

	/**
	 * Obtains the single instance of the OclTupleType metatype, named
	 * <tt>OclVoid</tt>.
	 *
	 * @return the <tt>OclTuple</tt> type (an instance of Class)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclTupleType();

	Type getOclType(@NonNull String typeName);

	/**
	 * Obtains the single instance of the VoidType metatype, named
	 * <tt>OclVoid</tt>.
	 *
	 * @return the <tt>OclVoid</tt> type (an instance of VoidType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOclVoidType();

	Element getOperationTemplateParameter(@NonNull Operation anOperation, int index);

	/**
	 * Obtains the generic instance of the OrderedCollection metatype, named
	 * <tt>OrderedCollection(T)</tt>.
	 *
	 * @return the <tt>OrderedCollection(T)</tt> type (an instance of CollectionType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOrderedCollectionType();

	/**
	 * Obtains the generic instance of the OrderedSetType metatype, named
	 * <tt>OrderedSet(T)</tt>.
	 *
	 * @return the <tt>OrderedSet(T)</tt> type (an instance of OrderedSetType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getOrderedSetType();

	/**
	 * Obtains the package containing the library types
	 */
	org.eclipse.ocl.pivot.@NonNull Package getPackage();

	Type getPrimitiveType(@NonNull PrimitiveTypeId id);

	/**
	 * Obtains the instance of the PrimitiveType metatype, named
	 * <tt>Real</tt>.
	 *
	 * @return the <tt>Real</tt> type (an instance of PrimitiveType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getRealType();

	org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String name);

	/**
	 * Obtains the generic instance of the SequenceType metatype, named
	 * <tt>Sequence(T)</tt>.
	 *
	 * @return the <tt>Sequence(T)</tt> type (an instance of SequenceType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getSequenceType();

	/**
	 * Obtains the generic instance of the SetType metatype, named
	 * <tt>Set(T)</tt>.
	 *
	 * @return the <tt>Set(T)</tt> type (an instance of SetType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getSetType();

	/**
	 * Obtains the instance of the PrimitiveType metatype, named
	 * <tt>String</tt>.
	 *
	 * @return the <tt>String</tt> type (an instance of PrimitiveType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getStringType();

	/**
	 * Obtains the generic instance of the UniqueCollection metatype, named
	 * <tt>Set(T)</tt>.
	 *
	 * @return the <tt>Set(T)</tt> type (an instance of CollectionType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getUniqueCollectionType();

	/**
	 * Obtains the instance of the PrimitiveType metatype,
	 * named <tt>UnlimitedNatural</tt>.
	 *
	 * @return the <tt>UnlimitedNatural</tt> type (an instance of
	 *     PrimitiveType)
	 */
	org.eclipse.ocl.pivot.@NonNull Class getUnlimitedNaturalType();
} // StandardLibrary
