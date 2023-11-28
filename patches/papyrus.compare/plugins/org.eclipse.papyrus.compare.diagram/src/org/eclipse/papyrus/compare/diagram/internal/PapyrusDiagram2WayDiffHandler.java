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
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <p>
 * Handles a diff for 2-way comparisons by indexing the given diff with a relevant key if this diff can be
 * related to another diff in the same model. It only cares about notation and UML diffs that can be related
 * with one another (changing the target of an Edge and the related change of UML Property if the Edge
 * represents an Association, an so on).
 * </p>
 * This should only be used with 2-way comparisons!
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class PapyrusDiagram2WayDiffHandler extends AbstractPapyrusDiagramDiffHandler {
	/** The indexer. */
	private final DiffIndexer indexer;

	/**
	 * Constructor.
	 * 
	 * @param indexer
	 *            The indexer
	 */
	public PapyrusDiagram2WayDiffHandler(DiffIndexer indexer) {
		this.indexer = indexer;
	}

	/**
	 * Handle the given diff.
	 * 
	 * @param diff
	 *            he diff to handle
	 */
	public void handle(Diff diff) {
		if (diff instanceof ReferenceChange && diff.getKind() == DifferenceKind.CHANGE) {
			ReferenceChange refChange = (ReferenceChange)diff;
			// Check the match is not contained in an ADD or DELETE
			if (!isContainedInAddOrDelete(refChange)) {
				handleActualReferenceChange(refChange);
			}
		}
	}

	/**
	 * Handles an actual reference change, that is to say a reference change that is not contained in an ADD
	 * or a DELETE diff.
	 * 
	 * @param refChange
	 *            The {@link ReferenceChange} to handle
	 */
	private void handleActualReferenceChange(ReferenceChange refChange) {
		if (isConnectorReferenceChange(refChange)) {
			// Changing the target of an edge that represents an
			// association has consequences
			Match match = refChange.getMatch();
			Connector left = (Connector)match.getLeft();
			if (left == null) {
				return;
			}
			EObject leftElement = left.getElement();
			if (leftElement instanceof Association) {
				Association assoc = (Association)leftElement;
				for (Property memberEnd : assoc.getMemberEnds()) {
					indexer.putEquivalentDiff(memberEnd, refChange);
				}
			} else if (leftElement instanceof Transition) {
				if (refChange.getReference() == NotationPackage.Literals.EDGE__SOURCE) {
					indexer.putEquivalentDiff(
							new FeatureInstance(leftElement, UMLPackage.Literals.TRANSITION__SOURCE),
							refChange);
				} else if (refChange.getReference() == NotationPackage.Literals.EDGE__TARGET) {
					indexer.putEquivalentDiff(
							new FeatureInstance(leftElement, UMLPackage.Literals.TRANSITION__TARGET),
							refChange);
				}
			}
		} else if (isPropertyTypeChange(refChange)) {
			// We record property type changes for properties
			// because those that participate in relations
			// materialize in notation files by a target change in
			// the related Connector
			indexer.putEquivalentDiff(refChange.getMatch().getLeft(), refChange);
		} else if (isTransitionReferenceChange(refChange)) {
			indexer.putEquivalentDiff(
					new FeatureInstance(refChange.getMatch().getLeft(), refChange.getReference()), refChange);
		}
		// TODO Manage other kinds of relations (Dependency, what
		// else in UML?)
	}

}
