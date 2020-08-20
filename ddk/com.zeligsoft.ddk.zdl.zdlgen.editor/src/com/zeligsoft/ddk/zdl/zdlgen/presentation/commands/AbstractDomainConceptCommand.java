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
package com.zeligsoft.ddk.zdl.zdlgen.presentation.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;

/**
 * The command is a base for all commands related to GenDomainConcepts. It
 * provides helper methods to access the GenMenuModel.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class AbstractDomainConceptCommand 
	extends AbstractCommand{
	
	protected GenDomainConcept concept;
	
	
	public AbstractDomainConceptCommand(String label, 
			GenDomainConcept concept) {
		super(label);
		this.concept = concept;
	}
	
	protected GenMenuModel getMenuModel() {
		GenMenuModel result = null;
		EObject container = concept.eContainer();
		while(container != null && !(container instanceof GenDomainModel)) {
			container = container.eContainer();
		}
		
		if(container == null) {
			result = null;
		} else {
			GenDomainModel model = (GenDomainModel) container;
			result = model.getMenuModel();
			if(result == null) {
				// the model musn't have a menu model yet
				result = ZDLGenFactory.eINSTANCE.createGenMenuModel();
				model.setMenuModel(result);
			}
		}
		
		return result;
	}
}
