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
package com.zeligsoft.cx.ui.properties.sections;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ISection;

/**
 * Interface class for CX property tab section page.
 * 
 * @author ysroh
 * 
 */
public interface ICXPropertySection
		extends ISection {

	/**
	 * Creates control for all sections that belongs to this tab
	 * 
	 * @param parent
	 * @return
	 */
	public Composite createControl(Composite parent);

	/**
	 * Queries the first EObject of the selected EObjects
	 * 
	 * @return
	 */
	public EObject getEObject();

	/**
	 * Queries all selected EObjects
	 * 
	 * @return
	 */
	public List<EObject> getSelectedEObjects();

	/**
	 * Queries current selection
	 * 
	 * @return
	 */
	public ISelection getSelection();

	/**
	 * Queries the composite for this section
	 * 
	 * @return
	 */
	public Composite getSectionComposite();

}
