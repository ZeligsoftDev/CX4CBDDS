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
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.contribution;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.internal.UmlValueSpecificationActivator;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.commands.ValueSpecificationSetCommand;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.ValueSpecification;

import com.google.inject.Injector;

/**
 * This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration of an xtext generatededitor, for properties of UML classifiers.
 */
public class ValueSpecificationXtextDirectEditorConfiguration extends DefaultXtextDirectEditorConfiguration {

	/**
	 * The contant for the string "not a ValueSpecification".
	 */
	private static final String NOT_A_VALUE_SPECIFICATION = "not a ValueSpecification"; //$NON-NLS-1$

	/**
	 * The xtext string value.
	 */
	protected String xtextStringValue = ""; //$NON-NLS-1$

	/**
	 * The structural feature to edit.
	 */
	protected EStructuralFeature structuralFeature = null;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration#getInjector()
	 */
	@Override
	public Injector getInjector() {
		return UmlValueSpecificationActivator.getInstance().getInjector(
				UmlValueSpecificationActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_VALUESPECIFICATION_XTEXT_UMLVALUESPECIFICATION);
	}

	/**
	 * Adapts {@link IDirectEditorConfiguration} to gmfs {@link IParser} interface for reuse in GMF direct editing infrastructure.
	 */
	@Override
	public IParser createParser(final EObject semanticObject) {
		objectToEdit = semanticObject;
		return new IParser() {

			public String getEditString(final IAdaptable element, final int flags) {
				return ValueSpecificationXtextDirectEditorConfiguration.this.getTextToEditInternal(semanticObject);
			}

			public ICommand getParseCommand(final IAdaptable element, final String newString, final int flags) {
				xtextStringValue = newString;
				EObject initialValue = null;
				// Try to get the structural feature
				structuralFeature = (EStructuralFeature) element.getAdapter(EStructuralFeature.class);
				if (null == structuralFeature) {
					// If the element is an EObject, try to get the structural feature corresponding
					initialValue = (EObject) element.getAdapter(ValueSpecification.class);
					structuralFeature = getStructuralFeature((EObject) objectToEdit, initialValue);
				} else {
					// Get the initial value specification corresponding to the structural feature
					initialValue = (EObject) ((EObject) objectToEdit).eGet(structuralFeature);
				}
				return ValueSpecificationXtextDirectEditorConfiguration.this.getParseCommand(initialValue, null);
			}

			public String getPrintString(final IAdaptable element, final int flags) {
				return ValueSpecificationXtextDirectEditorConfiguration.this.getTextToEdit(semanticObject);
			}

			public boolean isAffectingEvent(final Object event, final int flags) {
				return false;
			}

			public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
				// Not used
				return null;
			}

			public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
				// Not used
				return null;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration#getParseCommand(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected ICommand getParseCommand(final EObject initialValue, final EObject xtextObject) {
		ICommand result = null;
		if (objectToEdit instanceof EObject && null != structuralFeature) {
			// If the xtext object is not null, that means the xtext was already parsed
			if (null == xtextObject) {
				result = ValueSpecificationSetCommand.getInstance().createSetCommand(getInjector(), (EObject) objectToEdit, structuralFeature, xtextStringValue, getDefaultLanguages());
			} else {
				result = ValueSpecificationSetCommand.getInstance().getParseCommand((EObject) objectToEdit, structuralFeature, xtextObject, xtextStringValue, getDefaultLanguages());
			}
		}
		return result;
	}

	/**
	 * This allow to define the default languages for an opaque expression.
	 * 
	 * @return The list of default languages.
	 */
	protected Collection<String> getDefaultLanguages() {
		// This method will be redefined to define the default languages of an opaque expression
		return Collections.emptyList();
	}

	/**
	 * This allow to get the structural feature from the parent corresponding to the value.
	 * 
	 * @param parent
	 *            The parent EObject.
	 * @param value
	 *            The value to search.
	 * @return The {@link EStructuralFeature} corresponding or <code>null</code>.
	 */
	protected EStructuralFeature getStructuralFeature(final EObject parent, final EObject value) {
		EStructuralFeature feature = null;
		if (null != parent && null != value) {
			final Iterator<EStructuralFeature> features = parent.eClass().getEAllStructuralFeatures().iterator();
			while (null == feature && features.hasNext()) {
				final EStructuralFeature currentFeature = features.next();
				final Object currentValue = parent.eGet(currentFeature);
				if (currentFeature.isChangeable() && !currentFeature.isUnsettable() && null != currentValue && currentValue.equals(value)) {
					feature = currentFeature;
				}
			}
		}
		return feature;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof ValueSpecification) {
			return new UMLLabelProvider().getText(editedObject);
		}
		return NOT_A_VALUE_SPECIFICATION;
	}
}
