/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.SyntaxElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assigned Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignedSourceImpl#isIsParallelLocalName <em>Is Parallel Local Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignedSourceImpl extends EObjectImpl implements AssignedSource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignedSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAssignedSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(AlfPackage.eINSTANCE.getAssignedSource_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement getSource() {
		return (SyntaxElement)eGet(AlfPackage.eINSTANCE.getAssignedSource_Source(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SyntaxElement newSource) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_Source(), newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getUpper() {
		return (Integer)eGet(AlfPackage.eINSTANCE.getAssignedSource_Upper(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(Integer newUpper) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_Upper(), newUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLower() {
		return (Integer)eGet(AlfPackage.eINSTANCE.getAssignedSource_Lower(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(Integer newLower) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_Lower(), newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getType() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getAssignedSource_Type(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ElementReference newType) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_Type(), newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsParallelLocalName() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignedSource_IsParallelLocalName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsParallelLocalName(boolean newIsParallelLocalName) {
		eSet(AlfPackage.eINSTANCE.getAssignedSource_IsParallelLocalName(), newIsParallelLocalName);
	}

	/**
	 * The cached invocation delegate for the '{@link #isNew(org.eclipse.emf.common.util.EList) <em>Is New</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNew(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NEW_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignedSource__IsNew__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNew(EList<AssignedSource> assignmentsBefore) {
		try {
			return (Boolean)IS_NEW_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{assignmentsBefore}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #update(org.eclipse.emf.common.util.EList) <em>Update</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #update(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignedSource__Update__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> update(EList<AssignedSource> assignments) {
		try {
			return (EList<AssignedSource>)UPDATE_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{assignments}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #copy(org.eclipse.papyrus.uml.alf.SyntaxElement, boolean) <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #copy(org.eclipse.papyrus.uml.alf.SyntaxElement, boolean)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COPY_SYNTAX_ELEMENT_BOOLEAN__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignedSource__Copy__SyntaxElement_boolean()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource copy(SyntaxElement newSource, boolean isParallelLocal) {
		try {
			return (AssignedSource)COPY_SYNTAX_ELEMENT_BOOLEAN__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{newSource, isParallelLocal}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.ASSIGNED_SOURCE___IS_NEW__ELIST:
				return isNew((EList<AssignedSource>)arguments.get(0));
			case AlfPackage.ASSIGNED_SOURCE___UPDATE__ELIST:
				return update((EList<AssignedSource>)arguments.get(0));
			case AlfPackage.ASSIGNED_SOURCE___COPY__SYNTAXELEMENT_BOOLEAN:
				return copy((SyntaxElement)arguments.get(0), (Boolean)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // AssignedSourceImpl
