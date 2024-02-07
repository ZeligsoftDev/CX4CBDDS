/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of an active class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ActiveClassDefinition#getClassifierBehavior <em>Classifier Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getActiveClassDefinition()
 * @model
 * @generated
 */
public interface ActiveClassDefinition extends ClassDefinition {
	/**
	 * Returns the value of the '<em><b>Classifier Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The definition of an activity (which may be a stub) to act as the classifier behavior of the active class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classifier Behavior</em>' containment reference.
	 * @see #setClassifierBehavior(ActivityDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getActiveClassDefinition_ClassifierBehavior()
	 * @model containment="true"
	 * @generated
	 */
	ActivityDefinition getClassifierBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ActiveClassDefinition#getClassifierBehavior <em>Classifier Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier Behavior</em>' containment reference.
	 * @see #getClassifierBehavior()
	 * @generated
	 */
	void setClassifierBehavior(ActivityDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this active class definition
	 * considered as a class definition and the subunit is for an active class definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* NOTE: ClassDefinition::matchForStub would not allow an ActiveClassDefinition. \052/\n                        self.ClassifierDefinition_matchForStub(unit) and\n                        unit.definition.oclIsKindOf(ActiveClassDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an active class definition is not abstract, then it must have a classifier behavior.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      not self.isAbstract implies self.classifierBehavior <> null'"
	 * @generated
	 */
	boolean activeClassDefinitionClassifierBehavior(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ActiveClassDefinition
