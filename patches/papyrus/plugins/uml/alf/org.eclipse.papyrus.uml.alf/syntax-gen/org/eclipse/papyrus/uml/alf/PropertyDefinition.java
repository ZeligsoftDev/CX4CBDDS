/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A typed element definition for a property (attribute or association end).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#getInitializer <em>Initializer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#getTypePart <em>Type Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends MemberDefinition {
	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the property being defined has composite aggregation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see #setIsComposite(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition_IsComposite()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsComposite <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Composite</em>' attribute.
	 * @see #isIsComposite()
	 * @generated
	 */
	void setIsComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to initialize the property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(Expression value);

	/**
	 * Returns the value of the '<em><b>Is Collection Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether collection conversion is required for the initialization of this property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #setIsCollectionConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition_IsCollectionConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        self.initializer <> null and \n        self.initializer.type <> null and\n        self.isCollectionClass(self.initializer.type) and\n        (self.typePart.type = null or \n          not self.isCollectionClass(self.typePart.type)\n        )'"
	 * @generated
	 */
	boolean isIsCollectionConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsCollectionConversion <em>Is Collection Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #isIsCollectionConversion()
	 * @generated
	 */
	void setIsCollectionConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether BitString conversion is required for the initialization of this property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        self.typePart.type <> null and\n        self.isIntegerType(self.typePart.type) and\n        self.initializer.type <> null and\n        (self.isIntegerType(self.initializer.type) or\n          self.isIntegerCollectionClass(self.initializer.type)\n        )'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #isIsBitStringConversion()
	 * @generated
	 */
	void setIsBitStringConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Part</em>' containment reference.
	 * @see #setTypePart(TypedElementDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyDefinition_TypePart()
	 * @model containment="true"
	 * @generated
	 */
	TypedElementDefinition getTypePart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyDefinition#getTypePart <em>Type Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Part</em>' containment reference.
	 * @see #getTypePart()
	 * @generated
	 */
	void setTypePart(TypedElementDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Set(AssignedSource){}'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the annotation is for a stereotype that has a metaclass
	 * consistent with Property.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow property stereotype annotations. \052/\n                        false'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either a PropertyDefinition or an
	 * imported member whose referent is a PropertyDefinition or a Property.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isProperty()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a property definition has an initializer, then the initializer expression
	 * must be assignable to the property definition. There are no assignments before
	 * an initializer expression.
	 * (See also assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.initializer <> null implies \n          self.typePart.isAssignableFrom(self.initializer)'"
	 * @generated
	 */
	boolean propertyDefinitionInitializer(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A property definition requires collection conversion if its initializer has
	 * a collection class as its type and the property definition does not.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyDefinitionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A property definition requires BitString conversion if its type is BitString and
	 * the type of its initializer is Integer or a collection class whose argument type is Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyDefinitionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A property definition is a feature.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyDefinitionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PropertyDefinition
