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
 *  Pierre GAUTIER (CEA LIST) - bug 521865
 *  Vincent LORENZO (CEA LIST) - bug 521861
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 549705
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.properties.ui.providers.FeatureContentProvider;
import org.eclipse.papyrus.infra.properties.ui.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.papyrus.uml.tools.providers.UMLContainerContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * A Property Editor to display an instance of DataType
 * TODO: It could actually be used as a generic EObject property editor
 *
 * @author Camille Letavernier
 *
 */
public class EObjectContentsEditor extends Composite {

	protected Composite contents;

	protected Composite buttonsBar;

	protected EReference reference;

	protected IObservableValue modelElementObservable;

	protected Button addButton;

	protected Button deleteButton;

	protected IChangeListener valueListener;

	protected Composite self;

	/**
	 * the right scrollbar
	 */
	private final ScrolledComposite scrolled;

	/**
	 * listener to be be able to move the scrollbar with the mouse wheel
	 *
	 */
	private final MouseWheelListener mouseWheelListener = new MouseWheelListener() {

		@Override
		public void mouseScrolled(final MouseEvent e) {
			final Point or = EObjectContentsEditor.this.scrolled.getOrigin();
			or.y += -e.count * EObjectContentsEditor.this.scrolled.getVerticalBar().getIncrement();
			EObjectContentsEditor.this.scrolled.setOrigin(or);
		}
	};

	public EObjectContentsEditor(Composite parent, int style, EReference reference) {
		super(parent, style);

		setLayout(new FillLayout());

		self = new Group(this, SWT.NONE);

		final StringBuilder builder = new StringBuilder();
		if (null != reference) {
			builder.append(reference.getName());
			builder.append(":"); //$NON-NLS-1$
			if (null != reference.getEType()) {
				builder.append(reference.getEType().getName());
			}
		}
		((Group) self).setText(builder.toString());
		self.setLayout(new PropertiesLayout());

		buttonsBar = new Composite(self, SWT.NONE);
		buttonsBar.setLayout(new FillLayout());
		buttonsBar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		createAddButton();
		createDeleteButton();

		updateButtonsBar();

		scrolled = new ScrolledComposite(self, SWT.V_SCROLL);
		scrolled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scrolled.setLayout(new PropertiesLayout());
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		scrolled.setMinSize(250, 100);

		contents = new Composite(scrolled, SWT.NONE);
		contents.setLayout(new PropertiesLayout());
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setBackgroundMode(SWT.INHERIT_DEFAULT);
		contents.setBackground(self.getBackground());

		scrolled.setContent(contents);

		this.reference = reference;

		valueListener = new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				updateContents();
			}
		};

		parent.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
	}

	public void setValue(IObservableValue observable) {
		if (this.modelElementObservable != null) {
			this.modelElementObservable.removeChangeListener(valueListener);
		}

		this.modelElementObservable = observable;
		this.modelElementObservable.addChangeListener(valueListener);

		updateContents();
	}

	@Override
	public void dispose() {
		if (this.modelElementObservable != null) {
			this.modelElementObservable.removeChangeListener(valueListener);
		}
	}

	protected void updateContents() {
		EObject dataTypeInstance = (EObject) modelElementObservable.getValue();
		unregisteredMouseWheelListener(scrolled);
		for (Control child : contents.getChildren()) {
			child.dispose();
		}

		if (dataTypeInstance == null) {
			// Label label = new Label(contents, SWT.NONE);
			// label.setText("<<Unset>>");
		} else {
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
				EStructuralFeatureEditor propertyEditor = new EStructuralFeatureEditor(contents, SWT.NONE);

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

		scrolled.setMinSize(contents.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		registerMouseWheelListener(scrolled);
		updateButtonsBar();

		layout();
	}

	/**
	 * Register the mouse wheel listener for the control and its children
	 *
	 * @param control
	 *            a control
	 */
	private void registerMouseWheelListener(final Control control) {
		control.addMouseWheelListener(this.mouseWheelListener);
		if (control instanceof Composite) {
			for (Control ctrl : ((Composite) control).getChildren()) {
				registerMouseWheelListener(ctrl);
			}
		}
	}

	/**
	 * Unregister the mouse wheel listener for the control and its children
	 *
	 * @param control
	 *            a control
	 */
	private void unregisteredMouseWheelListener(final Control control) {
		control.removeMouseWheelListener(this.mouseWheelListener);
		if (control instanceof Composite) {
			for (Control ctrl : ((Composite) control).getChildren()) {
				unregisteredMouseWheelListener(ctrl);
			}
		}
	}

	@Override
	public void layout() {
		contents.layout();
		self.layout();
		super.layout();
		getParent().layout();
	}

	protected void createAddButton() {
		addButton = new Button(buttonsBar, SWT.PUSH);
		addButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Add_12x12.gif")); //$NON-NLS-1$
		addButton.setToolTipText(Messages.EObjectContentsEditor_CreateElement);

		addButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				addAction();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing
			}
		});
	}

	protected void addAction() {
		EClassifier classifier = reference.getEType();
		if (classifier instanceof EClass) {
			EClass classToInstantiate = (EClass) classifier;
			if (classToInstantiate.isAbstract()) {
				// TODO
			}

			EPackage ePackage = classToInstantiate.getEPackage();
			EObject value = ePackage.getEFactoryInstance().create(classToInstantiate);

			modelElementObservable.setValue(value);
		}
	}

	protected void createDeleteButton() {
		deleteButton = new Button(buttonsBar, SWT.PUSH);
		deleteButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Delete_12x12.gif")); //$NON-NLS-1$
		deleteButton.setToolTipText(Messages.EObjectContentsEditor_UnsetValue);

		deleteButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteAction();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//
			}
		});
	}

	protected void deleteAction() {
		modelElementObservable.setValue(null);
	}

	protected void updateButtonsBar() {
		deleteButton.setEnabled(modelElementObservable != null && modelElementObservable.getValue() != null);
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

		EMFGraphicalContentProvider provider = ProviderHelper.encapsulateProvider(contentProvider, resourceSet, HistoryUtil.getHistoryID(dataTypeInstance, reference, "container")); //$NON-NLS-1$

		factory.setContainerContentProvider(provider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}
}
