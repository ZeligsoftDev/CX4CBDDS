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
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.state.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.xtext.validation.Check;


public class UmlStateJavaValidator extends AbstractUmlStateJavaValidator {

	/**
	 * First checks if the new name being attributed to the edited state is already used by another state in the region.
	 * Then, notifies (via warning) any of the potential Behavior deletion implied by the textual specification
	 * (either DoActivity, Enty, or Exit behaviors)
	 *
	 * @param stateRule
	 */
	@Check
	public void checkStateName(StateRule stateRule) {
		if (stateRule.getName() == null || stateRule.getName().equals("")) {
			return;
		}

		//
		// first, checks if the new name of the State is already used by another state in the region
		//
		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) ContextElementUtil.getContextElement(stateRule.eResource());
		List<String> alreadyUsedNames = new ArrayList<String>();

		for (Vertex v : editedState.getContainer().getSubvertices()) {
			if (v instanceof org.eclipse.uml2.uml.State) {
				org.eclipse.uml2.uml.State s = (org.eclipse.uml2.uml.State) v;
				if (s != editedState) {
					alreadyUsedNames.add("" + s.getName());
				}
			}
		}

		String newName = "" + stateRule.getName();

		if (alreadyUsedNames.contains("" + newName) && InternationalizationPreferencesUtils.getInternationalizationPreference(stateRule)) {
			warning("Name " + newName + " is already used by another State in this Region", UmlStatePackage.eINSTANCE.getStateRule_Name());
		}


		// Check if ConnectionPointReference exist when one delete the submachine reference: not allowed!
		if ((stateRule.getSubmachine() == null) && !editedState.getConnections().isEmpty()) {
			error(getErrorMessageForSubmachineState(), UmlStatePackage.eINSTANCE.getStateRule_Submachine());
		}
		//
		// Then, checks if the textual specification implies deletion of the DoActivity, Entry or Exit behavior
		// and raises warnings accordingly
		//

		boolean deletionOfDoActivity = editedState.getDoActivity() != null && stateRule.getDo() == null;
		boolean deletionOfExit = editedState.getExit() != null && stateRule.getExit() == null;
		boolean deletionOfEntry = editedState.getEntry() != null && stateRule.getEntry() == null;

		if (deletionOfDoActivity) {
			warning(getBehaviorKindAsString(getBehaviorKind(editedState.getDoActivity())) + " " + editedState.getDoActivity().getName() + " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name());
		}

		if (deletionOfExit) {
			warning(getBehaviorKindAsString(getBehaviorKind(editedState.getExit())) + " " + editedState.getExit().getName() + " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name());
		}

		if (deletionOfEntry) {
			warning(getBehaviorKindAsString(getBehaviorKind(editedState.getEntry())) + " " + editedState.getEntry().getName() + " will be deleted", UmlStatePackage.eINSTANCE.getStateRule_Name());
		}
	}

	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior)
	 * of the DoActivity behavior.
	 *
	 * @param doRule
	 */
	@Check
	public void checkDoRule(DoRule doRule) {
		if (doRule.getKind() == null) {
			return;
		}
		if (doRule.getBehaviorName() == null || doRule.getBehaviorName().equals("")) {
			return;
		}

		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) ContextElementUtil.getContextElement(doRule.eResource());
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getDoActivity());
		BehaviorKind newDoKind = doRule.getKind();
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " + doRule.getBehaviorName() + " from <<" + getBehaviorKindAsString(oldDoKind) + ">> to <<" + getBehaviorKindAsString(newDoKind) + ">> will cause the deletion of " + getBehaviorKindAsString(oldDoKind) + " "
						+ doRule.getBehaviorName() + ". Any changes made to " + getBehaviorKindAsString(oldDoKind) + " " + doRule.getBehaviorName() + " will be lost", UmlStatePackage.eINSTANCE.getDoRule_Kind());
			}
		}
	}

	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior)
	 * of the Entry behavior.
	 *
	 * @param entryRule
	 */
	@Check
	public void checkEntryRule(EntryRule entryRule) {
		if (entryRule.getKind() == null) {
			return;
		}
		if (entryRule.getBehaviorName() == null || entryRule.getBehaviorName().equals("")) {
			return;
		}

		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) ContextElementUtil.getContextElement(entryRule.eResource());
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getEntry());
		BehaviorKind newDoKind = entryRule.getKind();
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " + entryRule.getBehaviorName() + " from <<" + getBehaviorKindAsString(oldDoKind) + ">> to <<" + getBehaviorKindAsString(newDoKind) + ">> will cause the deletion of " + getBehaviorKindAsString(oldDoKind) + " "
						+ entryRule.getBehaviorName() + ". Any changes made to " + getBehaviorKindAsString(oldDoKind) + " " + entryRule.getBehaviorName() + " will be lost", UmlStatePackage.eINSTANCE.getEntryRule_Kind());
			}
		}
	}

	/**
	 * Notifies (via a Warning) the potential impact of changing the kind (i.e., Activity, StateMachine or OpaqueBehavior)
	 * of the Entry behavior.
	 *
	 * @param exitRule
	 */
	@Check
	public void checkExitRule(ExitRule exitRule) {
		if (exitRule.getKind() == null) {
			return;
		}
		if (exitRule.getBehaviorName() == null || exitRule.getBehaviorName().equals("")) {
			return;
		}

		org.eclipse.uml2.uml.State editedState = (org.eclipse.uml2.uml.State) ContextElementUtil.getContextElement(exitRule.eResource());
		BehaviorKind oldDoKind = getBehaviorKind(editedState.getExit());
		BehaviorKind newDoKind = exitRule.getKind();
		if (oldDoKind != null) {
			if (oldDoKind != newDoKind) {
				warning("Changing the kind of " + exitRule.getBehaviorName() + " from <<" + getBehaviorKindAsString(oldDoKind) + ">> to <<" + getBehaviorKindAsString(newDoKind) + ">> will cause the deletion of " + getBehaviorKindAsString(oldDoKind) + " "
						+ exitRule.getBehaviorName() + ". Any changes made to " + getBehaviorKindAsString(oldDoKind) + " " + exitRule.getBehaviorName() + " will be lost", UmlStatePackage.eINSTANCE.getExitRule_Kind());
			}
		}
	}

	@Check
	public void checkSubmachineRule(SubmachineRule rule) {
		EObject contextElement = ContextElementUtil.getContextElement(rule.eResource());
		if (contextElement == null || !(contextElement instanceof org.eclipse.uml2.uml.State)) {
			return;
		}
		org.eclipse.uml2.uml.State contextState = (org.eclipse.uml2.uml.State) contextElement;
		if (contextState.isOrthogonal()) {
			error(getErrorMessageForOrthogonalState(), UmlStatePackage.eINSTANCE.getSubmachineRule_Submachine());
		}
		if (contextState.isComposite()) {
			error(getErrorMessageForCompositeState(), UmlStatePackage.eINSTANCE.getSubmachineRule_Submachine());
		}
	}

	// *****************//
	// Utility methods //
	// *****************//

	private String getErrorMessageForOrthogonalState() {
		return "An orthogonal state cannot reference a submachine.";
	}

	private String getErrorMessageForCompositeState() {
		return "A composite state cannot reference a submachine.";
	}

	private String getErrorMessageForSubmachineState() {
		return "A simple state cannot have ConnectionPointReferences. You should delete them before removing the reference to the submachine.";
	}

	private static BehaviorKind getBehaviorKind(Behavior behavior) {
		if (behavior == null) {
			return null;
		}
		if (behavior instanceof Activity) {
			return BehaviorKind.ACTIVITY;
		}
		if (behavior instanceof OpaqueBehavior) {
			return BehaviorKind.OPAQUE_BEHAVIOR;
		}
		if (behavior instanceof StateMachine) {
			return BehaviorKind.STATE_MACHINE;
		}
		return null;
	}

	private static String getBehaviorKindAsString(BehaviorKind behaviorKind) {
		if (behaviorKind == BehaviorKind.ACTIVITY) {
			return "Activity";
		}
		if (behaviorKind == BehaviorKind.OPAQUE_BEHAVIOR) {
			return "OpaqueBehavior";
		}
		if (behaviorKind == BehaviorKind.STATE_MACHINE) {
			return "StateMachine";
		}
		return "";
	}
}
