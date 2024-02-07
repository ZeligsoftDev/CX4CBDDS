/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A block of an accept statement that accepts one or more signals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getSignalNames <em>Signal Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getSignal <em>Signal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptBlock()
 * @model
 * @generated
 */
public interface AcceptBlock extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local name to which an accepted signal instance will be assigned.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptBlock_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The body of the accept block, executed if one of the named signals is received.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptBlock_Block()
	 * @model containment="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Signal Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of names of the signals accepted by this accept block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signal Names</em>' containment reference.
	 * @see #setSignalNames(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptBlock_SignalNames()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedNameList getSignalNames();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AcceptBlock#getSignalNames <em>Signal Names</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal Names</em>' containment reference.
	 * @see #getSignalNames()
	 * @generated
	 */
	void setSignalNames(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The signals denoted by the signal names of the accept block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signal</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptBlock_Signal()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                      self.signalNames.name.referent->select(isSignal())->asSet()'"
	 * @generated
	 */
	EList<ElementReference> getSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NameBinding{name = self.name}.toName()'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a compound accept statement, a local name defined in an accept block
	 * has the accept block as its assigned source before the block associated
	 * with the accept block. The type of the local name is the effective common
	 * ancestor of the specified signals for that accept clause, if one exists,
	 * and it is untyped otherwise.
	 * 
	 * Otherwise, the assignments before any block of an accept statement are the
	 * assignments before the accept statement.
	 * 
	 * <!-- end-model-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let name = self.actualName() in\n          if name = null or element <> self.block then\n            self.assignmentsBefore()\n          else\n            AssignedSource{\n              name = name,\n              source = self,\n              type = self.commonAncestor(self.signal),\n              lower = 1,\n              upper = 1\n            }.update(self.assignmentsBefore())\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The signals of an accept block are the referents of the signal names of the accept block.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptBlockSignalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All signal names in an accept block must resolve to signals.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.signalNames.name->forAll(\n                        referent->select(isSignal())->size() = 1\n                      )'"
	 * @generated
	 */
	boolean acceptBlockSignalNames(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AcceptBlock
