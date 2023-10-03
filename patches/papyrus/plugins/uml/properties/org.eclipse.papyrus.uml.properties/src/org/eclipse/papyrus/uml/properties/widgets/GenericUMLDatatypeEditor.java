/*****************************************************************************
 * Copyright (c) 2013, 2017, 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) - bug 521861
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 549705
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.providers.FeatureContentProvider;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.properties.ui.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.tools.providers.UMLContainerContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor to display an instance of DataType
 * TODO: It could actually be used as a generic EObject property editor
 *
 * @author Camille Letavernier
 *
 */
public class GenericUMLDatatypeEditor extends AbstractPropertyEditor {

	protected Composite self;

	public GenericUMLDatatypeEditor(Composite parent, int style) {
		super();
		self = new Composite(parent, SWT.NONE);
		self.setLayout(new PropertiesLayout(false));
	}

	@Override
	public void setProperty(String path) {
		this.propertyPath = path;
		// Do not check input, to avoid calling doBinding() twice
	}

	/**
	 * This widget is used to edit a full EObject. It does not need a property, nor a ModelElement.
	 *
	 * It retrieves all the EStructuralFeatures reflexively
	 */
	@Override
	protected void checkInput() {
		if (input != null) {
			try {
				doBinding();
			} catch (Exception ex) {
				// TODO : Handle the exception here. Display something ?
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * This widget is used to edit a full object. It does not need a property.
	 */
	@Override
	protected void doBinding() {
		DataSource input = getInput();
		IStructuredSelection selection = input.getSelection();
		if (selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();

		if (element instanceof EObject) {
			EObject dataTypeInstance = ((EObject) element);
			EClass dataTypeDefinition = dataTypeInstance.eClass();

			ILabelProvider labelProvider;
			try {
				if (null == dataTypeInstance.eResource() && null != dataTypeDefinition.eResource()) {
					// the datatype is not always in a resource (when it just comes to be created, nevertheless, its EClass is always in a resource loaded in the ResourceSet
					labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, dataTypeDefinition).getLabelProvider();
				} else {
					// I continue to use this branch for all other cases, to get exception and example to reproduce them
					labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, dataTypeInstance).getLabelProvider();
				}
			} catch (Exception ex) {
				Activator.log.error(ex);
				labelProvider = new UMLLabelProvider();
			}

			for (EStructuralFeature feature : dataTypeDefinition.getEAllStructuralFeatures()) {
				EStructuralFeatureEditor propertyEditor = new EStructuralFeatureEditor(self, SWT.NONE);


				if (null == dataTypeInstance.eResource() && null != dataTypeDefinition.eResource()) {
					propertyEditor.setProviders(new UMLContentProvider(dataTypeInstance, feature, null, dataTypeDefinition.eResource().getResourceSet()), labelProvider);
				} else {
					propertyEditor.setProviders(new UMLContentProvider(dataTypeInstance, feature), labelProvider);
				}


				if (feature instanceof EReference) {
					propertyEditor.setValueFactory(getUMLPropertyEditorFactory(dataTypeInstance, (EReference) feature));
				}

				propertyEditor.setFeatureToEdit(feature.getName(), feature, null, dataTypeInstance);
			}
		}
	}

	protected UMLPropertyEditorFactory getUMLPropertyEditorFactory(EObject dataTypeInstance, EReference reference) {
		UMLPropertyEditorFactory factory = new UMLPropertyEditorFactory(reference);
		EClass type = reference.getEReferenceType();

		factory.setContainerLabelProvider(new UMLFilteredLabelProvider());
		factory.setReferenceLabelProvider(new EMFLabelProvider());

		final Resource res = null != dataTypeInstance.eResource() ? dataTypeInstance.eResource() : null;
		ResourceSet resourceSet = null != res ? res.getResourceSet() : null;

		// the datatype is not always in a resource (when it just comes to be created, nevertheless, its EClass is always in a resource loaded in the ResourceSet
		if (null == resourceSet && null != dataTypeInstance.eClass().eResource()) {
			resourceSet = dataTypeInstance.eClass().eResource().getResourceSet();
		}

		final ITreeContentProvider contentProvider;
		if (null != dataTypeInstance.eResource()) {
			contentProvider = new UMLContainerContentProvider(dataTypeInstance, reference);
		} else {
			contentProvider = new UMLContainerContentProvider(dataTypeInstance, reference, resourceSet);
		}

		EMFGraphicalContentProvider provider = ProviderHelper.encapsulateProvider(contentProvider, resourceSet, HistoryUtil.getHistoryID(dataTypeInstance, reference, "container"));

		factory.setContainerContentProvider(provider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}
}
