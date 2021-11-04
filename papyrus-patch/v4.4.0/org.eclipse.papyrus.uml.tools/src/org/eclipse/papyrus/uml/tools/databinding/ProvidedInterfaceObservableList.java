/*****************************************************************************
 * Copyright (c) 2011 - 2014, 2018 CEA LIST.
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
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *  Vincent LORENZO - bug 541313 - [UML][CDO] UML calls to the method getCacheAdapter(EObject) must be replaced
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.tools.adapters.PortTypeAdapter;
import org.eclipse.papyrus.uml.tools.commands.DestroyDependencyWithoutSupplierCommand;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An IObservableList to edit the UML Derived feature {@link Port#getProvideds()}.
 *
 * @author Camille Letavernier
 *
 * @deprecated since 4.3
 *             use {@link org.eclipe.papyrus.uml.properties.databinding.ProvidedInterfaceObservableList} API, instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 */
@Deprecated
public class ProvidedInterfaceObservableList extends PapyrusObservableList {


	/** The port. */
	protected Port port = null;

	/** Adapter for port type. */
	private Adapter portTypeAdapter = null;

	/**
	 * Instantiates a new provided interface observable list.
	 *
	 * @param source
	 *            the source
	 * @param domain
	 *            the domain
	 */
	public ProvidedInterfaceObservableList(Port source, EditingDomain domain) {
		super(EMFProperties.list(UMLPackage.eINSTANCE.getPort_Provided()).observe(source), domain, source, UMLPackage.eINSTANCE.getPort_Provided());
		this.port = source;
		port.eAdapters().add(portTypeAdapter = new PortTypeAdapter(port, UMLPackage.eINSTANCE.getPort_Provided(), UMLPackage.Literals.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION));

	}

	/**
	 * Gets the adds the all command.
	 *
	 * @param values
	 *            the values
	 * @return the adds the all command
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getAddAllCommand(java.util.Collection)
	 */
	@Override
	public Command getAddAllCommand(Collection<?> values) {
		CompoundCommand returnedCommand = new CompoundCommand();
		List<IEditCommandRequest> requests = new LinkedList<>();
		List<Interface> commonInterfacesList = new ArrayList<>();

		EList<Interface> providedInterfaceList = port.getProvideds();


		// Sort input values
		for (Object current : values) {

			if (current instanceof Interface) {
				if (!providedInterfaceList.contains(current)) {
					// Added interface
					IEditCommandRequest request = new CreateRelationshipRequest(port.getType(), port.getType(), (EObject) current, ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.InterfaceRealization")); //$NON-NLS-1$
					requests.add(request);
				} else {
					// Common interfaces
					commonInterfacesList.add((Interface) current);
				}
			}
		}

		if (!requests.isEmpty()) {
			returnedCommand.append(getCommandFromRequests(getProvider(), requests));
		}


		// Handle deleted interfaces
		if (providedInterfaceList.size() != commonInterfacesList.size()) {
			List<Interface> removedInterfacesList = new ArrayList<>();

			for (Interface current : providedInterfaceList) {
				if (!commonInterfacesList.contains(current)) {
					removedInterfacesList.add(current);
				}
			}

			returnedCommand.append(getRemoveAllCommand(removedInterfacesList));
		}



		return returnedCommand;

	}

	/**
	 * Gets the removes the command.
	 *
	 * @param value
	 *            the value
	 * @return the removes the command
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getRemoveCommand(java.lang.Object)
	 */
	@Override
	public Command getRemoveCommand(Object value) {
		CompoundCommand commands = null;
		Dependency realization = getRealization(value);

		if (realization != null) {
			commands = new CompoundCommand();
			IEditCommandRequest request = new DestroyReferenceRequest((TransactionalEditingDomain) editingDomain, realization, UMLPackage.eINSTANCE.getDependency_Supplier(), (EObject) value, false);
			commands.append(new GMFtoEMFCommandWrapper(getProvider().getEditCommand(request)));
			commands.append(new GMFtoEMFCommandWrapper(new DestroyDependencyWithoutSupplierCommand((TransactionalEditingDomain) editingDomain, realization, getProvider())));

		}
		return commands;


	}

	/**
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getRemoveAllCommand(java.util.Collection)
	 *
	 * @param values
	 * @return
	 */
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		CompoundCommand commands = new CompoundCommand();
		Set<Dependency> dependenciesSet = new HashSet<>();

		for (Object value : values) {
			Dependency realization = getRealization(value);
			if (realization != null) {
				IEditCommandRequest request = new DestroyReferenceRequest((TransactionalEditingDomain) editingDomain, realization, UMLPackage.eINSTANCE.getDependency_Supplier(), (EObject) value, false);
				commands.append(new GMFtoEMFCommandWrapper(getProvider().getEditCommand(request)));
				dependenciesSet.add(realization);
			}
		}

		commands.append(new GMFtoEMFCommandWrapper(new DestroyDependencyWithoutSupplierCommand((TransactionalEditingDomain) editingDomain, dependenciesSet, getProvider())));

		return commands;
	}

	/**
	 * Gets the realization.
	 *
	 * @param value
	 *            the value
	 * @return the realization
	 */
	private Dependency getRealization(Object value) {
		Realization realization = null;
		if (value instanceof Interface) {
			Interface deletedInterface = (Interface) value;
			List<Realization> realizationsList = ElementUtil.getInstancesFilteredByType(port.getModel(), Realization.class, null);

			// Parse all Realizations of model
			boolean isRealization = false;
			Iterator<Realization> realizationsIterator = realizationsList.iterator();
			Realization current = null;
			while (realizationsIterator.hasNext() && !isRealization) {
				current = realizationsIterator.next();

				// Check if Realization links port's type to deleted interface
				isRealization = current.getSuppliers().contains(deletedInterface) && current.getClients().contains(port.getType());
				if (isRealization) {
					realization = current;
				}
			}
		}

		return realization;
	}

	/**
	 * Gets the clear command.
	 *
	 * @return the clear command
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getClearCommand()
	 */

	@Override
	public Command getClearCommand() {

		return new RecordingCommand((TransactionalEditingDomain) editingDomain) {

			@Override
			protected void doExecute() {
				CacheAdapter cache = CacheAdapter.getInstance();
				cache.put(port, UMLPackage.Literals.PORT__PROVIDED, null);

			}
		};
	}


	/**
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#dispose()
	 *
	 */
	@Override
	public synchronized void dispose() {
		port.eAdapters().remove(portTypeAdapter);
		super.dispose();
	}

}
