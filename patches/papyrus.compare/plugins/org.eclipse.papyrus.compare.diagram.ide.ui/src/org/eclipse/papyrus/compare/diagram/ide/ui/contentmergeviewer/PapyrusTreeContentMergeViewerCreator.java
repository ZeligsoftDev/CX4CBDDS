/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer;

import java.util.ResourceBundle;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.provider.TreeNodeCompareInput;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.provider.TreeNodeCompareInputLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Creator for {@link PapyrusTreeContentMergeViewer}.
 * 
 * @author Stefan Dirix
 */
@SuppressWarnings("restriction")
public class PapyrusTreeContentMergeViewerCreator implements IViewerCreator {

	/**
	 * {@inheritDoc}
	 */
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		final EMFCompareConfiguration emfConfig = new EMFCompareConfiguration(config);
		emfConfig.setLabelProvider(TreeNodeCompareInput.class, new TreeNodeCompareInputLabelProvider());
		final Viewer viewer = new PapyrusTreeContentMergeViewer(SWT.NONE,
				ResourceBundle.getBundle(PapyrusTreeContentMergeViewer.class.getName()), parent, emfConfig);
		return viewer;
	}

}
