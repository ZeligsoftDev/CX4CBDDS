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
 *  Christian W. Damus (CEA) - bug 444212
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collections;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSourceChangedEvent;
import org.eclipse.papyrus.infra.properties.ui.modelelement.IDataSourceListener;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppearanceForAppliedStereotypeComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;


public class StereotypeDisplay extends AbstractPropertyEditor {

	private AppearanceForAppliedStereotypeComposite composite;

	private IDataSourceListener dataSourceListener;

	public StereotypeDisplay(Composite parent, int style) {
		composite = new AppearanceForAppliedStereotypeComposite(parent);
		composite.createContent(parent, AbstractEditor.factory);
	}

	@Override
	protected void doBinding() {
		// No Databinding here ; the AppearanceForAppliedStereotypeComposite is responsible
		// for editing the data
		ModelElement element = input.getModelElement(propertyPath);
		if (element instanceof UMLNotationModelElement) {
			View diagramElement = (View) ((UMLNotationModelElement) element).getEModelElement();
			EditPart editPart = ((UMLNotationModelElement) element).getEditPart();
			Element umlElement = (Element) diagramElement.getElement();

			composite.setSelection(new StructuredSelection(Collections.singletonList(editPart)));
			composite.setElement(umlElement);
			composite.setInput(new StereotypedElementTreeObject(umlElement));
			composite.setDiagramElement(diagramElement);

			composite.refresh();
		}
	}

	@Override
	protected void unhookDataSourceListener(DataSource oldInput) {
		oldInput.removeDataSourceListener(getDataSourceListener());
		super.unhookDataSourceListener(oldInput);
	}

	@Override
	protected void hookDataSourceListener(DataSource newInput) {
		super.hookDataSourceListener(newInput);
		newInput.addDataSourceListener(getDataSourceListener());
	}

	private IDataSourceListener getDataSourceListener() {
		if (dataSourceListener == null) {
			dataSourceListener = new IDataSourceListener() {

				public void dataSourceChanged(DataSourceChangedEvent event) {
					// The data source's selection changed. Re-display our composite
					if ((composite != null) && !composite.isDisposed()) {
						composite.getDisplay().asyncExec(new Runnable() {

							public void run() {
								if (!composite.isDisposed()) {
									doBinding();
								}
							}
						});
					}
				}
			};
		}

		return dataSourceListener;
	}
}
