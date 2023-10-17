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
package org.eclipse.ocl.xtext.markupcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.markupcs.MarkupPackage
 * @generated
 */
public class MarkupSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MarkupPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupSwitch() {
		if (modelPackage == null) {
			modelPackage = MarkupPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case 0: {
				BulletElement bulletElement = (BulletElement)theEObject;
				T result = caseBulletElement(bulletElement);
				if (result == null) result = caseCompoundElement(bulletElement);
				if (result == null) result = caseMarkupElement(bulletElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				CompoundElement compoundElement = (CompoundElement)theEObject;
				T result = caseCompoundElement(compoundElement);
				if (result == null) result = caseMarkupElement(compoundElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				FigureElement figureElement = (FigureElement)theEObject;
				T result = caseFigureElement(figureElement);
				if (result == null) result = caseMarkupElement(figureElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				FigureRefElement figureRefElement = (FigureRefElement)theEObject;
				T result = caseFigureRefElement(figureRefElement);
				if (result == null) result = caseMarkupElement(figureRefElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				FontElement fontElement = (FontElement)theEObject;
				T result = caseFontElement(fontElement);
				if (result == null) result = caseCompoundElement(fontElement);
				if (result == null) result = caseMarkupElement(fontElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				FootnoteElement footnoteElement = (FootnoteElement)theEObject;
				T result = caseFootnoteElement(footnoteElement);
				if (result == null) result = caseCompoundElement(footnoteElement);
				if (result == null) result = caseMarkupElement(footnoteElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				HeadingElement headingElement = (HeadingElement)theEObject;
				T result = caseHeadingElement(headingElement);
				if (result == null) result = caseCompoundElement(headingElement);
				if (result == null) result = caseMarkupElement(headingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				Markup markup = (Markup)theEObject;
				T result = caseMarkup(markup);
				if (result == null) result = caseCompoundElement(markup);
				if (result == null) result = caseMarkupElement(markup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				MarkupElement markupElement = (MarkupElement)theEObject;
				T result = caseMarkupElement(markupElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				NewLineElement newLineElement = (NewLineElement)theEObject;
				T result = caseNewLineElement(newLineElement);
				if (result == null) result = caseMarkupElement(newLineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10: {
				NullElement nullElement = (NullElement)theEObject;
				T result = caseNullElement(nullElement);
				if (result == null) result = caseCompoundElement(nullElement);
				if (result == null) result = caseMarkupElement(nullElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11: {
				OCLCodeElement oclCodeElement = (OCLCodeElement)theEObject;
				T result = caseOCLCodeElement(oclCodeElement);
				if (result == null) result = caseCompoundElement(oclCodeElement);
				if (result == null) result = caseMarkupElement(oclCodeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12: {
				OCLEvalElement oclEvalElement = (OCLEvalElement)theEObject;
				T result = caseOCLEvalElement(oclEvalElement);
				if (result == null) result = caseCompoundElement(oclEvalElement);
				if (result == null) result = caseMarkupElement(oclEvalElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13: {
				OCLTextElement oclTextElement = (OCLTextElement)theEObject;
				T result = caseOCLTextElement(oclTextElement);
				if (result == null) result = caseCompoundElement(oclTextElement);
				if (result == null) result = caseMarkupElement(oclTextElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14: {
				TextElement textElement = (TextElement)theEObject;
				T result = caseTextElement(textElement);
				if (result == null) result = caseMarkupElement(textElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bullet Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bullet Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBulletElement(BulletElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundElement(CompoundElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Figure Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Figure Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFigureElement(FigureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Figure Ref Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Figure Ref Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFigureRefElement(FigureRefElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontElement(FontElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Footnote Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Footnote Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFootnoteElement(FootnoteElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Heading Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Heading Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeadingElement(HeadingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkup(Markup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkupElement(MarkupElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Line Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Line Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewLineElement(NewLineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullElement(NullElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Code Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLCodeElement(OCLCodeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Eval Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Eval Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLEvalElement(OCLEvalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Text Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLTextElement(OCLTextElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextElement(TextElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MarkupSwitch
