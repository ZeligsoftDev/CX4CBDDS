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

package com.zeligsoft.base.rsm.tooling.providers;

import org.eclipse.core.runtime.IAdaptable;

/**
 * Common Adaptable which allows for the creation of a wrapped adaptable.
 * 
 * @author jcorchis
 *
 */
public class WrapperAdaptable
		implements IAdaptable {

	IAdaptable baseAdaptable = null;

	public WrapperAdaptable(IAdaptable wrapped) {
		baseAdaptable = wrapped;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return baseAdaptable.getAdapter(adapter);
	}
}
