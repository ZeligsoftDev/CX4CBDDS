/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage
 * @generated
 */
public class CSSAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static CSSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CSSAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CSSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CSSSwitch<Adapter> modelSwitch = new CSSSwitch<Adapter>() {
		@Override
		public Adapter casestylesheet(stylesheet object) {
			return createstylesheetAdapter();
		}

		@Override
		public Adapter casecharset(charset object) {
			return createcharsetAdapter();
		}

		@Override
		public Adapter caseimportExpression(importExpression object) {
			return createimportExpressionAdapter();
		}

		@Override
		public Adapter casepage(page object) {
			return createpageAdapter();
		}

		@Override
		public Adapter casemedia(media object) {
			return createmediaAdapter();
		}

		@Override
		public Adapter casefont_face(font_face object) {
			return createfont_faceAdapter();
		}

		@Override
		public Adapter casekeyframes(keyframes object) {
			return createkeyframesAdapter();
		}

		@Override
		public Adapter casekeyframe_selector(keyframe_selector object) {
			return createkeyframe_selectorAdapter();
		}

		@Override
		public Adapter caseruleset(ruleset object) {
			return createrulesetAdapter();
		}

		@Override
		public Adapter caseselector(selector object) {
			return createselectorAdapter();
		}

		@Override
		public Adapter caseSimpleSelectorForNegation(SimpleSelectorForNegation object) {
			return createSimpleSelectorForNegationAdapter();
		}

		@Override
		public Adapter caseCssSelector(CssSelector object) {
			return createCssSelectorAdapter();
		}

		@Override
		public Adapter casesimple_selector(simple_selector object) {
			return createsimple_selectorAdapter();
		}

		@Override
		public Adapter caseClassSelector(ClassSelector object) {
			return createClassSelectorAdapter();
		}

		@Override
		public Adapter caseElementSelector(ElementSelector object) {
			return createElementSelectorAdapter();
		}

		@Override
		public Adapter caseUniversalSelector(UniversalSelector object) {
			return createUniversalSelectorAdapter();
		}

		@Override
		public Adapter caseIdSelector(IdSelector object) {
			return createIdSelectorAdapter();
		}

		@Override
		public Adapter casecss_declaration(css_declaration object) {
			return createcss_declarationAdapter();
		}

		@Override
		public Adapter casecss_property(css_property object) {
			return createcss_propertyAdapter();
		}

		@Override
		public Adapter casePseudoClassOrFunc(PseudoClassOrFunc object) {
			return createPseudoClassOrFuncAdapter();
		}

		@Override
		public Adapter casePseudoClass(PseudoClass object) {
			return createPseudoClassAdapter();
		}

		@Override
		public Adapter casePseudoClassName(PseudoClassName object) {
			return createPseudoClassNameAdapter();
		}

		@Override
		public Adapter casePseudoClassFunction(PseudoClassFunction object) {
			return createPseudoClassFunctionAdapter();
		}

		@Override
		public Adapter caseCssTok(CssTok object) {
			return createCssTokAdapter();
		}

		@Override
		public Adapter caseURLType(URLType object) {
			return createURLTypeAdapter();
		}

		@Override
		public Adapter caseAttributeSelector(AttributeSelector object) {
			return createAttributeSelectorAdapter();
		}

		@Override
		public Adapter caseSymbolTok(SymbolTok object) {
			return createSymbolTokAdapter();
		}

		@Override
		public Adapter caseWSTok(WSTok object) {
			return createWSTokAdapter();
		}

		@Override
		public Adapter caseStringTok(StringTok object) {
			return createStringTokAdapter();
		}

		@Override
		public Adapter caseNumberTok(NumberTok object) {
			return createNumberTokAdapter();
		}

		@Override
		public Adapter caseUrlTok(UrlTok object) {
			return createUrlTokAdapter();
		}

		@Override
		public Adapter caseColorTok(ColorTok object) {
			return createColorTokAdapter();
		}

		@Override
		public Adapter caseIdentifierTok(IdentifierTok object) {
			return createIdentifierTokAdapter();
		}

		@Override
		public Adapter caseFuncTok(FuncTok object) {
			return createFuncTokAdapter();
		}

		@Override
		public Adapter caseIntegerTok(IntegerTok object) {
			return createIntegerTokAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet <em>stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.stylesheet
	 * @generated
	 */
	public Adapter createstylesheetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset <em>charset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.charset
	 * @generated
	 */
	public Adapter createcharsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression <em>import Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.importExpression
	 * @generated
	 */
	public Adapter createimportExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page <em>page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.page
	 * @generated
	 */
	public Adapter createpageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media <em>media</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media
	 * @generated
	 */
	public Adapter createmediaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face <em>font face</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.font_face
	 * @generated
	 */
	public Adapter createfont_faceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframes <em>keyframes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframes
	 * @generated
	 */
	public Adapter createkeyframesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector <em>keyframe selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector
	 * @generated
	 */
	public Adapter createkeyframe_selectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset <em>ruleset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset
	 * @generated
	 */
	public Adapter createrulesetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector <em>selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector
	 * @generated
	 */
	public Adapter createselectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation <em>Simple Selector For Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SimpleSelectorForNegation
	 * @generated
	 */
	public Adapter createSimpleSelectorForNegationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssSelector <em>Css Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssSelector
	 * @generated
	 */
	public Adapter createCssSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector <em>simple selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector
	 * @generated
	 */
	public Adapter createsimple_selectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector <em>Class Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ClassSelector
	 * @generated
	 */
	public Adapter createClassSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector <em>Element Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector
	 * @generated
	 */
	public Adapter createElementSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector <em>Universal Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UniversalSelector
	 * @generated
	 */
	public Adapter createUniversalSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector <em>Id Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdSelector
	 * @generated
	 */
	public Adapter createIdSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration <em>css declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration
	 * @generated
	 */
	public Adapter createcss_declarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property <em>css property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_property
	 * @generated
	 */
	public Adapter createcss_propertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassOrFunc <em>Pseudo Class Or Func</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassOrFunc
	 * @generated
	 */
	public Adapter createPseudoClassOrFuncAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClass <em>Pseudo Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClass
	 * @generated
	 */
	public Adapter createPseudoClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName <em>Pseudo Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassName
	 * @generated
	 */
	public Adapter createPseudoClassNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction <em>Pseudo Class Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.PseudoClassFunction
	 * @generated
	 */
	public Adapter createPseudoClassFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok <em>Css Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok
	 * @generated
	 */
	public Adapter createCssTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType <em>URL Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType
	 * @generated
	 */
	public Adapter createURLTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector <em>Attribute Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector
	 * @generated
	 */
	public Adapter createAttributeSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok <em>Symbol Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok
	 * @generated
	 */
	public Adapter createSymbolTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.WSTok <em>WS Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.WSTok
	 * @generated
	 */
	public Adapter createWSTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok <em>String Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok
	 * @generated
	 */
	public Adapter createStringTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok <em>Number Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.NumberTok
	 * @generated
	 */
	public Adapter createNumberTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok <em>Url Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.UrlTok
	 * @generated
	 */
	public Adapter createUrlTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok <em>Color Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ColorTok
	 * @generated
	 */
	public Adapter createColorTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok <em>Identifier Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok
	 * @generated
	 */
	public Adapter createIdentifierTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok <em>Func Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok
	 * @generated
	 */
	public Adapter createFuncTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok <em>Integer Tok</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok
	 * @generated
	 */
	public Adapter createIntegerTokAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // CSSAdapterFactory
