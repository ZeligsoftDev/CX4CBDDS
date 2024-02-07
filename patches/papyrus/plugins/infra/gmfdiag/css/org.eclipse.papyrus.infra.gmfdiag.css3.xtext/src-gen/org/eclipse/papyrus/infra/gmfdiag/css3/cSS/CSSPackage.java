/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSFactory
 * @model kind="package"
 * @generated
 */
public interface CSSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "cSS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/gmfdiag/css3/CSS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "cSS";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	CSSPackage eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.stylesheetImpl <em>stylesheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.stylesheetImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getstylesheet()
	 * @generated
	 */
	int STYLESHEET = 0;

	/**
	 * The feature id for the '<em><b>Charset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__CHARSET = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Ruleset</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__RULESET = 2;

	/**
	 * The feature id for the '<em><b>Media</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__MEDIA = 3;

	/**
	 * The feature id for the '<em><b>Page</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__PAGE = 4;

	/**
	 * The feature id for the '<em><b>Font face</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__FONT_FACE = 5;

	/**
	 * The feature id for the '<em><b>Keyframes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET__KEYFRAMES = 6;

	/**
	 * The number of structural features of the '<em>stylesheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STYLESHEET_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.charsetImpl <em>charset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.charsetImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcharset()
	 * @generated
	 */
	int CHARSET = 1;

	/**
	 * The feature id for the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHARSET__CHARSET = 0;

	/**
	 * The number of structural features of the '<em>charset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHARSET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.importExpressionImpl <em>import Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.importExpressionImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getimportExpression()
	 * @generated
	 */
	int IMPORT_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT_EXPRESSION__VALUE = 0;

	/**
	 * The number of structural features of the '<em>import Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.pageImpl <em>page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.pageImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getpage()
	 * @generated
	 */
	int PAGE = 3;

	/**
	 * The feature id for the '<em><b>Pseudo Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE__PSEUDO_PAGE = 0;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE__DECLARATIONS = 1;

	/**
	 * The number of structural features of the '<em>page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl <em>media</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getmedia()
	 * @generated
	 */
	int MEDIA = 4;

	/**
	 * The feature id for the '<em><b>Medialist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEDIA__MEDIALIST = 0;

	/**
	 * The feature id for the '<em><b>Rulesets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEDIA__RULESETS = 1;

	/**
	 * The number of structural features of the '<em>media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEDIA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframesImpl <em>keyframes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframesImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getkeyframes()
	 * @generated
	 */
	int KEYFRAMES = 6;

	/**
	 * The number of structural features of the '<em>keyframes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int KEYFRAMES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.font_faceImpl <em>font face</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.font_faceImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getfont_face()
	 * @generated
	 */
	int FONT_FACE = 5;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FONT_FACE__DECLARATIONS = KEYFRAMES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FONT_FACE__NAME = KEYFRAMES_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Keyframeselectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FONT_FACE__KEYFRAMESELECTORS = KEYFRAMES_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>font face</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FONT_FACE_FEATURE_COUNT = KEYFRAMES_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl <em>keyframe selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getkeyframe_selector()
	 * @generated
	 */
	int KEYFRAME_SELECTOR = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int KEYFRAME_SELECTOR__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int KEYFRAME_SELECTOR__PERCENTAGE = 1;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int KEYFRAME_SELECTOR__DECLARATIONS = 2;

	/**
	 * The number of structural features of the '<em>keyframe selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int KEYFRAME_SELECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl <em>ruleset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getruleset()
	 * @generated
	 */
	int RULESET = 8;

	/**
	 * The feature id for the '<em><b>Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULESET__SELECTORS = 0;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULESET__DECLARATIONS = 1;

	/**
	 * The number of structural features of the '<em>ruleset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULESET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.selectorImpl <em>selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.selectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getselector()
	 * @generated
	 */
	int SELECTOR = 9;

	/**
	 * The feature id for the '<em><b>Simpleselectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTOR__SIMPLESELECTORS = 0;

	/**
	 * The feature id for the '<em><b>Combinator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTOR__COMBINATOR = 1;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTOR__SELECTOR = 2;

	/**
	 * The number of structural features of the '<em>selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SimpleSelectorForNegationImpl <em>Simple Selector For Negation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SimpleSelectorForNegationImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getSimpleSelectorForNegation()
	 * @generated
	 */
	int SIMPLE_SELECTOR_FOR_NEGATION = 10;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR_FOR_NEGATION__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Universal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR_FOR_NEGATION__UNIVERSAL = 1;

	/**
	 * The feature id for the '<em><b>Sub Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR_FOR_NEGATION__SUB_SELECTORS = 2;

	/**
	 * The number of structural features of the '<em>Simple Selector For Negation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR_FOR_NEGATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssSelectorImpl <em>Css Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getCssSelector()
	 * @generated
	 */
	int CSS_SELECTOR = 11;

	/**
	 * The number of structural features of the '<em>Css Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_SELECTOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.simple_selectorImpl <em>simple selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.simple_selectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getsimple_selector()
	 * @generated
	 */
	int SIMPLE_SELECTOR = 12;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Universal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR__UNIVERSAL = 1;

	/**
	 * The feature id for the '<em><b>Sub Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR__SUB_SELECTORS = 2;

	/**
	 * The number of structural features of the '<em>simple selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SELECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ClassSelectorImpl <em>Class Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ClassSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getClassSelector()
	 * @generated
	 */
	int CLASS_SELECTOR = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_SELECTOR__NAME = CSS_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_SELECTOR_FEATURE_COUNT = CSS_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ElementSelectorImpl <em>Element Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ElementSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getElementSelector()
	 * @generated
	 */
	int ELEMENT_SELECTOR = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_SELECTOR__NAME = 0;

	/**
	 * The number of structural features of the '<em>Element Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_SELECTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UniversalSelectorImpl <em>Universal Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UniversalSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getUniversalSelector()
	 * @generated
	 */
	int UNIVERSAL_SELECTOR = 15;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIVERSAL_SELECTOR__NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Universal Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIVERSAL_SELECTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdSelectorImpl <em>Id Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIdSelector()
	 * @generated
	 */
	int ID_SELECTOR = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_SELECTOR__NAME = CSS_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Id Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_SELECTOR_FEATURE_COUNT = CSS_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_declarationImpl <em>css declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_declarationImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcss_declaration()
	 * @generated
	 */
	int CSS_DECLARATION = 17;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_DECLARATION__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Value Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_DECLARATION__VALUE_TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Important</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_DECLARATION__IMPORTANT = 2;

	/**
	 * The number of structural features of the '<em>css declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_DECLARATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_propertyImpl <em>css property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_propertyImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcss_property()
	 * @generated
	 */
	int CSS_PROPERTY = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY__NAME = 0;

	/**
	 * The number of structural features of the '<em>css property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassOrFuncImpl <em>Pseudo Class Or Func</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassOrFuncImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassOrFunc()
	 * @generated
	 */
	int PSEUDO_CLASS_OR_FUNC = 19;

	/**
	 * The number of structural features of the '<em>Pseudo Class Or Func</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT = CSS_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassImpl <em>Pseudo Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClass()
	 * @generated
	 */
	int PSEUDO_CLASS = 20;

	/**
	 * The number of structural features of the '<em>Pseudo Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FEATURE_COUNT = CSS_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassNameImpl <em>Pseudo Class Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassNameImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassName()
	 * @generated
	 */
	int PSEUDO_CLASS_NAME = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_NAME__NAME = PSEUDO_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pseudo Class Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_NAME_FEATURE_COUNT = PSEUDO_CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassFunctionImpl <em>Pseudo Class Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassFunctionImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassFunction()
	 * @generated
	 */
	int PSEUDO_CLASS_FUNCTION = 22;

	/**
	 * The feature id for the '<em><b>Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FUNCTION__NOT = PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Param Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FUNCTION__PARAM_SELECTOR = PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FUNCTION__NAME = PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FUNCTION__PARAMS = PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Pseudo Class Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PSEUDO_CLASS_FUNCTION_FEATURE_COUNT = PSEUDO_CLASS_OR_FUNC_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssTokImpl <em>Css Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getCssTok()
	 * @generated
	 */
	int CSS_TOK = 23;

	/**
	 * The number of structural features of the '<em>Css Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CSS_TOK_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.URLTypeImpl <em>URL Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.URLTypeImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getURLType()
	 * @generated
	 */
	int URL_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TYPE__VALUE = IMPORT_EXPRESSION__VALUE;

	/**
	 * The feature id for the '<em><b>Media List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TYPE__MEDIA_LIST = IMPORT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TYPE__URL = IMPORT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>URL Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TYPE_FEATURE_COUNT = IMPORT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.AttributeSelectorImpl <em>Attribute Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.AttributeSelectorImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getAttributeSelector()
	 * @generated
	 */
	int ATTRIBUTE_SELECTOR = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SELECTOR__NAME = CSS_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SELECTOR__OP = CSS_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SELECTOR__VALUE = CSS_SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SELECTOR_FEATURE_COUNT = CSS_SELECTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SymbolTokImpl <em>Symbol Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SymbolTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getSymbolTok()
	 * @generated
	 */
	int SYMBOL_TOK = 26;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYMBOL_TOK__SYMBOL = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbol Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYMBOL_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.WSTokImpl <em>WS Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.WSTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getWSTok()
	 * @generated
	 */
	int WS_TOK = 27;

	/**
	 * The number of structural features of the '<em>WS Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WS_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.StringTokImpl <em>String Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.StringTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getStringTok()
	 * @generated
	 */
	int STRING_TOK = 28;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TOK__VALUE = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.NumberTokImpl <em>Number Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.NumberTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getNumberTok()
	 * @generated
	 */
	int NUMBER_TOK = 29;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_TOK__VAL = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UrlTokImpl <em>Url Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UrlTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getUrlTok()
	 * @generated
	 */
	int URL_TOK = 30;

	/**
	 * The feature id for the '<em><b>Url</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TOK__URL = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Url Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ColorTokImpl <em>Color Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ColorTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getColorTok()
	 * @generated
	 */
	int COLOR_TOK = 31;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLOR_TOK__VALUE = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLOR_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdentifierTokImpl <em>Identifier Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdentifierTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIdentifierTok()
	 * @generated
	 */
	int IDENTIFIER_TOK = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_TOK__NAME = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl <em>Func Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getFuncTok()
	 * @generated
	 */
	int FUNC_TOK = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNC_TOK__NAME = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNC_TOK__PARAMS = CSS_TOK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Func Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNC_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IntegerTokImpl <em>Integer Tok</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IntegerTokImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIntegerTok()
	 * @generated
	 */
	int INTEGER_TOK = 34;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TOK__VAL = CSS_TOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Tok</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TOK_FEATURE_COUNT = CSS_TOK_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet <em>stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>stylesheet</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet
	 * @generated
	 */
	EClass getstylesheet();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Charset</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getCharset()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Charset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getImports()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getRuleset <em>Ruleset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Ruleset</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getRuleset()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Ruleset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getMedia <em>Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Media</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getMedia()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Media();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Page</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getPage()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Page();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getFont_face <em>Font face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Font face</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getFont_face()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Font_face();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getKeyframes <em>Keyframes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Keyframes</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet#getKeyframes()
	 * @see #getstylesheet()
	 * @generated
	 */
	EReference getstylesheet_Keyframes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset <em>charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>charset</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset
	 * @generated
	 */
	EClass getcharset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Charset</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset#getCharset()
	 * @see #getcharset()
	 * @generated
	 */
	EAttribute getcharset_Charset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression <em>import Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>import Expression</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression
	 * @generated
	 */
	EClass getimportExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression#getValue()
	 * @see #getimportExpression()
	 * @generated
	 */
	EAttribute getimportExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page <em>page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>page</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page
	 * @generated
	 */
	EClass getpage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page#getPseudoPage <em>Pseudo Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Pseudo Page</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page#getPseudoPage()
	 * @see #getpage()
	 * @generated
	 */
	EAttribute getpage_PseudoPage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page#getDeclarations()
	 * @see #getpage()
	 * @generated
	 */
	EReference getpage_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media <em>media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>media</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media
	 * @generated
	 */
	EClass getmedia();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media#getMedialist <em>Medialist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Medialist</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media#getMedialist()
	 * @see #getmedia()
	 * @generated
	 */
	EAttribute getmedia_Medialist();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media#getRulesets <em>Rulesets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Rulesets</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media#getRulesets()
	 * @see #getmedia()
	 * @generated
	 */
	EReference getmedia_Rulesets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face <em>font face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>font face</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face
	 * @generated
	 */
	EClass getfont_face();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getDeclarations()
	 * @see #getfont_face()
	 * @generated
	 */
	EReference getfont_face_Declarations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getName()
	 * @see #getfont_face()
	 * @generated
	 */
	EAttribute getfont_face_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getKeyframeselectors <em>Keyframeselectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Keyframeselectors</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face#getKeyframeselectors()
	 * @see #getfont_face()
	 * @generated
	 */
	EReference getfont_face_Keyframeselectors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframes <em>keyframes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>keyframes</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframes
	 * @generated
	 */
	EClass getkeyframes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector <em>keyframe selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>keyframe selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector
	 * @generated
	 */
	EClass getkeyframe_selector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getType()
	 * @see #getkeyframe_selector()
	 * @generated
	 */
	EAttribute getkeyframe_selector_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getPercentage()
	 * @see #getkeyframe_selector()
	 * @generated
	 */
	EAttribute getkeyframe_selector_Percentage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector#getDeclarations()
	 * @see #getkeyframe_selector()
	 * @generated
	 */
	EReference getkeyframe_selector_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset <em>ruleset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ruleset</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset
	 * @generated
	 */
	EClass getruleset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset#getSelectors <em>Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Selectors</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset#getSelectors()
	 * @see #getruleset()
	 * @generated
	 */
	EReference getruleset_Selectors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset#getDeclarations()
	 * @see #getruleset()
	 * @generated
	 */
	EReference getruleset_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector <em>selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector
	 * @generated
	 */
	EClass getselector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getSimpleselectors <em>Simpleselectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Simpleselectors</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getSimpleselectors()
	 * @see #getselector()
	 * @generated
	 */
	EReference getselector_Simpleselectors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getCombinator <em>Combinator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Combinator</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getCombinator()
	 * @see #getselector()
	 * @generated
	 */
	EAttribute getselector_Combinator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector#getSelector()
	 * @see #getselector()
	 * @generated
	 */
	EReference getselector_Selector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation <em>Simple Selector For Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Simple Selector For Negation</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation
	 * @generated
	 */
	EClass getSimpleSelectorForNegation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getElement()
	 * @see #getSimpleSelectorForNegation()
	 * @generated
	 */
	EReference getSimpleSelectorForNegation_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getUniversal <em>Universal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Universal</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getUniversal()
	 * @see #getSimpleSelectorForNegation()
	 * @generated
	 */
	EReference getSimpleSelectorForNegation_Universal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getSubSelectors <em>Sub Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Selectors</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation#getSubSelectors()
	 * @see #getSimpleSelectorForNegation()
	 * @generated
	 */
	EReference getSimpleSelectorForNegation_SubSelectors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssSelector <em>Css Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Css Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssSelector
	 * @generated
	 */
	EClass getCssSelector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector <em>simple selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>simple selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector
	 * @generated
	 */
	EClass getsimple_selector();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getElement()
	 * @see #getsimple_selector()
	 * @generated
	 */
	EReference getsimple_selector_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getUniversal <em>Universal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Universal</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getUniversal()
	 * @see #getsimple_selector()
	 * @generated
	 */
	EReference getsimple_selector_Universal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getSubSelectors <em>Sub Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Selectors</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector#getSubSelectors()
	 * @see #getsimple_selector()
	 * @generated
	 */
	EReference getsimple_selector_SubSelectors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector <em>Class Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector
	 * @generated
	 */
	EClass getClassSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector#getName()
	 * @see #getClassSelector()
	 * @generated
	 */
	EAttribute getClassSelector_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector <em>Element Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector
	 * @generated
	 */
	EClass getElementSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector#getName()
	 * @see #getElementSelector()
	 * @generated
	 */
	EAttribute getElementSelector_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector <em>Universal Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Universal Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector
	 * @generated
	 */
	EClass getUniversalSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector#getNamespace()
	 * @see #getUniversalSelector()
	 * @generated
	 */
	EAttribute getUniversalSelector_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector <em>Id Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Id Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector
	 * @generated
	 */
	EClass getIdSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector#getName()
	 * @see #getIdSelector()
	 * @generated
	 */
	EAttribute getIdSelector_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration <em>css declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>css declaration</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration
	 * @generated
	 */
	EClass getcss_declaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#getProperty()
	 * @see #getcss_declaration()
	 * @generated
	 */
	EReference getcss_declaration_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#getValueTokens <em>Value Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Value Tokens</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#getValueTokens()
	 * @see #getcss_declaration()
	 * @generated
	 */
	EReference getcss_declaration_ValueTokens();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#isImportant <em>Important</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Important</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration#isImportant()
	 * @see #getcss_declaration()
	 * @generated
	 */
	EAttribute getcss_declaration_Important();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property <em>css property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>css property</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property
	 * @generated
	 */
	EClass getcss_property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property#getName()
	 * @see #getcss_property()
	 * @generated
	 */
	EAttribute getcss_property_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassOrFunc <em>Pseudo Class Or Func</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pseudo Class Or Func</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassOrFunc
	 * @generated
	 */
	EClass getPseudoClassOrFunc();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClass <em>Pseudo Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pseudo Class</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClass
	 * @generated
	 */
	EClass getPseudoClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName <em>Pseudo Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pseudo Class Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName
	 * @generated
	 */
	EClass getPseudoClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName#getName()
	 * @see #getPseudoClassName()
	 * @generated
	 */
	EAttribute getPseudoClassName_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction <em>Pseudo Class Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pseudo Class Function</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction
	 * @generated
	 */
	EClass getPseudoClassFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#isNot <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Not</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#isNot()
	 * @see #getPseudoClassFunction()
	 * @generated
	 */
	EAttribute getPseudoClassFunction_Not();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParamSelector <em>Param Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Param Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParamSelector()
	 * @see #getPseudoClassFunction()
	 * @generated
	 */
	EReference getPseudoClassFunction_ParamSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getName()
	 * @see #getPseudoClassFunction()
	 * @generated
	 */
	EAttribute getPseudoClassFunction_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction#getParams()
	 * @see #getPseudoClassFunction()
	 * @generated
	 */
	EReference getPseudoClassFunction_Params();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok <em>Css Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Css Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok
	 * @generated
	 */
	EClass getCssTok();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType <em>URL Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>URL Type</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType
	 * @generated
	 */
	EClass getURLType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType#getMediaList <em>Media List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Media List</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType#getMediaList()
	 * @see #getURLType()
	 * @generated
	 */
	EAttribute getURLType_MediaList();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType#getUrl()
	 * @see #getURLType()
	 * @generated
	 */
	EAttribute getURLType_Url();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector <em>Attribute Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Selector</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector
	 * @generated
	 */
	EClass getAttributeSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getName()
	 * @see #getAttributeSelector()
	 * @generated
	 */
	EAttribute getAttributeSelector_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getOp()
	 * @see #getAttributeSelector()
	 * @generated
	 */
	EAttribute getAttributeSelector_Op();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector#getValue()
	 * @see #getAttributeSelector()
	 * @generated
	 */
	EAttribute getAttributeSelector_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok <em>Symbol Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Symbol Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok
	 * @generated
	 */
	EClass getSymbolTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok#getSymbol()
	 * @see #getSymbolTok()
	 * @generated
	 */
	EAttribute getSymbolTok_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.WSTok <em>WS Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>WS Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.WSTok
	 * @generated
	 */
	EClass getWSTok();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok <em>String Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok
	 * @generated
	 */
	EClass getStringTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok#getValue()
	 * @see #getStringTok()
	 * @generated
	 */
	EAttribute getStringTok_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok <em>Number Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Number Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok
	 * @generated
	 */
	EClass getNumberTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok#getVal()
	 * @see #getNumberTok()
	 * @generated
	 */
	EAttribute getNumberTok_Val();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok <em>Url Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Url Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok
	 * @generated
	 */
	EClass getUrlTok();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Url</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok#getUrl()
	 * @see #getUrlTok()
	 * @generated
	 */
	EReference getUrlTok_Url();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok <em>Color Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Color Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok
	 * @generated
	 */
	EClass getColorTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok#getValue()
	 * @see #getColorTok()
	 * @generated
	 */
	EAttribute getColorTok_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok <em>Identifier Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Identifier Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok
	 * @generated
	 */
	EClass getIdentifierTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok#getName()
	 * @see #getIdentifierTok()
	 * @generated
	 */
	EAttribute getIdentifierTok_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok <em>Func Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Func Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok
	 * @generated
	 */
	EClass getFuncTok();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok#getName()
	 * @see #getFuncTok()
	 * @generated
	 */
	EReference getFuncTok_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok#getParams()
	 * @see #getFuncTok()
	 * @generated
	 */
	EReference getFuncTok_Params();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok <em>Integer Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Integer Tok</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok
	 * @generated
	 */
	EClass getIntegerTok();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok#getVal()
	 * @see #getIntegerTok()
	 * @generated
	 */
	EAttribute getIntegerTok_Val();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CSSFactory getCSSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.stylesheetImpl <em>stylesheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.stylesheetImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getstylesheet()
		 * @generated
		 */
		EClass STYLESHEET = eINSTANCE.getstylesheet();

		/**
		 * The meta object literal for the '<em><b>Charset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__CHARSET = eINSTANCE.getstylesheet_Charset();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__IMPORTS = eINSTANCE.getstylesheet_Imports();

		/**
		 * The meta object literal for the '<em><b>Ruleset</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__RULESET = eINSTANCE.getstylesheet_Ruleset();

		/**
		 * The meta object literal for the '<em><b>Media</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__MEDIA = eINSTANCE.getstylesheet_Media();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__PAGE = eINSTANCE.getstylesheet_Page();

		/**
		 * The meta object literal for the '<em><b>Font face</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__FONT_FACE = eINSTANCE.getstylesheet_Font_face();

		/**
		 * The meta object literal for the '<em><b>Keyframes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STYLESHEET__KEYFRAMES = eINSTANCE.getstylesheet_Keyframes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.charsetImpl <em>charset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.charsetImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcharset()
		 * @generated
		 */
		EClass CHARSET = eINSTANCE.getcharset();

		/**
		 * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CHARSET__CHARSET = eINSTANCE.getcharset_Charset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.importExpressionImpl <em>import Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.importExpressionImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getimportExpression()
		 * @generated
		 */
		EClass IMPORT_EXPRESSION = eINSTANCE.getimportExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMPORT_EXPRESSION__VALUE = eINSTANCE.getimportExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.pageImpl <em>page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.pageImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getpage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getpage();

		/**
		 * The meta object literal for the '<em><b>Pseudo Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PAGE__PSEUDO_PAGE = eINSTANCE.getpage_PseudoPage();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PAGE__DECLARATIONS = eINSTANCE.getpage_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl <em>media</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getmedia()
		 * @generated
		 */
		EClass MEDIA = eINSTANCE.getmedia();

		/**
		 * The meta object literal for the '<em><b>Medialist</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MEDIA__MEDIALIST = eINSTANCE.getmedia_Medialist();

		/**
		 * The meta object literal for the '<em><b>Rulesets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MEDIA__RULESETS = eINSTANCE.getmedia_Rulesets();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.font_faceImpl <em>font face</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.font_faceImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getfont_face()
		 * @generated
		 */
		EClass FONT_FACE = eINSTANCE.getfont_face();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FONT_FACE__DECLARATIONS = eINSTANCE.getfont_face_Declarations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FONT_FACE__NAME = eINSTANCE.getfont_face_Name();

		/**
		 * The meta object literal for the '<em><b>Keyframeselectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FONT_FACE__KEYFRAMESELECTORS = eINSTANCE.getfont_face_Keyframeselectors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframesImpl <em>keyframes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframesImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getkeyframes()
		 * @generated
		 */
		EClass KEYFRAMES = eINSTANCE.getkeyframes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl <em>keyframe selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getkeyframe_selector()
		 * @generated
		 */
		EClass KEYFRAME_SELECTOR = eINSTANCE.getkeyframe_selector();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute KEYFRAME_SELECTOR__TYPE = eINSTANCE.getkeyframe_selector_Type();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute KEYFRAME_SELECTOR__PERCENTAGE = eINSTANCE.getkeyframe_selector_Percentage();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference KEYFRAME_SELECTOR__DECLARATIONS = eINSTANCE.getkeyframe_selector_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl <em>ruleset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getruleset()
		 * @generated
		 */
		EClass RULESET = eINSTANCE.getruleset();

		/**
		 * The meta object literal for the '<em><b>Selectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULESET__SELECTORS = eINSTANCE.getruleset_Selectors();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULESET__DECLARATIONS = eINSTANCE.getruleset_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.selectorImpl <em>selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.selectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getselector()
		 * @generated
		 */
		EClass SELECTOR = eINSTANCE.getselector();

		/**
		 * The meta object literal for the '<em><b>Simpleselectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SELECTOR__SIMPLESELECTORS = eINSTANCE.getselector_Simpleselectors();

		/**
		 * The meta object literal for the '<em><b>Combinator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SELECTOR__COMBINATOR = eINSTANCE.getselector_Combinator();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SELECTOR__SELECTOR = eINSTANCE.getselector_Selector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SimpleSelectorForNegationImpl <em>Simple Selector For Negation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SimpleSelectorForNegationImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getSimpleSelectorForNegation()
		 * @generated
		 */
		EClass SIMPLE_SELECTOR_FOR_NEGATION = eINSTANCE.getSimpleSelectorForNegation();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR_FOR_NEGATION__ELEMENT = eINSTANCE.getSimpleSelectorForNegation_Element();

		/**
		 * The meta object literal for the '<em><b>Universal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR_FOR_NEGATION__UNIVERSAL = eINSTANCE.getSimpleSelectorForNegation_Universal();

		/**
		 * The meta object literal for the '<em><b>Sub Selectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR_FOR_NEGATION__SUB_SELECTORS = eINSTANCE.getSimpleSelectorForNegation_SubSelectors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssSelectorImpl <em>Css Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getCssSelector()
		 * @generated
		 */
		EClass CSS_SELECTOR = eINSTANCE.getCssSelector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.simple_selectorImpl <em>simple selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.simple_selectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getsimple_selector()
		 * @generated
		 */
		EClass SIMPLE_SELECTOR = eINSTANCE.getsimple_selector();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR__ELEMENT = eINSTANCE.getsimple_selector_Element();

		/**
		 * The meta object literal for the '<em><b>Universal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR__UNIVERSAL = eINSTANCE.getsimple_selector_Universal();

		/**
		 * The meta object literal for the '<em><b>Sub Selectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMPLE_SELECTOR__SUB_SELECTORS = eINSTANCE.getsimple_selector_SubSelectors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ClassSelectorImpl <em>Class Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ClassSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getClassSelector()
		 * @generated
		 */
		EClass CLASS_SELECTOR = eINSTANCE.getClassSelector();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CLASS_SELECTOR__NAME = eINSTANCE.getClassSelector_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ElementSelectorImpl <em>Element Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ElementSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getElementSelector()
		 * @generated
		 */
		EClass ELEMENT_SELECTOR = eINSTANCE.getElementSelector();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_SELECTOR__NAME = eINSTANCE.getElementSelector_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UniversalSelectorImpl <em>Universal Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UniversalSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getUniversalSelector()
		 * @generated
		 */
		EClass UNIVERSAL_SELECTOR = eINSTANCE.getUniversalSelector();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIVERSAL_SELECTOR__NAMESPACE = eINSTANCE.getUniversalSelector_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdSelectorImpl <em>Id Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIdSelector()
		 * @generated
		 */
		EClass ID_SELECTOR = eINSTANCE.getIdSelector();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ID_SELECTOR__NAME = eINSTANCE.getIdSelector_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_declarationImpl <em>css declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_declarationImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcss_declaration()
		 * @generated
		 */
		EClass CSS_DECLARATION = eINSTANCE.getcss_declaration();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CSS_DECLARATION__PROPERTY = eINSTANCE.getcss_declaration_Property();

		/**
		 * The meta object literal for the '<em><b>Value Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CSS_DECLARATION__VALUE_TOKENS = eINSTANCE.getcss_declaration_ValueTokens();

		/**
		 * The meta object literal for the '<em><b>Important</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CSS_DECLARATION__IMPORTANT = eINSTANCE.getcss_declaration_Important();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_propertyImpl <em>css property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.css_propertyImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getcss_property()
		 * @generated
		 */
		EClass CSS_PROPERTY = eINSTANCE.getcss_property();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CSS_PROPERTY__NAME = eINSTANCE.getcss_property_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassOrFuncImpl <em>Pseudo Class Or Func</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassOrFuncImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassOrFunc()
		 * @generated
		 */
		EClass PSEUDO_CLASS_OR_FUNC = eINSTANCE.getPseudoClassOrFunc();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassImpl <em>Pseudo Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClass()
		 * @generated
		 */
		EClass PSEUDO_CLASS = eINSTANCE.getPseudoClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassNameImpl <em>Pseudo Class Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassNameImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassName()
		 * @generated
		 */
		EClass PSEUDO_CLASS_NAME = eINSTANCE.getPseudoClassName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PSEUDO_CLASS_NAME__NAME = eINSTANCE.getPseudoClassName_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassFunctionImpl <em>Pseudo Class Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.PseudoClassFunctionImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getPseudoClassFunction()
		 * @generated
		 */
		EClass PSEUDO_CLASS_FUNCTION = eINSTANCE.getPseudoClassFunction();

		/**
		 * The meta object literal for the '<em><b>Not</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PSEUDO_CLASS_FUNCTION__NOT = eINSTANCE.getPseudoClassFunction_Not();

		/**
		 * The meta object literal for the '<em><b>Param Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PSEUDO_CLASS_FUNCTION__PARAM_SELECTOR = eINSTANCE.getPseudoClassFunction_ParamSelector();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PSEUDO_CLASS_FUNCTION__NAME = eINSTANCE.getPseudoClassFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PSEUDO_CLASS_FUNCTION__PARAMS = eINSTANCE.getPseudoClassFunction_Params();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssTokImpl <em>Css Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CssTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getCssTok()
		 * @generated
		 */
		EClass CSS_TOK = eINSTANCE.getCssTok();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.URLTypeImpl <em>URL Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.URLTypeImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getURLType()
		 * @generated
		 */
		EClass URL_TYPE = eINSTANCE.getURLType();

		/**
		 * The meta object literal for the '<em><b>Media List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute URL_TYPE__MEDIA_LIST = eINSTANCE.getURLType_MediaList();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute URL_TYPE__URL = eINSTANCE.getURLType_Url();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.AttributeSelectorImpl <em>Attribute Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.AttributeSelectorImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getAttributeSelector()
		 * @generated
		 */
		EClass ATTRIBUTE_SELECTOR = eINSTANCE.getAttributeSelector();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_SELECTOR__NAME = eINSTANCE.getAttributeSelector_Name();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_SELECTOR__OP = eINSTANCE.getAttributeSelector_Op();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_SELECTOR__VALUE = eINSTANCE.getAttributeSelector_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SymbolTokImpl <em>Symbol Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.SymbolTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getSymbolTok()
		 * @generated
		 */
		EClass SYMBOL_TOK = eINSTANCE.getSymbolTok();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYMBOL_TOK__SYMBOL = eINSTANCE.getSymbolTok_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.WSTokImpl <em>WS Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.WSTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getWSTok()
		 * @generated
		 */
		EClass WS_TOK = eINSTANCE.getWSTok();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.StringTokImpl <em>String Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.StringTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getStringTok()
		 * @generated
		 */
		EClass STRING_TOK = eINSTANCE.getStringTok();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TOK__VALUE = eINSTANCE.getStringTok_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.NumberTokImpl <em>Number Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.NumberTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getNumberTok()
		 * @generated
		 */
		EClass NUMBER_TOK = eINSTANCE.getNumberTok();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NUMBER_TOK__VAL = eINSTANCE.getNumberTok_Val();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UrlTokImpl <em>Url Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.UrlTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getUrlTok()
		 * @generated
		 */
		EClass URL_TOK = eINSTANCE.getUrlTok();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference URL_TOK__URL = eINSTANCE.getUrlTok_Url();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ColorTokImpl <em>Color Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.ColorTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getColorTok()
		 * @generated
		 */
		EClass COLOR_TOK = eINSTANCE.getColorTok();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLOR_TOK__VALUE = eINSTANCE.getColorTok_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdentifierTokImpl <em>Identifier Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IdentifierTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIdentifierTok()
		 * @generated
		 */
		EClass IDENTIFIER_TOK = eINSTANCE.getIdentifierTok();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IDENTIFIER_TOK__NAME = eINSTANCE.getIdentifierTok_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl <em>Func Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getFuncTok()
		 * @generated
		 */
		EClass FUNC_TOK = eINSTANCE.getFuncTok();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNC_TOK__NAME = eINSTANCE.getFuncTok_Name();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNC_TOK__PARAMS = eINSTANCE.getFuncTok_Params();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IntegerTokImpl <em>Integer Tok</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IntegerTokImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.CSSPackageImpl#getIntegerTok()
		 * @generated
		 */
		EClass INTEGER_TOK = eINSTANCE.getIntegerTok();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute INTEGER_TOK__VAL = eINSTANCE.getIntegerTok_Val();

	}

} // CSSPackage
