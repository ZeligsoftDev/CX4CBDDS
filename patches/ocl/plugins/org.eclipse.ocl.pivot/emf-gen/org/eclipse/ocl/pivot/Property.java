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
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.PropertyId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getAssociationClass <em>Association Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getDefaultValueString <em>Default Value String</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#isIsVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getRedefinedProperties <em>Redefined Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Property#getSubsettedProperty <em>Subsetted Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty()
 * @generated
 */
@SuppressWarnings("unused")
public interface Property extends Feature {

	/**
	 * Returns the value of the '<em><b>Association Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Class</em>' reference.
	 * @see #setAssociationClass(AssociationClass)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_AssociationClass()
	 * @see org.eclipse.ocl.pivot.AssociationClass#getUnownedAttributes
	 * @generated
	 */
	AssociationClass getAssociationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getAssociationClass <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Class</em>' reference.
	 * @see #getAssociationClass()
	 * @generated
	 */
	void setAssociationClass(AssociationClass value);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsReadOnly <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Read Only</em>' attribute.
	 * @see #isIsReadOnly()
	 * @generated
	 */
	void setIsReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Resolve Proxies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #setIsResolveProxies(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsResolveProxies()
	 * @generated
	 */
	boolean isIsResolveProxies();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsComposite <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Composite</em>' attribute.
	 * @see #isIsComposite()
	 * @generated
	 */
	void setIsComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsDerived()
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Is ID</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True indicates this property can be used to uniquely identify an instance of the containing Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is ID</em>' attribute.
	 * @see #setIsID(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsID()
	 * @generated
	 */
	boolean isIsID();

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In the case where the Property is one end of a binary association this gives the other end.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(Property)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_Opposite()
	 * @generated
	 */
	Property getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(Property value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(LanguageExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_OwnedExpression()
	 * @generated
	 */
	LanguageExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(LanguageExpression value);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isReadOnly is true, the StructuralFeature may not be written to after initialization.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Read Only</em>' attribute.
	 * @see #setIsReadOnly(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsReadOnly()
	 * @generated
	 */
	boolean isIsReadOnly();

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(Object)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_DefaultValue()
	 * @generated
	 */
	Object getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(Object value);

	/**
	 * Returns the value of the '<em><b>Default Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value String</em>' attribute.
	 * @see #setDefaultValueString(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_DefaultValueString()
	 * @generated
	 */
	String getDefaultValueString();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getDefaultValueString <em>Default Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value String</em>' attribute.
	 * @see #getDefaultValueString()
	 * @generated
	 */
	void setDefaultValueString(String value);

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see #setIsComposite(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsComposite()
	 * @generated
	 */
	boolean isIsComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsID <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is ID</em>' attribute.
	 * @see #isIsID()
	 * @generated
	 */
	void setIsID(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Implicit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Implicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Implicit</em>' attribute.
	 * @see #setIsImplicit(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsImplicit()
	 * @generated
	 */
	boolean isIsImplicit();

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_Keys()
	 * @generated
	 */
	@NonNull List<Property> getKeys();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsResolveProxies <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #isIsResolveProxies()
	 * @generated
	 */
	void setIsResolveProxies(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsTransient()
	 * @generated
	 */
	boolean isIsTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isIsTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unsettable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unsettable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unsettable</em>' attribute.
	 * @see #setIsUnsettable(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsUnsettable()
	 * @generated
	 */
	boolean isIsUnsettable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsUnsettable <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unsettable</em>' attribute.
	 * @see #isIsUnsettable()
	 * @generated
	 */
	void setIsUnsettable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Volatile</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Volatile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Volatile</em>' attribute.
	 * @see #setIsVolatile(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_IsVolatile()
	 * @generated
	 */
	boolean isIsVolatile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#isIsVolatile <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Volatile</em>' attribute.
	 * @see #isIsVolatile()
	 * @generated
	 */
	void setIsVolatile(boolean value);

	/**
	 * Returns the value of the '<em><b>Subsetted Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsetted Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties of which this Property is constrained to be a subset, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subsetted Property</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_SubsettedProperty()
	 * @generated
	 */
	List<Property> getSubsettedProperty();

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_ReferredProperty()
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean isAttribute(Property p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleDefaultExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Class#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Class that owns this Property, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_OwningClass()
	 * @see org.eclipse.ocl.pivot.Class#getOwnedProperties
	 * @generated
	 */
	@Override
	org.eclipse.ocl.pivot.Class getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Property#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Redefined Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties that are redefined by this property, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined Properties</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getProperty_RedefinedProperties()
	 * @generated
	 */
	@NonNull List<Property> getRedefinedProperties();

	@NonNull PropertyId getPropertyId();

	/**
	 * Return the Inheritance dispatch table for the owning type, or null for an orphan property owned by an Annotation.
	 */
	@Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary);

	/**
	 * Initialize the value of this property within objectValue to propertyValue.
	 * <p>
	 * This method is not thread-safe and should only be invoked to complete construction of objectvalue before
	 * making it visible to other threads.
	 */
	void initValue(@NonNull Object object, @Nullable Object ecoreValue);
} // Property
