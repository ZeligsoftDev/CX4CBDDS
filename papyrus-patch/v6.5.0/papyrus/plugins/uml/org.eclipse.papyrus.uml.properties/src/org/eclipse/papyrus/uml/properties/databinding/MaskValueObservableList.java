/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;


/**
 * An IObservableList for the StringListValueStyle named "maskLabel" (See {@link VisualInformationPapyrusConstants#CUSTOM_MASK_LABEL}
 *
 * It is used for configuring an {@link IMaskManagedLabelEditPolicy}
 *
 * @author Camille Letavernier
 *
 */
public class MaskValueObservableList extends CustomStringStyleObservableList {

	private EditPart editPart;

	public MaskValueObservableList(EditPart editPart, EditingDomain domain) {
		super(getView(editPart), domain, VisualInformationPapyrusConstants.CUSTOM_MASK_LABEL);
		this.editPart = editPart;

		updateWrappedList(getDefaultValues());
	}

	private static View getView(EditPart editPart) {
		return (View) editPart.getModel();
	}

	@Override
	protected IObservableList getConcreteList() {
		if (!isStyleCreated()) {
			return new WritableList(getDefaultValues(), String.class);
		}
		return super.getConcreteList();
	}

	protected List<String> getDefaultValues() {
		return new LinkedList<String>(((IMaskManagedLabelEditPolicy) editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY)).getCurrentDisplayValue());
	}

	@Override
	protected void refreshCacheList() {
		super.refreshCacheList();
		((IMaskManagedLabelEditPolicy) editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY)).refreshDisplay();
	}


	// When the style is not yet created (Style#values = []), we need to transform the commands. In this case, the "current value" equals "defaut value", which is not always empty.
	// The superclass expects an empty default state, and will return Unexecutable commands if we try to e.g. remove elements
	// For example, if our default state is [name, visibility], we can handle a "Remove visibility" command, by creating a [name] list.

	@Override
	public Command getRemoveCommand(Object value) {
		if (isStyleCreated()) {
			return super.getRemoveCommand(value);
		}

		// The current list is not always empty, even if the style is not defined: we have a default value
		Collection<Object> currentValues = new HashSet<Object>(wrappedList);
		if (currentValues.remove(value)) {
			return getAddAllCommand(currentValues);
		}
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		if (isStyleCreated()) {
			return super.getRemoveAllCommand(values);
		}

		Collection<Object> currentValues = new HashSet<Object>(wrappedList);
		if (currentValues.containsAll(values)) {
			currentValues.removeAll(values);
			if (currentValues.isEmpty()) {
				return IdentityCommand.INSTANCE;
			}
			return getAddAllCommand(currentValues);
		}
		return UnexecutableCommand.INSTANCE;
	}

}
