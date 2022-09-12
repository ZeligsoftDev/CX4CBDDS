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
 *  Christian W. Damus (CEA) - 402525
 *  Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 Stereotype Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.DISPLAY_PLACE;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.STEREOTYPE_DISPLAY;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT_ALIGNMENT;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.internal.databinding.Util;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStyleValueCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.uml2.uml.Element;

/**
 * An IObservableValue for editing the Stereotype appearance properties
 *
 * @author Camille Letavernier
 */
public class StereotypeAppearanceObservableValue extends AbstractObservableValue implements IObserving {


	/**
	 * Default values for Observable Value.
	 */
	private static final String DEFAULT_DISPLAY_TYPE = "Text";//$NON-NLS-1$
	protected final static String DEFAULT_LOCATION = "Compartment";//$NON-NLS-1$
	protected final static String DEFAULT_ALIGNMENT = "Horizontal";//$NON-NLS-1$

	/**
	 * The name of the property being observed
	 */
	protected String propertyPath;

	/**
	 * The UML Element being observed
	 */
	protected Element element;

	/**
	 * The Diagram Element associated to the UML Element
	 */
	protected EModelElement diagramElement;

	/**
	 * The EditingDomain on which the commands will be executed
	 */
	protected TransactionalEditingDomain domain;

	/**
	 * Try to synchronize annotation value from model.
	 */
	private Adapter diagramElementListener;

	/**
	 * Cached set value, and fire an event if this value changed.
	 */
	private String cachedValue;

	/**
	 *
	 * Constructor.
	 *
	 * @param diagramElement
	 *            The Diagram Element associated to the UML Element
	 * @param element
	 *            The UML Element being observed
	 * @param propertyPath
	 *            The name of the property being observed
	 * @param domain
	 *            The EditingDomain on which the commands will be executed.
	 *            This should be a {@link TransactionalEditingDomain}
	 */
	public StereotypeAppearanceObservableValue(EModelElement diagramElement, Element element, String propertyPath, EditingDomain domain) {
		this.propertyPath = propertyPath;
		this.diagramElement = diagramElement;
		this.element = element;
		this.domain = (TransactionalEditingDomain) domain;
		if (diagramElement != null) {
			diagramElement.eAdapters().add(getDiagramElementListener());
		}
	}

	/**
	 * Create a listener for DiagramElement.
	 */
	private Adapter getDiagramElementListener() {
		if (diagramElementListener == null) {
			diagramElementListener = new AdapterImpl() {

				@Override
				public void notifyChanged(Notification msg) {
					if (!msg.isTouch()) {
						handleStereotypeChanged(msg);
					}
				}
			};
		}
		return diagramElementListener;
	}

	/**
	 * Synchronize value from model. So that, the binded UI would be updated.
	 */
	protected void handleStereotypeChanged(Notification msg) {
		setValue(doGetValue());
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		if (propertyPath.equals(STEREOTYPE_DISPLAY)) {
			return getStereotypeDisplayValue();
		} else if (propertyPath.equals(TEXT_ALIGNMENT)) {
			return getTextAlignmentValue();
		} else if (propertyPath.equals(DISPLAY_PLACE)) {
			return getDisplayPlaceValue();
		}

		return null;
	}

	/**
	 * Get the Display Value of a View.
	 * 
	 * @return Shape, Icon or Text
	 */

	private String getStereotypeDisplayValue() {
		if (diagramElement != null) {
			return NotationUtils.getStringValue((View) diagramElement, StereotypeDisplayConstant.DISPLAY_ICON, DEFAULT_DISPLAY_TYPE);
		} else {
			return null;
		}
	}

	/**
	 * Get the Alignment of the Stereotype Label.
	 * 
	 * @return Horizontal or Vertical
	 */

	private String getTextAlignmentValue() {
		if (diagramElement != null) {
			return NotationUtils.getStringValue((View) diagramElement, StereotypeDisplayConstant.STEREOTYPE_LABEL_ALIGNMENT, DEFAULT_ALIGNMENT);
		} else {
			return null;
		}
	}

	/**
	 * Get the location of a Property for a View
	 * 
	 * @return Comment, Compartment or With Brace
	 */
	private String getDisplayPlaceValue() {
		if (diagramElement != null) {
			return NotationUtils.getStringValue((View) diagramElement, StereotypeDisplayConstant.STEREOTYPE_PROPERTY_LOCATION, DEFAULT_LOCATION);
		} else {
			return null;
		}
	}

	@SuppressWarnings("restriction")
	@Override
	protected void doSetValue(Object value) {
		if (value instanceof String) {
			String oldValue = cachedValue;
			String stringValue = (String) value;
			if (diagramElement != null) {
				diagramElement.eAdapters().remove(diagramElementListener);
			}
			String currentValue = doGetValue();
			// Update model with if the real value changed.
			if (!Util.equals(currentValue, stringValue)) {
				if (propertyPath.equals(STEREOTYPE_DISPLAY)) { // Edition of the stereotypeDisplay property
					setStereotypeDisplayValue(stringValue);
				} else if (propertyPath.equals(TEXT_ALIGNMENT)) { // Edition of the textAlignment property
					setTextAlignmentValue(stringValue);
				} else if (propertyPath.equals(DISPLAY_PLACE)) { // Edition of the displayPlace property
					setDisplayPlaceValue(stringValue);
				}
			}
			// Send an event if value changed. We should use the cached value since it was binded with others, and the real value can be changed externally(such as UNDO/REDO).
			if (!Util.equals(oldValue, stringValue) && hasListeners()) {
				fireValueChange(Diffs.createValueDiff(oldValue, stringValue));
			}
			if (diagramElement != null) {
				diagramElement.eAdapters().add(getDiagramElementListener());
			}
			cachedValue = stringValue;
		} else {
			Activator.log.warn("The value " + value + " is invalid for property " + propertyPath); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Set the Appearance user choice into a NamedStyle to be treated afterwards.
	 * 
	 * @param stereotypeAppearance
	 *            Type of Appearance
	 */
	private void setStereotypeDisplayValue(String stereotypeAppearance) {
		if (diagramElement instanceof View) {

			Command command = new CustomStyleValueCommand((View) diagramElement, stereotypeAppearance, NotationPackage.eINSTANCE.getStringValueStyle(), NotationPackage.eINSTANCE.getStringValueStyle_StringValue(),
					StereotypeDisplayConstant.DISPLAY_ICON);

			CommandUtil.executeUnsafeCommand(command, domain);
		}
	}

	/**
	 * @deprecated Not Used anymore since the new Stereotype Display Structure is in place.
	 * @param alignment
	 */
	@Deprecated
	private void setTextAlignmentValue(String alignment) {
		if (diagramElement instanceof View) {

			Command command = new CustomStyleValueCommand((View) diagramElement, alignment, NotationPackage.eINSTANCE.getStringValueStyle(), NotationPackage.eINSTANCE.getStringValueStyle_StringValue(),
					StereotypeDisplayConstant.STEREOTYPE_LABEL_ALIGNMENT);

			CommandUtil.executeUnsafeCommand(command, domain);

		}
	}

	/**
	 * Set the Location user choice into a NamedStyle to be treated afterwards.
	 * 
	 * @param stereotypePlacePresentation
	 *            location
	 */
	private void setDisplayPlaceValue(final String stereotypePlacePresentation) {
		if (diagramElement instanceof View) {

			Command command = new CustomStyleValueCommand((View) diagramElement, stereotypePlacePresentation, NotationPackage.eINSTANCE.getStringValueStyle(), NotationPackage.eINSTANCE.getStringValueStyle_StringValue(),
					StereotypeDisplayConstant.STEREOTYPE_PROPERTY_LOCATION);

			CommandUtil.executeUnsafeCommand(command, domain);

		}
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.IObserving#getObserved()
	 *
	 */
	public Object getObserved() {
		return diagramElement;
	}

	/**
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 *
	 */
	@Override
	public synchronized void dispose() {
		if (diagramElement != null && diagramElementListener != null) {
			diagramElement.eAdapters().remove(diagramElementListener);
		}
		super.dispose();
	}
}
