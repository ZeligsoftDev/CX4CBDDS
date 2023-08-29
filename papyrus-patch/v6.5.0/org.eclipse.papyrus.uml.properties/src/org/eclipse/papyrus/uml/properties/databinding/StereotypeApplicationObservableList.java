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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

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
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.papyrus.uml.tools.commands.UnapplyStereotypeCommand;
import org.eclipse.papyrus.uml.tools.databinding.AbstractStereotypeListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * An IObservableList for editing Stereotype Applications
 *
 * @author Camille Letavernier
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class StereotypeApplicationObservableList extends WritableList implements ICommitListener, IObserving {

	private Element umlSource;

	private EditingDomain domain;

	private final List<Command> commands;

	private AbstractStereotypeListener listener;

	/**
	 *
	 * Constructor.
	 *
	 * @param umlSource
	 *            The UML Element being observed
	 * @param domain
	 *            The Editing Domain on which the commands will be executed
	 */
	public StereotypeApplicationObservableList(Element umlSource, EditingDomain domain) {
		super(new LinkedList<Object>(umlSource.getAppliedStereotypes()), Stereotype.class);
		this.umlSource = umlSource;
		this.domain = domain;
		commands = new LinkedList<Command>();

		listener = new AbstractStereotypeListener(umlSource) {

			@Override
			protected void handleUnappliedStereotype(final EObject newValue) {
				StereotypeApplicationObservableList.this.fireListChange(new ListDiff() {

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
				StereotypeApplicationObservableList.this.fireListChange(new ListDiff() {

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
			 *
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
		};

		for (Command cmd : commands) {
			compoundCommand.append(cmd);
		}

		domain.getCommandStack().execute(compoundCommand);
		refreshCacheList();
		commands.clear();
	}

	private void refreshCacheList() {
		wrappedList.clear();
		wrappedList.addAll(umlSource.getAppliedStereotypes());
		fireListChange(null);
	}

	@Override
	public void clear() {
		removeAll(new LinkedList<Object>(wrappedList));
	}

	@Override
	public boolean add(Object o) {

		if (!(o instanceof Stereotype)) {
			return false;
		}
		Stereotype stereotype = (Stereotype) o;
		Command command = new ApplyStereotypeCommand(umlSource, stereotype, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.add(o);
	}

	@Override
	public boolean remove(Object o) {

		if (!(o instanceof Stereotype)) {
			return false;
		}

		final Stereotype stereotype = (Stereotype) o;
		Command command = new UnapplyStereotypeCommand(umlSource, stereotype, (TransactionalEditingDomain) domain);


		commands.add(command);

		return wrappedList.remove(o);
	}

	@Override
	public boolean addAll(Collection c) {
		// We only apply the stereotypes that are not applied yet (To avoid removing them when undo is called)
		c.removeAll(wrappedList);

		Command command = new ApplyStereotypeCommand(umlSource, c, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.addAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		Command command = new UnapplyStereotypeCommand(umlSource, c, (TransactionalEditingDomain) domain);

		commands.add(command);

		return wrappedList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {
		List<Object> objectsToRemove = new LinkedList<Object>();
		for (Object object : c) {
			if (!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		return removeAll(objectsToRemove);
	}


	// Unsupported operations. Some of them have a "proxy" implementation
	@Override
	public void add(int index, Object value) {
		add(value); // The list is not ordered
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return addAll(c); // The list is not ordered
	}

	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	public Object getObserved() {
		return umlSource;
	}

	@Override
	public void dispose() {
		super.dispose();
		listener.dispose();
	}
}
