/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markupcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.markupcs.MarkupFactory
 * @model kind="package"
 * @generated
 */
public interface MarkupPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "markupcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/MarkupCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "markup";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.xtext.markup";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MarkupPackage eINSTANCE = org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.MarkupElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getMarkupElement()
	 * @generated
	 */
	int MARKUP_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.CompoundElementImpl <em>Compound Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.CompoundElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getCompoundElement()
	 * @generated
	 */
	int COMPOUND_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.BulletElementImpl <em>Bullet Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.BulletElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getBulletElement()
	 * @generated
	 */
	int BULLET_ELEMENT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FigureElementImpl <em>Figure Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.FigureElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFigureElement()
	 * @generated
	 */
	int FIGURE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FigureRefElementImpl <em>Figure Ref Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.FigureRefElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFigureRefElement()
	 * @generated
	 */
	int FIGURE_REF_ELEMENT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FontElementImpl <em>Font Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.FontElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFontElement()
	 * @generated
	 */
	int FONT_ELEMENT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FootnoteElementImpl <em>Footnote Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.FootnoteElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFootnoteElement()
	 * @generated
	 */
	int FOOTNOTE_ELEMENT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.HeadingElementImpl <em>Heading Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.HeadingElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getHeadingElement()
	 * @generated
	 */
	int HEADING_ELEMENT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.MarkupImpl <em>Markup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getMarkup()
	 * @generated
	 */
	int MARKUP = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.NewLineElementImpl <em>New Line Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.NewLineElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getNewLineElement()
	 * @generated
	 */
	int NEW_LINE_ELEMENT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.NullElementImpl <em>Null Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.NullElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getNullElement()
	 * @generated
	 */
	int NULL_ELEMENT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLCodeElementImpl <em>OCL Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLCodeElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLCodeElement()
	 * @generated
	 */
	int OCL_CODE_ELEMENT = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLEvalElementImpl <em>OCL Eval Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLEvalElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLEvalElement()
	 * @generated
	 */
	int OCL_EVAL_ELEMENT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLTextElementImpl <em>OCL Text Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLTextElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLTextElement()
	 * @generated
	 */
	int OCL_TEXT_ELEMENT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.markupcs.impl.TextElementImpl <em>Text Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.markupcs.impl.TextElementImpl
	 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getTextElement()
	 * @generated
	 */
	int TEXT_ELEMENT = 14;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.BulletElement <em>Bullet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bullet Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.BulletElement
	 * @generated
	 */
	EClass getBulletElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.BulletElement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.BulletElement#getLevel()
	 * @see #getBulletElement()
	 * @generated
	 */
	EAttribute getBulletElement_Level();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.CompoundElement <em>Compound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.CompoundElement
	 * @generated
	 */
	EClass getCompoundElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.markupcs.CompoundElement#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.CompoundElement#getElements()
	 * @see #getCompoundElement()
	 * @generated
	 */
	EReference getCompoundElement_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.FigureElement <em>Figure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Figure Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement
	 * @generated
	 */
	EClass getFigureElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getId()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getSrc()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_Src();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getAlt <em>Alt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alt</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getAlt()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_Alt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getDef <em>Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Def</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getDef()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_Def();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getRequiredWidth <em>Required Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Width</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getRequiredWidth()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_RequiredWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getRequiredHeight <em>Required Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Height</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getRequiredHeight()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_RequiredHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getActualWidth <em>Actual Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual Width</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getActualWidth()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_ActualWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FigureElement#getActualHeight <em>Actual Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual Height</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement#getActualHeight()
	 * @see #getFigureElement()
	 * @generated
	 */
	EAttribute getFigureElement_ActualHeight();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.FigureRefElement <em>Figure Ref Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Figure Ref Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureRefElement
	 * @generated
	 */
	EClass getFigureRefElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.markupcs.FigureRefElement#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureRefElement#getRef()
	 * @see #getFigureRefElement()
	 * @generated
	 */
	EReference getFigureRefElement_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.FontElement <em>Font Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FontElement
	 * @generated
	 */
	EClass getFontElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.FontElement#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FontElement#getFont()
	 * @see #getFontElement()
	 * @generated
	 */
	EAttribute getFontElement_Font();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.FootnoteElement <em>Footnote Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Footnote Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.FootnoteElement
	 * @generated
	 */
	EClass getFootnoteElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.HeadingElement <em>Heading Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heading Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.HeadingElement
	 * @generated
	 */
	EClass getHeadingElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.HeadingElement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.HeadingElement#getLevel()
	 * @see #getHeadingElement()
	 * @generated
	 */
	EAttribute getHeadingElement_Level();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.Markup <em>Markup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markup</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.Markup
	 * @generated
	 */
	EClass getMarkup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupElement
	 * @generated
	 */
	EClass getMarkupElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupElement#getOwner()
	 * @see #getMarkupElement()
	 * @generated
	 */
	EReference getMarkupElement_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement#getUniqueId <em>Unique Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique Id</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupElement#getUniqueId()
	 * @see #getMarkupElement()
	 * @generated
	 */
	EAttribute getMarkupElement_UniqueId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.NewLineElement <em>New Line Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Line Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.NewLineElement
	 * @generated
	 */
	EClass getNewLineElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.markupcs.NewLineElement#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.NewLineElement#getText()
	 * @see #getNewLineElement()
	 * @generated
	 */
	EAttribute getNewLineElement_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.NullElement <em>Null Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.NullElement
	 * @generated
	 */
	EClass getNullElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.OCLCodeElement <em>OCL Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Code Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLCodeElement
	 * @generated
	 */
	EClass getOCLCodeElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.OCLEvalElement <em>OCL Eval Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Eval Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLEvalElement
	 * @generated
	 */
	EClass getOCLEvalElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.OCLTextElement <em>OCL Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Text Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLTextElement
	 * @generated
	 */
	EClass getOCLTextElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.markupcs.TextElement <em>Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Element</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.TextElement
	 * @generated
	 */
	EClass getTextElement();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.xtext.markupcs.TextElement#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Text</em>'.
	 * @see org.eclipse.ocl.xtext.markupcs.TextElement#getText()
	 * @see #getTextElement()
	 * @generated
	 */
	EAttribute getTextElement_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MarkupFactory getMarkupFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.BulletElementImpl <em>Bullet Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.BulletElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getBulletElement()
		 * @generated
		 */
		EClass BULLET_ELEMENT = eINSTANCE.getBulletElement();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BULLET_ELEMENT__LEVEL = eINSTANCE.getBulletElement_Level();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.CompoundElementImpl <em>Compound Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.CompoundElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getCompoundElement()
		 * @generated
		 */
		EClass COMPOUND_ELEMENT = eINSTANCE.getCompoundElement();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_ELEMENT__ELEMENTS = eINSTANCE.getCompoundElement_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FigureElementImpl <em>Figure Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.FigureElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFigureElement()
		 * @generated
		 */
		EClass FIGURE_ELEMENT = eINSTANCE.getFigureElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__ID = eINSTANCE.getFigureElement_Id();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__SRC = eINSTANCE.getFigureElement_Src();

		/**
		 * The meta object literal for the '<em><b>Alt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__ALT = eINSTANCE.getFigureElement_Alt();

		/**
		 * The meta object literal for the '<em><b>Def</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__DEF = eINSTANCE.getFigureElement_Def();

		/**
		 * The meta object literal for the '<em><b>Required Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__REQUIRED_WIDTH = eINSTANCE.getFigureElement_RequiredWidth();

		/**
		 * The meta object literal for the '<em><b>Required Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__REQUIRED_HEIGHT = eINSTANCE.getFigureElement_RequiredHeight();

		/**
		 * The meta object literal for the '<em><b>Actual Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__ACTUAL_WIDTH = eINSTANCE.getFigureElement_ActualWidth();

		/**
		 * The meta object literal for the '<em><b>Actual Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_ELEMENT__ACTUAL_HEIGHT = eINSTANCE.getFigureElement_ActualHeight();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FigureRefElementImpl <em>Figure Ref Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.FigureRefElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFigureRefElement()
		 * @generated
		 */
		EClass FIGURE_REF_ELEMENT = eINSTANCE.getFigureRefElement();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIGURE_REF_ELEMENT__REF = eINSTANCE.getFigureRefElement_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FontElementImpl <em>Font Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.FontElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFontElement()
		 * @generated
		 */
		EClass FONT_ELEMENT = eINSTANCE.getFontElement();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_ELEMENT__FONT = eINSTANCE.getFontElement_Font();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.FootnoteElementImpl <em>Footnote Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.FootnoteElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getFootnoteElement()
		 * @generated
		 */
		EClass FOOTNOTE_ELEMENT = eINSTANCE.getFootnoteElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.HeadingElementImpl <em>Heading Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.HeadingElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getHeadingElement()
		 * @generated
		 */
		EClass HEADING_ELEMENT = eINSTANCE.getHeadingElement();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADING_ELEMENT__LEVEL = eINSTANCE.getHeadingElement_Level();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.MarkupImpl <em>Markup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getMarkup()
		 * @generated
		 */
		EClass MARKUP = eINSTANCE.getMarkup();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.MarkupElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getMarkupElement()
		 * @generated
		 */
		EClass MARKUP_ELEMENT = eINSTANCE.getMarkupElement();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKUP_ELEMENT__OWNER = eINSTANCE.getMarkupElement_Owner();

		/**
		 * The meta object literal for the '<em><b>Unique Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKUP_ELEMENT__UNIQUE_ID = eINSTANCE.getMarkupElement_UniqueId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.NewLineElementImpl <em>New Line Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.NewLineElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getNewLineElement()
		 * @generated
		 */
		EClass NEW_LINE_ELEMENT = eINSTANCE.getNewLineElement();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_LINE_ELEMENT__TEXT = eINSTANCE.getNewLineElement_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.NullElementImpl <em>Null Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.NullElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getNullElement()
		 * @generated
		 */
		EClass NULL_ELEMENT = eINSTANCE.getNullElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLCodeElementImpl <em>OCL Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLCodeElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLCodeElement()
		 * @generated
		 */
		EClass OCL_CODE_ELEMENT = eINSTANCE.getOCLCodeElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLEvalElementImpl <em>OCL Eval Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLEvalElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLEvalElement()
		 * @generated
		 */
		EClass OCL_EVAL_ELEMENT = eINSTANCE.getOCLEvalElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.OCLTextElementImpl <em>OCL Text Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.OCLTextElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getOCLTextElement()
		 * @generated
		 */
		EClass OCL_TEXT_ELEMENT = eINSTANCE.getOCLTextElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.markupcs.impl.TextElementImpl <em>Text Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.markupcs.impl.TextElementImpl
		 * @see org.eclipse.ocl.xtext.markupcs.impl.MarkupPackageImpl#getTextElement()
		 * @generated
		 */
		EClass TEXT_ELEMENT = eINSTANCE.getTextElement();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_ELEMENT__TEXT = eINSTANCE.getTextElement_Text();

	}

} //MarkupPackage
