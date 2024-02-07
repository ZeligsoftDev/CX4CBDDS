/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.internal.UmlParameterActivator;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.Value;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.util.UmlParameterSwitch;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

import com.google.inject.Injector;


public class ParameterXtextDirectEditorConfiguration extends DefaultXtextDirectEditorConfiguration {

	@Override
	public Injector getInjector() {
		return UmlParameterActivator.getInstance().getInjector(UmlParameterActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_PARAMETER_XTEXT_UMLPARAMETER);
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		CompositeCommand cc = new CompositeCommand("Set values for Parameter"); //$NON-NLS-1$
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(umlObject);
		if (provider != null) {

			// Manage the name or the label set
			if (!(xtextObject instanceof Parameter)) {
				
				final ParameterRule parameterRuleObject = (ParameterRule) xtextObject;
				final Parameter parameter = (Parameter) umlObject;
				String newName = parameterRuleObject.getName();
				
				ICommand setNameCommand = null;
				if(InternationalizationPreferencesUtils.getInternationalizationPreference(parameter) && null != UMLLabelInternationalization.getInstance().getLabelWithoutUML(parameter)){
					final ModelSet modelSet = (ModelSet)parameter.eResource().getResourceSet();
					setNameCommand = new EMFtoGMFCommandWrapper(UMLLabelInternationalization.getInstance().getSetLabelCommand(modelSet.getTransactionalEditingDomain(), parameter, newName, null));
				}else{
					final SetRequest setNameRequest = new SetRequest(parameter, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
					setNameCommand = provider.getEditCommand(setNameRequest);
				}
				cc.add(setNameCommand);
			}
			
			ICommand editCommand = null;
			for (IEditCommandRequest current : getRequests(umlObject, xtextObject)) {
				editCommand = provider.getEditCommand(current);

				if (editCommand != null && editCommand.canExecute()) {
					cc.add(editCommand);
				}
			}
		}
		return cc;
	}

	/**
	 * Returns the list of requests to update the {@link #parameter}
	 *
	 * @return
	 *         the list of requests to update the {@link #parameter}
	 */
	protected List<IEditCommandRequest> getRequests(EObject modelObject, EObject xtextObject) {
		List<IEditCommandRequest> requests = new ArrayList<IEditCommandRequest>();


		// first: retrieves / determines if the xtextObject is a CollaborationUseRule object
		EObject modifiedObject = xtextObject;
		if (!(modelObject instanceof Parameter)) {
			return requests;
		}
		while (xtextObject != null && !(xtextObject instanceof ParameterRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if (modifiedObject == null) {
			return requests;
		}

		final ParameterRule parameterRuleObject = (ParameterRule) xtextObject;

		final Parameter parameter = (Parameter) modelObject;

		// Retrieves the information to be populated in modelObject
		if (parameterRuleObject.getModifiers() != null) {
			/** the new value for isException */
			boolean newIsException = false;

			/** the new value for isStream */
			boolean newIsStream = false;

			/** the new value for isOrdered */
			boolean newIsOrdered = false;

			/** the new value for isUnique */
			boolean newIsUnique = false;

			for (org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification modifier : parameterRuleObject.getModifiers().getValues()) {
				switch (modifier.getValue()) {
				case ORDERED:
					newIsOrdered = true;
					break;
				case UNIQUE:
					newIsUnique = true;
					break;
				case EXCEPTION:
					newIsException = true;
					break;
				case STREAM:
					newIsStream = true;
					break;
				default:
					break;
				}
			}

			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_IsException(), newIsException));
			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_IsStream(), newIsStream));
			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered));
			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique));
		}

		if (parameterRuleObject.getMultiplicity() != null) {
			/** the new lowerBound */
			int newLowerBound = 1;

			/** the new upperBound */
			int newUpperBound = 1;

			if (parameterRuleObject.getMultiplicity().getBounds().size() == 1) {
				String tempBound = parameterRuleObject.getMultiplicity().getBounds().get(0).getValue();
				if (tempBound.equals("*")) { //$NON-NLS-1$
					newLowerBound = 0;
					newUpperBound = -1;
				} else {
					newLowerBound = new Integer(tempBound).intValue();
					newUpperBound = new Integer(tempBound).intValue();
				}
			} else { // size == 2
				String tempBound = parameterRuleObject.getMultiplicity().getBounds().get(0).getValue();
				newLowerBound = new Integer(tempBound).intValue();
				tempBound = parameterRuleObject.getMultiplicity().getBounds().get(1).getValue();
				if (tempBound.equals("*")) { //$NON-NLS-1$
					newUpperBound = -1;
				} else {
					newUpperBound = new Integer(tempBound).intValue();
				}
			}

			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), newLowerBound));
			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), newUpperBound));
		}

		boolean setType = false;
		TypeRule typeRule = parameterRuleObject.getType();
		Type newType = null;
		if (parameterRuleObject.isTypeUndefined()) {
			setType = true;
		} else if (typeRule != null) {
			newType = typeRule.getType();
			setType = newType != parameter.getType();
		} // Else: no change

		if (setType) {
			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getTypedElement_Type(), newType));
		}

		if (parameterRuleObject.getVisibility() != null) {
			org.eclipse.uml2.uml.VisibilityKind newVisibility;

			VisibilityRule visibility = parameterRuleObject.getVisibility();

			newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

			switch (visibility.getVisibility()) {
			case PUBLIC:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
				break;
			case PACKAGE:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL;
				break;
			case PRIVATE:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL;
				break;
			case PROTECTED:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL;
				break;
			default:
				break;
			}

			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility));
		}

		if (parameterRuleObject.getDirection() != null) {
			DirectionRule direction = parameterRuleObject.getDirection();

			ParameterDirectionKind newDirection = ParameterDirectionKind.IN_LITERAL;

			switch (direction.getDirection()) {
			case IN:
				newDirection = ParameterDirectionKind.IN_LITERAL;
				break;
			case OUT:
				newDirection = ParameterDirectionKind.OUT_LITERAL;
				break;
			case INOUT:
				newDirection = ParameterDirectionKind.INOUT_LITERAL;
				break;
			case RETURN:
				newDirection = ParameterDirectionKind.RETURN_LITERAL;
				break;
			}

			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_Direction(), newDirection));
		}

		if (parameterRuleObject.getEffect() != null) {
			/** the new effect for the parameter */
			ParameterEffectKind newEffect = ParameterEffectKind.CREATE_LITERAL;

			switch (parameterRuleObject.getEffect().getEffectKind()) {
			case CREATE:
				newEffect = ParameterEffectKind.CREATE_LITERAL;
				break;
			case DELETE:
				newEffect = ParameterEffectKind.DELETE_LITERAL;
				break;
			case READ:
				newEffect = ParameterEffectKind.READ_LITERAL;
				break;
			case UPDATE:
				newEffect = ParameterEffectKind.UPDATE_LITERAL;
				break;
			}

			requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_Effect(), newEffect));
		}

		if (parameterRuleObject.getDefaultValue() != null) {
			final ValueSpecification currentDefault = parameter.getDefaultValue();
			Value newDefault = parameterRuleObject.getDefaultValue().getDefault();
			IEditCommandRequest request = new UmlParameterSwitch<IEditCommandRequest>() {
				@Override
				public SetRequest caseBooleanValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue object) {
					boolean booleanValue = object.getLiteralBoolean() == BooleanLiterals.TRUE;
					if (currentDefault instanceof LiteralBoolean) {
						return new SetRequest(currentDefault, UMLPackage.eINSTANCE.getLiteralBoolean_Value(), booleanValue);
					} else {
						// TODO: Destroy previous defaultValue if not null?
						LiteralBoolean literalBoolean = UMLFactory.eINSTANCE.createLiteralBoolean();
						literalBoolean.setValue(booleanValue);
						return new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_DefaultValue(), literalBoolean);
					}
				}

				@Override
				public SetRequest caseStringValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue object) {
					String stringValue = object.getLiteralString();
					if (currentDefault instanceof LiteralString) {
						return new SetRequest(currentDefault, UMLPackage.eINSTANCE.getLiteralString_Value(), stringValue);
					} else {
						// TODO: Destroy previous defaultValue if not null?
						LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
						literalString.setValue(stringValue);
						return new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_DefaultValue(), literalString);
					}
				}

				@Override
				public SetRequest caseIntValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue object) {
					Integer integerValue;
					try {
						integerValue = object.getLiteralInteger();
					} catch (NumberFormatException ex) {
						integerValue = 0;
					}

					if (currentDefault instanceof LiteralInteger) {
						return new SetRequest(currentDefault, UMLPackage.eINSTANCE.getLiteralInteger_Value(), integerValue);
					} else {
						// TODO: Destroy previous defaultValue if not null?
						LiteralInteger literalInteger = UMLFactory.eINSTANCE.createLiteralInteger();
						literalInteger.setValue(integerValue);
						return new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_DefaultValue(), literalInteger);
					}
				}

				@Override
				public SetRequest caseRealValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue object) {
					Double realValue;
					String literalDouble = "" + object.getInteger() + '.' + object.getFraction();
					try {
						realValue = Double.parseDouble(literalDouble);
					} catch (NumberFormatException ex) {
						realValue = 0.;
					}

					if (currentDefault instanceof LiteralReal) {
						return new SetRequest(currentDefault, UMLPackage.eINSTANCE.getLiteralReal_Value(), realValue);
					} else {
						// TODO: Destroy previous defaultValue if not null?
						LiteralReal literalReal = UMLFactory.eINSTANCE.createLiteralReal();
						literalReal.setValue(realValue);
						return new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_DefaultValue(), literalReal);
					}
				}

				@Override
				public SetRequest caseNullValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NullValue object) {
					if (parameter.getDefaultValue() instanceof LiteralNull) {
						return null;
					}

					LiteralNull literalNull = UMLFactory.eINSTANCE.createLiteralNull();
					return new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_DefaultValue(), literalNull);
				}

				@Override
				public IEditCommandRequest caseNoValue(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NoValue object) {
					if (parameter.getDefaultValue() == null) {
						return null;
					}

					return new DestroyElementRequest(parameter.getDefaultValue(), false);
				}
			}.doSwitch(newDefault);


			if (request != null) {
				requests.add(request);
			}
		}

		return requests;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Parameter) {
			return UMLParameterEditorUtil.getLabel((Parameter) editedObject).trim();
		}
		return "not a Parameter"; //$NON-NLS-1$
	}

}
