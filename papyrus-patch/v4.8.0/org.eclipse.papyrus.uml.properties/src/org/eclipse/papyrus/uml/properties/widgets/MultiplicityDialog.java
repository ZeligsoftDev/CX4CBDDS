/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.preferences.MultiplicityEditorPreferences;
import org.eclipse.swt.widgets.Composite;

/**
 * The multiplicity dialog for the properties view.
 */
public class MultiplicityDialog extends AbstractPropertyEditor {

	/**
	 * The multiplicity lower value property path.
	 */
	private static final String MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH = "UML:MultiplicityElement:lowerValue"; //$NON-NLS-1$

	/**
	 * The multiplicity upper value property path.
	 */
	private static final String MULTIPLICITY_UPPER_VALUE_UML_PROPERTY_PATH = "UML:MultiplicityElement:upperValue"; //$NON-NLS-1$

	/**
	 * The number of properties path used.
	 */
	private static final int NuMBER_PROPERTIES_PATH = 3;


	/**
	 * The ValueFactory used to create or edit Objects directly from this editor.
	 */
	protected ReferenceValueFactory factory;

	/**
	 * The MultiplicityReferenceDialog widget.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.MultiplicityDialog editor;


	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 */
	public MultiplicityDialog(final Composite parent, final int style) {
		setEditor(createMultiplicityDialog(parent, style));
	}

	/**
	 * Creates the multiplicity dialog.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 * @return The reference dialog.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.MultiplicityDialog createMultiplicityDialog(
			final Composite parent, final int style) {
		return editor = new ExtendedMultiplicityDialog(parent, style, MultiplicityEditorPreferences.instance.getPreferenceStore());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		// Create the content providers for each editor
		final List<IStaticContentProvider> contentProviders = new ArrayList<IStaticContentProvider>(NuMBER_PROPERTIES_PATH);
		contentProviders.add(input.getContentProvider(propertyPath));
		contentProviders.add(input.getContentProvider(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));
		contentProviders.add(input.getContentProvider(MULTIPLICITY_UPPER_VALUE_UML_PROPERTY_PATH));
		editor.setContentProviders(contentProviders);

		// Create the label providers for each editor
		final List<ILabelProvider> labelProviders = new ArrayList<ILabelProvider>(NuMBER_PROPERTIES_PATH);
		labelProviders.add(input.getLabelProvider(propertyPath));
		labelProviders.add(input.getLabelProvider(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));
		labelProviders.add(input.getLabelProvider(MULTIPLICITY_UPPER_VALUE_UML_PROPERTY_PATH));
		editor.setLabelProviders(labelProviders);

		editor.setDirectCreation(input.getDirectCreation(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));
		editor.setMandatory(input.isMandatory(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));

		final List<ReferenceValueFactory> factories = new ArrayList<ReferenceValueFactory>(NuMBER_PROPERTIES_PATH);
		if (null == factory) {
			// Use the default factory from the DataSource
			factories.add(input.getValueFactory(propertyPath));
		} else {
			// Use the factory explicitly specified
			factories.add(factory);
		}
		factories.add(input.getValueFactory(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));
		factories.add(input.getValueFactory(MULTIPLICITY_UPPER_VALUE_UML_PROPERTY_PATH));
		editor.setValueFactories(factories);

		super.doBinding();
	}

	/**
	 * Sets the ValueFactory used to create or edit Objects directly from this editor.
	 *
	 * @param factory
	 *            The reference value factory.
	 */
	public void setFactory(final ReferenceValueFactory factory) {
		this.factory = factory;
		final List<ReferenceValueFactory> factories = new ArrayList<ReferenceValueFactory>(NuMBER_PROPERTIES_PATH);
		factories.add(factory);
		factories.add(input.getValueFactory(MULTIPLICITY_LOWER_VALUE_UML_PROPERTY_PATH));
		factories.add(input.getValueFactory(MULTIPLICITY_UPPER_VALUE_UML_PROPERTY_PATH));
		editor.setValueFactories(factories);
	}

	/**
	 * Get the factory.
	 * 
	 * @return The ValueFactory used to create or edit Objects directly from
	 *         this editor.
	 */
	public ReferenceValueFactory getFactory() {
		return factory;
	}

}
