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

import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_BACKUP_COUNT_KEY;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_BACKUP_DEFAULT;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_FILENAME_KEY;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_FILE_DEFAULT;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_FILE_MAX_SIZE_KEY;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_FILE_SIZE_DEFAULT;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_LEVEL_DEFAULT;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.LOG_LEVEL_KEY;

import java.io.File;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
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

	private Text fileField;

	private Text maxSizeField;

	private Text maxBackupField;

	private final String[] LOG_LEVELS = new String[] {"OFF", "ERROR", "INFO", "DEBUG" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

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

		Label fileLabel = new Label(loggingComposite, SWT.LEAD);
		fileLabel.setText(EMFCompareRCPUIMessages.getString("LoggingPreferencePage.log.file")); //$NON-NLS-1$
		fileField = new Text(loggingComposite, SWT.BORDER | SWT.SINGLE);
		fileField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button fileButton = new Button(loggingComposite, SWT.PUSH);
		fileButton.setText(EMFCompareRCPUIMessages.getString("LoggingPreferencePage.filebutton.label")); //$NON-NLS-1$
		fileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
				File file = new File(fileField.getText());
				dlg.setFileName(file.getName());
				dlg.setFilterPath(file.getParent());
				String fileName = dlg.open();
				if (fileName != null) {
					fileField.setText(fileName);
				}
			}
		});

		Label maxSizeLabel = new Label(loggingComposite, SWT.LEAD);
		maxSizeLabel.setText(EMFCompareRCPUIMessages.getString("LoggingPreferencePage.log.file.size")); //$NON-NLS-1$
		maxSizeField = new Text(loggingComposite, SWT.BORDER | SWT.SINGLE);
		maxSizeField.setLayoutData(getDefaultFieldGridData(80));
		maxSizeField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				verifyIntegerFields();
			}
		});

		Label maxBackupLabel = new Label(loggingComposite, SWT.LEAD);
		maxBackupLabel.setText(EMFCompareRCPUIMessages.getString("LoggingPreferencePage.log.backup.count")); //$NON-NLS-1$
		maxBackupField = new Text(loggingComposite, SWT.BORDER | SWT.SINGLE);
		maxBackupField.setLayoutData(getDefaultFieldGridData(80));
		maxBackupField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				verifyIntegerFields();
			}
		});

		refreshWidgets();

		return loggingComposite;
	}

	protected GridData getDefaultFieldGridData(int width) {
		GridData gd = new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1);
		gd.widthHint = width;
		return gd;
	}

	protected void savePreferences() throws BackingStoreException, IOException {
		getPreferenceStore().setValue(LOG_FILENAME_KEY, fileField.getText());
		String item = levelCombo.getItem(levelCombo.getSelectionIndex());
		getPreferenceStore().setValue(LOG_LEVEL_KEY, item);
		getPreferenceStore().setValue(LOG_BACKUP_COUNT_KEY, maxBackupField.getText());
		getPreferenceStore().setValue(LOG_FILE_MAX_SIZE_KEY, maxSizeField.getText());
	}

	protected void resetPreferences() {
		getPreferenceStore().setToDefault(LOG_FILENAME_KEY);
		getPreferenceStore().setToDefault(LOG_LEVEL_KEY);
		getPreferenceStore().setToDefault(LOG_BACKUP_COUNT_KEY);
		getPreferenceStore().setToDefault(LOG_FILE_MAX_SIZE_KEY);
	}

	protected void refreshWidgets() {
		IPreferencesService prefsService = Platform.getPreferencesService();
		String fileName = prefsService.getString(EMFCompareRCPPlugin.PLUGIN_ID, LOG_FILENAME_KEY,
				LOG_FILE_DEFAULT, null);
		String level = prefsService.getString(EMFCompareRCPPlugin.PLUGIN_ID, LOG_LEVEL_KEY, LOG_LEVEL_DEFAULT,
				null);
		int maxBackupCount = prefsService.getInt(EMFCompareRCPPlugin.PLUGIN_ID, LOG_BACKUP_COUNT_KEY,
				LOG_BACKUP_DEFAULT, null);
		int maxSizeInMB = prefsService.getInt(EMFCompareRCPPlugin.PLUGIN_ID, LOG_FILE_MAX_SIZE_KEY,
				LOG_FILE_SIZE_DEFAULT, null);
		levelCombo.select(Arrays.asList(LOG_LEVELS).indexOf(level));
		levelCombo.pack();
		fileField.setText(fileName);
		maxBackupField.setText(Integer.toString(maxBackupCount));
		maxSizeField.setText(Integer.toString(maxSizeInMB));
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

	/**
	 * Verify if max size and max file fields are valid. It checks if the fields are integer and not empty.
	 */
	private void verifyIntegerFields() {
		try {
			Integer.parseInt(maxSizeField.getText());
			Integer.parseInt(maxBackupField.getText());
			setPreferencePageError(true, null);
		} catch (Exception e) {
			setPreferencePageError(false,
					EMFCompareRCPUIMessages.getString("LoggingPreferencePage.error.message")); //$NON-NLS-1$
		}
	}

	/**
	 * Set preference page error message and if this page is valid.
	 * 
	 * @param isValid
	 *            True if you can apply these preference
	 * @param errorMessage
	 *            Error message to display or null to remove the message
	 */
	private void setPreferencePageError(boolean isValid, String errorMessage) {
		setValid(isValid);
		setErrorMessage(errorMessage);
	}
}
