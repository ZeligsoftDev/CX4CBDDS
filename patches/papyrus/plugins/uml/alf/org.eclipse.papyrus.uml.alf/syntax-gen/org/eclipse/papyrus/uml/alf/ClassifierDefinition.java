/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a classifier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifierDefinition#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifierDefinition#getSpecialization <em>Specialization</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifierDefinition#getSpecializationReferent <em>Specialization Referent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifierDefinition()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierDefinition extends NamespaceDefinition {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the classifier is abstract or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifierDefinition_IsAbstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifierDefinition#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The names of classifiers specialized by the classifier being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specialization</em>' containment reference.
	 * @see #setSpecialization(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifierDefinition_Specialization()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedNameList getSpecialization();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifierDefinition#getSpecialization <em>Specialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization</em>' containment reference.
	 * @see #getSpecialization()
	 * @generated
	 */
	void setSpecialization(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>Specialization Referent</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References to the classifiers to which the names in the specialization list resolve.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specialization Referent</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifierDefinition_SpecializationReferent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n    if self.specialization = null then OrderedSet{}\n    else self.specialization.name.referent->asOrderedSet()\n    endif'"
	 * @generated
	 */
	EList<ElementReference> getSpecializationReferent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NamespaceDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean ClassifierDefinition_annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace definition associated with the given unit definition must
	 * be a classifier definition. The subunit classifier definition may be abstract
	 * if and only if the subunit classifier definition is abstract. The subunit
	 * classifier definition must have the same specialization referents as the
	 * stub classifier definition. (Note that it is the referents that must match,
	 * not the exact names or the ordering of those names in the specialization list.)
	 * The subunit classifier definition must also have a matching classifier
	 * template parameter for each classifier template parameter of the stub classifier
	 * definition. Two template parameters match if they have same names and the same
	 * specialization referents.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ClassifierDefinition_matchForStub(unit)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                          unit.definition.oclIsKindOf(ClassifierDefinition) and\n                          let classifier = unit.definition.oclAsType(ClassifierDefinition) in\n                            classifier.isAbstract = self.isAbstract and\n                            classifier.specializationReferent->size() = self.specializationReferent->size() and\n                            classifier.specializationReferent->forAll(containedIn(self.specializationReferent->asBag())) and\n                            classifier.templateParameters()->size() = self.templateParameters()->size() and\n                            Sequence{1..classifier.templateParameters()->size()}->forAll(i |\n                              classifier.templateParameters()->at(i).matches(self.templateParameters()->at(i))\n                            )'"
	 * @generated
	 */
	boolean ClassifierDefinition_matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the members of a classifier definition including its inherited members.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.NamespaceDefinition_members()->\n                                                                        includingAll(self.inheritedMembers())->asOrderedSet()'"
	 * @generated
	 */
	EList<Member> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns all of the inherited members of this classifier definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    self.inherit(\n      self.specializationReferent.members()->select(visibility() <> \'private\').\n        asMember()->asOrderedSet()\n    )'"
	 * @generated
	 */
	EList<Member> inheritedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Define how to inherit a set of members. Here the operation is defined to inherit them all.
	 * It is intended to be redefined in circumstances where inheritance is affected by redefinition.
	 * <!-- end-model-doc -->
	 * @model membersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='members'"
	 * @generated
	 */
	EList<Member> inherit(EList<Member> members);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each name listed in the specialization list for a classifier definition must
	 * have a single classifier referent. None of these referents may be templates.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specialization = null or\n                      self.specialization.name->forAll(\n                        referent->size() = 1 and\n                        referent->forAll(isClassifier() and not isTemplate())\n                      )'"
	 * @generated
	 */
	boolean classifierDefinitionSpecialization(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialization referents of a classifier definition are the classifiers denoted by the
	 * names in the specialization list for the classifier definition.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifierDefinitionSpecializationReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The members of a classifier definition include non-private members inherited from the classifiers it specializes.
	 * The visibility of inherited members is as specified in the UML Superstructure, Subclause 7.3.8.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifierDefinitionInheritedMembers(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ClassifierDefinition
