/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template binding in which the arguments are matched to formal template parameters by name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NamedTemplateBinding#getSubstitution <em>Substitution</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamedTemplateBinding()
 * @model
 * @generated
 */
public interface NamedTemplateBinding extends TemplateBinding {
	/**
	 * Returns the value of the '<em><b>Substitution</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The substitutions of arguments for template parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Substitution</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamedTemplateBinding_Substitution()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<TemplateParameterSubstitution> getSubstitution();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            \'<\' + \n            self.substitution->iterate(substitution : TemplateParameterSubstitution; s : String = \'\' | \n              if s = \'\' then substitution.toString()\n              else s + \',\' + substitution.toString()\n              endif\n            ) + \n            \'>\''"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" templateRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let parameters = template.templateParameters() in \n              parameters->size() = self.substitution->size() and \n              parameters->forAll(p | self.matchesParameter(p))'"
	 * @generated
	 */
	boolean matches(ElementReference template);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" parameterRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            self.substitution->exists(\n              parameterName = parameter.name() and\n              referent <> null and\n              parameter.parents()->forAll(c | referent.conformsTo(c))\n            )'"
	 * @generated
	 */
	boolean matchesParameter(ElementReference parameter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" templateRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            template.templateParameters()->collect(p |\n              let substitutions = self.substitution->select(actualParameterName() = p.name()) \n              in\n                if substitutions->size() = 1 then substitutions.referent->asSequence()\n                else Sequence(ElementReference){} endif\n            )'"
	 * @generated
	 */
	EList<ElementReference> bindTo(ElementReference template);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NamedTemplateBinding{substitution = self.substitution.copy()}'"
	 * @generated
	 */
	TemplateBinding copy();

} // NamedTemplateBinding
