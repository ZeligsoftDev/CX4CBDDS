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
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 *
 */
public interface ISectionComposite {

	/**
	 * Creates the content of the Section.
	 *
	 * @param factory
	 *            the factory used to create the widgets for the section
	 * @param parent
	 *            the parent of the composite for this section
	 *
	 * @return the top level Composite of this section
	 */
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory);

	/**
	 * Refresh the contents of the controls displayed in this section.
	 */
	public void refresh();


}
