/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.UnitDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ElementReferenceImpl extends EObjectImpl implements ElementReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getElementReference();
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
	 * The cached invocation delegate for the '{@link #isUml() <em>Is Uml</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUml()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_UML__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsUml()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUml() {
		try {
			return (Boolean)IS_UML__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAlf() <em>Is Alf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlf()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsAlf()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAlf() {
		try {
			return (Boolean)IS_ALF__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #asUml() <em>As Uml</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #asUml()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AS_UML__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__AsUml()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject asUml() {
		try {
			return (EObject)AS_UML__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #asAlf() <em>As Alf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #asAlf()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__AsAlf()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement asAlf() {
		try {
			return (SyntaxElement)AS_ALF__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public Member asMember() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSameKindAs(ElementReference member) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamedElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamespace() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamespaceFor(UnitDefinition unit) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isModelNamespace() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackage() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProfile() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackageableElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassifier() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstractClassifier() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssociation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClass() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActiveClass() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSignal() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumeration() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBehavior() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActivity() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMethod() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimitiveType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReception() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstructor() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDestructor() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFeature() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProperty() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssociationEnd() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateParameter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassifierTemplateParameter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameteredElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateBinding() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStereotype() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumerationLiteral() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoopVariable() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnnotation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequenceExpansionExpression() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #isAnyType() <em>Is Any Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ANY_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsAnyType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnyType() {
		try {
			return (Boolean)IS_ANY_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isDistinguishableFrom(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Distinguishable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DISTINGUISHABLE_FROM_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsDistinguishableFrom__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinguishableFrom(ElementReference other) {
		try {
			return (Boolean)IS_DISTINGUISHABLE_FROM_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{other}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAssignableFrom(org.eclipse.papyrus.uml.alf.AssignableElement) <em>Is Assignable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssignableFrom(org.eclipse.papyrus.uml.alf.AssignableElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ASSIGNABLE_FROM_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsAssignableFrom__AssignableElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssignableFrom(AssignableElement element) {
		try {
			return (Boolean)IS_ASSIGNABLE_FROM_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #collectionArgument() <em>Collection Argument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #collectionArgument()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COLLECTION_ARGUMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__CollectionArgument()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference collectionArgument() {
		try {
			return (ElementReference)COLLECTION_ARGUMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public String name() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String visibility() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> ownedMembers() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> members() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #visibleMembers() <em>Visible Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #visibleMembers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate VISIBLE_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__VisibleMembers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> visibleMembers() {
		try {
			return (EList<ElementReference>)VISIBLE_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public EList<ElementReference> nestedClassifiers() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #properties() <em>Properties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #properties()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PROPERTIES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Properties()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> properties() {
		try {
			return (EList<ElementReference>)PROPERTIES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #associationEnds() <em>Association Ends</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #associationEnds()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__AssociationEnds()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> associationEnds() {
		try {
			return (EList<ElementReference>)ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference opposite() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #receptions() <em>Receptions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #receptions()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RECEPTIONS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Receptions()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> receptions() {
		try {
			return (EList<ElementReference>)RECEPTIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference signal() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> parameters() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference returnParameter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference specification() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> redefinedOperations() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference namespace() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference template() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> templateParameters() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> parameteredElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> templateActuals() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String direction() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference association() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference type() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lower() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upper() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNonunique() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> parents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> allParents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference classifierBehavior() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference context() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> appliedProfiles() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #base() <em>Base</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #base()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BASE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Base()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference base() {
		try {
			return (ElementReference)BASE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #reference() <em>Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #reference()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Reference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference reference() {
		try {
			return (ElementReference)REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #templateBinding() <em>Template Binding</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateBinding()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_BINDING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__TemplateBinding()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference templateBinding() {
		try {
			return (ElementReference)TEMPLATE_BINDING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #bind(org.eclipse.emf.common.util.EList) <em>Bind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #bind(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BIND_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Bind__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference bind(EList<ElementReference> actuals) {
		try {
			return (ElementReference)BIND_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{actuals}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #boundElementName(org.eclipse.emf.common.util.EList) <em>Bound Element Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #boundElementName(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BOUND_ELEMENT_NAME_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__BoundElementName__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String boundElementName(EList<ElementReference> actuals) {
		try {
			return (String)BOUND_ELEMENT_NAME_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{actuals}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #boundPathName() <em>Bound Path Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #boundPathName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BOUND_PATH_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__BoundPathName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String boundPathName() {
		try {
			return (String)BOUND_PATH_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #qualifiedName() <em>Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate QUALIFIED_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__QualifiedName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName qualifiedName() {
		try {
			return (QualifiedName)QUALIFIED_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference activeClass() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #isActiveBehavior() <em>Is Active Behavior</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActiveBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVE_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__IsActiveBehavior()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActiveBehavior() {
		try {
			return (Boolean)IS_ACTIVE_BEHAVIOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean conformsTo(ElementReference other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(ElementReference other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #containedIn(org.eclipse.emf.common.util.EList) <em>Contained In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #containedIn(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONTAINED_IN_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__ContainedIn__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containedIn(EList<ElementReference> references) {
		try {
			return (Boolean)CONTAINED_IN_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{references}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #countIn(org.eclipse.emf.common.util.EList) <em>Count In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #countIn(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COUNT_IN_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__CountIn__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger countIn(EList<ElementReference> references) {
		try {
			return (BigInteger)COUNT_IN_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{references}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #positionIn(org.eclipse.emf.common.util.EList) <em>Position In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #positionIn(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate POSITION_IN_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__PositionIn__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger positionIn(EList<ElementReference> references) {
		try {
			return (BigInteger)POSITION_IN_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{references}));
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
	public ElementReference copy() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference modelScope() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> resolvePathName(String pathName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolve(String name) {
		try {
			return (EList<ElementReference>)RESOLVE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolve(java.lang.String) <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolve(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__Resolve__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveInScope(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> resolveStereotype(String stereotypeName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveVisible(java.lang.String, org.eclipse.papyrus.uml.alf.ElementReference) <em>Resolve Visible</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveVisible(java.lang.String, org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_VISIBLE_STRING_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__ResolveVisible__String_ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveVisible(String name, ElementReference namespace) {
		try {
			return (EList<ElementReference>)RESOLVE_VISIBLE_STRING_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{name, namespace}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveAssociationEnd(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String) <em>Resolve Association End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveAssociationEnd(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_ASSOCIATION_END_ELEMENT_REFERENCE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__ResolveAssociationEnd__ElementReference_String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveAssociationEnd(ElementReference oppositeEndType, String name) {
		try {
			return (EList<ElementReference>)RESOLVE_ASSOCIATION_END_ELEMENT_REFERENCE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{oppositeEndType, name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #containsMember(org.eclipse.papyrus.uml.alf.ElementReference) <em>Contains Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #containsMember(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONTAINS_MEMBER_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__ContainsMember__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsMember(ElementReference member) {
		try {
			return (Boolean)CONTAINS_MEMBER_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{member}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #allowPackageOnly() <em>Allow Package Only</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allowPackageOnly()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ALLOW_PACKAGE_ONLY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__AllowPackageOnly()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean allowPackageOnly() {
		try {
			return (Boolean)ALLOW_PACKAGE_ONLY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference stub() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stubFor(UnitDefinition unit) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #constructorReference() <em>Constructor Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #constructorReference()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONSTRUCTOR_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getElementReference__ConstructorReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference constructorReference() {
		try {
			return (ElementReference)CONSTRUCTOR_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case AlfPackage.ELEMENT_REFERENCE___IS_UML:
				return isUml();
			case AlfPackage.ELEMENT_REFERENCE___IS_ALF:
				return isAlf();
			case AlfPackage.ELEMENT_REFERENCE___AS_UML:
				return asUml();
			case AlfPackage.ELEMENT_REFERENCE___AS_ALF:
				return asAlf();
			case AlfPackage.ELEMENT_REFERENCE___AS_MEMBER:
				return asMember();
			case AlfPackage.ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___IS_NAMED_ELEMENT:
				return isNamedElement();
			case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE:
				return isNamespace();
			case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION:
				return isNamespaceFor((UnitDefinition)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___IS_MODEL_NAMESPACE:
				return isModelNamespace();
			case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGE:
				return isPackage();
			case AlfPackage.ELEMENT_REFERENCE___IS_PROFILE:
				return isProfile();
			case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT:
				return isPackageableElement();
			case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER:
				return isClassifier();
			case AlfPackage.ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER:
				return isAbstractClassifier();
			case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION:
				return isAssociation();
			case AlfPackage.ELEMENT_REFERENCE___IS_DATA_TYPE:
				return isDataType();
			case AlfPackage.ELEMENT_REFERENCE___IS_CLASS:
				return isClass();
			case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVE_CLASS:
				return isActiveClass();
			case AlfPackage.ELEMENT_REFERENCE___IS_SIGNAL:
				return isSignal();
			case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION:
				return isEnumeration();
			case AlfPackage.ELEMENT_REFERENCE___IS_BEHAVIOR:
				return isBehavior();
			case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVITY:
				return isActivity();
			case AlfPackage.ELEMENT_REFERENCE___IS_METHOD:
				return isMethod();
			case AlfPackage.ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE:
				return isPrimitiveType();
			case AlfPackage.ELEMENT_REFERENCE___IS_RECEPTION:
				return isReception();
			case AlfPackage.ELEMENT_REFERENCE___IS_OPERATION:
				return isOperation();
			case AlfPackage.ELEMENT_REFERENCE___IS_CONSTRUCTOR:
				return isConstructor();
			case AlfPackage.ELEMENT_REFERENCE___IS_DESTRUCTOR:
				return isDestructor();
			case AlfPackage.ELEMENT_REFERENCE___IS_FEATURE:
				return isFeature();
			case AlfPackage.ELEMENT_REFERENCE___IS_PROPERTY:
				return isProperty();
			case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION_END:
				return isAssociationEnd();
			case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETER:
				return isParameter();
			case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE:
				return isTemplate();
			case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER:
				return isClassifierTemplateParameter();
			case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT:
				return isParameteredElement();
			case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_BINDING:
				return isTemplateBinding();
			case AlfPackage.ELEMENT_REFERENCE___IS_STEREOTYPE:
				return isStereotype();
			case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL:
				return isEnumerationLiteral();
			case AlfPackage.ELEMENT_REFERENCE___IS_LOOP_VARIABLE:
				return isLoopVariable();
			case AlfPackage.ELEMENT_REFERENCE___IS_ANNOTATION:
				return isAnnotation();
			case AlfPackage.ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION:
				return isSequenceExpansionExpression();
			case AlfPackage.ELEMENT_REFERENCE___IS_ANY_TYPE:
				return isAnyType();
			case AlfPackage.ELEMENT_REFERENCE___IS_DISTINGUISHABLE_FROM__ELEMENTREFERENCE:
				return isDistinguishableFrom((ElementReference)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___IS_ASSIGNABLE_FROM__ASSIGNABLEELEMENT:
				return isAssignableFrom((AssignableElement)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___COLLECTION_ARGUMENT:
				return collectionArgument();
			case AlfPackage.ELEMENT_REFERENCE___NAME:
				return name();
			case AlfPackage.ELEMENT_REFERENCE___VISIBILITY:
				return visibility();
			case AlfPackage.ELEMENT_REFERENCE___OWNED_MEMBERS:
				return ownedMembers();
			case AlfPackage.ELEMENT_REFERENCE___MEMBERS:
				return members();
			case AlfPackage.ELEMENT_REFERENCE___VISIBLE_MEMBERS:
				return visibleMembers();
			case AlfPackage.ELEMENT_REFERENCE___NESTED_CLASSIFIERS:
				return nestedClassifiers();
			case AlfPackage.ELEMENT_REFERENCE___PROPERTIES:
				return properties();
			case AlfPackage.ELEMENT_REFERENCE___ASSOCIATION_ENDS:
				return associationEnds();
			case AlfPackage.ELEMENT_REFERENCE___OPPOSITE:
				return opposite();
			case AlfPackage.ELEMENT_REFERENCE___RECEPTIONS:
				return receptions();
			case AlfPackage.ELEMENT_REFERENCE___SIGNAL:
				return signal();
			case AlfPackage.ELEMENT_REFERENCE___PARAMETERS:
				return parameters();
			case AlfPackage.ELEMENT_REFERENCE___RETURN_PARAMETER:
				return returnParameter();
			case AlfPackage.ELEMENT_REFERENCE___SPECIFICATION:
				return specification();
			case AlfPackage.ELEMENT_REFERENCE___REDEFINED_OPERATIONS:
				return redefinedOperations();
			case AlfPackage.ELEMENT_REFERENCE___NAMESPACE:
				return namespace();
			case AlfPackage.ELEMENT_REFERENCE___TEMPLATE:
				return template();
			case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_PARAMETERS:
				return templateParameters();
			case AlfPackage.ELEMENT_REFERENCE___PARAMETERED_ELEMENTS:
				return parameteredElements();
			case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_ACTUALS:
				return templateActuals();
			case AlfPackage.ELEMENT_REFERENCE___DIRECTION:
				return direction();
			case AlfPackage.ELEMENT_REFERENCE___ASSOCIATION:
				return association();
			case AlfPackage.ELEMENT_REFERENCE___TYPE:
				return type();
			case AlfPackage.ELEMENT_REFERENCE___LOWER:
				return lower();
			case AlfPackage.ELEMENT_REFERENCE___UPPER:
				return upper();
			case AlfPackage.ELEMENT_REFERENCE___IS_ORDERED:
				return isOrdered();
			case AlfPackage.ELEMENT_REFERENCE___IS_NONUNIQUE:
				return isNonunique();
			case AlfPackage.ELEMENT_REFERENCE___PARENTS:
				return parents();
			case AlfPackage.ELEMENT_REFERENCE___ALL_PARENTS:
				return allParents();
			case AlfPackage.ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR:
				return classifierBehavior();
			case AlfPackage.ELEMENT_REFERENCE___CONTEXT:
				return context();
			case AlfPackage.ELEMENT_REFERENCE___APPLIED_PROFILES:
				return appliedProfiles();
			case AlfPackage.ELEMENT_REFERENCE___BASE:
				return base();
			case AlfPackage.ELEMENT_REFERENCE___REFERENCE:
				return reference();
			case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_BINDING:
				return templateBinding();
			case AlfPackage.ELEMENT_REFERENCE___BIND__ELIST:
				return bind((EList<ElementReference>)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___BOUND_ELEMENT_NAME__ELIST:
				return boundElementName((EList<ElementReference>)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___BOUND_PATH_NAME:
				return boundPathName();
			case AlfPackage.ELEMENT_REFERENCE___QUALIFIED_NAME:
				return qualifiedName();
			case AlfPackage.ELEMENT_REFERENCE___ACTIVE_CLASS:
				return activeClass();
			case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVE_BEHAVIOR:
				return isActiveBehavior();
			case AlfPackage.ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE:
				return conformsTo((ElementReference)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE:
				return equals((ElementReference)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___CONTAINED_IN__ELIST:
				return containedIn((EList<ElementReference>)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___COUNT_IN__ELIST:
				return countIn((EList<ElementReference>)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___POSITION_IN__ELIST:
				return positionIn((EList<ElementReference>)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___COPY:
				return copy();
			case AlfPackage.ELEMENT_REFERENCE___MODEL_SCOPE:
				return modelScope();
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING:
				return resolvePathName((String)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING:
				return resolveInScope((String)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE_STEREOTYPE__STRING:
				return resolveStereotype((String)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE__STRING:
				return resolve((String)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE_VISIBLE__STRING_ELEMENTREFERENCE:
				return resolveVisible((String)arguments.get(0), (ElementReference)arguments.get(1));
			case AlfPackage.ELEMENT_REFERENCE___RESOLVE_ASSOCIATION_END__ELEMENTREFERENCE_STRING:
				return resolveAssociationEnd((ElementReference)arguments.get(0), (String)arguments.get(1));
			case AlfPackage.ELEMENT_REFERENCE___CONTAINS_MEMBER__ELEMENTREFERENCE:
				return containsMember((ElementReference)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___ALLOW_PACKAGE_ONLY:
				return allowPackageOnly();
			case AlfPackage.ELEMENT_REFERENCE___STUB:
				return stub();
			case AlfPackage.ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION:
				return stubFor((UnitDefinition)arguments.get(0));
			case AlfPackage.ELEMENT_REFERENCE___CONSTRUCTOR_REFERENCE:
				return constructorReference();
		}
		return super.eInvoke(operationID, arguments);
	}

} // ElementReferenceImpl
