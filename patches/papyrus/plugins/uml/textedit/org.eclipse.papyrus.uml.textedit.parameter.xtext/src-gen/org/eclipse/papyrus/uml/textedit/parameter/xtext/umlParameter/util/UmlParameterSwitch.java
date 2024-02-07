/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NoValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NullValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.Value;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule;

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
 * 
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage
 * @generated
 */
public class UmlParameterSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlParameterPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlParameterSwitch() {
		if (modelPackage == null) {
			modelPackage = UmlParameterPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param ePackage
	 *            the package in question.
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
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case UmlParameterPackage.PARAMETER_RULE: {
			ParameterRule parameterRule = (ParameterRule) theEObject;
			T result = caseParameterRule(parameterRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.MODIFIERS_RULE: {
			ModifiersRule modifiersRule = (ModifiersRule) theEObject;
			T result = caseModifiersRule(modifiersRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.MODIFIER_SPECIFICATION: {
			ModifierSpecification modifierSpecification = (ModifierSpecification) theEObject;
			T result = caseModifierSpecification(modifierSpecification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.VISIBILITY_RULE: {
			VisibilityRule visibilityRule = (VisibilityRule) theEObject;
			T result = caseVisibilityRule(visibilityRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.DIRECTION_RULE: {
			DirectionRule directionRule = (DirectionRule) theEObject;
			T result = caseDirectionRule(directionRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.EFFECT_RULE: {
			EffectRule effectRule = (EffectRule) theEObject;
			T result = caseEffectRule(effectRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.DEFAULT_VALUE_RULE: {
			DefaultValueRule defaultValueRule = (DefaultValueRule) theEObject;
			T result = caseDefaultValueRule(defaultValueRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.VALUE: {
			Value value = (Value) theEObject;
			T result = caseValue(value);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.INT_VALUE: {
			IntValue intValue = (IntValue) theEObject;
			T result = caseIntValue(intValue);
			if (result == null)
				result = caseValue(intValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.STRING_VALUE: {
			StringValue stringValue = (StringValue) theEObject;
			T result = caseStringValue(stringValue);
			if (result == null)
				result = caseValue(stringValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.BOOLEAN_VALUE: {
			BooleanValue booleanValue = (BooleanValue) theEObject;
			T result = caseBooleanValue(booleanValue);
			if (result == null)
				result = caseValue(booleanValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.REAL_VALUE: {
			RealValue realValue = (RealValue) theEObject;
			T result = caseRealValue(realValue);
			if (result == null)
				result = caseValue(realValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.NULL_VALUE: {
			NullValue nullValue = (NullValue) theEObject;
			T result = caseNullValue(nullValue);
			if (result == null)
				result = caseValue(nullValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlParameterPackage.NO_VALUE: {
			NoValue noValue = (NoValue) theEObject;
			T result = caseNoValue(noValue);
			if (result == null)
				result = caseValue(noValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterRule(ParameterRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiers Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiers Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiersRule(ModifiersRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifierSpecification(ModifierSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visibility Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visibility Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisibilityRule(VisibilityRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direction Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direction Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectionRule(DirectionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effect Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effect Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffectRule(EffectRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Value Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Value Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultValueRule(DefaultValueRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntValue(IntValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValue(StringValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanValue(BooleanValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealValue(RealValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullValue(NullValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoValue(NoValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // UmlParameterSwitch
