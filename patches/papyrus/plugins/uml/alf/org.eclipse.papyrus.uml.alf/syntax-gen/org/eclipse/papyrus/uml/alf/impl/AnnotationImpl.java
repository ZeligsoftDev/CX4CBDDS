/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.Annotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AnnotationImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AnnotationImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AnnotationImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl extends SyntaxElementImpl implements Annotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAnnotation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return (String)eGet(AlfPackage.eINSTANCE.getAnnotation_Text(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		eSet(AlfPackage.eINSTANCE.getAnnotation_Text(), newText);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return (String)eGet(AlfPackage.eINSTANCE.getAnnotation_Identifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		eSet(AlfPackage.eINSTANCE.getAnnotation_Identifier(), newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getArgument() {
		return (EList<String>)eGet(AlfPackage.eINSTANCE.getAnnotation_Argument(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String identifier() {
		String text = this.getText();
		int i = text.indexOf('(');
		return i < 0 ? text : text.substring(0, i);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<String> arguments() {
		EList<String> arguments = new BasicEList<String>();
		String text = this.getText();
		int i = text.indexOf('(');
		if (i >= 0) {
			int j = i + 1;
			while (i < text.length()) {
				char c = text.charAt(i);
				if (c == ',' || c == ')') {
					arguments.add(text.substring(j, i));
					j = i + 1;
					if (c == ')') {
						break;
					}
				} else if (c == '\'') {
					do {
						i = i + 1;
					} while (i < text.length() &&
							(text.charAt(i) != '\'' || text.charAt(i - 1) == '\\'));
				}
				i = i + 1;
			}
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.ANNOTATION___IDENTIFIER:
				return identifier();
			case AlfPackage.ANNOTATION___ARGUMENTS:
				return arguments();
		}
		return super.eInvoke(operationID, arguments);
	}

} // AnnotationImpl
