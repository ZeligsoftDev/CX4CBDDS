/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList;

/**
 * An ObservableList used to edit collections of EObjects through
 * Papyrus commands
 *
 * @author Camille Letavernier
 * @deprecated since 1.2.0
 *             Use the {@link org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList} API, instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 */
@Deprecated
@SuppressWarnings("unchecked")
public class PapyrusObservableList extends EMFObservableList {

	/**
	 *
	 * Constructor.
	 *
	 * @param wrappedList
	 *            The list to be edited when #commit() is called
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 * @param source
	 *            The EObject from which the list will be retrieved
	 * @param feature
	 *            The feature from which the list will be retrieved
	 */
	public PapyrusObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(wrappedList, domain, source, feature);
	}

	/**
	 * @return the IElementEditService used to retrieve the command
	 */
	protected IElementEditService getProvider() {
		return ElementEditServiceUtils.getCommandProvider(source);
	}

	/**
	 * Creates an EMF command from a GMF request, with the given IElementEditService
	 *
	 * @param provider
	 * @param requests
	 * @return
	 * 		The EMF command corresponding to the given request
	 */
	protected Command getCommandFromRequests(IElementEditService provider, Collection<? extends IEditCommandRequest> requests) {
		if (requests.size() == 1) {
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(requests.iterator().next()));
		}

		CompositeCommand cc = new CompositeCommand("Edit list"); //$NON-NLS-1$

		for (IEditCommandRequest request : requests) {
			ICommand cmd = provider.getEditCommand(request);
			cc.add(cmd);
		}

		return new GMFtoEMFCommandWrapper(cc);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getAddCommand(int index, Object value) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.add(index, value);
			return getCommandFromRequests(provider, getRequests(values, null));
		}

		return super.getAddCommand(index, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getAddCommand(Object value) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.add(value);
			return getCommandFromRequests(provider, getRequests(values, null));
		}

		return super.getAddCommand(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getAddAllCommand(Collection<?> values) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			result.addAll(values);
			return getCommandFromRequests(provider, getRequests(result, null));
		}

		return super.getAddAllCommand(values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			result.addAll(index, values);
			return getCommandFromRequests(provider, getRequests(result, null));
		}
		return super.getAddAllCommand(index, values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getClearCommand() {
		IElementEditService provider = getProvider();
		if (provider != null) {
			return getCommandFromRequests(provider, getRequests(Collections.EMPTY_LIST, new LinkedList<Object>(this)));
		}
		return super.getClearCommand();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getRemoveCommand(int index) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			Object o = values.remove(index);
			return getCommandFromRequests(provider, getRequests(values, Collections.singletonList(o)));
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getRemoveCommand(final Object value) {
		IElementEditService provider = getProvider();

		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			values.remove(value);
			return getCommandFromRequests(provider, getRequests(values, Collections.singletonList(value)));
		}

		return super.getRemoveCommand(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> result = new LinkedList<Object>(this);
			result.removeAll(values);
			return getCommandFromRequests(provider, getRequests(result, values));
		}
		return super.getRemoveAllCommand(values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			Object result = values.remove(oldIndex);
			values.add(newIndex, result);
			return Collections.singletonList(getCommandFromRequests(provider, getRequests(values, null)));
		}

		return super.getMoveCommands(oldIndex, newIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getSetCommand(int index, Object value) {
		IElementEditService provider = getProvider();
		if (provider != null) {
			List<Object> values = new LinkedList<Object>(this);
			Object oldElem = values.set(index, value);
			return getCommandFromRequests(provider, getRequests(values, Collections.singletonList(oldElem)));
		}

		return super.getSetCommand(index, value);
	}

	/**
	 * Compute the requests
	 *
	 * @param newValues
	 *            the new list that will be set as a value of the observed feature
	 * @param removedValues
	 *            if element has been removed from the list put it there : it handles destroy of elements if the observed feature is a containment
	 * @return
	 */
	protected Collection<? extends IEditCommandRequest> getRequests(List<Object> newValues, Collection<?> removedValues) {
		LinkedList<IEditCommandRequest> requests = new LinkedList<>();

		if (feature instanceof EReference && ((EReference) feature).isContainment() && removedValues != null) {
			for (Object o : removedValues) {
				if (o instanceof EObject) {
					requests.add(new DestroyElementRequest((TransactionalEditingDomain) editingDomain, (EObject) o, false));
				}
			}
		}

		requests.add(new SetRequest((TransactionalEditingDomain) editingDomain, source, feature, newValues));
		return requests;
	}
}
