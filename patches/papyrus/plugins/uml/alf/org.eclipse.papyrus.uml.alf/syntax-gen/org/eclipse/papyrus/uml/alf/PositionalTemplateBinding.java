/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Positional Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template binding in which the arguments are matched to formal template parameters in order by position.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PositionalTemplateBinding#getArgumentName <em>Argument Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPositionalTemplateBinding()
 * @model
 * @generated
 */
public interface PositionalTemplateBinding extends TemplateBinding {
	/**
	 * Returns the value of the '<em><b>Argument Name</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.QualifiedName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The arguments for this template binding, to be matched by position to the template parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument Name</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPositionalTemplateBinding_ArgumentName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<QualifiedName> getArgumentName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            \'<\' + \n            self.argumentName->iterate(name : QualifiedName; s : String = \'\' | \n              if s = \'\' then name.pathName\n              else s + \',\' + name.pathName\n              endif\n            ) + \n            \'>\''"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" templateRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let parameters = template.templateParameters() in \n              parameters->size() = self.argumentName->size() and \n              Sequence{1 .. parameters->size()}->forAll(i | \n                self.matches(parameters->at(i), argumentName->at(i))\n              )'"
	 * @generated
	 */
	boolean matches(ElementReference template);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" parameterRequired="true" argumentNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let referents = argumentName.referent in\n              referents->size() = 1 and\n              referents->forAll(referent |\n                referent.isClassifier() and\n                parameter.parents()->forAll(c | referent.conformsTo(c))\n              )'"
	 * @generated
	 */
	boolean matches(ElementReference parameter, QualifiedName argumentName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" templateRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            self.argumentName->collect(argumentName |\n              let referents = argumentName.referent in\n                if referents->size() = 1 then referents->asSequence()\n                else Sequence(ElementReference){} endif\n            )'"
	 * @generated
	 */
	EList<ElementReference> bindTo(ElementReference template);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='PositionalTemplateBinding{argumentName = self.argumentName.copy()}'"
	 * @generated
	 */
	TemplateBinding copy();

} // PositionalTemplateBinding
