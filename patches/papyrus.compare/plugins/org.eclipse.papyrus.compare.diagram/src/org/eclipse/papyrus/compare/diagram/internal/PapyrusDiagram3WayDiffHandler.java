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
 * Handles a diff for 3-way comparisons by indexing the given diff with a relevant key if this diff can be
 * related to another diff in the same model. It only cares about notation and UML diffs that can be related
 * with one another (changing the target of an Edge and the related change of UML Property if the Edge
 * represents an Association, an so on).
 * </p>
 * This should only be used with 3-way comparisons!
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class PapyrusDiagram3WayDiffHandler extends AbstractPapyrusDiagramDiffHandler {
	/**
	 * Constructor.
	 * 
	 * @param indexer
	 *            The indexer
	 */
	private final DiffIndexer indexer;

	/**
	 * Constructor.
	 * 
	 * @param indexer
	 *            The indexer
	 */
	public PapyrusDiagram3WayDiffHandler(DiffIndexer indexer) {
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
			if (!isContainedInAddOrDelete(refChange)) {
				handleActualReferenceChange(refChange);
			}
		}
	}

	/**
	 * Handles a {@link ReferenceChange} that is not part of an ADD or DELETE.
	 * 
	 * @param refChange
	 *            The {@link ReferenceChange} to handle
	 */
	private void handleActualReferenceChange(ReferenceChange refChange) {
		if (isConnectorReferenceChange(refChange)) {
			// Changing the target of an edge that represents an
			// association has consequences
			Connector connectorOnDiffSide = (Connector)getMatchObjectOnSameSideAs(refChange);
			if (connectorOnDiffSide == null) {
				return;
			}
			EObject element = connectorOnDiffSide.getElement();
			if (element instanceof Association) {
				Association assoc = (Association)element;
				for (Property memberEnd : assoc.getMemberEnds()) {
					indexer.putEquivalentDiff(new SidedEObject(memberEnd, refChange.getSource()), refChange);
				}
			} else if (element instanceof Transition) {
				if (refChange.getReference() == NotationPackage.Literals.EDGE__SOURCE) {
					indexer.putEquivalentDiff(new SidedFeatureInstance(element,
							UMLPackage.Literals.TRANSITION__SOURCE, refChange.getSource()), refChange);
				} else if (refChange.getReference() == NotationPackage.Literals.EDGE__TARGET) {
					indexer.putEquivalentDiff(new SidedFeatureInstance(element,
							UMLPackage.Literals.TRANSITION__TARGET, refChange.getSource()), refChange);
				}
			}
		} else if (isPropertyTypeChange(refChange)) {
			// We record property type changes for properties
			// because those that participate in relations
			// materialize in notation files by a target change in
			// the related Connector
			indexer.putEquivalentDiff(
					new SidedEObject(getMatchObjectOnSameSideAs(refChange), refChange.getSource()),
					refChange);
		} else if (isTransitionReferenceChange(refChange)) {
			indexer.putEquivalentDiff(new SidedFeatureInstance(getMatchObjectOnSameSideAs(refChange),
					refChange.getReference(), refChange.getSource()), refChange);
		}
		// TODO Manage other kinds of relations (Dependency, what
		// else in UML?)
	}

	/**
	 * Provides the EObject of the given diff's match that is on the same side as the given diff.
	 * 
	 * @param diff
	 *            The diff
	 * @return The EObject of the given diff's match that's on the same side as the diff.
	 */
	protected EObject getMatchObjectOnSameSideAs(Diff diff) {
		Match match = diff.getMatch();
		// CHECKSTYLE:OFF No need of a default case
		switch (diff.getSource()) {
			case LEFT:
				return match.getLeft();
			case RIGHT:
				return match.getRight();
		}
		// CHECKSTYLE:ON
		throw new IllegalStateException(
				"The diff should be part of a 3-way comparison and have a non-null source."); //$NON-NLS-1$
	}

}
