/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Super-class of handlers of this project to mutualize some code.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public abstract class AbstractPapyrusDiagramDiffHandler implements IDiffHandler {

	/**
	 * Indicates whether the given {@link Diff} is a change of the reference <code>uml::Property.type</code>.
	 * 
	 * @param diff
	 *            The diff
	 * @return <code>true</code> if and only if the given diff is a {@link ReferenceChange} that concerns the
	 *         <code>uml::TypedElement.type</code> reference, on an Property
	 */
	protected boolean isPropertyTypeChange(ReferenceChange diff) {
		EReference ref = diff.getReference();
		return ref == UMLPackage.Literals.TYPED_ELEMENT__TYPE
				&& getOriginMatchObject(diff) instanceof Property;
	}

	/**
	 * Indicates whether the given {@link ReferenceChange} is a change of the "source" or "target" EReference
	 * of a uml::Transition.
	 * 
	 * @param diff
	 *            The diff
	 * @return <code>true</code> if and only if the change is that of a Transition's target or source
	 *         reference.
	 */
	protected boolean isTransitionReferenceChange(ReferenceChange diff) {
		EReference ref = diff.getReference();
		return (ref == UMLPackage.Literals.TRANSITION__TARGET
				|| ref == UMLPackage.Literals.TRANSITION__SOURCE)
				&& getOriginMatchObject(diff) instanceof Transition;
	}

	/**
	 * Indicates whether the given {@link ReferenceChange} is a change of the "source" or "target" EReference
	 * of a notation::Connector.
	 * 
	 * @param diff
	 *            the ref change
	 * @return <code>true</code> if and only if the change is that of a Connector'target or source reference.
	 */
	protected boolean isConnectorReferenceChange(ReferenceChange diff) {
		EReference ref = diff.getReference();
		return (ref == NotationPackage.Literals.EDGE__TARGET || ref == NotationPackage.Literals.EDGE__SOURCE)
				&& getOriginMatchObject(diff) instanceof Connector;
	}

	/**
	 * Indicates whether the given {@link ReferenceChange} is a part of a more global ADD or DELETE change.
	 * 
	 * @param refChange
	 *            The ref change
	 * @return <code>true</code> if and only if the given change is part of an ADD or DELETE.
	 */
	protected boolean isContainedInAddOrDelete(ReferenceChange refChange) {
		EObject eContainer = refChange.getMatch().eContainer();
		if (eContainer instanceof Match) {
			if (MatchUtil.getOriginValue(refChange.getMatch().getComparison(), refChange) == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Provides the EObject of the given diff's match that is on the "origin" side, which is LEFT for 2-way
	 * and ORIGIN for 3-way.
	 * 
	 * @param diff
	 *            The diff
	 * @return The EObject of the diff's match that is on the LEFT if the diff's comparison is 2-way, and on
	 *         the ORIGIN side if the diff's comparison is 3-way.
	 */
	protected EObject getOriginMatchObject(Diff diff) {
		Match match = diff.getMatch();
		final EObject result;
		if (match == null) {
			result = null; // diff is a ResourceLocationChange, for instance
		} else {
			if (match.getOrigin() != null) {
				result = match.getOrigin();
			} else {
				result = match.getLeft();
			}
		}
		return result;
	}

}
