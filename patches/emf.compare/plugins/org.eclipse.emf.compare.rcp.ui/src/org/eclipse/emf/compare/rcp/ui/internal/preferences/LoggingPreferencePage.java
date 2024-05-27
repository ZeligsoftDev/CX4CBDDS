/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Simon Delisle - bug 495753
 *     Mathias Schaefer - preferences refactoring
 *     Simon Delisle - Change verification for integer fields
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_LEVEL_DEFAULT;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_LEVEL_KEY;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Preference page used to configure logging in EMFCompare.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class LoggingPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Combo levelCombo;

	private final String[] LOG_LEVELS = new String[] {"OFF", "INFO", "DEBUG" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/**
	 * Constructor.
	 */
	public LoggingPreferencePage() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            .
	 * @param image
	 *            .
	 */
	public LoggingPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            .
	 */
	public LoggingPreferencePage(String title) {
		super(title);
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IWorkbench workbench) {
		ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				EMFCompareRCPPlugin.PLUGIN_ID);
		store.setSearchContexts(new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
		setPreferenceStore(store);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite loggingComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(loggingComposite);

		new Label(loggingComposite, SWT.LEAD)
				.setText(EMFCompareRCPUIMessages.getString("LoggingPreferencePage.log.level")); //$NON-NLS-1$
		levelCombo = new Combo(loggingComposite, SWT.DROP_DOWN);
		levelCombo.setItems(LOG_LEVELS);
		levelCombo.setLayoutData(getDefaultFieldGridData(100));

		refreshWidgets();

		return loggingComposite;
	}

	protected GridData getDefaultFieldGridData(int width) {
		GridData gd = new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1);
		gd.widthHint = width;
		return gd;
	}

	protected void savePreferences() throws BackingStoreException, IOException {
		String item = levelCombo.getItem(levelCombo.getSelectionIndex());
		getPreferenceStore().setValue(LOG_LEVEL_KEY, item);
	}

	protected void resetPreferences() {
		getPreferenceStore().setToDefault(LOG_LEVEL_KEY);
	}

	protected void refreshWidgets() {
		IPreferencesService prefsService = Platform.getPreferencesService();
		String level = prefsService.getString(EMFCompareRCPPlugin.PLUGIN_ID, LOG_LEVEL_KEY, LOG_LEVEL_DEFAULT,
				null);
		levelCombo.select(Arrays.asList(LOG_LEVELS).indexOf(level));
		levelCombo.pack();
	}

	@Override
	public boolean performOk() {
		try {
			savePreferences();
			refreshWidgets();
			return super.performOk();
		} catch (IOException | BackingStoreException e) {
			return false;
		}
	}

	@Override
	protected void performDefaults() {
		resetPreferences();
		refreshWidgets();
		super.performDefaults();
	}

}
