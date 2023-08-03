/***************************************************
 * Copyright (c) 2010 Atos Origin.

 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 *
 ****************************************************/
package org.eclipse.papyrus.views.modelexplorer.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.toolbox.dialog.InformationDialog;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.preferences.INavigatorPreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

/**
 * GenericTransformAction is an action which transforms and EObject by changing
 * its eclass.
 */
public class GenericTransformAction extends Action {

	/** title of error dialog */
	private static final String ERROR_TITLE = "Impossible to continue transformation.";

	/** message in error dialog */
	private static final String ERROR_MESSAGE = "The transformation can not continue.\n"
			+ "Some objects referencing your selection could not be able to reference the result of the transformation.\n"
			+ "For UML and SysML, applied stereotypes could not be applicable on the result of the transformation.\n"
			+ "Before performing the transformation please delete or unapply the elements listed bellow.";

	/** title of error dialog */
	private static final String WARNING_TITLE = "Warning: transformation command";

	/** WARNING_MESSAGE for transform command execution */
	private static final String WARNING_MESSAGE = "You are trying to transform an element typed %s into %s.\nThis operation will copy all the common elements between the two eclasses.\nDo you want to continue ?";

	/** The EClass to transform into. */
	private EClass targetEClass = null;

	/** The element to transform. */
	private EObject element;

	/**
	 * Constructor for a new action.
	 *
	 * @param transformationEClass
	 *            the eclass element must be transformed into
	 * @param adapterFactory
	 *            the adapter factory for providing label image
	 * @param elementToTransform
	 *            the element to transform
	 */
	public GenericTransformAction(EClass transformationEClass,
			AdapterFactory adapterFactory, EObject elementToTransform) {
		super(transformationEClass.getName());
		targetEClass = transformationEClass;
		element = elementToTransform;

		if (adapterFactory != null) {
			EObject tmpEobject = transformationEClass.getEPackage()
					.getEFactoryInstance().create(transformationEClass);
			IItemLabelProvider provider = (IItemLabelProvider) adapterFactory
					.adapt(tmpEobject, IItemLabelProvider.class);
			setImageDescriptor(ExtendedImageRegistry.INSTANCE
					.getImageDescriptor(provider.getImage(tmpEobject)));
		}
	}

	/**
	 * Transform the element and update referencing diagrams.
	 *
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		GenericTransformer transformer = new GenericTransformer(element);
		MultiStatus messages = transformer
				.isTransformationPossible(targetEClass);
		if (messages != null && messages.getChildren().length == 0) {
			String message = String.format(WARNING_MESSAGE, this.element
					.eClass().getName(), targetEClass.getName());
			InformationDialog dialog = new InformationDialog(
					Display.getDefault().getActiveShell(),
					WARNING_TITLE,
					message,
					Activator.getDefault().getPreferenceStore(),
					INavigatorPreferenceConstants.PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP,
					SWT.YES | SWT.NO, MessageDialog.INFORMATION, new String[] {
							IDialogConstants.YES_LABEL,
							IDialogConstants.NO_LABEL });
			int result = dialog.open();
			if (result == SWT.YES || result == Window.OK) {
				transformer.transform(targetEClass);
			}
		} else {
			ErrorDialog errorDialog = new ErrorDialog(Display.getDefault()
					.getActiveShell(), ERROR_TITLE, ERROR_MESSAGE, messages,
					IStatus.WARNING);
			errorDialog.open();
		}
	}

}
