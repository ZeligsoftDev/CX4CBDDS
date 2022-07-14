/*****************************************************************************
 * Copyright (c) 2012, 2014, 2019 Atos, CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 448139
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 549705
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.properties.ui.providers.FeatureContentProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.papyrus.uml.tools.providers.UMLContainerContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypePropertyEditor implements ISelectionChangedListener, IChangeListener {

	protected StereotypeEStructuralFeatureEditor eStructuralFeatureEditor;

	protected AppliedStereotypeCompositeWithView stereotypeComposite;

	protected int style = 0;

	public StereotypePropertyEditor(Composite parent, int style, AppliedStereotypeCompositeWithView stereotypeComposite) {
		this.stereotypeComposite = stereotypeComposite;
		eStructuralFeatureEditor = new StereotypeEStructuralFeatureEditor(parent, style);
		eStructuralFeatureEditor.setChangeListener(this);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if (event != null) {
			IStructuredSelection structSelection = (IStructuredSelection) event.getSelection();
			Object selection = structSelection.getFirstElement();

			if (selection instanceof AppliedStereotypePropertyTreeObject) {
				AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) selection;

				EObject stereotypeApplication = pTO.getStereotypeApplication();
				Element owner = pTO.getElement();
				EStructuralFeature feature = pTO.getFeature();
				Stereotype stereotype = pTO.getStereotype();

				ILabelProvider labelProvider;
				try {
					labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, stereotypeApplication).getLabelProvider();
				} catch (Exception ex) {
					labelProvider = new UMLLabelProvider();
				}

				eStructuralFeatureEditor.setStereotype(stereotype);
				eStructuralFeatureEditor.setProviders(new UMLContentProvider(stereotypeApplication, feature, stereotype), labelProvider);
				if (feature instanceof EReference) {
					eStructuralFeatureEditor.setValueFactory(getUMLPropertyEditorFactory(stereotypeApplication, (EReference) feature));
				}

				eStructuralFeatureEditor.setFeatureToEdit(pTO.getProperty().getName(), feature, owner, stereotypeApplication);
			} else {
				eStructuralFeatureEditor.setFeatureToEdit(null, null, null, null);
			}
		}
	}

	protected UMLPropertyEditorFactory getUMLPropertyEditorFactory(EObject stereotypeApplication, EReference reference) {
		UMLPropertyEditorFactory factory = new UMLPropertyEditorFactory(reference);
		EClass type = reference.getEReferenceType();

		factory.setContainerLabelProvider(new UMLFilteredLabelProvider());
		factory.setReferenceLabelProvider(new EMFLabelProvider());

		ITreeContentProvider contentProvider = new UMLContainerContentProvider(stereotypeApplication, reference);

		EMFGraphicalContentProvider provider = ProviderHelper.encapsulateProvider(contentProvider, stereotypeApplication.eResource().getResourceSet(), HistoryUtil.getHistoryID(stereotypeApplication, reference, "container"));

		factory.setContainerContentProvider(provider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}

	public void setLayoutData(GridData data) {
		eStructuralFeatureEditor.setLayoutData(data);
	}

	@Override
	public void handleChange(ChangeEvent event) {
		if (!stereotypeComposite.isDisposed()) {
			stereotypeComposite.refreshTreeViewer();
		}
	}
}
