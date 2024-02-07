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
package org.eclipse.ocl.xtext.markupcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.markupcs.BulletElement;
import org.eclipse.ocl.xtext.markupcs.CompoundElement;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.FigureRefElement;
import org.eclipse.ocl.xtext.markupcs.FontElement;
import org.eclipse.ocl.xtext.markupcs.FootnoteElement;
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.MarkupElement;
import org.eclipse.ocl.xtext.markupcs.MarkupFactory;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.NullElement;
import org.eclipse.ocl.xtext.markupcs.OCLCodeElement;
import org.eclipse.ocl.xtext.markupcs.OCLEvalElement;
import org.eclipse.ocl.xtext.markupcs.OCLTextElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MarkupFactoryImpl extends EFactoryImpl implements MarkupFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarkupFactory init() {
		try {
			MarkupFactory theMarkupFactory = (MarkupFactory)EPackage.Registry.INSTANCE.getEFactory(MarkupPackage.eNS_URI);
			if (theMarkupFactory != null) {
				return theMarkupFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MarkupFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case 0: return createBulletElement();
			case 1: return createCompoundElement();
			case 2: return createFigureElement();
			case 3: return createFigureRefElement();
			case 4: return createFontElement();
			case 5: return createFootnoteElement();
			case 6: return createHeadingElement();
			case 7: return createMarkup();
			case 8: return createMarkupElement();
			case 9: return createNewLineElement();
			case 10: return createNullElement();
			case 11: return createOCLCodeElement();
			case 12: return createOCLEvalElement();
			case 13: return createOCLTextElement();
			case 14: return createTextElement();
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
	public @NonNull BulletElement createBulletElement() {
		BulletElementImpl bulletElement = new BulletElementImpl();
		return bulletElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CompoundElement createCompoundElement() {
		CompoundElementImpl compoundElement = new CompoundElementImpl();
		return compoundElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull FigureElement createFigureElement() {
		FigureElementImpl figureElement = new FigureElementImpl();
		return figureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull FigureRefElement createFigureRefElement() {
		FigureRefElementImpl figureRefElement = new FigureRefElementImpl();
		return figureRefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull FontElement createFontElement() {
		FontElementImpl fontElement = new FontElementImpl();
		return fontElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull FootnoteElement createFootnoteElement() {
		FootnoteElementImpl footnoteElement = new FootnoteElementImpl();
		return footnoteElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull HeadingElement createHeadingElement() {
		HeadingElementImpl headingElement = new HeadingElementImpl();
		return headingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Markup createMarkup() {
		MarkupImpl markup = new MarkupImpl();
		return markup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MarkupElement createMarkupElement() {
		MarkupElementImpl markupElement = new MarkupElementImpl();
		return markupElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NewLineElement createNewLineElement() {
		NewLineElementImpl newLineElement = new NewLineElementImpl();
		return newLineElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NullElement createNullElement() {
		NullElementImpl nullElement = new NullElementImpl();
		return nullElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OCLCodeElement createOCLCodeElement() {
		OCLCodeElementImpl oclCodeElement = new OCLCodeElementImpl();
		return oclCodeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OCLEvalElement createOCLEvalElement() {
		OCLEvalElementImpl oclEvalElement = new OCLEvalElementImpl();
		return oclEvalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OCLTextElement createOCLTextElement() {
		OCLTextElementImpl oclTextElement = new OCLTextElementImpl();
		return oclTextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TextElement createTextElement() {
		TextElementImpl textElement = new TextElementImpl();
		return textElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MarkupPackage getMarkupPackage() {
		return (MarkupPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MarkupPackage getPackage() {
		return MarkupPackage.eINSTANCE;
	}

} //MarkupFactoryImpl
