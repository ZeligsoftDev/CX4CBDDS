/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assigned Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An assignment of a source element that gives the value of a local name, along with a record of the defined type (if any) and multiplicity of the local name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignedSource#isIsParallelLocalName <em>Is Parallel Local Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource()
 * @model
 * @generated
 */
public interface AssignedSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local name for which this is the assigned source.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The syntax element that is to be the source for the assigned value of the given local name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SyntaxElement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_Source()
	 * @model required="true"
	 * @generated
	 */
	SyntaxElement getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SyntaxElement value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound for the local name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(Integer)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_Upper()
	 * @model required="true"
	 * @generated
	 */
	Integer getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(Integer value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound for the name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(Integer)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_Lower()
	 * @model required="true"
	 * @generated
	 */
	Integer getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(Integer value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the element that gives the type for the local name (if any).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_Type()
	 * @model
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Parallel Local Name</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An indication whether this assignment is for a local name listed in a
	 * @parallel annotation of a for statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Parallel Local Name</em>' attribute.
	 * @see #setIsParallelLocalName(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignedSource_IsParallelLocalName()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsParallelLocalName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignedSource#isIsParallelLocalName <em>Is Parallel Local Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Parallel Local Name</em>' attribute.
	 * @see #isIsParallelLocalName()
	 * @generated
	 */
	void setIsParallelLocalName(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" assignmentsBeforeMany="true" assignmentsBeforeOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignment = assignmentsBefore->select(name = self.name) in\n          assignment->isEmpty() or assignment.source->excludes(self.source)'"
	 * @generated
	 */
	boolean isNew(EList<AssignedSource> assignmentsBefore);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" assignmentsMany="true" assignmentsOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='assignments->reject(a | a.name = self.name)->including(self)'"
	 * @generated
	 */
	EList<AssignedSource> update(EList<AssignedSource> assignments);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='AssignedSource{\n        name = self.name,\n        source = if newSource = null then self.source else newSource endif,\n        upper = self.upper,\n        lower = self.lower,\n        type = self.type,\n        isParallelLocalName = \n          if isParallelLocal = null then self.isParallelLocalName \n          else isParallelLocal endif\n      }'"
	 * @generated
	 */
	AssignedSource copy(SyntaxElement newSource, boolean isParallelLocal);

} // AssignedSource
