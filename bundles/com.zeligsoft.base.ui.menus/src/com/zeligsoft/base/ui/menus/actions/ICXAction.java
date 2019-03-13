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
package com.zeligsoft.base.ui.menus.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;

/**
 * Interface that all actions contributed through the dynamic menus must
 * implement.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public interface ICXAction extends IAction {

	/**
	 * Set the selected element that the action will work on
	 * @param context
	 */
	public abstract void setSelection(EObject context);

}