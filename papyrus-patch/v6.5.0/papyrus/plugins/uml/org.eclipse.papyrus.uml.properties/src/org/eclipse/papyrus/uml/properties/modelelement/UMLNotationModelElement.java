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
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.databinding.ElementCustomizationObservableValue;
import org.eclipse.papyrus.uml.properties.databinding.ElementCustomizationObservableValue.Property;
import org.eclipse.papyrus.uml.properties.databinding.MaskValueObservableList;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A ModelElement for handling UML-Specific appearance elements and properties
 *
 * @author Camille Letavernier
 *
 */
public class UMLNotationModelElement extends AbstractModelElement {

	/**
	 * The labelCustomization property
	 */
	public static final String LabelCustomization = "labelCustomization"; //$NON-NLS-1$

	/**
	 * The stereotypeDisplay property
	 */
	public static final String StereotypeDisplay = "stereotypeDisplay"; //$NON-NLS-1$

	/**
	 * The elementIcon property
	 */
	public static final String ElementIcon = "elementIcon"; //$NON-NLS-1$

	/**
	 * The shadow property
	 */
	public static final String Shadow = "shadow"; //$NON-NLS-1$

	/**
	 * The qualifiedName property
	 */
	public static final String QualifiedName = "qualifiedName"; //$NON-NLS-1$

	/**
	 * The GMF EditPart represented by this ModelElement
	 */
	protected EditPart sourceElement;

	/**
	 *
	 * Constructor.
	 *
	 * @param sourceElement
	 *            The GMF EditPart represented by this ModelElement
	 */
	public UMLNotationModelElement(EditPart sourceElement) {
		this.sourceElement = sourceElement;
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		if (propertyPath.equals(LabelCustomization)) {
			EditingDomain editingDomain = EMFHelper.resolveEditingDomain(sourceElement);
			return new MaskValueObservableList(sourceElement, editingDomain);
		} else if (propertyPath.equals(StereotypeDisplay)) {
			// TODO : check if we need an observable in this case. For now, the Widget is responsible for updating the element
			// @see StereotypeDisplay
			return null;
		} else if (propertyPath.equals(ElementIcon)) {
			return new ElementCustomizationObservableValue(sourceElement, Property.ELEMENT_ICON);
		} else if (propertyPath.equals(Shadow)) {
			return new ElementCustomizationObservableValue(sourceElement, Property.SHADOW);
		} else if (propertyPath.equals(QualifiedName)) {
			return new ElementCustomizationObservableValue(sourceElement, Property.QUALIFIED_NAME);
		}

		Activator.log.warn("Unknown property : " + propertyPath); //$NON-NLS-1$

		return null;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if (propertyPath.equals(QualifiedName)) {
			// maxDepth corresponds to "None" (The name is not qualified), while 0 corresponds to "Full" (Fully qualified name)
			return new AbstractStaticContentProvider() {

				public Object[] getElements() {
					int maxDepth = NamedElementUtil.getQualifiedNameMaxDepth((NamedElement) UMLUtil.resolveUMLElement(sourceElement));
					if (maxDepth == 0) {
						return new Integer[] { 0 };
					}

					Integer[] result = new Integer[maxDepth + 1];
					result[0] = maxDepth; // None
					result[1] = 0; // Full
					for (int i = 1; i < maxDepth; i++) {
						result[i + 1] = i;
					}
					return result;
				}

			};
		}

		return null;
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		// maxDepth corresponds to "None" (The name is not qualified), while 0 corresponds to "Full" (Fully qualified name)
		int depth = NamedElementUtil.getQualifiedNameMaxDepth((NamedElement) UMLUtil.resolveUMLElement(sourceElement));
		final int maxDepth = depth == 0 ? 1 : depth;

		return new LabelProvider() {

			@Override
			public String getText(Object value) {
				if (value instanceof Integer) {
					Integer intValue = (Integer) value;
					if (intValue == maxDepth) {
						return Messages.UMLNotationModelElement_DepthNone;
					} else if (intValue == 0) {
						return Messages.UMLNotationModelElement_DepthFull;
					} else {
						return "-" + intValue; //$NON-NLS-1$
					}
				}
				Activator.log.warn("Unknown value : " + value); //$NON-NLS-1$
				return ""; //$NON-NLS-1$
			}
		};
	}

	/**
	 * @return the GMF Notation model element associated to this edit part
	 */
	public EModelElement getEModelElement() {
		return (EModelElement) sourceElement.getModel();
	}

	/**
	 * @return the GMF Edit Part represented by this ModelElement
	 */
	public EditPart getEditPart() {
		return sourceElement;
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		if (QualifiedName.equals(propertyPath)) {
			return true;
		}
		return super.isMandatory(propertyPath);
	}

	@Override
	public boolean isEditable(String propertyPath) {
		return !EMFHelper.isReadOnly(getEModelElement());
	}
}
