/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.*;

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
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage
 * @generated
 */
public class EssentialOCLCSSwitch<@Nullable T>
		extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSSwitch() {
		if (modelPackage == null)
		{
			modelPackage = EssentialOCLCSPackage.eINSTANCE;
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
		switch (classifierID)
		{
			case 0:
			{
				AbstractNameExpCS abstractNameExpCS = (AbstractNameExpCS)theEObject;
				T result = caseAbstractNameExpCS(abstractNameExpCS);
				if (result == null) result = caseExpCS(abstractNameExpCS);
				if (result == null) result = caseModelElementCS(abstractNameExpCS);
				if (result == null) result = casePivotableElementCS(abstractNameExpCS);
				if (result == null) result = caseElementCS(abstractNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1:
			{
				AssociationClassCallExpCS associationClassCallExpCS = (AssociationClassCallExpCS)theEObject;
				T result = caseAssociationClassCallExpCS(associationClassCallExpCS);
				if (result == null) result = caseCallExpCS(associationClassCallExpCS);
				if (result == null) result = caseAbstractNameExpCS(associationClassCallExpCS);
				if (result == null) result = caseExpCS(associationClassCallExpCS);
				if (result == null) result = caseModelElementCS(associationClassCallExpCS);
				if (result == null) result = casePivotableElementCS(associationClassCallExpCS);
				if (result == null) result = caseElementCS(associationClassCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2:
			{
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseExpCS(booleanLiteralExpCS);
				if (result == null) result = caseModelElementCS(booleanLiteralExpCS);
				if (result == null) result = casePivotableElementCS(booleanLiteralExpCS);
				if (result == null) result = caseElementCS(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3:
			{
				CallExpCS callExpCS = (CallExpCS)theEObject;
				T result = caseCallExpCS(callExpCS);
				if (result == null) result = caseAbstractNameExpCS(callExpCS);
				if (result == null) result = caseExpCS(callExpCS);
				if (result == null) result = caseModelElementCS(callExpCS);
				if (result == null) result = casePivotableElementCS(callExpCS);
				if (result == null) result = caseElementCS(callExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4:
			{
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseExpCS(collectionLiteralExpCS);
				if (result == null) result = caseModelElementCS(collectionLiteralExpCS);
				if (result == null) result = casePivotableElementCS(collectionLiteralExpCS);
				if (result == null) result = caseElementCS(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5:
			{
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseModelElementCS(collectionLiteralPartCS);
				if (result == null) result = casePivotableElementCS(collectionLiteralPartCS);
				if (result == null) result = caseElementCS(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6:
			{
				CollectionPatternCS collectionPatternCS = (CollectionPatternCS)theEObject;
				T result = caseCollectionPatternCS(collectionPatternCS);
				if (result == null) result = caseTypedRefCS(collectionPatternCS);
				if (result == null) result = caseTypeRefCS(collectionPatternCS);
				if (result == null) result = caseElementRefCS(collectionPatternCS);
				if (result == null) result = casePivotableElementCS(collectionPatternCS);
				if (result == null) result = caseElementCS(collectionPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7:
			{
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				T result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseTypedRefCS(collectionTypeCS);
				if (result == null) result = caseTypeRefCS(collectionTypeCS);
				if (result == null) result = caseElementRefCS(collectionTypeCS);
				if (result == null) result = casePivotableElementCS(collectionTypeCS);
				if (result == null) result = caseElementCS(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8:
			{
				ContextCS contextCS = (ContextCS)theEObject;
				T result = caseContextCS(contextCS);
				if (result == null) result = caseNamedElementCS(contextCS);
				if (result == null) result = caseRootCS(contextCS);
				if (result == null) result = caseModelElementCS(contextCS);
				if (result == null) result = casePivotableElementCS(contextCS);
				if (result == null) result = caseElementCS(contextCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9:
			{
				CurlyBracketedClauseCS curlyBracketedClauseCS = (CurlyBracketedClauseCS)theEObject;
				T result = caseCurlyBracketedClauseCS(curlyBracketedClauseCS);
				if (result == null) result = caseContextLessElementCS(curlyBracketedClauseCS);
				if (result == null) result = caseElementCS(curlyBracketedClauseCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10:
			{
				ExpCS expCS = (ExpCS)theEObject;
				T result = caseExpCS(expCS);
				if (result == null) result = caseModelElementCS(expCS);
				if (result == null) result = casePivotableElementCS(expCS);
				if (result == null) result = caseElementCS(expCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11:
			{
				ExpSpecificationCS expSpecificationCS = (ExpSpecificationCS)theEObject;
				T result = caseExpSpecificationCS(expSpecificationCS);
				if (result == null) result = caseSpecificationCS(expSpecificationCS);
				if (result == null) result = caseModelElementCS(expSpecificationCS);
				if (result == null) result = casePivotableElementCS(expSpecificationCS);
				if (result == null) result = caseElementCS(expSpecificationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12:
			{
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				T result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseExpCS(ifExpCS);
				if (result == null) result = caseModelElementCS(ifExpCS);
				if (result == null) result = casePivotableElementCS(ifExpCS);
				if (result == null) result = caseElementCS(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13:
			{
				IfThenExpCS ifThenExpCS = (IfThenExpCS)theEObject;
				T result = caseIfThenExpCS(ifThenExpCS);
				if (result == null) result = caseExpCS(ifThenExpCS);
				if (result == null) result = caseModelElementCS(ifThenExpCS);
				if (result == null) result = casePivotableElementCS(ifThenExpCS);
				if (result == null) result = caseElementCS(ifThenExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14:
			{
				InfixExpCS infixExpCS = (InfixExpCS)theEObject;
				T result = caseInfixExpCS(infixExpCS);
				if (result == null) result = caseOperatorExpCS(infixExpCS);
				if (result == null) result = caseExpCS(infixExpCS);
				if (result == null) result = caseNamedElementCS(infixExpCS);
				if (result == null) result = caseModelElementCS(infixExpCS);
				if (result == null) result = casePivotableElementCS(infixExpCS);
				if (result == null) result = caseElementCS(infixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 15:
			{
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseExpCS(invalidLiteralExpCS);
				if (result == null) result = caseModelElementCS(invalidLiteralExpCS);
				if (result == null) result = casePivotableElementCS(invalidLiteralExpCS);
				if (result == null) result = caseElementCS(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 16:
			{
				IterateCallExpCS iterateCallExpCS = (IterateCallExpCS)theEObject;
				T result = caseIterateCallExpCS(iterateCallExpCS);
				if (result == null) result = caseIterationCallExpCS(iterateCallExpCS);
				if (result == null) result = caseCallExpCS(iterateCallExpCS);
				if (result == null) result = caseAbstractNameExpCS(iterateCallExpCS);
				if (result == null) result = caseExpCS(iterateCallExpCS);
				if (result == null) result = caseModelElementCS(iterateCallExpCS);
				if (result == null) result = casePivotableElementCS(iterateCallExpCS);
				if (result == null) result = caseElementCS(iterateCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 17:
			{
				IterationCallExpCS iterationCallExpCS = (IterationCallExpCS)theEObject;
				T result = caseIterationCallExpCS(iterationCallExpCS);
				if (result == null) result = caseCallExpCS(iterationCallExpCS);
				if (result == null) result = caseAbstractNameExpCS(iterationCallExpCS);
				if (result == null) result = caseExpCS(iterationCallExpCS);
				if (result == null) result = caseModelElementCS(iterationCallExpCS);
				if (result == null) result = casePivotableElementCS(iterationCallExpCS);
				if (result == null) result = caseElementCS(iterationCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 18:
			{
				LambdaLiteralExpCS lambdaLiteralExpCS = (LambdaLiteralExpCS)theEObject;
				T result = caseLambdaLiteralExpCS(lambdaLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(lambdaLiteralExpCS);
				if (result == null) result = caseExpCS(lambdaLiteralExpCS);
				if (result == null) result = caseModelElementCS(lambdaLiteralExpCS);
				if (result == null) result = casePivotableElementCS(lambdaLiteralExpCS);
				if (result == null) result = caseElementCS(lambdaLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 19:
			{
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = caseExpCS(letExpCS);
				if (result == null) result = caseModelElementCS(letExpCS);
				if (result == null) result = casePivotableElementCS(letExpCS);
				if (result == null) result = caseElementCS(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 20:
			{
				LetVariableCS letVariableCS = (LetVariableCS)theEObject;
				T result = caseLetVariableCS(letVariableCS);
				if (result == null) result = caseExpCS(letVariableCS);
				if (result == null) result = caseVariableCS(letVariableCS);
				if (result == null) result = caseNamedElementCS(letVariableCS);
				if (result == null) result = caseModelElementCS(letVariableCS);
				if (result == null) result = casePivotableElementCS(letVariableCS);
				if (result == null) result = caseElementCS(letVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 21:
			{
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseExpCS(literalExpCS);
				if (result == null) result = caseModelElementCS(literalExpCS);
				if (result == null) result = casePivotableElementCS(literalExpCS);
				if (result == null) result = caseElementCS(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 22:
			{
				MapLiteralExpCS mapLiteralExpCS = (MapLiteralExpCS)theEObject;
				T result = caseMapLiteralExpCS(mapLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(mapLiteralExpCS);
				if (result == null) result = caseExpCS(mapLiteralExpCS);
				if (result == null) result = caseModelElementCS(mapLiteralExpCS);
				if (result == null) result = casePivotableElementCS(mapLiteralExpCS);
				if (result == null) result = caseElementCS(mapLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 23:
			{
				MapLiteralPartCS mapLiteralPartCS = (MapLiteralPartCS)theEObject;
				T result = caseMapLiteralPartCS(mapLiteralPartCS);
				if (result == null) result = caseModelElementCS(mapLiteralPartCS);
				if (result == null) result = casePivotableElementCS(mapLiteralPartCS);
				if (result == null) result = caseElementCS(mapLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 24:
			{
				MapTypeCS mapTypeCS = (MapTypeCS)theEObject;
				T result = caseMapTypeCS(mapTypeCS);
				if (result == null) result = caseTypedRefCS(mapTypeCS);
				if (result == null) result = caseTypeRefCS(mapTypeCS);
				if (result == null) result = caseElementRefCS(mapTypeCS);
				if (result == null) result = casePivotableElementCS(mapTypeCS);
				if (result == null) result = caseElementCS(mapTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 25:
			{
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = caseAssociationClassCallExpCS(nameExpCS);
				if (result == null) result = caseShadowExpCS(nameExpCS);
				if (result == null) result = caseIterateCallExpCS(nameExpCS);
				if (result == null) result = caseOperationCallExpCS(nameExpCS);
				if (result == null) result = casePropertyCallExpCS(nameExpCS);
				if (result == null) result = caseVariableExpCS(nameExpCS);
				if (result == null) result = caseIterationCallExpCS(nameExpCS);
				if (result == null) result = caseCallExpCS(nameExpCS);
				if (result == null) result = caseAbstractNameExpCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseModelElementCS(nameExpCS);
				if (result == null) result = casePivotableElementCS(nameExpCS);
				if (result == null) result = caseElementCS(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 26:
			{
				NavigatingArgCS navigatingArgCS = (NavigatingArgCS)theEObject;
				T result = caseNavigatingArgCS(navigatingArgCS);
				if (result == null) result = caseModelElementCS(navigatingArgCS);
				if (result == null) result = casePivotableElementCS(navigatingArgCS);
				if (result == null) result = caseElementCS(navigatingArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 27:
			{
				NestedExpCS nestedExpCS = (NestedExpCS)theEObject;
				T result = caseNestedExpCS(nestedExpCS);
				if (result == null) result = caseExpCS(nestedExpCS);
				if (result == null) result = caseModelElementCS(nestedExpCS);
				if (result == null) result = casePivotableElementCS(nestedExpCS);
				if (result == null) result = caseElementCS(nestedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 28:
			{
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseExpCS(nullLiteralExpCS);
				if (result == null) result = caseModelElementCS(nullLiteralExpCS);
				if (result == null) result = casePivotableElementCS(nullLiteralExpCS);
				if (result == null) result = caseElementCS(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 29:
			{
				NumberLiteralExpCS numberLiteralExpCS = (NumberLiteralExpCS)theEObject;
				T result = caseNumberLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseExpCS(numberLiteralExpCS);
				if (result == null) result = caseModelElementCS(numberLiteralExpCS);
				if (result == null) result = casePivotableElementCS(numberLiteralExpCS);
				if (result == null) result = caseElementCS(numberLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 30:
			{
				OperationCallExpCS operationCallExpCS = (OperationCallExpCS)theEObject;
				T result = caseOperationCallExpCS(operationCallExpCS);
				if (result == null) result = caseCallExpCS(operationCallExpCS);
				if (result == null) result = caseAbstractNameExpCS(operationCallExpCS);
				if (result == null) result = caseExpCS(operationCallExpCS);
				if (result == null) result = caseModelElementCS(operationCallExpCS);
				if (result == null) result = casePivotableElementCS(operationCallExpCS);
				if (result == null) result = caseElementCS(operationCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 31:
			{
				OperatorExpCS operatorExpCS = (OperatorExpCS)theEObject;
				T result = caseOperatorExpCS(operatorExpCS);
				if (result == null) result = caseExpCS(operatorExpCS);
				if (result == null) result = caseNamedElementCS(operatorExpCS);
				if (result == null) result = caseModelElementCS(operatorExpCS);
				if (result == null) result = casePivotableElementCS(operatorExpCS);
				if (result == null) result = caseElementCS(operatorExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 32:
			{
				PatternExpCS patternExpCS = (PatternExpCS)theEObject;
				T result = casePatternExpCS(patternExpCS);
				if (result == null) result = caseExpCS(patternExpCS);
				if (result == null) result = caseModelElementCS(patternExpCS);
				if (result == null) result = casePivotableElementCS(patternExpCS);
				if (result == null) result = caseElementCS(patternExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 33:
			{
				PrefixExpCS prefixExpCS = (PrefixExpCS)theEObject;
				T result = casePrefixExpCS(prefixExpCS);
				if (result == null) result = caseOperatorExpCS(prefixExpCS);
				if (result == null) result = caseExpCS(prefixExpCS);
				if (result == null) result = caseNamedElementCS(prefixExpCS);
				if (result == null) result = caseModelElementCS(prefixExpCS);
				if (result == null) result = casePivotableElementCS(prefixExpCS);
				if (result == null) result = caseElementCS(prefixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 34:
			{
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseModelElementCS(primitiveLiteralExpCS);
				if (result == null) result = casePivotableElementCS(primitiveLiteralExpCS);
				if (result == null) result = caseElementCS(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 35:
			{
				PropertyCallExpCS propertyCallExpCS = (PropertyCallExpCS)theEObject;
				T result = casePropertyCallExpCS(propertyCallExpCS);
				if (result == null) result = caseCallExpCS(propertyCallExpCS);
				if (result == null) result = caseAbstractNameExpCS(propertyCallExpCS);
				if (result == null) result = caseExpCS(propertyCallExpCS);
				if (result == null) result = caseModelElementCS(propertyCallExpCS);
				if (result == null) result = casePivotableElementCS(propertyCallExpCS);
				if (result == null) result = caseElementCS(propertyCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 36:
			{
				RoundBracketedClauseCS roundBracketedClauseCS = (RoundBracketedClauseCS)theEObject;
				T result = caseRoundBracketedClauseCS(roundBracketedClauseCS);
				if (result == null) result = caseContextLessElementCS(roundBracketedClauseCS);
				if (result == null) result = caseElementCS(roundBracketedClauseCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 37:
			{
				SelfExpCS selfExpCS = (SelfExpCS)theEObject;
				T result = caseSelfExpCS(selfExpCS);
				if (result == null) result = caseExpCS(selfExpCS);
				if (result == null) result = caseModelElementCS(selfExpCS);
				if (result == null) result = casePivotableElementCS(selfExpCS);
				if (result == null) result = caseElementCS(selfExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 38:
			{
				ShadowExpCS shadowExpCS = (ShadowExpCS)theEObject;
				T result = caseShadowExpCS(shadowExpCS);
				if (result == null) result = caseAbstractNameExpCS(shadowExpCS);
				if (result == null) result = caseExpCS(shadowExpCS);
				if (result == null) result = caseModelElementCS(shadowExpCS);
				if (result == null) result = casePivotableElementCS(shadowExpCS);
				if (result == null) result = caseElementCS(shadowExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 39:
			{
				ShadowPartCS shadowPartCS = (ShadowPartCS)theEObject;
				T result = caseShadowPartCS(shadowPartCS);
				if (result == null) result = caseModelElementCS(shadowPartCS);
				if (result == null) result = casePivotableElementCS(shadowPartCS);
				if (result == null) result = caseElementCS(shadowPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 40:
			{
				SquareBracketedClauseCS squareBracketedClauseCS = (SquareBracketedClauseCS)theEObject;
				T result = caseSquareBracketedClauseCS(squareBracketedClauseCS);
				if (result == null) result = caseContextLessElementCS(squareBracketedClauseCS);
				if (result == null) result = caseElementCS(squareBracketedClauseCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 41:
			{
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				T result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseExpCS(stringLiteralExpCS);
				if (result == null) result = caseModelElementCS(stringLiteralExpCS);
				if (result == null) result = casePivotableElementCS(stringLiteralExpCS);
				if (result == null) result = caseElementCS(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 42:
			{
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseExpCS(tupleLiteralExpCS);
				if (result == null) result = caseModelElementCS(tupleLiteralExpCS);
				if (result == null) result = casePivotableElementCS(tupleLiteralExpCS);
				if (result == null) result = caseElementCS(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 43:
			{
				TupleLiteralPartCS tupleLiteralPartCS = (TupleLiteralPartCS)theEObject;
				T result = caseTupleLiteralPartCS(tupleLiteralPartCS);
				if (result == null) result = caseVariableCS(tupleLiteralPartCS);
				if (result == null) result = caseNamedElementCS(tupleLiteralPartCS);
				if (result == null) result = caseModelElementCS(tupleLiteralPartCS);
				if (result == null) result = casePivotableElementCS(tupleLiteralPartCS);
				if (result == null) result = caseElementCS(tupleLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 44:
			{
				TypeLiteralExpCS typeLiteralExpCS = (TypeLiteralExpCS)theEObject;
				T result = caseTypeLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseExpCS(typeLiteralExpCS);
				if (result == null) result = caseModelElementCS(typeLiteralExpCS);
				if (result == null) result = casePivotableElementCS(typeLiteralExpCS);
				if (result == null) result = caseElementCS(typeLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 45:
			{
				TypeNameExpCS typeNameExpCS = (TypeNameExpCS)theEObject;
				T result = caseTypeNameExpCS(typeNameExpCS);
				if (result == null) result = caseTypedRefCS(typeNameExpCS);
				if (result == null) result = caseTypeRefCS(typeNameExpCS);
				if (result == null) result = caseElementRefCS(typeNameExpCS);
				if (result == null) result = casePivotableElementCS(typeNameExpCS);
				if (result == null) result = caseElementCS(typeNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 46:
			{
				UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
				T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseModelElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePivotableElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 47:
			{
				VariableCS variableCS = (VariableCS)theEObject;
				T result = caseVariableCS(variableCS);
				if (result == null) result = caseNamedElementCS(variableCS);
				if (result == null) result = caseModelElementCS(variableCS);
				if (result == null) result = casePivotableElementCS(variableCS);
				if (result == null) result = caseElementCS(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 48:
			{
				VariableExpCS variableExpCS = (VariableExpCS)theEObject;
				T result = caseVariableExpCS(variableExpCS);
				if (result == null) result = caseAbstractNameExpCS(variableExpCS);
				if (result == null) result = caseExpCS(variableExpCS);
				if (result == null) result = caseModelElementCS(variableExpCS);
				if (result == null) result = casePivotableElementCS(variableExpCS);
				if (result == null) result = caseElementCS(variableExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNameExpCS(AbstractNameExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationClassCallExpCS(AssociationClassCallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpCS(CallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionPatternCS(CollectionPatternCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeCS(CollectionTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextCS(ContextCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Curly Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Curly Bracketed Clause CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCurlyBracketedClauseCS(CurlyBracketedClauseCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp Specification CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpSpecificationCS(ExpSpecificationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExpCS(IfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Then Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Then Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfThenExpCS(IfThenExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfixExpCS(InfixExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateCallExpCS(IterateCallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationCallExpCS(IterationCallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lambda Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lambda Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLambdaLiteralExpCS(LambdaLiteralExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpCS(LetExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetVariableCS(LetVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpCS(LiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapLiteralExpCS(MapLiteralExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapLiteralPartCS(MapLiteralPartCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapTypeCS(MapTypeCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpCS(NameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigatingArgCS(NavigatingArgCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedExpCS(NestedExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralExpCS(NullLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberLiteralExpCS(NumberLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExpCS(OperationCallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorExpCS(OperatorExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternExpCS(PatternExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrefixExpCS(PrefixExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExpCS(PropertyCallExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Round Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Round Bracketed Clause CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoundBracketedClauseCS(RoundBracketedClauseCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfExpCS(SelfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shadow Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shadow Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShadowExpCS(ShadowExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shadow Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shadow Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShadowPartCS(ShadowPartCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Square Bracketed Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Square Bracketed Clause CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSquareBracketedClauseCS(SquareBracketedClauseCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpCS(StringLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralExpCS(TupleLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralPartCS(TupleLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteralExpCS(TypeLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeNameExpCS(TypeNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedNaturalLiteralExpCS(
			UnlimitedNaturalLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableCS(VariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExpCS(VariableExpCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotableElementCS(PivotableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementRefCS(ElementRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRefCS(TypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedRefCS(TypedRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Less Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Less Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextLessElementCS(ContextLessElementCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificationCS(SpecificationCS object) {
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

} //EssentialOCLCSSwitch
