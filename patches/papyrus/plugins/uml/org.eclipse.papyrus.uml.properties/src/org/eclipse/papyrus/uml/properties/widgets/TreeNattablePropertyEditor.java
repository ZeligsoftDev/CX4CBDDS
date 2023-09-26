/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.tree.ITreeItemAxisHelper;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Vincent Lorenzo
 * @since 2.0
 * 
 *        Nattable Editor to use for tree table
 *
 */
public class TreeNattablePropertyEditor extends NattablePropertyEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public TreeNattablePropertyEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * @see org.eclipse.papyrus.uml.properties.widgets.NattablePropertyEditor#configureTable(org.eclipse.emf.transaction.TransactionalEditingDomain, org.eclipse.papyrus.infra.nattable.model.nattable.Table, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, org.eclipse.emf.common.command.CompoundCommand)
	 *
	 * @param domain
	 * @param table
	 * @param sourceElement
	 * @param synchronizedFeature
	 * @param rows
	 * @param command
	 */
	@Override
	protected void configureTable(TransactionalEditingDomain domain, Table table, EObject sourceElement, EStructuralFeature synchronizedFeature, Collection<?> rows, CompoundCommand command) {
		super.configureTable(domain, table, sourceElement, synchronizedFeature, rows, command);
		if (TableHelper.isTreeTable(table) && null != rows && !rows.isEmpty()) {// add test on TreeTable to fix bug 476623
			final AbstractAxisProvider axisProvider = table.getCurrentRowAxisProvider();
			TableHeaderAxisConfiguration conf = (TableHeaderAxisConfiguration) HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
			AxisManagerRepresentation rep = conf.getAxisManagers().get(0);
			for (Object context : rows) {
				addTreeItemAxis(domain, axisProvider, rep, context, command);
			}
		}
	}

	/**
	 * This allow to add the tree item axis.
	 * 
	 * @param axisProvider
	 *            The axis provider.
	 * @param rep
	 *            The axis manager representation.
	 * @param object
	 *            The object to add.
	 */
	protected void addTreeItemAxis(final TransactionalEditingDomain domain, final AbstractAxisProvider axisProvider, final AxisManagerRepresentation rep, final Object object, final CompoundCommand command) {
		final IAxis axis = ITreeItemAxisHelper.createITreeItemAxis(null, null, object, rep);
		Command addCommand = AddCommand.create(getTableEditingDomain(), axisProvider, NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), Collections.singleton(axis));
		command.append(addCommand);
	}
}
