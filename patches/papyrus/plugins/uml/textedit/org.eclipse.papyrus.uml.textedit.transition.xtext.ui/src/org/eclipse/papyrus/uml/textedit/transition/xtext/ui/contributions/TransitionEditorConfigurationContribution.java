/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.textedit.transition.xtext.ui.internal.UmlTransitionActivator;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.tools.helper.EventCreationHelper;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 *
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for Transitions of UML StateMachines.
 *
 */
@SuppressWarnings("nls")
public class TransitionEditorConfigurationContribution extends DefaultXtextDirectEditorConfiguration implements ICustomDirectEditorConfiguration {

	private static final String EMPTY = ""; //$NON-NLS-1$

	public static final String LANGUAGE = "Advanced transition textual editor"; //$NON-NLS-1$

	/**
	 * Override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.MULTI | SWT.WRAP;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Transition) {
			Transition transition = (Transition) editedObject;
			String textToEdit = EMPTY;

			// Triggers
			if (!transition.getTriggers().isEmpty()) {
				boolean isFirstTrigger = true;
				for (Trigger t : transition.getTriggers()) {
					if (!isFirstTrigger) {
						textToEdit = textToEdit + ", ";
					} else {
						isFirstTrigger = false;
					}
					Event e = t.getEvent();
					if (e instanceof CallEvent) {
						textToEdit = textToEdit + ((CallEvent) e).getOperation().getName();
					} else if (e instanceof SignalEvent) {
						textToEdit = textToEdit + ((SignalEvent) e).getSignal().getName();
					} else if (e instanceof ChangeEvent) {
						ValueSpecification specification = ((ChangeEvent) e).getChangeExpression();
						if (specification instanceof OpaqueExpression) { // Partial fix for Bug 475719
							String body = retrieveBody((OpaqueExpression) specification, "Natural language");
							textToEdit = textToEdit + "when \"" + body + "\"";
						} else {
							// TODO: What if the specification of the ChangeEvent is not an OpaqueExpression?
						}
					} else if (e instanceof TimeEvent) {
						String absRelPrefix = EMPTY + (((TimeEvent) e).isRelative() ? "after " : "at ");
						textToEdit = textToEdit + absRelPrefix + "\"" + retrieveBody((OpaqueExpression) ((TimeEvent) e).getWhen().getExpr(), "Natural language") + "\"";
					} else { // any receive event
						textToEdit = textToEdit + "all";
					}
				}
			}

			// Guard
			if (transition.getGuard() != null && transition.getGuard().getSpecification() != null) {
				textToEdit = textToEdit + " [" + "\"" + retrieveBody((OpaqueExpression) transition.getGuard().getSpecification(), "Natural language") + "\"" + "]";
			}

			if (transition.getEffect() != null) {
				textToEdit = textToEdit + " /\n";
				String behaviorKind = EMPTY;
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof Activity)) ? "Activity " : EMPTY);
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof StateMachine)) ? "StateMachine " : EMPTY);
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof OpaqueBehavior)) ? "OpaqueBehavior " : EMPTY);
				textToEdit = textToEdit + behaviorKind + " " + transition.getEffect().getName();
			}

			return textToEdit;
		}

		return "not a State";
	}

	private String retrieveBody(OpaqueExpression exp, String languageName) {
		String body = EMPTY;
		if (exp == null) {
			return body;
		}
		int index = 0;
		for (String _languageName : exp.getLanguages()) {
			if (_languageName.equals(languageName)) {
				if (index < exp.getBodies().size()) {
					return exp.getBodies().get(index);
				} else {
					return EMPTY;
				}
			}
			index++;
		}
		return body;
	}

	/**
	 * @author CEA LIST
	 *
	 *         A command for updating the context UML model
	 */
	protected class UpdateUMLTransitionCommand extends AbstractTransactionalCommand {
		
		private static final String ANY = "any"; //$NON-NLS-1$
		
		private final Transition transition;

		private final TransitionRule transitionRuleObject;

		private List<Trigger> newTriggers = new ArrayList<Trigger>();

		private Constraint newConstraint = null;

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			// - Events associated with triggers of this transition
			for (Trigger t : transition.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				if (UML2Util.getNonNavigableInverseReferences(e).size() == 0) {
					// no trigger is referencing the event any more, delete call event
					e.destroy();
				}
			}
			// - Triggers owned by this transition
			transition.getTriggers().removeAll(transition.getTriggers());
			// - Guard associated with the transition
			Constraint guard = transition.getGuard();
			transition.setGuard(null);
			if (guard != null) {
				guard.destroy();
			}

			// ////////////////////////////////////////////////////////////////////////////////////////////////
			// Then extract any relevant information from the TransitionRuleObject, and update the Transition
			// ////////////////////////////////////////////////////////////////////////////////////////////////

			// Create the new triggers
			if (transitionRuleObject != null) {
				if (transitionRuleObject.getTriggers() != null) {
					for (EventRule eventRule : transitionRuleObject.getTriggers()) {
						Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
						this.newTriggers.add(newTrigger);
						newTrigger.setEvent(createUMLEvent(eventRule));
					}
					transition.getTriggers().addAll(this.newTriggers);
				}
				// Create the new constraint
				if (transitionRuleObject.getGuard() != null && transitionRuleObject.getGuard().getConstraint() != null) {
					this.newConstraint = transition.createGuard(EMPTY);
					OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
					guardSpecification.getLanguages().add(EventCreationHelper.NATURAL_LANGUAGE);
					guardSpecification.getBodies().add(EMPTY + transitionRuleObject.getGuard().getConstraint());
					this.newConstraint.setSpecification(guardSpecification);
				}

				boolean hasEffect = transitionRuleObject.getEffect() != null && transitionRuleObject.getEffect().getKind() != null && transitionRuleObject.getEffect().getBehaviorName() != null;
				BehaviorKind oldKind = getBehaviorKind(transition.getEffect());

				if ((!hasEffect) || (transitionRuleObject.getEffect().getKind() != oldKind)) {
					// delete owned effect behavior
					Behavior effect = transition.getEffect();
					transition.setEffect(null);
					if (effect != null) {
						effect.destroy();
					}
				}

				// Create the new behavior
				if (hasEffect) {
					String behaviorName = transitionRuleObject.getEffect().getBehaviorName();
					if (transition.getEffect() == null) {
						// behavior does exist yet => create
						Behavior newEffectBehavior = createUMLBehavior(transitionRuleObject.getEffect().getKind(), behaviorName);
						transition.setEffect(newEffectBehavior);
					} else {
						transition.getEffect().setName(behaviorName);
					}
				}
			} else {
				// no effect, remove it.
				Behavior effect = transition.getEffect();
				transition.setEffect(null);
				if (effect != null) {
					effect.destroy();
				}
			}

			return CommandResult.newOKCommandResult(transition);
		}
		
		private Event createUMLEvent(EventRule eventRule) {
			Event e = null;
			EventCreationHelper helper = new EventCreationHelper(transition);
			// TODO : implement
			if (eventRule instanceof CallOrSignalEventRule) {
				CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule) eventRule;
				if (callOrSignalEventRule.getOperationOrSignal() != null) {
					NamedElement operationOrSignal = callOrSignalEventRule.getOperationOrSignal();
					if (operationOrSignal instanceof Operation) {
						e = helper.getOrCreateCallEvent((Operation) operationOrSignal, true);
					} else { // instanceof Signal
						e = helper.getOrCreateSignalEvent((Signal) operationOrSignal, true);
					}
				}
			} else if (eventRule instanceof ChangeEventRule) {
				ChangeEventRule changeEventRule = (ChangeEventRule) eventRule;
				if (changeEventRule.getExp() != null) {
					e = helper.getOrCreateChangeEvent(changeEventRule.getExp(), true);
				}
			} else if (eventRule instanceof TimeEventRule) {
				TimeEventRule timeEventRule = (TimeEventRule) eventRule;
				if (timeEventRule.getExpr() != null) {
					e = helper.getOrCreateTimeEvent(timeEventRule.getExpr(), timeEventRule instanceof RelativeTimeEventRule, true);
				}
			} else { // AnyReceiveEventRule
				e = UMLFactory.eINSTANCE.createAnyReceiveEvent();
				helper.getEventPackage().getPackagedElements().add(e);
				e.setName(ANY);
			}
			return e;
		}

		/**
		 * Return the behaviorKind for a given behavior
		 *
		 * @param behavior
		 *            the behavior
		 * @return
		 */
		protected BehaviorKind getBehaviorKind(Behavior behavior) {
			if (behavior instanceof OpaqueBehavior) {
				return BehaviorKind.OPAQUE_BEHAVIOR;
			} else if (behavior instanceof Activity) {
				return BehaviorKind.ACTIVITY;
			} else if (behavior instanceof StateMachine) {
				return BehaviorKind.STATE_MACHINE;
			} else {
				return null;
			}
		}

		/**
		 * Create a new UML behavior of a given kind
		 *
		 * @param kind
		 *            the behavior kind
		 * @param name
		 *            the name of the behavior
		 * @return the created behavior
		 */
		protected Behavior createUMLBehavior(BehaviorKind kind, String name) {
			if (kind == null) {
				return null;
			}

			Behavior behavior = null;

			switch (kind) {
			case ACTIVITY:
				behavior = UMLFactory.eINSTANCE.createActivity();
				break;

			case OPAQUE_BEHAVIOR:
				behavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
				break;

			case STATE_MACHINE:
				behavior = UMLFactory.eINSTANCE.createStateMachine();
				break;

			default:
				break;
			}

			behavior.setName(name);

			return behavior;
		}

		public UpdateUMLTransitionCommand(TransactionalEditingDomain domain, Transition transition, TransitionRule transitionRule) {
			super(domain, "Transition Update", getWorkspaceFiles(transition)); //$NON-NLS-1$
			this.transition = transition;
			this.transitionRuleObject = transitionRule;
		}
	}

	@Override
	public Injector getInjector() {
		return UmlTransitionActivator.getInstance().getInjector(UmlTransitionActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_TRANSITION_XTEXT_UMLTRANSITION);
	}

	@Override
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {

		if (!(modelObject instanceof Transition)) {
			return null;
		}

		Transition transition = (Transition) modelObject;

		TransitionRule transitionRuleObject = (TransitionRule) xtextObject;
		// transitionRuleObject may be null, if we have no input left

		// Creates and executes the update command
		try {
			TransactionalEditingDomain dom = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(transition);
			UpdateUMLTransitionCommand updateCommand = new UpdateUMLTransitionCommand(dom, transition, transitionRuleObject);
			return updateCommand;
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

}
