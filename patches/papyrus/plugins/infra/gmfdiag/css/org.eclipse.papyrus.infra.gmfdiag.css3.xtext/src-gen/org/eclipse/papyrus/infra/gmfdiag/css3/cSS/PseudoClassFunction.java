/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pseudo Class Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#isNot <em>Not</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParamSelector <em>Param Selector</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getPseudoClassFunction()
 * @model
 * @generated
 */
public interface PseudoClassFunction extends PseudoClassOrFunc {
	/**
	 * Returns the value of the '<em><b>Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Not</em>' attribute.
	 * @see #setNot(boolean)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getPseudoClassFunction_Not()
	 * @model
	 * @generated
	 */
	boolean isNot();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#isNot <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Not</em>' attribute.
	 * @see #isNot()
	 * @generated
	 */
	void setNot(boolean value);

	/**
	 * Returns the value of the '<em><b>Param Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Selector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Param Selector</em>' containment reference.
	 * @see #setParamSelector(SimpleSelectorForNegation)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getPseudoClassFunction_ParamSelector()
	 * @model containment="true"
	 * @generated
	 */
	SimpleSelectorForNegation getParamSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParamSelector <em>Param Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Param Selector</em>' containment reference.
	 * @see #getParamSelector()
	 * @generated
	 */
	void setParamSelector(SimpleSelectorForNegation value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getPseudoClassFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage#getPseudoClassFunction_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<CssTok> getParams();

} // PseudoClassFunction
