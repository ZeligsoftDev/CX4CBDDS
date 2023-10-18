/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.debug.vm.ui.launching.LaunchingUtils;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.ValidityUtils;
//import org.eclipse.ocl.xtext.essentialocl.ui.EssentialOCLEditor;
import org.eclipse.swt.widgets.Shell;

/**
 * DebugValidityAction activates ConstraintLOcator.debug() for an unambiguous validatable-node + constraining-node selection.
 */
public final class DebugValidityAction extends Action implements ISelectionChangedListener
{
	protected final @NonNull ValidityView validityView;
	protected final @NonNull ISelectionProvider selectionProvider;

	public DebugValidityAction(@NonNull ValidityView validityView, @NonNull ISelectionProvider selectionProvider) {
		super(ValidityUIMessages.ValidityView_Action_DebugValidity_Title);
		this.validityView = validityView;
		this.selectionProvider = selectionProvider;
		selectionProvider.addSelectionChangedListener(this);
		setToolTipText(ValidityUIMessages.ValidityView_Action_DebugValidity_ToolTipText);
		URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_DebugValidity_ImageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(image));
	}

	@Override
	public void run() {
		ISelection selection = selectionProvider.getSelection();
		if (selection instanceof StructuredSelection) {
			ResultConstrainingNode resultConstrainingNode = null;
			Object selectedObject = ((StructuredSelection) selection).getFirstElement();
			if (selectedObject instanceof ConstrainingNode) {
				resultConstrainingNode = ValidityUtils.getEnabledResultConstrainingNodes((ConstrainingNode)selectedObject).get(0);
			}
			else if (selectedObject instanceof ValidatableNode) {
				ResultValidatableNode resultValidatableNode = ValidityUtils.getEnabledResultValidatableNodes((ValidatableNode)selectedObject).get(0);
				resultConstrainingNode = resultValidatableNode.getResultConstrainingNode();
			}
			if (resultConstrainingNode != null) {
				final @Nullable Shell shell = validityView.getViewSite().getShell();
				ConstrainingNode eParent = resultConstrainingNode.getParent();
				if (eParent instanceof LeafConstrainingNode) {
					final ResultConstrainingNode finalResultConstrainingNode = resultConstrainingNode;
					org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator constraintLocator = ((LeafConstrainingNode)eParent).getConstraintLocator();
					if (constraintLocator instanceof org.eclipse.ocl.examples.emf.validation.validity.ui.locator.ConstraintUILocator) {
						final org.eclipse.ocl.examples.emf.validation.validity.ui.locator.ConstraintUILocator uiConstraintLocator = (org.eclipse.ocl.examples.emf.validation.validity.ui.locator.ConstraintUILocator)constraintLocator;
						LaunchingUtils.loadPerspectiveManager();
						Thread launchingThread = new Thread("DebugConstraintLauncher")
						{
							@Override
							public void run() {
								try {
									if (!uiConstraintLocator.debug(finalResultConstrainingNode, validityView, new NullProgressMonitor())) {
										openError(shell, "Debugging failed for '" + uiConstraintLocator.getName() + "'.");
									}
								} catch (final Exception e) {
									openError(shell, "Debugging failed for '" + uiConstraintLocator.getName() + "'." + e.toString());
								}
							}

							protected void openError(final @Nullable Shell shell, final String message) {
								if ((shell != null) && !shell.isDisposed()) {
									shell.getDisplay().asyncExec(new Runnable()
									{
										@Override
										public void run() {
											MessageDialog.openError(shell, "Constraint Debug Launcher", message);
										}
									});
								}
							}
						};
						launchingThread.start();
						return;
					}
					else {
						MessageDialog.openError(shell, "Constraint Debug Launcher",
							"Debugging not supported for '" + constraintLocator.getName() + "'." );
						return;
					}
				}
			}
			assert false; // Never happens
		}
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = selectionProvider.getSelection();
		if (selection instanceof StructuredSelection) {
			Object selectedObject = ((StructuredSelection) selection).getFirstElement();
			if (selectedObject instanceof ConstrainingNode) {
				setEnabled(ValidityUtils.getEnabledResultConstrainingNodes((ConstrainingNode)selectedObject).size() == 1);
			}
			else if (selectedObject instanceof ValidatableNode) {
				setEnabled(ValidityUtils.getEnabledResultValidatableNodes((ValidatableNode)selectedObject).size() == 1);
			}
			else {
				setEnabled(false);
			}
		}
	}
}