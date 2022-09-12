package com.zeligsoft.domain.dds4ccm.tools.dialogs;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

public class MessageDialogWithSuppressButton extends TrayDialog {

	protected String title;
	protected String message;
	protected String suppressMessage;
	protected String preferenceConstant;
	protected IEclipsePreferences store;
	protected boolean suppressed = false;

	public MessageDialogWithSuppressButton(Shell shell, String title, String message, String suppressMessage,
			IEclipsePreferences store, String preferenceConstant) {
		super(shell);
		this.title = title;
		this.message = message;
		this.suppressMessage = suppressMessage;
		this.store = store;
		this.preferenceConstant = preferenceConstant;
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(title);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createMessageArea(composite);

		createButtonArea(composite);

		return composite;

	}

	private void createMessageArea(Composite parent) {
		Composite messageComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginTop = 20;
		layout.marginBottom = 20;
		layout.marginLeft = 10;
		layout.marginRight = 10;
		messageComposite.setLayout(layout);
		messageComposite.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_CENTER
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		Label label = new Label(messageComposite, SWT.NONE);
		label.setText(message);
		label.setBackground(messageComposite.getBackground());

	}

	private void createButtonArea(Composite composite) {
		Composite barComposite = new Composite(composite, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout = new GridLayout();
		compositeLayout.horizontalSpacing = 20;
		GridData compositeLData = new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		barComposite.setLayoutData(compositeLData);
		barComposite.setLayout(compositeLayout);

		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonData.widthHint = 70;

		Button button = new Button(barComposite, SWT.CHECK);
		button.setText(suppressMessage);
		button.setSelection(suppressed);
		button.setBackground(barComposite.getBackground());
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				suppressed = button.getSelection();
			}
		});

		Button okButton = createButton(barComposite, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setLayoutData(buttonData);
		okButton.setEnabled(true);
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				store.putBoolean(preferenceConstant, suppressed);
				try {
					store.flush();
				} catch (BackingStoreException e1) {
					// do nothing
				}
			}
		});
	}

	@Override
	public int open() {
		suppressed = store.getBoolean(preferenceConstant, false);
		if (!suppressed) {
			return super.open();
		}
		return Window.OK;
	}

}
