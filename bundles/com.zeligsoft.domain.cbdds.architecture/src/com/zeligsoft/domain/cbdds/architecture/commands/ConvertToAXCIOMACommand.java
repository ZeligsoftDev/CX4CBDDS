/*****************************************************************************
 * Copyright (c) Zeligsoft(2009) Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		Young-Soo Roh - Initial API and implementation
 *
 *****************************************************************************/
package com.zeligsoft.domain.cbdds.architecture.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.architecture.commands.IModelConversionCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationModelTypeUtil;

/**
 * The Class CreateSysMLModelCommand.
 */
public class ConvertToAXCIOMACommand implements IModelConversionCommand {

	@Override
	public void convertModel(ModelSet modelSet) {

		UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
		EObject root = null;
		if (openedModel != null) {
			try {
				root = openedModel.lookupRoot();
			} catch (NotFoundException e) {
				return;
			}
		}
		if (root == null) {
			return;
		}

		final Model model = (Model) root;
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(model);

		if (DDS4CCMMigrationModelTypeUtil.isMigrationRequired(model)) {

			final RecordingCommand migrationCommand = new RecordingCommand(editingDomain, "Migrate Model") {

				@Override
				protected void doExecute() {

					DDS4CCMMigrationModelTypeUtil.migrateAll(model);
				}
			};

			editingDomain.getCommandStack().execute(migrationCommand);
		}
	}
}
