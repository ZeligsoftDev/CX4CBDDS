/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.internal.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.DropStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;

/**
 * Edit policy to set default strategies for CX parts to avoid pop-up during the
 * drop action.
 * 
 * @author Young-Soo Roh
 *
 */
public class AssemblyStructureCompartmentDragDropEditPolicy extends AbstractEditPolicy {

	private static boolean defaultInitialized = false;

	public AssemblyStructureCompartmentDragDropEditPolicy() {
	}

	@Override
	public void activate() {
		super.activate();
		if (!defaultInitialized) {
			defaultInitialized = true;
			DropStrategyManager manager = DropStrategyManager.instance;
			List<DropStrategy> defaultStrategies = manager.getAllStrategies().stream()
					.filter(st -> st.getID().startsWith("com.zeligsoft.domain.dds4ccm.ui.part"))
					.collect(Collectors.toList());
			DropStrategy propertyDrop = manager
					.findStrategy("org.eclipse.papyrus.uml.diagram.dnd.ClassifierToStructureCompAsPropertyDrop");
			if (propertyDrop != null) {
				for (DropStrategy df : defaultStrategies) {
					List<DropStrategy> conflicts = new ArrayList<DropStrategy>();
					conflicts.add(df);
					conflicts.add(propertyDrop);
					manager.setDefaultDropStrategy(conflicts, df);
				}
			}
		}
	}
}
