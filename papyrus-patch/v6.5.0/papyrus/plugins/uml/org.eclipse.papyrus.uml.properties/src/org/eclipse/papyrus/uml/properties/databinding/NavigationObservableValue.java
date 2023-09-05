/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.ui.databinding.AggregatedPapyrusObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.CommandBasedObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An ObservableValue for manipulating the UML Navigable property.
 * The navigable property is a virtual property, represented as a Boolean.
 *
 * @author Camille Letavernier
 * @since 3.3
 */
public class NavigationObservableValue extends ReferenceCountedObservable.Value implements IChangeListener, CommandBasedObservableValue, AggregatedObservable, IObserving {

	private Property memberEnd;

	private EditingDomain domain;

	private final IObservableList ownerObservableList;

	private boolean currentValue;

	/**
	 * Constructor.
	 *
	 * @param source
	 *            The EObject (Property) which the navigability is being edited
	 * @param domain
	 *            The Editing Domain on which the commands will be executed
	 */
	public NavigationObservableValue(EObject source, EditingDomain domain) {
		memberEnd = (Property) source;
		this.domain = domain;

		ownerObservableList = EMFProperties.list(UMLPackage.eINSTANCE.getAssociation_OwnedEnd()).observe(memberEnd.getAssociation());
		ownerObservableList.addChangeListener(this);
	}

	@Override
	public void handleChange(ChangeEvent event) {
		fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
	}

	@Override
	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return memberEnd.isNavigable();
	}

	@Override
	protected void doSetValue(Object value) {
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
	}

	@Override
	public Object getObserved() {
		return memberEnd;
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		ownerObservableList.removeChangeListener(this);
		ownerObservableList.dispose();
	}

	@Override
	public Command getCommand(Object value) {
		if (value instanceof Boolean) {
			boolean isNavigable = (Boolean) value;
			if (memberEnd.isNavigable() == isNavigable) {
				return UnexecutableCommand.INSTANCE;
			}

			Association association = memberEnd.getAssociation();

			List<Property> navigableEnds = new ArrayList<>();
			navigableEnds.addAll(association.getNavigableOwnedEnds());

			List<SetRequest> setRequests = new LinkedList<>();

			if (isNavigable) {
				navigableEnds.add(memberEnd);
			} else {
				if (memberEnd.getOwningAssociation() == null && memberEnd.getOwner() instanceof Classifier) {
					List<Property> ownedEnds = new LinkedList<>();
					ownedEnds.addAll(association.getOwnedEnds());
					ownedEnds.add(memberEnd);
					setRequests.add(new SetRequest(association, UMLPackage.eINSTANCE.getAssociation_OwnedEnd(), ownedEnds));
				}
				if (navigableEnds.contains(memberEnd)) {
					navigableEnds.remove(memberEnd);
				}
			}

			EStructuralFeature navigableFeature = UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd();
			setRequests.add(new SetRequest(association, navigableFeature, navigableEnds));

			CompoundCommand command = null;

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
			if (provider != null) {

				command = new CompoundCommand();

				for (SetRequest request : setRequests) {
					ICommand createGMFCommand = provider.getEditCommand(request);
					command.append(new GMFtoEMFCommandWrapper(createGMFCommand));
				}
			}

			currentValue = isNavigable;
			return command;
		}

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; // The observable cannot be aggregated
		}
	}

	@Override
	public boolean hasDifferentValues() {
		return false;
	}
}
