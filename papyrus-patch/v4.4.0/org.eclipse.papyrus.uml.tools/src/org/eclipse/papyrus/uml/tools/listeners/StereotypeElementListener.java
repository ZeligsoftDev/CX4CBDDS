/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *  Christian W. Damus - bugs 450523, 399859, 492482, 494478, 497341
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.listeners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.NotificationChainImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Listener of all stereotype application actions in Resource set.
 *
 * @author Gabriel Pascual
 *
 */
public class StereotypeElementListener extends ResourceSetListenerImpl {

	/** The stereotype filter notification. */
	private StereotypeNotificationFilter stereotypeFilter = new StereotypeNotificationFilter();

	private final StereotypeExtensionFinder finder;

	/** Notifications to dispatch and invert at post-commit of undo/redo transactions. */
	private final List<NotificationChain> undoRedoNotifications = new ArrayList<>();

	/** The transaction option indicating that a transaction performs undo or redo of a command. */
	private final Transaction.OptionMetadata undoRedoOption = Transaction.OptionMetadata.Registry.INSTANCE.getOptionMetadata(Transaction.OPTION_IS_UNDO_REDO_TRANSACTION);

	/**
	 * Instantiates a new stereotype element listener on an editing domain.
	 *
	 * @param editingDomain
	 *            the editing-domain context in which the listener responds to events
	 */
	public StereotypeElementListener(TransactionalEditingDomain editingDomain) {
		this(editingDomain.getResourceSet());
	}

	/**
	 * Instantiates a new stereotype element listener on a resource set.
	 *
	 * @param resourceSet
	 *            the resource-set context in which the listener responds to events
	 */
	public StereotypeElementListener(ResourceSet resourceSet) {
		super();

		this.finder = new StereotypeExtensionFinder(resourceSet);
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		Command result = null;

		if (!event.getNotifications().isEmpty()) {
			// Get filtered notifications
			final NotificationChain chain = new NotificationChainImpl();
			List<Notification> filteredNotificationsList = new ArrayList<>(event.getNotifications());

			// Handle each filtered notification
			for (Notification notification : filteredNotificationsList) {
				handleFilteredNotification(notification, chain);
			}

			result = new AbstractCommand("Inject Stereotype Notifications") { //$NON-NLS-1$
				private NotificationChain notifications;

				@Override
				protected boolean prepare() {
					this.notifications = chain;
					return true;
				}

				@Override
				public void execute() {
					dispatchAndInvert();
				}

				@Override
				public void undo() {
					// Schedule dispatch and inversion at post-commit time
					undoRedoNotifications.add(this.notifications);
				}

				@Override
				public void redo() {
					// Schedule dispatch and inversion at post-commit time
					undoRedoNotifications.add(this.notifications);
				}

				private void dispatchAndInvert() {
					this.notifications.dispatch();
					invertNotifications(this.notifications);
				}
			};
		}

		return result;
	}

	/**
	 * Invert the semantics of a chain of stereotype-application {@code notifications}
	 * in situ. This includes reversing the order in which they are dispatched.
	 * 
	 * @param notifications
	 *            notifications to invert
	 * @see StereotypeExtensionNotification#invert()
	 */
	private void invertNotifications(NotificationChain notifications) {
		// The chain is implemented as an EList
		@SuppressWarnings("unchecked")
		EList<Notification> list = (EList<Notification>) notifications;

		// Reverse the order
		ECollections.reverse(list);

		// And flip the type from applied <--> unapplied
		for (Notification next : list) {
			((StereotypeExtensionNotification) next).invert();
		}
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		if ((event.getTransaction() == null) || Boolean.FALSE.equals(undoRedoOption.getValue(event.getTransaction().getOptions()))) {
			// Not an undo/redo transaction? Purge any notifications that we may have
			// had from a rolled-back undo or redo
			undoRedoNotifications.clear();
		} else if (!undoRedoNotifications.isEmpty()) {
			// It's an undo/redo transaction. Dispatch the (inverted) notifications
			// that were deferred by the notification-injector command
			try {
				for (NotificationChain next : undoRedoNotifications) {
					next.dispatch();
					invertNotifications(next);
				}
			} finally {
				// Subsequent redo/undo of the injector command will collect
				// these again
				undoRedoNotifications.clear();
			}
		}
	}

	/**
	 * Handle filtered notification.
	 *
	 * @param notification
	 *            the notification
	 * @param notifications
	 *            a notification chain on which to collect notifications for later dispatch. If {@code null}, then dispatch immediately
	 */
	private void handleFilteredNotification(Notification notification, NotificationChain notifications) {
		final Object notifier = notification.getNotifier();

		Element extendedElement = null;
		Stereotype stereotype = null;
		boolean isBaseFeature = true;

		// Use UML tools to get Stereotype and base Element
		if (notifier instanceof EObject) {
			stereotype = finder.getDefiningStereotype((EObject) notifier);
			if (stereotype != null) {
				extendedElement = finder.getExtendedElement((EObject) notifier);
				isBaseFeature = ((EStructuralFeature) notification.getFeature()).getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
			}
		}


		int eventType = 0;
		// Check if notifier is an stereotype
		if (stereotype != null) {
			if (!isBaseFeature) {
				eventType = StereotypeExtensionNotification.MODIFIED_STEREOTYPE_OF_ELEMENT;
			} else if (extendedElement == null) {
				// Check state of base Element on stereotype application
				extendedElement = (Element) notification.getOldValue();
				eventType = StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT;
			} else {
				extendedElement = (Element) notification.getNewValue();
				eventType = StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT;
			}
		}


		if (stereotype != null) {
			Object oldValue = null;
			Object newValue = null;
			Element element = extendedElement;
			switch (eventType) {
			case StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT:
				oldValue = notifier;
				break;
			case StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT:
				newValue = notifier;
				break;
			case StereotypeExtensionNotification.MODIFIED_STEREOTYPE_OF_ELEMENT:
				// New value is the modified element
				newValue = notification.getNewValue();
				oldValue = notification.getOldValue();
				break;
			default:
				// Nothing to do

			}

			// Bug 450523: If element is null, the notification has already been sent. Simply ignore this case
			if (element != null) {
				NotificationImpl newNotification = new StereotypeExtensionNotification(element, eventType, oldValue, newValue, stereotype);
				if (notifications == null) {
					// Dispatch it now
					newNotification.dispatch();
				} else {
					notifications.add(newNotification);
				}
			}
		}

	}

	/**
	 * Gets the filter.
	 *
	 * @return the filter
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#getFilter()
	 */
	@Override
	public NotificationFilter getFilter() {
		return stereotypeFilter;
	}

	/**
	 * The Class StereotypeExtensionFinder.
	 */
	class StereotypeExtensionFinder extends UMLUtil {
		private final ResourceSet resourceSet;

		StereotypeExtensionFinder(ResourceSet resourceSet) {
			this.resourceSet = resourceSet;
		}

		Stereotype getDefiningStereotype(EObject stereotypeApplication) {
			Stereotype result = null;

			NamedElement umlDefinition = getUMLDefinition(stereotypeApplication.eClass(), stereotypeApplication);
			if (umlDefinition instanceof Stereotype) {
				result = (Stereotype) umlDefinition;
			}

			return result;
		}

		Property getExtensionEnd(EObject stereotypeApplication, EStructuralFeature ecoreDefinition) {
			Property result = null;

			NamedElement umlDefinition = getUMLDefinition(ecoreDefinition, stereotypeApplication);
			if (umlDefinition instanceof Property) {
				Property property = (Property) umlDefinition;

				// Is the property a member end of a metaclass extension?
				if (property.getAssociation() instanceof Extension) {
					result = property;
				}
			}

			return result;
		}

		NamedElement getUMLDefinition(ENamedElement ecoreElement, EObject context) {

			// Bug 450523: Quick pre-check: verify the existence of a base_X property typed with Element
			boolean mayBeStereotype = false;
			for (EReference reference : context.eClass().getEAllReferences()) {
				String name = reference.getName();
				if (name != null && name.startsWith(Extension.METACLASS_ROLE_PREFIX)) {
					EClass type = reference.getEType() instanceof EClass ? (EClass) reference.getEType() : null;
					if (type != null && UMLPackage.eINSTANCE.getElement().isSuperTypeOf(type)) {
						mayBeStereotype = true;
						break;
					}
				}
			}

			// If the quick check failed, don't go further
			if (!mayBeStereotype) {
				return null;
			}

			// If the quick pre-check is successful, do a complete check
			NamedElement result = getNamedElement(ecoreElement, context);

			if ((result == null) && (resourceSet != null)) {
				// Try again in the resource set context, with some loaded object for context
				EObject anyLoadedObject = getAnyEObject(resourceSet);
				if (anyLoadedObject != null) {
					// If there is no loaded object, then there's no point in any of this because
					// obviously there can't be a profile definition without any profiles loaded
					result = getNamedElement(ecoreElement, anyLoadedObject);
				}
			}

			return result;
		}

		/**
		 * @precondition the {@code stereotypeApplication} is known to be an instance of a {@link Stereotype} according to {@link #getDefiningStereotype(EObject)}
		 */
		Element getExtendedElement(EObject stereotypeApplication) {
			EClass eClass = stereotypeApplication.eClass();
			return getBaseElement(eClass, stereotypeApplication);
		}

		private EObject getAnyEObject(ResourceSet resourceSet) {
			EObject result = null;

			for (Resource next : resourceSet.getResources()) {
				if (next.isLoaded() && !next.getContents().isEmpty()) {
					result = next.getContents().get(0);
				}
			}

			return result;
		}
	}

	/**
	 * Notification filter on Stereotype application.
	 * <ul>
	 * <li>Set a {@link Stereotype} to {@link Element}</li>
	 * <li>Unset a {@link Stereotype} on {@link Element}</li>
	 * </ul>
	 */
	class StereotypeNotificationFilter extends NotificationFilter.Custom {

		/**
		 * Instantiates a new stereotype notification filter.
		 */
		StereotypeNotificationFilter() {
			super();
		}

		/**
		 * Matches.
		 *
		 * @param notification
		 *            the notification
		 * @return true, if successful
		 * @see org.eclipse.emf.transaction.NotificationFilter#matches(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public boolean matches(Notification notification) {

			// Get notification field to filter
			Object notifier = notification.getNotifier();
			Object feature = notification.getFeature();
			Object baseElement = null;
			boolean isBaseFeature = false;

			// Check if feature is a based feature of a stereotype extension
			if (feature instanceof EStructuralFeature) {
				isBaseFeature = ((EStructuralFeature) feature).getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
			}

			switch (notification.getEventType()) {
			case Notification.RESOLVE:
				// Only interested in proxy resolution when it is the base feature, because this is how we detect
				// application of a stereotype by loading a resource containing stereotype instances
				if (!isBaseFeature) {
					return false;
				}
				break;
			default:
				if (notification.isTouch()) {
					return false;
				}
				break;
			}

			// Fields of a stereotype extension
			Property extensionProperty = null;

			// Use UML tools to get extension property
			if (notifier instanceof EObject) {
				Stereotype stereotype = finder.getDefiningStereotype((EObject) notifier);
				if (stereotype != null) {
					extensionProperty = finder.getExtensionEnd((EObject) notifier, (EStructuralFeature) feature);
					if (extensionProperty == null) {
						baseElement = StereotypeExtensionFinder.getBaseElement((EObject) notifier);
					}
				}
			}

			return (extensionProperty != null && isBaseFeature) || (!isBaseFeature && baseElement instanceof Element);
		}
	}

	/**
	 * Specific notification handled by this listener.
	 * <p>
	 * It implements the {@link ENotificationImpl} notification.
	 * </p>
	 */
	public class StereotypeExtensionNotification extends ENotificationImpl {

		/** Event type notification for stereotype application action. */
		public static final int STEREOTYPE_APPLIED_TO_ELEMENT = Notification.EVENT_TYPE_COUNT + 21;

		/** Event type notification for stereotype unapplication action. */
		public static final int STEREOTYPE_UNAPPLIED_FROM_ELEMENT = Notification.EVENT_TYPE_COUNT + 22;

		/** The Constant MODIFIED_STEREOTYPE_OF_ELEMENT. */
		public static final int MODIFIED_STEREOTYPE_OF_ELEMENT = Notification.EVENT_TYPE_COUNT + 23;

		private Stereotype stereotype;

		/**
		 * Creates a new StereotypeExtensionNotification.
		 *
		 * @param notifier
		 *            the notifier that sends this notification
		 * @param eventType
		 *            the type of event
		 * @param oldValue
		 *            the instance (an {@link EObject} of some kind) of the {@link Stereotype} that was unapplied, or {@code null} if this is notification of a stereotype application;
		 *            or the old value of a stereotype property if this is a notification of a stereotype modification
		 * @param newValue
		 *            the instance (an {@link EObject} of some kind) of the {@link Stereotype} that was applied, or {@code null} if this is notification of a stereotype unapplication;
		 *            or the new value of a stereotype property if this is a notification of a stereotype modification
		 * @param stereotype
		 *            the {@link Stereotype} defining the extension object that was attached to or unattached from its base element or was modified
		 */
		public StereotypeExtensionNotification(Element notifier, int eventType, Object oldValue, Object newValue, Stereotype stereotype) {
			super((InternalEObject) notifier, eventType, null, oldValue, newValue);

			this.stereotype = stereotype;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isTouch() {
			return false;
		}

		/**
		 * Queries the stereotype that was applied to or unapplied from a model element, or an instance of which changed in some other way.
		 * 
		 * @return the stereotype defining the element extension instance that changed
		 */
		public Stereotype getStereotype() {
			return stereotype;
		}

		/**
		 * Flips an "applied" notification to "unapplied" and vice versa.
		 */
		void invert() {
			switch (getEventType()) {
			case STEREOTYPE_APPLIED_TO_ELEMENT:
				eventType = STEREOTYPE_UNAPPLIED_FROM_ELEMENT;
				break;
			case STEREOTYPE_UNAPPLIED_FROM_ELEMENT:
				eventType = STEREOTYPE_APPLIED_TO_ELEMENT;
				break;
			default:
				// Stereotype-modified events are their own inverses
				break;
			}

			// Swap the old and new values
			Object swap = oldValue;
			oldValue = newValue;
			newValue = swap;
		}
	}

}
