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
package com.zeligsoft.base.zdl.oaw;

import org.eclipse.xpand2.Generator;
import org.eclipse.xtend.expression.ResourceManager;

/**
 * An {@link Generator} which uses our ResourceManager.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class ZXpandGenerator extends Generator {

	private static final String COMPONENT_NAME = "Zeligsoft Xpand Generator";

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

	private ResourceManager manager;
	@Override
	public ResourceManager getResourceManager() {
		if(null == manager) {
			manager = new ZResourceManager();
		}
		return manager;
	}

	@Override
	public void setResourceManager(ResourceManager resourceManager) {
		// do nothing
	}
}