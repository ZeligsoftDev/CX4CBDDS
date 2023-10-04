/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonFactory;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlCommonFactoryImpl extends EFactoryImpl implements UmlCommonFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlCommonFactory init() {
		try {
			UmlCommonFactory theUmlCommonFactory = (UmlCommonFactory) EPackage.Registry.INSTANCE.getEFactory(UmlCommonPackage.eNS_URI);
			if (theUmlCommonFactory != null) {
				return theUmlCommonFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlCommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlCommonFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UmlCommonPackage.QUALIFIED_NAME:
			return createQualifiedName();
		case UmlCommonPackage.TYPE_RULE:
			return createTypeRule();
		case UmlCommonPackage.MULTIPLICITY_RULE:
			return createMultiplicityRule();
		case UmlCommonPackage.BOUND_SPECIFICATION:
			return createBoundSpecification();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case UmlCommonPackage.VISIBILITY_KIND:
			return createVisibilityKindFromString(eDataType, initialValue);
		case UmlCommonPackage.DIRECTION:
			return createDirectionFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case UmlCommonPackage.VISIBILITY_KIND:
			return convertVisibilityKindToString(eDataType, instanceValue);
		case UmlCommonPackage.DIRECTION:
			return convertDirectionToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualifiedName createQualifiedName() {
		QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeRule createTypeRule() {
		TypeRuleImpl typeRule = new TypeRuleImpl();
		return typeRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiplicityRule createMultiplicityRule() {
		MultiplicityRuleImpl multiplicityRule = new MultiplicityRuleImpl();
		return multiplicityRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BoundSpecification createBoundSpecification() {
		BoundSpecificationImpl boundSpecification = new BoundSpecificationImpl();
		return boundSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityKind createVisibilityKindFromString(EDataType eDataType, String initialValue) {
		VisibilityKind result = VisibilityKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Direction createDirectionFromString(EDataType eDataType, String initialValue) {
		Direction result = Direction.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlCommonPackage getUmlCommonPackage() {
		return (UmlCommonPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlCommonPackage getPackage() {
		return UmlCommonPackage.eINSTANCE;
	}

} // UmlCommonFactoryImpl
