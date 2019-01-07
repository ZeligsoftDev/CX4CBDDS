package apps.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.telelogic.rhapsody.core.IRPPackage;

/**
 * Wizard dialog
 * 
 * @author ysroh
 * 
 */
public abstract class WizardDialog {

	protected Shell sShell;
	protected Button buttonOK;
	protected Button buttonCancel;

	protected IRPPackage container;
	protected String title;

	protected boolean isCanceled = false;

	public WizardDialog(String title) {
		this.title = title;
	}

	protected abstract Composite createPageContent(Composite parent);

	public void open() {
		createSShell();
		if (sShell != null) {
			sShell.open();
			sShell.pack();
			while (!sShell.isDisposed()) {
				if (!sShell.getDisplay().readAndDispatch()) {
					sShell.getDisplay().sleep();
				}
			}
		}
	}

	protected abstract void okPressed();

	protected void createSShell() {
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM);
		GridLayout shellLayout = new GridLayout(2, false);
		sShell.setLayout(shellLayout);
		sShell.setText(title);

		Composite composite = createPageContent(sShell);
		GridData planData = new GridData();
		planData.grabExcessHorizontalSpace = true;
		planData.grabExcessVerticalSpace = true;
		planData.horizontalAlignment = SWT.FILL;
		planData.verticalAlignment = SWT.FILL;
		planData.horizontalSpan = 2;
		composite.setLayoutData(planData);

		buttonOK = new Button(sShell, SWT.PUSH);
		GridData okData = new GridData();
		okData.horizontalAlignment = SWT.RIGHT;
		okData.grabExcessHorizontalSpace = true;
		buttonOK.setLayoutData(okData);
		buttonOK.setText("OK");
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				okPressed();
				close();
			}
		});

		buttonCancel = new Button(sShell, SWT.PUSH);
		GridData cancelData = new GridData();
		cancelData.horizontalAlignment = SWT.RIGHT;
		buttonCancel.setLayoutData(cancelData);
		buttonCancel.setText("Cancel");
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				cancel();
			}
		});

		sShell.setDefaultButton(buttonOK);
		buttonOK.setFocus();

		sShell.setActive();
	}

	protected void close() {
		if (!sShell.isDisposed()) {
			sShell.dispose();
		}
	}

	protected void cancel() {
		isCanceled = true;
		close();
	}

	protected Button getButtonOK() {
		return buttonOK;
	}
}
