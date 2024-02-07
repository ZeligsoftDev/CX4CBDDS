/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>stylesheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getCharset <em>Charset</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getImports <em>Imports</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getRuleset <em>Ruleset</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getMedia <em>Media</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getPage <em>Page</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getFont_face <em>Font face</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getKeyframes <em>Keyframes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet()
 * @model
 * @generated
 */
public interface stylesheet extends EObject {
	/**
	 * Returns the value of the '<em><b>Charset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Charset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Charset</em>' containment reference.
	 * @see #setCharset(charset)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Charset()
	 * @model containment="true"
	 * @generated
	 */
	charset getCharset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getCharset <em>Charset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Charset</em>' containment reference.
	 * @see #getCharset()
	 * @generated
	 */
	void setCharset(charset value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<importExpression> getImports();

	/**
	 * Returns the value of the '<em><b>Ruleset</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ruleset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Ruleset</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Ruleset()
	 * @model containment="true"
	 * @generated
	 */
	EList<ruleset> getRuleset();

	/**
	 * Returns the value of the '<em><b>Media</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Media</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Media()
	 * @model containment="true"
	 * @generated
	 */
	EList<media> getMedia();

	/**
	 * Returns the value of the '<em><b>Page</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Page</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Page()
	 * @model containment="true"
	 * @generated
	 */
	EList<page> getPage();

	/**
	 * Returns the value of the '<em><b>Font face</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font face</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Font face</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Font_face()
	 * @model containment="true"
	 * @generated
	 */
	EList<font_face> getFont_face();

	/**
	 * Returns the value of the '<em><b>Keyframes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyframes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Keyframes</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getstylesheet_Keyframes()
	 * @model containment="true"
	 * @generated
	 */
	EList<keyframes> getKeyframes();

} // stylesheet
