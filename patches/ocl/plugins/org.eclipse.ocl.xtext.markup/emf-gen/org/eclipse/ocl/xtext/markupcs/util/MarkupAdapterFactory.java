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
package org.eclipse.ocl.xtext.markupcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.markupcs.BulletElement;
import org.eclipse.ocl.xtext.markupcs.CompoundElement;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.FigureRefElement;
import org.eclipse.ocl.xtext.markupcs.FontElement;
import org.eclipse.ocl.xtext.markupcs.FootnoteElement;
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.MarkupElement;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.NullElement;
import org.eclipse.ocl.xtext.markupcs.OCLCodeElement;
import org.eclipse.ocl.xtext.markupcs.OCLEvalElement;
import org.eclipse.ocl.xtext.markupcs.OCLTextElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage
 * @generated
 */
public class MarkupAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MarkupPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MarkupPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkupSwitch<@Nullable Adapter> modelSwitch =
			new MarkupSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseBulletElement(BulletElement object) {
				return createBulletElementAdapter();
			}
			@Override
			public Adapter caseCompoundElement(CompoundElement object) {
				return createCompoundElementAdapter();
			}
			@Override
			public Adapter caseFigureElement(FigureElement object) {
				return createFigureElementAdapter();
			}
			@Override
			public Adapter caseFigureRefElement(FigureRefElement object) {
				return createFigureRefElementAdapter();
			}
			@Override
			public Adapter caseFontElement(FontElement object) {
				return createFontElementAdapter();
			}
			@Override
			public Adapter caseFootnoteElement(FootnoteElement object) {
				return createFootnoteElementAdapter();
			}
			@Override
			public Adapter caseHeadingElement(HeadingElement object) {
				return createHeadingElementAdapter();
			}
			@Override
			public Adapter caseMarkup(Markup object) {
				return createMarkupAdapter();
			}
			@Override
			public Adapter caseMarkupElement(MarkupElement object) {
				return createMarkupElementAdapter();
			}
			@Override
			public Adapter caseNewLineElement(NewLineElement object) {
				return createNewLineElementAdapter();
			}
			@Override
			public Adapter caseNullElement(NullElement object) {
				return createNullElementAdapter();
			}
			@Override
			public Adapter caseOCLCodeElement(OCLCodeElement object) {
				return createOCLCodeElementAdapter();
			}
			@Override
			public Adapter caseOCLEvalElement(OCLEvalElement object) {
				return createOCLEvalElementAdapter();
			}
			@Override
			public Adapter caseOCLTextElement(OCLTextElement object) {
				return createOCLTextElementAdapter();
			}
			@Override
			public Adapter caseTextElement(TextElement object) {
				return createTextElementAdapter();
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
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.BulletElement <em>Bullet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.BulletElement
	 * @generated
	 */
	public Adapter createBulletElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.CompoundElement <em>Compound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.CompoundElement
	 * @generated
	 */
	public Adapter createCompoundElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.FigureElement <em>Figure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureElement
	 * @generated
	 */
	public Adapter createFigureElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.FigureRefElement <em>Figure Ref Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.FigureRefElement
	 * @generated
	 */
	public Adapter createFigureRefElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.FontElement <em>Font Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.FontElement
	 * @generated
	 */
	public Adapter createFontElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.FootnoteElement <em>Footnote Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.FootnoteElement
	 * @generated
	 */
	public Adapter createFootnoteElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.HeadingElement <em>Heading Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.HeadingElement
	 * @generated
	 */
	public Adapter createHeadingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.Markup <em>Markup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.Markup
	 * @generated
	 */
	public Adapter createMarkupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.MarkupElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.MarkupElement
	 * @generated
	 */
	public Adapter createMarkupElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.NewLineElement <em>New Line Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.NewLineElement
	 * @generated
	 */
	public Adapter createNewLineElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.NullElement <em>Null Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.NullElement
	 * @generated
	 */
	public Adapter createNullElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.OCLCodeElement <em>OCL Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLCodeElement
	 * @generated
	 */
	public Adapter createOCLCodeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.OCLEvalElement <em>OCL Eval Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLEvalElement
	 * @generated
	 */
	public Adapter createOCLEvalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.OCLTextElement <em>OCL Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.OCLTextElement
	 * @generated
	 */
	public Adapter createOCLTextElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.markupcs.TextElement <em>Text Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.markupcs.TextElement
	 * @generated
	 */
	public Adapter createTextElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MarkupAdapterFactory
