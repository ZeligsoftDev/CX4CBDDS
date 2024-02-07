/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The representation of a qualified name as a sequence of individual simple
 * names.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#isIsAmbiguous <em>Is Ambiguous</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#isIsFeatureReference <em>Is Feature Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getQualification <em>Qualification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getDisambiguation <em>Disambiguation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getNameBinding <em>Name Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getUnqualifiedName <em>Unqualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedName#getTemplateName <em>Template Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Is Ambiguous</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this qualified name is ambiguous.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ambiguous</em>' attribute.
	 * @see #setIsAmbiguous(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_IsAmbiguous()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsAmbiguous();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#isIsAmbiguous <em>Is Ambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ambiguous</em>' attribute.
	 * @see #isIsAmbiguous()
	 * @generated
	 */
	void setIsAmbiguous(boolean value);

	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The complete path name for the qualified name, with individual name
	 * bindings separated by "::" punctuation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path Name</em>' attribute.
	 * @see #setPathName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_PathName()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.unqualifiedName = null then \'\'\n        else if self.qualification = null then self.unqualifiedName.toString()\n        else self.qualification.pathName + \'::\' + self.unqualifiedName.toString()\n        endif endif'"
	 * @generated
	 */
	String getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#getPathName <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' attribute.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(String value);

	/**
	 * Returns the value of the '<em><b>Is Feature Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates whether this qualified name has been disambiguated to a
	 * feature reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Feature Reference</em>' attribute.
	 * @see #setIsFeatureReference(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_IsFeatureReference()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.disambiguation <> null'"
	 * @generated
	 */
	boolean isIsFeatureReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#isIsFeatureReference <em>Is Feature Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Feature Reference</em>' attribute.
	 * @see #isIsFeatureReference()
	 * @generated
	 */
	void setIsFeatureReference(boolean value);

	/**
	 * Returns the value of the '<em><b>Qualification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name corresponding to the qualification part of this
	 * qualified name, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qualification</em>' reference.
	 * @see #setQualification(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_Qualification()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let n = self.nameBinding->size() in \n          if n <= 1 then null\n          else QualifiedName{\n            nameBinding = self.nameBinding->subOrderedSet(1, n - 1).copy(),\n            isAmbiguous = n > 1 and self.isAmbiguous,\n            owner = self.owner()\n          }\n          endif'"
	 * @generated
	 */
	QualifiedName getQualification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#getQualification <em>Qualification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualification</em>' reference.
	 * @see #getQualification()
	 * @generated
	 */
	void setQualification(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Disambiguation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The disambiguation into a feature reference of a syntactic element
	 * initially parsed as a qualified name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disambiguation</em>' reference.
	 * @see #setDisambiguation(FeatureReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_Disambiguation()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.disambiguationCached()'"
	 * @generated
	 */
	FeatureReference getDisambiguation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#getDisambiguation <em>Disambiguation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disambiguation</em>' reference.
	 * @see #getDisambiguation()
	 * @generated
	 */
	void setDisambiguation(FeatureReference value);

	/**
	 * Returns the value of the '<em><b>Name Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.NameBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of individual name bindings in this qualified name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name Binding</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_NameBinding()
	 * @model containment="true"
	 * @generated
	 */
	EList<NameBinding> getNameBinding();

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The possible referents to which this qualified name may resolve.
	 * (Note that the UML rules for namespaces in general allow a namespace to
	 * contain elements of different kinds with the same name.) If the qualified
	 * name is for a template instantiation, then the referent is the equivalent
	 * bound element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_Referent()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.referentCached()'"
	 * @generated
	 */
	EList<ElementReference> getReferent();

	/**
	 * Returns the value of the '<em><b>Unqualified Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rightmost individual name binding in the qualified name, without the
	 * qualification.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unqualified Name</em>' reference.
	 * @see #setUnqualifiedName(NameBinding)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_UnqualifiedName()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.nameBinding->last()'"
	 * @generated
	 */
	NameBinding getUnqualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#getUnqualifiedName <em>Unqualified Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unqualified Name</em>' reference.
	 * @see #getUnqualifiedName()
	 * @generated
	 */
	void setUnqualifiedName(NameBinding value);

	/**
	 * Returns the value of the '<em><b>Template Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this qualified name is for a template binding, then the name of the
	 * template for which this qualified name is a binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template Name</em>' reference.
	 * @see #setTemplateName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedName_TemplateName()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.unqualifiedName = null or \n          self.unqualifiedName.binding = null then \n          null\n        else if self.nameBinding->size() = 1 then\n          QualifiedName{\n            nameBinding = Sequence{NameBinding{name = self.unqualifiedName.name}},\n            isAmbiguous = false,\n            owner = self.owner()\n          }\n        else\n          QualifiedName{\n            nameBinding = self.nameBinding->subOrderedSet(1, self.nameBinding->size() - 1).copy()->\n              append(NameBinding{name = self.unqualifiedName.name}),\n            isAmbiguous = false,\n            owner = self.owner()\n          }\n        endif endif'"
	 * @generated
	 */
	QualifiedName getTemplateName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.QualifiedName#getTemplateName <em>Template Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Name</em>' reference.
	 * @see #getTemplateName()
	 * @generated
	 */
	void setTemplateName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='QualifiedName{\n        nameBinding = self.nameBinding.copy(),\n        isAmbiguous = self.isAmbiguous,\n        owner = self.owner()\n      }'"
	 * @generated
	 */
	QualifiedName copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let nameBinding = NameBinding{name = name} in\n          QualifiedName{\n            nameBinding = self.nameBinding.copy()->append(nameBinding),\n            isAmbiguous = self.isAmbiguous,\n            owner = self.owner()\n          }'"
	 * @generated
	 */
	QualifiedName addName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameBindingsMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        QualifiedName{\n          nameBinding = self.nameBinding.copy()->includingAll(nameBindings),\n          isAmbiguous = self.isAmbiguous,\n          owner = self.owner()\n        }'"
	 * @generated
	 */
	QualifiedName addNameBindings(EList<NameBinding> nameBindings);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * Get the referents for this qualified name as a fully qualified name in
	 * model scope.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> modelReferents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unqualified name of a qualified name is the last name binding.
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameUnqualifiedNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The path name for a qualified name consists of the string representation
	 * of each of the name bindings, separated by "::" punctuation. The string
	 * representation of a name binding is its name followed by the
	 * representation of its template binding, if it has one. The string
	 * representation of a positional template binding consists of an ordered
	 * list of the path names of its argument qualified names separated by
	 * commas, all surrounded by the angle brackets "<" and ">".
	 * The string representation of a named template binding consists of an
	 * ordered list of its template parameter substitutions, each consisting of
	 * the formal parameter name followed by "=>" followed by the path name of
	 * the argument qualified name, separated by commas, all surrounded by the
	 * angle brackets "<" and ">".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNamePathNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A qualified name is a feature reference if its disambiguation is not
	 * empty.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameIsFeatureReferenceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualification of a qualified name is a empty if the qualified name
	 * has only one name binding. Otherwise it is the qualified name consisting
	 * of all the name bindings of the original qualified name except for the
	 * last one. The qualification of a qualified name is considered ambiguous
	 * if the qualified name is ambiguous and has more than two name bindings.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameQualificationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a qualified name is not ambiguous or it has a qualification that resolves
	 * to a namespace, then it is has no disambiguation. Otherwise, its
	 * disambiguation is a feature reference with a name given by the unqualified
	 * name of the qualified name and a target expression determined by the
	 * disambiguation of the qualification of the qualified name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameDisambiguationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referents of a qualified name are the elements to which the name may
	 * resolve in the current scope, according to the UML rules for namespaces
	 * and named elements.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a qualified name is a local name, then the reference must be within
	 * the same local scope as the definition of the named element.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameLocalName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a qualified name is an unqualified, non-local name, then it must be
	 * visible in the current scope of the use of the name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameNonLocalUnqualifiedName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a qualified name has a qualification, then its unqualified name must
	 * name an element of the namespace named by the qualification, where the
	 * first name in the qualification must name an element of the current scope.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameQualifiedResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the unqualified name of a qualified name has a template binding, then
	 * the template name must resolve to a template. The template binding must
	 * have an argument name for each of the template parameters and each argument
	 * name must resolve to a classifier. If the template parameter has constraining
	 * classifiers, then the referent of the corresponding argument name must conform
	 * to all those constraining classifiers.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      self.templateName <> null implies\n        let templates = self.templateName.referent in \n          templates->size() = 1 and \n          templates->forAll(template | \n            template.isTemplate() and \n            self.unqualifiedName.binding.matches(template)\n          )'"
	 * @generated
	 */
	boolean qualifiedNameTemplateBinding(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the last name binding in a qualified name has a template binding, then
	 * the template name is a qualified name with the same template bindings as
	 * the original qualified name, but with the template binding removed on the
	 * last name binding.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean qualifiedNameTemplateNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureReference disambiguationCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isAmbiguous or self.qualification = null then null\n        else if self.qualification.referent->exists(isNamespace()) then null\n        else \n          FeatureReference{\n            nameBinding = self.unqualifiedName.copy(), \n            expression = \n              if self.qualification.isFeatureReference then \n                PropertyAccessExpression{\n                  featureReference = self.qualification.disambiguation\n                }\n              else NameExpression{name = self.qualification}\n              endif,\n            owner = self.owner()\n          }\n        endif endif'"
	 * @generated
	 */
	FeatureReference disambiguation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> referentCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      if self.isFeatureReference then\n        Set(ElementReference){}\n      else if self.templateName = null then\n        let n = self.nameBinding->size() in\n        let currentScope = self.currentScope() in\n          if n = 0 or currentScope = null then\n            Set(ElementReference){}\n          else if n = 1 then\n            -- Resolve as an unqualified name.\n            currentScope.resolve(self.unqualifiedName.toName())\n          else\n            -- Resolve as a qualified name.\n            self.qualification.referent->select(isNamespace()).\n              resolveVisible(self.unqualifiedName.toName(), currentScope)->\n              asSet()\n          endif endif\n      else\n        -- Resolve as a bound element.\n        let referents = self.templateName.referent in\n          if referents->size() <> 1 then\n            Set(ElementReference){}\n          else\n            let template = referents->any(true) in\n            let actuals = self.unqualifiedName.binding.bindTo(template) in\n              Set{template.bind(actuals)}\n          endif\n      endif endif'"
	 * @generated
	 */
	EList<ElementReference> referent();

} // QualifiedName
