/*****************************************************************************
 * Copyright (c) 2011, 2018 CEA LIST.
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
package org.eclipse.papyrus.uml.properties.databinding;

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
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList;
import org.eclipse.papyrus.uml.tools.adapters.PortTypeAdapter;
import org.eclipse.papyrus.uml.tools.commands.DestroyDependencyWithoutSupplierCommand;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * An IObservableList to edit the UML Derived feature {@link Port#getRequireds()}
 *
 * @author Camille Letavernier
 * @since 3.3
 *
 */
public class RequiredInterfaceObservableList extends GMFObservableList {

	/** The port. */
	protected Port port = null;

	/** The port type adapter. */
	private Adapter portTypeAdapter = null;

	/**
	 * Instantiates a new required interface observable list.
	 *
	 * @param source
	 *            the source
	 * @param domain
	 *            the domain
	 */
	public RequiredInterfaceObservableList(Port source, EditingDomain domain) {
		super(EMFProperties.list(UMLPackage.eINSTANCE.getPort_Required()).observe(source), domain, source, UMLPackage.eINSTANCE.getPort_Required());
		this.port = source;
		port.eAdapters().add(portTypeAdapter = new PortTypeAdapter(port, UMLPackage.Literals.PORT__REQUIRED, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT));
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getAddAllCommand(java.util.Collection)
	 *
	 * @param values
	 * @return
	 */
	@Override
	public Command getAddAllCommand(Collection<?> values) {

		CompoundCommand returnedCommand = new CompoundCommand();
		List<IEditCommandRequest> requests = new LinkedList<>();
		List<Interface> commonInterfacesList = new ArrayList<>();
		EList<Interface> requiredInterfacesList = port.getRequireds();

		for (Object current : values) {
			if (current instanceof Interface) {

				if (!requiredInterfacesList.contains(current)) {

					// Added interface
					IEditCommandRequest request = new CreateRelationshipRequest(port.getType().eContainer(), port.getType(), (EObject) current, ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Usage")); //$NON-NLS-1$
					requests.add(request);
				} else {

					// Conserved interface
					commonInterfacesList.add((Interface) current);
				}
			}
		}

		if (!requests.isEmpty()) {
			returnedCommand.append(getCommandFromRequests(getProvider(), requests));
		}

		// Handle deleted interfaces
		if (requiredInterfacesList.size() != commonInterfacesList.size()) {
			List<Interface> removedInterfacesList = new ArrayList<>();

			for (Interface current : requiredInterfacesList) {
				if (!commonInterfacesList.contains(current)) {
					removedInterfacesList.add(current);
				}
			}

			returnedCommand.append(getRemoveAllCommand(removedInterfacesList));
		}

		return returnedCommand;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getRemoveCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getRemoveCommand(Object value) {
		CompoundCommand commands = null;
		Dependency usage = getUsage(value);
		if (usage != null) {
			commands = new CompoundCommand();
			IEditCommandRequest request = new DestroyReferenceRequest((TransactionalEditingDomain) editingDomain, usage, UMLPackage.eINSTANCE.getDependency_Supplier(), (EObject) value, false);
			commands.append(new GMFtoEMFCommandWrapper(getProvider().getEditCommand(request)));
			commands.append(new GMFtoEMFCommandWrapper(new DestroyDependencyWithoutSupplierCommand((TransactionalEditingDomain) editingDomain, usage, getProvider())));

		}

		return commands;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getRemoveAllCommand(java.util.Collection)
	 *
	 * @param values
	 * @return
	 */
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		CompoundCommand commands = new CompoundCommand();
		Set<Dependency> dependenciesSet = new HashSet<>();

		for (Object value : values) {
			Dependency usage = getUsage(value);
			if (usage != null) {
				IEditCommandRequest request = new DestroyReferenceRequest((TransactionalEditingDomain) editingDomain, usage, UMLPackage.eINSTANCE.getDependency_Supplier(), (EObject) value, false);
				commands.append(new GMFtoEMFCommandWrapper(getProvider().getEditCommand(request)));
				dependenciesSet.add(usage);
			}
		}

		commands.append(new GMFtoEMFCommandWrapper(new DestroyDependencyWithoutSupplierCommand((TransactionalEditingDomain) editingDomain, dependenciesSet, getProvider())));

		return commands;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getClearCommand()
	 *
	 * @return
	 */
	@Override
	public Command getClearCommand() {
		return new RecordingCommand((TransactionalEditingDomain) editingDomain) {

			@Override
			protected void doExecute() {
				CacheAdapter cache = CacheAdapter.getInstance();
				cache.put(port, UMLPackage.Literals.PORT__REQUIRED, null);

			}
		};
	}

	/**
	 * Gets the usage.
	 *
	 * @param value
	 *            the value
	 * @return the usage
	 */
	private Dependency getUsage(Object value) {
		Usage usage = null;
		if (value instanceof Interface) {
			Interface deletedInterface = (Interface) value;
			List<Usage> usagesList = ElementUtil.getInstancesFilteredByType(port.getModel(), Usage.class, null);

			// Parse all Usages of model
			boolean isUsage = false;
			Iterator<Usage> usagesIterator = usagesList.iterator();
			Usage current = null;
			while (usagesIterator.hasNext() && !isUsage) {
				current = usagesIterator.next();

				// Check if Usage links port's type to deleted interface
				isUsage = current.getSuppliers().contains(deletedInterface) && current.getClients().contains(port.getType());
				if (isUsage) {
					usage = current;
				}
			}
		}

		return usage;
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
