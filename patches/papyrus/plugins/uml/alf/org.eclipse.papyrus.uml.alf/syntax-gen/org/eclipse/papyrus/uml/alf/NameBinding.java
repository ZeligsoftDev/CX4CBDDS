/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An unqualified name, optionally with a template binding.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameBinding#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameBinding#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameBinding()
 * @model
 * @generated
 */
public interface NameBinding extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template binding to be used, if the name denotes a template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference.
	 * @see #setBinding(TemplateBinding)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameBinding_Binding()
	 * @model containment="true"
	 * @generated
	 */
	TemplateBinding getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameBinding#getBinding <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' containment reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(TemplateBinding value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An unqualified name. For names that appeared as unrestricted names in the input text, the string value here excludes the surrounding single quote characters and has any escape sequences resolved to the denoted special characters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameBinding_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameBinding#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if self.binding = null then self.toName()\n            else self.toName() + self.binding.toString()\n            endif'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if self.name = null or self.name = \'\' or self.name.at(1) <> \'\\\'\' then\n              name\n            else\n              let s = self.name.substring(2, name.size() - 1) in\n                self.process(s)\n            endif'"
	 * @generated
	 */
	String toName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" sRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let i = s.indexOf(\'\\\\\') in\n              if i = 0 then\n                s\n              else \n                if i = 1 then \'\' else s.substring(1, i-1) endif +\n                self.escape(s.at(i+1)) +\n                if i+2 > s.size() then \'\' else self.process(s.substring(i+2, s.size())) endif\n              endif'"
	 * @generated
	 */
	String process(String s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" sRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if s = \'b\' then \'\\b\'\n            else if s = \'f\' then \'\\f\'\n            else if s = \'t\' then \'\\t\'\n            else if s = \'n\' then \'\\n\'\n            else s endif endif endif endif'"
	 * @generated
	 */
	String escape(String s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NameBinding{\n            name = self.name,\n            binding = if self.binding = null then null else self.binding.copy() endif\n          }'"
	 * @generated
	 */
	NameBinding copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ownerRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        QualifiedName{\n                          nameBinding = OrderedSet{self.copy()},\n                          isAmbiguous = false,\n                          owner = owner\n                        }'"
	 * @generated
	 */
	QualifiedName toQualifiedName(SyntaxElement owner);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true" ownerRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        QualifiedName{\n                          nameBinding = OrderedSet{self.copy(), other},\n                          isAmbiguous = false,\n                          owner = owner\n                        }'"
	 * @generated
	 */
	QualifiedName toQualifiedNameWith(NameBinding other, SyntaxElement owner);

} // NameBinding
