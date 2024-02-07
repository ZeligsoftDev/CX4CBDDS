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
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.validation.UMLConnectionPointReferenceJavaValidator;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class UMLConnectionPointReferenceScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Rule for computing the scope of entry references
	 *
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_ConnectionPointReferenceRule_entry(ConnectionPointReferenceRule ctx, EReference ref) {

		List<Pseudostate> allPseudostates = getConnectionPoints(ctx, PseudostateKind.ENTRY_POINT_LITERAL);

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		iterableIEobjectDescriptions = Scopes.scopedElementsFor(allPseudostates);
		resultScope = new SimpleScope(iterableIEobjectDescriptions);

		return resultScope;
	}

	/**
	 * Rule for computing the scope of exit references
	 *
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_ConnectionPointReferenceRule_exit(ConnectionPointReferenceRule ctx, EReference ref) {
		List<Pseudostate> allPseudostates = getConnectionPoints(ctx, PseudostateKind.EXIT_POINT_LITERAL);

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		iterableIEobjectDescriptions = Scopes.scopedElementsFor(allPseudostates);
		resultScope = new SimpleScope(iterableIEobjectDescriptions);

		return resultScope;
	}

	private List<Pseudostate> getConnectionPoints(ConnectionPointReferenceRule ctx, PseudostateKind kind) {
		List<Pseudostate> allPseudostates = new ArrayList<Pseudostate>();

		if (UMLConnectionPointReferenceJavaValidator.getContextElement() == null ||
				!(UMLConnectionPointReferenceJavaValidator.getContextElement() instanceof ConnectionPointReference)) {
			return allPseudostates;
		}

		ConnectionPointReference connectionPoint = (ConnectionPointReference) UMLConnectionPointReferenceJavaValidator.getContextElement();

		State contextState = connectionPoint.getState();
		StateMachine subMachine = contextState != null ? contextState.getSubmachine() : null;

		if (subMachine == null) {
			return allPseudostates;
		}

		for (Pseudostate p : subMachine.getConnectionPoints()) {
			if (p.getKind() == kind) {
				allPseudostates.add(p);
			}
		}

		return allPseudostates;
	}

}
