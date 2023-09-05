/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueEditor;
import org.eclipse.papyrus.uml.properties.databinding.StereotypePropertyObservableList;
import org.eclipse.papyrus.uml.properties.databinding.StereotypePropertyObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A structural feature editor for stereotype properties.
 */
@SuppressWarnings("unchecked")
public class StereotypeEStructuralFeatureEditor extends EStructuralFeatureEditor {

	/**
	 * Store the stereotype to edit.
	 */
	private Stereotype stereotype;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The editor style.
	 */
	public StereotypeEStructuralFeatureEditor(final Composite parent, final int style) {
		super(parent, style);
	}

	/**
	 * Set the stereotype to manage.
	 *
	 * @param stereotype
	 *            The stereotype to manage.
	 */
	public void setStereotype(final Stereotype stereotype) {
		this.stereotype = stereotype;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.uml.properties.widgets.EStructuralFeatureEditor#getReferenceObservableValue(org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject, org.eclipse.uml2.uml.Element)
	 */
	@Override
	protected IObservableValue<?> getReferenceObservableValue(EReference feature, EObject stereotypeApplication, Element owner) {
		return new StereotypePropertyObservableValue(owner, feature, EMFHelper.resolveEditingDomain(stereotypeApplication), stereotype);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.uml.properties.widgets.EStructuralFeatureEditor#setValueEditorProperties(org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor, org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	protected void setValueEditorProperties(final AbstractValueEditor editor, final EObject stereotypeApplication, final Element owner, final String title, final EStructuralFeature feature) {
		final StereotypePropertyObservableValue observable = new StereotypePropertyObservableValue(owner, feature, EMFHelper.resolveEditingDomain(stereotypeApplication), stereotype);
		observable.addValueChangeListener(this);
		editor.setLabel(title);
		editor.setReadOnly(!isEditable(stereotypeApplication, feature));
		editor.setModelObservable(observable);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.uml.properties.widgets.EStructuralFeatureEditor#setMultipleValueEditorProperties(org.eclipse.papyrus.infra.widgets.editors.MultipleValueEditor, java.util.List, org.eclipse.emf.ecore.EObject, org.eclipse.uml2.uml.Element,
	 *      java.lang.String, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	protected void setMultipleValueEditorProperties(final MultipleValueEditor<?> editor, final List<?> initialList, final EObject stereotypeApplication, final Element owner, final String title, final EStructuralFeature feature) {
		final StereotypePropertyObservableList observable = new StereotypePropertyObservableList(initialList, EMFHelper.resolveEditingDomain(stereotypeApplication), owner, feature, stereotype);
		observable.addListChangeListener(this);
		editor.setLabel(title);
		editor.setUnique(feature.isUnique());
		editor.setOrdered(feature.isOrdered());
		editor.setUpperBound(feature.getUpperBound());
		editor.setModelObservable(observable);
		editor.setReadOnly(!isEditable(stereotypeApplication, feature));
		if (feature instanceof EReference) {
			editor.setDirectCreation(((EReference) feature).isContainment());
		}
		editor.addCommitListener(observable);
	}
}
