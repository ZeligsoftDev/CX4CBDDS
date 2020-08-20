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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenu;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.commands.AbstractDomainConceptCommand;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.l10.Messages;

/**
 * 
 * This action will take a list of GenDomainConcepts at create the
 * necessary GenMen for them and associate them with GenDomainConcepts.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class CreateMenuForConceptActionDelegate extends
		AbstractGenDomainConceptActionDelegate {

	@Override
	protected Command getCommandToRun() {
		CompoundCommand cc = new CompoundCommand(Messages.
				CreateActionFromConcept_CompoundCommand_ActionFromConcepts);
		
		for(GenDomainConcept concept : concepts) {
			CreateMenuForConceptCommand command = 
				new CreateMenuForConceptCommand( 
					Messages.CreateActionFromConcept_Command_CreateAction, 
					concept);
			cc.append(command);
		}
		return cc;
	}
	
	private static class CreateMenuForConceptCommand
		extends AbstractDomainConceptCommand {

		protected GenMenu newMenu;
		
		public CreateMenuForConceptCommand(String label, GenDomainConcept concept) {
			super(label, concept);
		}
		
		@Override
		public void execute() {
			if(concept.getMenu() == null) {
				// find the menu model to add it to
				GenMenuModel menuModel = getMenuModel();
				newMenu =
					ZDLGenFactory.eINSTANCE.createGenMenu();
				newMenu.setName("Create" + concept.getName()); //$NON-NLS-1$
				concept.setMenu(newMenu);
				menuModel.getItems().add(newMenu);
			}
		}

		@Override
		public void redo() {
			execute();
		}
		
		@Override
		public void undo() {
			if(newMenu != null) {
				concept.setMenu(null);
				GenMenuModel menuModel = getMenuModel();
				menuModel.getItems().remove(newMenu);
			}
		}
		
		@Override
		protected boolean prepare() {
			return (concept.getMenu() == null);
		}
		
	}

}
