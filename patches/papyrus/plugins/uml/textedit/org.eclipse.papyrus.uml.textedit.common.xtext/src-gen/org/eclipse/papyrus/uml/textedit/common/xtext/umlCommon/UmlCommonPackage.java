/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonFactory
 * @model kind="package"
 * @generated
 */
public interface UmlCommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlCommon";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/common/xtext/UmlCommon";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlCommon";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlCommonPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.QualifiedNameImpl
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getQualifiedName()
	 * @generated
	 */
	int QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME__PATH = 0;

	/**
	 * The feature id for the '<em><b>Remaining</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME__REMAINING = 1;

	/**
	 * The number of structural features of the '<em>Qualified Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl <em>Type Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getTypeRule()
	 * @generated
	 */
	int TYPE_RULE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE__PATH = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Type Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.MultiplicityRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getMultiplicityRule()
	 * @generated
	 */
	int MULTIPLICITY_RULE = 2;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_RULE__BOUNDS = 0;

	/**
	 * The number of structural features of the '<em>Multiplicity Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.BoundSpecificationImpl
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getBoundSpecification()
	 * @generated
	 */
	int BOUND_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOUND_SPECIFICATION__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Bound Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOUND_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind <em>Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getVisibilityKind()
	 * @generated
	 */
	int VISIBILITY_KIND = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName
	 * @generated
	 */
	EClass getQualifiedName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Path</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName#getPath()
	 * @see #getQualifiedName()
	 * @generated
	 */
	EReference getQualifiedName_Path();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName#getRemaining <em>Remaining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Remaining</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName#getRemaining()
	 * @see #getQualifiedName()
	 * @generated
	 */
	EReference getQualifiedName_Remaining();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule <em>Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule
	 * @generated
	 */
	EClass getTypeRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Path</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule#getPath()
	 * @see #getTypeRule()
	 * @generated
	 */
	EReference getTypeRule_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule#getType()
	 * @see #getTypeRule()
	 * @generated
	 */
	EReference getTypeRule_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule <em>Multiplicity Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multiplicity Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule
	 * @generated
	 */
	EClass getMultiplicityRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Bounds</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule#getBounds()
	 * @see #getMultiplicityRule()
	 * @generated
	 */
	EReference getMultiplicityRule_Bounds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification <em>Bound Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Bound Specification</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification
	 * @generated
	 */
	EClass getBoundSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification#getValue()
	 * @see #getBoundSpecification()
	 * @generated
	 */
	EAttribute getBoundSpecification_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Visibility Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
	 * @generated
	 */
	EEnum getVisibilityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction
	 * @generated
	 */
	EEnum getDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlCommonFactory getUmlCommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.QualifiedNameImpl
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getQualifiedName()
		 * @generated
		 */
		EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUALIFIED_NAME__PATH = eINSTANCE.getQualifiedName_Path();

		/**
		 * The meta object literal for the '<em><b>Remaining</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUALIFIED_NAME__REMAINING = eINSTANCE.getQualifiedName_Remaining();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl <em>Type Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getTypeRule()
		 * @generated
		 */
		EClass TYPE_RULE = eINSTANCE.getTypeRule();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPE_RULE__PATH = eINSTANCE.getTypeRule_Path();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPE_RULE__TYPE = eINSTANCE.getTypeRule_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.MultiplicityRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getMultiplicityRule()
		 * @generated
		 */
		EClass MULTIPLICITY_RULE = eINSTANCE.getMultiplicityRule();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTIPLICITY_RULE__BOUNDS = eINSTANCE.getMultiplicityRule_Bounds();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.BoundSpecificationImpl
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getBoundSpecification()
		 * @generated
		 */
		EClass BOUND_SPECIFICATION = eINSTANCE.getBoundSpecification();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOUND_SPECIFICATION__VALUE = eINSTANCE.getBoundSpecification_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind <em>Visibility Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getVisibilityKind()
		 * @generated
		 */
		EEnum VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction <em>Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction
		 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonPackageImpl#getDirection()
		 * @generated
		 */
		EEnum DIRECTION = eINSTANCE.getDirection();

	}

} // UmlCommonPackage
