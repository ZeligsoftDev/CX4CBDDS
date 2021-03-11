/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMModel;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.ModelTypeEnum;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.DDS4CCMModelImpl#getLocationPrefix <em>Location Prefix</em>}</li>
 *   <li>{@link dds4ccm.impl.DDS4CCMModelImpl#getFixedHeader <em>Fixed Header</em>}</li>
 *   <li>{@link dds4ccm.impl.DDS4CCMModelImpl#getFixedFooter <em>Fixed Footer</em>}</li>
 *   <li>{@link dds4ccm.impl.DDS4CCMModelImpl#getModelType <em>Model Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DDS4CCMModelImpl extends IDL3PlusModelImpl implements DDS4CCMModel {
	/**
	 * The default value of the '{@link #getLocationPrefix() <em>Location Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocationPrefix() <em>Location Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationPrefix()
	 * @generated
	 * @ordered
	 */
	protected String locationPrefix = LOCATION_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedHeader() <em>Fixed Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedHeader() <em>Fixed Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedHeader()
	 * @generated
	 * @ordered
	 */
	protected String fixedHeader = FIXED_HEADER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedFooter() <em>Fixed Footer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedFooter()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_FOOTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedFooter() <em>Fixed Footer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedFooter()
	 * @generated
	 * @ordered
	 */
	protected String fixedFooter = FIXED_FOOTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelType() <em>Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected static final ModelTypeEnum MODEL_TYPE_EDEFAULT = ModelTypeEnum.ATCD;

	/**
	 * The cached value of the '{@link #getModelType() <em>Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected ModelTypeEnum modelType = MODEL_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DDS4CCMModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getDDS4CCMModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocationPrefix() {
		return locationPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocationPrefix(String newLocationPrefix) {
		String oldLocationPrefix = locationPrefix;
		locationPrefix = newLocationPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DDS4CCM_MODEL__LOCATION_PREFIX, oldLocationPrefix, locationPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFixedHeader() {
		return fixedHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFixedHeader(String newFixedHeader) {
		String oldFixedHeader = fixedHeader;
		fixedHeader = newFixedHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DDS4CCM_MODEL__FIXED_HEADER, oldFixedHeader, fixedHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFixedFooter() {
		return fixedFooter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFixedFooter(String newFixedFooter) {
		String oldFixedFooter = fixedFooter;
		fixedFooter = newFixedFooter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DDS4CCM_MODEL__FIXED_FOOTER, oldFixedFooter, fixedFooter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelTypeEnum getModelType() {
		return modelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelType(ModelTypeEnum newModelType) {
		ModelTypeEnum oldModelType = modelType;
		modelType = newModelType == null ? MODEL_TYPE_EDEFAULT : newModelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DDS4CCM_MODEL__MODEL_TYPE, oldModelType, modelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.DDS4CCM_MODEL__LOCATION_PREFIX:
				return getLocationPrefix();
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_HEADER:
				return getFixedHeader();
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_FOOTER:
				return getFixedFooter();
			case DDS4CCMPackage.DDS4CCM_MODEL__MODEL_TYPE:
				return getModelType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DDS4CCMPackage.DDS4CCM_MODEL__LOCATION_PREFIX:
				setLocationPrefix((String)newValue);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_HEADER:
				setFixedHeader((String)newValue);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_FOOTER:
				setFixedFooter((String)newValue);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__MODEL_TYPE:
				setModelType((ModelTypeEnum)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DDS4CCMPackage.DDS4CCM_MODEL__LOCATION_PREFIX:
				setLocationPrefix(LOCATION_PREFIX_EDEFAULT);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_HEADER:
				setFixedHeader(FIXED_HEADER_EDEFAULT);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_FOOTER:
				setFixedFooter(FIXED_FOOTER_EDEFAULT);
				return;
			case DDS4CCMPackage.DDS4CCM_MODEL__MODEL_TYPE:
				setModelType(MODEL_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DDS4CCMPackage.DDS4CCM_MODEL__LOCATION_PREFIX:
				return LOCATION_PREFIX_EDEFAULT == null ? locationPrefix != null : !LOCATION_PREFIX_EDEFAULT.equals(locationPrefix);
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_HEADER:
				return FIXED_HEADER_EDEFAULT == null ? fixedHeader != null : !FIXED_HEADER_EDEFAULT.equals(fixedHeader);
			case DDS4CCMPackage.DDS4CCM_MODEL__FIXED_FOOTER:
				return FIXED_FOOTER_EDEFAULT == null ? fixedFooter != null : !FIXED_FOOTER_EDEFAULT.equals(fixedFooter);
			case DDS4CCMPackage.DDS4CCM_MODEL__MODEL_TYPE:
				return modelType != MODEL_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (locationPrefix: ");
		result.append(locationPrefix);
		result.append(", fixedHeader: ");
		result.append(fixedHeader);
		result.append(", fixedFooter: ");
		result.append(fixedFooter);
		result.append(", modelType: ");
		result.append(modelType);
		result.append(')');
		return result.toString();
	}

} //DDS4CCMModelImpl
