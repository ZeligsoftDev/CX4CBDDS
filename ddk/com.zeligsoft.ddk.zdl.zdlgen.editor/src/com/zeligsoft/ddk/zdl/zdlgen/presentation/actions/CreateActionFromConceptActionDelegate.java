/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.presentation.actions;


import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.ui.IEditorActionDelegate;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.commands.AbstractDomainConceptCommand;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.l10.Messages;

/**
 * This action will take a list of GenDomainConcepts at create the
 * necessary GenMenuCreateActions for them.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class CreateActionFromConceptActionDelegate 
	extends AbstractGenDomainConceptActionDelegate
	implements IEditorActionDelegate {

	/**
	 * Initialize me
	 */
	public CreateActionFromConceptActionDelegate() {
		// nothing to do
	}

	
	/**
	 * @return
	 */
	@Override
	protected Command getCommandToRun() {
		CompoundCommand cc = new CompoundCommand(Messages.
				CreateActionFromConcept_CompoundCommand_ActionFromConcepts);
		
		for(GenDomainConcept concept : concepts) {
			CreateActionFromConceptCommand command = 
				new CreateActionFromConceptCommand( 
					Messages.CreateActionFromConcept_Command_CreateAction, 
					concept);
			cc.append(command);
		}
		return cc;
	}
	
	/**
	 * A command that will add the GenMenuCreateAction to the GenMenuModel
	 * of the GenDomainModel that the given GenDomainConcept is part of.
	 * 
	 * @author Toby McClean (tmcclean)
	 *
	 */
	private static class CreateActionFromConceptCommand
		extends AbstractDomainConceptCommand {
		
		protected GenMenuCreateAction createdAction;
		
		/**
		 * Initializes me with the concept that I will make a 
		 * GenMenuCreateAction element from
		 * 
		 * @param concept
		 * 		the concept that I will create the action for
		 */
		public CreateActionFromConceptCommand(
				String label, GenDomainConcept concept) {
			super(label, concept);
		}
		
		@Override
		public void execute() {
			// find the menu model to add it to
			GenMenuModel menuModel = getMenuModel();
			createdAction =
				ZDLGenFactory.eINSTANCE.createGenMenuCreateAction();
			createdAction.setCreateConcept(concept);
			createdAction.setName(concept.getName());
			menuModel.getItems().add(createdAction);
		}
		
		@Override
		public void undo() {
			if(createdAction != null) {
				GenMenuModel menuModel = getMenuModel();
				menuModel.getItems().remove(createdAction);
			}
		}
		
		@Override
		public void redo() {
			execute();
		}
		
		@Override
		protected boolean prepare() {
			return true;
		}
	}
}
