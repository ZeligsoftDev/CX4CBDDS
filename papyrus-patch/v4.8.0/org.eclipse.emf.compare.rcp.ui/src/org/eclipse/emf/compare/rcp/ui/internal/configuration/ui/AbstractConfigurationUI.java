/*******************************************************************************
 * Copyright (c) 2014, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.osgi.service.prefs.Preferences;

/**
 * Abstract composite that is used to configure an item. The configuration will be stored in the
 * {@link Preferences} passed in parameter.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public abstract class AbstractConfigurationUI extends Composite {
	/** The preference store. */
	private final IPreferenceStore store;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            Parent {@link Composite}.
	 * @param style
	 *            Style of this {@link Composite}
	 * @param store
	 *            The {@link IPreferenceStore} to use for preferences, cannot be <code>null</code>
	 */
	public AbstractConfigurationUI(Composite parent, int style, IPreferenceStore store) {
		super(parent, style);
		this.store = checkNotNull(store);
	}

	/**
	 * Content of this composite. This should be overriden by clients.
	 */
	public abstract void createContent();

	/**
	 * Used to store the configuration. Implementation should store all the configuration in the
	 * {@link Preferences}.
	 */
	public abstract void storeConfiguration();

	/**
	 * Called to restore default preferences. This should be used to reset the configuration in the store.
	 */
	public abstract void resetDefault();

	/**
	 * Get the preference store used by this object.
	 * 
	 * @return The preference store used by this object.
	 */
	protected IPreferenceStore getPreferenceStore() {
		return store;
	}

}
