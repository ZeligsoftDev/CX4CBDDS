/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemvueModelFactoryImpl extends EFactoryImpl implements SystemvueModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SystemvueModelFactory init() {
		try {
			SystemvueModelFactory theSystemvueModelFactory = (SystemvueModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.agilent.com/2009/SystemvueModel"); 
			if (theSystemvueModelFactory != null) {
				return theSystemvueModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SystemvueModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemvueModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SystemvueModelPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case SystemvueModelPackage.HEADER_FILE: return createHeaderFile();
			case SystemvueModelPackage.PARAMETER: return createParameter();
			case SystemvueModelPackage.PORT: return createPort();
			case SystemvueModelPackage.SYSTEMVUE_MODEL: return createSystemvueModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SystemvueModelPackage.DIRECTION_TYPE:
				return createDirectionTypeFromString(eDataType, initialValue);
			case SystemvueModelPackage.IMPLEMENTATION:
				return createImplementationFromString(eDataType, initialValue);
			case SystemvueModelPackage.IMPLEMENTATION_TYPE:
				return createImplementationTypeFromString(eDataType, initialValue);
			case SystemvueModelPackage.TYPE_NAME:
				return createTypeNameFromString(eDataType, initialValue);
			case SystemvueModelPackage.TYPE_NAME_TYPE:
				return createTypeNameTypeFromString(eDataType, initialValue);
			case SystemvueModelPackage.DIRECTION_TYPE_OBJECT:
				return createDirectionTypeObjectFromString(eDataType, initialValue);
			case SystemvueModelPackage.IMPLEMENTATION_OBJECT:
				return createImplementationObjectFromString(eDataType, initialValue);
			case SystemvueModelPackage.IMPLEMENTATION_TYPE_OBJECT:
				return createImplementationTypeObjectFromString(eDataType, initialValue);
			case SystemvueModelPackage.TYPE_NAME_OBJECT:
				return createTypeNameObjectFromString(eDataType, initialValue);
			case SystemvueModelPackage.TYPE_NAME_TYPE_OBJECT:
				return createTypeNameTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SystemvueModelPackage.DIRECTION_TYPE:
				return convertDirectionTypeToString(eDataType, instanceValue);
			case SystemvueModelPackage.IMPLEMENTATION:
				return convertImplementationToString(eDataType, instanceValue);
			case SystemvueModelPackage.IMPLEMENTATION_TYPE:
				return convertImplementationTypeToString(eDataType, instanceValue);
			case SystemvueModelPackage.TYPE_NAME:
				return convertTypeNameToString(eDataType, instanceValue);
			case SystemvueModelPackage.TYPE_NAME_TYPE:
				return convertTypeNameTypeToString(eDataType, instanceValue);
			case SystemvueModelPackage.DIRECTION_TYPE_OBJECT:
				return convertDirectionTypeObjectToString(eDataType, instanceValue);
			case SystemvueModelPackage.IMPLEMENTATION_OBJECT:
				return convertImplementationObjectToString(eDataType, instanceValue);
			case SystemvueModelPackage.IMPLEMENTATION_TYPE_OBJECT:
				return convertImplementationTypeObjectToString(eDataType, instanceValue);
			case SystemvueModelPackage.TYPE_NAME_OBJECT:
				return convertTypeNameObjectToString(eDataType, instanceValue);
			case SystemvueModelPackage.TYPE_NAME_TYPE_OBJECT:
				return convertTypeNameTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderFile createHeaderFile() {
		HeaderFileImpl headerFile = new HeaderFileImpl();
		return headerFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemvueModel createSystemvueModel() {
		SystemvueModelImpl systemvueModel = new SystemvueModelImpl();
		return systemvueModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType createDirectionTypeFromString(EDataType eDataType, String initialValue) {
		DirectionType result = DirectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation createImplementationFromString(EDataType eDataType, String initialValue) {
		Implementation result = Implementation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImplementationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationType createImplementationTypeFromString(EDataType eDataType, String initialValue) {
		ImplementationType result = ImplementationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImplementationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName createTypeNameFromString(EDataType eDataType, String initialValue) {
		TypeName result = TypeName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNameType createTypeNameTypeFromString(EDataType eDataType, String initialValue) {
		TypeNameType result = TypeNameType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeNameTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType createDirectionTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDirectionTypeFromString(SystemvueModelPackage.Literals.DIRECTION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDirectionTypeToString(SystemvueModelPackage.Literals.DIRECTION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation createImplementationObjectFromString(EDataType eDataType, String initialValue) {
		return createImplementationFromString(SystemvueModelPackage.Literals.IMPLEMENTATION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImplementationObjectToString(EDataType eDataType, Object instanceValue) {
		return convertImplementationToString(SystemvueModelPackage.Literals.IMPLEMENTATION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationType createImplementationTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createImplementationTypeFromString(SystemvueModelPackage.Literals.IMPLEMENTATION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImplementationTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertImplementationTypeToString(SystemvueModelPackage.Literals.IMPLEMENTATION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName createTypeNameObjectFromString(EDataType eDataType, String initialValue) {
		return createTypeNameFromString(SystemvueModelPackage.Literals.TYPE_NAME, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeNameObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTypeNameToString(SystemvueModelPackage.Literals.TYPE_NAME, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNameType createTypeNameTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createTypeNameTypeFromString(SystemvueModelPackage.Literals.TYPE_NAME_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeNameTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTypeNameTypeToString(SystemvueModelPackage.Literals.TYPE_NAME_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemvueModelPackage getSystemvueModelPackage() {
		return (SystemvueModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SystemvueModelPackage getPackage() {
		return SystemvueModelPackage.eINSTANCE;
	}

} //SystemvueModelFactoryImpl
