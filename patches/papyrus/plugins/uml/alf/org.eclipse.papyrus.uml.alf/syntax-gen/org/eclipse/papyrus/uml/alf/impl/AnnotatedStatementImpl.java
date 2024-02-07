/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotated Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AnnotatedStatementImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AnnotatedStatementImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotatedStatementImpl extends DocumentedElementImpl implements AnnotatedStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotatedStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAnnotatedStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getAnnotation() {
		return (EList<String>)eGet(AlfPackage.eINSTANCE.getAnnotatedStatement_Annotation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getStatement() {
		return (Statement)eGet(AlfPackage.eINSTANCE.getAnnotatedStatement_Statement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(Statement newStatement) {
		eSet(AlfPackage.eINSTANCE.getAnnotatedStatement_Statement(), newStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<String> annotations() {
		EList<String> annotations = new BasicEList<String>();
		for (String text : this.getAnnotation()) {
			for (String annotation : text.replaceAll("[ \f\n\r\t]", "").substring(3).split("@", -1)) {
				annotations.add(annotation);
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.ANNOTATED_STATEMENT___ANNOTATIONS:
				return annotations();
		}
		return super.eInvoke(operationID, arguments);
	}

} // AnnotatedStatementImpl
