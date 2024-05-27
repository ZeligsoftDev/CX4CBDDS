/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory for {@link AbstractConfigurationUI}.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public interface IConfigurationUIFactory {

	/**
	 * Create an {@link AbstractConfigurationUI}
	 * 
	 * @param parent
	 *            Parent composite.
	 * @param style
	 *            Style of the new {@link AbstractConfigurationUI}
	 * @param store
	 *            {@link IPreferenceStore} to store configuration.
	 * @return Configuration UI
	 */
	AbstractConfigurationUI createUI(Composite parent, int style, IPreferenceStore store);

}
