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
package com.zeligsoft.ddk.zdl.zdlgen.presentation.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import com.zeligsoft.ddk.zdl.zdlgen.provider.util.ITreeTextProvider;

/**
 * Specialized label provider for the editor tree, that gets custom text from an
 * {@link ITreeTextProvider}.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TreeLabelProvider
		extends AdapterFactoryLabelProvider {

	/**
	 * Initializes me.
	 * 
	 * @param adapterFactory
	 *            my adapter factory
	 */
	public TreeLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		IItemLabelProvider provider = (IItemLabelProvider) adapterFactory
			.adapt(object, IItemLabelProvider.class);

		if ((provider instanceof ITreeTextProvider)
			&& (object instanceof EObject)) {
			
			return ((ITreeTextProvider) provider)
				.getTextForTree((EObject) object);
		}

		return super.getText(object);
	}
}
