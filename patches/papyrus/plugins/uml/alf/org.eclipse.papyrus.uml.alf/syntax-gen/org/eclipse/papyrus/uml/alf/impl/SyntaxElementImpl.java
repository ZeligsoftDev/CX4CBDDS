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
import org.eclipse.papyrus.uml.alf.RunTimeCaching;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.SyntaxElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Syntax Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SyntaxElementImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SyntaxElementImpl extends EObjectImpl implements SyntaxElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SyntaxElementImpl() {
		super();
	}

	private boolean unregistered = true;

	protected void registerCaching() {
		if (this.unregistered) {
			RunTimeCaching.register(this);
			this.unregistered = false;
		}
	}

	public String getId() {
		return this.getClass().getSimpleName() + "@" +
				Integer.toHexString(SyntaxElementImpl.this.hashCode());
	}

	public void clear() {
		this.assignmentsBefore = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSyntaxElement();
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
	public SyntaxElement getOwner() {
		return (SyntaxElement)eGet(AlfPackage.eINSTANCE.getSyntaxElement_Owner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(SyntaxElement newOwner) {
		eSet(AlfPackage.eINSTANCE.getSyntaxElement_Owner(), newOwner);
	}

	/**
	 * The cached invocation delegate for the '{@link #toReference() <em>To Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toReference()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__ToReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference toReference() {
		try {
			return (ElementReference)TO_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #owner() <em>Owner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #owner()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OWNER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__Owner()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement owner() {
		try {
			return (SyntaxElement)OWNER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #SyntaxElement_owner() <em>Syntax Element owner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SyntaxElement_owner()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SYNTAX_ELEMENT_OWNER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__SyntaxElement_owner()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement SyntaxElement_owner() {
		try {
			return (SyntaxElement)SYNTAX_ELEMENT_OWNER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #currentScope() <em>Current Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #currentScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CURRENT_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__CurrentScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference currentScope() {
		try {
			return (ElementReference)CURRENT_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #SyntaxElement_currentScope() <em>Syntax Element current Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SyntaxElement_currentScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SYNTAX_ELEMENT_CURRENT_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__SyntaxElement_currentScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference SyntaxElement_currentScope() {
		try {
			return (ElementReference)SYNTAX_ELEMENT_CURRENT_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #enclosingStatement() <em>Enclosing Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #enclosingStatement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ENCLOSING_STATEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__EnclosingStatement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement enclosingStatement() {
		try {
			return (Statement)ENCLOSING_STATEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #enclosingExpression() <em>Enclosing Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #enclosingExpression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ENCLOSING_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__EnclosingExpression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression enclosingExpression() {
		try {
			return (Expression)ENCLOSING_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore() <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__AssignmentsBefore()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	protected EList<AssignedSource> assignmentsBefore = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<AssignedSource> SyntaxElement_assignmentsBefore() {
		if (this.unregistered || this.assignmentsBefore == null) {
			this.assignmentsBefore = this.SyntaxElement_assignmentsBefore_base();
		}
		return this.assignmentsBefore;
	}

	/**
	 * The cached invocation delegate for the '{@link #SyntaxElement_assignmentsBefore_base() <em>Syntax Element assignments Before base</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SyntaxElement_assignmentsBefore_base()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SYNTAX_ELEMENT_ASSIGNMENTS_BEFORE_BASE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__SyntaxElement_assignmentsBefore_base()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> SyntaxElement_assignmentsBefore_base() {
		try {
			return (EList<AssignedSource>)SYNTAX_ELEMENT_ASSIGNMENTS_BEFORE_BASE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore(SyntaxElement element) {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #updateAll(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Update All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAll(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ALL_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__UpdateAll__EList_EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> updateAll(EList<AssignedSource> assignments, EList<AssignedSource> newAssignments) {
		try {
			return (EList<AssignedSource>)UPDATE_ALL_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{assignments, newAssignments}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #commonAncestor(org.eclipse.emf.common.util.EList) <em>Common Ancestor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #commonAncestor(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COMMON_ANCESTOR_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__CommonAncestor__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference commonAncestor(EList<ElementReference> classifiers) {
		try {
			return (ElementReference)COMMON_ANCESTOR_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{classifiers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #commonAncestors(org.eclipse.emf.common.util.EList) <em>Common Ancestors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #commonAncestors(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COMMON_ANCESTORS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__CommonAncestors__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> commonAncestors(EList<ElementReference> classifiers) {
		try {
			return (EList<ElementReference>)COMMON_ANCESTORS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{classifiers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #removeDuplicateElements(org.eclipse.emf.common.util.EList) <em>Remove Duplicate Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #removeDuplicateElements(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REMOVE_DUPLICATE_ELEMENTS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__RemoveDuplicateElements__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> removeDuplicateElements(EList<ElementReference> elements) {
		try {
			return (EList<ElementReference>)REMOVE_DUPLICATE_ELEMENTS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{elements}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveInLibrary(java.lang.String) <em>Resolve In Library</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveInLibrary(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_IN_LIBRARY_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__ResolveInLibrary__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveInLibrary(String pathName) {
		try {
			return (EList<ElementReference>)RESOLVE_IN_LIBRARY_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{pathName}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #primitiveType_(java.lang.String) <em>Primitive Type </em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #primitiveType_(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PRIMITIVE_TYPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__PrimitiveType___String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference primitiveType_(String typeName) {
		try {
			return (ElementReference)PRIMITIVE_TYPE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{typeName}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ElementReference primitiveType(String typeName) {
		return this.primitiveType_(typeName);
	}

	/**
	 * The cached invocation delegate for the '{@link #booleanType() <em>Boolean Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #booleanType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BOOLEAN_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__BooleanType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference booleanType() {
		try {
			return (ElementReference)BOOLEAN_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isBooleanType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Boolean Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_BOOLEAN_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsBooleanType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBooleanType(ElementReference element) {
		try {
			return (Boolean)IS_BOOLEAN_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #integerType() <em>Integer Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #integerType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INTEGER_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IntegerType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference integerType() {
		try {
			return (ElementReference)INTEGER_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isIntegerType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Integer Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIntegerType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_INTEGER_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsIntegerType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntegerType(ElementReference element) {
		try {
			return (Boolean)IS_INTEGER_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #stringType() <em>String Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stringType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STRING_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__StringType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stringType() {
		try {
			return (ElementReference)STRING_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isStringType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is String Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStringType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_STRING_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsStringType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStringType(ElementReference element) {
		try {
			return (Boolean)IS_STRING_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #unlimitedNaturalType() <em>Unlimited Natural Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #unlimitedNaturalType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UNLIMITED_NATURAL_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__UnlimitedNaturalType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference unlimitedNaturalType() {
		try {
			return (ElementReference)UNLIMITED_NATURAL_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isUnlimitedNaturalType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Unlimited Natural Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnlimitedNaturalType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_UNLIMITED_NATURAL_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsUnlimitedNaturalType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnlimitedNaturalType(ElementReference element) {
		try {
			return (Boolean)IS_UNLIMITED_NATURAL_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #bitStringType() <em>Bit String Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #bitStringType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BIT_STRING_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__BitStringType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference bitStringType() {
		try {
			return (ElementReference)BIT_STRING_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isBitStringType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Bit String Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBitStringType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_BIT_STRING_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsBitStringType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBitStringType(ElementReference element) {
		try {
			return (Boolean)IS_BIT_STRING_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #naturalType() <em>Natural Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #naturalType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NATURAL_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__NaturalType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference naturalType() {
		try {
			return (ElementReference)NATURAL_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNaturalType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Natural Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNaturalType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NATURAL_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsNaturalType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNaturalType(ElementReference element) {
		try {
			return (Boolean)IS_NATURAL_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNumericType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Numeric Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNumericType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NUMERIC_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsNumericType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNumericType(ElementReference element) {
		try {
			return (Boolean)IS_NUMERIC_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #collectionFunctionAdd() <em>Collection Function Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #collectionFunctionAdd()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COLLECTION_FUNCTION_ADD__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__CollectionFunctionAdd()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference collectionFunctionAdd() {
		try {
			return (ElementReference)COLLECTION_FUNCTION_ADD__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Collection Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsCollectionClass__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollectionClass(ElementReference element) {
		try {
			return (Boolean)IS_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isIntegerCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Integer Collection Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIntegerCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_INTEGER_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsIntegerCollectionClass__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntegerCollectionClass(ElementReference element) {
		try {
			return (Boolean)IS_INTEGER_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isBitStringCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Bit String Collection Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBitStringCollectionClass(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_BIT_STRING_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSyntaxElement__IsBitStringCollectionClass__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBitStringCollectionClass(ElementReference element) {
		try {
			return (Boolean)IS_BIT_STRING_COLLECTION_CLASS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
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
			case AlfPackage.SYNTAX_ELEMENT___TO_REFERENCE:
				return toReference();
			case AlfPackage.SYNTAX_ELEMENT___OWNER:
				return owner();
			case AlfPackage.SYNTAX_ELEMENT___SYNTAX_ELEMENT_OWNER:
				return SyntaxElement_owner();
			case AlfPackage.SYNTAX_ELEMENT___CURRENT_SCOPE:
				return currentScope();
			case AlfPackage.SYNTAX_ELEMENT___SYNTAX_ELEMENT_CURRENT_SCOPE:
				return SyntaxElement_currentScope();
			case AlfPackage.SYNTAX_ELEMENT___ENCLOSING_STATEMENT:
				return enclosingStatement();
			case AlfPackage.SYNTAX_ELEMENT___ENCLOSING_EXPRESSION:
				return enclosingExpression();
			case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE:
				return assignmentsBefore();
			case AlfPackage.SYNTAX_ELEMENT___SYNTAX_ELEMENT_ASSIGNMENTS_BEFORE:
				return SyntaxElement_assignmentsBefore();
			case AlfPackage.SYNTAX_ELEMENT___SYNTAX_ELEMENT_ASSIGNMENTS_BEFORE_BASE:
				return SyntaxElement_assignmentsBefore_base();
			case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___UPDATE_ALL__ELIST_ELIST:
				return updateAll((EList<AssignedSource>)arguments.get(0), (EList<AssignedSource>)arguments.get(1));
			case AlfPackage.SYNTAX_ELEMENT___COMMON_ANCESTOR__ELIST:
				return commonAncestor((EList<ElementReference>)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___COMMON_ANCESTORS__ELIST:
				return commonAncestors((EList<ElementReference>)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___REMOVE_DUPLICATE_ELEMENTS__ELIST:
				return removeDuplicateElements((EList<ElementReference>)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___RESOLVE_IN_LIBRARY__STRING:
				return resolveInLibrary((String)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___PRIMITIVE_TYPE__STRING:
				return primitiveType((String)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___PRIMITIVE_TYPE____STRING:
				return primitiveType_((String)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___BOOLEAN_TYPE:
				return booleanType();
			case AlfPackage.SYNTAX_ELEMENT___IS_BOOLEAN_TYPE__ELEMENTREFERENCE:
				return isBooleanType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___INTEGER_TYPE:
				return integerType();
			case AlfPackage.SYNTAX_ELEMENT___IS_INTEGER_TYPE__ELEMENTREFERENCE:
				return isIntegerType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___STRING_TYPE:
				return stringType();
			case AlfPackage.SYNTAX_ELEMENT___IS_STRING_TYPE__ELEMENTREFERENCE:
				return isStringType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___UNLIMITED_NATURAL_TYPE:
				return unlimitedNaturalType();
			case AlfPackage.SYNTAX_ELEMENT___IS_UNLIMITED_NATURAL_TYPE__ELEMENTREFERENCE:
				return isUnlimitedNaturalType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___BIT_STRING_TYPE:
				return bitStringType();
			case AlfPackage.SYNTAX_ELEMENT___IS_BIT_STRING_TYPE__ELEMENTREFERENCE:
				return isBitStringType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___NATURAL_TYPE:
				return naturalType();
			case AlfPackage.SYNTAX_ELEMENT___IS_NATURAL_TYPE__ELEMENTREFERENCE:
				return isNaturalType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___IS_NUMERIC_TYPE__ELEMENTREFERENCE:
				return isNumericType((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___COLLECTION_FUNCTION_ADD:
				return collectionFunctionAdd();
			case AlfPackage.SYNTAX_ELEMENT___IS_COLLECTION_CLASS__ELEMENTREFERENCE:
				return isCollectionClass((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___IS_INTEGER_COLLECTION_CLASS__ELEMENTREFERENCE:
				return isIntegerCollectionClass((ElementReference)arguments.get(0));
			case AlfPackage.SYNTAX_ELEMENT___IS_BIT_STRING_COLLECTION_CLASS__ELEMENTREFERENCE:
				return isBitStringCollectionClass((ElementReference)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SyntaxElementImpl
