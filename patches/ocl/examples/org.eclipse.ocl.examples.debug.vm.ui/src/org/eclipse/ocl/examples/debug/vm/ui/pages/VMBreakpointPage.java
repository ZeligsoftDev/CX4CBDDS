/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.pages;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.examples.debug.vm.ui.messages.DebugVMUIMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.model.IWorkbenchAdapter;

public abstract class VMBreakpointPage extends PropertyPage {
	protected Button fEnabledButton;
	protected Button fHitCountButton;
	protected Text fHitCountText;
	protected Combo fSuspendPolicy;
	protected List<String> fErrorMessages= new ArrayList<String>();

	/**
	 * Attribute used to indicate that a breakpoint should be deleted
	 * when cancel is pressed.
	 */
	public static final String ATTR_DELETE_ON_CANCEL = DebugVMUIPlugin.PLUGIN_ID + ".ATTR_DELETE_ON_CANCEL";  //$NON-NLS-1$

	/**
	 * Constant for the empty string
	 */
	protected static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/**
	 * the hit count fError message
	 */
	private static final String fgHitCountErrorMessage = DebugVMUIMessages.BreakpointPage_HitCountErrorMessage;

	/**
	 * Store the breakpoint properties.
	 * @see org.eclipse.jface.preference.IPreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		IWorkspaceRunnable wr = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				VMLineBreakpoint breakpoint = getBreakpoint();
				boolean delOnCancel = breakpoint.getMarker().getAttribute(ATTR_DELETE_ON_CANCEL) != null;
				if (delOnCancel) {
					// if this breakpoint is being created, remove the "delete on cancel" attribute
					// and register with the breakpoint manager
					breakpoint.getMarker().setAttribute(ATTR_DELETE_ON_CANCEL, (String)null);
					breakpoint.setRegistered(true);
				}
				doStore();
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(wr, null, 0, null);
		}
		catch (CoreException e) {
			DebugVMUIPlugin.statusDialog(e.getStatus());
			DebugVMUIPlugin.log(e);
		}
		return super.performOk();
	}

	/**
	 * Adds the given fError message to the errors currently displayed on this page.
	 * The page displays the most recently added fError message.
	 * Clients should retain messages that are passed into this method as the
	 * message should later be passed into removeErrorMessage(String) to clear the fError.
	 * This method should be used instead of setErrorMessage(String).
	 * @param message the fError message to display on this page.
	 */
	protected void addErrorMessage(String message) {
		fErrorMessages.remove(message);
		fErrorMessages.add(message);
		setErrorMessage(message);
		setValid(message == null);
	}

	/**
	 * Removes the given fError message from the errors currently displayed on this page.
	 * When an fError message is removed, the page displays the fError that was added
	 * before the given message. This is akin to popping the message from a stack.
	 * Clients should call this method instead of setErrorMessage(null).
	 * @param message the fError message to clear
	 */
	protected void removeErrorMessage(String message) {
		fErrorMessages.remove(message);
		if (fErrorMessages.isEmpty()) {
			addErrorMessage(null);
		} else {
			addErrorMessage(fErrorMessages.get(fErrorMessages.size() - 1));
		}
	}

	/**
	 * Stores the values configured in this page. This method
	 * should be called from within a workspace runnable to
	 * reduce the number of resource deltas.
	 */
	protected void doStore() throws CoreException {
		VMLineBreakpoint breakpoint = getBreakpoint();
		storeHitCount(breakpoint);
		storeEnabled(breakpoint);
	}

	/**
	 * Stores the value of the enabled state in the breakpoint.
	 * @param breakpoint the breakpoint to update
	 * @throws CoreException if an exception occurs while setting
	 *  the enabled state
	 */
	private void storeEnabled(VMLineBreakpoint breakpoint) throws CoreException {
		breakpoint.setEnabled(fEnabledButton.getSelection());
	}

	/**
	 * Stores the value of the hit count in the breakpoint.
	 * @param breakpoint the breakpoint to update
	 * @throws CoreException if an exception occurs while setting
	 *  the hit count
	 */
	private void storeHitCount(VMLineBreakpoint breakpoint) throws CoreException {
		int hitCount = -1;
		if (fHitCountButton.getSelection()) {
			try {
				hitCount = Integer.parseInt(fHitCountText.getText());
			}
			catch (NumberFormatException e) {
				DebugVMUIPlugin.log(new Status(IStatus.ERROR, DebugVMUIPlugin.PLUGIN_ID, IStatus.ERROR, MessageFormat.format("JavaBreakpointPage allowed input of invalid string for hit count value: {0}.", new Object[] { fHitCountText.getText() }), e));  //$NON-NLS-1$
			}
		}
		breakpoint.setHitCount(hitCount);
	}

	/**
	 * Creates the labels and editors displayed for the breakpoint.
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		setTitle(DebugVMUIMessages.BreakpointPage_ModulePrepareBreakpoint);
		noDefaultAndApplyButton();
		Composite mainComposite = createComposite(parent, 1);
		try {
			createLabels(mainComposite);
			createEnabledButton(mainComposite);
			createHitCountEditor(mainComposite);
			createTypeSpecificEditors(mainComposite);
		} catch (CoreException e) {
			DebugVMUIPlugin.log(e);
		}
		setValid(true);
		// if this breakpoint is being created, change the shell title to indicate 'creation'
		try {
			if (getBreakpoint().getMarker().getAttribute(ATTR_DELETE_ON_CANCEL) != null) {
				getShell().addShellListener(new ShellListener() {
					@Override
					public void shellActivated(ShellEvent e) {
						Shell shell = (Shell)e.getSource();
						shell.setText(MessageFormat.format(DebugVMUIMessages.BreakpointPage_CreateBreakpointForModule, new Object[]{getName(getBreakpoint())}));
						shell.removeShellListener(this);
					}
					@Override
					public void shellClosed(ShellEvent e) {
					}
					@Override
					public void shellDeactivated(ShellEvent e) {
					}
					@Override
					public void shellDeiconified(ShellEvent e) {
					}
					@Override
					public void shellIconified(ShellEvent e) {
					}
				});
			}
		} catch (CoreException e) {
			DebugVMUIPlugin.log(e);
		}
		return mainComposite;
	}

	/**
	 * Returns the name of the given element.
	 *
	 * @param element the element
	 * @return the name of the element
	 */
	private String getName(IAdaptable element) {
		IWorkbenchAdapter adapter = ClassUtil.getAdapter(element, IWorkbenchAdapter.class);
		if (adapter != null) {
			return adapter.getLabel(element);
		}
		return EMPTY_STRING;
	}

	/**
	 * Creates the labels displayed for the breakpoint.
	 * @param parent
	 * @throws DebugException
	 */
	protected void createLabels(Composite parent) throws CoreException {
		Composite labelComposite = createComposite(parent, 2);
		// TODO
		String typeName = getBreakpoint().getUnitURI().toPlatformString(true);
		if (typeName != null) {
			createLabel(labelComposite, DebugVMUIMessages.BreakpointPage_Module);
			Text text = SWTFactory.createText(labelComposite, SWT.READ_ONLY, 1, typeName);
			text.setBackground(parent.getBackground());
		}
		createTypeSpecificLabels(labelComposite);
	}

	/**
	 * @param parent the composite in which the hit count editor
	 *      will be created
	 */
	private void createHitCountEditor(Composite parent) throws CoreException {
		Composite hitCountComposite = createComposite(parent, 2);
		fHitCountButton= createCheckButton(hitCountComposite, DebugVMUIMessages.BreakpointPage_HitCount);
		fHitCountButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				fHitCountText.setEnabled(fHitCountButton.getSelection());
				hitCountChanged();
			}
		});
		int hitCount = getBreakpoint().getHitCount();
		String hitCountString= EMPTY_STRING;
		if (hitCount > 0) {
			hitCountString = Integer.valueOf(hitCount).toString();
			fHitCountButton.setSelection(true);
		} else {
			fHitCountButton.setSelection(false);
		}
		fHitCountText= createText(hitCountComposite, hitCountString);
		if (hitCount <= 0) {
			fHitCountText.setEnabled(false);
		}
		fHitCountText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				hitCountChanged();
			}
		});
	}

	/**
	 * Validates the current state of the hit count editor.
	 * Hit count value must be a positive integer.
	 */
	private void hitCountChanged() {
		if (!fHitCountButton.getSelection()) {
			removeErrorMessage(fgHitCountErrorMessage);
			return;
		}
		String hitCountText= fHitCountText.getText();
		int hitCount= -1;
		try {
			hitCount = Integer.parseInt(hitCountText);
		}
		catch (NumberFormatException e1) {
			addErrorMessage(fgHitCountErrorMessage);
			return;
		}
		if (hitCount < 1) {
			addErrorMessage(fgHitCountErrorMessage);
		} else {
			removeErrorMessage(fgHitCountErrorMessage);
		}
	}

	/**
	 * Creates the button to toggle enablement of the breakpoint
	 * @param parent
	 * @throws CoreException
	 */
	protected void createEnabledButton(Composite parent) throws CoreException {
		fEnabledButton = createCheckButton(parent, DebugVMUIMessages.BreakpointPage_Enabled);
		fEnabledButton.setSelection(getBreakpoint().isEnabled());
	}

	/**
	 * Returns the breakpoint that this preference page configures
	 * @return the breakpoint this page configures
	 */
	protected VMLineBreakpoint getBreakpoint() {
		return (VMLineBreakpoint) getElement();
	}

	/**
	 * Allows subclasses to add type specific labels to the common Java
	 * breakpoint page.
	 * @param parent
	 */
	protected void createTypeSpecificLabels(Composite parent) {}

	/**
	 * Allows subclasses to add type specific editors to the common Java
	 * breakpoint page.
	 * @param parent
	 */
	protected void createTypeSpecificEditors(Composite parent) throws CoreException {}

	/**
	 * Creates a fully configured text editor with the given initial value
	 * @param parent
	 * @param initialValue
	 * @return the configured text editor
	 */
	protected Text createText(Composite parent, String initialValue) {
		return SWTFactory.createText(parent, SWT.SINGLE | SWT.BORDER, 1, initialValue);
	}

	/**
	 * Creates a fully configured composite with the given number of columns
	 * @param parent
	 * @param numColumns
	 * @return the configured composite
	 */
	protected Composite createComposite(Composite parent, int numColumns) {
		return SWTFactory.createComposite(parent, parent.getFont(), numColumns, 1, GridData.FILL_HORIZONTAL, 0, 0);
	}

	/**
	 * Creates a fully configured check button with the given text.
	 * @param parent the parent composite
	 * @param text the label of the returned check button
	 * @return a fully configured check button
	 */
	protected Button createCheckButton(Composite parent, String text) {
		return SWTFactory.createCheckButton(parent, text, null, false, 1);
	}

	/**
	 * Creates a fully configured label with the given text.
	 * @param parent the parent composite
	 * @param text the test of the returned label
	 * @return a fully configured label
	 */
	protected Label createLabel(Composite parent, String text) {
		return SWTFactory.createLabel(parent, text, 1);
	}

	/**
	 * Creates a fully configured radio button with the given text.
	 * @param parent the parent composite
	 * @param text the label of the returned radio button
	 * @return a fully configured radio button
	 */
	protected Button createRadioButton(Composite parent, String text) {
		return SWTFactory.createRadioButton(parent, text, 1);
	}

	/**
	 * Check to see if the breakpoint should be deleted.
	 */
	@Override
	public boolean performCancel() {
		try {
			if (getBreakpoint().getMarker().getAttribute(ATTR_DELETE_ON_CANCEL) != null) {
				// if this breakpoint is being created, delete on cancel
				getBreakpoint().delete();
			}
		} catch (CoreException e) {
			DebugVMUIPlugin.statusDialog(DebugVMUIMessages.BreakpointPage_CancelBreakpointCreationError, e.getStatus());
		}
		return super.performCancel();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
	}
}