/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Port;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getHeaderFile <em>Header File</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl#getSystemvueModel <em>Systemvue Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemvueModelPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, SystemvueModelPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderFile getHeaderFile() {
		return (HeaderFile)getMixed().get(SystemvueModelPackage.Literals.DOCUMENT_ROOT__HEADER_FILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaderFile(HeaderFile newHeaderFile, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(SystemvueModelPackage.Literals.DOCUMENT_ROOT__HEADER_FILE, newHeaderFile, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderFile(HeaderFile newHeaderFile) {
		((FeatureMap.Internal)getMixed()).set(SystemvueModelPackage.Literals.DOCUMENT_ROOT__HEADER_FILE, newHeaderFile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter() {
		return (Parameter)getMixed().get(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PARAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PARAMETER, newParameter, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Parameter newParameter) {
		((FeatureMap.Internal)getMixed()).set(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PARAMETER, newParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort() {
		return (Port)getMixed().get(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPort(Port newPort, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PORT, newPort, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(Port newPort) {
		((FeatureMap.Internal)getMixed()).set(SystemvueModelPackage.Literals.DOCUMENT_ROOT__PORT, newPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemvueModel getSystemvueModel() {
		return (SystemvueModel)getMixed().get(SystemvueModelPackage.Literals.DOCUMENT_ROOT__SYSTEMVUE_MODEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemvueModel(SystemvueModel newSystemvueModel, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(SystemvueModelPackage.Literals.DOCUMENT_ROOT__SYSTEMVUE_MODEL, newSystemvueModel, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemvueModel(SystemvueModel newSystemvueModel) {
		((FeatureMap.Internal)getMixed()).set(SystemvueModelPackage.Literals.DOCUMENT_ROOT__SYSTEMVUE_MODEL, newSystemvueModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemvueModelPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__HEADER_FILE:
				return basicSetHeaderFile(null, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__PARAMETER:
				return basicSetParameter(null, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__PORT:
				return basicSetPort(null, msgs);
			case SystemvueModelPackage.DOCUMENT_ROOT__SYSTEMVUE_MODEL:
				return basicSetSystemvueModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemvueModelPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case SystemvueModelPackage.DOCUMENT_ROOT__HEADER_FILE:
				return getHeaderFile();
			case SystemvueModelPackage.DOCUMENT_ROOT__PARAMETER:
				return getParameter();
			case SystemvueModelPackage.DOCUMENT_ROOT__PORT:
				return getPort();
			case SystemvueModelPackage.DOCUMENT_ROOT__SYSTEMVUE_MODEL:
				return getSystemvueModel();
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
			case SystemvueModelPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__HEADER_FILE:
				setHeaderFile((HeaderFile)newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__PORT:
				setPort((Port)newValue);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__SYSTEMVUE_MODEL:
				setSystemvueModel((SystemvueModel)newValue);
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
			case SystemvueModelPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__HEADER_FILE:
				setHeaderFile((HeaderFile)null);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__PORT:
				setPort((Port)null);
				return;
			case SystemvueModelPackage.DOCUMENT_ROOT__SYSTEMVUE_MODEL:
				setSystemvueModel((SystemvueModel)null);
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
			case SystemvueModelPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case SystemvueModelPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case SystemvueModelPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case SystemvueModelPackage.DOCUMENT_ROOT__HEADER_FILE:
				return getHeaderFile() != null;
			case SystemvueModelPackage.DOCUMENT_ROOT__PARAMETER:
				return getParameter() != null;
			case SystemvueModelPackage.DOCUMENT_ROOT__PORT:
				return getPort() != null;
			case SystemvueModelPackage.DOCUMENT_ROOT__SYSTEMVUE_MODEL:
				return getSystemvueModel() != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
