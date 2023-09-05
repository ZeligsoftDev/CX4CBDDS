/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.io.File;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElement;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;

/**
 * A widget to edit a stereotype image. The image is serialized in order to be
 * embedded in the UML xmi model.
 *
 * An expression can be attached to each image, which will be interpreted at runtime
 * to determine which image should be displayed.
 *
 * Based on the org.eclipse.papyrus.infra.properties.ui.tabbed.profile.imagesection package
 * in the org.eclipse.papyrus.infra.properties.ui.tabbed.profile plug-in
 *
 * @author Camille Letavernier
 *
 */
public class StereotypeImageEditor extends AbstractPropertyEditor implements SelectionListener {

	private Button browseButton, removeButton;

	private Composite composite;

	private String addImagePath = "/icons/Add_32x32.gif"; //$NON-NLS-1$

	/**
	 * Papyrus custom format for Image serialization
	 */
	public final String PAPYRUS_FORMAT = "Papyrus"; //$NON-NLS-1$

	public StereotypeImageEditor(Composite parent, int style) {

		TabbedPropertySheetWidgetFactory factory = AbstractEditor.factory;

		composite = factory.createFlatFormComposite(parent);
		FormData data;

		browseButton = factory.createButton(composite, "", SWT.PUSH); //$NON-NLS-1$
		browseButton.setImage(Activator.getDefault().getImage(addImagePath));
		removeButton = factory.createButton(composite, "", SWT.PUSH); //$NON-NLS-1$
		removeButton.setImage(Activator.getDefault().getImage("/icons/delete.gif")); //$NON-NLS-1$
		CLabel iconLabel = factory.createCLabel(composite, "Content: ");

		// browseButton layout
		data = new FormData();
		data.left = new FormAttachment(0, 85);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		browseButton.setLayoutData(data);

		// removeButton layout
		data = new FormData();
		data.left = new FormAttachment(browseButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(browseButton, 0, SWT.CENTER);
		removeButton.setLayoutData(data);

		// iconLabel layout
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(browseButton, 0, SWT.CENTER);
		iconLabel.setLayoutData(data);

		browseButton.addSelectionListener(this);

		removeButton.addSelectionListener(this);
	}

	protected Element getElement() {
		ModelElement element = input.getModelElement(propertyPath);
		if (element instanceof UMLModelElement) {
			return (Element) ((UMLModelElement) element).getSource();
		}

		return null;
	}

	@Override
	protected void doBinding() {
		super.doBinding();
		refresh();
	}

	protected void browseAction() {
		FileDialog fd = new FileDialog(composite.getShell());
		String extensions[] = { "*.jpg;*.bmp;*.ico;*.gif;*.png;*.wmf;*.emf" }; //$NON-NLS-1$
		fd.setFilterExtensions(extensions);
		String iconSelected = fd.open();

		// No image selected
		if (iconSelected == null) {
			return;
		}

		if (getElement() instanceof Image) {

			final File imgFile = new File(iconSelected);
			Image image = (Image) getElement();

			TransactionalEditingDomain domain;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(image);

				AbstractTransactionalCommand operation = new AbstractTransactionalCommand(domain, "Set Image content", null) {

					/**
					 * {@inheritDoc}
					 */
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						try {
							ImageUtil.setContent((Image) getElement(), imgFile);
							((Image) getElement()).setFormat(PAPYRUS_FORMAT);
						} catch (Exception ex) {
							return CommandResult.newErrorCommandResult(ex);
						}
						return CommandResult.newOKCommandResult();
					}
				};
				domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(operation));
			} catch (ServiceException ex) {
				Activator.log.error(ex);

				// FIXME: Workaround for Bug 402525. The icon is not yet attached to the editing domain. Modify it directly.
				ImageUtil.setContent((Image) getElement(), imgFile);
				((Image) getElement()).setFormat(PAPYRUS_FORMAT);
				// ////

				// return;
			}

			refresh();
		}
	}

	protected void removeAction() {
		// Erase image content
		if (getElement() instanceof Image) {
			Image image = (Image) getElement();
			TransactionalEditingDomain domain;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(image);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return;
			}
			AbstractTransactionalCommand operation = new AbstractTransactionalCommand(domain, "Remove Image content", null) {

				/**
				 * {@inheritDoc}
				 */
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					try {
						ImageUtil.setContent((Image) getElement(), null);
					} catch (Exception ex) {
						return CommandResult.newErrorCommandResult(ex);
					}
					return CommandResult.newOKCommandResult();
				}
			};

			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(operation));

			refresh();
		}
	}

	public void widgetSelected(SelectionEvent e) {
		if (e.widget == browseButton) {
			browseAction();
		} else if (e.widget == removeButton) {
			removeAction();
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing
	}

	public void refresh() {
		if (!browseButton.isDisposed()) {

			/* initialization of buttons enabling */
			if (!(getElement() instanceof Image)) {
				return;
			}

			// Get Image content
			org.eclipse.swt.graphics.Image image = null;

			try {
				image = ImageUtil.getContent((Image) getElement());
			} catch (Exception e) {
				Activator.log.error(e);
			}

			// Refresh text
			if (image != null) {
				// Resize icon to 32x32
				org.eclipse.swt.graphics.Image resizedIcon = new org.eclipse.swt.graphics.Image(image.getDevice(), image.getImageData().scaledTo(32, 32));
				browseButton.setImage(resizedIcon);
				removeButton.setEnabled(true);

			} else {
				browseButton.setImage(Activator.getDefault().getImage(addImagePath));
				removeButton.setEnabled(false);
			}
		}
	}
}
