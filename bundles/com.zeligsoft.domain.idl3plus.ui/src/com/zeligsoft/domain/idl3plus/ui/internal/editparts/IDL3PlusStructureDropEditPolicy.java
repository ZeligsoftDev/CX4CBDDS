/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.domain.idl3plus.ui.internal.editparts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import com.ibm.xtools.uml.ui.diagrams.structure.internal.editpolicies.StructureCompartmentDropEditPolicy;

/**
 * Drop edit policy to prevent rearrangement.
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusStructureDropEditPolicy extends
		StructureCompartmentDropEditPolicy {

	@SuppressWarnings("rawtypes")
	@Override
	protected Command createArrangeCommand(List newObjects) {
		CompoundCommand cc = (CompoundCommand) super
				.createArrangeCommand(newObjects);
		Iterator itor = cc.getCommands().iterator();
		while (itor.hasNext()) {
			Object obj = itor.next();
			if (obj instanceof ICommandProxy) {
				if (((ICommandProxy) obj).getICommand() instanceof DeferredLayoutCommand) {
					itor.remove();
				}
			}
		}
		return cc;
	}
}
