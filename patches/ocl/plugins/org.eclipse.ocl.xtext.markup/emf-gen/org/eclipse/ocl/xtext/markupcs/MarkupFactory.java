/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markupcs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage
 * @generated
 */
public interface MarkupFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MarkupFactory eINSTANCE = org.eclipse.ocl.xtext.markupcs.impl.MarkupFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bullet Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bullet Element</em>'.
	 * @generated
	 */
	BulletElement createBulletElement();

	/**
	 * Returns a new object of class '<em>Compound Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Element</em>'.
	 * @generated
	 */
	CompoundElement createCompoundElement();

	/**
	 * Returns a new object of class '<em>Figure Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Figure Element</em>'.
	 * @generated
	 */
	FigureElement createFigureElement();

	/**
	 * Returns a new object of class '<em>Figure Ref Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Figure Ref Element</em>'.
	 * @generated
	 */
	FigureRefElement createFigureRefElement();

	/**
	 * Returns a new object of class '<em>Font Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Element</em>'.
	 * @generated
	 */
	FontElement createFontElement();

	/**
	 * Returns a new object of class '<em>Footnote Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Footnote Element</em>'.
	 * @generated
	 */
	FootnoteElement createFootnoteElement();

	/**
	 * Returns a new object of class '<em>Heading Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Heading Element</em>'.
	 * @generated
	 */
	HeadingElement createHeadingElement();

	/**
	 * Returns a new object of class '<em>Markup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markup</em>'.
	 * @generated
	 */
	Markup createMarkup();

	/**
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	MarkupElement createMarkupElement();

	/**
	 * Returns a new object of class '<em>New Line Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Line Element</em>'.
	 * @generated
	 */
	NewLineElement createNewLineElement();

	/**
	 * Returns a new object of class '<em>Null Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Element</em>'.
	 * @generated
	 */
	NullElement createNullElement();

	/**
	 * Returns a new object of class '<em>OCL Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Code Element</em>'.
	 * @generated
	 */
	OCLCodeElement createOCLCodeElement();

	/**
	 * Returns a new object of class '<em>OCL Eval Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Eval Element</em>'.
	 * @generated
	 */
	OCLEvalElement createOCLEvalElement();

	/**
	 * Returns a new object of class '<em>OCL Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Text Element</em>'.
	 * @generated
	 */
	OCLTextElement createOCLTextElement();

	/**
	 * Returns a new object of class '<em>Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Element</em>'.
	 * @generated
	 */
	TextElement createTextElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MarkupPackage getMarkupPackage();

} //MarkupFactory
