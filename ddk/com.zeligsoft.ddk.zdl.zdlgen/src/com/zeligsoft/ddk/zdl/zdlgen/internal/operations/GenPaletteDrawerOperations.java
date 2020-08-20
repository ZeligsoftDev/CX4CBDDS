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
package com.zeligsoft.ddk.zdl.zdlgen.internal.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Gen Palette Drawer</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer#allTools() <em>All Tools</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPaletteDrawerOperations extends GenDomainObjectOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPaletteDrawerOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<GenPaletteTool> allTools(GenPaletteDrawer genPaletteDrawer) {

		if (genPaletteDrawer.getSpecializes() == null) {
			return ECollections.unmodifiableEList(genPaletteDrawer.getTools());
		} else {
			EList<GenPaletteTool> tools = new BasicEList<GenPaletteTool>();
			EList<GenPaletteTool> newTools = new BasicEList<GenPaletteTool>();
			EMap<GenPaletteTool, GenPaletteTool> overridenList = new BasicEMap<GenPaletteTool, GenPaletteTool>();

			for (GenPaletteTool t : genPaletteDrawer.getTools()) {
				if (t.getOverrides() != null) {
					overridenList.put(t.getOverrides(), t);
				} else {
					newTools.add(t);
				}
			}

			EList<GenPaletteTool> inheritedTools = genPaletteDrawer.getSpecializes().allTools();

			for (GenPaletteTool it : inheritedTools) {
				if (overridenList.containsKey(it)) {
					tools.add(overridenList.get(it));
				} else {
					tools.add(it);
				}
			}

			tools.addAll(newTools);

			return ECollections.unmodifiableEList(tools);
		}
	}

} // GenPaletteDrawerOperations