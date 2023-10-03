/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Url Tok</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getUrlTok()
 * @model
 * @generated
 */
public interface UrlTok extends CssTok {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Url</em>' containment reference.
	 * @see #setUrl(URLType)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getUrlTok_Url()
	 * @model containment="true"
	 * @generated
	 */
	URLType getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok#getUrl <em>Url</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Url</em>' containment reference.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(URLType value);

} // UrlTok
