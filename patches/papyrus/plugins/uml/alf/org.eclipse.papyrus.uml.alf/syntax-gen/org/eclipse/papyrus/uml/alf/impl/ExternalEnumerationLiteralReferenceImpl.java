/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfFactory;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.ExternalElementReference;
import org.eclipse.papyrus.uml.alf.ExternalEnumerationLiteralReference;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Enumeration Literal Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ExternalEnumerationLiteralReferenceImpl extends ExternalElementReferenceImpl implements ExternalEnumerationLiteralReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalEnumerationLiteralReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject ExternalEnumerationLiteralReference_asUML() {
		return this.getElement();
	}

	/**
	 * The cached invocation delegate for the '{@link #isNamedEement() <em>Is Named Eement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNamedEement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NAMED_EEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__IsNamedEement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamedEement() {
		try {
			return (Boolean)IS_NAMED_EEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isClassifier() <em>Is Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClassifier()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CLASSIFIER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__IsClassifier()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassifier() {
		try {
			return (Boolean)IS_CLASSIFIER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isParameter() <em>Is Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__IsParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameter() {
		try {
			return (Boolean)IS_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isEnumerationLiteral() <em>Is Enumeration Literal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumerationLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ENUMERATION_LITERAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__IsEnumerationLiteral()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumerationLiteral() {
		try {
			return (Boolean)IS_ENUMERATION_LITERAL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public String ExternalEnumerationLiteralReference_visibility() {
		VisibilityKind visibility = ((NamedElement) this.getElement()).getVisibility();
		return visibility == null ? null :
				visibility == VisibilityKind.PACKAGE_LITERAL ? "package" :
						visibility == VisibilityKind.PRIVATE_LITERAL ? "private" :
								visibility == VisibilityKind.PROTECTED_LITERAL ? "protected" :
										visibility == VisibilityKind.PUBLIC_LITERAL ? "public" : "";

	}

	/**
	 * The cached invocation delegate for the '{@link #visibility() <em>Visibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #visibility()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate VISIBILITY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__Visibility()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String visibility() {
		try {
			return (String)VISIBILITY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference ExternalEnumerationLiteralReference_type() {
		EnumerationLiteral literal = (EnumerationLiteral) this.getElement();
		ExternalElementReference reference =
				AlfFactory.eINSTANCE.createExternalElementReference();
		reference.setElement(literal.getEnumeration());
		return reference;
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExternalEnumerationLiteralReference__Type()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference type() {
		try {
			return (ElementReference)TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ElementReference.class) {
			switch (baseOperationID) {
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_CLASSIFIER;
				case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETER: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_ENUMERATION_LITERAL;
				case AlfPackage.ELEMENT_REFERENCE___VISIBILITY: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___VISIBILITY;
				case AlfPackage.ELEMENT_REFERENCE___TYPE: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___TYPE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ExternalElementReference.class) {
			switch (baseOperationID) {
				case AlfPackage.EXTERNAL_ELEMENT_REFERENCE___IS_CLASSIFIER: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_CLASSIFIER;
				case AlfPackage.EXTERNAL_ELEMENT_REFERENCE___IS_PARAMETER: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_PARAMETER;
				case AlfPackage.EXTERNAL_ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_ENUMERATION_LITERAL;
				case AlfPackage.EXTERNAL_ELEMENT_REFERENCE___VISIBILITY: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___VISIBILITY;
				case AlfPackage.EXTERNAL_ELEMENT_REFERENCE___TYPE: return AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___TYPE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_NAMED_EEMENT:
				return isNamedEement();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_CLASSIFIER:
				return isClassifier();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_PARAMETER:
				return isParameter();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___IS_ENUMERATION_LITERAL:
				return isEnumerationLiteral();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___EXTERNAL_ENUMERATION_LITERAL_REFERENCE_VISIBILITY:
				return ExternalEnumerationLiteralReference_visibility();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___VISIBILITY:
				return visibility();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___EXTERNAL_ENUMERATION_LITERAL_REFERENCE_TYPE:
				return ExternalEnumerationLiteralReference_type();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE___TYPE:
				return type();
		}
		return super.eInvoke(operationID, arguments);
	}

} // ExternalEnumerationLiteralReferenceImpl
