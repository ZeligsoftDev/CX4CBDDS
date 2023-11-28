/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Munich and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Philip Langer - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Post-processor that causes changes applied to the contents of di-files to be ignored.
 * <p>
 * This post-processor removes the matches of model elements contained in di-files. Thus, those elements will
 * be ignored in the subsequent phases of the comparison.
 * </p>
 *
 * @author Philip Langer <planger@eclipsesource.com>
 */
public class IgnoreDiFilePostProcessor implements IPostProcessor {

	/** The name of the class that represents the di-file's root container. */
	private static final String SASH_WINDOWS_MNGR = "SashWindowsMngr"; //$NON-NLS-1$

	/** The file extension of di-files. */
	private static final String DI = "di"; //$NON-NLS-1$

	/**
	 * Removes the matches of or within di-files.
	 * <p>
	 * By removing the matches of resource matches and element matches of or within di-files, any changes
	 * within di-files are ignored during the remaining comparison.
	 * </p>
	 * 
	 * @param comparison
	 *            The comparison
	 * @param monitor
	 *            The progress monitor
	 */
	public void postMatch(Comparison comparison, Monitor monitor) {
		if (monitor == null || !monitor.isCanceled()) {
			filterSashModelMngrMatches(comparison);
			filterDiFileMatchResources(comparison);
		}
	}

	/**
	 * Removes the di-file {@link MatchResource match resources} of the given <code>comparison</code>.
	 * 
	 * @param comparison
	 *            The comparison to remove the match resources from.
	 */
	private void filterDiFileMatchResources(Comparison comparison) {
		final EList<MatchResource> matchedResources = comparison.getMatchedResources();
		for (Iterator<MatchResource> iterator = matchedResources.iterator(); iterator.hasNext();) {
			if (isDiFile(iterator.next())) {
				iterator.remove();
			}
		}
	}

	/**
	 * Removes the root matches that match an {@link EObject} of type {@link SashWindowsMngr} in di-files.
	 * 
	 * @param comparison
	 *            The comparison to remove the {@link SashWindowsMngr} root matches from.
	 */
	private void filterSashModelMngrMatches(Comparison comparison) {
		final EList<Match> matches = comparison.getMatches();
		for (Iterator<Match> iterator = matches.iterator(); iterator.hasNext();) {
			final EObject eObject = getMatchedEObject(iterator.next());
			if (isDiResource(eObject.eResource()) && SASH_WINDOWS_MNGR.equals(eObject.eClass().getName())) {
				iterator.remove();
			}
		}
	}

	/**
	 * Specifies whether the given <code>resource</code> is a di-file.
	 * 
	 * @param resource
	 *            The resource to check.
	 * @return <code>true</code> if it is a di-file (or null), <code>false</code> otherwise.
	 */
	private boolean isDiResource(Resource resource) {
		return resource == null || DI.equals(resource.getURI().fileExtension());
	}

	/**
	 * Returns the {@link EObject} of the given <code>match</code>.
	 * <p>
	 * It is either the {@link Match#getLeft() left}, {@link Match#getRight() right}, or
	 * {@link Match#getOrigin() origin} of the given {@link Match}.
	 * 
	 * @param match
	 *            The match.
	 * @return The {@link EObject} of the given <code>match</code>.
	 */
	private EObject getMatchedEObject(Match match) {
		final EObject eObject;
		if (match.getLeft() != null) {
			eObject = match.getLeft();
		} else if (match.getRight() != null) {
			eObject = match.getRight();
		} else {
			eObject = match.getOrigin();
		}
		return eObject;
	}

	/**
	 * Specifies whether the given <code>matchResource</code> concerns a di-file.
	 * 
	 * @param matchResource
	 *            The {@link MatchResource} to check.
	 * @return <code>true</code> if <code>matchResource</code> concerns a di-file, <code>false</code>
	 *         otherwise.
	 */
	private boolean isDiFile(MatchResource matchResource) {
		final Resource resource;
		if (matchResource.getLeft() != null) {
			resource = matchResource.getLeft();
		} else if (matchResource.getRight() != null) {
			resource = matchResource.getRight();
		} else {
			resource = matchResource.getOrigin();
		}
		return isDiResource(resource);
	}

	/**
	 * {@inheritDoc}
	 */
	public void postDiff(Comparison comparison, Monitor monitor) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void postRequirements(Comparison comparison, Monitor monitor) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void postEquivalences(Comparison comparison, Monitor monitor) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void postConflicts(Comparison comparison, Monitor monitor) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void postComparison(Comparison comparison, Monitor monitor) {
		// nothing to do
	}
}
