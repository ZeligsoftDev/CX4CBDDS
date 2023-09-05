/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.ecore.EModelElement;

/**
 * All Composite view has to modify a view
 *
 */
public interface IViewComposite {

	/**
	 * Sets the diagram element.
	 *
	 * @param diagramElement
	 *            the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement);

}
