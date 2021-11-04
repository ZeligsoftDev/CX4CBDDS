/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Shuai Li (CEA LIST) <shuai.li@cea.fr> - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Helper class to specify transition
 *
 */
public class EventCreationHelper {
	public static final String NATURAL_LANGUAGE = "Natural language"; //$NON-NLS-1$
	public static final String EVENTS = "events"; //$NON-NLS-1$
	
	Transition transition;
	
	public EventCreationHelper(Transition transition) {
		this.transition = transition;
	}
	
	/**
	 * put events in a sub-directory of the nearest package
	 *
	 * @return the resulting package
	 */
	public Package getEventPackage() {
		Package np = transition.getNearestPackage();
		for (int i = 0;; i++) {
			String name = EVENTS;
			if (i > 0) {
				name += i;
			}
			PackageableElement ep = np.getPackagedElement(name);
			if (ep instanceof Package) {
				return (Package) ep;
			} else if (ep == null) {
				// does not exist, create
				return np.createNestedPackage(name);
			}
			// exists, but is not a package, try again with different name ...
		}
	}

	/**
	 * Create a new call event (or get an existing call event) for an operation
	 *
	 * @param operation
	 * @return
	 */
	public CallEvent getOrCreateCallEvent(Operation operation, boolean renameExisting) {
		String name = "CE - " + operation.getClass_().getName() + " - " + operation.getName(); //$NON-NLS-1$ //$NON-NLS-2$
		Package eventPkg = getEventPackage();
		for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
			if (existingPE instanceof CallEvent) {
				// Call event with this operation exists already
				if (((CallEvent) existingPE).getOperation() == operation) {
					if (renameExisting) {
						((CallEvent) existingPE).setName(name);
					}
					return (CallEvent) existingPE;
				}
			}
		}
		CallEvent ce = UMLFactory.eINSTANCE.createCallEvent();
		ce.setOperation(operation);
		ce.setName(name);
		eventPkg.getPackagedElements().add(ce);
		return ce;
	}

	/**
	 * Create a new signal event (or get an existing) for a signal
	 *
	 * @param operation
	 * @return
	 */
	public SignalEvent getOrCreateSignalEvent(Signal signal, boolean renameExisting) {
		Package eventPkg = getEventPackage();
		String name = "SE - " + signal.getName(); //$NON-NLS-1$
		for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
			if (existingPE instanceof SignalEvent) {
				// Call event with this operation exists already
				if (((SignalEvent) existingPE).getSignal() == signal) {
					if (renameExisting) {
						((SignalEvent) existingPE).setName(name);
					}
					return (SignalEvent) existingPE;
				}
			}
		}
		SignalEvent se = UMLFactory.eINSTANCE.createSignalEvent();
		se.setSignal(signal);
		se.setName(name);
		eventPkg.getPackagedElements().add(se);
		return se;
	}

	/**
	 * Create a new change event (or get an existing) for an opaque change expression
	 *
	 * @param operation
	 * @return
	 */
	public ChangeEvent getOrCreateChangeEvent(String opaqueChangeExpr, boolean renameExisting) {
		Package eventPkg = getEventPackage();
		String name = "CE - " + opaqueChangeExpr; //$NON-NLS-1$
		for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
			if (existingPE instanceof ChangeEvent) {
				// Call event with this operation exists already
				ValueSpecification vs = ((ChangeEvent) existingPE).getChangeExpression();
				if (vs instanceof OpaqueExpression) {
					EList<String> bodies = ((OpaqueExpression) vs).getBodies();
					if ((bodies.size() > 0) && bodies.get(0).equals(opaqueChangeExpr)) {
						if (renameExisting) {
							((ChangeEvent) existingPE).setName(name);
						}
						return (ChangeEvent) existingPE;
					}
				}
			}
		}
		ChangeEvent ce = UMLFactory.eINSTANCE.createChangeEvent();
		OpaqueExpression changeExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
		changeExpression.getLanguages().add(NATURAL_LANGUAGE);
		changeExpression.getBodies().add(opaqueChangeExpr);
		ce.setChangeExpression(changeExpression);
		ce.setName(name);
		eventPkg.getPackagedElements().add(ce);
		return ce;
	}

	/**
	 * Create a new time event (or get an existing) for an opaque time expression
	 *
	 * @param operation
	 * @return
	 */
	public TimeEvent getOrCreateTimeEvent(String opaqueWhen, boolean isRelative, boolean renameExisting) {
		Package eventPkg = getEventPackage();
		String name = "TE - " + opaqueWhen; //$NON-NLS-1$
		for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
			if (existingPE instanceof TimeEvent) {
				// Call event with this operation exists already
				ValueSpecification vs = ((TimeEvent) existingPE).getWhen().getExpr();
				if (vs instanceof OpaqueExpression) {
					EList<String> bodies = ((OpaqueExpression) vs).getBodies();
					if ((bodies.size() > 0) && bodies.get(0).equals(opaqueWhen)) {
						if (renameExisting) {
							((TimeEvent) existingPE).setName(name);
						}
						return (TimeEvent) existingPE;
					}
				}
			}
		}
		TimeEvent te = UMLFactory.eINSTANCE.createTimeEvent();
		OpaqueExpression timeExpressionExp = UMLFactory.eINSTANCE.createOpaqueExpression();
		timeExpressionExp.getLanguages().add(NATURAL_LANGUAGE);
		timeExpressionExp.getBodies().add(opaqueWhen);
		TimeExpression timeExpression = UMLFactory.eINSTANCE.createTimeExpression();
		timeExpression.setExpr(timeExpressionExp);
		te.setWhen(timeExpression);
		te.setIsRelative(isRelative);
		te.setName(name);
		eventPkg.getPackagedElements().add(te);
		return te;
	}
}
