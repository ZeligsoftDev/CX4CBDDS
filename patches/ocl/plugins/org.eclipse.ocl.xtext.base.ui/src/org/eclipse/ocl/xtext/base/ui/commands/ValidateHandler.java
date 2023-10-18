/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * <p>
 * This class adapts instances of <code>IAction</code> to <code>IHandler</code>.
 * </p>
 *
 * Based on ActionHandler,AbstractHandler,EventManager
 */
public final class ValidateHandler implements IHandler2
{
	/**
	 * An empty array that can be returned from a call to
	 * {@link #getListeners()} when {@link #listenerList} is <code>null</code>.
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * A collection of objects listening to changes to this manager. This
	 * collection is <code>null</code> if there are no listeners.
	 */
	@SuppressWarnings("rawtypes")		// pre-Neon compatibility; Neon adds generics
	private transient ListenerList listenerList = null;

	/**
	 * Track this base class enabled state.
	 */
	private boolean baseEnabled = true;

	/**
	 * The wrapped action. This value is never <code>null</code>.
	 */
	private final ValidateCommand action;

	/**
	 * The property change listener hooked on to the action. This is initialized
	 * when the first listener is attached to this handler, and is removed when
	 * the handler is disposed or the last listener is removed.
	 */
	private IPropertyChangeListener propertyChangeListener;

	/**
	 * Creates a new instance of this class given an instance of
	 * <code>IAction</code>.
	 */
	public ValidateHandler() {
		this.action = new ValidateCommand();
	}

	@Override
	public final void addHandlerListener(final IHandlerListener handlerListener) {
		if (!hasListeners()) {
			attachListener();
		}
		addListenerObject(handlerListener);
	}

	/**
	 * Adds a listener to this manager that will be notified when this manager's
	 * state changes.
	 *
	 * @param listener
	 *            The listener to be added; must not be <code>null</code>.
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})		// pre-Neon compatibility; Neon adds generics
	protected synchronized final void addListenerObject(final Object listener) {
		if (listenerList == null) {
			listenerList = new ListenerList(ListenerList.IDENTITY);
		}

		listenerList.add(listener);
	}

	/**
	 * When a listener is attached to this handler, then this registers a
	 * listener with the underlying action.
	 */
	private final void attachListener() {
		if (propertyChangeListener == null) {
			propertyChangeListener = new IPropertyChangeListener() {
//				@Override
				@Override
				public final void propertyChange(
						final PropertyChangeEvent propertyChangeEvent) {
					final String property = propertyChangeEvent.getProperty();
					fireHandlerChanged(new HandlerEvent(ValidateHandler.this,
							IAction.ENABLED.equals(property),
							IAction.HANDLED.equals(property)));
				}
			};
		}

		this.action.addPropertyChangeListener(propertyChangeListener);
	}

	/**
	 * Clears all of the listeners from the listener list.
	 */
	protected synchronized final void clearListeners() {
		if (listenerList != null) {
			listenerList.clear();
		}
	}

	/**
	 * When no more listeners are registered, then this is used to removed the
	 * property change listener from the underlying action.
	 */
	private final void detachListener() {
		this.action.removePropertyChangeListener(propertyChangeListener);
		propertyChangeListener = null;
	}

	/**
	 * Removes the property change listener from the action.
	 *
	 * @see org.eclipse.core.commands.IHandler#dispose()
	 */
	@Override
	public final void dispose() {
		if (hasListeners()) {
			action.removePropertyChangeListener(propertyChangeListener);
		}
	}

/*	@Override
	public final Object execute(final ExecutionEvent event)
			throws ExecutionException {
		if ((action.getStyle() == IAction.AS_CHECK_BOX)
				|| (action.getStyle() == IAction.AS_RADIO_BUTTON)) {
			action.setChecked(!action.isChecked());
		}
		final Object trigger = event.getTrigger();
		try {
			ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
			if (trigger instanceof Event) {
				action.runWithEvent((Event) trigger);
			} else {
				action.runWithEvent(new Event());
			}
		} catch (Exception e) {
			throw new ExecutionException(
					"While executing the action, an exception occurred", e); //$NON-NLS-1$
		}
		return null;
	} */

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		action.setActiveWorkbenchPart(part);
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			setEnabled(action.updateSelection((IStructuredSelection) selection));
		} else {
			setEnabled(false);
		}
		action.run();
		return null;
	}

	/**
	 * Fires an event to all registered listeners describing changes to this
	 * instance.
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the first
	 * line of the method should be "<code>super.fireHandlerChanged(handlerEvent);</code>".
	 * </p>
	 *
	 * @param handlerEvent
	 *            the event describing changes to this instance. Must not be
	 *            <code>null</code>.
	 */
	protected void fireHandlerChanged(final HandlerEvent handlerEvent) {
		if (handlerEvent == null) {
			throw new NullPointerException();
		}

		final Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			final IHandlerListener listener = (IHandlerListener) listeners[i];
			listener.handlerChanged(handlerEvent);
		}
	}

	/**
	 * Returns the action associated with this handler
	 *
	 * @return the action associated with this handler (not null)
	 */
	public final IAction getAction() {
		return action;
	}

	/**
	 * Returns the listeners attached to this event manager.
	 *
	 * @return The listeners currently attached; may be empty, but never
	 *         <code>null</code>
	 */
	protected final Object[] getListeners() {
		@SuppressWarnings("rawtypes")		// pre-Neon compatibility; Neon adds generics
		final ListenerList list = listenerList;
		if (list == null) {
			return EMPTY_ARRAY;
		}

		return list.getListeners();
	}

	@Override
	public final boolean isEnabled() {
		return action.isEnabled();
	}

	@Override
	public final boolean isHandled() {
		return action.isHandled();
	}

	/**
	 * <p>
	 * Returns true iff there is one or more IHandlerListeners attached to this
	 * AbstractHandler.
	 * </p>
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the return
	 * value should include "<code>super.hasListeners() ||</code>".
	 * </p>
	 *
	 * @return true iff there is one or more IHandlerListeners attached to this
	 *         AbstractHandler
	 */
	protected boolean hasListeners() {
		return isListenerAttached();
	}

	/**
	 * Whether one or more listeners are attached to the manager.
	 *
	 * @return <code>true</code> if listeners are attached to the manager;
	 *         <code>false</code> otherwise.
	 */
	protected final boolean isListenerAttached() {
		return listenerList != null;
	}

	@Override
	public final void removeHandlerListener(final IHandlerListener handlerListener) {
		removeListenerObject(handlerListener);
		if (!hasListeners()) {
			detachListener();
		}
	}

	/**
	 * Removes a listener from this manager.
	 *
	 * @param listener
	 *            The listener to be removed; must not be <code>null</code>.
	 */
	protected synchronized final void removeListenerObject(final Object listener) {
		if (listenerList != null) {
			listenerList.remove(listener);

			if (listenerList.isEmpty()) {
				listenerList = null;
			}
		}
	}

	/**
	 * Allow the default {@link #isEnabled()} to answer our enabled state. It
	 * will fire a HandlerEvent if necessary. If clients use this method they
	 * should also consider overriding {@link #setEnabled(Object)} so they can
	 * be notified about framework execution contexts.
	 *
	 * @param state
	 *            the enabled state
	 */
	protected void setBaseEnabled(boolean state) {
		if (baseEnabled == state) {
			return;
		}
		baseEnabled = state;
		fireHandlerChanged(new HandlerEvent(this, true, false));
	}

	/**
	 * Called by the framework to allow the handler to update its enabled state
	 * by extracting the same information available at execution time. Clients
	 * may override if they need to extract information from the application
	 * context.
	 *
	 * @param evaluationContext
	 *            the application context. May be <code>null</code>
	 * @see #setBaseEnabled(boolean)
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
	}

	@Override
	public final String toString() {
		final StringBuffer buffer = new StringBuffer();

		buffer.append("ActionHandler("); //$NON-NLS-1$
		buffer.append(action);
		buffer.append(')');

		return buffer.toString();
	}
}
