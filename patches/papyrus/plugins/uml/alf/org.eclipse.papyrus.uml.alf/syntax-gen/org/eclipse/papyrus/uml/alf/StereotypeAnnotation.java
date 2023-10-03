/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An annotation of a member definition indicating the application of a stereotype (or one of a small number of special-case annotations).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getTaggedValues <em>Tagged Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getNames <em>Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getStereotypeName <em>Stereotype Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStereotypeAnnotation()
 * @model
 * @generated
 */
public interface StereotypeAnnotation extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Tagged Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A set of tagged values for the applied stereotype.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tagged Values</em>' containment reference.
	 * @see #setTaggedValues(TaggedValueList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStereotypeAnnotation_TaggedValues()
	 * @model containment="true"
	 * @generated
	 */
	TaggedValueList getTaggedValues();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getTaggedValues <em>Tagged Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tagged Values</em>' containment reference.
	 * @see #getTaggedValues()
	 * @generated
	 */
	void setTaggedValues(TaggedValueList value);

	/**
	 * Returns the value of the '<em><b>Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A set of references to model elements required for the stereotype being applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Names</em>' containment reference.
	 * @see #setNames(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStereotypeAnnotation_Names()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedNameList getNames();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getNames <em>Names</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Names</em>' containment reference.
	 * @see #getNames()
	 * @generated
	 */
	void setNames(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>Stereotype Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the stereotype being applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stereotype Name</em>' containment reference.
	 * @see #setStereotypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStereotypeAnnotation_StereotypeName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getStereotypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getStereotypeName <em>Stereotype Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Name</em>' containment reference.
	 * @see #getStereotypeName()
	 * @generated
	 */
	void setStereotypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The stereotype denoted by the stereotype name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stereotype</em>' reference.
	 * @see #setStereotype(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStereotypeAnnotation_Stereotype()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                  let profiles = self.appliedProfiles() in\n                  let qualification = self.stereotypeName.qualification in\n                  let name = self.stereotypeName.unqualifiedName.toName() in\n                    if self.stereotypeName.qualification = null then\n                      let standardProfile = profiles->select(name() = \'StandardProfile\') in\n                      let standardStereotype = standardProfile.resolveStereotype(name) in\n                        if standardStereotype->size() = 1 then\n                          standardStereotype->any(true)\n                        else\n                          let stereotype = profiles.resolveStereotype(name) in\n                          if stereotype->size() = 1 then\n                            stereotype->any(true)\n                          else\n                            null\n                          endif\n                        endif\n                    else\n                      let profile = profiles->select(qualifiedName() = qualification.pathName) in\n                        if profile->size() = 1 then\n                          let stereotype = profile.resolveStereotype(name) in\n                            if stereotype->size() = 1 then\n                              stereotype->any(true)\n                            else\n                              null\n                            endif\n                        else\n                          null\n                        endif\n                    endif'"
	 * @generated
	 */
	ElementReference getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation#getStereotype <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unless the stereotype name is "apply", "primitive" or "external" then the stereotype for a stereotype annotation is the stereotype denoted by the stereotype name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean stereotypeAnnotationStereotypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The stereotype name of a stereotype annotation must either be one of "apply",
	 * "primitive" or "external", or it must denote a single stereotype from a profile
	 * applied to an enclosing package. The stereotype name does not need to be qualified
	 * if there is only one applied profile with a stereotype of that name or if the
	 * there is a standard UML profile with the name.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                let name = self.stereotypeName.pathName in \n                  name = \'apply\' or name = \'primitive\' or name = \'external\' or\n                  self.stereotype <> null'"
	 * @generated
	 */
	boolean stereotypeAnnotationStereotypeName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the stereotype name of a stereotype annotation is "apply", then it must have a name list and all of the names in the list must resolve to profiles.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.stereotypeName.pathName = \'apply\' implies names->notEmpty()'"
	 * @generated
	 */
	boolean stereotypeAnnotationApply(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the stereotype name of a stereotype annotation is "primitive", then it may not have tagged values or names.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.stereotypeName.pathName = \'primitive\' implies\n                  (self.taggedValues = null and self.names = null)'"
	 * @generated
	 */
	boolean stereotypeAnnotationPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the stereotype name of a stereotype annotation is "external", then it may optionally have a single tagged value with the name "file" and no operator.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.stereotypeName.pathName = \'external\' implies\n                  (self.names = null and \n                    (self.taggedValues = null or \n                      self.taggedValues.taggedValue->size() = 1 and \n                      self.taggedValues.taggedValue->exists(\n                        name = \'file\' and operator = null\n                      )\n                    )\n                  )'"
	 * @generated
	 */
	boolean stereotypeAnnotationExternal(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a stereotype annotation has a stereotype and tagged values, then the each tagged value must have the name of an attribute of the stereotype and a value that is legally interpretable for the type of that attribute.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean stereotypeAnnotationTaggedValues(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a stereotype annotation has a stereotype and a list of names, then all the names in the list must resolve to visible model elements and the stereotype must have a single attribute with a (metaclass) type and multiplicity that are consistent with the types and number of the elements denoted by the given names.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean stereotypeAnnotationNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n  let owner = self.owner() in\n    if owner.oclIsKindOf(UnitDefinition) then\n      owner.oclAsType(UnitDefinition).appliedProfile\n    else\n      self.currentScope().appliedProfiles()\n    endif'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

} // StereotypeAnnotation
