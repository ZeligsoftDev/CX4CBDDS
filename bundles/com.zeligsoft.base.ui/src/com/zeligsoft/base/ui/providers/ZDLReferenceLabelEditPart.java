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
package com.zeligsoft.base.ui.providers;

import org.eclipse.draw2d.ConnectionLocator;

import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;

import org.eclipse.gmf.runtime.notation.View;

/**
 * The edit part for the label on a ZDL reference connection.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLReferenceLabelEditPart
		extends LabelEditPart {

	/**
	 * Initializes me with the view that I control.
	 * 
	 * @param view
	 *            my view
	 */
	public ZDLReferenceLabelEditPart(View view) {
		super(view);
	}

	@Override
	public int getKeyPoint() {
		return ConnectionLocator.SOURCE;
	}
}