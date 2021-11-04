/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.namereferences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Parser Helper to replace references to NamedElements in a text
 *
 * It relies on a parser to search references and replace them with a text value
 *
 * @author Camille Letavernier
 *
 */
// FIXME: Reimplement listeners mechanism. The listeners are not correctly added/removed (Especially when the referenced element is moved)
// FIXME: URI changes are not properly detected (ControlMode)
public class NameReferencesHelper extends TextReferencesHelper {

	private ChangeDispatcher listener = new ChangeDispatcher();

	public NameReferencesHelper() {
		super();
		// Empty
	}

	/**
	 *
	 * @param baseResource
	 *            The resource against which the link uris will be resolved
	 */
	public NameReferencesHelper(Resource baseResource) {
		super(baseResource);
	}

	@Override
	protected String decorate(String text) {
		return "<u>" + text + "</u>";
	}

	@Override
	public String replaceReferences(String text) {
		listener.clearElementListeners(); // Remove all previous listeners before adding new ones
		dispatch = false;
		String result = super.replaceReferences(text);
		dispatch = true;
		return result;
	}

	/**
	 * Returns the String replacement for the given element
	 */
	@Override
	protected String getReplacement(EObject elementToReplace, String cachedValue) {
		if (elementToReplace == null) {
			return UNKNOWN_ELEMENT;
		}

		if (elementToReplace.eIsProxy()) {
			return PROXY_ELEMENT;
		}

		if (elementToReplace instanceof NamedElement) {
			NamedElement target = (NamedElement) elementToReplace;

			if (installListeners()) {

				if (!target.eAdapters().contains(listener)) {
					// Listen on value changes (NamedElement#name)
					listener.listenOnElement(target);
				}

				if (!target.eResource().eAdapters().contains(listener)) {
					// Listen on resource changes (Deletion)
					listener.listenOnElement(target.eResource());
				}

				if (target.eContainer() != null && !target.eContainer().eAdapters().contains(listener)) {
					// Listen on the contents of the parent element (Deletion)
					listener.listenOnElement(target.eContainer());
				}
			}

			if (target.getName() == null) {
				return "UNNAMED";
			} else {
				return UMLLabelInternationalization.getInstance().getLabel(target);
			}
		}

		if (cachedValue == null) {
			return UNKNOWN_ELEMENT;
		}

		return cachedValue + " (Missing)";
	}

	private boolean dispatch = true;

	private boolean installListeners() {
		return !this.listener.listeners.isEmpty();
	}

	public void addListener(Adapter listener) {
		this.listener.addListener(listener);
	}

	public void removeListener(Adapter listener) {
		this.listener.removeListener(listener);
	}

	public void dispose() {
		this.listener.dispose();
		this.resourceSet = null;
		this.baseResource = null;
	}

	private class ChangeDispatcher extends AdapterImpl {

		private final Set<Adapter> listeners = new HashSet<Adapter>();

		private final Set<Notifier> listenOnElements = new HashSet<Notifier>();

		@Override
		public void notifyChanged(Notification msg) {
			// A change occurred on one of the referenced elements
			try {
				if (dispatch && isValidNotification(msg)) {
					for (Adapter listener : listeners) {
						try {
							listener.notifyChanged(msg);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// The current implementation is not strict. This will lead to useless refreshes
		// (e.g. each time the contents of the parent change, or when the name of the parent changes)
		// The NameReferencesHelper should probably handle its own listeners, and call a
		// refresh/listener method when updated, to be more precise
		boolean isValidNotification(Notification msg) {
			if (!listenOnElements.contains(msg.getNotifier())) {
				Object notifierObject = msg.getNotifier();
				if (notifierObject instanceof Notifier) {
					((Notifier) notifierObject).eAdapters().remove(this);
				}
				return false;
			}

			// Name of a NamedElement
			if (msg.getFeature() == UMLPackage.eINSTANCE.getNamedElement_Name()) {
				return true;
			}

			// Resource contents
			if (msg.getNotifier() instanceof Resource) {
				return true;
			}

			// Parent contents
			Object feature = msg.getFeature();
			if (feature instanceof EReference) {
				if (((EReference) feature).isContainment()) {
					return true;
				}
			}

			return false;
		}

		public void addListener(Adapter listener) {
			listeners.add(listener);
		}

		public void removeListener(Adapter listener) {
			listeners.remove(listener);
		}

		private void listenOnElement(Notifier element) {
			if (element.eAdapters().contains(this)) {
				return;
			}

			listenOnElements.add(element);
			element.eAdapters().add(this);
		}

		private void clearElementListeners() {
			List<Notifier> notifiers = new LinkedList<Notifier>(listenOnElements);
			for (Notifier notifier : notifiers) {
				notifier.eAdapters().remove(this);
			}
			listenOnElements.clear();
		}

		public void dispose() {
			listeners.clear();
			clearElementListeners();
		}
	}

}
