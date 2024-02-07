/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.export.IValidityExporter;
import org.eclipse.ocl.examples.emf.validation.validity.export.IValidityExporterDescriptor;
import org.eclipse.ocl.examples.emf.validation.validity.export.ValidityExporterRegistry;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.emf.validation.validity.ui.wizards.ExportValidationResultsFileWizard;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

public final class ExportValidationResultAction extends Action implements IMenuCreator
{
	private final @NonNull IDEValidityManager validityManager;
	private final @NonNull ValidityView validityView;

	/** Menu manager for this action. */
	private MenuManager menuManager = new MenuManager();

	public ExportValidationResultAction(@NonNull IDEValidityManager validityManager, @NonNull ValidityView validityView) {
		super(ValidityUIMessages.ValidityView_Action_ExportResult_Title);
		this.validityManager = validityManager;
		this.validityView = validityView;
		URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_ExportResult_ImageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(image));
		setToolTipText(ValidityUIMessages.ValidityView_Action_ExportResult_ToolTipText);
		if (!ValidityExporterRegistry.INSTANCE.getRegisteredExtensions().isEmpty()) {
			setMenuCreator(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.IMenuCreator#dispose()
	 */
	@Override
	public void dispose() {
		if (menuManager.getMenu() != null) {
			menuManager.getMenu().dispose();
		}
		menuManager.dispose();

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Control)
	 */
	@Override
	public Menu getMenu(Control parent) {
		// Creates the menu if needed, or removes all elements
		if (menuManager.getMenu() == null) {
			menuManager.createContextMenu(parent);
		} else {
			menuManager.removeAll();
		}

		// look for additional actions to add to the contextual menu.
		for (IValidityExporterDescriptor descriptor : ValidityExporterRegistry.INSTANCE.getRegisteredExtensions()) {
			if (descriptor != null) {
				final Action exportAction = new SpecificExportResultsAction(descriptor);
				menuManager.add(new ActionContributionItem(exportAction));
			}
		}

		return menuManager.getMenu();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Menu)
	 */
	@Override
	public Menu getMenu(Menu parent) {
		if (menuManager.getMenu() != null) {
			return menuManager.getMenu();
		}
		return null;
	}

	private final class SpecificExportResultsAction extends Action
	{
		private final @NonNull IValidityExporterDescriptor exportDescriptor;

		public SpecificExportResultsAction(@NonNull IValidityExporterDescriptor exportDescriptor) {
			super(ValidityUIMessages.ValidityView_Action_ExportResult_Title, IAction.AS_CHECK_BOX);
			this.exportDescriptor = exportDescriptor;
			setText(exportDescriptor.getExporterType());
			setToolTipText(ValidityUIMessages.ValidityView_Action_ExportResult_ToolTipText);
		}

		@Override
		public void run() {
			IResource selection = validityView.getSelectedResource();
			try {
				openExportWizard(selection);
			} catch (CoreException e) {
				ValidityUIPlugin.getPlugin().getLog().log(e.getStatus());
			}
		}

		/**
		 * Opens the export wizard for the receiver.
		 *
		 * @param currentResource
		 *            The current IResource selection in some part
		 * @throws CoreException
		 */
		private void openExportWizard(@Nullable final IResource currentResource)
				throws CoreException {
			final IWorkbenchWindow window = validityView.getSite().getWorkbenchWindow();
			Shell shell = window.getShell();
			if ((shell != null) && !shell.isDisposed() && (window.getWorkbench() != null)) {
				final Display display = shell.getDisplay();
				final IWorkbench workbench = window.getWorkbench();
				final RootNode rootNode = validityManager.getRootNode();
				if (display != null && workbench != null && rootNode != null) {
					display.syncExec(new Runnable() {
						@Override
						public void run() {
							IValidityExporter exporter = exportDescriptor.getExporter();
							Shell shell = window.getShell();
							if ((shell == null) || shell.isDisposed()) {
								return;
							}
							StructuredSelection structuredSelection;
							if (currentResource == null) {
								structuredSelection = StructuredSelection.EMPTY;
							}
							else if ((currentResource instanceof IProject) && !((IProject)currentResource).isOpen()) {
								structuredSelection = StructuredSelection.EMPTY;
							}
							else {
								structuredSelection = new StructuredSelection(currentResource);
							}
							ExportValidationResultsFileWizard wizard = new ExportValidationResultsFileWizard(workbench, structuredSelection, rootNode, exporter);
							WizardDialog dialog = new WizardDialog(shell, wizard);
							if (dialog.open() != Window.OK) {
								return;
							}
						}
					});
				} else {
					throw new CoreException(new Status(IStatus.ERROR, ValidityUIPlugin.PLUGIN_ID, ValidityUIMessages.ValidityView_Action_ExportError_NoResults));
				}
			}
		}
	}
}