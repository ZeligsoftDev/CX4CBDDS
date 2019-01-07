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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.swt.graphics.Image;

import com.zeligsoft.base.ui.utils.ZDLImageRegistry;

/**
 * An icon provider that gets icons for model elements according to their
 * defining ZDL concept.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLIconProvider
		extends AbstractProvider
		implements IIconProvider {

	/**
	 * Initializes me.
	 */
	public ZDLIconProvider() {
		super();
	}

	@Override
	public Image getIcon(IAdaptable hint, int flags) {
		Image result = null;

		EObject modelElement = (hint == null)
			? null
			: (EObject) hint.getAdapter(EObject.class);

		if (modelElement != null) {
			result = ZDLImageRegistry.getInstance().getZDLIcon(modelElement);
		}

		return result;
	}

	@Override
	public boolean provides(IOperation operation) {
		boolean result = false;

		if (operation instanceof IIconOperation) {
			IIconOperation iconOp = (IIconOperation) operation;

			IAdaptable hint = iconOp.getHint();
			result = (hint != null) && (getIcon(hint, 0) != null);
		}

		return result;
	}

}
