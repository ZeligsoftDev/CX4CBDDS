/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.DDS4CCMModel#getLocationPrefix <em>Location Prefix</em>}</li>
 *   <li>{@link dds4ccm.DDS4CCMModel#getFixedHeader <em>Fixed Header</em>}</li>
 *   <li>{@link dds4ccm.DDS4CCMModel#getFixedFooter <em>Fixed Footer</em>}</li>
 *   <li>{@link dds4ccm.DDS4CCMModel#getModelType <em>Model Type</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getDDS4CCMModel()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface DDS4CCMModel extends IDL3PlusModel {
	/**
	 * Returns the value of the '<em><b>Location Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Prefix</em>' attribute.
	 * @see #setLocationPrefix(String)
	 * @see dds4ccm.DDS4CCMPackage#getDDS4CCMModel_LocationPrefix()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getLocationPrefix();

	/**
	 * Sets the value of the '{@link dds4ccm.DDS4CCMModel#getLocationPrefix <em>Location Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Prefix</em>' attribute.
	 * @see #getLocationPrefix()
	 * @generated
	 */
	void setLocationPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Fixed Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Header</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Header</em>' attribute.
	 * @see #setFixedHeader(String)
	 * @see dds4ccm.DDS4CCMPackage#getDDS4CCMModel_FixedHeader()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getFixedHeader();

	/**
	 * Sets the value of the '{@link dds4ccm.DDS4CCMModel#getFixedHeader <em>Fixed Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Header</em>' attribute.
	 * @see #getFixedHeader()
	 * @generated
	 */
	void setFixedHeader(String value);

	/**
	 * Returns the value of the '<em><b>Fixed Footer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Footer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Footer</em>' attribute.
	 * @see #setFixedFooter(String)
	 * @see dds4ccm.DDS4CCMPackage#getDDS4CCMModel_FixedFooter()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getFixedFooter();

	/**
	 * Sets the value of the '{@link dds4ccm.DDS4CCMModel#getFixedFooter <em>Fixed Footer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Footer</em>' attribute.
	 * @see #getFixedFooter()
	 * @generated
	 */
	void setFixedFooter(String value);

	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute.
	 * The default value is <code>"ATCD"</code>.
	 * The literals are from the enumeration {@link dds4ccm.ModelTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see dds4ccm.ModelTypeEnum
	 * @see #setModelType(ModelTypeEnum)
	 * @see dds4ccm.DDS4CCMPackage#getDDS4CCMModel_ModelType()
	 * @model default="ATCD" required="true" ordered="false"
	 * @generated
	 */
	ModelTypeEnum getModelType();

	/**
	 * Sets the value of the '{@link dds4ccm.DDS4CCMModel#getModelType <em>Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Type</em>' attribute.
	 * @see dds4ccm.ModelTypeEnum
	 * @see #getModelType()
	 * @generated
	 */
	void setModelType(ModelTypeEnum value);

} // DDS4CCMModel
