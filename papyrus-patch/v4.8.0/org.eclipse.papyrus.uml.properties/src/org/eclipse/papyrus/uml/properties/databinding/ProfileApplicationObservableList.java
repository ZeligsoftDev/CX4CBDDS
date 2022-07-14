/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 399859
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.tools.commands.ApplyProfileCommand;
import org.eclipse.papyrus.uml.tools.commands.UnapplyProfileCommand;
import org.eclipse.papyrus.uml.tools.databinding.AbstractStereotypeListener;
import org.eclipse.papyrus.uml.tools.helper.ProfileApplicationDelegateRegistry;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 *
 * An IObservableList for Profile application
 *
 * @author Camille Letavernier
 * @since 3.3
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProfileApplicationObservableList extends WritableList implements ICommitListener, IObserving {

	private Package umlSource;

	private EditingDomain domain;

	private final List<Command> commands;

	private AbstractStereotypeListener listener;

	/**
	 * Initializes me with the default applied profiles provider.
	 *
	 * @param umlSource
	 *            The Package on which the profiles are applied or unapplied
	 * @param domain
	 *            The editing domain on which the commands are executed
	 */
	public ProfileApplicationObservableList(Package umlSource, EditingDomain domain) {
		super(getAppliedProfiles(umlSource), Profile.class);

		this.umlSource = umlSource;
		this.domain = domain;

		commands = new LinkedList<>();

		listener = new AbstractStereotypeListener(umlSource) {

			@Override
			protected void handleUnappliedStereotype(final EObject newValue) {
				ProfileApplicationObservableList.this.fireListChange(new ListDiff() {

					@Override
					public ListDiffEntry[] getDifferences() {
						return new ListDiffEntry[] { new ListDiffEntry() {

							@Override
							public int getPosition() {
								return 0;
							}

							@Override
							public boolean isAddition() {
								return false;
							}

							@Override
							public Object getElement() {
								return newValue;
							}

						} };
					}

				});
			}

			@Override
			protected void handleAppliedStereotype(final EObject newValue) {
				ProfileApplicationObservableList.this.fireListChange(new ListDiff() {

					@Override
					public ListDiffEntry[] getDifferences() {
						return new ListDiffEntry[] { new ListDiffEntry() {

							@Override
							public int getPosition() {
								return 0;
							}

							@Override
							public boolean isAddition() {
								return true;
							}

							@Override
							public Object getElement() {
								return newValue;
							}

						} };
					}

				});
			}
		};
	}

	@Override
	public Object getObserved() {
		return umlSource;
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		this.listener.dispose();
	}

	@Override
	public void commit(AbstractEditor editor) {
		if (commands.isEmpty()) {
			return;
		}

		CompoundCommand compoundCommand = new CompoundCommand() {

			@Override
			public void execute() {
				super.execute();
				refreshCacheList();
			}

			@Override
			public void undo() {
				super.undo();
				refreshCacheList();
			}

			@Override
			public void redo() {
				super.redo();
				refreshCacheList();
			}

			/**
			 * We have a sequential execution : the method canExecute() in
			 * the command n+1 depends on the result of the command n. We can't
			 * check every command's canExecute() method here, so we only
			 * check the first one.
			 */
			@Override
			public boolean canExecute() {
				return commandList.isEmpty() ? false : commandList.get(0).canExecute();
			}
			// TODO : edit the execute() method to call the remaining canExecute() checks
			// during the execution
			// (n).canExecute()
			// (n).execute()
			// (n+1).canExecute()
			// (n+1).execute()

			// Problem : this is the StrictCompoundCommand's behavior. However, in the
			// StrictCompoundCommand implementation, the execute() is called outside of
			// the current CommandStack, which is forbidden
		};

		for (Command cmd : commands) {
			compoundCommand.append(cmd);
		}

		domain.getCommandStack().execute(compoundCommand);
		refreshCacheList();
		commands.clear();
	}

	protected final void refreshCacheList() {
		wrappedList.clear();
		wrappedList.addAll(getAppliedProfiles(umlSource));
		fireListChange(null);
	}

	static Collection<Profile> getAppliedProfiles(Package package_) {
		final ProfileApplicationDelegateRegistry reg = ProfileApplicationDelegateRegistry.INSTANCE;

		List<Profile> result = new ArrayList<>();
		for (ProfileApplication next : reg.getDelegate(package_).getProfileApplications(package_)) {
			Profile profile = reg.getDelegate(next).getAppliedProfile(next);
			if (profile != null) {
				result.add(profile);
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		removeAll(new LinkedList<Object>(wrappedList));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(Object o) {
		if (!(o instanceof Profile)) {
			return false;
		}

		Profile profile = EMFHelper.reloadIntoContext((Profile) o, umlSource);
		Command command = new ApplyProfileCommand(umlSource, profile, (TransactionalEditingDomain) domain);

		commands.add(command);


		return wrappedList.add(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {

		if (!(o instanceof Profile)) {
			return false;
		}

		final Profile profile = (Profile) o;
		Command command = new UnapplyProfileCommand(umlSource, profile, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.remove(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection c) {
		// We only apply the profiles that are not applied yet (To avoid removing them when undo is called)
		c.removeAll(wrappedList);

		Collection<Profile> profiles = new LinkedList<>();
		for (Object element : c) {
			if (element instanceof Profile) {
				profiles.add(EMFHelper.reloadIntoContext((Profile) element, umlSource));
			} else {
				throw new IllegalArgumentException("The new value should only contain profiles"); //$NON-NLS-1$
			}
		}
		Command command = new ApplyProfileCommand(umlSource, profiles, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection c) {
		Command command = new UnapplyProfileCommand(umlSource, c, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.removeAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection c) {
		List<Object> objectsToRemove = new LinkedList<>();
		for (Object object : c) {
			if (!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		return removeAll(objectsToRemove);
	}

	// Unsupported operations. Some of them have a "proxy" implementation

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(int index, Object value) {
		add(value); // The list is not ordered
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(int index, Collection c) {
		return addAll(c); // The list is not ordered
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object move(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}
}
