/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 417409
 *  Christian W. Damus (CEA) - bug 441227
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.properties.ui.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.modelelement.StereotypeApplicationModelElement;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;


public class StereotypeApplication extends AbstractPropertyEditor {

	private AppliedStereotypeCompositeWithView stereotypeComposite;

	private Composite self;

	public StereotypeApplication(Composite parent, int style) {
		self = new Composite(parent, style);
		self.setLayout(new PropertiesLayout(2, true));

		int heightHint = 200;

		stereotypeComposite = new AppliedStereotypeCompositeWithView(self);
		stereotypeComposite.createContent(self, AbstractEditor.factory);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.heightHint = heightHint;
		stereotypeComposite.setLayoutData(data);

		StereotypePropertyEditor propertyEditor = new StereotypePropertyEditor(self, style, stereotypeComposite);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.heightHint = heightHint;
		propertyEditor.setLayoutData(data);

		stereotypeComposite.setPropertySelectionChangeListener(propertyEditor);
	}

	@Override
	protected void doBinding() {
		// No Databinding here ; the AppliedStereotypeCompositeWithView is responsible
		// for editing the data
		ModelElement element = input.getModelElement(propertyPath);
		if (element instanceof StereotypeApplicationModelElement) {
			internalDoBinding();

			final IObservable property = input.getObservable(propertyPath);
			property.addChangeListener(new IChangeListener() {
				public void handleChange(ChangeEvent event) {
					if ((self == null) || self.isDisposed()) {
						// Desist
						property.removeChangeListener(this);
					} else {
						// re-do the injection into the stereotype composite because the
						// underlying model element selection may have been changed
						internalDoBinding();
					}
				}
			});
		}
	}

	protected void internalDoBinding() {
		ModelElement element = input.getModelElement(propertyPath);
		if (element instanceof StereotypeApplicationModelElement) {
			StereotypeApplicationModelElement modelElement = (StereotypeApplicationModelElement) element;

			View diagramElement = (View) modelElement.getGraphicalElement();
			// EditPart editPart = ((StereotypeApplicationModelElement)element).getEditPart();
			final Element umlElement = modelElement.getUMLElement();

			if (stereotypeComposite.getElement() != umlElement) {
				stereotypeComposite.setElement(umlElement);
				stereotypeComposite.setInput(new StereotypedElementTreeObject(umlElement));
			}
			stereotypeComposite.setDiagramElement(diagramElement);

			stereotypeComposite.refresh();
		}
	}
}
