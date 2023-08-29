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
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.command.Command;
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
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.databinding.OwnedAttributeHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An ObservableValue for manipulating the UML Owner property.
 * The owner property is a virtual property, represented as an enumeration,
 * which can have two values : Association (Owned by Association) or Classifier
 * (Owned by Classifier)
 *
 * This value can be determined by the following query :
 * if self.association.ownedEnd->contains(self) then 'Association' else 'Classifier' endif
 *
 * This value doesn't make sense for n-ary associations, when n > 2.
 *
 * @author Camille Letavernier
 * @since 3.3
 */
public class OwnerObservableValue extends ReferenceCountedObservable.Value implements IChangeListener, AggregatedObservable, CommandBasedObservableValue, IObserving {

	private Property memberEnd;

	private EditingDomain domain;

	private String currentValue;

	private final IObservableList navigableEndsObservableList;

	/**
	 * Owned by classifier
	 */
	public static final String CLASSIFIER = "Classifier"; //$NON-NLS-1$

	/**
	 * Owned by association
	 */
	public static final String ASSOCIATION = "Association"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 * @param source
	 *            The EObject (Property) which the ownership is being edited
	 * @param domain
	 *            The Editing Domain on which the commands will be executed
	 */
	public OwnerObservableValue(EObject source, EditingDomain domain) {
		this.memberEnd = (Property) source;
		this.domain = domain;
		navigableEndsObservableList = EMFProperties.list(UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd()).observe(memberEnd.getAssociation());
		navigableEndsObservableList.addChangeListener(this);
	}

	@Override
	public void handleChange(ChangeEvent event) {
		fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		return memberEnd.getAssociation().getOwnedEnds().contains(memberEnd) ? "Association" : "Classifier"; //$NON-NLS-1$ //$NON-NLS-2$
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
		navigableEndsObservableList.removeChangeListener(this);
		navigableEndsObservableList.dispose();
	}

	@Override
	public Command getCommand(Object value) {
		if (value instanceof String) {
			String owner = (String) value;
			boolean isOwnedByAssociation = ASSOCIATION.equals(owner);

			Association association = memberEnd.getAssociation();

			if (association.getMemberEnds().size() > 2) {
				Activator.log.warn("Cannot change End owner for n-ary associations"); //$NON-NLS-1$
				return UnexecutableCommand.INSTANCE;
			}

			// Classifier classifier = memberEnd.getClass_();
			// EStructuralFeature ownedEndFeature = association.eClass().getEStructuralFeature(UMLPackage.ASSOCIATION__OWNED_END);

			ICommand command = null;

			if (isOwnedByAssociation) { // Owned by Association
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
				if (provider != null) {
					EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_OwnedEnd();
					List<Property> attributeList = new ArrayList<>();
					attributeList.addAll(association.getOwnedEnds());
					attributeList.add(memberEnd);
					// association.eSet(feature, attributeList);

					SetRequest request = new SetRequest(association, feature, attributeList);

					command = provider.getEditCommand(request);

				}
			} else { // Owned by Classifier

				command = OwnedAttributeHelper.getSetTypeOwnerForAssociationAttributeCommand(association, memberEnd);
			}

			if (command != null) {
				this.currentValue = owner;
				return new GMFtoEMFCommandWrapper(command);
			} else {
				Activator.log.warn("Cannot modify the memberEnd owner"); //$NON-NLS-1$
			}
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
