/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.IStrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;


public class ConstrainedElementContentProvider extends UMLContentProvider {

	public ConstrainedElementContentProvider(EObject source, EStructuralFeature feature) {
		super(source, feature);

		IStructuredContentProvider semanticProvider = getSemanticProvider(source, feature, stereotype);
		encapsulated = encapsulateProvider(semanticProvider, eObject, feature, root);
	}

	public static EMFGraphicalContentProvider encapsulateProvider(IStructuredContentProvider provider, EObject editedEObject, EStructuralFeature feature, ResourceSet root) {
		String historyId;
		if (editedEObject != null && feature != null) {
			historyId = HistoryUtil.getHistoryID(editedEObject, feature);
		} else {
			historyId = "DefaultHistory";
		}

		IStructuredContentProvider contentProvider;

		if (provider instanceof ITreeContentProvider) {
			contentProvider = getStrategyProvider((ITreeContentProvider) provider);
		} else {
			contentProvider = provider;
		}

		EMFGraphicalContentProvider graphicalProvider = new EMFGraphicalContentProvider(contentProvider, root, historyId);

		return graphicalProvider;
	}

	public static IStrategyBasedContentProvider getStrategyProvider(ITreeContentProvider provider) {
		TreeBrowseStrategy browseStrategy = new UMLContainmentBrowseStrategy(provider);
		TreeBrowseStrategy revealStrategy = new UMLContainmentBrowseStrategy(provider);

		return new StrategyBasedContentProvider(browseStrategy, revealStrategy);
	}
}
